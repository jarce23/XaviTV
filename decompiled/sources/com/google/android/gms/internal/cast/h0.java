package com.google.android.gms.internal.cast;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 extends c8.g {

    /* renamed from: p, reason: collision with root package name */
    public boolean f3319p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f3320q;

    public h0(Object obj) {
        super(1);
        this.f3320q = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f3319p;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3319p) {
            throw new NoSuchElementException();
        }
        this.f3319p = true;
        return this.f3320q;
    }
}
