package l1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends OutputStream {

    /* renamed from: o, reason: collision with root package name */
    public final FileOutputStream f8065o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8066p = false;

    public a(File file) {
        this.f8065o = new FileOutputStream(file);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileOutputStream fileOutputStream = this.f8065o;
        if (this.f8066p) {
            return;
        }
        this.f8066p = true;
        flush();
        try {
            fileOutputStream.getFD().sync();
        } catch (IOException e7) {
            b.r("AtomicFile", "Failed to sync file descriptor:", e7);
        }
        fileOutputStream.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        this.f8065o.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        this.f8065o.write(i10);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f8065o.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        this.f8065o.write(bArr, i10, i11);
    }
}
