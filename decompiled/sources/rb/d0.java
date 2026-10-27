package rb;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 extends r {

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f11002r;

    /* renamed from: s, reason: collision with root package name */
    public final Closeable f11003s;

    public /* synthetic */ d0(Closeable closeable, int i10) {
        this.f11002r = i10;
        this.f11003s = closeable;
    }

    private final synchronized void K() {
        ((FileChannel) this.f11003s).close();
    }

    private final synchronized int M(long j10, byte[] bArr, int i10, int i11) {
        za.h.e("array", bArr);
        ((RandomAccessFile) this.f11003s).seek(j10);
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            int read = ((RandomAccessFile) this.f11003s).read(bArr, i10, i11 - i12);
            if (read != -1) {
                i12 += read;
            } else if (i12 == 0) {
                return -1;
            }
        }
        return i12;
    }

    private final synchronized int N(long j10, byte[] bArr, int i10, int i11) {
        za.h.e("array", bArr);
        ((FileChannel) this.f11003s).position(j10);
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i10, i11);
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            int read = ((FileChannel) this.f11003s).read(wrap);
            if (read != -1) {
                i12 += read;
            } else if (i12 == 0) {
                return -1;
            }
        }
        return i12;
    }

    private final synchronized long O() {
        return ((RandomAccessFile) this.f11003s).length();
    }

    private final synchronized long P() {
        return ((FileChannel) this.f11003s).size();
    }

    private final synchronized void x() {
        ((RandomAccessFile) this.f11003s).close();
    }

    @Override // rb.r
    public final synchronized void a() {
        switch (this.f11002r) {
            case 0:
                x();
                break;
            default:
                K();
                break;
        }
    }

    @Override // rb.r
    public final synchronized int c(long j10, byte[] bArr, int i10, int i11) {
        switch (this.f11002r) {
            case 0:
                return M(j10, bArr, i10, i11);
            default:
                return N(j10, bArr, i10, i11);
        }
    }

    @Override // rb.r
    public final synchronized long n() {
        switch (this.f11002r) {
            case 0:
                return O();
            default:
                return P();
        }
    }
}
