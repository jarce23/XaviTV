package r3;

import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f10628a;

    /* renamed from: b, reason: collision with root package name */
    public long f10629b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10630c;

    /* renamed from: d, reason: collision with root package name */
    public int f10631d;

    /* renamed from: e, reason: collision with root package name */
    public long f10632e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10633f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10634h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10635i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10636j;

    /* renamed from: k, reason: collision with root package name */
    public long f10637k;

    /* renamed from: l, reason: collision with root package name */
    public long f10638l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10639m;

    public q(g0 g0Var) {
        this.f10628a = g0Var;
    }

    public final void a(int i10) {
        long j10 = this.f10638l;
        if (j10 != -9223372036854775807L) {
            long j11 = this.f10629b;
            long j12 = this.f10637k;
            if (j11 == j12) {
                return;
            }
            int i11 = (int) (j11 - j12);
            this.f10628a.e(j10, this.f10639m ? 1 : 0, i11, i10, null);
        }
    }
}
