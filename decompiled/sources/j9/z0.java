package j9;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z0 extends InputStream {

    /* renamed from: o, reason: collision with root package name */
    public final Enumeration f7505o;

    /* renamed from: p, reason: collision with root package name */
    public FileInputStream f7506p;

    public z0(Enumeration enumeration) {
        this.f7505o = enumeration;
        a();
    }

    public final void a() {
        FileInputStream fileInputStream = this.f7506p;
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        Enumeration enumeration = this.f7505o;
        if (enumeration.hasMoreElements()) {
            this.f7506p = new FileInputStream((File) enumeration.nextElement());
        } else {
            this.f7506p = null;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        FileInputStream fileInputStream = this.f7506p;
        if (fileInputStream != null) {
            fileInputStream.close();
            this.f7506p = null;
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        while (true) {
            FileInputStream fileInputStream = this.f7506p;
            if (fileInputStream == null) {
                return -1;
            }
            int read = fileInputStream.read();
            if (read != -1) {
                return read;
            }
            a();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        if (this.f7506p == null) {
            return -1;
        }
        bArr.getClass();
        if (i10 < 0 || i11 < 0 || i11 > bArr.length - i10) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return 0;
        }
        do {
            int read = this.f7506p.read(bArr, i10, i11);
            if (read > 0) {
                return read;
            }
            a();
        } while (this.f7506p != null);
        return -1;
    }
}
