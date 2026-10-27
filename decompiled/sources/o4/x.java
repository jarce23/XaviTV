package o4;

import android.content.Context;
import androidx.work.WorkerParameters;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9520a = p.f("WorkerFactory");

    public static o a(Context context, String str, WorkerParameters workerParameters) {
        Class cls;
        String str2 = f9520a;
        o oVar = null;
        try {
            cls = Class.forName(str).asSubclass(o.class);
        } catch (Throwable th) {
            p.d().c(str2, "Invalid class: " + str, th);
            cls = null;
        }
        if (cls != null) {
            try {
                oVar = (o) cls.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Throwable th2) {
                p.d().c(str2, "Could not instantiate " + str, th2);
            }
        }
        if (oVar == null || !oVar.f9509r) {
            return oVar;
        }
        throw new IllegalStateException("WorkerFactory (" + x.class.getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
