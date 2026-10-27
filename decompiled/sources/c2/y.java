package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y extends p1 {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f2764l;

    /* renamed from: m, reason: collision with root package name */
    public final i1.s0 f2765m;

    /* renamed from: n, reason: collision with root package name */
    public final i1.r0 f2766n;

    /* renamed from: o, reason: collision with root package name */
    public w f2767o;

    /* renamed from: p, reason: collision with root package name */
    public v f2768p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2769q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2770r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2771s;

    public y(a aVar, boolean z10) {
        super(aVar);
        this.f2764l = z10 && aVar.h();
        this.f2765m = new i1.s0();
        this.f2766n = new i1.r0();
        i1.t0 f10 = aVar.f();
        if (f10 == null) {
            this.f2767o = new w(new x(aVar.g()), i1.s0.f6019q, w.f2743e);
        } else {
            this.f2767o = new w(f10, null, null);
            this.f2771s = true;
        }
    }

    @Override // c2.p1
    public final void A() {
        if (this.f2764l) {
            return;
        }
        this.f2769q = true;
        z();
    }

    @Override // c2.a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final v a(d0 d0Var, g2.e eVar, long j10) {
        v vVar = new v(d0Var, eVar, j10);
        l1.d.g(vVar.f2739r == null);
        vVar.f2739r = this.f2679k;
        if (!this.f2770r) {
            this.f2768p = vVar;
            if (!this.f2769q) {
                this.f2769q = true;
                z();
            }
            return vVar;
        }
        Object obj = d0Var.f2539a;
        if (this.f2767o.f2745d != null && obj.equals(w.f2743e)) {
            obj = this.f2767o.f2745d;
        }
        vVar.d(d0Var.a(obj));
        return vVar;
    }

    public final boolean C(long j10) {
        v vVar = this.f2768p;
        int b2 = this.f2767o.b(vVar.f2736o.f2539a);
        if (b2 == -1) {
            return false;
        }
        w wVar = this.f2767o;
        i1.r0 r0Var = this.f2766n;
        wVar.f(b2, r0Var, false);
        long j11 = r0Var.f6015d;
        if (j11 != -9223372036854775807L && j10 >= j11) {
            j10 = Math.max(0L, j11 - 1);
        }
        vVar.f2742u = j10;
        return true;
    }

    @Override // c2.a
    public final void m(b0 b0Var) {
        v vVar = (v) b0Var;
        if (vVar.f2740s != null) {
            a aVar = vVar.f2739r;
            aVar.getClass();
            aVar.m(vVar.f2740s);
        }
        if (b0Var == this.f2768p) {
            this.f2768p = null;
        }
    }

    @Override // c2.l, c2.a
    public final void o() {
        this.f2770r = false;
        this.f2769q = false;
        super.o();
    }

    @Override // c2.p1, c2.a
    public final void r(i1.a0 a0Var) {
        if (this.f2771s) {
            w wVar = this.f2767o;
            this.f2767o = new w(new m1(this.f2767o.f2707b, a0Var), wVar.f2744c, wVar.f2745d);
        } else {
            this.f2767o = new w(new x(a0Var), i1.s0.f6019q, w.f2743e);
        }
        this.f2679k.r(a0Var);
    }

    @Override // c2.p1
    public final d0 x(d0 d0Var) {
        Object obj = d0Var.f2539a;
        Object obj2 = this.f2767o.f2745d;
        if (obj2 != null && obj2.equals(obj)) {
            obj = w.f2743e;
        }
        return d0Var.a(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00cc  */
    @Override // c2.p1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(i1.t0 r12) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.y.y(i1.t0):void");
    }
}
