package com.google.android.gms.internal.cast;

import android.util.Log;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p5 implements h7.j {

    /* renamed from: p, reason: collision with root package name */
    public static final y4 f3424p = new y4(1);

    /* renamed from: o, reason: collision with root package name */
    public final Object f3425o;

    public p5(w0 w0Var) {
        this.f3425o = w0Var;
    }

    public void a(int i10, Object obj, d6 d6Var) {
        u4 u4Var = (u4) this.f3425o;
        u4Var.Y(i10, 3);
        d6Var.c((o4) obj, u4Var.f3491d);
        u4Var.Y(i10, 4);
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void b(h7.h hVar, int i10) {
        w0 w0Var = (w0) this.f3425o;
        w0Var.f3549h = (h7.d) hVar;
        w0.a(w0Var, i10);
    }

    public void c(int i10, Object obj, d6 d6Var) {
        o4 o4Var = (o4) obj;
        u4 u4Var = (u4) this.f3425o;
        u4Var.Z((i10 << 3) | 2);
        u4Var.Z(o4Var.a(d6Var));
        d6Var.c(o4Var, u4Var.f3491d);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c1  */
    @Override // h7.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(h7.h r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.p5.d(h7.h, java.lang.String):void");
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void f(h7.h hVar, int i10) {
        w0 w0Var = (w0) this.f3425o;
        w0Var.f3549h = (h7.d) hVar;
        w0.a(w0Var, i10);
    }

    @Override // h7.j
    public void g(h7.h hVar, boolean z10) {
        w0.f3542j.b("onSessionResumed with wasSuspended = %b", Boolean.valueOf(z10));
        w0 w0Var = (w0) this.f3425o;
        w0Var.f3549h = (h7.d) hVar;
        w0Var.c();
        r7.r.e(w0Var.g);
        m1 b2 = w0Var.f3545c.b(w0Var.g);
        h1 m10 = i1.m(b2.d());
        m10.c();
        i1.p((i1) m10.f3641p, z10);
        b2.c();
        n1.p((n1) b2.f3641p, (i1) m10.a());
        w0Var.f3543a.a((n1) b2.a(), 227);
        w0.b(w0Var);
        w0Var.e();
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void h(h7.h hVar, int i10) {
        w0 w0Var = (w0) this.f3425o;
        w0Var.f3549h = (h7.d) hVar;
        w0.a(w0Var, i10);
    }

    @Override // h7.j
    public void i(h7.h hVar, String str) {
        w0.f3542j.b("onSessionStarted with sessionId = %s", str);
        w0 w0Var = (w0) this.f3425o;
        w0Var.f3549h = (h7.d) hVar;
        w0Var.c();
        x0 x0Var = w0Var.g;
        x0Var.f3576f = str;
        w0Var.f3543a.a((n1) w0Var.f3545c.b(x0Var).a(), 222);
        w0.b(w0Var);
        w0Var.e();
    }

    @Override // h7.j
    public /* synthetic */ void k(h7.h hVar) {
        ((w0) this.f3425o).f3549h = (h7.d) hVar;
    }

    @Override // h7.j
    public void m(h7.h hVar, int i10) {
        w0.f3542j.b("onSessionSuspended with reason = %d", Integer.valueOf(i10));
        w0 w0Var = (w0) this.f3425o;
        w0Var.f3549h = (h7.d) hVar;
        w0Var.c();
        r7.r.e(w0Var.g);
        w0Var.f3543a.a(w0Var.f3545c.a(w0Var.g, i10), 225);
        w0.b(w0Var);
        w0Var.f3547e.removeCallbacks(w0Var.f3546d);
    }

    @Override // h7.j
    public void n(h7.h hVar) {
        l7.b bVar = w0.f3542j;
        bVar.b("onSessionStarting", new Object[0]);
        w0 w0Var = (w0) this.f3425o;
        w0Var.f3549h = (h7.d) hVar;
        if (w0Var.g != null) {
            Log.w(bVar.f8271a, bVar.d("Start a session while there's already an active session. Create a new one.", new Object[0]));
        }
        w0Var.d();
        y0 y0Var = w0Var.f3545c;
        x0 x0Var = w0Var.g;
        m1 b2 = y0Var.b(x0Var);
        if (x0Var.f3579j == 1) {
            h1 m10 = i1.m(b2.d());
            m10.c();
            i1.r((i1) m10.f3641p, 17);
            b2.e((i1) m10.a());
        }
        w0Var.f3543a.a((n1) b2.a(), 221);
    }

    public p5() {
        s5 s5Var;
        try {
            s5Var = (s5) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            s5Var = f3424p;
        }
        o5 o5Var = new o5(y4.f3601b, s5Var);
        Charset charset = g5.f3312a;
        this.f3425o = o5Var;
    }

    public p5(u4 u4Var) {
        Charset charset = g5.f3312a;
        this.f3425o = u4Var;
        u4Var.f3491d = this;
    }
}
