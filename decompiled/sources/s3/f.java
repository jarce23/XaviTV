package s3;

import com.google.android.material.datepicker.m;
import java.math.RoundingMode;
import k2.a0;
import k2.b0;
import k2.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final m f11559a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11560b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11561c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11562d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11563e;

    public f(m mVar, int i10, long j10, long j11) {
        this.f11559a = mVar;
        this.f11560b = i10;
        this.f11561c = j10;
        long j12 = (j11 - j10) / mVar.f3773q;
        this.f11562d = j12;
        this.f11563e = a(j12);
    }

    public final long a(long j10) {
        long j11 = j10 * this.f11560b;
        long j12 = this.f11559a.f3772p;
        int i10 = l1.a0.f8067a;
        return l1.a0.V(j11, 1000000L, j12, RoundingMode.DOWN);
    }

    @Override // k2.a0
    public final boolean h() {
        return true;
    }

    @Override // k2.a0
    public final z j(long j10) {
        m mVar = this.f11559a;
        long j11 = this.f11562d;
        long j12 = l1.a0.j((mVar.f3772p * j10) / (this.f11560b * 1000000), 0L, j11 - 1);
        long j13 = this.f11561c;
        long a10 = a(j12);
        b0 b0Var = new b0(a10, (mVar.f3773q * j12) + j13);
        if (a10 >= j10 || j12 == j11 - 1) {
            return new z(b0Var, b0Var);
        }
        long j14 = j12 + 1;
        return new z(b0Var, new b0(a(j14), (mVar.f3773q * j14) + j13));
    }

    @Override // k2.a0
    public final long l() {
        return this.f11563e;
    }
}
