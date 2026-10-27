package r3;

import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t implements h {

    /* renamed from: a, reason: collision with root package name */
    public final l1.t f10674a;

    /* renamed from: b, reason: collision with root package name */
    public final k2.y f10675b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10676c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10677d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10678e;

    /* renamed from: f, reason: collision with root package name */
    public g0 f10679f;
    public String g;

    /* renamed from: h, reason: collision with root package name */
    public int f10680h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f10681i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10682j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10683k;

    /* renamed from: l, reason: collision with root package name */
    public long f10684l;

    /* renamed from: m, reason: collision with root package name */
    public int f10685m;

    /* renamed from: n, reason: collision with root package name */
    public long f10686n;

    public t(String str, int i10, String str2) {
        l1.t tVar = new l1.t(4);
        this.f10674a = tVar;
        tVar.f8129a[0] = -1;
        this.f10675b = new k2.y();
        this.f10686n = -9223372036854775807L;
        this.f10676c = str;
        this.f10677d = i10;
        this.f10678e = str2;
    }

    @Override // r3.h
    public final void a() {
        this.f10680h = 0;
        this.f10681i = 0;
        this.f10683k = false;
        this.f10686n = -9223372036854775807L;
    }

    @Override // r3.h
    public final void b(l1.t tVar) {
        l1.d.h(this.f10679f);
        while (tVar.a() > 0) {
            int i10 = this.f10680h;
            l1.t tVar2 = this.f10674a;
            if (i10 == 0) {
                byte[] bArr = tVar.f8129a;
                int i11 = tVar.f8130b;
                int i12 = tVar.f8131c;
                while (true) {
                    if (i11 >= i12) {
                        tVar.I(i12);
                        break;
                    }
                    byte b2 = bArr[i11];
                    boolean z10 = (b2 & 255) == 255;
                    boolean z11 = this.f10683k && (b2 & 224) == 224;
                    this.f10683k = z10;
                    if (z11) {
                        tVar.I(i11 + 1);
                        this.f10683k = false;
                        tVar2.f8129a[1] = bArr[i11];
                        this.f10681i = 2;
                        this.f10680h = 1;
                        break;
                    }
                    i11++;
                }
            } else if (i10 == 1) {
                int min = Math.min(tVar.a(), 4 - this.f10681i);
                tVar.h(tVar2.f8129a, this.f10681i, min);
                int i13 = this.f10681i + min;
                this.f10681i = i13;
                if (i13 >= 4) {
                    tVar2.I(0);
                    int j10 = tVar2.j();
                    k2.y yVar = this.f10675b;
                    if (yVar.a(j10)) {
                        this.f10685m = yVar.f7802b;
                        if (!this.f10682j) {
                            this.f10684l = (yVar.f7806f * 1000000) / yVar.f7803c;
                            i1.o oVar = new i1.o();
                            oVar.f5929a = this.g;
                            oVar.f5939l = i1.g0.m(this.f10678e);
                            oVar.f5940m = i1.g0.m((String) yVar.g);
                            oVar.f5941n = 4096;
                            oVar.E = yVar.f7804d;
                            oVar.F = yVar.f7803c;
                            oVar.f5932d = this.f10676c;
                            oVar.f5934f = this.f10677d;
                            this.f10679f.a(new i1.p(oVar));
                            this.f10682j = true;
                        }
                        tVar2.I(0);
                        this.f10679f.c(4, tVar2);
                        this.f10680h = 2;
                    } else {
                        this.f10681i = 0;
                        this.f10680h = 1;
                    }
                }
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException();
                }
                int min2 = Math.min(tVar.a(), this.f10685m - this.f10681i);
                this.f10679f.c(min2, tVar);
                int i14 = this.f10681i + min2;
                this.f10681i = i14;
                if (i14 >= this.f10685m) {
                    l1.d.g(this.f10686n != -9223372036854775807L);
                    this.f10679f.e(this.f10686n, 1, this.f10685m, 0, null);
                    this.f10686n += this.f10684l;
                    this.f10681i = 0;
                    this.f10680h = 0;
                }
            }
        }
    }

    @Override // r3.h
    public final void d(int i10, long j10) {
        this.f10686n = j10;
    }

    @Override // r3.h
    public final void e(k2.p pVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.g = e0Var.f10512e;
        e0Var.b();
        this.f10679f = pVar.q(e0Var.f10511d, 1);
    }

    @Override // r3.h
    public final void c(boolean z10) {
    }
}
