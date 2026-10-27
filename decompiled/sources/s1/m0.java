package s1;

import android.content.Context;
import android.os.Build;
import android.util.Pair;
import android.view.accessibility.CaptioningManager;
import c2.n1;
import i1.u0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import o9.d0;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f11377a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11378b;

    /* renamed from: c, reason: collision with root package name */
    public final c2.e1[] f11379c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11380d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11381e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11382f;
    public n0 g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11383h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean[] f11384i;

    /* renamed from: j, reason: collision with root package name */
    public final d[] f11385j;

    /* renamed from: k, reason: collision with root package name */
    public final f2.w f11386k;

    /* renamed from: l, reason: collision with root package name */
    public final d9.p f11387l;

    /* renamed from: m, reason: collision with root package name */
    public m0 f11388m;

    /* renamed from: n, reason: collision with root package name */
    public n1 f11389n;

    /* renamed from: o, reason: collision with root package name */
    public f2.x f11390o;

    /* renamed from: p, reason: collision with root package name */
    public long f11391p;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [c2.d] */
    public m0(d[] dVarArr, long j10, f2.w wVar, g2.e eVar, d9.p pVar, n0 n0Var, f2.x xVar) {
        this.f11385j = dVarArr;
        this.f11391p = j10;
        this.f11386k = wVar;
        this.f11387l = pVar;
        c2.d0 d0Var = n0Var.f11413a;
        this.f11378b = d0Var.f2539a;
        this.g = n0Var;
        this.f11389n = n1.f2659d;
        this.f11390o = xVar;
        this.f11379c = new c2.e1[dVarArr.length];
        this.f11384i = new boolean[dVarArr.length];
        long j11 = n0Var.f11414b;
        long j12 = n0Var.f11416d;
        boolean z10 = n0Var.f11418f;
        pVar.getClass();
        Object obj = d0Var.f2539a;
        int i10 = c1.f11239k;
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        c2.d0 a10 = d0Var.a(pair.second);
        x0 x0Var = (x0) ((HashMap) pVar.f4316e).get(obj2);
        x0Var.getClass();
        ((HashSet) pVar.f4318h).add(x0Var);
        w0 w0Var = (w0) ((HashMap) pVar.g).get(x0Var);
        if (w0Var != null) {
            w0Var.f11479a.d(w0Var.f11480b);
        }
        x0Var.f11485c.add(a10);
        c2.v a11 = x0Var.f11483a.a(a10, eVar, j11);
        ((IdentityHashMap) pVar.f4315d).put(a11, x0Var);
        pVar.d();
        this.f11377a = j12 != -9223372036854775807L ? new c2.d(a11, !z10, 0L, j12) : a11;
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [c2.b0, java.lang.Object] */
    public final long a(f2.x xVar, long j10, boolean z10, boolean[] zArr) {
        d[] dVarArr;
        c2.e1[] e1VarArr;
        int i10 = 0;
        while (true) {
            boolean z11 = true;
            if (i10 >= xVar.f4957a) {
                break;
            }
            if (z10 || !xVar.a(this.f11390o, i10)) {
                z11 = false;
            }
            this.f11384i[i10] = z11;
            i10++;
        }
        int i11 = 0;
        while (true) {
            dVarArr = this.f11385j;
            int length = dVarArr.length;
            e1VarArr = this.f11379c;
            if (i11 >= length) {
                break;
            }
            if (dVarArr[i11].f11249p == -2) {
                e1VarArr[i11] = null;
            }
            i11++;
        }
        b();
        this.f11390o = xVar;
        c();
        long k10 = this.f11377a.k(xVar.f4959c, this.f11384i, this.f11379c, zArr, j10);
        for (int i12 = 0; i12 < dVarArr.length; i12++) {
            if (dVarArr[i12].f11249p == -2 && this.f11390o.b(i12)) {
                e1VarArr[i12] = new n7.i(8);
            }
        }
        this.f11382f = false;
        for (int i13 = 0; i13 < e1VarArr.length; i13++) {
            if (e1VarArr[i13] != null) {
                l1.d.g(xVar.b(i13));
                if (dVarArr[i13].f11249p != -2) {
                    this.f11382f = true;
                }
            } else {
                l1.d.g(xVar.f4959c[i13] == null);
            }
        }
        return k10;
    }

    public final void b() {
        if (this.f11388m != null) {
            return;
        }
        int i10 = 0;
        while (true) {
            f2.x xVar = this.f11390o;
            if (i10 >= xVar.f4957a) {
                return;
            }
            boolean b2 = xVar.b(i10);
            f2.t tVar = this.f11390o.f4959c[i10];
            if (b2 && tVar != null) {
                tVar.h();
            }
            i10++;
        }
    }

    public final void c() {
        if (this.f11388m != null) {
            return;
        }
        int i10 = 0;
        while (true) {
            f2.x xVar = this.f11390o;
            if (i10 >= xVar.f4957a) {
                return;
            }
            boolean b2 = xVar.b(i10);
            f2.t tVar = this.f11390o.f4959c[i10];
            if (b2 && tVar != null) {
                tVar.e();
            }
            i10++;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [c2.g1, java.lang.Object] */
    public final long d() {
        if (!this.f11381e) {
            return this.g.f11414b;
        }
        long m10 = this.f11382f ? this.f11377a.m() : Long.MIN_VALUE;
        return m10 == Long.MIN_VALUE ? this.g.f11417e : m10;
    }

    public final long e() {
        return this.g.f11414b + this.f11391p;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c2.b0, java.lang.Object] */
    public final void f(float f10, i1.t0 t0Var, boolean z10) {
        this.f11381e = true;
        this.f11389n = this.f11377a.j();
        f2.x j10 = j(f10, t0Var, z10);
        n0 n0Var = this.g;
        long j11 = n0Var.f11414b;
        long j12 = n0Var.f11417e;
        if (j12 != -9223372036854775807L && j11 >= j12) {
            j11 = Math.max(0L, j12 - 1);
        }
        long a10 = a(j10, j11, false, new boolean[this.f11385j.length]);
        long j13 = this.f11391p;
        n0 n0Var2 = this.g;
        this.f11391p = (n0Var2.f11414b - a10) + j13;
        this.g = n0Var2.b(a10);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [c2.g1, java.lang.Object] */
    public final boolean g() {
        if (this.f11381e) {
            return !this.f11382f || this.f11377a.m() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean h() {
        if (this.f11381e) {
            return g() || d() - this.g.f11414b >= -9223372036854775807L;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [c2.b0, java.lang.Object] */
    public final void i() {
        b();
        ?? r02 = this.f11377a;
        try {
            boolean z10 = r02 instanceof c2.d;
            d9.p pVar = this.f11387l;
            if (z10) {
                pVar.h(((c2.d) r02).f2532o);
            } else {
                pVar.h(r02);
            }
        } catch (RuntimeException e7) {
            l1.b.h("MediaPeriodHolder", "Period release failed.", e7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f2.x j(float f10, i1.t0 t0Var, boolean z10) {
        final f2.k kVar;
        final boolean z11;
        String str;
        int i10;
        Pair j10;
        String str2;
        Pair j11;
        CaptioningManager captioningManager;
        Locale locale;
        boolean z12;
        boolean z13;
        o9.w0 w0Var;
        f2.t bVar;
        int i11;
        int[] iArr;
        Object obj;
        int i12;
        int[] iArr2;
        f2.s sVar;
        i1.u0 u0Var;
        int[] iArr3;
        Context context;
        int[] iArr4;
        f2.w wVar = this.f11386k;
        d[] dVarArr = this.f11385j;
        n1 n1Var = this.f11389n;
        wVar.getClass();
        int i13 = 1;
        int[] iArr5 = new int[dVarArr.length + 1];
        int length = dVarArr.length + 1;
        i1.u0[][] u0VarArr = new i1.u0[length][];
        int[][][] iArr6 = new int[dVarArr.length + 1][][];
        for (int i14 = 0; i14 < length; i14++) {
            int i15 = n1Var.f2660a;
            u0VarArr[i14] = new i1.u0[i15];
            iArr6[i14] = new int[i15][];
        }
        int length2 = dVarArr.length;
        final int[] iArr7 = new int[length2];
        for (int i16 = 0; i16 < length2; i16++) {
            iArr7[i16] = dVarArr[i16].A();
        }
        int i17 = 0;
        while (i17 < n1Var.f2660a) {
            i1.u0 a10 = n1Var.a(i17);
            int i18 = a10.f6041c == 5 ? i13 : 0;
            int length3 = dVarArr.length;
            int i19 = i13;
            int i20 = 0;
            int i21 = 0;
            while (i20 < dVarArr.length) {
                d dVar = dVarArr[i20];
                f2.w wVar2 = wVar;
                n1 n1Var2 = n1Var;
                int i22 = i13;
                int i23 = 0;
                for (int i24 = 0; i24 < a10.f6039a; i24++) {
                    i23 = Math.max(i23, dVar.z(a10.f6042d[i24]) & 7);
                }
                int i25 = iArr5[i20] == 0 ? i22 : 0;
                if (i23 > i21 || (i23 == i21 && i18 != 0 && i19 == 0 && i25 != 0)) {
                    i21 = i23;
                    i19 = i25;
                    length3 = i20;
                }
                i20++;
                i13 = i22;
                wVar = wVar2;
                n1Var = n1Var2;
            }
            f2.w wVar3 = wVar;
            n1 n1Var3 = n1Var;
            int i26 = i13;
            if (length3 == dVarArr.length) {
                iArr4 = new int[a10.f6039a];
            } else {
                d dVar2 = dVarArr[length3];
                int[] iArr8 = new int[a10.f6039a];
                for (int i27 = 0; i27 < a10.f6039a; i27++) {
                    iArr8[i27] = dVar2.z(a10.f6042d[i27]);
                }
                iArr4 = iArr8;
            }
            int i28 = iArr5[length3];
            u0VarArr[length3][i28] = a10;
            iArr6[length3][i28] = iArr4;
            iArr5[length3] = i28 + 1;
            i17++;
            i13 = i26;
            wVar = wVar3;
            n1Var = n1Var3;
        }
        f2.w wVar4 = wVar;
        int i29 = i13;
        int i30 = 0;
        n1[] n1VarArr = new n1[dVarArr.length];
        String[] strArr = new String[dVarArr.length];
        int[] iArr9 = new int[dVarArr.length];
        for (int i31 = 0; i31 < dVarArr.length; i31++) {
            int i32 = iArr5[i31];
            n1VarArr[i31] = new n1((i1.u0[]) l1.a0.Q(i32, u0VarArr[i31]));
            iArr6[i31] = (int[][]) l1.a0.Q(i32, iArr6[i31]);
            strArr[i31] = dVarArr[i31].j();
            iArr9[i31] = dVarArr[i31].f11249p;
        }
        f2.v vVar = new f2.v(iArr9, n1VarArr, iArr7, iArr6, new n1((i1.u0[]) l1.a0.Q(iArr5[dVarArr.length], u0VarArr[dVarArr.length])));
        final f2.r rVar = (f2.r) wVar4;
        synchronized (rVar.f4939d) {
            rVar.f4942h = Thread.currentThread();
            kVar = rVar.g;
        }
        if (rVar.f4945k == null && (context = rVar.f4940e) != null) {
            rVar.f4945k = Boolean.valueOf(l1.a0.N(context));
        }
        if (kVar.f4912s0 && Build.VERSION.SDK_INT >= 32 && rVar.f4943i == null) {
            rVar.f4943i = new c4.e(rVar.f4940e, rVar, rVar.f4945k);
        }
        int i33 = vVar.f4948a;
        Context context2 = rVar.f4940e;
        f2.s[] sVarArr = new f2.s[i33];
        int i34 = 0;
        while (true) {
            if (i34 >= vVar.f4948a) {
                z11 = 0;
                break;
            }
            if (2 == iArr9[i34] && n1VarArr[i34].f2660a > 0) {
                z11 = i29;
                break;
            }
            i34++;
        }
        Pair j12 = f2.r.j(i29, vVar, iArr6, new f2.o() { // from class: f2.e
            @Override // f2.o
            public final w0 b(int i35, u0 u0Var2, int[] iArr10) {
                r rVar2 = r.this;
                rVar2.getClass();
                k kVar2 = kVar;
                f fVar = new f(rVar2, kVar2);
                int i36 = iArr7[i35];
                d0 m10 = g0.m();
                for (int i37 = 0; i37 < u0Var2.f6039a; i37++) {
                    m10.a(new g(i35, u0Var2, i37, kVar2, iArr10[i37], z11, fVar, i36));
                }
                return m10.f();
            }
        }, new f2.c(4));
        if (j12 != null) {
            sVarArr[((Integer) j12.second).intValue()] = (f2.s) j12.first;
        }
        if (j12 == null) {
            str = null;
        } else {
            f2.s sVar2 = (f2.s) j12.first;
            str = sVar2.f4946a.f6042d[sVar2.f4947b[0]].f5982d;
        }
        i1.x0 x0Var = kVar.f6130u;
        Object obj2 = null;
        int i35 = 3;
        if (x0Var.f6069a == 2) {
            i10 = 2;
            j10 = null;
        } else {
            i10 = 2;
            j10 = f2.r.j(2, vVar, iArr6, new androidx.fragment.app.e(kVar, str, iArr7, (!kVar.f6120k || context2 == null) ? null : l1.a0.v(context2)), new f2.c(i35));
        }
        Pair j13 = ((kVar.A || j10 == null) && x0Var.f6069a != i10) ? f2.r.j(4, vVar, iArr6, new androidx.fragment.app.v0(6, kVar), new f2.c(i10)) : null;
        if (j13 != null) {
            sVarArr[((Integer) j13.second).intValue()] = (f2.s) j13.first;
        } else if (j10 != null) {
            sVarArr[((Integer) j10.second).intValue()] = (f2.s) j10.first;
        }
        if (x0Var.f6069a == 2) {
            j11 = null;
        } else {
            if (!kVar.f6133x || context2 == null || (captioningManager = (CaptioningManager) context2.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
                str2 = null;
            } else {
                int i36 = l1.a0.f8067a;
                str2 = locale.toLanguageTag();
            }
            j11 = f2.r.j(3, vVar, iArr6, new a7.f(kVar, str, str2, 4), new f2.c(5));
        }
        if (j11 != null) {
            sVarArr[((Integer) j11.second).intValue()] = (f2.s) j11.first;
        }
        int i37 = 0;
        while (i37 < i33) {
            int i38 = iArr9[i37];
            if (i38 == 2 || i38 == 1 || i38 == 3 || i38 == 4) {
                i12 = i37;
                iArr2 = iArr9;
            } else {
                n1 n1Var4 = n1VarArr[i37];
                int[][] iArr10 = iArr6[i37];
                if (x0Var.f6069a == 2) {
                    i12 = i37;
                    iArr2 = iArr9;
                } else {
                    int i39 = i30;
                    int i40 = i39;
                    i12 = i37;
                    i1.u0 u0Var2 = null;
                    f2.i iVar = null;
                    while (i39 < n1Var4.f2660a) {
                        i1.u0 a11 = n1Var4.a(i39);
                        int[] iArr11 = iArr10[i39];
                        n1 n1Var5 = n1Var4;
                        int[][] iArr12 = iArr10;
                        f2.i iVar2 = iVar;
                        int i41 = i40;
                        i1.u0 u0Var3 = u0Var2;
                        int i42 = i30;
                        while (i42 < a11.f6039a) {
                            int i43 = i42;
                            if (r.a.b(iArr11[i42], kVar.f4913t0)) {
                                u0Var = a11;
                                f2.i iVar3 = new f2.i(a11.f6042d[i43], iArr11[i43]);
                                if (iVar2 != null) {
                                    iArr3 = iArr9;
                                    if (o9.y.f9691a.c(iVar3.f4906p, iVar2.f4906p).c(iVar3.f4905o, iVar2.f4905o).e() <= 0) {
                                    }
                                } else {
                                    iArr3 = iArr9;
                                }
                                iVar2 = iVar3;
                                i41 = i43;
                                u0Var3 = u0Var;
                            } else {
                                u0Var = a11;
                                iArr3 = iArr9;
                            }
                            i42 = i43 + 1;
                            a11 = u0Var;
                            iArr9 = iArr3;
                        }
                        i39++;
                        u0Var2 = u0Var3;
                        i40 = i41;
                        iArr10 = iArr12;
                        iVar = iVar2;
                        n1Var4 = n1Var5;
                    }
                    iArr2 = iArr9;
                    if (u0Var2 != null) {
                        sVar = new f2.s(i30, u0Var2, new int[]{i40});
                        sVarArr[i12] = sVar;
                    }
                }
                sVar = null;
                sVarArr[i12] = sVar;
            }
            i37 = i12 + 1;
            iArr9 = iArr2;
            i30 = 0;
        }
        int i44 = vVar.f4948a;
        n1[] n1VarArr2 = vVar.f4950c;
        HashMap hashMap = new HashMap();
        for (int i45 = 0; i45 < i44; i45++) {
            f2.r.c(n1VarArr2[i45], kVar, hashMap);
        }
        f2.r.c(vVar.f4953f, kVar, hashMap);
        for (int i46 = 0; i46 < i44; i46++) {
            i1.v0 v0Var = (i1.v0) hashMap.get(Integer.valueOf(vVar.f4949b[i46]));
            if (v0Var != null) {
                i1.u0 u0Var4 = v0Var.f6051a;
                o9.g0 g0Var = v0Var.f6052b;
                sVarArr[i46] = (g0Var.isEmpty() || n1VarArr2[i46].b(u0Var4) == -1) ? null : new f2.s(0, u0Var4, com.google.android.gms.internal.cast.n.u(g0Var));
            }
        }
        int i47 = vVar.f4948a;
        for (int i48 = 0; i48 < i47; i48++) {
            n1 n1Var6 = vVar.f4950c[i48];
            Map map = (Map) kVar.f4915v0.get(i48);
            if (map != null && map.containsKey(n1Var6)) {
                Map map2 = (Map) kVar.f4915v0.get(i48);
                if (map2 != null && map2.get(n1Var6) != null) {
                    throw new ClassCastException();
                }
                sVarArr[i48] = null;
            }
        }
        for (int i49 = 0; i49 < i33; i49++) {
            int i50 = vVar.f4949b[i49];
            if (kVar.f4916w0.get(i49) || kVar.E.contains(Integer.valueOf(i50))) {
                sVarArr[i49] = null;
            }
        }
        d9.f fVar = rVar.f4941f;
        g2.d dVar3 = rVar.f4955b;
        l1.d.h(dVar3);
        fVar.getClass();
        ArrayList arrayList = new ArrayList();
        int i51 = 0;
        while (i51 < sVarArr.length) {
            f2.s sVar3 = sVarArr[i51];
            if (sVar3 == null || sVar3.f4947b.length <= 1) {
                obj = obj2;
                arrayList.add(obj);
            } else {
                o9.d0 m10 = o9.g0.m();
                m10.a(new f2.a(0L, 0L));
                arrayList.add(m10);
                obj = obj2;
            }
            i51++;
            obj2 = obj;
        }
        int length4 = sVarArr.length;
        long[][] jArr = new long[length4][];
        for (int i52 = 0; i52 < sVarArr.length; i52++) {
            f2.s sVar4 = sVarArr[i52];
            if (sVar4 == null) {
                jArr[i52] = new long[0];
            } else {
                int[] iArr13 = sVar4.f4947b;
                jArr[i52] = new long[iArr13.length];
                int i53 = 0;
                while (i53 < iArr13.length) {
                    int i54 = i53;
                    long j14 = sVar4.f4946a.f6042d[iArr13[i53]].f5987j;
                    long[] jArr2 = jArr[i52];
                    if (j14 == -1) {
                        j14 = 0;
                    }
                    jArr2[i54] = j14;
                    i53 = i54 + 1;
                }
                Arrays.sort(jArr[i52]);
            }
        }
        int[] iArr14 = new int[length4];
        long[] jArr3 = new long[length4];
        for (int i55 = 0; i55 < length4; i55++) {
            long[] jArr4 = jArr[i55];
            jArr3[i55] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        f2.b.u(arrayList, jArr3);
        o9.q.b(2, "expectedValuesPerKey");
        TreeMap treeMap = new TreeMap(o9.u0.f9682p);
        o9.r0 r0Var = new o9.r0();
        o9.s0 s0Var = new o9.s0(treeMap);
        s0Var.f9668t = r0Var;
        int i56 = 0;
        while (i56 < length4) {
            long[] jArr5 = jArr[i56];
            g2.d dVar4 = dVar3;
            if (jArr5.length <= 1) {
                i11 = length4;
                iArr = iArr14;
            } else {
                int length5 = jArr5.length;
                double[] dArr = new double[length5];
                int i57 = 0;
                while (true) {
                    long[] jArr6 = jArr[i56];
                    i11 = length4;
                    double d6 = 0.0d;
                    if (i57 >= jArr6.length) {
                        break;
                    }
                    int[] iArr15 = iArr14;
                    long j15 = jArr6[i57];
                    if (j15 != -1) {
                        d6 = Math.log(j15);
                    }
                    dArr[i57] = d6;
                    i57++;
                    length4 = i11;
                    iArr14 = iArr15;
                }
                iArr = iArr14;
                int i58 = length5 - 1;
                double d10 = dArr[i58] - dArr[0];
                int i59 = 0;
                while (i59 < i58) {
                    double d11 = dArr[i59];
                    i59++;
                    int i60 = i58;
                    Double valueOf = Double.valueOf(d10 == 0.0d ? 1.0d : (((d11 + dArr[i59]) * 0.5d) - dArr[0]) / d10);
                    double d12 = d10;
                    Integer valueOf2 = Integer.valueOf(i56);
                    Map map3 = s0Var.f9666r;
                    long[][] jArr7 = jArr;
                    Collection collection = (Collection) map3.get(valueOf);
                    if (collection == null) {
                        Collection c10 = s0Var.c();
                        if (!c10.add(valueOf2)) {
                            throw new AssertionError("New Collection violated the Collection spec");
                        }
                        s0Var.f9667s++;
                        map3.put(valueOf, c10);
                    } else if (collection.add(valueOf2)) {
                        s0Var.f9667s++;
                    }
                    i58 = i60;
                    d10 = d12;
                    jArr = jArr7;
                }
            }
            i56++;
            dVar3 = dVar4;
            length4 = i11;
            iArr14 = iArr;
            jArr = jArr;
        }
        g2.d dVar5 = dVar3;
        int[] iArr16 = iArr14;
        long[][] jArr8 = jArr;
        o9.n nVar = s0Var.f9649p;
        if (nVar == null) {
            nVar = new o9.n(0, s0Var);
            s0Var.f9649p = nVar;
        }
        o9.g0 n10 = o9.g0.n(nVar);
        for (int i61 = 0; i61 < n10.size(); i61++) {
            int intValue = ((Integer) n10.get(i61)).intValue();
            int i62 = iArr16[intValue] + 1;
            iArr16[intValue] = i62;
            jArr3[intValue] = jArr8[intValue][i62];
            f2.b.u(arrayList, jArr3);
        }
        for (int i63 = 0; i63 < sVarArr.length; i63++) {
            if (arrayList.get(i63) != null) {
                jArr3[i63] = jArr3[i63] * 2;
            }
        }
        f2.b.u(arrayList, jArr3);
        o9.d0 m11 = o9.g0.m();
        for (int i64 = 0; i64 < arrayList.size(); i64++) {
            o9.d0 d0Var = (o9.d0) arrayList.get(i64);
            m11.a(d0Var == null ? o9.w0.f9686s : d0Var.f());
        }
        o9.w0 f11 = m11.f();
        f2.t[] tVarArr = new f2.t[sVarArr.length];
        for (int i65 = 0; i65 < sVarArr.length; i65++) {
            f2.s sVar5 = sVarArr[i65];
            if (sVar5 != null) {
                int[] iArr17 = sVar5.f4947b;
                if (iArr17.length != 0) {
                    if (iArr17.length == 1) {
                        bVar = new f2.u(sVar5.f4946a, new int[]{iArr17[0]});
                    } else {
                        long j16 = 25000;
                        bVar = new f2.b(sVar5.f4946a, iArr17, dVar5, 10000, j16, j16, (o9.g0) f11.get(i65));
                    }
                    tVarArr[i65] = bVar;
                }
            }
        }
        d1[] d1VarArr = new d1[i33];
        for (int i66 = 0; i66 < i33; i66++) {
            d1VarArr[i66] = (kVar.f4916w0.get(i66) || kVar.E.contains(Integer.valueOf(vVar.f4949b[i66])) || (vVar.f4949b[i66] != -2 && tVarArr[i66] == null)) ? null : d1.f11261c;
        }
        if (kVar.f6130u.f6069a != 0) {
            int i67 = 0;
            int i68 = -1;
            int i69 = 0;
            while (true) {
                if (i69 < vVar.f4948a) {
                    int i70 = vVar.f4949b[i69];
                    f2.t tVar = tVarArr[i69];
                    if (i70 != 1 && tVar != null) {
                        break;
                    }
                    if (i70 == 1 && tVar != null && tVar.length() == 1) {
                        if (f2.r.i(kVar, iArr6[i69][vVar.f4950c[i69].b(tVar.k())][tVar.f(0)], tVar.l())) {
                            i67++;
                            i68 = i69;
                        }
                    }
                    i69++;
                } else if (i67 == 1) {
                    int i71 = kVar.f6130u.f6070b ? 1 : 2;
                    d1 d1Var = d1VarArr[i68];
                    d1VarArr[i68] = new d1(i71, d1Var != null && d1Var.f11263b);
                }
            }
        }
        Pair create = Pair.create(d1VarArr, tVarArr);
        f2.t[] tVarArr2 = (f2.t[]) create.second;
        List[] listArr = new List[tVarArr2.length];
        for (int i72 = 0; i72 < tVarArr2.length; i72++) {
            f2.t tVar2 = tVarArr2[i72];
            if (tVar2 != null) {
                w0Var = o9.g0.r(tVar2);
            } else {
                o9.e0 e0Var = o9.g0.f9617p;
                w0Var = o9.w0.f9686s;
            }
            listArr[i72] = w0Var;
        }
        o9.d0 d0Var2 = new o9.d0(4);
        int i73 = 0;
        while (true) {
            int i74 = vVar.f4948a;
            n1[] n1VarArr3 = vVar.f4950c;
            if (i73 >= i74) {
                break;
            }
            n1 n1Var7 = n1VarArr3[i73];
            List list = listArr[i73];
            int i75 = 0;
            while (i75 < n1Var7.f2660a) {
                i1.u0 a12 = n1Var7.a(i75);
                int i76 = n1VarArr3[i73].a(i75).f6039a;
                int[] iArr18 = new int[i76];
                int i77 = 0;
                int i78 = 0;
                while (i77 < i76) {
                    List[] listArr2 = listArr;
                    if ((vVar.f4952e[i73][i75][i77] & 7) == 4) {
                        iArr18[i78] = i77;
                        i78++;
                    }
                    i77++;
                    listArr = listArr2;
                }
                List[] listArr3 = listArr;
                int[] copyOf = Arrays.copyOf(iArr18, i78);
                n1 n1Var8 = n1Var7;
                int i79 = 16;
                String str3 = null;
                int i80 = 0;
                boolean z14 = false;
                int i81 = 0;
                while (i80 < copyOf.length) {
                    String str4 = n1VarArr3[i73].a(i75).f6042d[copyOf[i80]].f5991n;
                    int i82 = i81 + 1;
                    if (i81 == 0) {
                        str3 = str4;
                    } else {
                        z14 = (!Objects.equals(str3, str4)) | z14;
                    }
                    i79 = Math.min(i79, vVar.f4952e[i73][i75][i80] & 24);
                    i80++;
                    i81 = i82;
                }
                if (z14) {
                    i79 = Math.min(i79, vVar.f4951d[i73]);
                }
                boolean z15 = i79 != 0;
                int i83 = a12.f6039a;
                int[] iArr19 = new int[i83];
                boolean[] zArr = new boolean[i83];
                for (int i84 = 0; i84 < a12.f6039a; i84++) {
                    iArr19[i84] = vVar.f4952e[i73][i75][i84] & 7;
                    int i85 = 0;
                    while (true) {
                        if (i85 >= list.size()) {
                            z13 = false;
                            break;
                        }
                        f2.t tVar3 = (f2.t) list.get(i85);
                        if (tVar3.k().equals(a12) && tVar3.t(i84) != -1) {
                            z13 = true;
                            break;
                        }
                        i85++;
                    }
                    zArr[i84] = z13;
                }
                d0Var2.a(new i1.a1(a12, z15, iArr19, zArr));
                i75++;
                listArr = listArr3;
                n1Var7 = n1Var8;
            }
            i73++;
        }
        n1 n1Var9 = vVar.f4953f;
        for (int i86 = 0; i86 < n1Var9.f2660a; i86++) {
            i1.u0 a13 = n1Var9.a(i86);
            int[] iArr20 = new int[a13.f6039a];
            Arrays.fill(iArr20, 0);
            d0Var2.a(new i1.a1(a13, false, iArr20, new boolean[a13.f6039a]));
        }
        f2.x xVar = new f2.x((d1[]) create.first, (f2.t[]) create.second, new i1.b1(d0Var2.f()), vVar);
        for (int i87 = 0; i87 < xVar.f4957a; i87++) {
            if (xVar.b(i87)) {
                if (xVar.f4959c[i87] == null && this.f11385j[i87].f11249p != -2) {
                    z12 = false;
                    l1.d.g(z12);
                }
                z12 = true;
                l1.d.g(z12);
            } else {
                l1.d.g(xVar.f4959c[i87] == null);
            }
        }
        for (f2.t tVar4 : xVar.f4959c) {
            if (tVar4 != null) {
                tVar4.p(f10);
                tVar4.a(z10);
            }
        }
        return xVar;
    }

    public final void k() {
        Object obj = this.f11377a;
        if (obj instanceof c2.d) {
            long j10 = this.g.f11416d;
            if (j10 == -9223372036854775807L) {
                j10 = Long.MIN_VALUE;
            }
            c2.d dVar = (c2.d) obj;
            dVar.f2536s = 0L;
            dVar.f2537t = j10;
        }
    }
}
