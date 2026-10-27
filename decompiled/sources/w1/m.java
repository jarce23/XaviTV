package w1;

import a6.d0;
import c2.e1;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements e1 {

    /* renamed from: o, reason: collision with root package name */
    public final int f12832o;

    /* renamed from: p, reason: collision with root package name */
    public final r f12833p;

    /* renamed from: q, reason: collision with root package name */
    public int f12834q = -1;

    public m(r rVar, int i10) {
        this.f12833p = rVar;
        this.f12832o = i10;
    }

    public final void a() {
        l1.d.b(this.f12834q == -1);
        r rVar = this.f12833p;
        rVar.w();
        rVar.Y.getClass();
        int[] iArr = rVar.Y;
        int i10 = this.f12832o;
        int i11 = iArr[i10];
        if (i11 == -1) {
            if (rVar.X.contains(rVar.W.a(i10))) {
                i11 = -3;
            }
            i11 = -2;
        } else {
            boolean[] zArr = rVar.f12847b0;
            if (!zArr[i11]) {
                zArr[i11] = true;
            }
            i11 = -2;
        }
        this.f12834q = i11;
    }

    public final boolean b() {
        int i10 = this.f12834q;
        return (i10 == -1 || i10 == -3 || i10 == -2) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bf, code lost:
    
        if (((w1.j) r6.get(0)).f() == false) goto L59;
     */
    @Override // c2.e1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(x4.e r20, r1.e r21, int r22) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.m.f(x4.e, r1.e, int):int");
    }

    @Override // c2.e1
    public final boolean isReady() {
        if (this.f12834q == -3) {
            return true;
        }
        if (!b()) {
            return false;
        }
        int i10 = this.f12834q;
        r rVar = this.f12833p;
        return !rVar.E() && rVar.J[i10].u(rVar.h0);
    }

    @Override // c2.e1
    public final void r() {
        int i10 = this.f12834q;
        r rVar = this.f12833p;
        if (i10 == -2) {
            rVar.w();
            throw new d0(android.support.v4.media.d.q("Unable to bind a sample queue to TrackGroup with MIME type ", rVar.W.a(this.f12832o).f6042d[0].f5991n, "."));
        }
        if (i10 == -1) {
            rVar.G();
            return;
        }
        if (i10 != -3) {
            rVar.G();
            q qVar = rVar.J[i10];
            p4.p pVar = qVar.f2550h;
            if (pVar == null || pVar.h() != 1) {
                return;
            }
            v1.b f10 = qVar.f2550h.f();
            f10.getClass();
            throw f10;
        }
    }

    @Override // c2.e1
    public final int t(long j10) {
        Object next;
        Object obj;
        if (!b()) {
            return 0;
        }
        int i10 = this.f12834q;
        r rVar = this.f12833p;
        if (rVar.E()) {
            return 0;
        }
        q qVar = rVar.J[i10];
        int s10 = qVar.s(j10, rVar.h0);
        ArrayList arrayList = rVar.B;
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                obj = arrayList.get(arrayList.size() - 1);
            }
            obj = null;
        } else {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                do {
                    next = it.next();
                } while (it.hasNext());
                obj = next;
            }
            obj = null;
        }
        j jVar = (j) obj;
        if (jVar != null && !jVar.f()) {
            s10 = Math.min(s10, jVar.e(i10) - qVar.q());
        }
        qVar.D(s10);
        return s10;
    }
}
