package l7;

import g7.c0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v extends h {

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f8320c;

    /* renamed from: d, reason: collision with root package name */
    public final b8.e f8321d;

    public v(w wVar) {
        this.f8320c = new AtomicReference(wVar);
        this.f8321d = new b8.e(wVar.f3212d, 2);
    }

    @Override // l7.i
    public final void R() {
        w.T.b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }

    @Override // l7.i
    public final void a(int i10) {
        if (((w) this.f8320c.get()) == null) {
            return;
        }
        synchronized (w.V) {
        }
    }

    @Override // l7.i
    public final void a0(c cVar) {
        w wVar = (w) this.f8320c.get();
        if (wVar == null) {
            return;
        }
        w.T.b("onApplicationStatusChanged", new Object[0]);
        this.f8321d.post(new app.shamel.tv.activities.y(wVar, cVar, 23, false));
    }

    @Override // l7.i
    public final void c(int i10) {
        if (((w) this.f8320c.get()) == null) {
            return;
        }
        synchronized (w.V) {
        }
    }

    @Override // l7.i
    public final void d0(int i10) {
        w wVar = null;
        w wVar2 = (w) this.f8320c.getAndSet(null);
        if (wVar2 != null) {
            wVar2.N = -1;
            wVar2.O = -1;
            wVar2.A = null;
            wVar2.H = null;
            wVar2.L = 0.0d;
            wVar2.x();
            wVar2.I = false;
            wVar2.M = null;
            wVar = wVar2;
        }
        if (wVar == null) {
            return;
        }
        w.T.b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i10));
        if (i10 != 0) {
            int i11 = wVar.f3231x.get();
            r7.u uVar = wVar.f3214f;
            uVar.sendMessage(uVar.obtainMessage(6, i11, 2));
        }
    }

    @Override // l7.i
    public final void g(int i10) {
        w wVar = (w) this.f8320c.get();
        if (wVar == null) {
            return;
        }
        wVar.P = null;
        wVar.Q = null;
        synchronized (w.V) {
        }
        if (wVar.C != null) {
            this.f8321d.post(new androidx.emoji2.text.j(i10, 4, wVar));
        }
    }

    @Override // l7.i
    public final void i0(String str, String str2) {
        w wVar = (w) this.f8320c.get();
        if (wVar == null) {
            return;
        }
        w.T.b("Receive (type=text, ns=%s) %s", str, str2);
        this.f8321d.post(new c0(wVar, str, str2, 4));
    }

    @Override // l7.i
    public final void k(g7.d dVar, String str, String str2, boolean z10) {
        w wVar = (w) this.f8320c.get();
        if (wVar == null) {
            return;
        }
        wVar.A = dVar;
        wVar.P = dVar.f5192o;
        wVar.Q = str2;
        wVar.H = str;
        synchronized (w.U) {
        }
    }

    @Override // l7.i
    public final void l0(int i10, long j10) {
        w wVar = (w) this.f8320c.get();
        if (wVar == null) {
            return;
        }
        w.v(wVar, j10);
    }

    @Override // l7.i
    public final void n0(int i10) {
        if (((w) this.f8320c.get()) == null) {
            return;
        }
        synchronized (w.U) {
        }
    }

    @Override // l7.i
    public final void p0(String str, byte[] bArr) {
        if (((w) this.f8320c.get()) == null) {
            return;
        }
        w.T.b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    @Override // l7.i
    public final void r0(long j10) {
        w wVar = (w) this.f8320c.get();
        if (wVar == null) {
            return;
        }
        w.v(wVar, j10);
    }

    @Override // l7.i
    public final void t0(e eVar) {
        w wVar = (w) this.f8320c.get();
        if (wVar == null) {
            return;
        }
        w.T.b("onDeviceStatusChanged", new Object[0]);
        this.f8321d.post(new app.shamel.tv.activities.y(wVar, eVar, 22, false));
    }

    @Override // l7.i
    public final void Z(int i10) {
    }

    @Override // l7.i
    public final void r(int i10) {
    }
}
