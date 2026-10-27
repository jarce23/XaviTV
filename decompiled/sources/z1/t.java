package z1;

import android.text.TextUtils;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final String f14045a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14046b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14047c;

    public t(String str, boolean z10, boolean z11) {
        this.f14045a = str;
        this.f14046b = z10;
        this.f14047c = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == t.class) {
            t tVar = (t) obj;
            if (TextUtils.equals(this.f14045a, tVar.f14045a) && this.f14046b == tVar.f14046b && this.f14047c == tVar.f14047c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((android.support.v4.media.d.g(this.f14045a, 31, 31) + (this.f14046b ? 1231 : 1237)) * 31) + (this.f14047c ? 1231 : 1237);
    }
}
