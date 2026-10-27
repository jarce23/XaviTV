package c2;

import android.os.Handler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class l extends a {

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f2633h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public Handler f2634i;

    /* renamed from: j, reason: collision with root package name */
    public o1.e0 f2635j;

    @Override // c2.a
    public final void c() {
        for (k kVar : this.f2633h.values()) {
            kVar.f2628a.b(kVar.f2629b);
        }
    }

    @Override // c2.a
    public final void e() {
        for (k kVar : this.f2633h.values()) {
            kVar.f2628a.d(kVar.f2629b);
        }
    }

    @Override // c2.a
    public void i() {
        Iterator it = this.f2633h.values().iterator();
        while (it.hasNext()) {
            ((k) it.next()).f2628a.i();
        }
    }

    @Override // c2.a
    public void o() {
        HashMap hashMap = this.f2633h;
        for (k kVar : hashMap.values()) {
            a aVar = kVar.f2628a;
            j jVar = kVar.f2630c;
            aVar.n(kVar.f2629b);
            aVar.q(jVar);
            aVar.p(jVar);
        }
        hashMap.clear();
    }

    public abstract d0 s(Object obj, d0 d0Var);

    public abstract void v(Object obj, a aVar, i1.t0 t0Var);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [c2.e0, c2.i] */
    public final void w(final Object obj, a aVar) {
        HashMap hashMap = this.f2633h;
        l1.d.b(!hashMap.containsKey(obj));
        ?? r12 = new e0() { // from class: c2.i
            @Override // c2.e0
            public final void a(a aVar2, i1.t0 t0Var) {
                l.this.v(obj, aVar2, t0Var);
            }
        };
        j jVar = new j(this, obj);
        hashMap.put(obj, new k(aVar, r12, jVar));
        Handler handler = this.f2634i;
        handler.getClass();
        aVar.getClass();
        j0 j0Var = aVar.f2520c;
        j0Var.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = j0Var.f2623c;
        i0 i0Var = new i0();
        i0Var.f2603a = handler;
        i0Var.f2604b = jVar;
        copyOnWriteArrayList.add(i0Var);
        this.f2634i.getClass();
        j0 j0Var2 = aVar.f2521d;
        j0Var2.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList2 = j0Var2.f2623c;
        v1.c cVar = new v1.c();
        cVar.f12651a = jVar;
        copyOnWriteArrayList2.add(cVar);
        o1.e0 e0Var = this.f2635j;
        t1.u uVar = this.g;
        l1.d.h(uVar);
        aVar.j(r12, e0Var, uVar);
        if (this.f2519b.isEmpty()) {
            aVar.b(r12);
        }
    }

    public long t(long j10, Object obj) {
        return j10;
    }

    public int u(int i10, Object obj) {
        return i10;
    }
}
