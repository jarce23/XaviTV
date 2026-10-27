package i1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public final long f6036a;

    static {
        new t(new s());
        l1.a0.J(0);
        l1.a0.J(1);
        l1.a0.J(2);
        l1.a0.J(3);
        l1.a0.J(4);
        l1.a0.J(5);
        l1.a0.J(6);
        l1.a0.J(7);
    }

    public t(s sVar) {
        int i10 = l1.a0.f8067a;
        this.f6036a = sVar.f6018a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && this.f6036a == ((t) obj).f6036a;
    }

    public final int hashCode() {
        long j10 = this.f6036a;
        return ((((int) 0) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 923521;
    }
}
