package l4;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f8260a;

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.leanback.widget.z f8261b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f8260a = new c0();
        } else {
            f8260a = new b0();
        }
        f8261b = new androidx.leanback.widget.z(Float.class, "translationAlpha", 9);
        new androidx.leanback.widget.z(Rect.class, "clipBounds", 10);
    }

    public static void a(View view, int i10, int i11, int i12, int i13) {
        f8260a.Q(view, i10, i11, i12, i13);
    }

    public static void b(View view, int i10) {
        f8260a.G(view, i10);
    }
}
