package q5;

import a6.d0;
import android.util.Log;
import com.bumptech.glide.i;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import m6.f;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import x5.j;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements d, Callback {

    /* renamed from: o, reason: collision with root package name */
    public final Call.Factory f10338o;

    /* renamed from: p, reason: collision with root package name */
    public final j f10339p;

    /* renamed from: q, reason: collision with root package name */
    public m6.d f10340q;

    /* renamed from: r, reason: collision with root package name */
    public ResponseBody f10341r;

    /* renamed from: s, reason: collision with root package name */
    public com.bumptech.glide.load.data.c f10342s;

    /* renamed from: t, reason: collision with root package name */
    public volatile Call f10343t;

    public a(Call.Factory factory, j jVar) {
        this.f10338o = factory;
        this.f10339p = jVar;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        try {
            m6.d dVar = this.f10340q;
            if (dVar != null) {
                dVar.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.f10341r;
        if (responseBody != null) {
            responseBody.close();
        }
        this.f10342s = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public final int c() {
        return 2;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        Call call = this.f10343t;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(i iVar, com.bumptech.glide.load.data.c cVar) {
        Request.Builder url = new Request.Builder().url(this.f10339p.d());
        for (Map.Entry entry : this.f10339p.f13645b.a().entrySet()) {
            url.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        Request build = url.build();
        this.f10342s = cVar;
        this.f10343t = this.f10338o.newCall(build);
        this.f10343t.enqueue(this);
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call call, IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f10342s.l(iOException);
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) {
        this.f10341r = response.body();
        if (!response.isSuccessful()) {
            this.f10342s.l(new d0(response.code(), null, response.message()));
        } else {
            ResponseBody responseBody = this.f10341r;
            f.c("Argument must not be null", responseBody);
            m6.d dVar = new m6.d(this.f10341r.byteStream(), responseBody.contentLength());
            this.f10340q = dVar;
            this.f10342s.p(dVar);
        }
    }
}
