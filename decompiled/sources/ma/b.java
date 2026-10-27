package ma;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends fb.b implements ListIterator {

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ d f9040r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, int i10) {
        super(2, dVar);
        this.f9040r = dVar;
        int f10 = dVar.f();
        if (i10 < 0 || i10 > f10) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, f10));
        }
        this.f5055p = i10;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f5055p > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5055p;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f5055p - 1;
        this.f5055p = i10;
        return this.f9040r.get(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5055p - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
