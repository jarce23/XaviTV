package i1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f5899c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5900a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f5901b = 0;

    static {
        l1.a0.J(0);
        l1.a0.J(1);
        l1.a0.J(2);
        l1.a0.J(3);
    }

    public i(c1 c1Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f5900a == iVar.f5900a && this.f5901b == iVar.f5901b;
    }

    public final int hashCode() {
        return (((16337 + this.f5900a) * 31) + this.f5901b) * 31;
    }
}
