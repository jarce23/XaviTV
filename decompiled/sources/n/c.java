package n;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends j1.c {

    /* renamed from: b, reason: collision with root package name */
    public final Object f9091b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f9092c = Executors.newFixedThreadPool(4, new b());

    /* renamed from: d, reason: collision with root package name */
    public volatile Handler f9093d;

    public static Handler w(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return c0.b.b(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }
}
