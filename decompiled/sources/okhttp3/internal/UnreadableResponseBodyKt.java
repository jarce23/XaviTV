package okhttp3.internal;

import okhttp3.Response;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class UnreadableResponseBodyKt {
    public static final Response stripBody(Response response) {
        h.e("<this>", response);
        return response.newBuilder().body(new UnreadableResponseBody(response.body().contentType(), response.body().contentLength())).build();
    }
}
