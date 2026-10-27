package sb;

import java.util.Iterator;
import rb.i0;
import rb.u;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends ra.g implements p {

    /* renamed from: p, reason: collision with root package name */
    public ma.h f11684p;

    /* renamed from: q, reason: collision with root package name */
    public Iterator f11685q;

    /* renamed from: r, reason: collision with root package name */
    public int f11686r;

    /* renamed from: s, reason: collision with root package name */
    public /* synthetic */ Object f11687s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ i0 f11688t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ u f11689u;

    /* renamed from: v, reason: collision with root package name */
    public final /* synthetic */ boolean f11690v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(i0 i0Var, u uVar, boolean z10, pa.d dVar) {
        super(dVar);
        this.f11688t = i0Var;
        this.f11689u = uVar;
        this.f11690v = z10;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        return ((e) create((fb.g) obj, (pa.d) obj2)).invokeSuspend(la.i.f8335a);
    }

    @Override // ra.a
    public final pa.d create(Object obj, pa.d dVar) {
        e eVar = new e(this.f11688t, this.f11689u, this.f11690v, dVar);
        eVar.f11687s = obj;
        return eVar;
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        ma.h hVar;
        Iterator it;
        fb.g gVar = (fb.g) this.f11687s;
        qa.a aVar = qa.a.f10374o;
        int i10 = this.f11686r;
        u uVar = this.f11689u;
        if (i10 == 0) {
            com.google.android.gms.internal.cast.n.t(obj);
            ma.h hVar2 = new ma.h();
            i0 i0Var = this.f11688t;
            hVar2.addLast(i0Var);
            Iterator it2 = uVar.list(i0Var).iterator();
            hVar = hVar2;
            it = it2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Iterator it3 = this.f11685q;
            ma.h hVar3 = this.f11684p;
            com.google.android.gms.internal.cast.n.t(obj);
            it = it3;
            hVar = hVar3;
        }
        while (it.hasNext()) {
            i0 i0Var2 = (i0) it.next();
            this.f11687s = gVar;
            this.f11684p = hVar;
            this.f11685q = it;
            this.f11686r = 1;
            if (b.c(gVar, uVar, hVar, i0Var2, this.f11690v, false, this) == aVar) {
                return aVar;
            }
        }
        return la.i.f8335a;
    }
}
