package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.session.a0;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.l;
import androidx.leanback.widget.z;
import com.bumptech.glide.d;
import j.a;
import java.util.WeakHashMap;
import m.h3;
import m.i1;
import m.m2;
import m.n2;
import m.s0;
import m.t;
import m0.k0;
import m0.x;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: i0, reason: collision with root package name */
    public static final z f447i0 = new z(Float.class, "thumbPos", 11);

    /* renamed from: j0, reason: collision with root package name */
    public static final int[] f448j0 = {R.attr.state_checked};
    public int A;
    public boolean B;
    public CharSequence C;
    public CharSequence D;
    public CharSequence E;
    public CharSequence F;
    public boolean G;
    public int H;
    public final int I;
    public float J;
    public float K;
    public final VelocityTracker L;
    public final int M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public final TextPaint W;

    /* renamed from: a0, reason: collision with root package name */
    public final ColorStateList f449a0;

    /* renamed from: b0, reason: collision with root package name */
    public StaticLayout f450b0;

    /* renamed from: c0, reason: collision with root package name */
    public StaticLayout f451c0;

    /* renamed from: d0, reason: collision with root package name */
    public final a f452d0;

    /* renamed from: e0, reason: collision with root package name */
    public ObjectAnimator f453e0;

    /* renamed from: f0, reason: collision with root package name */
    public t f454f0;

    /* renamed from: g0, reason: collision with root package name */
    public m2 f455g0;
    public final Rect h0;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f456o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f457p;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f458q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f459r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f460s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f461t;

    /* renamed from: u, reason: collision with root package name */
    public ColorStateList f462u;

    /* renamed from: v, reason: collision with root package name */
    public PorterDuff.Mode f463v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f464w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f465x;

    /* renamed from: y, reason: collision with root package name */
    public int f466y;

    /* renamed from: z, reason: collision with root package name */
    public int f467z;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, org.chromium.net.R.attr.switchStyle);
        int resourceId;
        this.f457p = null;
        this.f458q = null;
        this.f459r = false;
        this.f460s = false;
        this.f462u = null;
        this.f463v = null;
        this.f464w = false;
        this.f465x = false;
        this.L = VelocityTracker.obtain();
        this.V = true;
        this.h0 = new Rect();
        n2.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.W = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = e.a.f4378v;
        a0 T = a0.T(context, attributeSet, iArr, org.chromium.net.R.attr.switchStyle);
        TypedArray typedArray = (TypedArray) T.f231q;
        k0.l(this, context, iArr, attributeSet, typedArray, org.chromium.net.R.attr.switchStyle);
        Drawable K = T.K(2);
        this.f456o = K;
        if (K != null) {
            K.setCallback(this);
        }
        Drawable K2 = T.K(11);
        this.f461t = K2;
        if (K2 != null) {
            K2.setCallback(this);
        }
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.G = typedArray.getBoolean(3, true);
        this.f466y = typedArray.getDimensionPixelSize(8, 0);
        this.f467z = typedArray.getDimensionPixelSize(5, 0);
        this.A = typedArray.getDimensionPixelSize(6, 0);
        this.B = typedArray.getBoolean(4, false);
        ColorStateList J = T.J(9);
        if (J != null) {
            this.f457p = J;
            this.f459r = true;
        }
        PorterDuff.Mode c10 = i1.c(typedArray.getInt(10, -1), null);
        if (this.f458q != c10) {
            this.f458q = c10;
            this.f460s = true;
        }
        if (this.f459r || this.f460s) {
            a();
        }
        ColorStateList J2 = T.J(12);
        if (J2 != null) {
            this.f462u = J2;
            this.f464w = true;
        }
        PorterDuff.Mode c11 = i1.c(typedArray.getInt(13, -1), null);
        if (this.f463v != c11) {
            this.f463v = c11;
            this.f465x = true;
        }
        if (this.f464w || this.f465x) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId2, e.a.f4379w);
            ColorStateList colorStateList = (!obtainStyledAttributes.hasValue(3) || (resourceId = obtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = n4.a.n(context, resourceId)) == null) ? obtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.f449a0 = colorStateList;
            } else {
                this.f449a0 = getTextColors();
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f10 = dimensionPixelSize;
                if (f10 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f10);
                    requestLayout();
                }
            }
            int i10 = obtainStyledAttributes.getInt(1, -1);
            int i11 = obtainStyledAttributes.getInt(2, -1);
            Typeface typeface = i10 != 1 ? i10 != 2 ? i10 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i11 > 0) {
                Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i11) : Typeface.create(typeface, i11);
                setSwitchTypeface(defaultFromStyle);
                int i12 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i11;
                textPaint.setFakeBoldText((i12 & 1) != 0);
                textPaint.setTextSkewX((2 & i12) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                a aVar = new a();
                aVar.f6901o = context2.getResources().getConfiguration().locale;
                this.f452d0 = aVar;
            } else {
                this.f452d0 = null;
            }
            setTextOnInternal(this.C);
            setTextOffInternal(this.E);
            obtainStyledAttributes.recycle();
        }
        new s0(this).f(attributeSet, org.chromium.net.R.attr.switchStyle);
        T.U();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.I = viewConfiguration.getScaledTouchSlop();
        this.M = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, org.chromium.net.R.attr.switchStyle);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private t getEmojiTextViewHelper() {
        if (this.f454f0 == null) {
            this.f454f0 = new t(this);
        }
        return this.f454f0;
    }

    private boolean getTargetCheckedState() {
        return this.N > 0.5f;
    }

    private int getThumbOffset() {
        boolean z10 = h3.f8433a;
        return (int) (((getLayoutDirection() == 1 ? 1.0f - this.N : this.N) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f461t;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.h0;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f456o;
        Rect b2 = drawable2 != null ? i1.b(drawable2) : i1.f8440c;
        return ((((this.O - this.Q) - rect.left) - rect.right) - b2.left) - b2.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.E = charSequence;
        TransformationMethod D = ((n4.a) getEmojiTextViewHelper().f8556b.f9953p).D(this.f452d0);
        if (D != null) {
            charSequence = D.getTransformation(charSequence, this);
        }
        this.F = charSequence;
        this.f451c0 = null;
        if (this.G) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.C = charSequence;
        TransformationMethod D = ((n4.a) getEmojiTextViewHelper().f8556b.f9953p).D(this.f452d0);
        if (D != null) {
            charSequence = D.getTransformation(charSequence, this);
        }
        this.D = charSequence;
        this.f450b0 = null;
        if (this.G) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f456o;
        if (drawable != null) {
            if (this.f459r || this.f460s) {
                Drawable mutate = drawable.mutate();
                this.f456o = mutate;
                if (this.f459r) {
                    mutate.setTintList(this.f457p);
                }
                if (this.f460s) {
                    this.f456o.setTintMode(this.f458q);
                }
                if (this.f456o.isStateful()) {
                    this.f456o.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f461t;
        if (drawable != null) {
            if (this.f464w || this.f465x) {
                Drawable mutate = drawable.mutate();
                this.f461t = mutate;
                if (this.f464w) {
                    mutate.setTintList(this.f462u);
                }
                if (this.f465x) {
                    this.f461t.setTintMode(this.f463v);
                }
                if (this.f461t.isStateful()) {
                    this.f461t.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.C);
        setTextOffInternal(this.E);
        requestLayout();
    }

    public final void d() {
        if (this.f455g0 == null && ((n4.a) this.f454f0.f8556b.f9953p).t() && l.f576k != null) {
            l a10 = l.a();
            int b2 = a10.b();
            if (b2 == 3 || b2 == 0) {
                m2 m2Var = new m2(this);
                this.f455g0 = m2Var;
                a10.f(m2Var);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i10;
        int i11;
        int i12 = this.R;
        int i13 = this.S;
        int i14 = this.T;
        int i15 = this.U;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f456o;
        Rect b2 = drawable != null ? i1.b(drawable) : i1.f8440c;
        Drawable drawable2 = this.f461t;
        Rect rect = this.h0;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i16 = rect.left;
            thumbOffset += i16;
            if (b2 != null) {
                int i17 = b2.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = b2.top;
                int i19 = rect.top;
                i10 = i18 > i19 ? (i18 - i19) + i13 : i13;
                int i20 = b2.right;
                int i21 = rect.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = b2.bottom;
                int i23 = rect.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                    this.f461t.setBounds(i12, i10, i14, i11);
                }
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.f461t.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f456o;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i24 = thumbOffset - rect.left;
            int i25 = thumbOffset + this.Q + rect.right;
            this.f456o.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f456o;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
        Drawable drawable2 = this.f461t;
        if (drawable2 != null) {
            drawable2.setHotspot(f10, f11);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f456o;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f461t;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        boolean z10 = h3.f8433a;
        if (getLayoutDirection() != 1) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.O;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.A : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        boolean z10 = h3.f8433a;
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.O;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.A : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d.K(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.G;
    }

    public boolean getSplitTrack() {
        return this.B;
    }

    public int getSwitchMinWidth() {
        return this.f467z;
    }

    public int getSwitchPadding() {
        return this.A;
    }

    public CharSequence getTextOff() {
        return this.E;
    }

    public CharSequence getTextOn() {
        return this.C;
    }

    public Drawable getThumbDrawable() {
        return this.f456o;
    }

    public final float getThumbPosition() {
        return this.N;
    }

    public int getThumbTextPadding() {
        return this.f466y;
    }

    public ColorStateList getThumbTintList() {
        return this.f457p;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f458q;
    }

    public Drawable getTrackDrawable() {
        return this.f461t;
    }

    public ColorStateList getTrackTintList() {
        return this.f462u;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f463v;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f456o;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f461t;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f453e0;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f453e0.end();
        this.f453e0 = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f448j0);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f461t;
        Rect rect = this.h0;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i10 = this.S;
        int i11 = this.U;
        int i12 = i10 + rect.top;
        int i13 = i11 - rect.bottom;
        Drawable drawable2 = this.f456o;
        if (drawable != null) {
            if (!this.B || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect b2 = i1.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += b2.left;
                rect.right -= b2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.f450b0 : this.f451c0;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.W;
            ColorStateList colorStateList = this.f449a0;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i12 + i13) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.C : this.E;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(text);
            sb2.append(' ');
            sb2.append(charSequence);
            accessibilityNodeInfo.setText(sb2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int width;
        int i15;
        int i16;
        int i17;
        super.onLayout(z10, i10, i11, i12, i13);
        int i18 = 0;
        if (this.f456o != null) {
            Drawable drawable = this.f461t;
            Rect rect = this.h0;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect b2 = i1.b(this.f456o);
            i14 = Math.max(0, b2.left - rect.left);
            i18 = Math.max(0, b2.right - rect.right);
        } else {
            i14 = 0;
        }
        boolean z11 = h3.f8433a;
        if (getLayoutDirection() == 1) {
            i15 = getPaddingLeft() + i14;
            width = ((this.O + i15) - i14) - i18;
        } else {
            width = (getWidth() - getPaddingRight()) - i18;
            i15 = (width - this.O) + i14 + i18;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i19 = this.P;
            int i20 = height - (i19 / 2);
            i16 = i19 + i20;
            i17 = i20;
        } else if (gravity != 80) {
            i17 = getPaddingTop();
            i16 = this.P + i17;
        } else {
            i16 = getHeight() - getPaddingBottom();
            i17 = i16 - this.P;
        }
        this.R = i15;
        this.S = i17;
        this.U = i16;
        this.T = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14 = 0;
        if (this.G) {
            StaticLayout staticLayout = this.f450b0;
            TextPaint textPaint = this.W;
            if (staticLayout == null) {
                CharSequence charSequence = this.D;
                this.f450b0 = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.f451c0 == null) {
                CharSequence charSequence2 = this.F;
                this.f451c0 = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f456o;
        Rect rect = this.h0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i12 = (this.f456o.getIntrinsicWidth() - rect.left) - rect.right;
            i13 = this.f456o.getIntrinsicHeight();
        } else {
            i12 = 0;
            i13 = 0;
        }
        this.Q = Math.max(this.G ? (this.f466y * 2) + Math.max(this.f450b0.getWidth(), this.f451c0.getWidth()) : 0, i12);
        Drawable drawable2 = this.f461t;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i14 = this.f461t.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i15 = rect.left;
        int i16 = rect.right;
        Drawable drawable3 = this.f456o;
        if (drawable3 != null) {
            Rect b2 = i1.b(drawable3);
            i15 = Math.max(i15, b2.left);
            i16 = Math.max(i16, b2.right);
        }
        int max = this.V ? Math.max(this.f467z, (this.Q * 2) + i15 + i16) : this.f467z;
        int max2 = Math.max(i14, i13);
        this.O = max;
        this.P = max2;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.C : this.E;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r1 != 3) goto L82;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        super.setChecked(z10);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object obj = this.C;
                if (obj == null) {
                    obj = getResources().getString(org.chromium.net.R.string.abc_capital_on);
                }
                Object obj2 = obj;
                WeakHashMap weakHashMap = k0.f8683a;
                new x(org.chromium.net.R.id.tag_state_description, CharSequence.class, 64, 30, 2).f(this, obj2);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object obj3 = this.E;
            if (obj3 == null) {
                obj3 = getResources().getString(org.chromium.net.R.string.abc_capital_off);
            }
            Object obj4 = obj3;
            WeakHashMap weakHashMap2 = k0.f8683a;
            new x(org.chromium.net.R.id.tag_state_description, CharSequence.class, 64, 30, 2).f(this, obj4);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.f453e0;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f447i0, isChecked ? 1.0f : 0.0f);
        this.f453e0 = ofFloat;
        ofFloat.setDuration(250L);
        this.f453e0.setAutoCancel(true);
        this.f453e0.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d.M(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
        setTextOnInternal(this.C);
        setTextOffInternal(this.E);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z10) {
        this.V = z10;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.G != z10) {
            this.G = z10;
            requestLayout();
            if (z10) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.B = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f467z = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.A = i10;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.W;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object obj = this.E;
        if (obj == null) {
            obj = getResources().getString(org.chromium.net.R.string.abc_capital_off);
        }
        WeakHashMap weakHashMap = k0.f8683a;
        new x(org.chromium.net.R.id.tag_state_description, CharSequence.class, 64, 30, 2).f(this, obj);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object obj = this.C;
        if (obj == null) {
            obj = getResources().getString(org.chromium.net.R.string.abc_capital_on);
        }
        WeakHashMap weakHashMap = k0.f8683a;
        new x(org.chromium.net.R.id.tag_state_description, CharSequence.class, 64, 30, 2).f(this, obj);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f456o;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f456o = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f10) {
        this.N = f10;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(n4.a.o(getContext(), i10));
    }

    public void setThumbTextPadding(int i10) {
        this.f466y = i10;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f457p = colorStateList;
        this.f459r = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f458q = mode;
        this.f460s = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f461t;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f461t = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(n4.a.o(getContext(), i10));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f462u = colorStateList;
        this.f464w = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f463v = mode;
        this.f465x = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f456o || drawable == this.f461t;
    }
}
