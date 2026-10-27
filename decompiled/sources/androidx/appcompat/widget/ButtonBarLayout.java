package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import e.a;
import java.util.WeakHashMap;
import m0.k0;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: o, reason: collision with root package name */
    public boolean f433o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f434p;

    /* renamed from: q, reason: collision with root package name */
    public int f435q;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f435q = -1;
        int[] iArr = a.f4367k;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        k0.l(this, context, iArr, attributeSet, obtainStyledAttributes, 0);
        this.f433o = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f433o);
        }
    }

    private void setStacked(boolean z10) {
        if (this.f434p != z10) {
            if (!z10 || this.f433o) {
                this.f434p = z10;
                setOrientation(z10 ? 1 : 0);
                setGravity(z10 ? 8388613 : 80);
                View findViewById = findViewById(R.id.spacer);
                if (findViewById != null) {
                    findViewById.setVisibility(z10 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        boolean z10;
        int i13;
        int size = View.MeasureSpec.getSize(i10);
        int i14 = 0;
        if (this.f433o) {
            if (size > this.f435q && this.f434p) {
                setStacked(false);
            }
            this.f435q = size;
        }
        if (this.f434p || View.MeasureSpec.getMode(i10) != 1073741824) {
            i12 = i10;
            z10 = false;
        } else {
            i12 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z10 = true;
        }
        super.onMeasure(i12, i11);
        if (this.f433o && !this.f434p && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z10 = true;
        }
        if (z10) {
            super.onMeasure(i10, i11);
        }
        int childCount = getChildCount();
        int i15 = 0;
        while (true) {
            i13 = -1;
            if (i15 >= childCount) {
                i15 = -1;
                break;
            } else if (getChildAt(i15).getVisibility() == 0) {
                break;
            } else {
                i15++;
            }
        }
        if (i15 >= 0) {
            View childAt = getChildAt(i15);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f434p) {
                int i16 = i15 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i16 >= childCount2) {
                        break;
                    }
                    if (getChildAt(i16).getVisibility() == 0) {
                        i13 = i16;
                        break;
                    }
                    i16++;
                }
                i14 = i13 >= 0 ? getChildAt(i13).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight : measuredHeight;
            } else {
                i14 = getPaddingBottom() + measuredHeight;
            }
        }
        WeakHashMap weakHashMap = k0.f8683a;
        if (getMinimumHeight() != i14) {
            setMinimumHeight(i14);
            if (i11 == 0) {
                super.onMeasure(i10, i11);
            }
        }
    }

    public void setAllowStacking(boolean z10) {
        if (this.f433o != z10) {
            this.f433o = z10;
            if (!z10 && this.f434p) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
