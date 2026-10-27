package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m1 extends s {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2653c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2654d;

    public m1(i1.t0 t0Var, i1.a0 a0Var) {
        super(t0Var);
        this.f2654d = a0Var;
    }

    @Override // c2.s, i1.t0
    public i1.r0 f(int i10, i1.r0 r0Var, boolean z10) {
        switch (this.f2653c) {
            case 1:
                i1.t0 t0Var = this.f2707b;
                i1.r0 f10 = t0Var.f(i10, r0Var, z10);
                if (t0Var.m(f10.f6014c, (i1.s0) this.f2654d, 0L).a()) {
                    f10.h(r0Var.f6012a, r0Var.f6013b, r0Var.f6014c, r0Var.f6015d, r0Var.f6016e, i1.c.f5813c, true);
                } else {
                    f10.f6017f = true;
                }
                return f10;
            default:
                return super.f(i10, r0Var, z10);
        }
    }

    @Override // c2.s, i1.t0
    public i1.s0 m(int i10, i1.s0 s0Var, long j10) {
        switch (this.f2653c) {
            case 0:
                super.m(i10, s0Var, j10);
                i1.a0 a0Var = (i1.a0) this.f2654d;
                s0Var.f6023c = a0Var;
                i1.x xVar = a0Var.f5793b;
                s0Var.getClass();
                return s0Var;
            default:
                return super.m(i10, s0Var, j10);
        }
    }

    public m1(i1.t0 t0Var) {
        super(t0Var);
        this.f2654d = new i1.s0();
    }
}
