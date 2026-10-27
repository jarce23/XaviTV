package kb;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends za.i implements ya.l {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f7922p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f7923q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(int i10, Object obj) {
        super(1);
        this.f7922p = i10;
        this.f7923q = obj;
    }

    @Override // ya.l
    public final Object invoke(Object obj) {
        switch (this.f7922p) {
            case 0:
                ib.f fVar = (ib.f) this.f7923q;
                la.i iVar = la.i.f8335a;
                fVar.resumeWith(iVar);
                return iVar;
            default:
                Throwable th = (Throwable) obj;
                o4.j jVar = (o4.j) this.f7923q;
                if (th == null) {
                    if (!jVar.f9503o.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                } else if (th instanceof CancellationException) {
                    jVar.f9503o.cancel(true);
                } else {
                    z4.j jVar2 = jVar.f9503o;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    jVar2.j(th);
                }
                return la.i.f8335a;
        }
    }
}
