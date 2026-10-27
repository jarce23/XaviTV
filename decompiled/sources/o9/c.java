package o9;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class c implements Iterator {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9585o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final Iterator f9586p;

    /* renamed from: q, reason: collision with root package name */
    public Object f9587q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f9588r;

    public c(l lVar) {
        this.f9588r = lVar;
        Collection collection = lVar.f9635p;
        this.f9587q = collection;
        this.f9586p = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public void a() {
        l lVar = (l) this.f9588r;
        lVar.g();
        if (lVar.f9635p != ((Collection) this.f9587q)) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f9585o) {
            case 0:
                break;
            case 1:
                break;
            default:
                a();
                break;
        }
        return this.f9586p.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f9585o) {
            case 0:
                Map.Entry entry = (Map.Entry) this.f9586p.next();
                this.f9587q = (Collection) entry.getValue();
                return ((d) this.f9588r).a(entry);
            case 1:
                Map.Entry entry2 = (Map.Entry) this.f9586p.next();
                this.f9587q = entry2;
                return entry2.getKey();
            default:
                a();
                return this.f9586p.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f9585o) {
            case 0:
                if (!(((Collection) this.f9587q) != null)) {
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }
                this.f9586p.remove();
                ((d) this.f9588r).f9601r.f9667s -= ((Collection) this.f9587q).size();
                ((Collection) this.f9587q).clear();
                this.f9587q = null;
                return;
            case 1:
                Map.Entry entry = (Map.Entry) this.f9587q;
                if (!(entry != null)) {
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }
                Collection collection = (Collection) entry.getValue();
                this.f9586p.remove();
                ((e) this.f9588r).f9604p.f9667s -= collection.size();
                collection.clear();
                this.f9587q = null;
                return;
            default:
                this.f9586p.remove();
                l lVar = (l) this.f9588r;
                s0 s0Var = lVar.f9638s;
                s0Var.f9667s--;
                lVar.h();
                return;
        }
    }

    public c(l lVar, ListIterator listIterator) {
        this.f9588r = lVar;
        this.f9587q = lVar.f9635p;
        this.f9586p = listIterator;
    }

    public c(e eVar, Iterator it) {
        this.f9586p = it;
        this.f9588r = eVar;
    }

    public c(d dVar) {
        this.f9588r = dVar;
        this.f9586p = dVar.f9600q.entrySet().iterator();
    }
}
