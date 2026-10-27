package c5;

import android.content.Intent;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.helper.r;
import app.shamel.tv.helper.s;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CatchUpEpgResponse;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import h5.b0;
import io.realm.n0;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import s1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements b0, h7.j, androidx.activity.result.b, Callback, s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ LiveChannelMobileActivity f2926o;

    public /* synthetic */ b(LiveChannelMobileActivity liveChannelMobileActivity) {
        this.f2926o = liveChannelMobileActivity;
    }

    @Override // h5.b0
    public void a(EPGChannel ePGChannel) {
        LiveChannelMobileActivity liveChannelMobileActivity = this.f2926o;
        liveChannelMobileActivity.H();
        if (!liveChannelMobileActivity.f1934n0.getText().toString().isEmpty()) {
            int i10 = liveChannelMobileActivity.Q0;
            if (i10 <= 4 || i10 >= liveChannelMobileActivity.f1942v0.s().size() + 5) {
                liveChannelMobileActivity.f1928i0 = a6.n.K().w((CategoryModel) liveChannelMobileActivity.f1916b0.get(liveChannelMobileActivity.Q0), _UrlKt.FRAGMENT_ENCODE_SET, liveChannelMobileActivity.f1942v0.g(), 0);
            } else if (!liveChannelMobileActivity.f1942v0.s().isEmpty()) {
                a6.n K = a6.n.K();
                r rVar = liveChannelMobileActivity.f1942v0;
                liveChannelMobileActivity.f1928i0 = K.s(_UrlKt.FRAGMENT_ENCODE_SET, rVar.t((String) rVar.s().get(liveChannelMobileActivity.Q0 - 5)));
            }
            liveChannelMobileActivity.f1934n0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
        }
        ArrayList arrayList = new ArrayList(liveChannelMobileActivity.f1928i0);
        int i11 = 0;
        while (true) {
            if (i11 >= arrayList.size()) {
                i11 = 0;
                break;
            } else if (((EPGChannel) arrayList.get(i11)).getName().equalsIgnoreCase(ePGChannel.getName())) {
                break;
            } else {
                i11++;
            }
        }
        liveChannelMobileActivity.R0 = i11;
        liveChannelMobileActivity.f1943w0.e0(i11);
        liveChannelMobileActivity.F(ePGChannel);
        if (liveChannelMobileActivity.f1942v0.g()) {
            liveChannelMobileActivity.M(null);
        } else {
            LiveChannelMobileActivity.u(liveChannelMobileActivity, liveChannelMobileActivity.U0);
        }
        liveChannelMobileActivity.x(liveChannelMobileActivity.R0);
        liveChannelMobileActivity.N(liveChannelMobileActivity.f1946z0.is_favorite());
        liveChannelMobileActivity.f1937q0.setVisibility(0);
        liveChannelMobileActivity.W0.removeCallbacks(liveChannelMobileActivity.f1932l0);
        liveChannelMobileActivity.E();
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void b(h7.h hVar, int i10) {
    }

    @Override // androidx.activity.result.b
    public void c(Object obj) {
        Intent intent;
        androidx.activity.result.a aVar = (androidx.activity.result.a) obj;
        if (aVar.f330o != -1 || (intent = aVar.f331p) == null) {
            return;
        }
        boolean equalsIgnoreCase = intent.getStringExtra("is_changed").equalsIgnoreCase("from_search");
        LiveChannelMobileActivity liveChannelMobileActivity = this.f2926o;
        if (equalsIgnoreCase) {
            liveChannelMobileActivity.V0 = true;
            liveChannelMobileActivity.K();
            liveChannelMobileActivity.Q0 = liveChannelMobileActivity.f1942v0.c();
            liveChannelMobileActivity.R0 = liveChannelMobileActivity.f1942v0.d();
            n0 w10 = a6.n.K().w((CategoryModel) liveChannelMobileActivity.f1916b0.get(liveChannelMobileActivity.Q0), _UrlKt.FRAGMENT_ENCODE_SET, liveChannelMobileActivity.f1942v0.g(), liveChannelMobileActivity.f1942v0.o());
            liveChannelMobileActivity.f1928i0 = w10;
            if (liveChannelMobileActivity.R0 > w10.size() - 1) {
                liveChannelMobileActivity.R0 = 0;
            }
            liveChannelMobileActivity.f1918c0.q(liveChannelMobileActivity.R0, liveChannelMobileActivity.f1928i0);
            liveChannelMobileActivity.f1946z0 = (EPGChannel) liveChannelMobileActivity.f1928i0.get(liveChannelMobileActivity.R0);
            if (liveChannelMobileActivity.f1942v0.g()) {
                liveChannelMobileActivity.M(null);
            } else {
                liveChannelMobileActivity.W0.removeCallbacks(liveChannelMobileActivity.f1931k0);
                liveChannelMobileActivity.A(liveChannelMobileActivity.f1946z0.getStream_id());
            }
            String name = liveChannelMobileActivity.f1946z0.getName();
            liveChannelMobileActivity.f1922e0 = name;
            liveChannelMobileActivity.J0.setText(name);
            liveChannelMobileActivity.N(liveChannelMobileActivity.f1946z0.is_favorite());
            liveChannelMobileActivity.x(liveChannelMobileActivity.R0);
        }
        liveChannelMobileActivity.F(liveChannelMobileActivity.f1946z0);
        liveChannelMobileActivity.f1943w0.requestFocus();
        liveChannelMobileActivity.f1943w0.e0(liveChannelMobileActivity.R0);
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void d(h7.h hVar, String str) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void f(h7.h hVar, int i10) {
    }

    @Override // h7.j
    public void g(h7.h hVar, boolean z10) {
        LiveChannelMobileActivity liveChannelMobileActivity = this.f2926o;
        liveChannelMobileActivity.X.setImageResource(R.drawable.ic_pause);
        liveChannelMobileActivity.Z.setEnabled(true);
        liveChannelMobileActivity.O0.setEnabled(true);
        liveChannelMobileActivity.Z.setAlpha(1.0f);
        liveChannelMobileActivity.O0.setAlpha(1.0f);
        LiveChannelMobileActivity.v(liveChannelMobileActivity);
    }

    @Override // h7.j
    public void h(h7.h hVar, int i10) {
        int i11 = LiveChannelMobileActivity.f1913j1;
        a0 a0Var = this.f2926o.f1940t0;
        if (a0Var != null) {
            a0Var.U(true);
        }
    }

    @Override // h7.j
    public void i(h7.h hVar, String str) {
        LiveChannelMobileActivity liveChannelMobileActivity = this.f2926o;
        liveChannelMobileActivity.X.setImageResource(R.drawable.ic_pause);
        liveChannelMobileActivity.Z.setEnabled(false);
        liveChannelMobileActivity.O0.setEnabled(false);
        liveChannelMobileActivity.Z.setAlpha(0.3f);
        liveChannelMobileActivity.O0.setAlpha(0.3f);
        LiveChannelMobileActivity.v(liveChannelMobileActivity);
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        LiveChannelMobileActivity liveChannelMobileActivity = this.f2926o;
        if (((CategoryModel) liveChannelMobileActivity.f1916b0.get(liveChannelMobileActivity.Q0)).getId().equalsIgnoreCase("resume_id")) {
            liveChannelMobileActivity.f1918c0.d();
            liveChannelMobileActivity.f1918c0.p(0);
            liveChannelMobileActivity.f1943w0.e0(0);
            liveChannelMobileActivity.R0 = 0;
        }
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void k(h7.h hVar) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void m(h7.h hVar, int i10) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void n(h7.h hVar) {
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        int i10 = LiveChannelMobileActivity.f1913j1;
        this.f2926o.M(null);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        Object body = response.body();
        LiveChannelMobileActivity liveChannelMobileActivity = this.f2926o;
        if (body == null || ((CatchUpEpgResponse) response.body()).getEpg_listings() == null || ((CatchUpEpgResponse) response.body()).getEpg_listings().size() <= 0) {
            int i10 = LiveChannelMobileActivity.f1913j1;
            liveChannelMobileActivity.M(null);
        } else {
            List<CatchUpEpg> epg_listings = ((CatchUpEpgResponse) response.body()).getEpg_listings();
            int i11 = LiveChannelMobileActivity.f1913j1;
            liveChannelMobileActivity.M(epg_listings);
            liveChannelMobileActivity.f1930j0 = ((CatchUpEpgResponse) response.body()).getEpg_listings();
        }
    }
}
