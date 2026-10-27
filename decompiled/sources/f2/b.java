package f2;

import android.os.SystemClock;
import i1.u0;
import java.util.ArrayList;
import java.util.List;
import l1.a0;
import o9.d0;
import o9.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends d {
    public final g2.d g;

    /* renamed from: h, reason: collision with root package name */
    public final long f4868h;

    /* renamed from: i, reason: collision with root package name */
    public final long f4869i;

    /* renamed from: j, reason: collision with root package name */
    public final long f4870j;

    /* renamed from: k, reason: collision with root package name */
    public final int f4871k;

    /* renamed from: l, reason: collision with root package name */
    public final int f4872l;

    /* renamed from: m, reason: collision with root package name */
    public final float f4873m;

    /* renamed from: n, reason: collision with root package name */
    public final float f4874n;

    /* renamed from: o, reason: collision with root package name */
    public final g0 f4875o;

    /* renamed from: p, reason: collision with root package name */
    public final l1.v f4876p;

    /* renamed from: q, reason: collision with root package name */
    public float f4877q;

    /* renamed from: r, reason: collision with root package name */
    public int f4878r;

    /* renamed from: s, reason: collision with root package name */
    public int f4879s;

    /* renamed from: t, reason: collision with root package name */
    public long f4880t;

    /* renamed from: u, reason: collision with root package name */
    public d2.b f4881u;

    public b(u0 u0Var, int[] iArr, g2.d dVar, long j10, long j11, long j12, g0 g0Var) {
        super(u0Var, iArr);
        if (j12 < j10) {
            l1.b.q("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j12 = j10;
        }
        this.g = dVar;
        this.f4868h = j10 * 1000;
        this.f4869i = j11 * 1000;
        this.f4870j = j12 * 1000;
        this.f4871k = 1279;
        this.f4872l = 719;
        this.f4873m = 0.7f;
        this.f4874n = 0.75f;
        this.f4875o = g0.n(g0Var);
        this.f4876p = l1.v.f8135a;
        this.f4877q = 1.0f;
        this.f4879s = 0;
        this.f4880t = -9223372036854775807L;
    }

    public static void u(ArrayList arrayList, long[] jArr) {
        long j10 = 0;
        for (long j11 : jArr) {
            j10 += j11;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            d0 d0Var = (d0) arrayList.get(i10);
            if (d0Var != null) {
                d0Var.a(new a(j10, jArr[i10]));
            }
        }
    }

    public static long w(List list) {
        if (!list.isEmpty()) {
            d2.b bVar = (d2.b) o9.q.g(list);
            long j10 = bVar.g;
            if (j10 != -9223372036854775807L) {
                long j11 = bVar.f4002h;
                if (j11 != -9223372036854775807L) {
                    return j11 - j10;
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // f2.d, f2.t
    public final void e() {
        this.f4880t = -9223372036854775807L;
        this.f4881u = null;
    }

    @Override // f2.d, f2.t
    public final int g(long j10, List list) {
        int i10;
        int i11;
        this.f4876p.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = this.f4880t;
        if (j11 != -9223372036854775807L && elapsedRealtime - j11 < 1000 && (list.isEmpty() || ((d2.b) o9.q.g(list)).equals(this.f4881u))) {
            return list.size();
        }
        this.f4880t = elapsedRealtime;
        this.f4881u = list.isEmpty() ? null : (d2.b) o9.q.g(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long B = a0.B(((d2.b) list.get(size - 1)).g - j10, this.f4877q);
        long j12 = this.f4870j;
        if (B >= j12) {
            w(list);
            i1.p pVar = this.f4886d[v(elapsedRealtime)];
            for (int i12 = 0; i12 < size; i12++) {
                d2.b bVar = (d2.b) list.get(i12);
                i1.p pVar2 = bVar.f3999d;
                if (a0.B(bVar.g - j10, this.f4877q) >= j12 && pVar2.f5987j < pVar.f5987j && (i10 = pVar2.f5999v) != -1 && i10 <= this.f4872l && (i11 = pVar2.f5998u) != -1 && i11 <= this.f4871k && i10 < pVar.f5999v) {
                    return i12;
                }
            }
        }
        return size;
    }

    @Override // f2.d, f2.t
    public final void h() {
        this.f4881u = null;
    }

    @Override // f2.t
    public final void i(long j10, long j11, long j12, List list, d2.c[] cVarArr) {
        long w10;
        this.f4876p.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i10 = this.f4878r;
        int i11 = 0;
        if (i10 >= cVarArr.length || !cVarArr[i10].next()) {
            int length = cVarArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    w10 = w(list);
                    break;
                }
                d2.c cVar = cVarArr[i12];
                if (cVar.next()) {
                    w10 = cVar.a() - cVar.d();
                    break;
                }
                i12++;
            }
        } else {
            d2.c cVar2 = cVarArr[this.f4878r];
            w10 = cVar2.a() - cVar2.d();
        }
        int i13 = this.f4879s;
        if (i13 == 0) {
            this.f4879s = 1;
            this.f4878r = v(elapsedRealtime);
            return;
        }
        int i14 = this.f4878r;
        boolean isEmpty = list.isEmpty();
        i1.p[] pVarArr = this.f4886d;
        if (!isEmpty) {
            i1.p pVar = ((d2.b) o9.q.g(list)).f3999d;
            while (i11 < this.f4884b) {
                if (pVarArr[i11] == pVar) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        i11 = -1;
        if (i11 != -1) {
            i13 = ((d2.b) o9.q.g(list)).f4000e;
            i14 = i11;
        }
        int v10 = v(elapsedRealtime);
        if (v10 != i14 && !b(i14, elapsedRealtime)) {
            i1.p pVar2 = pVarArr[i14];
            i1.p pVar3 = pVarArr[v10];
            long j13 = this.f4868h;
            if (j12 != -9223372036854775807L) {
                j13 = Math.min((long) ((w10 != -9223372036854775807L ? j12 - w10 : j12) * this.f4874n), j13);
            }
            int i15 = pVar3.f5987j;
            int i16 = pVar2.f5987j;
            if ((i15 > i16 && j11 < j13) || (i15 < i16 && j11 >= this.f4869i)) {
                v10 = i14;
            }
        }
        if (v10 != i14) {
            i13 = 3;
        }
        this.f4879s = i13;
        this.f4878r = v10;
    }

    @Override // f2.t
    public final int m() {
        return this.f4879s;
    }

    @Override // f2.t
    public final int n() {
        return this.f4878r;
    }

    @Override // f2.d, f2.t
    public final void p(float f10) {
        this.f4877q = f10;
    }

    @Override // f2.t
    public final Object q() {
        return null;
    }

    public final int v(long j10) {
        long j11;
        g2.g gVar = (g2.g) this.g;
        synchronized (gVar) {
            j11 = gVar.f5111l;
        }
        long j12 = (long) (j11 * this.f4873m);
        this.g.getClass();
        long j13 = (long) (j12 / this.f4877q);
        if (!this.f4875o.isEmpty()) {
            int i10 = 1;
            while (i10 < this.f4875o.size() - 1 && ((a) this.f4875o.get(i10)).f4866a < j13) {
                i10++;
            }
            a aVar = (a) this.f4875o.get(i10 - 1);
            a aVar2 = (a) this.f4875o.get(i10);
            long j14 = aVar.f4866a;
            long j15 = aVar.f4867b;
            j13 = j15 + ((long) (((j13 - j14) / (aVar2.f4866a - j14)) * (aVar2.f4867b - j15)));
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f4884b; i12++) {
            if (j10 == Long.MIN_VALUE || !b(i12, j10)) {
                if (this.f4886d[i12].f5987j <= j13) {
                    return i12;
                }
                i11 = i12;
            }
        }
        return i11;
    }
}
