package q1;

import java.nio.ByteBuffer;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends UploadDataProvider {

    /* renamed from: o, reason: collision with root package name */
    public final byte[] f10219o;

    /* renamed from: p, reason: collision with root package name */
    public int f10220p;

    public a(byte[] bArr) {
        this.f10219o = bArr;
    }

    @Override // org.chromium.net.UploadDataProvider
    public final long getLength() {
        return this.f10219o.length;
    }

    @Override // org.chromium.net.UploadDataProvider
    public final void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = this.f10219o;
        int min = Math.min(remaining, bArr.length - this.f10220p);
        byteBuffer.put(bArr, this.f10220p, min);
        this.f10220p += min;
        uploadDataSink.onReadSucceeded(false);
    }

    @Override // org.chromium.net.UploadDataProvider
    public final void rewind(UploadDataSink uploadDataSink) {
        this.f10220p = 0;
        uploadDataSink.onRewindSucceeded();
    }
}
