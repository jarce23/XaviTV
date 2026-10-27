package sb;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import rb.n0;
import rb.o0;
import rb.s0;
import rb.v0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements s0 {

    /* renamed from: o, reason: collision with root package name */
    public final InputStream f11699o;

    /* renamed from: p, reason: collision with root package name */
    public final k f11700p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ x4.i f11701q;

    public h(x4.i iVar) {
        this.f11701q = iVar;
        Socket socket = (Socket) iVar.f13553p;
        this.f11699o = socket.getInputStream();
        this.f11700p = new k(socket);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i10;
        x4.i iVar = this.f11701q;
        k kVar = this.f11700p;
        kVar.enter();
        try {
            AtomicInteger atomicInteger = (AtomicInteger) iVar.f13554q;
            Socket socket = (Socket) iVar.f13553p;
            za.h.e("<this>", atomicInteger);
            while (true) {
                int i11 = atomicInteger.get();
                if ((i11 & 2) != 0) {
                    i10 = 0;
                    break;
                }
                int i12 = i11 | 2;
                if (atomicInteger.compareAndSet(i11, i12)) {
                    i10 = i12;
                    break;
                }
            }
            if (i10 != 0) {
                if (i10 == 3) {
                    socket.close();
                } else {
                    if (socket.isClosed() || socket.isInputShutdown()) {
                        return;
                    }
                    try {
                        socket.shutdownInput();
                    } catch (UnsupportedOperationException unused) {
                        this.f11699o.close();
                    }
                }
                if (kVar.exit()) {
                    throw kVar.access$newTimeoutException(null);
                }
            }
        } catch (IOException e7) {
            if (!kVar.exit()) {
                throw e7;
            }
            throw kVar.access$newTimeoutException(e7);
        } finally {
            kVar.exit();
        }
    }

    @Override // rb.s0
    public final long read(rb.l lVar, long j10) {
        za.h.e("sink", lVar);
        if (j10 == 0) {
            return 0L;
        }
        if (j10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount < 0: ").toString());
        }
        k kVar = this.f11700p;
        kVar.throwIfReached();
        n0 V = lVar.V(1);
        int min = (int) Math.min(j10, 8192 - V.f11044c);
        try {
            kVar.enter();
            try {
                int read = this.f11699o.read(V.f11042a, V.f11044c, min);
                if (kVar.exit()) {
                    throw kVar.access$newTimeoutException(null);
                }
                if (read != -1) {
                    V.f11044c += read;
                    long j11 = read;
                    lVar.f11035p += j11;
                    return j11;
                }
                if (V.f11043b != V.f11044c) {
                    return -1L;
                }
                lVar.f11034o = V.a();
                o0.a(V);
                return -1L;
            } catch (IOException e7) {
                if (kVar.exit()) {
                    throw kVar.access$newTimeoutException(e7);
                }
                throw e7;
            } finally {
                kVar.exit();
            }
        } catch (AssertionError e8) {
            if (o.a(e8)) {
                throw new IOException(e8);
            }
            throw e8;
        }
    }

    @Override // rb.s0
    public final v0 timeout() {
        return this.f11700p;
    }

    public final String toString() {
        return "source(" + ((Socket) this.f11701q.f13553p) + ')';
    }
}
