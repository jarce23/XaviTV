package c2;

import java.io.IOException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s0 implements e1 {

    /* renamed from: o, reason: collision with root package name */
    public final int f2708o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ u0 f2709p;

    public s0(u0 u0Var, int i10) {
        this.f2709p = u0Var;
        this.f2708o = i10;
    }

    @Override // c2.e1
    public final int f(x4.e eVar, r1.e eVar2, int i10) {
        u0 u0Var = this.f2709p;
        if (u0Var.G()) {
            return -3;
        }
        int i11 = this.f2708o;
        u0Var.B(i11);
        int y8 = u0Var.H[i11].y(eVar, eVar2, i10, u0Var.f2722b0);
        if (y8 == -3) {
            u0Var.C(i11);
        }
        return y8;
    }

    @Override // c2.e1
    public final boolean isReady() {
        u0 u0Var = this.f2709p;
        return !u0Var.G() && u0Var.H[this.f2708o].u(u0Var.f2722b0);
    }

    @Override // c2.e1
    public final void r() {
        int i10 = this.f2708o;
        u0 u0Var = this.f2709p;
        d1 d1Var = u0Var.H[i10];
        p4.p pVar = d1Var.f2550h;
        if (pVar != null && pVar.h() == 1) {
            v1.b f10 = d1Var.f2550h.f();
            f10.getClass();
            throw f10;
        }
        g2.n nVar = u0Var.f2735z;
        int D = u0Var.f2727r.D(u0Var.R);
        IOException iOException = nVar.f5132c;
        if (iOException != null) {
            throw iOException;
        }
        g2.j jVar = nVar.f5131b;
        if (jVar != null) {
            if (D == Integer.MIN_VALUE) {
                D = jVar.f5117o;
            }
            IOException iOException2 = jVar.f5121s;
            if (iOException2 != null && jVar.f5122t > D) {
                throw iOException2;
            }
        }
    }

    @Override // c2.e1
    public final int t(long j10) {
        u0 u0Var = this.f2709p;
        if (u0Var.G()) {
            return 0;
        }
        int i10 = this.f2708o;
        u0Var.B(i10);
        d1 d1Var = u0Var.H[i10];
        int s10 = d1Var.s(j10, u0Var.f2722b0);
        d1Var.D(s10);
        if (s10 == 0) {
            u0Var.C(i10);
        }
        return s10;
    }
}
