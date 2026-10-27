package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Deflater;
import rb.b;
import rb.i;
import rb.l;
import rb.o;
import rb.p;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class MessageDeflater implements Closeable {
    private final l deflatedBytes;
    private final Deflater deflater;
    private final p deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z10) {
        this.noContextTakeover = z10;
        l lVar = new l();
        this.deflatedBytes = lVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new p(b.b(lVar), deflater);
    }

    private final boolean endsWith(l lVar, o oVar) {
        return lVar.u(lVar.f11035p - oVar.d(), oVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.deflaterSink.close();
    }

    public final void deflate(l lVar) {
        o oVar;
        h.e("buffer", lVar);
        if (this.deflatedBytes.f11035p != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(lVar, lVar.f11035p);
        this.deflaterSink.flush();
        l lVar2 = this.deflatedBytes;
        oVar = MessageDeflaterKt.EMPTY_DEFLATE_BLOCK;
        if (endsWith(lVar2, oVar)) {
            l lVar3 = this.deflatedBytes;
            long j10 = lVar3.f11035p - 4;
            i O = lVar3.O(b.f10995a);
            try {
                O.a(j10);
                O.close();
            } finally {
            }
        } else {
            this.deflatedBytes.X(0);
        }
        l lVar4 = this.deflatedBytes;
        lVar.write(lVar4, lVar4.f11035p);
    }
}
