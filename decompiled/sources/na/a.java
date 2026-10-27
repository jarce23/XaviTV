package na;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements ListIterator, ab.a {

    /* renamed from: p, reason: collision with root package name */
    public int f9271p;

    /* renamed from: r, reason: collision with root package name */
    public int f9273r;

    /* renamed from: s, reason: collision with root package name */
    public final ma.e f9274s;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9270o = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f9272q = -1;

    public a(c cVar, int i10) {
        int i11;
        this.f9274s = cVar;
        this.f9271p = i10;
        i11 = ((AbstractList) cVar).modCount;
        this.f9273r = i11;
    }

    public void a() {
        int i10;
        i10 = ((AbstractList) ((b) this.f9274s).f9279s).modCount;
        if (i10 != this.f9273r) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i10;
        int i11;
        switch (this.f9270o) {
            case 0:
                a();
                b bVar = (b) this.f9274s;
                int i12 = this.f9271p;
                this.f9271p = i12 + 1;
                bVar.add(i12, obj);
                this.f9272q = -1;
                i10 = ((AbstractList) bVar).modCount;
                this.f9273r = i10;
                break;
            default:
                b();
                c cVar = (c) this.f9274s;
                int i13 = this.f9271p;
                this.f9271p = i13 + 1;
                cVar.add(i13, obj);
                this.f9272q = -1;
                i11 = ((AbstractList) cVar).modCount;
                this.f9273r = i11;
                break;
        }
    }

    public void b() {
        int i10;
        i10 = ((AbstractList) ((c) this.f9274s)).modCount;
        if (i10 != this.f9273r) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f9270o) {
            case 0:
                if (this.f9271p < ((b) this.f9274s).f9277q) {
                }
                break;
            default:
                if (this.f9271p < ((c) this.f9274s).f9282p) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f9270o) {
            case 0:
                if (this.f9271p > 0) {
                }
                break;
            default:
                if (this.f9271p > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f9270o) {
            case 0:
                a();
                int i10 = this.f9271p;
                b bVar = (b) this.f9274s;
                if (i10 >= bVar.f9277q) {
                    throw new NoSuchElementException();
                }
                this.f9271p = i10 + 1;
                this.f9272q = i10;
                return bVar.f9275o[bVar.f9276p + i10];
            default:
                b();
                int i11 = this.f9271p;
                c cVar = (c) this.f9274s;
                if (i11 >= cVar.f9282p) {
                    throw new NoSuchElementException();
                }
                this.f9271p = i11 + 1;
                this.f9272q = i11;
                return cVar.f9281o[i11];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f9270o) {
        }
        return this.f9271p;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f9270o) {
            case 0:
                a();
                int i10 = this.f9271p;
                if (i10 <= 0) {
                    throw new NoSuchElementException();
                }
                int i11 = i10 - 1;
                this.f9271p = i11;
                this.f9272q = i11;
                b bVar = (b) this.f9274s;
                return bVar.f9275o[bVar.f9276p + i11];
            default:
                b();
                int i12 = this.f9271p;
                if (i12 <= 0) {
                    throw new NoSuchElementException();
                }
                int i13 = i12 - 1;
                this.f9271p = i13;
                this.f9272q = i13;
                return ((c) this.f9274s).f9281o[i13];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i10;
        switch (this.f9270o) {
            case 0:
                i10 = this.f9271p;
                break;
            default:
                i10 = this.f9271p;
                break;
        }
        return i10 - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i10;
        int i11;
        switch (this.f9270o) {
            case 0:
                b bVar = (b) this.f9274s;
                a();
                int i12 = this.f9272q;
                if (i12 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                bVar.g(i12);
                this.f9271p = this.f9272q;
                this.f9272q = -1;
                i10 = ((AbstractList) bVar).modCount;
                this.f9273r = i10;
                return;
            default:
                c cVar = (c) this.f9274s;
                b();
                int i13 = this.f9272q;
                if (i13 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                cVar.g(i13);
                this.f9271p = this.f9272q;
                this.f9272q = -1;
                i11 = ((AbstractList) cVar).modCount;
                this.f9273r = i11;
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f9270o) {
            case 0:
                a();
                int i10 = this.f9272q;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((b) this.f9274s).set(i10, obj);
                return;
            default:
                b();
                int i11 = this.f9272q;
                if (i11 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((c) this.f9274s).set(i11, obj);
                return;
        }
    }

    public a(b bVar, int i10) {
        int i11;
        this.f9274s = bVar;
        this.f9271p = i10;
        i11 = ((AbstractList) bVar).modCount;
        this.f9273r = i11;
    }
}
