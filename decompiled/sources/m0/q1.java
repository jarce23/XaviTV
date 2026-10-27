package m0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q1 {

    /* renamed from: b, reason: collision with root package name */
    public static final q1 f8705b;

    /* renamed from: a, reason: collision with root package name */
    public final n1 f8706a;

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            f8705b = m1.f8692s;
        } else if (i10 >= 30) {
            f8705b = k1.f8689r;
        } else {
            f8705b = n1.f8696b;
        }
    }

    public q1(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            this.f8706a = new m1(this, windowInsets);
            return;
        }
        if (i10 >= 31) {
            this.f8706a = new l1(this, windowInsets);
            return;
        }
        if (i10 >= 30) {
            this.f8706a = new k1(this, windowInsets);
            return;
        }
        if (i10 >= 29) {
            this.f8706a = new j1(this, windowInsets);
        } else if (i10 >= 28) {
            this.f8706a = new i1(this, windowInsets);
        } else {
            this.f8706a = new g1(this, windowInsets);
        }
    }

    public static e0.c e(e0.c cVar, int i10, int i11, int i12, int i13) {
        int max = Math.max(0, cVar.f4385a - i10);
        int max2 = Math.max(0, cVar.f4386b - i11);
        int max3 = Math.max(0, cVar.f4387c - i12);
        int max4 = Math.max(0, cVar.f4388d - i13);
        return (max == i10 && max2 == i11 && max3 == i12 && max4 == i13) ? cVar : e0.c.b(max, max2, max3, max4);
    }

    public static q1 g(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        q1 q1Var = new q1(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = k0.f8683a;
            q1 a10 = d0.a(view);
            n1 n1Var = q1Var.f8706a;
            n1Var.p(a10);
            n1Var.d(view.getRootView());
            n1Var.r(view.getWindowSystemUiVisibility());
        }
        return q1Var;
    }

    public final int a() {
        return this.f8706a.j().f4388d;
    }

    public final int b() {
        return this.f8706a.j().f4385a;
    }

    public final int c() {
        return this.f8706a.j().f4387c;
    }

    public final int d() {
        return this.f8706a.j().f4386b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q1) {
            return Objects.equals(this.f8706a, ((q1) obj).f8706a);
        }
        return false;
    }

    public final WindowInsets f() {
        n1 n1Var = this.f8706a;
        if (n1Var instanceof f1) {
            return ((f1) n1Var).f8657c;
        }
        return null;
    }

    public final int hashCode() {
        n1 n1Var = this.f8706a;
        if (n1Var == null) {
            return 0;
        }
        return n1Var.hashCode();
    }

    public q1() {
        this.f8706a = new n1(this);
    }
}
