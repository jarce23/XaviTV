package u3;

import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import i1.b1;
import i1.f1;
import i1.m0;
import i1.n0;
import i1.o0;
import i1.z0;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements m0, View.OnClickListener, PopupWindow.OnDismissListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ o f12405o;

    public f(o oVar) {
        this.f12405o = oVar;
    }

    @Override // i1.m0
    public final void d(i1.l0 l0Var) {
        boolean a10 = l0Var.a(4, 5, 13);
        o oVar = this.f12405o;
        if (a10) {
            oVar.q();
        }
        if (l0Var.a(4, 5, 7, 13)) {
            oVar.s();
        }
        if (l0Var.a(8, 13)) {
            oVar.t();
        }
        if (l0Var.a(9, 13)) {
            oVar.v();
        }
        if (l0Var.a(8, 9, 11, 0, 16, 17, 13)) {
            oVar.p();
        }
        if (l0Var.a(11, 0, 13)) {
            oVar.w();
        }
        if (l0Var.a(12, 13)) {
            oVar.r();
        }
        if (l0Var.a(2, 13)) {
            oVar.x();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        o oVar = this.f12405o;
        ImageView imageView = oVar.Q;
        View view2 = oVar.V;
        View view3 = oVar.U;
        View view4 = oVar.T;
        t tVar = oVar.f12446o;
        o0 o0Var = oVar.D0;
        if (o0Var == null) {
            return;
        }
        tVar.g();
        if (oVar.H == view) {
            b0.j jVar = (b0.j) o0Var;
            if (jVar.e(9)) {
                jVar.m();
                return;
            }
            return;
        }
        if (oVar.G == view) {
            b0.j jVar2 = (b0.j) o0Var;
            if (jVar2.e(7)) {
                jVar2.o();
                return;
            }
            return;
        }
        if (oVar.J == view) {
            if (((s1.a0) o0Var).F() != 4) {
                b0.j jVar3 = (b0.j) o0Var;
                if (jVar3.e(12)) {
                    s1.a0 a0Var = (s1.a0) jVar3;
                    a0Var.f0();
                    jVar3.n(12, a0Var.f11216w);
                    return;
                }
                return;
            }
            return;
        }
        if (oVar.K == view) {
            b0.j jVar4 = (b0.j) o0Var;
            if (jVar4.e(11)) {
                s1.a0 a0Var2 = (s1.a0) jVar4;
                a0Var2.f0();
                jVar4.n(11, -a0Var2.f11215v);
                return;
            }
            return;
        }
        if (oVar.I == view) {
            if (l1.a0.X(o0Var, oVar.H0)) {
                l1.a0.F(o0Var);
                return;
            }
            b0.j jVar5 = (b0.j) o0Var;
            if (jVar5.e(1)) {
                ((s1.a0) jVar5).U(false);
                return;
            }
            return;
        }
        if (oVar.N == view) {
            if (((b0.j) o0Var).e(15)) {
                s1.a0 a0Var3 = (s1.a0) o0Var;
                a0Var3.f0();
                int i10 = a0Var3.G;
                int i11 = oVar.N0;
                for (int i12 = 1; i12 <= 2; i12++) {
                    int i13 = (i10 + i12) % 3;
                    if (i13 != 0) {
                        if (i13 != 1) {
                            if (i13 == 2 && (i11 & 2) != 0) {
                            }
                        } else if ((i11 & 1) == 0) {
                        }
                    }
                    i10 = i13;
                }
                a0Var3.V(i10);
                return;
            }
            return;
        }
        if (oVar.O != view) {
            if (view4 == view) {
                tVar.f();
                oVar.e(oVar.f12468z, view4);
                return;
            }
            if (view3 == view) {
                tVar.f();
                oVar.e(oVar.A, view3);
                return;
            } else if (view2 == view) {
                tVar.f();
                oVar.e(oVar.C, view2);
                return;
            } else {
                if (imageView == view) {
                    tVar.f();
                    oVar.e(oVar.B, imageView);
                    return;
                }
                return;
            }
        }
        if (((b0.j) o0Var).e(14)) {
            s1.a0 a0Var4 = (s1.a0) o0Var;
            a0Var4.f0();
            boolean z10 = !a0Var4.H;
            l1.p pVar = a0Var4.f11204m;
            a0Var4.f0();
            if (a0Var4.H != z10) {
                a0Var4.H = z10;
                l1.x xVar = a0Var4.f11202l.f11343v;
                xVar.getClass();
                l1.w b2 = l1.x.b();
                b2.f8136a = xVar.f8138a.obtainMessage(12, z10 ? 1 : 0, 0);
                b2.b();
                pVar.c(9, new s1.u(0, z10));
                a0Var4.b0();
                pVar.b();
            }
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        o oVar = this.f12405o;
        if (oVar.T0) {
            oVar.f12446o.g();
        }
    }

    @Override // i1.m0
    public final /* synthetic */ void D() {
    }

    @Override // i1.m0
    public final /* synthetic */ void k() {
    }

    @Override // i1.m0
    public final /* synthetic */ void A(int i10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void B(i1.i0 i0Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void C(boolean z10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void H(z0 z0Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void I(boolean z10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void a(f1 f1Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void b(int i10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void c(b1 b1Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void e(int i10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void f(i1.d0 d0Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void h(int i10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void j(boolean z10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void m(boolean z10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void o(List list) {
    }

    @Override // i1.m0
    public final /* synthetic */ void q(i1.k0 k0Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void u(float f10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void v(i1.i0 i0Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void w(k1.c cVar) {
    }

    @Override // i1.m0
    public final /* synthetic */ void x(i1.f0 f0Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void y(int i10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void z(i1.j0 j0Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void E(int i10, int i11) {
    }

    @Override // i1.m0
    public final /* synthetic */ void r(int i10, boolean z10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void s(i1.a0 a0Var, int i10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void t(int i10, boolean z10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void n(int i10, n0 n0Var, n0 n0Var2) {
    }
}
