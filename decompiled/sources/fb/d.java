package fb;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements Iterator, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public Object f5059o;

    /* renamed from: p, reason: collision with root package name */
    public int f5060p = -2;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ e f5061q;

    public d(e eVar) {
        this.f5061q = eVar;
    }

    public final void a() {
        Object invoke;
        int i10 = this.f5060p;
        e eVar = this.f5061q;
        if (i10 == -2) {
            invoke = ((androidx.activity.e) eVar.f5063b).f291p;
        } else {
            okhttp3.internal.a aVar = (okhttp3.internal.a) eVar.f5064c;
            Object obj = this.f5059o;
            za.h.b(obj);
            invoke = aVar.invoke(obj);
        }
        this.f5059o = invoke;
        this.f5060p = invoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5060p < 0) {
            a();
        }
        return this.f5060p == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5060p < 0) {
            a();
        }
        if (this.f5060p == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.f5059o;
        za.h.c("null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence", obj);
        this.f5060p = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
