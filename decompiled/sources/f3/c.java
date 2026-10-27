package f3;

import c2.y0;
import i1.g0;
import i1.o;
import i1.p;
import java.util.Arrays;
import k2.s;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends i {

    /* renamed from: n, reason: collision with root package name */
    public s f4975n;

    /* renamed from: o, reason: collision with root package name */
    public y0 f4976o;

    @Override // f3.i
    public final long b(t tVar) {
        byte[] bArr = tVar.f8129a;
        if (bArr[0] != -1) {
            return -1L;
        }
        int i10 = (bArr[2] & 255) >> 4;
        if (i10 == 6 || i10 == 7) {
            tVar.J(4);
            tVar.D();
        }
        int t3 = k2.b.t(i10, tVar);
        tVar.I(0);
        return t3;
    }

    @Override // f3.i
    public final boolean c(t tVar, long j10, x4.e eVar) {
        byte[] bArr = tVar.f8129a;
        s sVar = this.f4975n;
        if (sVar == null) {
            s sVar2 = new s(17, bArr);
            this.f4975n = sVar2;
            o a10 = sVar2.c(Arrays.copyOfRange(bArr, 9, tVar.f8131c), null).a();
            a10.f5939l = g0.m("audio/ogg");
            eVar.f13542p = new p(a10);
            return true;
        }
        byte b2 = bArr[0];
        if ((b2 & Byte.MAX_VALUE) != 3) {
            if (b2 != -1) {
                return true;
            }
            y0 y0Var = this.f4976o;
            if (y0Var != null) {
                y0Var.f2772o = j10;
                eVar.f13543q = y0Var;
            }
            ((p) eVar.f13542p).getClass();
            return false;
        }
        x4.c u10 = k2.b.u(tVar);
        s sVar3 = new s(sVar.f7768a, sVar.f7769b, sVar.f7770c, sVar.f7771d, sVar.f7772e, sVar.g, sVar.f7774h, sVar.f7776j, u10, sVar.f7778l);
        this.f4975n = sVar3;
        y0 y0Var2 = new y0();
        y0Var2.f2774q = sVar3;
        y0Var2.f2775r = u10;
        y0Var2.f2772o = -1L;
        y0Var2.f2773p = -1L;
        this.f4976o = y0Var2;
        return true;
    }

    @Override // f3.i
    public final void d(boolean z10) {
        super.d(z10);
        if (z10) {
            this.f4975n = null;
            this.f4976o = null;
        }
    }
}
