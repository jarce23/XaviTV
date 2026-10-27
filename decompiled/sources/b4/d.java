package b4;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2205o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2206p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ j f2207q;

    public /* synthetic */ d(j jVar, ArrayList arrayList, int i10) {
        this.f2205o = i10;
        this.f2207q = jVar;
        this.f2206p = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2205o) {
            case 0:
                ArrayList arrayList = this.f2206p;
                int size = arrayList.size();
                int i10 = 0;
                while (true) {
                    j jVar = this.f2207q;
                    if (i10 >= size) {
                        arrayList.clear();
                        jVar.f2278m.remove(arrayList);
                        break;
                    } else {
                        Object obj = arrayList.get(i10);
                        i10++;
                        i iVar = (i) obj;
                        f1 f1Var = iVar.f2265a;
                        int i11 = iVar.f2266b;
                        int i12 = iVar.f2267c;
                        int i13 = iVar.f2268d;
                        int i14 = iVar.f2269e;
                        jVar.getClass();
                        View view = f1Var.f2232a;
                        int i15 = i13 - i11;
                        int i16 = i14 - i12;
                        if (i15 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i16 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator animate = view.animate();
                        jVar.f2281p.add(f1Var);
                        animate.setDuration(jVar.f2298e).setListener(new f(jVar, f1Var, i15, view, i16, animate)).start();
                    }
                }
            case 1:
                ArrayList arrayList2 = this.f2206p;
                int size2 = arrayList2.size();
                int i17 = 0;
                while (true) {
                    j jVar2 = this.f2207q;
                    if (i17 >= size2) {
                        arrayList2.clear();
                        jVar2.f2279n.remove(arrayList2);
                        break;
                    } else {
                        Object obj2 = arrayList2.get(i17);
                        i17++;
                        h hVar = (h) obj2;
                        ArrayList arrayList3 = jVar2.f2283r;
                        long j10 = jVar2.f2299f;
                        f1 f1Var2 = hVar.f2257a;
                        View view2 = f1Var2 == null ? null : f1Var2.f2232a;
                        f1 f1Var3 = hVar.f2258b;
                        View view3 = f1Var3 != null ? f1Var3.f2232a : null;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j10);
                            arrayList3.add(hVar.f2257a);
                            duration.translationX(hVar.f2261e - hVar.f2259c);
                            duration.translationY(hVar.f2262f - hVar.f2260d);
                            duration.alpha(0.0f).setListener(new g(jVar2, hVar, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator animate2 = view3.animate();
                            arrayList3.add(hVar.f2258b);
                            animate2.translationX(0.0f).translationY(0.0f).setDuration(j10).alpha(1.0f).setListener(new g(jVar2, hVar, animate2, view3, 1)).start();
                        }
                    }
                }
            default:
                ArrayList arrayList4 = this.f2206p;
                int size3 = arrayList4.size();
                int i18 = 0;
                while (true) {
                    j jVar3 = this.f2207q;
                    if (i18 >= size3) {
                        arrayList4.clear();
                        jVar3.f2277l.remove(arrayList4);
                        break;
                    } else {
                        Object obj3 = arrayList4.get(i18);
                        i18++;
                        f1 f1Var4 = (f1) obj3;
                        jVar3.getClass();
                        View view4 = f1Var4.f2232a;
                        ViewPropertyAnimator animate3 = view4.animate();
                        jVar3.f2280o.add(f1Var4);
                        animate3.alpha(1.0f).setDuration(jVar3.f2296c).setListener(new e(jVar3, f1Var4, view4, animate3)).start();
                    }
                }
        }
    }
}
