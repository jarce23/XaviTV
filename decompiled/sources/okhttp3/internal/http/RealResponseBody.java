package okhttp3.internal.http;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import rb.n;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final n source;

    public RealResponseBody(String str, long j10, n nVar) {
        h.e("source", nVar);
        this.contentTypeString = str;
        this.contentLength = j10;
        this.source = nVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public n source() {
        return this.source;
    }
}
