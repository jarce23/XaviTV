package com.iarcuschin.simpleratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.BounceInterpolator;
import org.chromium.net.R;
import x9.a;
import x9.b;
import x9.c;
import x9.d;
import x9.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SimpleRatingBar extends View {
    public float A;
    public float B;
    public boolean C;
    public c D;
    public float E;
    public float F;
    public boolean G;
    public float H;
    public final float I;
    public final Paint J;
    public final Paint K;
    public final Paint L;
    public final Paint M;
    public CornerPathEffect N;
    public final Path O;
    public View.OnClickListener P;
    public boolean Q;
    public float[] R;
    public RectF S;
    public RectF T;
    public Canvas U;
    public Bitmap V;

    /* renamed from: o, reason: collision with root package name */
    public int f3923o;

    /* renamed from: p, reason: collision with root package name */
    public int f3924p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3925q;

    /* renamed from: r, reason: collision with root package name */
    public int f3926r;

    /* renamed from: s, reason: collision with root package name */
    public int f3927s;

    /* renamed from: t, reason: collision with root package name */
    public int f3928t;

    /* renamed from: u, reason: collision with root package name */
    public final int f3929u;

    /* renamed from: v, reason: collision with root package name */
    public int f3930v;

    /* renamed from: w, reason: collision with root package name */
    public int f3931w;

    /* renamed from: x, reason: collision with root package name */
    public float f3932x;

    /* renamed from: y, reason: collision with root package name */
    public float f3933y;

    /* renamed from: z, reason: collision with root package name */
    public float f3934z;

    public SimpleRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c cVar;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.f13746a);
        int color = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.golden_stars));
        this.f3923o = color;
        this.f3924p = obtainStyledAttributes.getColor(3, color);
        this.f3926r = obtainStyledAttributes.getColor(13, 0);
        this.f3925q = obtainStyledAttributes.getColor(0, 0);
        this.f3927s = obtainStyledAttributes.getColor(9, this.f3923o);
        this.f3928t = obtainStyledAttributes.getColor(10, this.f3924p);
        this.f3930v = obtainStyledAttributes.getColor(11, this.f3926r);
        this.f3929u = obtainStyledAttributes.getColor(8, this.f3925q);
        this.f3931w = obtainStyledAttributes.getInteger(7, 5);
        this.f3932x = obtainStyledAttributes.getDimensionPixelSize(17, (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()));
        this.f3934z = obtainStyledAttributes.getDimensionPixelSize(6, Integer.MAX_VALUE);
        this.f3933y = obtainStyledAttributes.getDimensionPixelSize(16, Integer.MAX_VALUE);
        this.A = obtainStyledAttributes.getFloat(18, 0.1f);
        this.E = obtainStyledAttributes.getFloat(14, 5.0f);
        this.F = obtainStyledAttributes.getFloat(15, 6.0f);
        this.B = e(obtainStyledAttributes.getFloat(12, 0.0f));
        this.C = obtainStyledAttributes.getBoolean(5, false);
        this.G = obtainStyledAttributes.getBoolean(2, true);
        int i10 = obtainStyledAttributes.getInt(4, 0);
        c[] values = c.values();
        int length = values.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                Log.w("SimpleRatingBar", "Gravity chosen is neither 'left' nor 'right', I will set it to Left");
                cVar = c.Left;
                break;
            } else {
                cVar = values[i11];
                if (cVar.f13750o == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.D = cVar;
        obtainStyledAttributes.recycle();
        if (this.f3931w <= 0) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for numberOfStars. Found %d, but should be greater than 0", Integer.valueOf(this.f3931w)));
        }
        float f10 = this.f3933y;
        if (f10 != 2.14748365E9f) {
            float f11 = this.f3934z;
            if (f11 != 2.14748365E9f && f10 > f11) {
                Log.w("SimpleRatingBar", String.format("Initialized with conflicting values: starSize is greater than maxStarSize (%f > %f). I will ignore maxStarSize", Float.valueOf(f10), Float.valueOf(this.f3934z)));
            }
        }
        if (this.A <= 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for stepSize. Found %f, but should be greater than 0", Float.valueOf(this.A)));
        }
        if (this.E <= 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starBorderWidth. Found %f, but should be greater than 0", Float.valueOf(this.E)));
        }
        if (this.F < 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starCornerRadius. Found %f, but should be greater or equal than 0", Float.valueOf(this.E)));
        }
        this.O = new Path();
        this.N = new CornerPathEffect(this.F);
        Paint paint = new Paint(5);
        this.J = paint;
        Paint.Style style = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style);
        this.J.setAntiAlias(true);
        this.J.setDither(true);
        Paint paint2 = this.J;
        Paint.Join join = Paint.Join.ROUND;
        paint2.setStrokeJoin(join);
        Paint paint3 = this.J;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        this.J.setColor(-16777216);
        this.J.setPathEffect(this.N);
        Paint paint4 = new Paint(5);
        this.K = paint4;
        paint4.setStyle(Paint.Style.STROKE);
        this.K.setStrokeJoin(join);
        this.K.setStrokeCap(cap);
        this.K.setStrokeWidth(this.E);
        this.K.setPathEffect(this.N);
        Paint paint5 = new Paint(5);
        this.M = paint5;
        paint5.setStyle(style);
        this.M.setAntiAlias(true);
        this.M.setDither(true);
        this.M.setStrokeJoin(join);
        this.M.setStrokeCap(cap);
        Paint paint6 = new Paint(5);
        this.L = paint6;
        paint6.setStyle(style);
        this.L.setAntiAlias(true);
        this.L.setDither(true);
        this.L.setStrokeJoin(join);
        this.L.setStrokeCap(cap);
        this.I = TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics());
    }

    public final int a(float f10, boolean z10) {
        int i10;
        int round = Math.round(f10);
        if (z10) {
            i10 = getPaddingBottom() + getPaddingTop();
        } else {
            i10 = 0;
        }
        return round + i10;
    }

    public final int b(float f10, int i10, float f11, boolean z10) {
        int i11;
        int round = Math.round((f11 * (i10 - 1)) + (f10 * i10));
        if (z10) {
            i11 = getPaddingRight() + getPaddingLeft();
        } else {
            i11 = 0;
        }
        return round + i11;
    }

    public final void c(Canvas canvas, float f10, float f11, float f12, c cVar) {
        float f13 = this.H * f12;
        this.O.reset();
        float[] fArr = this.R;
        this.O.moveTo(fArr[0] + f10, fArr[1] + f11);
        int i10 = 2;
        while (true) {
            float[] fArr2 = this.R;
            if (i10 >= fArr2.length) {
                break;
            }
            this.O.lineTo(fArr2[i10] + f10, fArr2[i10 + 1] + f11);
            i10 += 2;
        }
        this.O.close();
        canvas.drawPath(this.O, this.J);
        if (cVar == c.Left) {
            float f14 = f13 + f10;
            float f15 = this.H;
            canvas.drawRect(f10, f11, (0.02f * f15) + f14, f11 + f15, this.L);
            float f16 = this.H;
            canvas.drawRect(f14, f11, f10 + f16, f11 + f16, this.M);
        } else {
            float f17 = this.H;
            float f18 = f10 + f17;
            canvas.drawRect(f18 - ((0.02f * f17) + f13), f11, f18, f11 + f17, this.L);
            float f19 = this.H;
            canvas.drawRect(f10, f11, (f10 + f19) - f13, f11 + f19, this.M);
        }
        if (this.G) {
            canvas.drawPath(this.O, this.K);
        }
    }

    public final void d(int i10, int i11) {
        Bitmap bitmap = this.V;
        if (bitmap != null) {
            bitmap.recycle();
        }
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        this.V = createBitmap;
        createBitmap.eraseColor(0);
        this.U = new Canvas(this.V);
    }

    public final float e(float f10) {
        if (f10 < 0.0f) {
            Log.w("SimpleRatingBar", String.format("Assigned rating is less than 0 (%f < 0), I will set it to exactly 0", Float.valueOf(f10)));
            return 0.0f;
        }
        if (f10 <= this.f3931w) {
            return f10;
        }
        Log.w("SimpleRatingBar", String.format("Assigned rating is greater than numberOfStars (%f > %d), I will set it to exactly numberOfStars", Float.valueOf(f10), Integer.valueOf(this.f3931w)));
        return this.f3931w;
    }

    public final void f(float f10) {
        if (this.D != c.Left) {
            f10 = getWidth() - f10;
        }
        RectF rectF = this.S;
        float f11 = rectF.left;
        if (f10 < f11) {
            this.B = 0.0f;
            return;
        }
        if (f10 > rectF.right) {
            this.B = this.f3931w;
            return;
        }
        float width = (this.f3931w / rectF.width()) * (f10 - f11);
        this.B = width;
        float f12 = this.A;
        float f13 = width % f12;
        if (f13 < f12 / 4.0f) {
            float f14 = width - f13;
            this.B = f14;
            this.B = Math.max(0.0f, f14);
        } else {
            float f15 = (width - f13) + f12;
            this.B = f15;
            this.B = Math.min(this.f3931w, f15);
        }
    }

    public b getAnimationBuilder() {
        b bVar = new b();
        new BounceInterpolator();
        getNumberOfStars();
        return bVar;
    }

    public int getBorderColor() {
        return this.f3923o;
    }

    public int getFillColor() {
        return this.f3924p;
    }

    public c getGravity() {
        return this.D;
    }

    public float getMaxStarSize() {
        return this.f3934z;
    }

    public int getNumberOfStars() {
        return this.f3931w;
    }

    public int getPressedBorderColor() {
        return this.f3927s;
    }

    public int getPressedFillColor() {
        return this.f3928t;
    }

    public int getPressedStarBackgroundColor() {
        return this.f3930v;
    }

    public float getRating() {
        return this.B;
    }

    public int getStarBackgroundColor() {
        return this.f3926r;
    }

    public float getStarBorderWidth() {
        return this.E;
    }

    public float getStarCornerRadius() {
        return this.F;
    }

    public float getStarSize() {
        return this.H;
    }

    public float getStarsSeparation() {
        return this.f3932x;
    }

    public float getStepSize() {
        return this.A;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f10;
        float f11;
        super.onDraw(canvas);
        int height = getHeight();
        if (getWidth() == 0 || height == 0) {
            return;
        }
        Canvas canvas2 = this.U;
        PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
        canvas2.drawColor(0, mode);
        if (this.Q) {
            this.K.setColor(this.f3927s);
            this.L.setColor(this.f3928t);
            if (this.f3928t != 0) {
                this.L.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            } else {
                this.L.setXfermode(new PorterDuffXfermode(mode));
            }
            this.M.setColor(this.f3930v);
            if (this.f3930v != 0) {
                this.M.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            } else {
                this.M.setXfermode(new PorterDuffXfermode(mode));
            }
        } else {
            this.K.setColor(this.f3923o);
            this.L.setColor(this.f3924p);
            if (this.f3924p != 0) {
                this.L.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            } else {
                this.L.setXfermode(new PorterDuffXfermode(mode));
            }
            this.M.setColor(this.f3926r);
            if (this.f3926r != 0) {
                this.M.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            } else {
                this.M.setXfermode(new PorterDuffXfermode(mode));
            }
        }
        c cVar = this.D;
        c cVar2 = c.Left;
        if (cVar == cVar2) {
            Canvas canvas3 = this.U;
            float f12 = this.B;
            RectF rectF = this.S;
            float f13 = rectF.left;
            float f14 = rectF.top;
            float f15 = f12;
            float f16 = f13;
            int i10 = 0;
            while (i10 < this.f3931w) {
                if (f15 >= 1.0f) {
                    f11 = f14;
                    c(canvas3, f16, f11, 1.0f, cVar2);
                    f15 -= 1.0f;
                } else {
                    f11 = f14;
                    c(canvas3, f16, f11, f15, cVar2);
                    f15 = 0.0f;
                }
                f16 += this.f3932x + this.H;
                i10++;
                f14 = f11;
            }
        } else {
            Canvas canvas4 = this.U;
            float f17 = this.B;
            RectF rectF2 = this.S;
            float f18 = rectF2.right - this.H;
            float f19 = rectF2.top;
            float f20 = f17;
            int i11 = 0;
            float f21 = f18;
            while (i11 < this.f3931w) {
                c cVar3 = c.Right;
                if (f20 >= 1.0f) {
                    f10 = f19;
                    c(canvas4, f21, f10, 1.0f, cVar3);
                    f20 -= 1.0f;
                } else {
                    f10 = f19;
                    c(canvas4, f21, f10, f20, cVar3);
                    f20 = 0.0f;
                }
                f21 -= this.f3932x + this.H;
                i11++;
                f19 = f10;
            }
        }
        if (this.Q) {
            canvas.drawColor(this.f3929u);
        } else {
            canvas.drawColor(this.f3925q);
        }
        canvas.drawBitmap(this.V, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        float min;
        super.onLayout(z10, i10, i11, i12, i13);
        int width = getWidth();
        int height = getHeight();
        float f10 = this.f3933y;
        if (f10 == 2.14748365E9f) {
            float f11 = this.f3934z;
            if (f11 != 2.14748365E9f) {
                float b2 = b(f11, this.f3931w, this.f3932x, true);
                float a10 = a(this.f3934z, true);
                if (b2 >= width || a10 >= height) {
                    float paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
                    float f12 = this.f3932x;
                    min = Math.min((paddingLeft - (f12 * (r5 - 1))) / this.f3931w, (height - getPaddingTop()) - getPaddingBottom());
                } else {
                    min = this.f3934z;
                }
            } else {
                float paddingLeft2 = (width - getPaddingLeft()) - getPaddingRight();
                float f13 = this.f3932x;
                min = Math.min((paddingLeft2 - (f13 * (r5 - 1))) / this.f3931w, (height - getPaddingTop()) - getPaddingBottom());
            }
            this.H = min;
        } else {
            this.H = f10;
        }
        float b10 = b(this.H, this.f3931w, this.f3932x, false);
        float a11 = a(this.H, false);
        float paddingLeft3 = ((((width - getPaddingLeft()) - getPaddingRight()) / 2) - (b10 / 2.0f)) + getPaddingLeft();
        float paddingTop = ((((height - getPaddingTop()) - getPaddingBottom()) / 2) - (a11 / 2.0f)) + getPaddingTop();
        RectF rectF = new RectF(paddingLeft3, paddingTop, b10 + paddingLeft3, a11 + paddingTop);
        this.S = rectF;
        float width2 = rectF.width() * 0.05f;
        RectF rectF2 = this.S;
        this.T = new RectF(rectF2.left - width2, rectF2.top, rectF2.right + width2, rectF2.bottom);
        float f14 = this.H;
        float f15 = 0.2f * f14;
        float f16 = 0.35f * f14;
        float f17 = 0.5f * f14;
        float f18 = 0.05f * f14;
        float f19 = 0.03f * f14;
        float f20 = 0.38f * f14;
        float f21 = 0.32f * f14;
        float f22 = 0.6f * f14;
        float f23 = f14 - f19;
        float f24 = f14 - f18;
        this.R = new float[]{f19, f20, f19 + f16, f20, f17, f18, f23 - f16, f20, f23, f20, f14 - f21, f22, f14 - f15, f24, f17, f14 - (0.27f * f14), f15, f24, f21, f22};
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                float f10 = this.f3933y;
                if (f10 != 2.14748365E9f) {
                    size = Math.min(b(f10, this.f3931w, this.f3932x, true), size);
                } else {
                    float f11 = this.f3934z;
                    size = f11 != 2.14748365E9f ? Math.min(b(f11, this.f3931w, this.f3932x, true), size) : Math.min(b(this.I, this.f3931w, this.f3932x, true), size);
                }
            } else {
                float f12 = this.f3933y;
                if (f12 != 2.14748365E9f) {
                    size = b(f12, this.f3931w, this.f3932x, true);
                } else {
                    float f13 = this.f3934z;
                    size = f13 != 2.14748365E9f ? b(f13, this.f3931w, this.f3932x, true) : b(this.I, this.f3931w, this.f3932x, true);
                }
            }
        }
        float paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        float f14 = this.f3932x;
        float f15 = (paddingLeft - (f14 * (r7 - 1))) / this.f3931w;
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                float f16 = this.f3933y;
                if (f16 != 2.14748365E9f) {
                    size2 = Math.min(a(f16, true), size2);
                } else {
                    float f17 = this.f3934z;
                    size2 = f17 != 2.14748365E9f ? Math.min(a(f17, true), size2) : Math.min(a(f15, true), size2);
                }
            } else {
                float f18 = this.f3933y;
                if (f18 != 2.14748365E9f) {
                    size2 = a(f18, true);
                } else {
                    float f19 = this.f3934z;
                    size2 = f19 != 2.14748365E9f ? a(f19, true) : a(f15, true);
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        setRating(eVar.f13751o);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f13751o = 0.0f;
        eVar.f13751o = getRating();
        return eVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        d(i10, i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
    
        if (r0 != 3) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.C
            r1 = 0
            if (r0 != 0) goto L4d
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r2 = 1
            if (r0 == 0) goto L2b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L2b
            r6 = 3
            if (r0 == r6) goto L28
            goto L47
        L17:
            float r0 = r6.getX()
            r6.getY()
            r5.f(r0)
            android.view.View$OnClickListener r6 = r5.P
            if (r6 == 0) goto L28
            r6.onClick(r5)
        L28:
            r5.Q = r1
            goto L47
        L2b:
            android.graphics.RectF r0 = r5.T
            float r3 = r6.getX()
            float r4 = r6.getY()
            boolean r0 = r0.contains(r3, r4)
            if (r0 == 0) goto L4b
            r5.Q = r2
            float r0 = r6.getX()
            r6.getY()
            r5.f(r0)
        L47:
            r5.invalidate()
            return r2
        L4b:
            r5.Q = r1
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iarcuschin.simpleratingbar.SimpleRatingBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBorderColor(int i10) {
        this.f3923o = i10;
        invalidate();
    }

    public void setDrawBorderEnabled(boolean z10) {
        this.G = z10;
        invalidate();
    }

    public void setFillColor(int i10) {
        this.f3924p = i10;
        invalidate();
    }

    public void setGravity(c cVar) {
        this.D = cVar;
        invalidate();
    }

    public void setIndicator(boolean z10) {
        this.C = z10;
        this.Q = false;
    }

    public void setMaxStarSize(float f10) {
        this.f3934z = f10;
        if (this.H > f10) {
            requestLayout();
            d(getWidth(), getHeight());
            invalidate();
        }
    }

    public void setNumberOfStars(int i10) {
        this.f3931w = i10;
        if (i10 <= 0) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for numberOfStars. Found %d, but should be greater than 0", Integer.valueOf(i10)));
        }
        this.B = 0.0f;
        requestLayout();
        d(getWidth(), getHeight());
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void setPressedBorderColor(int i10) {
        this.f3927s = i10;
        invalidate();
    }

    public void setPressedFillColor(int i10) {
        this.f3928t = i10;
        invalidate();
    }

    public void setPressedStarBackgroundColor(int i10) {
        this.f3930v = i10;
        invalidate();
    }

    public void setRating(float f10) {
        this.B = e(f10);
        invalidate();
    }

    public void setStarBackgroundColor(int i10) {
        this.f3926r = i10;
        invalidate();
    }

    public void setStarBorderWidth(float f10) {
        this.E = f10;
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starBorderWidth. Found %f, but should be greater than 0", Float.valueOf(f10)));
        }
        this.K.setStrokeWidth(f10);
        invalidate();
    }

    public void setStarCornerRadius(float f10) {
        this.F = f10;
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starCornerRadius. Found %f, but should be greater or equal than 0", Float.valueOf(f10)));
        }
        CornerPathEffect cornerPathEffect = new CornerPathEffect(f10);
        this.N = cornerPathEffect;
        this.K.setPathEffect(cornerPathEffect);
        this.J.setPathEffect(this.N);
        invalidate();
    }

    public void setStarSize(float f10) {
        this.f3933y = f10;
        if (f10 != 2.14748365E9f) {
            float f11 = this.f3934z;
            if (f11 != 2.14748365E9f && f10 > f11) {
                Log.w("SimpleRatingBar", String.format("Initialized with conflicting values: starSize is greater than maxStarSize (%f > %f). I will ignore maxStarSize", Float.valueOf(f10), Float.valueOf(this.f3934z)));
            }
        }
        requestLayout();
        d(getWidth(), getHeight());
        invalidate();
    }

    public void setStarsSeparation(float f10) {
        this.f3932x = f10;
        requestLayout();
        d(getWidth(), getHeight());
        invalidate();
    }

    public void setStepSize(float f10) {
        this.A = f10;
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for stepSize. Found %f, but should be greater than 0", Float.valueOf(f10)));
        }
        invalidate();
    }

    public void setOnRatingBarChangeListener(d dVar) {
    }
}
