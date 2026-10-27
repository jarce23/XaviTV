package m6;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends InputStream {

    /* renamed from: o, reason: collision with root package name */
    public final ByteBuffer f9004o;

    /* renamed from: p, reason: collision with root package name */
    public int f9005p = -1;

    public a(ByteBuffer byteBuffer) {
        this.f9004o = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f9004o.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i10) {
        this.f9005p = this.f9004o.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.f9004o;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        int i10 = this.f9005p;
        if (i10 == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.f9004o.position(i10);
    }

    @Override // java.io.InputStream
    public final long skip(long j10) {
        ByteBuffer byteBuffer = this.f9004o;
        if (!byteBuffer.hasRemaining()) {
            return -1L;
        }
        long min = Math.min(j10, byteBuffer.remaining());
        byteBuffer.position((int) (byteBuffer.position() + min));
        return min;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        ByteBuffer byteBuffer = this.f9004o;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i11, byteBuffer.remaining());
        byteBuffer.get(bArr, i10, min);
        return min;
    }
}
