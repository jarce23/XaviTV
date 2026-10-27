package m0;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 extends ra.g implements ya.p {

    /* renamed from: p, reason: collision with root package name */
    public int f8693p;

    /* renamed from: q, reason: collision with root package name */
    public /* synthetic */ Object f8694q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ View f8695r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(View view, pa.d dVar) {
        super(dVar);
        this.f8695r = view;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        return ((n0) create((fb.g) obj, (pa.d) obj2)).invokeSuspend(la.i.f8335a);
    }

    @Override // ra.a
    public final pa.d create(Object obj, pa.d dVar) {
        n0 n0Var = new n0(this.f8695r, dVar);
        n0Var.f8694q = obj;
        return n0Var;
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3 = qa.a.f10374o;
        int i10 = this.f8693p;
        View view = this.f8695r;
        if (i10 == 0) {
            com.google.android.gms.internal.cast.n.t(obj);
            fb.g gVar = (fb.g) this.f8694q;
            this.f8694q = gVar;
            this.f8693p = 1;
            gVar.f5066p = view;
            gVar.f5065o = 3;
            gVar.f5068r = this;
            return obj3;
        }
        Object obj4 = la.i.f8335a;
        if (i10 != 1) {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.google.android.gms.internal.cast.n.t(obj);
            return obj4;
        }
        fb.g gVar2 = (fb.g) this.f8694q;
        com.google.android.gms.internal.cast.n.t(obj);
        if (view instanceof ViewGroup) {
            this.f8694q = null;
            this.f8693p = 2;
            gVar2.getClass();
            fb.k kVar = new fb.k(new fb.b(1, (ViewGroup) view));
            if (kVar.f5073p.hasNext()) {
                gVar2.f5067q = kVar;
                gVar2.f5065o = 2;
                gVar2.f5068r = this;
                obj2 = obj3;
            } else {
                obj2 = obj4;
            }
            if (obj2 != obj3) {
                obj2 = obj4;
            }
            if (obj2 == obj3) {
                return obj3;
            }
        }
        return obj4;
    }
}
