package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class SeekBar extends View {
    public int A;
    public int B;

    /* renamed from: o, reason: collision with root package name */
    public final RectF f975o;

    /* renamed from: p, reason: collision with root package name */
    public final RectF f976p;

    /* renamed from: q, reason: collision with root package name */
    public final RectF f977q;

    /* renamed from: r, reason: collision with root package name */
    public final Paint f978r;

    /* renamed from: s, reason: collision with root package name */
    public final Paint f979s;

    /* renamed from: t, reason: collision with root package name */
    public final Paint f980t;

    /* renamed from: u, reason: collision with root package name */
    public final Paint f981u;

    /* renamed from: v, reason: collision with root package name */
    public int f982v;

    /* renamed from: w, reason: collision with root package name */
    public int f983w;

    /* renamed from: x, reason: collision with root package name */
    public int f984x;

    /* renamed from: y, reason: collision with root package name */
    public int f985y;

    /* renamed from: z, reason: collision with root package name */
    public int f986z;

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f975o = new RectF();
        this.f976p = new RectF();
        this.f977q = new RectF();
        Paint paint = new Paint(1);
        this.f978r = paint;
        Paint paint2 = new Paint(1);
        this.f979s = paint2;
        Paint paint3 = new Paint(1);
        this.f980t = paint3;
        Paint paint4 = new Paint(1);
        this.f981u = paint4;
        setWillNotDraw(false);
        paint3.setColor(-7829368);
        paint.setColor(-3355444);
        paint2.setColor(-65536);
        paint4.setColor(-1);
        this.A = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_bar_height);
        this.B = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_active_bar_height);
        this.f986z = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_active_radius);
    }

    public final void a() {
        int i10 = isFocused() ? this.B : this.A;
        int width = getWidth();
        int height = getHeight();
        int i11 = (height - i10) / 2;
        int i12 = this.A;
        float f10 = i11;
        float f11 = height - i11;
        this.f977q.set(i12 / 2, f10, width - (i12 / 2), f11);
        int i13 = isFocused() ? this.f986z : this.A / 2;
        float f12 = width - (i13 * 2);
        float f13 = (this.f982v / this.f984x) * f12;
        int i14 = this.A;
        RectF rectF = this.f975o;
        rectF.set(i14 / 2, f10, (i14 / 2) + f13, f11);
        this.f976p.set(rectF.right, f10, (this.A / 2) + ((this.f983w / this.f984x) * f12), f11);
        this.f985y = i13 + ((int) f13);
        invalidate();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    public int getMax() {
        return this.f984x;
    }

    public int getProgress() {
        return this.f982v;
    }

    public int getSecondProgress() {
        return this.f983w;
    }

    public int getSecondaryProgressColor() {
        return this.f978r.getColor();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f10 = isFocused() ? this.f986z : this.A / 2;
        canvas.drawRoundRect(this.f977q, f10, f10, this.f980t);
        RectF rectF = this.f976p;
        if (rectF.right > rectF.left) {
            canvas.drawRoundRect(rectF, f10, f10, this.f978r);
        }
        canvas.drawRoundRect(this.f975o, f10, f10, this.f979s);
        canvas.drawCircle(this.f985y, getHeight() / 2, f10, this.f981u);
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        a();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public void setActiveBarHeight(int i10) {
        this.B = i10;
        a();
    }

    public void setActiveRadius(int i10) {
        this.f986z = i10;
        a();
    }

    public void setBarHeight(int i10) {
        this.A = i10;
        a();
    }

    public void setMax(int i10) {
        this.f984x = i10;
        a();
    }

    public void setProgress(int i10) {
        int i11 = this.f984x;
        if (i10 > i11) {
            i10 = i11;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.f982v = i10;
        a();
    }

    public void setProgressColor(int i10) {
        this.f979s.setColor(i10);
    }

    public void setSecondaryProgress(int i10) {
        int i11 = this.f984x;
        if (i10 > i11) {
            i10 = i11;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.f983w = i10;
        a();
    }

    public void setSecondaryProgressColor(int i10) {
        this.f978r.setColor(i10);
    }

    public void setAccessibilitySeekListener(n0 n0Var) {
    }
}
