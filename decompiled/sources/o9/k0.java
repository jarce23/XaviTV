package o9;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 extends k1 {

    /* renamed from: o, reason: collision with root package name */
    public int f9629o;

    /* renamed from: p, reason: collision with root package name */
    public Object f9630p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f9631q;

    /* renamed from: r, reason: collision with root package name */
    public final Iterator f9632r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f9633s;

    public k0() {
        this.f9629o = 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        Object next;
        int i10 = this.f9629o;
        if (i10 == 4) {
            throw new IllegalStateException();
        }
        int b2 = s.e.b(i10);
        if (b2 == 0) {
            return true;
        }
        if (b2 == 2) {
            return false;
        }
        this.f9629o = 4;
        switch (this.f9631q) {
            case 0:
                do {
                    Iterator it = this.f9632r;
                    if (!it.hasNext()) {
                        this.f9629o = 3;
                        next = null;
                        break;
                    } else {
                        next = it.next();
                    }
                } while (!((n9.e) this.f9633s).apply(next));
            default:
                do {
                    Iterator it2 = this.f9632r;
                    if (!it2.hasNext()) {
                        this.f9629o = 3;
                        next = null;
                        break;
                    } else {
                        next = it2.next();
                    }
                } while (!((e1) this.f9633s).f9609p.contains(next));
        }
        this.f9630p = next;
        if (this.f9629o == 3) {
            return false;
        }
        this.f9629o = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9629o = 2;
        Object obj = this.f9630p;
        this.f9630p = null;
        return obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k0(Iterator it, n9.e eVar) {
        this();
        this.f9631q = 0;
        this.f9632r = it;
        this.f9633s = eVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k0(e1 e1Var) {
        this();
        this.f9631q = 1;
        this.f9633s = e1Var;
        this.f9632r = e1Var.f9608o.iterator();
    }
}
