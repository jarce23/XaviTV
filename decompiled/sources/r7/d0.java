package r7;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 {
    public static final Object g = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static d0 f10897h;

    /* renamed from: i, reason: collision with root package name */
    public static HandlerThread f10898i;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f10899a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Context f10900b;

    /* renamed from: c, reason: collision with root package name */
    public volatile b8.e f10901c;

    /* renamed from: d, reason: collision with root package name */
    public final u7.a f10902d;

    /* renamed from: e, reason: collision with root package name */
    public final long f10903e;

    /* renamed from: f, reason: collision with root package name */
    public final long f10904f;

    public d0(Context context, Looper looper) {
        c0 c0Var = new c0(this);
        this.f10900b = context.getApplicationContext();
        b8.e eVar = new b8.e(looper, c0Var);
        Looper.getMainLooper();
        this.f10901c = eVar;
        if (u7.a.f12561b == null) {
            synchronized (u7.a.f12560a) {
                try {
                    if (u7.a.f12561b == null) {
                        u7.a aVar = new u7.a();
                        new ConcurrentHashMap();
                        u7.a.f12561b = aVar;
                    }
                } finally {
                }
            }
        }
        u7.a aVar2 = u7.a.f12561b;
        r.e(aVar2);
        this.f10902d = aVar2;
        this.f10903e = 5000L;
        this.f10904f = 300000L;
    }

    public static HandlerThread a() {
        synchronized (g) {
            try {
                HandlerThread handlerThread = f10898i;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f10898i = handlerThread2;
                handlerThread2.start();
                return f10898i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final n7.a b(a0 a0Var, w wVar, String str) {
        n7.a aVar;
        HashMap hashMap = this.f10899a;
        synchronized (hashMap) {
            try {
                b0 b0Var = (b0) hashMap.get(a0Var);
                if (b0Var == null) {
                    b0Var = new b0(this, a0Var);
                    b0Var.f10872a.put(wVar, wVar);
                    aVar = b0Var.a(str, null);
                    hashMap.put(a0Var, b0Var);
                } else {
                    this.f10901c.removeMessages(0, a0Var);
                    if (b0Var.f10872a.containsKey(wVar)) {
                        String a0Var2 = a0Var.toString();
                        StringBuilder sb2 = new StringBuilder(a0Var2.length() + 81);
                        sb2.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb2.append(a0Var2);
                        throw new IllegalStateException(sb2.toString());
                    }
                    b0Var.f10872a.put(wVar, wVar);
                    int i10 = b0Var.f10873b;
                    if (i10 == 1) {
                        wVar.onServiceConnected(b0Var.f10877f, b0Var.f10875d);
                    } else if (i10 == 2) {
                        aVar = b0Var.a(str, null);
                    }
                    aVar = null;
                }
                if (b0Var.f10874c) {
                    return n7.a.f9212t;
                }
                if (aVar == null) {
                    aVar = new n7.a(-1, null, null);
                }
                return aVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(String str, ServiceConnection serviceConnection, boolean z10) {
        a0 a0Var = new a0(str, z10);
        r.f("ServiceConnection must not be null", serviceConnection);
        HashMap hashMap = this.f10899a;
        synchronized (hashMap) {
            try {
                b0 b0Var = (b0) hashMap.get(a0Var);
                if (b0Var == null) {
                    String a0Var2 = a0Var.toString();
                    StringBuilder sb2 = new StringBuilder(a0Var2.length() + 50);
                    sb2.append("Nonexistent connection status for service config: ");
                    sb2.append(a0Var2);
                    throw new IllegalStateException(sb2.toString());
                }
                if (!b0Var.f10872a.containsKey(serviceConnection)) {
                    String a0Var3 = a0Var.toString();
                    StringBuilder sb3 = new StringBuilder(a0Var3.length() + 76);
                    sb3.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb3.append(a0Var3);
                    throw new IllegalStateException(sb3.toString());
                }
                b0Var.f10872a.remove(serviceConnection);
                if (b0Var.f10872a.isEmpty()) {
                    this.f10901c.sendMessageDelayed(this.f10901c.obtainMessage(0, a0Var), this.f10903e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
