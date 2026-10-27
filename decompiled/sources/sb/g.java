package sb;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import rb.n0;
import rb.o0;
import rb.q0;
import rb.v0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements q0 {

    /* renamed from: o, reason: collision with root package name */
    public final OutputStream f11696o;

    /* renamed from: p, reason: collision with root package name */
    public final k f11697p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ x4.i f11698q;

    public g(x4.i iVar) {
        this.f11698q = iVar;
        Socket socket = (Socket) iVar.f13553p;
        this.f11696o = socket.getOutputStream();
        this.f11697p = new k(socket);
    }

    @Override // rb.q0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i10;
        OutputStream outputStream = this.f11696o;
        x4.i iVar = this.f11698q;
        k kVar = this.f11697p;
        kVar.enter();
        try {
            AtomicInteger atomicInteger = (AtomicInteger) iVar.f13554q;
            Socket socket = (Socket) iVar.f13553p;
            za.h.e("<this>", atomicInteger);
            while (true) {
                int i11 = atomicInteger.get();
                if ((i11 & 1) != 0) {
                    i10 = 0;
                    break;
                }
                int i12 = i11 | 1;
                if (atomicInteger.compareAndSet(i11, i12)) {
                    i10 = i12;
                    break;
                }
            }
            if (i10 != 0) {
                if (i10 != 3) {
                    if (!socket.isClosed() && !socket.isOutputShutdown()) {
                        outputStream.flush();
                        try {
                            socket.shutdownOutput();
                        } catch (UnsupportedOperationException unused) {
                            outputStream.close();
                        }
                    }
                    return;
                }
                socket.close();
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

    @Override // rb.q0, java.io.Flushable
    public final void flush() {
        k kVar = this.f11697p;
        kVar.enter();
        try {
            this.f11696o.flush();
            if (kVar.exit()) {
                throw kVar.access$newTimeoutException(null);
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

    @Override // rb.q0
    public final v0 timeout() {
        return this.f11697p;
    }

    public final String toString() {
        return "sink(" + ((Socket) this.f11698q.f13553p) + ')';
    }

    @Override // rb.q0
    public final void write(rb.l lVar, long j10) {
        za.h.e("source", lVar);
        rb.b.e(lVar.f11035p, 0L, j10);
        while (j10 > 0) {
            k kVar = this.f11697p;
            kVar.throwIfReached();
            n0 n0Var = lVar.f11034o;
            za.h.b(n0Var);
            int min = (int) Math.min(j10, n0Var.f11044c - n0Var.f11043b);
            kVar.enter();
            try {
                try {
                    this.f11696o.write(n0Var.f11042a, n0Var.f11043b, min);
                    if (kVar.exit()) {
                        throw kVar.access$newTimeoutException(null);
                    }
                    int i10 = n0Var.f11043b + min;
                    n0Var.f11043b = i10;
                    long j11 = min;
                    j10 -= j11;
                    lVar.f11035p -= j11;
                    if (i10 == n0Var.f11044c) {
                        lVar.f11034o = n0Var.a();
                        o0.a(n0Var);
                    }
                } catch (IOException e7) {
                    if (!kVar.exit()) {
                        throw e7;
                    }
                    throw kVar.access$newTimeoutException(e7);
                }
            } catch (Throwable th) {
                kVar.exit();
                throw th;
            }
        }
    }
}
