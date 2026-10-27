package fb;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ya.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements Iterator, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5072o;

    /* renamed from: p, reason: collision with root package name */
    public Iterator f5073p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f5074q;

    public k(b bVar) {
        this.f5072o = 1;
        this.f5074q = new ArrayList();
        this.f5073p = bVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f5072o) {
        }
        return this.f5073p.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5072o) {
            case 0:
                return ((l) ((e) this.f5074q).f5064c).invoke(this.f5073p.next());
            default:
                Object next = this.f5073p.next();
                ArrayList arrayList = (ArrayList) this.f5074q;
                View view = (View) next;
                ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                b bVar = viewGroup != null ? new b(1, viewGroup) : null;
                if (bVar == null || !bVar.hasNext()) {
                    while (!this.f5073p.hasNext() && !arrayList.isEmpty()) {
                        this.f5073p = (Iterator) ma.j.G(arrayList);
                        if (arrayList.isEmpty()) {
                            throw new NoSuchElementException("List is empty.");
                        }
                        arrayList.remove(ma.k.w(arrayList));
                    }
                } else {
                    arrayList.add(this.f5073p);
                    this.f5073p = bVar;
                }
                return next;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f5072o) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public k(e eVar) {
        this.f5072o = 0;
        this.f5074q = eVar;
        this.f5073p = ((f) eVar.f5063b).iterator();
    }
}
