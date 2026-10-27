package o9;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements Iterator {

    /* renamed from: o, reason: collision with root package name */
    public int f9657o;

    /* renamed from: p, reason: collision with root package name */
    public int f9658p;

    /* renamed from: q, reason: collision with root package name */
    public int f9659q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ u f9660r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f9661s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ u f9662t;

    public r(u uVar, int i10) {
        this.f9661s = i10;
        this.f9662t = uVar;
        this.f9660r = uVar;
        this.f9657o = uVar.f9677s;
        this.f9658p = uVar.isEmpty() ? -1 : 0;
        this.f9659q = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9658p >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object obj;
        u uVar = this.f9660r;
        if (uVar.f9677s != this.f9657o) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f9658p;
        this.f9659q = i10;
        switch (this.f9661s) {
            case 0:
                obj = this.f9662t.i()[i10];
                break;
            case 1:
                obj = new t(this.f9662t, i10);
                break;
            default:
                obj = this.f9662t.j()[i10];
                break;
        }
        int i11 = this.f9658p + 1;
        if (i11 >= uVar.f9678t) {
            i11 = -1;
        }
        this.f9658p = i11;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        u uVar = this.f9660r;
        int i10 = uVar.f9677s;
        int i11 = this.f9657o;
        if (i10 != i11) {
            throw new ConcurrentModificationException();
        }
        int i12 = this.f9659q;
        if (!(i12 >= 0)) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
        this.f9657o = i11 + 32;
        uVar.remove(uVar.i()[i12]);
        this.f9658p--;
        this.f9659q = -1;
    }
}
