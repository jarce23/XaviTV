package f9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bumptech.glide.e;
import d9.j;
import d9.n;
import org.chromium.net.R;
import x8.k;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c extends FrameLayout {

    /* renamed from: w, reason: collision with root package name */
    public static final b f5040w = new b();

    /* renamed from: o, reason: collision with root package name */
    public final n f5041o;

    /* renamed from: p, reason: collision with root package name */
    public int f5042p;

    /* renamed from: q, reason: collision with root package name */
    public final float f5043q;

    /* renamed from: r, reason: collision with root package name */
    public final float f5044r;

    /* renamed from: s, reason: collision with root package name */
    public final int f5045s;

    /* renamed from: t, reason: collision with root package name */
    public final int f5046t;

    /* renamed from: u, reason: collision with root package name */
    public ColorStateList f5047u;

    /* renamed from: v, reason: collision with root package name */
    public PorterDuff.Mode f5048v;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Context context, AttributeSet attributeSet) {
        super(i9.a.a(context, attributeSet, 0, 0), attributeSet);
        GradientDrawable gradientDrawable;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, j8.a.A);
        if (obtainStyledAttributes.hasValue(6)) {
            setElevation(obtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.f5042p = obtainStyledAttributes.getInt(2, 0);
        if (obtainStyledAttributes.hasValue(8) || obtainStyledAttributes.hasValue(9)) {
            this.f5041o = n.b(context2, attributeSet, 0, 0).a();
        }
        this.f5043q = obtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(com.bumptech.glide.d.l(context2, obtainStyledAttributes, 4));
        setBackgroundTintMode(k.f(obtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.f5044r = obtainStyledAttributes.getFloat(1, 1.0f);
        this.f5045s = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f5046t = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f5040w);
        setFocusable(true);
        if (getBackground() == null) {
            int p10 = e.p(getBackgroundOverlayColorAlpha(), e.l(this, R.attr.colorSurface), e.l(this, R.attr.colorOnSurface));
            n nVar = this.f5041o;
            if (nVar != null) {
                int i10 = d.f5049a;
                j jVar = new j(nVar);
                jVar.n(ColorStateList.valueOf(p10));
                gradientDrawable = jVar;
            } else {
                Resources resources = getResources();
                int i11 = d.f5049a;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(dimension);
                gradientDrawable2.setColor(p10);
                gradientDrawable = gradientDrawable2;
            }
            ColorStateList colorStateList = this.f5047u;
            if (colorStateList != null) {
                gradientDrawable.setTintList(colorStateList);
            }
            setBackground(gradientDrawable);
        }
    }

    public float getActionTextColorAlpha() {
        return this.f5044r;
    }

    public int getAnimationMode() {
        return this.f5042p;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f5043q;
    }

    public int getMaxInlineActionWidth() {
        return this.f5046t;
    }

    public int getMaxWidth() {
        return this.f5045s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int i12 = this.f5045s;
        if (i12 <= 0 || getMeasuredWidth() <= i12) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
    }

    public void setAnimationMode(int i10) {
        this.f5042p = i10;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f5047u != null) {
            drawable = drawable.mutate();
            drawable.setTintList(this.f5047u);
            drawable.setTintMode(this.f5048v);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f5047u = colorStateList;
        if (getBackground() != null) {
            Drawable mutate = getBackground().mutate();
            mutate.setTintList(colorStateList);
            mutate.setTintMode(this.f5048v);
            if (mutate != getBackground()) {
                super.setBackgroundDrawable(mutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f5048v = mode;
        if (getBackground() != null) {
            Drawable mutate = getBackground().mutate();
            mutate.setTintMode(mode);
            if (mutate != getBackground()) {
                super.setBackgroundDrawable(mutate);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f5040w);
        super.setOnClickListener(onClickListener);
    }

    private void setBaseTransientBottomBar(d dVar) {
    }
}
