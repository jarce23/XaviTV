package u;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends i {
    public v.b A0;
    public x.e B0;
    public int C0;
    public int D0;
    public int E0;
    public int F0;
    public int G0;
    public int H0;
    public float I0;
    public float J0;
    public float K0;
    public float L0;
    public float M0;
    public float N0;
    public int O0;
    public int P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public int U0;
    public ArrayList V0;
    public d[] W0;
    public d[] X0;
    public int[] Y0;
    public d[] Z0;

    /* renamed from: a1, reason: collision with root package name */
    public int f12127a1;

    /* renamed from: r0, reason: collision with root package name */
    public int f12128r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f12129s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f12130t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f12131u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f12132v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f12133w0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f12134x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f12135y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f12136z0;

    @Override // u.i
    public final void N() {
        for (int i10 = 0; i10 < this.f12144q0; i10++) {
            d dVar = this.f12143p0[i10];
            if (dVar != null) {
                dVar.E = true;
            }
        }
    }

    public final int O(d dVar, int i10) {
        d dVar2;
        if (dVar != null) {
            int[] iArr = dVar.f12087o0;
            if (iArr[1] == 3) {
                int i11 = dVar.f12090r;
                if (i11 != 0) {
                    if (i11 == 2) {
                        int i12 = (int) (dVar.f12097y * i10);
                        if (i12 != dVar.k()) {
                            dVar.g = true;
                            Q(iArr[0], dVar.n(), 1, i12, dVar);
                        }
                        return i12;
                    }
                    dVar2 = dVar;
                    if (i11 == 1) {
                        return dVar2.k();
                    }
                    if (i11 == 3) {
                        return (int) ((dVar2.n() * dVar2.V) + 0.5f);
                    }
                }
            } else {
                dVar2 = dVar;
            }
            return dVar2.k();
        }
        return 0;
    }

    public final int P(d dVar, int i10) {
        d dVar2;
        if (dVar != null) {
            int[] iArr = dVar.f12087o0;
            if (iArr[0] == 3) {
                int i11 = dVar.f12089q;
                if (i11 != 0) {
                    if (i11 == 2) {
                        int i12 = (int) (dVar.f12094v * i10);
                        if (i12 != dVar.n()) {
                            dVar.g = true;
                            Q(1, i12, iArr[1], dVar.k(), dVar);
                        }
                        return i12;
                    }
                    dVar2 = dVar;
                    if (i11 == 1) {
                        return dVar2.n();
                    }
                    if (i11 == 3) {
                        return (int) ((dVar2.k() * dVar2.V) + 0.5f);
                    }
                }
            } else {
                dVar2 = dVar;
            }
            return dVar2.n();
        }
        return 0;
    }

    public final void Q(int i10, int i11, int i12, int i13, d dVar) {
        x.e eVar;
        d dVar2;
        v.b bVar = this.A0;
        while (true) {
            eVar = this.B0;
            if (eVar != null || (dVar2 = this.S) == null) {
                break;
            } else {
                this.B0 = ((e) dVar2).f12103t0;
            }
        }
        bVar.f12580a = i10;
        bVar.f12581b = i12;
        bVar.f12582c = i11;
        bVar.f12583d = i13;
        eVar.b(dVar, bVar);
        dVar.J(bVar.f12584e);
        dVar.G(bVar.f12585f);
        dVar.D = bVar.f12586h;
        dVar.D(bVar.g);
    }

    @Override // u.d
    public final void b(s.c cVar, boolean z10) {
        d dVar;
        float f10;
        int i10;
        ArrayList arrayList = this.V0;
        super.b(cVar, z10);
        d dVar2 = this.S;
        boolean z11 = dVar2 != null && ((e) dVar2).f12104u0;
        int i11 = this.S0;
        if (i11 != 0) {
            if (i11 == 1) {
                int size = arrayList.size();
                int i12 = 0;
                while (i12 < size) {
                    ((f) arrayList.get(i12)).b(i12, z11, i12 == size + (-1));
                    i12++;
                }
            } else if (i11 == 2 && this.Y0 != null && this.X0 != null && this.W0 != null) {
                for (int i13 = 0; i13 < this.f12127a1; i13++) {
                    this.Z0[i13].A();
                }
                int[] iArr = this.Y0;
                int i14 = iArr[0];
                int i15 = iArr[1];
                float f11 = this.I0;
                d dVar3 = null;
                int i16 = 0;
                while (i16 < i14) {
                    if (z11) {
                        i10 = (i14 - i16) - 1;
                        f10 = 1.0f - this.I0;
                    } else {
                        f10 = f11;
                        i10 = i16;
                    }
                    d dVar4 = this.X0[i10];
                    if (dVar4 != null) {
                        c cVar2 = dVar4.H;
                        if (dVar4.f12071f0 != 8) {
                            if (i16 == 0) {
                                dVar4.f(cVar2, this.H, this.f12132v0);
                                dVar4.h0 = this.C0;
                                dVar4.f12065c0 = f10;
                            }
                            if (i16 == i14 - 1) {
                                dVar4.f(dVar4.J, this.J, this.f12133w0);
                            }
                            if (i16 > 0 && dVar3 != null) {
                                c cVar3 = dVar3.J;
                                dVar4.f(cVar2, cVar3, this.O0);
                                dVar3.f(cVar3, cVar2, 0);
                            }
                            dVar3 = dVar4;
                        }
                    }
                    i16++;
                    f11 = f10;
                }
                for (int i17 = 0; i17 < i15; i17++) {
                    d dVar5 = this.W0[i17];
                    if (dVar5 != null) {
                        c cVar4 = dVar5.I;
                        if (dVar5.f12071f0 != 8) {
                            if (i17 == 0) {
                                dVar5.f(cVar4, this.I, this.f12128r0);
                                dVar5.f12075i0 = this.D0;
                                dVar5.f12067d0 = this.J0;
                            }
                            if (i17 == i15 - 1) {
                                dVar5.f(dVar5.K, this.K, this.f12129s0);
                            }
                            if (i17 > 0 && dVar3 != null) {
                                c cVar5 = dVar3.K;
                                dVar5.f(cVar4, cVar5, this.P0);
                                dVar3.f(cVar5, cVar4, 0);
                            }
                            dVar3 = dVar5;
                        }
                    }
                }
                for (int i18 = 0; i18 < i14; i18++) {
                    for (int i19 = 0; i19 < i15; i19++) {
                        int i20 = (i19 * i14) + i18;
                        if (this.U0 == 1) {
                            i20 = (i18 * i15) + i19;
                        }
                        d[] dVarArr = this.Z0;
                        if (i20 < dVarArr.length && (dVar = dVarArr[i20]) != null && dVar.f12071f0 != 8) {
                            d dVar6 = this.X0[i18];
                            d dVar7 = this.W0[i19];
                            if (dVar != dVar6) {
                                dVar.f(dVar.H, dVar6.H, 0);
                                dVar.f(dVar.J, dVar6.J, 0);
                            }
                            if (dVar != dVar7) {
                                dVar.f(dVar.I, dVar7.I, 0);
                                dVar.f(dVar.K, dVar7.K, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((f) arrayList.get(0)).b(0, z11, true);
        }
        this.f12134x0 = false;
    }
}
