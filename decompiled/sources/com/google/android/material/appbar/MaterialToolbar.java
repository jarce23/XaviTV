package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import b4.o;
import com.bumptech.glide.c;
import d9.j;
import i9.a;
import java.util.ArrayList;
import java.util.Collections;
import org.chromium.net.R;
import x8.k;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: n0, reason: collision with root package name */
    public static final ImageView.ScaleType[] f3648n0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: i0, reason: collision with root package name */
    public Integer f3649i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f3650j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f3651k0;

    /* renamed from: l0, reason: collision with root package name */
    public ImageView.ScaleType f3652l0;

    /* renamed from: m0, reason: collision with root package name */
    public Boolean f3653m0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar), attributeSet, 0);
        Context context2 = getContext();
        TypedArray e7 = k.e(context2, attributeSet, j8.a.f7201v, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (e7.hasValue(2)) {
            setNavigationIconTint(e7.getColor(2, -1));
        }
        this.f3650j0 = e7.getBoolean(4, false);
        this.f3651k0 = e7.getBoolean(3, false);
        int i10 = e7.getInt(1, -1);
        if (i10 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f3648n0;
            if (i10 < scaleTypeArr.length) {
                this.f3652l0 = scaleTypeArr[i10];
            }
        }
        if (e7.hasValue(0)) {
            this.f3653m0 = Boolean.valueOf(e7.getBoolean(0, false));
        }
        e7.recycle();
        Drawable background = getBackground();
        ColorStateList valueOf = background == null ? ColorStateList.valueOf(0) : c.k(background);
        if (valueOf != null) {
            j jVar = new j();
            jVar.n(valueOf);
            jVar.k(context2);
            jVar.m(getElevation());
            setBackground(jVar);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f3652l0;
    }

    public Integer getNavigationIconTint() {
        return this.f3649i0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof j) {
            j1.c.q(this, (j) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z10, i10, i11, i12, i13);
        o oVar = k.f13745c;
        int i14 = 0;
        ImageView imageView2 = null;
        if (this.f3650j0 || this.f3651k0) {
            ArrayList d6 = k.d(this, getTitle());
            TextView textView = d6.isEmpty() ? null : (TextView) Collections.min(d6, oVar);
            ArrayList d10 = k.d(this, getSubtitle());
            TextView textView2 = d10.isEmpty() ? null : (TextView) Collections.max(d10, oVar);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i15 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i16 = 0; i16 < getChildCount(); i16++) {
                    View childAt = getChildAt(i16);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i15 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i15 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f3650j0 && textView != null) {
                    u(textView, pair);
                }
                if (this.f3651k0 && textView2 != null) {
                    u(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i14 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i14);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i14++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.f3653m0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f3652l0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        Drawable background = getBackground();
        if (background instanceof j) {
            ((j) background).m(f10);
        }
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.f3653m0;
        if (bool == null || bool.booleanValue() != z10) {
            this.f3653m0 = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f3652l0 != scaleType) {
            this.f3652l0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f3649i0 != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.f3649i0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i10) {
        this.f3649i0 = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.f3651k0 != z10) {
            this.f3651k0 = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.f3650j0 != z10) {
            this.f3650j0 = z10;
            requestLayout();
        }
    }

    public final void u(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i10 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i11 = measuredWidth2 + i10;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i10, 0), Math.max(i11 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i10 += max;
            i11 -= max;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i11 - i10, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i10, textView.getTop(), i11, textView.getBottom());
    }
}
