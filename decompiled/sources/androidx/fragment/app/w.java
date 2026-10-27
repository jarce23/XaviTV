package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w implements View.OnAttachStateChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ p0 f844o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ x f845p;

    public w(x xVar, p0 p0Var) {
        this.f845p = xVar;
        this.f844o = p0Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        p0 p0Var = this.f844o;
        s sVar = p0Var.f772c;
        p0Var.k();
        k.f((ViewGroup) sVar.S.getParent(), this.f845p.f847o).e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
