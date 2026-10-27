package kb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f7913a;

    public j(Throwable th) {
        this.f7913a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return za.h.a(this.f7913a, ((j) obj).f7913a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f7913a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // kb.k
    public final String toString() {
        return "Closed(" + this.f7913a + ')';
    }
}
