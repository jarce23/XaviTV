package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements e1 {

    /* renamed from: o, reason: collision with root package name */
    public final e1 f2529o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2530p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ d f2531q;

    public c(d dVar, e1 e1Var) {
        this.f2531q = dVar;
        this.f2529o = e1Var;
    }

    @Override // c2.e1
    public final int f(x4.e eVar, r1.e eVar2, int i10) {
        d dVar = this.f2531q;
        if (dVar.d()) {
            return -3;
        }
        if (this.f2530p) {
            eVar2.f8759p = 4;
            return -4;
        }
        long m10 = dVar.m();
        int f10 = this.f2529o.f(eVar, eVar2, i10);
        if (f10 != -5) {
            long j10 = dVar.f2537t;
            if (j10 == Long.MIN_VALUE || ((f10 != -4 || eVar2.f10412u < j10) && !(f10 == -3 && m10 == Long.MIN_VALUE && !eVar2.f10411t))) {
                return f10;
            }
            eVar2.j();
            eVar2.f8759p = 4;
            this.f2530p = true;
            return -4;
        }
        i1.p pVar = (i1.p) eVar.f13543q;
        pVar.getClass();
        int i11 = pVar.J;
        int i12 = pVar.I;
        if (i12 == 0 && i11 == 0) {
            return -5;
        }
        if (dVar.f2536s != 0) {
            i12 = 0;
        }
        if (dVar.f2537t != Long.MIN_VALUE) {
            i11 = 0;
        }
        i1.o a10 = pVar.a();
        a10.H = i12;
        a10.I = i11;
        eVar.f13543q = new i1.p(a10);
        return -5;
    }

    @Override // c2.e1
    public final boolean isReady() {
        return !this.f2531q.d() && this.f2529o.isReady();
    }

    @Override // c2.e1
    public final void r() {
        this.f2529o.r();
    }

    @Override // c2.e1
    public final int t(long j10) {
        if (this.f2531q.d()) {
            return -3;
        }
        return this.f2529o.t(j10);
    }
}
