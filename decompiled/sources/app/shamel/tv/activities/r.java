package app.shamel.tv.activities;

import app.shamel.tv.models.AppInfoModel;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements ya.q {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ ChangePlaylistActivity f2048o;

    public r(ChangePlaylistActivity changePlaylistActivity) {
        this.f2048o = changePlaylistActivity;
    }

    @Override // ya.q
    public final Object c(Object obj, Serializable serializable, Serializable serializable2) {
        AppInfoModel.UrlModel urlModel = (AppInfoModel.UrlModel) obj;
        Integer num = (Integer) serializable;
        boolean booleanValue = ((Boolean) serializable2).booleanValue();
        la.i iVar = la.i.f8335a;
        ChangePlaylistActivity changePlaylistActivity = this.f2048o;
        if (!booleanValue) {
            changePlaylistActivity.D0 = num.intValue();
            return iVar;
        }
        if (num.intValue() == changePlaylistActivity.A0.size()) {
            ChangePlaylistActivity.Q(changePlaylistActivity, -1);
            return iVar;
        }
        changePlaylistActivity.E0 = urlModel;
        if (urlModel.getId().equalsIgnoreCase("0")) {
            ChangePlaylistActivity.P(changePlaylistActivity, changePlaylistActivity.E0);
            return iVar;
        }
        AppInfoModel.UrlModel urlModel2 = changePlaylistActivity.E0;
        int intValue = num.intValue();
        androidx.fragment.app.j0 n10 = changePlaylistActivity.n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_connect");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return iVar;
        }
        String name = urlModel2.getName();
        h5.n nVar = new h5.n();
        nVar.f5630y0 = changePlaylistActivity;
        nVar.B0 = name;
        nVar.D0 = new q(changePlaylistActivity, intValue, urlModel2);
        nVar.M(n10, "fragment_connect");
        return iVar;
    }
}
