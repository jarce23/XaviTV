package x5;

import java.util.ArrayDeque;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends m6.j {
    @Override // m6.j
    public final void c(Object obj, Object obj2) {
        r rVar = (r) obj;
        rVar.getClass();
        ArrayDeque arrayDeque = r.f13662b;
        synchronized (arrayDeque) {
            arrayDeque.offer(rVar);
        }
    }
}
