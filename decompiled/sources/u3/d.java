package u3;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import i1.o0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends View implements f0 {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final StringBuilder I;
    public final Formatter J;
    public final androidx.activity.d K;
    public final CopyOnWriteArraySet L;
    public final Point M;
    public final float N;
    public int O;
    public long P;
    public int Q;
    public Rect R;
    public final ValueAnimator S;
    public float T;
    public boolean U;
    public boolean V;
    public long W;

    /* renamed from: a0, reason: collision with root package name */
    public long f12359a0;

    /* renamed from: b0, reason: collision with root package name */
    public long f12360b0;

    /* renamed from: c0, reason: collision with root package name */
    public long f12361c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f12362d0;

    /* renamed from: e0, reason: collision with root package name */
    public long[] f12363e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean[] f12364f0;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f12365o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f12366p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f12367q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f12368r;

    /* renamed from: s, reason: collision with root package name */
    public final Paint f12369s;

    /* renamed from: t, reason: collision with root package name */
    public final Paint f12370t;

    /* renamed from: u, reason: collision with root package name */
    public final Paint f12371u;

    /* renamed from: v, reason: collision with root package name */
    public final Paint f12372v;

    /* renamed from: w, reason: collision with root package name */
    public final Paint f12373w;

    /* renamed from: x, reason: collision with root package name */
    public final Paint f12374x;

    /* renamed from: y, reason: collision with root package name */
    public final Drawable f12375y;

    /* renamed from: z, reason: collision with root package name */
    public final int f12376z;

    public d(Context context, AttributeSet attributeSet) {
        super(context, null, 0);
        this.f12365o = new Rect();
        this.f12366p = new Rect();
        this.f12367q = new Rect();
        this.f12368r = new Rect();
        Paint paint = new Paint();
        this.f12369s = paint;
        Paint paint2 = new Paint();
        this.f12370t = paint2;
        Paint paint3 = new Paint();
        this.f12371u = paint3;
        Paint paint4 = new Paint();
        this.f12372v = paint4;
        Paint paint5 = new Paint();
        this.f12373w = paint5;
        Paint paint6 = new Paint();
        this.f12374x = paint6;
        paint6.setAntiAlias(true);
        this.L = new CopyOnWriteArraySet();
        this.M = new Point();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.N = f10;
        this.H = a(-50, f10);
        int a10 = a(4, f10);
        int a11 = a(26, f10);
        int a12 = a(4, f10);
        int a13 = a(12, f10);
        int a14 = a(0, f10);
        int a15 = a(16, f10);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, z.f12510b, 0, R.style.ExoStyledControls_TimeBar);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(10);
                this.f12375y = drawable;
                if (drawable != null) {
                    drawable.setLayoutDirection(getLayoutDirection());
                    a11 = Math.max(drawable.getMinimumHeight(), a11);
                }
                this.f12376z = obtainStyledAttributes.getDimensionPixelSize(3, a10);
                this.A = obtainStyledAttributes.getDimensionPixelSize(12, a11);
                this.B = obtainStyledAttributes.getInt(2, 0);
                this.C = obtainStyledAttributes.getDimensionPixelSize(1, a12);
                this.D = obtainStyledAttributes.getDimensionPixelSize(11, a13);
                this.E = obtainStyledAttributes.getDimensionPixelSize(8, a14);
                this.F = obtainStyledAttributes.getDimensionPixelSize(9, a15);
                int i10 = obtainStyledAttributes.getInt(6, -1);
                int i11 = obtainStyledAttributes.getInt(7, -1);
                int i12 = obtainStyledAttributes.getInt(4, -855638017);
                int i13 = obtainStyledAttributes.getInt(13, 872415231);
                int i14 = obtainStyledAttributes.getInt(0, -1291845888);
                int i15 = obtainStyledAttributes.getInt(5, 872414976);
                paint.setColor(i10);
                paint6.setColor(i11);
                paint2.setColor(i12);
                paint3.setColor(i13);
                paint4.setColor(i14);
                paint5.setColor(i15);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.f12376z = a10;
            this.A = a11;
            this.B = 0;
            this.C = a12;
            this.D = a13;
            this.E = a14;
            this.F = a15;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f12375y = null;
        }
        StringBuilder sb2 = new StringBuilder();
        this.I = sb2;
        this.J = new Formatter(sb2, Locale.getDefault());
        this.K = new androidx.activity.d(27, this);
        Drawable drawable2 = this.f12375y;
        if (drawable2 != null) {
            this.G = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.G = (Math.max(this.E, Math.max(this.D, this.F)) + 1) / 2;
        }
        this.T = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.S = valueAnimator;
        valueAnimator.addUpdateListener(new g9.h(1, this));
        this.f12359a0 = -9223372036854775807L;
        this.P = -9223372036854775807L;
        this.O = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static int a(int i10, float f10) {
        return (int) ((i10 * f10) + 0.5f);
    }

    private long getPositionIncrement() {
        long j10 = this.P;
        if (j10 != -9223372036854775807L) {
            return j10;
        }
        long j11 = this.f12359a0;
        if (j11 == -9223372036854775807L) {
            return 0L;
        }
        return j11 / this.O;
    }

    private String getProgressText() {
        return l1.a0.C(this.I, this.J, this.f12360b0);
    }

    private long getScrubberPosition() {
        if (this.f12366p.width() <= 0 || this.f12359a0 == -9223372036854775807L) {
            return 0L;
        }
        return (this.f12368r.width() * this.f12359a0) / r0.width();
    }

    public final boolean b(long j10) {
        long j11 = this.f12359a0;
        if (j11 <= 0) {
            return false;
        }
        long j12 = this.V ? this.W : this.f12360b0;
        long j13 = l1.a0.j(j12 + j10, 0L, j11);
        if (j13 == j12) {
            return false;
        }
        if (this.V) {
            f(j13);
        } else {
            c(j13);
        }
        e();
        return true;
    }

    public final void c(long j10) {
        this.W = j10;
        this.V = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.L.iterator();
        while (it.hasNext()) {
            o oVar = ((f) it.next()).f12405o;
            oVar.J0 = true;
            TextView textView = oVar.f12433a0;
            if (textView != null) {
                textView.setText(l1.a0.C(oVar.f12435c0, oVar.f12436d0, j10));
            }
            oVar.f12446o.f();
            o0 o0Var = oVar.D0;
            if (o0Var != null && oVar.L0) {
                if (oVar.i(o0Var)) {
                    try {
                        Method method = oVar.f12454s;
                        method.getClass();
                        method.invoke(oVar.D0, Boolean.TRUE);
                    } catch (IllegalAccessException | InvocationTargetException e7) {
                        throw new RuntimeException(e7);
                    }
                } else if (oVar.h(oVar.D0)) {
                    try {
                        Method method2 = oVar.f12460v;
                        method2.getClass();
                        method2.invoke(oVar.D0, Boolean.TRUE);
                    } catch (IllegalAccessException | InvocationTargetException e8) {
                        throw new RuntimeException(e8);
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder("Time bar scrubbing is enabled, but player is not an ExoPlayer or CompositionPlayer instance, so ignoring (because we can't enable scrubbing mode). player.class=");
                    o0 o0Var2 = oVar.D0;
                    o0Var2.getClass();
                    sb2.append(o0Var2.getClass());
                    l1.b.q("PlayerControlView", sb2.toString());
                }
            }
        }
    }

    public final void d(boolean z10) {
        removeCallbacks(this.K);
        this.V = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.L.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            long j10 = this.W;
            o oVar = fVar.f12405o;
            oVar.J0 = false;
            o0 o0Var = oVar.D0;
            if (o0Var != null) {
                if (!z10) {
                    o.a(oVar, o0Var, j10);
                }
                if (oVar.i(oVar.D0)) {
                    try {
                        Method method = oVar.f12454s;
                        method.getClass();
                        method.invoke(oVar.D0, Boolean.FALSE);
                    } catch (IllegalAccessException | InvocationTargetException e7) {
                        throw new RuntimeException(e7);
                    }
                } else if (oVar.h(oVar.D0)) {
                    try {
                        Method method2 = oVar.f12460v;
                        method2.getClass();
                        method2.invoke(oVar.D0, Boolean.FALSE);
                    } catch (IllegalAccessException | InvocationTargetException e8) {
                        throw new RuntimeException(e8);
                    }
                } else {
                    continue;
                }
            }
            oVar.f12446o.g();
        }
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f12375y;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void e() {
        Rect rect = this.f12367q;
        Rect rect2 = this.f12366p;
        rect.set(rect2);
        Rect rect3 = this.f12368r;
        rect3.set(rect2);
        long j10 = this.V ? this.W : this.f12360b0;
        if (this.f12359a0 > 0) {
            rect.right = Math.min(rect2.left + ((int) ((rect2.width() * this.f12361c0) / this.f12359a0)), rect2.right);
            rect3.right = Math.min(rect2.left + ((int) ((rect2.width() * j10) / this.f12359a0)), rect2.right);
        } else {
            int i10 = rect2.left;
            rect.right = i10;
            rect3.right = i10;
        }
        invalidate(this.f12365o);
    }

    public final void f(long j10) {
        if (this.W == j10) {
            return;
        }
        this.W = j10;
        Iterator it = this.L.iterator();
        while (it.hasNext()) {
            o oVar = ((f) it.next()).f12405o;
            TextView textView = oVar.f12433a0;
            if (textView != null) {
                textView.setText(l1.a0.C(oVar.f12435c0, oVar.f12436d0, j10));
            }
            if (oVar.k(oVar.D0)) {
                o.a(oVar, oVar.D0, j10);
            }
        }
    }

    public long getPreferredUpdateDelay() {
        int width = (int) (this.f12366p.width() / this.N);
        if (width == 0) {
            return Long.MAX_VALUE;
        }
        long j10 = this.f12359a0;
        if (j10 == 0 || j10 == -9223372036854775807L) {
            return Long.MAX_VALUE;
        }
        return j10 / width;
    }

    @Override // android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f12375y;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        Rect rect = this.f12366p;
        int height = rect.height();
        int centerY = rect.centerY() - (height / 2);
        int i10 = centerY + height;
        long j10 = this.f12359a0;
        Paint paint = this.f12371u;
        Rect rect2 = this.f12368r;
        if (j10 <= 0) {
            canvas2 = canvas;
            canvas2.drawRect(rect.left, centerY, rect.right, i10, paint);
        } else {
            Rect rect3 = this.f12367q;
            int i11 = rect3.left;
            int i12 = rect3.right;
            int max = Math.max(Math.max(rect.left, i12), rect2.right);
            int i13 = rect.right;
            if (max < i13) {
                canvas.drawRect(max, centerY, i13, i10, paint);
            }
            int max2 = Math.max(i11, rect2.right);
            if (i12 > max2) {
                canvas.drawRect(max2, centerY, i12, i10, this.f12370t);
            }
            if (rect2.width() > 0) {
                canvas.drawRect(rect2.left, centerY, rect2.right, i10, this.f12369s);
            }
            if (this.f12362d0 != 0) {
                long[] jArr = this.f12363e0;
                jArr.getClass();
                boolean[] zArr = this.f12364f0;
                zArr.getClass();
                int i14 = this.C;
                int i15 = i14 / 2;
                int i16 = 0;
                int i17 = 0;
                while (i17 < this.f12362d0) {
                    int i18 = i17;
                    canvas.drawRect(Math.min(rect.width() - i14, Math.max(i16, ((int) ((rect.width() * l1.a0.j(jArr[i17], 0L, this.f12359a0)) / this.f12359a0)) - i15)) + rect.left, centerY, r3 + i14, i10, zArr[i17] ? this.f12373w : this.f12372v);
                    i17 = i18 + 1;
                    i16 = i16;
                }
            }
            canvas2 = canvas;
        }
        if (this.f12359a0 > 0) {
            int i19 = l1.a0.i(rect2.right, rect2.left, rect.right);
            int centerY2 = rect2.centerY();
            Drawable drawable = this.f12375y;
            if (drawable == null) {
                canvas2.drawCircle(i19, centerY2, (int) ((((this.V || isFocused()) ? this.F : isEnabled() ? this.D : this.E) * this.T) / 2.0f), this.f12374x);
            } else {
                int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.T)) / 2;
                int intrinsicHeight = ((int) (drawable.getIntrinsicHeight() * this.T)) / 2;
                drawable.setBounds(i19 - intrinsicWidth, centerY2 - intrinsicHeight, i19 + intrinsicWidth, centerY2 + intrinsicHeight);
                drawable.draw(canvas2);
            }
        }
        canvas2.restore();
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (!this.V || z10) {
            return;
        }
        d(false);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.f12359a0 <= 0) {
            return;
        }
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L2e
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L25
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L25;
                default: goto L12;
            }
        L12:
            goto L2e
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.b(r0)
            if (r0 == 0) goto L2e
            androidx.activity.d r5 = r4.K
            r4.removeCallbacks(r5)
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L25:
            boolean r0 = r4.V
            if (r0 == 0) goto L2e
            r5 = 0
            r4.d(r5)
            return r3
        L2e:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.d.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        Rect rect;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i16 - getPaddingRight();
        int i18 = this.U ? 0 : this.G;
        int i19 = this.B;
        int i20 = this.f12376z;
        int i21 = this.A;
        if (i19 == 1) {
            i14 = (i17 - getPaddingBottom()) - i21;
            i15 = ((i17 - getPaddingBottom()) - i20) - Math.max(i18 - (i20 / 2), 0);
        } else {
            i14 = (i17 - i21) / 2;
            i15 = (i17 - i20) / 2;
        }
        Rect rect2 = this.f12365o;
        rect2.set(paddingLeft, i14, paddingRight, i21 + i14);
        this.f12366p.set(rect2.left + i18, i15, rect2.right - i18, i20 + i15);
        if (Build.VERSION.SDK_INT >= 29 && ((rect = this.R) == null || rect.width() != i16 || this.R.height() != i17)) {
            Rect rect3 = new Rect(0, 0, i16, i17);
            this.R = rect3;
            setSystemGestureExclusionRects(Collections.singletonList(rect3));
        }
        e();
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int i12 = this.A;
        if (mode == 0) {
            size = i12;
        } else if (mode != 1073741824) {
            size = Math.min(i12, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), size);
        Drawable drawable = this.f12375y;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i10) {
        Drawable drawable = this.f12375y;
        if (drawable == null || !drawable.setLayoutDirection(i10)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        if (r3 != 3) goto L34;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.isEnabled()
            r1 = 0
            if (r0 == 0) goto La1
            long r2 = r9.f12359a0
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L11
            goto La1
        L11:
            float r0 = r10.getX()
            int r0 = (int) r0
            float r2 = r10.getY()
            int r2 = (int) r2
            android.graphics.Point r3 = r9.M
            r3.set(r0, r2)
            int r0 = r3.x
            int r2 = r3.y
            int r3 = r10.getAction()
            android.graphics.Rect r4 = r9.f12366p
            android.graphics.Rect r5 = r9.f12368r
            r6 = 1
            if (r3 == 0) goto L7d
            r7 = 3
            if (r3 == r6) goto L6e
            r8 = 2
            if (r3 == r8) goto L38
            if (r3 == r7) goto L6e
            goto La1
        L38:
            boolean r10 = r9.V
            if (r10 == 0) goto La1
            int r10 = r9.H
            if (r2 >= r10) goto L52
            int r10 = r9.Q
            int r0 = r0 - r10
            int r0 = r0 / r7
            int r0 = r0 + r10
            float r10 = (float) r0
            int r10 = (int) r10
            int r0 = r4.left
            int r1 = r4.right
            int r10 = l1.a0.i(r10, r0, r1)
            r5.right = r10
            goto L60
        L52:
            r9.Q = r0
            float r10 = (float) r0
            int r10 = (int) r10
            int r0 = r4.left
            int r1 = r4.right
            int r10 = l1.a0.i(r10, r0, r1)
            r5.right = r10
        L60:
            long r0 = r9.getScrubberPosition()
            r9.f(r0)
            r9.e()
            r9.invalidate()
            return r6
        L6e:
            boolean r0 = r9.V
            if (r0 == 0) goto La1
            int r10 = r10.getAction()
            if (r10 != r7) goto L79
            r1 = r6
        L79:
            r9.d(r1)
            return r6
        L7d:
            float r10 = (float) r0
            float r0 = (float) r2
            int r10 = (int) r10
            int r0 = (int) r0
            android.graphics.Rect r2 = r9.f12365o
            boolean r0 = r2.contains(r10, r0)
            if (r0 == 0) goto La1
            int r0 = r4.left
            int r1 = r4.right
            int r10 = l1.a0.i(r10, r0, r1)
            r5.right = r10
            long r0 = r9.getScrubberPosition()
            r9.c(r0)
            r9.e()
            r9.invalidate()
            return r6
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.d.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i10, Bundle bundle) {
        if (super.performAccessibilityAction(i10, bundle)) {
            return true;
        }
        if (this.f12359a0 <= 0) {
            return false;
        }
        if (i10 == 8192) {
            if (b(-getPositionIncrement())) {
                d(false);
            }
        } else {
            if (i10 != 4096) {
                return false;
            }
            if (b(getPositionIncrement())) {
                d(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(int i10) {
        this.f12372v.setColor(i10);
        invalidate(this.f12365o);
    }

    public void setBufferedColor(int i10) {
        this.f12370t.setColor(i10);
        invalidate(this.f12365o);
    }

    public void setBufferedPosition(long j10) {
        if (this.f12361c0 == j10) {
            return;
        }
        this.f12361c0 = j10;
        e();
    }

    public void setDuration(long j10) {
        if (this.f12359a0 == j10) {
            return;
        }
        this.f12359a0 = j10;
        if (this.V && j10 == -9223372036854775807L) {
            d(true);
        }
        e();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!this.V || z10) {
            return;
        }
        d(true);
    }

    public void setKeyCountIncrement(int i10) {
        l1.d.b(i10 > 0);
        this.O = i10;
        this.P = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j10) {
        l1.d.b(j10 > 0);
        this.O = -1;
        this.P = j10;
    }

    public void setPlayedAdMarkerColor(int i10) {
        this.f12373w.setColor(i10);
        invalidate(this.f12365o);
    }

    public void setPlayedColor(int i10) {
        this.f12369s.setColor(i10);
        invalidate(this.f12365o);
    }

    public void setPosition(long j10) {
        if (this.f12360b0 == j10) {
            return;
        }
        this.f12360b0 = j10;
        setContentDescription(getProgressText());
        e();
    }

    public void setScrubberColor(int i10) {
        this.f12374x.setColor(i10);
        invalidate(this.f12365o);
    }

    public void setUnplayedColor(int i10) {
        this.f12371u.setColor(i10);
        invalidate(this.f12365o);
    }
}
