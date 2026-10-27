package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x extends i1.t0 {

    /* renamed from: b, reason: collision with root package name */
    public final i1.a0 f2751b;

    public x(i1.a0 a0Var) {
        this.f2751b = a0Var;
    }

    @Override // i1.t0
    public final int b(Object obj) {
        return obj == w.f2743e ? 0 : -1;
    }

    @Override // i1.t0
    public final i1.r0 f(int i10, i1.r0 r0Var, boolean z10) {
        r0Var.h(z10 ? 0 : null, z10 ? w.f2743e : null, 0, -9223372036854775807L, 0L, i1.c.f5813c, true);
        return r0Var;
    }

    @Override // i1.t0
    public final int h() {
        return 1;
    }

    @Override // i1.t0
    public final Object l(int i10) {
        return w.f2743e;
    }

    @Override // i1.t0
    public final i1.s0 m(int i10, i1.s0 s0Var, long j10) {
        Object obj = i1.s0.f6019q;
        s0Var.b(this.f2751b, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0L);
        s0Var.f6030k = true;
        return s0Var;
    }

    @Override // i1.t0
    public final int o() {
        return 1;
    }
}
