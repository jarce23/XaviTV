package o1;

import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends InputStream {

    /* renamed from: o, reason: collision with root package name */
    public final h f9415o;

    /* renamed from: p, reason: collision with root package name */
    public final l f9416p;

    /* renamed from: r, reason: collision with root package name */
    public boolean f9418r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9419s = false;

    /* renamed from: q, reason: collision with root package name */
    public final byte[] f9417q = new byte[1];

    public j(h hVar, l lVar) {
        this.f9415o = hVar;
        this.f9416p = lVar;
    }

    public final void a() {
        if (this.f9418r) {
            return;
        }
        this.f9415o.j(this.f9416p);
        this.f9418r = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f9419s) {
            return;
        }
        this.f9415o.close();
        this.f9419s = true;
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f9417q;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        l1.d.g(!this.f9419s);
        a();
        int read = this.f9415o.read(bArr, i10, i11);
        if (read == -1) {
            return -1;
        }
        return read;
    }
}
