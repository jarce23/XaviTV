package j9;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class v1 implements k9.f, k2.g, k2.p, m0.q, n6.a, r5.f, v6.b, u5.a, v5.a, z1.l, z3.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7475o;

    public /* synthetic */ v1(int i10) {
        this.f7475o = i10;
    }

    public static ArrayList n(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new m5.e((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    public static MediaCodec p(g1 g1Var) {
        String str = ((z1.p) g1Var.f7290o).f14000a;
        Trace.beginSection("createCodec:" + str);
        MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
        Trace.endSection();
        return createByCodecName;
    }

    public static rb.i0 u(String str) {
        za.h.e("<this>", str);
        rb.o oVar = sb.f.f11691a;
        rb.l lVar = new rb.l();
        lVar.e0(str);
        return sb.f.d(lVar, false);
    }

    public static rb.i0 v(File file) {
        String str = rb.i0.f11020p;
        String file2 = file.toString();
        za.h.d("toString(...)", file2);
        return u(file2);
    }

    public static rb.i0 w(Path path) {
        String str = rb.i0.f11020p;
        za.h.e("<this>", path);
        return u(path.toString());
    }

    public static android.graphics.Path x(float f10, float f11, float f12, float f13) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(f10, f11);
        path.lineTo(f12, f13);
        return path;
    }

    public static String y(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // u5.a
    public Bitmap b(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // k9.f
    public /* synthetic */ Object c() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new j0.l(2));
        k5.a.a(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    @Override // u5.a
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    public void g(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // ka.a
    public Object get() {
        switch (this.f7475o) {
            case 17:
                return new a5.a(2, Executors.newSingleThreadExecutor());
            default:
                n7.i iVar = new n7.i(9);
                HashMap hashMap = new HashMap();
                Set set = Collections.EMPTY_SET;
                if (set == null) {
                    throw new NullPointerException("Null flags");
                }
                hashMap.put(p6.c.f10025o, new z6.b(30000L, 86400000L, set));
                if (set == null) {
                    throw new NullPointerException("Null flags");
                }
                hashMap.put(p6.c.f10027q, new z6.b(1000L, 86400000L, set));
                if (set == null) {
                    throw new NullPointerException("Null flags");
                }
                Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(z6.c.f14128o, z6.c.f14129p)));
                if (unmodifiableSet == null) {
                    throw new NullPointerException("Null flags");
                }
                hashMap.put(p6.c.f10026p, new z6.b(86400000L, 86400000L, unmodifiableSet));
                if (hashMap.keySet().size() < p6.c.values().length) {
                    throw new IllegalStateException("Not all priorities have been configured");
                }
                new HashMap();
                return new z6.a(iVar, hashMap);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    @Override // z1.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z1.m h(j9.g1 r6) {
        /*
            r5 = this;
            r0 = 0
            android.media.MediaCodec r0 = p(r6)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.String r1 = "configureCodec"
            android.os.Trace.beginSection(r1)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.Object r1 = r6.f7293r     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.view.Surface r1 = (android.view.Surface) r1     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            if (r1 != 0) goto L25
            java.lang.Object r2 = r6.f7290o     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            z1.p r2 = (z1.p) r2     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            boolean r2 = r2.f14006h     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            if (r2 == 0) goto L25
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r3 = 35
            if (r2 < r3) goto L25
            r2 = 8
            goto L26
        L21:
            r6 = move-exception
            goto L49
        L23:
            r6 = move-exception
            goto L49
        L25:
            r2 = 0
        L26:
            java.lang.Object r3 = r6.f7291p     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.media.MediaFormat r3 = (android.media.MediaFormat) r3     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.Object r4 = r6.f7294s     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.media.MediaCrypto r4 = (android.media.MediaCrypto) r4     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r0.configure(r3, r1, r4, r2)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.os.Trace.endSection()     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.String r1 = "startCodec"
            android.os.Trace.beginSection(r1)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r0.start()     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.os.Trace.endSection()     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            x4.c r1 = new x4.c     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.Object r6 = r6.f7295t     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            z1.k r6 = (z1.k) r6     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r1.<init>(r0, r6)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            return r1
        L49:
            if (r0 == 0) goto L4e
            r0.release()
        L4e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.v1.h(j9.g1):z1.m");
    }

    @Override // n6.a
    public Object j() {
        switch (this.f7475o) {
            case 7:
                return new ArrayList();
            default:
                return new t5.x();
        }
    }

    @Override // v5.a
    public File l(r5.e eVar) {
        return null;
    }

    @Override // z3.b
    public void o() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // k2.p
    public k2.g0 q(int i10, int i11) {
        return new k2.m();
    }

    public n5.a r(m5.i iVar, Map map) {
        int i10 = iVar.f8975p;
        String str = iVar.f8976q;
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(iVar.g());
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int i11 = iVar.f8984y.f2285b;
        httpURLConnection.setConnectTimeout(i11);
        httpURLConnection.setReadTimeout(i11);
        boolean z10 = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        "https".equals(url.getProtocol());
        try {
            for (String str2 : hashMap.keySet()) {
                httpURLConnection.setRequestProperty(str2, (String) hashMap.get(str2));
            }
            if (i10 == 0) {
                httpURLConnection.setRequestMethod("GET");
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("Unknown method type.");
                }
                httpURLConnection.setRequestMethod("POST");
                byte[] d6 = iVar.d();
                if (d6 != null) {
                    httpURLConnection.setDoOutput(true);
                    if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                        httpURLConnection.setRequestProperty("Content-Type", iVar.e());
                    }
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(d6);
                    dataOutputStream.close();
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (i10 == 4 || ((100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304)) {
                n5.a aVar = new n5.a(responseCode, n(httpURLConnection.getHeaderFields()), -1, null);
                httpURLConnection.disconnect();
                return aVar;
            }
            try {
                return new n5.a(responseCode, n(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new n5.d(httpURLConnection));
            } catch (Throwable th) {
                th = th;
                z10 = true;
                if (!z10) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // z3.b
    public void s(int i10, Object obj) {
        String str;
        switch (i10) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = _UrlKt.FRAGMENT_ENCODE_SET;
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i10 == 6 || i10 == 7 || i10 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
    }

    public i2.j z(Context context, String str, y7.b bVar) {
        i2.j jVar = new i2.j();
        jVar.f6217a = 0;
        jVar.f6218b = 0;
        jVar.f6219c = 0;
        int h10 = bVar.h(context, str, true);
        jVar.f6218b = h10;
        if (h10 != 0) {
            jVar.f6219c = 1;
            return jVar;
        }
        int i10 = bVar.i(context, str);
        jVar.f6217a = i10;
        if (i10 != 0) {
            jVar.f6219c = -1;
        }
        return jVar;
    }

    public v1() {
        this.f7475o = 15;
        if (Build.VERSION.SDK_INT >= 35) {
        }
    }

    public v1(Context context) {
        this.f7475o = 16;
    }

    @Override // k2.p
    public void f() {
    }

    @Override // u5.a
    public void m() {
    }

    @Override // k2.g
    public long i(long j10) {
        return j10;
    }

    @Override // u5.a
    public void k(int i10) {
    }

    @Override // k2.p
    public void t(k2.a0 a0Var) {
    }

    @Override // v5.a
    public void a(r5.e eVar, x4.m mVar) {
    }

    @Override // r5.f
    public void d(byte[] bArr, Object obj, MessageDigest messageDigest) {
    }

    @Override // m0.q
    public void onScrollLimit(int i10, int i11, int i12, boolean z10) {
    }

    @Override // m0.q
    public void onScrollProgress(int i10, int i11, int i12, int i13) {
    }
}
