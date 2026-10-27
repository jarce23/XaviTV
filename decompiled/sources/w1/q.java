package w1;

import c2.d1;
import c2.j0;
import i1.e0;
import i1.f0;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends d1 {
    public final Map H;
    public i1.l I;

    public q(g2.e eVar, v1.f fVar, j0 j0Var, Map map) {
        super(eVar, fVar, j0Var);
        this.H = map;
    }

    @Override // c2.d1
    public final i1.p m(i1.p pVar) {
        i1.l lVar;
        i1.l lVar2 = this.I;
        if (lVar2 == null) {
            lVar2 = pVar.f5995r;
        }
        if (lVar2 != null && (lVar = (i1.l) this.H.get(lVar2.f5917q)) != null) {
            lVar2 = lVar;
        }
        f0 f0Var = pVar.f5989l;
        f0 f0Var2 = null;
        if (f0Var != null) {
            e0[] e0VarArr = f0Var.f5876a;
            int length = e0VarArr.length;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    i11 = -1;
                    break;
                }
                e0 e0Var = e0VarArr[i11];
                if ((e0Var instanceof y2.n) && "com.apple.streaming.transportStreamTimestamp".equals(((y2.n) e0Var).f13801b)) {
                    break;
                }
                i11++;
            }
            if (i11 != -1) {
                if (length != 1) {
                    e0[] e0VarArr2 = new e0[length - 1];
                    while (i10 < length) {
                        if (i10 != i11) {
                            e0VarArr2[i10 < i11 ? i10 : i10 - 1] = e0VarArr[i10];
                        }
                        i10++;
                    }
                    f0Var2 = new f0(e0VarArr2);
                }
            }
            if (lVar2 == pVar.f5995r || f0Var != pVar.f5989l) {
                i1.o a10 = pVar.a();
                a10.f5944q = lVar2;
                a10.f5938k = f0Var;
                pVar = new i1.p(a10);
            }
            return super.m(pVar);
        }
        f0Var = f0Var2;
        if (lVar2 == pVar.f5995r) {
        }
        i1.o a102 = pVar.a();
        a102.f5944q = lVar2;
        a102.f5938k = f0Var;
        pVar = new i1.p(a102);
        return super.m(pVar);
    }
}
