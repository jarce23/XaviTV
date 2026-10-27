package r3;

import java.util.List;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements k2.n {

    /* renamed from: a, reason: collision with root package name */
    public final b f10430a = new b("audio/ac3");

    /* renamed from: b, reason: collision with root package name */
    public final l1.t f10431b = new l1.t(2786);

    /* renamed from: c, reason: collision with root package name */
    public boolean f10432c;

    @Override // k2.n
    public final void c(k2.p pVar) {
        this.f10430a.e(pVar, new e0(0, 1));
        pVar.f();
        pVar.t(new k2.r(-9223372036854775807L));
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        this.f10432c = false;
        this.f10430a.a();
    }

    @Override // k2.n
    public final int f(k2.o oVar, i1.s sVar) {
        l1.t tVar = this.f10431b;
        int read = oVar.read(tVar.f8129a, 0, 2786);
        if (read == -1) {
            return -1;
        }
        tVar.I(0);
        tVar.H(read);
        boolean z10 = this.f10432c;
        b bVar = this.f10430a;
        if (!z10) {
            bVar.f10446o = 0L;
            this.f10432c = true;
        }
        bVar.b(tVar);
        return 0;
    }

    @Override // k2.n
    public final List g() {
        o9.e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(k2.o oVar) {
        k2.k kVar;
        int f10;
        l1.t tVar = new l1.t(10);
        int i10 = 0;
        while (true) {
            kVar = (k2.k) oVar;
            kVar.m(tVar.f8129a, 0, 10, false);
            tVar.I(0);
            if (tVar.z() != 4801587) {
                break;
            }
            tVar.J(3);
            int v10 = tVar.v();
            i10 += v10 + 10;
            kVar.f(v10, false);
        }
        kVar.f7755t = 0;
        kVar.f(i10, false);
        int i11 = 0;
        int i12 = i10;
        while (true) {
            kVar.m(tVar.f8129a, 0, 6, false);
            tVar.I(0);
            if (tVar.C() != 2935) {
                kVar.f7755t = 0;
                i12++;
                if (i12 - i10 >= 8192) {
                    break;
                }
                kVar.f(i12, false);
                i11 = 0;
            } else {
                i11++;
                if (i11 >= 4) {
                    return true;
                }
                byte[] bArr = tVar.f8129a;
                if (bArr.length < 6) {
                    f10 = -1;
                } else if (((bArr[5] & 248) >> 3) > 10) {
                    f10 = ((((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1) * 2;
                } else {
                    byte b2 = bArr[4];
                    f10 = k2.b.f((b2 & 192) >> 6, b2 & 63);
                }
                if (f10 == -1) {
                    break;
                }
                kVar.f(f10 - 6, false);
            }
        }
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
