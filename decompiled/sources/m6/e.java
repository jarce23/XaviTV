package m6;

import a6.e0;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends InputStream {

    /* renamed from: q, reason: collision with root package name */
    public static final ArrayDeque f9010q;

    /* renamed from: o, reason: collision with root package name */
    public e0 f9011o;

    /* renamed from: p, reason: collision with root package name */
    public IOException f9012p;

    static {
        char[] cArr = n.f9027a;
        f9010q = new ArrayDeque(0);
    }

    public final void a() {
        this.f9012p = null;
        this.f9011o = null;
        ArrayDeque arrayDeque = f9010q;
        synchronized (arrayDeque) {
            arrayDeque.offer(this);
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f9011o.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f9011o.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i10) {
        this.f9011o.mark(i10);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        this.f9011o.getClass();
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        try {
            return this.f9011o.read();
        } catch (IOException e7) {
            this.f9012p = e7;
            throw e7;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f9011o.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j10) {
        try {
            return this.f9011o.skip(j10);
        } catch (IOException e7) {
            this.f9012p = e7;
            throw e7;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        try {
            return this.f9011o.read(bArr);
        } catch (IOException e7) {
            this.f9012p = e7;
            throw e7;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        try {
            return this.f9011o.read(bArr, i10, i11);
        } catch (IOException e7) {
            this.f9012p = e7;
            throw e7;
        }
    }
}
