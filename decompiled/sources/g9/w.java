package g9;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Locale;
import m.z1;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w extends m.o {

    /* renamed from: s, reason: collision with root package name */
    public final z1 f5419s;

    /* renamed from: t, reason: collision with root package name */
    public final AccessibilityManager f5420t;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f5421u;

    /* renamed from: v, reason: collision with root package name */
    public final int f5422v;

    /* renamed from: w, reason: collision with root package name */
    public final float f5423w;

    /* renamed from: x, reason: collision with root package name */
    public ColorStateList f5424x;

    /* renamed from: y, reason: collision with root package name */
    public int f5425y;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f5426z;

    public w(Context context, AttributeSet attributeSet) {
        super(i9.a.a(context, attributeSet, R.attr.autoCompleteTextViewStyle, 0), attributeSet);
        this.f5421u = new Rect();
        Context context2 = getContext();
        TypedArray e7 = x8.k.e(context2, attributeSet, j8.a.f7188i, R.attr.autoCompleteTextViewStyle, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (e7.hasValue(0) && e7.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.f5422v = e7.getResourceId(3, R.layout.mtrl_auto_complete_simple_item);
        this.f5423w = e7.getDimensionPixelOffset(1, R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (e7.hasValue(2)) {
            this.f5424x = ColorStateList.valueOf(e7.getColor(2, 0));
        }
        this.f5425y = e7.getColor(4, 0);
        this.f5426z = com.bumptech.glide.d.l(context2, e7, 5);
        this.f5420t = (AccessibilityManager) context2.getSystemService("accessibility");
        z1 z1Var = new z1(context2, null, R.attr.listPopupWindowStyle, 0);
        this.f5419s = z1Var;
        z1Var.M = true;
        z1Var.N.setFocusable(true);
        z1Var.C = this;
        z1Var.N.setInputMethodMode(2);
        z1Var.o(getAdapter());
        z1Var.D = new u(0, this);
        if (e7.hasValue(6)) {
            setSimpleItems(e7.getResourceId(6, 0));
        }
        e7.recycle();
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean c() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f5420t;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16)) == null) {
            return false;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
            if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        if (c()) {
            this.f5419s.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f5424x;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout b2 = b();
        return (b2 == null || !b2.T) ? super.getHint() : b2.getHint();
    }

    public float getPopupElevation() {
        return this.f5423w;
    }

    public int getSimpleItemSelectedColor() {
        return this.f5425y;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f5426z;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout b2 = b();
        if (b2 != null && b2.T && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : _UrlKt.FRAGMENT_ENCODE_SET).equals("meizu")) {
                setHint(_UrlKt.FRAGMENT_ENCODE_SET);
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5419s.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b2 = b();
            int i12 = 0;
            if (adapter != null && b2 != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                z1 z1Var = this.f5419s;
                int min = Math.min(adapter.getCount(), Math.max(0, !z1Var.N.isShowing() ? -1 : z1Var.f8611q.getSelectedItemPosition()) + 15);
                View view = null;
                int i13 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i12) {
                        view = null;
                        i12 = itemViewType;
                    }
                    view = adapter.getView(max, view, b2);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i13 = Math.max(i13, view.getMeasuredWidth());
                }
                Drawable background = z1Var.N.getBackground();
                if (background != null) {
                    Rect rect = this.f5421u;
                    background.getPadding(rect);
                    i13 += rect.left + rect.right;
                }
                i12 = b2.getEndIconView().getMeasuredWidth() + i13;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i12), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        if (c()) {
            return;
        }
        super.onWindowFocusChanged(z10);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t3) {
        super.setAdapter(t3);
        this.f5419s.o(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        z1 z1Var = this.f5419s;
        if (z1Var != null) {
            z1Var.g(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i10) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i10));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f5424x = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof d9.j) {
            ((d9.j) dropDownBackground).n(this.f5424x);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f5419s.E = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        TextInputLayout b2 = b();
        if (b2 != null) {
            b2.u();
        }
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f5425y = i10;
        if (getAdapter() instanceof v) {
            ((v) getAdapter()).a();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f5426z = colorStateList;
        if (getAdapter() instanceof v) {
            ((v) getAdapter()).a();
        }
    }

    public void setSimpleItems(int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        if (c()) {
            this.f5419s.c();
        } else {
            super.showDropDown();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new v(this, getContext(), this.f5422v, strArr));
    }
}
