package k2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final app.shamel.tv.b f7798a;

    /* renamed from: b, reason: collision with root package name */
    public final app.shamel.tv.b f7799b;

    /* renamed from: c, reason: collision with root package name */
    public long f7800c;

    public x(long j10, long[] jArr, long[] jArr2) {
        l1.d.b(jArr.length == jArr2.length);
        int length = jArr2.length;
        if (length <= 0 || jArr2[0] <= 0) {
            this.f7798a = new app.shamel.tv.b(length);
            this.f7799b = new app.shamel.tv.b(length);
        } else {
            int i10 = length + 1;
            app.shamel.tv.b bVar = new app.shamel.tv.b(i10);
            this.f7798a = bVar;
            app.shamel.tv.b bVar2 = new app.shamel.tv.b(i10);
            this.f7799b = bVar2;
            bVar.a(0L);
            bVar2.a(0L);
        }
        this.f7798a.b(jArr);
        this.f7799b.b(jArr2);
        this.f7800c = j10;
    }

    @Override // k2.a0
    public final boolean h() {
        return this.f7799b.f2095p > 0;
    }

    @Override // k2.a0
    public final z j(long j10) {
        app.shamel.tv.b bVar = this.f7799b;
        if (bVar.f2095p == 0) {
            b0 b0Var = b0.f7687c;
            return new z(b0Var, b0Var);
        }
        int b2 = l1.a0.b(bVar, j10);
        long e7 = bVar.e(b2);
        app.shamel.tv.b bVar2 = this.f7798a;
        b0 b0Var2 = new b0(e7, bVar2.e(b2));
        if (e7 == j10 || b2 == bVar.f2095p - 1) {
            return new z(b0Var2, b0Var2);
        }
        int i10 = b2 + 1;
        return new z(b0Var2, new b0(bVar.e(i10), bVar2.e(i10)));
    }

    @Override // k2.a0
    public final long l() {
        return this.f7800c;
    }
}
