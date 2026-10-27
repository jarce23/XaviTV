package androidx.leanback.widget;

import android.view.View;
import b4.z0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class l extends b4.y {

    /* renamed from: q, reason: collision with root package name */
    public boolean f1032q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ p f1033r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(p pVar) {
        super(pVar.f1055q.getContext());
        this.f1033r = pVar;
    }

    @Override // b4.y
    public final int e(int i10) {
        int e7 = super.e(i10);
        int i11 = ((x0) this.f1033r.U.f13555r).f1097i;
        if (i11 > 0) {
            float f10 = (30.0f / i11) * i10;
            if (e7 < f10) {
                return (int) f10;
            }
        }
        return e7;
    }

    @Override // b4.y
    public final void h() {
        super.h();
        if (!this.f1032q) {
            l();
        }
        p pVar = this.f1033r;
        if (pVar.C == this) {
            pVar.C = null;
        }
        if (pVar.D == this) {
            pVar.D = null;
        }
    }

    @Override // b4.y
    public final void i(View view, z0 z0Var) {
        int i10;
        int i11;
        int[] iArr = p.f1051d0;
        p pVar = this.f1033r;
        if (pVar.b1(view, null, iArr)) {
            if (pVar.f1056r == 0) {
                i10 = iArr[0];
                i11 = iArr[1];
            } else {
                i10 = iArr[1];
                i11 = iArr[0];
            }
            int ceil = (int) Math.ceil(e((int) Math.sqrt((i11 * i11) + (i10 * i10))) / 0.3356d);
            z0Var.f2467a = i10;
            z0Var.f2468b = i11;
            z0Var.f2469c = ceil;
            z0Var.f2471e = this.f2458j;
            z0Var.f2472f = true;
        }
    }

    public void l() {
        View s10 = this.f2451b.B.s(this.f2450a);
        p pVar = this.f1033r;
        if (s10 == null) {
            int i10 = this.f2450a;
            if (i10 >= 0) {
                pVar.r1(i10, false);
                return;
            }
            return;
        }
        int i11 = pVar.B;
        int i12 = this.f2450a;
        if (i11 != i12) {
            pVar.B = i12;
        }
        if (pVar.R()) {
            pVar.f1064z |= 32;
            s10.requestFocus();
            pVar.f1064z &= -33;
        }
        pVar.T0();
        pVar.U0();
    }
}
