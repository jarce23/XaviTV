package h5;

import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5667o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ w f5668p;

    public /* synthetic */ v(w wVar, int i10) {
        this.f5667o = i10;
        this.f5668p = wVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5667o) {
            case 0:
                w wVar = this.f5668p;
                wVar.D0.a(wVar.H0);
                wVar.J(false, false);
                break;
            default:
                this.f5668p.J(false, false);
                break;
        }
    }
}
