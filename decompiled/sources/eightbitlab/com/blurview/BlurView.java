package eightbitlab.com.blurview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import z9.c;
import z9.e;
import z9.f;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class BlurView extends FrameLayout {

    /* renamed from: o, reason: collision with root package name */
    public c f4682o;

    /* renamed from: p, reason: collision with root package name */
    public final int f4683p;

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4682o = new e();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.f14161a, 0, 0);
        this.f4683p = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (this.f4682o.b(canvas)) {
            super.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isHardwareAccelerated()) {
            this.f4682o.d(true);
        } else {
            Log.e("BlurView", "BlurView can't be used in not hardware-accelerated window!");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4682o.d(false);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f4682o.a();
    }
}
