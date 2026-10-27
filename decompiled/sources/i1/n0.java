package i1;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5921a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5922b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f5923c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f5924d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5925e;

    /* renamed from: f, reason: collision with root package name */
    public final long f5926f;
    public final long g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5927h;

    /* renamed from: i, reason: collision with root package name */
    public final int f5928i;

    static {
        android.support.v4.media.d.t(0, 1, 2, 3, 4);
        l1.a0.J(5);
        l1.a0.J(6);
    }

    public n0(Object obj, int i10, a0 a0Var, Object obj2, int i11, long j10, long j11, int i12, int i13) {
        this.f5921a = obj;
        this.f5922b = i10;
        this.f5923c = a0Var;
        this.f5924d = obj2;
        this.f5925e = i11;
        this.f5926f = j10;
        this.g = j11;
        this.f5927h = i12;
        this.f5928i = i13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n0.class == obj.getClass()) {
            n0 n0Var = (n0) obj;
            if (this.f5922b == n0Var.f5922b && this.f5925e == n0Var.f5925e && this.f5926f == n0Var.f5926f && this.g == n0Var.g && this.f5927h == n0Var.f5927h && this.f5928i == n0Var.f5928i && Objects.equals(this.f5923c, n0Var.f5923c) && Objects.equals(this.f5921a, n0Var.f5921a) && Objects.equals(this.f5924d, n0Var.f5924d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f5921a, Integer.valueOf(this.f5922b), this.f5923c, this.f5924d, Integer.valueOf(this.f5925e), Long.valueOf(this.f5926f), Long.valueOf(this.g), Integer.valueOf(this.f5927h), Integer.valueOf(this.f5928i));
    }

    public final String toString() {
        String str = "mediaItem=" + this.f5922b + ", period=" + this.f5925e + ", pos=" + this.f5926f;
        int i10 = this.f5927h;
        if (i10 == -1) {
            return str;
        }
        StringBuilder a10 = s.e.a(str, ", contentPos=");
        a10.append(this.g);
        a10.append(", adGroup=");
        a10.append(i10);
        a10.append(", ad=");
        a10.append(this.f5928i);
        return a10.toString();
    }
}
