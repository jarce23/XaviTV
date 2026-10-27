package m;

import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final g f8436o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k f8437p;

    public i(k kVar, g gVar) {
        this.f8437p = kVar;
        this.f8436o = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.j jVar;
        k kVar = this.f8437p;
        l.l lVar = kVar.f8452q;
        if (lVar != null && (jVar = lVar.f7992e) != null) {
            jVar.r(lVar);
        }
        View view = (View) kVar.f8457v;
        if (view != null && view.getWindowToken() != null) {
            g gVar = this.f8436o;
            if (!gVar.b()) {
                if (gVar.f8054e != null) {
                    gVar.d(0, 0, false, false);
                }
            }
            kVar.G = gVar;
        }
        kVar.I = null;
    }
}
