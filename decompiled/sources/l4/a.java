package l4;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import j9.v1;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends m {
    public ArrayList O;
    public boolean P;
    public int Q;
    public boolean R;
    public int S;

    @Override // l4.m
    public final void A(a.a aVar) {
        this.S |= 8;
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((m) this.O.get(i10)).A(aVar);
        }
    }

    @Override // l4.m
    public final void B(TimeInterpolator timeInterpolator) {
        this.S |= 1;
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((m) this.O.get(i10)).B(timeInterpolator);
            }
        }
        this.f8238r = timeInterpolator;
    }

    @Override // l4.m
    public final void C(v1 v1Var) {
        super.C(v1Var);
        this.S |= 4;
        if (this.O != null) {
            for (int i10 = 0; i10 < this.O.size(); i10++) {
                ((m) this.O.get(i10)).C(v1Var);
            }
        }
    }

    @Override // l4.m
    public final void D() {
        this.S |= 2;
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((m) this.O.get(i10)).D();
        }
    }

    @Override // l4.m
    public final void E(long j10) {
        this.f8236p = j10;
    }

    @Override // l4.m
    public final String G(String str) {
        String G = super.G(str);
        for (int i10 = 0; i10 < this.O.size(); i10++) {
            StringBuilder a10 = s.e.a(G, "\n");
            a10.append(((m) this.O.get(i10)).G(str + "  "));
            G = a10.toString();
        }
        return G;
    }

    public final void H(m mVar) {
        this.O.add(mVar);
        mVar.f8243w = this;
        long j10 = this.f8237q;
        if (j10 >= 0) {
            mVar.z(j10);
        }
        if ((this.S & 1) != 0) {
            mVar.B(this.f8238r);
        }
        if ((this.S & 2) != 0) {
            mVar.D();
        }
        if ((this.S & 4) != 0) {
            mVar.C(this.J);
        }
        if ((this.S & 8) != 0) {
            mVar.A(null);
        }
    }

    @Override // l4.m
    public final void c(u uVar) {
        View view = uVar.f8258b;
        if (s(view)) {
            ArrayList arrayList = this.O;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                m mVar = (m) obj;
                if (mVar.s(view)) {
                    mVar.c(uVar);
                    uVar.f8259c.add(mVar);
                }
            }
        }
    }

    @Override // l4.m
    public final void cancel() {
        super.cancel();
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((m) this.O.get(i10)).cancel();
        }
    }

    @Override // l4.m
    public final void e(u uVar) {
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((m) this.O.get(i10)).e(uVar);
        }
    }

    @Override // l4.m
    public final void f(u uVar) {
        View view = uVar.f8258b;
        if (s(view)) {
            ArrayList arrayList = this.O;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                m mVar = (m) obj;
                if (mVar.s(view)) {
                    mVar.f(uVar);
                    uVar.f8259c.add(mVar);
                }
            }
        }
    }

    @Override // l4.m
    /* renamed from: i */
    public final m clone() {
        a aVar = (a) super.clone();
        aVar.O = new ArrayList();
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            m clone = ((m) this.O.get(i10)).clone();
            aVar.O.add(clone);
            clone.f8243w = aVar;
        }
        return aVar;
    }

    @Override // l4.m
    public final void k(ViewGroup viewGroup, x4.i iVar, x4.i iVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j10 = this.f8236p;
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) this.O.get(i10);
            if (j10 > 0 && (this.P || i10 == 0)) {
                long j11 = mVar.f8236p;
                if (j11 > 0) {
                    mVar.E(j11 + j10);
                } else {
                    mVar.E(j10);
                }
            }
            mVar.k(viewGroup, iVar, iVar2, arrayList, arrayList2);
        }
    }

    @Override // l4.m
    public final void v(View view) {
        super.v(view);
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((m) this.O.get(i10)).v(view);
        }
    }

    @Override // l4.m
    public final m w(k kVar) {
        super.w(kVar);
        return this;
    }

    @Override // l4.m
    public final void x(View view) {
        super.x(view);
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((m) this.O.get(i10)).x(view);
        }
    }

    @Override // l4.m
    public final void y() {
        if (this.O.isEmpty()) {
            F();
            l();
            return;
        }
        r rVar = new r();
        rVar.f8255b = this;
        ArrayList arrayList = this.O;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ((m) obj).a(rVar);
        }
        this.Q = this.O.size();
        if (this.P) {
            ArrayList arrayList2 = this.O;
            int size2 = arrayList2.size();
            while (i10 < size2) {
                Object obj2 = arrayList2.get(i10);
                i10++;
                ((m) obj2).y();
            }
            return;
        }
        for (int i12 = 1; i12 < this.O.size(); i12++) {
            ((m) this.O.get(i12 - 1)).a(new r((m) this.O.get(i12)));
        }
        m mVar = (m) this.O.get(0);
        if (mVar != null) {
            mVar.y();
        }
    }

    @Override // l4.m
    public final void z(long j10) {
        ArrayList arrayList;
        this.f8237q = j10;
        if (j10 < 0 || (arrayList = this.O) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((m) this.O.get(i10)).z(j10);
        }
    }
}
