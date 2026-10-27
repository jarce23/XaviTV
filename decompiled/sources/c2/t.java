package c2;

import android.net.Uri;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t implements o1.h {

    /* renamed from: o, reason: collision with root package name */
    public final o1.h f2710o;

    /* renamed from: p, reason: collision with root package name */
    public final int f2711p;

    /* renamed from: q, reason: collision with root package name */
    public final r0 f2712q;

    /* renamed from: r, reason: collision with root package name */
    public final byte[] f2713r;

    /* renamed from: s, reason: collision with root package name */
    public int f2714s;

    public t(o1.h hVar, int i10, r0 r0Var) {
        l1.d.b(i10 > 0);
        this.f2710o = hVar;
        this.f2711p = i10;
        this.f2712q = r0Var;
        this.f2713r = new byte[1];
        this.f2714s = i10;
    }

    @Override // o1.h
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // o1.h
    public final Map e() {
        return this.f2710o.e();
    }

    @Override // o1.h
    public final void g(o1.e0 e0Var) {
        e0Var.getClass();
        this.f2710o.g(e0Var);
    }

    @Override // o1.h
    public final long j(o1.l lVar) {
        throw new UnsupportedOperationException();
    }

    @Override // o1.h
    public final Uri l() {
        return this.f2710o.l();
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        int i12 = this.f2714s;
        o1.h hVar = this.f2710o;
        if (i12 == 0) {
            byte[] bArr2 = this.f2713r;
            int i13 = 0;
            if (hVar.read(bArr2, 0, 1) != -1) {
                int i14 = (bArr2[0] & 255) << 4;
                if (i14 != 0) {
                    byte[] bArr3 = new byte[i14];
                    int i15 = i14;
                    while (i15 > 0) {
                        int read = hVar.read(bArr3, i13, i15);
                        if (read != -1) {
                            i13 += read;
                            i15 -= read;
                        }
                    }
                    while (i14 > 0 && bArr3[i14 - 1] == 0) {
                        i14--;
                    }
                    if (i14 > 0) {
                        l1.t tVar = new l1.t(i14, bArr3);
                        r0 r0Var = this.f2712q;
                        long max = !r0Var.f2705l ? r0Var.f2702i : Math.max(r0Var.f2706m.y(true), r0Var.f2702i);
                        int a10 = tVar.a();
                        k2.g0 g0Var = r0Var.f2704k;
                        g0Var.getClass();
                        g0Var.c(a10, tVar);
                        g0Var.e(max, 1, a10, 0, null);
                        r0Var.f2705l = true;
                    }
                }
                this.f2714s = this.f2711p;
            }
            return -1;
        }
        int read2 = hVar.read(bArr, i10, Math.min(this.f2714s, i11));
        if (read2 != -1) {
            this.f2714s -= read2;
        }
        return read2;
    }
}
