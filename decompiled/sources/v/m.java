package v;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m extends o {

    /* renamed from: k, reason: collision with root package name */
    public f f12614k;

    /* renamed from: l, reason: collision with root package name */
    public a f12615l;

    @Override // v.d
    public final void a(d dVar) {
        float f10;
        float f11;
        float f12;
        int i10;
        if (s.e.b(this.f12630j) == 3) {
            u.d dVar2 = this.f12623b;
            l(dVar2.I, dVar2.K, 1);
            return;
        }
        g gVar = this.f12626e;
        if (gVar.f12600c && !gVar.f12606j && this.f12625d == 3) {
            u.d dVar3 = this.f12623b;
            int i11 = dVar3.f12090r;
            if (i11 == 2) {
                u.d dVar4 = dVar3.S;
                if (dVar4 != null) {
                    if (dVar4.f12068e.f12626e.f12606j) {
                        gVar.d((int) ((r5.g * dVar3.f12097y) + 0.5f));
                    }
                }
            } else if (i11 == 3) {
                g gVar2 = dVar3.f12066d.f12626e;
                if (gVar2.f12606j) {
                    int i12 = dVar3.W;
                    if (i12 == -1) {
                        f10 = gVar2.g;
                        f11 = dVar3.V;
                    } else if (i12 == 0) {
                        f12 = gVar2.g * dVar3.V;
                        i10 = (int) (f12 + 0.5f);
                        gVar.d(i10);
                    } else if (i12 != 1) {
                        i10 = 0;
                        gVar.d(i10);
                    } else {
                        f10 = gVar2.g;
                        f11 = dVar3.V;
                    }
                    f12 = f10 / f11;
                    i10 = (int) (f12 + 0.5f);
                    gVar.d(i10);
                }
            }
        }
        f fVar = this.f12628h;
        boolean z10 = fVar.f12600c;
        ArrayList arrayList = fVar.f12608l;
        if (z10) {
            f fVar2 = this.f12629i;
            boolean z11 = fVar2.f12600c;
            ArrayList arrayList2 = fVar2.f12608l;
            if (z11) {
                if (fVar.f12606j && fVar2.f12606j && gVar.f12606j) {
                    return;
                }
                if (!gVar.f12606j && this.f12625d == 3) {
                    u.d dVar5 = this.f12623b;
                    if (dVar5.f12089q == 0 && !dVar5.v()) {
                        f fVar3 = (f) arrayList.get(0);
                        f fVar4 = (f) arrayList2.get(0);
                        int i13 = fVar3.g + fVar.f12603f;
                        int i14 = fVar4.g + fVar2.f12603f;
                        fVar.d(i13);
                        fVar2.d(i14);
                        gVar.d(i14 - i13);
                        return;
                    }
                }
                if (!gVar.f12606j && this.f12625d == 3 && this.f12622a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    f fVar5 = (f) arrayList.get(0);
                    int i15 = (((f) arrayList2.get(0)).g + fVar2.f12603f) - (fVar5.g + fVar.f12603f);
                    int i16 = gVar.f12609m;
                    if (i15 < i16) {
                        gVar.d(i15);
                    } else {
                        gVar.d(i16);
                    }
                }
                if (gVar.f12606j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    f fVar6 = (f) arrayList.get(0);
                    f fVar7 = (f) arrayList2.get(0);
                    int i17 = fVar6.g;
                    int i18 = fVar.f12603f + i17;
                    int i19 = fVar7.g;
                    int i20 = fVar2.f12603f + i19;
                    float f13 = this.f12623b.f12067d0;
                    if (fVar6 == fVar7) {
                        f13 = 0.5f;
                    } else {
                        i17 = i18;
                        i19 = i20;
                    }
                    fVar.d((int) ((((i19 - i17) - gVar.g) * f13) + i17 + 0.5f));
                    fVar2.d(fVar.g + gVar.g);
                }
            }
        }
    }

    @Override // v.o
    public final void d() {
        u.d dVar;
        u.d dVar2;
        u.d dVar3;
        u.d dVar4;
        f fVar = this.f12614k;
        u.d dVar5 = this.f12623b;
        boolean z10 = dVar5.f12060a;
        g gVar = this.f12626e;
        if (z10) {
            gVar.d(dVar5.k());
        }
        boolean z11 = gVar.f12606j;
        ArrayList arrayList = gVar.f12607k;
        ArrayList arrayList2 = gVar.f12608l;
        f fVar2 = this.f12629i;
        f fVar3 = this.f12628h;
        if (!z11) {
            u.d dVar6 = this.f12623b;
            this.f12625d = dVar6.f12087o0[1];
            if (dVar6.D) {
                this.f12615l = new a(this);
            }
            int i10 = this.f12625d;
            if (i10 != 3) {
                if (i10 == 4 && (dVar4 = this.f12623b.S) != null && dVar4.f12087o0[1] == 1) {
                    int k10 = (dVar4.k() - this.f12623b.I.e()) - this.f12623b.K.e();
                    o.b(fVar3, dVar4.f12068e.f12628h, this.f12623b.I.e());
                    o.b(fVar2, dVar4.f12068e.f12629i, -this.f12623b.K.e());
                    gVar.d(k10);
                    return;
                }
                if (i10 == 1) {
                    gVar.d(this.f12623b.k());
                }
            }
        } else if (this.f12625d == 4 && (dVar2 = (dVar = this.f12623b).S) != null && dVar2.f12087o0[1] == 1) {
            o.b(fVar3, dVar2.f12068e.f12628h, dVar.I.e());
            o.b(fVar2, dVar2.f12068e.f12629i, -this.f12623b.K.e());
            return;
        }
        boolean z12 = gVar.f12606j;
        if (z12) {
            u.d dVar7 = this.f12623b;
            if (dVar7.f12060a) {
                u.c[] cVarArr = dVar7.P;
                u.c cVar = cVarArr[2];
                u.c cVar2 = cVar.f12057f;
                if (cVar2 != null && cVarArr[3].f12057f != null) {
                    if (dVar7.v()) {
                        fVar3.f12603f = this.f12623b.P[2].e();
                        fVar2.f12603f = -this.f12623b.P[3].e();
                    } else {
                        f h10 = o.h(this.f12623b.P[2]);
                        if (h10 != null) {
                            o.b(fVar3, h10, this.f12623b.P[2].e());
                        }
                        f h11 = o.h(this.f12623b.P[3]);
                        if (h11 != null) {
                            o.b(fVar2, h11, -this.f12623b.P[3].e());
                        }
                        fVar3.f12599b = true;
                        fVar2.f12599b = true;
                    }
                    u.d dVar8 = this.f12623b;
                    if (dVar8.D) {
                        o.b(fVar, fVar3, dVar8.Z);
                        return;
                    }
                    return;
                }
                if (cVar2 != null) {
                    f h12 = o.h(cVar);
                    if (h12 != null) {
                        o.b(fVar3, h12, this.f12623b.P[2].e());
                        o.b(fVar2, fVar3, gVar.g);
                        u.d dVar9 = this.f12623b;
                        if (dVar9.D) {
                            o.b(fVar, fVar3, dVar9.Z);
                            return;
                        }
                        return;
                    }
                    return;
                }
                u.c cVar3 = cVarArr[3];
                if (cVar3.f12057f != null) {
                    f h13 = o.h(cVar3);
                    if (h13 != null) {
                        o.b(fVar2, h13, -this.f12623b.P[3].e());
                        o.b(fVar3, fVar2, -gVar.g);
                    }
                    u.d dVar10 = this.f12623b;
                    if (dVar10.D) {
                        o.b(fVar, fVar3, dVar10.Z);
                        return;
                    }
                    return;
                }
                u.c cVar4 = cVarArr[4];
                if (cVar4.f12057f != null) {
                    f h14 = o.h(cVar4);
                    if (h14 != null) {
                        o.b(fVar, h14, 0);
                        o.b(fVar3, fVar, -this.f12623b.Z);
                        o.b(fVar2, fVar3, gVar.g);
                        return;
                    }
                    return;
                }
                if ((dVar7 instanceof u.i) || dVar7.S == null || dVar7.i(7).f12057f != null) {
                    return;
                }
                u.d dVar11 = this.f12623b;
                o.b(fVar3, dVar11.S.f12068e.f12628h, dVar11.p());
                o.b(fVar2, fVar3, gVar.g);
                u.d dVar12 = this.f12623b;
                if (dVar12.D) {
                    o.b(fVar, fVar3, dVar12.Z);
                    return;
                }
                return;
            }
        }
        if (z12 || this.f12625d != 3) {
            gVar.b(this);
        } else {
            u.d dVar13 = this.f12623b;
            int i11 = dVar13.f12090r;
            if (i11 == 2) {
                u.d dVar14 = dVar13.S;
                if (dVar14 != null) {
                    g gVar2 = dVar14.f12068e.f12626e;
                    arrayList2.add(gVar2);
                    gVar2.f12607k.add(gVar);
                    gVar.f12599b = true;
                    arrayList.add(fVar3);
                    arrayList.add(fVar2);
                }
            } else if (i11 == 3 && !dVar13.v()) {
                u.d dVar15 = this.f12623b;
                if (dVar15.f12089q != 3) {
                    g gVar3 = dVar15.f12066d.f12626e;
                    arrayList2.add(gVar3);
                    gVar3.f12607k.add(gVar);
                    gVar.f12599b = true;
                    arrayList.add(fVar3);
                    arrayList.add(fVar2);
                }
            }
        }
        u.d dVar16 = this.f12623b;
        u.c[] cVarArr2 = dVar16.P;
        u.c cVar5 = cVarArr2[2];
        u.c cVar6 = cVar5.f12057f;
        if (cVar6 != null && cVarArr2[3].f12057f != null) {
            if (dVar16.v()) {
                fVar3.f12603f = this.f12623b.P[2].e();
                fVar2.f12603f = -this.f12623b.P[3].e();
            } else {
                f h15 = o.h(this.f12623b.P[2]);
                f h16 = o.h(this.f12623b.P[3]);
                if (h15 != null) {
                    h15.b(this);
                }
                if (h16 != null) {
                    h16.b(this);
                }
                this.f12630j = 4;
            }
            if (this.f12623b.D) {
                c(fVar, fVar3, 1, this.f12615l);
            }
        } else if (cVar6 != null) {
            f h17 = o.h(cVar5);
            if (h17 != null) {
                o.b(fVar3, h17, this.f12623b.P[2].e());
                c(fVar2, fVar3, 1, gVar);
                if (this.f12623b.D) {
                    c(fVar, fVar3, 1, this.f12615l);
                }
                if (this.f12625d == 3) {
                    u.d dVar17 = this.f12623b;
                    if (dVar17.V > 0.0f) {
                        k kVar = dVar17.f12066d;
                        if (kVar.f12625d == 3) {
                            kVar.f12626e.f12607k.add(gVar);
                            arrayList2.add(this.f12623b.f12066d.f12626e);
                            gVar.f12598a = this;
                        }
                    }
                }
            }
        } else {
            u.c cVar7 = cVarArr2[3];
            if (cVar7.f12057f != null) {
                f h18 = o.h(cVar7);
                if (h18 != null) {
                    o.b(fVar2, h18, -this.f12623b.P[3].e());
                    c(fVar3, fVar2, -1, gVar);
                    if (this.f12623b.D) {
                        c(fVar, fVar3, 1, this.f12615l);
                    }
                }
            } else {
                u.c cVar8 = cVarArr2[4];
                if (cVar8.f12057f != null) {
                    f h19 = o.h(cVar8);
                    if (h19 != null) {
                        o.b(fVar, h19, 0);
                        c(fVar3, fVar, -1, this.f12615l);
                        c(fVar2, fVar3, 1, gVar);
                    }
                } else if (!(dVar16 instanceof u.i) && (dVar3 = dVar16.S) != null) {
                    o.b(fVar3, dVar3.f12068e.f12628h, dVar16.p());
                    c(fVar2, fVar3, 1, gVar);
                    if (this.f12623b.D) {
                        c(fVar, fVar3, 1, this.f12615l);
                    }
                    if (this.f12625d == 3) {
                        u.d dVar18 = this.f12623b;
                        if (dVar18.V > 0.0f) {
                            k kVar2 = dVar18.f12066d;
                            if (kVar2.f12625d == 3) {
                                kVar2.f12626e.f12607k.add(gVar);
                                arrayList2.add(this.f12623b.f12066d.f12626e);
                                gVar.f12598a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            gVar.f12600c = true;
        }
    }

    @Override // v.o
    public final void e() {
        f fVar = this.f12628h;
        if (fVar.f12606j) {
            this.f12623b.Y = fVar.g;
        }
    }

    @Override // v.o
    public final void f() {
        this.f12624c = null;
        this.f12628h.c();
        this.f12629i.c();
        this.f12614k.c();
        this.f12626e.c();
        this.g = false;
    }

    @Override // v.o
    public final boolean k() {
        return this.f12625d != 3 || this.f12623b.f12090r == 0;
    }

    public final void m() {
        this.g = false;
        f fVar = this.f12628h;
        fVar.c();
        fVar.f12606j = false;
        f fVar2 = this.f12629i;
        fVar2.c();
        fVar2.f12606j = false;
        f fVar3 = this.f12614k;
        fVar3.c();
        fVar3.f12606j = false;
        this.f12626e.f12606j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f12623b.f12072g0;
    }
}
