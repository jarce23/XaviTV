package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import j9.w1;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import m0.c0;
import m0.k0;
import m0.r1;
import m0.s1;
import m0.t1;
import m0.u1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class n<S> extends androidx.fragment.app.o {
    public u A0;
    public b B0;
    public l C0;
    public int D0;
    public CharSequence E0;
    public boolean F0;
    public int G0;
    public int H0;
    public CharSequence I0;
    public int J0;
    public CharSequence K0;
    public int L0;
    public CharSequence M0;
    public int N0;
    public CharSequence O0;
    public TextView P0;
    public CheckableImageButton Q0;
    public d9.j R0;
    public boolean S0;
    public CharSequence T0;
    public CharSequence U0;

    /* renamed from: x0, reason: collision with root package name */
    public final LinkedHashSet f3776x0;

    /* renamed from: y0, reason: collision with root package name */
    public final LinkedHashSet f3777y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f3778z0;

    public n() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.f3776x0 = new LinkedHashSet();
        this.f3777y0 = new LinkedHashSet();
    }

    public static int O(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar b2 = x.b();
        b2.set(5, 1);
        Calendar a10 = x.a(b2);
        a10.get(2);
        a10.get(1);
        int maximum = a10.getMaximum(7);
        a10.getActualMaximum(5);
        a10.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean P(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.bumptech.glide.c.z(R.attr.materialCalendarStyle, context, l.class.getCanonicalName()).data, new int[]{i10});
        boolean z10 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [m0.t1] */
    /* JADX WARN: Type inference failed for: r10v8, types: [m0.t1] */
    /* JADX WARN: Type inference failed for: r3v20, types: [m0.t1] */
    /* JADX WARN: Type inference failed for: r3v23, types: [m0.t1] */
    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void A() {
        WindowInsetsController insetsController;
        r1 r1Var;
        WindowInsetsController insetsController2;
        r1 r1Var2;
        WindowInsetsController insetsController3;
        WindowInsetsController insetsController4;
        super.A();
        Dialog dialog = this.f762s0;
        if (dialog == null) {
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        Window window = dialog.getWindow();
        if (this.F0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.R0);
            if (!this.S0) {
                View findViewById = F().findViewById(R.id.fullscreen_header);
                ColorStateList k10 = com.bumptech.glide.c.k(findViewById.getBackground());
                Integer valueOf = k10 != null ? Integer.valueOf(k10.getDefaultColor()) : null;
                boolean z10 = valueOf == null || valueOf.intValue() == 0;
                int k11 = com.bumptech.glide.e.k(window.getContext(), android.R.attr.colorBackground, -16777216);
                if (z10) {
                    valueOf = Integer.valueOf(k11);
                }
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 35) {
                    c0.c.e(window, false);
                } else if (i10 >= 30) {
                    c0.c.d(window, false);
                } else {
                    View decorView = window.getDecorView();
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
                }
                window.getContext();
                int h10 = i10 < 27 ? e0.a.h(com.bumptech.glide.e.k(window.getContext(), android.R.attr.navigationBarColor, -16777216), 128) : 0;
                window.setStatusBarColor(0);
                window.setNavigationBarColor(h10);
                int intValue = valueOf.intValue();
                boolean z11 = intValue != 0 && e0.a.d(intValue) > 0.5d;
                w1 w1Var = new w1(window.getDecorView());
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 35) {
                    insetsController4 = window.getInsetsController();
                    ?? u1Var = new u1(insetsController4, w1Var);
                    u1Var.f8721e = window;
                    r1Var = u1Var;
                } else if (i11 >= 30) {
                    insetsController = window.getInsetsController();
                    ?? t1Var = new t1(insetsController, w1Var);
                    t1Var.f8721e = window;
                    r1Var = t1Var;
                } else {
                    r1Var = i11 >= 26 ? new s1(window, w1Var) : new r1(window, w1Var);
                }
                r1Var.n(z11);
                boolean z12 = (h10 != 0 && e0.a.d(h10) > 0.5d) || (h10 == 0 && (k11 != 0 && (e0.a.d(k11) > 0.5d ? 1 : (e0.a.d(k11) == 0.5d ? 0 : -1)) > 0));
                w1 w1Var2 = new w1(window.getDecorView());
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 35) {
                    insetsController3 = window.getInsetsController();
                    ?? u1Var2 = new u1(insetsController3, w1Var2);
                    u1Var2.f8721e = window;
                    r1Var2 = u1Var2;
                } else if (i12 >= 30) {
                    insetsController2 = window.getInsetsController();
                    ?? t1Var2 = new t1(insetsController2, w1Var2);
                    t1Var2.f8721e = window;
                    r1Var2 = t1Var2;
                } else {
                    r1Var2 = i12 >= 26 ? new s1(window, w1Var2) : new r1(window, w1Var2);
                }
                r1Var2.m(z12);
                int paddingTop = findViewById.getPaddingTop();
                int paddingLeft = findViewById.getPaddingLeft();
                int paddingRight = findViewById.getPaddingRight();
                int i13 = findViewById.getLayoutParams().height;
                m mVar = new m();
                mVar.f3771o = i13;
                mVar.f3775s = findViewById;
                mVar.f3772p = paddingLeft;
                mVar.f3773q = paddingTop;
                mVar.f3774r = paddingRight;
                WeakHashMap weakHashMap = k0.f8683a;
                c0.j(findViewById, mVar);
                this.S0 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = l().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.R0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            View decorView2 = window.getDecorView();
            Dialog dialog2 = this.f762s0;
            if (dialog2 == null) {
                throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
            }
            decorView2.setOnTouchListener(new u8.a(dialog2, rect));
        }
        E();
        int i14 = this.f3778z0;
        if (i14 == 0) {
            N();
            throw null;
        }
        N();
        b bVar = this.B0;
        l lVar = new l();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i14);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", bVar.f3739r);
        lVar.I(bundle);
        this.C0 = lVar;
        u uVar = lVar;
        if (this.G0 == 1) {
            N();
            b bVar2 = this.B0;
            u oVar = new o();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i14);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar2);
            oVar.I(bundle2);
            uVar = oVar;
        }
        this.A0 = uVar;
        this.P0.setText((this.G0 == 1 && l().getConfiguration().orientation == 2) ? this.U0 : this.T0);
        N();
        throw null;
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void B() {
        this.A0.h0.clear();
        super.B();
    }

    @Override // androidx.fragment.app.o
    public final Dialog K() {
        Context E = E();
        E();
        int i10 = this.f3778z0;
        if (i10 == 0) {
            N();
            throw null;
        }
        Dialog dialog = new Dialog(E, i10);
        Context context = dialog.getContext();
        this.F0 = P(context, android.R.attr.windowFullscreen);
        this.R0 = new d9.j(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j8.a.f7192m, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        int color = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        this.R0.k(context);
        this.R0.n(ColorStateList.valueOf(color));
        this.R0.m(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    public final void N() {
        if (this.f811t.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.o, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f3776x0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.o, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f3777y0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.S;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        if (bundle == null) {
            bundle = this.f811t;
        }
        this.f3778z0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.B0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.D0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.E0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.G0 = bundle.getInt("INPUT_MODE_KEY");
        this.H0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.I0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.J0 = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.K0 = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.L0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.M0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.N0 = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.O0 = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence charSequence = this.E0;
        if (charSequence == null) {
            charSequence = E().getResources().getText(this.D0);
        }
        this.T0 = charSequence;
        if (charSequence != null) {
            CharSequence[] split = TextUtils.split(String.valueOf(charSequence), "\n");
            if (split.length > 1) {
                charSequence = split[0];
            }
        } else {
            charSequence = null;
        }
        this.U0 = charSequence;
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(this.F0 ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.F0) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(O(context), -2));
        } else {
            inflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(O(context), -1));
        }
        ((TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text)).setAccessibilityLiveRegion(1);
        this.Q0 = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.P0 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        this.Q0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.Q0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, n4.a.o(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], n4.a.o(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.Q0.setChecked(this.G0 != 0);
        k0.m(this.Q0, null);
        CheckableImageButton checkableImageButton2 = this.Q0;
        this.Q0.setContentDescription(this.G0 == 1 ? checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
        this.Q0.setOnClickListener(new androidx.mediarouter.app.b(2, this));
        N();
        throw null;
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void z(Bundle bundle) {
        super.z(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f3778z0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        b bVar = this.B0;
        a aVar = new a();
        int i10 = a.f3734b;
        int i11 = a.f3734b;
        long j10 = bVar.f3736o.f3786t;
        long j11 = bVar.f3737p.f3786t;
        aVar.f3735a = Long.valueOf(bVar.f3739r.f3786t);
        int i12 = bVar.f3740s;
        d dVar = bVar.f3738q;
        l lVar = this.C0;
        p pVar = lVar == null ? null : lVar.f3760k0;
        if (pVar != null) {
            aVar.f3735a = Long.valueOf(pVar.f3786t);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dVar);
        p b2 = p.b(j10);
        p b10 = p.b(j11);
        d dVar2 = (d) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l10 = aVar.f3735a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new b(b2, b10, dVar2, l10 == null ? null : p.b(l10.longValue()), i12));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.D0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.E0);
        bundle.putInt("INPUT_MODE_KEY", this.G0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.H0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.I0);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.J0);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.K0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.L0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.M0);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.N0);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.O0);
    }
}
