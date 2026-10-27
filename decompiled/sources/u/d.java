package u;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import okhttp3.internal.url._UrlKt;
import v.k;
import v.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class d {
    public float A;
    public final int[] B;
    public float C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public final c H;
    public final c I;
    public final c J;
    public final c K;
    public final c L;
    public final c M;
    public final c N;
    public final c O;
    public final c[] P;
    public final ArrayList Q;
    public final boolean[] R;
    public d S;
    public int T;
    public int U;
    public float V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f12061a0;

    /* renamed from: b, reason: collision with root package name */
    public v.c f12062b;

    /* renamed from: b0, reason: collision with root package name */
    public int f12063b0;

    /* renamed from: c, reason: collision with root package name */
    public v.c f12064c;

    /* renamed from: c0, reason: collision with root package name */
    public float f12065c0;

    /* renamed from: d0, reason: collision with root package name */
    public float f12067d0;

    /* renamed from: e0, reason: collision with root package name */
    public View f12069e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f12071f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f12072g0;
    public int h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f12075i0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12076j;

    /* renamed from: j0, reason: collision with root package name */
    public final float[] f12077j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12078k;

    /* renamed from: k0, reason: collision with root package name */
    public final d[] f12079k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12080l;

    /* renamed from: l0, reason: collision with root package name */
    public final d[] f12081l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12082m;

    /* renamed from: m0, reason: collision with root package name */
    public int f12083m0;

    /* renamed from: n, reason: collision with root package name */
    public int f12084n;

    /* renamed from: n0, reason: collision with root package name */
    public int f12085n0;

    /* renamed from: o, reason: collision with root package name */
    public int f12086o;

    /* renamed from: o0, reason: collision with root package name */
    public final int[] f12087o0;

    /* renamed from: p, reason: collision with root package name */
    public int f12088p;

    /* renamed from: q, reason: collision with root package name */
    public int f12089q;

    /* renamed from: r, reason: collision with root package name */
    public int f12090r;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f12091s;

    /* renamed from: t, reason: collision with root package name */
    public int f12092t;

    /* renamed from: u, reason: collision with root package name */
    public int f12093u;

    /* renamed from: v, reason: collision with root package name */
    public float f12094v;

    /* renamed from: w, reason: collision with root package name */
    public int f12095w;

    /* renamed from: x, reason: collision with root package name */
    public int f12096x;

    /* renamed from: y, reason: collision with root package name */
    public float f12097y;

    /* renamed from: z, reason: collision with root package name */
    public int f12098z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f12060a = false;

    /* renamed from: d, reason: collision with root package name */
    public k f12066d = null;

    /* renamed from: e, reason: collision with root package name */
    public m f12068e = null;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f12070f = {true, true};
    public boolean g = true;

    /* renamed from: h, reason: collision with root package name */
    public int f12073h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f12074i = -1;

    public d() {
        new HashMap();
        this.f12076j = false;
        this.f12078k = false;
        this.f12080l = false;
        this.f12082m = false;
        this.f12084n = -1;
        this.f12086o = -1;
        this.f12088p = 0;
        this.f12089q = 0;
        this.f12090r = 0;
        this.f12091s = new int[2];
        this.f12092t = 0;
        this.f12093u = 0;
        this.f12094v = 1.0f;
        this.f12095w = 0;
        this.f12096x = 0;
        this.f12097y = 1.0f;
        this.f12098z = -1;
        this.A = 1.0f;
        this.B = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.C = 0.0f;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        c cVar = new c(this, 2);
        this.H = cVar;
        c cVar2 = new c(this, 3);
        this.I = cVar2;
        c cVar3 = new c(this, 4);
        this.J = cVar3;
        c cVar4 = new c(this, 5);
        this.K = cVar4;
        c cVar5 = new c(this, 6);
        this.L = cVar5;
        c cVar6 = new c(this, 8);
        this.M = cVar6;
        c cVar7 = new c(this, 9);
        this.N = cVar7;
        c cVar8 = new c(this, 7);
        this.O = cVar8;
        this.P = new c[]{cVar, cVar3, cVar2, cVar4, cVar5, cVar8};
        ArrayList arrayList = new ArrayList();
        this.Q = arrayList;
        this.R = new boolean[2];
        this.f12087o0 = new int[]{1, 1};
        this.S = null;
        this.T = 0;
        this.U = 0;
        this.V = 0.0f;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f12065c0 = 0.5f;
        this.f12067d0 = 0.5f;
        this.f12071f0 = 0;
        this.f12072g0 = null;
        this.h0 = 0;
        this.f12075i0 = 0;
        this.f12077j0 = new float[]{-1.0f, -1.0f};
        this.f12079k0 = new d[]{null, null};
        this.f12081l0 = new d[]{null, null};
        this.f12083m0 = -1;
        this.f12085n0 = -1;
        arrayList.add(cVar);
        arrayList.add(cVar2);
        arrayList.add(cVar3);
        arrayList.add(cVar4);
        arrayList.add(cVar6);
        arrayList.add(cVar7);
        arrayList.add(cVar8);
        arrayList.add(cVar5);
    }

    public final void A() {
        d dVar = this.S;
        if (dVar != null && (dVar instanceof e)) {
            ((e) dVar).getClass();
        }
        ArrayList arrayList = this.Q;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((c) arrayList.get(i10)).j();
        }
    }

    public final void B() {
        this.f12076j = false;
        this.f12078k = false;
        this.f12080l = false;
        this.f12082m = false;
        ArrayList arrayList = this.Q;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar = (c) arrayList.get(i10);
            cVar.f12054c = false;
            cVar.f12053b = 0;
        }
    }

    public void C(x4.m mVar) {
        this.H.k();
        this.I.k();
        this.J.k();
        this.K.k();
        this.L.k();
        this.O.k();
        this.M.k();
        this.N.k();
    }

    public final void D(int i10) {
        this.Z = i10;
        this.D = i10 > 0;
    }

    public final void E(int i10, int i11) {
        if (this.f12076j) {
            return;
        }
        this.H.l(i10);
        this.J.l(i11);
        this.X = i10;
        this.T = i11 - i10;
        this.f12076j = true;
    }

    public final void F(int i10, int i11) {
        if (this.f12078k) {
            return;
        }
        this.I.l(i10);
        this.K.l(i11);
        this.Y = i10;
        this.U = i11 - i10;
        if (this.D) {
            this.L.l(i10 + this.Z);
        }
        this.f12078k = true;
    }

    public final void G(int i10) {
        this.U = i10;
        int i11 = this.f12063b0;
        if (i10 < i11) {
            this.U = i11;
        }
    }

    public final void H(int i10) {
        this.f12087o0[0] = i10;
    }

    public final void I(int i10) {
        this.f12087o0[1] = i10;
    }

    public final void J(int i10) {
        this.T = i10;
        int i11 = this.f12061a0;
        if (i10 < i11) {
            this.T = i11;
        }
    }

    public void K(boolean z10, boolean z11) {
        int i10;
        int i11;
        k kVar = this.f12066d;
        boolean z12 = z10 & kVar.g;
        m mVar = this.f12068e;
        boolean z13 = z11 & mVar.g;
        int i12 = kVar.f12628h.g;
        int i13 = mVar.f12628h.g;
        int i14 = kVar.f12629i.g;
        int i15 = mVar.f12629i.g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i15 = 0;
            i12 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (z12) {
            this.X = i12;
        }
        if (z13) {
            this.Y = i13;
        }
        if (this.f12071f0 == 8) {
            this.T = 0;
            this.U = 0;
            return;
        }
        int[] iArr = this.f12087o0;
        if (z12) {
            if (iArr[0] == 1 && i17 < (i11 = this.T)) {
                i17 = i11;
            }
            this.T = i17;
            int i19 = this.f12061a0;
            if (i17 < i19) {
                this.T = i19;
            }
        }
        if (z13) {
            if (iArr[1] == 1 && i18 < (i10 = this.U)) {
                i18 = i10;
            }
            this.U = i18;
            int i20 = this.f12063b0;
            if (i18 < i20) {
                this.U = i20;
            }
        }
    }

    public void L(s.c cVar, boolean z10) {
        int i10;
        int i11;
        m mVar;
        k kVar;
        cVar.getClass();
        int n10 = s.c.n(this.H);
        int n11 = s.c.n(this.I);
        int n12 = s.c.n(this.J);
        int n13 = s.c.n(this.K);
        if (z10 && (kVar = this.f12066d) != null) {
            v.f fVar = kVar.f12628h;
            if (fVar.f12606j) {
                v.f fVar2 = kVar.f12629i;
                if (fVar2.f12606j) {
                    n10 = fVar.g;
                    n12 = fVar2.g;
                }
            }
        }
        if (z10 && (mVar = this.f12068e) != null) {
            v.f fVar3 = mVar.f12628h;
            if (fVar3.f12606j) {
                v.f fVar4 = mVar.f12629i;
                if (fVar4.f12606j) {
                    n11 = fVar3.g;
                    n13 = fVar4.g;
                }
            }
        }
        int i12 = n13 - n11;
        if (n12 - n10 < 0 || i12 < 0 || n10 == Integer.MIN_VALUE || n10 == Integer.MAX_VALUE || n11 == Integer.MIN_VALUE || n11 == Integer.MAX_VALUE || n12 == Integer.MIN_VALUE || n12 == Integer.MAX_VALUE || n13 == Integer.MIN_VALUE || n13 == Integer.MAX_VALUE) {
            n10 = 0;
            n11 = 0;
            n12 = 0;
            n13 = 0;
        }
        int i13 = n12 - n10;
        int i14 = n13 - n11;
        this.X = n10;
        this.Y = n11;
        if (this.f12071f0 == 8) {
            this.T = 0;
            this.U = 0;
            return;
        }
        int[] iArr = this.f12087o0;
        int i15 = iArr[0];
        if (i15 == 1 && i13 < (i11 = this.T)) {
            i13 = i11;
        }
        if (iArr[1] == 1 && i14 < (i10 = this.U)) {
            i14 = i10;
        }
        this.T = i13;
        this.U = i14;
        int i16 = this.f12063b0;
        if (i14 < i16) {
            this.U = i16;
        }
        int i17 = this.f12061a0;
        if (i13 < i17) {
            this.T = i17;
        }
        int i18 = this.f12093u;
        if (i18 > 0 && i15 == 3) {
            this.T = Math.min(this.T, i18);
        }
        int i19 = this.f12096x;
        if (i19 > 0 && iArr[1] == 3) {
            this.U = Math.min(this.U, i19);
        }
        int i20 = this.T;
        if (i13 != i20) {
            this.f12073h = i20;
        }
        int i21 = this.U;
        if (i14 != i21) {
            this.f12074i = i21;
        }
    }

    public final void a(e eVar, s.c cVar, HashSet hashSet, int i10, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.b(eVar, cVar, this);
            hashSet.remove(this);
            b(cVar, eVar.R(64));
        }
        if (i10 == 0) {
            HashSet hashSet2 = this.H.f12052a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).f12055d.a(eVar, cVar, hashSet, i10, true);
                }
            }
            HashSet hashSet3 = this.J.f12052a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).f12055d.a(eVar, cVar, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.I.f12052a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((c) it3.next()).f12055d.a(eVar, cVar, hashSet, i10, true);
            }
        }
        HashSet hashSet5 = this.K.f12052a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((c) it4.next()).f12055d.a(eVar, cVar, hashSet, i10, true);
            }
        }
        HashSet hashSet6 = this.L.f12052a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((c) it5.next()).f12055d.a(eVar, cVar, hashSet, i10, true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        if (r12 != 3) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x05d3, code lost:
    
        if (r58.f12071f0 == r14) goto L374;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02b5  */
    /* JADX WARN: Type inference failed for: r17v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v16 */
    /* JADX WARN: Type inference failed for: r17v17 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v20 */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r58v0, types: [u.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(s.c r59, boolean r60) {
        /*
            Method dump skipped, instructions count: 1912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.d.b(s.c, boolean):void");
    }

    public boolean c() {
        return this.f12071f0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x03bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0440 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x04d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(s.c r30, boolean r31, boolean r32, boolean r33, boolean r34, s.f r35, s.f r36, int r37, boolean r38, u.c r39, u.c r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, int r51, int r52, int r53, int r54, float r55, boolean r56) {
        /*
            Method dump skipped, instructions count: 1323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.d.d(s.c, boolean, boolean, boolean, boolean, s.f, s.f, int, boolean, u.c, u.c, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void e(int i10, d dVar, int i11, int i12) {
        boolean z10;
        if (i10 == 7) {
            if (i11 != 7) {
                if (i11 == 2 || i11 == 4) {
                    e(2, dVar, i11, 0);
                    e(4, dVar, i11, 0);
                    i(7).a(dVar.i(i11), 0);
                    return;
                } else {
                    if (i11 == 3 || i11 == 5) {
                        e(3, dVar, i11, 0);
                        e(5, dVar, i11, 0);
                        i(7).a(dVar.i(i11), 0);
                        return;
                    }
                    return;
                }
            }
            c i13 = i(2);
            c i14 = i(4);
            c i15 = i(3);
            c i16 = i(5);
            boolean z11 = true;
            if ((i13 == null || !i13.h()) && (i14 == null || !i14.h())) {
                e(2, dVar, 2, 0);
                e(4, dVar, 4, 0);
                z10 = true;
            } else {
                z10 = false;
            }
            if ((i15 == null || !i15.h()) && (i16 == null || !i16.h())) {
                e(3, dVar, 3, 0);
                e(5, dVar, 5, 0);
            } else {
                z11 = false;
            }
            if (z10 && z11) {
                i(7).a(dVar.i(7), 0);
                return;
            } else if (z10) {
                i(8).a(dVar.i(8), 0);
                return;
            } else {
                if (z11) {
                    i(9).a(dVar.i(9), 0);
                    return;
                }
                return;
            }
        }
        if (i10 == 8 && (i11 == 2 || i11 == 4)) {
            c i17 = i(2);
            c i18 = dVar.i(i11);
            c i19 = i(4);
            i17.a(i18, 0);
            i19.a(i18, 0);
            i(8).a(i18, 0);
            return;
        }
        if (i10 == 9 && (i11 == 3 || i11 == 5)) {
            c i20 = dVar.i(i11);
            i(3).a(i20, 0);
            i(5).a(i20, 0);
            i(9).a(i20, 0);
            return;
        }
        if (i10 == 8 && i11 == 8) {
            i(2).a(dVar.i(2), 0);
            i(4).a(dVar.i(4), 0);
            i(8).a(dVar.i(i11), 0);
            return;
        }
        if (i10 == 9 && i11 == 9) {
            i(3).a(dVar.i(3), 0);
            i(5).a(dVar.i(5), 0);
            i(9).a(dVar.i(i11), 0);
            return;
        }
        c i21 = i(i10);
        c i22 = dVar.i(i11);
        if (i21.i(i22)) {
            if (i10 == 6) {
                c i23 = i(3);
                c i24 = i(5);
                if (i23 != null) {
                    i23.j();
                }
                if (i24 != null) {
                    i24.j();
                }
            } else if (i10 == 3 || i10 == 5) {
                c i25 = i(6);
                if (i25 != null) {
                    i25.j();
                }
                c i26 = i(7);
                if (i26.f12057f != i22) {
                    i26.j();
                }
                c f10 = i(i10).f();
                c i27 = i(9);
                if (i27.h()) {
                    f10.j();
                    i27.j();
                }
            } else if (i10 == 2 || i10 == 4) {
                c i28 = i(7);
                if (i28.f12057f != i22) {
                    i28.j();
                }
                c f11 = i(i10).f();
                c i29 = i(8);
                if (i29.h()) {
                    f11.j();
                    i29.j();
                }
            }
            i21.a(i22, i12);
        }
    }

    public final void f(c cVar, c cVar2, int i10) {
        if (cVar.f12055d == this) {
            e(cVar.f12056e, cVar2.f12055d, cVar2.f12056e, i10);
        }
    }

    public final void g(s.c cVar) {
        cVar.k(this.H);
        cVar.k(this.I);
        cVar.k(this.J);
        cVar.k(this.K);
        if (this.Z > 0) {
            cVar.k(this.L);
        }
    }

    public final void h() {
        if (this.f12066d == null) {
            k kVar = new k(this);
            kVar.f12628h.f12602e = 4;
            kVar.f12629i.f12602e = 5;
            kVar.f12627f = 0;
            this.f12066d = kVar;
        }
        if (this.f12068e == null) {
            m mVar = new m(this);
            v.f fVar = new v.f(mVar);
            mVar.f12614k = fVar;
            mVar.f12615l = null;
            mVar.f12628h.f12602e = 6;
            mVar.f12629i.f12602e = 7;
            fVar.f12602e = 8;
            mVar.f12627f = 1;
            this.f12068e = mVar;
        }
    }

    public c i(int i10) {
        switch (s.e.b(i10)) {
            case 0:
                return null;
            case 1:
                return this.H;
            case 2:
                return this.I;
            case 3:
                return this.J;
            case 4:
                return this.K;
            case 5:
                return this.L;
            case 6:
                return this.O;
            case 7:
                return this.M;
            case 8:
                return this.N;
            default:
                throw new AssertionError(r.a.m(i10));
        }
    }

    public final int j(int i10) {
        int[] iArr = this.f12087o0;
        if (i10 == 0) {
            return iArr[0];
        }
        if (i10 == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int k() {
        if (this.f12071f0 == 8) {
            return 0;
        }
        return this.U;
    }

    public final d l(int i10) {
        c cVar;
        c cVar2;
        if (i10 != 0) {
            if (i10 == 1 && (cVar2 = (cVar = this.K).f12057f) != null && cVar2.f12057f == cVar) {
                return cVar2.f12055d;
            }
            return null;
        }
        c cVar3 = this.J;
        c cVar4 = cVar3.f12057f;
        if (cVar4 == null || cVar4.f12057f != cVar3) {
            return null;
        }
        return cVar4.f12055d;
    }

    public final d m(int i10) {
        c cVar;
        c cVar2;
        if (i10 != 0) {
            if (i10 == 1 && (cVar2 = (cVar = this.I).f12057f) != null && cVar2.f12057f == cVar) {
                return cVar2.f12055d;
            }
            return null;
        }
        c cVar3 = this.H;
        c cVar4 = cVar3.f12057f;
        if (cVar4 == null || cVar4.f12057f != cVar3) {
            return null;
        }
        return cVar4.f12055d;
    }

    public final int n() {
        if (this.f12071f0 == 8) {
            return 0;
        }
        return this.T;
    }

    public final int o() {
        d dVar = this.S;
        return (dVar == null || !(dVar instanceof e)) ? this.X : ((e) dVar).f12106w0 + this.X;
    }

    public final int p() {
        d dVar = this.S;
        return (dVar == null || !(dVar instanceof e)) ? this.Y : ((e) dVar).f12107x0 + this.Y;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(int r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L1b
            u.c r5 = r4.H
            u.c r5 = r5.f12057f
            if (r5 == 0) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r1
        Le:
            u.c r3 = r4.J
            u.c r3 = r3.f12057f
            if (r3 == 0) goto L16
            r3 = r2
            goto L17
        L16:
            r3 = r1
        L17:
            int r5 = r5 + r3
            if (r5 >= r0) goto L3b
            goto L3a
        L1b:
            u.c r5 = r4.I
            u.c r5 = r5.f12057f
            if (r5 == 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            u.c r3 = r4.K
            u.c r3 = r3.f12057f
            if (r3 == 0) goto L2c
            r3 = r2
            goto L2d
        L2c:
            r3 = r1
        L2d:
            int r5 = r5 + r3
            u.c r3 = r4.L
            u.c r3 = r3.f12057f
            if (r3 == 0) goto L36
            r3 = r2
            goto L37
        L36:
            r3 = r1
        L37:
            int r5 = r5 + r3
            if (r5 >= r0) goto L3b
        L3a:
            return r2
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u.d.q(int):boolean");
    }

    public final boolean r(int i10, int i11) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        if (i10 == 0) {
            c cVar5 = this.H;
            c cVar6 = cVar5.f12057f;
            if (cVar6 == null || !cVar6.f12054c || (cVar4 = (cVar3 = this.J).f12057f) == null || !cVar4.f12054c) {
                return false;
            }
            return (cVar4.d() - cVar3.e()) - (cVar5.e() + cVar5.f12057f.d()) >= i11;
        }
        c cVar7 = this.I;
        c cVar8 = cVar7.f12057f;
        if (cVar8 == null || !cVar8.f12054c || (cVar2 = (cVar = this.K).f12057f) == null || !cVar2.f12054c) {
            return false;
        }
        return (cVar2.d() - cVar.e()) - (cVar7.e() + cVar7.f12057f.d()) >= i11;
    }

    public final void s(int i10, int i11, int i12, int i13, d dVar) {
        i(i10).b(dVar.i(i11), i12, i13, true);
    }

    public final boolean t(int i10) {
        c cVar;
        c cVar2;
        int i11 = i10 * 2;
        c[] cVarArr = this.P;
        c cVar3 = cVarArr[i11];
        c cVar4 = cVar3.f12057f;
        return (cVar4 == null || cVar4.f12057f == cVar3 || (cVar2 = (cVar = cVarArr[i11 + 1]).f12057f) == null || cVar2.f12057f != cVar) ? false : true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = _UrlKt.FRAGMENT_ENCODE_SET;
        sb2.append(_UrlKt.FRAGMENT_ENCODE_SET);
        if (this.f12072g0 != null) {
            str = android.support.v4.media.d.r(new StringBuilder("id: "), this.f12072g0, " ");
        }
        sb2.append(str);
        sb2.append("(");
        sb2.append(this.X);
        sb2.append(", ");
        sb2.append(this.Y);
        sb2.append(") - (");
        sb2.append(this.T);
        sb2.append(" x ");
        return r.a.d(sb2, this.U, ")");
    }

    public final boolean u() {
        c cVar = this.H;
        c cVar2 = cVar.f12057f;
        if (cVar2 != null && cVar2.f12057f == cVar) {
            return true;
        }
        c cVar3 = this.J;
        c cVar4 = cVar3.f12057f;
        return cVar4 != null && cVar4.f12057f == cVar3;
    }

    public final boolean v() {
        c cVar = this.I;
        c cVar2 = cVar.f12057f;
        if (cVar2 != null && cVar2.f12057f == cVar) {
            return true;
        }
        c cVar3 = this.K;
        c cVar4 = cVar3.f12057f;
        return cVar4 != null && cVar4.f12057f == cVar3;
    }

    public final boolean w() {
        return this.g && this.f12071f0 != 8;
    }

    public boolean x() {
        if (this.f12076j) {
            return true;
        }
        return this.H.f12054c && this.J.f12054c;
    }

    public boolean y() {
        if (this.f12078k) {
            return true;
        }
        return this.I.f12054c && this.K.f12054c;
    }

    public void z() {
        this.H.j();
        this.I.j();
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.S = null;
        this.C = 0.0f;
        this.T = 0;
        this.U = 0;
        this.V = 0.0f;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f12061a0 = 0;
        this.f12063b0 = 0;
        this.f12065c0 = 0.5f;
        this.f12067d0 = 0.5f;
        int[] iArr = this.f12087o0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.f12069e0 = null;
        this.f12071f0 = 0;
        this.h0 = 0;
        this.f12075i0 = 0;
        float[] fArr = this.f12077j0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f12084n = -1;
        this.f12086o = -1;
        int[] iArr2 = this.B;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.f12089q = 0;
        this.f12090r = 0;
        this.f12094v = 1.0f;
        this.f12097y = 1.0f;
        this.f12093u = Integer.MAX_VALUE;
        this.f12096x = Integer.MAX_VALUE;
        this.f12092t = 0;
        this.f12095w = 0;
        this.f12098z = -1;
        this.A = 1.0f;
        boolean[] zArr = this.f12070f;
        zArr[0] = true;
        zArr[1] = true;
        this.E = false;
        boolean[] zArr2 = this.R;
        zArr2[0] = false;
        zArr2[1] = false;
        this.g = true;
        int[] iArr3 = this.f12091s;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.f12073h = -1;
        this.f12074i = -1;
    }
}
