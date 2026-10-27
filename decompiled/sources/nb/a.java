package nb;

import ib.e1;
import ib.f0;
import ib.f1;
import ib.p0;
import ib.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.emoji2.text.s f9305a = new androidx.emoji2.text.s("NO_DECISION", false, 6);

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.emoji2.text.s f9306b = new androidx.emoji2.text.s("CLOSED", false, 6);

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.emoji2.text.s f9307c = new androidx.emoji2.text.s("UNDEFINED", false, 6);

    /* renamed from: d, reason: collision with root package name */
    public static final androidx.emoji2.text.s f9308d = new androidx.emoji2.text.s("REUSABLE_CLAIMED", false, 6);

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.emoji2.text.s f9309e = new androidx.emoji2.text.s("CONDITION_FALSE", false, 6);

    /* renamed from: f, reason: collision with root package name */
    public static final androidx.emoji2.text.s f9310f = new androidx.emoji2.text.s("NO_THREAD_ELEMENTS", false, 6);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, nb.u] */
    /* JADX WARN: Type inference failed for: r4v2, types: [nb.u] */
    public static final Object a(long j10, kb.m mVar) {
        kb.f fVar = kb.f.f7891w;
        while (true) {
            long j11 = mVar.f9344c;
            if (j11 >= j10 && !mVar.c()) {
                return mVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f9313a;
            Object obj = atomicReferenceFieldUpdater.get(mVar);
            androidx.emoji2.text.s sVar = f9306b;
            if (obj == sVar) {
                return sVar;
            }
            ?? r42 = (u) ((d) obj);
            if (r42 != 0) {
                mVar = r42;
            } else {
                ?? r12 = (u) fVar.b(Long.valueOf(j11 + 1), mVar);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(mVar, null, r12)) {
                        if (mVar.c()) {
                            mVar.d();
                        }
                        mVar = r12;
                    } else if (atomicReferenceFieldUpdater.get(mVar) != null) {
                        break;
                    }
                }
            }
        }
    }

    public static final u b(Object obj) {
        if (obj == f9306b) {
            throw new IllegalStateException("Does not contain segment");
        }
        za.h.c("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed", obj);
        return (u) obj;
    }

    public static final void c(pa.i iVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = f.f9316a.iterator();
        while (it.hasNext()) {
            try {
                ((jb.b) it.next()).M(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    com.bumptech.glide.f.a(runtimeException, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, runtimeException);
            }
        }
        try {
            com.bumptech.glide.f.a(th, new g(iVar));
        } catch (Throwable unused) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static final boolean d(Object obj) {
        return obj == f9306b;
    }

    public static final Object e(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void f(pa.i iVar, Object obj) {
        if (obj == f9310f) {
            return;
        }
        if (!(obj instanceof z)) {
            za.h.c("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>", iVar.x(null, x.f9348r));
            throw new ClassCastException();
        }
        z zVar = (z) obj;
        e1[] e1VarArr = zVar.f9353b;
        int length = e1VarArr.length - 1;
        if (length < 0) {
            return;
        }
        e1 e1Var = e1VarArr[length];
        za.h.b(null);
        Object obj2 = zVar.f9352a[length];
        throw null;
    }

    public static final void g(Object obj, pa.d dVar) {
        if (!(dVar instanceof h)) {
            dVar.resumeWith(obj);
            return;
        }
        h hVar = (h) dVar;
        ib.q qVar = hVar.f9319r;
        ra.c cVar = hVar.f9320s;
        Throwable a10 = la.f.a(obj);
        Object lVar = a10 == null ? obj : new ib.l(a10, false);
        cVar.getContext();
        if (qVar.O()) {
            hVar.f9321t = lVar;
            hVar.f6619q = 1;
            qVar.M(cVar.getContext(), hVar);
            return;
        }
        f0 a11 = f1.a();
        if (a11.f6556q >= 4294967296L) {
            hVar.f9321t = lVar;
            hVar.f6619q = 1;
            a11.Q(hVar);
            return;
        }
        a11.S(true);
        try {
            p0 p0Var = (p0) cVar.getContext().s(ib.r.f6589p);
            if (p0Var == null || p0Var.a()) {
                Object obj2 = hVar.f9322u;
                pa.i context = cVar.getContext();
                Object j10 = j(context, obj2);
                if (j10 != f9310f) {
                    ib.v.j(cVar, context);
                }
                try {
                    cVar.resumeWith(obj);
                } finally {
                    f(context, j10);
                }
            } else {
                CancellationException u10 = ((y0) p0Var).u();
                hVar.b(lVar, u10);
                hVar.resumeWith(com.google.android.gms.internal.cast.n.d(u10));
            }
            while (a11.T()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long h(long r23, long r25, long r27, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.a.h(long, long, long, java.lang.String):long");
    }

    public static int i(String str, int i10, int i11) {
        return (int) h(i10, 1, (i11 & 8) != 0 ? Integer.MAX_VALUE : 2097150, str);
    }

    public static final Object j(pa.i iVar, Object obj) {
        if (obj == null) {
            obj = iVar.x(0, x.f9347q);
            za.h.b(obj);
        }
        if (obj == 0) {
            return f9310f;
        }
        if (obj instanceof Integer) {
            return iVar.x(new z(((Number) obj).intValue(), iVar), x.f9349s);
        }
        r.a.j(obj);
        throw null;
    }
}
