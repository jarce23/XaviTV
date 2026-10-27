package j9;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: f, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7457f = new androidx.emoji2.text.s("ExtractorSessionStoreView", 3);

    /* renamed from: a, reason: collision with root package name */
    public final p f7458a;

    /* renamed from: b, reason: collision with root package name */
    public final n0 f7459b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f7460c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ReentrantLock f7461d = new ReentrantLock();

    /* renamed from: e, reason: collision with root package name */
    public final k9.e f7462e;

    public u0(p pVar, k9.e eVar, n0 n0Var) {
        this.f7458a = pVar;
        this.f7462e = eVar;
        this.f7459b = n0Var;
    }

    public final r0 a(int i10) {
        Integer valueOf = Integer.valueOf(i10);
        r0 r0Var = (r0) this.f7460c.get(valueOf);
        if (r0Var != null) {
            return r0Var;
        }
        throw new j0(String.format("Could not find session %d while trying to get it", valueOf), i10);
    }

    public final Object b(t0 t0Var) {
        ReentrantLock reentrantLock = this.f7461d;
        try {
            reentrantLock.lock();
            return t0Var.c();
        } finally {
            reentrantLock.unlock();
        }
    }
}
