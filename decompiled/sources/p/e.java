package p;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import o9.s;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class e extends i implements Map {

    /* renamed from: r, reason: collision with root package name */
    public s f9767r;

    /* renamed from: s, reason: collision with root package name */
    public b f9768s;

    /* renamed from: t, reason: collision with root package name */
    public d f9769t;

    public e(e eVar) {
        super(0);
        g(eVar);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        s sVar = this.f9767r;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this, 2);
        this.f9767r = sVar2;
        return sVar2;
    }

    public final boolean k(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public final Set keySet() {
        b bVar = this.f9768s;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f9768s = bVar2;
        return bVar2;
    }

    public final boolean l(Collection collection) {
        int i10 = this.f9781q;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i10 != this.f9781q;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f9781q);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        d dVar = this.f9769t;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(this);
        this.f9769t = dVar2;
        return dVar2;
    }
}
