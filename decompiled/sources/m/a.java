package m;

import androidx.appcompat.widget.ActionBarContextView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements m0.q0 {

    /* renamed from: o, reason: collision with root package name */
    public boolean f8355o = false;

    /* renamed from: p, reason: collision with root package name */
    public int f8356p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ ActionBarContextView f8357q;

    public a(ActionBarContextView actionBarContextView) {
        this.f8357q = actionBarContextView;
    }

    @Override // m0.q0
    public final void c() {
        if (this.f8355o) {
            return;
        }
        ActionBarContextView actionBarContextView = this.f8357q;
        actionBarContextView.f403t = null;
        super/*android.view.ViewGroup*/.setVisibility(this.f8356p);
    }

    @Override // m0.q0
    public final void d() {
        this.f8355o = true;
    }

    @Override // m0.q0
    public final void e() {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.f8355o = false;
    }
}
