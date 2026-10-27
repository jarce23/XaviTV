package la;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final Throwable f8330o;

    public e(Throwable th) {
        za.h.e("exception", th);
        this.f8330o = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return za.h.a(this.f8330o, ((e) obj).f8330o);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8330o.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f8330o + ')';
    }
}
