package c2;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 implements b0, a0 {

    /* renamed from: o, reason: collision with root package name */
    public final b0[] f2643o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean[] f2644p;

    /* renamed from: q, reason: collision with root package name */
    public final IdentityHashMap f2645q;

    /* renamed from: r, reason: collision with root package name */
    public final d9.f f2646r;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f2647s = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public final HashMap f2648t = new HashMap();

    /* renamed from: u, reason: collision with root package name */
    public a0 f2649u;

    /* renamed from: v, reason: collision with root package name */
    public n1 f2650v;

    /* renamed from: w, reason: collision with root package name */
    public b0[] f2651w;

    /* renamed from: x, reason: collision with root package name */
    public n f2652x;

    public m0(d9.f fVar, long[] jArr, b0... b0VarArr) {
        this.f2646r = fVar;
        this.f2643o = b0VarArr;
        fVar.getClass();
        o9.e0 e0Var = o9.g0.f9617p;
        o9.w0 w0Var = o9.w0.f9686s;
        this.f2652x = new n(w0Var, w0Var);
        this.f2645q = new IdentityHashMap();
        this.f2651w = new b0[0];
        this.f2644p = new boolean[b0VarArr.length];
        for (int i10 = 0; i10 < b0VarArr.length; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                this.f2644p[i10] = true;
                this.f2643o[i10] = new l1(b0VarArr[i10], j10);
            }
        }
    }

    @Override // c2.g1
    public final boolean a() {
        return this.f2652x.a();
    }

    @Override // c2.f1
    public final void b(g1 g1Var) {
        a0 a0Var = this.f2649u;
        a0Var.getClass();
        a0Var.b(this);
    }

    @Override // c2.a0
    public final void c(b0 b0Var) {
        ArrayList arrayList = this.f2647s;
        arrayList.remove(b0Var);
        if (arrayList.isEmpty()) {
            b0[] b0VarArr = this.f2643o;
            int i10 = 0;
            for (b0 b0Var2 : b0VarArr) {
                i10 += b0Var2.j().f2660a;
            }
            i1.u0[] u0VarArr = new i1.u0[i10];
            int i11 = 0;
            for (int i12 = 0; i12 < b0VarArr.length; i12++) {
                n1 j10 = b0VarArr[i12].j();
                int i13 = j10.f2660a;
                int i14 = 0;
                while (i14 < i13) {
                    i1.u0 a10 = j10.a(i14);
                    int i15 = a10.f6039a;
                    i1.p[] pVarArr = new i1.p[i15];
                    for (int i16 = 0; i16 < i15; i16++) {
                        i1.p pVar = a10.f6042d[i16];
                        i1.o a11 = pVar.a();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i12);
                        sb2.append(":");
                        String str = pVar.f5979a;
                        if (str == null) {
                            str = _UrlKt.FRAGMENT_ENCODE_SET;
                        }
                        sb2.append(str);
                        a11.f5929a = sb2.toString();
                        pVarArr[i16] = new i1.p(a11);
                    }
                    i1.u0 u0Var = new i1.u0(i12 + ":" + a10.f6040b, pVarArr);
                    this.f2648t.put(u0Var, a10);
                    u0VarArr[i11] = u0Var;
                    i14++;
                    i11++;
                }
            }
            this.f2650v = new n1(u0VarArr);
            a0 a0Var = this.f2649u;
            a0Var.getClass();
            a0Var.c(this);
        }
    }

    @Override // c2.g1
    public final long e() {
        return this.f2652x.e();
    }

    @Override // c2.b0
    public final long g() {
        long j10 = -9223372036854775807L;
        for (b0 b0Var : this.f2651w) {
            long g = b0Var.g();
            if (g != -9223372036854775807L) {
                if (j10 == -9223372036854775807L) {
                    for (b0 b0Var2 : this.f2651w) {
                        if (b0Var2 == b0Var) {
                            break;
                        }
                        if (b0Var2.p(g) != g) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j10 = g;
                } else if (g != j10) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (j10 != -9223372036854775807L && b0Var.p(j10) != j10) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j10;
    }

    @Override // c2.b0
    public final long h(long j10, s1.f1 f1Var) {
        b0[] b0VarArr = this.f2651w;
        return (b0VarArr.length > 0 ? b0VarArr[0] : this.f2643o[0]).h(j10, f1Var);
    }

    @Override // c2.b0
    public final n1 j() {
        n1 n1Var = this.f2650v;
        n1Var.getClass();
        return n1Var;
    }

    @Override // c2.b0
    public final long k(f2.t[] tVarArr, boolean[] zArr, e1[] e1VarArr, boolean[] zArr2, long j10) {
        IdentityHashMap identityHashMap;
        int[] iArr;
        int[] iArr2 = new int[tVarArr.length];
        int[] iArr3 = new int[tVarArr.length];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int length = tVarArr.length;
            identityHashMap = this.f2645q;
            if (i11 >= length) {
                break;
            }
            e1 e1Var = e1VarArr[i11];
            Integer num = e1Var == null ? null : (Integer) identityHashMap.get(e1Var);
            iArr2[i11] = num == null ? -1 : num.intValue();
            f2.t tVar = tVarArr[i11];
            if (tVar != null) {
                String str = tVar.k().f6040b;
                iArr3[i11] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr3[i11] = -1;
            }
            i11++;
        }
        identityHashMap.clear();
        int length2 = tVarArr.length;
        e1[] e1VarArr2 = new e1[length2];
        e1[] e1VarArr3 = new e1[tVarArr.length];
        f2.t[] tVarArr2 = new f2.t[tVarArr.length];
        b0[] b0VarArr = this.f2643o;
        ArrayList arrayList = new ArrayList(b0VarArr.length);
        long j11 = j10;
        int i12 = 0;
        while (i12 < b0VarArr.length) {
            int i13 = i10;
            while (i13 < tVarArr.length) {
                e1VarArr3[i13] = iArr2[i13] == i12 ? e1VarArr[i13] : null;
                if (iArr3[i13] == i12) {
                    f2.t tVar2 = tVarArr[i13];
                    tVar2.getClass();
                    iArr = iArr2;
                    i1.u0 u0Var = (i1.u0) this.f2648t.get(tVar2.k());
                    u0Var.getClass();
                    tVarArr2[i13] = new l0(tVar2, u0Var);
                } else {
                    iArr = iArr2;
                    tVarArr2[i13] = null;
                }
                i13++;
                iArr2 = iArr;
            }
            int[] iArr4 = iArr2;
            b0[] b0VarArr2 = b0VarArr;
            int i14 = i12;
            long k10 = b0VarArr2[i12].k(tVarArr2, zArr, e1VarArr3, zArr2, j11);
            if (i14 == 0) {
                j11 = k10;
            } else if (k10 != j11) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z10 = false;
            for (int i15 = 0; i15 < tVarArr.length; i15++) {
                if (iArr3[i15] == i14) {
                    e1 e1Var2 = e1VarArr3[i15];
                    e1Var2.getClass();
                    e1VarArr2[i15] = e1VarArr3[i15];
                    identityHashMap.put(e1Var2, Integer.valueOf(i14));
                    z10 = true;
                } else if (iArr4[i15] == i14) {
                    l1.d.g(e1VarArr3[i15] == null);
                }
            }
            if (z10) {
                arrayList.add(b0VarArr2[i14]);
            }
            i12 = i14 + 1;
            b0VarArr = b0VarArr2;
            iArr2 = iArr4;
            i10 = 0;
        }
        int i16 = i10;
        System.arraycopy(e1VarArr2, i16, e1VarArr, i16, length2);
        this.f2651w = (b0[]) arrayList.toArray(new b0[i16]);
        AbstractList q10 = o9.q.q(arrayList, new a6.a0(7));
        this.f2646r.getClass();
        this.f2652x = new n(arrayList, q10);
        return j11;
    }

    @Override // c2.b0
    public final void l(a0 a0Var, long j10) {
        this.f2649u = a0Var;
        ArrayList arrayList = this.f2647s;
        b0[] b0VarArr = this.f2643o;
        Collections.addAll(arrayList, b0VarArr);
        for (b0 b0Var : b0VarArr) {
            b0Var.l(this, j10);
        }
    }

    @Override // c2.g1
    public final long m() {
        return this.f2652x.m();
    }

    @Override // c2.b0
    public final void n() {
        for (b0 b0Var : this.f2643o) {
            b0Var.n();
        }
    }

    @Override // c2.b0
    public final long p(long j10) {
        long p10 = this.f2651w[0].p(j10);
        int i10 = 1;
        while (true) {
            b0[] b0VarArr = this.f2651w;
            if (i10 >= b0VarArr.length) {
                return p10;
            }
            if (b0VarArr[i10].p(p10) != p10) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i10++;
        }
    }

    @Override // c2.b0
    public final void r(long j10) {
        for (b0 b0Var : this.f2651w) {
            b0Var.r(j10);
        }
    }

    @Override // c2.g1
    public final boolean s(s1.k0 k0Var) {
        ArrayList arrayList = this.f2647s;
        if (arrayList.isEmpty()) {
            return this.f2652x.s(k0Var);
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b0) arrayList.get(i10)).s(k0Var);
        }
        return false;
    }

    @Override // c2.g1
    public final void v(long j10) {
        this.f2652x.v(j10);
    }
}
