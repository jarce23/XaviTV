package o1;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import o9.b1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p extends c {
    public InputStream A;
    public boolean B;
    public int C;
    public long D;
    public long E;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f9449s;

    /* renamed from: t, reason: collision with root package name */
    public final int f9450t;

    /* renamed from: u, reason: collision with root package name */
    public final int f9451u;

    /* renamed from: v, reason: collision with root package name */
    public final String f9452v;

    /* renamed from: w, reason: collision with root package name */
    public final j5.g f9453w;

    /* renamed from: x, reason: collision with root package name */
    public final j5.g f9454x;

    /* renamed from: y, reason: collision with root package name */
    public l f9455y;

    /* renamed from: z, reason: collision with root package name */
    public HttpURLConnection f9456z;

    public p(String str, int i10, int i11, boolean z10, j5.g gVar) {
        super(true);
        this.f9452v = str;
        this.f9450t = i10;
        this.f9451u = i11;
        this.f9449s = z10;
        this.f9453w = gVar;
        this.f9454x = new j5.g(13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // o1.h
    public final void close() {
        try {
            InputStream inputStream = this.A;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    int i10 = l1.a0.f8067a;
                    throw new v(e7, 2000, 3);
                }
            }
        } finally {
            this.A = null;
            t();
            if (this.B) {
                this.B = false;
                q();
            }
            this.f9456z = null;
            this.f9455y = null;
        }
    }

    @Override // o1.c, o1.h
    public final Map e() {
        HttpURLConnection httpURLConnection = this.f9456z;
        return httpURLConnection == null ? b1.f9578u : new o(httpURLConnection.getHeaderFields());
    }

    @Override // o1.h
    public final long j(l lVar) {
        this.f9455y = lVar;
        long j10 = 0;
        this.E = 0L;
        this.D = 0L;
        r();
        try {
            HttpURLConnection w10 = w(lVar);
            long j11 = lVar.f9433f;
            long j12 = lVar.g;
            this.f9456z = w10;
            this.C = w10.getResponseCode();
            w10.getResponseMessage();
            int i10 = this.C;
            if (i10 < 200 || i10 > 299) {
                Map<String, List<String>> headerFields = w10.getHeaderFields();
                if (this.C == 416 && j11 == y.d(w10.getHeaderField("Content-Range"))) {
                    this.B = true;
                    s(lVar);
                    if (j12 != -1) {
                        return j12;
                    }
                    return 0L;
                }
                InputStream errorStream = w10.getErrorStream();
                try {
                    if (errorStream != null) {
                        p9.b.b(errorStream);
                    } else {
                        int i11 = l1.a0.f8067a;
                    }
                } catch (IOException unused) {
                    int i12 = l1.a0.f8067a;
                }
                t();
                throw new x(this.C, this.C == 416 ? new i(2008) : null, headerFields);
            }
            w10.getContentType();
            if (this.C == 200 && j11 != 0) {
                j10 = j11;
            }
            boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(w10.getHeaderField("Content-Encoding"));
            if (equalsIgnoreCase) {
                this.D = j12;
            } else if (j12 != -1) {
                this.D = j12;
            } else {
                long b2 = y.b(w10.getHeaderField("Content-Length"), w10.getHeaderField("Content-Range"));
                this.D = b2 != -1 ? b2 - j10 : -1L;
            }
            try {
                this.A = w10.getInputStream();
                if (equalsIgnoreCase) {
                    this.A = new GZIPInputStream(this.A);
                }
                this.B = true;
                s(lVar);
                try {
                    x(j10);
                    return this.D;
                } catch (IOException e7) {
                    t();
                    if (e7 instanceof v) {
                        throw ((v) e7);
                    }
                    throw new v(e7, 2000, 1);
                }
            } catch (IOException e8) {
                t();
                throw new v(e8, 2000, 1);
            }
        } catch (IOException e10) {
            t();
            throw v.a(e10, 1);
        }
    }

    @Override // o1.h
    public final Uri l() {
        HttpURLConnection httpURLConnection = this.f9456z;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        l lVar = this.f9455y;
        if (lVar != null) {
            return lVar.f9428a;
        }
        return null;
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        try {
            long j10 = this.D;
            if (j10 != -1) {
                long j11 = j10 - this.E;
                if (j11 == 0) {
                    return -1;
                }
                i11 = (int) Math.min(i11, j11);
            }
            InputStream inputStream = this.A;
            int i12 = l1.a0.f8067a;
            int read = inputStream.read(bArr, i10, i11);
            if (read != -1) {
                this.E += read;
                f(read);
                return read;
            }
            return -1;
        } catch (IOException e7) {
            int i13 = l1.a0.f8067a;
            throw v.a(e7, 2);
        }
    }

    public final void t() {
        HttpURLConnection httpURLConnection = this.f9456z;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e7) {
                l1.b.h("DefaultHttpDataSource", "Unexpected error while disconnecting", e7);
            }
        }
    }

    public final URL u(URL url, String str) {
        if (str == null) {
            throw new v("Null location redirect", 2001);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new v(r.a.l("Unsupported protocol redirect: ", protocol), 2001);
            }
            if (this.f9449s || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new v("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", 2001);
        } catch (MalformedURLException e7) {
            throw new v(e7, 2001, 1);
        }
    }

    public final HttpURLConnection v(URL url, int i10, byte[] bArr, long j10, long j11, boolean z10, boolean z11, Map map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f9450t);
        httpURLConnection.setReadTimeout(this.f9451u);
        HashMap hashMap = new HashMap();
        j5.g gVar = this.f9453w;
        if (gVar != null) {
            hashMap.putAll(gVar.o());
        }
        hashMap.putAll(this.f9454x.o());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String a10 = y.a(j10, j11);
        if (a10 != null) {
            httpURLConnection.setRequestProperty("Range", a10);
        }
        String str = this.f9452v;
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", z10 ? "gzip" : "identity");
        httpURLConnection.setInstanceFollowRedirects(z11);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(l.b(i10));
        if (bArr == null) {
            httpURLConnection.connect();
            return httpURLConnection;
        }
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
        return httpURLConnection;
    }

    public final HttpURLConnection w(l lVar) {
        HttpURLConnection v10;
        URL url = new URL(lVar.f9428a.toString());
        int i10 = lVar.f9430c;
        byte[] bArr = lVar.f9431d;
        long j10 = lVar.f9433f;
        long j11 = lVar.g;
        int i11 = 1;
        int i12 = 0;
        boolean z10 = (lVar.f9435i & 1) == 1;
        if (!this.f9449s) {
            return v(url, i10, bArr, j10, j11, z10, true, lVar.f9432e);
        }
        while (true) {
            int i13 = i12 + 1;
            if (i12 > 20) {
                throw new v(new NoRouteToHostException(android.support.v4.media.d.m(i13, "Too many redirects: ")), 2001, 1);
            }
            v10 = v(url, i10, bArr, j10, j11, z10, false, lVar.f9432e);
            int responseCode = v10.getResponseCode();
            String headerField = v10.getHeaderField("Location");
            if ((i10 == i11 || i10 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                v10.disconnect();
                url = u(url, headerField);
            } else {
                if (i10 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                v10.disconnect();
                url = u(url, headerField);
                bArr = null;
                i10 = 1;
            }
            i12 = i13;
            i11 = 1;
        }
        return v10;
    }

    public final void x(long j10) {
        if (j10 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j10 > 0) {
            int min = (int) Math.min(j10, 4096);
            InputStream inputStream = this.A;
            int i10 = l1.a0.f8067a;
            int read = inputStream.read(bArr, 0, min);
            if (Thread.currentThread().isInterrupted()) {
                throw new v(new InterruptedIOException(), 2000, 1);
            }
            if (read == -1) {
                throw new v();
            }
            j10 -= read;
            f(read);
        }
    }
}
