package u;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends d {

    /* renamed from: p0, reason: collision with root package name */
    public float f12137p0 = -1.0f;

    /* renamed from: q0, reason: collision with root package name */
    public int f12138q0 = -1;

    /* renamed from: r0, reason: collision with root package name */
    public int f12139r0 = -1;

    /* renamed from: s0, reason: collision with root package name */
    public c f12140s0 = this.I;

    /* renamed from: t0, reason: collision with root package name */
    public int f12141t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f12142u0;

    public h() {
        this.Q.clear();
        this.Q.add(this.f12140s0);
        int length = this.P.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.P[i10] = this.f12140s0;
        }
    }

    @Override // u.d
    public final void L(s.c cVar, boolean z10) {
        if (this.S == null) {
            return;
        }
        c cVar2 = this.f12140s0;
        cVar.getClass();
        int n10 = s.c.n(cVar2);
        if (this.f12141t0 == 1) {
            this.X = n10;
            this.Y = 0;
            G(this.S.k());
            J(0);
            return;
        }
        this.X = 0;
        this.Y = n10;
        J(this.S.n());
        G(0);
    }

    public final void M(int i10) {
        this.f12140s0.l(i10);
        this.f12142u0 = true;
    }

    public final void N(int i10) {
        if (this.f12141t0 == i10) {
            return;
        }
        this.f12141t0 = i10;
        ArrayList arrayList = this.Q;
        arrayList.clear();
        if (this.f12141t0 == 1) {
            this.f12140s0 = this.H;
        } else {
            this.f12140s0 = this.I;
        }
        arrayList.add(this.f12140s0);
        c[] cVarArr = this.P;
        int length = cVarArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            cVarArr[i11] = this.f12140s0;
        }
    }

    @Override // u.d
    public final void b(s.c cVar, boolean z10) {
        e eVar = (e) this.S;
        if (eVar == null) {
            return;
        }
        Object i10 = eVar.i(2);
        Object i11 = eVar.i(4);
        d dVar = this.S;
        boolean z11 = dVar != null && dVar.f12087o0[0] == 2;
        if (this.f12141t0 == 0) {
            i10 = eVar.i(3);
            i11 = eVar.i(5);
            d dVar2 = this.S;
            z11 = dVar2 != null && dVar2.f12087o0[1] == 2;
        }
        if (this.f12142u0) {
            c cVar2 = this.f12140s0;
            if (cVar2.f12054c) {
                s.f k10 = cVar.k(cVar2);
                cVar.d(k10, this.f12140s0.d());
                if (this.f12138q0 != -1) {
                    if (z11) {
                        cVar.f(cVar.k(i11), k10, 0, 5);
                    }
                } else if (this.f12139r0 != -1 && z11) {
                    s.f k11 = cVar.k(i11);
                    cVar.f(k10, cVar.k(i10), 0, 5);
                    cVar.f(k11, k10, 0, 5);
                }
                this.f12142u0 = false;
                return;
            }
        }
        if (this.f12138q0 != -1) {
            s.f k12 = cVar.k(this.f12140s0);
            cVar.e(k12, cVar.k(i10), this.f12138q0, 8);
            if (z11) {
                cVar.f(cVar.k(i11), k12, 0, 5);
                return;
            }
            return;
        }
        if (this.f12139r0 != -1) {
            s.f k13 = cVar.k(this.f12140s0);
            s.f k14 = cVar.k(i11);
            cVar.e(k13, k14, -this.f12139r0, 8);
            if (z11) {
                cVar.f(k13, cVar.k(i10), 0, 5);
                cVar.f(k14, k13, 0, 5);
                return;
            }
            return;
        }
        if (this.f12137p0 != -1.0f) {
            s.f k15 = cVar.k(this.f12140s0);
            s.f k16 = cVar.k(i11);
            float f10 = this.f12137p0;
            s.b l10 = cVar.l();
            l10.f11108d.g(k15, -1.0f);
            l10.f11108d.g(k16, f10);
            cVar.c(l10);
        }
    }

    @Override // u.d
    public final boolean c() {
        return true;
    }

    @Override // u.d
    public final c i(int i10) {
        int b2 = s.e.b(i10);
        if (b2 != 1) {
            if (b2 != 2) {
                if (b2 != 3) {
                    if (b2 != 4) {
                        return null;
                    }
                }
            }
            if (this.f12141t0 == 0) {
                return this.f12140s0;
            }
            return null;
        }
        if (this.f12141t0 == 1) {
            return this.f12140s0;
        }
        return null;
    }

    @Override // u.d
    public final boolean x() {
        return this.f12142u0;
    }

    @Override // u.d
    public final boolean y() {
        return this.f12142u0;
    }
}
