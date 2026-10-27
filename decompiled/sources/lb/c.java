package lb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends ra.c {

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f8342o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d f8343p;

    /* renamed from: q, reason: collision with root package name */
    public int f8344q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, ra.c cVar) {
        super(cVar);
        this.f8343p = dVar;
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        this.f8342o = obj;
        this.f8344q |= Integer.MIN_VALUE;
        return this.f8343p.a(null, this);
    }
}
