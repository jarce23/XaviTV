package m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 extends r1 {

    /* renamed from: x, reason: collision with root package name */
    public final /* synthetic */ i0 f8396x;

    /* renamed from: y, reason: collision with root package name */
    public final /* synthetic */ l0 f8397y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(l0 l0Var, l0 l0Var2, i0 i0Var) {
        super(l0Var2);
        this.f8397y = l0Var;
        this.f8396x = i0Var;
    }

    @Override // m.r1
    public final l.b0 b() {
        return this.f8396x;
    }

    @Override // m.r1
    public final boolean c() {
        l0 l0Var = this.f8397y;
        if (l0Var.getInternalPopup().a()) {
            return true;
        }
        l0Var.f8472t.k(l0Var.getTextDirection(), l0Var.getTextAlignment());
        return true;
    }
}
