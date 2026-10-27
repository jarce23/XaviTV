package s1;

import android.util.Pair;
import c2.h1;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c1 extends i1.t0 {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f11239k = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f11240b;

    /* renamed from: c, reason: collision with root package name */
    public final h1 f11241c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11242d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11243e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f11244f;
    public final int[] g;

    /* renamed from: h, reason: collision with root package name */
    public final i1.t0[] f11245h;

    /* renamed from: i, reason: collision with root package name */
    public final Object[] f11246i;

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f11247j;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c1(java.util.ArrayList r8, c2.h1 r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            i1.t0[] r0 = new i1.t0[r0]
            int r1 = r8.size()
            r2 = 0
            r3 = r2
            r4 = r3
        Ld:
            if (r4 >= r1) goto L21
            java.lang.Object r5 = r8.get(r4)
            int r4 = r4 + 1
            s1.p0 r5 = (s1.p0) r5
            int r6 = r3 + 1
            i1.t0 r5 = r5.b()
            r0[r3] = r5
            r3 = r6
            goto Ld
        L21:
            int r1 = r8.size()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int r3 = r8.size()
            r4 = r2
        L2c:
            if (r4 >= r3) goto L40
            java.lang.Object r5 = r8.get(r4)
            int r4 = r4 + 1
            s1.p0 r5 = (s1.p0) r5
            int r6 = r2 + 1
            java.lang.Object r5 = r5.a()
            r1[r2] = r5
            r2 = r6
            goto L2c
        L40:
            r7.<init>(r0, r1, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.c1.<init>(java.util.ArrayList, c2.h1):void");
    }

    @Override // i1.t0
    public final int a(boolean z10) {
        if (this.f11240b != 0) {
            int i10 = 0;
            if (z10) {
                int[] iArr = this.f11241c.f2599b;
                i10 = iArr.length > 0 ? iArr[0] : -1;
            }
            do {
                i1.t0[] t0VarArr = this.f11245h;
                if (!t0VarArr[i10].p()) {
                    return t0VarArr[i10].a(z10) + this.g[i10];
                }
                i10 = q(i10, z10);
            } while (i10 != -1);
        }
        return -1;
    }

    @Override // i1.t0
    public final int b(Object obj) {
        int b2;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            Integer num = (Integer) this.f11247j.get(obj2);
            int intValue = num == null ? -1 : num.intValue();
            if (intValue != -1 && (b2 = this.f11245h[intValue].b(obj3)) != -1) {
                return this.f11244f[intValue] + b2;
            }
        }
        return -1;
    }

    @Override // i1.t0
    public final int c(boolean z10) {
        int i10;
        int i11 = this.f11240b;
        if (i11 != 0) {
            if (z10) {
                int[] iArr = this.f11241c.f2599b;
                i10 = iArr.length > 0 ? iArr[iArr.length - 1] : -1;
            } else {
                i10 = i11 - 1;
            }
            do {
                i1.t0[] t0VarArr = this.f11245h;
                if (!t0VarArr[i10].p()) {
                    return t0VarArr[i10].c(z10) + this.g[i10];
                }
                i10 = r(i10, z10);
            } while (i10 != -1);
        }
        return -1;
    }

    @Override // i1.t0
    public final int e(int i10, int i11, boolean z10) {
        int[] iArr = this.g;
        int d6 = l1.a0.d(iArr, i10 + 1, false, false);
        int i12 = iArr[d6];
        i1.t0[] t0VarArr = this.f11245h;
        int e7 = t0VarArr[d6].e(i10 - i12, i11 != 2 ? i11 : 0, z10);
        if (e7 != -1) {
            return i12 + e7;
        }
        int q10 = q(d6, z10);
        while (q10 != -1 && t0VarArr[q10].p()) {
            q10 = q(q10, z10);
        }
        if (q10 != -1) {
            return t0VarArr[q10].a(z10) + iArr[q10];
        }
        if (i11 == 2) {
            return a(z10);
        }
        return -1;
    }

    @Override // i1.t0
    public final i1.r0 f(int i10, i1.r0 r0Var, boolean z10) {
        int[] iArr = this.f11244f;
        int d6 = l1.a0.d(iArr, i10 + 1, false, false);
        int i11 = this.g[d6];
        this.f11245h[d6].f(i10 - iArr[d6], r0Var, z10);
        r0Var.f6014c += i11;
        if (z10) {
            Object obj = this.f11246i[d6];
            Object obj2 = r0Var.f6013b;
            obj2.getClass();
            r0Var.f6013b = Pair.create(obj, obj2);
        }
        return r0Var;
    }

    @Override // i1.t0
    public final i1.r0 g(Object obj, i1.r0 r0Var) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        Integer num = (Integer) this.f11247j.get(obj2);
        int intValue = num == null ? -1 : num.intValue();
        int i10 = this.g[intValue];
        this.f11245h[intValue].g(obj3, r0Var);
        r0Var.f6014c += i10;
        r0Var.f6013b = obj;
        return r0Var;
    }

    @Override // i1.t0
    public final int h() {
        return this.f11243e;
    }

    @Override // i1.t0
    public final int k(int i10, int i11, boolean z10) {
        int[] iArr = this.g;
        int d6 = l1.a0.d(iArr, i10 + 1, false, false);
        int i12 = iArr[d6];
        i1.t0[] t0VarArr = this.f11245h;
        int k10 = t0VarArr[d6].k(i10 - i12, i11 != 2 ? i11 : 0, z10);
        if (k10 != -1) {
            return i12 + k10;
        }
        int r2 = r(d6, z10);
        while (r2 != -1 && t0VarArr[r2].p()) {
            r2 = r(r2, z10);
        }
        if (r2 != -1) {
            return t0VarArr[r2].c(z10) + iArr[r2];
        }
        if (i11 == 2) {
            return c(z10);
        }
        return -1;
    }

    @Override // i1.t0
    public final Object l(int i10) {
        int[] iArr = this.f11244f;
        int d6 = l1.a0.d(iArr, i10 + 1, false, false);
        return Pair.create(this.f11246i[d6], this.f11245h[d6].l(i10 - iArr[d6]));
    }

    @Override // i1.t0
    public final i1.s0 m(int i10, i1.s0 s0Var, long j10) {
        int[] iArr = this.g;
        int d6 = l1.a0.d(iArr, i10 + 1, false, false);
        int i11 = iArr[d6];
        int i12 = this.f11244f[d6];
        this.f11245h[d6].m(i10 - i11, s0Var, j10);
        Object obj = this.f11246i[d6];
        if (!i1.s0.f6019q.equals(s0Var.f6021a)) {
            obj = Pair.create(obj, s0Var.f6021a);
        }
        s0Var.f6021a = obj;
        s0Var.f6033n += i12;
        s0Var.f6034o += i12;
        return s0Var;
    }

    @Override // i1.t0
    public final int o() {
        return this.f11242d;
    }

    public final int q(int i10, boolean z10) {
        if (!z10) {
            if (i10 < this.f11240b - 1) {
                return i10 + 1;
            }
            return -1;
        }
        h1 h1Var = this.f11241c;
        int i11 = h1Var.f2600c[i10] + 1;
        int[] iArr = h1Var.f2599b;
        if (i11 < iArr.length) {
            return iArr[i11];
        }
        return -1;
    }

    public final int r(int i10, boolean z10) {
        if (!z10) {
            if (i10 > 0) {
                return i10 - 1;
            }
            return -1;
        }
        h1 h1Var = this.f11241c;
        int i11 = h1Var.f2600c[i10] - 1;
        if (i11 >= 0) {
            return h1Var.f2599b[i11];
        }
        return -1;
    }

    public c1(i1.t0[] t0VarArr, Object[] objArr, h1 h1Var) {
        this.f11241c = h1Var;
        this.f11240b = h1Var.f2599b.length;
        int length = t0VarArr.length;
        this.f11245h = t0VarArr;
        this.f11244f = new int[length];
        this.g = new int[length];
        this.f11246i = objArr;
        this.f11247j = new HashMap();
        int length2 = t0VarArr.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i10 < length2) {
            i1.t0 t0Var = t0VarArr[i10];
            this.f11245h[i13] = t0Var;
            this.g[i13] = i11;
            this.f11244f[i13] = i12;
            i11 += t0Var.o();
            i12 += this.f11245h[i13].h();
            this.f11247j.put(objArr[i13], Integer.valueOf(i13));
            i10++;
            i13++;
        }
        this.f11242d = i11;
        this.f11243e = i12;
    }
}
