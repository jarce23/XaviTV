package s1;

import android.util.Pair;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class s0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11450o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ v0 f11451p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Pair f11452q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ c2.u f11453r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ c2.z f11454s;

    public /* synthetic */ s0(v0 v0Var, Pair pair, c2.u uVar, c2.z zVar, int i10) {
        this.f11450o = i10;
        this.f11451p = v0Var;
        this.f11452q = pair;
        this.f11453r = uVar;
        this.f11454s = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11450o) {
            case 0:
                t1.o oVar = (t1.o) this.f11451p.f11474p.f4319i;
                Pair pair = this.f11452q;
                oVar.i(((Integer) pair.first).intValue(), (c2.d0) pair.second, this.f11453r, this.f11454s);
                break;
            default:
                t1.o oVar2 = (t1.o) this.f11451p.f11474p.f4319i;
                Pair pair2 = this.f11452q;
                oVar2.l(((Integer) pair2.first).intValue(), (c2.d0) pair2.second, this.f11453r, this.f11454s);
                break;
        }
    }
}
