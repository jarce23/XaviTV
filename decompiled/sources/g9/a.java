package g9;

import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5325o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ q f5326p;

    public /* synthetic */ a(q qVar, int i10) {
        this.f5325o = i10;
        this.f5326p = qVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        switch (this.f5325o) {
            case 0:
                d dVar = (d) this.f5326p;
                dVar.s(dVar.t());
                break;
            default:
                m mVar = (m) this.f5326p;
                mVar.f5357l = z10;
                mVar.p();
                if (!z10) {
                    mVar.s(false);
                    mVar.f5358m = false;
                    break;
                }
                break;
        }
    }
}
