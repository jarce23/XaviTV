package androidx.activity;

import androidx.fragment.app.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
final class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements androidx.lifecycle.p, c {

    /* renamed from: o, reason: collision with root package name */
    public final androidx.lifecycle.t f279o;

    /* renamed from: p, reason: collision with root package name */
    public final a0 f280p;

    /* renamed from: q, reason: collision with root package name */
    public w f281q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ y f282r;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(y yVar, androidx.lifecycle.t tVar, a0 a0Var) {
        za.h.e("onBackPressedCallback", a0Var);
        this.f282r = yVar;
        this.f279o = tVar;
        this.f280p = a0Var;
        tVar.a(this);
    }

    @Override // androidx.lifecycle.p
    public final void a(androidx.lifecycle.r rVar, androidx.lifecycle.l lVar) {
        if (lVar != androidx.lifecycle.l.ON_START) {
            if (lVar != androidx.lifecycle.l.ON_STOP) {
                if (lVar == androidx.lifecycle.l.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            } else {
                w wVar = this.f281q;
                if (wVar != null) {
                    wVar.cancel();
                    return;
                }
                return;
            }
        }
        y yVar = this.f282r;
        yVar.getClass();
        a0 a0Var = this.f280p;
        za.h.e("onBackPressedCallback", a0Var);
        yVar.f363b.addLast(a0Var);
        w wVar2 = new w(yVar, a0Var);
        a0Var.f645b.add(wVar2);
        yVar.d();
        a0Var.f646c = new x(0, yVar, y.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0, 1);
        this.f281q = wVar2;
    }

    @Override // androidx.activity.c
    public final void cancel() {
        this.f279o.f(this);
        this.f280p.f645b.remove(this);
        w wVar = this.f281q;
        if (wVar != null) {
            wVar.cancel();
        }
        this.f281q = null;
    }
}
