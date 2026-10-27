package o5;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    public final FileInputStream f9539o;

    /* renamed from: p, reason: collision with root package name */
    public final Charset f9540p;

    /* renamed from: q, reason: collision with root package name */
    public byte[] f9541q;

    /* renamed from: r, reason: collision with root package name */
    public int f9542r;

    /* renamed from: s, reason: collision with root package name */
    public int f9543s;

    public d(FileInputStream fileInputStream, Charset charset) {
        if (charset == null) {
            throw null;
        }
        if (!charset.equals(e.f9544a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f9539o = fileInputStream;
        this.f9540p = charset;
        this.f9541q = new byte[8192];
    }

    public final String a() {
        int i10;
        synchronized (this.f9539o) {
            try {
                byte[] bArr = this.f9541q;
                if (bArr == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f9542r >= this.f9543s) {
                    int read = this.f9539o.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.f9542r = 0;
                    this.f9543s = read;
                }
                for (int i11 = this.f9542r; i11 != this.f9543s; i11++) {
                    byte[] bArr2 = this.f9541q;
                    if (bArr2[i11] == 10) {
                        int i12 = this.f9542r;
                        if (i11 != i12) {
                            i10 = i11 - 1;
                            if (bArr2[i10] == 13) {
                                String str = new String(bArr2, i12, i10 - i12, this.f9540p.name());
                                this.f9542r = i11 + 1;
                                return str;
                            }
                        }
                        i10 = i11;
                        String str2 = new String(bArr2, i12, i10 - i12, this.f9540p.name());
                        this.f9542r = i11 + 1;
                        return str2;
                    }
                }
                n5.e eVar = new n5.e(this, (this.f9543s - this.f9542r) + 80);
                while (true) {
                    byte[] bArr3 = this.f9541q;
                    int i13 = this.f9542r;
                    eVar.write(bArr3, i13, this.f9543s - i13);
                    this.f9543s = -1;
                    FileInputStream fileInputStream = this.f9539o;
                    byte[] bArr4 = this.f9541q;
                    int read2 = fileInputStream.read(bArr4, 0, bArr4.length);
                    if (read2 == -1) {
                        throw new EOFException();
                    }
                    this.f9542r = 0;
                    this.f9543s = read2;
                    for (int i14 = 0; i14 != this.f9543s; i14++) {
                        byte[] bArr5 = this.f9541q;
                        if (bArr5[i14] == 10) {
                            int i15 = this.f9542r;
                            if (i14 != i15) {
                                eVar.write(bArr5, i15, i14 - i15);
                            }
                            this.f9542r = i14 + 1;
                            return eVar.toString();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f9539o) {
            try {
                if (this.f9541q != null) {
                    this.f9541q = null;
                    this.f9539o.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
