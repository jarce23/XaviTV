package a6;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 extends FilterInputStream {

    /* renamed from: o, reason: collision with root package name */
    public volatile byte[] f51o;

    /* renamed from: p, reason: collision with root package name */
    public int f52p;

    /* renamed from: q, reason: collision with root package name */
    public int f53q;

    /* renamed from: r, reason: collision with root package name */
    public int f54r;

    /* renamed from: s, reason: collision with root package name */
    public int f55s;

    /* renamed from: t, reason: collision with root package name */
    public final u5.f f56t;

    public e0(InputStream inputStream, u5.f fVar) {
        super(inputStream);
        this.f54r = -1;
        this.f56t = fVar;
        this.f51o = (byte[]) fVar.d(65536, byte[].class);
    }

    public static void n() {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) {
        int i10 = this.f54r;
        if (i10 != -1) {
            int i11 = this.f55s - i10;
            int i12 = this.f53q;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.f52p == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f56t.d(i12, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f51o = bArr2;
                    this.f56t.h(bArr);
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy(bArr, i10, bArr, 0, bArr.length - i10);
                }
                int i13 = this.f55s - this.f54r;
                this.f55s = i13;
                this.f54r = 0;
                this.f52p = 0;
                int read = inputStream.read(bArr, i13, bArr.length - i13);
                int i14 = this.f55s;
                if (read > 0) {
                    i14 += read;
                }
                this.f52p = i14;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f54r = -1;
            this.f55s = 0;
            this.f52p = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f51o == null || inputStream == null) {
            n();
            throw null;
        }
        return (this.f52p - this.f55s) + inputStream.available();
    }

    public final synchronized void c() {
        if (this.f51o != null) {
            this.f56t.h(this.f51o);
            this.f51o = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f51o != null) {
            this.f56t.h(this.f51o);
            this.f51o = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i10) {
        this.f53q = Math.max(this.f53q, i10);
        this.f54r = this.f55s;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.f51o;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            n();
            throw null;
        }
        if (this.f55s >= this.f52p && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f51o && (bArr = this.f51o) == null) {
            n();
            throw null;
        }
        int i10 = this.f52p;
        int i11 = this.f55s;
        if (i10 - i11 <= 0) {
            return -1;
        }
        this.f55s = i11 + 1;
        return bArr[i11] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.f51o == null) {
            throw new IOException("Stream is closed");
        }
        int i10 = this.f54r;
        if (-1 == i10) {
            throw new d0("Mark has been invalidated, pos: " + this.f55s + " markLimit: " + this.f53q);
        }
        this.f55s = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j10) {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.f51o;
        if (bArr == null) {
            n();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            n();
            throw null;
        }
        int i10 = this.f52p;
        int i11 = this.f55s;
        if (i10 - i11 >= j10) {
            this.f55s = (int) (i11 + j10);
            return j10;
        }
        long j11 = i10 - i11;
        this.f55s = i10;
        if (this.f54r == -1 || j10 > this.f53q) {
            long skip = inputStream.skip(j10 - j11);
            if (skip > 0) {
                this.f54r = -1;
            }
            return j11 + skip;
        }
        if (a(inputStream, bArr) == -1) {
            return j11;
        }
        int i12 = this.f52p;
        int i13 = this.f55s;
        if (i12 - i13 >= j10 - j11) {
            this.f55s = (int) ((i13 + j10) - j11);
            return j10;
        }
        long j12 = (j11 + i12) - i13;
        this.f55s = i12;
        return j12;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        byte[] bArr2 = this.f51o;
        if (bArr2 == null) {
            n();
            throw null;
        }
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i14 = this.f55s;
            int i15 = this.f52p;
            if (i14 < i15) {
                int i16 = i15 - i14;
                if (i16 >= i11) {
                    i16 = i11;
                }
                System.arraycopy(bArr2, i14, bArr, i10, i16);
                this.f55s += i16;
                if (i16 == i11 || inputStream.available() == 0) {
                    return i16;
                }
                i10 += i16;
                i12 = i11 - i16;
            } else {
                i12 = i11;
            }
            while (true) {
                if (this.f54r == -1 && i12 >= bArr2.length) {
                    i13 = inputStream.read(bArr, i10, i12);
                    if (i13 == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                    if (bArr2 != this.f51o && (bArr2 = this.f51o) == null) {
                        n();
                        throw null;
                    }
                    int i17 = this.f52p;
                    int i18 = this.f55s;
                    i13 = i17 - i18;
                    if (i13 >= i12) {
                        i13 = i12;
                    }
                    System.arraycopy(bArr2, i18, bArr, i10, i13);
                    this.f55s += i13;
                }
                i12 -= i13;
                if (i12 == 0) {
                    return i11;
                }
                if (inputStream.available() == 0) {
                    return i11 - i12;
                }
                i10 += i13;
            }
        } else {
            n();
            throw null;
        }
    }
}
