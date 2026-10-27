package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bumptech.glide.manager.o;
import u3.a;
import u3.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f1200r = 0;

    /* renamed from: o, reason: collision with root package name */
    public final o f1201o;

    /* renamed from: p, reason: collision with root package name */
    public float f1202p;

    /* renamed from: q, reason: collision with root package name */
    public int f1203q;

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1203q = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, z.f12509a, 0, 0);
            try {
                this.f1203q = obtainStyledAttributes.getInt(0, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f1201o = new o(this);
    }

    public int getResizeMode() {
        return this.f1203q;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        float f10;
        float f11;
        super.onMeasure(i10, i11);
        if (this.f1202p <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f12 = measuredWidth;
        float f13 = measuredHeight;
        float f14 = (this.f1202p / (f12 / f13)) - 1.0f;
        float abs = Math.abs(f14);
        o oVar = this.f1201o;
        if (abs <= 0.01f) {
            if (oVar.f3080p) {
                return;
            }
            oVar.f3080p = true;
            ((AspectRatioFrameLayout) oVar.f3081q).post(oVar);
            return;
        }
        int i12 = this.f1203q;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 == 2) {
                    f10 = this.f1202p;
                } else if (i12 == 4) {
                    if (f14 > 0.0f) {
                        f10 = this.f1202p;
                    } else {
                        f11 = this.f1202p;
                    }
                }
                measuredWidth = (int) (f13 * f10);
            } else {
                f11 = this.f1202p;
            }
            measuredHeight = (int) (f12 / f11);
        } else if (f14 > 0.0f) {
            f11 = this.f1202p;
            measuredHeight = (int) (f12 / f11);
        } else {
            f10 = this.f1202p;
            measuredWidth = (int) (f13 * f10);
        }
        if (!oVar.f3080p) {
            oVar.f3080p = true;
            ((AspectRatioFrameLayout) oVar.f3081q).post(oVar);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f10) {
        if (this.f1202p != f10) {
            this.f1202p = f10;
            requestLayout();
        }
    }

    public void setResizeMode(int i10) {
        if (this.f1203q != i10) {
            this.f1203q = i10;
            requestLayout();
        }
    }

    public void setAspectRatioListener(a aVar) {
    }
}
