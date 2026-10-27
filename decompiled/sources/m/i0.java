package m;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i0 extends z1 implements k0 {
    public CharSequence R;
    public g0 S;
    public final Rect T;
    public int U;
    public final /* synthetic */ l0 V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(l0 l0Var, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.V = l0Var;
        this.T = new Rect();
        this.C = l0Var;
        this.M = true;
        this.N.setFocusable(true);
        this.D = new g9.u(1, this);
    }

    @Override // m.k0
    public final void e(CharSequence charSequence) {
        this.R = charSequence;
    }

    @Override // m.k0
    public final void i(int i10) {
        this.U = i10;
    }

    @Override // m.k0
    public final void k(int i10, int i11) {
        ViewTreeObserver viewTreeObserver;
        x xVar = this.N;
        boolean isShowing = xVar.isShowing();
        s();
        xVar.setInputMethodMode(2);
        c();
        o1 o1Var = this.f8611q;
        o1Var.setChoiceMode(1);
        o1Var.setTextDirection(i10);
        o1Var.setTextAlignment(i11);
        l0 l0Var = this.V;
        int selectedItemPosition = l0Var.getSelectedItemPosition();
        o1 o1Var2 = this.f8611q;
        if (xVar.isShowing() && o1Var2 != null) {
            o1Var2.setListSelectionHidden(false);
            o1Var2.setSelection(selectedItemPosition);
            if (o1Var2.getChoiceMode() != 0) {
                o1Var2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (isShowing || (viewTreeObserver = l0Var.getViewTreeObserver()) == null) {
            return;
        }
        l.d dVar = new l.d(3, this);
        viewTreeObserver.addOnGlobalLayoutListener(dVar);
        xVar.setOnDismissListener(new h0(this, dVar));
    }

    @Override // m.k0
    public final CharSequence n() {
        return this.R;
    }

    @Override // m.z1, m.k0
    public final void o(ListAdapter listAdapter) {
        super.o(listAdapter);
        this.S = (g0) listAdapter;
    }

    public final void s() {
        int i10;
        l0 l0Var = this.V;
        Rect rect = l0Var.f8474v;
        x xVar = this.N;
        Drawable background = xVar.getBackground();
        if (background != null) {
            background.getPadding(rect);
            boolean z10 = h3.f8433a;
            i10 = l0Var.getLayoutDirection() == 1 ? rect.right : -rect.left;
        } else {
            i10 = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = l0Var.getPaddingLeft();
        int paddingRight = l0Var.getPaddingRight();
        int width = l0Var.getWidth();
        int i11 = l0Var.f8473u;
        if (i11 == -2) {
            int a10 = l0Var.a(this.S, xVar.getBackground());
            int i12 = (l0Var.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (a10 > i12) {
                a10 = i12;
            }
            r(Math.max(a10, (width - paddingLeft) - paddingRight));
        } else if (i11 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i11);
        }
        boolean z11 = h3.f8433a;
        this.f8614t = l0Var.getLayoutDirection() == 1 ? (((width - paddingRight) - this.f8613s) - this.U) + i10 : paddingLeft + this.U + i10;
    }
}
