package m5;

import android.text.TextUtils;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f8964a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8965b;

    public e(String str, String str2) {
        this.f8964a = str;
        this.f8965b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (TextUtils.equals(this.f8964a, eVar.f8964a) && TextUtils.equals(this.f8965b, eVar.f8965b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f8965b.hashCode() + (this.f8964a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Header[name=");
        sb2.append(this.f8964a);
        sb2.append(",value=");
        return android.support.v4.media.d.r(sb2, this.f8965b, "]");
    }
}
