package app.shamel.tv.activities;

import android.util.Log;
import okhttp3.internal.url._UrlKt;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u0 implements m5.l, app.shamel.tv.helper.s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2058o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SeriesInfoActivity f2059p;

    public /* synthetic */ u0(SeriesInfoActivity seriesInfoActivity, int i10) {
        this.f2058o = i10;
        this.f2059p = seriesInfoActivity;
    }

    @Override // m5.l
    public void a(Object obj) {
        String str = (String) obj;
        SeriesInfoActivity seriesInfoActivity = this.f2059p;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("info")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("info");
                if (jSONObject2.has("backdrop_path")) {
                    try {
                        seriesInfoActivity.f1814k0 = jSONObject2.getJSONArray("backdrop_path").getString(0);
                        com.bumptech.glide.b.e(seriesInfoActivity.getApplicationContext()).r(seriesInfoActivity.f1814k0).E(seriesInfoActivity.V);
                    } catch (Exception e7) {
                        seriesInfoActivity.f1814k0 = _UrlKt.FRAGMENT_ENCODE_SET;
                        Log.e("SeriesInfoActivity", "getSeriesInfo_001", e7);
                    }
                }
            }
        } catch (Exception e8) {
            Log.e("SeriesInfoActivity", "getSeriesInfo_002", e8);
        }
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        switch (this.f2058o) {
            case 1:
                this.f2059p.T.Z(a6.n.K().v());
                break;
            default:
                this.f2059p.T.Z(a6.n.K().v());
                break;
        }
    }
}
