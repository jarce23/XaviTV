package h3;

import java.util.List;
import l1.a0;
import o9.e0;
import o9.g0;
import o9.p;
import o9.u0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements e {

    /* renamed from: q, reason: collision with root package name */
    public static final p f5526q = new p(new b(0), u0.f9682p);

    /* renamed from: o, reason: collision with root package name */
    public final g0 f5527o;

    /* renamed from: p, reason: collision with root package name */
    public final long[] f5528p;

    /* JADX WARN: Removed duplicated region for block: B:45:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0111 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(o9.w0 r19) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.c.<init>(o9.w0):void");
    }

    @Override // h3.e
    public final int a(long j10) {
        int a10 = a0.a(this.f5528p, j10, false);
        if (a10 < this.f5527o.size()) {
            return a10;
        }
        return -1;
    }

    @Override // h3.e
    public final long l(int i10) {
        l1.d.b(i10 < this.f5527o.size());
        return this.f5528p[i10];
    }

    @Override // h3.e
    public final List r(long j10) {
        int e7 = a0.e(this.f5528p, j10, false);
        if (e7 != -1) {
            return (g0) this.f5527o.get(e7);
        }
        e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // h3.e
    public final int w() {
        return this.f5527o.size();
    }
}
