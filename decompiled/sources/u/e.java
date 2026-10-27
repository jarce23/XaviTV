package u;

import android.support.v4.media.session.a0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import v.o;
import x4.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends d {
    public b[] A0;
    public b[] B0;
    public int C0;
    public boolean D0;
    public boolean E0;
    public WeakReference F0;
    public WeakReference G0;
    public WeakReference H0;
    public WeakReference I0;
    public final HashSet J0;
    public final v.b K0;

    /* renamed from: p0, reason: collision with root package name */
    public ArrayList f12099p0 = new ArrayList();

    /* renamed from: q0, reason: collision with root package name */
    public final a0 f12100q0 = new a0(this);

    /* renamed from: r0, reason: collision with root package name */
    public final v.e f12101r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f12102s0;

    /* renamed from: t0, reason: collision with root package name */
    public x.e f12103t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f12104u0;

    /* renamed from: v0, reason: collision with root package name */
    public final s.c f12105v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f12106w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f12107x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f12108y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f12109z0;

    public e() {
        v.e eVar = new v.e();
        eVar.f12592b = true;
        eVar.f12593c = true;
        eVar.f12595e = new ArrayList();
        new ArrayList();
        eVar.f12596f = null;
        eVar.g = new v.b();
        eVar.f12597h = new ArrayList();
        eVar.f12591a = this;
        eVar.f12594d = this;
        this.f12101r0 = eVar;
        this.f12103t0 = null;
        this.f12104u0 = false;
        this.f12105v0 = new s.c();
        this.f12108y0 = 0;
        this.f12109z0 = 0;
        this.A0 = new b[4];
        this.B0 = new b[4];
        this.C0 = 257;
        this.D0 = false;
        this.E0 = false;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = new HashSet();
        this.K0 = new v.b();
    }

    public static void Q(d dVar, x.e eVar, v.b bVar) {
        int i10;
        int i11;
        if (eVar == null) {
            return;
        }
        int i12 = dVar.f12071f0;
        int[] iArr = dVar.f12091s;
        if (i12 == 8 || (dVar instanceof h) || (dVar instanceof a)) {
            bVar.f12584e = 0;
            bVar.f12585f = 0;
            return;
        }
        int[] iArr2 = dVar.f12087o0;
        bVar.f12580a = iArr2[0];
        bVar.f12581b = iArr2[1];
        bVar.f12582c = dVar.n();
        bVar.f12583d = dVar.k();
        bVar.f12587i = false;
        bVar.f12588j = 0;
        boolean z10 = bVar.f12580a == 3;
        boolean z11 = bVar.f12581b == 3;
        boolean z12 = z10 && dVar.V > 0.0f;
        boolean z13 = z11 && dVar.V > 0.0f;
        if (z10 && dVar.q(0) && dVar.f12089q == 0 && !z12) {
            bVar.f12580a = 2;
            if (z11 && dVar.f12090r == 0) {
                bVar.f12580a = 1;
            }
            z10 = false;
        }
        if (z11 && dVar.q(1) && dVar.f12090r == 0 && !z13) {
            bVar.f12581b = 2;
            if (z10 && dVar.f12089q == 0) {
                bVar.f12581b = 1;
            }
            z11 = false;
        }
        if (dVar.x()) {
            bVar.f12580a = 1;
            z10 = false;
        }
        if (dVar.y()) {
            bVar.f12581b = 1;
            z11 = false;
        }
        if (z12) {
            if (iArr[0] == 4) {
                bVar.f12580a = 1;
            } else if (!z11) {
                if (bVar.f12581b == 1) {
                    i11 = bVar.f12583d;
                } else {
                    bVar.f12580a = 2;
                    eVar.b(dVar, bVar);
                    i11 = bVar.f12585f;
                }
                bVar.f12580a = 1;
                bVar.f12582c = (int) (dVar.V * i11);
            }
        }
        if (z13) {
            if (iArr[1] == 4) {
                bVar.f12581b = 1;
            } else if (!z10) {
                if (bVar.f12580a == 1) {
                    i10 = bVar.f12582c;
                } else {
                    bVar.f12581b = 2;
                    eVar.b(dVar, bVar);
                    i10 = bVar.f12584e;
                }
                bVar.f12581b = 1;
                if (dVar.W == -1) {
                    bVar.f12583d = (int) (i10 / dVar.V);
                } else {
                    bVar.f12583d = (int) (dVar.V * i10);
                }
            }
        }
        eVar.b(dVar, bVar);
        dVar.J(bVar.f12584e);
        dVar.G(bVar.f12585f);
        dVar.D = bVar.f12586h;
        dVar.D(bVar.g);
        bVar.f12588j = 0;
    }

    @Override // u.d
    public final void C(m mVar) {
        super.C(mVar);
        int size = this.f12099p0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((d) this.f12099p0.get(i10)).C(mVar);
        }
    }

    @Override // u.d
    public final void K(boolean z10, boolean z11) {
        super.K(z10, z11);
        int size = this.f12099p0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((d) this.f12099p0.get(i10)).K(z10, z11);
        }
    }

    public final void M(d dVar, int i10) {
        if (i10 == 0) {
            int i11 = this.f12108y0 + 1;
            b[] bVarArr = this.B0;
            if (i11 >= bVarArr.length) {
                this.B0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.B0;
            int i12 = this.f12108y0;
            bVarArr2[i12] = new b(dVar, 0, this.f12104u0);
            this.f12108y0 = i12 + 1;
            return;
        }
        if (i10 == 1) {
            int i13 = this.f12109z0 + 1;
            b[] bVarArr3 = this.A0;
            if (i13 >= bVarArr3.length) {
                this.A0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.A0;
            int i14 = this.f12109z0;
            bVarArr4[i14] = new b(dVar, 1, this.f12104u0);
            this.f12109z0 = i14 + 1;
        }
    }

    public final void N(s.c cVar) {
        e eVar;
        s.c cVar2;
        boolean R = R(64);
        b(cVar, R);
        int size = this.f12099p0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) this.f12099p0.get(i10);
            boolean[] zArr = dVar.R;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                d dVar2 = (d) this.f12099p0.get(i11);
                if (dVar2 instanceof a) {
                    a aVar = (a) dVar2;
                    for (int i12 = 0; i12 < aVar.f12144q0; i12++) {
                        d dVar3 = aVar.f12143p0[i12];
                        if (aVar.f12033s0 || dVar3.c()) {
                            int i13 = aVar.f12032r0;
                            if (i13 == 0 || i13 == 1) {
                                dVar3.R[0] = true;
                            } else if (i13 == 2 || i13 == 3) {
                                dVar3.R[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.J0;
        hashSet.clear();
        for (int i14 = 0; i14 < size; i14++) {
            d dVar4 = (d) this.f12099p0.get(i14);
            dVar4.getClass();
            boolean z11 = dVar4 instanceof g;
            if (z11 || (dVar4 instanceof h)) {
                if (z11) {
                    hashSet.add(dVar4);
                } else {
                    dVar4.b(cVar, R);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g gVar = (g) ((d) it.next());
                for (int i15 = 0; i15 < gVar.f12144q0; i15++) {
                    if (hashSet.contains(gVar.f12143p0[i15])) {
                        gVar.b(cVar, R);
                        hashSet.remove(gVar);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).b(cVar, R);
                }
                hashSet.clear();
            }
        }
        if (s.c.f11110p) {
            HashSet hashSet2 = new HashSet();
            for (int i16 = 0; i16 < size; i16++) {
                d dVar5 = (d) this.f12099p0.get(i16);
                dVar5.getClass();
                if (!(dVar5 instanceof g) && !(dVar5 instanceof h)) {
                    hashSet2.add(dVar5);
                }
            }
            eVar = this;
            cVar2 = cVar;
            eVar.a(this, cVar2, hashSet2, this.f12087o0[0] == 2 ? 0 : 1, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                d dVar6 = (d) it3.next();
                j.b(this, cVar2, dVar6);
                dVar6.b(cVar2, R);
            }
        } else {
            eVar = this;
            cVar2 = cVar;
            for (int i17 = 0; i17 < size; i17++) {
                d dVar7 = (d) eVar.f12099p0.get(i17);
                if (dVar7 instanceof e) {
                    int[] iArr = dVar7.f12087o0;
                    int i18 = iArr[0];
                    int i19 = iArr[1];
                    if (i18 == 2) {
                        dVar7.H(1);
                    }
                    if (i19 == 2) {
                        dVar7.I(1);
                    }
                    dVar7.b(cVar2, R);
                    if (i18 == 2) {
                        dVar7.H(i18);
                    }
                    if (i19 == 2) {
                        dVar7.I(i19);
                    }
                } else {
                    j.b(this, cVar2, dVar7);
                    if (!(dVar7 instanceof g) && !(dVar7 instanceof h)) {
                        dVar7.b(cVar2, R);
                    }
                }
            }
        }
        if (eVar.f12108y0 > 0) {
            j.a(this, cVar2, null, 0);
        }
        if (eVar.f12109z0 > 0) {
            j.a(this, cVar2, null, 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean O(int i10, boolean z10) {
        int i11;
        int i12;
        boolean z11;
        boolean z12;
        v.e eVar = this.f12101r0;
        ArrayList arrayList = eVar.f12595e;
        e eVar2 = eVar.f12591a;
        int j10 = eVar2.j(0);
        int[] iArr = eVar2.f12087o0;
        int j11 = eVar2.j(1);
        int o2 = eVar2.o();
        int p10 = eVar2.p();
        if (z10 && (j10 == 2 || j11 == 2)) {
            int size = arrayList.size();
            int i13 = 0;
            while (true) {
                if (i13 >= size) {
                    z12 = z10;
                    break;
                }
                Object obj = arrayList.get(i13);
                i13++;
                o oVar = (o) obj;
                if (oVar.f12627f == i10 && !oVar.k()) {
                    z12 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z12 && j10 == 2) {
                    eVar2.H(1);
                    eVar2.J(eVar.d(eVar2, 0));
                    eVar2.f12066d.f12626e.d(eVar2.n());
                }
            } else if (z12 && j11 == 2) {
                eVar2.I(1);
                eVar2.G(eVar.d(eVar2, 1));
                eVar2.f12068e.f12626e.d(eVar2.k());
            }
        }
        if (i10 == 0) {
            i11 = 0;
            int i14 = iArr[0];
            if (i14 == 1 || i14 == 4) {
                int n10 = eVar2.n() + o2;
                eVar2.f12066d.f12629i.d(n10);
                eVar2.f12066d.f12626e.d(n10 - o2);
                i12 = 1;
            }
            i12 = i11;
        } else {
            i11 = 0;
            int i15 = iArr[1];
            if (i15 == 1 || i15 == 4) {
                int k10 = eVar2.k() + p10;
                eVar2.f12068e.f12629i.d(k10);
                eVar2.f12068e.f12626e.d(k10 - p10);
                i12 = 1;
            }
            i12 = i11;
        }
        eVar.g();
        int size2 = arrayList.size();
        int i16 = i11;
        while (i16 < size2) {
            Object obj2 = arrayList.get(i16);
            i16++;
            o oVar2 = (o) obj2;
            if (oVar2.f12627f == i10 && (oVar2.f12623b != eVar2 || oVar2.g)) {
                oVar2.e();
            }
        }
        int size3 = arrayList.size();
        int i17 = i11;
        while (i17 < size3) {
            Object obj3 = arrayList.get(i17);
            i17++;
            o oVar3 = (o) obj3;
            if (oVar3.f12627f == i10 && (i12 != 0 || oVar3.f12623b != eVar2)) {
                if (!oVar3.f12628h.f12606j || !oVar3.f12629i.f12606j || (!(oVar3 instanceof v.c) && !oVar3.f12626e.f12606j)) {
                    z11 = i11;
                    break;
                }
            }
        }
        z11 = 1;
        eVar2.H(j10);
        eVar2.I(j11);
        return z11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:203:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0671 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x07bf  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x081d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x082a A[LOOP:14: B:279:0x0828->B:280:0x082a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0892  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x08b2  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x08f8  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x08bb  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x089f  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0800  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x090b  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0605 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:623:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:632:0x062f  */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P() {
        /*
            Method dump skipped, instructions count: 2329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.e.P():void");
    }

    public final boolean R(int i10) {
        return (this.C0 & i10) == i10;
    }

    @Override // u.d
    public final void z() {
        this.f12105v0.t();
        this.f12106w0 = 0;
        this.f12107x0 = 0;
        this.f12099p0.clear();
        super.z();
    }
}
