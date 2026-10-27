package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import rb.b;
import rb.m0;
import rb.o;
import rb.s0;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class BasePublicSuffixList implements PublicSuffixList {
    public o bytes;
    public o exceptionBytes;
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);
    private IOException readFailure;

    private final void readTheList() {
        try {
            m0 c10 = b.c(listSource());
            try {
                o i10 = c10.i(c10.readInt());
                o i11 = c10.i(c10.readInt());
                c10.close();
                synchronized (this) {
                    h.b(i10);
                    setBytes(i10);
                    h.b(i11);
                    setExceptionBytes(i11);
                }
            } finally {
            }
        } finally {
            this.readCompleteLatch.countDown();
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e7) {
                    this.readFailure = e7;
                    if (!z10) {
                        return;
                    }
                }
            } finally {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    public void ensureLoaded() {
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.bytes != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Unable to load " + getPath() + " resource.");
        illegalStateException.initCause(this.readFailure);
        throw illegalStateException;
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    public o getBytes() {
        o oVar = this.bytes;
        if (oVar != null) {
            return oVar;
        }
        h.h("bytes");
        throw null;
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    public o getExceptionBytes() {
        o oVar = this.exceptionBytes;
        if (oVar != null) {
            return oVar;
        }
        h.h("exceptionBytes");
        throw null;
    }

    public abstract Object getPath();

    public abstract s0 listSource();

    public void setBytes(o oVar) {
        h.e("<set-?>", oVar);
        this.bytes = oVar;
    }

    public void setExceptionBytes(o oVar) {
        h.e("<set-?>", oVar);
        this.exceptionBytes = oVar;
    }
}
