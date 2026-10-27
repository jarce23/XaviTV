package nb;

import ib.b1;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class u extends d implements b1 {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9343d = AtomicIntegerFieldUpdater.newUpdater(u.class, "cleanedAndPointers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final long f9344c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public u(long j10, kb.m mVar, int i10) {
        super(mVar);
        this.f9344c = j10;
        this.cleanedAndPointers$volatile = i10 << 16;
    }

    @Override // nb.d
    public final boolean c() {
        return f9343d.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return f9343d.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i10, pa.i iVar);

    public final void h() {
        if (f9343d.incrementAndGet(this) == kb.g.f7893b) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f9343d;
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
