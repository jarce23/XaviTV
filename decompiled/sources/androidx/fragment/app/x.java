package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x implements LayoutInflater.Factory2 {

    /* renamed from: o, reason: collision with root package name */
    public final i0 f847o;

    public x(i0 i0Var) {
        this.f847o = i0Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        p0 f10;
        boolean equals = FragmentContainerView.class.getName().equals(str);
        i0 i0Var = this.f847o;
        if (equals) {
            return new FragmentContainerView(context, attributeSet, i0Var);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.a.f13328a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    z10 = s.class.isAssignableFrom(c0.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    z10 = false;
                }
                if (z10) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    s z11 = resourceId != -1 ? i0Var.z(resourceId) : null;
                    if (z11 == null && string != null) {
                        z11 = i0Var.A(string);
                    }
                    if (z11 == null && id != -1) {
                        z11 = i0Var.z(id);
                    }
                    if (z11 == null) {
                        c0 C = i0Var.C();
                        context.getClassLoader();
                        z11 = C.a(attributeValue);
                        z11.A = true;
                        z11.J = resourceId != 0 ? resourceId : id;
                        z11.K = id;
                        z11.L = string;
                        z11.B = true;
                        z11.F = i0Var;
                        u uVar = i0Var.f707t;
                        z11.G = uVar;
                        f.j jVar = uVar.f826t;
                        z11.Q = true;
                        if ((uVar != null ? uVar.f825s : null) != null) {
                            z11.Q = true;
                        }
                        f10 = i0Var.a(z11);
                        if (i0.F(2)) {
                            Log.v("FragmentManager", "Fragment " + z11 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (z11.B) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        z11.B = true;
                        z11.F = i0Var;
                        u uVar2 = i0Var.f707t;
                        z11.G = uVar2;
                        f.j jVar2 = uVar2.f826t;
                        z11.Q = true;
                        if ((uVar2 != null ? uVar2.f825s : null) != null) {
                            z11.Q = true;
                        }
                        f10 = i0Var.f(z11);
                        if (i0.F(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + z11 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    y0.b bVar = y0.c.f13756a;
                    y0.c.b(new y0.a(z11, "Attempting to use <fragment> tag to add fragment " + z11 + " to container " + viewGroup));
                    y0.c.a(z11).getClass();
                    z11.R = viewGroup;
                    f10.k();
                    f10.j();
                    View view2 = z11.S;
                    if (view2 == null) {
                        throw new IllegalStateException(android.support.v4.media.d.q("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (z11.S.getTag() == null) {
                        z11.S.setTag(string);
                    }
                    z11.S.addOnAttachStateChangeListener(new w(this, f10));
                    return z11.S;
                }
            }
        }
        return null;
    }
}
