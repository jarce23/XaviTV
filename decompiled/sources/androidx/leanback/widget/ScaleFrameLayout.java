package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ScaleFrameLayout extends FrameLayout {

    /* renamed from: o, reason: collision with root package name */
    public float f947o;

    /* renamed from: p, reason: collision with root package name */
    public float f948p;

    /* renamed from: q, reason: collision with root package name */
    public float f949q;

    public ScaleFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f947o = 1.0f;
        this.f948p = 1.0f;
        this.f949q = 1.0f;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        view.setScaleX(this.f949q);
        view.setScaleY(this.f949q);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        boolean addViewInLayout = super.addViewInLayout(view, i10, layoutParams, z10);
        if (addViewInLayout) {
            view.setScaleX(this.f949q);
            view.setScaleY(this.f949q);
        }
        return addViewInLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.ScaleFrameLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        float f10 = this.f947o;
        if (f10 == 1.0f && this.f948p == 1.0f) {
            super.onMeasure(i10, i11);
            return;
        }
        if (f10 != 1.0f) {
            i10 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i10) / f10) + 0.5f), View.MeasureSpec.getMode(i10));
        }
        float f11 = this.f948p;
        if (f11 != 1.0f) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i11) / f11) + 0.5f), View.MeasureSpec.getMode(i11));
        }
        super.onMeasure(i10, i11);
        setMeasuredDimension((int) ((getMeasuredWidth() * this.f947o) + 0.5f), (int) ((getMeasuredHeight() * this.f948p) + 0.5f));
    }

    public void setChildScale(float f10) {
        if (this.f949q != f10) {
            this.f949q = f10;
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                getChildAt(i10).setScaleX(f10);
                getChildAt(i10).setScaleY(f10);
            }
        }
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        throw new UnsupportedOperationException();
    }

    public void setLayoutScaleX(float f10) {
        if (f10 != this.f947o) {
            this.f947o = f10;
            requestLayout();
        }
    }

    public void setLayoutScaleY(float f10) {
        if (f10 != this.f948p) {
            this.f948p = f10;
            requestLayout();
        }
    }
}
