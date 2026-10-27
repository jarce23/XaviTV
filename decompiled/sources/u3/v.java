package u3;

import android.os.Build;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.SubtitleView;
import i1.b1;
import i1.f1;
import i1.m0;
import i1.n0;
import i1.o0;
import i1.r0;
import i1.t0;
import i1.z0;
import java.util.List;
import s1.y0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v implements m0, View.OnClickListener, n, g {

    /* renamed from: o, reason: collision with root package name */
    public final r0 f12505o = new r0();

    /* renamed from: p, reason: collision with root package name */
    public Object f12506p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ PlayerView f12507q;

    public v(PlayerView playerView) {
        this.f12507q = playerView;
    }

    @Override // i1.m0
    public final void A(int i10) {
        int i11 = PlayerView.U;
        PlayerView playerView = this.f12507q;
        playerView.n();
        playerView.p();
        if (!playerView.e() || !playerView.R) {
            playerView.f(false);
            return;
        }
        o oVar = playerView.f1215z;
        if (oVar != null) {
            oVar.g();
        }
    }

    @Override // i1.m0
    public final void E(int i10, int i11) {
        PlayerView playerView = this.f12507q;
        View view = playerView.f1207r;
        if (Build.VERSION.SDK_INT == 34 && (view instanceof SurfaceView) && playerView.T) {
            p4.p pVar = playerView.f1209t;
            pVar.getClass();
            playerView.C.post(new androidx.emoji2.text.m(pVar, (SurfaceView) view, new androidx.activity.d(29, playerView), 6));
        }
    }

    @Override // i1.m0
    public final void a(f1 f1Var) {
        PlayerView playerView;
        o0 o0Var;
        if (f1Var.equals(f1.f5878d) || (o0Var = (playerView = this.f12507q).G) == null || ((s1.a0) o0Var).F() == 1) {
            return;
        }
        playerView.m();
    }

    @Override // i1.m0
    public final void c(b1 b1Var) {
        int b2;
        PlayerView playerView = this.f12507q;
        o0 o0Var = playerView.G;
        o0Var.getClass();
        b0.j jVar = (b0.j) o0Var;
        t0 A = jVar.e(17) ? ((s1.a0) o0Var).A() : t0.f6037a;
        if (A.p()) {
            this.f12506p = null;
        } else {
            boolean e7 = jVar.e(30);
            r0 r0Var = this.f12505o;
            if (e7) {
                s1.a0 a0Var = (s1.a0) o0Var;
                if (!a0Var.B().f5812a.isEmpty()) {
                    a0Var.f0();
                    if (a0Var.f11203l0.f11493a.p()) {
                        b2 = 0;
                    } else {
                        y0 y0Var = a0Var.f11203l0;
                        b2 = y0Var.f11493a.b(y0Var.f11494b.f2539a);
                    }
                    this.f12506p = A.f(b2, r0Var, true).f6013b;
                }
            }
            Object obj = this.f12506p;
            if (obj != null) {
                int b10 = A.b(obj);
                if (b10 != -1) {
                    if (((s1.a0) o0Var).x() == A.f(b10, r0Var, false).f6014c) {
                        return;
                    }
                }
                this.f12506p = null;
            }
        }
        playerView.q(false);
    }

    @Override // i1.m0
    public final void k() {
        PlayerView playerView = this.f12507q;
        View view = playerView.f1206q;
        if (view != null) {
            view.setVisibility(4);
            if (!playerView.b()) {
                playerView.d();
                return;
            }
            ImageView imageView = playerView.f1210u;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
        }
    }

    @Override // i1.m0
    public final void n(int i10, n0 n0Var, n0 n0Var2) {
        o oVar;
        int i11 = PlayerView.U;
        PlayerView playerView = this.f12507q;
        if (playerView.e() && playerView.R && (oVar = playerView.f1215z) != null) {
            oVar.g();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = PlayerView.U;
        this.f12507q.l();
    }

    @Override // i1.m0
    public final void t(int i10, boolean z10) {
        int i11 = PlayerView.U;
        PlayerView playerView = this.f12507q;
        playerView.n();
        if (!playerView.e() || !playerView.R) {
            playerView.f(false);
            return;
        }
        o oVar = playerView.f1215z;
        if (oVar != null) {
            oVar.g();
        }
    }

    @Override // i1.m0
    public final void w(k1.c cVar) {
        SubtitleView subtitleView = this.f12507q.f1212w;
        if (subtitleView != null) {
            subtitleView.setCues(cVar.f7642a);
        }
    }

    @Override // i1.m0
    public final /* synthetic */ void D() {
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
    public final /* synthetic */ void b(int i10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void d(i1.l0 l0Var) {
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
    public final /* synthetic */ void x(i1.f0 f0Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void y(int i10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void z(i1.j0 j0Var) {
    }

    @Override // i1.m0
    public final /* synthetic */ void r(int i10, boolean z10) {
    }

    @Override // i1.m0
    public final /* synthetic */ void s(i1.a0 a0Var, int i10) {
    }
}
