package v;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public o f12612a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f12613b;

    public static long a(f fVar, long j10) {
        o oVar = fVar.f12601d;
        ArrayList arrayList = fVar.f12607k;
        if (oVar instanceof j) {
            return j10;
        }
        int size = arrayList.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) arrayList.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f12601d != oVar) {
                    j11 = Math.min(j11, a(fVar2, fVar2.f12603f + j10));
                }
            }
        }
        f fVar3 = oVar.f12629i;
        f fVar4 = oVar.f12628h;
        if (fVar != fVar3) {
            return j11;
        }
        long j12 = j10 - oVar.j();
        return Math.min(Math.min(j11, a(fVar4, j12)), j12 - fVar4.f12603f);
    }

    public static long b(f fVar, long j10) {
        o oVar = fVar.f12601d;
        ArrayList arrayList = fVar.f12607k;
        if (oVar instanceof j) {
            return j10;
        }
        int size = arrayList.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) arrayList.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f12601d != oVar) {
                    j11 = Math.max(j11, b(fVar2, fVar2.f12603f + j10));
                }
            }
        }
        f fVar3 = oVar.f12628h;
        f fVar4 = oVar.f12629i;
        if (fVar != fVar3) {
            return j11;
        }
        long j12 = oVar.j() + j10;
        return Math.max(Math.max(j11, b(fVar4, j12)), j12 - fVar4.f12603f);
    }
}
