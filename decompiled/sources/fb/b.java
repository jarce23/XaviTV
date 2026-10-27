package fb;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class b implements Iterator, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5054o;

    /* renamed from: p, reason: collision with root package name */
    public int f5055p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f5056q;

    public /* synthetic */ b(int i10, Object obj) {
        this.f5054o = i10;
        this.f5056q = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f5054o) {
            case 0:
                Iterator it = (Iterator) this.f5056q;
                while (this.f5055p > 0 && it.hasNext()) {
                    it.next();
                    this.f5055p--;
                }
                return it.hasNext();
            case 1:
                return this.f5055p < ((ViewGroup) this.f5056q).getChildCount();
            case 2:
                return this.f5055p < ((ma.d) this.f5056q).f();
            default:
                return this.f5055p < ((Object[]) this.f5056q).length;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5054o) {
            case 0:
                Iterator it = (Iterator) this.f5056q;
                while (this.f5055p > 0 && it.hasNext()) {
                    it.next();
                    this.f5055p--;
                }
                return it.next();
            case 1:
                ViewGroup viewGroup = (ViewGroup) this.f5056q;
                int i10 = this.f5055p;
                this.f5055p = i10 + 1;
                View childAt = viewGroup.getChildAt(i10);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
            case 2:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ma.d dVar = (ma.d) this.f5056q;
                int i11 = this.f5055p;
                this.f5055p = i11 + 1;
                return dVar.get(i11);
            default:
                try {
                    Object[] objArr = (Object[]) this.f5056q;
                    int i12 = this.f5055p;
                    this.f5055p = i12 + 1;
                    return objArr[i12];
                } catch (ArrayIndexOutOfBoundsException e7) {
                    this.f5055p--;
                    throw new NoSuchElementException(e7.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f5054o) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                ViewGroup viewGroup = (ViewGroup) this.f5056q;
                int i10 = this.f5055p - 1;
                this.f5055p = i10;
                viewGroup.removeViewAt(i10);
                return;
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(Object[] objArr) {
        this.f5054o = 3;
        za.h.e("array", objArr);
        this.f5056q = objArr;
    }

    public b(c cVar) {
        this.f5054o = 0;
        this.f5056q = cVar.f5057a.iterator();
        this.f5055p = cVar.f5058b;
    }
}
