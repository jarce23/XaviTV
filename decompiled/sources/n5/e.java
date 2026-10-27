package n5;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends ByteArrayOutputStream {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9208o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final Object f9209p;

    public e(a aVar, int i10) {
        this.f9209p = aVar;
        ((ByteArrayOutputStream) this).buf = aVar.a(Math.max(i10, 256));
    }

    private final synchronized void c(int i10) {
        a(1);
        super.write(i10);
    }

    private final synchronized void n(byte[] bArr, int i10, int i11) {
        a(i11);
        super.write(bArr, i10, i11);
    }

    public void a(int i10) {
        a aVar = (a) this.f9209p;
        int i11 = ((ByteArrayOutputStream) this).count;
        if (i11 + i10 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] a10 = aVar.a((i11 + i10) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a10, 0, ((ByteArrayOutputStream) this).count);
        aVar.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = a10;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        switch (this.f9208o) {
            case 0:
                ((a) this.f9209p).b(((ByteArrayOutputStream) this).buf);
                ((ByteArrayOutputStream) this).buf = null;
                super.close();
                break;
            default:
                super.close();
                break;
        }
    }

    public void finalize() {
        switch (this.f9208o) {
            case 0:
                ((a) this.f9209p).b(((ByteArrayOutputStream) this).buf);
                break;
            default:
                super.finalize();
                break;
        }
    }

    @Override // java.io.ByteArrayOutputStream
    public String toString() {
        switch (this.f9208o) {
            case 1:
                int i10 = ((ByteArrayOutputStream) this).count;
                if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                    i10--;
                }
                try {
                    return new String(((ByteArrayOutputStream) this).buf, 0, i10, ((o5.d) this.f9209p).f9540p.name());
                } catch (UnsupportedEncodingException e7) {
                    throw new AssertionError(e7);
                }
            default:
                return super.toString();
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i10) {
        switch (this.f9208o) {
            case 0:
                c(i10);
                break;
            default:
                super.write(i10);
                break;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i10, int i11) {
        switch (this.f9208o) {
            case 0:
                n(bArr, i10, i11);
                break;
            default:
                super.write(bArr, i10, i11);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(o5.d dVar, int i10) {
        super(i10);
        this.f9209p = dVar;
    }
}
