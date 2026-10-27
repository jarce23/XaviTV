package v;

import j9.v1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: f, reason: collision with root package name */
    public static int f12616f;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f12617a;

    /* renamed from: b, reason: collision with root package name */
    public int f12618b;

    /* renamed from: c, reason: collision with root package name */
    public int f12619c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f12620d;

    /* renamed from: e, reason: collision with root package name */
    public int f12621e;

    public final void a(ArrayList arrayList) {
        int size = this.f12617a.size();
        if (this.f12621e != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                n nVar = (n) arrayList.get(i10);
                if (this.f12621e == nVar.f12618b) {
                    c(this.f12619c, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(s.c cVar, int i10) {
        int n10;
        int n11;
        ArrayList arrayList = this.f12617a;
        if (arrayList.size() == 0) {
            return 0;
        }
        u.e eVar = (u.e) ((u.d) arrayList.get(0)).S;
        cVar.t();
        eVar.b(cVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            ((u.d) arrayList.get(i11)).b(cVar, false);
        }
        if (i10 == 0 && eVar.f12108y0 > 0) {
            u.j.a(eVar, cVar, arrayList, 0);
        }
        if (i10 == 1 && eVar.f12109z0 > 0) {
            u.j.a(eVar, cVar, arrayList, 1);
        }
        try {
            cVar.p();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        this.f12620d = new ArrayList();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            u.d dVar = (u.d) arrayList.get(i12);
            v1 v1Var = new v1(21);
            new WeakReference(dVar);
            s.c.n(dVar.H);
            s.c.n(dVar.I);
            s.c.n(dVar.J);
            s.c.n(dVar.K);
            s.c.n(dVar.L);
            this.f12620d.add(v1Var);
        }
        if (i10 == 0) {
            n10 = s.c.n(eVar.H);
            n11 = s.c.n(eVar.J);
            cVar.t();
        } else {
            n10 = s.c.n(eVar.I);
            n11 = s.c.n(eVar.K);
            cVar.t();
        }
        return n11 - n10;
    }

    public final void c(int i10, n nVar) {
        int i11 = nVar.f12618b;
        ArrayList arrayList = this.f12617a;
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            u.d dVar = (u.d) obj;
            ArrayList arrayList2 = nVar.f12617a;
            if (!arrayList2.contains(dVar)) {
                arrayList2.add(dVar);
            }
            if (i10 == 0) {
                dVar.f12083m0 = i11;
            } else {
                dVar.f12085n0 = i11;
            }
        }
        this.f12621e = i11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f12619c;
        sb2.append(i10 == 0 ? "Horizontal" : i10 == 1 ? "Vertical" : i10 == 2 ? "Both" : "Unknown");
        sb2.append(" [");
        String d6 = r.a.d(sb2, this.f12618b, "] <");
        ArrayList arrayList = this.f12617a;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            StringBuilder a10 = s.e.a(d6, " ");
            a10.append(((u.d) obj).f12072g0);
            d6 = a10.toString();
        }
        return r.a.c(d6, " >");
    }
}
