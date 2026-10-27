package f3;

import java.math.BigInteger;
import k2.a0;
import k2.b0;
import k2.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f4962a;

    public a(b bVar) {
        this.f4962a = bVar;
    }

    @Override // k2.a0
    public final boolean h() {
        return true;
    }

    @Override // k2.a0
    public final z j(long j10) {
        b bVar = this.f4962a;
        long j11 = bVar.f4964p;
        BigInteger valueOf = BigInteger.valueOf((bVar.f4966r.f5001i * j10) / 1000000);
        long j12 = bVar.f4965q;
        b0 b0Var = new b0(j10, l1.a0.j((valueOf.multiply(BigInteger.valueOf(j12 - j11)).divide(BigInteger.valueOf(bVar.f4968t)).longValue() + j11) - 30000, bVar.f4964p, j12 - 1));
        return new z(b0Var, b0Var);
    }

    @Override // k2.a0
    public final long l() {
        return (this.f4962a.f4968t * 1000000) / r0.f4966r.f5001i;
    }
}
