package f;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import java.lang.reflect.Constructor;
import m.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class f0 {

    /* renamed from: b, reason: collision with root package name */
    public static final Class[] f4780b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f4781c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f4782d = {R.attr.accessibilityHeading};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f4783e = {R.attr.accessibilityPaneTitle};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f4784f = {R.attr.screenReaderFocusable};
    public static final String[] g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h, reason: collision with root package name */
    public static final p.i f4785h = new p.i(0);

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f4786a = new Object[2];

    public m.o a(Context context, AttributeSet attributeSet) {
        return new m.o(context, attributeSet);
    }

    public AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    public m.p c(Context context, AttributeSet attributeSet) {
        return new m.p(context, attributeSet, org.chromium.net.R.attr.checkboxStyle);
    }

    public m.z d(Context context, AttributeSet attributeSet) {
        return new m.z(context, attributeSet);
    }

    public w0 e(Context context, AttributeSet attributeSet) {
        return new w0(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) {
        String concat;
        p.i iVar = f4785h;
        Constructor constructor = (Constructor) iVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    concat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                concat = str;
            }
            constructor = Class.forName(concat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f4780b);
            iVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f4786a);
    }
}
