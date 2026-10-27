package b4;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2309a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0 f2310b;

    public /* synthetic */ m0(o0 o0Var, int i10) {
        this.f2309a = i10;
        this.f2310b = o0Var;
    }

    public final int a(View view) {
        int F;
        int i10;
        switch (this.f2309a) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                F = this.f2310b.F(view);
                i10 = ((ViewGroup.MarginLayoutParams) p0Var).rightMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                F = this.f2310b.A(view);
                i10 = ((ViewGroup.MarginLayoutParams) p0Var2).bottomMargin;
                break;
        }
        return F + i10;
    }

    public final int b(View view) {
        int C;
        int i10;
        switch (this.f2309a) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                C = this.f2310b.C(view);
                i10 = ((ViewGroup.MarginLayoutParams) p0Var).leftMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                C = this.f2310b.G(view);
                i10 = ((ViewGroup.MarginLayoutParams) p0Var2).topMargin;
                break;
        }
        return C - i10;
    }

    public final int c() {
        int i10;
        int L;
        switch (this.f2309a) {
            case 0:
                o0 o0Var = this.f2310b;
                i10 = o0Var.f2369n;
                L = o0Var.L();
                break;
            default:
                o0 o0Var2 = this.f2310b;
                i10 = o0Var2.f2370o;
                L = o0Var2.J();
                break;
        }
        return i10 - L;
    }

    public final int d() {
        switch (this.f2309a) {
            case 0:
                return this.f2310b.K();
            default:
                return this.f2310b.M();
        }
    }
}
