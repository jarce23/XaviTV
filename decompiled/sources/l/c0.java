package l;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.o0;
import m.e2;
import m.o1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 extends t implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public View A;
    public w B;
    public ViewTreeObserver C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean H;

    /* renamed from: p, reason: collision with root package name */
    public final Context f7945p;

    /* renamed from: q, reason: collision with root package name */
    public final l f7946q;

    /* renamed from: r, reason: collision with root package name */
    public final i f7947r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f7948s;

    /* renamed from: t, reason: collision with root package name */
    public final int f7949t;

    /* renamed from: u, reason: collision with root package name */
    public final int f7950u;

    /* renamed from: v, reason: collision with root package name */
    public final e2 f7951v;

    /* renamed from: y, reason: collision with root package name */
    public PopupWindow.OnDismissListener f7954y;

    /* renamed from: z, reason: collision with root package name */
    public View f7955z;

    /* renamed from: w, reason: collision with root package name */
    public final d f7952w = new d(1, this);

    /* renamed from: x, reason: collision with root package name */
    public final o0 f7953x = new o0(3, this);
    public int G = 0;

    public c0(Context context, l lVar, View view, int i10, boolean z10) {
        this.f7945p = context;
        this.f7946q = lVar;
        this.f7948s = z10;
        this.f7947r = new i(lVar, LayoutInflater.from(context), z10, R.layout.abc_popup_menu_item_layout);
        this.f7950u = i10;
        Resources resources = context.getResources();
        this.f7949t = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f7955z = view;
        this.f7951v = new e2(context, null, i10, 0);
        lVar.b(this, context);
    }

    @Override // l.b0
    public final boolean a() {
        return !this.D && this.f7951v.N.isShowing();
    }

    @Override // l.x
    public final void b() {
        this.E = false;
        i iVar = this.f7947r;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
    }

    @Override // l.b0
    public final void c() {
        View view;
        if (a()) {
            return;
        }
        if (this.D || (view = this.f7955z) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.A = view;
        e2 e2Var = this.f7951v;
        m.x xVar = e2Var.N;
        m.x xVar2 = e2Var.N;
        xVar.setOnDismissListener(this);
        e2Var.D = this;
        e2Var.M = true;
        xVar2.setFocusable(true);
        View view2 = this.A;
        boolean z10 = this.C == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.C = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f7952w);
        }
        view2.addOnAttachStateChangeListener(this.f7953x);
        e2Var.C = view2;
        e2Var.f8620z = this.G;
        boolean z11 = this.E;
        Context context = this.f7945p;
        i iVar = this.f7947r;
        if (!z11) {
            this.F = t.m(iVar, context, this.f7949t);
            this.E = true;
        }
        e2Var.r(this.F);
        xVar2.setInputMethodMode(2);
        Rect rect = this.f8048o;
        e2Var.L = rect != null ? new Rect(rect) : null;
        e2Var.c();
        o1 o1Var = e2Var.f8611q;
        o1Var.setOnKeyListener(this);
        if (this.H) {
            l lVar = this.f7946q;
            if (lVar.f7999m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) o1Var, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(lVar.f7999m);
                }
                frameLayout.setEnabled(false);
                o1Var.addHeaderView(frameLayout, null, false);
            }
        }
        e2Var.o(iVar);
        e2Var.c();
    }

    @Override // l.x
    public final void d(w wVar) {
        this.B = wVar;
    }

    @Override // l.b0
    public final void dismiss() {
        if (a()) {
            this.f7951v.dismiss();
        }
    }

    @Override // l.x
    public final void e(l lVar, boolean z10) {
        if (lVar != this.f7946q) {
            return;
        }
        dismiss();
        w wVar = this.B;
        if (wVar != null) {
            wVar.e(lVar, z10);
        }
    }

    @Override // l.b0
    public final o1 f() {
        return this.f7951v.f8611q;
    }

    @Override // l.x
    public final boolean i() {
        return false;
    }

    @Override // l.x
    public final boolean j(d0 d0Var) {
        boolean z10;
        if (d0Var.hasVisibleItems()) {
            v vVar = new v(this.f7945p, d0Var, this.A, this.f7948s, this.f7950u, 0);
            w wVar = this.B;
            vVar.f8056h = wVar;
            t tVar = vVar.f8057i;
            if (tVar != null) {
                tVar.d(wVar);
            }
            int size = d0Var.f7993f.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    z10 = false;
                    break;
                }
                MenuItem item = d0Var.getItem(i10);
                if (item.isVisible() && item.getIcon() != null) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            vVar.g = z10;
            t tVar2 = vVar.f8057i;
            if (tVar2 != null) {
                tVar2.o(z10);
            }
            vVar.f8058j = this.f7954y;
            this.f7954y = null;
            this.f7946q.c(false);
            e2 e2Var = this.f7951v;
            int i11 = e2Var.f8614t;
            int l10 = e2Var.l();
            if ((Gravity.getAbsoluteGravity(this.G, this.f7955z.getLayoutDirection()) & 7) == 5) {
                i11 += this.f7955z.getWidth();
            }
            if (!vVar.b()) {
                if (vVar.f8054e != null) {
                    vVar.d(i11, l10, true, true);
                }
            }
            w wVar2 = this.B;
            if (wVar2 != null) {
                wVar2.p(d0Var);
            }
            return true;
        }
        return false;
    }

    @Override // l.t
    public final void n(View view) {
        this.f7955z = view;
    }

    @Override // l.t
    public final void o(boolean z10) {
        this.f7947r.f7983q = z10;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.D = true;
        this.f7946q.c(true);
        ViewTreeObserver viewTreeObserver = this.C;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.C = this.A.getViewTreeObserver();
            }
            this.C.removeGlobalOnLayoutListener(this.f7952w);
            this.C = null;
        }
        this.A.removeOnAttachStateChangeListener(this.f7953x);
        PopupWindow.OnDismissListener onDismissListener = this.f7954y;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // l.t
    public final void p(int i10) {
        this.G = i10;
    }

    @Override // l.t
    public final void q(int i10) {
        this.f7951v.f8614t = i10;
    }

    @Override // l.t
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f7954y = onDismissListener;
    }

    @Override // l.t
    public final void s(boolean z10) {
        this.H = z10;
    }

    @Override // l.t
    public final void t(int i10) {
        this.f7951v.h(i10);
    }

    @Override // l.t
    public final void l(l lVar) {
    }
}
