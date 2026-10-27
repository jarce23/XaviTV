package l4;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import j9.v1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import m0.k0;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class m implements Cloneable {
    public static final Animator[] K = new Animator[0];
    public static final int[] L = {2, 1, 3, 4};
    public static final v1 M = new v1(4);
    public static final ThreadLocal N = new ThreadLocal();
    public k[] A;

    /* renamed from: y, reason: collision with root package name */
    public ArrayList f8245y;

    /* renamed from: z, reason: collision with root package name */
    public ArrayList f8246z;

    /* renamed from: o, reason: collision with root package name */
    public final String f8235o = getClass().getName();

    /* renamed from: p, reason: collision with root package name */
    public long f8236p = -1;

    /* renamed from: q, reason: collision with root package name */
    public long f8237q = -1;

    /* renamed from: r, reason: collision with root package name */
    public TimeInterpolator f8238r = null;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f8239s = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f8240t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public x4.i f8241u = new x4.i(10);

    /* renamed from: v, reason: collision with root package name */
    public x4.i f8242v = new x4.i(10);

    /* renamed from: w, reason: collision with root package name */
    public a f8243w = null;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f8244x = L;
    public final ArrayList B = new ArrayList();
    public Animator[] C = K;
    public int D = 0;
    public boolean E = false;
    public boolean F = false;
    public m G = null;
    public ArrayList H = null;
    public ArrayList I = new ArrayList();
    public v1 J = M;

    public static void b(x4.i iVar, View view, u uVar) {
        p.e eVar = (p.e) iVar.f13553p;
        p.e eVar2 = (p.e) iVar.f13556s;
        SparseArray sparseArray = (SparseArray) iVar.f13554q;
        p.g gVar = (p.g) iVar.f13555r;
        eVar.put(view, uVar);
        int id = view.getId();
        if (id >= 0) {
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = k0.f8683a;
        String e7 = m0.c0.e(view);
        if (e7 != null) {
            if (eVar2.containsKey(e7)) {
                eVar2.put(e7, null);
            } else {
                eVar2.put(e7, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (gVar.f9773o) {
                    int i10 = gVar.f9776r;
                    long[] jArr = gVar.f9774p;
                    Object[] objArr = gVar.f9775q;
                    int i11 = 0;
                    for (int i12 = 0; i12 < i10; i12++) {
                        Object obj = objArr[i12];
                        if (obj != p.h.f9777a) {
                            if (i12 != i11) {
                                jArr[i11] = jArr[i12];
                                objArr[i11] = obj;
                                objArr[i12] = null;
                            }
                            i11++;
                        }
                    }
                    gVar.f9773o = false;
                    gVar.f9776r = i11;
                }
                if (q.a.b(gVar.f9774p, gVar.f9776r, itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    gVar.g(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) gVar.d(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    gVar.g(itemIdAtPosition, null);
                }
            }
        }
    }

    public static p.e o() {
        ThreadLocal threadLocal = N;
        p.e eVar = (p.e) threadLocal.get();
        if (eVar != null) {
            return eVar;
        }
        p.e eVar2 = new p.e(0);
        threadLocal.set(eVar2);
        return eVar2;
    }

    public static boolean t(u uVar, u uVar2, String str) {
        Object obj = uVar.f8257a.get(str);
        Object obj2 = uVar2.f8257a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void B(TimeInterpolator timeInterpolator) {
        this.f8238r = timeInterpolator;
    }

    public void C(v1 v1Var) {
        if (v1Var == null) {
            this.J = M;
        } else {
            this.J = v1Var;
        }
    }

    public void E(long j10) {
        this.f8236p = j10;
    }

    public final void F() {
        if (this.D == 0) {
            u(this, l.g);
            this.F = false;
        }
        this.D++;
    }

    public String G(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(getClass().getSimpleName());
        sb2.append("@");
        sb2.append(Integer.toHexString(hashCode()));
        sb2.append(": ");
        if (this.f8237q != -1) {
            sb2.append("dur(");
            sb2.append(this.f8237q);
            sb2.append(") ");
        }
        if (this.f8236p != -1) {
            sb2.append("dly(");
            sb2.append(this.f8236p);
            sb2.append(") ");
        }
        if (this.f8238r != null) {
            sb2.append("interp(");
            sb2.append(this.f8238r);
            sb2.append(") ");
        }
        ArrayList arrayList = this.f8239s;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f8240t;
        if (size > 0 || arrayList2.size() > 0) {
            sb2.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    if (i10 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(arrayList.get(i10));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    if (i11 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(arrayList2.get(i11));
                }
            }
            sb2.append(")");
        }
        return sb2.toString();
    }

    public void a(k kVar) {
        if (this.H == null) {
            this.H = new ArrayList();
        }
        this.H.add(kVar);
    }

    public abstract void c(u uVar);

    public void cancel() {
        ArrayList arrayList = this.B;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.C);
        this.C = K;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            animator.cancel();
        }
        this.C = animatorArr;
        u(this, l.f8232i);
    }

    public final void d(View view, boolean z10) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            u uVar = new u(view);
            if (z10) {
                f(uVar);
            } else {
                c(uVar);
            }
            uVar.f8259c.add(this);
            e(uVar);
            if (z10) {
                b(this.f8241u, view, uVar);
            } else {
                b(this.f8242v, view, uVar);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                d(viewGroup.getChildAt(i10), z10);
            }
        }
    }

    public abstract void f(u uVar);

    public final void g(ViewGroup viewGroup, boolean z10) {
        h(z10);
        ArrayList arrayList = this.f8239s;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f8240t;
        if (size <= 0 && arrayList2.size() <= 0) {
            d(viewGroup, z10);
            return;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            View findViewById = viewGroup.findViewById(((Integer) arrayList.get(i10)).intValue());
            if (findViewById != null) {
                u uVar = new u(findViewById);
                if (z10) {
                    f(uVar);
                } else {
                    c(uVar);
                }
                uVar.f8259c.add(this);
                e(uVar);
                if (z10) {
                    b(this.f8241u, findViewById, uVar);
                } else {
                    b(this.f8242v, findViewById, uVar);
                }
            }
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            View view = (View) arrayList2.get(i11);
            u uVar2 = new u(view);
            if (z10) {
                f(uVar2);
            } else {
                c(uVar2);
            }
            uVar2.f8259c.add(this);
            e(uVar2);
            if (z10) {
                b(this.f8241u, view, uVar2);
            } else {
                b(this.f8242v, view, uVar2);
            }
        }
    }

    public final void h(boolean z10) {
        if (z10) {
            ((p.e) this.f8241u.f13553p).clear();
            ((SparseArray) this.f8241u.f13554q).clear();
            ((p.g) this.f8241u.f13555r).b();
        } else {
            ((p.e) this.f8242v.f13553p).clear();
            ((SparseArray) this.f8242v.f13554q).clear();
            ((p.g) this.f8242v.f13555r).b();
        }
    }

    @Override // 
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.I = new ArrayList();
            mVar.f8241u = new x4.i(10);
            mVar.f8242v = new x4.i(10);
            mVar.f8245y = null;
            mVar.f8246z = null;
            mVar.G = this;
            mVar.H = null;
            return mVar;
        } catch (CloneNotSupportedException e7) {
            throw new RuntimeException(e7);
        }
    }

    public Animator j(ViewGroup viewGroup, u uVar, u uVar2) {
        return null;
    }

    public void k(ViewGroup viewGroup, x4.i iVar, x4.i iVar2, ArrayList arrayList, ArrayList arrayList2) {
        int i10;
        int i11;
        View view;
        u uVar;
        Animator animator;
        u uVar2;
        p.e o2 = o();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        n().getClass();
        int i12 = 0;
        while (i12 < size) {
            u uVar3 = (u) arrayList.get(i12);
            u uVar4 = (u) arrayList2.get(i12);
            if (uVar3 != null && !uVar3.f8259c.contains(this)) {
                uVar3 = null;
            }
            if (uVar4 != null && !uVar4.f8259c.contains(this)) {
                uVar4 = null;
            }
            if ((uVar3 != null || uVar4 != null) && (uVar3 == null || uVar4 == null || r(uVar3, uVar4))) {
                Animator j10 = j(viewGroup, uVar3, uVar4);
                if (j10 != null) {
                    String str = this.f8235o;
                    if (uVar4 != null) {
                        view = uVar4.f8258b;
                        String[] p10 = p();
                        if (p10 != null && p10.length > 0) {
                            uVar2 = new u(view);
                            u uVar5 = (u) ((p.e) iVar2.f13553p).get(view);
                            i10 = size;
                            if (uVar5 != null) {
                                int i13 = 0;
                                while (i13 < p10.length) {
                                    String str2 = p10[i13];
                                    uVar2.f8257a.put(str2, uVar5.f8257a.get(str2));
                                    i13++;
                                    i12 = i12;
                                    uVar5 = uVar5;
                                }
                            }
                            i11 = i12;
                            int i14 = o2.f9781q;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= i14) {
                                    animator = j10;
                                    break;
                                }
                                j jVar = (j) o2.get((Animator) o2.f(i15));
                                if (jVar.f8227c != null && jVar.f8225a == view && jVar.f8226b.equals(str) && jVar.f8227c.equals(uVar2)) {
                                    animator = null;
                                    break;
                                }
                                i15++;
                            }
                        } else {
                            i10 = size;
                            i11 = i12;
                            animator = j10;
                            uVar2 = null;
                        }
                        j10 = animator;
                        uVar = uVar2;
                    } else {
                        i10 = size;
                        i11 = i12;
                        view = uVar3.f8258b;
                        uVar = null;
                    }
                    if (j10 != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        j jVar2 = new j();
                        jVar2.f8225a = view;
                        jVar2.f8226b = str;
                        jVar2.f8227c = uVar;
                        jVar2.f8228d = windowId;
                        jVar2.f8229e = this;
                        jVar2.f8230f = j10;
                        o2.put(j10, jVar2);
                        this.I.add(j10);
                    }
                    i12 = i11 + 1;
                    size = i10;
                }
            }
            i10 = size;
            i11 = i12;
            i12 = i11 + 1;
            size = i10;
        }
        if (sparseIntArray.size() != 0) {
            for (int i16 = 0; i16 < sparseIntArray.size(); i16++) {
                j jVar3 = (j) o2.get((Animator) this.I.get(sparseIntArray.keyAt(i16)));
                jVar3.f8230f.setStartDelay(jVar3.f8230f.getStartDelay() + (sparseIntArray.valueAt(i16) - Long.MAX_VALUE));
            }
        }
    }

    public final void l() {
        int i10 = this.D - 1;
        this.D = i10;
        if (i10 == 0) {
            u(this, l.f8231h);
            for (int i11 = 0; i11 < ((p.g) this.f8241u.f13555r).h(); i11++) {
                View view = (View) ((p.g) this.f8241u.f13555r).i(i11);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i12 = 0; i12 < ((p.g) this.f8242v.f13555r).h(); i12++) {
                View view2 = (View) ((p.g) this.f8242v.f13555r).i(i12);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.F = true;
        }
    }

    public final u m(View view, boolean z10) {
        a aVar = this.f8243w;
        if (aVar != null) {
            return aVar.m(view, z10);
        }
        ArrayList arrayList = z10 ? this.f8245y : this.f8246z;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            }
            u uVar = (u) arrayList.get(i10);
            if (uVar == null) {
                return null;
            }
            if (uVar.f8258b == view) {
                break;
            }
            i10++;
        }
        if (i10 >= 0) {
            return (u) (z10 ? this.f8246z : this.f8245y).get(i10);
        }
        return null;
    }

    public final m n() {
        a aVar = this.f8243w;
        return aVar != null ? aVar.n() : this;
    }

    public String[] p() {
        return null;
    }

    public final u q(View view, boolean z10) {
        a aVar = this.f8243w;
        if (aVar != null) {
            return aVar.q(view, z10);
        }
        return (u) ((p.e) (z10 ? this.f8241u : this.f8242v).f13553p).get(view);
    }

    public boolean r(u uVar, u uVar2) {
        if (uVar != null && uVar2 != null) {
            String[] p10 = p();
            if (p10 != null) {
                for (String str : p10) {
                    if (t(uVar, uVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = uVar.f8257a.keySet().iterator();
                while (it.hasNext()) {
                    if (t(uVar, uVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean s(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f8239s;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f8240t;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final String toString() {
        return G(_UrlKt.FRAGMENT_ENCODE_SET);
    }

    public final void u(m mVar, l lVar) {
        m mVar2 = this.G;
        if (mVar2 != null) {
            mVar2.u(mVar, lVar);
        }
        ArrayList arrayList = this.H;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.H.size();
        k[] kVarArr = this.A;
        if (kVarArr == null) {
            kVarArr = new k[size];
        }
        this.A = null;
        k[] kVarArr2 = (k[]) this.H.toArray(kVarArr);
        for (int i10 = 0; i10 < size; i10++) {
            lVar.a(kVarArr2[i10], mVar);
            kVarArr2[i10] = null;
        }
        this.A = kVarArr2;
    }

    public void v(View view) {
        if (this.F) {
            return;
        }
        ArrayList arrayList = this.B;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.C);
        this.C = K;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            animator.pause();
        }
        this.C = animatorArr;
        u(this, l.f8233j);
        this.E = true;
    }

    public m w(k kVar) {
        m mVar;
        ArrayList arrayList = this.H;
        if (arrayList != null) {
            if (!arrayList.remove(kVar) && (mVar = this.G) != null) {
                mVar.w(kVar);
            }
            if (this.H.size() == 0) {
                this.H = null;
            }
        }
        return this;
    }

    public void x(View view) {
        if (this.E) {
            if (!this.F) {
                ArrayList arrayList = this.B;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.C);
                this.C = K;
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    Animator animator = animatorArr[i10];
                    animatorArr[i10] = null;
                    animator.resume();
                }
                this.C = animatorArr;
                u(this, l.f8234k);
            }
            this.E = false;
        }
    }

    public void y() {
        F();
        p.e o2 = o();
        ArrayList arrayList = this.I;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Animator animator = (Animator) obj;
            if (o2.containsKey(animator)) {
                F();
                if (animator != null) {
                    animator.addListener(new i(this, o2));
                    long j10 = this.f8237q;
                    if (j10 >= 0) {
                        animator.setDuration(j10);
                    }
                    long j11 = this.f8236p;
                    if (j11 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j11);
                    }
                    TimeInterpolator timeInterpolator = this.f8238r;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new g9.l(1, this));
                    animator.start();
                }
            }
        }
        this.I.clear();
        l();
    }

    public void z(long j10) {
        this.f8237q = j10;
    }

    public void D() {
    }

    public void A(a.a aVar) {
    }

    public void e(u uVar) {
    }
}
