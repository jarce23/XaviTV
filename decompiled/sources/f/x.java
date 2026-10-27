package f;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import m0.p0;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x implements Window.Callback {

    /* renamed from: o, reason: collision with root package name */
    public final Window.Callback f4851o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4852p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4853q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4854r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ b0 f4855s;

    public x(b0 b0Var, Window.Callback callback) {
        this.f4855s = b0Var;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f4851o = callback;
    }

    public final void a(Window.Callback callback) {
        try {
            this.f4852p = true;
            callback.onContentChanged();
        } finally {
            this.f4852p = false;
        }
    }

    public final boolean b(int i10, Menu menu) {
        return this.f4851o.onMenuOpened(i10, menu);
    }

    public final void c(int i10, Menu menu) {
        this.f4851o.onPanelClosed(i10, menu);
    }

    public final void d(List list, Menu menu, int i10) {
        k.l.a(this.f4851o, list, menu, i10);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f4851o.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z10 = this.f4853q;
        Window.Callback callback = this.f4851o;
        return z10 ? callback.dispatchKeyEvent(keyEvent) : this.f4855s.t(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (r7 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        if (r0 != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006e A[RETURN] */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r7) {
        /*
            r6 = this;
            android.view.Window$Callback r0 = r6.f4851o
            boolean r0 = r0.dispatchKeyShortcutEvent(r7)
            r1 = 1
            if (r0 != 0) goto L6f
            int r0 = r7.getKeyCode()
            f.b0 r2 = r6.f4855s
            r2.A()
            f.m0 r3 = r2.C
            r4 = 0
            if (r3 == 0) goto L3d
            f.l0 r3 = r3.f4814k
            if (r3 != 0) goto L1d
        L1b:
            r0 = r4
            goto L39
        L1d:
            l.l r3 = r3.f4803r
            if (r3 == 0) goto L1b
            int r5 = r7.getDeviceId()
            android.view.KeyCharacterMap r5 = android.view.KeyCharacterMap.load(r5)
            int r5 = r5.getKeyboardType()
            if (r5 == r1) goto L31
            r5 = r1
            goto L32
        L31:
            r5 = r4
        L32:
            r3.setQwertyMode(r5)
            boolean r0 = r3.performShortcut(r0, r7, r4)
        L39:
            if (r0 == 0) goto L3d
        L3b:
            r7 = r1
            goto L6b
        L3d:
            f.a0 r0 = r2.f4721b0
            if (r0 == 0) goto L52
            int r3 = r7.getKeyCode()
            boolean r0 = r2.F(r0, r3, r7)
            if (r0 == 0) goto L52
            f.a0 r7 = r2.f4721b0
            if (r7 == 0) goto L3b
            r7.f4696l = r1
            goto L3b
        L52:
            f.a0 r0 = r2.f4721b0
            if (r0 != 0) goto L6a
            f.a0 r0 = r2.z(r4)
            r2.G(r0, r7)
            int r3 = r7.getKeyCode()
            boolean r7 = r2.F(r0, r3, r7)
            r0.f4695k = r4
            if (r7 == 0) goto L6a
            goto L3b
        L6a:
            r7 = r4
        L6b:
            if (r7 == 0) goto L6e
            goto L6f
        L6e:
            return r4
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f4851o.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f4851o.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f4851o.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f4851o.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f4851o.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f4851o.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f4852p) {
            this.f4851o.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 != 0 || (menu instanceof l.l)) {
            return this.f4851o.onCreatePanelMenu(i10, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i10) {
        return this.f4851o.onCreatePanelView(i10);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f4851o.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        return this.f4851o.onMenuItemSelected(i10, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i10, Menu menu) {
        b(i10, menu);
        if (i10 == 108) {
            b0 b0Var = this.f4855s;
            b0Var.A();
            m0 m0Var = b0Var.C;
            if (m0Var != null) {
                ArrayList arrayList = m0Var.f4818o;
                if (true != m0Var.f4817n) {
                    m0Var.f4817n = true;
                    if (arrayList.size() > 0) {
                        throw android.support.v4.media.d.k(0, arrayList);
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i10, Menu menu) {
        if (this.f4854r) {
            this.f4851o.onPanelClosed(i10, menu);
            return;
        }
        c(i10, menu);
        b0 b0Var = this.f4855s;
        if (i10 != 108) {
            if (i10 == 0) {
                a0 z10 = b0Var.z(i10);
                if (z10.f4697m) {
                    b0Var.q(z10, false);
                    return;
                }
                return;
            }
            return;
        }
        b0Var.A();
        m0 m0Var = b0Var.C;
        if (m0Var != null) {
            ArrayList arrayList = m0Var.f4818o;
            if (m0Var.f4817n) {
                m0Var.f4817n = false;
                if (arrayList.size() > 0) {
                    throw android.support.v4.media.d.k(0, arrayList);
                }
            }
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z10) {
        k.m.a(this.f4851o, z10);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i10, View view, Menu menu) {
        l.l lVar = menu instanceof l.l ? (l.l) menu : null;
        if (i10 == 0 && lVar == null) {
            return false;
        }
        if (lVar != null) {
            lVar.f8010x = true;
        }
        boolean onPreparePanel = this.f4851o.onPreparePanel(i10, view, menu);
        if (lVar != null) {
            lVar.f8010x = false;
        }
        return onPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i10) {
        l.l lVar = this.f4855s.z(0).f4692h;
        if (lVar != null) {
            d(list, lVar, i10);
        } else {
            d(list, menu, i10);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return k.k.a(this.f4851o, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f4851o.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z10) {
        this.f4851o.onWindowFocusChanged(z10);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
        ViewGroup viewGroup;
        b0 b0Var = this.f4855s;
        if (!b0Var.N || i10 != 0) {
            return k.k.b(this.f4851o, callback, i10);
        }
        Context context = b0Var.f4742y;
        x4.i iVar = new x4.i(context, callback);
        k.a aVar = b0Var.I;
        if (aVar != null) {
            aVar.a();
        }
        x4.c cVar = new x4.c(b0Var, iVar, 6, false);
        b0Var.A();
        m0 m0Var = b0Var.C;
        int i11 = 1;
        if (m0Var != null) {
            l0 l0Var = m0Var.f4814k;
            if (l0Var != null) {
                l0Var.a();
            }
            m0Var.f4809e.setHideOnContentScrollEnabled(false);
            m0Var.f4811h.e();
            l0 l0Var2 = new l0(m0Var, m0Var.f4811h.getContext(), cVar);
            l.l lVar = l0Var2.f4803r;
            lVar.w();
            try {
                if (((x4.i) l0Var2.f4804s.f13537p).t(l0Var2, lVar)) {
                    m0Var.f4814k = l0Var2;
                    l0Var2.g();
                    m0Var.f4811h.c(l0Var2);
                    m0Var.B(true);
                } else {
                    l0Var2 = null;
                }
                b0Var.I = l0Var2;
            } finally {
                lVar.v();
            }
        }
        if (b0Var.I == null) {
            p0 p0Var = b0Var.M;
            if (p0Var != null) {
                p0Var.b();
            }
            k.a aVar2 = b0Var.I;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (b0Var.J == null) {
                if (b0Var.X) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context.getTheme();
                    theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme newTheme = context.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        k.c cVar2 = new k.c(context, 0);
                        cVar2.getTheme().setTo(newTheme);
                        context = cVar2;
                    }
                    b0Var.J = new ActionBarContextView(context, null);
                    PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    b0Var.K = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    b0Var.K.setContentView(b0Var.J);
                    b0Var.K.setWidth(-1);
                    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    b0Var.J.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    b0Var.K.setHeight(-2);
                    b0Var.L = new r(b0Var, i11);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) b0Var.P.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        b0Var.A();
                        m0 m0Var2 = b0Var.C;
                        Context C = m0Var2 != null ? m0Var2.C() : null;
                        if (C != null) {
                            context = C;
                        }
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                        b0Var.J = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (b0Var.J != null) {
                p0 p0Var2 = b0Var.M;
                if (p0Var2 != null) {
                    p0Var2.b();
                }
                b0Var.J.e();
                Context context2 = b0Var.J.getContext();
                ActionBarContextView actionBarContextView = b0Var.J;
                k.d dVar = new k.d();
                dVar.f7527q = context2;
                dVar.f7528r = actionBarContextView;
                dVar.f7529s = cVar;
                l.l lVar2 = new l.l(actionBarContextView.getContext());
                lVar2.f7998l = 1;
                dVar.f7532v = lVar2;
                lVar2.f7992e = dVar;
                if (iVar.t(dVar, lVar2)) {
                    dVar.g();
                    b0Var.J.c(dVar);
                    b0Var.I = dVar;
                    if (b0Var.O && (viewGroup = b0Var.P) != null && viewGroup.isLaidOut()) {
                        b0Var.J.setAlpha(0.0f);
                        p0 a10 = m0.k0.a(b0Var.J);
                        a10.a(1.0f);
                        b0Var.M = a10;
                        a10.d(new t(i11, b0Var));
                    } else {
                        b0Var.J.setAlpha(1.0f);
                        b0Var.J.setVisibility(0);
                        if (b0Var.J.getParent() instanceof View) {
                            View view = (View) b0Var.J.getParent();
                            WeakHashMap weakHashMap = m0.k0.f8683a;
                            m0.a0.c(view);
                        }
                    }
                    if (b0Var.K != null) {
                        b0Var.f4743z.getDecorView().post(b0Var.L);
                    }
                } else {
                    b0Var.I = null;
                }
            }
            b0Var.I();
            b0Var.I = b0Var.I;
        }
        b0Var.I();
        k.a aVar3 = b0Var.I;
        if (aVar3 != null) {
            return iVar.j(aVar3);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f4851o.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
