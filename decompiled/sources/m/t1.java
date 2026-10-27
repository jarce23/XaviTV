package m;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class t1 extends ViewGroup {
    public int A;
    public int B;
    public int C;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8557o;

    /* renamed from: p, reason: collision with root package name */
    public int f8558p;

    /* renamed from: q, reason: collision with root package name */
    public int f8559q;

    /* renamed from: r, reason: collision with root package name */
    public int f8560r;

    /* renamed from: s, reason: collision with root package name */
    public int f8561s;

    /* renamed from: t, reason: collision with root package name */
    public int f8562t;

    /* renamed from: u, reason: collision with root package name */
    public float f8563u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8564v;

    /* renamed from: w, reason: collision with root package name */
    public int[] f8565w;

    /* renamed from: x, reason: collision with root package name */
    public int[] f8566x;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f8567y;

    /* renamed from: z, reason: collision with root package name */
    public int f8568z;

    public t1(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, 0);
        this.f8557o = true;
        this.f8558p = -1;
        this.f8559q = 0;
        this.f8561s = 8388659;
        int[] iArr = e.a.f4370n;
        android.support.v4.media.session.a0 T = android.support.v4.media.session.a0.T(context, attributeSet, iArr, 0);
        m0.k0.l(this, context, iArr, attributeSet, (TypedArray) T.f231q, 0);
        TypedArray typedArray = (TypedArray) T.f231q;
        int i11 = typedArray.getInt(1, -1);
        if (i11 >= 0) {
            setOrientation(i11);
        }
        int i12 = typedArray.getInt(0, -1);
        if (i12 >= 0) {
            setGravity(i12);
        }
        boolean z10 = typedArray.getBoolean(2, true);
        if (!z10) {
            setBaselineAligned(z10);
        }
        this.f8563u = typedArray.getFloat(4, -1.0f);
        this.f8558p = typedArray.getInt(3, -1);
        this.f8564v = typedArray.getBoolean(7, false);
        setDividerDrawable(T.K(5));
        this.B = typedArray.getInt(8, 0);
        this.C = typedArray.getDimensionPixelSize(6, 0);
        T.U();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof s1;
    }

    public final void d(Canvas canvas, int i10) {
        this.f8567y.setBounds(getPaddingLeft() + this.C, i10, (getWidth() - getPaddingRight()) - this.C, this.A + i10);
        this.f8567y.draw(canvas);
    }

    public final void e(Canvas canvas, int i10) {
        this.f8567y.setBounds(i10, getPaddingTop() + this.C, this.f8568z + i10, (getHeight() - getPaddingBottom()) - this.C);
        this.f8567y.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public s1 generateDefaultLayoutParams() {
        int i10 = this.f8560r;
        if (i10 == 0) {
            return new s1(-2, -2);
        }
        if (i10 == 1) {
            return new s1(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public s1 generateLayoutParams(AttributeSet attributeSet) {
        return new s1(getContext(), attributeSet);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i10;
        if (this.f8558p < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i11 = this.f8558p;
        if (childCount <= i11) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i11);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f8558p == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i12 = this.f8559q;
        if (this.f8560r == 1 && (i10 = this.f8561s & 112) != 48) {
            if (i10 == 16) {
                i12 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f8562t) / 2;
            } else if (i10 == 80) {
                i12 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f8562t;
            }
        }
        return i12 + ((LinearLayout.LayoutParams) ((s1) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f8558p;
    }

    public Drawable getDividerDrawable() {
        return this.f8567y;
    }

    public int getDividerPadding() {
        return this.C;
    }

    public int getDividerWidth() {
        return this.f8568z;
    }

    public int getGravity() {
        return this.f8561s;
    }

    public int getOrientation() {
        return this.f8560r;
    }

    public int getShowDividers() {
        return this.B;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f8563u;
    }

    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public s1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof s1 ? new s1((s1) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new s1((ViewGroup.MarginLayoutParams) layoutParams) : new s1(layoutParams);
    }

    public final boolean i(int i10) {
        if (i10 == 0) {
            return (this.B & 1) != 0;
        }
        if (i10 == getChildCount()) {
            return (this.B & 4) != 0;
        }
        if ((this.B & 2) != 0) {
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                if (getChildAt(i11).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i10;
        if (this.f8567y == null) {
            return;
        }
        int i11 = 0;
        if (this.f8560r == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i11 < virtualChildCount) {
                View childAt = getChildAt(i11);
                if (childAt != null && childAt.getVisibility() != 8 && i(i11)) {
                    d(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((s1) childAt.getLayoutParams())).topMargin) - this.A);
                }
                i11++;
            }
            if (i(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                d(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.A : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((s1) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z10 = h3.f8433a;
        boolean z11 = getLayoutDirection() == 1;
        while (i11 < virtualChildCount2) {
            View childAt3 = getChildAt(i11);
            if (childAt3 != null && childAt3.getVisibility() != 8 && i(i11)) {
                s1 s1Var = (s1) childAt3.getLayoutParams();
                e(canvas, z11 ? childAt3.getRight() + ((LinearLayout.LayoutParams) s1Var).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) s1Var).leftMargin) - this.f8568z);
            }
            i11++;
        }
        if (i(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                s1 s1Var2 = (s1) childAt4.getLayoutParams();
                if (z11) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) s1Var2).leftMargin;
                    i10 = this.f8568z;
                    right = left - i10;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) s1Var2).rightMargin;
                }
            } else if (z11) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i10 = this.f8568z;
                right = left - i10;
            }
            e(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0191  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.t1.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.t1.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z10) {
        this.f8557o = z10;
    }

    public void setBaselineAlignedChildIndex(int i10) {
        if (i10 >= 0 && i10 < getChildCount()) {
            this.f8558p = i10;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f8567y) {
            return;
        }
        this.f8567y = drawable;
        if (drawable != null) {
            this.f8568z = drawable.getIntrinsicWidth();
            this.A = drawable.getIntrinsicHeight();
        } else {
            this.f8568z = 0;
            this.A = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i10) {
        this.C = i10;
    }

    public void setGravity(int i10) {
        if (this.f8561s != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f8561s = i10;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i10) {
        int i11 = i10 & 8388615;
        int i12 = this.f8561s;
        if ((8388615 & i12) != i11) {
            this.f8561s = i11 | ((-8388616) & i12);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.f8564v = z10;
    }

    public void setOrientation(int i10) {
        if (this.f8560r != i10) {
            this.f8560r = i10;
            requestLayout();
        }
    }

    public void setShowDividers(int i10) {
        if (i10 != this.B) {
            requestLayout();
        }
        this.B = i10;
    }

    public void setVerticalGravity(int i10) {
        int i11 = i10 & 112;
        int i12 = this.f8561s;
        if ((i12 & 112) != i11) {
            this.f8561s = i11 | (i12 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.f8563u = Math.max(0.0f, f10);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
