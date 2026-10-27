package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import okhttp3.internal._UtilCommonKt;
import rb.i;
import rb.l;
import rb.m;
import rb.o;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final i maskCursor;
    private final byte[] maskKey;
    private final l messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final m sink;
    private final l sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z10, m mVar, Random random, boolean z11, boolean z12, long j10) {
        h.e("sink", mVar);
        h.e("random", random);
        this.isClient = z10;
        this.sink = mVar;
        this.random = random;
        this.perMessageDeflate = z11;
        this.noContextTakeover = z12;
        this.minimumDeflateSize = j10;
        this.messageBuffer = new l();
        this.sinkBuffer = mVar.b();
        this.maskKey = z10 ? new byte[4] : null;
        this.maskCursor = z10 ? new i() : null;
    }

    private final void writeControlFrame(int i10, o oVar) {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int d6 = oVar.d();
        if (d6 > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.X(i10 | 128);
        if (this.isClient) {
            this.sinkBuffer.X(d6 | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            h.b(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.m153write(this.maskKey);
            if (d6 > 0) {
                l lVar = this.sinkBuffer;
                long j10 = lVar.f11035p;
                lVar.W(oVar);
                l lVar2 = this.sinkBuffer;
                i iVar = this.maskCursor;
                h.b(iVar);
                lVar2.O(iVar);
                this.maskCursor.c(j10);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.X(d6);
            this.sinkBuffer.W(oVar);
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            _UtilCommonKt.closeQuietly(messageDeflater);
        }
        _UtilCommonKt.closeQuietly(this.sink);
    }

    public final Random getRandom() {
        return this.random;
    }

    public final m getSink() {
        return this.sink;
    }

    public final void writeClose(int i10, o oVar) {
        o oVar2 = o.f11048r;
        if (i10 != 0 || oVar != null) {
            if (i10 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i10);
            }
            l lVar = new l();
            lVar.c0(i10);
            if (oVar != null) {
                lVar.W(oVar);
            }
            oVar2 = lVar.i(lVar.f11035p);
        }
        try {
            writeControlFrame(8, oVar2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i10, o oVar) {
        h.e("data", oVar);
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.W(oVar);
        int i11 = i10 | 128;
        if (this.perMessageDeflate && oVar.d() >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            messageDeflater.deflate(this.messageBuffer);
            i11 = i10 | 192;
        }
        long j10 = this.messageBuffer.f11035p;
        this.sinkBuffer.X(i11);
        int i12 = this.isClient ? 128 : 0;
        if (j10 <= 125) {
            this.sinkBuffer.X(i12 | ((int) j10));
        } else if (j10 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.X(i12 | WebSocketProtocol.PAYLOAD_SHORT);
            this.sinkBuffer.c0((int) j10);
        } else {
            this.sinkBuffer.X(i12 | 127);
            this.sinkBuffer.b0(j10);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            h.b(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.m153write(this.maskKey);
            if (j10 > 0) {
                l lVar = this.messageBuffer;
                i iVar = this.maskCursor;
                h.b(iVar);
                lVar.O(iVar);
                this.maskCursor.c(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, j10);
        this.sink.flush();
    }

    public final void writePing(o oVar) {
        h.e("payload", oVar);
        writeControlFrame(9, oVar);
    }

    public final void writePong(o oVar) {
        h.e("payload", oVar);
        writeControlFrame(10, oVar);
    }
}
