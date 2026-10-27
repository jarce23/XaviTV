package v;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends o {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f12611k = new int[2];

    public static void m(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 == 0) {
                iArr[0] = (int) ((i16 * f10) + 0.5f);
                iArr[1] = i16;
                return;
            } else {
                if (i14 != 1) {
                    return;
                }
                iArr[0] = i15;
                iArr[1] = (int) ((i15 * f10) + 0.5f);
                return;
            }
        }
        int i17 = (int) ((i16 * f10) + 0.5f);
        int i18 = (int) ((i15 / f10) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x0243, code lost:
    
        if (r5 != 1) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02aa  */
    @Override // v.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(v.d r24) {
        /*
            Method dump skipped, instructions count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.k.a(v.d):void");
    }

    @Override // v.o
    public final void d() {
        u.d dVar;
        u.d dVar2;
        int i10;
        u.d dVar3;
        u.d dVar4;
        int i11;
        u.d dVar5 = this.f12623b;
        boolean z10 = dVar5.f12060a;
        g gVar = this.f12626e;
        if (z10) {
            gVar.d(dVar5.n());
        }
        boolean z11 = gVar.f12606j;
        ArrayList arrayList = gVar.f12607k;
        ArrayList arrayList2 = gVar.f12608l;
        f fVar = this.f12629i;
        f fVar2 = this.f12628h;
        if (!z11) {
            u.d dVar6 = this.f12623b;
            int i12 = dVar6.f12087o0[0];
            this.f12625d = i12;
            if (i12 != 3) {
                if (i12 == 4 && (dVar4 = dVar6.S) != null && ((i11 = dVar4.f12087o0[0]) == 1 || i11 == 4)) {
                    int n10 = (dVar4.n() - this.f12623b.H.e()) - this.f12623b.J.e();
                    o.b(fVar2, dVar4.f12066d.f12628h, this.f12623b.H.e());
                    o.b(fVar, dVar4.f12066d.f12629i, -this.f12623b.J.e());
                    gVar.d(n10);
                    return;
                }
                if (i12 == 1) {
                    gVar.d(dVar6.n());
                }
            }
        } else if (this.f12625d == 4 && (dVar2 = (dVar = this.f12623b).S) != null && ((i10 = dVar2.f12087o0[0]) == 1 || i10 == 4)) {
            o.b(fVar2, dVar2.f12066d.f12628h, dVar.H.e());
            o.b(fVar, dVar2.f12066d.f12629i, -this.f12623b.J.e());
            return;
        }
        if (gVar.f12606j) {
            u.d dVar7 = this.f12623b;
            if (dVar7.f12060a) {
                u.c[] cVarArr = dVar7.P;
                u.c cVar = cVarArr[0];
                u.c cVar2 = cVar.f12057f;
                if (cVar2 != null && cVarArr[1].f12057f != null) {
                    if (dVar7.u()) {
                        fVar2.f12603f = this.f12623b.P[0].e();
                        fVar.f12603f = -this.f12623b.P[1].e();
                        return;
                    }
                    f h10 = o.h(this.f12623b.P[0]);
                    if (h10 != null) {
                        o.b(fVar2, h10, this.f12623b.P[0].e());
                    }
                    f h11 = o.h(this.f12623b.P[1]);
                    if (h11 != null) {
                        o.b(fVar, h11, -this.f12623b.P[1].e());
                    }
                    fVar2.f12599b = true;
                    fVar.f12599b = true;
                    return;
                }
                if (cVar2 != null) {
                    f h12 = o.h(cVar);
                    if (h12 != null) {
                        o.b(fVar2, h12, this.f12623b.P[0].e());
                        o.b(fVar, fVar2, gVar.g);
                        return;
                    }
                    return;
                }
                u.c cVar3 = cVarArr[1];
                if (cVar3.f12057f != null) {
                    f h13 = o.h(cVar3);
                    if (h13 != null) {
                        o.b(fVar, h13, -this.f12623b.P[1].e());
                        o.b(fVar2, fVar, -gVar.g);
                        return;
                    }
                    return;
                }
                if ((dVar7 instanceof u.i) || dVar7.S == null || dVar7.i(7).f12057f != null) {
                    return;
                }
                u.d dVar8 = this.f12623b;
                o.b(fVar2, dVar8.S.f12066d.f12628h, dVar8.o());
                o.b(fVar, fVar2, gVar.g);
                return;
            }
        }
        if (this.f12625d == 3) {
            u.d dVar9 = this.f12623b;
            int i13 = dVar9.f12089q;
            if (i13 == 2) {
                u.d dVar10 = dVar9.S;
                if (dVar10 != null) {
                    g gVar2 = dVar10.f12068e.f12626e;
                    arrayList2.add(gVar2);
                    gVar2.f12607k.add(gVar);
                    gVar.f12599b = true;
                    arrayList.add(fVar2);
                    arrayList.add(fVar);
                }
            } else if (i13 == 3) {
                if (dVar9.f12090r == 3) {
                    fVar2.f12598a = this;
                    fVar.f12598a = this;
                    m mVar = dVar9.f12068e;
                    mVar.f12628h.f12598a = this;
                    mVar.f12629i.f12598a = this;
                    gVar.f12598a = this;
                    if (dVar9.v()) {
                        arrayList2.add(this.f12623b.f12068e.f12626e);
                        this.f12623b.f12068e.f12626e.f12607k.add(gVar);
                        m mVar2 = this.f12623b.f12068e;
                        mVar2.f12626e.f12598a = this;
                        arrayList2.add(mVar2.f12628h);
                        arrayList2.add(this.f12623b.f12068e.f12629i);
                        this.f12623b.f12068e.f12628h.f12607k.add(gVar);
                        this.f12623b.f12068e.f12629i.f12607k.add(gVar);
                    } else if (this.f12623b.u()) {
                        this.f12623b.f12068e.f12626e.f12608l.add(gVar);
                        arrayList.add(this.f12623b.f12068e.f12626e);
                    } else {
                        this.f12623b.f12068e.f12626e.f12608l.add(gVar);
                    }
                } else {
                    g gVar3 = dVar9.f12068e.f12626e;
                    arrayList2.add(gVar3);
                    gVar3.f12607k.add(gVar);
                    this.f12623b.f12068e.f12628h.f12607k.add(gVar);
                    this.f12623b.f12068e.f12629i.f12607k.add(gVar);
                    gVar.f12599b = true;
                    arrayList.add(fVar2);
                    arrayList.add(fVar);
                    fVar2.f12608l.add(gVar);
                    fVar.f12608l.add(gVar);
                }
            }
        }
        u.d dVar11 = this.f12623b;
        u.c[] cVarArr2 = dVar11.P;
        u.c cVar4 = cVarArr2[0];
        u.c cVar5 = cVar4.f12057f;
        if (cVar5 != null && cVarArr2[1].f12057f != null) {
            if (dVar11.u()) {
                fVar2.f12603f = this.f12623b.P[0].e();
                fVar.f12603f = -this.f12623b.P[1].e();
                return;
            }
            f h14 = o.h(this.f12623b.P[0]);
            f h15 = o.h(this.f12623b.P[1]);
            if (h14 != null) {
                h14.b(this);
            }
            if (h15 != null) {
                h15.b(this);
            }
            this.f12630j = 4;
            return;
        }
        if (cVar5 != null) {
            f h16 = o.h(cVar4);
            if (h16 != null) {
                o.b(fVar2, h16, this.f12623b.P[0].e());
                c(fVar, fVar2, 1, gVar);
                return;
            }
            return;
        }
        u.c cVar6 = cVarArr2[1];
        if (cVar6.f12057f != null) {
            f h17 = o.h(cVar6);
            if (h17 != null) {
                o.b(fVar, h17, -this.f12623b.P[1].e());
                c(fVar2, fVar, -1, gVar);
                return;
            }
            return;
        }
        if ((dVar11 instanceof u.i) || (dVar3 = dVar11.S) == null) {
            return;
        }
        o.b(fVar2, dVar3.f12066d.f12628h, dVar11.o());
        c(fVar, fVar2, 1, gVar);
    }

    @Override // v.o
    public final void e() {
        f fVar = this.f12628h;
        if (fVar.f12606j) {
            this.f12623b.X = fVar.g;
        }
    }

    @Override // v.o
    public final void f() {
        this.f12624c = null;
        this.f12628h.c();
        this.f12629i.c();
        this.f12626e.c();
        this.g = false;
    }

    @Override // v.o
    public final boolean k() {
        return this.f12625d != 3 || this.f12623b.f12089q == 0;
    }

    public final void n() {
        this.g = false;
        f fVar = this.f12628h;
        fVar.c();
        fVar.f12606j = false;
        f fVar2 = this.f12629i;
        fVar2.c();
        fVar2.f12606j = false;
        this.f12626e.f12606j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f12623b.f12072g0;
    }
}
