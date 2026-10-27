package okhttp3.internal.http2;

import j9.w1;
import rb.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final o PSEUDO_PREFIX;
    public static final o RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final o TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final o TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final o TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final o TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final o name;
    public final o value;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(za.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        o oVar = o.f11048r;
        PSEUDO_PREFIX = w1.F(":");
        RESPONSE_STATUS = w1.F(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = w1.F(TARGET_METHOD_UTF8);
        TARGET_PATH = w1.F(TARGET_PATH_UTF8);
        TARGET_SCHEME = w1.F(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = w1.F(TARGET_AUTHORITY_UTF8);
    }

    public Header(o oVar, o oVar2) {
        za.h.e("name", oVar);
        za.h.e("value", oVar2);
        this.name = oVar;
        this.value = oVar2;
        this.hpackSize = oVar2.d() + oVar.d() + 32;
    }

    public static /* synthetic */ Header copy$default(Header header, o oVar, o oVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            oVar = header.name;
        }
        if ((i10 & 2) != 0) {
            oVar2 = header.value;
        }
        return header.copy(oVar, oVar2);
    }

    public final o component1() {
        return this.name;
    }

    public final o component2() {
        return this.value;
    }

    public final Header copy(o oVar, o oVar2) {
        za.h.e("name", oVar);
        za.h.e("value", oVar2);
        return new Header(oVar, oVar2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return za.h.a(this.name, header.name) && za.h.a(this.value, header.value);
    }

    public int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        return this.name.r() + ": " + this.value.r();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String str, String str2) {
        this(w1.F(str), w1.F(str2));
        za.h.e("name", str);
        za.h.e("value", str2);
        o oVar = o.f11048r;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(o oVar, String str) {
        this(oVar, w1.F(str));
        za.h.e("name", oVar);
        za.h.e("value", str);
        o oVar2 = o.f11048r;
    }
}
