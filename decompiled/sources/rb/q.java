package rb;

import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q implements s0 {

    /* renamed from: o, reason: collision with root package name */
    public final r f11060o;

    /* renamed from: p, reason: collision with root package name */
    public long f11061p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11062q;

    public q(r rVar, long j10) {
        this.f11060o = rVar;
        this.f11061p = j10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f11062q) {
            return;
        }
        this.f11062q = true;
        r rVar = this.f11060o;
        ReentrantLock reentrantLock = rVar.f11065q;
        reentrantLock.lock();
        try {
            int i10 = rVar.f11064p - 1;
            rVar.f11064p = i10;
            if (i10 == 0) {
                if (rVar.f11063o) {
                    reentrantLock.unlock();
                    rVar.a();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // rb.s0
    public final long read(l lVar, long j10) {
        long j11;
        long j12;
        za.h.e("sink", lVar);
        if (this.f11062q) {
            throw new IllegalStateException("closed");
        }
        long j13 = this.f11061p;
        if (j10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount < 0: ").toString());
        }
        long j14 = j10 + j13;
        long j15 = j13;
        while (true) {
            if (j15 >= j14) {
                j11 = -1;
                break;
            }
            n0 V = lVar.V(1);
            j11 = -1;
            long j16 = j14;
            int c10 = this.f11060o.c(j15, V.f11042a, V.f11044c, (int) Math.min(j14 - j15, 8192 - r10));
            if (c10 == -1) {
                if (V.f11043b == V.f11044c) {
                    lVar.f11034o = V.a();
                    o0.a(V);
                }
                if (j13 == j15) {
                    j12 = -1;
                }
            } else {
                V.f11044c += c10;
                long j17 = c10;
                j15 += j17;
                lVar.f11035p += j17;
                j14 = j16;
            }
        }
        j12 = j15 - j13;
        if (j12 != j11) {
            this.f11061p += j12;
        }
        return j12;
    }

    @Override // rb.s0
    public final v0 timeout() {
        return v0.NONE;
    }
}
