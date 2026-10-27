package r3;

import java.util.Collections;
import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements h {

    /* renamed from: a, reason: collision with root package name */
    public final x4.m f10640a;

    /* renamed from: b, reason: collision with root package name */
    public String f10641b;

    /* renamed from: c, reason: collision with root package name */
    public g0 f10642c;

    /* renamed from: d, reason: collision with root package name */
    public q f10643d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10644e;

    /* renamed from: l, reason: collision with root package name */
    public long f10650l;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f10645f = new boolean[3];
    public final b4.u g = new b4.u(32);

    /* renamed from: h, reason: collision with root package name */
    public final b4.u f10646h = new b4.u(33);

    /* renamed from: i, reason: collision with root package name */
    public final b4.u f10647i = new b4.u(34);

    /* renamed from: j, reason: collision with root package name */
    public final b4.u f10648j = new b4.u(39);

    /* renamed from: k, reason: collision with root package name */
    public final b4.u f10649k = new b4.u(40);

    /* renamed from: m, reason: collision with root package name */
    public long f10651m = -9223372036854775807L;

    /* renamed from: n, reason: collision with root package name */
    public final l1.t f10652n = new l1.t();

    public r(x4.m mVar) {
        this.f10640a = mVar;
    }

    @Override // r3.h
    public final void a() {
        this.f10650l = 0L;
        this.f10651m = -9223372036854775807L;
        m1.o.a(this.f10645f);
        this.g.g();
        this.f10646h.g();
        this.f10647i.g();
        this.f10648j.g();
        this.f10649k.g();
        ((b4.b) this.f10640a.f13566r).i(0);
        q qVar = this.f10643d;
        if (qVar != null) {
            qVar.f10633f = false;
            qVar.g = false;
            qVar.f10634h = false;
            qVar.f10635i = false;
            qVar.f10636j = false;
        }
    }

    @Override // r3.h
    public final void b(l1.t tVar) {
        int i10;
        l1.d.h(this.f10642c);
        int i11 = l1.a0.f8067a;
        while (tVar.a() > 0) {
            int i12 = tVar.f8130b;
            int i13 = tVar.f8131c;
            byte[] bArr = tVar.f8129a;
            this.f10650l += tVar.a();
            this.f10642c.c(tVar.a(), tVar);
            while (i12 < i13) {
                int b2 = m1.o.b(bArr, i12, i13, this.f10645f);
                if (b2 == i13) {
                    g(bArr, i12, i13);
                    return;
                }
                int i14 = (bArr[b2 + 3] & 126) >> 1;
                if (b2 <= 0 || bArr[b2 - 1] != 0) {
                    i10 = 3;
                } else {
                    b2--;
                    i10 = 4;
                }
                int i15 = b2;
                int i16 = i10;
                int i17 = i15 - i12;
                if (i17 > 0) {
                    g(bArr, i12, i15);
                }
                int i18 = i13 - i15;
                long j10 = this.f10650l - i18;
                f(i18, i17 < 0 ? -i17 : 0, j10, this.f10651m);
                h(i18, i14, j10, this.f10651m);
                i12 = i15 + i16;
            }
        }
    }

    @Override // r3.h
    public final void c(boolean z10) {
        l1.d.h(this.f10642c);
        int i10 = l1.a0.f8067a;
        if (z10) {
            ((b4.b) this.f10640a.f13566r).i(0);
            f(0, 0, this.f10650l, this.f10651m);
            h(0, 48, this.f10650l, this.f10651m);
        }
    }

    @Override // r3.h
    public final void d(int i10, long j10) {
        this.f10651m = j10;
    }

    @Override // r3.h
    public final void e(k2.p pVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f10641b = e0Var.f10512e;
        e0Var.b();
        g0 q10 = pVar.q(e0Var.f10511d, 2);
        this.f10642c = q10;
        this.f10643d = new q(q10);
        this.f10640a.v(pVar, e0Var);
    }

    public final void f(int i10, int i11, long j10, long j11) {
        b4.b bVar = (b4.b) this.f10640a.f13566r;
        q qVar = this.f10643d;
        boolean z10 = this.f10644e;
        if (qVar.f10636j && qVar.g) {
            qVar.f10639m = qVar.f10630c;
            qVar.f10636j = false;
        } else if (qVar.f10634h || qVar.g) {
            if (z10 && qVar.f10635i) {
                qVar.a(i10 + ((int) (j10 - qVar.f10629b)));
            }
            qVar.f10637k = qVar.f10629b;
            qVar.f10638l = qVar.f10632e;
            qVar.f10639m = qVar.f10630c;
            qVar.f10635i = true;
        }
        if (!this.f10644e) {
            b4.u uVar = this.g;
            uVar.e(i11);
            b4.u uVar2 = this.f10646h;
            uVar2.e(i11);
            b4.u uVar3 = this.f10647i;
            uVar3.e(i11);
            if (uVar.f2420d && uVar2.f2420d && uVar3.f2420d) {
                String str = this.f10641b;
                int i12 = uVar.f2421e;
                byte[] bArr = new byte[uVar2.f2421e + i12 + uVar3.f2421e];
                System.arraycopy((byte[]) uVar.f2422f, 0, bArr, 0, i12);
                System.arraycopy((byte[]) uVar2.f2422f, 0, bArr, uVar.f2421e, uVar2.f2421e);
                System.arraycopy((byte[]) uVar3.f2422f, 0, bArr, uVar.f2421e + uVar2.f2421e, uVar3.f2421e);
                m1.k h10 = m1.o.h((byte[]) uVar2.f2422f, 3, uVar2.f2421e, null);
                m1.i iVar = h10.f8779b;
                String a10 = iVar != null ? l1.e.a(iVar.f8767a, iVar.f8768b, iVar.f8769c, iVar.f8770d, iVar.f8771e, iVar.f8772f) : null;
                i1.o oVar = new i1.o();
                oVar.f5929a = str;
                oVar.f5939l = i1.g0.m("video/mp2t");
                oVar.f5940m = i1.g0.m("video/hevc");
                oVar.f5937j = a10;
                oVar.f5947t = h10.f8782e;
                oVar.f5948u = h10.f8783f;
                oVar.f5949v = h10.g;
                oVar.f5950w = h10.f8784h;
                oVar.C = new i1.g(h10.f8787k, h10.f8788l, h10.f8789m, null, h10.f8780c + 8, h10.f8781d + 8);
                oVar.f5953z = h10.f8785i;
                oVar.f5942o = h10.f8786j;
                oVar.D = h10.f8778a + 1;
                oVar.f5943p = Collections.singletonList(bArr);
                i1.p pVar = new i1.p(oVar);
                this.f10642c.a(pVar);
                int i13 = pVar.f5993p;
                if (i13 == -1) {
                    throw new IllegalStateException();
                }
                bVar.v(i13);
                this.f10644e = true;
            }
        }
        b4.u uVar4 = this.f10648j;
        boolean e7 = uVar4.e(i11);
        l1.t tVar = this.f10652n;
        if (e7) {
            tVar.G(m1.o.m(uVar4.f2421e, (byte[]) uVar4.f2422f), (byte[]) uVar4.f2422f);
            tVar.J(5);
            bVar.a(j11, tVar);
        }
        b4.u uVar5 = this.f10649k;
        if (uVar5.e(i11)) {
            tVar.G(m1.o.m(uVar5.f2421e, (byte[]) uVar5.f2422f), (byte[]) uVar5.f2422f);
            tVar.J(5);
            bVar.a(j11, tVar);
        }
    }

    public final void g(byte[] bArr, int i10, int i11) {
        q qVar = this.f10643d;
        if (qVar.f10633f) {
            int i12 = qVar.f10631d;
            int i13 = (i10 + 2) - i12;
            if (i13 < i11) {
                qVar.g = (bArr[i13] & 128) != 0;
                qVar.f10633f = false;
            } else {
                qVar.f10631d = (i11 - i10) + i12;
            }
        }
        if (!this.f10644e) {
            this.g.a(bArr, i10, i11);
            this.f10646h.a(bArr, i10, i11);
            this.f10647i.a(bArr, i10, i11);
        }
        this.f10648j.a(bArr, i10, i11);
        this.f10649k.a(bArr, i10, i11);
    }

    public final void h(int i10, int i11, long j10, long j11) {
        q qVar = this.f10643d;
        boolean z10 = this.f10644e;
        qVar.g = false;
        qVar.f10634h = false;
        qVar.f10632e = j11;
        qVar.f10631d = 0;
        qVar.f10629b = j10;
        if (i11 >= 32 && i11 != 40) {
            if (qVar.f10635i && !qVar.f10636j) {
                if (z10) {
                    qVar.a(i10);
                }
                qVar.f10635i = false;
            }
            if ((32 <= i11 && i11 <= 35) || i11 == 39) {
                qVar.f10634h = !qVar.f10636j;
                qVar.f10636j = true;
            }
        }
        boolean z11 = i11 >= 16 && i11 <= 21;
        qVar.f10630c = z11;
        qVar.f10633f = z11 || i11 <= 9;
        if (!this.f10644e) {
            this.g.h(i11);
            this.f10646h.h(i11);
            this.f10647i.h(i11);
        }
        this.f10648j.h(i11);
        this.f10649k.h(i11);
    }
}
