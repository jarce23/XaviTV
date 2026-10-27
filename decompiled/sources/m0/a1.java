package m0;

import android.view.WindowInsets;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class a1 extends e1 {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets.Builder f8636c;

    public a1() {
        this.f8636c = z0.d();
    }

    @Override // m0.e1
    public q1 b() {
        WindowInsets build;
        a();
        build = this.f8636c.build();
        q1 g = q1.g(null, build);
        g.f8706a.o(this.f8650b);
        return g;
    }

    @Override // m0.e1
    public void d(e0.c cVar) {
        this.f8636c.setMandatorySystemGestureInsets(cVar.d());
    }

    @Override // m0.e1
    public void e(e0.c cVar) {
        this.f8636c.setStableInsets(cVar.d());
    }

    @Override // m0.e1
    public void f(e0.c cVar) {
        this.f8636c.setSystemGestureInsets(cVar.d());
    }

    @Override // m0.e1
    public void g(e0.c cVar) {
        this.f8636c.setSystemWindowInsets(cVar.d());
    }

    @Override // m0.e1
    public void h(e0.c cVar) {
        this.f8636c.setTappableElementInsets(cVar.d());
    }

    public a1(q1 q1Var) {
        super(q1Var);
        WindowInsets.Builder d6;
        WindowInsets f10 = q1Var.f();
        if (f10 != null) {
            d6 = z0.e(f10);
        } else {
            d6 = z0.d();
        }
        this.f8636c = d6;
    }
}
