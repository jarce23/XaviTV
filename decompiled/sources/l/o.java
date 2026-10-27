package l;

import android.view.ActionProvider;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements ActionProvider.VisibilityListener {

    /* renamed from: a, reason: collision with root package name */
    public h5.i f8039a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionProvider f8040b;

    public o(s sVar, ActionProvider actionProvider) {
        this.f8040b = actionProvider;
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z10) {
        h5.i iVar = this.f8039a;
        if (iVar != null) {
            l lVar = ((n) iVar.f5610p).f8026n;
            lVar.f7994h = true;
            lVar.p(true);
        }
    }
}
