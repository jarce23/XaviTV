package v;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final b f12610a = new b();

    public static boolean a(u.d dVar) {
        int[] iArr = dVar.f12087o0;
        int i10 = iArr[0];
        int i11 = iArr[1];
        u.d dVar2 = dVar.S;
        u.e eVar = dVar2 != null ? (u.e) dVar2 : null;
        if (eVar != null) {
            int i12 = eVar.f12087o0[0];
        }
        if (eVar != null) {
            int i13 = eVar.f12087o0[1];
        }
        boolean z10 = i10 == 1 || dVar.x() || i10 == 2 || (i10 == 3 && dVar.f12089q == 0 && dVar.V == 0.0f && dVar.q(0)) || (i10 == 3 && dVar.f12089q == 1 && dVar.r(0, dVar.n()));
        boolean z11 = i11 == 1 || dVar.y() || i11 == 2 || (i11 == 3 && dVar.f12090r == 0 && dVar.V == 0.0f && dVar.q(1)) || (i10 == 3 && dVar.f12090r == 1 && dVar.r(1, dVar.k()));
        return (dVar.V > 0.0f && (z10 || z11)) || (z10 && z11);
    }

    public static n b(u.d dVar, int i10, ArrayList arrayList, n nVar) {
        int i11;
        int i12 = i10 == 0 ? dVar.f12083m0 : dVar.f12085n0;
        if (i12 != -1 && (nVar == null || i12 != nVar.f12618b)) {
            int i13 = 0;
            while (true) {
                if (i13 >= arrayList.size()) {
                    break;
                }
                n nVar2 = (n) arrayList.get(i13);
                if (nVar2.f12618b == i12) {
                    if (nVar != null) {
                        nVar.c(i10, nVar2);
                        arrayList.remove(nVar);
                    }
                    nVar = nVar2;
                } else {
                    i13++;
                }
            }
        } else if (i12 != -1) {
            return nVar;
        }
        if (nVar == null) {
            if (dVar instanceof u.i) {
                u.i iVar = (u.i) dVar;
                int i14 = 0;
                while (true) {
                    if (i14 >= iVar.f12144q0) {
                        i11 = -1;
                        break;
                    }
                    u.d dVar2 = iVar.f12143p0[i14];
                    if ((i10 == 0 && (i11 = dVar2.f12083m0) != -1) || (i10 == 1 && (i11 = dVar2.f12085n0) != -1)) {
                        break;
                    }
                    i14++;
                }
                if (i11 != -1) {
                    int i15 = 0;
                    while (true) {
                        if (i15 >= arrayList.size()) {
                            break;
                        }
                        n nVar3 = (n) arrayList.get(i15);
                        if (nVar3.f12618b == i11) {
                            nVar = nVar3;
                            break;
                        }
                        i15++;
                    }
                }
            }
            if (nVar == null) {
                nVar = new n();
                nVar.f12617a = new ArrayList();
                nVar.f12620d = null;
                nVar.f12621e = -1;
                int i16 = n.f12616f;
                n.f12616f = i16 + 1;
                nVar.f12618b = i16;
                nVar.f12619c = i10;
            }
            arrayList.add(nVar);
        }
        int i17 = nVar.f12618b;
        ArrayList arrayList2 = nVar.f12617a;
        if (arrayList2.contains(dVar)) {
            return nVar;
        }
        arrayList2.add(dVar);
        if (dVar instanceof u.h) {
            u.h hVar = (u.h) dVar;
            hVar.f12140s0.c(hVar.f12141t0 == 0 ? 1 : 0, arrayList, nVar);
        }
        if (i10 == 0) {
            dVar.f12083m0 = i17;
            dVar.H.c(i10, arrayList, nVar);
            dVar.J.c(i10, arrayList, nVar);
        } else {
            dVar.f12085n0 = i17;
            dVar.I.c(i10, arrayList, nVar);
            dVar.L.c(i10, arrayList, nVar);
            dVar.K.c(i10, arrayList, nVar);
        }
        dVar.O.c(i10, arrayList, nVar);
        return nVar;
    }

    public static void c(int i10, u.d dVar, x.e eVar, boolean z10) {
        u.c cVar;
        u.c cVar2;
        char c10;
        u.c cVar3;
        u.c cVar4;
        u.c cVar5;
        if (dVar.f12080l) {
            return;
        }
        if (!(dVar instanceof u.e) && dVar.w() && a(dVar)) {
            u.e.Q(dVar, eVar, new b());
        }
        u.c i11 = dVar.i(2);
        u.c i12 = dVar.i(4);
        int d6 = i11.d();
        int d10 = i12.d();
        HashSet hashSet = i11.f12052a;
        if (hashSet != null && i11.f12054c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                u.c cVar6 = (u.c) it.next();
                u.d dVar2 = cVar6.f12055d;
                int i13 = i10 + 1;
                boolean a10 = a(dVar2);
                u.c cVar7 = dVar2.H;
                u.c cVar8 = dVar2.J;
                if (dVar2.w() && a10) {
                    c10 = 0;
                    u.e.Q(dVar2, eVar, new b());
                } else {
                    c10 = 0;
                }
                int i14 = dVar2.f12087o0[c10];
                if (i14 != 3 || a10) {
                    if (!dVar2.w()) {
                        if (cVar6 == cVar7 && cVar8.f12057f == null) {
                            int e7 = cVar7.e() + d6;
                            dVar2.E(e7, dVar2.n() + e7);
                            c(i13, dVar2, eVar, z10);
                        } else if (cVar6 == cVar8 && cVar7.f12057f == null) {
                            int e8 = d6 - cVar8.e();
                            dVar2.E(e8 - dVar2.n(), e8);
                            c(i13, dVar2, eVar, z10);
                        } else if (cVar6 == cVar7 && (cVar3 = cVar8.f12057f) != null && cVar3.f12054c && !dVar2.u()) {
                            d(i13, dVar2, eVar, z10);
                        }
                    }
                } else if (i14 == 3 && dVar2.f12093u >= 0 && dVar2.f12092t >= 0 && (dVar2.f12071f0 == 8 || (dVar2.f12089q == 0 && dVar2.V == 0.0f))) {
                    if (!dVar2.u() && !dVar2.E && ((cVar6 == cVar7 && (cVar5 = cVar8.f12057f) != null && cVar5.f12054c) || (cVar6 == cVar8 && (cVar4 = cVar7.f12057f) != null && cVar4.f12054c))) {
                        if (!dVar2.u()) {
                            e(i13, dVar, eVar, dVar2, z10);
                        }
                    }
                }
            }
        }
        if (dVar instanceof u.h) {
            return;
        }
        HashSet hashSet2 = i12.f12052a;
        if (hashSet2 != null && i12.f12054c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                u.c cVar9 = (u.c) it2.next();
                u.d dVar3 = cVar9.f12055d;
                int i15 = i10 + 1;
                boolean a11 = a(dVar3);
                u.c cVar10 = dVar3.H;
                u.c cVar11 = dVar3.J;
                if (dVar3.w() && a11) {
                    u.e.Q(dVar3, eVar, new b());
                }
                boolean z11 = (cVar9 == cVar10 && (cVar2 = cVar11.f12057f) != null && cVar2.f12054c) || (cVar9 == cVar11 && (cVar = cVar10.f12057f) != null && cVar.f12054c);
                int i16 = dVar3.f12087o0[0];
                if (i16 != 3 || a11) {
                    if (!dVar3.w()) {
                        if (cVar9 == cVar10 && cVar11.f12057f == null) {
                            int e10 = cVar10.e() + d10;
                            dVar3.E(e10, dVar3.n() + e10);
                            c(i15, dVar3, eVar, z10);
                        } else if (cVar9 == cVar11 && cVar10.f12057f == null) {
                            int e11 = d10 - cVar11.e();
                            dVar3.E(e11 - dVar3.n(), e11);
                            c(i15, dVar3, eVar, z10);
                        } else if (z11 && !dVar3.u()) {
                            d(i15, dVar3, eVar, z10);
                        }
                    }
                } else if (i16 == 3 && dVar3.f12093u >= 0 && dVar3.f12092t >= 0 && (dVar3.f12071f0 == 8 || (dVar3.f12089q == 0 && dVar3.V == 0.0f))) {
                    if (!dVar3.u() && !dVar3.E && z11 && !dVar3.u()) {
                        e(i15, dVar, eVar, dVar3, z10);
                    }
                }
            }
        }
        dVar.f12080l = true;
    }

    public static void d(int i10, u.d dVar, x.e eVar, boolean z10) {
        float f10 = dVar.f12065c0;
        u.c cVar = dVar.H;
        int d6 = cVar.f12057f.d();
        u.c cVar2 = dVar.J;
        int d10 = cVar2.f12057f.d();
        int e7 = cVar.e() + d6;
        int e8 = d10 - cVar2.e();
        if (d6 == d10) {
            f10 = 0.5f;
        } else {
            d6 = e7;
            d10 = e8;
        }
        int n10 = dVar.n();
        int i11 = (d10 - d6) - n10;
        if (d6 > d10) {
            i11 = (d6 - d10) - n10;
        }
        int i12 = ((int) (i11 > 0 ? (f10 * i11) + 0.5f : f10 * i11)) + d6;
        int i13 = i12 + n10;
        if (d6 > d10) {
            i13 = i12 - n10;
        }
        dVar.E(i12, i13);
        c(i10 + 1, dVar, eVar, z10);
    }

    public static void e(int i10, u.d dVar, x.e eVar, u.d dVar2, boolean z10) {
        float f10 = dVar2.f12065c0;
        u.c cVar = dVar2.H;
        int e7 = cVar.e() + cVar.f12057f.d();
        u.c cVar2 = dVar2.J;
        int d6 = cVar2.f12057f.d() - cVar2.e();
        if (d6 >= e7) {
            int n10 = dVar2.n();
            if (dVar2.f12071f0 != 8) {
                int i11 = dVar2.f12089q;
                if (i11 == 2) {
                    n10 = (int) (dVar2.f12065c0 * 0.5f * (dVar instanceof u.e ? dVar.n() : dVar.S.n()));
                } else if (i11 == 0) {
                    n10 = d6 - e7;
                }
                n10 = Math.max(dVar2.f12092t, n10);
                int i12 = dVar2.f12093u;
                if (i12 > 0) {
                    n10 = Math.min(i12, n10);
                }
            }
            int i13 = e7 + ((int) ((f10 * ((d6 - e7) - n10)) + 0.5f));
            dVar2.E(i13, n10 + i13);
            c(i10 + 1, dVar2, eVar, z10);
        }
    }

    public static void f(int i10, u.d dVar, x.e eVar) {
        float f10 = dVar.f12067d0;
        u.c cVar = dVar.I;
        int d6 = cVar.f12057f.d();
        u.c cVar2 = dVar.K;
        int d10 = cVar2.f12057f.d();
        int e7 = cVar.e() + d6;
        int e8 = d10 - cVar2.e();
        if (d6 == d10) {
            f10 = 0.5f;
        } else {
            d6 = e7;
            d10 = e8;
        }
        int k10 = dVar.k();
        int i11 = (d10 - d6) - k10;
        if (d6 > d10) {
            i11 = (d6 - d10) - k10;
        }
        int i12 = (int) (i11 > 0 ? (f10 * i11) + 0.5f : f10 * i11);
        int i13 = d6 + i12;
        int i14 = i13 + k10;
        if (d6 > d10) {
            i13 = d6 - i12;
            i14 = i13 - k10;
        }
        dVar.F(i13, i14);
        i(i10 + 1, dVar, eVar);
    }

    public static void g(int i10, u.d dVar, x.e eVar, u.d dVar2) {
        float f10 = dVar2.f12067d0;
        u.c cVar = dVar2.I;
        int e7 = cVar.e() + cVar.f12057f.d();
        u.c cVar2 = dVar2.K;
        int d6 = cVar2.f12057f.d() - cVar2.e();
        if (d6 >= e7) {
            int k10 = dVar2.k();
            if (dVar2.f12071f0 != 8) {
                int i11 = dVar2.f12090r;
                if (i11 == 2) {
                    k10 = (int) (f10 * 0.5f * (dVar instanceof u.e ? dVar.k() : dVar.S.k()));
                } else if (i11 == 0) {
                    k10 = d6 - e7;
                }
                k10 = Math.max(dVar2.f12095w, k10);
                int i12 = dVar2.f12096x;
                if (i12 > 0) {
                    k10 = Math.min(i12, k10);
                }
            }
            int i13 = e7 + ((int) ((f10 * ((d6 - e7) - k10)) + 0.5f));
            dVar2.F(i13, k10 + i13);
            i(i10 + 1, dVar2, eVar);
        }
    }

    public static boolean h(int i10, int i11, int i12, int i13) {
        return (i12 == 1 || i12 == 2 || (i12 == 4 && i10 != 2)) || (i13 == 1 || i13 == 2 || (i13 == 4 && i11 != 2));
    }

    public static void i(int i10, u.d dVar, x.e eVar) {
        u.c cVar;
        u.c cVar2;
        float f10;
        u.c cVar3;
        u.c cVar4;
        u.c cVar5;
        if (dVar.f12082m) {
            return;
        }
        if (!(dVar instanceof u.e) && dVar.w() && a(dVar)) {
            u.e.Q(dVar, eVar, new b());
        }
        u.c i11 = dVar.i(3);
        u.c i12 = dVar.i(5);
        int d6 = i11.d();
        int d10 = i12.d();
        HashSet hashSet = i11.f12052a;
        if (hashSet != null && i11.f12054c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                u.c cVar6 = (u.c) it.next();
                u.d dVar2 = cVar6.f12055d;
                int i13 = i10 + 1;
                boolean a10 = a(dVar2);
                u.c cVar7 = dVar2.I;
                u.c cVar8 = dVar2.K;
                if (dVar2.w() && a10) {
                    f10 = 0.0f;
                    u.e.Q(dVar2, eVar, new b());
                } else {
                    f10 = 0.0f;
                }
                int i14 = dVar2.f12087o0[1];
                if (i14 != 3 || a10) {
                    if (!dVar2.w()) {
                        if (cVar6 == cVar7 && cVar8.f12057f == null) {
                            int e7 = cVar7.e() + d6;
                            dVar2.F(e7, dVar2.k() + e7);
                            i(i13, dVar2, eVar);
                        } else if (cVar6 == cVar8 && cVar8.f12057f == null) {
                            int e8 = d6 - cVar8.e();
                            dVar2.F(e8 - dVar2.k(), e8);
                            i(i13, dVar2, eVar);
                        } else if (cVar6 == cVar7 && (cVar3 = cVar8.f12057f) != null && cVar3.f12054c) {
                            f(i13, dVar2, eVar);
                        }
                    }
                } else if (i14 == 3 && dVar2.f12096x >= 0 && dVar2.f12095w >= 0 && (dVar2.f12071f0 == 8 || (dVar2.f12090r == 0 && dVar2.V == f10))) {
                    if (!dVar2.v() && !dVar2.E && ((cVar6 == cVar7 && (cVar5 = cVar8.f12057f) != null && cVar5.f12054c) || (cVar6 == cVar8 && (cVar4 = cVar7.f12057f) != null && cVar4.f12054c))) {
                        if (!dVar2.v()) {
                            g(i13, dVar, eVar, dVar2);
                        }
                    }
                }
            }
        }
        if (dVar instanceof u.h) {
            return;
        }
        HashSet hashSet2 = i12.f12052a;
        if (hashSet2 != null && i12.f12054c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                u.c cVar9 = (u.c) it2.next();
                u.d dVar3 = cVar9.f12055d;
                int i15 = i10 + 1;
                boolean a11 = a(dVar3);
                u.c cVar10 = dVar3.I;
                u.c cVar11 = dVar3.K;
                if (dVar3.w() && a11) {
                    u.e.Q(dVar3, eVar, new b());
                }
                boolean z10 = (cVar9 == cVar10 && (cVar2 = cVar11.f12057f) != null && cVar2.f12054c) || (cVar9 == cVar11 && (cVar = cVar10.f12057f) != null && cVar.f12054c);
                int i16 = dVar3.f12087o0[1];
                if (i16 != 3 || a11) {
                    if (!dVar3.w()) {
                        if (cVar9 == cVar10 && cVar11.f12057f == null) {
                            int e10 = cVar10.e() + d10;
                            dVar3.F(e10, dVar3.k() + e10);
                            i(i15, dVar3, eVar);
                        } else if (cVar9 == cVar11 && cVar10.f12057f == null) {
                            int e11 = d10 - cVar11.e();
                            dVar3.F(e11 - dVar3.k(), e11);
                            i(i15, dVar3, eVar);
                        } else if (z10 && !dVar3.v()) {
                            f(i15, dVar3, eVar);
                        }
                    }
                } else if (i16 == 3 && dVar3.f12096x >= 0 && dVar3.f12095w >= 0 && (dVar3.f12071f0 == 8 || (dVar3.f12090r == 0 && dVar3.V == 0.0f))) {
                    if (!dVar3.v() && !dVar3.E && z10 && !dVar3.v()) {
                        g(i15, dVar, eVar, dVar3);
                    }
                }
            }
        }
        u.c i17 = dVar.i(6);
        if (i17.f12052a != null && i17.f12054c) {
            int d11 = i17.d();
            Iterator it3 = i17.f12052a.iterator();
            while (it3.hasNext()) {
                u.c cVar12 = (u.c) it3.next();
                u.d dVar4 = cVar12.f12055d;
                int i18 = i10 + 1;
                boolean a12 = a(dVar4);
                u.c cVar13 = dVar4.L;
                if (dVar4.w() && a12) {
                    u.e.Q(dVar4, eVar, new b());
                }
                if (dVar4.f12087o0[1] != 3 || a12) {
                    if (!dVar4.w() && cVar12 == cVar13) {
                        int e12 = cVar12.e() + d11;
                        if (dVar4.D) {
                            int i19 = e12 - dVar4.Z;
                            int i20 = dVar4.U + i19;
                            dVar4.Y = i19;
                            dVar4.I.l(i19);
                            dVar4.K.l(i20);
                            cVar13.l(e12);
                            dVar4.f12078k = true;
                        }
                        i(i18, dVar4, eVar);
                    }
                }
            }
        }
        dVar.f12082m = true;
    }
}
