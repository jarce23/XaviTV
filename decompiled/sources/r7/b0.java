package r7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f10872a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f10873b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10874c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f10875d;

    /* renamed from: e, reason: collision with root package name */
    public final a0 f10876e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f10877f;
    public final /* synthetic */ d0 g;

    public b0(d0 d0Var, a0 a0Var) {
        this.g = d0Var;
        this.f10876e = a0Var;
    }

    public final n7.a a(String str, Executor executor) {
        d0 d0Var;
        u7.a aVar;
        Context context;
        a0 a0Var;
        try {
            Intent a10 = t.a(this.g.f10900b, this.f10876e);
            this.f10873b = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(v7.b.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
            }
            try {
                d0Var = this.g;
                aVar = d0Var.f10902d;
                context = d0Var.f10900b;
                a0Var = this.f10876e;
            } catch (Throwable th) {
                th = th;
            }
            try {
                boolean b2 = aVar.b(context, str, a10, this, executor);
                this.f10874c = b2;
                if (b2) {
                    d0Var.f10901c.sendMessageDelayed(d0Var.f10901c.obtainMessage(1, a0Var), d0Var.f10904f);
                    n7.a aVar2 = n7.a.f9212t;
                    StrictMode.setVmPolicy(vmPolicy);
                    return aVar2;
                }
                this.f10873b = 2;
                try {
                    d0Var.f10902d.a(d0Var.f10900b, this);
                } catch (IllegalArgumentException unused) {
                }
                n7.a aVar3 = new n7.a(16, null, null);
                StrictMode.setVmPolicy(vmPolicy);
                return aVar3;
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                StrictMode.setVmPolicy(vmPolicy);
                throw th3;
            }
        } catch (s e7) {
            return e7.f10954o;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d0 d0Var = this.g;
        synchronized (d0Var.f10899a) {
            try {
                d0Var.f10901c.removeMessages(1, this.f10876e);
                this.f10875d = iBinder;
                this.f10877f = componentName;
                Iterator it = this.f10872a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f10873b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        d0 d0Var = this.g;
        synchronized (d0Var.f10899a) {
            try {
                d0Var.f10901c.removeMessages(1, this.f10876e);
                this.f10875d = null;
                this.f10877f = componentName;
                Iterator it = this.f10872a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f10873b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
