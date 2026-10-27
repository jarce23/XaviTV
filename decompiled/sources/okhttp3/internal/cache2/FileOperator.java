package okhttp3.internal.cache2;

import java.nio.channels.FileChannel;
import rb.l;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        h.e("fileChannel", fileChannel);
        this.fileChannel = fileChannel;
    }

    public final void read(long j10, l lVar, long j11) {
        h.e("sink", lVar);
        if (j11 < 0) {
            throw new IndexOutOfBoundsException();
        }
        long j12 = j10;
        long j13 = j11;
        while (j13 > 0) {
            long transferTo = this.fileChannel.transferTo(j12, j13, lVar);
            j12 += transferTo;
            j13 -= transferTo;
        }
    }

    public final void write(long j10, l lVar, long j11) {
        h.e("source", lVar);
        if (j11 < 0 || j11 > lVar.f11035p) {
            throw new IndexOutOfBoundsException();
        }
        long j12 = j10;
        long j13 = j11;
        while (j13 > 0) {
            long transferFrom = this.fileChannel.transferFrom(lVar, j12, j13);
            j12 += transferFrom;
            j13 -= transferFrom;
        }
    }
}
