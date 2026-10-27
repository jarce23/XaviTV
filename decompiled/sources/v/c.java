package v;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends o {

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f12589k;

    /* renamed from: l, reason: collision with root package name */
    public int f12590l;

    public c(u.d dVar, int i10) {
        super(dVar);
        u.d dVar2;
        ArrayList arrayList = new ArrayList();
        this.f12589k = arrayList;
        this.f12627f = i10;
        u.d dVar3 = this.f12623b;
        u.d m10 = dVar3.m(i10);
        while (true) {
            dVar2 = dVar3;
            dVar3 = m10;
            if (dVar3 == null) {
                break;
            } else {
                m10 = dVar3.m(this.f12627f);
            }
        }
        this.f12623b = dVar2;
        int i11 = this.f12627f;
        arrayList.add(i11 == 0 ? dVar2.f12066d : i11 == 1 ? dVar2.f12068e : null);
        u.d l10 = dVar2.l(this.f12627f);
        while (l10 != null) {
            int i12 = this.f12627f;
            arrayList.add(i12 == 0 ? l10.f12066d : i12 == 1 ? l10.f12068e : null);
            l10 = l10.l(this.f12627f);
        }
        int size = arrayList.size();
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayList.get(i13);
            i13++;
            o oVar = (o) obj;
            int i14 = this.f12627f;
            if (i14 == 0) {
                oVar.f12623b.f12062b = this;
            } else if (i14 == 1) {
                oVar.f12623b.f12064c = this;
            }
        }
        if (this.f12627f == 0 && ((u.e) this.f12623b.S).f12104u0 && arrayList.size() > 1) {
            this.f12623b = ((o) arrayList.get(arrayList.size() - 1)).f12623b;
        }
        this.f12590l = this.f12627f == 0 ? this.f12623b.h0 : this.f12623b.f12075i0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:288:0x0392, code lost:
    
        r2 = r2 - r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd  */
    @Override // v.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(v.d r28) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.c.a(v.d):void");
    }

    @Override // v.o
    public final void d() {
        ArrayList arrayList = this.f12589k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((o) obj).d();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        u.d dVar = ((o) arrayList.get(0)).f12623b;
        u.d dVar2 = ((o) arrayList.get(size2 - 1)).f12623b;
        int i11 = this.f12627f;
        f fVar = this.f12629i;
        f fVar2 = this.f12628h;
        if (i11 == 0) {
            u.c cVar = dVar.H;
            u.c cVar2 = dVar2.J;
            f i12 = o.i(cVar, 0);
            int e7 = cVar.e();
            u.d m10 = m();
            if (m10 != null) {
                e7 = m10.H.e();
            }
            if (i12 != null) {
                o.b(fVar2, i12, e7);
            }
            f i13 = o.i(cVar2, 0);
            int e8 = cVar2.e();
            u.d n10 = n();
            if (n10 != null) {
                e8 = n10.J.e();
            }
            if (i13 != null) {
                o.b(fVar, i13, -e8);
            }
        } else {
            u.c cVar3 = dVar.I;
            u.c cVar4 = dVar2.K;
            f i14 = o.i(cVar3, 1);
            int e10 = cVar3.e();
            u.d m11 = m();
            if (m11 != null) {
                e10 = m11.I.e();
            }
            if (i14 != null) {
                o.b(fVar2, i14, e10);
            }
            f i15 = o.i(cVar4, 1);
            int e11 = cVar4.e();
            u.d n11 = n();
            if (n11 != null) {
                e11 = n11.K.e();
            }
            if (i15 != null) {
                o.b(fVar, i15, -e11);
            }
        }
        fVar2.f12598a = this;
        fVar.f12598a = this;
    }

    @Override // v.o
    public final void e() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f12589k;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((o) arrayList.get(i10)).e();
            i10++;
        }
    }

    @Override // v.o
    public final void f() {
        this.f12624c = null;
        ArrayList arrayList = this.f12589k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((o) obj).f();
        }
    }

    @Override // v.o
    public final long j() {
        ArrayList arrayList = this.f12589k;
        int size = arrayList.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            j10 = r5.f12629i.f12603f + ((o) arrayList.get(i10)).j() + j10 + r5.f12628h.f12603f;
        }
        return j10;
    }

    @Override // v.o
    public final boolean k() {
        ArrayList arrayList = this.f12589k;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!((o) arrayList.get(i10)).k()) {
                return false;
            }
        }
        return true;
    }

    public final u.d m() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f12589k;
            if (i10 >= arrayList.size()) {
                return null;
            }
            u.d dVar = ((o) arrayList.get(i10)).f12623b;
            if (dVar.f12071f0 != 8) {
                return dVar;
            }
            i10++;
        }
    }

    public final u.d n() {
        ArrayList arrayList = this.f12589k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            u.d dVar = ((o) arrayList.get(size)).f12623b;
            if (dVar.f12071f0 != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f12627f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.f12589k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            sb2.append("<");
            sb2.append((o) obj);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
