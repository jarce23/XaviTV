package e4;

import gb.i;
import java.util.Locale;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f4554a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4555b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4556c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4557d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4558e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4559f;
    public final int g;

    public a(int i10, int i11, String str, String str2, String str3, boolean z10) {
        this.f4554a = str;
        this.f4555b = str2;
        this.f4556c = z10;
        this.f4557d = i10;
        this.f4558e = str3;
        this.f4559f = i11;
        Locale locale = Locale.US;
        h.d("US", locale);
        String upperCase = str2.toUpperCase(locale);
        h.d("this as java.lang.String).toUpperCase(locale)", upperCase);
        this.g = i.b0(upperCase, "INT") ? 3 : (i.b0(upperCase, "CHAR") || i.b0(upperCase, "CLOB") || i.b0(upperCase, "TEXT")) ? 2 : i.b0(upperCase, "BLOB") ? 5 : (i.b0(upperCase, "REAL") || i.b0(upperCase, "FLOA") || i.b0(upperCase, "DOUB")) ? 4 : 1;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f4557d != aVar.f4557d) {
                return false;
            }
            int i10 = aVar.f4559f;
            String str = aVar.f4558e;
            if (!this.f4554a.equals(aVar.f4554a) || this.f4556c != aVar.f4556c) {
                return false;
            }
            String str2 = this.f4558e;
            int i11 = this.f4559f;
            if (i11 == 1 && i10 == 2 && str2 != null && !a.a.j(str2, str)) {
                return false;
            }
            if (i11 == 2 && i10 == 1 && str != null && !a.a.j(str, str2)) {
                return false;
            }
            if (i11 != 0 && i11 == i10) {
                if (str2 != null) {
                    if (!a.a.j(str2, str)) {
                        return false;
                    }
                } else if (str != null) {
                    return false;
                }
            }
            if (this.g != aVar.g) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.f4554a.hashCode() * 31) + this.g) * 31) + (this.f4556c ? 1231 : 1237)) * 31) + this.f4557d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Column{name='");
        sb2.append(this.f4554a);
        sb2.append("', type='");
        sb2.append(this.f4555b);
        sb2.append("', affinity='");
        sb2.append(this.g);
        sb2.append("', notNull=");
        sb2.append(this.f4556c);
        sb2.append(", primaryKeyPosition=");
        sb2.append(this.f4557d);
        sb2.append(", defaultValue='");
        String str = this.f4558e;
        if (str == null) {
            str = "undefined";
        }
        return android.support.v4.media.d.r(sb2, str, "'}");
    }
}
