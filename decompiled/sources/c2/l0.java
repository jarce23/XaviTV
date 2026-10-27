package c2;

import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 implements f2.t {

    /* renamed from: a, reason: collision with root package name */
    public final f2.t f2636a;

    /* renamed from: b, reason: collision with root package name */
    public final i1.u0 f2637b;

    public l0(f2.t tVar, i1.u0 u0Var) {
        this.f2636a = tVar;
        this.f2637b = u0Var;
    }

    @Override // f2.t
    public final void a(boolean z10) {
        this.f2636a.a(z10);
    }

    @Override // f2.t
    public final boolean b(int i10, long j10) {
        return this.f2636a.b(i10, j10);
    }

    @Override // f2.t
    public final boolean c(long j10, d2.a aVar, List list) {
        return this.f2636a.c(j10, aVar, list);
    }

    @Override // f2.t
    public final i1.p d(int i10) {
        return this.f2637b.f6042d[this.f2636a.f(i10)];
    }

    @Override // f2.t
    public final void e() {
        this.f2636a.e();
    }

    public final boolean equals(Object obj) {
        if (u(obj) && (obj instanceof l0)) {
            return this.f2637b.equals(((l0) obj).f2637b);
        }
        return false;
    }

    @Override // f2.t
    public final int f(int i10) {
        return this.f2636a.f(i10);
    }

    @Override // f2.t
    public final int g(long j10, List list) {
        return this.f2636a.g(j10, list);
    }

    @Override // f2.t
    public final void h() {
        this.f2636a.h();
    }

    public final int hashCode() {
        return this.f2637b.hashCode() + (this.f2636a.hashCode() * 31);
    }

    @Override // f2.t
    public final void i(long j10, long j11, long j12, List list, d2.c[] cVarArr) {
        this.f2636a.i(j10, j11, j12, list, cVarArr);
    }

    @Override // f2.t
    public final int j() {
        return this.f2636a.j();
    }

    @Override // f2.t
    public final i1.u0 k() {
        return this.f2637b;
    }

    @Override // f2.t
    public final i1.p l() {
        return this.f2637b.f6042d[this.f2636a.j()];
    }

    @Override // f2.t
    public final int length() {
        return this.f2636a.length();
    }

    @Override // f2.t
    public final int m() {
        return this.f2636a.m();
    }

    @Override // f2.t
    public final int n() {
        return this.f2636a.n();
    }

    @Override // f2.t
    public final boolean o(int i10, long j10) {
        return this.f2636a.o(i10, j10);
    }

    @Override // f2.t
    public final void p(float f10) {
        this.f2636a.p(f10);
    }

    @Override // f2.t
    public final Object q() {
        return this.f2636a.q();
    }

    @Override // f2.t
    public final void r() {
        this.f2636a.r();
    }

    @Override // f2.t
    public final void s() {
        this.f2636a.s();
    }

    @Override // f2.t
    public final int t(int i10) {
        return this.f2636a.t(i10);
    }

    public final boolean u(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l0) {
            return this.f2636a.equals(((l0) obj).f2636a);
        }
        return false;
    }
}
