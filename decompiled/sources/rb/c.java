package rb;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {
    public static final void a(c cVar, g gVar, long j10, boolean z10) {
        g gVar2;
        k0 k0Var;
        Condition condition;
        cVar.getClass();
        gVar2 = g.idleSentinel;
        if (gVar2 == null) {
            g.idleSentinel = new g();
            d dVar = new d("Okio Watchdog");
            dVar.setDaemon(true);
            dVar.start();
        }
        long nanoTime = System.nanoTime();
        if (j10 != 0 && z10) {
            gVar.timeoutAt = Math.min(j10, gVar.deadlineNanoTime() - nanoTime) + nanoTime;
        } else if (j10 != 0) {
            gVar.timeoutAt = nanoTime + j10;
        } else {
            if (!z10) {
                throw new AssertionError();
            }
            gVar.timeoutAt = gVar.deadlineNanoTime();
        }
        k0Var = g.queue;
        k0Var.getClass();
        int i10 = k0Var.f11032a + 1;
        k0Var.f11032a = i10;
        g[] gVarArr = k0Var.f11033b;
        if (i10 == gVarArr.length) {
            g[] gVarArr2 = new g[i10 * 2];
            ma.i.F(0, 0, 14, gVarArr, gVarArr2);
            k0Var.f11033b = gVarArr2;
        }
        k0Var.a(gVar, i10);
        if (gVar.index == 1) {
            condition = g.condition;
            condition.signal();
        }
    }

    public static g b() {
        k0 k0Var;
        k0 k0Var2;
        Condition condition;
        Condition condition2;
        long j10;
        k0 k0Var3;
        long j11;
        g gVar;
        k0Var = g.queue;
        g gVar2 = k0Var.f11033b[1];
        if (gVar2 != null) {
            long remainingNanos$okio = gVar2.remainingNanos$okio(System.nanoTime());
            if (remainingNanos$okio > 0) {
                condition = g.condition;
                condition.await(remainingNanos$okio, TimeUnit.NANOSECONDS);
                return null;
            }
            k0Var2 = g.queue;
            k0Var2.b(gVar2);
            gVar2.state = 2;
            return gVar2;
        }
        long nanoTime = System.nanoTime();
        condition2 = g.condition;
        j10 = g.IDLE_TIMEOUT_MILLIS;
        condition2.await(j10, TimeUnit.MILLISECONDS);
        k0Var3 = g.queue;
        if (k0Var3.f11033b[1] == null) {
            long nanoTime2 = System.nanoTime() - nanoTime;
            j11 = g.IDLE_TIMEOUT_NANOS;
            if (nanoTime2 >= j11) {
                gVar = g.idleSentinel;
                return gVar;
            }
        }
        return null;
    }
}
