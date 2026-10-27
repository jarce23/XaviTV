package f3;

import i1.h0;
import java.util.List;
import k2.n;
import k2.o;
import k2.p;
import l1.a0;
import l1.t;
import o9.e0;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements n {

    /* renamed from: a, reason: collision with root package name */
    public p f4977a;

    /* renamed from: b, reason: collision with root package name */
    public i f4978b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4979c;

    @Override // k2.n
    public final void c(p pVar) {
        this.f4977a = pVar;
    }

    public final boolean d(o oVar) {
        boolean z10;
        f fVar = new f();
        if (fVar.a(oVar, true) && (fVar.f4985a & 2) == 2) {
            int min = Math.min(fVar.f4989e, 8);
            t tVar = new t(min);
            oVar.o(tVar.f8129a, 0, min);
            tVar.I(0);
            if (tVar.a() >= 5 && tVar.w() == 127 && tVar.y() == 1179402563) {
                this.f4978b = new c();
                return true;
            }
            tVar.I(0);
            try {
                z10 = k2.b.x(1, tVar, true);
            } catch (h0 unused) {
                z10 = false;
            }
            if (z10) {
                this.f4978b = new k();
            } else {
                tVar.I(0);
                if (h.e(tVar, h.f4991o)) {
                    this.f4978b = new h();
                }
            }
            return true;
        }
        return false;
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        i iVar = this.f4978b;
        if (iVar != null) {
            e eVar = iVar.f4994a;
            f fVar = (f) eVar.f4983r;
            fVar.f4985a = 0;
            fVar.f4986b = 0L;
            fVar.f4987c = 0;
            fVar.f4988d = 0;
            fVar.f4989e = 0;
            ((t) eVar.f4984s).F(0);
            eVar.f4980o = -1;
            eVar.f4982q = false;
            if (j10 == 0) {
                iVar.d(!iVar.f5004l);
                return;
            }
            if (iVar.f5000h != 0) {
                long j12 = (iVar.f5001i * j11) / 1000000;
                iVar.f4998e = j12;
                g gVar = iVar.f4997d;
                int i10 = a0.f8067a;
                gVar.u(j12);
                iVar.f5000h = 2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x017b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017c  */
    @Override // k2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(k2.o r21, i1.s r22) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.d.f(k2.o, i1.s):int");
    }

    @Override // k2.n
    public final List g() {
        e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(o oVar) {
        try {
            return d(oVar);
        } catch (h0 unused) {
            return false;
        }
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final n b() {
        return this;
    }
}
