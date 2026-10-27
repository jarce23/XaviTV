package f3;

import i1.h0;
import java.io.EOFException;
import k2.o;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f4985a;

    /* renamed from: b, reason: collision with root package name */
    public long f4986b;

    /* renamed from: c, reason: collision with root package name */
    public int f4987c;

    /* renamed from: d, reason: collision with root package name */
    public int f4988d;

    /* renamed from: e, reason: collision with root package name */
    public int f4989e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f4990f = new int[255];
    public final t g = new t(255);

    public final boolean a(o oVar, boolean z10) {
        boolean z11;
        boolean z12;
        this.f4985a = 0;
        this.f4986b = 0L;
        this.f4987c = 0;
        this.f4988d = 0;
        this.f4989e = 0;
        t tVar = this.g;
        tVar.F(27);
        try {
            z11 = oVar.m(tVar.f8129a, 0, 27, z10);
        } catch (EOFException e7) {
            if (!z10) {
                throw e7;
            }
            z11 = false;
        }
        if (z11 && tVar.y() == 1332176723) {
            if (tVar.w() == 0) {
                this.f4985a = tVar.w();
                this.f4986b = tVar.m();
                tVar.n();
                tVar.n();
                tVar.n();
                int w10 = tVar.w();
                this.f4987c = w10;
                this.f4988d = w10 + 27;
                tVar.F(w10);
                try {
                    z12 = oVar.m(tVar.f8129a, 0, this.f4987c, z10);
                } catch (EOFException e8) {
                    if (!z10) {
                        throw e8;
                    }
                    z12 = false;
                }
                if (z12) {
                    for (int i10 = 0; i10 < this.f4987c; i10++) {
                        int w11 = tVar.w();
                        this.f4990f[i10] = w11;
                        this.f4989e += w11;
                    }
                    return true;
                }
            } else if (!z10) {
                throw h0.c("unsupported bit stream revision");
            }
        }
        return false;
    }

    public final boolean b(o oVar, long j10) {
        boolean z10;
        l1.d.b(oVar.getPosition() == oVar.n());
        t tVar = this.g;
        tVar.F(4);
        while (true) {
            if (j10 != -1 && oVar.getPosition() + 4 >= j10) {
                break;
            }
            try {
                z10 = oVar.m(tVar.f8129a, 0, 4, true);
            } catch (EOFException unused) {
                z10 = false;
            }
            if (!z10) {
                break;
            }
            tVar.I(0);
            if (tVar.y() == 1332176723) {
                oVar.h();
                return true;
            }
            oVar.i(1);
        }
        do {
            if (j10 != -1 && oVar.getPosition() >= j10) {
                break;
            }
        } while (oVar.a(1) != -1);
        return false;
    }
}
