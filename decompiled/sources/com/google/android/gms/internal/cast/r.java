package com.google.android.gms.internal.cast;

import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements i8.c, i8.b, h7.j {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ t f3439o;

    public /* synthetic */ r(t tVar) {
        this.f3439o = tVar;
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void b(h7.h hVar, int i10) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void d(h7.h hVar, String str) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void f(h7.h hVar, int i10) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void g(h7.h hVar, boolean z10) {
    }

    @Override // h7.j
    public void h(h7.h hVar, int i10) {
        l7.b bVar = t.f3467i;
        bVar.b("onSessionEnded with error = %d", Integer.valueOf(i10));
        t tVar = this.f3439o;
        int i11 = tVar.f3472e;
        if (i11 != 0) {
            if (tVar.f3474h != null) {
                bVar.b("notify transferred with type = %d, sessionState = %s", Integer.valueOf(i11), tVar.f3474h);
                Iterator it = new HashSet(tVar.f3469b).iterator();
                while (it.hasNext()) {
                    u0 u0Var = (u0) it.next();
                    int i12 = tVar.f3472e;
                    switch (u0Var.f3486a) {
                        case 0:
                            w0.f3542j.b("onTransferred with type = %d", Integer.valueOf(i12));
                            w0 w0Var = (w0) u0Var.f3487b;
                            w0Var.c();
                            m1 b2 = w0Var.f3545c.b(w0Var.g);
                            h1 m10 = i1.m(b2.d());
                            m10.c();
                            i1.v((i1) m10.f3641p, i12);
                            b2.e((i1) m10.a());
                            w0Var.f3543a.a((n1) b2.a(), 231);
                            w0Var.f3550i = false;
                            w0Var.g = null;
                            break;
                    }
                }
            } else {
                bVar.b("No need to notify with null sessionState", new Object[0]);
            }
        } else {
            bVar.b("No need to notify transferred if the transfer type is unknown", new Object[0]);
        }
        if (tVar.f3472e == 2) {
            return;
        }
        tVar.c();
    }

    @Override // h7.j
    public void i(h7.h hVar, String str) {
        g7.k kVar;
        l7.b bVar = t.f3467i;
        t tVar = this.f3439o;
        int i10 = 1;
        bVar.b("onSessionStarted with transferType = %d", Integer.valueOf(tVar.f3472e));
        if (tVar.f3468a.B && tVar.f3472e == 2) {
            if (tVar.f3474h == null) {
                bVar.b("skip restoring session state due to null SessionState", new Object[0]);
            } else {
                i7.h a10 = tVar.a();
                if (a10 == null) {
                    bVar.b("skip restoring session state due to null RemoteMediaClient", new Object[0]);
                } else {
                    bVar.b("resume SessionState to current session", new Object[0]);
                    g7.r rVar = tVar.f3474h;
                    if (rVar != null && (kVar = rVar.f5288o) != null) {
                        i7.h.f6496k.b("resume SessionState", new Object[0]);
                        r7.r.b();
                        if (a10.x()) {
                            i7.h.y(new i7.j(a10, kVar, i10));
                        } else {
                            i7.h.u();
                        }
                    }
                }
            }
        }
        tVar.c();
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void k(h7.h hVar) {
    }

    @Override // i8.c
    public void l(Object obj) {
        t tVar = this.f3439o;
        tVar.f3474h = (g7.r) obj;
        r.i iVar = tVar.g;
        if (iVar != null) {
            iVar.a();
        }
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void m(h7.h hVar, int i10) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void n(h7.h hVar) {
    }

    @Override // i8.b
    public void w(Exception exc) {
        t tVar = this.f3439o;
        tVar.getClass();
        l7.b bVar = t.f3467i;
        Log.w(bVar.f8271a, bVar.d("Fail to store SessionState", new Object[0]), exc);
        tVar.b(100);
    }
}
