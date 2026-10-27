package f;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class w {
    public static OnBackInvokedDispatcher a(Activity activity) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        return onBackInvokedDispatcher;
    }

    public static OnBackInvokedCallback b(Object obj, b0 b0Var) {
        Objects.requireNonNull(b0Var);
        androidx.activity.s sVar = new androidx.activity.s(1, b0Var);
        androidx.activity.o.f(obj).registerOnBackInvokedCallback(1000000, sVar);
        return sVar;
    }

    public static void c(Object obj, Object obj2) {
        androidx.activity.o.f(obj).unregisterOnBackInvokedCallback(androidx.activity.o.c(obj2));
    }
}
