package o9;

import java.util.AbstractList;
import java.util.ListIterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 extends j1 implements ListIterator {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f9646p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ AbstractList f9647q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n0(AbstractList abstractList, ListIterator listIterator, int i10) {
        super(listIterator);
        this.f9646p = i10;
        this.f9647q = abstractList;
    }

    @Override // o9.j1
    public final Object a(Object obj) {
        switch (this.f9646p) {
            case 0:
                return ((o0) this.f9647q).f9652p.apply(obj);
            default:
                return ((p0) this.f9647q).f9656p.apply(obj);
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return ((ListIterator) this.f9627o).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return ((ListIterator) this.f9627o).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return a(((ListIterator) this.f9627o).previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return ((ListIterator) this.f9627o).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
