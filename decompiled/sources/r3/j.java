package r3;

import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: r, reason: collision with root package name */
    public static final double[] f10540r = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    public String f10541a;

    /* renamed from: b, reason: collision with root package name */
    public g0 f10542b;

    /* renamed from: c, reason: collision with root package name */
    public final android.support.v4.media.session.a0 f10543c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10544d;

    /* renamed from: e, reason: collision with root package name */
    public final l1.t f10545e;

    /* renamed from: f, reason: collision with root package name */
    public final b4.u f10546f;
    public final boolean[] g = new boolean[4];

    /* renamed from: h, reason: collision with root package name */
    public final i f10547h;

    /* renamed from: i, reason: collision with root package name */
    public long f10548i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10549j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10550k;

    /* renamed from: l, reason: collision with root package name */
    public long f10551l;

    /* renamed from: m, reason: collision with root package name */
    public long f10552m;

    /* renamed from: n, reason: collision with root package name */
    public long f10553n;

    /* renamed from: o, reason: collision with root package name */
    public long f10554o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10555p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10556q;

    public j(android.support.v4.media.session.a0 a0Var, String str) {
        this.f10543c = a0Var;
        this.f10544d = str;
        i iVar = new i();
        iVar.f10539d = new byte[128];
        this.f10547h = iVar;
        if (a0Var != null) {
            this.f10546f = new b4.u(178);
            this.f10545e = new l1.t();
        } else {
            this.f10546f = null;
            this.f10545e = null;
        }
        this.f10552m = -9223372036854775807L;
        this.f10554o = -9223372036854775807L;
    }

    @Override // r3.h
    public final void a() {
        m1.o.a(this.g);
        i iVar = this.f10547h;
        iVar.f10536a = false;
        iVar.f10537b = 0;
        iVar.f10538c = 0;
        b4.u uVar = this.f10546f;
        if (uVar != null) {
            uVar.g();
        }
        this.f10548i = 0L;
        this.f10549j = false;
        this.f10552m = -9223372036854775807L;
        this.f10554o = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e9  */
    @Override // r3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(l1.t r23) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.j.b(l1.t):void");
    }

    @Override // r3.h
    public final void c(boolean z10) {
        l1.d.h(this.f10542b);
        if (z10) {
            boolean z11 = this.f10555p;
            this.f10542b.e(this.f10554o, z11 ? 1 : 0, (int) (this.f10548i - this.f10553n), 0, null);
        }
    }

    @Override // r3.h
    public final void d(int i10, long j10) {
        this.f10552m = j10;
    }

    @Override // r3.h
    public final void e(k2.p pVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f10541a = e0Var.f10512e;
        e0Var.b();
        this.f10542b = pVar.q(e0Var.f10511d, 2);
        android.support.v4.media.session.a0 a0Var = this.f10543c;
        if (a0Var != null) {
            a0Var.D(pVar, e0Var);
        }
    }
}
