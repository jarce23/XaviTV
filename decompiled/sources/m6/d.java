package m6;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends FilterInputStream {

    /* renamed from: o, reason: collision with root package name */
    public final long f9008o;

    /* renamed from: p, reason: collision with root package name */
    public int f9009p;

    public d(InputStream inputStream, long j10) {
        super(inputStream);
        this.f9008o = j10;
    }

    public final void a(int i10) {
        if (i10 >= 0) {
            this.f9009p += i10;
            return;
        }
        long j10 = this.f9009p;
        long j11 = this.f9008o;
        if (j11 - j10 <= 0) {
            return;
        }
        throw new IOException("Failed to read all expected data, expected: " + j11 + ", but read: " + this.f9009p);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.f9008o - this.f9009p, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i10, int i11) {
        int read;
        read = super.read(bArr, i10, i11);
        a(read);
        return read;
    }
}
