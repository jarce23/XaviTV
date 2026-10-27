package ib;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class z extends pb.i {

    /* renamed from: q, reason: collision with root package name */
    public int f6619q;

    public z(int i10) {
        super(0L, pb.k.g);
        this.f6619q = i10;
    }

    public abstract void b(Object obj, CancellationException cancellationException);

    public abstract pa.d c();

    public Throwable d(Object obj) {
        l lVar = obj instanceof l ? (l) obj : null;
        if (lVar != null) {
            return lVar.f6575a;
        }
        return null;
    }

    public final void f(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            com.bumptech.glide.f.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        za.h.b(th);
        v.d(c().getContext(), new u("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object g();

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        r5 = (ib.p0) r5.s(ib.r.f6589p);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r12 = this;
            la.i r0 = la.i.f8335a
            androidx.leanback.widget.i r1 = r12.f10179p
            pa.d r2 = r12.c()     // Catch: java.lang.Throwable -> L23
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            za.h.c(r3, r2)     // Catch: java.lang.Throwable -> L23
            nb.h r2 = (nb.h) r2     // Catch: java.lang.Throwable -> L23
            ra.c r3 = r2.f9320s     // Catch: java.lang.Throwable -> L23
            java.lang.Object r2 = r2.f9322u     // Catch: java.lang.Throwable -> L23
            pa.i r4 = r3.getContext()     // Catch: java.lang.Throwable -> L23
            java.lang.Object r2 = nb.a.j(r4, r2)     // Catch: java.lang.Throwable -> L23
            androidx.emoji2.text.s r5 = nb.a.f9310f     // Catch: java.lang.Throwable -> L23
            if (r2 == r5) goto L26
            ib.v.j(r3, r4)     // Catch: java.lang.Throwable -> L23
            goto L26
        L23:
            r2 = move-exception
            goto L8f
        L26:
            pa.i r5 = r3.getContext()     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r6 = r12.g()     // Catch: java.lang.Throwable -> L4a
            java.lang.Throwable r7 = r12.d(r6)     // Catch: java.lang.Throwable -> L4a
            r8 = 0
            if (r7 != 0) goto L4c
            int r9 = r12.f6619q     // Catch: java.lang.Throwable -> L4a
            r10 = 1
            if (r9 == r10) goto L3f
            r11 = 2
            if (r9 != r11) goto L3e
            goto L3f
        L3e:
            r10 = 0
        L3f:
            if (r10 == 0) goto L4c
            ib.r r9 = ib.r.f6589p     // Catch: java.lang.Throwable -> L4a
            pa.g r5 = r5.s(r9)     // Catch: java.lang.Throwable -> L4a
            ib.p0 r5 = (ib.p0) r5     // Catch: java.lang.Throwable -> L4a
            goto L4d
        L4a:
            r3 = move-exception
            goto L8b
        L4c:
            r5 = r8
        L4d:
            if (r5 == 0) goto L66
            boolean r9 = r5.a()     // Catch: java.lang.Throwable -> L4a
            if (r9 != 0) goto L66
            ib.y0 r5 = (ib.y0) r5     // Catch: java.lang.Throwable -> L4a
            java.util.concurrent.CancellationException r5 = r5.u()     // Catch: java.lang.Throwable -> L4a
            r12.b(r6, r5)     // Catch: java.lang.Throwable -> L4a
            la.e r5 = com.google.android.gms.internal.cast.n.d(r5)     // Catch: java.lang.Throwable -> L4a
            r3.resumeWith(r5)     // Catch: java.lang.Throwable -> L4a
            goto L77
        L66:
            if (r7 == 0) goto L70
            la.e r5 = com.google.android.gms.internal.cast.n.d(r7)     // Catch: java.lang.Throwable -> L4a
            r3.resumeWith(r5)     // Catch: java.lang.Throwable -> L4a
            goto L77
        L70:
            java.lang.Object r5 = r12.e(r6)     // Catch: java.lang.Throwable -> L4a
            r3.resumeWith(r5)     // Catch: java.lang.Throwable -> L4a
        L77:
            nb.a.f(r4, r2)     // Catch: java.lang.Throwable -> L23
            r1.getClass()     // Catch: java.lang.Throwable -> L7e
            goto L83
        L7e:
            r0 = move-exception
            la.e r0 = com.google.android.gms.internal.cast.n.d(r0)
        L83:
            java.lang.Throwable r0 = la.f.a(r0)
            r12.f(r8, r0)
            goto L9f
        L8b:
            nb.a.f(r4, r2)     // Catch: java.lang.Throwable -> L23
            throw r3     // Catch: java.lang.Throwable -> L23
        L8f:
            r1.getClass()     // Catch: java.lang.Throwable -> L93
            goto L98
        L93:
            r0 = move-exception
            la.e r0 = com.google.android.gms.internal.cast.n.d(r0)
        L98:
            java.lang.Throwable r0 = la.f.a(r0)
            r12.f(r2, r0)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ib.z.run():void");
    }

    public Object e(Object obj) {
        return obj;
    }
}
