package nb;

import ib.f0;
import ib.f1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends ib.z implements ra.d, pa.d {

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9318v = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: r, reason: collision with root package name */
    public final ib.q f9319r;

    /* renamed from: s, reason: collision with root package name */
    public final ra.c f9320s;

    /* renamed from: t, reason: collision with root package name */
    public Object f9321t;

    /* renamed from: u, reason: collision with root package name */
    public final Object f9322u;

    public h(ib.q qVar, ra.c cVar) {
        super(-1);
        this.f9319r = qVar;
        this.f9320s = cVar;
        this.f9321t = a.f9307c;
        Object x6 = cVar.getContext().x(0, x.f9347q);
        za.h.b(x6);
        this.f9322u = x6;
    }

    @Override // ib.z
    public final void b(Object obj, CancellationException cancellationException) {
        if (obj instanceof ib.m) {
            throw null;
        }
    }

    @Override // ib.z
    public final Object g() {
        Object obj = this.f9321t;
        this.f9321t = a.f9307c;
        return obj;
    }

    @Override // ra.d
    public final ra.d getCallerFrame() {
        ra.c cVar = this.f9320s;
        if (r.a.k(cVar)) {
            return cVar;
        }
        return null;
    }

    @Override // pa.d
    public final pa.i getContext() {
        return this.f9320s.getContext();
    }

    @Override // pa.d
    public final void resumeWith(Object obj) {
        ra.c cVar = this.f9320s;
        pa.i context = cVar.getContext();
        Throwable a10 = la.f.a(obj);
        Object lVar = a10 == null ? obj : new ib.l(a10, false);
        ib.q qVar = this.f9319r;
        if (qVar.O()) {
            this.f9321t = lVar;
            this.f6619q = 0;
            qVar.M(context, this);
            return;
        }
        f0 a11 = f1.a();
        if (a11.f6556q >= 4294967296L) {
            this.f9321t = lVar;
            this.f6619q = 0;
            a11.Q(this);
            return;
        }
        a11.S(true);
        try {
            pa.i context2 = cVar.getContext();
            Object j10 = a.j(context2, this.f9322u);
            try {
                cVar.resumeWith(obj);
                while (a11.T()) {
                }
            } finally {
                a.f(context2, j10);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f9319r + ", " + ib.v.i(this.f9320s) + ']';
    }

    @Override // ib.z
    public final pa.d c() {
        return this;
    }
}
