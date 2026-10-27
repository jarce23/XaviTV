package ib;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.emoji2.text.s f6595a;

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.emoji2.text.s f6596b;

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.emoji2.text.s f6597c;

    /* renamed from: d, reason: collision with root package name */
    public static final androidx.emoji2.text.s f6598d;

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.emoji2.text.s f6599e;

    /* renamed from: f, reason: collision with root package name */
    public static final androidx.emoji2.text.s f6600f;
    public static final androidx.emoji2.text.s g;

    /* renamed from: h, reason: collision with root package name */
    public static final c0 f6601h = new c0(false);

    /* renamed from: i, reason: collision with root package name */
    public static final c0 f6602i = new c0(true);

    static {
        int i10 = 6;
        boolean z10 = false;
        f6595a = new androidx.emoji2.text.s("RESUME_TOKEN", z10, i10);
        f6596b = new androidx.emoji2.text.s("CLOSED_EMPTY", z10, i10);
        f6597c = new androidx.emoji2.text.s("COMPLETING_ALREADY", z10, i10);
        f6598d = new androidx.emoji2.text.s("COMPLETING_WAITING_CHILDREN", z10, i10);
        f6599e = new androidx.emoji2.text.s("COMPLETING_RETRY", z10, i10);
        f6600f = new androidx.emoji2.text.s("TOO_LATE_TO_CANCEL", z10, i10);
        g = new androidx.emoji2.text.s("SEALED", z10, i10);
    }

    public static final nb.e a(pa.i iVar) {
        if (iVar.s(r.f6589p) == null) {
            iVar = iVar.K(new s0());
        }
        return new nb.e(iVar);
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final f c(pa.d dVar) {
        f fVar;
        f fVar2;
        if (!(dVar instanceof nb.h)) {
            return new f(1, dVar);
        }
        nb.h hVar = (nb.h) dVar;
        androidx.emoji2.text.s sVar = nb.a.f9308d;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = nb.h.f9318v;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(hVar);
            fVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(hVar, sVar);
                fVar2 = null;
                break;
            }
            if (obj instanceof f) {
                while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, sVar)) {
                    if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                        break;
                    }
                }
                fVar2 = (f) obj;
                break loop0;
            }
            if (obj != sVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (fVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f.f6552u;
            Object obj2 = atomicReferenceFieldUpdater2.get(fVar2);
            if (!(obj2 instanceof k) || ((k) obj2).f6571d == null) {
                f.f6551t.set(fVar2, 536870911);
                atomicReferenceFieldUpdater2.set(fVar2, b.f6544a);
                fVar = fVar2;
            } else {
                fVar2.l();
            }
            if (fVar != null) {
                return fVar;
            }
        }
        return new f(2, dVar);
    }

    public static final void d(pa.i iVar, Throwable th) {
        try {
            jb.b bVar = (jb.b) iVar.s(r.f6588o);
            if (bVar != null) {
                bVar.M(th);
            } else {
                nb.a.c(iVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                com.bumptech.glide.f.a(runtimeException, th);
                th = runtimeException;
            }
            nb.a.c(iVar, th);
        }
    }

    public static b0 e(p0 p0Var, boolean z10, u0 u0Var, int i10) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        boolean z11 = (i10 & 2) != 0;
        if (p0Var instanceof y0) {
            return ((y0) p0Var).C(z10, z11, u0Var);
        }
        t0 t0Var = new t0(1, u0Var, m0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0);
        y0 y0Var = (y0) p0Var;
        y0Var.getClass();
        return y0Var.C(z10, z11, new l0(t0Var));
    }

    public static void f(s sVar, ya.p pVar) {
        t tVar = t.f6591o;
        pa.i g6 = g(sVar, pa.j.f10146o);
        t tVar2 = t.f6591o;
        a d1Var = new d1(g6, true);
        d1Var.P(tVar, d1Var, pVar);
    }

    public static final pa.i g(s sVar, pa.i iVar) {
        pa.i K;
        pa.i e7 = sVar.e();
        Boolean bool = Boolean.FALSE;
        n nVar = n.f6578r;
        boolean booleanValue = ((Boolean) e7.x(bool, nVar)).booleanValue();
        boolean booleanValue2 = ((Boolean) iVar.x(bool, nVar)).booleanValue();
        if (booleanValue || booleanValue2) {
            n nVar2 = new n(2, 2);
            pa.j jVar = pa.j.f10146o;
            pa.i iVar2 = (pa.i) e7.x(jVar, nVar2);
            Object obj = iVar;
            if (booleanValue2) {
                obj = iVar.x(jVar, n.f6577q);
            }
            K = iVar2.K((pa.i) obj);
        } else {
            K = e7.K(iVar);
        }
        pb.e eVar = a0.f6541a;
        return (K == eVar || K.s(pa.e.f10145o) != null) ? K : K.K(eVar);
    }

    public static final void h(f fVar, pa.d dVar, boolean z10) {
        Object obj = f.f6552u.get(fVar);
        Throwable d6 = fVar.d(obj);
        Object d10 = d6 != null ? com.google.android.gms.internal.cast.n.d(d6) : fVar.e(obj);
        if (!z10) {
            dVar.resumeWith(d10);
            return;
        }
        za.h.c("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>", dVar);
        nb.h hVar = (nb.h) dVar;
        ra.c cVar = hVar.f9320s;
        Object obj2 = hVar.f9322u;
        pa.i context = cVar.getContext();
        Object j10 = nb.a.j(context, obj2);
        if (j10 != nb.a.f9310f) {
            j(cVar, context);
        }
        try {
            cVar.resumeWith(d10);
        } finally {
            nb.a.f(context, j10);
        }
    }

    public static final String i(pa.d dVar) {
        Object d6;
        if (dVar instanceof nb.h) {
            return dVar.toString();
        }
        try {
            d6 = dVar + '@' + b(dVar);
        } catch (Throwable th) {
            d6 = com.google.android.gms.internal.cast.n.d(th);
        }
        if (la.f.a(d6) != null) {
            d6 = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) d6;
    }

    public static final void j(pa.d dVar, pa.i iVar) {
        if ((dVar instanceof ra.d) && iVar.s(h1.f6564o) != null) {
            ra.d dVar2 = (ra.d) dVar;
            do {
                dVar2 = dVar2.getCallerFrame();
            } while (dVar2 != null);
        }
    }
}
