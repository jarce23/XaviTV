package w1;

import android.text.TextUtils;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final int f12869a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12870b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12871c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12872d;

    /* renamed from: e, reason: collision with root package name */
    public final String f12873e;

    /* renamed from: f, reason: collision with root package name */
    public final String f12874f;

    public s(int i10, int i11, String str, String str2, String str3, String str4) {
        this.f12869a = i10;
        this.f12870b = i11;
        this.f12871c = str;
        this.f12872d = str2;
        this.f12873e = str3;
        this.f12874f = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && s.class == obj.getClass()) {
            s sVar = (s) obj;
            if (this.f12869a == sVar.f12869a && this.f12870b == sVar.f12870b && TextUtils.equals(this.f12871c, sVar.f12871c) && TextUtils.equals(this.f12872d, sVar.f12872d) && TextUtils.equals(this.f12873e, sVar.f12873e) && TextUtils.equals(this.f12874f, sVar.f12874f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = ((this.f12869a * 31) + this.f12870b) * 31;
        String str = this.f12871c;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12872d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12873e;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f12874f;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }
}
