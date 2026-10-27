package q6;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f10347c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f10348d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f10349e;

    /* renamed from: a, reason: collision with root package name */
    public final String f10350a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10351b;

    static {
        String u10 = k5.a.u("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f10347c = u10;
        k5.a.u("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        k5.a.u("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f10348d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new p6.b("proto"), new p6.b("json"))));
        f10349e = new a(u10, null);
    }

    public a(String str, String str2) {
        this.f10350a = str;
        this.f10351b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
        if (split.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = split[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }
}
