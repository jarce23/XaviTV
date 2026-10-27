package b4;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends k0 {

    /* renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f2272s;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f2273h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f2274i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f2275j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f2276k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f2277l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f2278m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f2279n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f2280o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f2281p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f2282q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f2283r;

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((f1) arrayList.get(size)).f2232a.animate().cancel();
        }
    }

    @Override // b4.k0
    public final boolean a(f1 f1Var, f1 f1Var2, j0 j0Var, j0 j0Var2) {
        int i10;
        int i11;
        int i12 = j0Var.f2285b;
        int i13 = j0Var.f2286c;
        if (f1Var2.p()) {
            int i14 = j0Var.f2285b;
            i11 = j0Var.f2286c;
            i10 = i14;
        } else {
            i10 = j0Var2.f2285b;
            i11 = j0Var2.f2286c;
        }
        if (f1Var == f1Var2) {
            return g(f1Var, i12, i13, i10, i11);
        }
        View view = f1Var.f2232a;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        l(f1Var);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        View view2 = f1Var2.f2232a;
        l(f1Var2);
        view2.setTranslationX(-((int) ((i10 - i12) - translationX)));
        view2.setTranslationY(-((int) ((i11 - i13) - translationY)));
        view2.setAlpha(0.0f);
        ArrayList arrayList = this.f2276k;
        h hVar = new h();
        hVar.f2257a = f1Var;
        hVar.f2258b = f1Var2;
        hVar.f2259c = i12;
        hVar.f2260d = i13;
        hVar.f2261e = i10;
        hVar.f2262f = i11;
        arrayList.add(hVar);
        return true;
    }

    @Override // b4.k0
    public final void d(f1 f1Var) {
        ArrayList arrayList = this.f2277l;
        ArrayList arrayList2 = this.f2278m;
        ArrayList arrayList3 = this.f2279n;
        View view = f1Var.f2232a;
        view.animate().cancel();
        ArrayList arrayList4 = this.f2275j;
        int size = arrayList4.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((i) arrayList4.get(size)).f2265a == f1Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(f1Var);
                arrayList4.remove(size);
            }
        }
        j(this.f2276k, f1Var);
        if (this.f2273h.remove(f1Var)) {
            view.setAlpha(1.0f);
            c(f1Var);
        }
        if (this.f2274i.remove(f1Var)) {
            view.setAlpha(1.0f);
            c(f1Var);
        }
        for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList5 = (ArrayList) arrayList3.get(size2);
            j(arrayList5, f1Var);
            if (arrayList5.isEmpty()) {
                arrayList3.remove(size2);
            }
        }
        for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList6 = (ArrayList) arrayList2.get(size3);
            int size4 = arrayList6.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((i) arrayList6.get(size4)).f2265a == f1Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(f1Var);
                    arrayList6.remove(size4);
                    if (arrayList6.isEmpty()) {
                        arrayList2.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = arrayList.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList.get(size5);
            if (arrayList7.remove(f1Var)) {
                view.setAlpha(1.0f);
                c(f1Var);
                if (arrayList7.isEmpty()) {
                    arrayList.remove(size5);
                }
            }
        }
        this.f2282q.remove(f1Var);
        this.f2280o.remove(f1Var);
        this.f2283r.remove(f1Var);
        this.f2281p.remove(f1Var);
        i();
    }

    @Override // b4.k0
    public final void e() {
        ArrayList arrayList = this.f2279n;
        ArrayList arrayList2 = this.f2277l;
        ArrayList arrayList3 = this.f2278m;
        ArrayList arrayList4 = this.f2276k;
        ArrayList arrayList5 = this.f2274i;
        ArrayList arrayList6 = this.f2273h;
        ArrayList arrayList7 = this.f2275j;
        int size = arrayList7.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            i iVar = (i) arrayList7.get(size);
            View view = iVar.f2265a.f2232a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(iVar.f2265a);
            arrayList7.remove(size);
        }
        for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
            c((f1) arrayList6.get(size2));
            arrayList6.remove(size2);
        }
        int size3 = arrayList5.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            f1 f1Var = (f1) arrayList5.get(size3);
            f1Var.f2232a.setAlpha(1.0f);
            c(f1Var);
            arrayList5.remove(size3);
        }
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            h hVar = (h) arrayList4.get(size4);
            f1 f1Var2 = hVar.f2257a;
            if (f1Var2 != null) {
                k(hVar, f1Var2);
            }
            f1 f1Var3 = hVar.f2258b;
            if (f1Var3 != null) {
                k(hVar, f1Var3);
            }
        }
        arrayList4.clear();
        if (f()) {
            for (int size5 = arrayList3.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList8 = (ArrayList) arrayList3.get(size5);
                for (int size6 = arrayList8.size() - 1; size6 >= 0; size6--) {
                    i iVar2 = (i) arrayList8.get(size6);
                    View view2 = iVar2.f2265a.f2232a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(iVar2.f2265a);
                    arrayList8.remove(size6);
                    if (arrayList8.isEmpty()) {
                        arrayList3.remove(arrayList8);
                    }
                }
            }
            for (int size7 = arrayList2.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList9 = (ArrayList) arrayList2.get(size7);
                for (int size8 = arrayList9.size() - 1; size8 >= 0; size8--) {
                    f1 f1Var4 = (f1) arrayList9.get(size8);
                    f1Var4.f2232a.setAlpha(1.0f);
                    c(f1Var4);
                    arrayList9.remove(size8);
                    if (arrayList9.isEmpty()) {
                        arrayList2.remove(arrayList9);
                    }
                }
            }
            for (int size9 = arrayList.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    h hVar2 = (h) arrayList10.get(size10);
                    f1 f1Var5 = hVar2.f2257a;
                    if (f1Var5 != null) {
                        k(hVar2, f1Var5);
                    }
                    f1 f1Var6 = hVar2.f2258b;
                    if (f1Var6 != null) {
                        k(hVar2, f1Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList.remove(arrayList10);
                    }
                }
            }
            h(this.f2282q);
            h(this.f2281p);
            h(this.f2280o);
            h(this.f2283r);
            ArrayList arrayList11 = this.f2295b;
            if (arrayList11.size() > 0) {
                throw android.support.v4.media.d.k(0, arrayList11);
            }
            arrayList11.clear();
        }
    }

    @Override // b4.k0
    public final boolean f() {
        return (this.f2274i.isEmpty() && this.f2276k.isEmpty() && this.f2275j.isEmpty() && this.f2273h.isEmpty() && this.f2281p.isEmpty() && this.f2282q.isEmpty() && this.f2280o.isEmpty() && this.f2283r.isEmpty() && this.f2278m.isEmpty() && this.f2277l.isEmpty() && this.f2279n.isEmpty()) ? false : true;
    }

    public final boolean g(f1 f1Var, int i10, int i11, int i12, int i13) {
        View view = f1Var.f2232a;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) f1Var.f2232a.getTranslationY());
        l(f1Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            c(f1Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        ArrayList arrayList = this.f2275j;
        i iVar = new i();
        iVar.f2265a = f1Var;
        iVar.f2266b = translationX;
        iVar.f2267c = translationY;
        iVar.f2268d = i12;
        iVar.f2269e = i13;
        arrayList.add(iVar);
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.f2295b;
        if (arrayList.size() > 0) {
            throw android.support.v4.media.d.k(0, arrayList);
        }
        arrayList.clear();
    }

    public final void j(ArrayList arrayList, f1 f1Var) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            h hVar = (h) arrayList.get(size);
            if (k(hVar, f1Var) && hVar.f2257a == null && hVar.f2258b == null) {
                arrayList.remove(hVar);
            }
        }
    }

    public final boolean k(h hVar, f1 f1Var) {
        if (hVar.f2258b == f1Var) {
            hVar.f2258b = null;
        } else {
            if (hVar.f2257a != f1Var) {
                return false;
            }
            hVar.f2257a = null;
        }
        View view = f1Var.f2232a;
        View view2 = f1Var.f2232a;
        view.setAlpha(1.0f);
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
        c(f1Var);
        return true;
    }

    public final void l(f1 f1Var) {
        if (f2272s == null) {
            f2272s = new ValueAnimator().getInterpolator();
        }
        f1Var.f2232a.animate().setInterpolator(f2272s);
        d(f1Var);
    }
}
