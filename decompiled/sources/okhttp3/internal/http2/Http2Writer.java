package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.http2.Hpack;
import rb.l;
import rb.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Http2Writer implements Closeable, Lockable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final l hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final m sink;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(za.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public Http2Writer(m mVar, boolean z10) {
        za.h.e("sink", mVar);
        this.sink = mVar;
        this.client = z10;
        l lVar = new l();
        this.hpackBuffer = lVar;
        this.maxFrameSize = Http2.INITIAL_MAX_FRAME_SIZE;
        this.hpackWriter = new Hpack.Writer(0, false, lVar, 3, null);
    }

    private final void writeContinuationFrames(int i10, long j10) {
        while (j10 > 0) {
            long min = Math.min(this.maxFrameSize, j10);
            j10 -= min;
            frameHeader(i10, (int) min, 9, j10 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final void applyAndAckSettings(Settings settings) {
        za.h.e("peerSettings", settings);
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
                if (settings.getHeaderTableSize() != -1) {
                    this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
                }
                frameHeader(0, 0, 4, 1);
                this.sink.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            this.closed = true;
            this.sink.close();
        }
    }

    public final void connectionPreface() {
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (this.client) {
                    Logger logger2 = logger;
                    if (logger2.isLoggable(Level.FINE)) {
                        logger2.fine(_UtilJvmKt.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.e(), new Object[0]));
                    }
                    this.sink.B(Http2.CONNECTION_PREFACE);
                    this.sink.flush();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void data(boolean z10, int i10, l lVar, int i11) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            dataFrame(i10, z10 ? 1 : 0, lVar, i11);
        }
    }

    public final void dataFrame(int i10, int i11, l lVar, int i12) {
        frameHeader(i10, i12, 0, i11);
        if (i12 > 0) {
            m mVar = this.sink;
            za.h.b(lVar);
            mVar.write(lVar, i12);
        }
    }

    public final void flush() {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.sink.flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void frameHeader(int r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            r0 = 8
            if (r11 == r0) goto L1d
            java.util.logging.Logger r0 = okhttp3.internal.http2.Http2Writer.logger
            java.util.logging.Level r1 = java.util.logging.Level.FINE
            boolean r1 = r0.isLoggable(r1)
            if (r1 == 0) goto L1d
            okhttp3.internal.http2.Http2 r2 = okhttp3.internal.http2.Http2.INSTANCE
            r3 = 0
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            java.lang.String r9 = r2.frameLog(r3, r4, r5, r6, r7)
            r0.fine(r9)
            goto L21
        L1d:
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
        L21:
            int r9 = r8.maxFrameSize
            if (r5 > r9) goto L57
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r9 & r4
            if (r9 != 0) goto L47
            rb.m r9 = r8.sink
            okhttp3.internal._UtilCommonKt.writeMedium(r9, r5)
            rb.m r9 = r8.sink
            r10 = r6 & 255(0xff, float:3.57E-43)
            r9.writeByte(r10)
            rb.m r9 = r8.sink
            r10 = r7 & 255(0xff, float:3.57E-43)
            r9.writeByte(r10)
            rb.m r9 = r8.sink
            r10 = 2147483647(0x7fffffff, float:NaN)
            r10 = r10 & r4
            r9.writeInt(r10)
            return
        L47:
            java.lang.String r9 = "reserved bit set: "
            java.lang.String r9 = android.support.v4.media.d.m(r4, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L57:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "FRAME_SIZE_ERROR length > "
            r9.<init>(r10)
            int r10 = r8.maxFrameSize
            r9.append(r10)
            java.lang.String r10 = ": "
            r9.append(r10)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Writer.frameHeader(int, int, int, int):void");
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final void goAway(int i10, ErrorCode errorCode, byte[] bArr) {
        za.h.e("errorCode", errorCode);
        za.h.e("debugData", bArr);
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            frameHeader(0, bArr.length + 8, 7, 0);
            this.sink.writeInt(i10);
            this.sink.writeInt(errorCode.getHttpCode());
            if (bArr.length != 0) {
                this.sink.write(bArr);
            }
            this.sink.flush();
        }
    }

    public final void headers(boolean z10, int i10, List<Header> list) {
        za.h.e("headerBlock", list);
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(list);
            long j10 = this.hpackBuffer.f11035p;
            long min = Math.min(this.maxFrameSize, j10);
            int i11 = j10 == min ? 4 : 0;
            if (z10) {
                i11 |= 1;
            }
            frameHeader(i10, (int) min, 1, i11);
            this.sink.write(this.hpackBuffer, min);
            if (j10 > min) {
                writeContinuationFrames(i10, j10 - min);
            }
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final void ping(boolean z10, int i10, int i11) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            frameHeader(0, 8, 6, z10 ? 1 : 0);
            this.sink.writeInt(i10);
            this.sink.writeInt(i11);
            this.sink.flush();
        }
    }

    public final void pushPromise(int i10, int i11, List<Header> list) {
        za.h.e("requestHeaders", list);
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(list);
            long j10 = this.hpackBuffer.f11035p;
            int min = (int) Math.min(this.maxFrameSize - 4, j10);
            long j11 = min;
            frameHeader(i10, min + 4, 5, j10 == j11 ? 4 : 0);
            this.sink.writeInt(i11 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j11);
            if (j10 > j11) {
                writeContinuationFrames(i10, j10 - j11);
            }
        }
    }

    public final void rstStream(int i10, ErrorCode errorCode) {
        za.h.e("errorCode", errorCode);
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            frameHeader(i10, 4, 3, 0);
            this.sink.writeInt(errorCode.getHttpCode());
            this.sink.flush();
        }
    }

    public final void settings(Settings settings) {
        za.h.e("settings", settings);
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                frameHeader(0, settings.size() * 6, 4, 0);
                for (int i10 = 0; i10 < 10; i10++) {
                    if (settings.isSet(i10)) {
                        this.sink.writeShort(i10);
                        this.sink.writeInt(settings.get(i10));
                    }
                }
                this.sink.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void windowUpdate(int i10, long j10) {
        int i11;
        long j11;
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (j10 == 0 || j10 > 2147483647L) {
                    throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j10).toString());
                }
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    i11 = i10;
                    j11 = j10;
                    logger2.fine(Http2.INSTANCE.frameLogWindowUpdate(false, i11, 4, j11));
                } else {
                    i11 = i10;
                    j11 = j10;
                }
                frameHeader(i11, 4, 8, 0);
                this.sink.writeInt((int) j11);
                this.sink.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
