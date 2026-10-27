package ib;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6546a;

    public c0(boolean z10) {
        this.f6546a = z10;
    }

    @Override // ib.j0
    public final boolean a() {
        return this.f6546a;
    }

    @Override // ib.j0
    public final z0 e() {
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Empty{");
        sb2.append(this.f6546a ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
