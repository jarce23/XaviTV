package e3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import k2.a0;
import k2.h0;
import o9.e0;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements k2.n, a0 {
    public l[] A;
    public long[][] B;
    public int C;
    public long D;
    public int E;
    public z2.a F;

    /* renamed from: a, reason: collision with root package name */
    public final h3.i f4482a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4483b;

    /* renamed from: c, reason: collision with root package name */
    public final l1.t f4484c;

    /* renamed from: d, reason: collision with root package name */
    public final l1.t f4485d;

    /* renamed from: e, reason: collision with root package name */
    public final l1.t f4486e;

    /* renamed from: f, reason: collision with root package name */
    public final l1.t f4487f;
    public final ArrayDeque g;

    /* renamed from: h, reason: collision with root package name */
    public final o f4488h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f4489i;

    /* renamed from: j, reason: collision with root package name */
    public w0 f4490j;

    /* renamed from: k, reason: collision with root package name */
    public int f4491k;

    /* renamed from: l, reason: collision with root package name */
    public int f4492l;

    /* renamed from: m, reason: collision with root package name */
    public long f4493m;

    /* renamed from: n, reason: collision with root package name */
    public int f4494n;

    /* renamed from: o, reason: collision with root package name */
    public l1.t f4495o;

    /* renamed from: p, reason: collision with root package name */
    public int f4496p;

    /* renamed from: q, reason: collision with root package name */
    public int f4497q;

    /* renamed from: r, reason: collision with root package name */
    public int f4498r;

    /* renamed from: s, reason: collision with root package name */
    public int f4499s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4500t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4501u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4502v;

    /* renamed from: w, reason: collision with root package name */
    public long f4503w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f4504x;

    /* renamed from: y, reason: collision with root package name */
    public long f4505y;

    /* renamed from: z, reason: collision with root package name */
    public k2.p f4506z;

    public m(h3.i iVar, int i10) {
        this.f4482a = iVar;
        this.f4483b = i10;
        e0 e0Var = g0.f9617p;
        this.f4490j = w0.f9686s;
        this.f4491k = (i10 & 4) != 0 ? 3 : 0;
        this.f4488h = new o();
        this.f4489i = new ArrayList();
        this.f4487f = new l1.t(16);
        this.g = new ArrayDeque();
        this.f4484c = new l1.t(m1.o.f8813a);
        this.f4485d = new l1.t(6);
        this.f4486e = new l1.t();
        this.f4496p = -1;
        this.f4506z = k2.p.f7764e;
        this.A = new l[0];
    }

    @Override // k2.n
    public final void c(k2.p pVar) {
        if ((this.f4483b & 16) == 0) {
            pVar = new c4.e(pVar, this.f4482a);
        }
        this.f4506z = pVar;
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        this.g.clear();
        this.f4494n = 0;
        this.f4496p = -1;
        this.f4497q = 0;
        this.f4498r = 0;
        this.f4499s = 0;
        this.f4500t = false;
        if (j10 == 0) {
            if (this.f4491k != 3) {
                this.f4491k = 0;
                this.f4494n = 0;
                return;
            } else {
                o oVar = this.f4488h;
                oVar.f4511a.clear();
                oVar.f4512b = 0;
                this.f4489i.clear();
                return;
            }
        }
        for (l lVar : this.A) {
            t tVar = lVar.f4478b;
            int e7 = l1.a0.e(tVar.f4552f, j11, false);
            while (true) {
                if (e7 < 0) {
                    e7 = -1;
                    break;
                } else if ((tVar.g[e7] & 1) != 0) {
                    break;
                } else {
                    e7--;
                }
            }
            if (e7 == -1) {
                e7 = tVar.a(j11);
            }
            lVar.f4481e = e7;
            h0 h0Var = lVar.f4480d;
            if (h0Var != null) {
                h0Var.f7735b = false;
                h0Var.f7736c = 0;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x052a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x070c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0006 A[SYNTHETIC] */
    @Override // k2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(k2.o r40, i1.s r41) {
        /*
            Method dump skipped, instructions count: 1850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.m.f(k2.o, i1.s):int");
    }

    @Override // k2.n
    public final List g() {
        return this.f4490j;
    }

    @Override // k2.a0
    public final boolean h() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4 A[EDGE_INSN: B:70:0x00e4->B:71:0x00e4 BREAK  A[LOOP:1: B:29:0x006b->B:58:0x00e0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f8  */
    @Override // k2.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k2.z j(long r21) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.m.j(long):k2.z");
    }

    @Override // k2.a0
    public final long l() {
        return this.D;
    }

    @Override // k2.n
    public final boolean m(k2.o oVar) {
        w0 w0Var;
        k2.e0 k10 = p.k(oVar, false, (this.f4483b & 2) != 0);
        if (k10 != null) {
            w0Var = g0.r(k10);
        } else {
            e0 e0Var = g0.f9617p;
            w0Var = w0.f9686s;
        }
        this.f4490j = w0Var;
        return k10 == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0002 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(long r34) {
        /*
            Method dump skipped, instructions count: 797
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.m.n(long):void");
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final k2.n b() {
        return this;
    }
}
