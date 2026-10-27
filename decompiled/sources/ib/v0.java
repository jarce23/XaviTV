package ib;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v0 extends u0 {

    /* renamed from: e, reason: collision with root package name */
    public final y0 f6603e;

    /* renamed from: f, reason: collision with root package name */
    public final w0 f6604f;
    public final j g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f6605h;

    public v0(y0 y0Var, w0 w0Var, j jVar, Object obj) {
        this.f6603e = y0Var;
        this.f6604f = w0Var;
        this.g = jVar;
        this.f6605h = obj;
    }

    @Override // ib.m0
    public final void d(Throwable th) {
        j F = y0.F(this.g);
        y0 y0Var = this.f6603e;
        w0 w0Var = this.f6604f;
        Object obj = this.f6605h;
        if (F != null) {
            while (v.e(F.f6566e, false, new v0(y0Var, w0Var, F, obj), 1) == a1.f6543a) {
                F = y0.F(F);
                if (F == null) {
                }
            }
            return;
        }
        y0Var.i(y0Var.t(w0Var, obj));
    }
}
