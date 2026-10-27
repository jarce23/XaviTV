package j9;

import java.io.FileInputStream;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends InputStream {

    /* renamed from: o, reason: collision with root package name */
    public final FileInputStream f7414o;

    /* renamed from: p, reason: collision with root package name */
    public long f7415p;

    public q(FileInputStream fileInputStream, long j10) {
        this.f7414o = fileInputStream;
        this.f7415p = j10;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        this.f7414o.close();
        this.f7415p = 0L;
    }

    @Override // java.io.InputStream
    public final int read() {
        long j10 = this.f7415p;
        if (j10 <= 0) {
            return -1;
        }
        this.f7415p = j10 - 1;
        return this.f7414o.read();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        long j10 = this.f7415p;
        if (j10 <= 0) {
            return -1;
        }
        int read = this.f7414o.read(bArr, i10, (int) Math.min(i11, j10));
        if (read != -1) {
            this.f7415p -= read;
        }
        return read;
    }
}
