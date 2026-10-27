package rb;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class r implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    public boolean f11063o;

    /* renamed from: p, reason: collision with root package name */
    public int f11064p;

    /* renamed from: q, reason: collision with root package name */
    public final ReentrantLock f11065q = new ReentrantLock();

    public abstract void a();

    public abstract int c(long j10, byte[] bArr, int i10, int i11);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f11065q;
        reentrantLock.lock();
        try {
            if (this.f11063o) {
                return;
            }
            this.f11063o = true;
            if (this.f11064p != 0) {
                return;
            }
            reentrantLock.unlock();
            a();
        } finally {
            reentrantLock.unlock();
        }
    }

    public abstract long n();

    public final q s(long j10) {
        ReentrantLock reentrantLock = this.f11065q;
        reentrantLock.lock();
        try {
            if (this.f11063o) {
                throw new IllegalStateException("closed");
            }
            this.f11064p++;
            reentrantLock.unlock();
            return new q(this, j10);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        ReentrantLock reentrantLock = this.f11065q;
        reentrantLock.lock();
        try {
            if (this.f11063o) {
                throw new IllegalStateException("closed");
            }
            reentrantLock.unlock();
            return n();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
