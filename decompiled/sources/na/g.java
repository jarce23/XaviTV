package na;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends ma.f {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9300o;

    /* renamed from: p, reason: collision with root package name */
    public final f f9301p;

    public /* synthetic */ g(f fVar, int i10) {
        this.f9300o = i10;
        this.f9301p = fVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f9300o) {
            case 0:
                za.h.e("element", (Map.Entry) obj);
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        switch (this.f9300o) {
            case 0:
                za.h.e("elements", collection);
                throw new UnsupportedOperationException();
            default:
                za.h.e("elements", collection);
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f9300o) {
            case 0:
                this.f9301p.clear();
                break;
            default:
                this.f9301p.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f9300o) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                return this.f9301p.f((Map.Entry) obj);
            default:
                return this.f9301p.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f9300o) {
            case 0:
                za.h.e("elements", collection);
                return this.f9301p.e(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // ma.f
    public final int f() {
        switch (this.f9300o) {
        }
        return this.f9301p.f9296w;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f9300o) {
        }
        return this.f9301p.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f9300o) {
            case 0:
                f fVar = this.f9301p;
                fVar.getClass();
                return new d(fVar, 0);
            default:
                f fVar2 = this.f9301p;
                fVar2.getClass();
                return new d(fVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f9300o) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    f fVar = this.f9301p;
                    fVar.getClass();
                    fVar.c();
                    int h10 = fVar.h(entry.getKey());
                    if (h10 >= 0) {
                        Object[] objArr = fVar.f9289p;
                        za.h.b(objArr);
                        if (za.h.a(objArr[h10], entry.getValue())) {
                            fVar.l(h10);
                            break;
                        }
                    }
                }
                break;
            default:
                f fVar2 = this.f9301p;
                fVar2.c();
                int h11 = fVar2.h(obj);
                if (h11 >= 0) {
                    fVar2.l(h11);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        switch (this.f9300o) {
            case 0:
                za.h.e("elements", collection);
                this.f9301p.c();
                break;
            default:
                za.h.e("elements", collection);
                this.f9301p.c();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        switch (this.f9300o) {
            case 0:
                za.h.e("elements", collection);
                this.f9301p.c();
                break;
            default:
                za.h.e("elements", collection);
                this.f9301p.c();
                break;
        }
        return super.retainAll(collection);
    }
}
