package p;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements Iterator, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public int f9756o;

    /* renamed from: p, reason: collision with root package name */
    public int f9757p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9758q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f9759r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f9760s;

    public a(int i10) {
        this.f9756o = i10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9757p < this.f9756o;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object f10;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f9757p;
        switch (this.f9759r) {
            case 0:
                f10 = ((e) this.f9760s).f(i10);
                break;
            case 1:
                f10 = ((e) this.f9760s).j(i10);
                break;
            default:
                f10 = ((f) this.f9760s).f9771p[i10];
                break;
        }
        this.f9757p++;
        this.f9758q = true;
        return f10;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f9758q) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i10 = this.f9757p - 1;
        this.f9757p = i10;
        switch (this.f9759r) {
            case 0:
                ((e) this.f9760s).h(i10);
                break;
            case 1:
                ((e) this.f9760s).h(i10);
                break;
            default:
                ((f) this.f9760s).f(i10);
                break;
        }
        this.f9756o--;
        this.f9758q = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        this(fVar.f9772q);
        this.f9759r = 2;
        this.f9760s = fVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(e eVar, int i10) {
        this(eVar.f9781q);
        this.f9759r = i10;
        switch (i10) {
            case 1:
                this.f9760s = eVar;
                this(eVar.f9781q);
                break;
            default:
                this.f9760s = eVar;
                break;
        }
    }
}
