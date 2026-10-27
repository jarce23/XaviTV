package s1;

import android.util.Pair;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11445o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ v0 f11446p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Pair f11447q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ c2.z f11448r;

    public /* synthetic */ r0(v0 v0Var, Pair pair, c2.z zVar, int i10) {
        this.f11445o = i10;
        this.f11446p = v0Var;
        this.f11447q = pair;
        this.f11448r = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11445o) {
            case 0:
                t1.o oVar = (t1.o) this.f11446p.f11474p.f4319i;
                Pair pair = this.f11447q;
                int intValue = ((Integer) pair.first).intValue();
                c2.d0 d0Var = (c2.d0) pair.second;
                d0Var.getClass();
                oVar.G(intValue, d0Var, this.f11448r);
                break;
            default:
                t1.o oVar2 = (t1.o) this.f11446p.f11474p.f4319i;
                Pair pair2 = this.f11447q;
                oVar2.F(((Integer) pair2.first).intValue(), (c2.d0) pair2.second, this.f11448r);
                break;
        }
    }
}
