package ib;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends l {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6560c = AtomicIntegerFieldUpdater.newUpdater(g.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public g(f fVar, Throwable th, boolean z10) {
        super(th, z10);
        this._resumed$volatile = 0;
    }
}
