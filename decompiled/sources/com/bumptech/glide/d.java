package com.bumptech.glide;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.session.a0;
import android.text.SpannableStringBuilder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.transition.TransitionValues;
import android.util.Log;
import android.util.Property;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.leanback.transition.FadeAndShortSlide;
import i1.f0;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import l4.x;
import m.w0;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f2996a = true;

    /* renamed from: b, reason: collision with root package name */
    public static Field f2997b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f2998c;

    public static int B(i3.f fVar, int i10, int i11, int i12) {
        l1.d.b(Math.max(Math.max(i10, i11), i12) <= 31);
        int i13 = (1 << i10) - 1;
        int i14 = (1 << i11) - 1;
        w7.b.h(w7.b.h(i13, i14), 1 << i12);
        if (fVar.b() < i10) {
            return -1;
        }
        int i15 = fVar.i(i10);
        if (i15 == i13) {
            if (fVar.b() < i11) {
                return -1;
            }
            int i16 = fVar.i(i11);
            i15 += i16;
            if (i16 == i14) {
                if (fVar.b() < i12) {
                    return -1;
                }
                return fVar.i(i12) + i15;
            }
        }
        return i15;
    }

    public static void C(TextView textView, int i10) {
        y7.d.b(i10);
        if (Build.VERSION.SDK_INT >= 28) {
            c0.b.o(textView, i10);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i11 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), i10 + i11, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void D(TextView textView, int i10) {
        y7.d.b(i10);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i11 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i10 - i11);
        }
    }

    public static void E(TextView textView, int i10) {
        y7.d.b(i10);
        if (i10 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i10 - r0, 1.0f);
        }
    }

    public static void I(i3.f fVar) {
        fVar.t(3);
        fVar.t(8);
        boolean h10 = fVar.h();
        boolean h11 = fVar.h();
        if (h10) {
            fVar.t(5);
        }
        if (h11) {
            fVar.t(6);
        }
    }

    public static void J(i3.f fVar) {
        int i10;
        int i11 = fVar.i(2);
        if (i11 == 0) {
            fVar.t(6);
            return;
        }
        int B = B(fVar, 5, 8, 16) + 1;
        if (i11 == 1) {
            fVar.t(B * 7);
            return;
        }
        if (i11 == 2) {
            boolean h10 = fVar.h();
            int i12 = h10 ? 1 : 5;
            int i13 = h10 ? 7 : 5;
            int i14 = h10 ? 8 : 6;
            int i15 = 0;
            while (i15 < B) {
                if (fVar.h()) {
                    fVar.t(7);
                    i10 = 0;
                } else {
                    if (fVar.i(2) == 3 && fVar.i(i13) * i12 != 0) {
                        fVar.s();
                    }
                    i10 = fVar.i(i14) * i12;
                    if (i10 != 0 && i10 != 180) {
                        fVar.s();
                    }
                    fVar.s();
                }
                if (i10 != 0 && i10 != 180 && fVar.h()) {
                    i15++;
                }
                i15++;
            }
        }
    }

    public static ActionMode.Callback K(ActionMode.Callback callback) {
        return (!(callback instanceof p0.i) || Build.VERSION.SDK_INT < 26) ? callback : ((p0.i) callback).f9808a;
    }

    public static ActionMode.Callback M(ActionMode.Callback callback, TextView textView) {
        int i10 = Build.VERSION.SDK_INT;
        return (i10 < 26 || i10 > 27 || (callback instanceof p0.i) || callback == null) ? callback : new p0.i(callback, textView);
    }

    public static void N(int i10, int i11) {
        String z10;
        if (i10 < 0 || i10 >= i11) {
            if (i10 < 0) {
                z10 = e.z("%s (%s) must not be negative", "index", Integer.valueOf(i10));
            } else {
                if (i11 < 0) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i11).length() + 15);
                    sb2.append("negative size: ");
                    sb2.append(i11);
                    throw new IllegalArgumentException(sb2.toString());
                }
                z10 = e.z("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i10), Integer.valueOf(i11));
            }
            throw new IndexOutOfBoundsException(z10);
        }
    }

    public static void O(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException((i10 < 0 || i10 > i12) ? P("start index", i10, i12) : (i11 < 0 || i11 > i12) ? P("end index", i11, i12) : e.z("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    public static String P(String str, int i10, int i11) {
        if (i10 < 0) {
            return e.z("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return e.z("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i11).length() + 15);
        sb2.append("negative size: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, Object obj, int i10, int i11) {
        for (Object obj2 : spannableStringBuilder.getSpans(i10, i11, obj.getClass())) {
            if (spannableStringBuilder.getSpanStart(obj2) == i10 && spannableStringBuilder.getSpanEnd(obj2) == i11 && spannableStringBuilder.getSpanFlags(obj2) == 33) {
                spannableStringBuilder.removeSpan(obj2);
            }
        }
        spannableStringBuilder.setSpan(obj, i10, i11, 33);
    }

    public static void b(StringBuilder sb2, Object obj, ya.l lVar) {
        if (lVar != null) {
            sb2.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb2.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb2.append(((Character) obj).charValue());
        } else {
            sb2.append((CharSequence) obj.toString());
        }
    }

    public static String c(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb2.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return sb2.toString();
    }

    public static void f(int i10, int i11, int i12) {
        if (i10 < 0 || i11 > i12) {
            StringBuilder g = r.a.g("fromIndex: ", i10, ", toIndex: ", i11, ", size: ");
            g.append(i12);
            throw new IndexOutOfBoundsException(g.toString());
        }
        if (i10 > i11) {
            throw new IllegalArgumentException(android.support.v4.media.d.p("fromIndex: ", " > toIndex: ", i10, i11));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] g(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            jArr[i10] = iArr[i10];
        }
        return jArr;
    }

    public static ObjectAnimator h(View view, TransitionValues transitionValues, int i10, int i11, float f10, float f11, float f12, float f13, TimeInterpolator timeInterpolator, FadeAndShortSlide fadeAndShortSlide) {
        float f14 = f11;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.view.getTag(R.id.transitionPosition)) != null) {
            f10 = (r2[0] - i10) + translationX;
            f14 = (r2[1] - i11) + translationY;
        }
        int round = Math.round(f10 - translationX) + i10;
        int round2 = Math.round(f14 - translationY) + i11;
        view.setTranslationX(f10);
        view.setTranslationY(f14);
        if (f10 == f12 && f14 == f13) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f10, f14);
        path.lineTo(f12, f13);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, (Property<View, Float>) View.TRANSLATION_Y, path);
        androidx.leanback.transition.g gVar = new androidx.leanback.transition.g(view, transitionValues.view, round, round2, translationX, translationY);
        fadeAndShortSlide.addListener(gVar);
        ofFloat.addListener(gVar);
        ofFloat.addPauseListener(gVar);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    public static boolean k(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static ColorStateList l(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        ColorStateList n10;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (n10 = n4.a.n(context, resourceId)) == null) ? typedArray.getColorStateList(i10) : n10;
    }

    public static ColorStateList m(Context context, a0 a0Var, int i10) {
        int resourceId;
        ColorStateList n10;
        TypedArray typedArray = (TypedArray) a0Var.f231q;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (n10 = n4.a.n(context, resourceId)) == null) ? a0Var.J(i10) : n10;
    }

    public static Drawable n(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        Drawable o2;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (o2 = n4.a.o(context, resourceId)) == null) ? typedArray.getDrawable(i10) : o2;
    }

    public static k0.d v(w0 w0Var) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return new k0.d(c0.b.l(w0Var));
        }
        TextPaint textPaint = new TextPaint(w0Var.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = w0Var.getBreakStrategy();
        int hyphenationFrequency = w0Var.getHyphenationFrequency();
        if (w0Var.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            if (i10 < 28 || (w0Var.getInputType() & 15) != 3) {
                boolean z10 = w0Var.getLayoutDirection() == 1;
                switch (w0Var.getTextDirection()) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (z10) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        }
                        break;
                }
            } else {
                byte directionality = Character.getDirectionality(c0.b.c(i0.c.b(w0Var.getTextLocale()))[0].codePointAt(0));
                textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            }
        }
        return new k0.d(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static boolean y(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public abstract boolean A(float f10, float f11);

    public void F(View view, float f10) {
        if (f2996a) {
            try {
                x.b(view, f10);
                return;
            } catch (NoSuchMethodError unused) {
                f2996a = false;
            }
        }
        view.setAlpha(f10);
    }

    public void G(View view, int i10) {
        if (!f2998c) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f2997b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            f2998c = true;
        }
        Field field = f2997b;
        if (field != null) {
            try {
                f2997b.setInt(view, i10 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract boolean H(View view, float f10);

    public abstract void L(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11);

    public abstract int d(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float e(int i10);

    public f0 i(t2.a aVar) {
        ByteBuffer byteBuffer = aVar.f10410s;
        byteBuffer.getClass();
        l1.d.b(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return j(aVar, byteBuffer);
    }

    public abstract f0 j(t2.a aVar, ByteBuffer byteBuffer);

    public abstract int o();

    public abstract int p();

    public abstract int q();

    public abstract int r();

    public abstract int s(View view);

    public abstract int t(CoordinatorLayout coordinatorLayout);

    public abstract int u();

    public float w(View view) {
        if (f2996a) {
            try {
                return x.a(view);
            } catch (NoSuchMethodError unused) {
                f2996a = false;
            }
        }
        return view.getAlpha();
    }

    public abstract boolean x(float f10);

    public abstract boolean z(View view);
}
