package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Hpack;
import rb.l;
import rb.n;
import rb.o;
import rb.s0;
import rb.v0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final n source;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(za.e eVar) {
            this();
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i10, int i11, int i12) {
            if ((i11 & 8) != 0) {
                i10--;
            }
            if (i12 <= i10) {
                return i10 - i12;
            }
            throw new IOException(android.support.v4.media.d.p("PROTOCOL_ERROR padding ", " > remaining length ", i12, i10));
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public interface Handler {
        void ackSettings();

        void alternateService(int i10, String str, o oVar, String str2, int i11, long j10);

        void data(boolean z10, int i10, n nVar, int i11);

        void goAway(int i10, ErrorCode errorCode, o oVar);

        void headers(boolean z10, int i10, int i11, List<Header> list);

        void ping(boolean z10, int i10, int i11);

        void priority(int i10, int i11, int i12, boolean z10);

        void pushPromise(int i10, int i11, List<Header> list);

        void rstStream(int i10, ErrorCode errorCode);

        void settings(boolean z10, Settings settings);

        void windowUpdate(int i10, long j10);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        za.h.d("getLogger(...)", logger2);
        logger = logger2;
    }

    public Http2Reader(n nVar, boolean z10) {
        za.h.e("source", nVar);
        this.source = nVar;
        this.client = z10;
        ContinuationSource continuationSource = new ContinuationSource(nVar);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z10 = (i11 & 1) != 0;
        if ((i11 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int and = (i11 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        handler.data(z10, i12, this.source, Companion.lengthWithoutPadding(i10, i11, and));
        this.source.skip(and);
    }

    private final void readGoAway(Handler handler, int i10, int i11, int i12) {
        if (i10 < 8) {
            throw new IOException(android.support.v4.media.d.m(i10, "TYPE_GOAWAY length < 8: "));
        }
        if (i12 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int readInt = this.source.readInt();
        int readInt2 = this.source.readInt();
        int i13 = i10 - 8;
        ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt2);
        if (fromHttp2 == null) {
            throw new IOException(android.support.v4.media.d.m(readInt2, "TYPE_GOAWAY unexpected error code: "));
        }
        o oVar = o.f11048r;
        if (i13 > 0) {
            oVar = this.source.i(i13);
        }
        handler.goAway(readInt, fromHttp2, oVar);
    }

    private final List<Header> readHeaderBlock(int i10, int i11, int i12, int i13) {
        this.continuation.setLeft(i10);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i11);
        this.continuation.setFlags(i12);
        this.continuation.setStreamId(i13);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z10 = (i11 & 1) != 0;
        int and = (i11 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        if ((i11 & 32) != 0) {
            readPriority(handler, i12);
            i10 -= 5;
        }
        handler.headers(z10, i12, -1, readHeaderBlock(Companion.lengthWithoutPadding(i10, i11, and), and, i11, i12));
    }

    private final void readPing(Handler handler, int i10, int i11, int i12) {
        if (i10 != 8) {
            throw new IOException(android.support.v4.media.d.m(i10, "TYPE_PING length != 8: "));
        }
        if (i12 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.ping((i11 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void readPriority(Handler handler, int i10, int i11, int i12) {
        if (i10 != 5) {
            throw new IOException(android.support.v4.media.d.o("TYPE_PRIORITY length: ", i10, " != 5"));
        }
        if (i12 == 0) {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        readPriority(handler, i12);
    }

    private final void readPushPromise(Handler handler, int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int and = (i11 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        handler.pushPromise(i12, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i10 - 4, i11, and), and, i11, i12));
    }

    private final void readRstStream(Handler handler, int i10, int i11, int i12) {
        if (i10 != 4) {
            throw new IOException(android.support.v4.media.d.o("TYPE_RST_STREAM length: ", i10, " != 4"));
        }
        if (i12 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int readInt = this.source.readInt();
        ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt);
        if (fromHttp2 == null) {
            throw new IOException(android.support.v4.media.d.m(readInt, "TYPE_RST_STREAM unexpected error code: "));
        }
        handler.rstStream(i12, fromHttp2);
    }

    private final void readSettings(Handler handler, int i10, int i11, int i12) {
        int readInt;
        if (i12 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i11 & 1) != 0) {
            if (i10 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.ackSettings();
            return;
        }
        if (i10 % 6 != 0) {
            throw new IOException(android.support.v4.media.d.m(i10, "TYPE_SETTINGS length % 6 != 0: "));
        }
        Settings settings = new Settings();
        db.a x6 = k5.a.x(k5.a.y(0, i10), 6);
        int i13 = x6.f4350o;
        int i14 = x6.f4351p;
        int i15 = x6.f4352q;
        if ((i15 > 0 && i13 <= i14) || (i15 < 0 && i14 <= i13)) {
            while (true) {
                int and = _UtilCommonKt.and(this.source.readShort(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                readInt = this.source.readInt();
                if (and != 2) {
                    if (and != 4) {
                        if (and == 5 && (readInt < 16384 || readInt > 16777215)) {
                            break;
                        }
                    } else if (readInt < 0) {
                        throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                    }
                } else if (readInt != 0 && readInt != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                settings.set(and, readInt);
                if (i13 == i14) {
                    break;
                } else {
                    i13 += i15;
                }
            }
            throw new IOException(android.support.v4.media.d.m(readInt, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
        }
        handler.settings(false, settings);
    }

    private final void readWindowUpdate(Handler handler, int i10, int i11, int i12) {
        int i13;
        try {
            if (i10 != 4) {
                throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i10);
            }
            try {
                long and = _UtilCommonKt.and(this.source.readInt(), 2147483647L);
                if (and == 0) {
                    throw new IOException("windowSizeIncrement was 0");
                }
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    i13 = i12;
                    logger2.fine(Http2.INSTANCE.frameLogWindowUpdate(true, i12, i10, and));
                } else {
                    i13 = i12;
                }
                handler.windowUpdate(i13, and);
            } catch (Exception e7) {
                e = e7;
                Exception exc = e;
                logger.fine(Http2.INSTANCE.frameLog(true, i12, i10, 8, i11));
                throw exc;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }

    public final boolean nextFrame(boolean z10, Handler handler) {
        za.h.e("handler", handler);
        try {
            this.source.D(9L);
            int readMedium = _UtilCommonKt.readMedium(this.source);
            if (readMedium > 16384) {
                throw new IOException(android.support.v4.media.d.m(readMedium, "FRAME_SIZE_ERROR: "));
            }
            int and = _UtilCommonKt.and(this.source.readByte(), 255);
            int and2 = _UtilCommonKt.and(this.source.readByte(), 255);
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            if (and != 8) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.INSTANCE.frameLog(true, readInt, readMedium, and, and2));
                }
            }
            if (z10 && and != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(and));
            }
            switch (and) {
                case 0:
                    readData(handler, readMedium, and2, readInt);
                    return true;
                case 1:
                    readHeaders(handler, readMedium, and2, readInt);
                    return true;
                case 2:
                    readPriority(handler, readMedium, and2, readInt);
                    return true;
                case 3:
                    readRstStream(handler, readMedium, and2, readInt);
                    return true;
                case 4:
                    readSettings(handler, readMedium, and2, readInt);
                    return true;
                case 5:
                    readPushPromise(handler, readMedium, and2, readInt);
                    return true;
                case 6:
                    readPing(handler, readMedium, and2, readInt);
                    return true;
                case 7:
                    readGoAway(handler, readMedium, and2, readInt);
                    return true;
                case 8:
                    readWindowUpdate(handler, readMedium, and2, readInt);
                    return true;
                default:
                    this.source.skip(readMedium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(Handler handler) {
        za.h.e("handler", handler);
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        n nVar = this.source;
        o oVar = Http2.CONNECTION_PREFACE;
        o i10 = nVar.i(oVar.d());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(_UtilJvmKt.format("<< CONNECTION " + i10.e(), new Object[0]));
        }
        if (!oVar.equals(i10)) {
            throw new IOException("Expected a connection header but was ".concat(i10.r()));
        }
    }

    private final void readPriority(Handler handler, int i10) {
        int readInt = this.source.readInt();
        handler.priority(i10, readInt & Integer.MAX_VALUE, _UtilCommonKt.and(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class ContinuationSource implements s0 {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final n source;
        private int streamId;

        public ContinuationSource(n nVar) {
            za.h.e("source", nVar);
            this.source = nVar;
        }

        private final void readContinuationHeader() {
            int i10 = this.streamId;
            int readMedium = _UtilCommonKt.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            int and = _UtilCommonKt.and(this.source.readByte(), 255);
            this.flags = _UtilCommonKt.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, and, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (and == 9) {
                if (readInt != i10) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(and + " != TYPE_CONTINUATION");
            }
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // rb.s0
        public long read(l lVar, long j10) {
            za.h.e("sink", lVar);
            while (true) {
                int i10 = this.left;
                if (i10 != 0) {
                    long read = this.source.read(lVar, Math.min(j10, i10));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left -= (int) read;
                    return read;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        public final void setFlags(int i10) {
            this.flags = i10;
        }

        public final void setLeft(int i10) {
            this.left = i10;
        }

        public final void setLength(int i10) {
            this.length = i10;
        }

        public final void setPadding(int i10) {
            this.padding = i10;
        }

        public final void setStreamId(int i10) {
            this.streamId = i10;
        }

        @Override // rb.s0
        public v0 timeout() {
            return this.source.timeout();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
