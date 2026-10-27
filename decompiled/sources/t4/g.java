package t4;

import com.google.android.gms.internal.cast.n;
import java.io.Serializable;
import la.i;
import ya.q;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends ra.h implements q {

    /* renamed from: p, reason: collision with root package name */
    public int f11881p;

    /* renamed from: q, reason: collision with root package name */
    public /* synthetic */ lb.g f11882q;

    /* renamed from: r, reason: collision with root package name */
    public /* synthetic */ Object[] f11883r;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ya.q
    public final Object c(Object obj, Serializable serializable, Serializable serializable2) {
        g gVar = new g(3, (pa.d) serializable2);
        gVar.f11882q = (lb.g) obj;
        gVar.f11883r = (Object[]) serializable;
        return gVar.invokeSuspend(i.f8335a);
    }

    @Override // ra.a
    public final Object invokeSuspend(Object obj) {
        c cVar;
        c cVar2;
        qa.a aVar = qa.a.f10374o;
        int i10 = this.f11881p;
        if (i10 == 0) {
            n.t(obj);
            lb.g gVar = this.f11882q;
            c[] cVarArr = (c[]) this.f11883r;
            int length = cVarArr.length;
            int i11 = 0;
            while (true) {
                cVar = a.f11874a;
                if (i11 >= length) {
                    cVar2 = null;
                    break;
                }
                cVar2 = cVarArr[i11];
                if (!za.h.a(cVar2, cVar)) {
                    break;
                }
                i11++;
            }
            if (cVar2 != null) {
                cVar = cVar2;
            }
            this.f11881p = 1;
            if (gVar.a(cVar, this) == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            n.t(obj);
        }
        return i.f8335a;
    }
}
