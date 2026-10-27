package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
class ClockHandView extends View {
    public static final /* synthetic */ int B = 0;
    public int A;

    /* renamed from: o, reason: collision with root package name */
    public final ValueAnimator f3883o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3884p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f3885q;

    /* renamed from: r, reason: collision with root package name */
    public final int f3886r;

    /* renamed from: s, reason: collision with root package name */
    public final float f3887s;

    /* renamed from: t, reason: collision with root package name */
    public final Paint f3888t;

    /* renamed from: u, reason: collision with root package name */
    public final RectF f3889u;

    /* renamed from: v, reason: collision with root package name */
    public final int f3890v;

    /* renamed from: w, reason: collision with root package name */
    public float f3891w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f3892x;

    /* renamed from: y, reason: collision with root package name */
    public double f3893y;

    /* renamed from: z, reason: collision with root package name */
    public int f3894z;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f3883o = valueAnimator;
        this.f3885q = new ArrayList();
        Paint paint = new Paint();
        this.f3888t = paint;
        this.f3889u = new RectF();
        this.A = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j8.a.f7185e, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        w7.b.u(context, R.attr.motionDurationLong2, 200);
        w7.b.v(context, R.attr.motionEasingEmphasizedInterpolator, k8.a.f7831b);
        this.f3894z = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f3886r = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f3890v = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f3887s = r5.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        obtainStyledAttributes.recycle();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i10 = ClockHandView.B;
                ClockHandView.this.c(((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.addListener(new e());
    }

    public final int a(int i10) {
        return i10 == 2 ? Math.round(this.f3894z * 0.66f) : this.f3894z;
    }

    public final void b(float f10) {
        this.f3883o.cancel();
        c(f10);
    }

    public final void c(float f10) {
        float f11 = f10 % 360.0f;
        this.f3891w = f11;
        this.f3893y = Math.toRadians(f11 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float a10 = a(this.A);
        float cos = (((float) Math.cos(this.f3893y)) * a10) + width;
        float sin = (a10 * ((float) Math.sin(this.f3893y))) + height;
        float f12 = this.f3886r;
        this.f3889u.set(cos - f12, sin - f12, cos + f12, sin + f12);
        ArrayList arrayList = this.f3885q;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ClockFaceView clockFaceView = (ClockFaceView) ((f) obj);
            if (Math.abs(clockFaceView.W - f11) > 0.001f) {
                clockFaceView.W = f11;
                clockFaceView.n();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f10 = width;
        float a10 = a(this.A);
        float cos = (((float) Math.cos(this.f3893y)) * a10) + f10;
        float f11 = height;
        float sin = (a10 * ((float) Math.sin(this.f3893y))) + f11;
        Paint paint = this.f3888t;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.f3886r, paint);
        double sin2 = Math.sin(this.f3893y);
        paint.setStrokeWidth(this.f3890v);
        canvas.drawLine(f10, f11, width + ((int) (Math.cos(this.f3893y) * r2)), height + ((int) (r2 * sin2)), paint);
        canvas.drawCircle(f10, f11, this.f3887s, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f3883o.isRunning()) {
            return;
        }
        b(this.f3891w);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        int actionMasked = motionEvent.getActionMasked();
        float x6 = motionEvent.getX();
        float y8 = motionEvent.getY();
        boolean z12 = false;
        if (actionMasked == 0) {
            this.f3892x = false;
            z10 = true;
            z11 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z11 = this.f3892x;
            if (this.f3884p) {
                this.A = ((float) Math.hypot((double) (x6 - ((float) (getWidth() / 2))), (double) (y8 - ((float) (getHeight() / 2))))) <= ((float) a(2)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
            }
            z10 = false;
        } else {
            z11 = false;
            z10 = false;
        }
        boolean z13 = this.f3892x;
        int degrees = (int) Math.toDegrees(Math.atan2(y8 - (getHeight() / 2), x6 - (getWidth() / 2)));
        int i10 = degrees + 90;
        if (i10 < 0) {
            i10 = degrees + 450;
        }
        float f10 = i10;
        boolean z14 = this.f3891w != f10;
        if (!z10 || !z14) {
            if (z14 || z11) {
                b(f10);
            }
            this.f3892x = z13 | z12;
            return true;
        }
        z12 = true;
        this.f3892x = z13 | z12;
        return true;
    }
}
