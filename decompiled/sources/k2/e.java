package k2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final g f7713a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7714b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7715c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7716d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7717e;

    /* renamed from: f, reason: collision with root package name */
    public final long f7718f;

    public e(g gVar, long j10, long j11, long j12, long j13, long j14) {
        this.f7713a = gVar;
        this.f7714b = j10;
        this.f7715c = j11;
        this.f7716d = j12;
        this.f7717e = j13;
        this.f7718f = j14;
    }

    @Override // k2.a0
    public final boolean h() {
        return true;
    }

    @Override // k2.a0
    public final z j(long j10) {
        b0 b0Var = new b0(j10, f.a(this.f7713a.i(j10), 0L, this.f7715c, this.f7716d, this.f7717e, this.f7718f));
        return new z(b0Var, b0Var);
    }

    @Override // k2.a0
    public final long l() {
        return this.f7714b;
    }
}
