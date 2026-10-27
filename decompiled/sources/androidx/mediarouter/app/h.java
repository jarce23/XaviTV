package androidx.mediarouter.app;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1314o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1315p;

    public /* synthetic */ h(int i10, Object obj) {
        this.f1314o = i10;
        this.f1315p = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1314o) {
            case 0:
                s sVar = (s) this.f1315p;
                sVar.j(true);
                sVar.S.requestLayout();
                sVar.S.getViewTreeObserver().addOnGlobalLayoutListener(new g(sVar));
                break;
            default:
                s sVar2 = ((q) this.f1315p).f1382p;
                if (sVar2.f1385a0 != null) {
                    sVar2.f1385a0 = null;
                    if (sVar2.f1400q0) {
                        sVar2.q(sVar2.f1401r0);
                        break;
                    }
                }
                break;
        }
    }
}
