package g5;

import android.view.View;
import h5.i;
import h5.k;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5156o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ i f5157p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ b f5158q;

    public /* synthetic */ a(b bVar, i iVar, int i10) {
        this.f5156o = i10;
        this.f5158q = bVar;
        this.f5157p = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5156o) {
            case 0:
                this.f5158q.dismiss();
                ((k) this.f5157p.f5610p).H0.b();
                break;
            default:
                this.f5158q.dismiss();
                ((k) this.f5157p.f5610p).H0.b();
                break;
        }
    }
}
