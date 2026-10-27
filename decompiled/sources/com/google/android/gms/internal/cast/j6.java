package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j6 implements Iterator {

    /* renamed from: o, reason: collision with root package name */
    public final Iterator f3346o;

    public j6(k6 k6Var) {
        this.f3346o = k6Var.f3354o.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3346o.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f3346o.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
