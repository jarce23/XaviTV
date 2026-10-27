package na;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends ma.f implements Serializable {

    /* renamed from: p, reason: collision with root package name */
    public static final i f9303p;

    /* renamed from: o, reason: collision with root package name */
    public final f f9304o;

    static {
        f fVar = f.B;
        f9303p = new i(f.B);
    }

    public i(f fVar) {
        za.h.e("backing", fVar);
        this.f9304o = fVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.f9304o.a(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        za.h.e("elements", collection);
        this.f9304o.c();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f9304o.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f9304o.containsKey(obj);
    }

    @Override // ma.f
    public final int f() {
        return this.f9304o.f9296w;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f9304o.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        f fVar = this.f9304o;
        fVar.getClass();
        return new d(fVar, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        f fVar = this.f9304o;
        fVar.c();
        int h10 = fVar.h(obj);
        if (h10 < 0) {
            return false;
        }
        fVar.l(h10);
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        za.h.e("elements", collection);
        this.f9304o.c();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        za.h.e("elements", collection);
        this.f9304o.c();
        return super.retainAll(collection);
    }

    public i() {
        this(new f());
    }
}
