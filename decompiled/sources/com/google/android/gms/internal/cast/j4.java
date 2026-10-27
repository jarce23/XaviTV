package com.google.android.gms.internal.cast;

import android.text.TextUtils;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j4 implements h7.j {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ u5 f3345o;

    public /* synthetic */ j4(u5 u5Var) {
        this.f3345o = u5Var;
    }

    @Override // h7.j
    public void b(h7.h hVar, int i10) {
        c2.j1 j1Var = new c2.j1(5, 2);
        j1Var.f2626q = Integer.valueOf(i10);
        t6 t6Var = new t6(j1Var);
        u5 u5Var = this.f3345o;
        u5.e(u5Var, t6Var);
        u5Var.g();
    }

    @Override // h7.j
    public void d(h7.h hVar, String str) {
        t6 t6Var = new t6(new c2.j1(7, 2));
        u5 u5Var = this.f3345o;
        u5.e(u5Var, t6Var);
        s6 s6Var = (s6) u5Var.f3497r;
        r7.r.e(s6Var);
        s6Var.a((h7.d) hVar);
        s6 s6Var2 = (s6) u5Var.f3497r;
        r7.r.e(s6Var2);
        String str2 = s6Var2.f3464k;
        if (str2 == null) {
            s6Var2.f3464k = str;
        } else {
            if (TextUtils.equals(str, str2)) {
                return;
            }
            s6Var2.b(4);
        }
    }

    @Override // h7.j
    public void f(h7.h hVar, int i10) {
        c2.j1 j1Var = new c2.j1(8, 2);
        j1Var.f2626q = Integer.valueOf(i10);
        t6 t6Var = new t6(j1Var);
        u5 u5Var = this.f3345o;
        u5.e(u5Var, t6Var);
        u5Var.g();
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void g(h7.h hVar, boolean z10) {
        t6 t6Var = new t6(new c2.j1(4, 2));
        u5 u5Var = this.f3345o;
        u5.e(u5Var, t6Var);
        s6 s6Var = (s6) u5Var.f3497r;
        r7.r.e(s6Var);
        s6Var.a((h7.d) hVar);
    }

    @Override // h7.j
    public void h(h7.h hVar, int i10) {
        c2.j1 j1Var = new c2.j1(9, 2);
        j1Var.f2626q = Integer.valueOf(i10);
        u5 u5Var = this.f3345o;
        j1Var.f2627r = Boolean.valueOf(((c) u5Var.f3495p).f3277e == 2);
        u5.e(u5Var, new t6(j1Var));
        u5Var.g();
    }

    @Override // h7.j
    public void i(h7.h hVar, String str) {
        t6 t6Var = new t6(new c2.j1(4, 2));
        u5 u5Var = this.f3345o;
        u5.e(u5Var, t6Var);
        s6 s6Var = (s6) u5Var.f3497r;
        r7.r.e(s6Var);
        s6Var.a((h7.d) hVar);
        s6 s6Var2 = (s6) u5Var.f3497r;
        r7.r.e(s6Var2);
        String str2 = s6Var2.f3464k;
        if (str2 == null) {
            s6Var2.f3464k = str;
        } else {
            if (TextUtils.equals(str, str2)) {
                return;
            }
            s6Var2.b(4);
        }
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void k(h7.h hVar) {
    }

    @Override // h7.j
    public void m(h7.h hVar, int i10) {
        c2.j1 j1Var = new c2.j1(6, 2);
        j1Var.f2626q = Integer.valueOf(i10);
        t6 t6Var = new t6(j1Var);
        u5 u5Var = this.f3345o;
        u5.e(u5Var, t6Var);
        s6 s6Var = (s6) u5Var.f3497r;
        r7.r.e(s6Var);
        s6Var.a((h7.d) hVar);
    }

    @Override // h7.j
    public void n(h7.h hVar) {
        h7.d dVar = (h7.d) hVar;
        c2.j1 j1Var = new c2.j1(2, 2);
        u5 u5Var = this.f3345o;
        j1Var.f2627r = Boolean.valueOf(((c) u5Var.f3495p).f3277e == 2);
        u5.e(u5Var, new t6(j1Var));
        s6 s6Var = (s6) u5Var.f3497r;
        r7.r.e(s6Var);
        s6Var.a(dVar);
        dVar.f5735l = (j4) u5Var.f3498s;
    }
}
