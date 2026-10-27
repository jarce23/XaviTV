package i1;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: h, reason: collision with root package name */
    public static final g f5882h = new g(1, 2, 3, null, -1, -1);

    /* renamed from: i, reason: collision with root package name */
    public static final String f5883i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f5884j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f5885k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f5886l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f5887m;

    /* renamed from: n, reason: collision with root package name */
    public static final String f5888n;

    /* renamed from: a, reason: collision with root package name */
    public final int f5889a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5890b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5891c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f5892d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5893e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5894f;
    public int g;

    static {
        int i10 = l1.a0.f8067a;
        f5883i = Integer.toString(0, 36);
        f5884j = Integer.toString(1, 36);
        f5885k = Integer.toString(2, 36);
        f5886l = Integer.toString(3, 36);
        f5887m = Integer.toString(4, 36);
        f5888n = Integer.toString(5, 36);
    }

    public g(int i10, int i11, int i12, byte[] bArr, int i13, int i14) {
        this.f5889a = i10;
        this.f5890b = i11;
        this.f5891c = i12;
        this.f5892d = bArr;
        this.f5893e = i13;
        this.f5894f = i14;
    }

    public static String a(int i10) {
        return i10 != -1 ? i10 != 1 ? i10 != 2 ? android.support.v4.media.d.m(i10, "Undefined color range ") : "Limited range" : "Full range" : "Unset color range";
    }

    public static String b(int i10) {
        return i10 != -1 ? i10 != 6 ? i10 != 1 ? i10 != 2 ? android.support.v4.media.d.m(i10, "Undefined color space ") : "BT601" : "BT709" : "BT2020" : "Unset color space";
    }

    public static String c(int i10) {
        return i10 != -1 ? i10 != 10 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 6 ? i10 != 7 ? android.support.v4.media.d.m(i10, "Undefined color transfer ") : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    public static boolean e(g gVar) {
        if (gVar == null) {
            return true;
        }
        int i10 = gVar.f5889a;
        if (i10 != -1 && i10 != 1 && i10 != 2) {
            return false;
        }
        int i11 = gVar.f5890b;
        if (i11 != -1 && i11 != 2) {
            return false;
        }
        int i12 = gVar.f5891c;
        if ((i12 != -1 && i12 != 3) || gVar.f5892d != null) {
            return false;
        }
        int i13 = gVar.f5894f;
        if (i13 != -1 && i13 != 8) {
            return false;
        }
        int i14 = gVar.f5893e;
        return i14 == -1 || i14 == 8;
    }

    public static int f(int i10) {
        if (i10 == 1) {
            return 1;
        }
        if (i10 != 9) {
            return (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int g(int i10) {
        if (i10 == 1) {
            return 3;
        }
        if (i10 == 4) {
            return 10;
        }
        if (i10 == 13) {
            return 2;
        }
        if (i10 == 16) {
            return 6;
        }
        if (i10 != 18) {
            return (i10 == 6 || i10 == 7) ? 3 : -1;
        }
        return 7;
    }

    public final boolean d() {
        return (this.f5889a == -1 || this.f5890b == -1 || this.f5891c == -1) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f5889a == gVar.f5889a && this.f5890b == gVar.f5890b && this.f5891c == gVar.f5891c && Arrays.equals(this.f5892d, gVar.f5892d) && this.f5893e == gVar.f5893e && this.f5894f == gVar.f5894f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.g == 0) {
            this.g = ((((Arrays.hashCode(this.f5892d) + ((((((527 + this.f5889a) * 31) + this.f5890b) * 31) + this.f5891c) * 31)) * 31) + this.f5893e) * 31) + this.f5894f;
        }
        return this.g;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("ColorInfo(");
        sb2.append(b(this.f5889a));
        sb2.append(", ");
        sb2.append(a(this.f5890b));
        sb2.append(", ");
        sb2.append(c(this.f5891c));
        sb2.append(", ");
        sb2.append(this.f5892d != null);
        sb2.append(", ");
        String str2 = "NA";
        int i10 = this.f5893e;
        if (i10 != -1) {
            str = i10 + "bit Luma";
        } else {
            str = "NA";
        }
        sb2.append(str);
        sb2.append(", ");
        int i11 = this.f5894f;
        if (i11 != -1) {
            str2 = i11 + "bit Chroma";
        }
        return android.support.v4.media.d.r(sb2, str2, ")");
    }
}
