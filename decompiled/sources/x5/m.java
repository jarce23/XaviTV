package x5;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f13653a;

    public m(String str) {
        this.f13653a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f13653a.equals(((m) obj).f13653a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13653a.hashCode();
    }

    public final String toString() {
        return android.support.v4.media.d.r(new StringBuilder("StringHeaderFactory{value='"), this.f13653a, "'}");
    }
}
