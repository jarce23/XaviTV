package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class p0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2677o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ u0 f2678p;

    public /* synthetic */ p0(u0 u0Var, int i10) {
        this.f2677o = i10;
        this.f2678p = u0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2677o) {
            case 0:
                this.f2678p.W = true;
                break;
            case 1:
                this.f2678p.A();
                break;
            default:
                u0 u0Var = this.f2678p;
                if (!u0Var.f2723c0) {
                    a0 a0Var = u0Var.F;
                    a0Var.getClass();
                    a0Var.b(u0Var);
                    break;
                }
                break;
        }
    }
}
