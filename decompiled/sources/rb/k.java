package rb;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends OutputStream {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11030o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ m f11031p;

    public /* synthetic */ k(m mVar, int i10) {
        this.f11030o = i10;
        this.f11031p = mVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f11030o) {
            case 0:
                break;
            default:
                ((l0) this.f11031p).close();
                break;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        switch (this.f11030o) {
            case 0:
                break;
            default:
                l0 l0Var = (l0) this.f11031p;
                if (!l0Var.f11038q) {
                    l0Var.flush();
                    break;
                }
                break;
        }
    }

    public final String toString() {
        switch (this.f11030o) {
            case 0:
                return ((l) this.f11031p) + ".outputStream()";
            default:
                return ((l0) this.f11031p) + ".outputStream()";
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        switch (this.f11030o) {
            case 0:
                ((l) this.f11031p).X(i10);
                return;
            default:
                l0 l0Var = (l0) this.f11031p;
                if (l0Var.f11038q) {
                    throw new IOException("closed");
                }
                l0Var.f11037p.X((byte) i10);
                l0Var.v();
                return;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        switch (this.f11030o) {
            case 0:
                za.h.e("data", bArr);
                ((l) this.f11031p).m154write(bArr, i10, i11);
                return;
            default:
                za.h.e("data", bArr);
                l0 l0Var = (l0) this.f11031p;
                if (!l0Var.f11038q) {
                    l0Var.f11037p.m154write(bArr, i10, i11);
                    l0Var.v();
                    return;
                }
                throw new IOException("closed");
        }
    }

    private final void a() {
    }

    private final void c() {
    }
}
