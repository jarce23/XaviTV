package okhttp3;

import com.bumptech.glide.f;
import gb.d;
import gb.g;
import gb.h;
import gb.i;
import gb.p;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import x4.m;
import za.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final h TYPE_SUBTYPE = new h("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final h PARAMETER = new h(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m80deprecated_get(String str) {
            za.h.e("mediaType", str);
            return get(str);
        }

        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m81deprecated_parse(String str) {
            za.h.e("mediaType", str);
            return parse(str);
        }

        public final MediaType get(String str) {
            za.h.e("<this>", str);
            m a10 = MediaType.TYPE_SUBTYPE.a(0, str);
            if (a10 == null) {
                throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
            }
            if (((gb.e) a10.f13566r) == null) {
                a10.f13566r = new gb.e(a10);
            }
            gb.e eVar = (gb.e) a10.f13566r;
            za.h.b(eVar);
            String str2 = (String) eVar.get(1);
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            za.h.d("toLowerCase(...)", lowerCase);
            if (((gb.e) a10.f13566r) == null) {
                a10.f13566r = new gb.e(a10);
            }
            gb.e eVar2 = (gb.e) a10.f13566r;
            za.h.b(eVar2);
            String lowerCase2 = ((String) eVar2.get(2)).toLowerCase(locale);
            za.h.d("toLowerCase(...)", lowerCase2);
            ArrayList arrayList = new ArrayList();
            Matcher matcher = (Matcher) a10.f13564p;
            int i10 = k5.a.y(matcher.start(), matcher.end()).f4351p;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= str.length()) {
                    return new MediaType(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
                }
                m a11 = MediaType.PARAMETER.a(i11, str);
                if (a11 == null) {
                    StringBuilder sb2 = new StringBuilder("Parameter is not formatted correctly: \"");
                    String substring = str.substring(i11);
                    za.h.d("substring(...)", substring);
                    sb2.append(substring);
                    sb2.append("\" for: \"");
                    sb2.append(str);
                    sb2.append('\"');
                    throw new IllegalArgumentException(sb2.toString().toString());
                }
                Matcher matcher2 = (Matcher) a11.f13564p;
                g gVar = (g) a11.f13565q;
                d g = gVar.g(1);
                String str3 = g != null ? g.f5461a : null;
                if (str3 == null) {
                    i10 = k5.a.y(matcher2.start(), matcher2.end()).f4351p;
                } else {
                    d g6 = gVar.g(2);
                    String str4 = g6 != null ? g6.f5461a : null;
                    if (str4 == null) {
                        d g10 = gVar.g(3);
                        za.h.b(g10);
                        str4 = g10.f5461a;
                    } else if (str4.length() > 0 && com.bumptech.glide.c.i(str4.charAt(0), '\'', false) && str4.length() > 0 && com.bumptech.glide.c.i(str4.charAt(i.c0(str4)), '\'', false) && str4.length() > 2) {
                        str4 = str4.substring(1, str4.length() - 1);
                        za.h.d("substring(...)", str4);
                    }
                    arrayList.add(str3);
                    arrayList.add(str4);
                    i10 = k5.a.y(matcher2.start(), matcher2.end()).f4351p;
                }
            }
        }

        public final MediaType parse(String str) {
            za.h.e("<this>", str);
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    public MediaType(String str, String str2, String str3, String[] strArr) {
        za.h.e("mediaType", str);
        za.h.e("type", str2);
        za.h.e("subtype", str3);
        za.h.e("parameterNamesAndValues", strArr);
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m78deprecated_subtype() {
        return this.subtype;
    }

    /* renamed from: -deprecated_type, reason: not valid java name */
    public final String m79deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && za.h.a(((MediaType) obj).mediaType, this.mediaType);
    }

    public final String getMediaType$okhttp() {
        return this.mediaType;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String parameter(String str) {
        za.h.e("name", str);
        int i10 = 0;
        int j10 = f.j(0, this.parameterNamesAndValues.length - 1, 2);
        if (j10 < 0) {
            return null;
        }
        while (!p.S(this.parameterNamesAndValues[i10], str)) {
            if (i10 == j10) {
                return null;
            }
            i10 += 2;
        }
        return this.parameterNamesAndValues[i10 + 1];
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }

    public final Charset charset(Charset charset) {
        String parameter = parameter("charset");
        if (parameter == null) {
            return charset;
        }
        try {
            return Charset.forName(parameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
