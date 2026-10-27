package m0;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y0 extends e1 {

    /* renamed from: e, reason: collision with root package name */
    public static Field f8740e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f8741f = false;
    public static Constructor g = null;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f8742h = false;

    /* renamed from: c, reason: collision with root package name */
    public WindowInsets f8743c;

    /* renamed from: d, reason: collision with root package name */
    public e0.c f8744d;

    public y0() {
        this.f8743c = i();
    }

    private static WindowInsets i() {
        if (!f8741f) {
            try {
                f8740e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e7) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e7);
            }
            f8741f = true;
        }
        Field field = f8740e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e8) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e8);
            }
        }
        if (!f8742h) {
            try {
                g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e10) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e10);
            }
            f8742h = true;
        }
        Constructor constructor = g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e11) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e11);
            }
        }
        return null;
    }

    @Override // m0.e1
    public q1 b() {
        a();
        q1 g6 = q1.g(null, this.f8743c);
        e0.c[] cVarArr = this.f8650b;
        n1 n1Var = g6.f8706a;
        n1Var.o(cVarArr);
        n1Var.q(this.f8744d);
        return g6;
    }

    @Override // m0.e1
    public void e(e0.c cVar) {
        this.f8744d = cVar;
    }

    @Override // m0.e1
    public void g(e0.c cVar) {
        WindowInsets windowInsets = this.f8743c;
        if (windowInsets != null) {
            this.f8743c = windowInsets.replaceSystemWindowInsets(cVar.f4385a, cVar.f4386b, cVar.f4387c, cVar.f4388d);
        }
    }

    public y0(q1 q1Var) {
        super(q1Var);
        this.f8743c = q1Var.f();
    }
}
