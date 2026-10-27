package mb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends ra.c {

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f9065o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d f9066p;

    /* renamed from: q, reason: collision with root package name */
    public int f9067q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, ra.c cVar) {
        super(cVar);
        this.f9066p = dVar;
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        this.f9065o = obj;
        this.f9067q |= Integer.MIN_VALUE;
        return this.f9066p.a(null, this);
    }
}
