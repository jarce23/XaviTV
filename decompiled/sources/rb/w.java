package rb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class w implements q0 {
    private final q0 delegate;

    public w(q0 q0Var) {
        za.h.e("delegate", q0Var);
        this.delegate = q0Var;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final q0 m158deprecated_delegate() {
        return this.delegate;
    }

    @Override // rb.q0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final q0 delegate() {
        return this.delegate;
    }

    @Override // rb.q0, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // rb.q0
    public v0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // rb.q0
    public void write(l lVar, long j10) {
        za.h.e("source", lVar);
        this.delegate.write(lVar, j10);
    }
}
