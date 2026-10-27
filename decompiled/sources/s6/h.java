package s6;

import j9.g1;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f11605a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f11606b;

    /* renamed from: c, reason: collision with root package name */
    public final k f11607c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11608d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11609e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f11610f;

    public h(String str, Integer num, k kVar, long j10, long j11, HashMap hashMap) {
        this.f11605a = str;
        this.f11606b = num;
        this.f11607c = kVar;
        this.f11608d = j10;
        this.f11609e = j11;
        this.f11610f = hashMap;
    }

    public final String a(String str) {
        String str2 = (String) this.f11610f.get(str);
        return str2 == null ? _UrlKt.FRAGMENT_ENCODE_SET : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f11610f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final g1 c() {
        g1 g1Var = new g1();
        String str = this.f11605a;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        g1Var.f7290o = str;
        g1Var.f7291p = this.f11606b;
        k kVar = this.f11607c;
        if (kVar == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        g1Var.f7292q = kVar;
        g1Var.f7293r = Long.valueOf(this.f11608d);
        g1Var.f7294s = Long.valueOf(this.f11609e);
        g1Var.f7295t = new HashMap(this.f11610f);
        return g1Var;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            Integer num2 = hVar.f11606b;
            if (this.f11605a.equals(hVar.f11605a) && ((num = this.f11606b) != null ? num.equals(num2) : num2 == null) && this.f11607c.equals(hVar.f11607c) && this.f11608d == hVar.f11608d && this.f11609e == hVar.f11609e && this.f11610f.equals(hVar.f11610f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f11605a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f11606b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f11607c.hashCode()) * 1000003;
        long j10 = this.f11608d;
        int i10 = (hashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f11609e;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f11610f.hashCode();
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f11605a + ", code=" + this.f11606b + ", encodedPayload=" + this.f11607c + ", eventMillis=" + this.f11608d + ", uptimeMillis=" + this.f11609e + ", autoMetadata=" + this.f11610f + "}";
    }
}
