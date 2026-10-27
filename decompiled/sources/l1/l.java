package l1;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import w3.q0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8100o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f8101p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f8102q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f8103r;

    public /* synthetic */ l(Object obj, int i10, Object obj2, int i11) {
        this.f8100o = i11;
        this.f8102q = obj;
        this.f8101p = i10;
        this.f8103r = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8100o) {
            case 0:
                CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.f8102q;
                m mVar = (m) this.f8103r;
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    o oVar = (o) it.next();
                    if (!oVar.f8107d) {
                        int i10 = this.f8101p;
                        if (i10 != -1) {
                            oVar.f8105b.a(i10);
                        }
                        oVar.f8106c = true;
                        mVar.invoke(oVar.f8104a);
                    }
                }
                break;
            default:
                ((z3.b) ((q0) this.f8102q).f13000c).s(this.f8101p, this.f8103r);
                break;
        }
    }
}
