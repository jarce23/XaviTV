package r3;

import java.util.List;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements k2.n {

    /* renamed from: c, reason: collision with root package name */
    public final l1.t f10477c;

    /* renamed from: d, reason: collision with root package name */
    public final i3.f f10478d;

    /* renamed from: e, reason: collision with root package name */
    public k2.p f10479e;

    /* renamed from: f, reason: collision with root package name */
    public long f10480f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10481h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10482i;

    /* renamed from: a, reason: collision with root package name */
    public final e f10475a = new e(0, null, "audio/mp4a-latm", true);

    /* renamed from: b, reason: collision with root package name */
    public final l1.t f10476b = new l1.t(2048);
    public long g = -1;

    public d(int i10) {
        l1.t tVar = new l1.t(10);
        this.f10477c = tVar;
        byte[] bArr = tVar.f8129a;
        this.f10478d = new i3.f(bArr.length, bArr);
    }

    @Override // k2.n
    public final void c(k2.p pVar) {
        this.f10479e = pVar;
        this.f10475a.e(pVar, new e0(0, 1));
        pVar.f();
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        this.f10481h = false;
        this.f10475a.a();
        this.f10480f = j11;
    }

    @Override // k2.n
    public final int f(k2.o oVar, i1.s sVar) {
        l1.d.h(this.f10479e);
        oVar.c();
        l1.t tVar = this.f10476b;
        int read = oVar.read(tVar.f8129a, 0, 2048);
        boolean z10 = read == -1;
        if (!this.f10482i) {
            this.f10479e.t(new k2.r(-9223372036854775807L));
            this.f10482i = true;
        }
        if (z10) {
            return -1;
        }
        tVar.I(0);
        tVar.H(read);
        boolean z11 = this.f10481h;
        e eVar = this.f10475a;
        if (!z11) {
            eVar.f10505u = this.f10480f;
            this.f10481h = true;
        }
        eVar.b(tVar);
        return 0;
    }

    @Override // k2.n
    public final List g() {
        o9.e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(k2.o oVar) {
        int i10 = 0;
        while (true) {
            l1.t tVar = this.f10477c;
            oVar.o(tVar.f8129a, 0, 10);
            tVar.I(0);
            if (tVar.z() != 4801587) {
                break;
            }
            tVar.J(3);
            int v10 = tVar.v();
            i10 += v10 + 10;
            oVar.p(v10);
        }
        oVar.h();
        oVar.p(i10);
        if (this.g == -1) {
            this.g = i10;
        }
        int i11 = i10;
        int i12 = 0;
        int i13 = 0;
        do {
            l1.t tVar2 = this.f10477c;
            k2.k kVar = (k2.k) oVar;
            kVar.m(tVar2.f8129a, 0, 2, false);
            tVar2.I(0);
            if ((tVar2.C() & 65526) == 65520) {
                i12++;
                if (i12 >= 4 && i13 > 188) {
                    return true;
                }
                kVar.m(tVar2.f8129a, 0, 4, false);
                i3.f fVar = this.f10478d;
                fVar.q(14);
                int i14 = fVar.i(13);
                if (i14 <= 6) {
                    i11++;
                    kVar.f7755t = 0;
                    kVar.f(i11, false);
                } else {
                    kVar.f(i14 - 6, false);
                    i13 += i14;
                }
            } else {
                i11++;
                kVar.f7755t = 0;
                kVar.f(i11, false);
            }
            i12 = 0;
            i13 = 0;
        } while (i11 - i10 < 8192);
        return false;
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final k2.n b() {
        return this;
    }
}
