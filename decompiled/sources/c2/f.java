package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends s {

    /* renamed from: c, reason: collision with root package name */
    public final long f2573c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2574d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2575e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2576f;

    public f(i1.t0 t0Var, long j10, long j11) {
        super(t0Var);
        if (j11 != Long.MIN_VALUE && j11 < j10) {
            throw new g(2, j10, j11);
        }
        boolean z10 = false;
        if (t0Var.h() != 1) {
            throw new g(0);
        }
        i1.s0 m10 = t0Var.m(0, new i1.s0(), 0L);
        long max = Math.max(0L, j10);
        if (!m10.f6030k && max != 0 && !m10.f6027h) {
            throw new g(1);
        }
        long max2 = j11 == Long.MIN_VALUE ? m10.f6032m : Math.max(0L, j11);
        long j12 = m10.f6032m;
        if (j12 != -9223372036854775807L) {
            max2 = max2 > j12 ? j12 : max2;
            if (max > max2) {
                max = max2;
            }
        }
        this.f2573c = max;
        this.f2574d = max2;
        this.f2575e = max2 != -9223372036854775807L ? max2 - max : -9223372036854775807L;
        if (m10.f6028i && (max2 == -9223372036854775807L || (j12 != -9223372036854775807L && max2 == j12))) {
            z10 = true;
        }
        this.f2576f = z10;
    }

    @Override // c2.s, i1.t0
    public final i1.r0 f(int i10, i1.r0 r0Var, boolean z10) {
        this.f2707b.f(0, r0Var, z10);
        long j10 = r0Var.f6016e - this.f2573c;
        long j11 = this.f2575e;
        r0Var.h(r0Var.f6012a, r0Var.f6013b, 0, j11 != -9223372036854775807L ? j11 - j10 : -9223372036854775807L, j10, i1.c.f5813c, false);
        return r0Var;
    }

    @Override // c2.s, i1.t0
    public final i1.s0 m(int i10, i1.s0 s0Var, long j10) {
        this.f2707b.m(0, s0Var, 0L);
        long j11 = s0Var.f6035p;
        long j12 = this.f2573c;
        s0Var.f6035p = j11 + j12;
        s0Var.f6032m = this.f2575e;
        s0Var.f6028i = this.f2576f;
        long j13 = s0Var.f6031l;
        if (j13 != -9223372036854775807L) {
            long max = Math.max(j13, j12);
            s0Var.f6031l = max;
            long j14 = this.f2574d;
            if (j14 != -9223372036854775807L) {
                max = Math.min(max, j14);
            }
            s0Var.f6031l = max - j12;
        }
        long Z = l1.a0.Z(j12);
        long j15 = s0Var.f6025e;
        if (j15 != -9223372036854775807L) {
            s0Var.f6025e = j15 + Z;
        }
        long j16 = s0Var.f6026f;
        if (j16 != -9223372036854775807L) {
            s0Var.f6026f = j16 + Z;
        }
        return s0Var;
    }
}
