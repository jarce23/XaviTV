package androidx.mediarouter.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MediaRouteButton extends View {
    public static final SparseArray D = new SparseArray(2);
    public static final int[] E = {R.attr.state_checked};
    public static final int[] F = {R.attr.state_checkable};
    public final int A;
    public final int B;
    public boolean C;

    /* renamed from: o, reason: collision with root package name */
    public final w3.b0 f1238o;

    /* renamed from: p, reason: collision with root package name */
    public final f0 f1239p;

    /* renamed from: q, reason: collision with root package name */
    public w3.o f1240q;

    /* renamed from: r, reason: collision with root package name */
    public u f1241r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1242s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1243t;

    /* renamed from: u, reason: collision with root package name */
    public a f1244u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f1245v;

    /* renamed from: w, reason: collision with root package name */
    public int f1246w;

    /* renamed from: x, reason: collision with root package name */
    public int f1247x;

    /* renamed from: y, reason: collision with root package name */
    public int f1248y;

    /* renamed from: z, reason: collision with root package name */
    public final ColorStateList f1249z;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MediaRouteButton(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = i7.e.m(r8)
            r0.<init>(r8, r1)
            r8 = 2130969659(0x7f04043b, float:1.7548006E38)
            int r8 = i7.e.o(r0, r8)
            if (r8 == 0) goto L18
            android.view.ContextThemeWrapper r1 = new android.view.ContextThemeWrapper
            r1.<init>(r0, r8)
            r0 = r1
        L18:
            r6 = 2130969647(0x7f04042f, float:1.7547982E38)
            r7.<init>(r0, r9, r6)
            w3.o r8 = w3.o.f12981c
            r7.f1240q = r8
            androidx.mediarouter.app.u r8 = androidx.mediarouter.app.u.f1419a
            r7.f1241r = r8
            android.content.Context r2 = r7.getContext()
            int[] r3 = v3.a.f12662a
            r8 = 0
            android.content.res.TypedArray r5 = r2.obtainStyledAttributes(r9, r3, r6, r8)
            r1 = r7
            r4 = r9
            m0.k0.l(r1, r2, r3, r4, r5, r6)
            boolean r9 = r7.isInEditMode()
            r0 = 3
            if (r9 == 0) goto L4d
            r9 = 0
            r1.f1238o = r9
            r1.f1239p = r9
            int r8 = r5.getResourceId(r0, r8)
            android.graphics.drawable.Drawable r8 = n4.a.o(r2, r8)
            r1.f1245v = r8
            return
        L4d:
            w3.b0 r9 = w3.b0.d(r2)
            r1.f1238o = r9
            androidx.mediarouter.app.f0 r9 = new androidx.mediarouter.app.f0
            r2 = 1
            r9.<init>(r7, r2)
            r1.f1239p = r9
            w3.z r9 = w3.b0.g()
            boolean r2 = r9.d()
            if (r2 != 0) goto L68
            int r9 = r9.f13075h
            goto L69
        L68:
            r9 = r8
        L69:
            r1.f1248y = r9
            r1.f1247x = r9
            r9 = 4
            android.content.res.ColorStateList r9 = r5.getColorStateList(r9)
            r1.f1249z = r9
            int r9 = r5.getDimensionPixelSize(r8, r8)
            r1.A = r9
            r9 = 1
            int r2 = r5.getDimensionPixelSize(r9, r8)
            r1.B = r2
            int r0 = r5.getResourceId(r0, r8)
            r2 = 2
            int r2 = r5.getResourceId(r2, r8)
            r1.f1246w = r2
            r5.recycle()
            int r2 = r1.f1246w
            android.util.SparseArray r3 = androidx.mediarouter.app.MediaRouteButton.D
            if (r2 == 0) goto La4
            java.lang.Object r2 = r3.get(r2)
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2
            if (r2 == 0) goto La4
            android.graphics.drawable.Drawable r2 = r2.newDrawable()
            r7.setRemoteIndicatorDrawable(r2)
        La4:
            android.graphics.drawable.Drawable r2 = r1.f1245v
            if (r2 != 0) goto Ld0
            if (r0 == 0) goto Lcd
            java.lang.Object r2 = r3.get(r0)
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2
            if (r2 == 0) goto Lba
            android.graphics.drawable.Drawable r8 = r2.newDrawable()
            r7.setRemoteIndicatorDrawableInternal(r8)
            goto Ld0
        Lba:
            androidx.mediarouter.app.a r2 = new androidx.mediarouter.app.a
            android.content.Context r3 = r7.getContext()
            r2.<init>(r7, r0, r3)
            r1.f1244u = r2
            java.util.concurrent.Executor r0 = android.os.AsyncTask.SERIAL_EXECUTOR
            java.lang.Void[] r8 = new java.lang.Void[r8]
            r2.executeOnExecutor(r0, r8)
            goto Ld0
        Lcd:
            r7.a()
        Ld0:
            r7.d()
            r7.setClickable(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteButton.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private androidx.fragment.app.i0 getFragmentManager() {
        Activity activity = getActivity();
        if (activity instanceof f.j) {
            return ((f.j) activity).n();
        }
        return null;
    }

    public final void a() {
        if (this.f1246w > 0) {
            a aVar = this.f1244u;
            if (aVar != null) {
                aVar.cancel(false);
            }
            a aVar2 = new a(this, this.f1246w, getContext());
            this.f1244u = aVar2;
            this.f1246w = 0;
            aVar2.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public final void b() {
        this.f1238o.getClass();
        w3.z g = w3.b0.g();
        int i10 = !g.d() ? g.f13075h : 0;
        if (this.f1248y != i10) {
            this.f1248y = i10;
            d();
            refreshDrawableState();
        }
        if (i10 == 1) {
            a();
        }
    }

    public final boolean c() {
        androidx.fragment.app.i0 fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
        }
        this.f1238o.getClass();
        if (w3.b0.g().d()) {
            if (fragmentManager.A("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null) {
                Log.w("MediaRouteButton", "showDialog(): Route chooser dialog already showing!");
                return false;
            }
            this.f1241r.getClass();
            f fVar = new f();
            w3.o oVar = this.f1240q;
            if (oVar == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            fVar.N();
            if (!fVar.f1304z0.equals(oVar)) {
                fVar.f1304z0 = oVar;
                Bundle bundle = fVar.f811t;
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle("selector", oVar.f12982a);
                fVar.I(bundle);
                f.d0 d0Var = fVar.f1303y0;
                if (d0Var != null) {
                    if (fVar.f1302x0) {
                        ((a0) d0Var).h(oVar);
                    } else {
                        ((e) d0Var).i(oVar);
                    }
                }
            }
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
            aVar.f(0, fVar, "android.support.v7.mediarouter:MediaRouteChooserDialogFragment", 1);
            aVar.e(true);
            return true;
        }
        if (fragmentManager.A("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null) {
            Log.w("MediaRouteButton", "showDialog(): Route controller dialog already showing!");
            return false;
        }
        this.f1241r.getClass();
        t tVar = new t();
        w3.o oVar2 = this.f1240q;
        if (oVar2 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (tVar.f1418z0 == null) {
            Bundle bundle2 = tVar.f811t;
            if (bundle2 != null) {
                tVar.f1418z0 = w3.o.b(bundle2.getBundle("selector"));
            }
            if (tVar.f1418z0 == null) {
                tVar.f1418z0 = w3.o.f12981c;
            }
        }
        if (!tVar.f1418z0.equals(oVar2)) {
            tVar.f1418z0 = oVar2;
            Bundle bundle3 = tVar.f811t;
            if (bundle3 == null) {
                bundle3 = new Bundle();
            }
            bundle3.putBundle("selector", oVar2.f12982a);
            tVar.I(bundle3);
            f.d0 d0Var2 = tVar.f1417y0;
            if (d0Var2 != null && tVar.f1416x0) {
                ((n0) d0Var2).j(oVar2);
            }
        }
        androidx.fragment.app.a aVar2 = new androidx.fragment.app.a(fragmentManager);
        aVar2.f(0, tVar, "android.support.v7.mediarouter:MediaRouteControllerDialogFragment", 1);
        aVar2.e(true);
        return true;
    }

    public final void d() {
        int i10 = this.f1248y;
        String string = getContext().getString(i10 != 1 ? i10 != 2 ? org.chromium.net.R.string.mr_cast_button_disconnected : org.chromium.net.R.string.mr_cast_button_connected : org.chromium.net.R.string.mr_cast_button_connecting);
        setContentDescription(string);
        if (!this.C || TextUtils.isEmpty(string)) {
            string = null;
        }
        k5.a.w(this, string);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1245v != null) {
            this.f1245v.setState(getDrawableState());
            if (this.f1245v.getCurrent() instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) this.f1245v.getCurrent();
                int i10 = this.f1248y;
                if (i10 == 1 || this.f1247x != i10) {
                    if (!animationDrawable.isRunning()) {
                        animationDrawable.start();
                    }
                } else if (i10 == 2 && !animationDrawable.isRunning()) {
                    animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
                }
            }
            invalidate();
        }
        this.f1247x = this.f1248y;
    }

    public u getDialogFactory() {
        return this.f1241r;
    }

    public w3.o getRouteSelector() {
        return this.f1240q;
    }

    @Override // android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1245v;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.f1242s = true;
        if (!this.f1240q.d()) {
            this.f1238o.a(this.f1240q, this.f1239p, 0);
        }
        b();
    }

    @Override // android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (this.f1238o != null && !this.f1243t) {
            int i11 = this.f1248y;
            if (i11 == 1) {
                View.mergeDrawableStates(onCreateDrawableState, F);
                return onCreateDrawableState;
            }
            if (i11 == 2) {
                View.mergeDrawableStates(onCreateDrawableState, E);
                return onCreateDrawableState;
            }
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.f1242s = false;
            if (!this.f1240q.d()) {
                this.f1238o.i(this.f1239p);
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1245v != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int intrinsicWidth = this.f1245v.getIntrinsicWidth();
            int intrinsicHeight = this.f1245v.getIntrinsicHeight();
            int i10 = (((width - paddingLeft) - intrinsicWidth) / 2) + paddingLeft;
            int i11 = (((height - paddingTop) - intrinsicHeight) / 2) + paddingTop;
            this.f1245v.setBounds(i10, i11, intrinsicWidth + i10, intrinsicHeight + i11);
            this.f1245v.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        Drawable drawable = this.f1245v;
        int i13 = 0;
        if (drawable != null) {
            i12 = getPaddingRight() + getPaddingLeft() + drawable.getIntrinsicWidth();
        } else {
            i12 = 0;
        }
        int max = Math.max(this.A, i12);
        Drawable drawable2 = this.f1245v;
        if (drawable2 != null) {
            i13 = getPaddingBottom() + getPaddingTop() + drawable2.getIntrinsicHeight();
        }
        int max2 = Math.max(this.B, i13);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, max);
        } else if (mode != 1073741824) {
            size = max;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, max2);
        } else if (mode2 != 1073741824) {
            size2 = max2;
        }
        setMeasuredDimension(size, size2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0107, code lost:
    
        if (r2 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00a4, code lost:
    
        if (j1.c.r(r2) != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean performClick() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteButton.performClick():boolean");
    }

    public void setCheatSheetEnabled(boolean z10) {
        if (z10 != this.C) {
            this.C = z10;
            d();
        }
    }

    public void setDialogFactory(u uVar) {
        if (uVar == null) {
            throw new IllegalArgumentException("factory must not be null");
        }
        this.f1241r = uVar;
    }

    public void setRemoteIndicatorDrawable(Drawable drawable) {
        this.f1246w = 0;
        setRemoteIndicatorDrawableInternal(drawable);
    }

    public void setRemoteIndicatorDrawableInternal(Drawable drawable) {
        a aVar = this.f1244u;
        if (aVar != null) {
            aVar.cancel(false);
        }
        Drawable drawable2 = this.f1245v;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1245v);
        }
        if (drawable != null) {
            ColorStateList colorStateList = this.f1249z;
            if (colorStateList != null) {
                drawable = drawable.mutate();
                drawable.setTintList(colorStateList);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
        }
        this.f1245v = drawable;
        refreshDrawableState();
    }

    public void setRouteSelector(w3.o oVar) {
        if (oVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f1240q.equals(oVar)) {
            return;
        }
        if (this.f1242s) {
            boolean d6 = this.f1240q.d();
            f0 f0Var = this.f1239p;
            w3.b0 b0Var = this.f1238o;
            if (!d6) {
                b0Var.i(f0Var);
            }
            if (!oVar.d()) {
                b0Var.a(oVar, f0Var, 0);
            }
        }
        this.f1240q = oVar;
        b();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        Drawable drawable = this.f1245v;
        if (drawable != null) {
            drawable.setVisible(i10 == 0, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1245v;
    }

    @Deprecated
    public void setAlwaysVisible(boolean z10) {
    }
}
