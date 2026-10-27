package t5;

import java.security.MessageDigest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements r5.e {

    /* renamed from: b, reason: collision with root package name */
    public final r5.e f11912b;

    /* renamed from: c, reason: collision with root package name */
    public final r5.e f11913c;

    public d(r5.e eVar, r5.e eVar2) {
        this.f11912b = eVar;
        this.f11913c = eVar2;
    }

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        this.f11912b.b(messageDigest);
        this.f11913c.b(messageDigest);
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f11912b.equals(dVar.f11912b) && this.f11913c.equals(dVar.f11913c)) {
                return true;
            }
        }
        return false;
    }

    @Override // r5.e
    public final int hashCode() {
        return this.f11913c.hashCode() + (this.f11912b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f11912b + ", signature=" + this.f11913c + '}';
    }
}
