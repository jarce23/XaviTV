package i2;

import android.content.Context;
import s1.g1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements s1.l0 {

    /* renamed from: o, reason: collision with root package name */
    public boolean f6265o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f6266p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f6267q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f6268r;

    /* renamed from: s, reason: collision with root package name */
    public Object f6269s;

    /* renamed from: t, reason: collision with root package name */
    public Object f6270t;

    public o(s1.h0 h0Var, l1.v vVar) {
        this.f6268r = h0Var;
        this.f6267q = new g1(vVar);
        this.f6265o = true;
    }

    @Override // s1.l0
    public void a(i1.j0 j0Var) {
        s1.l0 l0Var = (s1.l0) this.f6270t;
        if (l0Var != null) {
            l0Var.a(j0Var);
            j0Var = ((s1.l0) this.f6270t).d();
        }
        ((g1) this.f6267q).a(j0Var);
    }

    @Override // s1.l0
    public boolean b() {
        if (this.f6265o) {
            ((g1) this.f6267q).getClass();
            return false;
        }
        s1.l0 l0Var = (s1.l0) this.f6270t;
        l0Var.getClass();
        return l0Var.b();
    }

    public void c(s1.d dVar) {
        s1.l0 l0Var;
        s1.l0 i10 = dVar.i();
        if (i10 == null || i10 == (l0Var = (s1.l0) this.f6270t)) {
            return;
        }
        if (l0Var != null) {
            throw new s1.l(2, new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.f6270t = i10;
        this.f6269s = dVar;
        ((u1.b0) i10).a((i1.j0) ((g1) this.f6267q).f11315s);
    }

    @Override // s1.l0
    public i1.j0 d() {
        s1.l0 l0Var = (s1.l0) this.f6270t;
        return l0Var != null ? l0Var.d() : (i1.j0) ((g1) this.f6267q).f11315s;
    }

    @Override // s1.l0
    public long e() {
        if (this.f6265o) {
            return ((g1) this.f6267q).e();
        }
        s1.l0 l0Var = (s1.l0) this.f6270t;
        l0Var.getClass();
        return l0Var.e();
    }

    public o(Context context, z zVar) {
        this.f6267q = context.getApplicationContext();
        this.f6268r = zVar;
        this.f6270t = l1.v.f8135a;
    }
}
