package j9;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class o0 implements t0 {

    /* renamed from: o, reason: collision with root package name */
    public long f7399o;

    /* renamed from: p, reason: collision with root package name */
    public final int f7400p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f7401q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f7402r;

    public /* synthetic */ o0(u0 u0Var, String str, int i10, long j10) {
        this.f7401q = u0Var;
        this.f7402r = str;
        this.f7400p = i10;
        this.f7399o = j10;
    }

    public static String d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public static int i(n5.c cVar) {
        int read = cVar.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public static int j(n5.c cVar) {
        return (i(cVar) << 24) | i(cVar) | (i(cVar) << 8) | (i(cVar) << 16);
    }

    public static long k(n5.c cVar) {
        return (i(cVar) & 255) | ((i(cVar) & 255) << 8) | ((i(cVar) & 255) << 16) | ((i(cVar) & 255) << 24) | ((i(cVar) & 255) << 32) | ((i(cVar) & 255) << 40) | ((i(cVar) & 255) << 48) | ((255 & i(cVar)) << 56);
    }

    public static String l(n5.c cVar) {
        return new String(n(cVar, k(cVar)), "UTF-8");
    }

    public static byte[] n(n5.c cVar, long j10) {
        long j11 = cVar.f9205o - cVar.f9206p;
        if (j10 >= 0 && j10 <= j11) {
            int i10 = (int) j10;
            if (i10 == j10) {
                byte[] bArr = new byte[i10];
                new DataInputStream(cVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j10 + ", maxLength=" + j11);
    }

    public static void o(BufferedOutputStream bufferedOutputStream, int i10) {
        bufferedOutputStream.write(i10 & 255);
        bufferedOutputStream.write((i10 >> 8) & 255);
        bufferedOutputStream.write((i10 >> 16) & 255);
        bufferedOutputStream.write((i10 >> 24) & 255);
    }

    public static void p(BufferedOutputStream bufferedOutputStream, long j10) {
        bufferedOutputStream.write((byte) j10);
        bufferedOutputStream.write((byte) (j10 >>> 8));
        bufferedOutputStream.write((byte) (j10 >>> 16));
        bufferedOutputStream.write((byte) (j10 >>> 24));
        bufferedOutputStream.write((byte) (j10 >>> 32));
        bufferedOutputStream.write((byte) (j10 >>> 40));
        bufferedOutputStream.write((byte) (j10 >>> 48));
        bufferedOutputStream.write((byte) (j10 >>> 56));
    }

    public static void q(BufferedOutputStream bufferedOutputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        p(bufferedOutputStream, bytes.length);
        bufferedOutputStream.write(bytes, 0, bytes.length);
    }

    public synchronized m5.b a(String str) {
        n5.b bVar = (n5.b) ((LinkedHashMap) this.f7401q).get(str);
        if (bVar == null) {
            return null;
        }
        File b2 = b(str);
        try {
            n5.c cVar = new n5.c(new BufferedInputStream(new FileInputStream(b2)), b2.length());
            try {
                n5.b a10 = n5.b.a(cVar);
                if (TextUtils.equals(str, a10.f9199b)) {
                    return bVar.b(n(cVar, cVar.f9205o - cVar.f9206p));
                }
                m5.p.b("%s: key=%s, found=%s", b2.getAbsolutePath(), str, a10.f9199b);
                n5.b bVar2 = (n5.b) ((LinkedHashMap) this.f7401q).remove(str);
                if (bVar2 != null) {
                    this.f7399o -= bVar2.f9198a;
                }
                return null;
            } finally {
                cVar.close();
            }
        } catch (IOException e7) {
            m5.p.b("%s: %s", b2.getAbsolutePath(), e7.toString());
            m(str);
            return null;
        }
    }

    public File b(String str) {
        return new File(((x4.l) this.f7402r).h(), d(str));
    }

    @Override // j9.t0
    public Object c() {
        int i10;
        u0 u0Var = (u0) this.f7401q;
        String str = (String) this.f7402r;
        long j10 = this.f7399o;
        List asList = Arrays.asList(str);
        u0Var.getClass();
        r0 r0Var = (r0) ((Map) u0Var.b(new j5.g(u0Var, asList))).get(str);
        if (r0Var == null || (i10 = r0Var.f7426c.f7419d) == 5 || i10 == 6 || i10 == 4) {
            u0.f7457f.f(android.support.v4.media.d.q("Could not find pack ", str, " while trying to complete it"), new Object[0]);
        }
        p pVar = u0Var.f7458a;
        int i11 = this.f7400p;
        if (pVar.c(i11, str, j10).exists()) {
            p.f(pVar.c(i11, str, j10));
        }
        r0Var.f7426c.f7419d = 4;
        return null;
    }

    public synchronized void e() {
        File h10 = ((x4.l) this.f7402r).h();
        if (!h10.exists()) {
            if (!h10.mkdirs()) {
                m5.p.c("Unable to create cache dir %s", h10.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = h10.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                long length = file.length();
                n5.c cVar = new n5.c(new BufferedInputStream(new FileInputStream(file)), length);
                try {
                    n5.b a10 = n5.b.a(cVar);
                    a10.f9198a = length;
                    h(a10.f9199b, a10);
                    cVar.close();
                } catch (Throwable th) {
                    cVar.close();
                    throw th;
                }
            } catch (IOException unused) {
                file.delete();
            }
        }
    }

    public void f() {
        long j10 = this.f7399o;
        int i10 = this.f7400p;
        if (j10 < i10) {
            return;
        }
        if (m5.p.f9002a) {
            m5.p.d("Pruning old cache entries.", new Object[0]);
        }
        long j11 = this.f7399o;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = ((LinkedHashMap) this.f7401q).entrySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            n5.b bVar = (n5.b) ((Map.Entry) it.next()).getValue();
            if (b(bVar.f9199b).delete()) {
                this.f7399o -= bVar.f9198a;
            } else {
                String str = bVar.f9199b;
                m5.p.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
            }
            it.remove();
            i11++;
            if (this.f7399o < i10 * 0.9f) {
                break;
            }
        }
        if (m5.p.f9002a) {
            m5.p.d("pruned %d files, %d bytes, %d ms", Integer.valueOf(i11), Long.valueOf(this.f7399o - j11), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    public synchronized void g(String str, m5.b bVar) {
        BufferedOutputStream bufferedOutputStream;
        n5.b bVar2;
        long j10 = this.f7399o;
        byte[] bArr = bVar.f8950a;
        long length = j10 + bArr.length;
        int i10 = this.f7400p;
        if (length <= i10 || bArr.length <= i10 * 0.9f) {
            File b2 = b(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(b2));
                bVar2 = new n5.b(str, bVar);
            } catch (IOException unused) {
                if (!b2.delete()) {
                    m5.p.b("Could not clean up file %s", b2.getAbsolutePath());
                }
                if (!((x4.l) this.f7402r).h().exists()) {
                    m5.p.b("Re-initializing cache after external clearing.", new Object[0]);
                    ((LinkedHashMap) this.f7401q).clear();
                    this.f7399o = 0L;
                    e();
                }
            }
            if (!bVar2.c(bufferedOutputStream)) {
                bufferedOutputStream.close();
                m5.p.b("Failed to write header for %s", b2.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(bVar.f8950a);
            bufferedOutputStream.close();
            bVar2.f9198a = b2.length();
            h(str, bVar2);
            f();
        }
    }

    public void h(String str, n5.b bVar) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f7401q;
        if (linkedHashMap.containsKey(str)) {
            this.f7399o = (bVar.f9198a - ((n5.b) linkedHashMap.get(str)).f9198a) + this.f7399o;
        } else {
            this.f7399o += bVar.f9198a;
        }
        linkedHashMap.put(str, bVar);
    }

    public synchronized void m(String str) {
        boolean delete = b(str).delete();
        n5.b bVar = (n5.b) ((LinkedHashMap) this.f7401q).remove(str);
        if (bVar != null) {
            this.f7399o -= bVar.f9198a;
        }
        if (!delete) {
            m5.p.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    public o0(x4.l lVar) {
        this.f7401q = new LinkedHashMap(16, 0.75f, true);
        this.f7399o = 0L;
        this.f7402r = lVar;
        this.f7400p = 5242880;
    }
}
