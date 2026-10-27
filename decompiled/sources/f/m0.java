package f;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m.f1;
import m.z2;
import m0.p0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 extends com.bumptech.glide.e implements m.d {
    public static final AccelerateInterpolator A = new AccelerateInterpolator();
    public static final DecelerateInterpolator B = new DecelerateInterpolator();

    /* renamed from: c, reason: collision with root package name */
    public Context f4807c;

    /* renamed from: d, reason: collision with root package name */
    public Context f4808d;

    /* renamed from: e, reason: collision with root package name */
    public ActionBarOverlayLayout f4809e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContainer f4810f;
    public f1 g;

    /* renamed from: h, reason: collision with root package name */
    public ActionBarContextView f4811h;

    /* renamed from: i, reason: collision with root package name */
    public final View f4812i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4813j;

    /* renamed from: k, reason: collision with root package name */
    public l0 f4814k;

    /* renamed from: l, reason: collision with root package name */
    public l0 f4815l;

    /* renamed from: m, reason: collision with root package name */
    public x4.c f4816m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4817n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f4818o;

    /* renamed from: p, reason: collision with root package name */
    public int f4819p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4820q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4821r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4822s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4823t;

    /* renamed from: u, reason: collision with root package name */
    public k.j f4824u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4825v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4826w;

    /* renamed from: x, reason: collision with root package name */
    public final k0 f4827x;

    /* renamed from: y, reason: collision with root package name */
    public final k0 f4828y;

    /* renamed from: z, reason: collision with root package name */
    public final a6.n f4829z;

    public m0(Activity activity, boolean z10) {
        new ArrayList();
        this.f4818o = new ArrayList();
        this.f4819p = 0;
        this.f4820q = true;
        this.f4823t = true;
        this.f4827x = new k0(this, 0);
        this.f4828y = new k0(this, 1);
        this.f4829z = new a6.n(24, this);
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (z10) {
            return;
        }
        this.f4812i = decorView.findViewById(R.id.content);
    }

    public final void B(boolean z10) {
        p0 i10;
        p0 p0Var;
        if (z10) {
            if (!this.f4822s) {
                this.f4822s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4809e;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                G(false);
            }
        } else if (this.f4822s) {
            this.f4822s = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4809e;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            G(false);
        }
        if (!this.f4810f.isLaidOut()) {
            if (z10) {
                ((z2) this.g).f8621a.setVisibility(4);
                this.f4811h.setVisibility(0);
                return;
            } else {
                ((z2) this.g).f8621a.setVisibility(0);
                this.f4811h.setVisibility(8);
                return;
            }
        }
        if (z10) {
            z2 z2Var = (z2) this.g;
            i10 = m0.k0.a(z2Var.f8621a);
            i10.a(0.0f);
            i10.c(100L);
            i10.d(new k.i(z2Var, 4));
            p0Var = this.f4811h.i(0, 200L);
        } else {
            z2 z2Var2 = (z2) this.g;
            p0 a10 = m0.k0.a(z2Var2.f8621a);
            a10.a(1.0f);
            a10.c(200L);
            a10.d(new k.i(z2Var2, 0));
            i10 = this.f4811h.i(8, 100L);
            p0Var = a10;
        }
        k.j jVar = new k.j();
        ArrayList arrayList = jVar.f7573a;
        arrayList.add(i10);
        View view = (View) i10.f8704a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) p0Var.f8704a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(p0Var);
        jVar.b();
    }

    public final Context C() {
        if (this.f4808d == null) {
            TypedValue typedValue = new TypedValue();
            this.f4807c.getTheme().resolveAttribute(org.chromium.net.R.attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f4808d = new ContextThemeWrapper(this.f4807c, i10);
            } else {
                this.f4808d = this.f4807c;
            }
        }
        return this.f4808d;
    }

    public final void D(View view) {
        f1 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(org.chromium.net.R.id.decor_content_parent);
        this.f4809e = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback findViewById = view.findViewById(org.chromium.net.R.id.action_bar);
        if (findViewById instanceof f1) {
            wrapper = (f1) findViewById;
        } else {
            if (!(findViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById != null ? findViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) findViewById).getWrapper();
        }
        this.g = wrapper;
        this.f4811h = (ActionBarContextView) view.findViewById(org.chromium.net.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(org.chromium.net.R.id.action_bar_container);
        this.f4810f = actionBarContainer;
        f1 f1Var = this.g;
        if (f1Var == null || this.f4811h == null || actionBarContainer == null) {
            throw new IllegalStateException(m0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((z2) f1Var).f8621a.getContext();
        this.f4807c = context;
        if ((((z2) this.g).f8622b & 4) != 0) {
            this.f4813j = true;
        }
        int i10 = context.getApplicationInfo().targetSdkVersion;
        this.g.getClass();
        F(context.getResources().getBoolean(org.chromium.net.R.bool.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.f4807c.obtainStyledAttributes(null, e.a.f4358a, org.chromium.net.R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4809e;
            if (!actionBarOverlayLayout2.f416u) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f4826w = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f4810f;
            WeakHashMap weakHashMap = m0.k0.f8683a;
            m0.c0.i(actionBarContainer2, dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void E(boolean z10) {
        if (this.f4813j) {
            return;
        }
        int i10 = z10 ? 4 : 0;
        z2 z2Var = (z2) this.g;
        int i11 = z2Var.f8622b;
        this.f4813j = true;
        z2Var.a((i10 & 4) | (i11 & (-5)));
    }

    public final void F(boolean z10) {
        if (z10) {
            this.f4810f.setTabContainer(null);
            ((z2) this.g).getClass();
        } else {
            ((z2) this.g).getClass();
            this.f4810f.setTabContainer(null);
        }
        this.g.getClass();
        ((z2) this.g).f8621a.setCollapsible(false);
        this.f4809e.setHasNonEmbeddedTabs(false);
    }

    public final void G(boolean z10) {
        boolean z11 = this.f4821r;
        boolean z12 = this.f4822s;
        final a6.n nVar = this.f4829z;
        View view = this.f4812i;
        if (!z12 && z11) {
            if (this.f4823t) {
                this.f4823t = false;
                k.j jVar = this.f4824u;
                if (jVar != null) {
                    jVar.a();
                }
                int i10 = this.f4819p;
                k0 k0Var = this.f4827x;
                if (i10 != 0 || (!this.f4825v && !z10)) {
                    k0Var.c();
                    return;
                }
                this.f4810f.setAlpha(1.0f);
                this.f4810f.setTransitioning(true);
                k.j jVar2 = new k.j();
                float f10 = -this.f4810f.getHeight();
                if (z10) {
                    this.f4810f.getLocationInWindow(new int[]{0, 0});
                    f10 -= r12[1];
                }
                p0 a10 = m0.k0.a(this.f4810f);
                a10.e(f10);
                final View view2 = (View) a10.f8704a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(nVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: m0.o0
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) ((f.m0) a6.n.this.f74p).f4810f.getParent()).invalidate();
                        }
                    } : null);
                }
                boolean z13 = jVar2.f7577e;
                ArrayList arrayList = jVar2.f7573a;
                if (!z13) {
                    arrayList.add(a10);
                }
                if (this.f4820q && view != null) {
                    p0 a11 = m0.k0.a(view);
                    a11.e(f10);
                    if (!jVar2.f7577e) {
                        arrayList.add(a11);
                    }
                }
                boolean z14 = jVar2.f7577e;
                if (!z14) {
                    jVar2.f7575c = A;
                }
                if (!z14) {
                    jVar2.f7574b = 250L;
                }
                if (!z14) {
                    jVar2.f7576d = k0Var;
                }
                this.f4824u = jVar2;
                jVar2.b();
                return;
            }
            return;
        }
        if (this.f4823t) {
            return;
        }
        this.f4823t = true;
        k.j jVar3 = this.f4824u;
        if (jVar3 != null) {
            jVar3.a();
        }
        this.f4810f.setVisibility(0);
        int i11 = this.f4819p;
        k0 k0Var2 = this.f4828y;
        if (i11 == 0 && (this.f4825v || z10)) {
            this.f4810f.setTranslationY(0.0f);
            float f11 = -this.f4810f.getHeight();
            if (z10) {
                this.f4810f.getLocationInWindow(new int[]{0, 0});
                f11 -= r12[1];
            }
            this.f4810f.setTranslationY(f11);
            k.j jVar4 = new k.j();
            p0 a12 = m0.k0.a(this.f4810f);
            a12.e(0.0f);
            final View view3 = (View) a12.f8704a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(nVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: m0.o0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((View) ((f.m0) a6.n.this.f74p).f4810f.getParent()).invalidate();
                    }
                } : null);
            }
            boolean z15 = jVar4.f7577e;
            ArrayList arrayList2 = jVar4.f7573a;
            if (!z15) {
                arrayList2.add(a12);
            }
            if (this.f4820q && view != null) {
                view.setTranslationY(f11);
                p0 a13 = m0.k0.a(view);
                a13.e(0.0f);
                if (!jVar4.f7577e) {
                    arrayList2.add(a13);
                }
            }
            boolean z16 = jVar4.f7577e;
            if (!z16) {
                jVar4.f7575c = B;
            }
            if (!z16) {
                jVar4.f7574b = 250L;
            }
            if (!z16) {
                jVar4.f7576d = k0Var2;
            }
            this.f4824u = jVar4;
            jVar4.b();
        } else {
            this.f4810f.setAlpha(1.0f);
            this.f4810f.setTranslationY(0.0f);
            if (this.f4820q && view != null) {
                view.setTranslationY(0.0f);
            }
            k0Var2.c();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f4809e;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = m0.k0.f8683a;
            m0.a0.c(actionBarOverlayLayout);
        }
    }

    public m0(Dialog dialog) {
        new ArrayList();
        this.f4818o = new ArrayList();
        this.f4819p = 0;
        this.f4820q = true;
        this.f4823t = true;
        this.f4827x = new k0(this, 0);
        this.f4828y = new k0(this, 1);
        this.f4829z = new a6.n(24, this);
        D(dialog.getWindow().getDecorView());
    }
}
