package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rb.l;
import rb.m;
import retrofit2.Converter;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    private final TypeAdapter<T> adapter;
    private final Gson gson;
    private final boolean streaming;

    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter, boolean z10) {
        this.gson = gson;
        this.adapter = typeAdapter;
        this.streaming = z10;
    }

    public static <T> void writeJson(m mVar, Gson gson, TypeAdapter<T> typeAdapter, T t3) {
        JsonWriter newJsonWriter = gson.newJsonWriter(new OutputStreamWriter(mVar.G(), StandardCharsets.UTF_8));
        typeAdapter.write(newJsonWriter, t3);
        newJsonWriter.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) {
        return convert((GsonRequestBodyConverter<T>) obj);
    }

    @Override // retrofit2.Converter
    public RequestBody convert(T t3) {
        if (this.streaming) {
            return new GsonStreamingRequestBody(this.gson, this.adapter, t3);
        }
        l lVar = new l();
        writeJson(lVar, this.gson, this.adapter, t3);
        return RequestBody.create(MEDIA_TYPE, lVar.i(lVar.f11035p));
    }
}
