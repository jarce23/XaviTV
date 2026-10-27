package e9;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends com.bumptech.glide.d {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4669d;

    /* renamed from: e, reason: collision with root package name */
    public final SideSheetBehavior f4670e;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int i10) {
        this.f4669d = i10;
        this.f4670e = sideSheetBehavior;
    }

    @Override // com.bumptech.glide.d
    public final boolean A(float f10, float f11) {
        switch (this.f4669d) {
            case 0:
                if (Math.abs(f10) <= Math.abs(f11) || Math.abs(f10) <= 500) {
                }
                break;
            default:
                if (Math.abs(f10) <= Math.abs(f11) || Math.abs(f10) <= 500) {
                }
                break;
        }
        return false;
    }

    @Override // com.bumptech.glide.d
    public final boolean H(View view, float f10) {
        switch (this.f4669d) {
            case 0:
                float left = view.getLeft();
                SideSheetBehavior sideSheetBehavior = this.f4670e;
                float abs = Math.abs((f10 * sideSheetBehavior.f3825k) + left);
                sideSheetBehavior.getClass();
                if (abs > 0.5f) {
                }
                break;
            default:
                float right = view.getRight();
                SideSheetBehavior sideSheetBehavior2 = this.f4670e;
                float abs2 = Math.abs((f10 * sideSheetBehavior2.f3825k) + right);
                sideSheetBehavior2.getClass();
                if (abs2 > 0.5f) {
                }
                break;
        }
        return false;
    }

    @Override // com.bumptech.glide.d
    public final void L(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        switch (this.f4669d) {
            case 0:
                if (i10 <= this.f4670e.f3827m) {
                    marginLayoutParams.leftMargin = i11;
                    break;
                }
                break;
            default:
                int i12 = this.f4670e.f3827m;
                if (i10 <= i12) {
                    marginLayoutParams.rightMargin = i12 - i10;
                    break;
                }
                break;
        }
    }

    @Override // com.bumptech.glide.d
    public final int d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f4669d) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // com.bumptech.glide.d
    public final float e(int i10) {
        switch (this.f4669d) {
            case 0:
                float p10 = p();
                return (i10 - p10) / (o() - p10);
            default:
                float f10 = this.f4670e.f3827m;
                return (f10 - i10) / (f10 - o());
        }
    }

    @Override // com.bumptech.glide.d
    public final int o() {
        switch (this.f4669d) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f4670e;
                return Math.max(0, sideSheetBehavior.f3828n + sideSheetBehavior.f3829o);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.f4670e;
                return Math.max(0, (sideSheetBehavior2.f3827m - sideSheetBehavior2.f3826l) - sideSheetBehavior2.f3829o);
        }
    }

    @Override // com.bumptech.glide.d
    public final int p() {
        switch (this.f4669d) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f4670e;
                return (-sideSheetBehavior.f3826l) - sideSheetBehavior.f3829o;
            default:
                return this.f4670e.f3827m;
        }
    }

    @Override // com.bumptech.glide.d
    public final int q() {
        switch (this.f4669d) {
            case 0:
                return this.f4670e.f3829o;
            default:
                return this.f4670e.f3827m;
        }
    }

    @Override // com.bumptech.glide.d
    public final int r() {
        switch (this.f4669d) {
            case 0:
                return -this.f4670e.f3826l;
            default:
                return o();
        }
    }

    @Override // com.bumptech.glide.d
    public final int s(View view) {
        switch (this.f4669d) {
            case 0:
                return view.getRight() + this.f4670e.f3829o;
            default:
                return view.getLeft() - this.f4670e.f3829o;
        }
    }

    @Override // com.bumptech.glide.d
    public final int t(CoordinatorLayout coordinatorLayout) {
        switch (this.f4669d) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // com.bumptech.glide.d
    public final int u() {
        switch (this.f4669d) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.bumptech.glide.d
    public final boolean x(float f10) {
        switch (this.f4669d) {
            case 0:
                if (f10 > 0.0f) {
                }
                break;
            default:
                if (f10 < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // com.bumptech.glide.d
    public final boolean z(View view) {
        switch (this.f4669d) {
            case 0:
                if (view.getRight() < (o() - p()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (o() + this.f4670e.f3827m) / 2) {
                }
                break;
        }
        return false;
    }
}
