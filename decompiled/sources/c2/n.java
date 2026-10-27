package c2;

import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n implements g1 {

    /* renamed from: o, reason: collision with root package name */
    public final o9.w0 f2655o;

    /* renamed from: p, reason: collision with root package name */
    public long f2656p;

    public n(List list, List list2) {
        o9.d0 m10 = o9.g0.m();
        l1.d.b(list.size() == list2.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            m10.a(new m((g1) list.get(i10), (List) list2.get(i10)));
        }
        this.f2655o = m10.f();
        this.f2656p = -9223372036854775807L;
    }

    @Override // c2.g1
    public final boolean a() {
        int i10 = 0;
        while (true) {
            o9.w0 w0Var = this.f2655o;
            if (i10 >= w0Var.f9688r) {
                return false;
            }
            if (((m) w0Var.get(i10)).f2641o.a()) {
                return true;
            }
            i10++;
        }
    }

    @Override // c2.g1
    public final long e() {
        int i10 = 0;
        long j10 = Long.MAX_VALUE;
        while (true) {
            o9.w0 w0Var = this.f2655o;
            if (i10 >= w0Var.f9688r) {
                break;
            }
            long e7 = ((m) w0Var.get(i10)).f2641o.e();
            if (e7 != Long.MIN_VALUE) {
                j10 = Math.min(j10, e7);
            }
            i10++;
        }
        if (j10 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j10;
    }

    @Override // c2.g1
    public final long m() {
        int i10 = 0;
        long j10 = Long.MAX_VALUE;
        long j11 = Long.MAX_VALUE;
        while (true) {
            o9.w0 w0Var = this.f2655o;
            if (i10 >= w0Var.f9688r) {
                break;
            }
            m mVar = (m) w0Var.get(i10);
            long m10 = mVar.f2641o.m();
            o9.g0 g0Var = mVar.f2642p;
            if ((g0Var.contains(1) || g0Var.contains(2) || g0Var.contains(4)) && m10 != Long.MIN_VALUE) {
                j10 = Math.min(j10, m10);
            }
            if (m10 != Long.MIN_VALUE) {
                j11 = Math.min(j11, m10);
            }
            i10++;
        }
        if (j10 != Long.MAX_VALUE) {
            this.f2656p = j10;
            return j10;
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j12 = this.f2656p;
        return j12 != -9223372036854775807L ? j12 : j11;
    }

    @Override // c2.g1
    public final boolean s(s1.k0 k0Var) {
        boolean z10;
        boolean z11 = false;
        do {
            long e7 = e();
            if (e7 == Long.MIN_VALUE) {
                return z11;
            }
            int i10 = 0;
            z10 = false;
            while (true) {
                o9.w0 w0Var = this.f2655o;
                if (i10 >= w0Var.f9688r) {
                    break;
                }
                long e8 = ((m) w0Var.get(i10)).f2641o.e();
                boolean z12 = e8 != Long.MIN_VALUE && e8 <= k0Var.f11365a;
                if (e8 == e7 || z12) {
                    z10 |= ((m) w0Var.get(i10)).f2641o.s(k0Var);
                }
                i10++;
            }
            z11 |= z10;
        } while (z10);
        return z11;
    }

    @Override // c2.g1
    public final void v(long j10) {
        int i10 = 0;
        while (true) {
            o9.w0 w0Var = this.f2655o;
            if (i10 >= w0Var.f9688r) {
                return;
            }
            ((m) w0Var.get(i10)).v(j10);
            i10++;
        }
    }
}
