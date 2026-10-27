package m0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f1 extends n1 {

    /* renamed from: i, reason: collision with root package name */
    public static boolean f8652i = false;

    /* renamed from: j, reason: collision with root package name */
    public static Method f8653j;

    /* renamed from: k, reason: collision with root package name */
    public static Class f8654k;

    /* renamed from: l, reason: collision with root package name */
    public static Field f8655l;

    /* renamed from: m, reason: collision with root package name */
    public static Field f8656m;

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f8657c;

    /* renamed from: d, reason: collision with root package name */
    public e0.c[] f8658d;

    /* renamed from: e, reason: collision with root package name */
    public e0.c f8659e;

    /* renamed from: f, reason: collision with root package name */
    public q1 f8660f;
    public e0.c g;

    /* renamed from: h, reason: collision with root package name */
    public int f8661h;

    public f1(q1 q1Var, WindowInsets windowInsets) {
        super(q1Var);
        this.f8659e = null;
        this.f8657c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private e0.c s(int i10, boolean z10) {
        e0.c cVar = e0.c.f4384e;
        for (int i11 = 1; i11 <= 512; i11 <<= 1) {
            if ((i10 & i11) != 0) {
                cVar = e0.c.a(cVar, t(i11, z10));
            }
        }
        return cVar;
    }

    private e0.c u() {
        q1 q1Var = this.f8660f;
        return q1Var != null ? q1Var.f8706a.h() : e0.c.f4384e;
    }

    private e0.c v(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!f8652i) {
            w();
        }
        Method method = f8653j;
        if (method != null && f8654k != null && f8655l != null) {
            try {
                Object invoke = method.invoke(view, null);
                if (invoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f8655l.get(f8656m.get(invoke));
                if (rect != null) {
                    return e0.c.b(rect.left, rect.top, rect.right, rect.bottom);
                }
            } catch (ReflectiveOperationException e7) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e7.getMessage(), e7);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void w() {
        try {
            f8653j = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f8654k = cls;
            f8655l = cls.getDeclaredField("mVisibleInsets");
            f8656m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f8655l.setAccessible(true);
            f8656m.setAccessible(true);
        } catch (ReflectiveOperationException e7) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e7.getMessage(), e7);
        }
        f8652i = true;
    }

    public static boolean y(int i10, int i11) {
        return (i10 & 6) == (i11 & 6);
    }

    @Override // m0.n1
    public void d(View view) {
        e0.c v10 = v(view);
        if (v10 == null) {
            v10 = e0.c.f4384e;
        }
        x(v10);
    }

    @Override // m0.n1
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        return Objects.equals(this.g, f1Var.g) && y(this.f8661h, f1Var.f8661h);
    }

    @Override // m0.n1
    public e0.c f(int i10) {
        return s(i10, false);
    }

    @Override // m0.n1
    public final e0.c j() {
        if (this.f8659e == null) {
            WindowInsets windowInsets = this.f8657c;
            this.f8659e = e0.c.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f8659e;
    }

    @Override // m0.n1
    public q1 l(int i10, int i11, int i12, int i13) {
        q1 g = q1.g(null, this.f8657c);
        int i14 = Build.VERSION.SDK_INT;
        e1 d1Var = i14 >= 34 ? new d1(g) : i14 >= 31 ? new c1(g) : i14 >= 30 ? new b1(g) : i14 >= 29 ? new a1(g) : new y0(g);
        d1Var.g(q1.e(j(), i10, i11, i12, i13));
        d1Var.e(q1.e(h(), i10, i11, i12, i13));
        return d1Var.b();
    }

    @Override // m0.n1
    public boolean n() {
        return this.f8657c.isRound();
    }

    @Override // m0.n1
    public void o(e0.c[] cVarArr) {
        this.f8658d = cVarArr;
    }

    @Override // m0.n1
    public void p(q1 q1Var) {
        this.f8660f = q1Var;
    }

    @Override // m0.n1
    public void r(int i10) {
        this.f8661h = i10;
    }

    public e0.c t(int i10, boolean z10) {
        e0.c h10;
        int i11;
        e0.c cVar = e0.c.f4384e;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 8) {
                    e0.c[] cVarArr = this.f8658d;
                    h10 = cVarArr != null ? cVarArr[x4.f.B(8)] : null;
                    if (h10 != null) {
                        return h10;
                    }
                    e0.c j10 = j();
                    e0.c u10 = u();
                    int i12 = j10.f4388d;
                    if (i12 > u10.f4388d) {
                        return e0.c.b(0, 0, 0, i12);
                    }
                    e0.c cVar2 = this.g;
                    if (cVar2 != null && !cVar2.equals(cVar) && (i11 = this.g.f4388d) > u10.f4388d) {
                        return e0.c.b(0, 0, 0, i11);
                    }
                } else {
                    if (i10 == 16) {
                        return i();
                    }
                    if (i10 == 32) {
                        return g();
                    }
                    if (i10 == 64) {
                        return k();
                    }
                    if (i10 == 128) {
                        q1 q1Var = this.f8660f;
                        h e7 = q1Var != null ? q1Var.f8706a.e() : e();
                        if (e7 != null) {
                            int i13 = Build.VERSION.SDK_INT;
                            return e0.c.b(i13 >= 28 ? c0.b.h(e7.f8670a) : 0, i13 >= 28 ? c0.b.j(e7.f8670a) : 0, i13 >= 28 ? c0.b.i(e7.f8670a) : 0, i13 >= 28 ? c0.b.g(e7.f8670a) : 0);
                        }
                    }
                }
            } else {
                if (z10) {
                    e0.c u11 = u();
                    e0.c h11 = h();
                    return e0.c.b(Math.max(u11.f4385a, h11.f4385a), 0, Math.max(u11.f4387c, h11.f4387c), Math.max(u11.f4388d, h11.f4388d));
                }
                if ((this.f8661h & 2) == 0) {
                    e0.c j11 = j();
                    q1 q1Var2 = this.f8660f;
                    h10 = q1Var2 != null ? q1Var2.f8706a.h() : null;
                    int i14 = j11.f4388d;
                    if (h10 != null) {
                        i14 = Math.min(i14, h10.f4388d);
                    }
                    return e0.c.b(j11.f4385a, 0, j11.f4387c, i14);
                }
            }
        } else {
            if (z10) {
                return e0.c.b(0, Math.max(u().f4386b, j().f4386b), 0, 0);
            }
            if ((this.f8661h & 4) == 0) {
                return e0.c.b(0, j().f4386b, 0, 0);
            }
        }
        return cVar;
    }

    public void x(e0.c cVar) {
        this.g = cVar;
    }
}
