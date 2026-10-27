package y4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final p4.f f13836o;

    /* renamed from: p, reason: collision with root package name */
    public final p4.l f13837p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f13838q;

    /* renamed from: r, reason: collision with root package name */
    public final int f13839r;

    public m(p4.f fVar, p4.l lVar, boolean z10, int i10) {
        za.h.e("processor", fVar);
        za.h.e("token", lVar);
        this.f13836o = fVar;
        this.f13837p = lVar;
        this.f13838q = z10;
        this.f13839r = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean k10;
        p4.s b2;
        if (this.f13838q) {
            p4.f fVar = this.f13836o;
            p4.l lVar = this.f13837p;
            int i10 = this.f13839r;
            fVar.getClass();
            String str = lVar.f9939a.f13557a;
            synchronized (fVar.f9926k) {
                b2 = fVar.b(str);
            }
            k10 = p4.f.e(str, b2, i10);
        } else {
            k10 = this.f13836o.k(this.f13837p, this.f13839r);
        }
        o4.p.d().a(o4.p.f("StopWorkRunnable"), "StopWorkRunnable for " + this.f13837p.f9939a.f13557a + "; Processor.stopWork = " + k10);
    }
}
