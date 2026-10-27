package b4;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2423a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f2424b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2425c;

    /* renamed from: d, reason: collision with root package name */
    public final List f2426d;

    /* renamed from: e, reason: collision with root package name */
    public int f2427e;

    /* renamed from: f, reason: collision with root package name */
    public int f2428f;
    public t0 g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2429h;

    public u0(RecyclerView recyclerView) {
        this.f2429h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f2423a = arrayList;
        this.f2424b = null;
        this.f2425c = new ArrayList();
        this.f2426d = Collections.unmodifiableList(arrayList);
        this.f2427e = 2;
        this.f2428f = 2;
    }

    public final void a(f1 f1Var, boolean z10) {
        RecyclerView.j(f1Var);
        View view = f1Var.f2232a;
        RecyclerView recyclerView = this.f2429h;
        h1 h1Var = recyclerView.C0;
        if (h1Var != null) {
            g1 g1Var = h1Var.f2264e;
            m0.k0.m(view, g1Var != null ? (m0.b) g1Var.f2256e.remove(view) : null);
        }
        if (z10) {
            v0 v0Var = recyclerView.C;
            ArrayList arrayList = recyclerView.D;
            if (v0Var != null) {
                ((androidx.leanback.widget.a) v0Var).a(f1Var);
            }
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((androidx.leanback.widget.a) ((v0) arrayList.get(i10))).a(f1Var);
            }
            f0 f0Var = recyclerView.A;
            if (f0Var != null) {
                f0Var.k(f1Var);
            }
            if (recyclerView.f1487v0 != null) {
                recyclerView.f1484u.d0(f1Var);
            }
        }
        f1Var.f2249s = null;
        f1Var.f2248r = null;
        t0 c10 = c();
        c10.getClass();
        int i11 = f1Var.f2237f;
        ArrayList arrayList2 = c10.a(i11).f2402a;
        if (((s0) c10.f2414a.get(i11)).f2403b <= arrayList2.size()) {
            j1.c.d(view);
        } else {
            f1Var.n();
            arrayList2.add(f1Var);
        }
    }

    public final int b(int i10) {
        RecyclerView recyclerView = this.f2429h;
        if (i10 >= 0 && i10 < recyclerView.f1487v0.b()) {
            return !recyclerView.f1487v0.g ? i10 : recyclerView.f1480s.h(i10, 0);
        }
        StringBuilder f10 = r.a.f("invalid position ", i10, ". State item count is ");
        f10.append(recyclerView.f1487v0.b());
        f10.append(recyclerView.z());
        throw new IndexOutOfBoundsException(f10.toString());
    }

    public final t0 c() {
        if (this.g == null) {
            t0 t0Var = new t0();
            t0Var.f2414a = new SparseArray();
            t0Var.f2415b = 0;
            t0Var.f2416c = Collections.newSetFromMap(new IdentityHashMap());
            this.g = t0Var;
            e();
        }
        return this.g;
    }

    public final View d(int i10) {
        return l(i10, Long.MAX_VALUE).f2232a;
    }

    public final void e() {
        RecyclerView recyclerView;
        f0 f0Var;
        t0 t0Var = this.g;
        if (t0Var == null || (f0Var = (recyclerView = this.f2429h).A) == null || !recyclerView.H) {
            return;
        }
        t0Var.f2416c.add(f0Var);
    }

    public final void f(f0 f0Var, boolean z10) {
        t0 t0Var = this.g;
        if (t0Var != null) {
            SparseArray sparseArray = t0Var.f2414a;
            Set set = t0Var.f2416c;
            set.remove(f0Var);
            if (set.size() != 0 || z10) {
                return;
            }
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                ArrayList arrayList = ((s0) sparseArray.get(sparseArray.keyAt(i10))).f2402a;
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    j1.c.d(((f1) arrayList.get(i11)).f2232a);
                }
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.f2425c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            h(size);
        }
        arrayList.clear();
        if (RecyclerView.S0) {
            p pVar = this.f2429h.f1485u0;
            int[] iArr = (int[]) pVar.f2377b;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            pVar.f2380e = 0;
        }
    }

    public final void h(int i10) {
        ArrayList arrayList = this.f2425c;
        a((f1) arrayList.get(i10), true);
        arrayList.remove(i10);
    }

    public final void i(View view) {
        f1 J = RecyclerView.J(view);
        boolean k10 = J.k();
        RecyclerView recyclerView = this.f2429h;
        if (k10) {
            recyclerView.removeDetachedView(view, false);
        }
        if (J.j()) {
            J.f2244n.m(J);
        } else if (J.q()) {
            J.f2240j &= -33;
        }
        j(J);
        if (recyclerView.f1462d0 == null || J.h()) {
            return;
        }
        recyclerView.f1462d0.d(J);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
    
        r7 = r7 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(b4.f1 r13) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.u0.j(b4.f1):void");
    }

    public final void k(View view) {
        k0 k0Var;
        f1 J = RecyclerView.J(view);
        int i10 = J.f2240j & 12;
        RecyclerView recyclerView = this.f2429h;
        if (i10 == 0 && J.l() && (k0Var = recyclerView.f1462d0) != null) {
            j jVar = (j) k0Var;
            if (J.d().isEmpty() && jVar.g && !J.g()) {
                if (this.f2424b == null) {
                    this.f2424b = new ArrayList();
                }
                J.f2244n = this;
                J.f2245o = true;
                this.f2424b.add(J);
                return;
            }
        }
        if (J.g() && !J.i() && !recyclerView.A.f2229b) {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + recyclerView.z());
        }
        J.f2244n = this;
        J.f2245o = false;
        this.f2423a.add(J);
    }

    /* JADX WARN: Code restructure failed: missing block: B:199:0x0411, code lost:
    
        if (r10.g() == false) goto L238;
     */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0531 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b4.f1 l(int r28, long r29) {
        /*
            Method dump skipped, instructions count: 1369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.u0.l(int, long):b4.f1");
    }

    public final void m(f1 f1Var) {
        if (f1Var.f2245o) {
            this.f2424b.remove(f1Var);
        } else {
            this.f2423a.remove(f1Var);
        }
        f1Var.f2244n = null;
        f1Var.f2245o = false;
        f1Var.f2240j &= -33;
    }

    public final void n() {
        o0 o0Var = this.f2429h.B;
        this.f2428f = this.f2427e + (o0Var != null ? o0Var.f2365j : 0);
        ArrayList arrayList = this.f2425c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f2428f; size--) {
            h(size);
        }
    }
}
