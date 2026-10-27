package h7;

import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.internal.cast.c3;
import com.google.android.gms.internal.cast.j4;
import com.google.android.gms.internal.cast.n2;
import com.google.android.gms.internal.cast.s6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 extends i7.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5738a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5739b;

    public /* synthetic */ f0(int i10, Object obj) {
        this.f5738a = i10;
        this.f5739b = obj;
    }

    @Override // i7.g
    public void a() {
        switch (this.f5738a) {
            case 2:
                ((j7.j) this.f5739b).b();
                break;
        }
    }

    @Override // i7.g
    public void b() {
        switch (this.f5738a) {
            case 2:
                ((j7.j) this.f5739b).b();
                break;
        }
    }

    @Override // i7.g
    public void c() {
        switch (this.f5738a) {
            case 2:
                ((j7.j) this.f5739b).b();
                break;
        }
    }

    @Override // i7.g
    public void d() {
        switch (this.f5738a) {
            case 2:
                ((j7.j) this.f5739b).b();
                break;
        }
    }

    @Override // i7.g
    public void e() {
        switch (this.f5738a) {
            case 1:
                i7.c cVar = (i7.c) this.f5739b;
                long e7 = cVar.e();
                if (e7 != cVar.f6470b) {
                    cVar.f6470b = e7;
                    cVar.c();
                    if (cVar.f6470b != 0) {
                        cVar.d();
                        break;
                    }
                }
                break;
            case 2:
                ((j7.j) this.f5739b).b();
                break;
        }
    }

    @Override // i7.g
    public void f(String str, long j10, int i10, long j11, long j12) {
        switch (this.f5738a) {
            case 0:
                j4 j4Var = ((d) this.f5739b).f5735l;
                if (j4Var != null) {
                    s6 f10 = j4Var.f3345o.f();
                    n2 n2Var = new n2(str);
                    n2Var.f3391b = j10;
                    n2Var.f3392c = i10;
                    n2Var.f3393d = j11;
                    n2Var.f3394e = j12;
                    c3 c3Var = new c3(n2Var);
                    c3Var.f3286f = f10.f3461h;
                    f10.f3458d.add(c3Var);
                    break;
                }
                break;
        }
    }

    @Override // i7.g
    public void g(int[] iArr) {
        switch (this.f5738a) {
            case 1:
                i7.c cVar = (i7.c) this.f5739b;
                ArrayList c10 = l7.a.c(iArr);
                if (!cVar.f6472d.equals(c10)) {
                    cVar.h();
                    cVar.f6474f.evictAll();
                    cVar.g.clear();
                    cVar.f6472d = c10;
                    i7.c.b(cVar);
                    cVar.g();
                    cVar.f();
                    break;
                }
                break;
        }
    }

    @Override // i7.g
    public void h(int[] iArr, int i10) {
        int i11;
        switch (this.f5738a) {
            case 1:
                if (i10 == 0) {
                    i11 = ((i7.c) this.f5739b).f6472d.size();
                } else {
                    i11 = ((i7.c) this.f5739b).f6473e.get(i10, -1);
                    if (i11 == -1) {
                        ((i7.c) this.f5739b).d();
                        return;
                    }
                }
                ((i7.c) this.f5739b).h();
                ((i7.c) this.f5739b).f6472d.addAll(i11, l7.a.c(iArr));
                i7.c.b((i7.c) this.f5739b);
                i7.c cVar = (i7.c) this.f5739b;
                synchronized (cVar.f6480m) {
                    Iterator it = cVar.f6480m.iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                }
                ((i7.c) this.f5739b).f();
                return;
            default:
                return;
        }
    }

    @Override // i7.g
    public void i(g7.o[] oVarArr) {
        switch (this.f5738a) {
            case 1:
                HashSet hashSet = new HashSet();
                i7.c cVar = (i7.c) this.f5739b;
                SparseIntArray sparseIntArray = cVar.f6473e;
                ArrayList arrayList = cVar.g;
                arrayList.clear();
                int i10 = 0;
                for (g7.o oVar : oVarArr) {
                    int i11 = oVar.f5267p;
                    cVar.f6474f.put(Integer.valueOf(i11), oVar);
                    int i12 = sparseIntArray.get(i11, -1);
                    if (i12 == -1) {
                        cVar.d();
                        break;
                    } else {
                        hashSet.add(Integer.valueOf(i12));
                    }
                }
                int size = arrayList.size();
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    int i13 = sparseIntArray.get(((Integer) obj).intValue(), -1);
                    if (i13 != -1) {
                        hashSet.add(Integer.valueOf(i13));
                    }
                }
                arrayList.clear();
                ArrayList arrayList2 = new ArrayList(hashSet);
                Collections.sort(arrayList2);
                cVar.h();
                l7.a.e(arrayList2);
                i7.c.a(cVar);
                cVar.f();
                break;
        }
    }

    @Override // i7.g
    public void j(int[] iArr) {
        switch (this.f5738a) {
            case 1:
                ArrayList arrayList = new ArrayList();
                for (int i10 : iArr) {
                    ((i7.c) this.f5739b).f6474f.remove(Integer.valueOf(i10));
                    int i11 = ((i7.c) this.f5739b).f6473e.get(i10, -1);
                    if (i11 == -1) {
                        ((i7.c) this.f5739b).d();
                        return;
                    } else {
                        ((i7.c) this.f5739b).f6473e.delete(i10);
                        arrayList.add(Integer.valueOf(i11));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                Collections.sort(arrayList);
                ((i7.c) this.f5739b).h();
                ((i7.c) this.f5739b).f6472d.removeAll(l7.a.c(iArr));
                i7.c.b((i7.c) this.f5739b);
                i7.c cVar = (i7.c) this.f5739b;
                l7.a.e(arrayList);
                synchronized (cVar.f6480m) {
                    Iterator it = cVar.f6480m.iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                }
                ((i7.c) this.f5739b).f();
                return;
            default:
                return;
        }
    }

    @Override // i7.g
    public void k(ArrayList arrayList, ArrayList arrayList2, int i10) {
        switch (this.f5738a) {
            case 1:
                ArrayList arrayList3 = new ArrayList();
                int i11 = 0;
                if (i10 == 0) {
                    ((i7.c) this.f5739b).f6472d.size();
                } else if (arrayList2.isEmpty()) {
                    l7.b bVar = ((i7.c) this.f5739b).f6469a;
                    Log.w(bVar.f8271a, bVar.d("Received a Queue Reordered message with an empty reordered items IDs list.", new Object[0]));
                } else if (((i7.c) this.f5739b).f6473e.get(i10, -1) == -1) {
                    i7.c cVar = (i7.c) this.f5739b;
                    cVar.f6473e.get(((Integer) arrayList2.get(0)).intValue(), -1);
                }
                int size = arrayList2.size();
                while (i11 < size) {
                    Object obj = arrayList2.get(i11);
                    i11++;
                    int i12 = ((i7.c) this.f5739b).f6473e.get(((Integer) obj).intValue(), -1);
                    if (i12 == -1) {
                        ((i7.c) this.f5739b).d();
                        return;
                    }
                    arrayList3.add(Integer.valueOf(i12));
                }
                ((i7.c) this.f5739b).h();
                i7.c cVar2 = (i7.c) this.f5739b;
                cVar2.f6472d = arrayList;
                i7.c.b(cVar2);
                i7.c cVar3 = (i7.c) this.f5739b;
                synchronized (cVar3.f6480m) {
                    Iterator it = cVar3.f6480m.iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                }
                ((i7.c) this.f5739b).f();
                return;
            default:
                return;
        }
    }

    @Override // i7.g
    public void l(int[] iArr) {
        switch (this.f5738a) {
            case 1:
                i7.c cVar = (i7.c) this.f5739b;
                ArrayList arrayList = new ArrayList();
                for (int i10 : iArr) {
                    cVar.f6474f.remove(Integer.valueOf(i10));
                    int i11 = cVar.f6473e.get(i10, -1);
                    if (i11 == -1) {
                        cVar.d();
                        break;
                    } else {
                        arrayList.add(Integer.valueOf(i11));
                    }
                }
                Collections.sort(arrayList);
                cVar.h();
                l7.a.e(arrayList);
                i7.c.a(cVar);
                cVar.f();
                break;
        }
    }

    @Override // i7.g
    public void m() {
        switch (this.f5738a) {
            case 1:
                ((i7.c) this.f5739b).d();
                break;
        }
    }
}
