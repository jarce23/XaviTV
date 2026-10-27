package m;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class k1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f8462a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f8463b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f8464c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f8465d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
            f8462a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f8463b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f8464c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f8465d = true;
        } catch (NoSuchMethodException e7) {
            e7.printStackTrace();
        }
    }
}
