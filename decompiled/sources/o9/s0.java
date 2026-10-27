package o9;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s0 extends o implements Serializable {

    /* renamed from: r, reason: collision with root package name */
    public final transient Map f9666r;

    /* renamed from: s, reason: collision with root package name */
    public transient int f9667s;

    /* renamed from: t, reason: collision with root package name */
    public transient r0 f9668t;

    public s0(Map map) {
        if (!map.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.f9666r = map;
    }

    @Override // o9.o
    public final Map a() {
        Map map = this.f9650q;
        if (map != null) {
            return map;
        }
        Map map2 = this.f9666r;
        Map fVar = map2 instanceof NavigableMap ? new f(this, (NavigableMap) map2) : map2 instanceof SortedMap ? new i(this, (SortedMap) map2) : new d(this, map2);
        this.f9650q = fVar;
        return fVar;
    }

    public final void b() {
        Map map = this.f9666r;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.f9667s = 0;
    }

    public final Collection c() {
        return (List) this.f9668t.get();
    }
}
