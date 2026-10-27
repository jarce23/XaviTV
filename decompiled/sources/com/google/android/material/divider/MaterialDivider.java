package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.bumptech.glide.d;
import d9.j;
import i9.a;
import org.chromium.net.R;
import x8.k;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MaterialDivider extends View {

    /* renamed from: o, reason: collision with root package name */
    public final j f3803o;

    /* renamed from: p, reason: collision with root package name */
    public int f3804p;

    /* renamed from: q, reason: collision with root package name */
    public int f3805q;

    /* renamed from: r, reason: collision with root package name */
    public int f3806r;

    /* renamed from: s, reason: collision with root package name */
    public int f3807s;

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider), attributeSet, R.attr.materialDividerStyle);
        Context context2 = getContext();
        this.f3803o = new j();
        TypedArray e7 = k.e(context2, attributeSet, j8.a.f7195p, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.f3804p = e7.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f3806r = e7.getDimensionPixelOffset(2, 0);
        this.f3807s = e7.getDimensionPixelOffset(1, 0);
        setDividerColor(d.l(context2, e7, 0).getDefaultColor());
        e7.recycle();
    }

    public int getDividerColor() {
        return this.f3805q;
    }

    public int getDividerInsetEnd() {
        return this.f3807s;
    }

    public int getDividerInsetStart() {
        return this.f3806r;
    }

    public int getDividerThickness() {
        return this.f3804p;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i10;
        super.onDraw(canvas);
        boolean z10 = getLayoutDirection() == 1;
        int i11 = z10 ? this.f3807s : this.f3806r;
        if (z10) {
            width = getWidth();
            i10 = this.f3806r;
        } else {
            width = getWidth();
            i10 = this.f3807s;
        }
        int i12 = width - i10;
        int bottom = getBottom() - getTop();
        j jVar = this.f3803o;
        jVar.setBounds(i11, 0, i12, bottom);
        jVar.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f3804p;
            if (i12 > 0 && measuredHeight != i12) {
                measuredHeight = i12;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i10) {
        if (this.f3805q != i10) {
            this.f3805q = i10;
            this.f3803o.n(ColorStateList.valueOf(i10));
            invalidate();
        }
    }

    public void setDividerColorResource(int i10) {
        setDividerColor(getContext().getColor(i10));
    }

    public void setDividerInsetEnd(int i10) {
        this.f3807s = i10;
    }

    public void setDividerInsetEndResource(int i10) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerInsetStart(int i10) {
        this.f3806r = i10;
    }

    public void setDividerInsetStartResource(int i10) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerThickness(int i10) {
        if (this.f3804p != i10) {
            this.f3804p = i10;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i10) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i10));
    }
}
