package q3;

import java.util.regex.Pattern;
import l1.t;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f10267c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f10268d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a, reason: collision with root package name */
    public final t f10269a = new t();

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f10270b = new StringBuilder();

    public static String a(t tVar, StringBuilder sb2) {
        boolean z10 = false;
        sb2.setLength(0);
        int i10 = tVar.f8130b;
        int i11 = tVar.f8131c;
        while (i10 < i11 && !z10) {
            char c10 = (char) tVar.f8129a[i10];
            if ((c10 < 'A' || c10 > 'Z') && ((c10 < 'a' || c10 > 'z') && !((c10 >= '0' && c10 <= '9') || c10 == '#' || c10 == '-' || c10 == '.' || c10 == '_'))) {
                z10 = true;
            } else {
                i10++;
                sb2.append(c10);
            }
        }
        tVar.J(i10 - tVar.f8130b);
        return sb2.toString();
    }

    public static String b(t tVar, StringBuilder sb2) {
        c(tVar);
        if (tVar.a() == 0) {
            return null;
        }
        String a10 = a(tVar, sb2);
        if (!a10.isEmpty()) {
            return a10;
        }
        return _UrlKt.FRAGMENT_ENCODE_SET + ((char) tVar.w());
    }

    public static void c(t tVar) {
        while (true) {
            for (boolean z10 = true; tVar.a() > 0 && z10; z10 = false) {
                int i10 = tVar.f8130b;
                byte[] bArr = tVar.f8129a;
                byte b2 = bArr[i10];
                char c10 = (char) b2;
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    tVar.J(1);
                } else {
                    int i11 = tVar.f8131c;
                    int i12 = i10 + 2;
                    if (i12 <= i11) {
                        int i13 = i10 + 1;
                        if (b2 == 47 && bArr[i13] == 42) {
                            while (true) {
                                int i14 = i12 + 1;
                                if (i14 >= i11) {
                                    break;
                                }
                                if (((char) bArr[i12]) == '*' && ((char) bArr[i14]) == '/') {
                                    i12 += 2;
                                    i11 = i12;
                                } else {
                                    i12 = i14;
                                }
                            }
                            tVar.J(i11 - tVar.f8130b);
                        }
                    }
                }
            }
            return;
        }
    }
}
