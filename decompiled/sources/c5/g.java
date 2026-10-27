package c5;

import android.content.Intent;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
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
public final class g implements b0, h7.j, androidx.activity.result.b, Callback, s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ LiveMobileActivity f2935o;

    public /* synthetic */ g(LiveMobileActivity liveMobileActivity) {
        this.f2935o = liveMobileActivity;
    }

    @Override // h5.b0
    public void a(EPGChannel ePGChannel) {
        LiveMobileActivity liveMobileActivity = this.f2935o;
        liveMobileActivity.I();
        if (!liveMobileActivity.f1969n0.getText().toString().isEmpty()) {
            int i10 = liveMobileActivity.R0;
            if (i10 <= 4 || i10 >= liveMobileActivity.f1978w0.s().size() + 5) {
                liveMobileActivity.f1964j0 = a6.n.K().w((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0), _UrlKt.FRAGMENT_ENCODE_SET, liveMobileActivity.f1978w0.g(), 0);
            } else if (liveMobileActivity.f1978w0.s().size() > 0) {
                a6.n K = a6.n.K();
                r rVar = liveMobileActivity.f1978w0;
                liveMobileActivity.f1964j0 = K.s(_UrlKt.FRAGMENT_ENCODE_SET, rVar.t((String) rVar.s().get(liveMobileActivity.R0 - 5)));
            }
            liveMobileActivity.f1969n0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
        }
        ArrayList arrayList = new ArrayList(liveMobileActivity.f1964j0);
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
        liveMobileActivity.S0 = i11;
        liveMobileActivity.f1980y0.e0(i11);
        liveMobileActivity.G(ePGChannel);
        if (liveMobileActivity.f1978w0.g()) {
            liveMobileActivity.N(null);
        } else {
            LiveMobileActivity.u(liveMobileActivity, liveMobileActivity.V0);
        }
        liveMobileActivity.y(liveMobileActivity.S0);
        liveMobileActivity.O(liveMobileActivity.B0.is_favorite());
        liveMobileActivity.f1973r0.setVisibility(0);
        liveMobileActivity.X0.removeCallbacks(liveMobileActivity.f1970o0);
        liveMobileActivity.F();
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
        LiveMobileActivity liveMobileActivity = this.f2935o;
        if (equalsIgnoreCase) {
            liveMobileActivity.W0 = true;
            liveMobileActivity.L();
            liveMobileActivity.R0 = liveMobileActivity.f1978w0.c();
            liveMobileActivity.S0 = liveMobileActivity.f1978w0.d();
            n0 w10 = a6.n.K().w((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0), _UrlKt.FRAGMENT_ENCODE_SET, liveMobileActivity.f1978w0.g(), liveMobileActivity.f1978w0.o());
            liveMobileActivity.f1964j0 = w10;
            if (liveMobileActivity.S0 > w10.size() - 1) {
                liveMobileActivity.S0 = 0;
            }
            liveMobileActivity.f1954d0.q(liveMobileActivity.S0, liveMobileActivity.f1964j0);
            liveMobileActivity.B0 = (EPGChannel) liveMobileActivity.f1964j0.get(liveMobileActivity.S0);
            liveMobileActivity.f1979x0.e0(liveMobileActivity.R0);
            d5.n0 n0Var = liveMobileActivity.f1950b0;
            int i10 = liveMobileActivity.R0;
            int i11 = n0Var.f4147l;
            n0Var.f4147l = i10;
            n0Var.e(i11);
            n0Var.e(n0Var.f4147l);
            if (liveMobileActivity.f1978w0.g()) {
                liveMobileActivity.N(null);
            } else {
                liveMobileActivity.X0.removeCallbacks(liveMobileActivity.f1967l0);
                liveMobileActivity.B(liveMobileActivity.B0.getStream_id());
            }
            String name = liveMobileActivity.B0.getName();
            liveMobileActivity.f1958f0 = name;
            liveMobileActivity.K0.setText(name);
            liveMobileActivity.O(liveMobileActivity.B0.is_favorite());
            liveMobileActivity.y(liveMobileActivity.S0);
        } else if (intent.getStringExtra("is_changed").equalsIgnoreCase("add_group")) {
            List a10 = liveMobileActivity.f1978w0.a();
            liveMobileActivity.f1952c0 = a10;
            d5.n0 n0Var2 = liveMobileActivity.f1950b0;
            n0Var2.f4140d = a10;
            n0Var2.d();
            liveMobileActivity.f1979x0.requestFocus();
        }
        liveMobileActivity.G(liveMobileActivity.B0);
        liveMobileActivity.f1980y0.requestFocus();
        liveMobileActivity.f1980y0.e0(liveMobileActivity.S0);
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void d(h7.h hVar, String str) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void f(h7.h hVar, int i10) {
    }

    @Override // h7.j
    public void g(h7.h hVar, boolean z10) {
        int i10 = LiveMobileActivity.f1947k1;
        LiveMobileActivity liveMobileActivity = this.f2935o;
        liveMobileActivity.getClass();
        LiveMobileActivity.w(liveMobileActivity);
    }

    @Override // h7.j
    public void h(h7.h hVar, int i10) {
        LiveMobileActivity liveMobileActivity = this.f2935o;
        liveMobileActivity.X.setImageResource(R.drawable.ic_pause);
        liveMobileActivity.Z.setEnabled(true);
        liveMobileActivity.P0.setEnabled(true);
        liveMobileActivity.Z.setAlpha(1.0f);
        liveMobileActivity.P0.setAlpha(1.0f);
        a0 a0Var = liveMobileActivity.f1976u0;
        if (a0Var != null) {
            a0Var.U(true);
        }
    }

    @Override // h7.j
    public void i(h7.h hVar, String str) {
        LiveMobileActivity liveMobileActivity = this.f2935o;
        liveMobileActivity.X.setImageResource(R.drawable.ic_pause);
        liveMobileActivity.Z.setEnabled(false);
        liveMobileActivity.P0.setEnabled(false);
        liveMobileActivity.Z.setAlpha(0.3f);
        liveMobileActivity.P0.setAlpha(0.3f);
        LiveMobileActivity.w(liveMobileActivity);
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        LiveMobileActivity liveMobileActivity = this.f2935o;
        if (!((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0)).getId().equalsIgnoreCase("resume_id")) {
            liveMobileActivity.f1950b0.e(0);
            return;
        }
        liveMobileActivity.f1954d0.d();
        liveMobileActivity.f1954d0.p(0);
        liveMobileActivity.f1980y0.e0(0);
        liveMobileActivity.S0 = 0;
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
        int i10 = LiveMobileActivity.f1947k1;
        this.f2935o.N(null);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        Object body = response.body();
        LiveMobileActivity liveMobileActivity = this.f2935o;
        if (body == null || ((CatchUpEpgResponse) response.body()).getEpg_listings() == null || ((CatchUpEpgResponse) response.body()).getEpg_listings().size() <= 0) {
            int i10 = LiveMobileActivity.f1947k1;
            liveMobileActivity.N(null);
        } else {
            List<CatchUpEpg> epg_listings = ((CatchUpEpgResponse) response.body()).getEpg_listings();
            int i11 = LiveMobileActivity.f1947k1;
            liveMobileActivity.N(epg_listings);
            liveMobileActivity.f1966k0 = ((CatchUpEpgResponse) response.body()).getEpg_listings();
        }
    }
}
