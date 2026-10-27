package u;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends i {

    /* renamed from: r0, reason: collision with root package name */
    public int f12032r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f12033s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f12034t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f12035u0;

    public final boolean O() {
        int i10;
        int i11;
        int i12;
        boolean z10 = true;
        int i13 = 0;
        while (true) {
            i10 = this.f12144q0;
            if (i13 >= i10) {
                break;
            }
            d dVar = this.f12143p0[i13];
            if ((this.f12033s0 || dVar.c()) && ((((i11 = this.f12032r0) == 0 || i11 == 1) && !dVar.x()) || (((i12 = this.f12032r0) == 2 || i12 == 3) && !dVar.y()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int i14 = 0;
        boolean z11 = false;
        for (int i15 = 0; i15 < this.f12144q0; i15++) {
            d dVar2 = this.f12143p0[i15];
            if (this.f12033s0 || dVar2.c()) {
                if (!z11) {
                    int i16 = this.f12032r0;
                    if (i16 == 0) {
                        i14 = dVar2.i(2).d();
                    } else if (i16 == 1) {
                        i14 = dVar2.i(4).d();
                    } else if (i16 == 2) {
                        i14 = dVar2.i(3).d();
                    } else if (i16 == 3) {
                        i14 = dVar2.i(5).d();
                    }
                    z11 = true;
                }
                int i17 = this.f12032r0;
                if (i17 == 0) {
                    i14 = Math.min(i14, dVar2.i(2).d());
                } else if (i17 == 1) {
                    i14 = Math.max(i14, dVar2.i(4).d());
                } else if (i17 == 2) {
                    i14 = Math.min(i14, dVar2.i(3).d());
                } else if (i17 == 3) {
                    i14 = Math.max(i14, dVar2.i(5).d());
                }
            }
        }
        int i18 = i14 + this.f12034t0;
        int i19 = this.f12032r0;
        if (i19 == 0 || i19 == 1) {
            E(i18, i18);
        } else {
            F(i18, i18);
        }
        this.f12035u0 = true;
        return true;
    }

    public final int P() {
        int i10 = this.f12032r0;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    @Override // u.d
    public final void b(s.c cVar, boolean z10) {
        boolean z11;
        int i10;
        int i11;
        c[] cVarArr = this.P;
        c cVar2 = this.H;
        cVarArr[0] = cVar2;
        int i12 = 2;
        c cVar3 = this.I;
        cVarArr[2] = cVar3;
        c cVar4 = this.J;
        cVarArr[1] = cVar4;
        c cVar5 = this.K;
        cVarArr[3] = cVar5;
        for (c cVar6 : cVarArr) {
            cVar6.f12059i = cVar.k(cVar6);
        }
        int i13 = this.f12032r0;
        if (i13 < 0 || i13 >= 4) {
            return;
        }
        c cVar7 = cVarArr[i13];
        if (!this.f12035u0) {
            O();
        }
        if (this.f12035u0) {
            this.f12035u0 = false;
            int i14 = this.f12032r0;
            if (i14 == 0 || i14 == 1) {
                cVar.d(cVar2.f12059i, this.X);
                cVar.d(cVar4.f12059i, this.X);
                return;
            } else {
                if (i14 == 2 || i14 == 3) {
                    cVar.d(cVar3.f12059i, this.Y);
                    cVar.d(cVar5.f12059i, this.Y);
                    return;
                }
                return;
            }
        }
        for (int i15 = 0; i15 < this.f12144q0; i15++) {
            d dVar = this.f12143p0[i15];
            if ((this.f12033s0 || dVar.c()) && ((((i11 = this.f12032r0) == 0 || i11 == 1) && dVar.f12087o0[0] == 3 && dVar.H.f12057f != null && dVar.J.f12057f != null) || ((i11 == 2 || i11 == 3) && dVar.f12087o0[1] == 3 && dVar.I.f12057f != null && dVar.K.f12057f != null))) {
                z11 = true;
                break;
            }
        }
        z11 = false;
        boolean z12 = cVar2.g() || cVar4.g();
        boolean z13 = cVar3.g() || cVar5.g();
        int i16 = !(!z11 && (((i10 = this.f12032r0) == 0 && z12) || ((i10 == 2 && z13) || ((i10 == 1 && z12) || (i10 == 3 && z13))))) ? 4 : 5;
        int i17 = 0;
        while (i17 < this.f12144q0) {
            d dVar2 = this.f12143p0[i17];
            if (this.f12033s0 || dVar2.c()) {
                s.f k10 = cVar.k(dVar2.P[this.f12032r0]);
                c[] cVarArr2 = dVar2.P;
                int i18 = this.f12032r0;
                c cVar8 = cVarArr2[i18];
                cVar8.f12059i = k10;
                c cVar9 = cVar8.f12057f;
                int i19 = (cVar9 == null || cVar9.f12055d != this) ? 0 : cVar8.g;
                if (i18 == 0 || i18 == i12) {
                    s.f fVar = cVar7.f12059i;
                    int i20 = this.f12034t0 - i19;
                    s.b l10 = cVar.l();
                    s.f m10 = cVar.m();
                    m10.f11133r = 0;
                    l10.c(fVar, k10, m10, i20);
                    cVar.c(l10);
                } else {
                    s.f fVar2 = cVar7.f12059i;
                    int i21 = this.f12034t0 + i19;
                    s.b l11 = cVar.l();
                    s.f m11 = cVar.m();
                    m11.f11133r = 0;
                    l11.b(fVar2, k10, m11, i21);
                    cVar.c(l11);
                }
                cVar.e(cVar7.f12059i, k10, this.f12034t0 + i19, i16);
            }
            i17++;
            i12 = 2;
        }
        int i22 = this.f12032r0;
        if (i22 == 0) {
            cVar.e(cVar4.f12059i, cVar2.f12059i, 0, 8);
            cVar.e(cVar2.f12059i, this.S.J.f12059i, 0, 4);
            cVar.e(cVar2.f12059i, this.S.H.f12059i, 0, 0);
            return;
        }
        if (i22 == 1) {
            cVar.e(cVar2.f12059i, cVar4.f12059i, 0, 8);
            cVar.e(cVar2.f12059i, this.S.H.f12059i, 0, 4);
            cVar.e(cVar2.f12059i, this.S.J.f12059i, 0, 0);
        } else if (i22 == 2) {
            cVar.e(cVar5.f12059i, cVar3.f12059i, 0, 8);
            cVar.e(cVar3.f12059i, this.S.K.f12059i, 0, 4);
            cVar.e(cVar3.f12059i, this.S.I.f12059i, 0, 0);
        } else if (i22 == 3) {
            cVar.e(cVar3.f12059i, cVar5.f12059i, 0, 8);
            cVar.e(cVar3.f12059i, this.S.I.f12059i, 0, 4);
            cVar.e(cVar3.f12059i, this.S.K.f12059i, 0, 0);
        }
    }

    @Override // u.d
    public final boolean c() {
        return true;
    }

    @Override // u.d
    public final String toString() {
        String r2 = android.support.v4.media.d.r(new StringBuilder("[Barrier] "), this.f12072g0, " {");
        for (int i10 = 0; i10 < this.f12144q0; i10++) {
            d dVar = this.f12143p0[i10];
            if (i10 > 0) {
                r2 = r.a.c(r2, ", ");
            }
            r2 = r2 + dVar.f12072g0;
        }
        return r.a.c(r2, "}");
    }

    @Override // u.d
    public final boolean x() {
        return this.f12035u0;
    }

    @Override // u.d
    public final boolean y() {
        return this.f12035u0;
    }
}
