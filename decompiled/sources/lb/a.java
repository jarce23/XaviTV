package lb;

import kb.s;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends ra.c {

    /* renamed from: o, reason: collision with root package name */
    public s f8336o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f8337p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ b f8338q;

    /* renamed from: r, reason: collision with root package name */
    public int f8339r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, ra.c cVar) {
        super(cVar);
        this.f8338q = bVar;
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        this.f8337p = obj;
        this.f8339r |= Integer.MIN_VALUE;
        return this.f8338q.b(null, this);
    }
}
