package b4;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2203o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2204p;

    public /* synthetic */ c0(RecyclerView recyclerView, int i10) {
        this.f2203o = i10;
        this.f2204p = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        int i10 = this.f2203o;
        RecyclerView recyclerView = this.f2204p;
        switch (i10) {
            case 0:
                if (recyclerView.J && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.H) {
                        recyclerView.requestLayout();
                        break;
                    } else if (!recyclerView.M) {
                        recyclerView.n();
                        break;
                    } else {
                        recyclerView.L = true;
                        break;
                    }
                }
                break;
            default:
                k0 k0Var = recyclerView.f1462d0;
                if (k0Var != null) {
                    j jVar = (j) k0Var;
                    long j10 = jVar.f2297d;
                    ArrayList arrayList = jVar.f2273h;
                    boolean isEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = jVar.f2275j;
                    boolean isEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = jVar.f2276k;
                    boolean isEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = jVar.f2274i;
                    boolean isEmpty4 = arrayList4.isEmpty();
                    if (!isEmpty || !isEmpty2 || !isEmpty4 || !isEmpty3) {
                        int size = arrayList.size();
                        int i11 = 0;
                        while (i11 < size) {
                            Object obj = arrayList.get(i11);
                            int i12 = i11 + 1;
                            f1 f1Var = (f1) obj;
                            View view = f1Var.f2232a;
                            ViewPropertyAnimator animate = view.animate();
                            jVar.f2282q.add(f1Var);
                            animate.setDuration(j10).alpha(0.0f).setListener(new e(jVar, f1Var, animate, view)).start();
                            i11 = i12;
                            arrayList = arrayList;
                            isEmpty = isEmpty;
                        }
                        boolean z11 = isEmpty;
                        arrayList.clear();
                        if (!isEmpty2) {
                            ArrayList arrayList5 = new ArrayList();
                            arrayList5.addAll(arrayList2);
                            jVar.f2278m.add(arrayList5);
                            arrayList2.clear();
                            d dVar = new d(jVar, arrayList5, 0);
                            if (z11) {
                                dVar.run();
                            } else {
                                View view2 = ((i) arrayList5.get(0)).f2265a.f2232a;
                                WeakHashMap weakHashMap = m0.k0.f8683a;
                                view2.postOnAnimationDelayed(dVar, j10);
                            }
                        }
                        if (!isEmpty3) {
                            ArrayList arrayList6 = new ArrayList();
                            arrayList6.addAll(arrayList3);
                            jVar.f2279n.add(arrayList6);
                            arrayList3.clear();
                            d dVar2 = new d(jVar, arrayList6, 1);
                            if (z11) {
                                dVar2.run();
                            } else {
                                View view3 = ((h) arrayList6.get(0)).f2257a.f2232a;
                                WeakHashMap weakHashMap2 = m0.k0.f8683a;
                                view3.postOnAnimationDelayed(dVar2, j10);
                            }
                        }
                        if (!isEmpty4) {
                            ArrayList arrayList7 = new ArrayList();
                            arrayList7.addAll(arrayList4);
                            jVar.f2277l.add(arrayList7);
                            arrayList4.clear();
                            d dVar3 = new d(jVar, arrayList7, 2);
                            if (!z11 || !isEmpty2 || !isEmpty3) {
                                if (z11) {
                                    j10 = 0;
                                }
                                long max = Math.max(!isEmpty2 ? jVar.f2298e : 0L, isEmpty3 ? 0L : jVar.f2299f) + j10;
                                z10 = false;
                                View view4 = ((f1) arrayList7.get(0)).f2232a;
                                WeakHashMap weakHashMap3 = m0.k0.f8683a;
                                view4.postOnAnimationDelayed(dVar3, max);
                                recyclerView.B0 = z10;
                                break;
                            } else {
                                dVar3.run();
                            }
                        }
                    }
                }
                z10 = false;
                recyclerView.B0 = z10;
        }
    }
}
