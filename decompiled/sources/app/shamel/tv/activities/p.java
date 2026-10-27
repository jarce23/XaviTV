package app.shamel.tv.activities;

import app.shamel.tv.models.AppInfoModel;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements h5.j, h5.t, h5.j0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ ChangePlaylistActivity f2041o;

    public /* synthetic */ p(ChangePlaylistActivity changePlaylistActivity) {
        this.f2041o = changePlaylistActivity;
    }

    @Override // h5.t
    public void a() {
        this.f2041o.finishAffinity();
        System.exit(0);
    }

    @Override // h5.j
    public void b() {
        ChangePlaylistActivity changePlaylistActivity = this.f2041o;
        changePlaylistActivity.F0 = false;
        changePlaylistActivity.f1599c0.J(false, false);
        AppInfoModel b2 = changePlaylistActivity.f1606k0.b();
        changePlaylistActivity.f1600d0 = b2;
        List<AppInfoModel.UrlModel> result = b2.getResult();
        changePlaylistActivity.A0 = result;
        d5.j0 j0Var = changePlaylistActivity.f1605j0;
        j0Var.f4120d = result;
        j0Var.d();
    }

    @Override // h5.j0
    public void f() {
        this.f2041o.C0 = -1;
    }

    @Override // h5.t
    public void e() {
    }
}
