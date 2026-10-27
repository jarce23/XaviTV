package f3;

import i1.f0;
import i1.g0;
import i1.o;
import i1.p;
import java.util.ArrayList;
import java.util.Arrays;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: o, reason: collision with root package name */
    public static final byte[] f4991o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f4992p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* renamed from: n, reason: collision with root package name */
    public boolean f4993n;

    public static boolean e(t tVar, byte[] bArr) {
        if (tVar.a() < bArr.length) {
            return false;
        }
        int i10 = tVar.f8130b;
        byte[] bArr2 = new byte[bArr.length];
        tVar.h(bArr2, 0, bArr.length);
        tVar.I(i10);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // f3.i
    public final long b(t tVar) {
        byte[] bArr = tVar.f8129a;
        return (this.f5001i * k2.b.k(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0)) / 1000000;
    }

    @Override // f3.i
    public final boolean c(t tVar, long j10, x4.e eVar) {
        if (e(tVar, f4991o)) {
            byte[] copyOf = Arrays.copyOf(tVar.f8129a, tVar.f8131c);
            int i10 = copyOf[9] & 255;
            ArrayList a10 = k2.b.a(copyOf);
            if (((p) eVar.f13542p) == null) {
                o oVar = new o();
                oVar.f5939l = g0.m("audio/ogg");
                oVar.f5940m = g0.m("audio/opus");
                oVar.E = i10;
                oVar.F = 48000;
                oVar.f5943p = a10;
                eVar.f13542p = new p(oVar);
                return true;
            }
        } else {
            if (!e(tVar, f4992p)) {
                l1.d.h((p) eVar.f13542p);
                return false;
            }
            l1.d.h((p) eVar.f13542p);
            if (!this.f4993n) {
                this.f4993n = true;
                tVar.J(8);
                f0 r2 = k2.b.r(o9.g0.o(k2.b.v(tVar, false, false).f7741p));
                if (r2 != null) {
                    o a11 = ((p) eVar.f13542p).a();
                    a11.f5938k = r2.b(((p) eVar.f13542p).f5989l);
                    eVar.f13542p = new p(a11);
                    return true;
                }
            }
        }
        return true;
    }

    @Override // f3.i
    public final void d(boolean z10) {
        super.d(z10);
        if (z10) {
            this.f4993n = false;
        }
    }
}
