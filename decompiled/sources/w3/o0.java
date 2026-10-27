package w3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o0 extends n implements ServiceConnection {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f12984q = 0;

    /* renamed from: i, reason: collision with root package name */
    public final ComponentName f12985i;

    /* renamed from: j, reason: collision with root package name */
    public final b8.e f12986j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f12987k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12988l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12989m;

    /* renamed from: n, reason: collision with root package name */
    public j0 f12990n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12991o;

    /* renamed from: p, reason: collision with root package name */
    public androidx.fragment.app.v0 f12992p;

    static {
        Log.isLoggable("MediaRouteProviderProxy", 3);
    }

    public o0(Context context, ComponentName componentName) {
        super(context, new p4.p(26, componentName));
        this.f12987k = new ArrayList();
        this.f12985i = componentName;
        this.f12986j = new b8.e();
    }

    @Override // w3.n
    public final l c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
        }
        ea.a aVar = this.g;
        if (aVar == null) {
            return null;
        }
        List list = (List) aVar.f4681c;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((i) list.get(i10)).d().equals(str)) {
                m0 m0Var = new m0(this, str);
                this.f12987k.add(m0Var);
                if (this.f12991o) {
                    m0Var.c(this.f12990n);
                }
                m();
                return m0Var;
            }
        }
        return null;
    }

    @Override // w3.n
    public final m d(String str) {
        if (str != null) {
            return j(str, null);
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    @Override // w3.n
    public final m e(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return j(str, str2);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }

    @Override // w3.n
    public final void f(j jVar) {
        if (this.f12991o) {
            j0 j0Var = this.f12990n;
            int i10 = j0Var.f12943d;
            j0Var.f12943d = i10 + 1;
            j0Var.b(10, i10, 0, jVar != null ? jVar.f12938a : null, null);
        }
        m();
    }

    public final void i() {
        if (this.f12989m) {
            return;
        }
        Intent intent = new Intent("android.media.MediaRouteProviderService");
        intent.setComponent(this.f12985i);
        try {
            this.f12989m = this.f12967a.bindService(intent, this, Build.VERSION.SDK_INT >= 29 ? 4097 : 1);
        } catch (SecurityException unused) {
        }
    }

    public final n0 j(String str, String str2) {
        ea.a aVar = this.g;
        if (aVar == null) {
            return null;
        }
        List list = (List) aVar.f4681c;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((i) list.get(i10)).d().equals(str)) {
                n0 n0Var = new n0(this, str, str2);
                this.f12987k.add(n0Var);
                if (this.f12991o) {
                    n0Var.c(this.f12990n);
                }
                m();
                return n0Var;
            }
        }
        return null;
    }

    public final void k() {
        if (this.f12990n != null) {
            g(null);
            this.f12991o = false;
            ArrayList arrayList = this.f12987k;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((k0) arrayList.get(i10)).b();
            }
            j0 j0Var = this.f12990n;
            j0Var.b(2, 0, 0, null, null);
            j0Var.f12941b.f4745b.clear();
            j0Var.f12940a.getBinder().unlinkToDeath(j0Var, 0);
            j0Var.f12947i.f12986j.post(new i0(j0Var, 0));
            this.f12990n = null;
        }
    }

    public final void l() {
        if (this.f12989m) {
            this.f12989m = false;
            k();
            try {
                this.f12967a.unbindService(this);
            } catch (IllegalArgumentException e7) {
                Log.e("MediaRouteProviderProxy", this + ": unbindService failed", e7);
            }
        }
    }

    public final void m() {
        if (!this.f12988l || (this.f12971e == null && this.f12987k.isEmpty())) {
            l();
        } else {
            i();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f12989m) {
            k();
            Messenger messenger = iBinder != null ? new Messenger(iBinder) : null;
            if (messenger != null) {
                try {
                    if (messenger.getBinder() != null) {
                        j0 j0Var = new j0(this, messenger);
                        int i10 = j0Var.f12943d;
                        j0Var.f12943d = i10 + 1;
                        j0Var.g = i10;
                        if (j0Var.b(1, i10, 4, null, null)) {
                            try {
                                j0Var.f12940a.getBinder().linkToDeath(j0Var, 0);
                                this.f12990n = j0Var;
                                return;
                            } catch (RemoteException unused) {
                                j0Var.binderDied();
                                return;
                            }
                        }
                        return;
                    }
                } catch (NullPointerException unused2) {
                }
            }
            Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        k();
    }

    public final String toString() {
        return "Service connection " + this.f12985i.flattenToShortString();
    }
}
