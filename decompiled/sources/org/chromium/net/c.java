package org.chromium.net;

import h5.i;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends UploadDataProvider {

    /* renamed from: o, reason: collision with root package name */
    public volatile FileChannel f9753o;

    /* renamed from: p, reason: collision with root package name */
    public final i f9754p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f9755q = new Object();

    public c(i iVar) {
        this.f9754p = iVar;
    }

    public final FileChannel a() {
        if (this.f9753o == null) {
            synchronized (this.f9755q) {
                try {
                    if (this.f9753o == null) {
                        this.f9753o = this.f9754p.C();
                    }
                } finally {
                }
            }
        }
        return this.f9753o;
    }

    @Override // org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileChannel fileChannel = this.f9753o;
        if (fileChannel != null) {
            fileChannel.close();
        }
    }

    @Override // org.chromium.net.UploadDataProvider
    public final long getLength() {
        return a().size();
    }

    @Override // org.chromium.net.UploadDataProvider
    public final void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }
        FileChannel a10 = a();
        int i10 = 0;
        while (i10 == 0) {
            int read = a10.read(byteBuffer);
            if (read == -1) {
                break;
            } else {
                i10 += read;
            }
        }
        uploadDataSink.onReadSucceeded(false);
    }

    @Override // org.chromium.net.UploadDataProvider
    public final void rewind(UploadDataSink uploadDataSink) {
        a().position(0L);
        uploadDataSink.onRewindSucceeded();
    }
}
