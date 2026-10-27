package m;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u2 implements l.x {

    /* renamed from: o, reason: collision with root package name */
    public l.l f8573o;

    /* renamed from: p, reason: collision with root package name */
    public l.n f8574p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Toolbar f8575q;

    public u2(Toolbar toolbar) {
        this.f8575q = toolbar;
    }

    @Override // l.x
    public final void b() {
        if (this.f8574p != null) {
            l.l lVar = this.f8573o;
            if (lVar != null) {
                int size = lVar.f7993f.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (this.f8573o.getItem(i10) == this.f8574p) {
                        return;
                    }
                }
            }
            k(this.f8574p);
        }
    }

    @Override // l.x
    public final boolean g(l.n nVar) {
        Toolbar toolbar = this.f8575q;
        toolbar.c();
        ViewParent parent = toolbar.f482v.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f482v);
            }
            toolbar.addView(toolbar.f482v);
        }
        View actionView = nVar.getActionView();
        toolbar.f483w = actionView;
        this.f8574p = nVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f483w);
            }
            v2 h10 = Toolbar.h();
            h10.f8580a = (toolbar.B & 112) | 8388611;
            h10.f8581b = 2;
            toolbar.f483w.setLayoutParams(h10);
            toolbar.addView(toolbar.f483w);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((v2) childAt.getLayoutParams()).f8581b != 2 && childAt != toolbar.f475o) {
                toolbar.removeViewAt(childCount);
                toolbar.S.add(childAt);
            }
        }
        toolbar.requestLayout();
        nVar.C = true;
        nVar.f8026n.p(false);
        KeyEvent.Callback callback = toolbar.f483w;
        if (callback instanceof k.b) {
            ((l.p) ((k.b) callback)).f8041o.onActionViewExpanded();
        }
        toolbar.t();
        return true;
    }

    @Override // l.x
    public final void h(Context context, l.l lVar) {
        l.n nVar;
        l.l lVar2 = this.f8573o;
        if (lVar2 != null && (nVar = this.f8574p) != null) {
            lVar2.d(nVar);
        }
        this.f8573o = lVar;
    }

    @Override // l.x
    public final boolean i() {
        return false;
    }

    @Override // l.x
    public final boolean j(l.d0 d0Var) {
        return false;
    }

    @Override // l.x
    public final boolean k(l.n nVar) {
        Toolbar toolbar = this.f8575q;
        KeyEvent.Callback callback = toolbar.f483w;
        if (callback instanceof k.b) {
            ((l.p) ((k.b) callback)).f8041o.onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.f483w);
        toolbar.removeView(toolbar.f482v);
        toolbar.f483w = null;
        ArrayList arrayList = toolbar.S;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f8574p = null;
        toolbar.requestLayout();
        nVar.C = false;
        nVar.f8026n.p(false);
        toolbar.t();
        return true;
    }

    @Override // l.x
    public final void e(l.l lVar, boolean z10) {
    }
}
