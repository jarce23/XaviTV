package i1;

import android.util.Pair;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class t0 {

    /* renamed from: a, reason: collision with root package name */
    public static final q0 f6037a = new q0();

    static {
        l1.a0.J(0);
        l1.a0.J(1);
        l1.a0.J(2);
    }

    public int a(boolean z10) {
        return p() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z10) {
        if (p()) {
            return -1;
        }
        return o() - 1;
    }

    public final int d(int i10, r0 r0Var, s0 s0Var, int i11, boolean z10) {
        int i12 = f(i10, r0Var, false).f6014c;
        if (m(i12, s0Var, 0L).f6034o != i10) {
            return i10 + 1;
        }
        int e7 = e(i12, i11, z10);
        if (e7 == -1) {
            return -1;
        }
        return m(e7, s0Var, 0L).f6033n;
    }

    public int e(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == c(z10)) {
                return -1;
            }
            return i10 + 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == c(z10) ? a(z10) : i10 + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        int c10;
        if (this != obj) {
            if (obj instanceof t0) {
                t0 t0Var = (t0) obj;
                if (t0Var.o() == o() && t0Var.h() == h()) {
                    s0 s0Var = new s0();
                    r0 r0Var = new r0();
                    s0 s0Var2 = new s0();
                    r0 r0Var2 = new r0();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= o()) {
                            int i11 = 0;
                            while (true) {
                                if (i11 >= h()) {
                                    int a10 = a(true);
                                    if (a10 == t0Var.a(true) && (c10 = c(true)) == t0Var.c(true)) {
                                        while (a10 != c10) {
                                            int e7 = e(a10, 0, true);
                                            if (e7 == t0Var.e(a10, 0, true)) {
                                                a10 = e7;
                                            }
                                        }
                                    }
                                } else {
                                    if (!f(i11, r0Var, true).equals(t0Var.f(i11, r0Var2, true))) {
                                        break;
                                    }
                                    i11++;
                                }
                            }
                        } else {
                            if (!m(i10, s0Var, 0L).equals(t0Var.m(i10, s0Var2, 0L))) {
                                break;
                            }
                            i10++;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public abstract r0 f(int i10, r0 r0Var, boolean z10);

    public r0 g(Object obj, r0 r0Var) {
        return f(b(obj), r0Var, true);
    }

    public abstract int h();

    public int hashCode() {
        s0 s0Var = new s0();
        r0 r0Var = new r0();
        int o2 = o() + 217;
        for (int i10 = 0; i10 < o(); i10++) {
            o2 = (o2 * 31) + m(i10, s0Var, 0L).hashCode();
        }
        int h10 = h() + (o2 * 31);
        for (int i11 = 0; i11 < h(); i11++) {
            h10 = (h10 * 31) + f(i11, r0Var, true).hashCode();
        }
        int a10 = a(true);
        while (a10 != -1) {
            h10 = (h10 * 31) + a10;
            a10 = e(a10, 0, true);
        }
        return h10;
    }

    public final Pair i(s0 s0Var, r0 r0Var, int i10, long j10) {
        Pair j11 = j(s0Var, r0Var, i10, j10, 0L);
        j11.getClass();
        return j11;
    }

    public final Pair j(s0 s0Var, r0 r0Var, int i10, long j10, long j11) {
        l1.d.c(i10, o());
        m(i10, s0Var, j11);
        if (j10 == -9223372036854775807L) {
            j10 = s0Var.f6031l;
            if (j10 == -9223372036854775807L) {
                return null;
            }
        }
        int i11 = s0Var.f6033n;
        f(i11, r0Var, false);
        while (i11 < s0Var.f6034o && r0Var.f6016e != j10) {
            int i12 = i11 + 1;
            if (f(i12, r0Var, false).f6016e > j10) {
                break;
            }
            i11 = i12;
        }
        f(i11, r0Var, true);
        long j12 = j10 - r0Var.f6016e;
        long j13 = r0Var.f6015d;
        if (j13 != -9223372036854775807L) {
            j12 = Math.min(j12, j13 - 1);
        }
        long max = Math.max(0L, j12);
        Object obj = r0Var.f6013b;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(max));
    }

    public int k(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == a(z10)) {
                return -1;
            }
            return i10 - 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == a(z10) ? c(z10) : i10 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object l(int i10);

    public abstract s0 m(int i10, s0 s0Var, long j10);

    public final void n(int i10, s0 s0Var) {
        m(i10, s0Var, 0L);
    }

    public abstract int o();

    public final boolean p() {
        return o() == 0;
    }
}
