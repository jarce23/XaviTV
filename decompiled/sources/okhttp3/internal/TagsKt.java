package okhttp3.internal;

import java.util.concurrent.atomic.AtomicReference;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class TagsKt {
    public static final <T> T computeIfAbsent(AtomicReference<Tags> atomicReference, eb.b bVar, ya.a aVar) {
        h.e("<this>", atomicReference);
        h.e("type", bVar);
        h.e("compute", aVar);
        T t3 = null;
        while (true) {
            Tags tags = atomicReference.get();
            T t8 = (T) tags.get(bVar);
            if (t8 != null) {
                return t8;
            }
            if (t3 == null) {
                t3 = (T) aVar.invoke();
            }
            Tags plus = tags.plus(bVar, t3);
            while (!atomicReference.compareAndSet(tags, plus)) {
                if (atomicReference.get() != tags) {
                    break;
                }
            }
            return t3;
        }
    }
}
