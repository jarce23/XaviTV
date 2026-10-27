package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.url._UrlKt;
import rb.i;
import rb.l;
import rb.n;
import rb.o;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final l controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final i maskCursor;
    private final byte[] maskKey;
    private final l messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final n source;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public interface FrameCallback {
        void onReadClose(int i10, String str);

        void onReadMessage(String str);

        void onReadMessage(o oVar);

        void onReadPing(o oVar);

        void onReadPong(o oVar);
    }

    public WebSocketReader(boolean z10, n nVar, FrameCallback frameCallback, boolean z11, boolean z12) {
        h.e("source", nVar);
        h.e("frameCallback", frameCallback);
        this.isClient = z10;
        this.source = nVar;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z11;
        this.noContextTakeover = z12;
        this.controlFrameBuffer = new l();
        this.messageFrameBuffer = new l();
        this.maskKey = z10 ? null : new byte[4];
        this.maskCursor = z10 ? null : new i();
    }

    private final void readControlFrame() {
        short s10;
        String str;
        long j10 = this.frameLength;
        if (j10 > 0) {
            this.source.z(this.controlFrameBuffer, j10);
            if (!this.isClient) {
                l lVar = this.controlFrameBuffer;
                i iVar = this.maskCursor;
                h.b(iVar);
                lVar.O(iVar);
                this.maskCursor.c(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                i iVar2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                h.b(bArr);
                webSocketProtocol.toggleMask(iVar2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                l lVar2 = this.controlFrameBuffer;
                long j11 = lVar2.f11035p;
                if (j11 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j11 != 0) {
                    s10 = lVar2.readShort();
                    str = this.controlFrameBuffer.S();
                    String closeCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s10);
                    if (closeCodeExceptionMessage != null) {
                        throw new ProtocolException(closeCodeExceptionMessage);
                    }
                } else {
                    s10 = 1005;
                    str = _UrlKt.FRAGMENT_ENCODE_SET;
                }
                this.frameCallback.onReadClose(s10, str);
                this.closed = true;
                return;
            case 9:
                FrameCallback frameCallback = this.frameCallback;
                l lVar3 = this.controlFrameBuffer;
                frameCallback.onReadPing(lVar3.i(lVar3.f11035p));
                return;
            case 10:
                FrameCallback frameCallback2 = this.frameCallback;
                l lVar4 = this.controlFrameBuffer;
                frameCallback2.onReadPong(lVar4.i(lVar4.f11035p));
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + _UtilJvmKt.toHexString(this.opcode));
        }
    }

    private final void readHeader() {
        boolean z10;
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int and = _UtilCommonKt.and(this.source.readByte(), 255);
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            int i10 = and & 15;
            this.opcode = i10;
            boolean z11 = (and & 128) != 0;
            this.isFinalFrame = z11;
            boolean z12 = (and & 8) != 0;
            this.isControlFrame = z12;
            if (z12 && !z11) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z13 = (and & 64) != 0;
            if (i10 == 1 || i10 == 2) {
                if (!z13) {
                    z10 = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z10 = true;
                }
                this.readingCompressedMessage = z10;
            } else if (z13) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((and & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((and & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int and2 = _UtilCommonKt.and(this.source.readByte(), 255);
            boolean z14 = (and2 & 128) != 0;
            if (z14 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j10 = and2 & 127;
            this.frameLength = j10;
            if (j10 == 126) {
                this.frameLength = _UtilCommonKt.and(this.source.readShort(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            } else if (j10 == 127) {
                long readLong = this.source.readLong();
                this.frameLength = readLong;
                if (readLong < 0) {
                    throw new ProtocolException("Frame length 0x" + _UtilJvmKt.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z14) {
                n nVar = this.source;
                byte[] bArr = this.maskKey;
                h.b(bArr);
                nVar.readFully(bArr);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void readMessage() {
        while (!this.closed) {
            long j10 = this.frameLength;
            if (j10 > 0) {
                this.source.z(this.messageFrameBuffer, j10);
                if (!this.isClient) {
                    l lVar = this.messageFrameBuffer;
                    i iVar = this.maskCursor;
                    h.b(iVar);
                    lVar.O(iVar);
                    this.maskCursor.c(this.messageFrameBuffer.f11035p - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    i iVar2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    h.b(bArr);
                    webSocketProtocol.toggleMask(iVar2, bArr);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + _UtilJvmKt.toHexString(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() {
        int i10 = this.opcode;
        if (i10 != 1 && i10 != 2) {
            throw new ProtocolException("Unknown opcode: " + _UtilJvmKt.toHexString(i10));
        }
        readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) {
                messageInflater = new MessageInflater(this.noContextTakeover);
                this.messageInflater = messageInflater;
            }
            messageInflater.inflate(this.messageFrameBuffer);
        }
        if (i10 == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.S());
            return;
        }
        FrameCallback frameCallback = this.frameCallback;
        l lVar = this.messageFrameBuffer;
        frameCallback.onReadMessage(lVar.i(lVar.f11035p));
    }

    private final void readUntilNonControlFrame() {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            _UtilCommonKt.closeQuietly(messageInflater);
        }
        _UtilCommonKt.closeQuietly(this.source);
    }

    public final n getSource() {
        return this.source;
    }

    public final void processNextFrame() {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
