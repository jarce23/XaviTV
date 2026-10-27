package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 extends y {

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatSeekBar f8376e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f8377f;
    public ColorStateList g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f8378h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8379i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8380j;

    public c0(AppCompatSeekBar appCompatSeekBar) {
        super(appCompatSeekBar);
        this.g = null;
        this.f8378h = null;
        this.f8379i = false;
        this.f8380j = false;
        this.f8376e = appCompatSeekBar;
    }

    @Override // m.y
    public final void b(AttributeSet attributeSet, int i10) {
        super.b(attributeSet, R.attr.seekBarStyle);
        AppCompatSeekBar appCompatSeekBar = this.f8376e;
        Context context = appCompatSeekBar.getContext();
        int[] iArr = e.a.g;
        android.support.v4.media.session.a0 T = android.support.v4.media.session.a0.T(context, attributeSet, iArr, R.attr.seekBarStyle);
        TypedArray typedArray = (TypedArray) T.f231q;
        m0.k0.l(appCompatSeekBar, appCompatSeekBar.getContext(), iArr, attributeSet, (TypedArray) T.f231q, R.attr.seekBarStyle);
        Drawable L = T.L(0);
        if (L != null) {
            appCompatSeekBar.setThumb(L);
        }
        Drawable K = T.K(1);
        Drawable drawable = this.f8377f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f8377f = K;
        if (K != null) {
            K.setCallback(appCompatSeekBar);
            K.setLayoutDirection(appCompatSeekBar.getLayoutDirection());
            if (K.isStateful()) {
                K.setState(appCompatSeekBar.getDrawableState());
            }
            f();
        }
        appCompatSeekBar.invalidate();
        if (typedArray.hasValue(3)) {
            this.f8378h = i1.c(typedArray.getInt(3, -1), this.f8378h);
            this.f8380j = true;
        }
        if (typedArray.hasValue(2)) {
            this.g = T.J(2);
            this.f8379i = true;
        }
        T.U();
        f();
    }

    public final void f() {
        Drawable drawable = this.f8377f;
        if (drawable != null) {
            if (this.f8379i || this.f8380j) {
                Drawable mutate = drawable.mutate();
                this.f8377f = mutate;
                if (this.f8379i) {
                    mutate.setTintList(this.g);
                }
                if (this.f8380j) {
                    this.f8377f.setTintMode(this.f8378h);
                }
                if (this.f8377f.isStateful()) {
                    this.f8377f.setState(this.f8376e.getDrawableState());
                }
            }
        }
    }

    public final void g(Canvas canvas) {
        if (this.f8377f != null) {
            int max = this.f8376e.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f8377f.getIntrinsicWidth();
                int intrinsicHeight = this.f8377f.getIntrinsicHeight();
                int i10 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i11 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f8377f.setBounds(-i10, -i11, i10, i11);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f8377f.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
