package m;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.InvocationTargetException;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class o1 extends ListView {

    /* renamed from: o, reason: collision with root package name */
    public final Rect f8500o;

    /* renamed from: p, reason: collision with root package name */
    public int f8501p;

    /* renamed from: q, reason: collision with root package name */
    public int f8502q;

    /* renamed from: r, reason: collision with root package name */
    public int f8503r;

    /* renamed from: s, reason: collision with root package name */
    public int f8504s;

    /* renamed from: t, reason: collision with root package name */
    public int f8505t;

    /* renamed from: u, reason: collision with root package name */
    public m1 f8506u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8507v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f8508w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8509x;

    /* renamed from: y, reason: collision with root package name */
    public p0.e f8510y;

    /* renamed from: z, reason: collision with root package name */
    public androidx.activity.j f8511z;

    public o1(Context context, boolean z10) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f8500o = new Rect();
        this.f8501p = 0;
        this.f8502q = 0;
        this.f8503r = 0;
        this.f8504s = 0;
        this.f8508w = z10;
        setCacheColorHint(0);
    }

    public final int a(int i10, int i11) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i12 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i13 = 0;
        View view = null;
        for (int i14 = 0; i14 < count; i14++) {
            int itemViewType = adapter.getItemViewType(i14);
            if (itemViewType != i13) {
                view = null;
                i13 = itemViewType;
            }
            view = adapter.getView(i14, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i15 = layoutParams.height;
            view.measure(i10, i15 > 0 ? View.MeasureSpec.makeMeasureSpec(i15, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i14 > 0) {
                i12 += dividerHeight;
            }
            i12 += view.getMeasuredHeight();
            if (i12 >= i11) {
                return i11;
            }
        }
        return i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x014a A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.MotionEvent r18, int r19) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.o1.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f8500o;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f8511z != null) {
            return;
        }
        super.drawableStateChanged();
        m1 m1Var = this.f8506u;
        if (m1Var != null) {
            m1Var.f8482p = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f8509x && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f8508w || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f8508w || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f8508w || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f8508w && this.f8507v) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f8511z = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f8511z == null) {
            androidx.activity.j jVar = new androidx.activity.j(25, this);
            this.f8511z = jVar;
            post(jVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return onHoverEvent;
        }
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                requestFocus();
                if (i10 < 30 || !k1.f8465d) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                } else {
                    try {
                        k1.f8462a.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                        k1.f8463b.invoke(this, Integer.valueOf(pointToPosition));
                        k1.f8464c.invoke(this, Integer.valueOf(pointToPosition));
                    } catch (IllegalAccessException e7) {
                        e7.printStackTrace();
                    } catch (InvocationTargetException e8) {
                        e8.printStackTrace();
                    }
                }
            }
            Drawable selector = getSelector();
            if (selector != null && this.f8509x && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f8505t = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        androidx.activity.j jVar = this.f8511z;
        if (jVar != null) {
            o1 o1Var = (o1) jVar.f302p;
            o1Var.f8511z = null;
            o1Var.removeCallbacks(jVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f8507v = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        m1 m1Var;
        if (drawable != null) {
            m1Var = new m1();
            Drawable drawable2 = m1Var.f8481o;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            m1Var.f8481o = drawable;
            if (drawable != null) {
                drawable.setCallback(m1Var);
            }
            m1Var.f8482p = true;
        } else {
            m1Var = null;
        }
        this.f8506u = m1Var;
        super.setSelector(m1Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f8501p = rect.left;
        this.f8502q = rect.top;
        this.f8503r = rect.right;
        this.f8504s = rect.bottom;
    }
}
