package com.google.android.gms.internal.cast;

import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: i, reason: collision with root package name */
    public static final l7.b f3467i = new l7.b("SessionTransController", null);

    /* renamed from: a, reason: collision with root package name */
    public final h7.c f3468a;

    /* renamed from: f, reason: collision with root package name */
    public h7.i f3473f;
    public r.i g;

    /* renamed from: h, reason: collision with root package name */
    public g7.r f3474h;

    /* renamed from: b, reason: collision with root package name */
    public final Set f3469b = Collections.synchronizedSet(new HashSet());

    /* renamed from: e, reason: collision with root package name */
    public int f3472e = 0;

    /* renamed from: c, reason: collision with root package name */
    public final b8.e f3470c = new b8.e(Looper.getMainLooper(), 2);

    /* renamed from: d, reason: collision with root package name */
    public final s f3471d = new s(this, 0);

    public t(h7.c cVar) {
        this.f3468a = cVar;
    }

    public final i7.h a() {
        h7.i iVar = this.f3473f;
        l7.b bVar = f3467i;
        if (iVar == null) {
            bVar.b("skip transferring as SessionManager is null", new Object[0]);
            return null;
        }
        h7.d c10 = iVar.c();
        if (c10 == null) {
            bVar.b("skip transferring as CastSession is null", new Object[0]);
            return null;
        }
        r7.r.b();
        return c10.f5733j;
    }

    public final void b(int i10) {
        r.i iVar = this.g;
        if (iVar != null) {
            iVar.f10402d = true;
            r.k kVar = iVar.f10400b;
            if (kVar != null && kVar.f10405p.cancel(true)) {
                iVar.f10399a = null;
                iVar.f10400b = null;
                iVar.f10401c = null;
            }
        }
        int i11 = 2;
        f3467i.b("notify failed transfer with type = %d, reason = %d", Integer.valueOf(this.f3472e), Integer.valueOf(i10));
        Iterator it = new HashSet(this.f3469b).iterator();
        while (it.hasNext()) {
            u0 u0Var = (u0) it.next();
            int i12 = this.f3472e;
            switch (u0Var.f3486a) {
                case 0:
                    w0.f3542j.b("onTransferFailed with type = %d and reason = %d", Integer.valueOf(i12), Integer.valueOf(i10));
                    w0 w0Var = (w0) u0Var.f3487b;
                    w0Var.c();
                    m1 b2 = w0Var.f3545c.b(w0Var.g);
                    h1 m10 = i1.m(b2.d());
                    m10.c();
                    i1.v((i1) m10.f3641p, i12);
                    m10.c();
                    i1.w((i1) m10.f3641p, i10);
                    b2.e((i1) m10.a());
                    w0Var.f3543a.a((n1) b2.a(), 232);
                    w0Var.f3550i = false;
                    break;
                default:
                    c2.j1 j1Var = new c2.j1(11, i11);
                    j1Var.f2626q = Integer.valueOf(i10);
                    u5 u5Var = (u5) u0Var.f3487b;
                    j1Var.f2627r = Boolean.valueOf(((c) u5Var.f3495p).f3277e == 2);
                    u5.e(u5Var, new t6(j1Var));
                    break;
            }
        }
        c();
    }

    public final void c() {
        b8.e eVar = this.f3470c;
        r7.r.e(eVar);
        s sVar = this.f3471d;
        r7.r.e(sVar);
        eVar.removeCallbacks(sVar);
        this.f3472e = 0;
        this.f3474h = null;
    }
}
