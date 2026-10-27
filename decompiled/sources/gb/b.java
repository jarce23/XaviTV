package gb;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements Iterator, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public int f5451o = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f5452p;

    /* renamed from: q, reason: collision with root package name */
    public int f5453q;

    /* renamed from: r, reason: collision with root package name */
    public db.c f5454r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ fb.e f5455s;

    public b(fb.e eVar) {
        this.f5455s = eVar;
        int length = ((CharSequence) eVar.f5063b).length();
        if (length < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.o("Cannot coerce value to an empty range: maximum ", length, " is less than minimum 0."));
        }
        length = length >= 0 ? 0 : length;
        this.f5452p = length;
        this.f5453q = length;
    }

    public final void a() {
        fb.e eVar = this.f5455s;
        CharSequence charSequence = (CharSequence) eVar.f5063b;
        int i10 = this.f5453q;
        if (i10 < 0) {
            this.f5451o = 0;
            this.f5454r = null;
            return;
        }
        if (i10 > charSequence.length()) {
            this.f5454r = new db.c(this.f5452p, i.c0(charSequence), 1);
            this.f5453q = -1;
        } else {
            la.d dVar = (la.d) ((q) eVar.f5064c).b(charSequence, Integer.valueOf(this.f5453q));
            if (dVar == null) {
                this.f5454r = new db.c(this.f5452p, i.c0(charSequence), 1);
                this.f5453q = -1;
            } else {
                int intValue = ((Number) dVar.f8328o).intValue();
                int intValue2 = ((Number) dVar.f8329p).intValue();
                this.f5454r = k5.a.y(this.f5452p, intValue);
                int i11 = intValue + intValue2;
                this.f5452p = i11;
                this.f5453q = i11 + (intValue2 == 0 ? 1 : 0);
            }
        }
        this.f5451o = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5451o == -1) {
            a();
        }
        return this.f5451o == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5451o == -1) {
            a();
        }
        if (this.f5451o == 0) {
            throw new NoSuchElementException();
        }
        db.c cVar = this.f5454r;
        za.h.c("null cannot be cast to non-null type kotlin.ranges.IntRange", cVar);
        this.f5454r = null;
        this.f5451o = -1;
        return cVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
