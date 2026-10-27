package o9;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class d extends AbstractMap {

    /* renamed from: o, reason: collision with root package name */
    public transient b f9598o;

    /* renamed from: p, reason: collision with root package name */
    public transient n f9599p;

    /* renamed from: q, reason: collision with root package name */
    public final transient Map f9600q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ s0 f9601r;

    public d(s0 s0Var, Map map) {
        this.f9601r = s0Var;
        this.f9600q = map;
    }

    public final c0 a(Map.Entry entry) {
        Object key = entry.getKey();
        List list = (List) ((Collection) entry.getValue());
        boolean z10 = list instanceof RandomAccess;
        s0 s0Var = this.f9601r;
        return new c0(key, z10 ? new h(s0Var, key, list, null) : new l(s0Var, key, list, null));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        s0 s0Var = this.f9601r;
        if (this.f9600q == s0Var.f9666r) {
            s0Var.b();
            return;
        }
        c cVar = new c(this);
        while (cVar.hasNext()) {
            cVar.next();
            cVar.remove();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.f9600q;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        b bVar = this.f9598o;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f9598o = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.f9600q.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Map map = this.f9600q;
        map.getClass();
        try {
            obj2 = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return null;
        }
        List list = (List) collection;
        boolean z10 = list instanceof RandomAccess;
        s0 s0Var = this.f9601r;
        return z10 ? new h(s0Var, obj, list, null) : new l(s0Var, obj, list, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f9600q.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        s0 s0Var = this.f9601r;
        Set set = s0Var.f9648o;
        if (set != null) {
            return set;
        }
        Map map = s0Var.f9666r;
        Set gVar = map instanceof NavigableMap ? new g(s0Var, (NavigableMap) map) : map instanceof SortedMap ? new j(s0Var, (SortedMap) map) : new e(s0Var, map);
        s0Var.f9648o = gVar;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Collection collection = (Collection) this.f9600q.remove(obj);
        if (collection == null) {
            return null;
        }
        s0 s0Var = this.f9601r;
        Collection c10 = s0Var.c();
        c10.addAll(collection);
        s0Var.f9667s -= collection.size();
        collection.clear();
        return c10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f9600q.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f9600q.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        n nVar = this.f9599p;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this);
        this.f9599p = nVar2;
        return nVar2;
    }
}
