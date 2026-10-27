package a6;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 extends MediaDataSource {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f70o;

    public k0(ByteBuffer byteBuffer) {
        this.f70o = byteBuffer;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f70o.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j10, byte[] bArr, int i10, int i11) {
        ByteBuffer byteBuffer = this.f70o;
        if (j10 >= byteBuffer.limit()) {
            return -1;
        }
        byteBuffer.position((int) j10);
        int min = Math.min(i11, byteBuffer.remaining());
        byteBuffer.get(bArr, i10, min);
        return min;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
