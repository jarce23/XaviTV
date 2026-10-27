package f2;

import i1.u0;
import o9.g0;
import o9.v0;
import o9.y;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends p implements Comparable {
    public final boolean A;

    /* renamed from: s, reason: collision with root package name */
    public final int f4918s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f4919t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f4920u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f4921v;

    /* renamed from: w, reason: collision with root package name */
    public final int f4922w;

    /* renamed from: x, reason: collision with root package name */
    public final int f4923x;

    /* renamed from: y, reason: collision with root package name */
    public final int f4924y;

    /* renamed from: z, reason: collision with root package name */
    public final int f4925z;

    public n(int i10, u0 u0Var, int i11, k kVar, int i12, String str, String str2) {
        super(i10, u0Var, i11);
        int i13;
        int i14 = 0;
        this.f4919t = r.a.b(i12, false);
        int i15 = this.f4929r.f5983e;
        int i16 = kVar.f6134y;
        g0 g0Var = kVar.f6131v;
        int i17 = i15 & (~i16);
        this.f4920u = (i17 & 1) != 0;
        this.f4921v = (i17 & 2) != 0;
        g0 r2 = str2 != null ? g0.r(str2) : g0Var.isEmpty() ? g0.r(_UrlKt.FRAGMENT_ENCODE_SET) : g0Var;
        int i18 = 0;
        while (true) {
            if (i18 >= r2.size()) {
                i13 = 0;
                i18 = Integer.MAX_VALUE;
                break;
            } else {
                i13 = r.d(this.f4929r, (String) r2.get(i18), kVar.f6135z);
                if (i13 > 0) {
                    break;
                } else {
                    i18++;
                }
            }
        }
        this.f4922w = i18;
        this.f4923x = i13;
        int i19 = str2 != null ? 1088 : kVar.f6132w;
        int i20 = this.f4929r.f5984f;
        v0 v0Var = r.f4938l;
        int bitCount = (i20 == 0 || i20 != i19) ? Integer.bitCount(i19 & i20) : Integer.MAX_VALUE;
        this.f4924y = bitCount;
        this.A = (1088 & this.f4929r.f5984f) != 0;
        int d6 = r.d(this.f4929r, str, r.g(str) == null);
        this.f4925z = d6;
        boolean z10 = i13 > 0 || (g0Var.isEmpty() && bitCount > 0) || this.f4920u || (this.f4921v && d6 > 0);
        if (r.a.b(i12, kVar.f4913t0) && z10) {
            i14 = 1;
        }
        this.f4918s = i14;
    }

    @Override // f2.p
    public final int a() {
        return this.f4918s;
    }

    @Override // f2.p
    public final /* bridge */ /* synthetic */ boolean b(p pVar) {
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(n nVar) {
        y c10 = y.f9691a.c(this.f4919t, nVar.f4919t);
        Integer valueOf = Integer.valueOf(this.f4922w);
        Integer valueOf2 = Integer.valueOf(nVar.f4922w);
        o9.u0 u0Var = o9.u0.f9682p;
        o9.u0 u0Var2 = o9.u0.f9683q;
        y b2 = c10.b(valueOf, valueOf2, u0Var2);
        int i10 = nVar.f4923x;
        int i11 = this.f4923x;
        y a10 = b2.a(i11, i10);
        int i12 = nVar.f4924y;
        int i13 = this.f4924y;
        y c11 = a10.a(i13, i12).c(this.f4920u, nVar.f4920u);
        Boolean valueOf3 = Boolean.valueOf(this.f4921v);
        Boolean valueOf4 = Boolean.valueOf(nVar.f4921v);
        if (i11 != 0) {
            u0Var = u0Var2;
        }
        y a11 = c11.b(valueOf3, valueOf4, u0Var).a(this.f4925z, nVar.f4925z);
        if (i13 == 0) {
            a11 = a11.d(this.A, nVar.A);
        }
        return a11.e();
    }
}
