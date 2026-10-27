package pl.droidsonroids.gif;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f10200p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ c f10201q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, c cVar2, int i10) {
        super(cVar2);
        this.f10201q = cVar;
        this.f10200p = i10;
    }

    @Override // pl.droidsonroids.gif.f
    public final void a() {
        c cVar = this.f10201q;
        cVar.f10208u.q(this.f10200p, cVar.f10207t);
        this.f10215o.A.sendEmptyMessageAtTime(-1, 0L);
    }
}
