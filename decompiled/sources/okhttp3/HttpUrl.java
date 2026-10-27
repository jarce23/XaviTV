package okhttp3;

import android.support.v4.media.d;
import com.bumptech.glide.f;
import gb.i;
import gb.p;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import ma.g;
import ma.l;
import ma.r;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.url._UrlKt;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class HttpUrl {
    public static final Companion Companion = new Companion(null);
    private final String fragment;
    private final String host;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Builder {
        private String encodedFragment;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = _UrlKt.FRAGMENT_ENCODE_SET;
        private String encodedPassword = _UrlKt.FRAGMENT_ENCODE_SET;
        private int port = -1;
        private final List<String> encodedPathSegments = new ArrayList(new g(new String[]{_UrlKt.FRAGMENT_ENCODE_SET}, true));

        private final int effectivePort() {
            int i10 = this.port;
            if (i10 != -1) {
                return i10;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            h.b(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return h.a(str, ".") || p.S(str, "%2e");
        }

        private final boolean isDotDot(String str) {
            return h.a(str, "..") || p.S(str, "%2e.") || p.S(str, ".%2e") || p.S(str, "%2e%2e");
        }

        private final int parsePort(String str, int i10, int i11) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(_UrlKt.canonicalize$default(str, i10, i11, _UrlKt.FRAGMENT_ENCODE_SET, false, false, false, false, 120, null));
            } catch (NumberFormatException unused) {
            }
            if (1 > parseInt || parseInt >= 65536) {
                return -1;
            }
            return parseInt;
        }

        private final void pop() {
            if (this.encodedPathSegments.remove(r0.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add(_UrlKt.FRAGMENT_ENCODE_SET);
            } else {
                this.encodedPathSegments.set(r0.size() - 1, _UrlKt.FRAGMENT_ENCODE_SET);
            }
        }

        private final int portColonOffset(String str, int i10, int i11) {
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if (charAt == ':') {
                    return i10;
                }
                if (charAt == '[') {
                    do {
                        i10++;
                        if (i10 < i11) {
                        }
                    } while (str.charAt(i10) != ']');
                }
                i10++;
            }
            return i11;
        }

        private final void push(String str, int i10, int i11, boolean z10, boolean z11) {
            String canonicalize$default = _UrlKt.canonicalize$default(str, i10, i11, _UrlKt.PATH_SEGMENT_ENCODE_SET, z11, false, false, false, 112, null);
            if (isDot(canonicalize$default)) {
                return;
            }
            if (isDotDot(canonicalize$default)) {
                pop();
                return;
            }
            if (this.encodedPathSegments.get(r12.size() - 1).length() == 0) {
                this.encodedPathSegments.set(r12.size() - 1, canonicalize$default);
            } else {
                this.encodedPathSegments.add(canonicalize$default);
            }
            if (z10) {
                this.encodedPathSegments.add(_UrlKt.FRAGMENT_ENCODE_SET);
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            h.b(list);
            int size = list.size() - 2;
            int j10 = f.j(size, 0, -2);
            if (j10 > size) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                h.b(list2);
                if (h.a(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    h.b(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    h.b(list4);
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    h.b(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size == j10) {
                    return;
                } else {
                    size -= 2;
                }
            }
        }

        private final void resolvePath(String str, int i10, int i11) {
            if (i10 == i11) {
                return;
            }
            char charAt = str.charAt(i10);
            if (charAt == '/' || charAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add(_UrlKt.FRAGMENT_ENCODE_SET);
                i10++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, _UrlKt.FRAGMENT_ENCODE_SET);
            }
            int i12 = i10;
            while (i12 < i11) {
                int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i12, i11);
                boolean z10 = delimiterOffset < i11;
                String str2 = str;
                push(str2, i12, delimiterOffset, z10, true);
                if (z10) {
                    i12 = delimiterOffset + 1;
                    str = str2;
                } else {
                    str = str2;
                    i12 = delimiterOffset;
                }
            }
        }

        private final int schemeDelimiterOffset(String str, int i10, int i11) {
            if (i11 - i10 < 2) {
                return -1;
            }
            char charAt = str.charAt(i10);
            if ((h.f(charAt, 97) >= 0 && h.f(charAt, 122) <= 0) || (h.f(charAt, 65) >= 0 && h.f(charAt, 90) <= 0)) {
                while (true) {
                    i10++;
                    if (i10 >= i11) {
                        break;
                    }
                    char charAt2 = str.charAt(i10);
                    if ('a' > charAt2 || charAt2 >= '{') {
                        if ('A' > charAt2 || charAt2 >= '[') {
                            if ('0' > charAt2 || charAt2 >= ':') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i10;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private final int slashCount(String str, int i10, int i11) {
            int i12 = 0;
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if (charAt != '/' && charAt != '\\') {
                    break;
                }
                i12++;
                i10++;
            }
            return i12;
        }

        private final void toPathString(List<String> list, StringBuilder sb2) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append('/');
                sb2.append(list.get(i10));
            }
        }

        private final List<String> toQueryNamesAndValues(String str) {
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 <= str.length()) {
                int e02 = i.e0(str, '&', i10, 4);
                if (e02 == -1) {
                    e02 = str.length();
                }
                int e03 = i.e0(str, '=', i10, 4);
                if (e03 == -1 || e03 > e02) {
                    String substring = str.substring(i10, e02);
                    h.d("substring(...)", substring);
                    arrayList.add(substring);
                    arrayList.add(null);
                } else {
                    String substring2 = str.substring(i10, e03);
                    h.d("substring(...)", substring2);
                    arrayList.add(substring2);
                    String substring3 = str.substring(e03 + 1, e02);
                    h.d("substring(...)", substring3);
                    arrayList.add(substring3);
                }
                i10 = e02 + 1;
            }
            return arrayList;
        }

        public final Builder addEncodedPathSegment(String str) {
            h.e("encodedPathSegment", str);
            push(str, 0, str.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String str) {
            h.e("encodedPathSegments", str);
            return addPathSegments(str, true);
        }

        public final Builder addEncodedQueryParameter(String str, String str2) {
            h.e("encodedName", str);
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            h.b(list);
            list.add(_UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            h.b(list2);
            list2.add(str2 != null ? _UrlKt.canonicalize$default(str2, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null) : null);
            return this;
        }

        public final Builder addPathSegment(String str) {
            h.e("pathSegment", str);
            push(str, 0, str.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String str) {
            h.e("pathSegments", str);
            return addPathSegments(str, false);
        }

        public final Builder addQueryParameter(String str, String str2) {
            h.e("name", str);
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            h.b(list);
            list.add(_UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            h.b(list2);
            list2.add(str2 != null ? _UrlKt.canonicalize$default(str2, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null) : null);
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String percentDecode$default = _UrlKt.percentDecode$default(this.encodedUsername, 0, 0, false, 7, null);
            String percentDecode$default2 = _UrlKt.percentDecode$default(this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int effectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(l.z(list));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(_UrlKt.percentDecode$default((String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                arrayList = new ArrayList(l.z(list2));
                for (String str3 : list2) {
                    arrayList.add(str3 != null ? _UrlKt.percentDecode$default(str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, percentDecode$default, percentDecode$default2, str2, effectivePort, arrayList2, arrayList, str4 != null ? _UrlKt.percentDecode$default(str4, 0, 0, false, 7, null) : null, toString(), null);
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.FRAGMENT_ENCODE_SET, true, false, false, true, 51, null) : null;
            return this;
        }

        public final Builder encodedPassword(String str) {
            h.e("encodedPassword", str);
            this.encodedPassword = _UrlKt.canonicalize$default(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 115, null);
            return this;
        }

        public final Builder encodedPath(String str) {
            h.e("encodedPath", str);
            if (!p.Y(str, "/", false)) {
                throw new IllegalArgumentException("unexpected encodedPath: ".concat(str).toString());
            }
            resolvePath(str, 0, str.length());
            return this;
        }

        public final Builder encodedQuery(String str) {
            String canonicalize$default;
            this.encodedQueryNamesAndValues = (str == null || (canonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 83, null)) == null) ? null : toQueryNamesAndValues(canonicalize$default);
            return this;
        }

        public final Builder encodedUsername(String str) {
            h.e("encodedUsername", str);
            this.encodedUsername = _UrlKt.canonicalize$default(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 115, null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.FRAGMENT_ENCODE_SET, false, false, false, true, 59, null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String str) {
            h.e("host", str);
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(str, 0, 0, false, 7, null));
            if (canonicalHost == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(str));
            }
            this.host = canonicalHost;
            return this;
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int delimiterOffset;
            boolean z10;
            int i10;
            int i11;
            char c10;
            String str2 = str;
            h.e("input", str2);
            int indexOfFirstNonAsciiWhitespace$default = _UtilCommonKt.indexOfFirstNonAsciiWhitespace$default(str2, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = _UtilCommonKt.indexOfLastNonAsciiWhitespace$default(str2, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            int schemeDelimiterOffset = schemeDelimiterOffset(str2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            boolean z11 = true;
            if (schemeDelimiterOffset != -1) {
                if (p.X(indexOfFirstNonAsciiWhitespace$default, str2, "https:", true)) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!p.X(indexOfFirstNonAsciiWhitespace$default, str2, "http:", true)) {
                        StringBuilder sb2 = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                        String substring = str2.substring(0, schemeDelimiterOffset);
                        h.d("substring(...)", substring);
                        sb2.append(substring);
                        sb2.append('\'');
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    if (str2.length() > 6) {
                        str2 = i.n0(6, str2).concat("...");
                    }
                    throw new IllegalArgumentException(r.a.l("Expected URL scheme 'http' or 'https' but no scheme was found for ", str2));
                }
                this.scheme = httpUrl.scheme();
            }
            int slashCount = slashCount(str2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c11 = '?';
            char c12 = '#';
            if (slashCount >= 2 || httpUrl == null || !h.a(httpUrl.scheme(), this.scheme)) {
                boolean z12 = false;
                boolean z13 = false;
                int i12 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                while (true) {
                    delimiterOffset = _UtilCommonKt.delimiterOffset(str2, "@/\\?#", i12, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? str2.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == 65535 || charAt == c12 || charAt == '/' || charAt == '\\' || charAt == c11) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z12) {
                            z10 = z11;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.encodedPassword);
                            sb3.append("%40");
                            str2 = str;
                            i10 = delimiterOffset;
                            sb3.append(_UrlKt.canonicalize$default(str2, i12, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null));
                            this.encodedPassword = sb3.toString();
                        } else {
                            int delimiterOffset2 = _UtilCommonKt.delimiterOffset(str2, ':', i12, delimiterOffset);
                            z10 = z11;
                            String canonicalize$default = _UrlKt.canonicalize$default(str2, i12, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                            if (z13) {
                                canonicalize$default = this.encodedUsername + "%40" + canonicalize$default;
                            }
                            this.encodedUsername = canonicalize$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                i11 = delimiterOffset;
                                this.encodedPassword = _UrlKt.canonicalize$default(str, delimiterOffset2 + 1, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                                z12 = z10;
                            } else {
                                i11 = delimiterOffset;
                            }
                            str2 = str;
                            i10 = i11;
                            z13 = z10;
                        }
                        i12 = i10 + 1;
                        z11 = z10;
                        c12 = '#';
                        c11 = '?';
                    }
                }
                int portColonOffset = portColonOffset(str2, i12, delimiterOffset);
                int i13 = portColonOffset + 1;
                if (i13 < delimiterOffset) {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(str2, i12, portColonOffset, false, 4, null));
                    int parsePort = parsePort(str2, i13, delimiterOffset);
                    this.port = parsePort;
                    if (parsePort == -1) {
                        StringBuilder sb4 = new StringBuilder("Invalid URL port: \"");
                        String substring2 = str2.substring(i13, delimiterOffset);
                        h.d("substring(...)", substring2);
                        sb4.append(substring2);
                        sb4.append('\"');
                        throw new IllegalArgumentException(sb4.toString().toString());
                    }
                } else {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(str2, i12, portColonOffset, false, 4, null));
                    Companion companion = HttpUrl.Companion;
                    String str3 = this.scheme;
                    h.b(str3);
                    this.port = companion.defaultPort(str3);
                }
                if (this.host == null) {
                    StringBuilder sb5 = new StringBuilder("Invalid URL host: \"");
                    String substring3 = str2.substring(i12, portColonOffset);
                    h.d("substring(...)", substring3);
                    sb5.append(substring3);
                    sb5.append('\"');
                    throw new IllegalArgumentException(sb5.toString().toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || str2.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int delimiterOffset3 = _UtilCommonKt.delimiterOffset(str2, "?#", indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            resolvePath(str2, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 >= indexOfLastNonAsciiWhitespace$default || str2.charAt(delimiterOffset3) != '?') {
                c10 = '#';
            } else {
                c10 = '#';
                int delimiterOffset4 = _UtilCommonKt.delimiterOffset(str2, '#', delimiterOffset3, indexOfLastNonAsciiWhitespace$default);
                this.encodedQueryNamesAndValues = toQueryNamesAndValues(_UrlKt.canonicalize$default(str2, delimiterOffset3 + 1, delimiterOffset4, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 80, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < indexOfLastNonAsciiWhitespace$default && str2.charAt(delimiterOffset3) == c10) {
                this.encodedFragment = _UrlKt.canonicalize$default(str2, delimiterOffset3 + 1, indexOfLastNonAsciiWhitespace$default, _UrlKt.FRAGMENT_ENCODE_SET, true, false, false, true, 48, null);
            }
            return this;
        }

        public final Builder password(String str) {
            h.e("password", str);
            this.encodedPassword = _UrlKt.canonicalize$default(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 123, null);
            return this;
        }

        public final Builder port(int i10) {
            if (1 > i10 || i10 >= 65536) {
                throw new IllegalArgumentException(d.m(i10, "unexpected port: ").toString());
            }
            this.port = i10;
            return this;
        }

        public final Builder query(String str) {
            String canonicalize$default;
            this.encodedQueryNamesAndValues = (str == null || (canonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_ENCODE_SET, false, false, true, false, 91, null)) == null) ? null : toQueryNamesAndValues(canonicalize$default);
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String str;
            String str2 = this.host;
            if (str2 != null) {
                Pattern compile = Pattern.compile("[\"<>^`{|}]");
                h.d("compile(...)", compile);
                str = compile.matcher(str2).replaceAll(_UrlKt.FRAGMENT_ENCODE_SET);
                h.d("replaceAll(...)", str);
            } else {
                str = null;
            }
            this.host = str;
            int size = this.encodedPathSegments.size();
            for (int i10 = 0; i10 < size; i10++) {
                List<String> list = this.encodedPathSegments;
                list.set(i10, _UrlKt.canonicalize$default(list.get(i10), 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, 99, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str3 = list2.get(i11);
                    list2.set(i11, str3 != null ? _UrlKt.canonicalize$default(str3, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, 67, null) : null);
                }
            }
            String str4 = this.encodedFragment;
            this.encodedFragment = str4 != null ? _UrlKt.canonicalize$default(str4, 0, 0, _UrlKt.FRAGMENT_ENCODE_SET_URI, true, true, false, true, 35, null) : null;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String str) {
            h.e("encodedName", str);
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String str) {
            h.e("name", str);
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            return this;
        }

        public final Builder removePathSegment(int i10) {
            this.encodedPathSegments.remove(i10);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add(_UrlKt.FRAGMENT_ENCODE_SET);
            }
            return this;
        }

        public final Builder scheme(String str) {
            h.e("scheme", str);
            if (str.equalsIgnoreCase("http")) {
                this.scheme = "http";
                return this;
            }
            if (!str.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str));
            }
            this.scheme = "https";
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            h.e("<set-?>", str);
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i10, String str) {
            h.e("encodedPathSegment", str);
            String canonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, true, false, false, false, 115, null);
            this.encodedPathSegments.set(i10, canonicalize$default);
            if (isDot(canonicalize$default) || isDotDot(canonicalize$default)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(str).toString());
            }
            return this;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String str, String str2) {
            h.e("encodedName", str);
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            h.e("<set-?>", str);
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i10, String str) {
            h.e("pathSegment", str);
            String canonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, false, false, false, false, 123, null);
            if (isDot(canonicalize$default) || isDotDot(canonicalize$default)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(str).toString());
            }
            this.encodedPathSegments.set(i10, canonicalize$default);
            return this;
        }

        public final void setPort$okhttp(int i10) {
            this.port = i10;
        }

        public final Builder setQueryParameter(String str, String str2) {
            h.e("name", str);
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb2.append(str);
                sb2.append("://");
            } else {
                sb2.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb2.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb2.append(':');
                    sb2.append(this.encodedPassword);
                }
                sb2.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (i.a0(str2, ':')) {
                    sb2.append('[');
                    sb2.append(this.host);
                    sb2.append(']');
                } else {
                    sb2.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int effectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null || effectivePort != HttpUrl.Companion.defaultPort(str3)) {
                    sb2.append(':');
                    sb2.append(effectivePort);
                }
            }
            toPathString(this.encodedPathSegments, sb2);
            if (this.encodedQueryNamesAndValues != null) {
                sb2.append('?');
                Companion companion = HttpUrl.Companion;
                List<String> list = this.encodedQueryNamesAndValues;
                h.b(list);
                companion.toQueryString(list, sb2);
            }
            if (this.encodedFragment != null) {
                sb2.append('#');
                sb2.append(this.encodedFragment);
            }
            return sb2.toString();
        }

        public final Builder username(String str) {
            h.e("username", str);
            this.encodedUsername = _UrlKt.canonicalize$default(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 123, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z10) {
            boolean z11;
            Builder builder;
            String str2;
            boolean z12;
            int i10 = 0;
            while (true) {
                int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i10, str.length());
                if (delimiterOffset < str.length()) {
                    z11 = true;
                    str2 = str;
                    z12 = z10;
                    builder = this;
                } else {
                    z11 = false;
                    builder = this;
                    str2 = str;
                    z12 = z10;
                }
                builder.push(str2, i10, delimiterOffset, z11, z12);
                i10 = delimiterOffset + 1;
                if (i10 > str2.length()) {
                    return builder;
                }
                str = str2;
                z10 = z12;
            }
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void toQueryString(List<String> list, StringBuilder sb2) {
            db.a x6 = k5.a.x(k5.a.y(0, list.size()), 2);
            int i10 = x6.f4350o;
            int i11 = x6.f4351p;
            int i12 = x6.f4352q;
            if ((i12 <= 0 || i10 > i11) && (i12 >= 0 || i11 > i10)) {
                return;
            }
            while (true) {
                String str = list.get(i10);
                String str2 = list.get(i10 + 1);
                if (i10 > 0) {
                    sb2.append('&');
                }
                sb2.append(str);
                if (str2 != null) {
                    sb2.append('=');
                    sb2.append(str2);
                }
                if (i10 == i11) {
                    return;
                } else {
                    i10 += i12;
                }
            }
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m74deprecated_get(String str) {
            h.e("url", str);
            return get(str);
        }

        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m77deprecated_parse(String str) {
            h.e("url", str);
            return parse(str);
        }

        public final int defaultPort(String str) {
            h.e("scheme", str);
            if (str.equals("http")) {
                return 80;
            }
            return str.equals("https") ? 443 : -1;
        }

        public final HttpUrl get(String str) {
            h.e("<this>", str);
            return new Builder().parse$okhttp(null, str).build();
        }

        public final HttpUrl parse(String str) {
            h.e("<this>", str);
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m76deprecated_get(URL url) {
            h.e("url", url);
            return get(url);
        }

        public final HttpUrl get(URL url) {
            h.e("<this>", url);
            String url2 = url.toString();
            h.d("toString(...)", url2);
            return parse(url2);
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m75deprecated_get(URI uri) {
            h.e("uri", uri);
            return get(uri);
        }

        public final HttpUrl get(URI uri) {
            h.e("<this>", uri);
            String uri2 = uri.toString();
            h.d("toString(...)", uri2);
            return parse(uri2);
        }
    }

    public /* synthetic */ HttpUrl(String str, String str2, String str3, String str4, int i10, List list, List list2, String str5, String str6, e eVar) {
        this(str, str2, str3, str4, i10, list, list2, str5, str6);
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m55deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m56deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m57deprecated_encodedPath() {
        return encodedPath();
    }

    /* renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m58deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m59deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m60deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m61deprecated_fragment() {
        return this.fragment;
    }

    /* renamed from: -deprecated_host, reason: not valid java name */
    public final String m62deprecated_host() {
        return this.host;
    }

    /* renamed from: -deprecated_password, reason: not valid java name */
    public final String m63deprecated_password() {
        return this.password;
    }

    /* renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m64deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m65deprecated_pathSize() {
        return pathSize();
    }

    /* renamed from: -deprecated_port, reason: not valid java name */
    public final int m66deprecated_port() {
        return this.port;
    }

    /* renamed from: -deprecated_query, reason: not valid java name */
    public final String m67deprecated_query() {
        return query();
    }

    /* renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m68deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m69deprecated_querySize() {
        return querySize();
    }

    /* renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m70deprecated_scheme() {
        return this.scheme;
    }

    /* renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m71deprecated_uri() {
        return uri();
    }

    /* renamed from: -deprecated_url, reason: not valid java name */
    public final URL m72deprecated_url() {
        return url();
    }

    /* renamed from: -deprecated_username, reason: not valid java name */
    public final String m73deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String substring = this.url.substring(i.e0(this.url, '#', 0, 6) + 1);
        h.d("substring(...)", substring);
        return substring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        String substring = this.url.substring(i.e0(this.url, ':', this.scheme.length() + 3, 4) + 1, i.e0(this.url, '@', 0, 6));
        h.d("substring(...)", substring);
        return substring;
    }

    public final String encodedPath() {
        int e02 = i.e0(this.url, '/', this.scheme.length() + 3, 4);
        String str = this.url;
        String substring = this.url.substring(e02, _UtilCommonKt.delimiterOffset(str, "?#", e02, str.length()));
        h.d("substring(...)", substring);
        return substring;
    }

    public final List<String> encodedPathSegments() {
        int e02 = i.e0(this.url, '/', this.scheme.length() + 3, 4);
        String str = this.url;
        int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "?#", e02, str.length());
        ArrayList arrayList = new ArrayList();
        while (e02 < delimiterOffset) {
            int i10 = e02 + 1;
            int delimiterOffset2 = _UtilCommonKt.delimiterOffset(this.url, '/', i10, delimiterOffset);
            String substring = this.url.substring(i10, delimiterOffset2);
            h.d("substring(...)", substring);
            arrayList.add(substring);
            e02 = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int e02 = i.e0(this.url, '?', 0, 6) + 1;
        String str = this.url;
        String substring = this.url.substring(e02, _UtilCommonKt.delimiterOffset(str, '#', e02, str.length()));
        h.d("substring(...)", substring);
        return substring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = this.url.substring(length, _UtilCommonKt.delimiterOffset(str, ":@", length, str.length()));
        h.d("substring(...)", substring);
        return substring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && h.a(((HttpUrl) obj).url, this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return h.a(this.scheme, "https");
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Companion.toQueryString(this.queryNamesAndValues, sb2);
        return sb2.toString();
    }

    public final String queryParameter(String str) {
        h.e("name", str);
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        db.a x6 = k5.a.x(k5.a.y(0, list.size()), 2);
        int i10 = x6.f4350o;
        int i11 = x6.f4351p;
        int i12 = x6.f4352q;
        if ((i12 <= 0 || i10 > i11) && (i12 >= 0 || i11 > i10)) {
            return null;
        }
        while (!str.equals(this.queryNamesAndValues.get(i10))) {
            if (i10 == i11) {
                return null;
            }
            i10 += i12;
        }
        return this.queryNamesAndValues.get(i10 + 1);
    }

    public final String queryParameterName(int i10) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i10 * 2);
        h.b(str);
        return str;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return r.f9053o;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.queryNamesAndValues.size() / 2, 1.0f);
        db.a x6 = k5.a.x(k5.a.y(0, this.queryNamesAndValues.size()), 2);
        int i10 = x6.f4350o;
        int i11 = x6.f4351p;
        int i12 = x6.f4352q;
        if ((i12 > 0 && i10 <= i11) || (i12 < 0 && i11 <= i10)) {
            while (true) {
                String str = this.queryNamesAndValues.get(i10);
                h.b(str);
                linkedHashSet.add(str);
                if (i10 == i11) {
                    break;
                }
                i10 += i12;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        h.d("unmodifiableSet(...)", unmodifiableSet);
        return unmodifiableSet;
    }

    public final String queryParameterValue(int i10) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i10 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String str) {
        h.e("name", str);
        if (this.queryNamesAndValues == null) {
            return ma.p.f9051o;
        }
        ArrayList arrayList = new ArrayList(4);
        db.a x6 = k5.a.x(k5.a.y(0, this.queryNamesAndValues.size()), 2);
        int i10 = x6.f4350o;
        int i11 = x6.f4351p;
        int i12 = x6.f4352q;
        if ((i12 > 0 && i10 <= i11) || (i12 < 0 && i11 <= i10)) {
            while (true) {
                if (str.equals(this.queryNamesAndValues.get(i10))) {
                    arrayList.add(this.queryNamesAndValues.get(i10 + 1));
                }
                if (i10 == i11) {
                    break;
                }
                i10 += i12;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        h.d("unmodifiableList(...)", unmodifiableList);
        return unmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        h.b(newBuilder);
        return newBuilder.username(_UrlKt.FRAGMENT_ENCODE_SET).password(_UrlKt.FRAGMENT_ENCODE_SET).build().toString();
    }

    public final HttpUrl resolve(String str) {
        h.e("link", str);
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (_HostnamesCommonKt.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e7) {
            try {
                Pattern compile = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                h.d("compile(...)", compile);
                h.e("input", builder);
                String replaceAll = compile.matcher(builder).replaceAll(_UrlKt.FRAGMENT_ENCODE_SET);
                h.d("replaceAll(...)", replaceAll);
                URI create = URI.create(replaceAll);
                h.b(create);
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e7);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final String username() {
        return this.username;
    }

    private HttpUrl(String str, String str2, String str3, String str4, int i10, List<String> list, List<String> list2, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i10;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    public final Builder newBuilder(String str) {
        h.e("link", str);
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
