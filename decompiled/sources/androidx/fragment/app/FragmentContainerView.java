package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.WeakHashMap;
import m0.q1;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f622o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f623p;

    /* renamed from: q, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f624q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f625r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        String str;
        za.h.e("context", context);
        this.f622o = new ArrayList();
        this.f623p = new ArrayList();
        this.f625r = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.a.f13329b, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    public final void a(View view) {
        if (this.f623p.contains(view)) {
            this.f622o.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        za.h.e("child", view);
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof s ? (s) tag : null) != null) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        q1 q1Var;
        za.h.e("insets", windowInsets);
        q1 g = q1.g(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f624q;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            za.h.d("onApplyWindowInsetsListe…lyWindowInsets(v, insets)", onApplyWindowInsets);
            q1Var = q1.g(null, onApplyWindowInsets);
        } else {
            WeakHashMap weakHashMap = m0.k0.f8683a;
            WindowInsets f10 = g.f();
            if (f10 != null) {
                WindowInsets b2 = m0.a0.b(this, f10);
                if (!b2.equals(f10)) {
                    g = q1.g(this, b2);
                }
            }
            q1Var = g;
        }
        if (!q1Var.f8706a.m()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                m0.k0.b(getChildAt(i10), q1Var);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        za.h.e("canvas", canvas);
        if (this.f625r) {
            ArrayList arrayList = this.f622o;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                super.drawChild(canvas, (View) obj, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j10) {
        za.h.e("canvas", canvas);
        za.h.e("child", view);
        if (this.f625r) {
            ArrayList arrayList = this.f622o;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        za.h.e("view", view);
        this.f623p.remove(view);
        if (this.f622o.remove(view)) {
            this.f625r = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends s> F getFragment() {
        f.j jVar;
        s sVar;
        i0 n10;
        View view = this;
        while (true) {
            jVar = null;
            if (view == null) {
                sVar = null;
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            sVar = tag instanceof s ? (s) tag : null;
            if (sVar != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (sVar == null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof f.j) {
                    jVar = (f.j) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (jVar == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            n10 = jVar.n();
        } else {
            if (!sVar.o()) {
                throw new IllegalStateException("The Fragment " + sVar + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            n10 = sVar.h();
        }
        return (F) n10.z(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        za.h.e("insets", windowInsets);
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                za.h.d("view", childAt);
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        za.h.e("view", view);
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i10) {
        View childAt = getChildAt(i10);
        za.h.d("view", childAt);
        a(childAt);
        super.removeViewAt(i10);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        za.h.e("view", view);
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View childAt = getChildAt(i13);
            za.h.d("view", childAt);
            a(childAt);
        }
        super.removeViews(i10, i11);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View childAt = getChildAt(i13);
            za.h.d("view", childAt);
            a(childAt);
        }
        super.removeViewsInLayout(i10, i11);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f625r = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        za.h.e("listener", onApplyWindowInsetsListener);
        this.f624q = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        za.h.e("view", view);
        if (view.getParent() == this) {
            this.f623p.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, i0 i0Var) {
        super(context, attributeSet);
        View view;
        za.h.e("context", context);
        za.h.e("attrs", attributeSet);
        this.f622o = new ArrayList();
        this.f623p = new ArrayList();
        this.f625r = true;
        String classAttribute = attributeSet.getClassAttribute();
        int i10 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.a.f13329b, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        s z10 = i0Var.z(id);
        if (classAttribute != null && z10 == null) {
            if (id == -1) {
                throw new IllegalStateException(android.support.v4.media.d.q("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : _UrlKt.FRAGMENT_ENCODE_SET));
            }
            c0 C = i0Var.C();
            context.getClassLoader();
            s a10 = C.a(classAttribute);
            za.h.d("fm.fragmentFactory.insta…ontext.classLoader, name)", a10);
            a10.Q = true;
            u uVar = a10.G;
            if ((uVar == null ? null : uVar.f825s) != null) {
                a10.Q = true;
            }
            a aVar = new a(i0Var);
            aVar.f640p = true;
            a10.R = this;
            aVar.f(getId(), a10, string, 1);
            if (!aVar.g) {
                aVar.f632h = false;
                i0 i0Var2 = aVar.f641q;
                if (i0Var2.f707t != null && !i0Var2.G) {
                    i0Var2.w(true);
                    aVar.a(i0Var2.I, i0Var2.J);
                    i0Var2.f690b = true;
                    try {
                        i0Var2.Q(i0Var2.I, i0Var2.J);
                        i0Var2.d();
                        i0Var2.b0();
                        if (i0Var2.H) {
                            i0Var2.H = false;
                            i0Var2.Z();
                        }
                        ((HashMap) i0Var2.f691c.f13554q).values().removeAll(Collections.singleton(null));
                    } catch (Throwable th) {
                        i0Var2.d();
                        throw th;
                    }
                }
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        ArrayList k10 = i0Var.f691c.k();
        int size = k10.size();
        while (i10 < size) {
            Object obj = k10.get(i10);
            i10++;
            p0 p0Var = (p0) obj;
            s sVar = p0Var.f772c;
            if (sVar.K == getId() && (view = sVar.S) != null && view.getParent() == null) {
                sVar.R = this;
                p0Var.b();
            }
        }
    }
}
