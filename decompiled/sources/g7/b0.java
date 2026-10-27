package g7;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5179o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d0 f5180p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f5181q;

    public /* synthetic */ b0(d0 d0Var, int i10, int i11) {
        this.f5179o = i11;
        this.f5180p = d0Var;
        this.f5181q = i10;
    }

    private final void a() {
        d0 d0Var = this.f5180p;
        e0 e0Var = d0Var.f5201c;
        e0Var.f5219x = -1;
        e0Var.f5220y = -1;
        e0Var.f5215t = null;
        e0Var.f5216u = null;
        e0Var.f5217v = 0.0d;
        e0Var.i();
        e0Var.f5218w = false;
        e0Var.f5221z = null;
        e0 e0Var2 = d0Var.f5201c;
        e0Var2.F = 1;
        int i10 = this.f5181q;
        synchronized (e0Var2.E) {
            try {
                Iterator it = d0Var.f5201c.E.iterator();
                while (it.hasNext()) {
                    h7.r rVar = ((h7.k) it.next()).f5749a.f5729e;
                    if (rVar != null) {
                        try {
                            n7.a aVar = new n7.a(i10, null, null);
                            h7.p pVar = (h7.p) rVar;
                            Parcel w02 = pVar.w0();
                            com.google.android.gms.internal.cast.u.c(w02, aVar);
                            pVar.y0(w02, 3);
                        } catch (RemoteException e7) {
                            h7.d.f5726m.a(e7, "Unable to call %s on %s.", "onDisconnected", h7.r.class.getSimpleName());
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        d0Var.f5201c.g();
        e0 e0Var3 = d0Var.f5201c;
        e0Var3.f(e0Var3.f5206k);
    }

    private final void b() {
        Iterator it;
        d0 d0Var = this.f5180p;
        int i10 = this.f5181q;
        if (i10 == 0) {
            e0 e0Var = d0Var.f5201c;
            e0Var.F = 2;
            e0Var.f5208m = true;
            e0Var.f5209n = true;
            synchronized (e0Var.E) {
                try {
                    Iterator it2 = d0Var.f5201c.E.iterator();
                    while (it2.hasNext()) {
                        ((h7.k) it2.next()).a();
                    }
                } finally {
                }
            }
            return;
        }
        e0 e0Var2 = d0Var.f5201c;
        e0Var2.F = 1;
        synchronized (e0Var2.E) {
            try {
                it = d0Var.f5201c.E.iterator();
            } catch (RemoteException e7) {
                h7.d.f5726m.a(e7, "Unable to call %s on %s.", "onConnectionFailed", h7.r.class.getSimpleName());
            } finally {
            }
            while (it.hasNext()) {
                h7.r rVar = ((h7.k) it.next()).f5749a.f5729e;
                if (rVar != null) {
                    n7.a aVar = new n7.a(i10, null, null);
                    h7.p pVar = (h7.p) rVar;
                    Parcel w02 = pVar.w0();
                    com.google.android.gms.internal.cast.u.c(w02, aVar);
                    pVar.y0(w02, 3);
                }
            }
        }
        d0Var.f5201c.g();
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5179o) {
            case 0:
                a();
                return;
            case 1:
                b();
                return;
            case 2:
                this.f5180p.f5201c.D.b(this.f5181q);
                return;
            default:
                d0 d0Var = this.f5180p;
                e0 e0Var = d0Var.f5201c;
                e0Var.F = 3;
                int i10 = this.f5181q;
                synchronized (e0Var.E) {
                    try {
                        Iterator it = d0Var.f5201c.E.iterator();
                        while (it.hasNext()) {
                            h7.r rVar = ((h7.k) it.next()).f5749a.f5729e;
                            if (rVar != null) {
                                try {
                                    h7.p pVar = (h7.p) rVar;
                                    Parcel w02 = pVar.w0();
                                    w02.writeInt(i10);
                                    pVar.y0(w02, 2);
                                } catch (RemoteException e7) {
                                    h7.d.f5726m.a(e7, "Unable to call %s on %s.", "onConnectionSuspended", h7.r.class.getSimpleName());
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
