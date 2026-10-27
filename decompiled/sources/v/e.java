package v;

import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public u.e f12591a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12592b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12593c;

    /* renamed from: d, reason: collision with root package name */
    public u.e f12594d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f12595e;

    /* renamed from: f, reason: collision with root package name */
    public x.e f12596f;
    public b g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f12597h;

    public final void a(f fVar, int i10, ArrayList arrayList, l lVar) {
        o oVar = fVar.f12601d;
        l lVar2 = oVar.f12624c;
        f fVar2 = oVar.f12629i;
        f fVar3 = oVar.f12628h;
        if (lVar2 == null) {
            u.e eVar = this.f12591a;
            if (oVar == eVar.f12066d || oVar == eVar.f12068e) {
                return;
            }
            if (lVar == null) {
                lVar = new l();
                lVar.f12612a = null;
                lVar.f12613b = new ArrayList();
                lVar.f12612a = oVar;
                arrayList.add(lVar);
            }
            oVar.f12624c = lVar;
            lVar.f12613b.add(oVar);
            ArrayList arrayList2 = fVar3.f12607k;
            int size = arrayList2.size();
            int i11 = 0;
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList2.get(i12);
                i12++;
                d dVar = (d) obj;
                if (dVar instanceof f) {
                    a((f) dVar, i10, arrayList, lVar);
                }
            }
            ArrayList arrayList3 = fVar2.f12607k;
            int size2 = arrayList3.size();
            int i13 = 0;
            while (i13 < size2) {
                Object obj2 = arrayList3.get(i13);
                i13++;
                d dVar2 = (d) obj2;
                if (dVar2 instanceof f) {
                    a((f) dVar2, i10, arrayList, lVar);
                }
            }
            if (i10 == 1 && (oVar instanceof m)) {
                ArrayList arrayList4 = ((m) oVar).f12614k.f12607k;
                int size3 = arrayList4.size();
                int i14 = 0;
                while (i14 < size3) {
                    Object obj3 = arrayList4.get(i14);
                    i14++;
                    d dVar3 = (d) obj3;
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i10, arrayList, lVar);
                    }
                }
            }
            ArrayList arrayList5 = fVar3.f12608l;
            int size4 = arrayList5.size();
            int i15 = 0;
            while (i15 < size4) {
                Object obj4 = arrayList5.get(i15);
                i15++;
                a((f) obj4, i10, arrayList, lVar);
            }
            ArrayList arrayList6 = fVar2.f12608l;
            int size5 = arrayList6.size();
            int i16 = 0;
            while (i16 < size5) {
                Object obj5 = arrayList6.get(i16);
                i16++;
                a((f) obj5, i10, arrayList, lVar);
            }
            if (i10 == 1 && (oVar instanceof m)) {
                ArrayList arrayList7 = ((m) oVar).f12614k.f12608l;
                int size6 = arrayList7.size();
                while (i11 < size6) {
                    Object obj6 = arrayList7.get(i11);
                    i11++;
                    a((f) obj6, i10, arrayList, lVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0274, code lost:
    
        r6 = 1;
        r9 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0277, code lost:
    
        f(r11, 0, r10, 0, r12);
        r12.f12066d.f12626e.d(r12.n());
        r12.f12068e.f12626e.d(r12.k());
        r12.f12060a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x029a, code lost:
    
        r7 = r10;
        r0 = r13;
        r10 = r8;
        r8 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00e8, code lost:
    
        if (r15 != 3) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00ea, code lost:
    
        if (r6 != r0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00ec, code lost:
    
        f(r0, 0, r0, 0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00f5, code lost:
    
        r11 = r12.k();
        f(1, (int) ((r11 * r12.V) + 0.5f), 1, r11, r12);
        r12.f12066d.f12626e.d(r12.n());
        r12.f12068e.f12626e.d(r12.k());
        r12.f12060a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x012c, code lost:
    
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x012f, code lost:
    
        if (r15 != 1) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0131, code lost:
    
        f(r8, 0, r6, 0, r12);
        r12.f12066d.f12626e.f12609m = r12.n();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0145, code lost:
    
        if (r15 != 2) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0147, code lost:
    
        r0 = r2[r16];
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0149, code lost:
    
        if (r0 == 1) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x014c, code lost:
    
        if (r0 != 4) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x014f, code lost:
    
        r10 = r6;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0152, code lost:
    
        r0 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0154, code lost:
    
        f(1, (int) ((r4 * r25.n()) + 0.5f), r6, r12.k(), r12);
        r12.f12066d.f12626e.d(r12.n());
        r12.f12068e.f12626e.d(r12.k());
        r12.f12060a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0182, code lost:
    
        r10 = r6;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x018a, code lost:
    
        if (r7[r16].f12057f == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0190, code lost:
    
        if (r7[1].f12057f != null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0192, code lost:
    
        f(r8, 0, r10, 0, r12);
        r12.f12066d.f12626e.d(r12.n());
        r12.f12068e.f12626e.d(r12.k());
        r12.f12060a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01b4, code lost:
    
        r8 = r0;
        r10 = r6;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00c9, code lost:
    
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c0, code lost:
    
        if (r13 == 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d4, code lost:
    
        if (r13 != 3) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d6, code lost:
    
        if (r6 == r0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d9, code lost:
    
        if (r6 != 1) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00dc, code lost:
    
        r8 = r0;
        r0 = 3;
        r10 = r6;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01b8, code lost:
    
        if (r10 != r0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01ba, code lost:
    
        if (r13 == r8) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01bc, code lost:
    
        if (r13 != r6) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01bf, code lost:
    
        r9 = r0;
        r7 = r10;
        r0 = r13;
        r10 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01c3, code lost:
    
        r8 = r6;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x029f, code lost:
    
        if (r0 != r9) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02a1, code lost:
    
        if (r7 != r9) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02a3, code lost:
    
        if (r15 == r6) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02a5, code lost:
    
        if (r1 != r6) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02a9, code lost:
    
        if (r1 != 2) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02ab, code lost:
    
        if (r15 != 2) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02af, code lost:
    
        if (r2[r16] != r8) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02b3, code lost:
    
        if (r2[r6] != r8) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02b5, code lost:
    
        f(r8, (int) ((r4 * r25.n()) + 0.5f), r8, (int) ((r14 * r25.k()) + 0.5f), r12);
        r12.f12066d.f12626e.d(r12.n());
        r12.f12068e.f12626e.d(r12.k());
        r12.f12060a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02e8, code lost:
    
        f(r10, 0, r10, 0, r12);
        r12.f12066d.f12626e.f12609m = r12.n();
        r12.f12068e.f12626e.f12609m = r12.k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c7, code lost:
    
        if (r1 != r0) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01c9, code lost:
    
        if (r13 != r8) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01cb, code lost:
    
        f(r8, 0, r8, 0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01d3, code lost:
    
        r9 = r12.n();
        r0 = r12.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01dc, code lost:
    
        if (r12.W != (-1)) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01de, code lost:
    
        r0 = 1.0f / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e0, code lost:
    
        f(r6, r9, r6, (int) ((r9 * r0) + 0.5f), r12);
        r12.f12066d.f12626e.d(r12.n());
        r12.f12068e.f12626e.d(r12.k());
        r12.f12060a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0208, code lost:
    
        if (r1 != 1) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x020a, code lost:
    
        f(r13, 0, r8, 0, r12);
        r12.f12068e.f12626e.f12609m = r12.k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x021f, code lost:
    
        r11 = r8;
        r8 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0222, code lost:
    
        if (r1 != 2) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0224, code lost:
    
        r7 = r2[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0226, code lost:
    
        if (r7 == r6) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0229, code lost:
    
        if (r7 != 4) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x022c, code lost:
    
        r0 = r8;
        r7 = r10;
        r10 = r11;
        r9 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0231, code lost:
    
        f(r8, r12.n(), r6, (int) ((r14 * r25.k()) + 0.5f), r12);
        r12.f12066d.f12626e.d(r12.n());
        r12.f12068e.f12626e.d(r12.k());
        r12.f12060a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x025f, code lost:
    
        r0 = r8;
        r8 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0267, code lost:
    
        if (r7[2].f12057f == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x026f, code lost:
    
        if (r7[3].f12057f != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0272, code lost:
    
        r7 = r10;
        r10 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0337  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(u.e r25) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.e.b(u.e):void");
    }

    public final void c() {
        u.e eVar = this.f12591a;
        ArrayList arrayList = this.f12597h;
        ArrayList arrayList2 = this.f12595e;
        arrayList2.clear();
        u.e eVar2 = this.f12594d;
        eVar2.f12066d.f();
        eVar2.f12068e.f();
        arrayList2.add(eVar2.f12066d);
        arrayList2.add(eVar2.f12068e);
        ArrayList arrayList3 = eVar2.f12099p0;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList3.get(i10);
            i10++;
            u.d dVar = (u.d) obj;
            if (dVar instanceof u.h) {
                i iVar = new i(dVar);
                dVar.f12066d.f();
                dVar.f12068e.f();
                iVar.f12627f = ((u.h) dVar).f12141t0;
                arrayList2.add(iVar);
            } else {
                if (dVar.u()) {
                    if (dVar.f12062b == null) {
                        dVar.f12062b = new c(dVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f12062b);
                } else {
                    arrayList2.add(dVar.f12066d);
                }
                if (dVar.v()) {
                    if (dVar.f12064c == null) {
                        dVar.f12064c = new c(dVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f12064c);
                } else {
                    arrayList2.add(dVar.f12068e);
                }
                if (dVar instanceof u.i) {
                    arrayList2.add(new j(dVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList2.get(i11);
            i11++;
            ((o) obj2).f();
        }
        int size3 = arrayList2.size();
        int i12 = 0;
        while (i12 < size3) {
            Object obj3 = arrayList2.get(i12);
            i12++;
            o oVar = (o) obj3;
            if (oVar.f12623b != eVar2) {
                oVar.d();
            }
        }
        arrayList.clear();
        e(eVar.f12066d, 0, arrayList);
        e(eVar.f12068e, 1, arrayList);
        this.f12592b = false;
    }

    public final int d(u.e eVar, int i10) {
        ArrayList arrayList;
        int i11;
        long max;
        float f10;
        u.e eVar2 = eVar;
        ArrayList arrayList2 = this.f12597h;
        int size = arrayList2.size();
        long j10 = 0;
        int i12 = 0;
        long j11 = 0;
        while (i12 < size) {
            o oVar = ((l) arrayList2.get(i12)).f12612a;
            if (!(oVar instanceof c) ? !(i10 != 0 ? (oVar instanceof m) : (oVar instanceof k)) : ((c) oVar).f12627f != i10) {
                f fVar = (i10 == 0 ? eVar2.f12066d : eVar2.f12068e).f12628h;
                f fVar2 = (i10 == 0 ? eVar2.f12066d : eVar2.f12068e).f12629i;
                f fVar3 = oVar.f12628h;
                f fVar4 = oVar.f12629i;
                boolean contains = fVar3.f12608l.contains(fVar);
                boolean contains2 = fVar4.f12608l.contains(fVar2);
                long j12 = oVar.j();
                if (contains && contains2) {
                    long b2 = l.b(fVar3, j10);
                    long a10 = l.a(fVar4, j10);
                    long j13 = b2 - j12;
                    int i13 = fVar4.f12603f;
                    arrayList = arrayList2;
                    i11 = size;
                    if (j13 >= (-i13)) {
                        j13 += i13;
                    }
                    long j14 = fVar3.f12603f;
                    long j15 = ((-a10) - j12) - j14;
                    if (j15 >= j14) {
                        j15 -= j14;
                    }
                    u.d dVar = oVar.f12623b;
                    if (i10 == 0) {
                        f10 = dVar.f12065c0;
                    } else if (i10 == 1) {
                        f10 = dVar.f12067d0;
                    } else {
                        dVar.getClass();
                        f10 = -1.0f;
                    }
                    float f11 = f10 > 0.0f ? (long) ((j13 / (1.0f - f10)) + (j15 / f10)) : 0L;
                    max = (fVar3.f12603f + ((((long) ((f11 * f10) + 0.5f)) + j12) + ((long) (((1.0f - f10) * f11) + 0.5f)))) - fVar4.f12603f;
                } else {
                    arrayList = arrayList2;
                    i11 = size;
                    max = contains ? Math.max(l.b(fVar3, fVar3.f12603f), fVar3.f12603f + j12) : contains2 ? Math.max(-l.a(fVar4, fVar4.f12603f), (-fVar4.f12603f) + j12) : (oVar.j() + fVar3.f12603f) - fVar4.f12603f;
                }
            } else {
                arrayList = arrayList2;
                i11 = size;
                max = j10;
            }
            j11 = Math.max(j11, max);
            i12++;
            eVar2 = eVar;
            arrayList2 = arrayList;
            size = i11;
            j10 = 0;
        }
        return (int) j11;
    }

    public final void e(o oVar, int i10, ArrayList arrayList) {
        f fVar = oVar.f12628h;
        f fVar2 = oVar.f12629i;
        ArrayList arrayList2 = fVar.f12607k;
        int size = arrayList2.size();
        int i11 = 0;
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList2.get(i12);
            i12++;
            d dVar = (d) obj;
            if (dVar instanceof f) {
                a((f) dVar, i10, arrayList, null);
            } else if (dVar instanceof o) {
                a(((o) dVar).f12628h, i10, arrayList, null);
            }
        }
        ArrayList arrayList3 = fVar2.f12607k;
        int size2 = arrayList3.size();
        int i13 = 0;
        while (i13 < size2) {
            Object obj2 = arrayList3.get(i13);
            i13++;
            d dVar2 = (d) obj2;
            if (dVar2 instanceof f) {
                a((f) dVar2, i10, arrayList, null);
            } else if (dVar2 instanceof o) {
                a(((o) dVar2).f12629i, i10, arrayList, null);
            }
        }
        if (i10 == 1) {
            ArrayList arrayList4 = ((m) oVar).f12614k.f12607k;
            int size3 = arrayList4.size();
            while (i11 < size3) {
                Object obj3 = arrayList4.get(i11);
                i11++;
                d dVar3 = (d) obj3;
                if (dVar3 instanceof f) {
                    a((f) dVar3, i10, arrayList, null);
                }
            }
        }
    }

    public final void f(int i10, int i11, int i12, int i13, u.d dVar) {
        b bVar = this.g;
        bVar.f12580a = i10;
        bVar.f12581b = i12;
        bVar.f12582c = i11;
        bVar.f12583d = i13;
        this.f12596f.b(dVar, bVar);
        dVar.J(bVar.f12584e);
        dVar.G(bVar.f12585f);
        dVar.D = bVar.f12586h;
        dVar.D(bVar.g);
    }

    public final void g() {
        a aVar;
        e eVar = this;
        ArrayList arrayList = eVar.f12591a.f12099p0;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            u.d dVar = (u.d) arrayList.get(i10);
            if (!dVar.f12060a) {
                int[] iArr = dVar.f12087o0;
                int i12 = iArr[0];
                int i13 = iArr[1];
                int i14 = dVar.f12089q;
                int i15 = dVar.f12090r;
                boolean z10 = i12 == 2 || (i12 == 3 && i14 == 1);
                boolean z11 = i13 == 2 || (i13 == 3 && i15 == 1);
                g gVar = dVar.f12066d.f12626e;
                boolean z12 = gVar.f12606j;
                g gVar2 = dVar.f12068e.f12626e;
                boolean z13 = gVar2.f12606j;
                boolean z14 = z10;
                if (z12 && z13) {
                    eVar.f(1, gVar.g, 1, gVar2.g, dVar);
                    dVar.f12060a = true;
                } else if (z12 && z11) {
                    f(1, gVar.g, 2, gVar2.g, dVar);
                    if (i13 == 3) {
                        dVar.f12068e.f12626e.f12609m = dVar.k();
                    } else {
                        dVar.f12068e.f12626e.d(dVar.k());
                        dVar.f12060a = true;
                    }
                } else if (z13 && z14) {
                    f(2, gVar.g, 1, gVar2.g, dVar);
                    if (i12 == 3) {
                        dVar.f12066d.f12626e.f12609m = dVar.n();
                    } else {
                        dVar.f12066d.f12626e.d(dVar.n());
                        dVar.f12060a = true;
                    }
                }
                if (dVar.f12060a && (aVar = dVar.f12068e.f12615l) != null) {
                    aVar.d(dVar.Z);
                }
                eVar = this;
            }
            i10 = i11;
        }
    }
}
