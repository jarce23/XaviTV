package pb;

import ib.g0;
import ib.q;
import java.util.concurrent.Executor;
import nb.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends g0 implements Executor {

    /* renamed from: q, reason: collision with root package name */
    public static final d f10173q = new d();

    /* renamed from: r, reason: collision with root package name */
    public static final q f10174r;

    static {
        q qVar = l.f10188q;
        int i10 = w.f9346a;
        if (64 >= i10) {
            i10 = 64;
        }
        int i11 = nb.a.i("kotlinx.coroutines.io.parallelism", i10, 12);
        qVar.getClass();
        if (i11 < 1) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i11, "Expected positive parallelism level, but got ").toString());
        }
        if (i11 < k.f10184d) {
            if (i11 < 1) {
                throw new IllegalArgumentException(android.support.v4.media.d.m(i11, "Expected positive parallelism level, but got ").toString());
            }
            qVar = new nb.i(qVar, i11);
        }
        f10174r = qVar;
    }

    @Override // ib.q
    public final void M(pa.i iVar, Runnable runnable) {
        f10174r.M(iVar, runnable);
    }

    @Override // ib.q
    public final void N(pa.i iVar, Runnable runnable) {
        f10174r.N(iVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        M(pa.j.f10146o, runnable);
    }

    @Override // ib.q
    public final String toString() {
        return "Dispatchers.IO";
    }
}
