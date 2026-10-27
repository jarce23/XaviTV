package n5;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* renamed from: o, reason: collision with root package name */
    public final long f9205o;

    /* renamed from: p, reason: collision with root package name */
    public long f9206p;

    public c(BufferedInputStream bufferedInputStream, long j10) {
        super(bufferedInputStream);
        this.f9205o = j10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int read = super.read();
        if (read != -1) {
            this.f9206p++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        int read = super.read(bArr, i10, i11);
        if (read != -1) {
            this.f9206p += read;
        }
        return read;
    }
}
