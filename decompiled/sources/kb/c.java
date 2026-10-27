package kb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends ra.c {

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f7875o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ e f7876p;

    /* renamed from: q, reason: collision with root package name */
    public int f7877q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, ra.c cVar) {
        super(cVar);
        this.f7876p = eVar;
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        this.f7875o = obj;
        this.f7877q |= Integer.MIN_VALUE;
        Object y8 = e.y(this.f7876p, this);
        return y8 == qa.a.f10374o ? y8 : new l(y8);
    }
}
