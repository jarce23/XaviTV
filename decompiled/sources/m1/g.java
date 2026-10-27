package m1;

import i1.c0;
import i1.e0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f8762a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8763b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8764c;

    public g(long j10, long j11, long j12) {
        this.f8762a = j10;
        this.f8763b = j11;
        this.f8764c = j12;
    }

    @Override // i1.e0
    public final /* synthetic */ i1.p a() {
        return null;
    }

    @Override // i1.e0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f8762a == gVar.f8762a && this.f8763b == gVar.f8763b && this.f8764c == gVar.f8764c;
    }

    public final int hashCode() {
        return i7.e.q(this.f8764c) + ((i7.e.q(this.f8763b) + ((i7.e.q(this.f8762a) + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.f8762a + ", modification time=" + this.f8763b + ", timescale=" + this.f8764c;
    }

    @Override // i1.e0
    public final /* synthetic */ void c(c0 c0Var) {
    }
}
