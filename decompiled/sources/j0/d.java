package j0;

import android.util.Base64;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f6909a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6910b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6911c;

    /* renamed from: d, reason: collision with root package name */
    public final List f6912d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6913e;

    /* renamed from: f, reason: collision with root package name */
    public final String f6914f;
    public final String g;

    public d(String str, String str2, String str3, List list, String str4, String str5) {
        str.getClass();
        this.f6909a = str;
        str2.getClass();
        this.f6910b = str2;
        this.f6911c = str3;
        list.getClass();
        this.f6912d = list;
        this.f6913e = str4;
        this.f6914f = str5;
        this.g = str + "-" + str2 + "-" + str3 + "-" + str4 + "-" + str5;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f6909a + ", mProviderPackage: " + this.f6910b + ", mQuery: " + this.f6911c + ", mSystemFont: " + this.f6913e + ", mVariationSettings: " + this.f6914f + ", mCertificates:");
        int i10 = 0;
        while (true) {
            List list = this.f6912d;
            if (i10 >= list.size()) {
                sb2.append("}mCertificatesArray: 0");
                return sb2.toString();
            }
            sb2.append(" [");
            List list2 = (List) list.get(i10);
            for (int i11 = 0; i11 < list2.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString((byte[]) list2.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
            i10++;
        }
    }
}
