package kb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends ra.c {

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f7878o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ e f7879p;

    /* renamed from: q, reason: collision with root package name */
    public int f7880q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, ra.c cVar) {
        super(cVar);
        this.f7879p = eVar;
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        this.f7878o = obj;
        this.f7880q |= Integer.MIN_VALUE;
        Object z10 = this.f7879p.z(null, 0, 0L, this);
        return z10 == qa.a.f10374o ? z10 : new l(z10);
    }
}
