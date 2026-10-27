package i8;

import a6.m0;
import android.util.SparseArray;
import com.bumptech.glide.manager.t;
import j9.g1;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import l1.a0;
import p1.k;
import p1.m;
import p1.o;
import p1.q;
import x4.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements m {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6529a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6530b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6531c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f6532d;

    /* renamed from: e, reason: collision with root package name */
    public Object f6533e;

    public i() {
        this.f6530b = new Object();
        this.f6532d = new t(4);
    }

    public static int m(k kVar, int i10) {
        int hashCode = kVar.f9850b.hashCode() + (kVar.f9849a * 31);
        if (i10 < 2) {
            long d6 = android.support.v4.media.d.d(kVar.f9853e);
            return (hashCode * 31) + ((int) (d6 ^ (d6 >>> 32)));
        }
        return kVar.f9853e.hashCode() + (hashCode * 31);
    }

    public static k o(int i10, DataInputStream dataInputStream) {
        o a10;
        int readInt = dataInputStream.readInt();
        String readUTF = dataInputStream.readUTF();
        if (i10 < 2) {
            long readLong = dataInputStream.readLong();
            p1.g gVar = new p1.g();
            gVar.a("exo_len", Long.valueOf(readLong));
            a10 = o.f9859c.a(gVar);
        } else {
            a10 = g1.a(dataInputStream);
        }
        return new k(readInt, readUTF, a10);
    }

    @Override // p1.m
    public void a(k kVar) {
        this.f6529a = true;
    }

    @Override // p1.m
    public boolean b() {
        r rVar = (r) this.f6532d;
        return ((File) rVar.f13607p).exists() || ((File) rVar.f13608q).exists();
    }

    @Override // p1.m
    public void c(k kVar, boolean z10) {
        this.f6529a = true;
    }

    @Override // p1.m
    public void d(HashMap hashMap) {
        if (this.f6529a) {
            e(hashMap);
        }
    }

    @Override // p1.m
    public void e(HashMap hashMap) {
        DataOutputStream dataOutputStream;
        r rVar = (r) this.f6532d;
        DataOutputStream dataOutputStream2 = null;
        try {
            l1.a n10 = rVar.n();
            q qVar = (q) this.f6533e;
            if (qVar == null) {
                this.f6533e = new q(n10);
            } else {
                qVar.a(n10);
            }
            dataOutputStream = new DataOutputStream((q) this.f6533e);
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.writeInt(2);
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(hashMap.size());
            int i10 = 0;
            for (k kVar : hashMap.values()) {
                dataOutputStream.writeInt(kVar.f9849a);
                dataOutputStream.writeUTF(kVar.f9850b);
                g1.b(kVar.f9853e, dataOutputStream);
                i10 += m(kVar, 2);
            }
            dataOutputStream.writeInt(i10);
            dataOutputStream.close();
            ((File) rVar.f13608q).delete();
            int i11 = a0.f8067a;
            this.f6529a = false;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            a0.g(dataOutputStream2);
            throw th;
        }
    }

    @Override // p1.m
    public void g(HashMap hashMap, SparseArray sparseArray) {
        BufferedInputStream bufferedInputStream;
        DataInputStream dataInputStream;
        l1.d.g(!this.f6529a);
        Cipher cipher = (Cipher) this.f6530b;
        r rVar = (r) this.f6532d;
        File file = (File) rVar.f13607p;
        File file2 = (File) rVar.f13607p;
        File file3 = (File) rVar.f13608q;
        if (file.exists() || file3.exists()) {
            DataInputStream dataInputStream2 = null;
            try {
                if (file3.exists()) {
                    file2.delete();
                    file3.renameTo(file2);
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                int readInt = dataInputStream.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (cipher != null) {
                            byte[] bArr = new byte[16];
                            dataInputStream.readFully(bArr);
                            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                            try {
                                SecretKeySpec secretKeySpec = (SecretKeySpec) this.f6531c;
                                int i10 = a0.f8067a;
                                cipher.init(2, secretKeySpec, ivParameterSpec);
                                dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, cipher));
                            } catch (InvalidAlgorithmParameterException e7) {
                                e = e7;
                                throw new IllegalStateException(e);
                            } catch (InvalidKeyException e8) {
                                e = e8;
                                throw new IllegalStateException(e);
                            }
                        }
                    }
                    int readInt2 = dataInputStream.readInt();
                    int i11 = 0;
                    for (int i12 = 0; i12 < readInt2; i12++) {
                        k o2 = o(readInt, dataInputStream);
                        String str = o2.f9850b;
                        hashMap.put(str, o2);
                        sparseArray.put(o2.f9849a, str);
                        i11 += m(o2, readInt);
                    }
                    int readInt3 = dataInputStream.readInt();
                    boolean z10 = dataInputStream.read() == -1;
                    if (readInt3 == i11 && z10) {
                        a0.g(dataInputStream);
                        return;
                    }
                }
                a0.g(dataInputStream);
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    a0.g(dataInputStream2);
                }
                hashMap.clear();
                sparseArray.clear();
                file2.delete();
                file3.delete();
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    a0.g(dataInputStream2);
                }
                throw th;
            }
            hashMap.clear();
            sparseArray.clear();
            file2.delete();
            file3.delete();
        }
    }

    @Override // p1.m
    public void h() {
        r rVar = (r) this.f6532d;
        ((File) rVar.f13607p).delete();
        ((File) rVar.f13608q).delete();
    }

    public void i(a aVar) {
        ((t) this.f6532d).f(new g(e.f6521a, aVar));
        s();
    }

    public void j(Executor executor, c cVar) {
        ((t) this.f6532d).f(new g(executor, cVar));
        s();
    }

    public Exception k() {
        Exception exc;
        synchronized (this.f6530b) {
            exc = (Exception) this.f6533e;
        }
        return exc;
    }

    public Object l() {
        Object obj;
        synchronized (this.f6530b) {
            try {
                r7.r.g("Task is not yet complete", this.f6529a);
                Exception exc = (Exception) this.f6533e;
                if (exc != null) {
                    throw new m0(exc);
                }
                obj = this.f6531c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public boolean n() {
        boolean z10;
        synchronized (this.f6530b) {
            z10 = false;
            if (this.f6529a && ((Exception) this.f6533e) == null) {
                z10 = true;
            }
        }
        return z10;
    }

    public void p(Object obj) {
        synchronized (this.f6530b) {
            r();
            this.f6529a = true;
            this.f6531c = obj;
        }
        ((t) this.f6532d).g(this);
    }

    public void q(Exception exc) {
        synchronized (this.f6530b) {
            r();
            this.f6529a = true;
            this.f6533e = exc;
        }
        ((t) this.f6532d).g(this);
    }

    public void r() {
        boolean z10;
        if (this.f6529a) {
            int i10 = i1.q.f6007o;
            synchronized (this.f6530b) {
                z10 = this.f6529a;
            }
            if (!z10) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception k10 = k();
        }
    }

    public void s() {
        synchronized (this.f6530b) {
            try {
                if (this.f6529a) {
                    ((t) this.f6532d).g(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public i(File file) {
        this.f6530b = null;
        this.f6531c = null;
        this.f6532d = new r(file);
    }

    @Override // p1.m
    public void f(long j10) {
    }
}
