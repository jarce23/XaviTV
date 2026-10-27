package okhttp3;

import gb.p;
import java.util.ArrayList;
import ma.j;
import okhttp3.Interceptor;
import okhttp3.internal.http.HttpHeaders;
import rb.n;
import rb.s0;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CompressionInterceptor implements Interceptor {
    private final String acceptEncoding;
    private final DecompressionAlgorithm[] algorithms;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public interface DecompressionAlgorithm {
        s0 decompress(n nVar);

        String getEncoding();
    }

    public CompressionInterceptor(DecompressionAlgorithm... decompressionAlgorithmArr) {
        h.e("algorithms", decompressionAlgorithmArr);
        this.algorithms = decompressionAlgorithmArr;
        ArrayList arrayList = new ArrayList(decompressionAlgorithmArr.length);
        for (DecompressionAlgorithm decompressionAlgorithm : decompressionAlgorithmArr) {
            arrayList.add(decompressionAlgorithm.getEncoding());
        }
        this.acceptEncoding = j.F(arrayList, ", ", null, null, null, 62);
    }

    public final Response decompress$okhttp(Response response) {
        DecompressionAlgorithm lookupDecompressor$okhttp;
        h.e("response", response);
        if (HttpHeaders.promisesBody(response)) {
            ResponseBody body = response.body();
            String header$default = Response.header$default(response, "Content-Encoding", null, 2, null);
            if (header$default != null && (lookupDecompressor$okhttp = lookupDecompressor$okhttp(header$default)) != null) {
                return response.newBuilder().removeHeader("Content-Encoding").removeHeader("Content-Length").body(ResponseBody.Companion.create(rb.b.c(lookupDecompressor$okhttp.decompress(body.source())), body.contentType(), -1L)).build();
            }
        }
        return response;
    }

    public final String getAcceptEncoding$okhttp() {
        return this.acceptEncoding;
    }

    public final DecompressionAlgorithm[] getAlgorithms() {
        return this.algorithms;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        h.e("chain", chain);
        return ((this.algorithms.length == 0) || chain.request().header("Accept-Encoding") != null) ? chain.proceed(chain.request()) : decompress$okhttp(chain.proceed(chain.request().newBuilder().header("Accept-Encoding", this.acceptEncoding).build()));
    }

    public final DecompressionAlgorithm lookupDecompressor$okhttp(String str) {
        h.e("encoding", str);
        for (DecompressionAlgorithm decompressionAlgorithm : this.algorithms) {
            if (p.S(decompressionAlgorithm.getEncoding(), str)) {
                return decompressionAlgorithm;
            }
        }
        return null;
    }
}
