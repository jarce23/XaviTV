package m;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s2 implements n, l.j {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Toolbar f8554o;

    public /* synthetic */ s2(Toolbar toolbar) {
        this.f8554o = toolbar;
    }

    @Override // l.j
    public boolean h(l.l lVar, MenuItem menuItem) {
        this.f8554o.getClass();
        return false;
    }

    @Override // l.j
    public void r(l.l lVar) {
        Toolbar toolbar = this.f8554o;
        k kVar = toolbar.f475o.H;
        if (kVar == null || !kVar.f()) {
            Iterator it = ((CopyOnWriteArrayList) toolbar.U.f13565q).iterator();
            while (it.hasNext()) {
                ((androidx.fragment.app.b0) it.next()).f661a.s();
            }
        }
    }
}
