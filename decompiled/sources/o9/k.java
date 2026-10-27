package o9;

import java.util.List;
import java.util.ListIterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends c implements ListIterator {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ l f9628s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar) {
        super(lVar);
        this.f9628s = lVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        l lVar = this.f9628s;
        boolean isEmpty = lVar.isEmpty();
        b().add(obj);
        lVar.f9639t.f9667s++;
        if (isEmpty) {
            lVar.f();
        }
    }

    public final ListIterator b() {
        a();
        return (ListIterator) this.f9586p;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return b().previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        b().set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, int i10) {
        super(lVar, ((List) lVar.f9635p).listIterator(i10));
        this.f9628s = lVar;
    }
}
