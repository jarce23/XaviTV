package k2;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f7807a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f7808b;

    public z(b0 b0Var, b0 b0Var2) {
        this.f7807a = b0Var;
        this.f7808b = b0Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && z.class == obj.getClass()) {
            z zVar = (z) obj;
            if (this.f7807a.equals(zVar.f7807a) && this.f7808b.equals(zVar.f7808b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f7808b.hashCode() + (this.f7807a.hashCode() * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("[");
        b0 b0Var = this.f7807a;
        sb2.append(b0Var);
        b0 b0Var2 = this.f7808b;
        if (b0Var.equals(b0Var2)) {
            str = _UrlKt.FRAGMENT_ENCODE_SET;
        } else {
            str = ", " + b0Var2;
        }
        return android.support.v4.media.d.r(sb2, str, "]");
    }
}
