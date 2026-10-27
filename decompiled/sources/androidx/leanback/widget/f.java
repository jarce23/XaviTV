package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import okhttp3.internal.http2.Http2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f extends RecyclerView {
    public final p W0;
    public boolean X0;
    public boolean Y0;
    public b4.k0 Z0;

    /* renamed from: a1, reason: collision with root package name */
    public b4.v0 f1016a1;

    /* renamed from: b1, reason: collision with root package name */
    public int f1017b1;

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.X0 = true;
        this.Y0 = true;
        this.f1017b1 = 4;
        p pVar = new p(this);
        this.W0 = pVar;
        setLayoutManager(pVar);
        setPreserveFocusAfterLayout(false);
        setDescendantFocusability(262144);
        setHasFixedSize(true);
        setChildrenDrawingOrderEnabled(true);
        setWillNotDraw(true);
        setOverScrollMode(2);
        ((b4.j) getItemAnimator()).g = false;
        super.setRecyclerListener(new a(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchGenericFocusedEvent(MotionEvent motionEvent) {
        return super.dispatchGenericFocusedEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void e0(int i10) {
        p pVar = this.W0;
        if ((pVar.f1064z & 64) != 0) {
            pVar.w1(i10, false);
        } else {
            super.e0(i10);
        }
    }

    @Override // android.view.View
    public final View focusSearch(int i10) {
        if (isFocused()) {
            p pVar = this.W0;
            View s10 = pVar.s(pVar.B);
            if (s10 != null) {
                return focusSearch(s10, i10);
            }
        }
        return super.focusSearch(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final int getChildDrawingOrder(int i10, int i11) {
        int indexOfChild;
        p pVar = this.W0;
        View s10 = pVar.s(pVar.B);
        return (s10 != null && i11 >= (indexOfChild = indexOfChild(s10))) ? i11 < i10 + (-1) ? ((indexOfChild + i10) - 1) - i11 : indexOfChild : i11;
    }

    public int getExtraLayoutSpace() {
        return this.W0.X;
    }

    public int getFocusScrollStrategy() {
        return this.W0.T;
    }

    @Deprecated
    public int getHorizontalMargin() {
        return this.W0.L;
    }

    public int getHorizontalSpacing() {
        return this.W0.L;
    }

    public int getInitialPrefetchItemCount() {
        return this.f1017b1;
    }

    public int getItemAlignmentOffset() {
        return ((t) this.W0.V.f232r).f1075b;
    }

    public float getItemAlignmentOffsetPercent() {
        return ((t) this.W0.V.f232r).f1076c;
    }

    public int getItemAlignmentViewId() {
        return ((t) this.W0.V.f232r).f1074a;
    }

    public e getOnUnhandledKeyListener() {
        return null;
    }

    public final int getSaveChildrenLimitNumber() {
        return this.W0.Z.f1088p;
    }

    public final int getSaveChildrenPolicy() {
        return this.W0.Z.f1087o;
    }

    public int getSelectedPosition() {
        return this.W0.B;
    }

    public int getSelectedSubPosition() {
        this.W0.getClass();
        return 0;
    }

    @Deprecated
    public int getVerticalMargin() {
        return this.W0.M;
    }

    public int getVerticalSpacing() {
        return this.W0.M;
    }

    public int getWindowAlignment() {
        return ((x0) this.W0.U.f13555r).f1095f;
    }

    public int getWindowAlignmentOffset() {
        return ((x0) this.W0.U.f13555r).g;
    }

    public float getWindowAlignmentOffsetPercent() {
        return ((x0) this.W0.U.f13555r).f1096h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void h0(int i10) {
        p pVar = this.W0;
        if ((pVar.f1064z & 64) != 0) {
            pVar.w1(i10, false);
        } else {
            super.h0(i10);
        }
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return this.Y0;
    }

    public final void m0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a1.a.f11c);
        boolean z10 = obtainStyledAttributes.getBoolean(4, false);
        boolean z11 = obtainStyledAttributes.getBoolean(3, false);
        p pVar = this.W0;
        pVar.f1064z = (z10 ? 2048 : 0) | (pVar.f1064z & (-6145)) | (z11 ? 4096 : 0);
        boolean z12 = obtainStyledAttributes.getBoolean(6, true);
        boolean z13 = obtainStyledAttributes.getBoolean(5, true);
        pVar.f1064z = (z12 ? 8192 : 0) | (pVar.f1064z & (-24577)) | (z13 ? Http2.INITIAL_MAX_FRAME_SIZE : 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, obtainStyledAttributes.getDimensionPixelSize(8, 0));
        if (pVar.f1056r == 1) {
            pVar.M = dimensionPixelSize;
            pVar.N = dimensionPixelSize;
        } else {
            pVar.M = dimensionPixelSize;
            pVar.O = dimensionPixelSize;
        }
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, obtainStyledAttributes.getDimensionPixelSize(7, 0));
        if (pVar.f1056r == 0) {
            pVar.L = dimensionPixelSize2;
            pVar.N = dimensionPixelSize2;
        } else {
            pVar.L = dimensionPixelSize2;
            pVar.O = dimensionPixelSize2;
        }
        if (obtainStyledAttributes.hasValue(0)) {
            setGravity(obtainStyledAttributes.getInt(0, 0));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        p pVar = this.W0;
        if (!z10) {
            pVar.getClass();
            return;
        }
        int i11 = pVar.B;
        while (true) {
            View s10 = pVar.s(i11);
            if (s10 == null) {
                return;
            }
            if (s10.getVisibility() == 0 && s10.hasFocusable()) {
                s10.requestFocus();
                return;
            }
            i11++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        p pVar = this.W0;
        int i14 = pVar.T;
        if (i14 == 1 || i14 == 2) {
            int x6 = pVar.x();
            if ((i10 & 2) != 0) {
                i12 = x6;
                i11 = 0;
                i13 = 1;
            } else {
                i11 = x6 - 1;
                i12 = -1;
                i13 = -1;
            }
            x0 x0Var = (x0) pVar.U.f13555r;
            int i15 = x0Var.f1098j;
            int i16 = ((x0Var.f1097i - i15) - x0Var.f1099k) + i15;
            while (i11 != i12) {
                View w10 = pVar.w(i11);
                if (w10.getVisibility() == 0 && pVar.f1057s.e(w10) >= i15 && pVar.f1057s.b(w10) <= i16 && w10.requestFocus(i10, rect)) {
                    return true;
                }
                i11 += i13;
            }
        } else {
            View s10 = pVar.s(pVar.B);
            if (s10 != null) {
                return s10.requestFocus(i10, rect);
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i10) {
        int i11;
        p pVar = this.W0;
        if (pVar.f1056r == 0) {
            if (i10 == 1) {
                i11 = 262144;
            }
            i11 = 0;
        } else {
            if (i10 == 1) {
                i11 = 524288;
            }
            i11 = 0;
        }
        int i12 = pVar.f1064z;
        if ((786432 & i12) == i11) {
            return;
        }
        pVar.f1064z = i11 | (i12 & (-786433)) | 256;
        ((x0) pVar.U.f13554q).f1100l = i10 == 1;
    }

    public void setAnimateChildLayout(boolean z10) {
        if (this.X0 != z10) {
            this.X0 = z10;
            if (z10) {
                super.setItemAnimator(this.Z0);
            } else {
                this.Z0 = getItemAnimator();
                super.setItemAnimator(null);
            }
        }
    }

    public void setChildrenVisibility(int i10) {
        p pVar = this.W0;
        pVar.F = i10;
        if (i10 != -1) {
            int x6 = pVar.x();
            for (int i11 = 0; i11 < x6; i11++) {
                pVar.w(i11).setVisibility(pVar.F);
            }
        }
    }

    public void setExtraLayoutSpace(int i10) {
        p pVar = this.W0;
        int i11 = pVar.X;
        if (i11 == i10) {
            return;
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("ExtraLayoutSpace must >= 0");
        }
        pVar.X = i10;
        pVar.C0();
    }

    public void setFocusDrawingOrderEnabled(boolean z10) {
        super.setChildrenDrawingOrderEnabled(z10);
    }

    public void setFocusScrollStrategy(int i10) {
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("Invalid scrollStrategy");
        }
        this.W0.T = i10;
        requestLayout();
    }

    public final void setFocusSearchDisabled(boolean z10) {
        setDescendantFocusability(z10 ? 393216 : 262144);
        p pVar = this.W0;
        pVar.f1064z = (z10 ? 32768 : 0) | (pVar.f1064z & (-32769));
    }

    public void setGravity(int i10) {
        this.W0.P = i10;
        requestLayout();
    }

    public void setHasOverlappingRendering(boolean z10) {
        this.Y0 = z10;
    }

    @Deprecated
    public void setHorizontalMargin(int i10) {
        setHorizontalSpacing(i10);
    }

    public void setHorizontalSpacing(int i10) {
        p pVar = this.W0;
        if (pVar.f1056r == 0) {
            pVar.L = i10;
            pVar.N = i10;
        } else {
            pVar.L = i10;
            pVar.O = i10;
        }
        requestLayout();
    }

    public void setInitialPrefetchItemCount(int i10) {
        this.f1017b1 = i10;
    }

    public void setItemAlignmentOffset(int i10) {
        p pVar = this.W0;
        ((t) pVar.V.f232r).f1075b = i10;
        pVar.x1();
        requestLayout();
    }

    public void setItemAlignmentOffsetPercent(float f10) {
        p pVar = this.W0;
        t tVar = (t) pVar.V.f232r;
        tVar.getClass();
        if ((f10 < 0.0f || f10 > 100.0f) && f10 != -1.0f) {
            throw new IllegalArgumentException();
        }
        tVar.f1076c = f10;
        pVar.x1();
        requestLayout();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z10) {
        p pVar = this.W0;
        ((t) pVar.V.f232r).f1077d = z10;
        pVar.x1();
        requestLayout();
    }

    public void setItemAlignmentViewId(int i10) {
        p pVar = this.W0;
        ((t) pVar.V.f232r).f1074a = i10;
        pVar.x1();
    }

    @Deprecated
    public void setItemMargin(int i10) {
        setItemSpacing(i10);
    }

    public void setItemSpacing(int i10) {
        p pVar = this.W0;
        pVar.L = i10;
        pVar.M = i10;
        pVar.O = i10;
        pVar.N = i10;
        requestLayout();
    }

    public void setLayoutEnabled(boolean z10) {
        p pVar = this.W0;
        int i10 = pVar.f1064z;
        if (((i10 & 512) != 0) != z10) {
            pVar.f1064z = (i10 & (-513)) | (z10 ? 512 : 0);
            pVar.C0();
        }
    }

    public void setOnChildLaidOutListener(w wVar) {
        this.W0.getClass();
    }

    public void setOnChildSelectedListener(x xVar) {
        this.W0.getClass();
    }

    public void setOnChildViewHolderSelectedListener(y yVar) {
        p pVar = this.W0;
        if (yVar == null) {
            pVar.A = null;
            return;
        }
        ArrayList arrayList = pVar.A;
        if (arrayList == null) {
            pVar.A = new ArrayList();
        } else {
            arrayList.clear();
        }
        pVar.A.add(yVar);
    }

    public void setPruneChild(boolean z10) {
        p pVar = this.W0;
        int i10 = pVar.f1064z;
        if (((i10 & 65536) != 0) != z10) {
            pVar.f1064z = (i10 & (-65537)) | (z10 ? 65536 : 0);
            if (z10) {
                pVar.C0();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setRecyclerListener(b4.v0 v0Var) {
        this.f1016a1 = v0Var;
    }

    public final void setSaveChildrenLimitNumber(int i10) {
        w0 w0Var = this.W0.Z;
        w0Var.f1088p = i10;
        w0Var.d();
    }

    public final void setSaveChildrenPolicy(int i10) {
        w0 w0Var = this.W0.Z;
        w0Var.f1087o = i10;
        w0Var.d();
    }

    public void setScrollEnabled(boolean z10) {
        int i10;
        p pVar = this.W0;
        int i11 = pVar.f1064z;
        if (((i11 & 131072) != 0) != z10) {
            int i12 = (i11 & (-131073)) | (z10 ? 131072 : 0);
            pVar.f1064z = i12;
            if ((i12 & 131072) == 0 || pVar.T != 0 || (i10 = pVar.B) == -1) {
                return;
            }
            pVar.r1(i10, true);
        }
    }

    public void setSelectedPosition(int i10) {
        this.W0.w1(i10, false);
    }

    public void setSelectedPositionSmooth(int i10) {
        this.W0.w1(i10, true);
    }

    @Deprecated
    public void setVerticalMargin(int i10) {
        setVerticalSpacing(i10);
    }

    public void setVerticalSpacing(int i10) {
        p pVar = this.W0;
        if (pVar.f1056r == 1) {
            pVar.M = i10;
            pVar.N = i10;
        } else {
            pVar.M = i10;
            pVar.O = i10;
        }
        requestLayout();
    }

    public void setWindowAlignment(int i10) {
        ((x0) this.W0.U.f13555r).f1095f = i10;
        requestLayout();
    }

    public void setWindowAlignmentOffset(int i10) {
        ((x0) this.W0.U.f13555r).g = i10;
        requestLayout();
    }

    public void setWindowAlignmentOffsetPercent(float f10) {
        x0 x0Var = (x0) this.W0.U.f13555r;
        x0Var.getClass();
        if ((f10 < 0.0f || f10 > 100.0f) && f10 != -1.0f) {
            throw new IllegalArgumentException();
        }
        x0Var.f1096h = f10;
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverHighEdge(boolean z10) {
        x0 x0Var = (x0) this.W0.U.f13555r;
        x0Var.f1094e = z10 ? x0Var.f1094e | 2 : x0Var.f1094e & (-3);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverLowEdge(boolean z10) {
        x0 x0Var = (x0) this.W0.U.f13555r;
        x0Var.f1094e = z10 ? x0Var.f1094e | 1 : x0Var.f1094e & (-2);
        requestLayout();
    }

    public void setOnKeyInterceptListener(b bVar) {
    }

    public void setOnMotionInterceptListener(c cVar) {
    }

    public void setOnTouchInterceptListener(d dVar) {
    }

    public void setOnUnhandledKeyListener(e eVar) {
    }
}
