package mb;

import com.google.android.gms.internal.cast.n;
import kb.s;
import la.i;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends ra.h implements p {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f9061p;

    /* renamed from: q, reason: collision with root package name */
    public int f9062q;

    /* renamed from: r, reason: collision with root package name */
    public /* synthetic */ Object f9063r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f9064s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, pa.d dVar, int i10) {
        super(2, dVar);
        this.f9061p = i10;
        this.f9064s = obj;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        s sVar = (s) obj;
        pa.d dVar = (pa.d) obj2;
        switch (this.f9061p) {
        }
        return ((b) create(sVar, dVar)).invokeSuspend(i.f8335a);
    }

    @Override // ra.a
    public final pa.d create(Object obj, pa.d dVar) {
        switch (this.f9061p) {
            case 0:
                b bVar = new b((lb.b) this.f9064s, dVar, 0);
                bVar.f9063r = obj;
                return bVar;
            default:
                b bVar2 = new b((u4.d) this.f9064s, dVar, 1);
                bVar2.f9063r = obj;
                return bVar2;
        }
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f9061p) {
            case 0:
                qa.a aVar = qa.a.f10374o;
                int i10 = this.f9062q;
                if (i10 == 0) {
                    n.t(obj);
                    s sVar = (s) this.f9063r;
                    lb.b bVar = (lb.b) this.f9064s;
                    this.f9062q = 1;
                    if (bVar.b(sVar, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    n.t(obj);
                }
                return i.f8335a;
            default:
                qa.a aVar2 = qa.a.f10374o;
                int i11 = this.f9062q;
                if (i11 == 0) {
                    n.t(obj);
                    s sVar2 = (s) this.f9063r;
                    u4.d dVar = (u4.d) this.f9064s;
                    u4.c cVar = new u4.c(dVar, sVar2);
                    v4.f fVar = dVar.f12519a;
                    fVar.getClass();
                    synchronized (fVar.f12669c) {
                        try {
                            if (fVar.f12670d.add(cVar)) {
                                if (fVar.f12670d.size() == 1) {
                                    fVar.f12671e = fVar.a();
                                    o4.p.d().a(v4.g.f12672a, fVar.getClass().getSimpleName() + ": initial state = " + fVar.f12671e);
                                    fVar.c();
                                }
                                cVar.a(fVar.f12671e);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    u4.b bVar2 = new u4.b((u4.d) this.f9064s, cVar);
                    this.f9062q = 1;
                    if (w7.b.f(sVar2, bVar2, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    n.t(obj);
                }
                return i.f8335a;
        }
    }
}
