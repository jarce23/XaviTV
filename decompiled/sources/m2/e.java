package m2;

import java.math.RoundingMode;
import k2.b0;
import k2.g0;
import k2.z;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final d f8845a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f8846b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8847c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8848d;

    /* renamed from: e, reason: collision with root package name */
    public final long f8849e;

    /* renamed from: f, reason: collision with root package name */
    public int f8850f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f8851h;

    /* renamed from: i, reason: collision with root package name */
    public int f8852i;

    /* renamed from: j, reason: collision with root package name */
    public int f8853j;

    /* renamed from: k, reason: collision with root package name */
    public int f8854k;

    /* renamed from: l, reason: collision with root package name */
    public long f8855l;

    /* renamed from: m, reason: collision with root package name */
    public long[] f8856m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f8857n;

    public e(int i10, d dVar, g0 g0Var) {
        int i11 = dVar.f8842d;
        this.f8845a = dVar;
        int b2 = dVar.b();
        boolean z10 = true;
        if (b2 != 1 && b2 != 2) {
            z10 = false;
        }
        l1.d.b(z10);
        int i12 = (((i10 % 10) + 48) << 8) | ((i10 / 10) + 48);
        this.f8847c = (b2 == 2 ? 1667497984 : 1651965952) | i12;
        long j10 = dVar.f8840b * 1000000;
        long j11 = dVar.f8841c;
        int i13 = a0.f8067a;
        this.f8849e = a0.V(i11, j10, j11, RoundingMode.DOWN);
        this.f8846b = g0Var;
        this.f8848d = b2 == 2 ? i12 | 1650720768 : -1;
        this.f8855l = -1L;
        this.f8856m = new long[512];
        this.f8857n = new int[512];
        this.f8850f = i11;
    }

    public final b0 a(int i10) {
        return new b0(((this.f8849e * 1) / this.f8850f) * this.f8857n[i10], this.f8856m[i10]);
    }

    public final z b(long j10) {
        if (this.f8854k == 0) {
            b0 b0Var = new b0(0L, this.f8855l);
            return new z(b0Var, b0Var);
        }
        int i10 = (int) (j10 / ((this.f8849e * 1) / this.f8850f));
        int d6 = a0.d(this.f8857n, i10, true, true);
        if (this.f8857n[d6] == i10) {
            b0 a10 = a(d6);
            return new z(a10, a10);
        }
        b0 a11 = a(d6);
        int i11 = d6 + 1;
        return i11 < this.f8856m.length ? new z(a11, a(i11)) : new z(a11, a11);
    }
}
