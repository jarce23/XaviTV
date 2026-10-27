package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import e.a;
import java.lang.ref.WeakReference;
import m.f3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: o, reason: collision with root package name */
    public int f487o;

    /* renamed from: p, reason: collision with root package name */
    public int f488p;

    /* renamed from: q, reason: collision with root package name */
    public WeakReference f489q;

    /* renamed from: r, reason: collision with root package name */
    public LayoutInflater f490r;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f487o = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.A, 0, 0);
        this.f488p = obtainStyledAttributes.getResourceId(2, -1);
        this.f487o = obtainStyledAttributes.getResourceId(1, 0);
        setId(obtainStyledAttributes.getResourceId(0, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f487o == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflater = this.f490r;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(getContext());
        }
        View inflate = layoutInflater.inflate(this.f487o, viewGroup, false);
        int i10 = this.f488p;
        if (i10 != -1) {
            inflate.setId(i10);
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(inflate, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(inflate, indexOfChild);
        }
        this.f489q = new WeakReference(inflate);
        return inflate;
    }

    public int getInflatedId() {
        return this.f488p;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f490r;
    }

    public int getLayoutResource() {
        return this.f487o;
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i10) {
        this.f488p = i10;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f490r = layoutInflater;
    }

    public void setLayoutResource(int i10) {
        this.f487o = i10;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        WeakReference weakReference = this.f489q;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i10);
            return;
        }
        super.setVisibility(i10);
        if (i10 == 0 || i10 == 4) {
            a();
        }
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public void setOnInflateListener(f3 f3Var) {
    }
}
