package r5;

import android.text.TextUtils;
import j9.v1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: e, reason: collision with root package name */
    public static final v1 f10790e = new v1(12);

    /* renamed from: a, reason: collision with root package name */
    public final Object f10791a;

    /* renamed from: b, reason: collision with root package name */
    public final f f10792b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10793c;

    /* renamed from: d, reason: collision with root package name */
    public volatile byte[] f10794d;

    public g(String str, Object obj, f fVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.f10793c = str;
        this.f10791a = obj;
        this.f10792b = fVar;
    }

    public static g a(String str, Object obj) {
        return new g(str, obj, f10790e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f10793c.equals(((g) obj).f10793c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10793c.hashCode();
    }

    public final String toString() {
        return android.support.v4.media.d.r(new StringBuilder("Option{key='"), this.f10793c, "'}");
    }
}
