package mb;

import com.google.android.gms.internal.cast.n;
import ib.s;
import java.util.concurrent.atomic.AtomicInteger;
import la.i;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends ra.h implements p {

    /* renamed from: p, reason: collision with root package name */
    public int f9070p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ lb.f[] f9071q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f9072r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f9073s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ kb.e f9074t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(lb.f[] fVarArr, int i10, AtomicInteger atomicInteger, kb.e eVar, pa.d dVar) {
        super(2, dVar);
        this.f9071q = fVarArr;
        this.f9072r = i10;
        this.f9073s = atomicInteger;
        this.f9074t = eVar;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        return ((e) create((s) obj, (pa.d) obj2)).invokeSuspend(i.f8335a);
    }

    @Override // ra.a
    public final pa.d create(Object obj, pa.d dVar) {
        return new e(this.f9071q, this.f9072r, this.f9073s, this.f9074t, dVar);
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        qa.a aVar = qa.a.f10374o;
        int i10 = this.f9070p;
        AtomicInteger atomicInteger = this.f9073s;
        kb.e eVar = this.f9074t;
        try {
            if (i10 == 0) {
                n.t(obj);
                lb.f[] fVarArr = this.f9071q;
                int i11 = this.f9072r;
                lb.f fVar = fVarArr[i11];
                d dVar = new d(eVar, i11);
                this.f9070p = 1;
                if (fVar.a(dVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                n.t(obj);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                x4.f.i(eVar);
            }
            return i.f8335a;
        } finally {
            if (atomicInteger.decrementAndGet() == 0) {
                x4.f.i(eVar);
            }
        }
    }
}
