package rb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class x implements s0 {
    private final s0 delegate;

    public x(s0 s0Var) {
        za.h.e("delegate", s0Var);
        this.delegate = s0Var;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final s0 m159deprecated_delegate() {
        return this.delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final s0 delegate() {
        return this.delegate;
    }

    @Override // rb.s0
    public long read(l lVar, long j10) {
        za.h.e("sink", lVar);
        return this.delegate.read(lVar, j10);
    }

    @Override // rb.s0
    public v0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
