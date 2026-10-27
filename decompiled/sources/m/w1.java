package m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w1 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8593o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ z1 f8594p;

    public /* synthetic */ w1(z1 z1Var, int i10) {
        this.f8593o = i10;
        this.f8594p = z1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8593o) {
            case 0:
                o1 o1Var = this.f8594p.f8611q;
                if (o1Var != null) {
                    o1Var.setListSelectionHidden(true);
                    o1Var.requestLayout();
                    break;
                }
                break;
            default:
                z1 z1Var = this.f8594p;
                o1 o1Var2 = z1Var.f8611q;
                if (o1Var2 != null && o1Var2.isAttachedToWindow() && z1Var.f8611q.getCount() > z1Var.f8611q.getChildCount() && z1Var.f8611q.getChildCount() <= z1Var.A) {
                    z1Var.N.setInputMethodMode(2);
                    z1Var.c();
                    break;
                }
                break;
        }
    }
}
