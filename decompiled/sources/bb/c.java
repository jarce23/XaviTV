package bb;

import java.util.Random;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: p, reason: collision with root package name */
    public final b f2489p = new b(0);

    @Override // bb.a
    public final Random a() {
        Object obj = this.f2489p.get();
        h.d("get(...)", obj);
        return (Random) obj;
    }
}
