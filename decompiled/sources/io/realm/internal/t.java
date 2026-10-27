package io.realm.internal;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t implements Comparable {

    /* renamed from: q, reason: collision with root package name */
    public static final t f6767q = new t(-1, -1);

    /* renamed from: o, reason: collision with root package name */
    public final long f6768o;

    /* renamed from: p, reason: collision with root package name */
    public final long f6769p;

    public t(long j10, long j11) {
        this.f6768o = j10;
        this.f6769p = j11;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        t tVar = (t) obj;
        if (tVar == null) {
            throw new IllegalArgumentException("Version cannot be compared to a null value.");
        }
        long j10 = this.f6768o;
        long j11 = tVar.f6768o;
        if (j10 > j11) {
            return 1;
        }
        return j10 < j11 ? -1 : 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && t.class == obj.getClass()) {
            t tVar = (t) obj;
            if (this.f6768o == tVar.f6768o && this.f6769p == tVar.f6769p) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f6768o;
        int i10 = ((int) (j10 ^ (j10 >>> 32))) * 31;
        long j11 = this.f6769p;
        return i10 + ((int) ((j11 >>> 32) ^ j11));
    }

    public final String toString() {
        return "VersionID{version=" + this.f6768o + ", index=" + this.f6769p + '}';
    }
}
