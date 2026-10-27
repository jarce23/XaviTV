package m;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements l.x {
    public boolean A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public g G;
    public g H;
    public i I;
    public h J;

    /* renamed from: o, reason: collision with root package name */
    public final Context f8450o;

    /* renamed from: p, reason: collision with root package name */
    public Context f8451p;

    /* renamed from: q, reason: collision with root package name */
    public l.l f8452q;

    /* renamed from: r, reason: collision with root package name */
    public final LayoutInflater f8453r;

    /* renamed from: s, reason: collision with root package name */
    public l.w f8454s;

    /* renamed from: v, reason: collision with root package name */
    public l.z f8457v;

    /* renamed from: w, reason: collision with root package name */
    public j f8458w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f8459x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8460y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f8461z;

    /* renamed from: t, reason: collision with root package name */
    public final int f8455t = R.layout.abc_action_menu_layout;

    /* renamed from: u, reason: collision with root package name */
    public final int f8456u = R.layout.abc_action_menu_item_layout;
    public final SparseBooleanArray F = new SparseBooleanArray();
    public final h5.i K = new h5.i(15, this);

    public k(Context context) {
        this.f8450o = context;
        this.f8453r = LayoutInflater.from(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [l.y] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final View a(l.n nVar, View view, ViewGroup viewGroup) {
        View actionView = nVar.getActionView();
        if (actionView == null || nVar.e()) {
            ActionMenuItemView actionMenuItemView = view instanceof l.y ? (l.y) view : (l.y) this.f8453r.inflate(this.f8456u, viewGroup, false);
            actionMenuItemView.b(nVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f8457v);
            if (this.J == null) {
                this.J = new h(this);
            }
            actionMenuItemView2.setPopupCallback(this.J);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(nVar.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof m)) {
            actionView.setLayoutParams(ActionMenuView.k(layoutParams));
        }
        return actionView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.x
    public final void b() {
        int i10;
        ViewGroup viewGroup = (ViewGroup) this.f8457v;
        ArrayList arrayList = null;
        boolean z10 = false;
        if (viewGroup != null) {
            l.l lVar = this.f8452q;
            if (lVar != null) {
                lVar.i();
                ArrayList l10 = this.f8452q.l();
                int size = l10.size();
                i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    l.n nVar = (l.n) l10.get(i11);
                    if ((nVar.f8036x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i10);
                        l.n itemData = childAt instanceof l.y ? ((l.y) childAt).getItemData() : null;
                        View a10 = a(nVar, childAt, viewGroup);
                        if (nVar != itemData) {
                            a10.setPressed(false);
                            a10.jumpDrawablesToCurrentState();
                        }
                        if (a10 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a10.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a10);
                            }
                            ((ViewGroup) this.f8457v).addView(a10, i10);
                        }
                        i10++;
                    }
                }
            } else {
                i10 = 0;
            }
            while (i10 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i10) == this.f8458w) {
                    i10++;
                } else {
                    viewGroup.removeViewAt(i10);
                }
            }
        }
        ((View) this.f8457v).requestLayout();
        l.l lVar2 = this.f8452q;
        if (lVar2 != null) {
            lVar2.i();
            ArrayList arrayList2 = lVar2.f7995i;
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                l.o oVar = ((l.n) arrayList2.get(i12)).A;
            }
        }
        l.l lVar3 = this.f8452q;
        if (lVar3 != null) {
            lVar3.i();
            arrayList = lVar3.f7996j;
        }
        if (this.f8461z && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z10 = !((l.n) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z10 = true;
            }
        }
        if (z10) {
            if (this.f8458w == null) {
                this.f8458w = new j(this, this.f8450o);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f8458w.getParent();
            if (viewGroup3 != this.f8457v) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f8458w);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f8457v;
                j jVar = this.f8458w;
                actionMenuView.getClass();
                m j10 = ActionMenuView.j();
                j10.f8475a = true;
                actionMenuView.addView(jVar, j10);
            }
        } else {
            j jVar2 = this.f8458w;
            if (jVar2 != null) {
                Object parent = jVar2.getParent();
                Object obj = this.f8457v;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f8458w);
                }
            }
        }
        ((ActionMenuView) this.f8457v).setOverflowReserved(this.f8461z);
    }

    public final boolean c() {
        Object obj;
        i iVar = this.I;
        if (iVar != null && (obj = this.f8457v) != null) {
            ((View) obj).removeCallbacks(iVar);
            this.I = null;
            return true;
        }
        g gVar = this.G;
        if (gVar == null) {
            return false;
        }
        if (gVar.b()) {
            gVar.f8057i.dismiss();
        }
        return true;
    }

    @Override // l.x
    public final void d(l.w wVar) {
        throw null;
    }

    @Override // l.x
    public final void e(l.l lVar, boolean z10) {
        c();
        g gVar = this.H;
        if (gVar != null && gVar.b()) {
            gVar.f8057i.dismiss();
        }
        l.w wVar = this.f8454s;
        if (wVar != null) {
            wVar.e(lVar, z10);
        }
    }

    public final boolean f() {
        g gVar = this.G;
        return gVar != null && gVar.b();
    }

    @Override // l.x
    public final boolean g(l.n nVar) {
        return false;
    }

    @Override // l.x
    public final void h(Context context, l.l lVar) {
        this.f8451p = context;
        LayoutInflater.from(context);
        this.f8452q = lVar;
        Resources resources = context.getResources();
        if (!this.A) {
            this.f8461z = true;
        }
        int i10 = 2;
        this.B = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i11 = configuration.screenWidthDp;
        int i12 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i11 > 600 || ((i11 > 960 && i12 > 720) || (i11 > 720 && i12 > 960))) {
            i10 = 5;
        } else if (i11 >= 500 || ((i11 > 640 && i12 > 480) || (i11 > 480 && i12 > 640))) {
            i10 = 4;
        } else if (i11 >= 360) {
            i10 = 3;
        }
        this.D = i10;
        int i13 = this.B;
        if (this.f8461z) {
            if (this.f8458w == null) {
                j jVar = new j(this, this.f8450o);
                this.f8458w = jVar;
                if (this.f8460y) {
                    jVar.setImageDrawable(this.f8459x);
                    this.f8459x = null;
                    this.f8460y = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f8458w.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i13 -= this.f8458w.getMeasuredWidth();
        } else {
            this.f8458w = null;
        }
        this.C = i13;
        float f10 = resources.getDisplayMetrics().density;
    }

    @Override // l.x
    public final boolean i() {
        int i10;
        ArrayList arrayList;
        int i11;
        boolean z10;
        k kVar = this;
        l.l lVar = kVar.f8452q;
        if (lVar != null) {
            arrayList = lVar.l();
            i10 = arrayList.size();
        } else {
            i10 = 0;
            arrayList = null;
        }
        int i12 = kVar.D;
        int i13 = kVar.C;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) kVar.f8457v;
        int i14 = 0;
        boolean z11 = false;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            i11 = 2;
            z10 = true;
            if (i14 >= i10) {
                break;
            }
            l.n nVar = (l.n) arrayList.get(i14);
            int i17 = nVar.f8037y;
            if ((i17 & 2) == 2) {
                i15++;
            } else if ((i17 & 1) == 1) {
                i16++;
            } else {
                z11 = true;
            }
            if (kVar.E && nVar.C) {
                i12 = 0;
            }
            i14++;
        }
        if (kVar.f8461z && (z11 || i16 + i15 > i12)) {
            i12--;
        }
        int i18 = i12 - i15;
        SparseBooleanArray sparseBooleanArray = kVar.F;
        sparseBooleanArray.clear();
        int i19 = 0;
        int i20 = 0;
        while (i19 < i10) {
            l.n nVar2 = (l.n) arrayList.get(i19);
            int i21 = nVar2.f8037y;
            boolean z12 = (i21 & 2) == i11 ? z10 : false;
            int i22 = nVar2.f8015b;
            if (z12) {
                View a10 = kVar.a(nVar2, null, viewGroup);
                a10.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = a10.getMeasuredWidth();
                i13 -= measuredWidth;
                if (i20 == 0) {
                    i20 = measuredWidth;
                }
                if (i22 != 0) {
                    sparseBooleanArray.put(i22, z10);
                }
                nVar2.f(z10);
            } else if ((i21 & 1) == z10) {
                boolean z13 = sparseBooleanArray.get(i22);
                boolean z14 = ((i18 > 0 || z13) && i13 > 0) ? z10 : false;
                if (z14) {
                    View a11 = kVar.a(nVar2, null, viewGroup);
                    a11.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = a11.getMeasuredWidth();
                    i13 -= measuredWidth2;
                    if (i20 == 0) {
                        i20 = measuredWidth2;
                    }
                    z14 &= i13 + i20 > 0;
                }
                if (z14 && i22 != 0) {
                    sparseBooleanArray.put(i22, true);
                } else if (z13) {
                    sparseBooleanArray.put(i22, false);
                    for (int i23 = 0; i23 < i19; i23++) {
                        l.n nVar3 = (l.n) arrayList.get(i23);
                        if (nVar3.f8015b == i22) {
                            if ((nVar3.f8036x & 32) == 32) {
                                i18++;
                            }
                            nVar3.f(false);
                        }
                    }
                }
                if (z14) {
                    i18--;
                }
                nVar2.f(z14);
            } else {
                nVar2.f(false);
                i19++;
                i11 = 2;
                kVar = this;
                z10 = true;
            }
            i19++;
            i11 = 2;
            kVar = this;
            z10 = true;
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.x
    public final boolean j(l.d0 d0Var) {
        boolean z10;
        if (d0Var.hasVisibleItems()) {
            l.d0 d0Var2 = d0Var;
            while (true) {
                l.l lVar = d0Var2.f7958z;
                if (lVar == this.f8452q) {
                    break;
                }
                d0Var2 = (l.d0) lVar;
            }
            l.n nVar = d0Var2.A;
            ViewGroup viewGroup = (ViewGroup) this.f8457v;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i10 = 0;
                while (true) {
                    if (i10 >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i10);
                    if ((childAt instanceof l.y) && ((l.y) childAt).getItemData() == nVar) {
                        view = childAt;
                        break;
                    }
                    i10++;
                }
            }
            if (view != null) {
                d0Var.A.getClass();
                int size = d0Var.f7993f.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        z10 = false;
                        break;
                    }
                    MenuItem item = d0Var.getItem(i11);
                    if (item.isVisible() && item.getIcon() != null) {
                        z10 = true;
                        break;
                    }
                    i11++;
                }
                g gVar = new g(this, this.f8451p, d0Var, view);
                this.H = gVar;
                gVar.g = z10;
                l.t tVar = gVar.f8057i;
                if (tVar != null) {
                    tVar.o(z10);
                }
                g gVar2 = this.H;
                if (!gVar2.b()) {
                    if (gVar2.f8054e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    gVar2.d(0, 0, false, false);
                }
                l.w wVar = this.f8454s;
                if (wVar != null) {
                    wVar.p(d0Var);
                }
                return true;
            }
        }
        return false;
    }

    @Override // l.x
    public final boolean k(l.n nVar) {
        return false;
    }

    public final boolean l() {
        l.l lVar;
        if (!this.f8461z || f() || (lVar = this.f8452q) == null || this.f8457v == null || this.I != null) {
            return false;
        }
        lVar.i();
        if (lVar.f7996j.isEmpty()) {
            return false;
        }
        i iVar = new i(this, new g(this, this.f8451p, this.f8452q, this.f8458w));
        this.I = iVar;
        ((View) this.f8457v).post(iVar);
        return true;
    }
}
