package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import e.a;
import m.b;
import m.k2;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: o, reason: collision with root package name */
    public boolean f389o;

    /* renamed from: p, reason: collision with root package name */
    public View f390p;

    /* renamed from: q, reason: collision with root package name */
    public View f391q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f392r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f393s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f394t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f395u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f396v;

    /* renamed from: w, reason: collision with root package name */
    public final int f397w;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f4358a);
        boolean z10 = false;
        this.f392r = obtainStyledAttributes.getDrawable(0);
        this.f393s = obtainStyledAttributes.getDrawable(2);
        this.f397w = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f395u = true;
            this.f394t = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.f395u ? !(this.f392r != null || this.f393s != null) : this.f394t == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f392r;
        if (drawable != null && drawable.isStateful()) {
            this.f392r.setState(getDrawableState());
        }
        Drawable drawable2 = this.f393s;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f393s.setState(getDrawableState());
        }
        Drawable drawable3 = this.f394t;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f394t.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f392r;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f393s;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f394t;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f390p = findViewById(R.id.action_bar);
        this.f391q = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f389o || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        boolean z11 = true;
        if (this.f395u) {
            Drawable drawable = this.f394t;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z11 = false;
            }
        } else {
            if (this.f392r == null) {
                z11 = false;
            } else if (this.f390p.getVisibility() == 0) {
                this.f392r.setBounds(this.f390p.getLeft(), this.f390p.getTop(), this.f390p.getRight(), this.f390p.getBottom());
            } else {
                View view = this.f391q;
                if (view == null || view.getVisibility() != 0) {
                    this.f392r.setBounds(0, 0, 0, 0);
                } else {
                    this.f392r.setBounds(this.f391q.getLeft(), this.f391q.getTop(), this.f391q.getRight(), this.f391q.getBottom());
                }
            }
            this.f396v = false;
        }
        if (z11) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        if (this.f390p == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f397w) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f390p == null) {
            return;
        }
        View.MeasureSpec.getMode(i11);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f392r;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f392r);
        }
        this.f392r = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f390p;
            if (view != null) {
                this.f392r.setBounds(view.getLeft(), this.f390p.getTop(), this.f390p.getRight(), this.f390p.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f395u ? !(this.f392r != null || this.f393s != null) : this.f394t == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f394t;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f394t);
        }
        this.f394t = drawable;
        boolean z10 = this.f395u;
        boolean z11 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z10 && (drawable2 = this.f394t) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z10 ? !(this.f392r != null || this.f393s != null) : this.f394t == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f393s;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f393s);
        }
        this.f393s = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f396v && this.f393s != null) {
                throw null;
            }
        }
        boolean z10 = false;
        if (!this.f395u ? !(this.f392r != null || this.f393s != null) : this.f394t == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z10) {
        this.f389o = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f392r;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f393s;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f394t;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f392r;
        boolean z10 = this.f395u;
        if (drawable == drawable2 && !z10) {
            return true;
        }
        if (drawable == this.f393s && this.f396v) {
            return true;
        }
        return (drawable == this.f394t && z10) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }

    public void setTabContainer(k2 k2Var) {
    }
}
