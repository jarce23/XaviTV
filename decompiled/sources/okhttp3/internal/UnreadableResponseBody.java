package okhttp3.internal;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import rb.l;
import rb.n;
import rb.s0;
import rb.v0;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class UnreadableResponseBody extends ResponseBody implements s0 {
    private final long contentLength;
    private final MediaType mediaType;

    public UnreadableResponseBody(MediaType mediaType, long j10) {
        this.mediaType = mediaType;
        this.contentLength = j10;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.mediaType;
    }

    @Override // rb.s0
    public long read(l lVar, long j10) {
        h.e("sink", lVar);
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    @Override // okhttp3.ResponseBody
    public n source() {
        return rb.b.c(this);
    }

    @Override // rb.s0
    public v0 timeout() {
        return v0.NONE;
    }

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
