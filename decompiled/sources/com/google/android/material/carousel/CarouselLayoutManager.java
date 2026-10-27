package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.v4.media.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import b4.a0;
import b4.a1;
import b4.b1;
import b4.o0;
import b4.p0;
import b4.u0;
import org.chromium.net.R;
import q8.a;
import q8.b;
import q8.c;
import q8.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CarouselLayoutManager extends o0 implements a1 {

    /* renamed from: p, reason: collision with root package name */
    public final e f3722p;

    /* renamed from: q, reason: collision with root package name */
    public m1.e f3723q;

    /* renamed from: r, reason: collision with root package name */
    public final View.OnLayoutChangeListener f3724r;

    public CarouselLayoutManager() {
        e eVar = new e();
        new b();
        this.f3724r = new a(0, this);
        this.f3722p = eVar;
        C0();
        V0(0);
    }

    @Override // b4.o0
    public final void B(View view, Rect rect) {
        super.B(view, rect);
        rect.centerY();
        if (T0()) {
            rect.centerX();
        }
        throw null;
    }

    @Override // b4.o0
    public final boolean B0(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
        return false;
    }

    @Override // b4.o0
    public final int E0(int i10, u0 u0Var, b1 b1Var) {
        if (!T0() || x() == 0 || i10 == 0) {
            return 0;
        }
        u0Var.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // b4.o0
    public final int G0(int i10, u0 u0Var, b1 b1Var) {
        if (!f() || x() == 0 || i10 == 0) {
            return 0;
        }
        u0Var.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // b4.o0
    public final void P0(RecyclerView recyclerView, int i10) {
        a0 a0Var = new a0(this, recyclerView.getContext(), 1);
        a0Var.f2450a = i10;
        Q0(a0Var);
    }

    @Override // b4.o0
    public final boolean S() {
        return true;
    }

    public final float S0(float f10, float f11) {
        return U0() ? f10 - f11 : f10 + f11;
    }

    public final boolean T0() {
        return this.f3723q.f8759p == 0;
    }

    public final boolean U0() {
        return T0() && I() == 1;
    }

    public final void V0(int i10) {
        c cVar;
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException(d.m(i10, "invalid orientation:"));
        }
        c(null);
        m1.e eVar = this.f3723q;
        if (eVar == null || i10 != eVar.f8759p) {
            if (i10 == 0) {
                cVar = new c(this, 1);
            } else {
                if (i10 != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                cVar = new c(this, 0);
            }
            this.f3723q = cVar;
            C0();
        }
    }

    @Override // b4.o0
    public final void Z(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        e eVar = this.f3722p;
        float f10 = eVar.f10368a;
        if (f10 <= 0.0f) {
            f10 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        eVar.f10368a = f10;
        float f11 = eVar.f10369b;
        if (f11 <= 0.0f) {
            f11 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        eVar.f10369b = f11;
        C0();
        recyclerView.addOnLayoutChangeListener(this.f3724r);
    }

    @Override // b4.a1
    public final PointF a(int i10) {
        return null;
    }

    @Override // b4.o0
    public final void a0(RecyclerView recyclerView) {
        recyclerView.removeOnLayoutChangeListener(this.f3724r);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x003a, code lost:
    
        if (r6 == 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0044, code lost:
    
        if (U0() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0048, code lost:
    
        if (r6 == 1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0051, code lost:
    
        if (U0() != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // b4.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View b0(android.view.View r4, int r5, b4.u0 r6, b4.b1 r7) {
        /*
            r3 = this;
            int r6 = r3.x()
            if (r6 != 0) goto L8
            goto L96
        L8:
            m1.e r6 = r3.f3723q
            int r6 = r6.f8759p
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = -1
            r1 = 1
            if (r5 == r1) goto L46
            r2 = 2
            if (r5 == r2) goto L3c
            r2 = 17
            if (r5 == r2) goto L4b
            r2 = 33
            if (r5 == r2) goto L48
            r2 = 66
            if (r5 == r2) goto L3e
            r2 = 130(0x82, float:1.82E-43)
            if (r5 == r2) goto L3a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown focus request:"
            r6.<init>(r2)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "CarouselLayoutManager"
            android.util.Log.d(r6, r5)
        L38:
            r5 = r7
            goto L54
        L3a:
            if (r6 != r1) goto L38
        L3c:
            r5 = r1
            goto L54
        L3e:
            if (r6 != 0) goto L38
            boolean r5 = r3.U0()
            if (r5 == 0) goto L3c
        L46:
            r5 = r0
            goto L54
        L48:
            if (r6 != r1) goto L38
            goto L46
        L4b:
            if (r6 != 0) goto L38
            boolean r5 = r3.U0()
            if (r5 == 0) goto L46
            goto L3c
        L54:
            if (r5 != r7) goto L57
            goto L96
        L57:
            r6 = 0
            if (r5 != r0) goto L8b
            int r4 = b4.o0.N(r4)
            if (r4 != 0) goto L61
            goto L96
        L61:
            android.view.View r4 = r3.w(r6)
            int r4 = b4.o0.N(r4)
            int r4 = r4 - r1
            if (r4 < 0) goto L7a
            int r5 = r3.H()
            if (r4 < r5) goto L73
            goto L7a
        L73:
            m1.e r4 = r3.f3723q
            r4.h()
            r4 = 0
            throw r4
        L7a:
            boolean r4 = r3.U0()
            if (r4 == 0) goto L86
            int r4 = r3.x()
            int r6 = r4 + (-1)
        L86:
            android.view.View r4 = r3.w(r6)
            return r4
        L8b:
            int r4 = b4.o0.N(r4)
            int r5 = r3.H()
            int r5 = r5 - r1
            if (r4 != r5) goto L98
        L96:
            r4 = 0
            return r4
        L98:
            int r4 = r3.x()
            int r4 = r4 - r1
            android.view.View r4 = r3.w(r4)
            int r4 = b4.o0.N(r4)
            int r4 = r4 + r1
            if (r4 < 0) goto Lb6
            int r5 = r3.H()
            if (r4 < r5) goto Laf
            goto Lb6
        Laf:
            m1.e r4 = r3.f3723q
            r4.h()
            r4 = 0
            throw r4
        Lb6:
            boolean r4 = r3.U0()
            if (r4 == 0) goto Lbd
            goto Lc3
        Lbd:
            int r4 = r3.x()
            int r6 = r4 + (-1)
        Lc3:
            android.view.View r4 = r3.w(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.b0(android.view.View, int, b4.u0, b4.b1):android.view.View");
    }

    @Override // b4.o0
    public final void c0(AccessibilityEvent accessibilityEvent) {
        super.c0(accessibilityEvent);
        if (x() > 0) {
            accessibilityEvent.setFromIndex(o0.N(w(0)));
            accessibilityEvent.setToIndex(o0.N(w(x() - 1)));
        }
    }

    @Override // b4.o0
    public final boolean e() {
        return T0();
    }

    @Override // b4.o0
    public final boolean f() {
        return !T0();
    }

    @Override // b4.o0
    public final void h0(int i10, int i11) {
        H();
    }

    @Override // b4.o0
    public final void i0() {
        H();
    }

    @Override // b4.o0
    public final int k(b1 b1Var) {
        x();
        return 0;
    }

    @Override // b4.o0
    public final void k0(int i10, int i11) {
        H();
    }

    @Override // b4.o0
    public final int l(b1 b1Var) {
        return 0;
    }

    @Override // b4.o0
    public final int m(b1 b1Var) {
        return 0;
    }

    @Override // b4.o0
    public final int n(b1 b1Var) {
        x();
        return 0;
    }

    @Override // b4.o0
    public final void n0(u0 u0Var, b1 b1Var) {
        if (b1Var.b() > 0) {
            if ((T0() ? this.f2369n : this.f2370o) > 0.0f) {
                U0();
                u0Var.d(0);
                throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
            }
        }
        v0(u0Var);
    }

    @Override // b4.o0
    public final int o(b1 b1Var) {
        return 0;
    }

    @Override // b4.o0
    public final void o0(b1 b1Var) {
        if (x() == 0) {
            return;
        }
        o0.N(w(0));
    }

    @Override // b4.o0
    public final int p(b1 b1Var) {
        return 0;
    }

    @Override // b4.o0
    public final p0 t() {
        return new p0(-2, -2);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        new b();
        this.f3724r = new a(0, this);
        this.f3722p = new e();
        C0();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j8.a.f7182b);
            obtainStyledAttributes.getInt(0, 0);
            C0();
            V0(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
        }
    }

    @Override // b4.o0
    public final void F0(int i10) {
    }
}
