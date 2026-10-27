package app.shamel.tv.activities;

import app.shamel.tv.models.CategoryModel;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 implements app.shamel.tv.helper.s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1870o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f1871p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ LiveChannelActivity f1872q;

    public /* synthetic */ b0(LiveChannelActivity liveChannelActivity, int i10, int i11) {
        this.f1870o = i11;
        this.f1872q = liveChannelActivity;
        this.f1871p = i10;
    }

    @Override // app.shamel.tv.helper.s
    public final void j() {
        switch (this.f1870o) {
            case 0:
                LiveChannelActivity liveChannelActivity = this.f1872q;
                if (((CategoryModel) liveChannelActivity.P.get(liveChannelActivity.f1687a1)).getId().equalsIgnoreCase("fav_id")) {
                    io.realm.n0 w10 = a6.n.K().w((CategoryModel) liveChannelActivity.P.get(liveChannelActivity.f1687a1), _UrlKt.FRAGMENT_ENCODE_SET, liveChannelActivity.f1718w0.g(), liveChannelActivity.f1718w0.o());
                    liveChannelActivity.W = w10;
                    liveChannelActivity.Q.q(0, w10);
                } else {
                    liveChannelActivity.Q.e(this.f1871p);
                }
                liveChannelActivity.f1718w0.S(a6.n.K().t());
                break;
            default:
                LiveChannelActivity liveChannelActivity2 = this.f1872q;
                if (((CategoryModel) liveChannelActivity2.P.get(liveChannelActivity2.f1687a1)).getId().equalsIgnoreCase("lock_id")) {
                    io.realm.n0 w11 = a6.n.K().w((CategoryModel) liveChannelActivity2.P.get(liveChannelActivity2.f1687a1), _UrlKt.FRAGMENT_ENCODE_SET, liveChannelActivity2.f1718w0.g(), liveChannelActivity2.f1718w0.o());
                    liveChannelActivity2.W = w11;
                    liveChannelActivity2.Q.q(0, w11);
                } else {
                    liveChannelActivity2.Q.e(this.f1871p);
                }
                liveChannelActivity2.f1718w0.T(a6.n.K().x());
                break;
        }
    }
}
