package o9;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends AbstractCollection {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9644o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f9645p;

    public /* synthetic */ n(int i10, Serializable serializable) {
        this.f9644o = i10;
        this.f9645p = serializable;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.f9644o) {
            case 0:
                ((s0) this.f9645p).b();
                break;
            case 1:
                ((u) this.f9645p).clear();
                break;
            default:
                ((d) this.f9645p).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.f9644o) {
            case 0:
                Iterator it = ((s0) this.f9645p).a().values().iterator();
                while (it.hasNext()) {
                    if (((Collection) it.next()).contains(obj)) {
                        return true;
                    }
                }
                return false;
            case 1:
            default:
                return super.contains(obj);
            case 2:
                return ((d) this.f9645p).containsValue(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.f9644o) {
            case 2:
                return ((d) this.f9645p).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f9644o) {
            case 0:
                return new a((s0) this.f9645p);
            case 1:
                u uVar = (u) this.f9645p;
                Map b2 = uVar.b();
                return b2 != null ? b2.values().iterator() : new r(uVar, 2);
            default:
                return new q0(((d) this.f9645p).entrySet().iterator());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f9644o) {
            case 2:
                d dVar = (d) this.f9645p;
                try {
                    return super.remove(obj);
                } catch (UnsupportedOperationException unused) {
                    for (Map.Entry entry : dVar.entrySet()) {
                        if (com.bumptech.glide.d.k(obj, entry.getValue())) {
                            dVar.remove(entry.getKey());
                            return true;
                        }
                    }
                    return false;
                }
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f9644o) {
            case 2:
                d dVar = (d) this.f9645p;
                try {
                    collection.getClass();
                    return super.removeAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    for (Map.Entry entry : dVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return dVar.keySet().removeAll(hashSet);
                }
            default:
                return super.removeAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.f9644o) {
            case 2:
                d dVar = (d) this.f9645p;
                try {
                    collection.getClass();
                    return super.retainAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    for (Map.Entry entry : dVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return dVar.keySet().retainAll(hashSet);
                }
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.f9644o) {
            case 0:
                return ((s0) this.f9645p).f9667s;
            case 1:
                return ((u) this.f9645p).size();
            default:
                return ((d) this.f9645p).f9600q.size();
        }
    }

    public n(d dVar) {
        this.f9644o = 2;
        this.f9645p = dVar;
    }
}
