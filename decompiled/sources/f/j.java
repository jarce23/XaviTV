package f;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.r0;
import java.util.ArrayList;
import java.util.Objects;
import m.e3;
import m.z2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class j extends androidx.activity.n implements k {
    public boolean I;
    public boolean J;
    public b0 L;
    public final a6.n G = new a6.n(3, new androidx.fragment.app.u(this));
    public final androidx.lifecycle.t H = new androidx.lifecycle.t(this);
    public boolean K = true;

    public j() {
        ((f4.d) this.f311s.f3099d).e("android:support:lifecycle", new androidx.activity.f(1, this));
        final int i10 = 0;
        h(new l0.a(this) { // from class: androidx.fragment.app.t

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f.j f821b;

            {
                this.f821b = this;
            }

            @Override // l0.a
            public final void accept(Object obj) {
                switch (i10) {
                    case 0:
                        this.f821b.G.G();
                        break;
                    default:
                        this.f821b.G.G();
                        break;
                }
            }
        });
        final int i11 = 1;
        this.B.add(new l0.a(this) { // from class: androidx.fragment.app.t

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f.j f821b;

            {
                this.f821b = this;
            }

            @Override // l0.a
            public final void accept(Object obj) {
                switch (i11) {
                    case 0:
                        this.f821b.G.G();
                        break;
                    default:
                        this.f821b.G.G();
                        break;
                }
            }
        });
        i(new androidx.activity.g(this, 1));
        ((f4.d) this.f311s.f3099d).e("androidx:appcompat", new h(this));
        i(new i(this));
    }

    public static boolean o(androidx.fragment.app.i0 i0Var) {
        boolean z10 = false;
        for (androidx.fragment.app.s sVar : i0Var.f691c.m()) {
            if (sVar != null) {
                androidx.fragment.app.u uVar = sVar.G;
                if ((uVar == null ? null : uVar.f829w) != null) {
                    z10 |= o(sVar.h());
                }
                r0 r0Var = sVar.f801b0;
                androidx.lifecycle.m mVar = androidx.lifecycle.m.f1147r;
                if (r0Var != null) {
                    r0Var.c();
                    if (r0Var.f797r.f1158c.compareTo(mVar) >= 0) {
                        sVar.f801b0.f797r.g();
                        z10 = true;
                    }
                }
                if (sVar.f800a0.f1158c.compareTo(mVar) >= 0) {
                    sVar.f800a0.g();
                    z10 = true;
                }
            }
        }
        return z10;
    }

    @Override // android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k();
        b0 b0Var = (b0) m();
        b0Var.v();
        ((ViewGroup) b0Var.P.findViewById(R.id.content)).addView(view, layoutParams);
        b0Var.A.a(b0Var.f4743z.getCallback());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        b0 b0Var = (b0) m();
        b0Var.f4723d0 = true;
        int i18 = b0Var.h0;
        if (i18 == -100) {
            i18 = q.f4837p;
        }
        int C = b0Var.C(context, i18);
        if (q.b(context) && q.b(context)) {
            if (Build.VERSION.SDK_INT < 33) {
                synchronized (q.f4844w) {
                    try {
                        i0.f fVar = q.f4838q;
                        if (fVar == null) {
                            if (q.f4839r == null) {
                                q.f4839r = i0.f.b(b0.c.e(context));
                            }
                            if (!q.f4839r.f5785a.isEmpty()) {
                                q.f4838q = q.f4839r;
                            }
                        } else if (!fVar.equals(q.f4839r)) {
                            i0.f fVar2 = q.f4838q;
                            q.f4839r = fVar2;
                            b0.c.d(context, fVar2.f5785a.a());
                        }
                    } finally {
                    }
                }
            } else if (!q.f4841t) {
                q.f4836o.execute(new l(context, 0));
            }
        }
        i0.f n10 = b0.n(context);
        Configuration configuration = null;
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(b0.s(context, C, n10, null, false));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof k.c) {
            try {
                ((k.c) context).a(b0.s(context, C, n10, null, false));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (b0.f4719y0) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f10 = configuration3.fontScale;
                    float f11 = configuration4.fontScale;
                    if (f10 != f11) {
                        configuration.fontScale = f11;
                    }
                    int i19 = configuration3.mcc;
                    int i20 = configuration4.mcc;
                    if (i19 != i20) {
                        configuration.mcc = i20;
                    }
                    int i21 = configuration3.mnc;
                    int i22 = configuration4.mnc;
                    if (i21 != i22) {
                        configuration.mnc = i22;
                    }
                    int i23 = Build.VERSION.SDK_INT;
                    if (i23 >= 24) {
                        v.a(configuration3, configuration4, configuration);
                    } else if (!Objects.equals(configuration3.locale, configuration4.locale)) {
                        configuration.locale = configuration4.locale;
                    }
                    int i24 = configuration3.touchscreen;
                    int i25 = configuration4.touchscreen;
                    if (i24 != i25) {
                        configuration.touchscreen = i25;
                    }
                    int i26 = configuration3.keyboard;
                    int i27 = configuration4.keyboard;
                    if (i26 != i27) {
                        configuration.keyboard = i27;
                    }
                    int i28 = configuration3.keyboardHidden;
                    int i29 = configuration4.keyboardHidden;
                    if (i28 != i29) {
                        configuration.keyboardHidden = i29;
                    }
                    int i30 = configuration3.navigation;
                    int i31 = configuration4.navigation;
                    if (i30 != i31) {
                        configuration.navigation = i31;
                    }
                    int i32 = configuration3.navigationHidden;
                    int i33 = configuration4.navigationHidden;
                    if (i32 != i33) {
                        configuration.navigationHidden = i33;
                    }
                    int i34 = configuration3.orientation;
                    int i35 = configuration4.orientation;
                    if (i34 != i35) {
                        configuration.orientation = i35;
                    }
                    int i36 = configuration3.screenLayout & 15;
                    int i37 = configuration4.screenLayout & 15;
                    if (i36 != i37) {
                        configuration.screenLayout |= i37;
                    }
                    int i38 = configuration3.screenLayout & 192;
                    int i39 = configuration4.screenLayout & 192;
                    if (i38 != i39) {
                        configuration.screenLayout |= i39;
                    }
                    int i40 = configuration3.screenLayout & 48;
                    int i41 = configuration4.screenLayout & 48;
                    if (i40 != i41) {
                        configuration.screenLayout |= i41;
                    }
                    int i42 = configuration3.screenLayout & 768;
                    int i43 = configuration4.screenLayout & 768;
                    if (i42 != i43) {
                        configuration.screenLayout |= i43;
                    }
                    if (i23 >= 26) {
                        i10 = configuration3.colorMode;
                        int i44 = i10 & 3;
                        i11 = configuration4.colorMode;
                        if (i44 != (i11 & 3)) {
                            i16 = configuration.colorMode;
                            i17 = configuration4.colorMode;
                            configuration.colorMode = i16 | (i17 & 3);
                        }
                        i12 = configuration3.colorMode;
                        int i45 = i12 & 12;
                        i13 = configuration4.colorMode;
                        if (i45 != (i13 & 12)) {
                            i14 = configuration.colorMode;
                            i15 = configuration4.colorMode;
                            configuration.colorMode = i14 | (i15 & 12);
                        }
                    }
                    int i46 = configuration3.uiMode & 15;
                    int i47 = configuration4.uiMode & 15;
                    if (i46 != i47) {
                        configuration.uiMode |= i47;
                    }
                    int i48 = configuration3.uiMode & 48;
                    int i49 = configuration4.uiMode & 48;
                    if (i48 != i49) {
                        configuration.uiMode |= i49;
                    }
                    int i50 = configuration3.screenWidthDp;
                    int i51 = configuration4.screenWidthDp;
                    if (i50 != i51) {
                        configuration.screenWidthDp = i51;
                    }
                    int i52 = configuration3.screenHeightDp;
                    int i53 = configuration4.screenHeightDp;
                    if (i52 != i53) {
                        configuration.screenHeightDp = i53;
                    }
                    int i54 = configuration3.smallestScreenWidthDp;
                    int i55 = configuration4.smallestScreenWidthDp;
                    if (i54 != i55) {
                        configuration.smallestScreenWidthDp = i55;
                    }
                    int i56 = configuration3.densityDpi;
                    int i57 = configuration4.densityDpi;
                    if (i56 != i57) {
                        configuration.densityDpi = i57;
                    }
                }
            }
            Configuration s10 = b0.s(context, C, n10, configuration, true);
            k.c cVar = new k.c(context, org.chromium.net.R.style.Theme_AppCompat_Empty);
            cVar.a(s10);
            try {
                if (context.getTheme() != null) {
                    d0.b.m(cVar.getTheme());
                }
            } catch (NullPointerException unused3) {
            }
            context = cVar;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        ((b0) m()).A();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // b0.e, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        ((b0) m()).A();
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (r1.equals("--list-dumpables") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 33) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        if (r1.equals("--dump-dumpable") == false) goto L37;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dump(java.lang.String r8, java.io.FileDescriptor r9, java.io.PrintWriter r10, java.lang.String[] r11) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.j.dump(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    @Override // android.app.Activity
    public final View findViewById(int i10) {
        b0 b0Var = (b0) m();
        b0Var.v();
        return b0Var.f4743z.findViewById(i10);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        b0 b0Var = (b0) m();
        if (b0Var.D == null) {
            b0Var.A();
            m0 m0Var = b0Var.C;
            b0Var.D = new k.h(m0Var != null ? m0Var.C() : b0Var.f4742y);
        }
        return b0Var.D;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i10 = e3.f8405a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        b0 b0Var = (b0) m();
        if (b0Var.C != null) {
            b0Var.A();
            b0Var.C.getClass();
            b0Var.B(0);
        }
    }

    public final q m() {
        if (this.L == null) {
            o oVar = q.f4836o;
            this.L = new b0(this, null, this, this);
        }
        return this.L;
    }

    public final androidx.fragment.app.j0 n() {
        return ((androidx.fragment.app.u) this.G.f74p).f828v;
    }

    @Override // androidx.activity.n, android.app.Activity
    public final void onActivityResult(int i10, int i11, Intent intent) {
        this.G.G();
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.n, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b0 b0Var = (b0) m();
        if (b0Var.U && b0Var.O) {
            b0Var.A();
            m0 m0Var = b0Var.C;
            if (m0Var != null) {
                m0Var.F(m0Var.f4807c.getResources().getBoolean(org.chromium.net.R.bool.abc_action_bar_embed_tabs));
            }
        }
        m.r a10 = m.r.a();
        Context context = b0Var.f4742y;
        synchronized (a10) {
            a10.f8529a.l(context);
        }
        b0Var.f4726g0 = new Configuration(b0Var.f4742y.getResources().getConfiguration());
        b0Var.l(false, false);
    }

    @Override // androidx.activity.n, b0.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.H.d(androidx.lifecycle.l.ON_CREATE);
        androidx.fragment.app.j0 j0Var = ((androidx.fragment.app.u) this.G.f74p).f828v;
        j0Var.E = false;
        j0Var.F = false;
        j0Var.L.f736h = false;
        j0Var.t(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = ((androidx.fragment.app.u) this.G.f74p).f828v.f694f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        p();
        m().d();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i10, keyEvent);
        }
        return true;
    }

    @Override // androidx.activity.n, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        Intent b2;
        if (!q(i10, menuItem)) {
            b0 b0Var = (b0) m();
            b0Var.A();
            m0 m0Var = b0Var.C;
            if (menuItem.getItemId() != 16908332 || m0Var == null || (((z2) m0Var.g).f8622b & 4) == 0 || (b2 = b0.c.b(this)) == null) {
                return false;
            }
            if (!shouldUpRecreateTask(b2)) {
                navigateUpTo(b2);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Intent b10 = b0.c.b(this);
            if (b10 == null) {
                b10 = b0.c.b(this);
            }
            if (b10 != null) {
                ComponentName component = b10.getComponent();
                if (component == null) {
                    component = b10.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent a10 = b0.c.a(this, component);
                    while (a10 != null) {
                        arrayList.add(size, a10);
                        a10 = b0.c.a(this, a10.getComponent());
                    }
                    arrayList.add(b10);
                } catch (PackageManager.NameNotFoundException e7) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e7);
                }
            }
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            startActivities(intentArr, null);
            try {
                finishAffinity();
            } catch (IllegalStateException unused) {
                finish();
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.J = false;
        ((androidx.fragment.app.u) this.G.f74p).f828v.t(5);
        this.H.d(androidx.lifecycle.l.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((b0) m()).v();
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        r();
        b0 b0Var = (b0) m();
        b0Var.A();
        m0 m0Var = b0Var.C;
        if (m0Var != null) {
            m0Var.f4825v = true;
        }
    }

    @Override // androidx.activity.n, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.G.G();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        a6.n nVar = this.G;
        nVar.G();
        super.onResume();
        this.J = true;
        ((androidx.fragment.app.u) nVar.f74p).f828v.x(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        s();
        ((b0) m()).l(true, false);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.G.G();
    }

    @Override // android.app.Activity
    public void onStop() {
        t();
        b0 b0Var = (b0) m();
        b0Var.A();
        m0 m0Var = b0Var.C;
        if (m0Var != null) {
            m0Var.f4825v = false;
            k.j jVar = m0Var.f4824u;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        m().k(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        ((b0) m()).A();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    public final void p() {
        super.onDestroy();
        ((androidx.fragment.app.u) this.G.f74p).f828v.k();
        this.H.d(androidx.lifecycle.l.ON_DESTROY);
    }

    public final boolean q(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return ((androidx.fragment.app.u) this.G.f74p).f828v.i();
        }
        return false;
    }

    public final void r() {
        super.onPostResume();
        this.H.d(androidx.lifecycle.l.ON_RESUME);
        androidx.fragment.app.j0 j0Var = ((androidx.fragment.app.u) this.G.f74p).f828v;
        j0Var.E = false;
        j0Var.F = false;
        j0Var.L.f736h = false;
        j0Var.t(7);
    }

    public final void s() {
        a6.n nVar = this.G;
        nVar.G();
        androidx.fragment.app.u uVar = (androidx.fragment.app.u) nVar.f74p;
        super.onStart();
        this.K = false;
        if (!this.I) {
            this.I = true;
            androidx.fragment.app.j0 j0Var = uVar.f828v;
            j0Var.E = false;
            j0Var.F = false;
            j0Var.L.f736h = false;
            j0Var.t(4);
        }
        uVar.f828v.x(true);
        this.H.d(androidx.lifecycle.l.ON_START);
        androidx.fragment.app.j0 j0Var2 = uVar.f828v;
        j0Var2.E = false;
        j0Var2.F = false;
        j0Var2.L.f736h = false;
        j0Var2.t(5);
    }

    @Override // android.app.Activity
    public final void setContentView(int i10) {
        k();
        m().g(i10);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i10) {
        super.setTheme(i10);
        ((b0) m()).f4727i0 = i10;
    }

    public final void t() {
        super.onStop();
        this.K = true;
        while (o(n())) {
        }
        androidx.fragment.app.j0 j0Var = ((androidx.fragment.app.u) this.G.f74p).f828v;
        j0Var.F = true;
        j0Var.L.f736h = true;
        j0Var.t(4);
        this.H.d(androidx.lifecycle.l.ON_STOP);
    }

    @Override // androidx.activity.n, android.app.Activity
    public void setContentView(View view) {
        k();
        m().i(view);
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k();
        m().j(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = ((androidx.fragment.app.u) this.G.f74p).f828v.f694f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }
}
