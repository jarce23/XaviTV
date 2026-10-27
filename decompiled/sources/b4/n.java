package b4;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends l0 {
    public static final int[] C = {R.attr.state_pressed};
    public static final int[] D = new int[0];
    public int A;
    public final androidx.activity.j B;

    /* renamed from: a, reason: collision with root package name */
    public final int f2321a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2322b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f2323c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f2324d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2325e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2326f;
    public final StateListDrawable g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f2327h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2328i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2329j;

    /* renamed from: k, reason: collision with root package name */
    public int f2330k;

    /* renamed from: l, reason: collision with root package name */
    public int f2331l;

    /* renamed from: m, reason: collision with root package name */
    public float f2332m;

    /* renamed from: n, reason: collision with root package name */
    public int f2333n;

    /* renamed from: o, reason: collision with root package name */
    public int f2334o;

    /* renamed from: p, reason: collision with root package name */
    public float f2335p;

    /* renamed from: s, reason: collision with root package name */
    public final RecyclerView f2338s;

    /* renamed from: z, reason: collision with root package name */
    public final ValueAnimator f2345z;

    /* renamed from: q, reason: collision with root package name */
    public int f2336q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f2337r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2339t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2340u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f2341v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f2342w = 0;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f2343x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    public final int[] f2344y = new int[2];

    /* JADX WARN: Multi-variable type inference failed */
    public n(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2345z = ofFloat;
        this.A = 0;
        androidx.activity.j jVar = new androidx.activity.j(9, this);
        this.B = jVar;
        k kVar = new k(this);
        this.f2323c = stateListDrawable;
        this.f2324d = drawable;
        this.g = stateListDrawable2;
        this.f2327h = drawable2;
        this.f2325e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f2326f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f2328i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f2329j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f2321a = i11;
        this.f2322b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new l(this));
        ofFloat.addUpdateListener(new m(0 == true ? 1 : 0, this));
        RecyclerView recyclerView2 = this.f2338s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.E;
            o0 o0Var = recyclerView2.B;
            if (o0Var != null) {
                o0Var.c("Cannot remove item decoration during a scroll  or layout");
            }
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.P();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f2338s;
            recyclerView3.F.remove(this);
            if (recyclerView3.G == this) {
                recyclerView3.G = null;
            }
            ArrayList arrayList2 = this.f2338s.f1491x0;
            if (arrayList2 != null) {
                arrayList2.remove(kVar);
            }
            this.f2338s.removeCallbacks(jVar);
        }
        this.f2338s = recyclerView;
        recyclerView.g(this);
        this.f2338s.F.add(this);
        this.f2338s.h(kVar);
    }

    public static int e(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 != 0) {
            int i14 = i10 - i12;
            int i15 = (int) (((f11 - f10) / i13) * i14);
            int i16 = i11 + i15;
            if (i16 < i14 && i16 >= 0) {
                return i15;
            }
        }
        return 0;
    }

    @Override // b4.l0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        int i10 = this.f2336q;
        RecyclerView recyclerView2 = this.f2338s;
        if (i10 != recyclerView2.getWidth() || this.f2337r != recyclerView2.getHeight()) {
            this.f2336q = recyclerView2.getWidth();
            this.f2337r = recyclerView2.getHeight();
            f(0);
            return;
        }
        if (this.A != 0) {
            if (this.f2339t) {
                int i11 = this.f2336q;
                int i12 = this.f2325e;
                int i13 = i11 - i12;
                int i14 = this.f2331l;
                int i15 = this.f2330k;
                int i16 = i14 - (i15 / 2);
                StateListDrawable stateListDrawable = this.f2323c;
                stateListDrawable.setBounds(0, 0, i12, i15);
                int i17 = this.f2326f;
                int i18 = this.f2337r;
                Drawable drawable = this.f2324d;
                drawable.setBounds(0, 0, i17, i18);
                WeakHashMap weakHashMap = m0.k0.f8683a;
                if (recyclerView2.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i12, i16);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i12, -i16);
                } else {
                    canvas.translate(i13, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i16);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i13, -i16);
                }
            }
            if (this.f2340u) {
                int i19 = this.f2337r;
                int i20 = this.f2328i;
                int i21 = i19 - i20;
                int i22 = this.f2334o;
                int i23 = this.f2333n;
                int i24 = i22 - (i23 / 2);
                StateListDrawable stateListDrawable2 = this.g;
                stateListDrawable2.setBounds(0, 0, i23, i20);
                int i25 = this.f2336q;
                int i26 = this.f2329j;
                Drawable drawable2 = this.f2327h;
                drawable2.setBounds(0, 0, i25, i26);
                canvas.translate(0.0f, i21);
                drawable2.draw(canvas);
                canvas.translate(i24, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i24, -i21);
            }
        }
    }

    public final boolean c(float f10, float f11) {
        if (f11 < this.f2337r - this.f2328i) {
            return false;
        }
        int i10 = this.f2334o;
        int i11 = this.f2333n;
        return f10 >= ((float) (i10 - (i11 / 2))) && f10 <= ((float) ((i11 / 2) + i10));
    }

    public final boolean d(float f10, float f11) {
        WeakHashMap weakHashMap = m0.k0.f8683a;
        int layoutDirection = this.f2338s.getLayoutDirection();
        int i10 = this.f2325e;
        if (layoutDirection == 1) {
            if (f10 > i10) {
                return false;
            }
        } else if (f10 < this.f2336q - i10) {
            return false;
        }
        int i11 = this.f2331l;
        int i12 = this.f2330k / 2;
        return f11 >= ((float) (i11 - i12)) && f11 <= ((float) (i12 + i11));
    }

    public final void f(int i10) {
        androidx.activity.j jVar = this.B;
        StateListDrawable stateListDrawable = this.f2323c;
        if (i10 == 2 && this.f2341v != 2) {
            stateListDrawable.setState(C);
            this.f2338s.removeCallbacks(jVar);
        }
        if (i10 == 0) {
            this.f2338s.invalidate();
        } else {
            g();
        }
        if (this.f2341v == 2 && i10 != 2) {
            stateListDrawable.setState(D);
            this.f2338s.removeCallbacks(jVar);
            this.f2338s.postDelayed(jVar, 1200);
        } else if (i10 == 1) {
            this.f2338s.removeCallbacks(jVar);
            this.f2338s.postDelayed(jVar, 1500);
        }
        this.f2341v = i10;
    }

    public final void g() {
        int i10 = this.A;
        ValueAnimator valueAnimator = this.f2345z;
        if (i10 != 0) {
            if (i10 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
