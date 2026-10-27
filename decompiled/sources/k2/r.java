package k2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class r implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7765a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7766b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7767c;

    public /* synthetic */ r(int i10, long j10, Object obj) {
        this.f7765a = i10;
        this.f7767c = obj;
        this.f7766b = j10;
    }

    @Override // k2.a0
    public final boolean h() {
        switch (this.f7765a) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return true;
        }
    }

    @Override // k2.a0
    public final z j(long j10) {
        switch (this.f7765a) {
            case 0:
                s sVar = (s) this.f7767c;
                l1.d.h(sVar.f7777k);
                x4.c cVar = sVar.f7777k;
                long[] jArr = (long[]) cVar.f13537p;
                long[] jArr2 = (long[]) cVar.f13538q;
                int e7 = l1.a0.e(jArr, l1.a0.j((sVar.f7772e * j10) / 1000000, 0L, sVar.f7776j - 1), false);
                long j11 = e7 == -1 ? 0L : jArr[e7];
                long j12 = e7 != -1 ? jArr2[e7] : 0L;
                int i10 = sVar.f7772e;
                long j13 = (j11 * 1000000) / i10;
                long j14 = this.f7766b;
                b0 b0Var = new b0(j13, j12 + j14);
                if (j13 == j10 || e7 == jArr.length - 1) {
                    return new z(b0Var, b0Var);
                }
                int i11 = e7 + 1;
                return new z(b0Var, new b0((jArr[i11] * 1000000) / i10, j14 + jArr2[i11]));
            case 1:
                return (z) this.f7767c;
            default:
                m2.b bVar = (m2.b) this.f7767c;
                z b2 = bVar.f8828i[0].b(j10);
                int i12 = 1;
                while (true) {
                    m2.e[] eVarArr = bVar.f8828i;
                    if (i12 >= eVarArr.length) {
                        return b2;
                    }
                    z b10 = eVarArr[i12].b(j10);
                    if (b10.f7807a.f7689b < b2.f7807a.f7689b) {
                        b2 = b10;
                    }
                    i12++;
                }
        }
    }

    @Override // k2.a0
    public final long l() {
        switch (this.f7765a) {
        }
        return this.f7766b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(long j10) {
        this(j10, 0L);
        this.f7765a = 1;
    }

    public r(long j10, long j11) {
        this.f7765a = 1;
        this.f7766b = j10;
        b0 b0Var = j11 == 0 ? b0.f7687c : new b0(0L, j11);
        this.f7767c = new z(b0Var, b0Var);
    }
}
