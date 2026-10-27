package g7;

import com.google.android.gms.common.api.Status;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 extends l7.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e0 f5201c;

    public d0(e0 e0Var) {
        this.f5201c = e0Var;
    }

    @Override // l7.i
    public final void R() {
        e0.G.b("Deprecated callback: \"onStatusReceived\"", new Object[0]);
    }

    @Override // l7.i
    public final void Z(int i10) {
        e0.j(this.f5201c).post(new b0(this, i10, 3));
    }

    @Override // l7.i
    public final void a(int i10) {
        e0.e(this.f5201c, i10);
    }

    @Override // l7.i
    public final void a0(l7.c cVar) {
        e0.j(this.f5201c).post(new app.shamel.tv.activities.y(this, cVar, 10, false));
    }

    @Override // l7.i
    public final void c(int i10) {
        e0.e(this.f5201c, i10);
    }

    @Override // l7.i
    public final void d0(int i10) {
        e0.j(this.f5201c).post(new b0(this, i10, 0));
    }

    @Override // l7.i
    public final void g(int i10) {
        e0 e0Var = this.f5201c;
        e0.e(e0Var, i10);
        if (e0Var.D != null) {
            e0.j(e0Var).post(new b0(this, i10, 2));
        }
    }

    @Override // l7.i
    public final void i0(String str, String str2) {
        e0.G.b("Receive (type=text, ns=%s) %s", str, str2);
        e0.j(this.f5201c).post(new c0(this, str, str2, 0));
    }

    @Override // l7.i
    public final void k(d dVar, String str, String str2, boolean z10) {
        e0 e0Var = this.f5201c;
        e0Var.f5215t = dVar;
        e0Var.f5216u = str;
        l7.u uVar = new l7.u(new Status(0, null, null, null), dVar, str, str2, z10);
        synchronized (e0Var.f5213r) {
            try {
                i8.d dVar2 = e0Var.f5210o;
                if (dVar2 != null) {
                    dVar2.b(uVar);
                }
                e0Var.f5210o = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // l7.i
    public final void l0(int i10, long j10) {
        e0.d(this.f5201c, j10, i10);
    }

    @Override // l7.i
    public final void n0(int i10) {
        this.f5201c.h(i10);
    }

    @Override // l7.i
    public final void p0(String str, byte[] bArr) {
        e0.G.b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    @Override // l7.i
    public final void r(int i10) {
        e0.j(this.f5201c).post(new b0(this, i10, 1));
    }

    @Override // l7.i
    public final void r0(long j10) {
        e0.d(this.f5201c, j10, 0);
    }

    @Override // l7.i
    public final void t0(l7.e eVar) {
        e0.j(this.f5201c).post(new app.shamel.tv.activities.y(this, eVar, 9, false));
    }
}
