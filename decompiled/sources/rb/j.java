package rb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends InputStream {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11022o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ n f11023p;

    public /* synthetic */ j(n nVar, int i10) {
        this.f11022o = i10;
        this.f11023p = nVar;
    }

    @Override // java.io.InputStream
    public final int available() {
        long min;
        switch (this.f11022o) {
            case 0:
                min = Math.min(((l) this.f11023p).f11035p, Integer.MAX_VALUE);
                break;
            default:
                m0 m0Var = (m0) this.f11023p;
                if (!m0Var.f11041q) {
                    min = Math.min(m0Var.f11040p.f11035p, Integer.MAX_VALUE);
                    break;
                } else {
                    throw new IOException("closed");
                }
        }
        return (int) min;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f11022o) {
            case 0:
                break;
            default:
                ((m0) this.f11023p).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        switch (this.f11022o) {
            case 0:
                l lVar = (l) this.f11023p;
                if (lVar.f11035p > 0) {
                    return lVar.readByte() & 255;
                }
                return -1;
            default:
                m0 m0Var = (m0) this.f11023p;
                l lVar2 = m0Var.f11040p;
                if (m0Var.f11041q) {
                    throw new IOException("closed");
                }
                if (lVar2.f11035p == 0 && m0Var.f11039o.read(lVar2, 8192L) == -1) {
                    return -1;
                }
                return lVar2.readByte() & 255;
        }
    }

    public final String toString() {
        switch (this.f11022o) {
            case 0:
                return ((l) this.f11023p) + ".inputStream()";
            default:
                return ((m0) this.f11023p) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public long transferTo(OutputStream outputStream) {
        switch (this.f11022o) {
            case 1:
                za.h.e("out", outputStream);
                m0 m0Var = (m0) this.f11023p;
                l lVar = m0Var.f11040p;
                if (m0Var.f11041q) {
                    throw new IOException("closed");
                }
                long j10 = 0;
                long j11 = 0;
                while (true) {
                    if (lVar.f11035p == j10 && m0Var.f11039o.read(lVar, 8192L) == -1) {
                        return j11;
                    }
                    long j12 = lVar.f11035p;
                    j11 += j12;
                    b.e(j12, 0L, j12);
                    n0 n0Var = lVar.f11034o;
                    while (j12 > j10) {
                        za.h.b(n0Var);
                        int min = (int) Math.min(j12, n0Var.f11044c - n0Var.f11043b);
                        outputStream.write(n0Var.f11042a, n0Var.f11043b, min);
                        int i10 = n0Var.f11043b + min;
                        n0Var.f11043b = i10;
                        long j13 = min;
                        lVar.f11035p -= j13;
                        j12 -= j13;
                        if (i10 == n0Var.f11044c) {
                            n0 a10 = n0Var.a();
                            lVar.f11034o = a10;
                            o0.a(n0Var);
                            n0Var = a10;
                        }
                        j10 = 0;
                    }
                }
                break;
            default:
                return super.transferTo(outputStream);
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        switch (this.f11022o) {
            case 0:
                za.h.e("sink", bArr);
                return ((l) this.f11023p).read(bArr, i10, i11);
            default:
                za.h.e("data", bArr);
                m0 m0Var = (m0) this.f11023p;
                l lVar = m0Var.f11040p;
                if (!m0Var.f11041q) {
                    b.e(bArr.length, i10, i11);
                    if (lVar.f11035p == 0 && m0Var.f11039o.read(lVar, 8192L) == -1) {
                        return -1;
                    }
                    return lVar.read(bArr, i10, i11);
                }
                throw new IOException("closed");
        }
    }

    private final void a() {
    }
}
