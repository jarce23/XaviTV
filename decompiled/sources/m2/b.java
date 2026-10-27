package m2;

import i2.j;
import j9.v1;
import java.util.List;
import k2.n;
import k2.o;
import k2.p;
import l1.a0;
import l1.t;
import o9.e0;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements n {

    /* renamed from: a, reason: collision with root package name */
    public final t f8821a;

    /* renamed from: b, reason: collision with root package name */
    public final j f8822b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8823c;

    /* renamed from: d, reason: collision with root package name */
    public final d9.f f8824d;

    /* renamed from: e, reason: collision with root package name */
    public int f8825e;

    /* renamed from: f, reason: collision with root package name */
    public p f8826f;
    public c g;

    /* renamed from: h, reason: collision with root package name */
    public long f8827h;

    /* renamed from: i, reason: collision with root package name */
    public e[] f8828i;

    /* renamed from: j, reason: collision with root package name */
    public long f8829j;

    /* renamed from: k, reason: collision with root package name */
    public e f8830k;

    /* renamed from: l, reason: collision with root package name */
    public int f8831l;

    /* renamed from: m, reason: collision with root package name */
    public long f8832m;

    /* renamed from: n, reason: collision with root package name */
    public long f8833n;

    /* renamed from: o, reason: collision with root package name */
    public int f8834o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8835p;

    public b(int i10, d9.f fVar) {
        this.f8824d = fVar;
        this.f8823c = (i10 & 1) == 0;
        this.f8821a = new t(12);
        this.f8822b = new j();
        this.f8826f = new v1(2);
        this.f8828i = new e[0];
        this.f8832m = -1L;
        this.f8833n = -1L;
        this.f8831l = -1;
        this.f8827h = -9223372036854775807L;
    }

    @Override // k2.n
    public final void c(p pVar) {
        this.f8825e = 0;
        if (this.f8823c) {
            pVar = new c4.e(pVar, this.f8824d);
        }
        this.f8826f = pVar;
        this.f8829j = -1L;
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        this.f8829j = -1L;
        this.f8830k = null;
        for (e eVar : this.f8828i) {
            if (eVar.f8854k == 0) {
                eVar.f8852i = 0;
            } else {
                eVar.f8852i = eVar.f8857n[a0.e(eVar.f8856m, j10, true)];
            }
        }
        if (j10 != 0) {
            this.f8825e = 6;
        } else if (this.f8828i.length == 0) {
            this.f8825e = 0;
        } else {
            this.f8825e = 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010d  */
    @Override // k2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(k2.o r24, i1.s r25) {
        /*
            Method dump skipped, instructions count: 1102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.b.f(k2.o, i1.s):int");
    }

    @Override // k2.n
    public final List g() {
        e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(o oVar) {
        t tVar = this.f8821a;
        oVar.o(tVar.f8129a, 0, 12);
        tVar.I(0);
        if (tVar.l() == 1179011410) {
            tVar.J(4);
            if (tVar.l() == 541677121) {
                return true;
            }
        }
        return false;
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final n b() {
        return this;
    }
}
