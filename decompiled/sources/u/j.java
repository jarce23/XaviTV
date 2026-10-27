package u;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean[] f12145a = new boolean[3];

    /* JADX WARN: Code restructure failed: missing block: B:163:0x0290, code lost:
    
        if (r7.f12055d == r6) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0112, code lost:
    
        if (r4.f12055d == r12) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:265:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(u.e r40, s.c r41, java.util.ArrayList r42, int r43) {
        /*
            Method dump skipped, instructions count: 1791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.j.a(u.e, s.c, java.util.ArrayList, int):void");
    }

    public static void b(e eVar, s.c cVar, d dVar) {
        dVar.f12084n = -1;
        c cVar2 = dVar.L;
        int[] iArr = dVar.f12087o0;
        c cVar3 = dVar.K;
        c cVar4 = dVar.I;
        c cVar5 = dVar.J;
        c cVar6 = dVar.H;
        dVar.f12086o = -1;
        int[] iArr2 = eVar.f12087o0;
        if (iArr2[0] != 2 && iArr[0] == 4) {
            int i10 = cVar6.g;
            int n10 = eVar.n() - cVar5.g;
            cVar6.f12059i = cVar.k(cVar6);
            cVar5.f12059i = cVar.k(cVar5);
            cVar.d(cVar6.f12059i, i10);
            cVar.d(cVar5.f12059i, n10);
            dVar.f12084n = 2;
            dVar.X = i10;
            int i11 = n10 - i10;
            dVar.T = i11;
            int i12 = dVar.f12061a0;
            if (i11 < i12) {
                dVar.T = i12;
            }
        }
        if (iArr2[1] == 2 || iArr[1] != 4) {
            return;
        }
        int i13 = cVar4.g;
        int k10 = eVar.k() - cVar3.g;
        cVar4.f12059i = cVar.k(cVar4);
        cVar3.f12059i = cVar.k(cVar3);
        cVar.d(cVar4.f12059i, i13);
        cVar.d(cVar3.f12059i, k10);
        if (dVar.Z > 0 || dVar.f12071f0 == 8) {
            s.f k11 = cVar.k(cVar2);
            cVar2.f12059i = k11;
            cVar.d(k11, dVar.Z + i13);
        }
        dVar.f12086o = 2;
        dVar.Y = i13;
        int i14 = k10 - i13;
        dVar.U = i14;
        int i15 = dVar.f12063b0;
        if (i14 < i15) {
            dVar.U = i15;
        }
    }

    public static final boolean c(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
