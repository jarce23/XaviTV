package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3399o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f3400p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f3401q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f3402r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f3403s;

    public /* synthetic */ o(p pVar, w3.z zVar, w3.z zVar2, r.i iVar) {
        this.f3399o = 0;
        this.f3400p = pVar;
        this.f3401q = zVar;
        this.f3402r = zVar2;
        this.f3403s = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10;
        i8.i iVar;
        int i11 = this.f3399o;
        g7.r rVar = null;
        Object obj = this.f3402r;
        Object obj2 = this.f3401q;
        Object obj3 = this.f3403s;
        Object obj4 = this.f3400p;
        switch (i11) {
            case 0:
                w3.z zVar = (w3.z) obj2;
                w3.z zVar2 = (w3.z) obj;
                r.i iVar2 = (r.i) obj3;
                t tVar = ((p) obj4).f3414a;
                tVar.getClass();
                l7.b bVar = t.f3467i;
                Set set = tVar.f3469b;
                if (new HashSet(set).isEmpty()) {
                    bVar.b("No need to prepare transfer without any callback", new Object[0]);
                    iVar2.a();
                    return;
                }
                if (zVar.f13078k != 1) {
                    bVar.b("No need to prepare transfer when transferring from local", new Object[0]);
                    iVar2.a();
                    return;
                }
                i7.h a10 = tVar.a();
                if (a10 == null || !a10.g()) {
                    bVar.b("No need to prepare transfer when there is no media session", new Object[0]);
                    iVar2.a();
                    return;
                }
                bVar.b("Prepare route transfer for changing endpoint", new Object[0]);
                int i12 = 2;
                if (zVar2.f13078k == 0) {
                    y1.a(z0.CAST_TRANSFER_TO_LOCAL_USED);
                    i10 = 1;
                } else {
                    i10 = CastDevice.b(zVar2.f13085r) == null ? 3 : 2;
                }
                tVar.f3472e = i10;
                tVar.g = iVar2;
                bVar.b("notify transferring with type = %d", Integer.valueOf(i10));
                Iterator it = new HashSet(set).iterator();
                while (it.hasNext()) {
                    u0 u0Var = (u0) it.next();
                    int i13 = tVar.f3472e;
                    switch (u0Var.f3486a) {
                        case 0:
                            w0.f3542j.b("onTransferring with type = %d", Integer.valueOf(i13));
                            w0 w0Var = (w0) u0Var.f3487b;
                            w0Var.f3550i = true;
                            w0Var.c();
                            m1 b2 = w0Var.f3545c.b(w0Var.g);
                            h1 m10 = i1.m(b2.d());
                            m10.c();
                            i1.v((i1) m10.f3641p, i13);
                            b2.e((i1) m10.a());
                            w0Var.f3543a.a((n1) b2.a(), 230);
                            break;
                        default:
                            c2.j1 j1Var = new c2.j1(10, i12);
                            u5 u5Var = (u5) u0Var.f3487b;
                            j1Var.f2627r = Boolean.valueOf(((c) u5Var.f3495p).f3277e == 2);
                            u5.e(u5Var, new t6(j1Var));
                            s6 f10 = u5Var.f();
                            a aVar = new a(new androidx.leanback.widget.i(i13));
                            aVar.f3237c = f10.f3461h;
                            f10.f3457c.add(aVar);
                            break;
                    }
                }
                tVar.f3474h = null;
                r7.r.b();
                if (a10.x()) {
                    a10.g = new i8.d();
                    i7.h.f6496k.b("create SessionState with cached mediaInfo and mediaStatus", new Object[0]);
                    MediaInfo c10 = a10.c();
                    g7.q d6 = a10.d();
                    if (c10 != null && d6 != null) {
                        Boolean bool = Boolean.TRUE;
                        long a11 = a10.a();
                        g7.n nVar = d6.J;
                        double d10 = d6.f5279r;
                        if (Double.compare(d10, 2.0d) > 0 || Double.compare(d10, 0.5d) < 0) {
                            throw new IllegalArgumentException("playbackRate must be between PLAYBACK_RATE_MIN and PLAYBACK_RATE_MAX");
                        }
                        rVar = new g7.r(new g7.k(c10, nVar, bool, a11, d10, d6.f5286y, d6.C, null, null, null, null, 0L), null);
                    }
                    if (rVar != null) {
                        a10.g.b(rVar);
                    } else {
                        a10.g.a(new l7.l());
                    }
                    iVar = a10.g.f6520a;
                } else {
                    l7.l lVar = new l7.l();
                    iVar = new i8.i();
                    iVar.q(lVar);
                }
                r rVar2 = new r(tVar);
                iVar.getClass();
                a5.a aVar2 = i8.e.f6521a;
                iVar.j(aVar2, rVar2);
                ((com.bumptech.glide.manager.t) iVar.f6532d).f(new i8.g((Executor) aVar2, (i8.b) new r(tVar)));
                iVar.s();
                b8.e eVar = tVar.f3470c;
                r7.r.e(eVar);
                s sVar = tVar.f3471d;
                r7.r.e(sVar);
                eVar.postDelayed(sVar, 10000L);
                return;
            case 1:
                l.f fVar = (l.f) ((h5.i) obj3).f5610p;
                l.n nVar2 = (l.n) obj2;
                l.e eVar2 = (l.e) obj4;
                if (eVar2 != null) {
                    fVar.N = true;
                    eVar2.f7960b.c(false);
                    fVar.N = false;
                }
                if (nVar2.isEnabled() && nVar2.hasSubMenu()) {
                    ((l.l) obj).q(nVar2, null, 4);
                    return;
                }
                return;
            case 2:
                ((w3.s) obj4).a((w3.l) obj3, (w3.i) obj2, (Collection) obj);
                return;
            default:
                ((w3.s) obj4).a((w3.l) obj3, (w3.i) obj2, (ArrayList) obj);
                return;
        }
    }

    public /* synthetic */ o(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        this.f3399o = i10;
        this.f3403s = obj;
        this.f3400p = obj2;
        this.f3401q = obj3;
        this.f3402r = obj4;
    }
}
