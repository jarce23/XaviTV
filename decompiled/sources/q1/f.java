package q1;

import android.net.Uri;
import i1.b0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import l1.a0;
import l1.v;
import o1.l;
import o1.y;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends o1.c {
    public final v A;
    public final int B;
    public boolean C;
    public long D;
    public UrlRequest E;
    public e F;
    public l G;
    public ByteBuffer H;
    public UrlResponseInfo I;
    public IOException J;
    public boolean K;
    public volatile long L;

    /* renamed from: s, reason: collision with root package name */
    public final CronetEngine f10232s;

    /* renamed from: t, reason: collision with root package name */
    public final Executor f10233t;

    /* renamed from: u, reason: collision with root package name */
    public final int f10234u;

    /* renamed from: v, reason: collision with root package name */
    public final int f10235v;

    /* renamed from: w, reason: collision with root package name */
    public final int f10236w;

    /* renamed from: x, reason: collision with root package name */
    public final j5.g f10237x;

    /* renamed from: y, reason: collision with root package name */
    public final j5.g f10238y;

    /* renamed from: z, reason: collision with root package name */
    public final l1.g f10239z;

    static {
        b0.a("media3.datasource.cronet");
    }

    public f(CronetEngine cronetEngine, Executor executor, int i10, int i11, int i12, j5.g gVar, int i13) {
        super(true);
        this.f10232s = cronetEngine;
        executor.getClass();
        this.f10233t = executor;
        this.f10234u = i10;
        this.f10235v = i11;
        this.f10236w = i12;
        this.f10237x = gVar;
        this.A = v.f8135a;
        this.B = i13;
        this.f10238y = new j5.g(13);
        this.f10239z = new l1.g();
    }

    public static String u(String str, Map map) {
        List list = (List) map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    @Override // o1.h
    public final synchronized void close() {
        try {
            UrlRequest urlRequest = this.E;
            if (urlRequest != null) {
                urlRequest.cancel();
                this.E = null;
            }
            e eVar = this.F;
            if (eVar != null) {
                eVar.f10230a = true;
                this.F = null;
            }
            ByteBuffer byteBuffer = this.H;
            if (byteBuffer != null) {
                byteBuffer.limit(0);
            }
            this.G = null;
            this.I = null;
            this.J = null;
            this.K = false;
            if (this.C) {
                this.C = false;
                q();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // o1.c, o1.h
    public final Map e() {
        UrlResponseInfo urlResponseInfo = this.I;
        return urlResponseInfo == null ? Collections.EMPTY_MAP : urlResponseInfo.getAllHeaders();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b4, code lost:
    
        if (r5 != 0) goto L32;
     */
    @Override // o1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long j(o1.l r20) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.f.j(o1.l):long");
    }

    @Override // o1.h
    public final Uri l() {
        UrlResponseInfo urlResponseInfo = this.I;
        if (urlResponseInfo != null) {
            return Uri.parse(urlResponseInfo.getUrl());
        }
        l lVar = this.G;
        if (lVar != null) {
            return lVar.f9428a;
        }
        return null;
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        l1.d.g(this.C);
        if (i11 == 0) {
            return 0;
        }
        if (this.D == 0) {
            return -1;
        }
        ByteBuffer v10 = v();
        if (!v10.hasRemaining()) {
            this.f10239z.e();
            v10.clear();
            int i12 = a0.f8067a;
            w(v10);
            if (this.K) {
                this.D = 0L;
                return -1;
            }
            v10.flip();
            l1.d.g(v10.hasRemaining());
        }
        long j10 = this.D;
        if (j10 == -1) {
            j10 = Long.MAX_VALUE;
        }
        long[] jArr = {j10, v10.remaining(), i11};
        long j11 = jArr[0];
        for (int i13 = 1; i13 < 3; i13++) {
            long j12 = jArr[i13];
            if (j12 < j11) {
                j11 = j12;
            }
        }
        int i14 = (int) j11;
        v10.get(bArr, i10, i14);
        long j13 = this.D;
        if (j13 != -1) {
            this.D = j13 - i14;
        }
        f(i14);
        return i14;
    }

    public final void t(l lVar) {
        this.F = new e(this);
        Uri uri = lVar.f9428a;
        byte[] bArr = lVar.f9431d;
        String uri2 = uri.toString();
        e eVar = this.F;
        CronetEngine cronetEngine = this.f10232s;
        Executor executor = this.f10233t;
        UrlRequest.Builder allowDirectExecutor = cronetEngine.newUrlRequestBuilder(uri2, eVar, executor).setPriority(this.f10234u).allowDirectExecutor();
        HashMap hashMap = new HashMap();
        j5.g gVar = this.f10237x;
        if (gVar != null) {
            hashMap.putAll(gVar.o());
        }
        hashMap.putAll(this.f10238y.o());
        hashMap.putAll(lVar.f9432e);
        for (Map.Entry entry : hashMap.entrySet()) {
            allowDirectExecutor.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        if (bArr != null && !hashMap.containsKey("Content-Type")) {
            throw new d("HTTP request with non-empty body must set Content-Type", 1004);
        }
        String a10 = y.a(lVar.f9433f, lVar.g);
        if (a10 != null) {
            allowDirectExecutor.addHeader("Range", a10);
        }
        allowDirectExecutor.setHttpMethod(l.b(lVar.f9430c));
        if (bArr != null) {
            allowDirectExecutor.setUploadDataProvider(new a(bArr), executor);
        }
        this.E = allowDirectExecutor.build();
    }

    public final ByteBuffer v() {
        if (this.H == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.B);
            this.H = allocateDirect;
            allocateDirect.limit(0);
        }
        return this.H;
    }

    public final void w(ByteBuffer byteBuffer) {
        UrlRequest urlRequest = this.E;
        int i10 = a0.f8067a;
        urlRequest.read(byteBuffer);
        try {
        } catch (InterruptedException unused) {
            if (byteBuffer == this.H) {
                this.H = null;
            }
            Thread.currentThread().interrupt();
            this.J = new InterruptedIOException();
        } catch (SocketTimeoutException e7) {
            if (byteBuffer == this.H) {
                this.H = null;
            }
            this.J = new o1.v(e7, 2002, 2);
        }
        if (!this.f10239z.b(this.f10236w)) {
            throw new SocketTimeoutException();
        }
        IOException iOException = this.J;
        if (iOException != null) {
            if (!(iOException instanceof o1.v)) {
                throw o1.v.a(iOException, 2);
            }
            throw ((o1.v) iOException);
        }
    }

    public final byte[] x() {
        byte[] bArr = a0.f8069c;
        ByteBuffer v10 = v();
        while (!this.K) {
            this.f10239z.e();
            v10.clear();
            w(v10);
            v10.flip();
            if (v10.remaining() > 0) {
                int length = bArr.length;
                bArr = Arrays.copyOf(bArr, v10.remaining() + bArr.length);
                v10.get(bArr, length, v10.remaining());
            }
        }
        return bArr;
    }
}
