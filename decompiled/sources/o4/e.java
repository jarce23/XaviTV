package o4;

import androidx.work.CoroutineWorker;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends ra.h implements ya.p {

    /* renamed from: p, reason: collision with root package name */
    public int f9494p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ CoroutineWorker f9495q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(CoroutineWorker coroutineWorker, pa.d dVar) {
        super(2, dVar);
        this.f9495q = coroutineWorker;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        return ((e) create((ib.s) obj, (pa.d) obj2)).invokeSuspend(la.i.f8335a);
    }

    @Override // ra.a
    public final pa.d create(Object obj, pa.d dVar) {
        return new e(this.f9495q, dVar);
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        CoroutineWorker coroutineWorker = this.f9495q;
        z4.j jVar = coroutineWorker.f1514t;
        qa.a aVar = qa.a.f10374o;
        int i10 = this.f9494p;
        try {
            if (i10 == 0) {
                com.google.android.gms.internal.cast.n.t(obj);
                this.f9494p = 1;
                obj = coroutineWorker.f();
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                com.google.android.gms.internal.cast.n.t(obj);
            }
            jVar.i((n) obj);
        } catch (Throwable th) {
            jVar.j(th);
        }
        return la.i.f8335a;
    }
}
