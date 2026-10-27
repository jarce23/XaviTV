package w1;

import android.net.Uri;
import android.util.SparseArray;
import c2.a0;
import c2.b0;
import c2.j0;
import c2.n1;
import i1.f0;
import i1.h0;
import i1.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import o1.e0;
import o9.g0;
import o9.w0;
import s1.f1;
import s1.k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements b0, x1.t {
    public final boolean A;
    public final int B;
    public final t1.u C;
    public final p4.p D = new p4.p(24, this);
    public a0 E;
    public int F;
    public n1 G;
    public r[] H;
    public r[] I;
    public int J;
    public c2.n K;

    /* renamed from: o, reason: collision with root package name */
    public final c f12808o;

    /* renamed from: p, reason: collision with root package name */
    public final x1.c f12809p;

    /* renamed from: q, reason: collision with root package name */
    public final p4.p f12810q;

    /* renamed from: r, reason: collision with root package name */
    public final e0 f12811r;

    /* renamed from: s, reason: collision with root package name */
    public final v1.f f12812s;

    /* renamed from: t, reason: collision with root package name */
    public final j0 f12813t;

    /* renamed from: u, reason: collision with root package name */
    public final n7.i f12814u;

    /* renamed from: v, reason: collision with root package name */
    public final j0 f12815v;

    /* renamed from: w, reason: collision with root package name */
    public final g2.e f12816w;

    /* renamed from: x, reason: collision with root package name */
    public final IdentityHashMap f12817x;

    /* renamed from: y, reason: collision with root package name */
    public final p4.p f12818y;

    /* renamed from: z, reason: collision with root package name */
    public final d9.f f12819z;

    public k(c cVar, x1.c cVar2, p4.p pVar, e0 e0Var, v1.f fVar, j0 j0Var, n7.i iVar, j0 j0Var2, g2.e eVar, d9.f fVar2, boolean z10, int i10, t1.u uVar) {
        this.f12808o = cVar;
        this.f12809p = cVar2;
        this.f12810q = pVar;
        this.f12811r = e0Var;
        this.f12812s = fVar;
        this.f12813t = j0Var;
        this.f12814u = iVar;
        this.f12815v = j0Var2;
        this.f12816w = eVar;
        this.f12819z = fVar2;
        this.A = z10;
        this.B = i10;
        this.C = uVar;
        fVar2.getClass();
        o9.e0 e0Var2 = g0.f9617p;
        w0 w0Var = w0.f9686s;
        this.K = new c2.n(w0Var, w0Var);
        this.f12817x = new IdentityHashMap();
        this.f12818y = new p4.p(25);
        this.H = new r[0];
        this.I = new r[0];
    }

    public static i1.p f(i1.p pVar, i1.p pVar2, boolean z10) {
        f0 f0Var;
        int i10;
        String str;
        String str2;
        g0 g0Var;
        int i11;
        int i12;
        String str3;
        o9.e0 e0Var = g0.f9617p;
        w0 w0Var = w0.f9686s;
        if (pVar2 != null) {
            str2 = pVar2.f5988k;
            f0Var = pVar2.f5989l;
            i11 = pVar2.F;
            i10 = pVar2.f5983e;
            i12 = pVar2.f5984f;
            str = pVar2.f5982d;
            str3 = pVar2.f5980b;
            g0Var = pVar2.f5981c;
        } else {
            String u10 = l1.a0.u(1, pVar.f5988k);
            f0Var = pVar.f5989l;
            if (z10) {
                i11 = pVar.F;
                i10 = pVar.f5983e;
                i12 = pVar.f5984f;
                str = pVar.f5982d;
                str3 = pVar.f5980b;
                str2 = u10;
                g0Var = pVar.f5981c;
            } else {
                i10 = 0;
                str = null;
                str2 = u10;
                g0Var = w0Var;
                i11 = -1;
                i12 = 0;
                str3 = null;
            }
        }
        String d6 = i1.g0.d(str2);
        int i13 = z10 ? pVar.f5985h : -1;
        int i14 = z10 ? pVar.f5986i : -1;
        i1.o oVar = new i1.o();
        oVar.f5929a = pVar.f5979a;
        oVar.f5930b = str3;
        oVar.f5931c = g0.n(g0Var);
        oVar.f5939l = i1.g0.m(pVar.f5990m);
        oVar.f5940m = i1.g0.m(d6);
        oVar.f5937j = str2;
        oVar.f5938k = f0Var;
        oVar.f5935h = i13;
        oVar.f5936i = i14;
        oVar.E = i11;
        oVar.f5933e = i10;
        oVar.f5934f = i12;
        oVar.f5932d = str;
        return new i1.p(oVar);
    }

    @Override // c2.g1
    public final boolean a() {
        return this.K.a();
    }

    @Override // x1.t
    public final void b() {
        for (r rVar : this.H) {
            g2.n nVar = rVar.f12866x;
            i iVar = rVar.f12860r;
            ArrayList arrayList = rVar.B;
            if (!arrayList.isEmpty()) {
                j jVar = (j) o9.q.g(arrayList);
                int b2 = iVar.b(jVar);
                int i10 = jVar.f12796o;
                if (b2 == 1) {
                    if (!jVar.f()) {
                        l1.d.g(i10 != -1);
                        x1.l a10 = iVar.g.a(iVar.f12778e[iVar.f12780h.a(jVar.f3999d)], false);
                        a10.getClass();
                        g0 g0Var = a10.f13425r;
                        int i11 = (int) (jVar.f4004j - a10.f13418k);
                        jVar.K = i11 < 0 ? 0L : ((x1.g) (i11 < g0Var.size() ? ((x1.i) g0Var.get(i11)).A : a10.f13426s).get(i10)).f13398q;
                    }
                } else if (b2 == 0) {
                    rVar.F.post(new androidx.fragment.app.d(rVar, 28, jVar));
                } else if (b2 == 2 && !rVar.h0 && nVar.b()) {
                    nVar.a();
                }
            }
        }
        this.E.b(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        if ((((x1.b) r9.g.f13346r.get(r18)) == null ? !x1.b.a(r4, r13) : false) == false) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0056 A[SYNTHETIC] */
    @Override // x1.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.net.Uri r18, app.shamel.tv.b r19, boolean r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            w1.r[] r2 = r0.H
            int r3 = r2.length
            r6 = 0
            r7 = 1
        L9:
            if (r6 >= r3) goto L90
            r8 = r2[r6]
            w1.i r9 = r8.f12860r
            android.net.Uri[] r10 = r9.f12778e
            boolean r11 = l1.a0.l(r10, r1)
            if (r11 != 0) goto L1e
            r8 = r19
            r4 = 1
            r16 = 1
            goto L8b
        L1e:
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r20 != 0) goto L40
            n7.i r8 = r8.f12865w
            f2.t r13 = r9.f12790r
            b4.j0 r13 = j1.c.i(r13)
            r8.getClass()
            r8 = r19
            g2.h r13 = n7.i.B(r13, r8)
            if (r13 == 0) goto L42
            int r14 = r13.f5115a
            r15 = 2
            if (r14 != r15) goto L42
            long r13 = r13.f5116b
            goto L43
        L40:
            r8 = r19
        L42:
            r13 = r11
        L43:
            r15 = 0
            r16 = 1
        L46:
            int r4 = r10.length
            r5 = -1
            if (r15 >= r4) goto L56
            r4 = r10[r15]
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L53
            goto L57
        L53:
            int r15 = r15 + 1
            goto L46
        L56:
            r15 = r5
        L57:
            if (r15 != r5) goto L5a
            goto L87
        L5a:
            f2.t r4 = r9.f12790r
            int r4 = r4.t(r15)
            if (r4 != r5) goto L63
            goto L87
        L63:
            r9.f12787o = r1
            int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r5 == 0) goto L8a
            f2.t r5 = r9.f12790r
            boolean r4 = r5.o(r4, r13)
            if (r4 == 0) goto L8a
            x1.c r4 = r9.g
            java.util.HashMap r4 = r4.f13346r
            java.lang.Object r4 = r4.get(r1)
            x1.b r4 = (x1.b) r4
            if (r4 == 0) goto L84
            boolean r4 = x1.b.a(r4, r13)
            r4 = r4 ^ 1
            goto L85
        L84:
            r4 = 0
        L85:
            if (r4 == 0) goto L8a
        L87:
            r4 = r16
            goto L8b
        L8a:
            r4 = 0
        L8b:
            r7 = r7 & r4
            int r6 = r6 + 1
            goto L9
        L90:
            c2.a0 r1 = r0.E
            r1.b(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.k.c(android.net.Uri, app.shamel.tv.b, boolean):boolean");
    }

    public final r d(String str, int i10, Uri[] uriArr, i1.p[] pVarArr, i1.p pVar, List list, Map map, long j10) {
        return new r(str, i10, this.D, new i(this.f12808o, this.f12809p, uriArr, pVarArr, this.f12810q, this.f12811r, this.f12818y, list, this.C), map, this.f12816w, j10, pVar, this.f12812s, this.f12813t, this.f12814u, this.f12815v, this.B);
    }

    @Override // c2.g1
    public final long e() {
        return this.K.e();
    }

    @Override // c2.b0
    public final long g() {
        return -9223372036854775807L;
    }

    @Override // c2.b0
    public final long h(long j10, f1 f1Var) {
        r[] rVarArr = this.I;
        int length = rVarArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            r rVar = rVarArr[i10];
            if (rVar.O == 2) {
                i iVar = rVar.f12860r;
                x1.c cVar = iVar.g;
                int n10 = iVar.f12790r.n();
                Uri[] uriArr = iVar.f12778e;
                x1.l a10 = (n10 >= uriArr.length || n10 == -1) ? null : cVar.a(uriArr[iVar.f12790r.j()], true);
                if (a10 != null) {
                    g0 g0Var = a10.f13425r;
                    if (!g0Var.isEmpty()) {
                        long j11 = a10.f13415h - cVar.B;
                        long j12 = j10 - j11;
                        int c10 = l1.a0.c(g0Var, Long.valueOf(j12), true);
                        long j13 = ((x1.i) g0Var.get(c10)).f13400s;
                        return f1Var.a(j12, j13, (!a10.f13452c || c10 == g0Var.size() - 1) ? j13 : ((x1.i) g0Var.get(c10 + 1)).f13400s) + j11;
                    }
                }
            } else {
                i10++;
            }
        }
        return j10;
    }

    @Override // c2.b0
    public final n1 j() {
        n1 n1Var = this.G;
        n1Var.getClass();
        return n1Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:188:0x011e, code lost:
    
        if (r44 != r3.f12849d0) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0310 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ac  */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r30v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v39 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    @Override // c2.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long k(f2.t[] r40, boolean[] r41, c2.e1[] r42, boolean[] r43, long r44) {
        /*
            Method dump skipped, instructions count: 855
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.k.k(f2.t[], boolean[], c2.e1[], boolean[], long):long");
    }

    @Override // c2.b0
    public final void l(a0 a0Var, long j10) {
        c cVar;
        boolean z10;
        List list;
        List list2;
        int i10;
        HashSet hashSet;
        HashSet hashSet2;
        int i11;
        boolean z11;
        c cVar2;
        int i12;
        boolean z12;
        Uri[] uriArr;
        this.E = a0Var;
        x1.c cVar3 = this.f12809p;
        cVar3.getClass();
        cVar3.f13347s.add(this);
        x1.o oVar = cVar3.f13352x;
        oVar.getClass();
        List list3 = oVar.g;
        List list4 = oVar.f13442e;
        Map map = Collections.EMPTY_MAP;
        boolean isEmpty = list4.isEmpty();
        List list5 = oVar.f13444h;
        int i13 = 0;
        this.F = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        c cVar4 = this.f12808o;
        boolean z13 = this.A;
        if (isEmpty) {
            cVar = cVar4;
            z10 = z13;
            list = list3;
            list2 = list5;
        } else {
            i1.p pVar = oVar.f13446j;
            int size = list4.size();
            int[] iArr = new int[size];
            int i14 = 0;
            int i15 = 0;
            while (true) {
                list2 = list5;
                if (i14 >= list4.size()) {
                    break;
                }
                i1.p pVar2 = ((x1.n) list4.get(i14)).f13435b;
                int i16 = pVar2.f5999v;
                String str = pVar2.f5988k;
                if (i16 > 0 || l1.a0.u(2, str) != null) {
                    iArr[i14] = 2;
                    i15++;
                } else if (l1.a0.u(1, str) != null) {
                    iArr[i14] = 1;
                    i13++;
                } else {
                    iArr[i14] = -1;
                }
                i14++;
                list5 = list2;
            }
            if (i15 > 0) {
                z12 = false;
                cVar2 = cVar4;
                i12 = i15;
                z11 = true;
            } else if (i13 < size) {
                z11 = false;
                cVar2 = cVar4;
                i12 = size - i13;
                z12 = true;
            } else {
                z11 = false;
                cVar2 = cVar4;
                i12 = size;
                z12 = false;
            }
            Uri[] uriArr2 = new Uri[i12];
            i1.p[] pVarArr = new i1.p[i12];
            int[] iArr2 = new int[i12];
            int i17 = 0;
            int i18 = 0;
            while (i17 < list4.size()) {
                if (z11) {
                    uriArr = uriArr2;
                    if (iArr[i17] != 2) {
                        i17++;
                        uriArr2 = uriArr;
                    }
                } else {
                    uriArr = uriArr2;
                }
                if (!z12 || iArr[i17] != 1) {
                    x1.n nVar = (x1.n) list4.get(i17);
                    uriArr[i18] = nVar.f13434a;
                    pVarArr[i18] = nVar.f13435b;
                    iArr2[i18] = i17;
                    i18++;
                }
                i17++;
                uriArr2 = uriArr;
            }
            Uri[] uriArr3 = uriArr2;
            String str2 = pVarArr[0].f5988k;
            int t3 = l1.a0.t(2, str2);
            int t8 = l1.a0.t(1, str2);
            boolean z14 = (t8 == 1 || (t8 == 0 && list3.isEmpty())) && t3 <= 1 && t8 + t3 > 0;
            c cVar5 = cVar2;
            list = list3;
            z10 = z13;
            r d6 = d("main", (z11 || t8 <= 0) ? 0 : 1, uriArr3, pVarArr, oVar.f13446j, oVar.f13447k, map, j10);
            arrayList.add(d6);
            arrayList2.add(iArr2);
            if (z10 && z14) {
                ArrayList arrayList3 = new ArrayList();
                if (t3 > 0) {
                    i1.p[] pVarArr2 = new i1.p[i12];
                    int i19 = 0;
                    while (i19 < i12) {
                        i1.p pVar3 = pVarArr[i19];
                        String u10 = l1.a0.u(2, pVar3.f5988k);
                        String d10 = i1.g0.d(u10);
                        i1.o oVar2 = new i1.o();
                        oVar2.f5929a = pVar3.f5979a;
                        oVar2.f5930b = pVar3.f5980b;
                        oVar2.f5931c = g0.n(pVar3.f5981c);
                        oVar2.f5939l = i1.g0.m(pVar3.f5990m);
                        oVar2.f5940m = i1.g0.m(d10);
                        oVar2.f5937j = u10;
                        oVar2.f5938k = pVar3.f5989l;
                        oVar2.f5935h = pVar3.f5985h;
                        oVar2.f5936i = pVar3.f5986i;
                        oVar2.f5947t = pVar3.f5998u;
                        oVar2.f5948u = pVar3.f5999v;
                        oVar2.f5951x = pVar3.f6002y;
                        oVar2.f5933e = pVar3.f5983e;
                        oVar2.f5934f = pVar3.f5984f;
                        pVarArr2[i19] = new i1.p(oVar2);
                        i19++;
                        pVarArr = pVarArr;
                    }
                    i1.p[] pVarArr3 = pVarArr;
                    arrayList3.add(new u0("main", pVarArr2));
                    if (t8 > 0 && (pVar != null || list.isEmpty())) {
                        arrayList3.add(new u0("main:audio", f(pVarArr3[0], pVar, false)));
                    }
                    List list6 = oVar.f13447k;
                    if (list6 != null) {
                        for (int i20 = 0; i20 < list6.size(); i20++) {
                            arrayList3.add(new u0(android.support.v4.media.d.m(i20, "main:cc:"), cVar5.b((i1.p) list6.get(i20))));
                        }
                    }
                    cVar = cVar5;
                } else {
                    cVar = cVar5;
                    i1.p[] pVarArr4 = new i1.p[i12];
                    for (int i21 = 0; i21 < i12; i21++) {
                        pVarArr4[i21] = f(pVarArr[i21], pVar, true);
                    }
                    arrayList3.add(new u0("main", pVarArr4));
                }
                i1.o oVar3 = new i1.o();
                oVar3.f5929a = "ID3";
                oVar3.f5940m = i1.g0.m("application/id3");
                u0 u0Var = new u0("main:id3", new i1.p(oVar3));
                arrayList3.add(u0Var);
                d6.H((u0[]) arrayList3.toArray(new u0[0]), arrayList3.indexOf(u0Var));
            } else {
                cVar = cVar5;
            }
        }
        ArrayList arrayList4 = new ArrayList(list.size());
        ArrayList arrayList5 = new ArrayList(list.size());
        ArrayList arrayList6 = new ArrayList(list.size());
        HashSet hashSet3 = new HashSet();
        int i22 = 0;
        while (i22 < list.size()) {
            List list7 = list;
            String str3 = ((x1.m) list7.get(i22)).f13433c;
            if (hashSet3.add(str3)) {
                arrayList4.clear();
                arrayList5.clear();
                arrayList6.clear();
                boolean z15 = true;
                for (int i23 = 0; i23 < list7.size(); i23++) {
                    if (str3.equals(((x1.m) list7.get(i23)).f13433c)) {
                        x1.m mVar = (x1.m) list7.get(i23);
                        arrayList6.add(Integer.valueOf(i23));
                        Uri uri = mVar.f13431a;
                        i1.p pVar4 = mVar.f13432b;
                        arrayList4.add(uri);
                        arrayList5.add(pVar4);
                        z15 &= l1.a0.t(1, pVar4.f5988k) == 1;
                    }
                }
                String concat = "audio:".concat(str3);
                int i24 = l1.a0.f8067a;
                list = list7;
                hashSet2 = hashSet3;
                i11 = i22;
                r d11 = d(concat, 1, (Uri[]) arrayList4.toArray(new Uri[0]), (i1.p[]) arrayList5.toArray(new i1.p[0]), null, Collections.EMPTY_LIST, map, j10);
                arrayList2.add(com.google.android.gms.internal.cast.n.u(arrayList6));
                arrayList.add(d11);
                if (z10 && z15) {
                    d11.H(new u0[]{new u0(concat, (i1.p[]) arrayList5.toArray(new i1.p[0]))}, new int[0]);
                }
            } else {
                hashSet2 = hashSet3;
                i11 = i22;
                list = list7;
            }
            i22 = i11 + 1;
            hashSet3 = hashSet2;
        }
        this.J = arrayList.size();
        ArrayList arrayList7 = new ArrayList(list2.size());
        ArrayList arrayList8 = new ArrayList(list2.size());
        ArrayList arrayList9 = new ArrayList(list2.size());
        HashSet hashSet4 = new HashSet();
        int i25 = 0;
        while (i25 < list2.size()) {
            List list8 = list2;
            String str4 = ((x1.m) list8.get(i25)).f13433c;
            if (hashSet4.add(str4)) {
                arrayList7.clear();
                arrayList8.clear();
                arrayList9.clear();
                for (int i26 = 0; i26 < list8.size(); i26++) {
                    if (str4.equals(((x1.m) list8.get(i26)).f13433c)) {
                        x1.m mVar2 = (x1.m) list8.get(i26);
                        arrayList9.add(Integer.valueOf(i26));
                        arrayList7.add(mVar2.f13431a);
                        arrayList8.add(mVar2.f13432b);
                    }
                }
                String concat2 = "subtitle:".concat(str4);
                i1.p[] pVarArr5 = (i1.p[]) arrayList8.toArray(new i1.p[0]);
                int i27 = l1.a0.f8067a;
                Uri[] uriArr4 = (Uri[]) arrayList7.toArray(new Uri[0]);
                o9.e0 e0Var = g0.f9617p;
                list2 = list8;
                i10 = i25;
                hashSet = hashSet4;
                r d12 = d(concat2, 3, uriArr4, pVarArr5, null, w0.f9686s, map, j10);
                arrayList2.add(com.google.android.gms.internal.cast.n.u(arrayList9));
                arrayList.add(d12);
                int length = pVarArr5.length;
                i1.p[] pVarArr6 = new i1.p[length];
                for (int i28 = 0; i28 < length; i28++) {
                    pVarArr6[i28] = cVar.b(pVarArr5[i28]);
                }
                d12.H(new u0[]{new u0(concat2, pVarArr6)}, new int[0]);
            } else {
                hashSet = hashSet4;
                i10 = i25;
                list2 = list8;
            }
            i25 = i10 + 1;
            hashSet4 = hashSet;
        }
        this.H = (r[]) arrayList.toArray(new r[0]);
        this.F = this.H.length;
        for (int i29 = 0; i29 < this.J; i29++) {
            this.H[i29].f12860r.f12784l = true;
        }
        for (r rVar : this.H) {
            if (!rVar.R) {
                s1.j0 j0Var = new s1.j0();
                j0Var.f11362a = rVar.f12849d0;
                rVar.s(new k0(j0Var));
            }
        }
        this.I = this.H;
    }

    @Override // c2.g1
    public final long m() {
        return this.K.m();
    }

    @Override // c2.b0
    public final void n() {
        for (r rVar : this.H) {
            rVar.G();
            if (rVar.h0 && !rVar.R) {
                throw h0.a(null, "Loading finished before preparation is complete.");
            }
        }
    }

    @Override // c2.b0
    public final long p(long j10) {
        r[] rVarArr = this.I;
        if (rVarArr.length > 0) {
            boolean J = rVarArr[0].J(j10, false);
            int i10 = 1;
            while (true) {
                r[] rVarArr2 = this.I;
                if (i10 >= rVarArr2.length) {
                    break;
                }
                rVarArr2[i10].J(j10, J);
                i10++;
            }
            if (J) {
                ((SparseArray) this.f12818y.f9953p).clear();
            }
        }
        return j10;
    }

    @Override // c2.b0
    public final void r(long j10) {
        for (r rVar : this.I) {
            if (rVar.Q && !rVar.E()) {
                int length = rVar.J.length;
                for (int i10 = 0; i10 < length; i10++) {
                    rVar.J[i10].i(j10, rVar.f12847b0[i10]);
                }
            }
        }
    }

    @Override // c2.g1
    public final boolean s(k0 k0Var) {
        if (this.G != null) {
            return this.K.s(k0Var);
        }
        for (r rVar : this.H) {
            if (!rVar.R) {
                s1.j0 j0Var = new s1.j0();
                j0Var.f11362a = rVar.f12849d0;
                rVar.s(new k0(j0Var));
            }
        }
        return false;
    }

    @Override // c2.g1
    public final void v(long j10) {
        this.K.v(j10);
    }
}
