package androidx.leanback.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.WeakHashMap;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SearchOrbView extends FrameLayout implements View.OnClickListener {
    public boolean A;
    public boolean B;
    public final ArgbEvaluator C;
    public final l0 D;
    public ValueAnimator E;
    public final l0 F;

    /* renamed from: o, reason: collision with root package name */
    public View.OnClickListener f963o;

    /* renamed from: p, reason: collision with root package name */
    public final View f964p;

    /* renamed from: q, reason: collision with root package name */
    public final View f965q;

    /* renamed from: r, reason: collision with root package name */
    public final ImageView f966r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f967s;

    /* renamed from: t, reason: collision with root package name */
    public m0 f968t;

    /* renamed from: u, reason: collision with root package name */
    public final float f969u;

    /* renamed from: v, reason: collision with root package name */
    public final int f970v;

    /* renamed from: w, reason: collision with root package name */
    public final int f971w;

    /* renamed from: x, reason: collision with root package name */
    public final float f972x;

    /* renamed from: y, reason: collision with root package name */
    public final float f973y;

    /* renamed from: z, reason: collision with root package name */
    public ValueAnimator f974z;

    public SearchOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchOrbViewStyle);
    }

    public final void a(boolean z10) {
        float f10 = z10 ? this.f969u : 1.0f;
        ViewPropertyAnimator scaleY = this.f964p.animate().scaleX(f10).scaleY(f10);
        long j10 = this.f971w;
        scaleY.setDuration(j10).start();
        if (this.E == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.E = ofFloat;
            ofFloat.addUpdateListener(this.F);
        }
        if (z10) {
            this.E.start();
        } else {
            this.E.reverse();
        }
        this.E.setDuration(j10);
        this.A = z10;
        b();
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f974z;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f974z = null;
        }
        if (this.A && this.B) {
            ValueAnimator ofObject = ValueAnimator.ofObject(this.C, Integer.valueOf(this.f968t.f1041a), Integer.valueOf(this.f968t.f1042b), Integer.valueOf(this.f968t.f1041a));
            this.f974z = ofObject;
            ofObject.setRepeatCount(-1);
            this.f974z.setDuration(this.f970v * 2);
            this.f974z.addUpdateListener(this.D);
            this.f974z.start();
        }
    }

    public float getFocusedZoom() {
        return this.f969u;
    }

    public int getLayoutResourceId() {
        return R.layout.lb_search_orb;
    }

    public int getOrbColor() {
        return this.f968t.f1041a;
    }

    public m0 getOrbColors() {
        return this.f968t;
    }

    public Drawable getOrbIcon() {
        return this.f967s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.B = true;
        b();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f963o;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.B = false;
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        a(z10);
    }

    public void setOnOrbClickedListener(View.OnClickListener onClickListener) {
        this.f963o = onClickListener;
    }

    public void setOrbColor(int i10) {
        setOrbColors(new m0(i10, i10, 0));
    }

    public void setOrbColors(m0 m0Var) {
        this.f968t = m0Var;
        this.f966r.setColorFilter(m0Var.f1043c);
        if (this.f974z == null) {
            setOrbViewColor(this.f968t.f1041a);
        } else {
            this.A = true;
            b();
        }
    }

    public void setOrbIcon(Drawable drawable) {
        this.f967s = drawable;
        this.f966r.setImageDrawable(drawable);
    }

    public void setOrbViewColor(int i10) {
        View view = this.f965q;
        if (view.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) view.getBackground()).setColor(i10);
        }
    }

    public void setSearchOrbZ(float f10) {
        float f11 = this.f973y;
        float f12 = this.f972x;
        float f13 = ((f11 - f12) * f10) + f12;
        WeakHashMap weakHashMap = m0.k0.f8683a;
        m0.c0.k(this.f965q, f13);
    }

    public SearchOrbView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.C = new ArgbEvaluator();
        this.D = new l0(this, 0);
        this.F = new l0(this, 1);
        Resources resources = context.getResources();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResourceId(), (ViewGroup) this, true);
        this.f964p = inflate;
        this.f965q = inflate.findViewById(R.id.search_orb);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
        this.f966r = imageView;
        this.f969u = context.getResources().getFraction(R.fraction.lb_search_orb_focused_zoom, 1, 1);
        this.f970v = context.getResources().getInteger(R.integer.lb_search_orb_pulse_duration_ms);
        this.f971w = context.getResources().getInteger(R.integer.lb_search_orb_scale_duration_ms);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.lb_search_orb_focused_z);
        this.f973y = dimensionPixelSize;
        this.f972x = context.getResources().getDimensionPixelSize(R.dimen.lb_search_orb_unfocused_z);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a1.a.g, i10, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(2);
        setOrbIcon(drawable == null ? resources.getDrawable(R.drawable.lb_ic_in_app_search) : drawable);
        int color = obtainStyledAttributes.getColor(1, resources.getColor(R.color.lb_default_search_color));
        setOrbColors(new m0(color, obtainStyledAttributes.getColor(0, color), obtainStyledAttributes.getColor(3, 0)));
        obtainStyledAttributes.recycle();
        setFocusable(true);
        setClipChildren(false);
        setOnClickListener(this);
        setSoundEffectsEnabled(false);
        setSearchOrbZ(0.0f);
        WeakHashMap weakHashMap = m0.k0.f8683a;
        m0.c0.k(imageView, dimensionPixelSize);
    }
}
