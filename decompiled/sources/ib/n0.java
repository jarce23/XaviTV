package ib;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 extends r0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6580f = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;

    /* renamed from: e, reason: collision with root package name */
    public final m0 f6581e;

    public n0(m0 m0Var) {
        this.f6581e = m0Var;
    }

    @Override // ib.m0
    public final void d(Throwable th) {
        if (f6580f.compareAndSet(this, 0, 1)) {
            this.f6581e.d(th);
        }
    }
}
