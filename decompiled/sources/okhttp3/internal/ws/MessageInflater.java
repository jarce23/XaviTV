package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Inflater;
import okhttp3.internal.http2.Settings;
import rb.c0;
import rb.l;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class MessageInflater implements Closeable {
    private final l deflatedBytes = new l();
    private Inflater inflater;
    private c0 inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z10) {
        this.noContextTakeover = z10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c0 c0Var = this.inflaterSource;
        if (c0Var != null) {
            c0Var.close();
        }
        this.inflaterSource = null;
        this.inflater = null;
    }

    public final void inflate(l lVar) {
        h.e("buffer", lVar);
        if (this.deflatedBytes.f11035p != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Inflater inflater = this.inflater;
        if (inflater == null) {
            inflater = new Inflater(true);
            this.inflater = inflater;
        }
        c0 c0Var = this.inflaterSource;
        if (c0Var == null) {
            c0Var = new c0(this.deflatedBytes, inflater);
            this.inflaterSource = c0Var;
        }
        if (this.noContextTakeover) {
            inflater.reset();
        }
        this.deflatedBytes.d(lVar);
        this.deflatedBytes.a0(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        long bytesRead = inflater.getBytesRead() + this.deflatedBytes.f11035p;
        do {
            c0Var.a(lVar, Long.MAX_VALUE);
            if (inflater.getBytesRead() >= bytesRead) {
                break;
            }
        } while (!inflater.finished());
        if (inflater.getBytesRead() < bytesRead) {
            this.deflatedBytes.a();
            c0Var.close();
            this.inflaterSource = null;
            this.inflater = null;
        }
    }
}
