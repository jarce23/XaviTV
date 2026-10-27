package r3;

import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u implements h {

    /* renamed from: e, reason: collision with root package name */
    public String f10691e;

    /* renamed from: f, reason: collision with root package name */
    public g0 f10692f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10694i;

    /* renamed from: k, reason: collision with root package name */
    public int f10696k;

    /* renamed from: l, reason: collision with root package name */
    public int f10697l;

    /* renamed from: n, reason: collision with root package name */
    public int f10699n;

    /* renamed from: o, reason: collision with root package name */
    public int f10700o;

    /* renamed from: s, reason: collision with root package name */
    public int f10704s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10706u;

    /* renamed from: d, reason: collision with root package name */
    public int f10690d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final l1.t f10687a = new l1.t(2, new byte[15]);

    /* renamed from: b, reason: collision with root package name */
    public final i3.f f10688b = new i3.f();

    /* renamed from: c, reason: collision with root package name */
    public final l1.t f10689c = new l1.t();

    /* renamed from: p, reason: collision with root package name */
    public final v f10701p = new v();

    /* renamed from: q, reason: collision with root package name */
    public int f10702q = -2147483647;

    /* renamed from: r, reason: collision with root package name */
    public int f10703r = -1;

    /* renamed from: t, reason: collision with root package name */
    public long f10705t = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10695j = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10698m = true;
    public double g = -9.223372036854776E18d;

    /* renamed from: h, reason: collision with root package name */
    public double f10693h = -9.223372036854776E18d;

    @Override // r3.h
    public final void a() {
        this.f10690d = 0;
        this.f10697l = 0;
        this.f10687a.F(2);
        this.f10699n = 0;
        this.f10700o = 0;
        this.f10702q = -2147483647;
        this.f10703r = -1;
        this.f10704s = 0;
        this.f10705t = -1L;
        this.f10706u = false;
        this.f10694i = false;
        this.f10698m = true;
        this.f10695j = true;
        this.g = -9.223372036854776E18d;
        this.f10693h = -9.223372036854776E18d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0486 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x046d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0420  */
    @Override // r3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(l1.t r25) {
        /*
            Method dump skipped, instructions count: 1376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.u.b(l1.t):void");
    }

    @Override // r3.h
    public final void d(int i10, long j10) {
        this.f10696k = i10;
        if (!this.f10695j && (this.f10700o != 0 || !this.f10698m)) {
            this.f10694i = true;
        }
        if (j10 != -9223372036854775807L) {
            if (this.f10694i) {
                this.f10693h = j10;
            } else {
                this.g = j10;
            }
        }
    }

    @Override // r3.h
    public final void e(k2.p pVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f10691e = e0Var.f10512e;
        e0Var.b();
        this.f10692f = pVar.q(e0Var.f10511d, 1);
    }

    @Override // r3.h
    public final void c(boolean z10) {
    }
}
