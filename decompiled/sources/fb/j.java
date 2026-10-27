package fb;

import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements Iterable, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ e f5071o;

    public j(e eVar) {
        this.f5071o = eVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new gb.b(this.f5071o);
    }
}
