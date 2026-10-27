package fb;

import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    public final f f5057a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5058b;

    public c(f fVar, int i10) {
        za.h.e("sequence", fVar);
        this.f5057a = fVar;
        this.f5058b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
    }

    @Override // fb.f
    public final Iterator iterator() {
        return new b(this);
    }
}
