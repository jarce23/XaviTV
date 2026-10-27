package z2;

import java.util.Locale;
import java.util.Objects;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f14054a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14055b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14056c;

    public b(int i10, long j10, long j11) {
        l1.d.b(j10 < j11);
        this.f14054a = j10;
        this.f14055b = j11;
        this.f14056c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f14054a == bVar.f14054a && this.f14055b == bVar.f14055b && this.f14056c == bVar.f14056c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f14054a), Long.valueOf(this.f14055b), Integer.valueOf(this.f14056c));
    }

    public final String toString() {
        int i10 = a0.f8067a;
        Locale locale = Locale.US;
        return "Segment: startTimeMs=" + this.f14054a + ", endTimeMs=" + this.f14055b + ", speedDivisor=" + this.f14056c;
    }
}
