package ib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class y0 implements p0, c1 {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6617o = AtomicReferenceFieldUpdater.newUpdater(y0.class, Object.class, "_state$volatile");

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6618p = AtomicReferenceFieldUpdater.newUpdater(y0.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public y0(boolean z10) {
        this._state$volatile = z10 ? v.f6602i : v.f6601h;
    }

    public static j F(nb.k kVar) {
        while (kVar.j()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = nb.k.f9330b;
            nb.k f10 = kVar.f();
            if (f10 == null) {
                Object obj = atomicReferenceFieldUpdater.get(kVar);
                while (true) {
                    kVar = (nb.k) obj;
                    if (!kVar.j()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVar);
                }
            } else {
                kVar = f10;
            }
        }
        while (true) {
            kVar = kVar.i();
            if (!kVar.j()) {
                if (kVar instanceof j) {
                    return (j) kVar;
                }
                if (kVar instanceof z0) {
                    return null;
                }
            }
        }
    }

    public static String L(Object obj) {
        if (!(obj instanceof w0)) {
            return obj instanceof j0 ? ((j0) obj).a() ? "Active" : "New" : obj instanceof l ? "Cancelled" : "Completed";
        }
        w0 w0Var = (w0) obj;
        return w0Var.d() ? "Cancelling" : w0Var.f() ? "Completing" : "Active";
    }

    public final void B(p0 p0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6618p;
        a1 a1Var = a1.f6543a;
        if (p0Var == null) {
            atomicReferenceFieldUpdater.set(this, a1Var);
            return;
        }
        y0 y0Var = (y0) p0Var;
        loop0: while (true) {
            Object y8 = y0Var.y();
            boolean z10 = y8 instanceof c0;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6617o;
            if (!z10) {
                if (!(y8 instanceof i0)) {
                    break;
                }
                z0 z0Var = ((i0) y8).f6565a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(y0Var, y8, z0Var)) {
                    if (atomicReferenceFieldUpdater2.get(y0Var) != y8) {
                        break;
                    }
                }
                y0Var.getClass();
                break loop0;
            }
            if (!((c0) y8).f6546a) {
                c0 c0Var = v.f6602i;
                while (!atomicReferenceFieldUpdater2.compareAndSet(y0Var, y8, c0Var)) {
                    if (atomicReferenceFieldUpdater2.get(y0Var) != y8) {
                        break;
                    }
                }
                y0Var.getClass();
                break loop0;
            }
            break;
        }
        i iVar = (i) v.e(y0Var, true, new j(this), 2);
        atomicReferenceFieldUpdater.set(this, iVar);
        if (y() instanceof j0) {
            return;
        }
        iVar.b();
        atomicReferenceFieldUpdater.set(this, a1Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bf, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ib.b0 C(boolean r9, boolean r10, ib.m0 r11) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ib.y0.C(boolean, boolean, ib.m0):ib.b0");
    }

    public boolean D() {
        return false;
    }

    public final Object E(Object obj) {
        Object M;
        do {
            M = M(y(), obj);
            if (M == v.f6597c) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                l lVar = obj instanceof l ? (l) obj : null;
                throw new IllegalStateException(str, lVar != null ? lVar.f6575a : null);
            }
        } while (M == v.f6599e);
        return M;
    }

    public final void G(z0 z0Var, Throwable th) {
        Object h10 = z0Var.h();
        za.h.c("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", h10);
        a6.m0 m0Var = null;
        for (nb.k kVar = (nb.k) h10; !kVar.equals(z0Var); kVar = kVar.i()) {
            if (kVar instanceof r0) {
                u0 u0Var = (u0) kVar;
                try {
                    u0Var.d(th);
                } catch (Throwable th2) {
                    if (m0Var != null) {
                        com.bumptech.glide.f.a(m0Var, th2);
                    } else {
                        m0Var = new a6.m0("Exception in completion handler " + u0Var + " for " + this, th2);
                    }
                }
            }
        }
        if (m0Var != null) {
            A(m0Var);
        }
        m(th);
    }

    public final void J(u0 u0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        z0 z0Var = new z0();
        u0Var.getClass();
        nb.k.f9330b.set(z0Var, u0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = nb.k.f9329a;
        atomicReferenceFieldUpdater2.set(z0Var, u0Var);
        loop0: while (true) {
            if (u0Var.h() == u0Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(u0Var, u0Var, z0Var)) {
                    if (atomicReferenceFieldUpdater2.get(u0Var) != u0Var) {
                        break;
                    }
                }
                z0Var.g(u0Var);
                break loop0;
            }
            break;
        }
        nb.k i10 = u0Var.i();
        do {
            atomicReferenceFieldUpdater = f6617o;
            if (atomicReferenceFieldUpdater.compareAndSet(this, u0Var, i10)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == u0Var);
    }

    @Override // pa.i
    public final pa.i K(pa.i iVar) {
        return i7.e.x(this, iVar);
    }

    public final Object M(Object obj, Object obj2) {
        if (!(obj instanceof j0)) {
            return v.f6597c;
        }
        if (((obj instanceof c0) || (obj instanceof u0)) && !(obj instanceof j) && !(obj2 instanceof l)) {
            j0 j0Var = (j0) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6617o;
            Object k0Var = obj2 instanceof j0 ? new k0((j0) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, j0Var, k0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != j0Var) {
                    return v.f6599e;
                }
            }
            H(obj2);
            q(j0Var, obj2);
            return obj2;
        }
        j0 j0Var2 = (j0) obj;
        z0 w10 = w(j0Var2);
        if (w10 == null) {
            return v.f6599e;
        }
        j jVar = null;
        w0 w0Var = j0Var2 instanceof w0 ? (w0) j0Var2 : null;
        if (w0Var == null) {
            w0Var = new w0(w10, null);
        }
        synchronized (w0Var) {
            if (w0Var.f()) {
                return v.f6597c;
            }
            w0.f6608b.set(w0Var, 1);
            if (w0Var != j0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6617o;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, j0Var2, w0Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != j0Var2) {
                        return v.f6599e;
                    }
                }
            }
            boolean d6 = w0Var.d();
            l lVar = obj2 instanceof l ? (l) obj2 : null;
            if (lVar != null) {
                w0Var.b(lVar.f6575a);
            }
            Throwable c10 = w0Var.c();
            if (d6) {
                c10 = null;
            }
            if (c10 != null) {
                G(w10, c10);
            }
            j jVar2 = j0Var2 instanceof j ? (j) j0Var2 : null;
            if (jVar2 == null) {
                z0 e7 = j0Var2.e();
                if (e7 != null) {
                    jVar = F(e7);
                }
            } else {
                jVar = jVar2;
            }
            if (jVar != null) {
                while (v.e(jVar.f6566e, false, new v0(this, w0Var, jVar, obj2), 1) == a1.f6543a) {
                    jVar = F(jVar);
                    if (jVar == null) {
                    }
                }
                return v.f6598d;
            }
            return t(w0Var, obj2);
        }
    }

    @Override // ib.p0
    public boolean a() {
        Object y8 = y();
        return (y8 instanceof j0) && ((j0) y8).a();
    }

    @Override // ib.p0
    public void c(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new q0(o(), null, this);
        }
        l(cancellationException);
    }

    @Override // pa.g
    public final pa.h getKey() {
        return r.f6589p;
    }

    public final boolean h(j0 j0Var, z0 z0Var, u0 u0Var) {
        nb.k f10;
        x0 x0Var = new x0(u0Var, this, j0Var);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = nb.k.f9330b;
            f10 = z0Var.f();
            if (f10 == null) {
                Object obj = atomicReferenceFieldUpdater.get(z0Var);
                while (true) {
                    f10 = (nb.k) obj;
                    if (!f10.j()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(f10);
                }
            }
            nb.k.f9330b.set(u0Var, f10);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = nb.k.f9329a;
            atomicReferenceFieldUpdater2.set(u0Var, z0Var);
            x0Var.f6614c = z0Var;
            while (!atomicReferenceFieldUpdater2.compareAndSet(f10, z0Var, x0Var)) {
                if (atomicReferenceFieldUpdater2.get(f10) != z0Var) {
                    break;
                }
            }
        }
        return x0Var.a(f10) == null;
    }

    public void j(Object obj) {
        i(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if (r0 == ib.v.f6598d) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ib.y0.k(java.lang.Object):boolean");
    }

    public void l(CancellationException cancellationException) {
        k(cancellationException);
    }

    public final boolean m(Throwable th) {
        if (D()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        i iVar = (i) f6618p.get(this);
        return (iVar == null || iVar == a1.f6543a) ? z10 : iVar.c(th) || z10;
    }

    @Override // pa.i
    public final pa.i n(pa.h hVar) {
        return i7.e.w(this, hVar);
    }

    public String o() {
        return "Job was cancelled";
    }

    public boolean p(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return k(th) && v();
    }

    public final void q(j0 j0Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6618p;
        i iVar = (i) atomicReferenceFieldUpdater.get(this);
        if (iVar != null) {
            iVar.b();
            atomicReferenceFieldUpdater.set(this, a1.f6543a);
        }
        a6.m0 m0Var = null;
        l lVar = obj instanceof l ? (l) obj : null;
        Throwable th = lVar != null ? lVar.f6575a : null;
        if (j0Var instanceof u0) {
            try {
                ((u0) j0Var).d(th);
                return;
            } catch (Throwable th2) {
                A(new a6.m0("Exception in completion handler " + j0Var + " for " + this, th2));
                return;
            }
        }
        z0 e7 = j0Var.e();
        if (e7 != null) {
            Object h10 = e7.h();
            za.h.c("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", h10);
            for (nb.k kVar = (nb.k) h10; !kVar.equals(e7); kVar = kVar.i()) {
                if (kVar instanceof u0) {
                    u0 u0Var = (u0) kVar;
                    try {
                        u0Var.d(th);
                    } catch (Throwable th3) {
                        if (m0Var != null) {
                            com.bumptech.glide.f.a(m0Var, th3);
                        } else {
                            m0Var = new a6.m0("Exception in completion handler " + u0Var + " for " + this, th3);
                        }
                    }
                }
            }
            if (m0Var != null) {
                A(m0Var);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    public final Throwable r(Object obj) {
        CancellationException cancellationException;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        y0 y0Var = (y0) ((c1) obj);
        Object y8 = y0Var.y();
        if (y8 instanceof w0) {
            cancellationException = ((w0) y8).c();
        } else if (y8 instanceof l) {
            cancellationException = ((l) y8).f6575a;
        } else {
            if (y8 instanceof j0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + y8).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        return cancellationException2 == null ? new q0("Parent job is ".concat(L(y8)), cancellationException, y0Var) : cancellationException2;
    }

    @Override // pa.i
    public final pa.g s(pa.h hVar) {
        za.h.e("key", hVar);
        if (za.h.a(r.f6589p, hVar)) {
            return this;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object t(w0 w0Var, Object obj) {
        Throwable th = null;
        l lVar = obj instanceof l ? (l) obj : null;
        Throwable th2 = lVar != null ? lVar.f6575a : null;
        synchronized (w0Var) {
            w0Var.d();
            ArrayList g = w0Var.g(th2);
            if (!g.isEmpty()) {
                int size = g.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    Object obj2 = g.get(i10);
                    i10++;
                    if (!(((Throwable) obj2) instanceof CancellationException)) {
                        th = obj2;
                        break;
                    }
                }
                th = th;
                if (th == null) {
                    th = (Throwable) g.get(0);
                }
            } else if (w0Var.d()) {
                th = new q0(o(), null, this);
            }
            if (th != null && g.size() > 1) {
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(g.size()));
                int size2 = g.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj3 = g.get(i11);
                    i11++;
                    Throwable th3 = (Throwable) obj3;
                    if (th3 != th && th3 != th && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                        com.bumptech.glide.f.a(th, th3);
                    }
                }
            }
        }
        if (th != null && th != th2) {
            obj = new l(th, false);
        }
        if (th != null && (m(th) || z(th))) {
            za.h.c("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally", obj);
            l.f6574b.compareAndSet((l) obj, 0, 1);
        }
        H(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6617o;
        Object k0Var = obj instanceof j0 ? new k0((j0) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, w0Var, k0Var) && atomicReferenceFieldUpdater.get(this) == w0Var) {
        }
        q(w0Var, obj);
        return obj;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName() + '{' + L(y()) + '}');
        sb2.append('@');
        sb2.append(v.b(this));
        return sb2.toString();
    }

    public final CancellationException u() {
        CancellationException cancellationException;
        Object y8 = y();
        if (!(y8 instanceof w0)) {
            if (y8 instanceof j0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(y8 instanceof l)) {
                return new q0(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((l) y8).f6575a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new q0(o(), th, this) : cancellationException;
        }
        Throwable c10 = ((w0) y8).c();
        if (c10 == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String concat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = c10 instanceof CancellationException ? (CancellationException) c10 : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (concat == null) {
            concat = o();
        }
        return new q0(concat, c10, this);
    }

    public boolean v() {
        return true;
    }

    public final z0 w(j0 j0Var) {
        z0 e7 = j0Var.e();
        if (e7 != null) {
            return e7;
        }
        if (j0Var instanceof c0) {
            return new z0();
        }
        if (j0Var instanceof u0) {
            J((u0) j0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + j0Var).toString());
    }

    @Override // pa.i
    public final Object x(Object obj, ya.p pVar) {
        return pVar.b(obj, this);
    }

    public final Object y() {
        while (true) {
            Object obj = f6617o.get(this);
            if (!(obj instanceof nb.q)) {
                return obj;
            }
            ((nb.q) obj).a(this);
        }
    }

    public boolean z(Throwable th) {
        return false;
    }

    public void I() {
    }

    public void A(a6.m0 m0Var) {
        throw m0Var;
    }

    public void H(Object obj) {
    }

    public void i(Object obj) {
    }
}
