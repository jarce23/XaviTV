package f;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import m.e1;
import m.f1;
import m.h3;
import m.u2;
import m.z2;
import m0.p0;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 extends q implements l.j, LayoutInflater.Factory2 {

    /* renamed from: w0, reason: collision with root package name */
    public static final p.i f4717w0 = new p.i(0);

    /* renamed from: x0, reason: collision with root package name */
    public static final int[] f4718x0 = {R.attr.windowBackground};

    /* renamed from: y0, reason: collision with root package name */
    public static final boolean f4719y0 = !"robolectric".equals(Build.FINGERPRINT);
    public x A;
    public final Object B;
    public m0 C;
    public k.h D;
    public CharSequence E;
    public e1 F;
    public s G;
    public s H;
    public k.a I;
    public ActionBarContextView J;
    public PopupWindow K;
    public r L;
    public boolean O;
    public ViewGroup P;
    public TextView Q;
    public View R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public a0[] f4720a0;

    /* renamed from: b0, reason: collision with root package name */
    public a0 f4721b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f4722c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f4723d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f4724e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f4725f0;

    /* renamed from: g0, reason: collision with root package name */
    public Configuration f4726g0;
    public final int h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f4727i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f4728j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f4729k0;

    /* renamed from: l0, reason: collision with root package name */
    public y f4730l0;

    /* renamed from: m0, reason: collision with root package name */
    public y f4731m0;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f4732n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f4733o0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f4735q0;

    /* renamed from: r0, reason: collision with root package name */
    public Rect f4736r0;

    /* renamed from: s0, reason: collision with root package name */
    public Rect f4737s0;

    /* renamed from: t0, reason: collision with root package name */
    public f0 f4738t0;

    /* renamed from: u0, reason: collision with root package name */
    public OnBackInvokedDispatcher f4739u0;

    /* renamed from: v0, reason: collision with root package name */
    public OnBackInvokedCallback f4740v0;

    /* renamed from: x, reason: collision with root package name */
    public final Object f4741x;

    /* renamed from: y, reason: collision with root package name */
    public final Context f4742y;

    /* renamed from: z, reason: collision with root package name */
    public Window f4743z;
    public p0 M = null;
    public final boolean N = true;

    /* renamed from: p0, reason: collision with root package name */
    public final r f4734p0 = new r(this, 0);

    public b0(Context context, Window window, k kVar, Object obj) {
        j jVar = null;
        this.h0 = -100;
        this.f4742y = context;
        this.B = kVar;
        this.f4741x = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof j)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        jVar = (j) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (jVar != null) {
                this.h0 = ((b0) jVar.m()).h0;
            }
        }
        if (this.h0 == -100) {
            String name = this.f4741x.getClass().getName();
            p.i iVar = f4717w0;
            Integer num = (Integer) iVar.get(name);
            if (num != null) {
                this.h0 = num.intValue();
                iVar.remove(this.f4741x.getClass().getName());
            }
        }
        if (window != null) {
            m(window);
        }
        m.r.d();
    }

    public static i0.f n(Context context) {
        i0.f fVar;
        i0.f b2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33 || (fVar = q.f4838q) == null) {
            return null;
        }
        i0.h hVar = fVar.f5785a;
        i0.f y8 = y(context.getApplicationContext().getResources().getConfiguration());
        int i11 = 0;
        if (i10 < 24) {
            b2 = hVar.isEmpty() ? i0.f.f5784b : i0.f.b(u.b(hVar.get(0)));
        } else if (hVar.isEmpty()) {
            b2 = i0.f.f5784b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (i11 < y8.f5785a.size() + hVar.size()) {
                Locale locale = i11 < hVar.size() ? hVar.get(i11) : y8.f5785a.get(i11 - hVar.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i11++;
            }
            b2 = i0.f.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
        }
        return b2.f5785a.isEmpty() ? y8 : b2;
    }

    public static Configuration s(Context context, int i10, i0.f fVar, Configuration configuration, boolean z10) {
        int i11 = i10 != 1 ? i10 != 2 ? z10 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        if (fVar != null) {
            i0.h hVar = fVar.f5785a;
            if (Build.VERSION.SDK_INT >= 24) {
                v.d(configuration2, fVar);
                return configuration2;
            }
            configuration2.setLocale(hVar.get(0));
            configuration2.setLayoutDirection(hVar.get(0));
        }
        return configuration2;
    }

    public static i0.f y(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? v.b(configuration) : i0.f.b(u.b(configuration.locale));
    }

    public final void A() {
        v();
        if (this.U && this.C == null) {
            Object obj = this.f4741x;
            if (obj instanceof Activity) {
                this.C = new m0((Activity) obj, this.V);
            } else if (obj instanceof Dialog) {
                this.C = new m0((Dialog) obj);
            }
            m0 m0Var = this.C;
            if (m0Var != null) {
                m0Var.E(this.f4735q0);
            }
        }
    }

    public final void B(int i10) {
        this.f4733o0 = (1 << i10) | this.f4733o0;
        if (this.f4732n0) {
            return;
        }
        View decorView = this.f4743z.getDecorView();
        WeakHashMap weakHashMap = m0.k0.f8683a;
        decorView.postOnAnimation(this.f4734p0);
        this.f4732n0 = true;
    }

    public final int C(Context context, int i10) {
        if (i10 != -100) {
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 != 1 && i10 != 2) {
                        if (i10 != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.f4731m0 == null) {
                            this.f4731m0 = new y(this, context);
                        }
                        return this.f4731m0.f();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return x(context).f();
                }
            }
            return i10;
        }
        return -1;
    }

    public final boolean D() {
        f1 f1Var;
        u2 u2Var;
        boolean z10 = this.f4722c0;
        this.f4722c0 = false;
        a0 z11 = z(0);
        if (!z11.f4697m) {
            k.a aVar = this.I;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            A();
            m0 m0Var = this.C;
            if (m0Var == null || (f1Var = m0Var.g) == null || (u2Var = ((z2) f1Var).f8621a.f470c0) == null || u2Var.f8574p == null) {
                return false;
            }
            u2 u2Var2 = ((z2) f1Var).f8621a.f470c0;
            l.n nVar = u2Var2 == null ? null : u2Var2.f8574p;
            if (nVar != null) {
                nVar.collapseActionView();
            }
        } else if (!z10) {
            q(z11, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0176, code lost:
    
        if (r2.f7980t.getCount() > 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0156, code lost:
    
        if (r2 != null) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(f.a0 r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b0.E(f.a0, android.view.KeyEvent):void");
    }

    public final boolean F(a0 a0Var, int i10, KeyEvent keyEvent) {
        l.l lVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((a0Var.f4695k || G(a0Var, keyEvent)) && (lVar = a0Var.f4692h) != null) {
            return lVar.performShortcut(i10, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cd, code lost:
    
        if (r13.f4692h == null) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean G(f.a0 r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b0.G(f.a0, android.view.KeyEvent):boolean");
    }

    public final void H() {
        if (this.O) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void I() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z10 = false;
            if (this.f4739u0 != null && (z(0).f4697m || this.I != null)) {
                z10 = true;
            }
            if (z10 && this.f4740v0 == null) {
                this.f4740v0 = w.b(this.f4739u0, this);
            } else {
                if (z10 || (onBackInvokedCallback = this.f4740v0) == null) {
                    return;
                }
                w.c(this.f4739u0, onBackInvokedCallback);
                this.f4740v0 = null;
            }
        }
    }

    @Override // f.q
    public final void a() {
        LayoutInflater from = LayoutInflater.from(this.f4742y);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else {
            if (from.getFactory2() instanceof b0) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // f.q
    public final void c() {
        String str;
        this.f4723d0 = true;
        l(false, true);
        w();
        Object obj = this.f4741x;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = b0.c.c(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e7) {
                    throw new IllegalArgumentException(e7);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                m0 m0Var = this.C;
                if (m0Var == null) {
                    this.f4735q0 = true;
                } else {
                    m0Var.E(true);
                }
            }
            synchronized (q.f4843v) {
                q.e(this);
                q.f4842u.add(new WeakReference(this));
            }
        }
        this.f4726g0 = new Configuration(this.f4742y.getResources().getConfiguration());
        this.f4724e0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // f.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f4741x
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = f.q.f4843v
            monitor-enter(r0)
            f.q.e(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f4732n0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f4743z
            android.view.View r0 = r0.getDecorView()
            f.r r1 = r3.f4734p0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.f4725f0 = r0
            int r0 = r3.h0
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f4741x
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            p.i r0 = f.b0.f4717w0
            java.lang.Object r1 = r3.f4741x
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.h0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            p.i r0 = f.b0.f4717w0
            java.lang.Object r1 = r3.f4741x
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            f.y r0 = r3.f4730l0
            if (r0 == 0) goto L63
            r0.c()
        L63:
            f.y r0 = r3.f4731m0
            if (r0 == 0) goto L6a
            r0.c()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b0.d():void");
    }

    @Override // f.q
    public final boolean f(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i10 = 108;
        } else if (i10 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i10 = 109;
        }
        if (this.Y && i10 == 108) {
            return false;
        }
        if (this.U && i10 == 1) {
            this.U = false;
        }
        if (i10 == 1) {
            H();
            this.Y = true;
            return true;
        }
        if (i10 == 2) {
            H();
            this.S = true;
            return true;
        }
        if (i10 == 5) {
            H();
            this.T = true;
            return true;
        }
        if (i10 == 10) {
            H();
            this.W = true;
            return true;
        }
        if (i10 == 108) {
            H();
            this.U = true;
            return true;
        }
        if (i10 != 109) {
            return this.f4743z.requestFeature(i10);
        }
        H();
        this.V = true;
        return true;
    }

    @Override // f.q
    public final void g(int i10) {
        v();
        ViewGroup viewGroup = (ViewGroup) this.P.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f4742y).inflate(i10, viewGroup);
        this.A.a(this.f4743z.getCallback());
    }

    @Override // l.j
    public final boolean h(l.l lVar, MenuItem menuItem) {
        a0 a0Var;
        Window.Callback callback = this.f4743z.getCallback();
        if (callback != null && !this.f4725f0) {
            l.l k10 = lVar.k();
            a0[] a0VarArr = this.f4720a0;
            int length = a0VarArr != null ? a0VarArr.length : 0;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    a0Var = a0VarArr[i10];
                    if (a0Var != null && a0Var.f4692h == k10) {
                        break;
                    }
                    i10++;
                } else {
                    a0Var = null;
                    break;
                }
            }
            if (a0Var != null) {
                return callback.onMenuItemSelected(a0Var.f4686a, menuItem);
            }
        }
        return false;
    }

    @Override // f.q
    public final void i(View view) {
        v();
        ViewGroup viewGroup = (ViewGroup) this.P.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.A.a(this.f4743z.getCallback());
    }

    @Override // f.q
    public final void j(View view, ViewGroup.LayoutParams layoutParams) {
        v();
        ViewGroup viewGroup = (ViewGroup) this.P.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.A.a(this.f4743z.getCallback());
    }

    @Override // f.q
    public final void k(CharSequence charSequence) {
        this.E = charSequence;
        e1 e1Var = this.F;
        if (e1Var != null) {
            e1Var.setWindowTitle(charSequence);
            return;
        }
        m0 m0Var = this.C;
        if (m0Var == null) {
            TextView textView = this.Q;
            if (textView != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        z2 z2Var = (z2) m0Var.g;
        if (z2Var.g) {
            return;
        }
        Toolbar toolbar = z2Var.f8621a;
        z2Var.f8627h = charSequence;
        if ((z2Var.f8622b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (z2Var.g) {
                m0.k0.n(toolbar.getRootView(), charSequence);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(boolean r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b0.l(boolean, boolean):boolean");
    }

    public final void m(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.f4743z != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof x) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        x xVar = new x(this, callback);
        this.A = xVar;
        window.setCallback(xVar);
        Context context = this.f4742y;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f4718x0);
        if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawable = null;
        } else {
            m.r a10 = m.r.a();
            synchronized (a10) {
                drawable = a10.f8529a.g(context, resourceId, true);
            }
        }
        if (drawable != null) {
            window.setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        this.f4743z = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.f4739u0) != null) {
            return;
        }
        Object obj = this.f4741x;
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f4740v0) != null) {
            w.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f4740v0 = null;
        }
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.f4739u0 = w.a(activity);
                I();
            }
        }
        this.f4739u0 = null;
        I();
    }

    public final void o(int i10, a0 a0Var, l.l lVar) {
        if (lVar == null) {
            if (a0Var == null && i10 >= 0) {
                a0[] a0VarArr = this.f4720a0;
                if (i10 < a0VarArr.length) {
                    a0Var = a0VarArr[i10];
                }
            }
            if (a0Var != null) {
                lVar = a0Var.f4692h;
            }
        }
        if ((a0Var == null || a0Var.f4697m) && !this.f4725f0) {
            x xVar = this.A;
            Window.Callback callback = this.f4743z.getCallback();
            xVar.getClass();
            try {
                xVar.f4854r = true;
                callback.onPanelClosed(i10, lVar);
            } finally {
                xVar.f4854r = false;
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:68:0x01e3
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.LayoutInflater.Factory2
    public final android.view.View onCreateView(android.view.View r9, java.lang.String r10, android.content.Context r11, android.util.AttributeSet r12) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void p(l.l lVar) {
        m.k kVar;
        if (this.Z) {
            return;
        }
        this.Z = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.F;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((z2) actionBarOverlayLayout.f414s).f8621a.f475o;
        if (actionMenuView != null && (kVar = actionMenuView.H) != null) {
            kVar.c();
            m.g gVar = kVar.H;
            if (gVar != null && gVar.b()) {
                gVar.f8057i.dismiss();
            }
        }
        Window.Callback callback = this.f4743z.getCallback();
        if (callback != null && !this.f4725f0) {
            callback.onPanelClosed(108, lVar);
        }
        this.Z = false;
    }

    public final void q(a0 a0Var, boolean z10) {
        z zVar;
        e1 e1Var;
        m.k kVar;
        if (z10 && a0Var.f4686a == 0 && (e1Var = this.F) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) e1Var;
            actionBarOverlayLayout.k();
            ActionMenuView actionMenuView = ((z2) actionBarOverlayLayout.f414s).f8621a.f475o;
            if (actionMenuView != null && (kVar = actionMenuView.H) != null && kVar.f()) {
                p(a0Var.f4692h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f4742y.getSystemService("window");
        if (windowManager != null && a0Var.f4697m && (zVar = a0Var.f4690e) != null) {
            windowManager.removeView(zVar);
            if (z10) {
                o(a0Var.f4686a, a0Var, null);
            }
        }
        a0Var.f4695k = false;
        a0Var.f4696l = false;
        a0Var.f4697m = false;
        a0Var.f4691f = null;
        a0Var.f4698n = true;
        if (this.f4721b0 == a0Var) {
            this.f4721b0 = null;
        }
        if (a0Var.f4686a == 0) {
            I();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r6.f() != false) goto L20;
     */
    @Override // l.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(l.l r6) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b0.r(l.l):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r4.dispatchKeyEvent(r7) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00dc, code lost:
    
        if (r7.c() != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0102, code lost:
    
        if (r7.l() != false) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b0.t(android.view.KeyEvent):boolean");
    }

    public final void u(int i10) {
        a0 z10 = z(i10);
        if (z10.f4692h != null) {
            Bundle bundle = new Bundle();
            z10.f4692h.t(bundle);
            if (bundle.size() > 0) {
                z10.f4700p = bundle;
            }
            z10.f4692h.w();
            z10.f4692h.clear();
        }
        z10.f4699o = true;
        z10.f4698n = true;
        if ((i10 == 108 || i10 == 0) && this.F != null) {
            a0 z11 = z(0);
            z11.f4695k = false;
            G(z11, null);
        }
    }

    public final void v() {
        ViewGroup viewGroup;
        if (this.O) {
            return;
        }
        Context context = this.f4742y;
        int[] iArr = e.a.f4366j;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!obtainStyledAttributes.hasValue(117)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        int i10 = 0;
        int i11 = 1;
        if (obtainStyledAttributes.getBoolean(WebSocketProtocol.PAYLOAD_SHORT, false)) {
            f(1);
        } else if (obtainStyledAttributes.getBoolean(117, false)) {
            f(108);
        }
        if (obtainStyledAttributes.getBoolean(118, false)) {
            f(109);
        }
        if (obtainStyledAttributes.getBoolean(119, false)) {
            f(10);
        }
        this.X = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        w();
        this.f4743z.getDecorView();
        LayoutInflater from = LayoutInflater.from(context);
        if (this.Y) {
            viewGroup = this.W ? (ViewGroup) from.inflate(org.chromium.net.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(org.chromium.net.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.X) {
            viewGroup = (ViewGroup) from.inflate(org.chromium.net.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.V = false;
            this.U = false;
        } else if (this.U) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(org.chromium.net.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new k.c(context, typedValue.resourceId) : context).inflate(org.chromium.net.R.layout.abc_screen_toolbar, (ViewGroup) null);
            e1 e1Var = (e1) viewGroup.findViewById(org.chromium.net.R.id.decor_content_parent);
            this.F = e1Var;
            e1Var.setWindowCallback(this.f4743z.getCallback());
            if (this.V) {
                ((ActionBarOverlayLayout) this.F).j(109);
            }
            if (this.S) {
                ((ActionBarOverlayLayout) this.F).j(2);
            }
            if (this.T) {
                ((ActionBarOverlayLayout) this.F).j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.U + ", windowActionBarOverlay: " + this.V + ", android:windowIsFloating: " + this.X + ", windowActionModeOverlay: " + this.W + ", windowNoTitle: " + this.Y + " }");
        }
        s sVar = new s(this, i10);
        WeakHashMap weakHashMap = m0.k0.f8683a;
        m0.c0.j(viewGroup, sVar);
        if (this.F == null) {
            this.Q = (TextView) viewGroup.findViewById(org.chromium.net.R.id.title);
        }
        boolean z10 = h3.f8433a;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e7) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e7);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e8) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e8);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(org.chromium.net.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f4743z.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f4743z.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new s(this, i11));
        this.P = viewGroup;
        Object obj = this.f4741x;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.E;
        if (!TextUtils.isEmpty(title)) {
            e1 e1Var2 = this.F;
            if (e1Var2 != null) {
                e1Var2.setWindowTitle(title);
            } else {
                m0 m0Var = this.C;
                if (m0Var != null) {
                    z2 z2Var = (z2) m0Var.g;
                    if (!z2Var.g) {
                        Toolbar toolbar = z2Var.f8621a;
                        z2Var.f8627h = title;
                        if ((z2Var.f8622b & 8) != 0) {
                            toolbar.setTitle(title);
                            if (z2Var.g) {
                                m0.k0.n(toolbar.getRootView(), title);
                            }
                        }
                    }
                } else {
                    TextView textView = this.Q;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.P.findViewById(R.id.content);
        View decorView = this.f4743z.getDecorView();
        contentFrameLayout2.f442u.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (obtainStyledAttributes2.hasValue(122)) {
            obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (obtainStyledAttributes2.hasValue(123)) {
            obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (obtainStyledAttributes2.hasValue(120)) {
            obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (obtainStyledAttributes2.hasValue(121)) {
            obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        obtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.O = true;
        a0 z11 = z(0);
        if (this.f4725f0 || z11.f4692h != null) {
            return;
        }
        B(108);
    }

    public final void w() {
        if (this.f4743z == null) {
            Object obj = this.f4741x;
            if (obj instanceof Activity) {
                m(((Activity) obj).getWindow());
            }
        }
        if (this.f4743z == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final androidx.fragment.app.g x(Context context) {
        if (this.f4730l0 == null) {
            if (android.support.v4.media.session.a0.f228t == null) {
                Context applicationContext = context.getApplicationContext();
                android.support.v4.media.session.a0.f228t = new android.support.v4.media.session.a0(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f4730l0 = new y(this, android.support.v4.media.session.a0.f228t);
        }
        return this.f4730l0;
    }

    public final a0 z(int i10) {
        a0[] a0VarArr = this.f4720a0;
        if (a0VarArr == null || a0VarArr.length <= i10) {
            a0[] a0VarArr2 = new a0[i10 + 1];
            if (a0VarArr != null) {
                System.arraycopy(a0VarArr, 0, a0VarArr2, 0, a0VarArr.length);
            }
            this.f4720a0 = a0VarArr2;
            a0VarArr = a0VarArr2;
        }
        a0 a0Var = a0VarArr[i10];
        if (a0Var != null) {
            return a0Var;
        }
        a0 a0Var2 = new a0();
        a0Var2.f4686a = i10;
        a0Var2.f4698n = false;
        a0VarArr[i10] = a0Var2;
        return a0Var2;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
