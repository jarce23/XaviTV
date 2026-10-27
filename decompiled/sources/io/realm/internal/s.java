package io.realm.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class s implements Iterator {

    /* renamed from: o, reason: collision with root package name */
    public OsResults f6765o;

    /* renamed from: p, reason: collision with root package name */
    public int f6766p = -1;

    public s(OsResults osResults) {
        if (osResults.f6704p.isClosed()) {
            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
        }
        this.f6765o = osResults;
        if (osResults.f6707s) {
            return;
        }
        if (osResults.f6704p.isInTransaction()) {
            this.f6765o = this.f6765o.c();
        } else {
            this.f6765o.f6704p.addIterator(this);
        }
    }

    public final void a() {
        if (this.f6765o == null) {
            throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a living Realm collection.");
        }
    }

    public abstract Object b(int i10, OsResults osResults);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        a();
        return ((long) (this.f6766p + 1)) < this.f6765o.h();
    }

    @Override // java.util.Iterator
    public final Object next() {
        a();
        int i10 = this.f6766p + 1;
        this.f6766p = i10;
        if (i10 < this.f6765o.h()) {
            return b(this.f6766p, this.f6765o);
        }
        throw new NoSuchElementException("Cannot access index " + this.f6766p + " when size is " + this.f6765o.h() + ". Remember to check hasNext() before using next().");
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove() is not supported by RealmResults iterators.");
    }
}
