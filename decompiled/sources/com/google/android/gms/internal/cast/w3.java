package com.google.android.gms.internal.cast;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w3 extends y7.d {

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3551d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3552e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3553f;
    public final AtomicReferenceFieldUpdater g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3554h;

    public w3(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f3551d = atomicReferenceFieldUpdater;
        this.f3552e = atomicReferenceFieldUpdater2;
        this.f3553f = atomicReferenceFieldUpdater3;
        this.g = atomicReferenceFieldUpdater4;
        this.f3554h = atomicReferenceFieldUpdater5;
    }

    @Override // y7.d
    public final v3 B(b4 b4Var) {
        return (v3) this.g.getAndSet(b4Var, v3.f3528d);
    }

    @Override // y7.d
    public final a4 F(b4 b4Var) {
        return (a4) this.f3553f.getAndSet(b4Var, a4.f3250c);
    }

    @Override // y7.d
    public final void H(a4 a4Var, a4 a4Var2) {
        this.f3552e.lazySet(a4Var, a4Var2);
    }

    @Override // y7.d
    public final void I(a4 a4Var, Thread thread) {
        this.f3551d.lazySet(a4Var, thread);
    }

    @Override // y7.d
    public final boolean J(b4 b4Var, v3 v3Var, v3 v3Var2) {
        return a.a.w(this.g, b4Var, v3Var, v3Var2);
    }

    @Override // y7.d
    public final boolean K(b4 b4Var, Object obj, Object obj2) {
        return a.a.w(this.f3554h, b4Var, obj, obj2);
    }

    @Override // y7.d
    public final boolean L(b4 b4Var, a4 a4Var, a4 a4Var2) {
        return a.a.w(this.f3553f, b4Var, a4Var, a4Var2);
    }
}
