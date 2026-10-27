package androidx.leanback.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class PagingIndicator extends View {
    public static final DecelerateInterpolator K = new DecelerateInterpolator();
    public static final z L;
    public static final z M;
    public static final z N;
    public int A;
    public int B;
    public int C;
    public int D;
    public final Paint E;
    public final Paint F;
    public Bitmap G;
    public Paint H;
    public final Rect I;
    public final float J;

    /* renamed from: o, reason: collision with root package name */
    public boolean f925o;

    /* renamed from: p, reason: collision with root package name */
    public final int f926p;

    /* renamed from: q, reason: collision with root package name */
    public final int f927q;

    /* renamed from: r, reason: collision with root package name */
    public final int f928r;

    /* renamed from: s, reason: collision with root package name */
    public final int f929s;

    /* renamed from: t, reason: collision with root package name */
    public final int f930t;

    /* renamed from: u, reason: collision with root package name */
    public final int f931u;

    /* renamed from: v, reason: collision with root package name */
    public final int f932v;

    /* renamed from: w, reason: collision with root package name */
    public a0[] f933w;

    /* renamed from: x, reason: collision with root package name */
    public int[] f934x;

    /* renamed from: y, reason: collision with root package name */
    public int[] f935y;

    /* renamed from: z, reason: collision with root package name */
    public int[] f936z;

    static {
        Class<Float> cls = Float.class;
        L = new z(cls, "alpha", 0);
        M = new z(cls, "diameter", 1);
        N = new z(cls, "translation_x", 2);
    }

    public PagingIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a1.a.f10b, 0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(6, getResources().getDimensionPixelOffset(R.dimen.lb_page_indicator_dot_radius));
        this.f927q = dimensionPixelOffset;
        int i10 = dimensionPixelOffset * 2;
        this.f926p = i10;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(2, getResources().getDimensionPixelOffset(R.dimen.lb_page_indicator_arrow_radius));
        this.f930t = dimensionPixelOffset2;
        int i11 = dimensionPixelOffset2 * 2;
        this.f929s = i11;
        this.f928r = obtainStyledAttributes.getDimensionPixelOffset(5, getResources().getDimensionPixelOffset(R.dimen.lb_page_indicator_dot_gap));
        this.f931u = obtainStyledAttributes.getDimensionPixelOffset(4, getResources().getDimensionPixelOffset(R.dimen.lb_page_indicator_arrow_gap));
        int color = obtainStyledAttributes.getColor(3, getResources().getColor(R.color.lb_page_indicator_dot));
        Paint paint = new Paint(1);
        this.E = paint;
        paint.setColor(color);
        this.D = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.lb_page_indicator_arrow_background));
        if (this.H == null && obtainStyledAttributes.hasValue(1)) {
            setArrowColor(obtainStyledAttributes.getColor(1, 0));
        }
        obtainStyledAttributes.recycle();
        this.f925o = resources.getConfiguration().getLayoutDirection() == 0;
        int color2 = resources.getColor(R.color.lb_page_indicator_arrow_shadow);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.lb_page_indicator_arrow_shadow_radius);
        this.f932v = dimensionPixelSize;
        Paint paint2 = new Paint(1);
        this.F = paint2;
        float dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.lb_page_indicator_arrow_shadow_offset);
        paint2.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, color2);
        this.G = d();
        this.I = new Rect(0, 0, this.G.getWidth(), this.G.getHeight());
        float f10 = i11;
        this.J = this.G.getWidth() / f10;
        AnimatorSet animatorSet2 = new AnimatorSet();
        z zVar = L;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, zVar, 0.0f, 1.0f);
        ofFloat.setDuration(167L);
        DecelerateInterpolator decelerateInterpolator = K;
        ofFloat.setInterpolator(decelerateInterpolator);
        float f11 = i10;
        z zVar2 = M;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((Object) null, zVar2, f11, f10);
        ofFloat2.setDuration(417L);
        ofFloat2.setInterpolator(decelerateInterpolator);
        animatorSet2.playTogether(ofFloat, ofFloat2, c());
        AnimatorSet animatorSet3 = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat((Object) null, zVar, 1.0f, 0.0f);
        ofFloat3.setDuration(167L);
        ofFloat3.setInterpolator(decelerateInterpolator);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat((Object) null, zVar2, f10, f11);
        ofFloat4.setDuration(417L);
        ofFloat4.setInterpolator(decelerateInterpolator);
        animatorSet3.playTogether(ofFloat3, ofFloat4, c());
        animatorSet.playTogether(animatorSet2, animatorSet3);
        setLayerType(1, null);
    }

    private int getDesiredHeight() {
        return getPaddingBottom() + getPaddingTop() + this.f929s + this.f932v;
    }

    private int getDesiredWidth() {
        return getPaddingRight() + getPaddingLeft() + getRequiredWidth();
    }

    private int getRequiredWidth() {
        return ((this.B - 3) * this.f928r) + (this.f931u * 2) + (this.f927q * 2);
    }

    private void setSelectedPage(int i10) {
        if (i10 == this.C) {
            return;
        }
        this.C = i10;
        a();
    }

    public final void a() {
        int i10;
        int i11 = 0;
        while (true) {
            i10 = this.C;
            if (i11 >= i10) {
                break;
            }
            this.f933w[i11].b();
            a0 a0Var = this.f933w[i11];
            if (i11 != 0) {
                r2 = 1.0f;
            }
            a0Var.f1007h = r2;
            a0Var.f1004d = this.f935y[i11];
            i11++;
        }
        a0 a0Var2 = this.f933w[i10];
        a0Var2.f1003c = 0.0f;
        a0Var2.f1004d = 0.0f;
        PagingIndicator pagingIndicator = a0Var2.f1009j;
        a0Var2.f1005e = pagingIndicator.f929s;
        float f10 = pagingIndicator.f930t;
        a0Var2.f1006f = f10;
        a0Var2.g = f10 * pagingIndicator.J;
        a0Var2.f1001a = 1.0f;
        a0Var2.a();
        a0[] a0VarArr = this.f933w;
        int i12 = this.C;
        a0 a0Var3 = a0VarArr[i12];
        a0Var3.f1007h = i12 <= 0 ? 1.0f : -1.0f;
        a0Var3.f1004d = this.f934x[i12];
        while (true) {
            i12++;
            if (i12 >= this.B) {
                return;
            }
            this.f933w[i12].b();
            a0 a0Var4 = this.f933w[i12];
            a0Var4.f1007h = 1.0f;
            a0Var4.f1004d = this.f936z[i12];
        }
    }

    public final void b() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int requiredWidth = getRequiredWidth();
        int i10 = (paddingLeft + width) / 2;
        int i11 = this.B;
        int[] iArr = new int[i11];
        this.f934x = iArr;
        int[] iArr2 = new int[i11];
        this.f935y = iArr2;
        int[] iArr3 = new int[i11];
        this.f936z = iArr3;
        boolean z10 = this.f925o;
        int i12 = this.f927q;
        int i13 = this.f931u;
        int i14 = this.f928r;
        int i15 = 1;
        if (z10) {
            int i16 = i10 - (requiredWidth / 2);
            iArr[0] = ((i16 + i12) - i14) + i13;
            iArr2[0] = i16 + i12;
            iArr3[0] = (i13 * 2) + ((i16 + i12) - (i14 * 2));
            while (i15 < this.B) {
                int[] iArr4 = this.f934x;
                int[] iArr5 = this.f935y;
                int i17 = i15 - 1;
                iArr4[i15] = iArr5[i17] + i13;
                iArr5[i15] = iArr5[i17] + i14;
                this.f936z[i15] = iArr4[i17] + i13;
                i15++;
            }
        } else {
            int i18 = (requiredWidth / 2) + i10;
            iArr[0] = ((i18 - i12) + i14) - i13;
            iArr2[0] = i18 - i12;
            iArr3[0] = ((i14 * 2) + (i18 - i12)) - (i13 * 2);
            while (i15 < this.B) {
                int[] iArr6 = this.f934x;
                int[] iArr7 = this.f935y;
                int i19 = i15 - 1;
                iArr6[i15] = iArr7[i19] - i13;
                iArr7[i15] = iArr7[i19] - i14;
                this.f936z[i15] = iArr6[i19] - i13;
                i15++;
            }
        }
        this.A = paddingTop + this.f930t;
        a();
    }

    public final ObjectAnimator c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, N, (-this.f931u) + this.f928r, 0.0f);
        ofFloat.setDuration(417L);
        ofFloat.setInterpolator(K);
        return ofFloat;
    }

    public final Bitmap d() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.lb_ic_nav_arrow);
        if (this.f925o) {
            return decodeResource;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, false);
    }

    public int[] getDotSelectedLeftX() {
        return this.f935y;
    }

    public int[] getDotSelectedRightX() {
        return this.f936z;
    }

    public int[] getDotSelectedX() {
        return this.f934x;
    }

    public int getPageCount() {
        return this.B;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        for (int i10 = 0; i10 < this.B; i10++) {
            a0 a0Var = this.f933w[i10];
            float f10 = a0Var.f1004d + a0Var.f1003c;
            PagingIndicator pagingIndicator = a0Var.f1009j;
            int i11 = pagingIndicator.A;
            Paint paint = pagingIndicator.F;
            canvas.drawCircle(f10, i11, a0Var.f1006f, pagingIndicator.E);
            if (a0Var.f1001a > 0.0f) {
                paint.setColor(a0Var.f1002b);
                canvas.drawCircle(f10, pagingIndicator.A, a0Var.f1006f, paint);
                Bitmap bitmap = pagingIndicator.G;
                Rect rect = pagingIndicator.I;
                float f11 = a0Var.g;
                float f12 = pagingIndicator.A;
                canvas.drawBitmap(bitmap, rect, new Rect((int) (f10 - f11), (int) (f12 - f11), (int) (f10 + f11), (int) (f12 + f11)), pagingIndicator.H);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int desiredHeight = getDesiredHeight();
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE) {
            desiredHeight = Math.min(desiredHeight, View.MeasureSpec.getSize(i11));
        } else if (mode == 1073741824) {
            desiredHeight = View.MeasureSpec.getSize(i11);
        }
        int desiredWidth = getDesiredWidth();
        int mode2 = View.MeasureSpec.getMode(i10);
        if (mode2 == Integer.MIN_VALUE) {
            desiredWidth = Math.min(desiredWidth, View.MeasureSpec.getSize(i10));
        } else if (mode2 == 1073741824) {
            desiredWidth = View.MeasureSpec.getSize(i10);
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = i10 == 0;
        if (this.f925o != z10) {
            this.f925o = z10;
            this.G = d();
            a0[] a0VarArr = this.f933w;
            if (a0VarArr != null) {
                for (a0 a0Var : a0VarArr) {
                    a0Var.f1008i = a0Var.f1009j.f925o ? 1.0f : -1.0f;
                }
            }
            b();
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        setMeasuredDimension(i10, i11);
        b();
    }

    public void setArrowBackgroundColor(int i10) {
        this.D = i10;
    }

    public void setArrowColor(int i10) {
        if (this.H == null) {
            this.H = new Paint();
        }
        this.H.setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.SRC_IN));
    }

    public void setDotBackgroundColor(int i10) {
        this.E.setColor(i10);
    }

    public void setPageCount(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The page count should be a positive integer");
        }
        this.B = i10;
        this.f933w = new a0[i10];
        for (int i11 = 0; i11 < this.B; i11++) {
            this.f933w[i11] = new a0(this);
        }
        b();
        setSelectedPage(0);
    }
}
