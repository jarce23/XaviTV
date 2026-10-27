package io.realm;

import io.realm.internal.OsResults;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p extends io.realm.internal.s implements ListIterator {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ n0 f6787q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(n0 n0Var, int i10) {
        super(n0Var.f6784p);
        this.f6787q = n0Var;
        if (i10 >= 0 && i10 <= this.f6765o.h()) {
            this.f6766p = i10 - 1;
            return;
        }
        throw new IndexOutOfBoundsException("Starting location must be a valid index: [0, " + (this.f6765o.h() - 1) + "]. Yours was " + i10);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Adding an element is not supported. Use Realm.createObject() instead.");
    }

    @Override // io.realm.internal.s
    public final Object b(int i10, OsResults osResults) {
        return this.f6787q.f6785q.y(i10, osResults);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        a();
        return this.f6766p >= 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        a();
        return this.f6766p + 1;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        try {
            this.f6766p--;
            return b(this.f6766p, this.f6765o);
        } catch (IndexOutOfBoundsException unused) {
            throw new NoSuchElementException(r.a.d(new StringBuilder("Cannot access index less than zero. This was "), this.f6766p, ". Remember to check hasPrevious() before using previous()."));
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        a();
        return this.f6766p;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Replacing an element is not supported.");
    }
}
