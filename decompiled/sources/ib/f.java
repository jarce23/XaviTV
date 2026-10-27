package ib;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends z implements e, ra.d, i1 {

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6551t = AtomicIntegerFieldUpdater.newUpdater(f.class, "_decisionAndIndex$volatile");

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6552u = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_state$volatile");

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6553v = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: r, reason: collision with root package name */
    public final pa.d f6554r;

    /* renamed from: s, reason: collision with root package name */
    public final pa.i f6555s;

    public f(int i10, pa.d dVar) {
        super(i10);
        this.f6554r = dVar;
        this.f6555s = dVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f6544a;
    }

    public static void s(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public static Object v(b1 b1Var, Object obj, int i10, ya.l lVar) {
        if (obj instanceof l) {
            return obj;
        }
        if (i10 != 1 && i10 != 2) {
            return obj;
        }
        if (lVar != null || (b1Var instanceof d)) {
            return new k(obj, b1Var instanceof d ? (d) b1Var : null, lVar, (CancellationException) null, 16);
        }
        return obj;
    }

    @Override // ib.i1
    public final void a(nb.u uVar, int i10) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i11;
        do {
            atomicIntegerFieldUpdater = f6551t;
            i11 = atomicIntegerFieldUpdater.get(this);
            if ((i11 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        q(uVar);
    }

    @Override // ib.z
    public final void b(Object obj, CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6552u;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof b1) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof l) {
                return;
            }
            if (!(obj2 instanceof k)) {
                cancellationException2 = cancellationException;
                k kVar = new k(obj2, (d) null, (ya.l) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, kVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            k kVar2 = (k) obj2;
            if (kVar2.f6572e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            k a10 = k.a(kVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, a10)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    cancellationException2 = cancellationException;
                }
            }
            d dVar = kVar2.f6569b;
            if (dVar != null) {
                h(dVar, cancellationException);
            }
            ya.l lVar = kVar2.f6570c;
            if (lVar != null) {
                i(lVar, cancellationException);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // ib.z
    public final pa.d c() {
        return this.f6554r;
    }

    @Override // ib.z
    public final Throwable d(Object obj) {
        Throwable d6 = super.d(obj);
        if (d6 != null) {
            return d6;
        }
        return null;
    }

    @Override // ib.z
    public final Object e(Object obj) {
        return obj instanceof k ? ((k) obj).f6568a : obj;
    }

    @Override // ib.z
    public final Object g() {
        return f6552u.get(this);
    }

    @Override // ra.d
    public final ra.d getCallerFrame() {
        pa.d dVar = this.f6554r;
        if (dVar instanceof ra.d) {
            return (ra.d) dVar;
        }
        return null;
    }

    @Override // pa.d
    public final pa.i getContext() {
        return this.f6555s;
    }

    public final void h(d dVar, Throwable th) {
        try {
            dVar.f6547a.invoke(th);
        } catch (Throwable th2) {
            v.d(this.f6555s, new a6.m0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void i(ya.l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            v.d(this.f6555s, new a6.m0("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void j(nb.u uVar, Throwable th) {
        pa.i iVar = this.f6555s;
        int i10 = f6551t.get(this) & 536870911;
        if (i10 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            uVar.g(i10, iVar);
        } catch (Throwable th2) {
            v.d(iVar, new a6.m0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6552u;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof b1) {
                g gVar = new g(this, th, (obj instanceof d) || (obj instanceof nb.u));
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, gVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                b1 b1Var = (b1) obj;
                if (b1Var instanceof d) {
                    h((d) obj, th);
                } else if (b1Var instanceof nb.u) {
                    j((nb.u) obj, th);
                }
                if (!r()) {
                    l();
                }
                m(this.f6619q);
                return;
            }
            return;
        }
    }

    public final void l() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6553v;
        b0 b0Var = (b0) atomicReferenceFieldUpdater.get(this);
        if (b0Var == null) {
            return;
        }
        b0Var.b();
        atomicReferenceFieldUpdater.set(this, a1.f6543a);
    }

    public final void m(int i10) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i11;
        do {
            atomicIntegerFieldUpdater = f6551t;
            i11 = atomicIntegerFieldUpdater.get(this);
            int i12 = i11 >> 29;
            if (i12 != 0) {
                if (i12 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z10 = i10 == 4;
                pa.d dVar = this.f6554r;
                if (!z10 && (dVar instanceof nb.h)) {
                    boolean z11 = i10 == 1 || i10 == 2;
                    int i13 = this.f6619q;
                    if (z11 == (i13 == 1 || i13 == 2)) {
                        nb.h hVar = (nb.h) dVar;
                        q qVar = hVar.f9319r;
                        pa.i context = hVar.f9320s.getContext();
                        if (qVar.O()) {
                            qVar.M(context, this);
                            return;
                        }
                        f0 a10 = f1.a();
                        if (a10.f6556q >= 4294967296L) {
                            a10.Q(this);
                            return;
                        }
                        a10.S(true);
                        try {
                            v.h(this, dVar, true);
                            do {
                            } while (a10.T());
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                }
                v.h(this, dVar, z10);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, 1073741824 + (536870911 & i11)));
    }

    public final Object n() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        p0 p0Var;
        boolean r2 = r();
        do {
            atomicIntegerFieldUpdater = f6551t;
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (r2) {
                    t();
                }
                Object obj = f6552u.get(this);
                if (obj instanceof l) {
                    throw ((l) obj).f6575a;
                }
                int i12 = this.f6619q;
                if ((i12 != 1 && i12 != 2) || (p0Var = (p0) this.f6555s.s(r.f6589p)) == null || p0Var.a()) {
                    return e(obj);
                }
                CancellationException u10 = ((y0) p0Var).u();
                b(obj, u10);
                throw u10;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 536870912 + (536870911 & i10)));
        if (((b0) f6553v.get(this)) == null) {
            p();
        }
        if (r2) {
            t();
        }
        return qa.a.f10374o;
    }

    public final void o() {
        b0 p10 = p();
        if (p10 == null || (f6552u.get(this) instanceof b1)) {
            return;
        }
        p10.b();
        f6553v.set(this, a1.f6543a);
    }

    public final b0 p() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        p0 p0Var = (p0) this.f6555s.s(r.f6589p);
        if (p0Var == null) {
            return null;
        }
        b0 e7 = v.e(p0Var, true, new h(this), 2);
        do {
            atomicReferenceFieldUpdater = f6553v;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, e7)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return e7;
    }

    public final void q(b1 b1Var) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6552u;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, b1Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            boolean z10 = true;
            if (obj instanceof d ? true : obj instanceof nb.u) {
                s(b1Var, obj);
                throw null;
            }
            if (obj instanceof l) {
                l lVar = (l) obj;
                if (!l.f6574b.compareAndSet(lVar, 0, 1)) {
                    s(b1Var, obj);
                    throw null;
                }
                if (obj instanceof g) {
                    Throwable th = lVar.f6575a;
                    if (b1Var instanceof d) {
                        h((d) b1Var, th);
                        return;
                    } else {
                        za.h.c("null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>", b1Var);
                        j((nb.u) b1Var, th);
                        return;
                    }
                }
                return;
            }
            if (obj instanceof k) {
                k kVar = (k) obj;
                if (kVar.f6569b != null) {
                    s(b1Var, obj);
                    throw null;
                }
                if (b1Var instanceof nb.u) {
                    return;
                }
                za.h.c("null cannot be cast to non-null type kotlinx.coroutines.CancelHandler", b1Var);
                d dVar = (d) b1Var;
                Throwable th2 = kVar.f6572e;
                if (th2 != null) {
                    h(dVar, th2);
                    return;
                }
                k a10 = k.a(kVar, dVar, null, 29);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, a10)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    return;
                }
            } else {
                if (b1Var instanceof nb.u) {
                    return;
                }
                za.h.c("null cannot be cast to non-null type kotlinx.coroutines.CancelHandler", b1Var);
                k kVar2 = new k(obj, (d) b1Var, (ya.l) null, (CancellationException) null, 28);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, kVar2)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    return;
                }
            }
        }
    }

    public final boolean r() {
        if (this.f6619q != 2) {
            return false;
        }
        pa.d dVar = this.f6554r;
        za.h.c("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>", dVar);
        return nb.h.f9318v.get((nb.h) dVar) != null;
    }

    @Override // pa.d
    public final void resumeWith(Object obj) {
        Throwable a10 = la.f.a(obj);
        if (a10 != null) {
            obj = new l(a10, false);
        }
        u(obj, this.f6619q, null);
    }

    public final void t() {
        pa.d dVar = this.f6554r;
        Throwable th = null;
        nb.h hVar = dVar instanceof nb.h ? (nb.h) dVar : null;
        if (hVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = nb.h.f9318v;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(hVar);
                androidx.emoji2.text.s sVar = nb.a.f9308d;
                if (obj == sVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, sVar, this)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != sVar) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            l();
            k(th);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("CancellableContinuation(");
        sb2.append(v.i(this.f6554r));
        sb2.append("){");
        Object obj = f6552u.get(this);
        sb2.append(obj instanceof b1 ? "Active" : obj instanceof g ? "Cancelled" : "Completed");
        sb2.append("}@");
        sb2.append(v.b(this));
        return sb2.toString();
    }

    public final void u(Object obj, int i10, ya.l lVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6552u;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof b1) {
                Object v10 = v((b1) obj2, obj, i10, lVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, v10)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!r()) {
                    l();
                }
                m(i10);
                return;
            }
            if (obj2 instanceof g) {
                g gVar = (g) obj2;
                if (g.f6560c.compareAndSet(gVar, 0, 1)) {
                    if (lVar != null) {
                        i(lVar, gVar.f6575a);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }
}
