package fb;

import com.google.android.gms.internal.cast.n;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements Iterator, pa.d, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public int f5065o;

    /* renamed from: p, reason: collision with root package name */
    public Object f5066p;

    /* renamed from: q, reason: collision with root package name */
    public Iterator f5067q;

    /* renamed from: r, reason: collision with root package name */
    public pa.d f5068r;

    public final RuntimeException a() {
        int i10 = this.f5065o;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f5065o);
    }

    @Override // pa.d
    public final pa.i getContext() {
        return pa.j.f10146o;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i10 = this.f5065o;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw a();
                }
                Iterator it = this.f5067q;
                za.h.b(it);
                if (it.hasNext()) {
                    this.f5065o = 2;
                    return true;
                }
                this.f5067q = null;
            }
            this.f5065o = 5;
            pa.d dVar = this.f5068r;
            za.h.b(dVar);
            this.f5068r = null;
            dVar.resumeWith(la.i.f8335a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i10 = this.f5065o;
        if (i10 == 0 || i10 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i10 == 2) {
            this.f5065o = 1;
            Iterator it = this.f5067q;
            za.h.b(it);
            return it.next();
        }
        if (i10 != 3) {
            throw a();
        }
        this.f5065o = 0;
        Object obj = this.f5066p;
        this.f5066p = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // pa.d
    public final void resumeWith(Object obj) {
        n.t(obj);
        this.f5065o = 4;
    }
}
