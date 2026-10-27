package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8542a;

    /* renamed from: b, reason: collision with root package name */
    public p2 f8543b;

    /* renamed from: c, reason: collision with root package name */
    public p2 f8544c;

    /* renamed from: d, reason: collision with root package name */
    public p2 f8545d;

    /* renamed from: e, reason: collision with root package name */
    public p2 f8546e;

    /* renamed from: f, reason: collision with root package name */
    public p2 f8547f;
    public p2 g;

    /* renamed from: h, reason: collision with root package name */
    public p2 f8548h;

    /* renamed from: i, reason: collision with root package name */
    public final b1 f8549i;

    /* renamed from: j, reason: collision with root package name */
    public int f8550j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f8551k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f8552l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8553m;

    public s0(TextView textView) {
        this.f8542a = textView;
        this.f8549i = new b1(textView);
    }

    public static p2 c(Context context, r rVar, int i10) {
        ColorStateList i11;
        synchronized (rVar) {
            i11 = rVar.f8529a.i(context, i10);
        }
        if (i11 == null) {
            return null;
        }
        p2 p2Var = new p2();
        p2Var.f8520d = true;
        p2Var.f8517a = i11;
        return p2Var;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i10 >= 30) {
            o0.b.a(editorInfo, text);
            return;
        }
        text.getClass();
        if (i10 >= 30) {
            o0.b.a(editorInfo, text);
            return;
        }
        int i11 = editorInfo.initialSelStart;
        int i12 = editorInfo.initialSelEnd;
        int i13 = i11 > i12 ? i12 : i11;
        if (i11 <= i12) {
            i11 = i12;
        }
        int length = text.length();
        if (i13 < 0 || i11 > length) {
            o0.c.a(editorInfo, null, 0, 0);
            return;
        }
        int i14 = editorInfo.inputType & 4095;
        if (i14 == 129 || i14 == 225 || i14 == 18) {
            o0.c.a(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            o0.c.a(editorInfo, text, i13, i11);
            return;
        }
        int i15 = i11 - i13;
        int i16 = i15 > 1024 ? 0 : i15;
        int i17 = 2048 - i16;
        int min = Math.min(text.length() - i11, i17 - Math.min(i13, (int) (i17 * 0.8d)));
        int min2 = Math.min(i13, i17 - min);
        int i18 = i13 - min2;
        if (Character.isLowSurrogate(text.charAt(i18))) {
            i18++;
            min2--;
        }
        if (Character.isHighSurrogate(text.charAt((i11 + min) - 1))) {
            min--;
        }
        int i19 = min2 + i16;
        o0.c.a(editorInfo, i16 != i15 ? TextUtils.concat(text.subSequence(i18, i18 + min2), text.subSequence(i11, min + i11)) : text.subSequence(i18, i19 + min + i18), min2, i19);
    }

    public final void a(Drawable drawable, p2 p2Var) {
        if (drawable == null || p2Var == null) {
            return;
        }
        r.e(drawable, p2Var, this.f8542a.getDrawableState());
    }

    public final void b() {
        p2 p2Var = this.f8543b;
        TextView textView = this.f8542a;
        if (p2Var != null || this.f8544c != null || this.f8545d != null || this.f8546e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f8543b);
            a(compoundDrawables[1], this.f8544c);
            a(compoundDrawables[2], this.f8545d);
            a(compoundDrawables[3], this.f8546e);
        }
        if (this.f8547f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f8547f);
        a(compoundDrawablesRelative[2], this.g);
    }

    public final ColorStateList d() {
        p2 p2Var = this.f8548h;
        if (p2Var != null) {
            return p2Var.f8517a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        p2 p2Var = this.f8548h;
        if (p2Var != null) {
            return p2Var.f8518b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.util.AttributeSet r27, int r28) {
        /*
            Method dump skipped, instructions count: 1035
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.s0.f(android.util.AttributeSet, int):void");
    }

    public final void g(Context context, int i10) {
        String string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, e.a.f4379w);
        android.support.v4.media.session.a0 a0Var = new android.support.v4.media.session.a0(context, obtainStyledAttributes);
        boolean hasValue = obtainStyledAttributes.hasValue(14);
        TextView textView = this.f8542a;
        if (hasValue) {
            textView.setAllCaps(obtainStyledAttributes.getBoolean(14, false));
        }
        int i11 = Build.VERSION.SDK_INT;
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, a0Var);
        if (i11 >= 26 && obtainStyledAttributes.hasValue(13) && (string = obtainStyledAttributes.getString(13)) != null) {
            q0.d(textView, string);
        }
        a0Var.U();
        Typeface typeface = this.f8552l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f8550j);
        }
    }

    public final void i(int i10, int i11, int i12, int i13) {
        b1 b1Var = this.f8549i;
        if (b1Var.j()) {
            DisplayMetrics displayMetrics = b1Var.f8370j.getResources().getDisplayMetrics();
            b1Var.k(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (b1Var.h()) {
                b1Var.a();
            }
        }
    }

    public final void j(int[] iArr, int i10) {
        b1 b1Var = this.f8549i;
        if (b1Var.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i10 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = b1Var.f8370j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr2[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                b1Var.f8367f = b1.b(iArr2);
                if (!b1Var.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                b1Var.g = false;
            }
            if (b1Var.h()) {
                b1Var.a();
            }
        }
    }

    public final void k(int i10) {
        b1 b1Var = this.f8549i;
        if (b1Var.j()) {
            if (i10 == 0) {
                b1Var.f8362a = 0;
                b1Var.f8365d = -1.0f;
                b1Var.f8366e = -1.0f;
                b1Var.f8364c = -1.0f;
                b1Var.f8367f = new int[0];
                b1Var.f8363b = false;
                return;
            }
            if (i10 != 1) {
                throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = b1Var.f8370j.getResources().getDisplayMetrics();
            b1Var.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (b1Var.h()) {
                b1Var.a();
            }
        }
    }

    public final void l(ColorStateList colorStateList) {
        if (this.f8548h == null) {
            this.f8548h = new p2();
        }
        p2 p2Var = this.f8548h;
        p2Var.f8517a = colorStateList;
        p2Var.f8520d = colorStateList != null;
        this.f8543b = p2Var;
        this.f8544c = p2Var;
        this.f8545d = p2Var;
        this.f8546e = p2Var;
        this.f8547f = p2Var;
        this.g = p2Var;
    }

    public final void m(PorterDuff.Mode mode) {
        if (this.f8548h == null) {
            this.f8548h = new p2();
        }
        p2 p2Var = this.f8548h;
        p2Var.f8518b = mode;
        p2Var.f8519c = mode != null;
        this.f8543b = p2Var;
        this.f8544c = p2Var;
        this.f8545d = p2Var;
        this.f8546e = p2Var;
        this.f8547f = p2Var;
        this.g = p2Var;
    }

    public final void n(Context context, android.support.v4.media.session.a0 a0Var) {
        String string;
        int i10 = this.f8550j;
        TypedArray typedArray = (TypedArray) a0Var.f231q;
        this.f8550j = typedArray.getInt(2, i10);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            int i12 = typedArray.getInt(11, -1);
            this.f8551k = i12;
            if (i12 != -1) {
                this.f8550j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f8553m = false;
                int i13 = typedArray.getInt(1, 1);
                if (i13 == 1) {
                    this.f8552l = Typeface.SANS_SERIF;
                    return;
                } else if (i13 == 2) {
                    this.f8552l = Typeface.SERIF;
                    return;
                } else {
                    if (i13 != 3) {
                        return;
                    }
                    this.f8552l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f8552l = null;
        int i14 = typedArray.hasValue(12) ? 12 : 10;
        int i15 = this.f8551k;
        int i16 = this.f8550j;
        if (!context.isRestricted()) {
            try {
                Typeface M = a0Var.M(i14, this.f8550j, new n0(this, i15, i16, new WeakReference(this.f8542a)));
                if (M != null) {
                    if (i11 < 28 || this.f8551k == -1) {
                        this.f8552l = M;
                    } else {
                        this.f8552l = r0.a(Typeface.create(M, 0), this.f8551k, (this.f8550j & 2) != 0);
                    }
                }
                this.f8553m = this.f8552l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f8552l != null || (string = typedArray.getString(i14)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f8551k == -1) {
            this.f8552l = Typeface.create(string, this.f8550j);
        } else {
            this.f8552l = r0.a(Typeface.create(string, 0), this.f8551k, (this.f8550j & 2) != 0);
        }
    }
}
