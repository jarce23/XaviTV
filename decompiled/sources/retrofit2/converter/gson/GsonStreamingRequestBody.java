package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rb.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
final class GsonStreamingRequestBody<T> extends RequestBody {
    private final TypeAdapter<T> adapter;
    private final Gson gson;
    private final T value;

    public GsonStreamingRequestBody(Gson gson, TypeAdapter<T> typeAdapter, T t3) {
        this.gson = gson;
        this.adapter = typeAdapter;
        this.value = t3;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return GsonRequestBodyConverter.MEDIA_TYPE;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(m mVar) {
        GsonRequestBodyConverter.writeJson(mVar, this.gson, this.adapter, this.value);
    }
}
