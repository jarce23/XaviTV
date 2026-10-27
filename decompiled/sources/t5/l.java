package t5;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11959o;

    /* renamed from: p, reason: collision with root package name */
    public final i6.f f11960p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ o f11961q;

    public /* synthetic */ l(o oVar, i6.f fVar, int i10) {
        this.f11959o = i10;
        this.f11961q = oVar;
        this.f11960p = fVar;
    }

    private final void a() {
        i6.f fVar = this.f11960p;
        fVar.f6429b.a();
        synchronized (fVar.f6430c) {
            synchronized (this.f11961q) {
                try {
                    if (this.f11961q.f11965o.f11964o.contains(new m(this.f11960p, m6.f.f9014b))) {
                        o oVar = this.f11961q;
                        try {
                            this.f11960p.f(oVar.E, 5);
                        } catch (Throwable th) {
                            throw new b(th);
                        }
                    }
                    this.f11961q.d();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11959o) {
            case 0:
                a();
                return;
            default:
                i6.f fVar = this.f11960p;
                fVar.f6429b.a();
                synchronized (fVar.f6430c) {
                    synchronized (this.f11961q) {
                        try {
                            if (this.f11961q.f11965o.f11964o.contains(new m(this.f11960p, m6.f.f9014b))) {
                                this.f11961q.G.a();
                                o oVar = this.f11961q;
                                try {
                                    this.f11960p.h(oVar.G, oVar.C, oVar.J);
                                    this.f11961q.j(this.f11960p);
                                } catch (Throwable th) {
                                    throw new b(th);
                                }
                            }
                            this.f11961q.d();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
        }
    }
}
