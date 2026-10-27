package e2;

import h3.g;
import h3.k;
import java.nio.ByteBuffer;
import r1.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends h implements h3.f {

    /* renamed from: n, reason: collision with root package name */
    public final k f4410n;

    public b(k kVar) {
        super(new h3.h[2], new h3.d[2]);
        int i10 = this.g;
        r1.e[] eVarArr = this.f10422e;
        l1.d.g(i10 == eVarArr.length);
        for (r1.e eVar : eVarArr) {
            eVar.m(1024);
        }
        this.f4410n = kVar;
    }

    @Override // r1.h
    public final r1.e g() {
        return new h3.h(1);
    }

    @Override // r1.h
    public final r1.f h() {
        return new h3.d(this);
    }

    @Override // r1.h
    public final r1.c i(Throwable th) {
        return new g("Unexpected decode error", th);
    }

    @Override // r1.h
    public final r1.c j(r1.e eVar, r1.f fVar, boolean z10) {
        h3.h hVar = (h3.h) eVar;
        h3.d dVar = (h3.d) fVar;
        try {
            ByteBuffer byteBuffer = hVar.f10410s;
            byteBuffer.getClass();
            byte[] array = byteBuffer.array();
            int limit = byteBuffer.limit();
            k kVar = this.f4410n;
            if (z10) {
                kVar.reset();
            }
            h3.e b2 = kVar.b(array, 0, limit);
            long j10 = hVar.f10412u;
            long j11 = hVar.f5533x;
            dVar.f10415q = j10;
            dVar.f5529s = b2;
            if (j11 != Long.MAX_VALUE) {
                j10 = j11;
            }
            dVar.f5530t = j10;
            dVar.f10416r = false;
            return null;
        } catch (g e7) {
            return e7;
        }
    }

    @Override // h3.f
    public final void d(long j10) {
    }
}
