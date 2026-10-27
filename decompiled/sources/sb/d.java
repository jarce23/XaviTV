package sb;

import rb.i0;
import rb.u;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends ra.g implements p {

    /* renamed from: p, reason: collision with root package name */
    public int f11680p;

    /* renamed from: q, reason: collision with root package name */
    public /* synthetic */ Object f11681q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ u f11682r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ i0 f11683s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(u uVar, i0 i0Var, pa.d dVar) {
        super(dVar);
        this.f11682r = uVar;
        this.f11683s = i0Var;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        return ((d) create((fb.g) obj, (pa.d) obj2)).invokeSuspend(la.i.f8335a);
    }

    @Override // ra.a
    public final pa.d create(Object obj, pa.d dVar) {
        d dVar2 = new d(this.f11682r, this.f11683s, dVar);
        dVar2.f11681q = obj;
        return dVar2;
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        fb.g gVar = (fb.g) this.f11681q;
        qa.a aVar = qa.a.f10374o;
        int i10 = this.f11680p;
        if (i10 == 0) {
            com.google.android.gms.internal.cast.n.t(obj);
            ma.h hVar = new ma.h();
            this.f11681q = null;
            this.f11680p = 1;
            if (b.c(gVar, this.f11682r, hVar, this.f11683s, false, true, this) == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.google.android.gms.internal.cast.n.t(obj);
        }
        return la.i.f8335a;
    }
}
