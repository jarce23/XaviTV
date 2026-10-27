package e3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f4417a;

    /* renamed from: b, reason: collision with root package name */
    public int f4418b;

    /* renamed from: c, reason: collision with root package name */
    public int f4419c;

    /* renamed from: d, reason: collision with root package name */
    public long f4420d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4421e;

    /* renamed from: f, reason: collision with root package name */
    public final l1.t f4422f;
    public final l1.t g;

    /* renamed from: h, reason: collision with root package name */
    public int f4423h;

    /* renamed from: i, reason: collision with root package name */
    public int f4424i;

    public b(l1.t tVar, l1.t tVar2, boolean z10) {
        this.g = tVar;
        this.f4422f = tVar2;
        this.f4421e = z10;
        tVar2.I(12);
        this.f4417a = tVar2.A();
        tVar.I(12);
        this.f4424i = tVar.A();
        k2.b.c("first_chunk must be 1", tVar.j() == 1);
        this.f4418b = -1;
    }

    public final boolean a() {
        int i10 = this.f4418b + 1;
        this.f4418b = i10;
        if (i10 == this.f4417a) {
            return false;
        }
        boolean z10 = this.f4421e;
        l1.t tVar = this.f4422f;
        this.f4420d = z10 ? tVar.B() : tVar.y();
        if (this.f4418b == this.f4423h) {
            l1.t tVar2 = this.g;
            this.f4419c = tVar2.A();
            tVar2.J(4);
            int i11 = this.f4424i - 1;
            this.f4424i = i11;
            this.f4423h = i11 > 0 ? tVar2.A() - 1 : -1;
        }
        return true;
    }
}
