package cb;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends bb.a {
    @Override // bb.a
    public final Random a() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        h.d("current(...)", current);
        return current;
    }
}
