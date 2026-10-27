package rb;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements s0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11007o = 1;

    /* renamed from: p, reason: collision with root package name */
    public final Object f11008p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f11009q;

    public f(InputStream inputStream, v0 v0Var) {
        za.h.e("timeout", v0Var);
        this.f11008p = inputStream;
        this.f11009q = v0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f11007o) {
            case 0:
                g gVar = (g) this.f11008p;
                s0 s0Var = (s0) this.f11009q;
                gVar.enter();
                try {
                    s0Var.close();
                    if (gVar.exit()) {
                        throw gVar.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e7) {
                    if (!gVar.exit()) {
                        throw e7;
                    }
                    throw gVar.access$newTimeoutException(e7);
                } finally {
                    gVar.exit();
                }
            default:
                ((InputStream) this.f11008p).close();
                return;
        }
    }

    @Override // rb.s0
    public final long read(l lVar, long j10) {
        switch (this.f11007o) {
            case 0:
                za.h.e("sink", lVar);
                g gVar = (g) this.f11008p;
                s0 s0Var = (s0) this.f11009q;
                gVar.enter();
                try {
                    long read = s0Var.read(lVar, j10);
                    if (gVar.exit()) {
                        throw gVar.access$newTimeoutException(null);
                    }
                    return read;
                } catch (IOException e7) {
                    if (gVar.exit()) {
                        throw gVar.access$newTimeoutException(e7);
                    }
                    throw e7;
                } finally {
                    gVar.exit();
                }
            default:
                za.h.e("sink", lVar);
                if (j10 == 0) {
                    return 0L;
                }
                if (j10 < 0) {
                    throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount < 0: ").toString());
                }
                try {
                    ((v0) this.f11009q).throwIfReached();
                    n0 V = lVar.V(1);
                    int read2 = ((InputStream) this.f11008p).read(V.f11042a, V.f11044c, (int) Math.min(j10, 8192 - V.f11044c));
                    if (read2 == -1) {
                        if (V.f11043b == V.f11044c) {
                            lVar.f11034o = V.a();
                            o0.a(V);
                        }
                        return -1L;
                    }
                    V.f11044c += read2;
                    long j11 = read2;
                    lVar.f11035p += j11;
                    return j11;
                } catch (AssertionError e8) {
                    if (sb.o.a(e8)) {
                        throw new IOException(e8);
                    }
                    throw e8;
                }
        }
    }

    @Override // rb.s0
    public final v0 timeout() {
        switch (this.f11007o) {
            case 0:
                return (g) this.f11008p;
            default:
                return (v0) this.f11009q;
        }
    }

    public final String toString() {
        switch (this.f11007o) {
            case 0:
                return "AsyncTimeout.source(" + ((s0) this.f11009q) + ')';
            default:
                return "source(" + ((InputStream) this.f11008p) + ')';
        }
    }

    public f(g gVar, s0 s0Var) {
        this.f11008p = gVar;
        this.f11009q = s0Var;
    }
}
