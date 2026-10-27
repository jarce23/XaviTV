package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import g9.s;
import h7.g;
import java.util.ArrayList;
import k7.a;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CastSeekBar extends View {

    /* renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f3176x = 0;

    /* renamed from: o, reason: collision with root package name */
    public final a f3177o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f3178p;

    /* renamed from: q, reason: collision with root package name */
    public final float f3179q;

    /* renamed from: r, reason: collision with root package name */
    public final float f3180r;

    /* renamed from: s, reason: collision with root package name */
    public final float f3181s;

    /* renamed from: t, reason: collision with root package name */
    public final Paint f3182t;

    /* renamed from: u, reason: collision with root package name */
    public final int f3183u;

    /* renamed from: v, reason: collision with root package name */
    public final int f3184v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3185w;

    public CastSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3178p = new ArrayList();
        setAccessibilityDelegate(new s(1, this));
        Paint paint = new Paint(1);
        this.f3182t = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3179q = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_width);
        this.f3180r = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_height);
        this.f3181s = context.getResources().getDimension(R.dimen.cast_seek_bar_progress_height) / 2.0f;
        context.getResources().getDimension(R.dimen.cast_seek_bar_thumb_size);
        context.getResources().getDimension(R.dimen.cast_seek_bar_ad_break_minimum_width);
        this.f3177o = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, g.f5740a, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(18, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(20, 0);
        int resourceId3 = obtainStyledAttributes.getResourceId(23, 0);
        int resourceId4 = obtainStyledAttributes.getResourceId(0, 0);
        this.f3183u = context.getResources().getColor(resourceId);
        context.getResources().getColor(resourceId2);
        this.f3184v = context.getResources().getColor(resourceId3);
        this.f3185w = context.getResources().getColor(resourceId4);
        obtainStyledAttributes.recycle();
    }

    public final void a(Canvas canvas, int i10, int i11, int i12, int i13) {
        Paint paint = this.f3182t;
        paint.setColor(i13);
        float f10 = 1;
        float f11 = i12;
        float f12 = this.f3181s;
        canvas.drawRect((i10 / f10) * f11, -f12, (i11 / f10) * f11, f12, paint);
    }

    public int getMaxProgress() {
        this.f3177o.getClass();
        return 1;
    }

    public int getProgress() {
        this.f3177o.getClass();
        return 0;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        CastSeekBar castSeekBar;
        Canvas canvas2;
        int i10;
        int i11;
        int save = canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int progress = getProgress();
        int save2 = canvas.save();
        canvas.translate(0.0f, measuredHeight / 2);
        this.f3177o.getClass();
        int i12 = 0;
        int max = Math.max(0, 0);
        if (max > 0) {
            i10 = max;
            castSeekBar = this;
            canvas2 = canvas;
            castSeekBar.a(canvas2, 0, i10, measuredWidth, this.f3184v);
        } else {
            castSeekBar = this;
            canvas2 = canvas;
            i10 = max;
        }
        if (progress > i10) {
            castSeekBar.a(canvas2, i10, progress, measuredWidth, castSeekBar.f3183u);
            i11 = progress;
        } else {
            i11 = progress;
        }
        if (1 > i11) {
            castSeekBar.a(canvas2, i11, 1, measuredWidth, castSeekBar.f3184v);
        }
        canvas2.restoreToCount(save2);
        ArrayList arrayList = castSeekBar.f3178p;
        if (arrayList != null && !arrayList.isEmpty()) {
            castSeekBar.f3182t.setColor(castSeekBar.f3185w);
            getMeasuredWidth();
            getPaddingLeft();
            getPaddingRight();
            int measuredHeight2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int save3 = canvas2.save();
            canvas2.translate(0.0f, measuredHeight2 / 2);
            int size = arrayList.size();
            while (i12 < size) {
                Object obj = arrayList.get(i12);
                i12++;
                if (obj != null) {
                    throw new ClassCastException();
                }
            }
            canvas2.restoreToCount(save3);
        }
        isEnabled();
        canvas2.restoreToCount(save);
    }

    @Override // android.view.View
    public final synchronized void onMeasure(int i10, int i11) {
        float paddingLeft = getPaddingLeft();
        setMeasuredDimension(View.resolveSizeAndState((int) (this.f3179q + paddingLeft + getPaddingRight()), i10, 0), View.resolveSizeAndState((int) (this.f3180r + getPaddingTop() + getPaddingBottom()), i11, 0));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        this.f3177o.getClass();
        return false;
    }
}
