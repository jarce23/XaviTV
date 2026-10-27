package io.realm;

import io.realm.internal.OsResults;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 extends AbstractList implements OrderedRealmCollection {

    /* renamed from: o, reason: collision with root package name */
    public final u f6783o;

    /* renamed from: p, reason: collision with root package name */
    public final OsResults f6784p;

    /* renamed from: q, reason: collision with root package name */
    public final x4.m f6785q;

    public n0(u uVar, OsResults osResults, x4.m mVar) {
        this.f6783o = uVar;
        this.f6784p = osResults;
        this.f6785q = mVar;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        this.f6783o.c();
        if (!this.f6784p.f6706r) {
            return false;
        }
        if ((obj instanceof io.realm.internal.y) && ((io.realm.internal.a0) ((io.realm.internal.y) obj).a().f2682c) == io.realm.internal.f.f6741o) {
            return false;
        }
        o oVar = new o(this);
        while (oVar.hasNext()) {
            Object next = oVar.next();
            if ((next instanceof byte[]) && (obj instanceof byte[])) {
                if (Arrays.equals((byte[]) next, (byte[]) obj)) {
                    return true;
                }
            } else {
                if (next != null && next.equals(obj)) {
                    return true;
                }
                if (next == null && obj == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void f() {
        this.f6783o.c();
        if (size() > 0) {
            this.f6784p.b();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        this.f6783o.c();
        x4.m mVar = this.f6785q;
        return ((u) mVar.f13564p).x((Class) mVar.f13566r, ((OsResults) mVar.f13565q).d(i10));
    }

    @Override // io.realm.RealmCollection
    public final boolean isValid() {
        return this.f6784p.e();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new o(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new p(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i10) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        this.f6783o.c();
        OsResults osResults = this.f6784p;
        if (!osResults.f6706r) {
            return 0;
        }
        long h10 = osResults.h();
        if (h10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) h10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i10) {
        return new p(this, i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }
}
