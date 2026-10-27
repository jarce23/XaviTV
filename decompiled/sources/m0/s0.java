package m0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s0 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final io.realm.internal.p f8715a;

    /* renamed from: b, reason: collision with root package name */
    public q1 f8716b;

    public s0(View view, io.realm.internal.p pVar) {
        q1 q1Var;
        this.f8715a = pVar;
        WeakHashMap weakHashMap = k0.f8683a;
        q1 a10 = d0.a(view);
        if (a10 != null) {
            int i10 = Build.VERSION.SDK_INT;
            q1Var = (i10 >= 34 ? new d1(a10) : i10 >= 31 ? new c1(a10) : i10 >= 30 ? new b1(a10) : i10 >= 29 ? new a1(a10) : new y0(a10)).b();
        } else {
            q1Var = null;
        }
        this.f8716b = q1Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int[] iArr;
        boolean z10;
        if (!view.isLaidOut()) {
            this.f8716b = q1.g(view, windowInsets);
            return t0.i(view, windowInsets);
        }
        q1 g = q1.g(view, windowInsets);
        n1 n1Var = g.f8706a;
        if (this.f8716b == null) {
            WeakHashMap weakHashMap = k0.f8683a;
            this.f8716b = d0.a(view);
        }
        if (this.f8716b == null) {
            this.f8716b = g;
            return t0.i(view, windowInsets);
        }
        io.realm.internal.p j10 = t0.j(view);
        if (j10 != null && Objects.equals((q1) j10.f6757q, g)) {
            return t0.i(view, windowInsets);
        }
        int[] iArr2 = new int[1];
        int[] iArr3 = new int[1];
        q1 q1Var = this.f8716b;
        int i10 = 1;
        while (i10 <= 512) {
            e0.c f10 = n1Var.f(i10);
            e0.c f11 = q1Var.f8706a.f(i10);
            int i11 = f10.f4385a;
            int i12 = f10.f4388d;
            int i13 = f10.f4387c;
            int i14 = f10.f4386b;
            int i15 = f11.f4385a;
            int i16 = f11.f4388d;
            int i17 = f11.f4387c;
            int i18 = f11.f4386b;
            if (i11 > i15 || i14 > i18 || i13 > i17 || i12 > i16) {
                iArr = iArr2;
                z10 = true;
            } else {
                iArr = iArr2;
                z10 = false;
            }
            if (z10 != (i11 < i15 || i14 < i18 || i13 < i17 || i12 < i16)) {
                if (z10) {
                    iArr[0] = iArr[0] | i10;
                } else {
                    iArr3[0] = iArr3[0] | i10;
                }
            }
            i10 <<= 1;
            iArr2 = iArr;
        }
        int i19 = iArr2[0];
        int i20 = iArr3[0];
        int i21 = i19 | i20;
        if (i21 == 0) {
            this.f8716b = g;
            return t0.i(view, windowInsets);
        }
        q1 q1Var2 = this.f8716b;
        x0 x0Var = new x0(i21, (i19 & 8) != 0 ? t0.f8717e : (i20 & 8) != 0 ? t0.f8718f : (i19 & 519) != 0 ? t0.g : (i20 & 519) != 0 ? t0.f8719h : null, (i21 & 8) != 0 ? 160L : 250L);
        x0Var.f8738a.d(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(x0Var.f8738a.a());
        e0.c f12 = n1Var.f(i21);
        e0.c f13 = q1Var2.f8706a.f(i21);
        int min = Math.min(f12.f4385a, f13.f4385a);
        int i22 = f12.f4386b;
        int i23 = f13.f4386b;
        int min2 = Math.min(i22, i23);
        int i24 = f12.f4387c;
        int i25 = f13.f4387c;
        int min3 = Math.min(i24, i25);
        int i26 = f12.f4388d;
        int i27 = f13.f4388d;
        x4.e eVar = new x4.e(e0.c.b(min, min2, min3, Math.min(i26, i27)), 11, e0.c.b(Math.max(f12.f4385a, f13.f4385a), Math.max(i22, i23), Math.max(i24, i25), Math.max(i26, i27)));
        t0.f(view, g, false);
        duration.addUpdateListener(new r0(x0Var, g, q1Var2, i21, view));
        duration.addListener(new l4.i(x0Var, view, 2));
        o.a(view, new g7.c0(view, x0Var, eVar, duration));
        this.f8716b = g;
        return t0.i(view, windowInsets);
    }
}
