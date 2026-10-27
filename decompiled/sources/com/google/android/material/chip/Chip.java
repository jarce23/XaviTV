package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import d9.n;
import d9.y;
import i9.a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import k0.g;
import m.p;
import m0.k0;
import okhttp3.internal.url._UrlKt;
import s8.b;
import s8.c;
import s8.d;
import s8.e;
import x8.i;
import x8.k;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Chip extends p implements d, y, Checkable {
    public static final Rect K = new Rect();
    public static final int[] L = {R.attr.state_selected};
    public static final int[] M = {R.attr.state_checkable};
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public CharSequence E;
    public final c F;
    public boolean G;
    public final Rect H;
    public final RectF I;
    public final b J;

    /* renamed from: s, reason: collision with root package name */
    public e f3725s;

    /* renamed from: t, reason: collision with root package name */
    public InsetDrawable f3726t;

    /* renamed from: u, reason: collision with root package name */
    public RippleDrawable f3727u;

    /* renamed from: v, reason: collision with root package name */
    public View.OnClickListener f3728v;

    /* renamed from: w, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f3729w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f3730x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f3731y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3732z;

    public Chip(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, org.chromium.net.R.attr.chipStyle, org.chromium.net.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, org.chromium.net.R.attr.chipStyle);
        int resourceId;
        int resourceId2;
        int resourceId3;
        this.H = new Rect();
        this.I = new RectF();
        this.J = new b(0, this);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        e eVar = new e(context2, attributeSet);
        Context context3 = eVar.B0;
        int[] iArr = j8.a.f7183c;
        TypedArray e7 = k.e(context3, attributeSet, iArr, org.chromium.net.R.attr.chipStyle, org.chromium.net.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        eVar.f11639b1 = e7.hasValue(37);
        Context context4 = eVar.B0;
        ColorStateList l10 = com.bumptech.glide.d.l(context4, e7, 24);
        if (eVar.U != l10) {
            eVar.U = l10;
            eVar.onStateChange(eVar.getState());
        }
        ColorStateList l11 = com.bumptech.glide.d.l(context4, e7, 11);
        if (eVar.V != l11) {
            eVar.V = l11;
            eVar.onStateChange(eVar.getState());
        }
        float dimension = e7.getDimension(19, 0.0f);
        if (eVar.W != dimension) {
            eVar.W = dimension;
            eVar.invalidateSelf();
            eVar.A();
        }
        if (e7.hasValue(12)) {
            eVar.G(e7.getDimension(12, 0.0f));
        }
        eVar.L(com.bumptech.glide.d.l(context4, e7, 22));
        eVar.M(e7.getDimension(23, 0.0f));
        eVar.W(com.bumptech.glide.d.l(context4, e7, 36));
        CharSequence text = e7.getText(5);
        text = text == null ? _UrlKt.FRAGMENT_ENCODE_SET : text;
        if (!TextUtils.equals(eVar.f11638b0, text)) {
            eVar.f11638b0 = text;
            eVar.H0.f13740d = true;
            eVar.invalidateSelf();
            eVar.A();
        }
        a9.d dVar = (!e7.hasValue(0) || (resourceId3 = e7.getResourceId(0, 0)) == 0) ? null : new a9.d(context4, resourceId3);
        dVar.f170l = e7.getDimension(1, dVar.f170l);
        eVar.X(dVar);
        int i10 = e7.getInt(3, 0);
        if (i10 == 1) {
            eVar.Y0 = TextUtils.TruncateAt.START;
        } else if (i10 == 2) {
            eVar.Y0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i10 == 3) {
            eVar.Y0 = TextUtils.TruncateAt.END;
        }
        eVar.K(e7.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            eVar.K(e7.getBoolean(15, false));
        }
        eVar.H(com.bumptech.glide.d.n(context4, e7, 14));
        if (e7.hasValue(17)) {
            eVar.J(com.bumptech.glide.d.l(context4, e7, 17));
        }
        eVar.I(e7.getDimension(16, -1.0f));
        eVar.T(e7.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            eVar.T(e7.getBoolean(26, false));
        }
        eVar.N(com.bumptech.glide.d.n(context4, e7, 25));
        eVar.S(com.bumptech.glide.d.l(context4, e7, 30));
        eVar.P(e7.getDimension(28, 0.0f));
        eVar.C(e7.getBoolean(6, false));
        eVar.F(e7.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            eVar.F(e7.getBoolean(8, false));
        }
        eVar.D(com.bumptech.glide.d.n(context4, e7, 7));
        if (e7.hasValue(9)) {
            eVar.E(com.bumptech.glide.d.l(context4, e7, 9));
        }
        eVar.f11654r0 = (!e7.hasValue(39) || (resourceId2 = e7.getResourceId(39, 0)) == 0) ? null : k8.b.a(context4, resourceId2);
        eVar.f11655s0 = (!e7.hasValue(33) || (resourceId = e7.getResourceId(33, 0)) == 0) ? null : k8.b.a(context4, resourceId);
        float dimension2 = e7.getDimension(21, 0.0f);
        if (eVar.f11656t0 != dimension2) {
            eVar.f11656t0 = dimension2;
            eVar.invalidateSelf();
            eVar.A();
        }
        eVar.V(e7.getDimension(35, 0.0f));
        eVar.U(e7.getDimension(34, 0.0f));
        float dimension3 = e7.getDimension(41, 0.0f);
        if (eVar.f11659w0 != dimension3) {
            eVar.f11659w0 = dimension3;
            eVar.invalidateSelf();
            eVar.A();
        }
        float dimension4 = e7.getDimension(40, 0.0f);
        if (eVar.f11660x0 != dimension4) {
            eVar.f11660x0 = dimension4;
            eVar.invalidateSelf();
            eVar.A();
        }
        eVar.Q(e7.getDimension(29, 0.0f));
        eVar.O(e7.getDimension(27, 0.0f));
        float dimension5 = e7.getDimension(13, 0.0f);
        if (eVar.A0 != dimension5) {
            eVar.A0 = dimension5;
            eVar.invalidateSelf();
            eVar.A();
        }
        eVar.f11637a1 = e7.getDimensionPixelSize(4, Integer.MAX_VALUE);
        e7.recycle();
        k.a(context2, attributeSet, org.chromium.net.R.attr.chipStyle, org.chromium.net.R.style.Widget_MaterialComponents_Chip_Action);
        k.b(context2, attributeSet, iArr, org.chromium.net.R.attr.chipStyle, org.chromium.net.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, org.chromium.net.R.attr.chipStyle, org.chromium.net.R.style.Widget_MaterialComponents_Chip_Action);
        this.B = obtainStyledAttributes.getBoolean(32, false);
        TypedValue x6 = com.bumptech.glide.c.x(context2, org.chromium.net.R.attr.minTouchTargetSize);
        this.D = (int) Math.ceil(obtainStyledAttributes.getDimension(20, (int) ((x6 == null || x6.type != 5) ? context2.getResources().getDimension(org.chromium.net.R.dimen.mtrl_min_touch_target_size) : x6.getDimension(context2.getResources().getDisplayMetrics()))));
        obtainStyledAttributes.recycle();
        setChipDrawable(eVar);
        eVar.m(getElevation());
        k.a(context2, attributeSet, org.chromium.net.R.attr.chipStyle, org.chromium.net.R.style.Widget_MaterialComponents_Chip_Action);
        k.b(context2, attributeSet, iArr, org.chromium.net.R.attr.chipStyle, org.chromium.net.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, org.chromium.net.R.attr.chipStyle, org.chromium.net.R.style.Widget_MaterialComponents_Chip_Action);
        boolean hasValue = obtainStyledAttributes2.hasValue(37);
        obtainStyledAttributes2.recycle();
        this.F = new c(this, this);
        d();
        if (!hasValue) {
            setOutlineProvider(new b1.a(this, 1));
        }
        setChecked(this.f3730x);
        setText(eVar.f11638b0);
        setEllipsize(eVar.Y0);
        g();
        if (!this.f3725s.Z0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        f();
        if (this.B) {
            setMinHeight(this.D);
        }
        this.C = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: s8.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = Chip.this.f3729w;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
                }
            }
        });
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.I;
        rectF.setEmpty();
        if (c() && this.f3728v != null) {
            e eVar = this.f3725s;
            Rect bounds = eVar.getBounds();
            rectF.setEmpty();
            if (eVar.a0()) {
                float f10 = eVar.A0 + eVar.f11662z0 + eVar.f11648l0 + eVar.f11661y0 + eVar.f11660x0;
                if (eVar.getLayoutDirection() == 0) {
                    float f11 = bounds.right;
                    rectF.right = f11;
                    rectF.left = f11 - f10;
                } else {
                    float f12 = bounds.left;
                    rectF.left = f12;
                    rectF.right = f12 + f10;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i10 = (int) closeIconTouchBounds.left;
        int i11 = (int) closeIconTouchBounds.top;
        int i12 = (int) closeIconTouchBounds.right;
        int i13 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.H;
        rect.set(i10, i11, i12, i13);
        return rect;
    }

    private a9.d getTextAppearance() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.H0.f13742f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f3732z != z10) {
            this.f3732z = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f3731y != z10) {
            this.f3731y = z10;
            refreshDrawableState();
        }
    }

    public final void b(int i10) {
        this.D = i10;
        if (!this.B) {
            InsetDrawable insetDrawable = this.f3726t;
            if (insetDrawable == null) {
                e();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f3726t = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    e();
                    return;
                }
                return;
            }
        }
        int max = Math.max(0, i10 - ((int) this.f3725s.W));
        int max2 = Math.max(0, i10 - this.f3725s.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            InsetDrawable insetDrawable2 = this.f3726t;
            if (insetDrawable2 == null) {
                e();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f3726t = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    e();
                    return;
                }
                return;
            }
        }
        int i11 = max2 > 0 ? max2 / 2 : 0;
        int i12 = max > 0 ? max / 2 : 0;
        if (this.f3726t != null) {
            Rect rect = new Rect();
            this.f3726t.getPadding(rect);
            if (rect.top == i12 && rect.bottom == i12 && rect.left == i11 && rect.right == i11) {
                e();
                return;
            }
        }
        if (getMinHeight() != i10) {
            setMinHeight(i10);
        }
        if (getMinWidth() != i10) {
            setMinWidth(i10);
        }
        this.f3726t = new InsetDrawable((Drawable) this.f3725s, i11, i12, i11, i12);
        e();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r2 = this;
            s8.e r0 = r2.f3725s
            if (r0 == 0) goto L13
            android.graphics.drawable.Drawable r0 = r0.f11645i0
            if (r0 == 0) goto Le
            boolean r1 = r0 instanceof f0.a
            if (r1 == 0) goto Lf
            f0.a r0 = (f0.a) r0
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L13
            r0 = 1
            return r0
        L13:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.c():boolean");
    }

    public final void d() {
        e eVar;
        if (!c() || (eVar = this.f3725s) == null || !eVar.h0 || this.f3728v == null) {
            k0.m(this, null);
            this.G = false;
        } else {
            k0.m(this, this.F);
            this.G = true;
        }
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i10;
        if (!this.G) {
            return super.dispatchHoverEvent(motionEvent);
        }
        c cVar = this.F;
        AccessibilityManager accessibilityManager = cVar.f11149h;
        int i11 = 0;
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                float x6 = motionEvent.getX();
                float y8 = motionEvent.getY();
                Chip chip = cVar.f11633q;
                if (chip.c() && chip.getCloseIconTouchBounds().contains(x6, y8)) {
                    i11 = 1;
                }
                int i12 = cVar.f11154m;
                if (i12 != i11) {
                    cVar.f11154m = i11;
                    cVar.r(i11, 128);
                    cVar.r(i12, 256);
                    return true;
                }
            } else if (action == 10 && (i10 = cVar.f11154m) != Integer.MIN_VALUE) {
                if (i10 != Integer.MIN_VALUE) {
                    cVar.f11154m = Integer.MIN_VALUE;
                    cVar.r(Integer.MIN_VALUE, 128);
                    cVar.r(i10, 256);
                    return true;
                }
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.G) {
            return super.dispatchKeyEvent(keyEvent);
        }
        c cVar = this.F;
        cVar.getClass();
        boolean z10 = false;
        int i10 = 0;
        z10 = false;
        z10 = false;
        z10 = false;
        z10 = false;
        z10 = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i11 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i11 = 33;
                                } else if (keyCode == 21) {
                                    i11 = 17;
                                } else if (keyCode != 22) {
                                    i11 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z11 = false;
                                while (i10 < repeatCount && cVar.m(i11, null)) {
                                    i10++;
                                    z11 = true;
                                }
                                z10 = z11;
                                break;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int i12 = cVar.f11153l;
                    if (i12 != Integer.MIN_VALUE) {
                        Chip chip = cVar.f11633q;
                        if (i12 == 0) {
                            chip.performClick();
                        } else if (i12 == 1) {
                            chip.playSoundEffect(0);
                            View.OnClickListener onClickListener = chip.f3728v;
                            if (onClickListener != null) {
                                onClickListener.onClick(chip);
                            }
                            if (chip.G) {
                                chip.F.r(1, 1);
                            }
                        }
                    }
                    z10 = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z10 = cVar.m(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z10 = cVar.m(1, null);
            }
        }
        if (!z10 || cVar.f11153l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // m.p, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f3725s;
        boolean z10 = false;
        int i10 = 0;
        z10 = false;
        if (eVar != null && e.z(eVar.f11645i0)) {
            e eVar2 = this.f3725s;
            ?? isEnabled = isEnabled();
            int i11 = isEnabled;
            if (this.A) {
                i11 = isEnabled + 1;
            }
            int i12 = i11;
            if (this.f3732z) {
                i12 = i11 + 1;
            }
            int i13 = i12;
            if (this.f3731y) {
                i13 = i12 + 1;
            }
            int i14 = i13;
            if (isChecked()) {
                i14 = i13 + 1;
            }
            int[] iArr = new int[i14];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i10 = 1;
            }
            if (this.A) {
                iArr[i10] = 16842908;
                i10++;
            }
            if (this.f3732z) {
                iArr[i10] = 16843623;
                i10++;
            }
            if (this.f3731y) {
                iArr[i10] = 16842919;
                i10++;
            }
            if (isChecked()) {
                iArr[i10] = 16842913;
            }
            z10 = eVar2.R(iArr);
        }
        if (z10) {
            invalidate();
        }
    }

    public final void e() {
        this.f3727u = new RippleDrawable(b9.a.a(this.f3725s.f11636a0), getBackgroundDrawable(), null);
        this.f3725s.getClass();
        setBackground(this.f3727u);
        f();
    }

    public final void f() {
        e eVar;
        if (TextUtils.isEmpty(getText()) || (eVar = this.f3725s) == null) {
            return;
        }
        int w10 = (int) (eVar.w() + eVar.A0 + eVar.f11660x0);
        e eVar2 = this.f3725s;
        int v10 = (int) (eVar2.v() + eVar2.f11656t0 + eVar2.f11659w0);
        if (this.f3726t != null) {
            Rect rect = new Rect();
            this.f3726t.getPadding(rect);
            v10 += rect.left;
            w10 += rect.right;
        }
        setPaddingRelative(v10, getPaddingTop(), w10, getPaddingBottom());
    }

    public final void g() {
        TextPaint paint = getPaint();
        e eVar = this.f3725s;
        if (eVar != null) {
            paint.drawableState = eVar.getState();
        }
        a9.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.d(getContext(), paint, this.J);
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.E)) {
            return this.E;
        }
        e eVar = this.f3725s;
        if (eVar == null || !eVar.f11650n0) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        getParent();
        return "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f3726t;
        return insetDrawable == null ? this.f3725s : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11652p0;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11653q0;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.V;
        }
        return null;
    }

    public float getChipCornerRadius() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return Math.max(0.0f, eVar.x());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f3725s;
    }

    public float getChipEndPadding() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.A0;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        e eVar = this.f3725s;
        if (eVar == null || (drawable = eVar.f11641d0) == 0) {
            return null;
        }
        if (!(drawable instanceof f0.a)) {
            return drawable;
        }
        return null;
    }

    public float getChipIconSize() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11643f0;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11642e0;
        }
        return null;
    }

    public float getChipMinHeight() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.W;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11656t0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.Y;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.Z;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getCloseIcon() {
        Drawable drawable;
        e eVar = this.f3725s;
        if (eVar == null || (drawable = eVar.f11645i0) == 0) {
            return null;
        }
        if (!(drawable instanceof f0.a)) {
            return drawable;
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11649m0;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11662z0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11648l0;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11661y0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11647k0;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.Y0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.G) {
            c cVar = this.F;
            if (cVar.f11153l == 1 || cVar.f11152k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public k8.b getHideMotionSpec() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11655s0;
        }
        return null;
    }

    public float getIconEndPadding() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11658v0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11657u0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11636a0;
        }
        return null;
    }

    public n getShapeAppearanceModel() {
        return this.f3725s.f4277p.f4259a;
    }

    public k8.b getShowMotionSpec() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11654r0;
        }
        return null;
    }

    public float getTextEndPadding() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11660x0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        e eVar = this.f3725s;
        if (eVar != null) {
            return eVar.f11659w0;
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j1.c.q(this, this.f3725s);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, L);
        }
        e eVar = this.f3725s;
        if (eVar != null && eVar.f11650n0) {
            View.mergeDrawableStates(onCreateDrawableState, M);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.G) {
            c cVar = this.F;
            int i11 = cVar.f11153l;
            if (i11 != Integer.MIN_VALUE) {
                cVar.j(i11);
            }
            if (z10) {
                cVar.m(i10, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        e eVar = this.f3725s;
        accessibilityNodeInfo.setCheckable(eVar != null && eVar.f11650n0);
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i10) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i10);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.C != i10) {
            this.C = i10;
            f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L4a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.f3731y
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L51
        L2c:
            boolean r0 = r5.f3731y
            if (r0 == 0) goto L45
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.f3728v
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.G
            if (r0 == 0) goto L43
            s8.c r0 = r5.F
            r0.r(r2, r2)
        L43:
            r0 = r2
            goto L46
        L45:
            r0 = r3
        L46:
            r5.setCloseIconPressed(r3)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r2)
            goto L2a
        L50:
            r0 = r3
        L51:
            if (r0 != 0) goto L5b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            return r3
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.E = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f3727u) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // m.p, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f3727u) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // m.p, android.view.View
    public void setBackgroundResource(int i10) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.C(z10);
        }
    }

    public void setCheckableResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.C(eVar.B0.getResources().getBoolean(i10));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        e eVar = this.f3725s;
        if (eVar == null) {
            this.f3730x = z10;
        } else if (eVar.f11650n0) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.D(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.D(n4.a.o(eVar.B0, i10));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.E(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.E(n4.a.n(eVar.B0, i10));
        }
    }

    public void setCheckedIconVisible(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.F(eVar.B0.getResources().getBoolean(i10));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        e eVar = this.f3725s;
        if (eVar == null || eVar.V == colorStateList) {
            return;
        }
        eVar.V = colorStateList;
        eVar.onStateChange(eVar.getState());
    }

    public void setChipBackgroundColorResource(int i10) {
        ColorStateList n10;
        e eVar = this.f3725s;
        if (eVar == null || eVar.V == (n10 = n4.a.n(eVar.B0, i10))) {
            return;
        }
        eVar.V = n10;
        eVar.onStateChange(eVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.G(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.G(eVar.B0.getResources().getDimension(i10));
        }
    }

    public void setChipDrawable(e eVar) {
        e eVar2 = this.f3725s;
        if (eVar2 != eVar) {
            if (eVar2 != null) {
                eVar2.X0 = new WeakReference(null);
            }
            this.f3725s = eVar;
            eVar.Z0 = false;
            eVar.X0 = new WeakReference(this);
            b(this.D);
        }
    }

    public void setChipEndPadding(float f10) {
        e eVar = this.f3725s;
        if (eVar == null || eVar.A0 == f10) {
            return;
        }
        eVar.A0 = f10;
        eVar.invalidateSelf();
        eVar.A();
    }

    public void setChipEndPaddingResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            float dimension = eVar.B0.getResources().getDimension(i10);
            if (eVar.A0 != dimension) {
                eVar.A0 = dimension;
                eVar.invalidateSelf();
                eVar.A();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.H(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.H(n4.a.o(eVar.B0, i10));
        }
    }

    public void setChipIconSize(float f10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.I(f10);
        }
    }

    public void setChipIconSizeResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.I(eVar.B0.getResources().getDimension(i10));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.J(colorStateList);
        }
    }

    public void setChipIconTintResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.J(n4.a.n(eVar.B0, i10));
        }
    }

    public void setChipIconVisible(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.K(eVar.B0.getResources().getBoolean(i10));
        }
    }

    public void setChipMinHeight(float f10) {
        e eVar = this.f3725s;
        if (eVar == null || eVar.W == f10) {
            return;
        }
        eVar.W = f10;
        eVar.invalidateSelf();
        eVar.A();
    }

    public void setChipMinHeightResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            float dimension = eVar.B0.getResources().getDimension(i10);
            if (eVar.W != dimension) {
                eVar.W = dimension;
                eVar.invalidateSelf();
                eVar.A();
            }
        }
    }

    public void setChipStartPadding(float f10) {
        e eVar = this.f3725s;
        if (eVar == null || eVar.f11656t0 == f10) {
            return;
        }
        eVar.f11656t0 = f10;
        eVar.invalidateSelf();
        eVar.A();
    }

    public void setChipStartPaddingResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            float dimension = eVar.B0.getResources().getDimension(i10);
            if (eVar.f11656t0 != dimension) {
                eVar.f11656t0 = dimension;
                eVar.invalidateSelf();
                eVar.A();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.L(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.L(n4.a.n(eVar.B0, i10));
        }
    }

    public void setChipStrokeWidth(float f10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.M(f10);
        }
    }

    public void setChipStrokeWidthResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.M(eVar.B0.getResources().getDimension(i10));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(Drawable drawable) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.N(drawable);
        }
        d();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        e eVar = this.f3725s;
        if (eVar == null || eVar.f11649m0 == charSequence) {
            return;
        }
        String str = k0.b.f7584b;
        k0.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? k0.b.f7587e : k0.b.f7586d;
        bVar.getClass();
        ea.a aVar = g.f7594a;
        eVar.f11649m0 = bVar.c(charSequence);
        eVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.O(f10);
        }
    }

    public void setCloseIconEndPaddingResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.O(eVar.B0.getResources().getDimension(i10));
        }
    }

    public void setCloseIconResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.N(n4.a.o(eVar.B0, i10));
        }
        d();
    }

    public void setCloseIconSize(float f10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.P(f10);
        }
    }

    public void setCloseIconSizeResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.P(eVar.B0.getResources().getDimension(i10));
        }
    }

    public void setCloseIconStartPadding(float f10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.Q(f10);
        }
    }

    public void setCloseIconStartPaddingResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.Q(eVar.B0.getResources().getDimension(i10));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.S(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.S(n4.a.n(eVar.B0, i10));
        }
    }

    public void setCloseIconVisible(int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    @Override // m.p, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // m.p, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.m(f10);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f3725s == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.Y0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.B = z10;
        b(this.D);
    }

    @Override // android.widget.TextView
    public void setGravity(int i10) {
        if (i10 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(k8.b bVar) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.f11655s0 = bVar;
        }
    }

    public void setHideMotionSpecResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.f11655s0 = k8.b.a(eVar.B0, i10);
        }
    }

    public void setIconEndPadding(float f10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.U(f10);
        }
    }

    public void setIconEndPaddingResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.U(eVar.B0.getResources().getDimension(i10));
        }
    }

    public void setIconStartPadding(float f10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.V(f10);
        }
    }

    public void setIconStartPaddingResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.V(eVar.B0.getResources().getDimension(i10));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        if (this.f3725s == null) {
            return;
        }
        super.setLayoutDirection(i10);
    }

    @Override // android.widget.TextView
    public void setLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i10) {
        super.setMaxWidth(i10);
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.f11637a1 = i10;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i10);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f3729w = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f3728v = onClickListener;
        d();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.W(colorStateList);
        }
        this.f3725s.getClass();
        e();
    }

    public void setRippleColorResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.W(n4.a.n(eVar.B0, i10));
            this.f3725s.getClass();
            e();
        }
    }

    @Override // d9.y
    public void setShapeAppearanceModel(n nVar) {
        this.f3725s.setShapeAppearanceModel(nVar);
    }

    public void setShowMotionSpec(k8.b bVar) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.f11654r0 = bVar;
        }
    }

    public void setShowMotionSpecResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.f11654r0 = k8.b.a(eVar.B0, i10);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z10) {
        if (!z10) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z10);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        e eVar = this.f3725s;
        if (eVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        super.setText(eVar.Z0 ? null : charSequence, bufferType);
        e eVar2 = this.f3725s;
        if (eVar2 == null || TextUtils.equals(eVar2.f11638b0, charSequence)) {
            return;
        }
        eVar2.f11638b0 = charSequence;
        eVar2.H0.f13740d = true;
        eVar2.invalidateSelf();
        eVar2.A();
    }

    public void setTextAppearance(a9.d dVar) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.X(dVar);
        }
        g();
    }

    public void setTextAppearanceResource(int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        e eVar = this.f3725s;
        if (eVar == null || eVar.f11660x0 == f10) {
            return;
        }
        eVar.f11660x0 = f10;
        eVar.invalidateSelf();
        eVar.A();
    }

    public void setTextEndPaddingResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            float dimension = eVar.B0.getResources().getDimension(i10);
            if (eVar.f11660x0 != dimension) {
                eVar.f11660x0 = dimension;
                eVar.invalidateSelf();
                eVar.A();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        e eVar = this.f3725s;
        if (eVar != null) {
            float applyDimension = TypedValue.applyDimension(i10, f10, getResources().getDisplayMetrics());
            i iVar = eVar.H0;
            a9.d dVar = iVar.f13742f;
            if (dVar != null) {
                dVar.f170l = applyDimension;
                iVar.f13737a.setTextSize(applyDimension);
                eVar.A();
                eVar.invalidateSelf();
            }
        }
        g();
    }

    public void setTextStartPadding(float f10) {
        e eVar = this.f3725s;
        if (eVar == null || eVar.f11659w0 == f10) {
            return;
        }
        eVar.f11659w0 = f10;
        eVar.invalidateSelf();
        eVar.A();
    }

    public void setTextStartPaddingResource(int i10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            float dimension = eVar.B0.getResources().getDimension(i10);
            if (eVar.f11659w0 != dimension) {
                eVar.f11659w0 = dimension;
                eVar.invalidateSelf();
                eVar.A();
            }
        }
    }

    public void setCloseIconVisible(boolean z10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.T(z10);
        }
        d();
    }

    public void setCheckedIconVisible(boolean z10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.F(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.K(z10);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.X(new a9.d(eVar.B0, i10));
        }
        g();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        e eVar = this.f3725s;
        if (eVar != null) {
            eVar.X(new a9.d(eVar.B0, i10));
        }
        g();
    }

    public void setInternalOnCheckedChangeListener(x8.e eVar) {
    }
}
