package okhttp3;

import android.support.v4.media.d;
import gb.i;
import gb.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.DateFormattingKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.url._UrlKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final String sameSite;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Builder {
        private String domain;
        private long expiresAt;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path;
        private boolean persistent;
        private String sameSite;
        private boolean secure;
        private String value;

        public Builder() {
            this.expiresAt = DateFormattingKt.MAX_DATE;
            this.path = "/";
        }

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j10 = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j10, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, this.sameSite, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final Builder domain(String str) {
            h.e("domain", str);
            return domain(str, false);
        }

        public final Builder expiresAt(long j10) {
            if (j10 <= 0) {
                j10 = Long.MIN_VALUE;
            }
            if (j10 > DateFormattingKt.MAX_DATE) {
                j10 = 253402300799999L;
            }
            this.expiresAt = j10;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            h.e("domain", str);
            return domain(str, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String str) {
            h.e("name", str);
            if (!h.a(i.o0(str).toString(), str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = str;
            return this;
        }

        public final Builder path(String str) {
            h.e("path", str);
            if (!p.Y(str, "/", false)) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = str;
            return this;
        }

        public final Builder sameSite(String str) {
            h.e("sameSite", str);
            if (!h.a(i.o0(str).toString(), str)) {
                throw new IllegalArgumentException("sameSite is not trimmed");
            }
            this.sameSite = str;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String str) {
            h.e("value", str);
            if (!h.a(i.o0(str).toString(), str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = str;
            return this;
        }

        private final Builder domain(String str, boolean z10) {
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(r.a.l("unexpected domain: ", str));
            }
            this.domain = canonicalHost;
            this.hostOnly = z10;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Cookie cookie) {
            this();
            h.e("cookie", cookie);
            this.name = cookie.name();
            this.value = cookie.value();
            this.expiresAt = cookie.expiresAt();
            this.domain = cookie.domain();
            this.path = cookie.path();
            this.secure = cookie.secure();
            this.httpOnly = cookie.httpOnly();
            this.persistent = cookie.persistent();
            this.hostOnly = cookie.hostOnly();
            this.sameSite = cookie.sameSite();
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final int dateCharacterOffset(String str, int i10, int i11, boolean z10) {
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || ('0' <= charAt && charAt < ':') || (('a' <= charAt && charAt < '{') || (('A' <= charAt && charAt < '[') || charAt == ':'))) == (!z10)) {
                    return i10;
                }
                i10++;
            }
            return i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            return h.a(str, str2) || (p.R(str, str2, false) && str.charAt((str.length() - str2.length()) - 1) == '.' && !_HostnamesCommonKt.canParseAsIpAddress(str));
        }

        private final String parseDomain(String str) {
            if (p.R(str, ".", false)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(i.k0(str, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i10, int i11) {
            int dateCharacterOffset = dateCharacterOffset(str, i10, i11, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            while (dateCharacterOffset < i11) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i11, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i13 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    h.d("group(...)", group);
                    i13 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    h.d("group(...)", group2);
                    i16 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    h.d("group(...)", group3);
                    i17 = Integer.parseInt(group3);
                } else if (i14 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    h.d("group(...)", group4);
                    i14 = Integer.parseInt(group4);
                } else if (i15 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    h.d("group(...)", group5);
                    Locale locale = Locale.US;
                    h.d("US", locale);
                    String lowerCase = group5.toLowerCase(locale);
                    h.d("toLowerCase(...)", lowerCase);
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    h.d("pattern(...)", pattern);
                    i15 = i.f0(pattern, lowerCase, 0, 6) / 4;
                } else if (i12 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    h.d("group(...)", group6);
                    i12 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i11, false);
            }
            if (70 <= i12 && i12 < 100) {
                i12 += 1900;
            }
            if (i12 >= 0 && i12 < 70) {
                i12 += 2000;
            }
            if (i12 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i15 == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i14 || i14 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i13 < 0 || i13 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i16 < 0 || i16 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i17 < 0 || i17 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(_UtilJvmKt.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i12);
            gregorianCalendar.set(2, i15 - 1);
            gregorianCalendar.set(5, i14);
            gregorianCalendar.set(11, i13);
            gregorianCalendar.set(12, i16);
            gregorianCalendar.set(13, i17);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e7) {
                Pattern compile = Pattern.compile("-?\\d+");
                h.d("compile(...)", compile);
                h.e("input", str);
                if (compile.matcher(str).matches()) {
                    return p.Y(str, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e7;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (h.a(encodedPath, str)) {
                return true;
            }
            return p.Y(encodedPath, str, false) && (p.R(str, "/", false) || encodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl httpUrl, String str) {
            h.e("url", httpUrl);
            h.e("setCookie", str);
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        public final Cookie parse$okhttp(long j10, HttpUrl httpUrl, String str) {
            long j11;
            String str2;
            h.e("url", httpUrl);
            h.e("setCookie", str);
            int delimiterOffset$default = _UtilCommonKt.delimiterOffset$default(str, ';', 0, 0, 6, (Object) null);
            int delimiterOffset$default2 = _UtilCommonKt.delimiterOffset$default(str, '=', 0, delimiterOffset$default, 2, (Object) null);
            String str3 = null;
            if (delimiterOffset$default2 != delimiterOffset$default) {
                String trimSubstring$default = _UtilCommonKt.trimSubstring$default(str, 0, delimiterOffset$default2, 1, null);
                if (trimSubstring$default.length() != 0 && _UtilCommonKt.indexOfControlOrNonAscii(trimSubstring$default) == -1) {
                    String trimSubstring = _UtilCommonKt.trimSubstring(str, delimiterOffset$default2 + 1, delimiterOffset$default);
                    if (_UtilCommonKt.indexOfControlOrNonAscii(trimSubstring) == -1) {
                        int i10 = delimiterOffset$default + 1;
                        int length = str.length();
                        String str4 = null;
                        boolean z10 = false;
                        boolean z11 = false;
                        boolean z12 = false;
                        boolean z13 = true;
                        long j12 = -1;
                        long j13 = DateFormattingKt.MAX_DATE;
                        String str5 = null;
                        while (i10 < length) {
                            int delimiterOffset = _UtilCommonKt.delimiterOffset(str, ';', i10, length);
                            int delimiterOffset2 = _UtilCommonKt.delimiterOffset(str, '=', i10, delimiterOffset);
                            String trimSubstring2 = _UtilCommonKt.trimSubstring(str, i10, delimiterOffset2);
                            String trimSubstring3 = delimiterOffset2 < delimiterOffset ? _UtilCommonKt.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : _UrlKt.FRAGMENT_ENCODE_SET;
                            if (p.S(trimSubstring2, "expires")) {
                                try {
                                    j13 = parseExpires(trimSubstring3, 0, trimSubstring3.length());
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (p.S(trimSubstring2, "max-age")) {
                                j12 = parseMaxAge(trimSubstring3);
                            } else {
                                if (p.S(trimSubstring2, "domain")) {
                                    str3 = parseDomain(trimSubstring3);
                                    z13 = false;
                                } else if (p.S(trimSubstring2, "path")) {
                                    str5 = trimSubstring3;
                                } else if (p.S(trimSubstring2, "secure")) {
                                    z12 = true;
                                } else if (p.S(trimSubstring2, "httponly")) {
                                    z10 = true;
                                } else if (p.S(trimSubstring2, "samesite")) {
                                    str4 = trimSubstring3;
                                }
                                i10 = delimiterOffset + 1;
                            }
                            z11 = true;
                            i10 = delimiterOffset + 1;
                        }
                        if (j12 == Long.MIN_VALUE) {
                            j11 = Long.MIN_VALUE;
                        } else if (j12 != -1) {
                            long j14 = j10 + (j12 <= 9223372036854775L ? j12 * 1000 : Long.MAX_VALUE);
                            j11 = (j14 < j10 || j14 > DateFormattingKt.MAX_DATE) ? 253402300799999L : j14;
                        } else {
                            j11 = j13;
                        }
                        String host = httpUrl.host();
                        if (str3 == null) {
                            str2 = host;
                        } else {
                            if (!domainMatch(host, str3)) {
                                return null;
                            }
                            str2 = str3;
                        }
                        if (host.length() != str2.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str2) == null) {
                            return null;
                        }
                        String str6 = "/";
                        if (str5 == null || !p.Y(str5, "/", false)) {
                            String encodedPath = httpUrl.encodedPath();
                            int i02 = i.i0(encodedPath, '/', 0, 6);
                            if (i02 != 0) {
                                str6 = encodedPath.substring(0, i02);
                                h.d("substring(...)", str6);
                            }
                            str5 = str6;
                        }
                        return new Cookie(trimSubstring$default, trimSubstring, j11, str2, str5, z12, z10, z11, z13, str4, null);
                    }
                }
            }
            return null;
        }

        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            h.e("url", httpUrl);
            h.e("headers", headers);
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            List<Cookie> list = null;
            ArrayList arrayList = null;
            for (int i10 = 0; i10 < size; i10++) {
                Cookie parse = parse(httpUrl, values.get(i10));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList != null) {
                list = Collections.unmodifiableList(arrayList);
                h.d("unmodifiableList(...)", list);
            }
            return list == null ? ma.p.f9051o : list;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Cookie(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, String str5, e eVar) {
        this(str, str2, j10, str3, str4, z10, z11, z12, z13, str5);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain, reason: not valid java name */
    public final String m34deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m35deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m36deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m37deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name, reason: not valid java name */
    public final String m38deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path, reason: not valid java name */
    public final String m39deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m40deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m41deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value, reason: not valid java name */
    public final String m42deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return h.a(cookie.name, this.name) && h.a(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && h.a(cookie.domain, this.domain) && h.a(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly && h.a(cookie.sameSite, this.sameSite);
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int g = d.g(this.value, d.g(this.name, 527, 31), 31);
        long j10 = this.expiresAt;
        int g6 = (((((((d.g(this.path, d.g(this.domain, (g + ((int) (j10 ^ (j10 >>> 32)))) * 31, 31), 31) + (this.secure ? 1231 : 1237)) * 31) + (this.httpOnly ? 1231 : 1237)) * 31) + (this.persistent ? 1231 : 1237)) * 31) + (this.hostOnly ? 1231 : 1237)) * 31;
        String str = this.sameSite;
        return g6 + (str != null ? str.hashCode() : 0);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        h.e("url", httpUrl);
        if ((this.hostOnly ? h.a(httpUrl.host(), this.domain) : Companion.domainMatch(httpUrl.host(), this.domain)) && Companion.pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final String sameSite() {
        return this.sameSite;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.name);
        sb2.append('=');
        sb2.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(DateFormattingKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(this.domain);
        }
        sb2.append("; path=");
        sb2.append(this.path);
        if (this.secure) {
            sb2.append("; secure");
        }
        if (this.httpOnly) {
            sb2.append("; httponly");
        }
        if (this.sameSite != null) {
            sb2.append("; samesite=");
            sb2.append(this.sameSite);
        }
        String sb3 = sb2.toString();
        h.d("toString(...)", sb3);
        return sb3;
    }

    public final String value() {
        return this.value;
    }

    private Cookie(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, String str5) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j10;
        this.domain = str3;
        this.path = str4;
        this.secure = z10;
        this.httpOnly = z11;
        this.persistent = z12;
        this.hostOnly = z13;
        this.sameSite = str5;
    }
}
