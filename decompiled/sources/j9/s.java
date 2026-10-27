package j9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f7431a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7432b;

    public s(String str, String str2) {
        this.f7431a = str;
        this.f7432b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        String str = sVar.f7432b;
        if (!this.f7431a.equals(sVar.f7431a)) {
            return false;
        }
        String str2 = this.f7432b;
        return str2 == null ? str == null : str2.equals(str);
    }

    public final int hashCode() {
        int hashCode = this.f7431a.hashCode();
        String str = this.f7432b;
        return ((hashCode ^ (-721379959)) * 1000003) ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AssetPackLocation{packStorageMethod=0, path=");
        sb2.append(this.f7431a);
        sb2.append(", assetsPath=");
        return android.support.v4.media.d.r(sb2, this.f7432b, "}");
    }
}
