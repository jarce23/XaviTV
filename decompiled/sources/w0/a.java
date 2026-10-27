package w0;

import android.media.MediaDataSource;
import java.io.IOException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends MediaDataSource {

    /* renamed from: o, reason: collision with root package name */
    public long f12707o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ f f12708p;

    public a(f fVar) {
        this.f12708p = fVar;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j10, byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        if (j10 < 0) {
            return -1;
        }
        try {
            long j11 = this.f12707o;
            f fVar = this.f12708p;
            if (j11 != j10) {
                if (j11 >= 0 && j10 >= j11 + fVar.f12711o.available()) {
                    return -1;
                }
                fVar.c(j10);
                this.f12707o = j10;
            }
            if (i11 > fVar.f12711o.available()) {
                i11 = fVar.f12711o.available();
            }
            int read = fVar.read(bArr, i10, i11);
            if (read >= 0) {
                this.f12707o += read;
                return read;
            }
        } catch (IOException unused) {
        }
        this.f12707o = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
