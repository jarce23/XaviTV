package m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: l, reason: collision with root package name */
    public static final RectF f8360l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap f8361m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f8362a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8363b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f8364c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f8365d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f8366e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f8367f = new int[0];
    public boolean g = false;

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f8368h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f8369i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f8370j;

    /* renamed from: k, reason: collision with root package name */
    public final y0 f8371k;

    public b1(TextView textView) {
        this.f8369i = textView;
        this.f8370j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f8371k = new z0();
        } else {
            this.f8371k = new y0();
        }
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i10 : iArr) {
                if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i11 = 0; i11 < size; i11++) {
                    iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f8361m;
            Method method = (Method) concurrentHashMap.get(str);
            if (method != null || (method = TextView.class.getDeclaredMethod(str, null)) == null) {
                return method;
            }
            method.setAccessible(true);
            concurrentHashMap.put(str, method);
            return method;
        } catch (Exception e7) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e7);
            return null;
        }
    }

    public static Object e(Object obj, String str, Object obj2) {
        try {
            return d(str).invoke(obj, null);
        } catch (Exception e7) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e7);
            return obj2;
        }
    }

    public final void a() {
        if (f()) {
            if (this.f8363b) {
                if (this.f8369i.getMeasuredHeight() <= 0 || this.f8369i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f8371k.b(this.f8369i) ? 1048576 : (this.f8369i.getMeasuredWidth() - this.f8369i.getTotalPaddingLeft()) - this.f8369i.getTotalPaddingRight();
                int height = (this.f8369i.getHeight() - this.f8369i.getCompoundPaddingBottom()) - this.f8369i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f8360l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float c10 = c(rectF);
                        if (c10 != this.f8369i.getTextSize()) {
                            g(0, c10);
                        }
                    } finally {
                    }
                }
            }
            this.f8363b = true;
        }
    }

    public final int c(RectF rectF) {
        CharSequence transformation;
        int length = this.f8367f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i10 = length - 1;
        int i11 = 0;
        int i12 = 1;
        while (i12 <= i10) {
            int i13 = (i12 + i10) / 2;
            int i14 = this.f8367f[i13];
            TextView textView = this.f8369i;
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            CharSequence charSequence = (transformationMethod == null || (transformation = transformationMethod.getTransformation(text, textView)) == null) ? text : transformation;
            int maxLines = textView.getMaxLines();
            TextPaint textPaint = this.f8368h;
            if (textPaint == null) {
                this.f8368h = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.f8368h.set(textView.getPaint());
            this.f8368h.setTextSize(i14);
            StaticLayout a10 = x0.a(charSequence, (Layout.Alignment) e(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines, this.f8369i, this.f8368h, this.f8371k);
            if ((maxLines == -1 || (a10.getLineCount() <= maxLines && a10.getLineEnd(a10.getLineCount() - 1) == charSequence.length())) && a10.getHeight() <= rectF.bottom) {
                int i15 = i13 + 1;
                i11 = i12;
                i12 = i15;
            } else {
                i11 = i13 - 1;
                i10 = i11;
            }
        }
        return this.f8367f[i11];
    }

    public final boolean f() {
        return j() && this.f8362a != 0;
    }

    public final void g(int i10, float f10) {
        Context context = this.f8370j;
        float applyDimension = TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.f8369i;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean isInLayout = textView.isInLayout();
            if (textView.getLayout() != null) {
                this.f8363b = false;
                try {
                    Method d6 = d("nullLayouts");
                    if (d6 != null) {
                        d6.invoke(textView, null);
                    }
                } catch (Exception e7) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e7);
                }
                if (isInLayout) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean h() {
        if (j() && this.f8362a == 1) {
            if (!this.g || this.f8367f.length == 0) {
                int floor = ((int) Math.floor((this.f8366e - this.f8365d) / this.f8364c)) + 1;
                int[] iArr = new int[floor];
                for (int i10 = 0; i10 < floor; i10++) {
                    iArr[i10] = Math.round((i10 * this.f8364c) + this.f8365d);
                }
                this.f8367f = b(iArr);
            }
            this.f8363b = true;
        } else {
            this.f8363b = false;
        }
        return this.f8363b;
    }

    public final boolean i() {
        boolean z10 = this.f8367f.length > 0;
        this.g = z10;
        if (z10) {
            this.f8362a = 1;
            this.f8365d = r0[0];
            this.f8366e = r0[r1 - 1];
            this.f8364c = -1.0f;
        }
        return z10;
    }

    public final boolean j() {
        return !(this.f8369i instanceof AppCompatEditText);
    }

    public final void k(float f10, float f11, float f12) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        }
        if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        if (f12 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
        this.f8362a = 1;
        this.f8365d = f10;
        this.f8366e = f11;
        this.f8364c = f12;
        this.g = false;
    }
}
