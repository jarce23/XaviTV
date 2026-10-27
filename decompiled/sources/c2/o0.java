package c2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o0 extends l {

    /* renamed from: s, reason: collision with root package name */
    public static final i1.a0 f2666s;

    /* renamed from: k, reason: collision with root package name */
    public final a[] f2667k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f2668l;

    /* renamed from: m, reason: collision with root package name */
    public final i1.t0[] f2669m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f2670n;

    /* renamed from: o, reason: collision with root package name */
    public final d9.f f2671o;

    /* renamed from: p, reason: collision with root package name */
    public int f2672p;

    /* renamed from: q, reason: collision with root package name */
    public long[][] f2673q;

    /* renamed from: r, reason: collision with root package name */
    public a6.d0 f2674r;

    static {
        i1.s sVar = new i1.s();
        o9.e0 e0Var = o9.g0.f9617p;
        o9.w0 w0Var = o9.w0.f9686s;
        List list = Collections.EMPTY_LIST;
        o9.w0 w0Var2 = o9.w0.f9686s;
        i1.v vVar = new i1.v();
        f2666s = new i1.a0("MergingMediaSource", new i1.u(sVar), null, new i1.w(vVar), i1.d0.B, i1.y.f6072a);
    }

    public o0(a... aVarArr) {
        d9.f fVar = new d9.f(8);
        this.f2667k = aVarArr;
        this.f2671o = fVar;
        this.f2670n = new ArrayList(Arrays.asList(aVarArr));
        this.f2672p = -1;
        this.f2668l = new ArrayList(aVarArr.length);
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            this.f2668l.add(new ArrayList());
        }
        this.f2669m = new i1.t0[aVarArr.length];
        this.f2673q = new long[0][];
        new HashMap();
        o9.q.b(8, "expectedKeys");
        o9.q.b(2, "expectedValuesPerKey");
        new o9.s0(o9.u.a(8)).f9668t = new o9.r0();
    }

    @Override // c2.a
    public final b0 a(d0 d0Var, g2.e eVar, long j10) {
        a[] aVarArr = this.f2667k;
        int length = aVarArr.length;
        b0[] b0VarArr = new b0[length];
        i1.t0[] t0VarArr = this.f2669m;
        int b2 = t0VarArr[0].b(d0Var.f2539a);
        for (int i10 = 0; i10 < length; i10++) {
            d0 a10 = d0Var.a(t0VarArr[i10].l(b2));
            b0VarArr[i10] = aVarArr[i10].a(a10, eVar, j10 - this.f2673q[b2][i10]);
            ((List) this.f2668l.get(i10)).add(new n0(a10, b0VarArr[i10]));
        }
        return new m0(this.f2671o, this.f2673q[b2], b0VarArr);
    }

    @Override // c2.a
    public final i1.a0 g() {
        a[] aVarArr = this.f2667k;
        return aVarArr.length > 0 ? aVarArr[0].g() : f2666s;
    }

    @Override // c2.l, c2.a
    public final void i() {
        a6.d0 d0Var = this.f2674r;
        if (d0Var != null) {
            throw d0Var;
        }
        super.i();
    }

    @Override // c2.a
    public final void k(o1.e0 e0Var) {
        this.f2635j = e0Var;
        this.f2634i = l1.a0.n(null);
        int i10 = 0;
        while (true) {
            a[] aVarArr = this.f2667k;
            if (i10 >= aVarArr.length) {
                return;
            }
            w(Integer.valueOf(i10), aVarArr[i10]);
            i10++;
        }
    }

    @Override // c2.a
    public final void m(b0 b0Var) {
        m0 m0Var = (m0) b0Var;
        int i10 = 0;
        while (true) {
            a[] aVarArr = this.f2667k;
            if (i10 >= aVarArr.length) {
                return;
            }
            List list = (List) this.f2668l.get(i10);
            b0[] b0VarArr = m0Var.f2643o;
            boolean[] zArr = m0Var.f2644p;
            b0 b0Var2 = zArr[i10] ? ((l1) b0VarArr[i10]).f2638o : b0VarArr[i10];
            int i11 = 0;
            while (true) {
                if (i11 >= list.size()) {
                    break;
                }
                if (((n0) list.get(i11)).f2658b.equals(b0Var2)) {
                    list.remove(i11);
                    break;
                }
                i11++;
            }
            a aVar = aVarArr[i10];
            b0[] b0VarArr2 = m0Var.f2643o;
            aVar.m(zArr[i10] ? ((l1) b0VarArr2[i10]).f2638o : b0VarArr2[i10]);
            i10++;
        }
    }

    @Override // c2.l, c2.a
    public final void o() {
        super.o();
        Arrays.fill(this.f2669m, (Object) null);
        this.f2672p = -1;
        this.f2674r = null;
        ArrayList arrayList = this.f2670n;
        arrayList.clear();
        Collections.addAll(arrayList, this.f2667k);
    }

    @Override // c2.a
    public final void r(i1.a0 a0Var) {
        this.f2667k[0].r(a0Var);
    }

    @Override // c2.l
    public final d0 s(Object obj, d0 d0Var) {
        int intValue = ((Integer) obj).intValue();
        ArrayList arrayList = this.f2668l;
        List list = (List) arrayList.get(intValue);
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (((n0) list.get(i10)).f2657a.equals(d0Var)) {
                return ((n0) ((List) arrayList.get(0)).get(i10)).f2657a;
            }
        }
        return null;
    }

    @Override // c2.l
    public final void v(Object obj, a aVar, i1.t0 t0Var) {
        Integer num = (Integer) obj;
        if (this.f2674r != null) {
            return;
        }
        if (this.f2672p == -1) {
            this.f2672p = t0Var.h();
        } else if (t0Var.h() != this.f2672p) {
            this.f2674r = new a6.d0();
            return;
        }
        int length = this.f2673q.length;
        i1.t0[] t0VarArr = this.f2669m;
        if (length == 0) {
            this.f2673q = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.f2672p, t0VarArr.length);
        }
        ArrayList arrayList = this.f2670n;
        arrayList.remove(aVar);
        t0VarArr[num.intValue()] = t0Var;
        if (arrayList.isEmpty()) {
            l(t0VarArr[0]);
        }
    }
}
