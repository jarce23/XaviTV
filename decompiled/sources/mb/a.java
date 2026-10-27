package mb;

import androidx.work.CoroutineWorker;
import com.google.android.gms.internal.cast.n;
import ib.s;
import ib.t;
import ib.v;
import java.util.ArrayList;
import java.util.List;
import kb.r;
import la.i;
import ma.l;
import o4.j;
import x4.o;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends ra.h implements p {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f9056p;

    /* renamed from: q, reason: collision with root package name */
    public int f9057q;

    /* renamed from: r, reason: collision with root package name */
    public Object f9058r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f9059s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ Object f9060t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(a3.f fVar, o oVar, t4.e eVar, pa.d dVar) {
        super(2, dVar);
        this.f9056p = 2;
        this.f9058r = fVar;
        this.f9059s = oVar;
        this.f9060t = eVar;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        s sVar = (s) obj;
        pa.d dVar = (pa.d) obj2;
        switch (this.f9056p) {
            case 0:
                return ((a) create(sVar, dVar)).invokeSuspend(i.f8335a);
            case 1:
                a aVar = (a) create(sVar, dVar);
                i iVar = i.f8335a;
                aVar.invokeSuspend(iVar);
                return iVar;
            default:
                return ((a) create(sVar, dVar)).invokeSuspend(i.f8335a);
        }
    }

    @Override // ra.a
    public final pa.d create(Object obj, pa.d dVar) {
        switch (this.f9056p) {
            case 0:
                a aVar = new a((lb.g) this.f9059s, (lb.b) this.f9060t, dVar, 0);
                aVar.f9058r = obj;
                return aVar;
            case 1:
                return new a((j) this.f9059s, (CoroutineWorker) this.f9060t, dVar, 1);
            default:
                return new a((a3.f) this.f9058r, (o) this.f9059s, (t4.e) this.f9060t, dVar);
        }
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f9056p;
        Object obj2 = this.f9060t;
        pa.d dVar = null;
        int i11 = 0;
        i iVar = i.f8335a;
        Object obj3 = this.f9059s;
        int i12 = 1;
        switch (i10) {
            case 0:
                qa.a aVar = qa.a.f10374o;
                int i13 = this.f9057q;
                if (i13 != 0) {
                    if (i13 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    n.t(obj);
                    return iVar;
                }
                n.t(obj);
                s sVar = (s) this.f9058r;
                kb.a aVar2 = kb.a.f7868o;
                t tVar = t.f6592p;
                p bVar = new b((lb.b) obj2, dVar, i11);
                r rVar = new r(v.g(sVar, pa.j.f10146o), n4.a.b(-2, aVar2, 4));
                rVar.P(tVar, rVar, bVar);
                this.f9057q = 1;
                Object h10 = i7.e.h((lb.g) obj3, rVar, true, this);
                if (h10 != aVar) {
                    h10 = iVar;
                }
                return h10 == aVar ? aVar : iVar;
            case 1:
                qa.a aVar3 = qa.a.f10374o;
                int i14 = this.f9057q;
                if (i14 == 0) {
                    n.t(obj);
                    this.f9058r = (j) obj3;
                    this.f9057q = 1;
                    throw new IllegalStateException("Not implemented");
                }
                if (i14 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j jVar = (j) this.f9058r;
                n.t(obj);
                jVar.f9503o.i(obj);
                return iVar;
            default:
                o oVar = (o) obj3;
                qa.a aVar4 = qa.a.f10374o;
                int i15 = this.f9057q;
                if (i15 != 0) {
                    if (i15 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    n.t(obj);
                    return iVar;
                }
                n.t(obj);
                a3.f fVar = (a3.f) this.f9058r;
                fVar.getClass();
                List list = fVar.f27o;
                ArrayList arrayList = new ArrayList();
                for (Object obj4 : list) {
                    if (((u4.d) obj4).b(oVar)) {
                        arrayList.add(obj4);
                    }
                }
                ArrayList arrayList2 = new ArrayList(l.z(arrayList));
                int size = arrayList.size();
                int i16 = 0;
                while (i16 < size) {
                    Object obj5 = arrayList.get(i16);
                    i16++;
                    u4.d dVar2 = (u4.d) obj5;
                    dVar2.getClass();
                    arrayList2.add(new lb.b(new b(dVar2, dVar, i12)));
                }
                lb.e eVar = new lb.e(new lb.b((lb.f[]) ma.j.J(arrayList2).toArray(new lb.f[0])));
                lb.d dVar3 = new lb.d((t4.e) obj2, oVar);
                this.f9057q = 1;
                return eVar.a(dVar3, this) == aVar4 ? aVar4 : iVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, Object obj2, pa.d dVar, int i10) {
        super(2, dVar);
        this.f9056p = i10;
        this.f9059s = obj;
        this.f9060t = obj2;
    }
}
