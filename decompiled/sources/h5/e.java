package h5;

import android.content.DialogInterface;
import android.graphics.Color;
import android.view.KeyEvent;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements DialogInterface.OnKeyListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5592o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ androidx.fragment.app.o f5593p;

    public /* synthetic */ e(androidx.fragment.app.o oVar, int i10) {
        this.f5592o = i10;
        this.f5593p = oVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        switch (this.f5592o) {
            case 0:
                f fVar = (f) this.f5593p;
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if (i10 == 22) {
                    if (fVar.H0.hasFocus() || fVar.J0.hasFocus() || fVar.I0.hasFocus()) {
                        fVar.B0.requestFocus();
                    } else if (fVar.B0.hasFocus() && fVar.W0.size() > 0) {
                        fVar.L0.requestFocus();
                    }
                } else {
                    if (i10 != 21) {
                        if (i10 != 4) {
                            return false;
                        }
                        fVar.G0.a(fVar.W0);
                        return false;
                    }
                    if (fVar.L0.hasFocus()) {
                        fVar.B0.requestFocus();
                    } else if (fVar.B0.hasFocus()) {
                        fVar.H0.requestFocus();
                    }
                }
                return true;
            case 1:
                k kVar = (k) this.f5593p;
                if (keyEvent.getKeyCode() != 0) {
                    return false;
                }
                switch (keyEvent.getKeyCode()) {
                    case 19:
                        if (!kVar.f5616z0.hasFocus() && !kVar.A0.hasFocus()) {
                            return false;
                        }
                        kVar.B0.setFocusable(true);
                        kVar.B0.requestFocus();
                        break;
                    case 20:
                        if (!kVar.B0.hasFocus()) {
                            return false;
                        }
                        kVar.B0.setFocusable(false);
                        if (!kVar.X0) {
                            kVar.f5616z0.requestFocus();
                            break;
                        } else {
                            kVar.A0.requestFocus();
                            break;
                        }
                    case 21:
                        if (!kVar.D0.hasFocus() && !kVar.G0.hasFocus() && !kVar.f5615y0.hasFocus() && !kVar.f5616z0.hasFocus()) {
                            return false;
                        }
                        break;
                    case 22:
                        if (!kVar.F0.hasFocus() && !kVar.E0.hasFocus() && !kVar.f5615y0.hasFocus() && !kVar.A0.hasFocus()) {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
                return true;
            case 2:
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
                    return false;
                }
                ((r) this.f5593p).J(false, false);
                return true;
            case 3:
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
                    return false;
                }
                ((u) this.f5593p).J(false, false);
                return true;
            case 4:
                y yVar = (y) this.f5593p;
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if (i10 == 21) {
                    if (!yVar.I0.hasFocus()) {
                        return false;
                    }
                    yVar.A0.requestFocus();
                } else {
                    if (i10 != 22 || !yVar.I0.hasFocus()) {
                        return false;
                    }
                    yVar.f5680z0.requestFocus();
                }
                return true;
            case 5:
                a0 a0Var = (a0) this.f5593p;
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if (i10 == 21) {
                    if (!a0Var.D0.hasFocus()) {
                        return false;
                    }
                    a0Var.f5580z0.requestFocus();
                } else {
                    if (i10 != 22 || !a0Var.D0.hasFocus()) {
                        return false;
                    }
                    a0Var.f5579y0.requestFocus();
                }
                return true;
            case 6:
                c0 c0Var = (c0) this.f5593p;
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 19) {
                    if (keyCode != 20 || !c0Var.f5588z0.hasFocus()) {
                        return false;
                    }
                    c0Var.f5588z0.setFocusable(false);
                    c0Var.D0.requestFocus();
                } else {
                    if (!c0Var.D0.hasFocus() || c0Var.G0 != 0) {
                        return false;
                    }
                    c0Var.f5588z0.setFocusable(true);
                    c0Var.f5588z0.requestFocus();
                }
                return true;
            case 7:
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
                    return false;
                }
                ((k0) this.f5593p).J(false, false);
                return true;
            case 8:
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
                    return false;
                }
                ((n0) this.f5593p).J(false, false);
                return true;
            case 9:
                s0 s0Var = (s0) this.f5593p;
                if (keyEvent.getAction() != 0 || i10 != 19 || !s0Var.B0.hasFocus()) {
                    return false;
                }
                s0Var.D0.requestFocus();
                return true;
            default:
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
                    return false;
                }
                u0 u0Var = (u0) ((t0) this.f5593p).f5660z0.f5610p;
                u0Var.B0.setBackgroundColor(Color.parseColor(u0Var.F0.D()));
                u0Var.A0.setBackgroundColor(Color.parseColor(u0Var.F0.C()));
                return false;
        }
    }
}
