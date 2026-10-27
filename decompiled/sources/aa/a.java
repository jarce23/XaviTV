package aa;

import ba.b;
import ba.d;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {
    public static Scheduler a(ba.a aVar) {
        try {
            d dVar = b.f2486a;
            if (dVar != null) {
                return dVar;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }
}
