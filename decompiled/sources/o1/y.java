package o1;

import android.text.TextUtils;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o9.b1;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f9463a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f9464b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static String a(long j10, long j11) {
        if (j10 == 0 && j11 == -1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder("bytes=");
        sb2.append(j10);
        sb2.append("-");
        if (j11 != -1) {
            sb2.append((j10 + j11) - 1);
        }
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long b(java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "Inconsistent headers ["
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            java.lang.String r2 = "]"
            java.lang.String r3 = "HttpUtil"
            if (r1 != 0) goto L25
            long r4 = java.lang.Long.parseLong(r10)     // Catch: java.lang.NumberFormatException -> L11
            goto L27
        L11:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "Unexpected Content-Length ["
            r1.<init>(r4)
            r1.append(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            l1.b.g(r3, r1)
        L25:
            r4 = -1
        L27:
            boolean r1 = android.text.TextUtils.isEmpty(r11)
            if (r1 != 0) goto L94
            java.util.regex.Pattern r1 = o1.y.f9463a
            java.util.regex.Matcher r1 = r1.matcher(r11)
            boolean r6 = r1.matches()
            if (r6 == 0) goto L94
            r6 = 2
            java.lang.String r6 = r1.group(r6)     // Catch: java.lang.NumberFormatException -> L80
            r6.getClass()     // Catch: java.lang.NumberFormatException -> L80
            long r6 = java.lang.Long.parseLong(r6)     // Catch: java.lang.NumberFormatException -> L80
            r8 = 1
            java.lang.String r1 = r1.group(r8)     // Catch: java.lang.NumberFormatException -> L80
            r1.getClass()     // Catch: java.lang.NumberFormatException -> L80
            long r8 = java.lang.Long.parseLong(r1)     // Catch: java.lang.NumberFormatException -> L80
            long r6 = r6 - r8
            r8 = 1
            long r6 = r6 + r8
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L5d
            r4 = r6
            goto L94
        L5d:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L94
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L80
            r1.<init>(r0)     // Catch: java.lang.NumberFormatException -> L80
            r1.append(r10)     // Catch: java.lang.NumberFormatException -> L80
            java.lang.String r10 = "] ["
            r1.append(r10)     // Catch: java.lang.NumberFormatException -> L80
            r1.append(r11)     // Catch: java.lang.NumberFormatException -> L80
            r1.append(r2)     // Catch: java.lang.NumberFormatException -> L80
            java.lang.String r10 = r1.toString()     // Catch: java.lang.NumberFormatException -> L80
            l1.b.q(r3, r10)     // Catch: java.lang.NumberFormatException -> L80
            long r4 = java.lang.Math.max(r4, r6)     // Catch: java.lang.NumberFormatException -> L80
            goto L94
        L80:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Unexpected Content-Range ["
            r10.<init>(r0)
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            l1.b.g(r3, r10)
        L94:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.y.b(java.lang.String, java.lang.String):long");
    }

    public static String c(String str, Map map, CookieHandler cookieHandler) {
        Map<String, List<String>> map2;
        List<String> list;
        if (cookieHandler == null) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        try {
            map2 = cookieHandler.get(new URI(str), map);
        } catch (Exception e7) {
            l1.b.r("HttpUtil", "Failed to read cookies from CookieHandler", e7);
            map2 = b1.f9578u;
        }
        StringBuilder sb2 = new StringBuilder();
        if (map2.containsKey("Cookie") && (list = map2.get("Cookie")) != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append("; ");
            }
        }
        String sb3 = sb2.toString();
        int length = sb3.length();
        while (length > 0) {
            int codePointBefore = Character.codePointBefore(sb3, length);
            if (!Character.isWhitespace(codePointBefore)) {
                break;
            }
            length -= Character.charCount(codePointBefore);
        }
        return sb3.substring(0, length);
    }

    public static long d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = f9464b.matcher(str);
        if (!matcher.matches()) {
            return -1L;
        }
        String group = matcher.group(1);
        group.getClass();
        return Long.parseLong(group);
    }
}
