package m;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class l0 extends Spinner {

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f8466w = {R.attr.spinnerMode};

    /* renamed from: o, reason: collision with root package name */
    public final b4.b f8467o;

    /* renamed from: p, reason: collision with root package name */
    public final Context f8468p;

    /* renamed from: q, reason: collision with root package name */
    public final d0 f8469q;

    /* renamed from: r, reason: collision with root package name */
    public SpinnerAdapter f8470r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f8471s;

    /* renamed from: t, reason: collision with root package name */
    public final k0 f8472t;

    /* renamed from: u, reason: collision with root package name */
    public int f8473u;

    /* renamed from: v, reason: collision with root package name */
    public final Rect f8474v;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        if (r7 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l0(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r12 = this;
            r0 = 2130970021(0x7f0405a5, float:1.754874E38)
            r12.<init>(r13, r14, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r12.f8474v = r1
            android.content.Context r1 = r12.getContext()
            m.n2.a(r12, r1)
            int[] r1 = e.a.f4377u
            android.support.v4.media.session.a0 r2 = android.support.v4.media.session.a0.T(r13, r14, r1, r0)
            java.lang.Object r3 = r2.f231q
            android.content.res.TypedArray r3 = (android.content.res.TypedArray) r3
            b4.b r4 = new b4.b
            r4.<init>(r12)
            r12.f8467o = r4
            r4 = 4
            r5 = 0
            int r4 = r3.getResourceId(r4, r5)
            if (r4 == 0) goto L35
            k.c r6 = new k.c
            r6.<init>(r13, r4)
            r12.f8468p = r6
            goto L37
        L35:
            r12.f8468p = r13
        L37:
            r4 = -1
            r6 = 0
            int[] r7 = m.l0.f8466w     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            android.content.res.TypedArray r7 = r13.obtainStyledAttributes(r14, r7, r0, r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            boolean r8 = r7.hasValue(r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            if (r8 == 0) goto L50
            int r4 = r7.getInt(r5, r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            goto L50
        L4a:
            r13 = move-exception
            r6 = r7
            goto Ld5
        L4e:
            r8 = move-exception
            goto L59
        L50:
            r7.recycle()
            goto L63
        L54:
            r13 = move-exception
            goto Ld5
        L57:
            r8 = move-exception
            r7 = r6
        L59:
            java.lang.String r9 = "AppCompatSpinner"
            java.lang.String r10 = "Could not read android:spinnerMode"
            android.util.Log.i(r9, r10, r8)     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L63
            goto L50
        L63:
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L9d
            if (r4 == r8) goto L6a
            goto Laa
        L6a:
            m.i0 r4 = new m.i0
            android.content.Context r9 = r12.f8468p
            r4.<init>(r12, r9, r14)
            android.content.Context r9 = r12.f8468p
            android.support.v4.media.session.a0 r1 = android.support.v4.media.session.a0.T(r9, r14, r1, r0)
            java.lang.Object r9 = r1.f231q
            android.content.res.TypedArray r9 = (android.content.res.TypedArray) r9
            r10 = 3
            r11 = -2
            int r9 = r9.getLayoutDimension(r10, r11)
            r12.f8473u = r9
            android.graphics.drawable.Drawable r9 = r1.K(r8)
            r4.g(r9)
            java.lang.String r7 = r3.getString(r7)
            r4.R = r7
            r1.U()
            r12.f8472t = r4
            m.d0 r1 = new m.d0
            r1.<init>(r12, r12, r4)
            r12.f8469q = r1
            goto Laa
        L9d:
            m.f0 r1 = new m.f0
            r1.<init>(r12)
            r12.f8472t = r1
            java.lang.String r4 = r3.getString(r7)
            r1.f8408q = r4
        Laa:
            java.lang.CharSequence[] r1 = r3.getTextArray(r5)
            if (r1 == 0) goto Lc1
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r13, r4, r1)
            r13 = 2131624258(0x7f0e0142, float:1.887569E38)
            r3.setDropDownViewResource(r13)
            r12.setAdapter(r3)
        Lc1:
            r2.U()
            r12.f8471s = r8
            android.widget.SpinnerAdapter r13 = r12.f8470r
            if (r13 == 0) goto Lcf
            r12.setAdapter(r13)
            r12.f8470r = r6
        Lcf:
            b4.b r13 = r12.f8467o
            r13.m(r14, r0)
            return
        Ld5:
            if (r6 == 0) goto Lda
            r6.recycle()
        Lda:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: m.l0.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i11;
        }
        Rect rect = this.f8474v;
        drawable.getPadding(rect);
        return rect.left + rect.right + i11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b4.b bVar = this.f8467o;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        k0 k0Var = this.f8472t;
        return k0Var != null ? k0Var.b() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        k0 k0Var = this.f8472t;
        return k0Var != null ? k0Var.l() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f8472t != null ? this.f8473u : super.getDropDownWidth();
    }

    public final k0 getInternalPopup() {
        return this.f8472t;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        k0 k0Var = this.f8472t;
        return k0Var != null ? k0Var.d() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f8468p;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        k0 k0Var = this.f8472t;
        return k0Var != null ? k0Var.n() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        b4.b bVar = this.f8467o;
        if (bVar != null) {
            return bVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b4.b bVar = this.f8467o;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k0 k0Var = this.f8472t;
        if (k0Var == null || !k0Var.a()) {
            return;
        }
        k0Var.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f8472t == null || View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        j0 j0Var = (j0) parcelable;
        super.onRestoreInstanceState(j0Var.getSuperState());
        if (!j0Var.f8442o || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new l.d(2, this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        j0 j0Var = new j0(super.onSaveInstanceState());
        k0 k0Var = this.f8472t;
        j0Var.f8442o = k0Var != null && k0Var.a();
        return j0Var;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        d0 d0Var = this.f8469q;
        if (d0Var == null || !d0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        k0 k0Var = this.f8472t;
        if (k0Var == null) {
            return super.performClick();
        }
        if (k0Var.a()) {
            return true;
        }
        k0Var.k(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b4.b bVar = this.f8467o;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b4.b bVar = this.f8467o;
        if (bVar != null) {
            bVar.p(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        k0 k0Var = this.f8472t;
        if (k0Var == null) {
            super.setDropDownHorizontalOffset(i10);
        } else {
            k0Var.i(i10);
            k0Var.j(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        k0 k0Var = this.f8472t;
        if (k0Var != null) {
            k0Var.h(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f8472t != null) {
            this.f8473u = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        k0 k0Var = this.f8472t;
        if (k0Var != null) {
            k0Var.g(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(n4.a.o(getPopupContext(), i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        k0 k0Var = this.f8472t;
        if (k0Var != null) {
            k0Var.e(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b4.b bVar = this.f8467o;
        if (bVar != null) {
            bVar.w(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b4.b bVar = this.f8467o;
        if (bVar != null) {
            bVar.x(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f8471s) {
            this.f8470r = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        k0 k0Var = this.f8472t;
        if (k0Var != null) {
            Context context = this.f8468p;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            g0 g0Var = new g0();
            g0Var.f8412o = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                g0Var.f8413p = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                e0.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            k0Var.o(g0Var);
        }
    }
}
