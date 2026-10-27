package p8;

import a6.n;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import d9.a0;
import d9.b0;
import d9.c0;
import d9.d0;
import d9.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import org.chromium.net.R;
import org.xmlpull.v1.XmlPullParserException;
import p4.p;
import x8.k;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e extends LinearLayout {

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f10109o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f10110p;

    /* renamed from: q, reason: collision with root package name */
    public final p f10111q;

    /* renamed from: r, reason: collision with root package name */
    public final d f10112r;

    /* renamed from: s, reason: collision with root package name */
    public Integer[] f10113s;

    /* renamed from: t, reason: collision with root package name */
    public z f10114t;

    /* renamed from: u, reason: collision with root package name */
    public b0 f10115u;

    /* renamed from: v, reason: collision with root package name */
    public int f10116v;

    /* renamed from: w, reason: collision with root package name */
    public d0 f10117w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10118x;

    public e(Context context, AttributeSet attributeSet) {
        super(i9.a.a(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        z b2;
        XmlResourceParser xml;
        int next;
        d0 d0Var;
        int next2;
        this.f10109o = new ArrayList();
        this.f10110p = new ArrayList();
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this;
        this.f10111q = new p(3, materialButtonToggleGroup);
        this.f10112r = new d(0, materialButtonToggleGroup);
        this.f10118x = true;
        Context context2 = getContext();
        TypedArray e7 = k.e(context2, attributeSet, j8.a.f7190k, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup, new int[0]);
        if (e7.hasValue(2)) {
            int resourceId = e7.getResourceId(2, 0);
            if (resourceId != 0 && context2.getResources().getResourceTypeName(resourceId).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId);
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                }
                try {
                    d0Var = new d0();
                    d0Var.f4255c = new int[10][];
                    d0Var.f4256d = new n[10];
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next2 = xml.next();
                        if (next2 == 2) {
                            break;
                        }
                    } while (next2 != 1);
                    if (next2 != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    if (xml.getName().equals("selector")) {
                        d0Var.a(context2, xml, asAttributeSet, context2.getTheme());
                    }
                    xml.close();
                    this.f10117w = d0Var;
                } finally {
                }
            }
            d0Var = null;
            this.f10117w = d0Var;
        }
        if (e7.hasValue(4)) {
            b0 b10 = b0.b(context2, e7, 4);
            this.f10115u = b10;
            if (b10 == null) {
                a0 a0Var = new a0(d9.n.a(context2, e7.getResourceId(4, 0), e7.getResourceId(5, 0), new d9.a(0)).a());
                this.f10115u = a0Var.f4234a != 0 ? new b0(a0Var) : null;
            }
        }
        if (e7.hasValue(3)) {
            d9.a aVar = new d9.a(0.0f);
            int resourceId2 = e7.getResourceId(3, 0);
            if (resourceId2 == 0) {
                b2 = z.b(d9.n.c(e7, 3, aVar));
            } else if (context2.getResources().getResourceTypeName(resourceId2).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId2);
                    try {
                        b2 = new z();
                        AttributeSet asAttributeSet2 = Xml.asAttributeSet(xml);
                        do {
                            next = xml.next();
                            if (next == 2) {
                                break;
                            }
                        } while (next != 1);
                        if (next != 2) {
                            throw new XmlPullParserException("No start tag found");
                        }
                        if (xml.getName().equals("selector")) {
                            b2.d(context2, xml, asAttributeSet2, context2.getTheme());
                        }
                        xml.close();
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused2) {
                    b2 = z.b(aVar);
                }
            } else {
                b2 = z.b(d9.n.c(e7, 3, aVar));
            }
            this.f10114t = b2;
        }
        this.f10116v = e7.getDimensionPixelSize(1, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(e7.getBoolean(0, true));
        e7.recycle();
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (c(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    public final void a() {
        int i10;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i11 = firstVisibleChildIndex + 1; i11 < getChildCount(); i11++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i11);
            MaterialButton materialButton2 = (MaterialButton) getChildAt(i11 - 1);
            if (this.f10116v <= 0) {
                i10 = Math.min(materialButton.getStrokeWidth(), materialButton2.getStrokeWidth());
                materialButton.setShouldDrawSurfaceColorStroke(true);
                materialButton2.setShouldDrawSurfaceColorStroke(true);
            } else {
                materialButton.setShouldDrawSurfaceColorStroke(false);
                materialButton2.setShouldDrawSurfaceColorStroke(false);
                i10 = 0;
            }
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(this.f10116v - i10);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = this.f10116v - i10;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        d();
        this.f10118x = true;
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.f10111q);
        this.f10109o.add(materialButton.getShapeAppearanceModel());
        this.f10110p.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    public final void b() {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        float max;
        if (this.f10117w == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int i10 = Integer.MAX_VALUE;
        for (int i11 = firstVisibleChildIndex; i11 <= lastVisibleChildIndex; i11++) {
            if (c(i11)) {
                if (c(i11) && this.f10117w != null) {
                    MaterialButton materialButton3 = (MaterialButton) getChildAt(i11);
                    d0 d0Var = this.f10117w;
                    int width = materialButton3.getWidth();
                    int i12 = -width;
                    for (int i13 = 0; i13 < d0Var.f4253a; i13++) {
                        c0 c0Var = (c0) d0Var.f4256d[i13].f74p;
                        int i14 = c0Var.f4251a;
                        float f10 = c0Var.f4252b;
                        if (i14 == 2) {
                            max = Math.max(i12, f10);
                        } else if (i14 == 1) {
                            max = Math.max(i12, width * f10);
                        }
                        i12 = (int) max;
                    }
                    int max2 = Math.max(0, i12);
                    int i15 = i11 - 1;
                    while (true) {
                        materialButton = null;
                        if (i15 < 0) {
                            materialButton2 = null;
                            break;
                        } else {
                            if (c(i15)) {
                                materialButton2 = (MaterialButton) getChildAt(i15);
                                break;
                            }
                            i15--;
                        }
                    }
                    int allowedWidthDecrease = materialButton2 == null ? 0 : materialButton2.getAllowedWidthDecrease();
                    int childCount = getChildCount();
                    int i16 = i11 + 1;
                    while (true) {
                        if (i16 >= childCount) {
                            break;
                        }
                        if (c(i16)) {
                            materialButton = (MaterialButton) getChildAt(i16);
                            break;
                        }
                        i16++;
                    }
                    r5 = Math.min(max2, allowedWidthDecrease + (materialButton != null ? materialButton.getAllowedWidthDecrease() : 0));
                }
                if (i11 != firstVisibleChildIndex && i11 != lastVisibleChildIndex) {
                    r5 /= 2;
                }
                i10 = Math.min(i10, r5);
            }
        }
        int i17 = firstVisibleChildIndex;
        while (i17 <= lastVisibleChildIndex) {
            if (c(i17)) {
                ((MaterialButton) getChildAt(i17)).setSizeChange(this.f10117w);
                ((MaterialButton) getChildAt(i17)).setWidthChangeMax((i17 == firstVisibleChildIndex || i17 == lastVisibleChildIndex) ? i10 : i10 * 2);
            }
            i17++;
        }
    }

    public final boolean c(int i10) {
        return getChildAt(i10).getVisibility() != 8;
    }

    public final void d() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i10);
            LinearLayout.LayoutParams layoutParams = materialButton.J;
            if (layoutParams != null) {
                materialButton.setLayoutParams(layoutParams);
                materialButton.J = null;
                materialButton.G = -1.0f;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f10112r);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put((MaterialButton) getChildAt(i10), Integer.valueOf(i10));
        }
        this.f10113s = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        a0 a0Var;
        int i10;
        if (!(this.f10114t == null && this.f10115u == null) && this.f10118x) {
            this.f10118x = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i11 = 0;
            while (i11 < childCount) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i11);
                if (materialButton.getVisibility() != 8) {
                    boolean z10 = i11 == firstVisibleChildIndex;
                    boolean z11 = i11 == lastVisibleChildIndex;
                    b0 b0Var = this.f10115u;
                    if (b0Var == null || (!z10 && !z11)) {
                        b0Var = (b0) this.f10110p.get(i11);
                    }
                    if (b0Var == null) {
                        a0Var = new a0((d9.n) this.f10109o.get(i11));
                    } else {
                        a0 a0Var2 = new a0();
                        int i12 = b0Var.f4243a;
                        a0Var2.f4234a = i12;
                        a0Var2.f4235b = b0Var.f4244b;
                        int[][] iArr = b0Var.f4245c;
                        int[][] iArr2 = new int[iArr.length][];
                        a0Var2.f4236c = iArr2;
                        d9.n[] nVarArr = b0Var.f4246d;
                        a0Var2.f4237d = new d9.n[nVarArr.length];
                        System.arraycopy(iArr, 0, iArr2, 0, i12);
                        System.arraycopy(nVarArr, 0, a0Var2.f4237d, 0, a0Var2.f4234a);
                        a0Var2.f4238e = b0Var.f4247e;
                        a0Var2.f4239f = b0Var.f4248f;
                        a0Var2.g = b0Var.g;
                        a0Var2.f4240h = b0Var.f4249h;
                        a0Var = a0Var2;
                    }
                    boolean z12 = getOrientation() == 0;
                    boolean z13 = getLayoutDirection() == 1;
                    if (z12) {
                        i10 = z10 ? 5 : 0;
                        if (z11) {
                            i10 |= 10;
                        }
                        if (z13) {
                            i10 = ((i10 & 10) >> 1) | ((i10 & 5) << 1);
                        }
                    } else {
                        i10 = z10 ? 3 : 0;
                        if (z11) {
                            i10 |= 12;
                        }
                    }
                    int i13 = ~i10;
                    z zVar = this.f10114t;
                    if ((i13 | 1) == i13) {
                        a0Var.f4238e = zVar;
                    }
                    if ((i13 | 2) == i13) {
                        a0Var.f4239f = zVar;
                    }
                    if ((i13 | 4) == i13) {
                        a0Var.g = zVar;
                    }
                    if ((i13 | 8) == i13) {
                        a0Var.f4240h = zVar;
                    }
                    b0 b0Var2 = a0Var.f4234a == 0 ? null : new b0(a0Var);
                    if (b0Var2.d()) {
                        materialButton.setStateListShapeAppearanceModel(b0Var2);
                    } else {
                        materialButton.setShapeAppearanceModel(b0Var2.c());
                    }
                }
                i11++;
            }
        }
    }

    public d0 getButtonSizeChange() {
        return this.f10117w;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f10113s;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i11;
    }

    public d9.d getInnerCornerSize() {
        return this.f10114t.f4347b;
    }

    public z getInnerCornerSizeStateList() {
        return this.f10114t;
    }

    public d9.n getShapeAppearance() {
        b0 b0Var = this.f10115u;
        if (b0Var == null) {
            return null;
        }
        return b0Var.c();
    }

    public int getSpacing() {
        return this.f10116v;
    }

    public b0 getStateListShapeAppearance() {
        return this.f10115u;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            d();
            b();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        e();
        a();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f10109o.remove(indexOfChild);
            this.f10110p.remove(indexOfChild);
        }
        this.f10118x = true;
        e();
        d();
        a();
    }

    public void setButtonSizeChange(d0 d0Var) {
        if (this.f10117w != d0Var) {
            this.f10117w = d0Var;
            b();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            ((MaterialButton) getChildAt(i10)).setEnabled(z10);
        }
    }

    public void setInnerCornerSize(d9.d dVar) {
        this.f10114t = z.b(dVar);
        this.f10118x = true;
        e();
        invalidate();
    }

    public void setInnerCornerSizeStateList(z zVar) {
        this.f10114t = zVar;
        this.f10118x = true;
        e();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (getOrientation() != i10) {
            this.f10118x = true;
        }
        super.setOrientation(i10);
    }

    public void setShapeAppearance(d9.n nVar) {
        a0 a0Var = new a0(nVar);
        this.f10115u = a0Var.f4234a == 0 ? null : new b0(a0Var);
        this.f10118x = true;
        e();
        invalidate();
    }

    public void setSpacing(int i10) {
        this.f10116v = i10;
        invalidate();
        requestLayout();
    }

    public void setStateListShapeAppearance(b0 b0Var) {
        this.f10115u = b0Var;
        this.f10118x = true;
        e();
        invalidate();
    }
}
