package j5;

import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", "samsung-agent/1").build());
    }
}
