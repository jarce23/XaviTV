package w9;

import java.io.OutputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends OutputStream {

    /* renamed from: o, reason: collision with root package name */
    public long f13148o;

    @Override // java.io.OutputStream
    public final void write(int i10) {
        this.f13148o++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f13148o += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 >= 0 && i10 <= bArr.length && i11 >= 0 && (i12 = i10 + i11) <= bArr.length && i12 >= 0) {
            this.f13148o += i11;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
