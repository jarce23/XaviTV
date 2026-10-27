package o5;

import android.os.Build;
import android.os.StrictMode;
import h5.i;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    public final File f9527o;

    /* renamed from: p, reason: collision with root package name */
    public final File f9528p;

    /* renamed from: q, reason: collision with root package name */
    public final File f9529q;

    /* renamed from: r, reason: collision with root package name */
    public final File f9530r;

    /* renamed from: t, reason: collision with root package name */
    public final long f9532t;

    /* renamed from: w, reason: collision with root package name */
    public BufferedWriter f9535w;

    /* renamed from: y, reason: collision with root package name */
    public int f9537y;

    /* renamed from: v, reason: collision with root package name */
    public long f9534v = 0;

    /* renamed from: x, reason: collision with root package name */
    public final LinkedHashMap f9536x = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: z, reason: collision with root package name */
    public long f9538z = 0;
    public final ThreadPoolExecutor A = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());
    public final a8.b B = new a8.b(1, this);

    /* renamed from: s, reason: collision with root package name */
    public final int f9531s = 1;

    /* renamed from: u, reason: collision with root package name */
    public final int f9533u = 1;

    public c(File file, long j10) {
        this.f9527o = file;
        this.f9528p = new File(file, "journal");
        this.f9529q = new File(file, "journal.tmp");
        this.f9530r = new File(file, "journal.bkp");
        this.f9532t = j10;
    }

    public static c N(File file, long j10) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                S(file2, file3, false);
            }
        }
        c cVar = new c(file, j10);
        if (cVar.f9528p.exists()) {
            try {
                cVar.P();
                cVar.O();
                return cVar;
            } catch (IOException e7) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e7.getMessage() + ", removing");
                cVar.close();
                e.a(cVar.f9527o);
            }
        }
        file.mkdirs();
        c cVar2 = new c(file, j10);
        cVar2.R();
        return cVar2;
    }

    public static void S(File file, File file2, boolean z10) {
        if (z10) {
            n(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void a(c cVar, c4.e eVar, boolean z10) {
        synchronized (cVar) {
            b bVar = (b) eVar.f2876p;
            if (bVar.f9526f != eVar) {
                throw new IllegalStateException();
            }
            if (z10 && !bVar.f9525e) {
                for (int i10 = 0; i10 < cVar.f9533u; i10++) {
                    if (!((boolean[]) eVar.f2877q)[i10]) {
                        eVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    }
                    if (!bVar.f9524d[i10].exists()) {
                        eVar.c();
                        return;
                    }
                }
            }
            for (int i11 = 0; i11 < cVar.f9533u; i11++) {
                File file = bVar.f9524d[i11];
                if (!z10) {
                    n(file);
                } else if (file.exists()) {
                    File file2 = bVar.f9523c[i11];
                    file.renameTo(file2);
                    long j10 = bVar.f9522b[i11];
                    long length = file2.length();
                    bVar.f9522b[i11] = length;
                    cVar.f9534v = (cVar.f9534v - j10) + length;
                }
            }
            cVar.f9537y++;
            bVar.f9526f = null;
            if (bVar.f9525e || z10) {
                bVar.f9525e = true;
                cVar.f9535w.append((CharSequence) "CLEAN");
                cVar.f9535w.append(' ');
                cVar.f9535w.append((CharSequence) bVar.f9521a);
                cVar.f9535w.append((CharSequence) bVar.a());
                cVar.f9535w.append('\n');
                if (z10) {
                    cVar.f9538z++;
                }
            } else {
                cVar.f9536x.remove(bVar.f9521a);
                cVar.f9535w.append((CharSequence) "REMOVE");
                cVar.f9535w.append(' ');
                cVar.f9535w.append((CharSequence) bVar.f9521a);
                cVar.f9535w.append('\n');
            }
            x(cVar.f9535w);
            if (cVar.f9534v > cVar.f9532t || cVar.M()) {
                cVar.A.submit(cVar.B);
            }
        }
    }

    public static void c(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void n(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void x(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final synchronized i K(String str) {
        if (this.f9535w == null) {
            throw new IllegalStateException("cache is closed");
        }
        b bVar = (b) this.f9536x.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.f9525e) {
            return null;
        }
        for (File file : bVar.f9523c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f9537y++;
        this.f9535w.append((CharSequence) "READ");
        this.f9535w.append(' ');
        this.f9535w.append((CharSequence) str);
        this.f9535w.append('\n');
        if (M()) {
            this.A.submit(this.B);
        }
        return new i(25, bVar.f9523c);
    }

    public final boolean M() {
        int i10 = this.f9537y;
        return i10 >= 2000 && i10 >= this.f9536x.size();
    }

    public final void O() {
        n(this.f9529q);
        Iterator it = this.f9536x.values().iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            c4.e eVar = bVar.f9526f;
            int i10 = this.f9533u;
            int i11 = 0;
            if (eVar == null) {
                while (i11 < i10) {
                    this.f9534v += bVar.f9522b[i11];
                    i11++;
                }
            } else {
                bVar.f9526f = null;
                while (i11 < i10) {
                    n(bVar.f9523c[i11]);
                    n(bVar.f9524d[i11]);
                    i11++;
                }
                it.remove();
            }
        }
    }

    public final void P() {
        File file = this.f9528p;
        d dVar = new d(new FileInputStream(file), e.f9544a);
        try {
            String a10 = dVar.a();
            String a11 = dVar.a();
            String a12 = dVar.a();
            String a13 = dVar.a();
            String a14 = dVar.a();
            if (!"libcore.io.DiskLruCache".equals(a10) || !"1".equals(a11) || !Integer.toString(this.f9531s).equals(a12) || !Integer.toString(this.f9533u).equals(a13) || !_UrlKt.FRAGMENT_ENCODE_SET.equals(a14)) {
                throw new IOException("unexpected journal header: [" + a10 + ", " + a11 + ", " + a13 + ", " + a14 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    Q(dVar.a());
                    i10++;
                } catch (EOFException unused) {
                    this.f9537y = i10 - this.f9536x.size();
                    if (dVar.f9543s == -1) {
                        R();
                    } else {
                        this.f9535w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), e.f9544a));
                    }
                    try {
                        dVar.close();
                        return;
                    } catch (RuntimeException e7) {
                        throw e7;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                dVar.close();
            } catch (RuntimeException e8) {
                throw e8;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void Q(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i10 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i10);
        LinkedHashMap linkedHashMap = this.f9536x;
        if (indexOf2 == -1) {
            substring = str.substring(i10);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i10, indexOf2);
        }
        b bVar = (b) linkedHashMap.get(substring);
        if (bVar == null) {
            bVar = new b(this, substring);
            linkedHashMap.put(substring, bVar);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith("CLEAN")) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.f9526f = new c4.e(this, bVar);
                return;
            } else {
                if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        bVar.f9525e = true;
        bVar.f9526f = null;
        if (split.length != bVar.g.f9533u) {
            throw new IOException("unexpected journal line: " + Arrays.toString(split));
        }
        for (int i11 = 0; i11 < split.length; i11++) {
            try {
                bVar.f9522b[i11] = Long.parseLong(split[i11]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(split));
            }
        }
    }

    public final synchronized void R() {
        try {
            BufferedWriter bufferedWriter = this.f9535w;
            if (bufferedWriter != null) {
                c(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f9529q), e.f9544a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write("1");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f9531s));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f9533u));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (b bVar : this.f9536x.values()) {
                    if (bVar.f9526f != null) {
                        bufferedWriter2.write("DIRTY " + bVar.f9521a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + bVar.f9521a + bVar.a() + '\n');
                    }
                }
                c(bufferedWriter2);
                if (this.f9528p.exists()) {
                    S(this.f9528p, this.f9530r, true);
                }
                S(this.f9529q, this.f9528p, false);
                this.f9530r.delete();
                this.f9535w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f9528p, true), e.f9544a));
            } catch (Throwable th) {
                c(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void T() {
        while (this.f9534v > this.f9532t) {
            String str = (String) ((Map.Entry) this.f9536x.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.f9535w == null) {
                        throw new IllegalStateException("cache is closed");
                    }
                    b bVar = (b) this.f9536x.get(str);
                    if (bVar != null && bVar.f9526f == null) {
                        for (int i10 = 0; i10 < this.f9533u; i10++) {
                            File file = bVar.f9523c[i10];
                            if (file.exists() && !file.delete()) {
                                throw new IOException("failed to delete " + file);
                            }
                            long j10 = this.f9534v;
                            long[] jArr = bVar.f9522b;
                            this.f9534v = j10 - jArr[i10];
                            jArr[i10] = 0;
                        }
                        this.f9537y++;
                        this.f9535w.append((CharSequence) "REMOVE");
                        this.f9535w.append(' ');
                        this.f9535w.append((CharSequence) str);
                        this.f9535w.append('\n');
                        this.f9536x.remove(str);
                        if (M()) {
                            this.A.submit(this.B);
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f9535w == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f9536x.values());
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                c4.e eVar = ((b) obj).f9526f;
                if (eVar != null) {
                    eVar.c();
                }
            }
            T();
            c(this.f9535w);
            this.f9535w = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final c4.e s(String str) {
        synchronized (this) {
            try {
                if (this.f9535w == null) {
                    throw new IllegalStateException("cache is closed");
                }
                b bVar = (b) this.f9536x.get(str);
                if (bVar == null) {
                    bVar = new b(this, str);
                    this.f9536x.put(str, bVar);
                } else if (bVar.f9526f != null) {
                    return null;
                }
                c4.e eVar = new c4.e(this, bVar);
                bVar.f9526f = eVar;
                this.f9535w.append((CharSequence) "DIRTY");
                this.f9535w.append(' ');
                this.f9535w.append((CharSequence) str);
                this.f9535w.append('\n');
                x(this.f9535w);
                return eVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
