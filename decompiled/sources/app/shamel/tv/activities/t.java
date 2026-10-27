package app.shamel.tv.activities;

import app.shamel.tv.models.CategoryModel;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements app.shamel.tv.helper.s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2051o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ LiveActivity f2052p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f2053q;

    public /* synthetic */ t(LiveActivity liveActivity, int i10, int i11) {
        this.f2051o = i11;
        this.f2052p = liveActivity;
        this.f2053q = i10;
    }

    @Override // app.shamel.tv.helper.s
    public final void j() {
        switch (this.f2051o) {
            case 0:
                LiveActivity liveActivity = this.f2052p;
                if (((CategoryModel) liveActivity.Q.get(liveActivity.f1651c1)).getId().equalsIgnoreCase("fav_id")) {
                    io.realm.n0 w10 = a6.n.K().w((CategoryModel) liveActivity.Q.get(liveActivity.f1651c1), _UrlKt.FRAGMENT_ENCODE_SET, liveActivity.f1682x0.g(), liveActivity.f1682x0.o());
                    liveActivity.X = w10;
                    liveActivity.R.q(0, w10);
                } else {
                    liveActivity.R.e(this.f2053q);
                }
                liveActivity.f1682x0.S(a6.n.K().t());
                liveActivity.P.e(3);
                break;
            default:
                LiveActivity liveActivity2 = this.f2052p;
                if (((CategoryModel) liveActivity2.Q.get(liveActivity2.f1651c1)).getId().equalsIgnoreCase("lock_id")) {
                    io.realm.n0 w11 = a6.n.K().w((CategoryModel) liveActivity2.Q.get(liveActivity2.f1651c1), _UrlKt.FRAGMENT_ENCODE_SET, liveActivity2.f1682x0.g(), liveActivity2.f1682x0.o());
                    liveActivity2.X = w11;
                    liveActivity2.R.q(0, w11);
                } else {
                    liveActivity2.R.e(this.f2053q);
                }
                liveActivity2.f1682x0.T(a6.n.K().x());
                liveActivity2.P.e(4);
                break;
        }
    }
}
