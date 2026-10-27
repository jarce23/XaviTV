package l1;

import java.math.RoundingMode;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public long f8139a;

    /* renamed from: b, reason: collision with root package name */
    public long f8140b;

    /* renamed from: c, reason: collision with root package name */
    public long f8141c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal f8142d = new ThreadLocal();

    public y(long j10) {
        g(j10);
    }

    public final synchronized long a(long j10) {
        if (j10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (!f()) {
                long j11 = this.f8139a;
                if (j11 == 9223372036854775806L) {
                    Long l10 = (Long) this.f8142d.get();
                    l10.getClass();
                    j11 = l10.longValue();
                }
                this.f8140b = j11 - j10;
                notifyAll();
            }
            this.f8141c = j10;
            return j10 + this.f8140b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long b(long j10) {
        if (j10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j11 = this.f8141c;
            if (j11 != -9223372036854775807L) {
                int i10 = a0.f8067a;
                long V = a0.V(j11, 90000L, 1000000L, RoundingMode.DOWN);
                long j12 = (4294967296L + V) / 8589934592L;
                long j13 = ((j12 - 1) * 8589934592L) + j10;
                long j14 = (j12 * 8589934592L) + j10;
                j10 = Math.abs(j13 - V) < Math.abs(j14 - V) ? j13 : j14;
            }
            long j15 = j10;
            int i11 = a0.f8067a;
            return a(a0.V(j15, 1000000L, 90000L, RoundingMode.DOWN));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long c(long j10) {
        if (j10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j11 = this.f8141c;
        if (j11 != -9223372036854775807L) {
            int i10 = a0.f8067a;
            long V = a0.V(j11, 90000L, 1000000L, RoundingMode.DOWN);
            long j12 = V / 8589934592L;
            Long.signum(j12);
            long j13 = (j12 * 8589934592L) + j10;
            j10 = j13 >= V ? j13 : ((j12 + 1) * 8589934592L) + j10;
        }
        long j14 = j10;
        int i11 = a0.f8067a;
        return a(a0.V(j14, 1000000L, 90000L, RoundingMode.DOWN));
    }

    public final synchronized long d() {
        long j10;
        j10 = this.f8139a;
        if (j10 == Long.MAX_VALUE || j10 == 9223372036854775806L) {
            j10 = -9223372036854775807L;
        }
        return j10;
    }

    public final synchronized long e() {
        return this.f8140b;
    }

    public final synchronized boolean f() {
        return this.f8140b != -9223372036854775807L;
    }

    public final synchronized void g(long j10) {
        this.f8139a = j10;
        this.f8140b = j10 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f8141c = -9223372036854775807L;
    }

    public final synchronized void h(long j10, boolean z10) {
        try {
            d.g(this.f8139a == 9223372036854775806L);
            if (f()) {
                return;
            }
            if (z10) {
                this.f8142d.set(Long.valueOf(j10));
            } else {
                while (!f()) {
                    wait();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
