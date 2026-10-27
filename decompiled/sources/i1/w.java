package i1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final long f6053a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6054b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6055c;

    /* renamed from: d, reason: collision with root package name */
    public final float f6056d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6057e;

    static {
        new v().a();
        l1.a0.J(0);
        l1.a0.J(1);
        l1.a0.J(2);
        l1.a0.J(3);
        l1.a0.J(4);
    }

    public w(v vVar) {
        long j10 = vVar.f6044a;
        long j11 = vVar.f6045b;
        long j12 = vVar.f6046c;
        float f10 = vVar.f6047d;
        float f11 = vVar.f6048e;
        this.f6053a = j10;
        this.f6054b = j11;
        this.f6055c = j12;
        this.f6056d = f10;
        this.f6057e = f11;
    }

    public final v a() {
        v vVar = new v();
        vVar.f6044a = this.f6053a;
        vVar.f6045b = this.f6054b;
        vVar.f6046c = this.f6055c;
        vVar.f6047d = this.f6056d;
        vVar.f6048e = this.f6057e;
        return vVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f6053a == wVar.f6053a && this.f6054b == wVar.f6054b && this.f6055c == wVar.f6055c && this.f6056d == wVar.f6056d && this.f6057e == wVar.f6057e;
    }

    public final int hashCode() {
        long j10 = this.f6053a;
        long j11 = this.f6054b;
        int i10 = ((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f6055c;
        int i11 = (i10 + ((int) ((j12 >>> 32) ^ j12))) * 31;
        float f10 = this.f6056d;
        int floatToIntBits = (i11 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
        float f11 = this.f6057e;
        return floatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0);
    }
}
