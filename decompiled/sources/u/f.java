package u;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f12110a;

    /* renamed from: d, reason: collision with root package name */
    public c f12113d;

    /* renamed from: e, reason: collision with root package name */
    public c f12114e;

    /* renamed from: f, reason: collision with root package name */
    public c f12115f;
    public c g;

    /* renamed from: h, reason: collision with root package name */
    public int f12116h;

    /* renamed from: i, reason: collision with root package name */
    public int f12117i;

    /* renamed from: j, reason: collision with root package name */
    public int f12118j;

    /* renamed from: k, reason: collision with root package name */
    public int f12119k;

    /* renamed from: q, reason: collision with root package name */
    public int f12125q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ g f12126r;

    /* renamed from: b, reason: collision with root package name */
    public d f12111b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f12112c = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f12120l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f12121m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f12122n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f12123o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f12124p = 0;

    public f(g gVar, int i10, c cVar, c cVar2, c cVar3, c cVar4, int i11) {
        this.f12126r = gVar;
        this.f12110a = i10;
        this.f12113d = cVar;
        this.f12114e = cVar2;
        this.f12115f = cVar3;
        this.g = cVar4;
        this.f12116h = gVar.f12132v0;
        this.f12117i = gVar.f12128r0;
        this.f12118j = gVar.f12133w0;
        this.f12119k = gVar.f12129s0;
        this.f12125q = i11;
    }

    public final void a(d dVar) {
        int i10 = this.f12110a;
        g gVar = this.f12126r;
        if (i10 == 0) {
            int P = gVar.P(dVar, this.f12125q);
            if (dVar.f12087o0[0] == 3) {
                this.f12124p++;
                P = 0;
            }
            this.f12120l = P + (dVar.f12071f0 != 8 ? gVar.O0 : 0) + this.f12120l;
            int O = gVar.O(dVar, this.f12125q);
            if (this.f12111b == null || this.f12112c < O) {
                this.f12111b = dVar;
                this.f12112c = O;
                this.f12121m = O;
            }
        } else {
            int P2 = gVar.P(dVar, this.f12125q);
            int O2 = gVar.O(dVar, this.f12125q);
            if (dVar.f12087o0[1] == 3) {
                this.f12124p++;
                O2 = 0;
            }
            this.f12121m = O2 + (dVar.f12071f0 != 8 ? gVar.P0 : 0) + this.f12121m;
            if (this.f12111b == null || this.f12112c < P2) {
                this.f12111b = dVar;
                this.f12112c = P2;
                this.f12120l = P2;
            }
        }
        this.f12123o++;
    }

    public final void b(int i10, boolean z10, boolean z11) {
        g gVar;
        int i11;
        int i12;
        d dVar;
        char c10;
        int i13;
        int i14;
        int i15;
        int i16 = this.f12123o;
        int i17 = 0;
        while (true) {
            gVar = this.f12126r;
            if (i17 >= i16 || (i15 = this.f12122n + i17) >= gVar.f12127a1) {
                break;
            }
            d dVar2 = gVar.Z0[i15];
            if (dVar2 != null) {
                dVar2.A();
            }
            i17++;
        }
        if (i16 == 0 || this.f12111b == null) {
            return;
        }
        boolean z12 = z11 && i10 == 0;
        int i18 = -1;
        int i19 = -1;
        for (int i20 = 0; i20 < i16; i20++) {
            int i21 = this.f12122n + (z10 ? (i16 - 1) - i20 : i20);
            if (i21 >= gVar.f12127a1) {
                break;
            }
            if (gVar.Z0[i21].f12071f0 == 0) {
                if (i18 == -1) {
                    i18 = i20;
                }
                i19 = i20;
            }
        }
        if (this.f12110a != 0) {
            d dVar3 = this.f12111b;
            dVar3.h0 = gVar.C0;
            c cVar = dVar3.H;
            c cVar2 = dVar3.J;
            int i22 = this.f12116h;
            if (i10 > 0) {
                i22 += gVar.O0;
            }
            if (z10) {
                cVar2.a(this.f12115f, i22);
                if (z11) {
                    cVar.a(this.f12113d, this.f12118j);
                }
                if (i10 > 0) {
                    this.f12115f.f12055d.H.a(cVar2, 0);
                }
            } else {
                cVar.a(this.f12113d, i22);
                if (z11) {
                    cVar2.a(this.f12115f, this.f12118j);
                }
                if (i10 > 0) {
                    this.f12113d.f12055d.J.a(cVar, 0);
                }
            }
            d dVar4 = null;
            int i23 = 0;
            while (i23 < i16) {
                int i24 = this.f12122n + i23;
                if (i24 >= gVar.f12127a1) {
                    return;
                }
                d dVar5 = gVar.Z0[i24];
                if (i23 == 0) {
                    dVar5.f(dVar5.I, this.f12114e, this.f12117i);
                    int i25 = gVar.D0;
                    float f10 = gVar.J0;
                    if (this.f12122n == 0) {
                        i12 = gVar.F0;
                        i11 = -1;
                        if (i12 != -1) {
                            f10 = gVar.L0;
                            i25 = i12;
                            dVar5.f12075i0 = i25;
                            dVar5.f12067d0 = f10;
                        }
                    } else {
                        i11 = -1;
                    }
                    if (z11 && (i12 = gVar.H0) != i11) {
                        f10 = gVar.N0;
                        i25 = i12;
                    }
                    dVar5.f12075i0 = i25;
                    dVar5.f12067d0 = f10;
                }
                if (i23 == i16 - 1) {
                    dVar5.f(dVar5.K, this.g, this.f12119k);
                }
                if (dVar4 != null) {
                    c cVar3 = dVar4.K;
                    c cVar4 = dVar5.I;
                    cVar4.a(cVar3, gVar.P0);
                    if (i23 == i18) {
                        int i26 = this.f12117i;
                        if (cVar4.h()) {
                            cVar4.f12058h = i26;
                        }
                    }
                    cVar3.a(cVar4, 0);
                    if (i23 == i19 + 1) {
                        int i27 = this.f12119k;
                        if (cVar3.h()) {
                            cVar3.f12058h = i27;
                        }
                    }
                }
                if (dVar5 != dVar3) {
                    if (z10) {
                        int i28 = gVar.Q0;
                        if (i28 == 0) {
                            dVar5.J.a(cVar2, 0);
                        } else if (i28 == 1) {
                            dVar5.H.a(cVar, 0);
                        } else if (i28 == 2) {
                            dVar5.H.a(cVar, 0);
                            dVar5.J.a(cVar2, 0);
                        }
                    } else {
                        int i29 = gVar.Q0;
                        if (i29 == 0) {
                            dVar5.H.a(cVar, 0);
                        } else if (i29 == 1) {
                            dVar5.J.a(cVar2, 0);
                        } else if (i29 == 2) {
                            if (z12) {
                                dVar5.H.a(this.f12113d, this.f12116h);
                                dVar5.J.a(this.f12115f, this.f12118j);
                            } else {
                                dVar5.H.a(cVar, 0);
                                dVar5.J.a(cVar2, 0);
                            }
                        }
                        i23++;
                        dVar4 = dVar5;
                    }
                }
                i23++;
                dVar4 = dVar5;
            }
            return;
        }
        d dVar6 = this.f12111b;
        dVar6.f12075i0 = gVar.D0;
        c cVar5 = dVar6.K;
        c cVar6 = dVar6.I;
        int i30 = this.f12117i;
        if (i10 > 0) {
            i30 += gVar.P0;
        }
        cVar6.a(this.f12114e, i30);
        if (z11) {
            cVar5.a(this.g, this.f12119k);
        }
        if (i10 > 0) {
            this.f12114e.f12055d.K.a(cVar6, 0);
        }
        if (gVar.R0 == 3 && !dVar6.D) {
            for (int i31 = 0; i31 < i16; i31++) {
                int i32 = this.f12122n + (z10 ? (i16 - 1) - i31 : i31);
                if (i32 >= gVar.f12127a1) {
                    break;
                }
                dVar = gVar.Z0[i32];
                if (dVar.D) {
                    break;
                }
            }
        }
        dVar = dVar6;
        int i33 = 0;
        d dVar7 = null;
        while (i33 < i16) {
            int i34 = z10 ? (i16 - 1) - i33 : i33;
            int i35 = this.f12122n + i34;
            if (i35 >= gVar.f12127a1) {
                return;
            }
            d dVar8 = gVar.Z0[i35];
            if (i33 == 0) {
                dVar8.f(dVar8.H, this.f12113d, this.f12116h);
            }
            if (i34 == 0) {
                int i36 = gVar.C0;
                float f11 = z10 ? 1.0f - gVar.I0 : gVar.I0;
                if (this.f12122n == 0) {
                    int i37 = gVar.E0;
                    i13 = i36;
                    if (i37 != -1) {
                        f11 = z10 ? 1.0f - gVar.K0 : gVar.K0;
                        i14 = i37;
                        dVar8.h0 = i14;
                        dVar8.f12065c0 = f11;
                    }
                } else {
                    i13 = i36;
                }
                if (!z11 || (i14 = gVar.G0) == -1) {
                    i14 = i13;
                } else {
                    f11 = z10 ? 1.0f - gVar.M0 : gVar.M0;
                }
                dVar8.h0 = i14;
                dVar8.f12065c0 = f11;
            }
            if (i33 == i16 - 1) {
                dVar8.f(dVar8.J, this.f12115f, this.f12118j);
            }
            if (dVar7 != null) {
                c cVar7 = dVar7.J;
                c cVar8 = dVar8.H;
                cVar8.a(cVar7, gVar.O0);
                if (i33 == i18) {
                    int i38 = this.f12116h;
                    if (cVar8.h()) {
                        cVar8.f12058h = i38;
                    }
                }
                cVar7.a(cVar8, 0);
                if (i33 == i19 + 1) {
                    int i39 = this.f12118j;
                    if (cVar7.h()) {
                        cVar7.f12058h = i39;
                    }
                }
            }
            if (dVar8 != dVar6) {
                int i40 = gVar.R0;
                c10 = 3;
                if (i40 == 3 && dVar.D && dVar8 != dVar && dVar8.D) {
                    dVar8.L.a(dVar.L, 0);
                } else if (i40 == 0) {
                    dVar8.I.a(cVar6, 0);
                } else if (i40 == 1) {
                    dVar8.K.a(cVar5, 0);
                } else if (z12) {
                    dVar8.I.a(this.f12114e, this.f12117i);
                    dVar8.K.a(this.g, this.f12119k);
                } else {
                    dVar8.I.a(cVar6, 0);
                    dVar8.K.a(cVar5, 0);
                }
            } else {
                c10 = 3;
            }
            i33++;
            dVar7 = dVar8;
        }
    }

    public final int c() {
        return this.f12110a == 1 ? this.f12121m - this.f12126r.P0 : this.f12121m;
    }

    public final int d() {
        return this.f12110a == 0 ? this.f12120l - this.f12126r.O0 : this.f12120l;
    }

    public final void e(int i10) {
        g gVar;
        int i11;
        int i12 = this.f12124p;
        if (i12 == 0) {
            return;
        }
        int i13 = this.f12123o;
        int i14 = i10 / i12;
        int i15 = 0;
        while (true) {
            gVar = this.f12126r;
            if (i15 >= i13 || (i11 = this.f12122n + i15) >= gVar.f12127a1) {
                break;
            }
            d dVar = gVar.Z0[i11];
            if (this.f12110a == 0) {
                if (dVar != null) {
                    int[] iArr = dVar.f12087o0;
                    if (iArr[0] == 3 && dVar.f12089q == 0) {
                        gVar.Q(1, i14, iArr[1], dVar.k(), dVar);
                    }
                }
            } else if (dVar != null) {
                int[] iArr2 = dVar.f12087o0;
                if (iArr2[1] == 3 && dVar.f12090r == 0) {
                    int i16 = i14;
                    gVar.Q(iArr2[0], dVar.n(), 1, i16, dVar);
                    i14 = i16;
                }
            }
            i15++;
        }
        this.f12120l = 0;
        this.f12121m = 0;
        this.f12111b = null;
        this.f12112c = 0;
        int i17 = this.f12123o;
        for (int i18 = 0; i18 < i17; i18++) {
            int i19 = this.f12122n + i18;
            if (i19 >= gVar.f12127a1) {
                return;
            }
            d dVar2 = gVar.Z0[i19];
            if (this.f12110a == 0) {
                int n10 = dVar2.n();
                int i20 = gVar.O0;
                if (dVar2.f12071f0 == 8) {
                    i20 = 0;
                }
                this.f12120l = n10 + i20 + this.f12120l;
                int O = gVar.O(dVar2, this.f12125q);
                if (this.f12111b == null || this.f12112c < O) {
                    this.f12111b = dVar2;
                    this.f12112c = O;
                    this.f12121m = O;
                }
            } else {
                int P = gVar.P(dVar2, this.f12125q);
                int O2 = gVar.O(dVar2, this.f12125q);
                int i21 = gVar.P0;
                if (dVar2.f12071f0 == 8) {
                    i21 = 0;
                }
                this.f12121m = O2 + i21 + this.f12121m;
                if (this.f12111b == null || this.f12112c < P) {
                    this.f12111b = dVar2;
                    this.f12112c = P;
                    this.f12120l = P;
                }
            }
        }
    }

    public final void f(int i10, c cVar, c cVar2, c cVar3, c cVar4, int i11, int i12, int i13, int i14, int i15) {
        this.f12110a = i10;
        this.f12113d = cVar;
        this.f12114e = cVar2;
        this.f12115f = cVar3;
        this.g = cVar4;
        this.f12116h = i11;
        this.f12117i = i12;
        this.f12118j = i13;
        this.f12119k = i14;
        this.f12125q = i15;
    }
}
