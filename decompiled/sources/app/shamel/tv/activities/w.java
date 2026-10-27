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
public final class w implements h5.b0, androidx.activity.result.b, Callback, app.shamel.tv.helper.s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ LiveActivity f2067o;

    public /* synthetic */ w(LiveActivity liveActivity) {
        this.f2067o = liveActivity;
    }

    @Override // h5.b0
    public void a(EPGChannel ePGChannel) {
        int i10 = LiveActivity.f1645p1;
        LiveActivity liveActivity = this.f2067o;
        liveActivity.J();
        if (!liveActivity.f1648b0.getText().toString().isEmpty()) {
            int i11 = liveActivity.f1651c1;
            if (i11 <= 4 || i11 >= liveActivity.f1682x0.s().size() + 5) {
                liveActivity.X = a6.n.K().w((CategoryModel) liveActivity.Q.get(liveActivity.f1651c1), _UrlKt.FRAGMENT_ENCODE_SET, liveActivity.f1682x0.g(), 0);
            } else if (liveActivity.f1682x0.s().size() > 0) {
                a6.n K = a6.n.K();
                app.shamel.tv.helper.r rVar = liveActivity.f1682x0;
                liveActivity.X = K.s(_UrlKt.FRAGMENT_ENCODE_SET, rVar.t((String) rVar.s().get(liveActivity.f1651c1 - 5)));
            }
            liveActivity.f1648b0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
        }
        ArrayList arrayList = new ArrayList(liveActivity.X);
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
        liveActivity.f1653d1 = i12;
        liveActivity.f1684z0.setSelectedPosition(i12);
        liveActivity.H(ePGChannel);
        if (liveActivity.f1682x0.g()) {
            liveActivity.R(null);
        } else {
            liveActivity.A(liveActivity.f1661i1);
        }
        liveActivity.v(liveActivity.f1653d1);
        liveActivity.S(liveActivity.C0.is_favorite());
        liveActivity.f1675q0.setVisibility(0);
        liveActivity.f1667l1.removeCallbacks(liveActivity.f1650c0);
        liveActivity.E();
    }

    @Override // androidx.activity.result.b
    public void c(Object obj) {
        Intent intent;
        androidx.activity.result.a aVar = (androidx.activity.result.a) obj;
        if (aVar.f330o != -1 || (intent = aVar.f331p) == null) {
            return;
        }
        boolean equalsIgnoreCase = intent.getStringExtra("is_changed").equalsIgnoreCase("from_search");
        LiveActivity liveActivity = this.f2067o;
        if (equalsIgnoreCase) {
            liveActivity.f1665k1 = true;
            liveActivity.O();
            liveActivity.f1651c1 = liveActivity.f1682x0.c();
            liveActivity.f1653d1 = liveActivity.f1682x0.d();
            io.realm.n0 w10 = a6.n.K().w((CategoryModel) liveActivity.Q.get(liveActivity.f1651c1), _UrlKt.FRAGMENT_ENCODE_SET, liveActivity.f1682x0.g(), liveActivity.f1682x0.o());
            liveActivity.X = w10;
            if (liveActivity.f1653d1 > w10.size() - 1) {
                liveActivity.f1653d1 = 0;
            }
            liveActivity.R.q(liveActivity.f1653d1, liveActivity.X);
            liveActivity.C0 = (EPGChannel) liveActivity.X.get(liveActivity.f1653d1);
            liveActivity.f1683y0.setSelectedPosition(liveActivity.f1651c1);
            liveActivity.f1683y0.e0(liveActivity.f1651c1);
            d5.n0 n0Var = liveActivity.P;
            int i10 = liveActivity.f1651c1;
            int i11 = n0Var.f4147l;
            n0Var.f4147l = i10;
            n0Var.e(i11);
            n0Var.e(n0Var.f4147l);
            if (liveActivity.f1682x0.g()) {
                liveActivity.R(null);
            } else {
                liveActivity.f1667l1.removeCallbacks(liveActivity.Z);
                liveActivity.y(liveActivity.C0.getStream_id());
            }
            String name = liveActivity.C0.getName();
            liveActivity.T = name;
            liveActivity.S0.setText(name);
            liveActivity.S(liveActivity.C0.is_favorite());
            liveActivity.v(liveActivity.f1653d1);
        } else if (intent.getStringExtra("is_changed").equalsIgnoreCase("add_group")) {
            List a10 = liveActivity.f1682x0.a();
            liveActivity.Q = a10;
            d5.n0 n0Var2 = liveActivity.P;
            n0Var2.f4140d = a10;
            n0Var2.d();
            liveActivity.f1683y0.requestFocus();
        }
        liveActivity.H(liveActivity.C0);
        liveActivity.M(false);
        liveActivity.f1684z0.requestFocus();
        liveActivity.f1684z0.setSelectedPosition(liveActivity.f1653d1);
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        LiveActivity liveActivity = this.f2067o;
        if (!((CategoryModel) liveActivity.Q.get(liveActivity.f1651c1)).getId().equalsIgnoreCase("resume_id")) {
            liveActivity.P.e(0);
            return;
        }
        liveActivity.R.d();
        liveActivity.R.p(0);
        liveActivity.f1684z0.e0(0);
        liveActivity.f1684z0.setSelectedPosition(0);
        liveActivity.f1653d1 = 0;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        int i10 = LiveActivity.f1645p1;
        this.f2067o.R(null);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        Object body = response.body();
        LiveActivity liveActivity = this.f2067o;
        if (body == null || ((CatchUpEpgResponse) response.body()).getEpg_listings() == null || ((CatchUpEpgResponse) response.body()).getEpg_listings().size() <= 0) {
            int i10 = LiveActivity.f1645p1;
            liveActivity.R(null);
        } else {
            List<CatchUpEpg> epg_listings = ((CatchUpEpgResponse) response.body()).getEpg_listings();
            int i11 = LiveActivity.f1645p1;
            liveActivity.R(epg_listings);
            liveActivity.Y = ((CatchUpEpgResponse) response.body()).getEpg_listings();
        }
    }
}
