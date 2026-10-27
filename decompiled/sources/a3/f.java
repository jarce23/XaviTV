package a3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ma.j;
import o4.p;
import t4.h;
import x4.i;
import x4.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements h3.e {

    /* renamed from: o, reason: collision with root package name */
    public final List f27o;

    public f(List list) {
        this.f27o = list;
    }

    @Override // h3.e
    public int a(long j10) {
        return j10 < 0 ? 0 : -1;
    }

    public boolean b(o oVar) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f27o) {
            u4.d dVar = (u4.d) obj;
            dVar.getClass();
            if (dVar.b(oVar) && dVar.c(dVar.f12519a.a())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            p.d().a(h.f11884a, "Work " + oVar.f13569a + " constrained by " + j.F(arrayList, null, null, null, t4.f.f11880p, 31));
        }
        return arrayList.isEmpty();
    }

    @Override // h3.e
    public long l(int i10) {
        l1.d.b(i10 == 0);
        return 0L;
    }

    @Override // h3.e
    public List r(long j10) {
        return j10 >= 0 ? this.f27o : Collections.EMPTY_LIST;
    }

    @Override // h3.e
    public int w() {
        return 1;
    }

    public f(i iVar) {
        za.h.e("trackers", iVar);
        u4.a aVar = new u4.a((v4.f) iVar.f13553p, 0);
        u4.a aVar2 = new u4.a((v4.a) iVar.f13554q);
        u4.a aVar3 = new u4.a((v4.f) iVar.f13556s, 4);
        v4.f fVar = (v4.f) iVar.f13555r;
        this.f27o = ma.i.B(new u4.d[]{aVar, aVar2, aVar3, new u4.a(fVar, 2), new u4.a(fVar, 3), new u4.f(fVar), new u4.e(fVar)});
    }

    public f(ArrayList arrayList) {
        this.f27o = Collections.unmodifiableList(arrayList);
    }
}
