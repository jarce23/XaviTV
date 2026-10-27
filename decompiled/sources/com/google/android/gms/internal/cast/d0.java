package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 extends e0 {

    /* renamed from: q, reason: collision with root package name */
    public final transient int f3292q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f3293r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ e0 f3294s;

    public d0(e0 e0Var, int i10, int i11) {
        this.f3294s = e0Var;
        this.f3292q = i10;
        this.f3293r = i11;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final int g() {
        return this.f3294s.h() + this.f3292q + this.f3293r;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        j1.c.s(i10, this.f3293r);
        return this.f3294s.get(i10 + this.f3292q);
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final int h() {
        return this.f3294s.h() + this.f3292q;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final Object[] i() {
        return this.f3294s.i();
    }

    @Override // com.google.android.gms.internal.cast.e0, java.util.List
    /* renamed from: j */
    public final e0 subList(int i10, int i11) {
        j1.c.u(i10, i11, this.f3293r);
        int i12 = this.f3292q;
        return this.f3294s.subList(i10 + i12, i11 + i12);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3293r;
    }
}
