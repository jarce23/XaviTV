package app.shamel.tv.activities;

import android.content.Intent;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CatchUpEpgResponse;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 implements app.shamel.tv.helper.s, h5.b0, androidx.activity.result.b, Callback {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ LiveChannelActivity f1864o;

    public /* synthetic */ a0(LiveChannelActivity liveChannelActivity) {
        this.f1864o = liveChannelActivity;
    }

    @Override // h5.b0
    public void a(EPGChannel ePGChannel) {
        int i10 = LiveChannelActivity.f1685m1;
        LiveChannelActivity liveChannelActivity = this.f1864o;
        liveChannelActivity.G();
        if (!liveChannelActivity.f1686a0.getText().toString().isEmpty()) {
            int i11 = liveChannelActivity.f1687a1;
            if (i11 <= 4 || i11 >= liveChannelActivity.f1718w0.s().size() + 5) {
                liveChannelActivity.W = a6.n.K().w((CategoryModel) liveChannelActivity.P.get(liveChannelActivity.f1687a1), _UrlKt.FRAGMENT_ENCODE_SET, liveChannelActivity.f1718w0.g(), 0);
            } else if (liveChannelActivity.f1718w0.s().size() > 0) {
                a6.n K = a6.n.K();
                app.shamel.tv.helper.r rVar = liveChannelActivity.f1718w0;
                liveChannelActivity.W = K.s(_UrlKt.FRAGMENT_ENCODE_SET, rVar.t((String) rVar.s().get(liveChannelActivity.f1687a1 - 5)));
            }
            liveChannelActivity.f1686a0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
        }
        ArrayList arrayList = new ArrayList(liveChannelActivity.W);
        int i12 = 0;
        while (true) {
            if (i12 >= arrayList.size()) {
                i12 = 0;
                break;
            } else if (((EPGChannel) arrayList.get(i12)).getName().equalsIgnoreCase(ePGChannel.getName())) {
                break;
            } else {
                i12++;
            }
        }
        liveChannelActivity.f1689b1 = i12;
        liveChannelActivity.f1719x0.setSelectedPosition(i12);
        liveChannelActivity.E(ePGChannel);
        if (liveChannelActivity.f1718w0.g()) {
            liveChannelActivity.N(null);
        } else {
            liveChannelActivity.z(liveChannelActivity.f1697f1);
        }
        liveChannelActivity.u(liveChannelActivity.f1689b1);
        liveChannelActivity.O(liveChannelActivity.A0.is_favorite());
        liveChannelActivity.f1711p0.setVisibility(0);
        liveChannelActivity.f1701i1.removeCallbacks(liveChannelActivity.f1688b0);
        liveChannelActivity.B();
    }

    @Override // androidx.activity.result.b
    public void c(Object obj) {
        Intent intent;
        androidx.activity.result.a aVar = (androidx.activity.result.a) obj;
        if (aVar.f330o != -1 || (intent = aVar.f331p) == null) {
            return;
        }
        boolean equalsIgnoreCase = intent.getStringExtra("is_changed").equalsIgnoreCase("from_search");
        LiveChannelActivity liveChannelActivity = this.f1864o;
        if (equalsIgnoreCase) {
            liveChannelActivity.h1 = true;
            liveChannelActivity.K();
            liveChannelActivity.f1687a1 = liveChannelActivity.f1718w0.c();
            liveChannelActivity.f1689b1 = liveChannelActivity.f1718w0.d();
            io.realm.n0 w10 = a6.n.K().w((CategoryModel) liveChannelActivity.P.get(liveChannelActivity.f1687a1), _UrlKt.FRAGMENT_ENCODE_SET, liveChannelActivity.f1718w0.g(), liveChannelActivity.f1718w0.o());
            liveChannelActivity.W = w10;
            if (liveChannelActivity.f1689b1 > w10.size() - 1) {
                liveChannelActivity.f1689b1 = 0;
            }
            liveChannelActivity.Q.q(liveChannelActivity.f1689b1, liveChannelActivity.W);
            liveChannelActivity.A0 = (EPGChannel) liveChannelActivity.W.get(liveChannelActivity.f1689b1);
            if (liveChannelActivity.f1718w0.g()) {
                liveChannelActivity.N(null);
            } else {
                liveChannelActivity.f1701i1.removeCallbacks(liveChannelActivity.Y);
                liveChannelActivity.x(liveChannelActivity.A0.getStream_id());
            }
            String name = liveChannelActivity.A0.getName();
            liveChannelActivity.S = name;
            liveChannelActivity.Q0.setText(name);
            liveChannelActivity.O(liveChannelActivity.A0.is_favorite());
            liveChannelActivity.u(liveChannelActivity.f1689b1);
        }
        liveChannelActivity.E(liveChannelActivity.A0);
        liveChannelActivity.I(false);
        liveChannelActivity.f1719x0.requestFocus();
        liveChannelActivity.f1719x0.setSelectedPosition(liveChannelActivity.f1689b1);
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        LiveChannelActivity liveChannelActivity = this.f1864o;
        if (((CategoryModel) liveChannelActivity.P.get(liveChannelActivity.f1687a1)).getId().equalsIgnoreCase("resume_id")) {
            liveChannelActivity.Q.d();
            liveChannelActivity.Q.p(0);
            liveChannelActivity.f1719x0.e0(0);
            liveChannelActivity.f1719x0.setSelectedPosition(0);
            liveChannelActivity.f1689b1 = 0;
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        int i10 = LiveChannelActivity.f1685m1;
        this.f1864o.N(null);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        Object body = response.body();
        LiveChannelActivity liveChannelActivity = this.f1864o;
        if (body == null || ((CatchUpEpgResponse) response.body()).getEpg_listings() == null || ((CatchUpEpgResponse) response.body()).getEpg_listings().size() <= 0) {
            int i10 = LiveChannelActivity.f1685m1;
            liveChannelActivity.N(null);
        } else {
            List<CatchUpEpg> epg_listings = ((CatchUpEpgResponse) response.body()).getEpg_listings();
            int i11 = LiveChannelActivity.f1685m1;
            liveChannelActivity.N(epg_listings);
            liveChannelActivity.X = ((CatchUpEpgResponse) response.body()).getEpg_listings();
        }
    }
}
