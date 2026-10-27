package o9;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 extends k1 {

    /* renamed from: o, reason: collision with root package name */
    public final Object f9642o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9643p;

    public m0(Object obj) {
        this.f9642o = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f9643p;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f9643p) {
            throw new NoSuchElementException();
        }
        this.f9643p = true;
        return this.f9642o;
    }
}
