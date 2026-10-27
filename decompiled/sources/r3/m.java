package r3;

import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements h {

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f10570l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final android.support.v4.media.session.a0 f10571a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.t f10572b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean[] f10573c = new boolean[4];

    /* renamed from: d, reason: collision with root package name */
    public final k f10574d;

    /* renamed from: e, reason: collision with root package name */
    public final b4.u f10575e;

    /* renamed from: f, reason: collision with root package name */
    public l f10576f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public String f10577h;

    /* renamed from: i, reason: collision with root package name */
    public g0 f10578i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10579j;

    /* renamed from: k, reason: collision with root package name */
    public long f10580k;

    public m(android.support.v4.media.session.a0 a0Var) {
        this.f10571a = a0Var;
        k kVar = new k();
        kVar.f10562e = new byte[128];
        this.f10574d = kVar;
        this.f10580k = -9223372036854775807L;
        this.f10575e = new b4.u(178);
        this.f10572b = new l1.t();
    }

    @Override // r3.h
    public final void a() {
        m1.o.a(this.f10573c);
        k kVar = this.f10574d;
        kVar.f10558a = false;
        kVar.f10560c = 0;
        kVar.f10559b = 0;
        l lVar = this.f10576f;
        if (lVar != null) {
            lVar.f10564b = false;
            lVar.f10565c = false;
            lVar.f10566d = false;
            lVar.f10567e = -1;
        }
        b4.u uVar = this.f10575e;
        if (uVar != null) {
            uVar.g();
        }
        this.g = 0L;
        this.f10580k = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013d  */
    @Override // r3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(l1.t r20) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.m.b(l1.t):void");
    }

    @Override // r3.h
    public final void c(boolean z10) {
        l1.d.h(this.f10576f);
        if (z10) {
            this.f10576f.b(0, this.g, this.f10579j);
            l lVar = this.f10576f;
            lVar.f10564b = false;
            lVar.f10565c = false;
            lVar.f10566d = false;
            lVar.f10567e = -1;
        }
    }

    @Override // r3.h
    public final void d(int i10, long j10) {
        this.f10580k = j10;
    }

    @Override // r3.h
    public final void e(k2.p pVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f10577h = e0Var.f10512e;
        e0Var.b();
        g0 q10 = pVar.q(e0Var.f10511d, 2);
        this.f10578i = q10;
        this.f10576f = new l(q10);
        this.f10571a.D(pVar, e0Var);
    }
}
