package okhttp3.internal.http;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rb.b;
import rb.l0;
import rb.m;
import rb.z;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class GzipRequestBody extends RequestBody {
    private final RequestBody delegate;

    public GzipRequestBody(RequestBody requestBody) {
        h.e("delegate", requestBody);
        this.delegate = requestBody;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return -1L;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.delegate.contentType();
    }

    public final RequestBody getDelegate() {
        return this.delegate;
    }

    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        return this.delegate.isOneShot();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(m mVar) {
        h.e("sink", mVar);
        l0 b2 = b.b(new z(mVar));
        try {
            this.delegate.writeTo(b2);
            b2.close();
        } finally {
        }
    }
}
