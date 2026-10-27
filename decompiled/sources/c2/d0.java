package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2539a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2540b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2541c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2542d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2543e;

    public d0(Object obj) {
        this(-1L, obj);
    }

    public final d0 a(Object obj) {
        if (this.f2539a.equals(obj)) {
            return this;
        }
        return new d0(obj, this.f2540b, this.f2541c, this.f2542d, this.f2543e);
    }

    public final boolean b() {
        return this.f2540b != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f2539a.equals(d0Var.f2539a) && this.f2540b == d0Var.f2540b && this.f2541c == d0Var.f2541c && this.f2542d == d0Var.f2542d && this.f2543e == d0Var.f2543e;
    }

    public final int hashCode() {
        return ((((((((this.f2539a.hashCode() + 527) * 31) + this.f2540b) * 31) + this.f2541c) * 31) + ((int) this.f2542d)) * 31) + this.f2543e;
    }

    public d0(long j10, Object obj) {
        this(obj, -1, -1, j10, -1);
    }

    public d0(int i10, long j10, Object obj) {
        this(obj, -1, -1, j10, i10);
    }

    public d0(Object obj, int i10, int i11, long j10, int i12) {
        this.f2539a = obj;
        this.f2540b = i10;
        this.f2541c = i11;
        this.f2542d = j10;
        this.f2543e = i12;
    }
}
