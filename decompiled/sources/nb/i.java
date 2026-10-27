package nb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends ib.q implements ib.y {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9323u = AtomicIntegerFieldUpdater.newUpdater(i.class, "runningWorkers$volatile");

    /* renamed from: q, reason: collision with root package name */
    public final ib.q f9324q;

    /* renamed from: r, reason: collision with root package name */
    public final int f9325r;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* renamed from: s, reason: collision with root package name */
    public final l f9326s;

    /* renamed from: t, reason: collision with root package name */
    public final Object f9327t;

    /* JADX WARN: Multi-variable type inference failed */
    public i(ib.q qVar, int i10) {
        this.f9324q = qVar;
        this.f9325r = i10;
        if ((qVar instanceof ib.y ? (ib.y) qVar : null) == null) {
            int i11 = ib.x.f6612a;
        }
        this.f9326s = new l();
        this.f9327t = new Object();
    }

    @Override // ib.q
    public final void M(pa.i iVar, Runnable runnable) {
        Runnable P;
        this.f9326s.a(runnable);
        if (f9323u.get(this) >= this.f9325r || !Q() || (P = P()) == null) {
            return;
        }
        this.f9324q.M(this, new app.shamel.tv.activities.y(this, 26, P));
    }

    @Override // ib.q
    public final void N(pa.i iVar, Runnable runnable) {
        Runnable P;
        this.f9326s.a(runnable);
        if (f9323u.get(this) >= this.f9325r || !Q() || (P = P()) == null) {
            return;
        }
        this.f9324q.N(this, new app.shamel.tv.activities.y(this, 26, P));
    }

    public final Runnable P() {
        while (true) {
            Runnable runnable = (Runnable) this.f9326s.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f9327t) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9323u;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f9326s.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean Q() {
        synchronized (this.f9327t) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9323u;
            if (atomicIntegerFieldUpdater.get(this) >= this.f9325r) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
