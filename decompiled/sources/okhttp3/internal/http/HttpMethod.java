package okhttp3.internal.http;

import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean invalidatesCache(String str) {
        h.e("method", str);
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static final boolean permitsRequestBody(String str) {
        h.e("method", str);
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(String str) {
        h.e("method", str);
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("QUERY") || str.equals("REPORT");
    }

    public final boolean isCacheable(String str) {
        h.e("requestMethod", str);
        return str.equals("GET") || str.equals("QUERY");
    }

    public final boolean redirectsToGet(String str) {
        h.e("method", str);
        return !str.equals("PROPFIND");
    }

    public final boolean redirectsWithBody(String str) {
        h.e("method", str);
        return str.equals("PROPFIND");
    }
}
