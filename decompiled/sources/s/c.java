package s;

import java.util.Arrays;
import x4.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: p, reason: collision with root package name */
    public static boolean f11110p = false;

    /* renamed from: q, reason: collision with root package name */
    public static int f11111q = 1000;

    /* renamed from: c, reason: collision with root package name */
    public final d f11114c;

    /* renamed from: f, reason: collision with root package name */
    public b[] f11117f;

    /* renamed from: l, reason: collision with root package name */
    public final m f11122l;

    /* renamed from: o, reason: collision with root package name */
    public b f11125o;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11112a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f11113b = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f11115d = 32;

    /* renamed from: e, reason: collision with root package name */
    public int f11116e = 32;
    public boolean g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f11118h = new boolean[32];

    /* renamed from: i, reason: collision with root package name */
    public int f11119i = 1;

    /* renamed from: j, reason: collision with root package name */
    public int f11120j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f11121k = 32;

    /* renamed from: m, reason: collision with root package name */
    public f[] f11123m = new f[f11111q];

    /* renamed from: n, reason: collision with root package name */
    public int f11124n = 0;

    public c() {
        this.f11117f = null;
        this.f11117f = new b[32];
        s();
        m mVar = new m(22);
        mVar.f13564p = new l0.d();
        mVar.f13565q = new l0.d();
        mVar.f13566r = new f[32];
        this.f11122l = mVar;
        d dVar = new d(mVar);
        dVar.f11126f = new f[128];
        dVar.g = new f[128];
        dVar.f11127h = 0;
        dVar.f11128i = new x4.c(dVar);
        this.f11114c = dVar;
        this.f11125o = new b(mVar);
    }

    public static int n(Object obj) {
        f fVar = ((u.c) obj).f12059i;
        if (fVar != null) {
            return (int) (fVar.f11134s + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final f a(int i10) {
        l0.d dVar = (l0.d) this.f11122l.f13565q;
        int i11 = dVar.f8063p;
        f fVar = null;
        if (i11 > 0) {
            int i12 = i11 - 1;
            ?? r32 = dVar.f8062o;
            ?? r42 = r32[i12];
            r32[i12] = 0;
            dVar.f8063p = i12;
            fVar = r42;
        }
        f fVar2 = fVar;
        if (fVar2 == null) {
            fVar2 = new f(i10);
            fVar2.f11141z = i10;
        } else {
            fVar2.c();
            fVar2.f11141z = i10;
        }
        int i13 = this.f11124n;
        int i14 = f11111q;
        if (i13 >= i14) {
            int i15 = i14 * 2;
            f11111q = i15;
            this.f11123m = (f[]) Arrays.copyOf(this.f11123m, i15);
        }
        f[] fVarArr = this.f11123m;
        int i16 = this.f11124n;
        this.f11124n = i16 + 1;
        fVarArr[i16] = fVar2;
        return fVar2;
    }

    public final void b(f fVar, f fVar2, int i10, float f10, f fVar3, f fVar4, int i11, int i12) {
        b l10 = l();
        if (fVar2 == fVar3) {
            l10.f11108d.g(fVar, 1.0f);
            l10.f11108d.g(fVar4, 1.0f);
            l10.f11108d.g(fVar2, -2.0f);
        } else if (f10 == 0.5f) {
            l10.f11108d.g(fVar, 1.0f);
            l10.f11108d.g(fVar2, -1.0f);
            l10.f11108d.g(fVar3, -1.0f);
            l10.f11108d.g(fVar4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                l10.f11106b = (-i10) + i11;
            }
        } else if (f10 <= 0.0f) {
            l10.f11108d.g(fVar, -1.0f);
            l10.f11108d.g(fVar2, 1.0f);
            l10.f11106b = i10;
        } else if (f10 >= 1.0f) {
            l10.f11108d.g(fVar4, -1.0f);
            l10.f11108d.g(fVar3, 1.0f);
            l10.f11106b = -i11;
        } else {
            float f11 = 1.0f - f10;
            l10.f11108d.g(fVar, f11 * 1.0f);
            l10.f11108d.g(fVar2, f11 * (-1.0f));
            l10.f11108d.g(fVar3, (-1.0f) * f10);
            l10.f11108d.g(fVar4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                l10.f11106b = (i11 * f10) + ((-i10) * f11);
            }
        }
        if (i12 != 8) {
            l10.a(this, i12);
        }
        c(l10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d3, code lost:
    
        if (r4.f11140y <= 1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d6, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e0, code lost:
    
        if (r4.f11140y <= 1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00f5, code lost:
    
        if (r4.f11140y <= 1) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f8, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0102, code lost:
    
        if (r4.f11140y <= 1) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(s.b r18) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.c.c(s.b):void");
    }

    public final void d(f fVar, int i10) {
        int i11 = fVar.f11132q;
        if (i11 == -1) {
            fVar.d(this, i10);
            for (int i12 = 0; i12 < this.f11113b + 1; i12++) {
                f fVar2 = ((f[]) this.f11122l.f13566r)[i12];
            }
            return;
        }
        if (i11 == -1) {
            b l10 = l();
            l10.f11105a = fVar;
            float f10 = i10;
            fVar.f11134s = f10;
            l10.f11106b = f10;
            l10.f11109e = true;
            c(l10);
            return;
        }
        b bVar = this.f11117f[i11];
        if (bVar.f11109e) {
            bVar.f11106b = i10;
            return;
        }
        if (bVar.f11108d.d() == 0) {
            bVar.f11109e = true;
            bVar.f11106b = i10;
            return;
        }
        b l11 = l();
        if (i10 < 0) {
            l11.f11106b = i10 * (-1);
            l11.f11108d.g(fVar, 1.0f);
        } else {
            l11.f11106b = i10;
            l11.f11108d.g(fVar, -1.0f);
        }
        c(l11);
    }

    public final void e(f fVar, f fVar2, int i10, int i11) {
        if (i11 == 8 && fVar2.f11135t && fVar.f11132q == -1) {
            fVar.d(this, fVar2.f11134s + i10);
            return;
        }
        b l10 = l();
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            l10.f11106b = i10;
        }
        if (z10) {
            l10.f11108d.g(fVar, 1.0f);
            l10.f11108d.g(fVar2, -1.0f);
        } else {
            l10.f11108d.g(fVar, -1.0f);
            l10.f11108d.g(fVar2, 1.0f);
        }
        if (i11 != 8) {
            l10.a(this, i11);
        }
        c(l10);
    }

    public final void f(f fVar, f fVar2, int i10, int i11) {
        b l10 = l();
        f m10 = m();
        m10.f11133r = 0;
        l10.b(fVar, fVar2, m10, i10);
        if (i11 != 8) {
            l10.f11108d.g(j(i11), (int) (l10.f11108d.c(m10) * (-1.0f)));
        }
        c(l10);
    }

    public final void g(f fVar, f fVar2, int i10, int i11) {
        b l10 = l();
        f m10 = m();
        m10.f11133r = 0;
        l10.c(fVar, fVar2, m10, i10);
        if (i11 != 8) {
            l10.f11108d.g(j(i11), (int) (l10.f11108d.c(m10) * (-1.0f)));
        }
        c(l10);
    }

    public final void h(b bVar) {
        int i10;
        if (bVar.f11109e) {
            bVar.f11105a.d(this, bVar.f11106b);
        } else {
            b[] bVarArr = this.f11117f;
            int i11 = this.f11120j;
            bVarArr[i11] = bVar;
            f fVar = bVar.f11105a;
            fVar.f11132q = i11;
            this.f11120j = i11 + 1;
            fVar.e(this, bVar);
        }
        if (this.f11112a) {
            int i12 = 0;
            while (i12 < this.f11120j) {
                if (this.f11117f[i12] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f11117f[i12];
                if (bVar2 != null && bVar2.f11109e) {
                    bVar2.f11105a.d(this, bVar2.f11106b);
                    ((l0.d) this.f11122l.f13564p).a(bVar2);
                    this.f11117f[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f11120j;
                        if (i13 >= i10) {
                            break;
                        }
                        b[] bVarArr2 = this.f11117f;
                        int i15 = i13 - 1;
                        b bVar3 = bVarArr2[i13];
                        bVarArr2[i15] = bVar3;
                        f fVar2 = bVar3.f11105a;
                        if (fVar2.f11132q == i13) {
                            fVar2.f11132q = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f11117f[i14] = null;
                    }
                    this.f11120j = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f11112a = false;
        }
    }

    public final void i() {
        for (int i10 = 0; i10 < this.f11120j; i10++) {
            b bVar = this.f11117f[i10];
            bVar.f11105a.f11134s = bVar.f11106b;
        }
    }

    public final f j(int i10) {
        if (this.f11119i + 1 >= this.f11116e) {
            o();
        }
        f a10 = a(4);
        float[] fArr = a10.f11137v;
        int i11 = this.f11113b + 1;
        this.f11113b = i11;
        this.f11119i++;
        a10.f11131p = i11;
        a10.f11133r = i10;
        ((f[]) this.f11122l.f13566r)[i11] = a10;
        d dVar = this.f11114c;
        dVar.f11128i.f13537p = a10;
        Arrays.fill(fArr, 0.0f);
        fArr[a10.f11133r] = 1.0f;
        dVar.j(a10);
        return a10;
    }

    public final f k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.f11119i + 1 >= this.f11116e) {
            o();
        }
        if (!(obj instanceof u.c)) {
            return null;
        }
        u.c cVar = (u.c) obj;
        f fVar = cVar.f12059i;
        if (fVar == null) {
            cVar.k();
            fVar = cVar.f12059i;
        }
        int i10 = fVar.f11131p;
        m mVar = this.f11122l;
        if (i10 != -1 && i10 <= this.f11113b && ((f[]) mVar.f13566r)[i10] != null) {
            return fVar;
        }
        if (i10 != -1) {
            fVar.c();
        }
        int i11 = this.f11113b + 1;
        this.f11113b = i11;
        this.f11119i++;
        fVar.f11131p = i11;
        fVar.f11141z = 1;
        ((f[]) mVar.f13566r)[i11] = fVar;
        return fVar;
    }

    public final b l() {
        Object obj;
        m mVar = this.f11122l;
        l0.d dVar = (l0.d) mVar.f13564p;
        int i10 = dVar.f8063p;
        if (i10 > 0) {
            int i11 = i10 - 1;
            Object[] objArr = dVar.f8062o;
            obj = objArr[i11];
            objArr[i11] = null;
            dVar.f8063p = i11;
        } else {
            obj = null;
        }
        b bVar = (b) obj;
        if (bVar == null) {
            return new b(mVar);
        }
        bVar.f11105a = null;
        bVar.f11108d.b();
        bVar.f11106b = 0.0f;
        bVar.f11109e = false;
        return bVar;
    }

    public final f m() {
        if (this.f11119i + 1 >= this.f11116e) {
            o();
        }
        f a10 = a(3);
        int i10 = this.f11113b + 1;
        this.f11113b = i10;
        this.f11119i++;
        a10.f11131p = i10;
        ((f[]) this.f11122l.f13566r)[i10] = a10;
        return a10;
    }

    public final void o() {
        int i10 = this.f11115d * 2;
        this.f11115d = i10;
        this.f11117f = (b[]) Arrays.copyOf(this.f11117f, i10);
        m mVar = this.f11122l;
        mVar.f13566r = (f[]) Arrays.copyOf((f[]) mVar.f13566r, this.f11115d);
        int i11 = this.f11115d;
        this.f11118h = new boolean[i11];
        this.f11116e = i11;
        this.f11121k = i11;
    }

    public final void p() {
        d dVar = this.f11114c;
        if (dVar.e()) {
            i();
            return;
        }
        if (!this.g) {
            q(dVar);
            return;
        }
        for (int i10 = 0; i10 < this.f11120j; i10++) {
            if (!this.f11117f[i10].f11109e) {
                q(dVar);
                return;
            }
        }
        i();
    }

    public final void q(d dVar) {
        int i10 = 0;
        while (true) {
            if (i10 >= this.f11120j) {
                break;
            }
            b bVar = this.f11117f[i10];
            int i11 = 1;
            if (bVar.f11105a.f11141z != 1) {
                float f10 = 0.0f;
                if (bVar.f11106b < 0.0f) {
                    boolean z10 = false;
                    int i12 = 0;
                    while (!z10) {
                        i12 += i11;
                        float f11 = Float.MAX_VALUE;
                        int i13 = -1;
                        int i14 = -1;
                        int i15 = 0;
                        int i16 = 0;
                        while (i15 < this.f11120j) {
                            b bVar2 = this.f11117f[i15];
                            if (bVar2.f11105a.f11141z != i11 && !bVar2.f11109e && bVar2.f11106b < f10) {
                                int d6 = bVar2.f11108d.d();
                                int i17 = 0;
                                while (i17 < d6) {
                                    f e7 = bVar2.f11108d.e(i17);
                                    float c10 = bVar2.f11108d.c(e7);
                                    if (c10 > f10) {
                                        for (int i18 = 0; i18 < 9; i18++) {
                                            float f12 = e7.f11136u[i18] / c10;
                                            if ((f12 < f11 && i18 == i16) || i18 > i16) {
                                                i16 = i18;
                                                i14 = e7.f11131p;
                                                i13 = i15;
                                                f11 = f12;
                                            }
                                        }
                                    }
                                    i17++;
                                    f10 = 0.0f;
                                }
                            }
                            i15++;
                            f10 = 0.0f;
                            i11 = 1;
                        }
                        if (i13 != -1) {
                            b bVar3 = this.f11117f[i13];
                            bVar3.f11105a.f11132q = -1;
                            bVar3.g(((f[]) this.f11122l.f13566r)[i14]);
                            f fVar = bVar3.f11105a;
                            fVar.f11132q = i13;
                            fVar.e(this, bVar3);
                        } else {
                            z10 = true;
                        }
                        if (i12 > this.f11119i / 2) {
                            z10 = true;
                        }
                        f10 = 0.0f;
                        i11 = 1;
                    }
                }
            }
            i10++;
        }
        r(dVar);
        i();
    }

    public final void r(b bVar) {
        boolean z10;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f11119i; i11++) {
            this.f11118h[i11] = false;
        }
        boolean z11 = false;
        int i12 = 0;
        while (!z11) {
            int i13 = 1;
            i12++;
            if (i12 >= this.f11119i * 2) {
                return;
            }
            f fVar = bVar.f11105a;
            if (fVar != null) {
                this.f11118h[fVar.f11131p] = true;
            }
            f d6 = bVar.d(this.f11118h);
            if (d6 != null) {
                boolean[] zArr = this.f11118h;
                int i14 = d6.f11131p;
                if (zArr[i14]) {
                    return;
                } else {
                    zArr[i14] = true;
                }
            }
            if (d6 != null) {
                float f10 = Float.MAX_VALUE;
                int i15 = i10;
                int i16 = -1;
                while (i15 < this.f11120j) {
                    b bVar2 = this.f11117f[i15];
                    if (bVar2.f11105a.f11141z != i13 && !bVar2.f11109e) {
                        a aVar = bVar2.f11108d;
                        int i17 = aVar.f11102h;
                        if (i17 != -1) {
                            for (int i18 = 0; i17 != -1 && i18 < aVar.f11096a; i18++) {
                                if (aVar.f11100e[i17] == d6.f11131p) {
                                    z10 = true;
                                    break;
                                }
                                i17 = aVar.f11101f[i17];
                            }
                        }
                        z10 = false;
                        if (z10) {
                            float c10 = bVar2.f11108d.c(d6);
                            if (c10 < 0.0f) {
                                float f11 = (-bVar2.f11106b) / c10;
                                if (f11 < f10) {
                                    f10 = f11;
                                    i16 = i15;
                                }
                            }
                        }
                    }
                    i15++;
                    i13 = 1;
                }
                if (i16 > -1) {
                    b bVar3 = this.f11117f[i16];
                    bVar3.f11105a.f11132q = -1;
                    bVar3.g(d6);
                    f fVar2 = bVar3.f11105a;
                    fVar2.f11132q = i16;
                    fVar2.e(this, bVar3);
                }
            } else {
                z11 = true;
            }
            i10 = 0;
        }
    }

    public final void s() {
        for (int i10 = 0; i10 < this.f11120j; i10++) {
            b bVar = this.f11117f[i10];
            if (bVar != null) {
                ((l0.d) this.f11122l.f13564p).a(bVar);
            }
            this.f11117f[i10] = null;
        }
    }

    public final void t() {
        m mVar;
        int i10 = 0;
        while (true) {
            mVar = this.f11122l;
            f[] fVarArr = (f[]) mVar.f13566r;
            if (i10 >= fVarArr.length) {
                break;
            }
            f fVar = fVarArr[i10];
            if (fVar != null) {
                fVar.c();
            }
            i10++;
        }
        l0.d dVar = (l0.d) mVar.f13565q;
        f[] fVarArr2 = this.f11123m;
        int i11 = this.f11124n;
        dVar.getClass();
        if (i11 > fVarArr2.length) {
            i11 = fVarArr2.length;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            f fVar2 = fVarArr2[i12];
            int i13 = dVar.f8063p;
            Object[] objArr = dVar.f8062o;
            if (i13 < objArr.length) {
                objArr[i13] = fVar2;
                dVar.f8063p = i13 + 1;
            }
        }
        this.f11124n = 0;
        Arrays.fill((f[]) mVar.f13566r, (Object) null);
        this.f11113b = 0;
        d dVar2 = this.f11114c;
        dVar2.f11127h = 0;
        dVar2.f11106b = 0.0f;
        this.f11119i = 1;
        for (int i14 = 0; i14 < this.f11120j; i14++) {
            b bVar = this.f11117f[i14];
        }
        s();
        this.f11120j = 0;
        this.f11125o = new b(mVar);
    }
}
