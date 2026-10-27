package com.google.android.material.button;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.v0;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import d9.b0;
import d9.d0;
import d9.j;
import d9.m;
import d9.n;
import d9.y;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p4.p;
import p8.a;
import p8.b;
import p8.f;
import t0.e;
import x8.k;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, y {
    public static final int[] T = {R.attr.state_checkable};
    public static final int[] U = {R.attr.state_checked};
    public static final a V = new a();
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public float G;
    public int H;
    public int I;
    public LinearLayout.LayoutParams J;
    public boolean K;
    public int L;
    public boolean M;
    public int N;
    public d0 O;
    public int P;
    public float Q;
    public float R;
    public e S;

    /* renamed from: r, reason: collision with root package name */
    public final f f3711r;

    /* renamed from: s, reason: collision with root package name */
    public final LinkedHashSet f3712s;

    /* renamed from: t, reason: collision with root package name */
    public b f3713t;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f3714u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f3715v;

    /* renamed from: w, reason: collision with root package name */
    public Drawable f3716w;

    /* renamed from: x, reason: collision with root package name */
    public String f3717x;

    /* renamed from: y, reason: collision with root package name */
    public int f3718y;

    /* renamed from: z, reason: collision with root package name */
    public int f3719z;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(i9.a.b(context, attributeSet, org.chromium.net.R.attr.materialButtonStyle, org.chromium.net.R.style.Widget_MaterialComponents_Button, new int[]{org.chromium.net.R.attr.materialSizeOverlay}), attributeSet, org.chromium.net.R.attr.materialButtonStyle);
        this.f3712s = new LinkedHashSet();
        this.C = false;
        this.D = false;
        this.F = -1;
        this.G = -1.0f;
        this.H = -1;
        this.I = -1;
        this.N = -1;
        Context context2 = getContext();
        TypedArray e7 = k.e(context2, attributeSet, j8.a.f7189j, org.chromium.net.R.attr.materialButtonStyle, org.chromium.net.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.B = e7.getDimensionPixelSize(13, 0);
        int i10 = e7.getInt(16, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f3714u = k.f(i10, mode);
        this.f3715v = d.l(getContext(), e7, 15);
        this.f3716w = d.n(getContext(), e7, 11);
        this.E = e7.getInteger(12, 1);
        this.f3718y = e7.getDimensionPixelSize(14, 0);
        b0 b2 = b0.b(context2, e7, 19);
        n c10 = b2 != null ? b2.c() : n.b(context2, attributeSet, org.chromium.net.R.attr.materialButtonStyle, org.chromium.net.R.style.Widget_MaterialComponents_Button).a();
        boolean z10 = e7.getBoolean(17, false);
        f fVar = new f(this, c10);
        this.f3711r = fVar;
        fVar.f10124f = e7.getDimensionPixelOffset(2, 0);
        fVar.g = e7.getDimensionPixelOffset(3, 0);
        fVar.f10125h = e7.getDimensionPixelOffset(4, 0);
        fVar.f10126i = e7.getDimensionPixelOffset(5, 0);
        if (e7.hasValue(9)) {
            int dimensionPixelSize = e7.getDimensionPixelSize(9, -1);
            fVar.f10127j = dimensionPixelSize;
            float f10 = dimensionPixelSize;
            m f11 = fVar.f10120b.f();
            f11.f4293e = new d9.a(f10);
            f11.f4294f = new d9.a(f10);
            f11.g = new d9.a(f10);
            f11.f4295h = new d9.a(f10);
            fVar.f10120b = f11.a();
            fVar.f10121c = null;
            fVar.d();
            fVar.f10136s = true;
        }
        fVar.f10128k = e7.getDimensionPixelSize(22, 0);
        fVar.f10129l = k.f(e7.getInt(8, -1), mode);
        fVar.f10130m = d.l(getContext(), e7, 7);
        fVar.f10131n = d.l(getContext(), e7, 21);
        fVar.f10132o = d.l(getContext(), e7, 18);
        fVar.f10137t = e7.getBoolean(6, false);
        fVar.f10140w = e7.getDimensionPixelSize(10, 0);
        fVar.f10138u = e7.getBoolean(23, true);
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (e7.hasValue(0)) {
            fVar.f10135r = true;
            setSupportBackgroundTintList(fVar.f10130m);
            setSupportBackgroundTintMode(fVar.f10129l);
        } else {
            fVar.c();
        }
        setPaddingRelative(paddingStart + fVar.f10124f, paddingTop + fVar.f10125h, paddingEnd + fVar.g, paddingBottom + fVar.f10126i);
        setCheckedInternal(e7.getBoolean(1, false));
        if (b2 != null) {
            fVar.f10122d = d();
            if (fVar.f10121c != null) {
                fVar.d();
            }
            fVar.f10121c = b2;
            fVar.d();
        }
        setOpticalCenterEnabled(z10);
        e7.recycle();
        setCompoundDrawablePadding(this.B);
        h(this.f3716w != null);
    }

    public static /* synthetic */ void a(MaterialButton materialButton) {
        materialButton.L = materialButton.getOpticalCenterShift();
        materialButton.j();
        materialButton.invalidate();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.Q;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        j a10;
        if (this.K && this.M && (a10 = this.f3711r.a(false)) != null) {
            return (int) (a10.h() * 0.11f);
        }
        return 0;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < lineCount; i10++) {
            f10 = Math.max(f10, getLayout().getLineWidth(i10));
        }
        return (int) Math.ceil(f10);
    }

    private void setCheckedInternal(boolean z10) {
        f fVar = this.f3711r;
        if (fVar == null || !fVar.f10137t || this.C == z10) {
            return;
        }
        this.C = z10;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z11 = this.C;
            if (!materialButtonToggleGroup.f3721z) {
                materialButtonToggleGroup.f(getId(), z11);
            }
        }
        if (this.D) {
            return;
        }
        this.D = true;
        Iterator it = this.f3712s.iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.d.l(it);
        }
        this.D = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f10) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        if (this.Q != f10) {
            this.Q = f10;
            j();
            invalidate();
            if (getParent() instanceof p8.e) {
                p8.e eVar = (p8.e) getParent();
                int i10 = (int) this.Q;
                int indexOfChild = eVar.indexOfChild(this);
                if (indexOfChild < 0) {
                    return;
                }
                int i11 = indexOfChild - 1;
                while (true) {
                    materialButton = null;
                    if (i11 < 0) {
                        materialButton2 = null;
                        break;
                    } else {
                        if (eVar.c(i11)) {
                            materialButton2 = (MaterialButton) eVar.getChildAt(i11);
                            break;
                        }
                        i11--;
                    }
                }
                int childCount = eVar.getChildCount();
                while (true) {
                    indexOfChild++;
                    if (indexOfChild >= childCount) {
                        break;
                    } else if (eVar.c(indexOfChild)) {
                        materialButton = (MaterialButton) eVar.getChildAt(indexOfChild);
                        break;
                    }
                }
                if (materialButton2 == null && materialButton == null) {
                    return;
                }
                if (materialButton2 == null) {
                    materialButton.setDisplayedWidthDecrease(i10);
                }
                if (materialButton == null) {
                    materialButton2.setDisplayedWidthDecrease(i10);
                }
                if (materialButton2 == null || materialButton == null) {
                    return;
                }
                materialButton2.setDisplayedWidthDecrease(i10 / 2);
                materialButton.setDisplayedWidthDecrease((i10 + 1) / 2);
            }
        }
    }

    public final t0.f d() {
        Context context = getContext();
        TypedValue x6 = c.x(context, org.chromium.net.R.attr.motionSpringFastSpatial);
        int[] iArr = j8.a.f7198s;
        TypedArray obtainStyledAttributes = x6 == null ? context.obtainStyledAttributes(null, iArr, 0, org.chromium.net.R.style.Motion_Material3_Spring_Standard_Fast_Spatial) : context.obtainStyledAttributes(x6.resourceId, iArr);
        t0.f fVar = new t0.f();
        try {
            float f10 = obtainStyledAttributes.getFloat(1, Float.MIN_VALUE);
            if (f10 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f11 = obtainStyledAttributes.getFloat(0, Float.MIN_VALUE);
            if (f11 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            if (f10 <= 0.0f) {
                throw new IllegalArgumentException("Spring stiffness constant must be positive.");
            }
            fVar.f11771a = Math.sqrt(f10);
            fVar.f11773c = false;
            if (f11 < 0.0f) {
                throw new IllegalArgumentException("Damping ratio must be non-negative");
            }
            fVar.f11772b = f11;
            fVar.f11773c = false;
            obtainStyledAttributes.recycle();
            return fVar;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final boolean e() {
        f fVar = this.f3711r;
        return (fVar == null || fVar.f10135r) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0071, code lost:
    
        if (r1 == 2) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(boolean r9) {
        /*
            r8 = this;
            d9.d0 r0 = r8.O
            if (r0 != 0) goto L6
            goto L85
        L6:
            t0.e r0 = r8.S
            if (r0 != 0) goto L19
            t0.e r0 = new t0.e
            p8.a r1 = com.google.android.material.button.MaterialButton.V
            r0.<init>(r8, r1)
            r8.S = r0
            t0.f r1 = r8.d()
            r0.f11768j = r1
        L19:
            boolean r0 = r8.M
            if (r0 == 0) goto L85
            int r0 = r8.P
            d9.d0 r1 = r8.O
            int[] r2 = r8.getDrawableState()
            int[][] r3 = r1.f4255c
            r4 = 0
            r5 = r4
        L29:
            int r6 = r1.f4253a
            r7 = -1
            if (r5 >= r6) goto L3a
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L37
            goto L3b
        L37:
            int r5 = r5 + 1
            goto L29
        L3a:
            r5 = r7
        L3b:
            if (r5 >= 0) goto L54
            int[] r2 = android.util.StateSet.WILD_CARD
            int[][] r3 = r1.f4255c
            r5 = r4
        L42:
            int r6 = r1.f4253a
            if (r5 >= r6) goto L53
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L50
            r7 = r5
            goto L53
        L50:
            int r5 = r5 + 1
            goto L42
        L53:
            r5 = r7
        L54:
            if (r5 >= 0) goto L59
            a6.n r1 = r1.f4254b
            goto L5d
        L59:
            a6.n[] r1 = r1.f4256d
            r1 = r1[r5]
        L5d:
            java.lang.Object r1 = r1.f74p
            d9.c0 r1 = (d9.c0) r1
            int r2 = r8.getWidth()
            float r3 = r1.f4252b
            int r1 = r1.f4251a
            r5 = 1
            if (r1 != r5) goto L70
            float r1 = (float) r2
            float r3 = r3 * r1
        L6e:
            int r4 = (int) r3
            goto L74
        L70:
            r2 = 2
            if (r1 != r2) goto L74
            goto L6e
        L74:
            int r0 = java.lang.Math.min(r0, r4)
            t0.e r1 = r8.S
            float r0 = (float) r0
            r1.a(r0)
            if (r9 == 0) goto L85
            t0.e r9 = r8.S
            r9.d()
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.f(boolean):void");
    }

    public final void g() {
        int i10 = this.E;
        if (i10 == 1 || i10 == 2) {
            setCompoundDrawablesRelative(this.f3716w, null, null, null);
            return;
        }
        if (i10 == 3 || i10 == 4) {
            setCompoundDrawablesRelative(null, null, this.f3716w, null);
        } else if (i10 == 16 || i10 == 32) {
            setCompoundDrawablesRelative(null, this.f3716w, null, null);
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f3717x)) {
            return this.f3717x;
        }
        f fVar = this.f3711r;
        return ((fVar == null || !fVar.f10137t) ? Button.class : CompoundButton.class).getName();
    }

    public int getAllowedWidthDecrease() {
        return this.N;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (e()) {
            return this.f3711r.f10127j;
        }
        return 0;
    }

    public t0.f getCornerSpringForce() {
        return this.f3711r.f10122d;
    }

    public Drawable getIcon() {
        return this.f3716w;
    }

    public int getIconGravity() {
        return this.E;
    }

    public int getIconPadding() {
        return this.B;
    }

    public int getIconSize() {
        return this.f3718y;
    }

    public ColorStateList getIconTint() {
        return this.f3715v;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f3714u;
    }

    public int getInsetBottom() {
        return this.f3711r.f10126i;
    }

    public int getInsetTop() {
        return this.f3711r.f10125h;
    }

    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f3711r.f10132o;
        }
        return null;
    }

    public n getShapeAppearanceModel() {
        if (e()) {
            return this.f3711r.f10120b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public b0 getStateListShapeAppearanceModel() {
        if (e()) {
            return this.f3711r.f10121c;
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f3711r.f10131n;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.f3711r.f10128k;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.f3711r.f10130m : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.f3711r.f10129l : super.getSupportBackgroundTintMode();
    }

    public final void h(boolean z10) {
        Drawable drawable = this.f3716w;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f3716w = mutate;
            mutate.setTintList(this.f3715v);
            PorterDuff.Mode mode = this.f3714u;
            if (mode != null) {
                this.f3716w.setTintMode(mode);
            }
            int i10 = this.f3718y;
            if (i10 == 0) {
                i10 = this.f3716w.getIntrinsicWidth();
            }
            int i11 = this.f3718y;
            if (i11 == 0) {
                i11 = this.f3716w.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f3716w;
            int i12 = this.f3719z;
            int i13 = this.A;
            drawable2.setBounds(i12, i13, i10 + i12, i11 + i13);
            this.f3716w.setVisible(true, z10);
        }
        if (z10) {
            g();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i14 = this.E;
        if (((i14 == 1 || i14 == 2) && drawable3 != this.f3716w) || (((i14 == 3 || i14 == 4) && drawable5 != this.f3716w) || ((i14 == 16 || i14 == 32) && drawable4 != this.f3716w))) {
            g();
        }
    }

    public final void i(int i10, int i11) {
        if (this.f3716w == null || getLayout() == null) {
            return;
        }
        int i12 = this.E;
        if (i12 != 1 && i12 != 2 && i12 != 3 && i12 != 4) {
            if (i12 == 16 || i12 == 32) {
                this.f3719z = 0;
                if (i12 == 16) {
                    this.A = 0;
                    h(false);
                    return;
                }
                int i13 = this.f3718y;
                if (i13 == 0) {
                    i13 = this.f3716w.getIntrinsicHeight();
                }
                int max = Math.max(0, (((((i11 - getTextHeight()) - getPaddingTop()) - i13) - this.B) - getPaddingBottom()) / 2);
                if (this.A != max) {
                    this.A = max;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.A = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i14 = this.E;
        if (i14 == 1 || i14 == 3 || ((i14 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i14 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f3719z = 0;
            h(false);
            return;
        }
        int i15 = this.f3718y;
        if (i15 == 0) {
            i15 = this.f3716w.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i10 - getTextLayoutWidth()) - getPaddingEnd()) - i15) - this.B) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.E == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f3719z != textLayoutWidth) {
            this.f3719z = textLayoutWidth;
            h(false);
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.C;
    }

    public final void j() {
        int i10 = (int) (this.Q - this.R);
        int i11 = (i10 / 2) + this.L;
        getLayoutParams().width = (int) (this.G + i10);
        setPaddingRelative(this.H + i11, getPaddingTop(), (this.I + i10) - i11, getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            j1.c.q(this, this.f3711r.a(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        f fVar = this.f3711r;
        if (fVar != null && fVar.f10137t) {
            View.mergeDrawableStates(onCreateDrawableState, T);
        }
        if (this.C) {
            View.mergeDrawableStates(onCreateDrawableState, U);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.C);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        f fVar = this.f3711r;
        accessibilityNodeInfo.setCheckable(fVar != null && fVar.f10137t);
        accessibilityNodeInfo.setChecked(this.C);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        super.onLayout(z10, i10, i11, i12, i13);
        i(getMeasuredWidth(), getMeasuredHeight());
        int i15 = getResources().getConfiguration().orientation;
        if (this.F != i15) {
            this.F = i15;
            this.G = -1.0f;
        }
        if (this.G == -1.0f) {
            this.G = getMeasuredWidth();
            if (this.J == null && (getParent() instanceof p8.e) && ((p8.e) getParent()).getButtonSizeChange() != null) {
                this.J = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.J);
                layoutParams.width = (int) this.G;
                setLayoutParams(layoutParams);
            }
        }
        boolean z11 = false;
        if (this.N == -1) {
            if (this.f3716w == null) {
                i14 = 0;
            } else {
                int iconPadding = getIconPadding();
                int i16 = this.f3718y;
                if (i16 == 0) {
                    i16 = this.f3716w.getIntrinsicWidth();
                }
                i14 = iconPadding + i16;
            }
            this.N = (getMeasuredWidth() - getTextLayoutWidth()) - i14;
        }
        if (this.H == -1) {
            this.H = getPaddingStart();
        }
        if (this.I == -1) {
            this.I = getPaddingEnd();
        }
        if ((getParent() instanceof p8.e) && ((p8.e) getParent()).getOrientation() == 0) {
            z11 = true;
        }
        this.M = z11;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof p8.c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        p8.c cVar = (p8.c) parcelable;
        super.onRestoreInstanceState(cVar.f10407o);
        setChecked(cVar.f10106q);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        p8.c cVar = new p8.c(super.onSaveInstanceState());
        cVar.f10106q = this.C;
        return cVar;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (isEnabled() && this.f3711r.f10138u) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f3716w != null) {
            if (this.f3716w.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f3717x = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (!e()) {
            super.setBackgroundColor(i10);
            return;
        }
        f fVar = this.f3711r;
        if (fVar.a(false) != null) {
            fVar.a(false).setTint(i10);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        f fVar = this.f3711r;
        fVar.f10135r = true;
        MaterialButton materialButton = fVar.f10119a;
        materialButton.setSupportBackgroundTintList(fVar.f10130m);
        materialButton.setSupportBackgroundTintMode(fVar.f10129l);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i10) {
        setBackgroundDrawable(i10 != 0 ? n4.a.o(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (e()) {
            this.f3711r.f10137t = z10;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedInternal(z10);
    }

    public void setCornerRadius(int i10) {
        if (e()) {
            f fVar = this.f3711r;
            if (fVar.f10136s && fVar.f10127j == i10) {
                return;
            }
            fVar.f10127j = i10;
            fVar.f10136s = true;
            float f10 = i10;
            m f11 = fVar.f10120b.f();
            f11.f4293e = new d9.a(f10);
            f11.f4294f = new d9.a(f10);
            f11.g = new d9.a(f10);
            f11.f4295h = new d9.a(f10);
            fVar.f10120b = f11.a();
            fVar.f10121c = null;
            fVar.d();
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCornerSpringForce(t0.f fVar) {
        f fVar2 = this.f3711r;
        fVar2.f10122d = fVar;
        if (fVar2.f10121c != null) {
            fVar2.d();
        }
    }

    public void setDisplayedWidthDecrease(int i10) {
        this.R = Math.min(i10, this.N);
        j();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        if (e()) {
            this.f3711r.a(false).m(f10);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f3716w != drawable) {
            this.f3716w = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.E != i10) {
            this.E = i10;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i10) {
        if (this.B != i10) {
            this.B = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        setIcon(i10 != 0 ? n4.a.o(getContext(), i10) : null);
    }

    public void setIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f3718y != i10) {
            this.f3718y = i10;
            h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f3715v != colorStateList) {
            this.f3715v = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f3714u != mode) {
            this.f3714u = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(n4.a.n(getContext(), i10));
    }

    public void setInsetBottom(int i10) {
        f fVar = this.f3711r;
        fVar.b(fVar.f10125h, i10);
    }

    public void setInsetTop(int i10) {
        f fVar = this.f3711r;
        fVar.b(i10, fVar.f10126i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f3713t = bVar;
    }

    public void setOpticalCenterEnabled(boolean z10) {
        if (this.K != z10) {
            this.K = z10;
            f fVar = this.f3711r;
            if (z10) {
                v0 v0Var = new v0(15, this);
                fVar.f10123e = v0Var;
                j a10 = fVar.a(false);
                if (a10 != null) {
                    a10.R = v0Var;
                }
            } else {
                fVar.f10123e = null;
                j a11 = fVar.a(false);
                if (a11 != null) {
                    a11.R = null;
                }
            }
            post(new androidx.activity.d(18, this));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        b bVar = this.f3713t;
        if (bVar != null) {
            ((MaterialButtonToggleGroup) ((p) bVar).f9953p).invalidate();
        }
        super.setPressed(z10);
        f(false);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (e()) {
            f fVar = this.f3711r;
            MaterialButton materialButton = fVar.f10119a;
            if (fVar.f10132o != colorStateList) {
                fVar.f10132o = colorStateList;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(b9.a.a(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i10) {
        if (e()) {
            setRippleColor(n4.a.n(getContext(), i10));
        }
    }

    @Override // d9.y
    public void setShapeAppearanceModel(n nVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        f fVar = this.f3711r;
        fVar.f10120b = nVar;
        fVar.f10121c = null;
        fVar.d();
    }

    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (e()) {
            f fVar = this.f3711r;
            fVar.f10134q = z10;
            fVar.e();
        }
    }

    public void setSizeChange(d0 d0Var) {
        if (this.O != d0Var) {
            this.O = d0Var;
            f(true);
        }
    }

    public void setStateListShapeAppearanceModel(b0 b0Var) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        f fVar = this.f3711r;
        if (fVar.f10122d == null && b0Var.d()) {
            fVar.f10122d = d();
            if (fVar.f10121c != null) {
                fVar.d();
            }
        }
        fVar.f10121c = b0Var;
        fVar.d();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (e()) {
            f fVar = this.f3711r;
            if (fVar.f10131n != colorStateList) {
                fVar.f10131n = colorStateList;
                fVar.e();
            }
        }
    }

    public void setStrokeColorResource(int i10) {
        if (e()) {
            setStrokeColor(n4.a.n(getContext(), i10));
        }
    }

    public void setStrokeWidth(int i10) {
        if (e()) {
            f fVar = this.f3711r;
            if (fVar.f10128k != i10) {
                fVar.f10128k = i10;
                fVar.e();
            }
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!e()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        f fVar = this.f3711r;
        if (fVar.f10130m != colorStateList) {
            fVar.f10130m = colorStateList;
            if (fVar.a(false) != null) {
                fVar.a(false).setTintList(fVar.f10130m);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!e()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        f fVar = this.f3711r;
        if (fVar.f10129l != mode) {
            fVar.f10129l = mode;
            if (fVar.a(false) == null || fVar.f10129l == null) {
                return;
            }
            fVar.a(false).setTintMode(fVar.f10129l);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f3711r.f10138u = z10;
    }

    @Override // android.widget.TextView
    public void setWidth(int i10) {
        this.G = -1.0f;
        super.setWidth(i10);
    }

    public void setWidthChangeMax(int i10) {
        if (this.P != i10) {
            this.P = i10;
            f(true);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.C);
    }
}
