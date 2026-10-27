package okhttp3;

import android.support.v4.media.d;
import j9.w1;
import java.io.Closeable;
import java.io.EOFException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http1.HeadersReader;
import rb.h0;
import rb.l;
import rb.n;
import rb.o;
import rb.s0;
import rb.u0;
import rb.v0;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final h0 afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final o crlfDashDashBoundary;
    private PartSource currentPart;
    private final o dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final n source;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final h0 getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Part implements Closeable {
        private final n body;
        private final Headers headers;

        public Part(Headers headers, n nVar) {
            h.e("headers", headers);
            h.e("body", nVar);
            this.headers = headers;
            this.body = nVar;
        }

        public final n body() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.body.close();
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class PartSource implements s0 {
        private final v0 timeout = new v0();

        public PartSource() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (h.a(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override // rb.s0
        public long read(l lVar, long j10) {
            long j11;
            h.e("sink", lVar);
            if (j10 < 0) {
                throw new IllegalArgumentException(d.n(j10, "byteCount < 0: ").toString());
            }
            if (!h.a(MultipartReader.this.currentPart, this)) {
                throw new IllegalStateException("closed");
            }
            v0 timeout = MultipartReader.this.source.timeout();
            v0 v0Var = this.timeout;
            MultipartReader multipartReader = MultipartReader.this;
            long timeoutNanos = timeout.timeoutNanos();
            u0 u0Var = v0.Companion;
            long timeoutNanos2 = v0Var.timeoutNanos();
            long timeoutNanos3 = timeout.timeoutNanos();
            u0Var.getClass();
            if (timeoutNanos2 == 0 || (timeoutNanos3 != 0 && timeoutNanos2 >= timeoutNanos3)) {
                timeoutNanos2 = timeoutNanos3;
            }
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            timeout.timeout(timeoutNanos2, timeUnit);
            if (!timeout.hasDeadline()) {
                if (v0Var.hasDeadline()) {
                    timeout.deadlineNanoTime(v0Var.deadlineNanoTime());
                }
                try {
                    long currentPartBytesRemaining = multipartReader.currentPartBytesRemaining(j10);
                    long read = currentPartBytesRemaining == 0 ? -1L : multipartReader.source.read(lVar, currentPartBytesRemaining);
                    timeout.timeout(timeoutNanos, timeUnit);
                    if (v0Var.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                    return read;
                } catch (Throwable th) {
                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (v0Var.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                    throw th;
                }
            }
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (v0Var.hasDeadline()) {
                j11 = deadlineNanoTime;
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), v0Var.deadlineNanoTime()));
            } else {
                j11 = deadlineNanoTime;
            }
            try {
                long currentPartBytesRemaining2 = multipartReader.currentPartBytesRemaining(j10);
                long read2 = currentPartBytesRemaining2 == 0 ? -1L : multipartReader.source.read(lVar, currentPartBytesRemaining2);
                timeout.timeout(timeoutNanos, timeUnit);
                if (v0Var.hasDeadline()) {
                    timeout.deadlineNanoTime(j11);
                }
                return read2;
            } catch (Throwable th2) {
                long j12 = j11;
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (v0Var.hasDeadline()) {
                    timeout.deadlineNanoTime(j12);
                }
                throw th2;
            }
        }

        @Override // rb.s0
        public v0 timeout() {
            return this.timeout;
        }
    }

    static {
        o oVar = o.f11048r;
        afterBoundaryOptions = rb.b.f(w1.F("\r\n"), w1.F("--"), w1.F(" "), w1.F("\t"));
    }

    public MultipartReader(n nVar, String str) {
        h.e("source", nVar);
        h.e("boundary", str);
        this.source = nVar;
        this.boundary = str;
        l lVar = new l();
        lVar.e0("--");
        lVar.e0(str);
        this.dashDashBoundary = lVar.i(lVar.f11035p);
        l lVar2 = new l();
        lVar2.e0("\r\n--");
        lVar2.e0(str);
        this.crlfDashDashBoundary = lVar2.i(lVar2.f11035p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentPartBytesRemaining(long j10) {
        long min = Math.min(this.source.b().f11035p, j10) + 1;
        long L = this.source.L(min, this.crlfDashDashBoundary);
        if (L != -1) {
            return L;
        }
        if (this.source.b().f11035p >= min) {
            return Math.min(min, j10);
        }
        throw new EOFException();
    }

    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    public final Part nextPart() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.u(0L, this.dashDashBoundary)) {
            this.source.skip(this.dashDashBoundary.d());
        } else {
            while (true) {
                long currentPartBytesRemaining = currentPartBytesRemaining(8192L);
                if (currentPartBytesRemaining == 0) {
                    break;
                }
                this.source.skip(currentPartBytesRemaining);
            }
            this.source.skip(this.crlfDashDashBoundary.d());
        }
        boolean z10 = false;
        while (true) {
            int e7 = this.source.e(afterBoundaryOptions);
            if (e7 == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (e7 == 0) {
                this.partCount++;
                Headers readHeaders = new HeadersReader(this.source).readHeaders();
                PartSource partSource = new PartSource();
                this.currentPart = partSource;
                return new Part(readHeaders, rb.b.c(partSource));
            }
            if (e7 == 1) {
                if (z10) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.partCount == 0) {
                    throw new ProtocolException("expected at least 1 part");
                }
                this.noMoreParts = true;
                return null;
            }
            if (e7 == 2 || e7 == 3) {
                z10 = true;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MultipartReader(okhttp3.ResponseBody r3) {
        /*
            r2 = this;
            java.lang.String r0 = "response"
            za.h.e(r0, r3)
            rb.n r0 = r3.source()
            okhttp3.MediaType r3 = r3.contentType()
            if (r3 == 0) goto L1b
            java.lang.String r1 = "boundary"
            java.lang.String r3 = r3.parameter(r1)
            if (r3 == 0) goto L1b
            r2.<init>(r0, r3)
            return
        L1b:
            java.net.ProtocolException r3 = new java.net.ProtocolException
            java.lang.String r0 = "expected the Content-Type to have a boundary parameter"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartReader.<init>(okhttp3.ResponseBody):void");
    }
}
