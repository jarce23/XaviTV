package p6;

import android.support.v4.media.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f10024a;

    public b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f10024a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f10024a.equals(((b) obj).f10024a);
    }

    public final int hashCode() {
        return this.f10024a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return d.r(new StringBuilder("Encoding{name=\""), this.f10024a, "\"}");
    }
}
