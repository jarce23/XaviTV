package o1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o9.f1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements Map {

    /* renamed from: o, reason: collision with root package name */
    public final Map f9448o;

    public o(Map map) {
        this.f9448o = map;
    }

    @Override // java.util.Map
    public final void clear() {
        this.f9448o.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return obj != null && this.f9448o.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        Iterator it = ((f1) entrySet()).iterator();
        it.getClass();
        if (obj == null) {
            while (it.hasNext()) {
                if (((Map.Entry) it.next()).getValue() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(((Map.Entry) it.next()).getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return o9.q.f(this.f9448o.entrySet(), new n(0));
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj != null && o9.q.d(this, obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) this.f9448o.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return o9.q.h(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        Map map = this.f9448o;
        return map.isEmpty() || (map.size() == 1 && map.containsKey(null));
    }

    @Override // java.util.Map
    public final Set keySet() {
        return o9.q.f(this.f9448o.keySet(), new n(1));
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f9448o.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        this.f9448o.putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return this.f9448o.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        Map map = this.f9448o;
        return map.size() - (map.containsKey(null) ? 1 : 0);
    }

    public final String toString() {
        return this.f9448o.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f9448o.values();
    }
}
