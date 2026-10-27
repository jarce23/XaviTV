package rb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements q0 {
    @Override // rb.q0
    public final v0 timeout() {
        return v0.NONE;
    }

    @Override // rb.q0
    public final void write(l lVar, long j10) {
        za.h.e("source", lVar);
        lVar.skip(j10);
    }

    @Override // rb.q0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // rb.q0, java.io.Flushable
    public final void flush() {
    }
}
