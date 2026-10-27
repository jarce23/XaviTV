package p;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Iterator, Map.Entry {

    /* renamed from: o, reason: collision with root package name */
    public int f9762o;

    /* renamed from: p, reason: collision with root package name */
    public int f9763p = -1;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9764q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ e f9765r;

    public c(e eVar) {
        this.f9765r = eVar;
        this.f9762o = eVar.f9781q - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f9764q) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i10 = this.f9763p;
        e eVar = this.f9765r;
        return za.h.a(key, eVar.f(i10)) && za.h.a(entry.getValue(), eVar.j(this.f9763p));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f9764q) {
            return this.f9765r.f(this.f9763p);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f9764q) {
            return this.f9765r.j(this.f9763p);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9763p < this.f9762o;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f9764q) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i10 = this.f9763p;
        e eVar = this.f9765r;
        Object f10 = eVar.f(i10);
        Object j10 = eVar.j(this.f9763p);
        return (f10 == null ? 0 : f10.hashCode()) ^ (j10 != null ? j10.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9763p++;
        this.f9764q = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f9764q) {
            throw new IllegalStateException();
        }
        this.f9765r.h(this.f9763p);
        this.f9763p--;
        this.f9762o--;
        this.f9764q = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f9764q) {
            return this.f9765r.i(this.f9763p, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
