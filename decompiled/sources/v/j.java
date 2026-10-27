package v;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends o {
    @Override // v.d
    public final void a(d dVar) {
        u.a aVar = (u.a) this.f12623b;
        int i10 = aVar.f12032r0;
        f fVar = this.f12628h;
        ArrayList arrayList = fVar.f12608l;
        int size = arrayList.size();
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayList.get(i13);
            i13++;
            int i14 = ((f) obj).g;
            if (i12 == -1 || i14 < i12) {
                i12 = i14;
            }
            if (i11 < i14) {
                i11 = i14;
            }
        }
        if (i10 == 0 || i10 == 2) {
            fVar.d(i12 + aVar.f12034t0);
        } else {
            fVar.d(i11 + aVar.f12034t0);
        }
    }

    @Override // v.o
    public final void d() {
        u.d dVar = this.f12623b;
        if (dVar instanceof u.a) {
            f fVar = this.f12628h;
            fVar.f12599b = true;
            ArrayList arrayList = fVar.f12608l;
            u.a aVar = (u.a) dVar;
            int i10 = aVar.f12032r0;
            boolean z10 = aVar.f12033s0;
            int i11 = 0;
            if (i10 == 0) {
                fVar.f12602e = 4;
                while (i11 < aVar.f12144q0) {
                    u.d dVar2 = aVar.f12143p0[i11];
                    if (z10 || dVar2.f12071f0 != 8) {
                        f fVar2 = dVar2.f12066d.f12628h;
                        fVar2.f12607k.add(fVar);
                        arrayList.add(fVar2);
                    }
                    i11++;
                }
                m(this.f12623b.f12066d.f12628h);
                m(this.f12623b.f12066d.f12629i);
                return;
            }
            if (i10 == 1) {
                fVar.f12602e = 5;
                while (i11 < aVar.f12144q0) {
                    u.d dVar3 = aVar.f12143p0[i11];
                    if (z10 || dVar3.f12071f0 != 8) {
                        f fVar3 = dVar3.f12066d.f12629i;
                        fVar3.f12607k.add(fVar);
                        arrayList.add(fVar3);
                    }
                    i11++;
                }
                m(this.f12623b.f12066d.f12628h);
                m(this.f12623b.f12066d.f12629i);
                return;
            }
            if (i10 == 2) {
                fVar.f12602e = 6;
                while (i11 < aVar.f12144q0) {
                    u.d dVar4 = aVar.f12143p0[i11];
                    if (z10 || dVar4.f12071f0 != 8) {
                        f fVar4 = dVar4.f12068e.f12628h;
                        fVar4.f12607k.add(fVar);
                        arrayList.add(fVar4);
                    }
                    i11++;
                }
                m(this.f12623b.f12068e.f12628h);
                m(this.f12623b.f12068e.f12629i);
                return;
            }
            if (i10 != 3) {
                return;
            }
            fVar.f12602e = 7;
            while (i11 < aVar.f12144q0) {
                u.d dVar5 = aVar.f12143p0[i11];
                if (z10 || dVar5.f12071f0 != 8) {
                    f fVar5 = dVar5.f12068e.f12629i;
                    fVar5.f12607k.add(fVar);
                    arrayList.add(fVar5);
                }
                i11++;
            }
            m(this.f12623b.f12068e.f12628h);
            m(this.f12623b.f12068e.f12629i);
        }
    }

    @Override // v.o
    public final void e() {
        u.d dVar = this.f12623b;
        if (dVar instanceof u.a) {
            int i10 = ((u.a) dVar).f12032r0;
            f fVar = this.f12628h;
            if (i10 == 0 || i10 == 1) {
                dVar.X = fVar.g;
            } else {
                dVar.Y = fVar.g;
            }
        }
    }

    @Override // v.o
    public final void f() {
        this.f12624c = null;
        this.f12628h.c();
    }

    @Override // v.o
    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        f fVar2 = this.f12628h;
        fVar2.f12607k.add(fVar);
        fVar.f12608l.add(fVar2);
    }
}
