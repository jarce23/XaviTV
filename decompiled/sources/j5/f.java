package j5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static OkHttpClient f7112a;

    public static a a(String str) {
        OkHttpClient okHttpClient;
        Gson create = new GsonBuilder().setLenient().create();
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(str);
        synchronized (f.class) {
            okHttpClient = f7112a;
            if (okHttpClient == null) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                e eVar = new e();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                okHttpClient = new OkHttpClient.Builder().connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).addInterceptor(eVar).addInterceptor(httpLoggingInterceptor).build();
                f7112a = okHttpClient;
            }
        }
        return (a) baseUrl.client(okHttpClient).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create(create)).build().create(a.class);
    }
}
