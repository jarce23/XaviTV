package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
class ControlBar extends LinearLayout {

    /* renamed from: o, reason: collision with root package name */
    public int f894o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f895p;

    public ControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f894o = -1;
        this.f895p = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i10, int i11) {
        if (i10 != 33 && i10 != 130) {
            super.addFocusables(arrayList, i10, i11);
            return;
        }
        int i12 = this.f894o;
        if (i12 >= 0 && i12 < getChildCount()) {
            arrayList.add(getChildAt(this.f894o));
        } else if (getChildCount() > 0) {
            arrayList.add(getChildAt(this.f895p ? getChildCount() / 2 : 0));
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (getChildCount() > 0) {
            int i11 = this.f894o;
            if (getChildAt((i11 < 0 || i11 >= getChildCount()) ? this.f895p ? getChildCount() / 2 : 0 : this.f894o).requestFocus(i10, rect)) {
                return true;
            }
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.f894o = indexOfChild(view);
    }
}
