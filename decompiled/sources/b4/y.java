package b4;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public int f2450a = -1;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f2451b;

    /* renamed from: c, reason: collision with root package name */
    public o0 f2452c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2453d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2454e;

    /* renamed from: f, reason: collision with root package name */
    public View f2455f;
    public final z0 g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2456h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f2457i;

    /* renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f2458j;

    /* renamed from: k, reason: collision with root package name */
    public PointF f2459k;

    /* renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f2460l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2461m;

    /* renamed from: n, reason: collision with root package name */
    public float f2462n;

    /* renamed from: o, reason: collision with root package name */
    public int f2463o;

    /* renamed from: p, reason: collision with root package name */
    public int f2464p;

    public y(Context context) {
        z0 z0Var = new z0();
        z0Var.f2470d = -1;
        z0Var.f2472f = false;
        z0Var.g = 0;
        z0Var.f2467a = 0;
        z0Var.f2468b = 0;
        z0Var.f2469c = Integer.MIN_VALUE;
        z0Var.f2471e = null;
        this.g = z0Var;
        this.f2457i = new LinearInterpolator();
        this.f2458j = new DecelerateInterpolator();
        this.f2461m = false;
        this.f2463o = 0;
        this.f2464p = 0;
        this.f2460l = context.getResources().getDisplayMetrics();
    }

    public static int a(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == -1) {
            return i12 - i10;
        }
        if (i14 != 0) {
            if (i14 == 1) {
                return i13 - i11;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i15 = i12 - i10;
        if (i15 > 0) {
            return i15;
        }
        int i16 = i13 - i11;
        if (i16 < 0) {
            return i16;
        }
        return 0;
    }

    public int b(View view, int i10) {
        o0 o0Var = this.f2452c;
        if (o0Var == null || !o0Var.e()) {
            return 0;
        }
        p0 p0Var = (p0) view.getLayoutParams();
        return a(o0Var.C(view) - ((ViewGroup.MarginLayoutParams) p0Var).leftMargin, o0Var.F(view) + ((ViewGroup.MarginLayoutParams) p0Var).rightMargin, o0Var.K(), o0Var.f2369n - o0Var.L(), i10);
    }

    public int c(View view, int i10) {
        o0 o0Var = this.f2452c;
        if (o0Var == null || !o0Var.f()) {
            return 0;
        }
        p0 p0Var = (p0) view.getLayoutParams();
        return a(o0Var.G(view) - ((ViewGroup.MarginLayoutParams) p0Var).topMargin, o0Var.A(view) + ((ViewGroup.MarginLayoutParams) p0Var).bottomMargin, o0Var.M(), o0Var.f2370o - o0Var.J(), i10);
    }

    public float d(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int e(int i10) {
        float abs = Math.abs(i10);
        if (!this.f2461m) {
            this.f2462n = d(this.f2460l);
            this.f2461m = true;
        }
        return (int) Math.ceil(abs * this.f2462n);
    }

    public PointF f(int i10) {
        Object obj = this.f2452c;
        if (obj instanceof a1) {
            return ((a1) obj).a(i10);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + a1.class.getCanonicalName());
        return null;
    }

    public final void g(int i10, int i11) {
        PointF f10;
        RecyclerView recyclerView = this.f2451b;
        if (this.f2450a == -1 || recyclerView == null) {
            j();
        }
        if (this.f2453d && this.f2455f == null && this.f2452c != null && (f10 = f(this.f2450a)) != null) {
            float f11 = f10.x;
            if (f11 != 0.0f || f10.y != 0.0f) {
                recyclerView.d0((int) Math.signum(f11), (int) Math.signum(f10.y), null);
            }
        }
        this.f2453d = false;
        View view = this.f2455f;
        z0 z0Var = this.g;
        if (view != null) {
            this.f2451b.getClass();
            f1 J = RecyclerView.J(view);
            if ((J != null ? J.c() : -1) == this.f2450a) {
                View view2 = this.f2455f;
                b1 b1Var = recyclerView.f1487v0;
                i(view2, z0Var);
                z0Var.a(recyclerView);
                j();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f2455f = null;
            }
        }
        if (this.f2454e) {
            b1 b1Var2 = recyclerView.f1487v0;
            if (this.f2451b.B.x() == 0) {
                j();
            } else {
                int i12 = this.f2463o;
                int i13 = i12 - i10;
                if (i12 * i13 <= 0) {
                    i13 = 0;
                }
                this.f2463o = i13;
                int i14 = this.f2464p;
                int i15 = i14 - i11;
                if (i14 * i15 <= 0) {
                    i15 = 0;
                }
                this.f2464p = i15;
                if (i13 == 0 && i15 == 0) {
                    k(z0Var);
                }
            }
            boolean z10 = z0Var.f2470d >= 0;
            z0Var.a(recyclerView);
            if (z10 && this.f2454e) {
                this.f2453d = true;
                recyclerView.f1481s0.b();
            }
        }
    }

    public void h() {
        this.f2464p = 0;
        this.f2463o = 0;
        this.f2459k = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(android.view.View r7, b4.z0 r8) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r6.f2459k
            r1 = 0
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L15
            float r0 = r0.x
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto Lf
            goto L15
        Lf:
            if (r0 <= 0) goto L13
            r0 = r3
            goto L16
        L13:
            r0 = r2
            goto L16
        L15:
            r0 = r1
        L16:
            int r0 = r6.b(r7, r0)
            android.graphics.PointF r5 = r6.f2459k
            if (r5 == 0) goto L2a
            float r5 = r5.y
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 != 0) goto L25
            goto L2a
        L25:
            if (r4 <= 0) goto L29
            r1 = r3
            goto L2a
        L29:
            r1 = r2
        L2a:
            int r7 = r6.c(r7, r1)
            int r1 = r0 * r0
            int r2 = r7 * r7
            int r2 = r2 + r1
            double r1 = (double) r2
            double r1 = java.lang.Math.sqrt(r1)
            int r1 = (int) r1
            int r1 = r6.e(r1)
            double r1 = (double) r1
            r4 = 4599717252057688074(0x3fd57a786c22680a, double:0.3356)
            double r1 = r1 / r4
            double r1 = java.lang.Math.ceil(r1)
            int r1 = (int) r1
            if (r1 <= 0) goto L59
            int r0 = -r0
            int r7 = -r7
            r8.f2467a = r0
            r8.f2468b = r7
            r8.f2469c = r1
            android.view.animation.DecelerateInterpolator r7 = r6.f2458j
            r8.f2471e = r7
            r8.f2472f = r3
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.y.i(android.view.View, b4.z0):void");
    }

    public final void j() {
        if (this.f2454e) {
            this.f2454e = false;
            h();
            this.f2451b.f1487v0.f2185a = -1;
            this.f2455f = null;
            this.f2450a = -1;
            this.f2453d = false;
            o0 o0Var = this.f2452c;
            if (o0Var.f2361e == this) {
                o0Var.f2361e = null;
            }
            this.f2452c = null;
            this.f2451b = null;
        }
    }

    public void k(z0 z0Var) {
        PointF f10 = f(this.f2450a);
        if (f10 != null) {
            if (f10.x != 0.0f || f10.y != 0.0f) {
                float f11 = f10.y;
                float sqrt = (float) Math.sqrt((f11 * f11) + (r1 * r1));
                float f12 = f10.x / sqrt;
                f10.x = f12;
                float f13 = f10.y / sqrt;
                f10.y = f13;
                this.f2459k = f10;
                this.f2463o = (int) (f12 * 10000.0f);
                this.f2464p = (int) (f13 * 10000.0f);
                int e7 = e(10000);
                z0Var.f2467a = (int) (this.f2463o * 1.2f);
                z0Var.f2468b = (int) (this.f2464p * 1.2f);
                z0Var.f2469c = (int) (e7 * 1.2f);
                z0Var.f2471e = this.f2457i;
                z0Var.f2472f = true;
                return;
            }
        }
        z0Var.f2470d = this.f2450a;
        j();
    }
}
