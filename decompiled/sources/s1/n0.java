package s1;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final c2.d0 f11413a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11414b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11415c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11416d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11417e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11418f;
    public final boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f11419h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f11420i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f11421j;

    public n0(c2.d0 d0Var, long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15 = true;
        l1.d.b(!z14 || z12);
        l1.d.b(!z13 || z12);
        if (z11 && (z12 || z13 || z14)) {
            z15 = false;
        }
        l1.d.b(z15);
        this.f11413a = d0Var;
        this.f11414b = j10;
        this.f11415c = j11;
        this.f11416d = j12;
        this.f11417e = j13;
        this.f11418f = z10;
        this.g = z11;
        this.f11419h = z12;
        this.f11420i = z13;
        this.f11421j = z14;
    }

    public final n0 a(long j10) {
        if (j10 == this.f11415c) {
            return this;
        }
        return new n0(this.f11413a, this.f11414b, j10, this.f11416d, this.f11417e, this.f11418f, this.g, this.f11419h, this.f11420i, this.f11421j);
    }

    public final n0 b(long j10) {
        if (j10 == this.f11414b) {
            return this;
        }
        return new n0(this.f11413a, j10, this.f11415c, this.f11416d, this.f11417e, this.f11418f, this.g, this.f11419h, this.f11420i, this.f11421j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n0.class == obj.getClass()) {
            n0 n0Var = (n0) obj;
            if (this.f11414b == n0Var.f11414b && this.f11415c == n0Var.f11415c && this.f11416d == n0Var.f11416d && this.f11417e == n0Var.f11417e && this.f11418f == n0Var.f11418f && this.g == n0Var.g && this.f11419h == n0Var.f11419h && this.f11420i == n0Var.f11420i && this.f11421j == n0Var.f11421j && Objects.equals(this.f11413a, n0Var.f11413a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((((((this.f11413a.hashCode() + 527) * 31) + ((int) this.f11414b)) * 31) + ((int) this.f11415c)) * 31) + ((int) this.f11416d)) * 31) + ((int) this.f11417e)) * 31) + (this.f11418f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.f11419h ? 1 : 0)) * 31) + (this.f11420i ? 1 : 0)) * 31) + (this.f11421j ? 1 : 0);
    }
}
