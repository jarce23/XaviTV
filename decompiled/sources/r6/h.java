package r6;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f10832a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10833b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10834c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10835d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10836e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10837f;
    public final String g;

    /* renamed from: h, reason: collision with root package name */
    public final String f10838h;

    /* renamed from: i, reason: collision with root package name */
    public final String f10839i;

    /* renamed from: j, reason: collision with root package name */
    public final String f10840j;

    /* renamed from: k, reason: collision with root package name */
    public final String f10841k;

    /* renamed from: l, reason: collision with root package name */
    public final String f10842l;

    public h(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f10832a = num;
        this.f10833b = str;
        this.f10834c = str2;
        this.f10835d = str3;
        this.f10836e = str4;
        this.f10837f = str5;
        this.g = str6;
        this.f10838h = str7;
        this.f10839i = str8;
        this.f10840j = str9;
        this.f10841k = str10;
        this.f10842l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            Integer num = this.f10832a;
            if (num != null ? num.equals(((h) aVar).f10832a) : ((h) aVar).f10832a == null) {
                String str = this.f10833b;
                if (str != null ? str.equals(((h) aVar).f10833b) : ((h) aVar).f10833b == null) {
                    String str2 = this.f10834c;
                    if (str2 != null ? str2.equals(((h) aVar).f10834c) : ((h) aVar).f10834c == null) {
                        String str3 = this.f10835d;
                        if (str3 != null ? str3.equals(((h) aVar).f10835d) : ((h) aVar).f10835d == null) {
                            String str4 = this.f10836e;
                            if (str4 != null ? str4.equals(((h) aVar).f10836e) : ((h) aVar).f10836e == null) {
                                String str5 = this.f10837f;
                                if (str5 != null ? str5.equals(((h) aVar).f10837f) : ((h) aVar).f10837f == null) {
                                    String str6 = this.g;
                                    if (str6 != null ? str6.equals(((h) aVar).g) : ((h) aVar).g == null) {
                                        String str7 = this.f10838h;
                                        if (str7 != null ? str7.equals(((h) aVar).f10838h) : ((h) aVar).f10838h == null) {
                                            String str8 = this.f10839i;
                                            if (str8 != null ? str8.equals(((h) aVar).f10839i) : ((h) aVar).f10839i == null) {
                                                String str9 = this.f10840j;
                                                if (str9 != null ? str9.equals(((h) aVar).f10840j) : ((h) aVar).f10840j == null) {
                                                    String str10 = this.f10841k;
                                                    if (str10 != null ? str10.equals(((h) aVar).f10841k) : ((h) aVar).f10841k == null) {
                                                        String str11 = this.f10842l;
                                                        if (str11 != null ? str11.equals(((h) aVar).f10842l) : ((h) aVar).f10842l == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.f10832a;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f10833b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f10834c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f10835d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f10836e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f10837f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f10838h;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f10839i;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f10840j;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f10841k;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f10842l;
        return (str11 != null ? str11.hashCode() : 0) ^ hashCode11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb2.append(this.f10832a);
        sb2.append(", model=");
        sb2.append(this.f10833b);
        sb2.append(", hardware=");
        sb2.append(this.f10834c);
        sb2.append(", device=");
        sb2.append(this.f10835d);
        sb2.append(", product=");
        sb2.append(this.f10836e);
        sb2.append(", osBuild=");
        sb2.append(this.f10837f);
        sb2.append(", manufacturer=");
        sb2.append(this.g);
        sb2.append(", fingerprint=");
        sb2.append(this.f10838h);
        sb2.append(", locale=");
        sb2.append(this.f10839i);
        sb2.append(", country=");
        sb2.append(this.f10840j);
        sb2.append(", mccMnc=");
        sb2.append(this.f10841k);
        sb2.append(", applicationBuild=");
        return android.support.v4.media.d.r(sb2, this.f10842l, "}");
    }
}
