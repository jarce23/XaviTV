package b4;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z extends androidx.emoji2.text.g {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2466d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(o0 o0Var, int i10) {
        super(o0Var);
        this.f2466d = i10;
    }

    @Override // androidx.emoji2.text.g
    public final int b(View view) {
        int F;
        int i10;
        switch (this.f2466d) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                F = ((o0) this.f570b).F(view);
                i10 = ((ViewGroup.MarginLayoutParams) p0Var).rightMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                F = ((o0) this.f570b).A(view);
                i10 = ((ViewGroup.MarginLayoutParams) p0Var2).bottomMargin;
                break;
        }
        return F + i10;
    }

    @Override // androidx.emoji2.text.g
    public final int c(View view) {
        int E;
        int i10;
        switch (this.f2466d) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                ((o0) this.f570b).getClass();
                E = o0.E(view) + ((ViewGroup.MarginLayoutParams) p0Var).leftMargin;
                i10 = ((ViewGroup.MarginLayoutParams) p0Var).rightMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                ((o0) this.f570b).getClass();
                E = o0.D(view) + ((ViewGroup.MarginLayoutParams) p0Var2).topMargin;
                i10 = ((ViewGroup.MarginLayoutParams) p0Var2).bottomMargin;
                break;
        }
        return E + i10;
    }

    @Override // androidx.emoji2.text.g
    public final int d(View view) {
        int D;
        int i10;
        switch (this.f2466d) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                ((o0) this.f570b).getClass();
                D = o0.D(view) + ((ViewGroup.MarginLayoutParams) p0Var).topMargin;
                i10 = ((ViewGroup.MarginLayoutParams) p0Var).bottomMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                ((o0) this.f570b).getClass();
                D = o0.E(view) + ((ViewGroup.MarginLayoutParams) p0Var2).leftMargin;
                i10 = ((ViewGroup.MarginLayoutParams) p0Var2).rightMargin;
                break;
        }
        return D + i10;
    }

    @Override // androidx.emoji2.text.g
    public final int e(View view) {
        int C;
        int i10;
        switch (this.f2466d) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                C = ((o0) this.f570b).C(view);
                i10 = ((ViewGroup.MarginLayoutParams) p0Var).leftMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                C = ((o0) this.f570b).G(view);
                i10 = ((ViewGroup.MarginLayoutParams) p0Var2).topMargin;
                break;
        }
        return C - i10;
    }

    @Override // androidx.emoji2.text.g
    public final int f() {
        switch (this.f2466d) {
            case 0:
                return ((o0) this.f570b).f2369n;
            default:
                return ((o0) this.f570b).f2370o;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int g() {
        int i10;
        int L;
        switch (this.f2466d) {
            case 0:
                o0 o0Var = (o0) this.f570b;
                i10 = o0Var.f2369n;
                L = o0Var.L();
                break;
            default:
                o0 o0Var2 = (o0) this.f570b;
                i10 = o0Var2.f2370o;
                L = o0Var2.J();
                break;
        }
        return i10 - L;
    }

    @Override // androidx.emoji2.text.g
    public final int h() {
        switch (this.f2466d) {
            case 0:
                return ((o0) this.f570b).L();
            default:
                return ((o0) this.f570b).J();
        }
    }

    @Override // androidx.emoji2.text.g
    public final int i() {
        switch (this.f2466d) {
            case 0:
                return ((o0) this.f570b).f2367l;
            default:
                return ((o0) this.f570b).f2368m;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int j() {
        switch (this.f2466d) {
            case 0:
                return ((o0) this.f570b).f2368m;
            default:
                return ((o0) this.f570b).f2367l;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int k() {
        switch (this.f2466d) {
            case 0:
                return ((o0) this.f570b).K();
            default:
                return ((o0) this.f570b).M();
        }
    }

    @Override // androidx.emoji2.text.g
    public final int l() {
        int K;
        int L;
        switch (this.f2466d) {
            case 0:
                o0 o0Var = (o0) this.f570b;
                K = o0Var.f2369n - o0Var.K();
                L = o0Var.L();
                break;
            default:
                o0 o0Var2 = (o0) this.f570b;
                K = o0Var2.f2370o - o0Var2.M();
                L = o0Var2.J();
                break;
        }
        return K - L;
    }

    @Override // androidx.emoji2.text.g
    public final int m(View view) {
        switch (this.f2466d) {
            case 0:
                o0 o0Var = (o0) this.f570b;
                Rect rect = (Rect) this.f571c;
                o0Var.Q(view, rect);
                return rect.right;
            default:
                o0 o0Var2 = (o0) this.f570b;
                Rect rect2 = (Rect) this.f571c;
                o0Var2.Q(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int n(View view) {
        switch (this.f2466d) {
            case 0:
                o0 o0Var = (o0) this.f570b;
                Rect rect = (Rect) this.f571c;
                o0Var.Q(view, rect);
                return rect.left;
            default:
                o0 o0Var2 = (o0) this.f570b;
                Rect rect2 = (Rect) this.f571c;
                o0Var2.Q(view, rect2);
                return rect2.top;
        }
    }

    @Override // androidx.emoji2.text.g
    public final void o(int i10) {
        switch (this.f2466d) {
            case 0:
                ((o0) this.f570b).V(i10);
                break;
            default:
                ((o0) this.f570b).W(i10);
                break;
        }
    }
}
