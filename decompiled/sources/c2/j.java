package c2;

import java.io.IOException;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements k0, v1.d {

    /* renamed from: o, reason: collision with root package name */
    public final Object f2617o;

    /* renamed from: p, reason: collision with root package name */
    public j0 f2618p;

    /* renamed from: q, reason: collision with root package name */
    public j0 f2619q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ l f2620r;

    public j(l lVar, Object obj) {
        this.f2620r = lVar;
        int i10 = 0;
        d0 d0Var = null;
        this.f2618p = new j0(lVar.f2520c.f2623c, i10, d0Var);
        this.f2619q = new j0(lVar.f2521d.f2623c, i10, d0Var);
        this.f2617o = obj;
    }

    @Override // c2.k0
    public final void F(int i10, d0 d0Var, z zVar) {
        if (a(i10, d0Var)) {
            j0 j0Var = this.f2618p;
            z b2 = b(zVar, d0Var);
            j0Var.getClass();
            j0Var.a(new a7.g(j0Var, 3, b2));
        }
    }

    @Override // c2.k0
    public final void G(int i10, d0 d0Var, z zVar) {
        if (a(i10, d0Var)) {
            j0 j0Var = this.f2618p;
            z b2 = b(zVar, d0Var);
            d0 d0Var2 = j0Var.f2622b;
            d0Var2.getClass();
            j0Var.a(new a7.f(j0Var, d0Var2, b2, 3));
        }
    }

    public final boolean a(int i10, d0 d0Var) {
        d0 d0Var2;
        Object obj = this.f2617o;
        l lVar = this.f2620r;
        if (d0Var != null) {
            d0Var2 = lVar.s(obj, d0Var);
            if (d0Var2 == null) {
                return false;
            }
        } else {
            d0Var2 = null;
        }
        int u10 = lVar.u(i10, obj);
        j0 j0Var = this.f2618p;
        if (j0Var.f2621a != u10 || !Objects.equals(j0Var.f2622b, d0Var2)) {
            this.f2618p = new j0(lVar.f2520c.f2623c, u10, d0Var2);
        }
        j0 j0Var2 = this.f2619q;
        if (j0Var2.f2621a == u10 && Objects.equals(j0Var2.f2622b, d0Var2)) {
            return true;
        }
        this.f2619q = new j0(lVar.f2521d.f2623c, u10, d0Var2);
        return true;
    }

    public final z b(z zVar, d0 d0Var) {
        long j10 = zVar.f2781f;
        l lVar = this.f2620r;
        Object obj = this.f2617o;
        long t3 = lVar.t(j10, obj);
        long j11 = zVar.g;
        long t8 = lVar.t(j11, obj);
        return (t3 == j10 && t8 == j11) ? zVar : new z(zVar.f2776a, zVar.f2777b, zVar.f2778c, zVar.f2779d, zVar.f2780e, t3, t8);
    }

    @Override // c2.k0
    public final void g(int i10, d0 d0Var, u uVar, z zVar, int i11) {
        if (a(i10, d0Var)) {
            j0 j0Var = this.f2618p;
            z b2 = b(zVar, d0Var);
            j0Var.getClass();
            j0Var.a(new f0(j0Var, uVar, b2, i11));
        }
    }

    @Override // c2.k0
    public final void i(int i10, d0 d0Var, u uVar, z zVar) {
        if (a(i10, d0Var)) {
            j0 j0Var = this.f2618p;
            z b2 = b(zVar, d0Var);
            j0Var.getClass();
            j0Var.a(new g0(j0Var, uVar, b2, 1));
        }
    }

    @Override // c2.k0
    public final void l(int i10, d0 d0Var, u uVar, z zVar) {
        if (a(i10, d0Var)) {
            j0 j0Var = this.f2618p;
            z b2 = b(zVar, d0Var);
            j0Var.getClass();
            j0Var.a(new g0(j0Var, uVar, b2, 0));
        }
    }

    @Override // c2.k0
    public final void p(int i10, d0 d0Var, u uVar, z zVar, IOException iOException, boolean z10) {
        if (a(i10, d0Var)) {
            j0 j0Var = this.f2618p;
            z b2 = b(zVar, d0Var);
            j0Var.getClass();
            j0Var.a(new h0(j0Var, uVar, b2, iOException, z10));
        }
    }
}
