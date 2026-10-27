package r8;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import com.bumptech.glide.e;
import g9.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m.p;
import m4.d;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends p {
    public static final int[] M = {R.attr.state_indeterminate};
    public static final int[] N = {R.attr.state_error};
    public static final int[][] O = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public static final int P = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    public Drawable A;
    public boolean B;
    public ColorStateList C;
    public ColorStateList D;
    public PorterDuff.Mode E;
    public int F;
    public int[] G;
    public boolean H;
    public CharSequence I;
    public CompoundButton.OnCheckedChangeListener J;
    public final d K;
    public final a L;

    /* renamed from: s, reason: collision with root package name */
    public final LinkedHashSet f10969s;

    /* renamed from: t, reason: collision with root package name */
    public final LinkedHashSet f10970t;

    /* renamed from: u, reason: collision with root package name */
    public ColorStateList f10971u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f10972v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f10973w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10974x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f10975y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f10976z;

    /* JADX WARN: Removed duplicated region for block: B:13:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r8.c.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private String getButtonStateDescription() {
        int i10 = this.F;
        return i10 == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i10 == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f10971u == null) {
            int l10 = e.l(this, R.attr.colorControlActivated);
            int l11 = e.l(this, R.attr.colorError);
            int l12 = e.l(this, R.attr.colorSurface);
            int l13 = e.l(this, R.attr.colorOnSurface);
            this.f10971u = new ColorStateList(O, new int[]{e.p(1.0f, l12, l11), e.p(1.0f, l12, l10), e.p(0.54f, l12, l13), e.p(0.38f, l12, l13), e.p(0.38f, l12, l13)});
        }
        return this.f10971u;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.C;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        l lVar;
        Drawable drawable = this.f10976z;
        ColorStateList colorStateList3 = this.C;
        PorterDuff.Mode buttonTintMode = getButtonTintMode();
        if (drawable == null) {
            drawable = null;
        } else if (colorStateList3 != null) {
            drawable = drawable.mutate();
            if (buttonTintMode != null) {
                drawable.setTintMode(buttonTintMode);
            }
        }
        this.f10976z = drawable;
        Drawable drawable2 = this.A;
        ColorStateList colorStateList4 = this.D;
        PorterDuff.Mode mode = this.E;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (colorStateList4 != null) {
            drawable2 = drawable2.mutate();
            if (mode != null) {
                drawable2.setTintMode(mode);
            }
        }
        this.A = drawable2;
        if (this.B) {
            d dVar = this.K;
            if (dVar != null) {
                m4.c cVar = dVar.f8883p;
                Drawable drawable3 = dVar.f8890o;
                a aVar = this.L;
                if (drawable3 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable3;
                    if (aVar.f10966a == null) {
                        aVar.f10966a = new m4.b(aVar);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(aVar.f10966a);
                }
                ArrayList arrayList = dVar.f8886s;
                if (arrayList != null && aVar != null) {
                    arrayList.remove(aVar);
                    if (dVar.f8886s.size() == 0 && (lVar = dVar.f8885r) != null) {
                        cVar.f8879b.removeListener(lVar);
                        dVar.f8885r = null;
                    }
                }
                Drawable drawable4 = dVar.f8890o;
                if (drawable4 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable4;
                    if (aVar.f10966a == null) {
                        aVar.f10966a = new m4.b(aVar);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar.f10966a);
                } else if (aVar != null) {
                    if (dVar.f8886s == null) {
                        dVar.f8886s = new ArrayList();
                    }
                    if (!dVar.f8886s.contains(aVar)) {
                        dVar.f8886s.add(aVar);
                        if (dVar.f8885r == null) {
                            dVar.f8885r = new l(3, dVar);
                        }
                        cVar.f8879b.addListener(dVar.f8885r);
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable5 = this.f10976z;
                if ((drawable5 instanceof AnimatedStateListDrawable) && dVar != null) {
                    ((AnimatedStateListDrawable) drawable5).addTransition(R.id.checked, R.id.unchecked, dVar, false);
                    ((AnimatedStateListDrawable) this.f10976z).addTransition(R.id.indeterminate, R.id.unchecked, dVar, false);
                }
            }
        }
        Drawable drawable6 = this.f10976z;
        if (drawable6 != null && (colorStateList2 = this.C) != null) {
            drawable6.setTintList(colorStateList2);
        }
        Drawable drawable7 = this.A;
        if (drawable7 != null && (colorStateList = this.D) != null) {
            drawable7.setTintList(colorStateList);
        }
        Drawable drawable8 = this.f10976z;
        Drawable drawable9 = this.A;
        if (drawable8 == null) {
            drawable8 = drawable9;
        } else if (drawable9 != null) {
            int intrinsicWidth = drawable9.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable8.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable9.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable8.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable8.getIntrinsicWidth() || intrinsicHeight > drawable8.getIntrinsicHeight()) {
                float f10 = intrinsicWidth / intrinsicHeight;
                if (f10 >= drawable8.getIntrinsicWidth() / drawable8.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable8.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f10);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable8.getIntrinsicHeight();
                    intrinsicWidth = (int) (f10 * intrinsicHeight);
                }
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable8, drawable9});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable8 = layerDrawable;
        }
        super.setButtonDrawable(drawable8);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f10976z;
    }

    public Drawable getButtonIconDrawable() {
        return this.A;
    }

    public ColorStateList getButtonIconTintList() {
        return this.D;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.E;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.C;
    }

    public int getCheckedState() {
        return this.F;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f10975y;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.F == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f10972v && this.C == null && this.D == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] copyOf;
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, M);
        }
        if (this.f10974x) {
            View.mergeDrawableStates(onCreateDrawableState, N);
        }
        int i11 = 0;
        while (true) {
            if (i11 >= onCreateDrawableState.length) {
                copyOf = Arrays.copyOf(onCreateDrawableState, onCreateDrawableState.length + 1);
                copyOf[onCreateDrawableState.length] = 16842912;
                break;
            }
            int i12 = onCreateDrawableState[i11];
            if (i12 == 16842912) {
                copyOf = onCreateDrawableState;
                break;
            }
            if (i12 == 0) {
                copyOf = (int[]) onCreateDrawableState.clone();
                copyOf[i11] = 16842912;
                break;
            }
            i11++;
        }
        this.G = copyOf;
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.f10973w || !TextUtils.isEmpty(getText()) || (buttonDrawable = getButtonDrawable()) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (getLayoutDirection() == 1 ? -1 : 1);
        int save = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f10974x) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f10975y));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCheckedState(bVar.f10968o);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f10968o = getCheckedState();
        return bVar;
    }

    @Override // m.p, android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(n4.a.o(getContext(), i10));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.A = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i10) {
        setButtonIconDrawable(n4.a.o(getContext(), i10));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.D == colorStateList) {
            return;
        }
        this.D = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.E == mode) {
            return;
        }
        this.E = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.C == colorStateList) {
            return;
        }
        this.C = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f10973w = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.F != i10) {
            this.F = i10;
            super.setChecked(i10 == 1);
            refreshDrawableState();
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30 && this.I == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.H) {
                return;
            }
            this.H = true;
            LinkedHashSet linkedHashSet = this.f10970t;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw android.support.v4.media.d.l(it);
                }
            }
            if (this.F != 2 && (onCheckedChangeListener = this.J) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (i11 >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.H = false;
        }
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f10975y = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i10) {
        setErrorAccessibilityLabel(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f10974x == z10) {
            return;
        }
        this.f10974x = z10;
        refreshDrawableState();
        Iterator it = this.f10969s.iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.d.l(it);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.J = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.I = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f10972v = z10;
        if (z10) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // m.p, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f10976z = drawable;
        this.B = false;
        a();
    }
}
