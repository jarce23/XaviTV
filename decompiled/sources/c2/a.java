package c2;

import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2518a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f2519b = new HashSet(1);

    /* renamed from: c, reason: collision with root package name */
    public final j0 f2520c;

    /* renamed from: d, reason: collision with root package name */
    public final j0 f2521d;

    /* renamed from: e, reason: collision with root package name */
    public Looper f2522e;

    /* renamed from: f, reason: collision with root package name */
    public i1.t0 f2523f;
    public t1.u g;

    public a() {
        int i10 = 0;
        d0 d0Var = null;
        this.f2520c = new j0(new CopyOnWriteArrayList(), i10, d0Var);
        this.f2521d = new j0(new CopyOnWriteArrayList(), i10, d0Var);
    }

    public abstract b0 a(d0 d0Var, g2.e eVar, long j10);

    public final void b(e0 e0Var) {
        HashSet hashSet = this.f2519b;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.remove(e0Var);
        if (isEmpty || !hashSet.isEmpty()) {
            return;
        }
        c();
    }

    public final void d(e0 e0Var) {
        this.f2522e.getClass();
        HashSet hashSet = this.f2519b;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.add(e0Var);
        if (isEmpty) {
            e();
        }
    }

    public i1.t0 f() {
        return null;
    }

    public abstract i1.a0 g();

    public boolean h() {
        return true;
    }

    public abstract void i();

    public final void j(e0 e0Var, o1.e0 e0Var2, t1.u uVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f2522e;
        l1.d.b(looper == null || looper == myLooper);
        this.g = uVar;
        i1.t0 t0Var = this.f2523f;
        this.f2518a.add(e0Var);
        if (this.f2522e == null) {
            this.f2522e = myLooper;
            this.f2519b.add(e0Var);
            k(e0Var2);
        } else if (t0Var != null) {
            d(e0Var);
            e0Var.a(this, t0Var);
        }
    }

    public abstract void k(o1.e0 e0Var);

    public final void l(i1.t0 t0Var) {
        this.f2523f = t0Var;
        ArrayList arrayList = this.f2518a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((e0) obj).a(this, t0Var);
        }
    }

    public abstract void m(b0 b0Var);

    public final void n(e0 e0Var) {
        ArrayList arrayList = this.f2518a;
        arrayList.remove(e0Var);
        if (!arrayList.isEmpty()) {
            b(e0Var);
            return;
        }
        this.f2522e = null;
        this.f2523f = null;
        this.g = null;
        this.f2519b.clear();
        o();
    }

    public abstract void o();

    public final void p(v1.d dVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2521d.f2623c;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            v1.c cVar = (v1.c) it.next();
            if (cVar.f12651a == dVar) {
                copyOnWriteArrayList.remove(cVar);
            }
        }
    }

    public final void q(k0 k0Var) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2520c.f2623c;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            i0 i0Var = (i0) it.next();
            if (i0Var.f2604b == k0Var) {
                copyOnWriteArrayList.remove(i0Var);
            }
        }
    }

    public abstract void r(i1.a0 a0Var);

    public void c() {
    }

    public void e() {
    }
}
