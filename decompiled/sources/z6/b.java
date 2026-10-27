package z6;

import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f14125a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14126b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f14127c;

    public b(long j10, long j11, Set set) {
        this.f14125a = j10;
        this.f14126b = j11;
        this.f14127c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f14125a == bVar.f14125a && this.f14126b == bVar.f14126b && this.f14127c.equals(bVar.f14127c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f14125a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f14126b;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f14127c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f14125a + ", maxAllowedDelay=" + this.f14126b + ", flags=" + this.f14127c + "}";
    }
}
