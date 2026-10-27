package k2;

import java.io.EOFException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7763a = new byte[4096];

    @Override // k2.g0
    public final int b(i1.h hVar, int i10, boolean z10) {
        byte[] bArr = this.f7763a;
        int read = hVar.read(bArr, 0, Math.min(bArr.length, i10));
        if (read != -1) {
            return read;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // k2.g0
    public final void c(int i10, l1.t tVar) {
        tVar.J(i10);
    }

    @Override // k2.g0
    public final void d(l1.t tVar, int i10, int i11) {
        tVar.J(i10);
    }

    @Override // k2.g0
    public final int f(i1.h hVar, int i10, boolean z10) {
        return b(hVar, i10, z10);
    }

    @Override // k2.g0
    public final void a(i1.p pVar) {
    }

    @Override // k2.g0
    public final void e(long j10, int i10, int i11, int i12, f0 f0Var) {
    }
}
