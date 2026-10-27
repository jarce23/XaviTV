package app.shamel.tv.activities;

import android.content.Intent;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1873o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ f.j f1874p;

    public /* synthetic */ c(f.j jVar, int i10) {
        this.f1873o = i10;
        this.f1874p = jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f1873o;
        f.j jVar = this.f1874p;
        switch (i10) {
            case 0:
                AddGroupActivity addGroupActivity = (AddGroupActivity) jVar;
                int i11 = AddGroupActivity.f1570f0;
                androidx.fragment.app.j0 n10 = addGroupActivity.n();
                androidx.fragment.app.a i12 = android.support.v4.media.d.i(n10, n10);
                androidx.fragment.app.s A = n10.A("fragment_add_channel");
                if (A == null) {
                    String str = addGroupActivity.f1572b0;
                    int i13 = addGroupActivity.Z;
                    h5.f fVar = new h5.f();
                    fVar.F0 = str;
                    fVar.f5596z0 = i13;
                    fVar.G0 = new d(addGroupActivity);
                    fVar.M(n10, "fragment_add_channel");
                    break;
                } else {
                    android.support.v4.media.d.v(i12, A, false);
                    break;
                }
            case 1:
                AddGroupActivity addGroupActivity2 = (AddGroupActivity) jVar;
                int i14 = AddGroupActivity.f1570f0;
                addGroupActivity2.getClass();
                Intent intent = new Intent();
                intent.putExtra("is_changed", "add_group");
                addGroupActivity2.setResult(-1, intent);
                addGroupActivity2.finish();
                break;
            default:
                CatchUpPlayerActivity catchUpPlayerActivity = (CatchUpPlayerActivity) jVar;
                if (catchUpPlayerActivity.Z.getVisibility() == 8) {
                    catchUpPlayerActivity.Z.setVisibility(0);
                    catchUpPlayerActivity.f1592k0.removeCallbacks(catchUpPlayerActivity.W);
                    catchUpPlayerActivity.u();
                    break;
                } else {
                    catchUpPlayerActivity.Z.setVisibility(8);
                    break;
                }
        }
    }
}
