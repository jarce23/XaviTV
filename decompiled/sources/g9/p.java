package g9;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.o0;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m.w0;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p extends LinearLayout {
    public int A;
    public ImageView.ScaleType B;
    public View.OnLongClickListener C;
    public CharSequence D;
    public final w0 E;
    public boolean F;
    public EditText G;
    public final AccessibilityManager H;
    public AccessibilityManager.TouchExplorationStateChangeListener I;
    public final n J;

    /* renamed from: o, reason: collision with root package name */
    public final TextInputLayout f5366o;

    /* renamed from: p, reason: collision with root package name */
    public final FrameLayout f5367p;

    /* renamed from: q, reason: collision with root package name */
    public final CheckableImageButton f5368q;

    /* renamed from: r, reason: collision with root package name */
    public ColorStateList f5369r;

    /* renamed from: s, reason: collision with root package name */
    public PorterDuff.Mode f5370s;

    /* renamed from: t, reason: collision with root package name */
    public View.OnLongClickListener f5371t;

    /* renamed from: u, reason: collision with root package name */
    public final CheckableImageButton f5372u;

    /* renamed from: v, reason: collision with root package name */
    public final app.shamel.tv.activities.v f5373v;

    /* renamed from: w, reason: collision with root package name */
    public int f5374w;

    /* renamed from: x, reason: collision with root package name */
    public final LinkedHashSet f5375x;

    /* renamed from: y, reason: collision with root package name */
    public ColorStateList f5376y;

    /* renamed from: z, reason: collision with root package name */
    public PorterDuff.Mode f5377z;

    public p(TextInputLayout textInputLayout, android.support.v4.media.session.a0 a0Var) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.f5374w = 0;
        this.f5375x = new LinkedHashSet();
        this.J = new n(this);
        o oVar = new o(this);
        this.H = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f5366o = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f5367p = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton a10 = a(this, from, R.id.text_input_error_icon);
        this.f5368q = a10;
        CheckableImageButton a11 = a(frameLayout, from, R.id.text_input_end_icon);
        this.f5372u = a11;
        this.f5373v = new app.shamel.tv.activities.v(this, a0Var);
        w0 w0Var = new w0(getContext(), null);
        this.E = w0Var;
        TypedArray typedArray = (TypedArray) a0Var.f231q;
        if (typedArray.hasValue(38)) {
            this.f5369r = com.bumptech.glide.d.m(getContext(), a0Var, 38);
        }
        if (typedArray.hasValue(39)) {
            this.f5370s = x8.k.f(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(a0Var.K(37));
        }
        a10.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        a10.setImportantForAccessibility(2);
        a10.setClickable(false);
        a10.setPressable(false);
        a10.setCheckable(false);
        a10.setFocusable(false);
        if (!typedArray.hasValue(54)) {
            if (typedArray.hasValue(32)) {
                this.f5376y = com.bumptech.glide.d.m(getContext(), a0Var, 32);
            }
            if (typedArray.hasValue(33)) {
                this.f5377z = x8.k.f(typedArray.getInt(33, -1), null);
            }
        }
        if (typedArray.hasValue(30)) {
            g(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && a11.getContentDescription() != (text = typedArray.getText(27))) {
                a11.setContentDescription(text);
            }
            a11.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(54)) {
            if (typedArray.hasValue(55)) {
                this.f5376y = com.bumptech.glide.d.m(getContext(), a0Var, 55);
            }
            if (typedArray.hasValue(56)) {
                this.f5377z = x8.k.f(typedArray.getInt(56, -1), null);
            }
            g(typedArray.getBoolean(54, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(52);
            if (a11.getContentDescription() != text2) {
                a11.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.A) {
            this.A = dimensionPixelSize;
            a11.setMinimumWidth(dimensionPixelSize);
            a11.setMinimumHeight(dimensionPixelSize);
            a10.setMinimumWidth(dimensionPixelSize);
            a10.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType i10 = a.a.i(typedArray.getInt(31, -1));
            this.B = i10;
            a11.setScaleType(i10);
            a10.setScaleType(i10);
        }
        w0Var.setVisibility(8);
        w0Var.setId(R.id.textinput_suffix_text);
        w0Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        w0Var.setAccessibilityLiveRegion(1);
        w0Var.setTextAppearance(typedArray.getResourceId(73, 0));
        if (typedArray.hasValue(74)) {
            w0Var.setTextColor(a0Var.J(74));
        }
        CharSequence text3 = typedArray.getText(72);
        this.D = TextUtils.isEmpty(text3) ? null : text3;
        w0Var.setText(text3);
        n();
        frameLayout.addView(a11);
        addView(w0Var);
        addView(frameLayout);
        addView(a10);
        textInputLayout.f3867t0.add(oVar);
        if (textInputLayout.f3864s != null) {
            oVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new o0(1, this));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i10) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i10);
        if (com.bumptech.glide.d.y(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final q b() {
        q eVar;
        int i10 = this.f5374w;
        app.shamel.tv.activities.v vVar = this.f5373v;
        SparseArray sparseArray = (SparseArray) vVar.f2063r;
        q qVar = (q) sparseArray.get(i10);
        if (qVar != null) {
            return qVar;
        }
        p pVar = (p) vVar.f2064s;
        if (i10 == -1) {
            eVar = new e(pVar, 0);
        } else if (i10 == 0) {
            eVar = new e(pVar, 1);
        } else if (i10 == 1) {
            eVar = new x(pVar, vVar.f2062q);
        } else if (i10 == 2) {
            eVar = new d(pVar);
        } else {
            if (i10 != 3) {
                throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Invalid end icon mode: "));
            }
            eVar = new m(pVar);
        }
        sparseArray.append(i10, eVar);
        return eVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.f5372u;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return this.E.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.f5367p.getVisibility() == 0 && this.f5372u.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f5368q.getVisibility() == 0;
    }

    public final void f(boolean z10) {
        boolean z11;
        boolean isActivated;
        boolean z12;
        q b2 = b();
        boolean j10 = b2.j();
        CheckableImageButton checkableImageButton = this.f5372u;
        boolean z13 = true;
        if (!j10 || (z12 = checkableImageButton.f3811r) == b2.k()) {
            z11 = false;
        } else {
            checkableImageButton.setChecked(!z12);
            z11 = true;
        }
        if (!(b2 instanceof m) || (isActivated = checkableImageButton.isActivated()) == ((m) b2).f5357l) {
            z13 = z11;
        } else {
            checkableImageButton.setActivated(!isActivated);
        }
        if (z10 || z13) {
            a.a.s(this.f5366o, checkableImageButton, this.f5376y);
        }
    }

    public final void g(int i10) {
        if (this.f5374w == i10) {
            return;
        }
        q b2 = b();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.I;
        AccessibilityManager accessibilityManager = this.H;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.I = null;
        b2.r();
        this.f5374w = i10;
        Iterator it = this.f5375x.iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.d.l(it);
        }
        h(i10 != 0);
        q b10 = b();
        int i11 = this.f5373v.f2061p;
        if (i11 == 0) {
            i11 = b10.d();
        }
        Drawable o2 = i11 != 0 ? n4.a.o(getContext(), i11) : null;
        CheckableImageButton checkableImageButton = this.f5372u;
        checkableImageButton.setImageDrawable(o2);
        TextInputLayout textInputLayout = this.f5366o;
        if (o2 != null) {
            a.a.a(textInputLayout, checkableImageButton, this.f5376y, this.f5377z);
            a.a.s(textInputLayout, checkableImageButton, this.f5376y);
        }
        int c10 = b10.c();
        CharSequence text = c10 != 0 ? getResources().getText(c10) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(b10.j());
        if (!b10.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i10);
        }
        b10.q();
        AccessibilityManager.TouchExplorationStateChangeListener h10 = b10.h();
        this.I = h10;
        if (h10 != null && accessibilityManager != null && isAttachedToWindow()) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.I);
        }
        View.OnClickListener f10 = b10.f();
        View.OnLongClickListener onLongClickListener = this.C;
        checkableImageButton.setOnClickListener(f10);
        a.a.t(checkableImageButton, onLongClickListener);
        EditText editText = this.G;
        if (editText != null) {
            b10.l(editText);
            j(b10);
        }
        a.a.a(textInputLayout, checkableImageButton, this.f5376y, this.f5377z);
        f(true);
    }

    public final void h(boolean z10) {
        if (d() != z10) {
            this.f5372u.setVisibility(z10 ? 0 : 8);
            k();
            m();
            this.f5366o.s();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f5368q;
        checkableImageButton.setImageDrawable(drawable);
        l();
        a.a.a(this.f5366o, checkableImageButton, this.f5369r, this.f5370s);
    }

    public final void j(q qVar) {
        if (this.G == null) {
            return;
        }
        if (qVar.e() != null) {
            this.G.setOnFocusChangeListener(qVar.e());
        }
        if (qVar.g() != null) {
            this.f5372u.setOnFocusChangeListener(qVar.g());
        }
    }

    public final void k() {
        this.f5367p.setVisibility((this.f5372u.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || !((this.D == null || this.F) ? 8 : false)) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f5368q;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f5366o;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.f3876y.f5404q && textInputLayout.o()) ? 0 : 8);
        k();
        m();
        if (this.f5374w != 0) {
            return;
        }
        textInputLayout.s();
    }

    public final void m() {
        TextInputLayout textInputLayout = this.f5366o;
        if (textInputLayout.f3864s == null) {
            return;
        }
        this.E.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.f3864s.getPaddingTop(), (d() || e()) ? 0 : textInputLayout.f3864s.getPaddingEnd(), textInputLayout.f3864s.getPaddingBottom());
    }

    public final void n() {
        w0 w0Var = this.E;
        int visibility = w0Var.getVisibility();
        int i10 = (this.D == null || this.F) ? 8 : 0;
        if (visibility != i10) {
            b().o(i10 == 0);
        }
        k();
        w0Var.setVisibility(i10);
        this.f5366o.s();
    }
}
