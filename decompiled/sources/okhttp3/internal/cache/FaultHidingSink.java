package okhttp3.internal.cache;

import java.io.IOException;
import rb.q0;
import rb.w;
import ya.l;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class FaultHidingSink extends w {
    private boolean hasErrors;
    private final l onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(q0 q0Var, l lVar) {
        super(q0Var);
        h.e("delegate", q0Var);
        h.e("onException", lVar);
        this.onException = lVar;
    }

    @Override // rb.w, rb.q0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e7) {
            this.hasErrors = true;
            this.onException.invoke(e7);
        }
    }

    @Override // rb.w, rb.q0, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e7) {
            this.hasErrors = true;
            this.onException.invoke(e7);
        }
    }

    public final l getOnException() {
        return this.onException;
    }

    @Override // rb.w, rb.q0
    public void write(rb.l lVar, long j10) {
        h.e("source", lVar);
        if (this.hasErrors) {
            lVar.skip(j10);
            return;
        }
        try {
            super.write(lVar, j10);
        } catch (IOException e7) {
            this.hasErrors = true;
            this.onException.invoke(e7);
        }
    }
}
