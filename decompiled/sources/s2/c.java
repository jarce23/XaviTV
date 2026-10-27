package s2;

import k2.a0;
import k2.b0;
import k2.t;
import k2.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f11526b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b4.c f11527c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b4.c cVar, a0 a0Var, a0 a0Var2) {
        super(a0Var);
        this.f11527c = cVar;
        this.f11526b = a0Var2;
    }

    @Override // k2.t, k2.a0
    public final z j(long j10) {
        z j11 = this.f11526b.j(j10);
        b0 b0Var = j11.f7807a;
        long j12 = b0Var.f7688a;
        long j13 = b0Var.f7689b;
        long j14 = this.f11527c.f2201p;
        b0 b0Var2 = new b0(j12, j13 + j14);
        b0 b0Var3 = j11.f7808b;
        return new z(b0Var2, new b0(b0Var3.f7688a, b0Var3.f7689b + j14));
    }
}
