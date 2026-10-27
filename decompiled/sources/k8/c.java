package k8;

import android.animation.TimeInterpolator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public long f7836a;

    /* renamed from: b, reason: collision with root package name */
    public long f7837b;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f7838c;

    /* renamed from: d, reason: collision with root package name */
    public int f7839d;

    /* renamed from: e, reason: collision with root package name */
    public int f7840e;

    public final TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.f7838c;
        return timeInterpolator != null ? timeInterpolator : a.f7831b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f7836a == cVar.f7836a && this.f7837b == cVar.f7837b && this.f7839d == cVar.f7839d && this.f7840e == cVar.f7840e) {
            return a().getClass().equals(cVar.a().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f7836a;
        long j11 = this.f7837b;
        return ((((a().getClass().hashCode() + (((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) ((j11 >>> 32) ^ j11))) * 31)) * 31) + this.f7839d) * 31) + this.f7840e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n");
        sb2.append(c.class.getName());
        sb2.append('{');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" delay: ");
        sb2.append(this.f7836a);
        sb2.append(" duration: ");
        sb2.append(this.f7837b);
        sb2.append(" interpolator: ");
        sb2.append(a().getClass());
        sb2.append(" repeatCount: ");
        sb2.append(this.f7839d);
        sb2.append(" repeatMode: ");
        return r.a.d(sb2, this.f7840e, "}\n");
    }
}
