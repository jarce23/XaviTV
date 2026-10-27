package b4;

import android.database.Observable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g0 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            RecyclerView recyclerView = ((w0) ((Observable) this).mObservers.get(size)).f2445a;
            recyclerView.i(null);
            recyclerView.f1487v0.f2190f = true;
            recyclerView.W(true);
            if (!recyclerView.f1480s.l()) {
                recyclerView.requestLayout();
            }
        }
    }

    public final void c(int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            RecyclerView recyclerView = ((w0) ((Observable) this).mObservers.get(size)).f2445a;
            recyclerView.i(null);
            b bVar = recyclerView.f1480s;
            ArrayList arrayList = (ArrayList) bVar.f2177c;
            arrayList.add(bVar.n(null, 4, i10, 1));
            bVar.f2175a |= 4;
            if (arrayList.size() == 1) {
                if (RecyclerView.R0 && recyclerView.I && recyclerView.H) {
                    c0 c0Var = recyclerView.f1488w;
                    WeakHashMap weakHashMap = m0.k0.f8683a;
                    recyclerView.postOnAnimation(c0Var);
                } else {
                    recyclerView.P = true;
                    recyclerView.requestLayout();
                }
            }
        }
    }
}
