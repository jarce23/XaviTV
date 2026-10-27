package com.bumptech.glide.load.data;

import a6.d0;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements d {

    /* renamed from: o, reason: collision with root package name */
    public final x5.j f3052o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3053p;

    /* renamed from: q, reason: collision with root package name */
    public HttpURLConnection f3054q;

    /* renamed from: r, reason: collision with root package name */
    public InputStream f3055r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f3056s;

    public j(x5.j jVar, int i10) {
        this.f3052o = jVar;
        this.f3053p = i10;
    }

    public static int e(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e7) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e7);
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        InputStream inputStream = this.f3055r;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f3054q;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f3054q = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public final int c() {
        return 2;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        this.f3056s = true;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(com.bumptech.glide.i iVar, c cVar) {
        x5.j jVar = this.f3052o;
        int i10 = m6.h.f9016b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            try {
                if (jVar.f13649f == null) {
                    jVar.f13649f = new URL(jVar.d());
                }
                cVar.p(f(jVar.f13649f, 0, null, jVar.f13645b.a()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + m6.h.a(elapsedRealtimeNanos));
                }
            } catch (IOException e7) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e7);
                }
                cVar.l(e7);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + m6.h.a(elapsedRealtimeNanos));
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + m6.h.a(elapsedRealtimeNanos));
            }
            throw th;
        }
    }

    public final InputStream f(URL url, int i10, URL url2, Map map) {
        if (i10 >= 5) {
            throw new d0(-1, null, "Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new d0(-1, null, "In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        int i11 = this.f3053p;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setConnectTimeout(i11);
            httpURLConnection.setReadTimeout(i11);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            this.f3054q = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.f3055r = this.f3054q.getInputStream();
                if (this.f3056s) {
                    return null;
                }
                int e7 = e(this.f3054q);
                int i12 = e7 / 100;
                if (i12 == 2) {
                    HttpURLConnection httpURLConnection2 = this.f3054q;
                    try {
                        if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            this.f3055r = new m6.d(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                            }
                            this.f3055r = httpURLConnection2.getInputStream();
                        }
                        return this.f3055r;
                    } catch (IOException e8) {
                        throw new d0(e(httpURLConnection2), e8, "Failed to obtain InputStream");
                    }
                }
                if (i12 != 3) {
                    if (e7 == -1) {
                        throw new d0(e7, null, "Http request failed");
                    }
                    try {
                        throw new d0(e7, null, this.f3054q.getResponseMessage());
                    } catch (IOException e10) {
                        throw new d0(e7, e10, "Failed to get a response message");
                    }
                }
                String headerField = this.f3054q.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new d0(e7, null, "Received empty or null redirect url");
                }
                try {
                    URL url3 = new URL(url, headerField);
                    b();
                    return f(url3, i10 + 1, url, map);
                } catch (MalformedURLException e11) {
                    throw new d0(e7, e11, r.a.l("Bad redirect url: ", headerField));
                }
            } catch (IOException e12) {
                throw new d0(e(this.f3054q), e12, "Failed to connect or obtain data");
            }
        } catch (IOException e13) {
            throw new d0(0, e13, "URL.openConnection threw");
        }
    }
}
