package app.shamel.tv.activities.mobile;

import a6.n;
import a6.q;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.e0;
import androidx.fragment.app.j0;
import androidx.fragment.app.s;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerView;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.activities.CatchUpActivity;
import app.shamel.tv.activities.MovieActivity;
import app.shamel.tv.activities.SearchActivity;
import app.shamel.tv.activities.SeriesActivity;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import app.shamel.tv.activities.y;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.helper.r;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.WordModels;
import c2.y0;
import c5.d;
import c5.h;
import d5.e;
import d5.m;
import d5.n0;
import e5.l;
import f.j;
import h5.h0;
import h7.b;
import h7.i;
import i1.c0;
import i1.d0;
import i1.u;
import i1.v;
import i1.w;
import i1.x;
import i1.z0;
import j5.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o1.g;
import o9.g0;
import o9.w0;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import r.a;
import s1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class LiveMobileActivity extends j implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: k1, reason: collision with root package name */
    public static final /* synthetic */ int f1947k1 = 0;
    public SeekBar A0;
    public EPGChannel B0;
    public z0 C0;
    public TextView D0;
    public TextView E0;
    public TextView F0;
    public TextView G0;
    public TextView H0;
    public TextView I0;
    public TextView J0;
    public TextView K0;
    public TextView L0;
    public y0 M;
    public TextView M0;
    public AudioManager N;
    public TextView N0;
    public SeekBar O;
    public View O0;
    public ImageButton P;
    public SeekBar P0;
    public Button Q;
    public WordModels Q0;
    public Button R;
    public ImageButton S;
    public ImageButton T;
    public ImageButton U;
    public ImageButton V;
    public ImageButton W;
    public ImageButton X;
    public ImageButton Y;
    public ImageButton Z;

    /* renamed from: a0, reason: collision with root package name */
    public Button f1948a0;

    /* renamed from: a1, reason: collision with root package name */
    public AspectRatioFrameLayout f1949a1;

    /* renamed from: b0, reason: collision with root package name */
    public n0 f1950b0;

    /* renamed from: b1, reason: collision with root package name */
    public d f1951b1;

    /* renamed from: c0, reason: collision with root package name */
    public List f1952c0;

    /* renamed from: c1, reason: collision with root package name */
    public MediaRouteButton f1953c1;

    /* renamed from: d0, reason: collision with root package name */
    public e f1954d0;

    /* renamed from: d1, reason: collision with root package name */
    public b f1955d1;

    /* renamed from: e0, reason: collision with root package name */
    public ImageView f1956e0;

    /* renamed from: e1, reason: collision with root package name */
    public i f1957e1;

    /* renamed from: f0, reason: collision with root package name */
    public String f1958f0;

    /* renamed from: f1, reason: collision with root package name */
    public TextView f1959f1;

    /* renamed from: g0, reason: collision with root package name */
    public String f1960g0;

    /* renamed from: g1, reason: collision with root package name */
    public h f1961g1;
    public g h0;
    public int h1;

    /* renamed from: i0, reason: collision with root package name */
    public m f1962i0;

    /* renamed from: j0, reason: collision with root package name */
    public io.realm.n0 f1964j0;

    /* renamed from: k0, reason: collision with root package name */
    public List f1966k0;

    /* renamed from: l0, reason: collision with root package name */
    public y f1967l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f1968m0;

    /* renamed from: n0, reason: collision with root package name */
    public EditText f1969n0;

    /* renamed from: o0, reason: collision with root package name */
    public h f1970o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f1971p0;

    /* renamed from: q0, reason: collision with root package name */
    public ImageView f1972q0;

    /* renamed from: r0, reason: collision with root package name */
    public ConstraintLayout f1973r0;

    /* renamed from: s0, reason: collision with root package name */
    public ConstraintLayout f1974s0;

    /* renamed from: t0, reason: collision with root package name */
    public ConstraintLayout f1975t0;

    /* renamed from: u0, reason: collision with root package name */
    public a0 f1976u0;

    /* renamed from: v0, reason: collision with root package name */
    public PlayerView f1977v0;

    /* renamed from: w0, reason: collision with root package name */
    public r f1978w0;

    /* renamed from: x0, reason: collision with root package name */
    public RecyclerView f1979x0;

    /* renamed from: y0, reason: collision with root package name */
    public RecyclerView f1980y0;

    /* renamed from: z0, reason: collision with root package name */
    public RecyclerView f1981z0;
    public int R0 = 0;
    public int S0 = 0;
    public int T0 = 0;
    public int U0 = 0;
    public String V0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public boolean W0 = false;
    public final Handler X0 = new Handler(Looper.getMainLooper());
    public String Y0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public int Z0 = 1;

    /* renamed from: i1, reason: collision with root package name */
    public final c f1963i1 = l(new e0(2), new c5.g(this));

    /* renamed from: j1, reason: collision with root package name */
    public final c5.g f1965j1 = new c5.g(this);

    public static String C(String str) {
        if (str == null) {
            return null;
        }
        if (str.toLowerCase().contains(".m3u8")) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            str = str.substring(0, lastIndexOf);
        }
        return a.c(str, ".m3u8");
    }

    public static void u(LiveMobileActivity liveMobileActivity, String str) {
        try {
            f.a(liveMobileActivity.f1978w0.B()).get_short_epg(liveMobileActivity.f1978w0.I(), liveMobileActivity.f1978w0.v(), str).enqueue(new c5.g(liveMobileActivity));
        } catch (Exception unused) {
            liveMobileActivity.N(null);
        }
    }

    public static void v(LiveMobileActivity liveMobileActivity, int i10) {
        j0 n10 = liveMobileActivity.n();
        androidx.fragment.app.a i11 = android.support.v4.media.d.i(n10, n10);
        s A = n10.A("fragment_lock");
        if (A != null) {
            android.support.v4.media.d.v(i11, A, false);
            return;
        }
        h0 N = h0.N(liveMobileActivity.f1978w0.u());
        N.f5607z0 = new c5.f(liveMobileActivity, i10, 0);
        N.M(n10, "fragment_lock");
    }

    public static void w(LiveMobileActivity liveMobileActivity) {
        try {
            String str = liveMobileActivity.f1960g0;
            if (str != null && !str.isEmpty()) {
                a0 a0Var = liveMobileActivity.f1976u0;
                if (a0Var != null) {
                    a0Var.U(false);
                }
                liveMobileActivity.x(C(liveMobileActivity.f1960g0));
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    public final void A(EPGChannel ePGChannel, int i10) {
        if (ePGChannel == null || l.f4606a.contains(((CategoryModel) this.f1952c0.get(this.R0)).getId())) {
            return;
        }
        n.K().k(ePGChannel.getName(), !ePGChannel.is_locked(), new c5.f(this, i10, 2));
    }

    public final void B(String str) {
        this.f1968m0 = 1;
        y yVar = new y(this, 6, str);
        this.f1967l0 = yVar;
        yVar.run();
    }

    public final void D() {
        y0 y0Var = this.M;
        if (y0Var != null && y0Var.g()) {
            a0 a0Var = this.f1976u0;
            if (a0Var != null) {
                a0Var.U(false);
                return;
            }
            return;
        }
        PlayerView playerView = this.f1977v0;
        if (playerView != null) {
            playerView.h();
        }
        a0 a0Var2 = this.f1976u0;
        if (a0Var2 != null) {
            a0Var2.j();
            return;
        }
        String str = this.f1960g0;
        if (str == null || str.isEmpty()) {
            return;
        }
        H(this.f1960g0);
    }

    public final boolean E(String str, String str2) {
        return this.f1978w0.g() ? str2.contains("adult") || str2.contains("xxx") || str2.contains("porn") : l.f4606a.contains(str);
    }

    public final void F() {
        y0 y0Var = this.M;
        if (y0Var != null && y0Var.g()) {
            this.X0.removeCallbacks(this.f1970o0);
            this.f1973r0.setVisibility(0);
        } else {
            this.f1971p0 = 10;
            h hVar = new h(this, 1);
            this.f1970o0 = hVar;
            hVar.run();
        }
    }

    public final void G(EPGChannel ePGChannel) {
        y0 y0Var;
        String str;
        if (ePGChannel != null) {
            this.f1978w0.M(this.R0);
            this.f1978w0.N(this.S0);
            this.B0 = ePGChannel;
            this.V0 = ePGChannel.getStream_id();
            this.f1958f0 = this.B0.getName();
            O(this.B0.is_favorite());
            P(ePGChannel.is_locked());
            if (this.f1978w0.g()) {
                this.f1960g0 = this.B0.getUrl();
            } else {
                this.f1960g0 = app.shamel.tv.helper.a.g(this.f1978w0.B(), this.f1978w0.I(), this.f1978w0.v(), this.V0, this.f1978w0.p());
            }
            if (l.f4606a.contains(((CategoryModel) this.f1952c0.get(this.R0)).getId()) || E(this.B0.getCategory_id(), this.B0.getCategory_name())) {
                P(true);
            } else {
                n.K().l(this.B0.getName(), true, new c5.g(this));
            }
            this.f1950b0.e(1);
            I();
            H(this.f1960g0);
            y0 y0Var2 = this.M;
            if (y0Var2 == null || !y0Var2.g() || (y0Var = this.M) == null || !y0Var.g() || (str = this.f1960g0) == null || str.trim().isEmpty()) {
                return;
            }
            a0 a0Var = this.f1976u0;
            if (a0Var != null) {
                a0Var.U(false);
            }
            x(C(this.f1960g0));
        }
    }

    public final void H(String str) {
        a0 a0Var = this.f1976u0;
        if (a0Var != null) {
            a0Var.O();
        }
        if (this.f1972q0.getVisibility() == 0) {
            this.f1972q0.setVisibility(8);
        }
        i1.s sVar = new i1.s();
        o9.e0 e0Var = g0.f9617p;
        w0 w0Var = w0.f9686s;
        List list = Collections.EMPTY_LIST;
        w0 w0Var2 = w0.f9686s;
        v vVar = new v();
        i1.y yVar = i1.y.f6072a;
        Uri parse = Uri.parse(str);
        c0 c0Var = new c0();
        c0Var.f5817a = "title";
        i1.a0 a0Var2 = new i1.a0(_UrlKt.FRAGMENT_ENCODE_SET, new u(sVar), parse != null ? new x(parse, null, null, list, w0Var2, -9223372036854775807L) : null, new w(vVar), new d0(c0Var), yVar);
        s1.n nVar = new s1.n(this);
        x4.l lVar = new x4.l(18);
        lVar.f13562p = k5.a.n(this, this.f1978w0.k());
        c2.r rVar = new c2.r(this);
        rVar.g(this.h0);
        rVar.h(lVar);
        nVar.b(rVar);
        nVar.c(k5.a.e(this, true));
        a0 a10 = nVar.a();
        this.f1976u0 = a10;
        a10.W(this.C0);
        this.f1976u0.q(new app.shamel.tv.activities.u(3));
        this.f1976u0.f11204m.a(new app.shamel.tv.activities.j(this, 6));
        this.f1976u0.q(new h2.a());
        a0 a0Var3 = this.f1976u0;
        i1.d dVar = i1.d.f5843b;
        a0Var3.S();
        this.f1976u0.U(true);
        this.f1977v0.setPlayer(this.f1976u0);
        this.f1976u0.p(a0Var2);
        this.f1976u0.N();
        this.f1976u0.j();
    }

    public final void I() {
        a0 a0Var = this.f1976u0;
        if (a0Var == null) {
            return;
        }
        a0Var.Z();
        this.f1976u0.O();
        this.f1976u0 = null;
        this.f1977v0.setPlayer(null);
    }

    public final void J() {
        int i10;
        int i11 = 0;
        if (this.f1978w0.g()) {
            String category_name = this.B0.getCategory_name();
            i10 = 0;
            while (true) {
                if (i10 >= this.f1952c0.size()) {
                    i10 = 0;
                    break;
                } else if (((CategoryModel) this.f1952c0.get(i10)).getName().equalsIgnoreCase(category_name)) {
                    break;
                } else {
                    i10++;
                }
            }
        } else {
            String category_id = this.B0.getCategory_id();
            i10 = 0;
            for (int i12 = 0; i12 < this.f1952c0.size(); i12++) {
                if (((CategoryModel) this.f1952c0.get(i12)).getId().equalsIgnoreCase(category_id)) {
                    i10 = i12;
                }
            }
        }
        io.realm.n0 w10 = n.K().w((CategoryModel) this.f1952c0.get(i10), _UrlKt.FRAGMENT_ENCODE_SET, this.f1978w0.g(), this.f1978w0.o());
        int i13 = 0;
        while (true) {
            if (i13 >= w10.size()) {
                break;
            }
            if (this.B0.getName().equalsIgnoreCase(((EPGChannel) w10.get(i13)).getName())) {
                i11 = i13;
                break;
            }
            i13++;
        }
        this.f1978w0.M(i10);
        this.f1978w0.N(i11);
    }

    public final void K(List list) {
        if (list == null || list.size() <= 0) {
            this.F0.setText(this.Q0.getNo_information());
            this.E0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.A0.setProgress(0);
            this.M0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.L0.setText(this.Q0.getNo_information());
            return;
        }
        this.E0.setText(k5.j.e(((CatchUpEpg) list.get(0)).getTitle()));
        this.F0.setText(k5.j.h(k5.j.i(((CatchUpEpg) list.get(0)).getStart()).getTime() + LTVApp.f2083r, app.shamel.tv.helper.a.b(this)));
        this.A0.setProgress(((CatchUpEpg) list.get(0)).getProgress());
        if (list.size() <= 1) {
            this.M0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.L0.setText(this.Q0.getNo_information());
        } else {
            this.L0.setText(k5.j.e(((CatchUpEpg) list.get(1)).getTitle()));
            this.M0.setText(k5.j.h(k5.j.i(((CatchUpEpg) list.get(1)).getStart()).getTime() + LTVApp.f2083r, app.shamel.tv.helper.a.b(this)));
        }
    }

    public final void L() {
        boolean z10 = this.W0;
        Handler handler = this.X0;
        if (z10) {
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            this.f1948a0.setVisibility(8);
            this.f1980y0.setVisibility(8);
            this.f1979x0.setVisibility(8);
            if (this.f1973r0.getVisibility() == 8) {
                this.f1973r0.setVisibility(0);
            }
            handler.removeCallbacks(this.f1970o0);
            F();
        } else {
            this.Q.setVisibility(0);
            this.R.setVisibility(0);
            this.f1948a0.setVisibility(0);
            handler.removeCallbacks(this.f1970o0);
            this.f1973r0.setVisibility(8);
            this.f1980y0.setVisibility(0);
            this.f1979x0.setVisibility(0);
            this.f1954d0.p(this.S0);
            this.f1980y0.requestFocus();
        }
        x.m mVar = new x.m();
        mVar.c(this.f1975t0);
        if (this.W0) {
            mVar.l(R.id.vertical_line1, -0.23f);
            mVar.l(R.id.vertical_line2, 0.0f);
            mVar.l(R.id.horizontal_line1, 0.0f);
            mVar.l(R.id.horizontal_line2, 1.0f);
        } else {
            mVar.l(R.id.vertical_line1, 0.23f);
            mVar.l(R.id.vertical_line2, 0.5f);
            mVar.l(R.id.horizontal_line1, 0.1f);
            mVar.l(R.id.horizontal_line2, 0.6f);
        }
        mVar.a(this.f1975t0);
    }

    public final void M(EPGChannel ePGChannel, int i10, int i11) {
        j0 n10 = n();
        androidx.fragment.app.a i12 = android.support.v4.media.d.i(n10, n10);
        s A = n10.A("fragment_channel_lock");
        if (A != null) {
            android.support.v4.media.d.v(i12, A, false);
            return;
        }
        h0 N = h0.N(this.f1978w0.u());
        N.f5607z0 = new app.shamel.tv.activities.v(this, i11, i10, ePGChannel, 3);
        N.M(n10, "fragment_channel_lock");
    }

    public final void N(List list) {
        if (list == null || list.isEmpty()) {
            this.f1962i0.l(new ArrayList());
            K(new ArrayList());
        } else {
            this.f1962i0.l(list);
            K(list);
        }
    }

    public final void O(boolean z10) {
        if (z10) {
            this.R.setText(this.Q0.getRemove_favorites());
            this.T.setColorFilter(getColor(R.color.yellow));
        } else {
            this.R.setText(this.Q0.getAdd_to_favorite());
            this.T.setColorFilter(getColor(R.color.white));
        }
    }

    public final void P(boolean z10) {
        if (z10) {
            this.V.setImageResource(R.drawable.ic_locked);
        } else {
            this.V.setImageResource(R.drawable.ic_lock);
        }
    }

    public final void Q() {
        y0 y0Var = this.M;
        if (y0Var == null || !y0Var.g()) {
            return;
        }
        try {
            i iVar = this.f1957e1;
            if (iVar != null) {
                iVar.b(true);
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.W0) {
            this.W0 = false;
            L();
            return true;
        }
        Q();
        I();
        finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
            this.W0 = false;
            L();
            return;
        }
        c cVar = this.f1963i1;
        if (id == R.id.btn_catch_up || id == R.id.btn_full_catch) {
            if (this.f1978w0.g()) {
                Toast.makeText(this, this.Q0.getNo_epg_avaliable(), 0).show();
                return;
            } else {
                if (this.B0 != null) {
                    I();
                    LTVApp.f2084s = this.B0.getName();
                    cVar.z(new Intent(this, (Class<?>) CatchUpActivity.class));
                    return;
                }
                return;
            }
        }
        if (id == R.id.btn_fav || id == R.id.btn_full_fav) {
            EPGChannel ePGChannel = this.B0;
            if (ePGChannel != null) {
                z(ePGChannel, this.S0);
                O(!this.B0.is_favorite());
                if (this.B0.is_favorite()) {
                    Toast.makeText(this, this.Q0.getChannel_removed_from_fav(), 0).show();
                    return;
                } else {
                    Toast.makeText(this, this.Q0.getChannel_added_to_fav(), 0).show();
                    return;
                }
            }
            return;
        }
        if (id == R.id.btn_full_search) {
            this.f1973r0.setVisibility(8);
            j0 n10 = n();
            n10.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(n10);
            s A = n10.A("fragment_search");
            if (A != null) {
                android.support.v4.media.d.v(aVar, A, false);
                return;
            }
            h5.c0 N = h5.c0.N(this, (CategoryModel) this.f1952c0.get(this.R0), this.R0, this.f1978w0.g());
            N.B0 = new c5.g(this);
            N.M(n10, "fragment_search");
            return;
        }
        if (id == R.id.btn_lock) {
            EPGChannel ePGChannel2 = this.B0;
            if (ePGChannel2 != null) {
                if (E(ePGChannel2.getCategory_id(), this.B0.getCategory_name())) {
                    Toast.makeText(this, this.Q0.getChannel_locked_default(), 0).show();
                    return;
                }
                if (this.B0.is_locked()) {
                    M(this.B0, this.S0, 4);
                    return;
                }
                A(this.B0, this.S0);
                P(!this.B0.is_locked());
                if (this.B0.is_locked()) {
                    Toast.makeText(this, this.Q0.getChannel_unlocked(), 0).show();
                    return;
                } else {
                    Toast.makeText(this, this.Q0.getChannel_locked(), 0).show();
                    return;
                }
            }
            return;
        }
        Handler handler = this.X0;
        i7.h hVar = null;
        if (id == R.id.btn_next) {
            if (this.S0 < this.f1964j0.size() - 1) {
                this.S0++;
            } else {
                this.S0 = 0;
            }
            if (this.f1964j0.size() <= 0 || this.S0 >= this.f1964j0.size()) {
                return;
            }
            if (((CategoryModel) this.f1952c0.get(this.R0)).getId().equalsIgnoreCase("all_id") && E(((EPGChannel) this.f1964j0.get(this.S0)).getCategory_id(), ((EPGChannel) this.f1964j0.get(this.S0)).getCategory_name())) {
                M((EPGChannel) this.f1964j0.get(this.S0), this.S0, 1);
                return;
            }
            if (!l.f4606a.contains(((CategoryModel) this.f1952c0.get(this.R0)).getId()) && !((CategoryModel) this.f1952c0.get(this.R0)).getId().equalsIgnoreCase("lock_id") && ((EPGChannel) this.f1964j0.get(this.S0)).is_locked()) {
                M((EPGChannel) this.f1964j0.get(this.S0), this.S0, 1);
                return;
            }
            G((EPGChannel) this.f1964j0.get(this.S0));
            if (this.f1978w0.g()) {
                N(null);
            } else {
                handler.removeCallbacks(this.f1967l0);
                B(this.V0);
            }
            y(this.S0);
            if (this.f1973r0.getVisibility() == 8) {
                this.f1973r0.setVisibility(0);
            }
            handler.removeCallbacks(this.f1970o0);
            F();
            this.K0.setText(this.f1958f0);
            this.f1980y0.e0(this.S0);
            return;
        }
        if (id == R.id.btn_play) {
            y0 y0Var = this.M;
            if (y0Var == null || !y0Var.g()) {
                a0 a0Var = this.f1976u0;
                if (a0Var != null) {
                    if (a0Var.E()) {
                        this.f1976u0.U(false);
                        this.X.setImageResource(R.drawable.ic_play);
                        return;
                    } else {
                        this.f1976u0.U(true);
                        this.X.setImageResource(R.drawable.ic_pause);
                        return;
                    }
                }
                return;
            }
            if (this.f1955d1 == null) {
                this.f1955d1 = b.a(getApplicationContext());
            }
            if (this.f1957e1 == null) {
                b bVar = this.f1955d1;
                bVar.getClass();
                r7.r.b();
                this.f1957e1 = bVar.f5702c;
            }
            h7.d c10 = this.f1957e1.c();
            if (c10 != null && c10.a()) {
                r7.r.b();
                hVar = c10.f5733j;
            }
            if (hVar != null) {
                int e7 = hVar.e();
                if (e7 == 2 || e7 == 4) {
                    hVar.o();
                    this.X.setImageResource(R.drawable.ic_play);
                    return;
                } else {
                    hVar.p();
                    this.X.setImageResource(R.drawable.ic_pause);
                    return;
                }
            }
            return;
        }
        if (id == R.id.btn_previous) {
            int i10 = this.S0;
            if (i10 > 0) {
                this.S0 = i10 - 1;
            } else {
                this.S0 = this.f1964j0.size() - 1;
            }
            if (this.f1964j0.size() <= 0 || this.S0 >= this.f1964j0.size()) {
                return;
            }
            if (((CategoryModel) this.f1952c0.get(this.R0)).getId().equalsIgnoreCase("all_id") && E(((EPGChannel) this.f1964j0.get(this.S0)).getCategory_id(), ((EPGChannel) this.f1964j0.get(this.S0)).getCategory_name())) {
                M((EPGChannel) this.f1964j0.get(this.S0), this.S0, 1);
                return;
            }
            if (!l.f4606a.contains(((CategoryModel) this.f1952c0.get(this.R0)).getId()) && !((CategoryModel) this.f1952c0.get(this.R0)).getId().equalsIgnoreCase("lock_id") && ((EPGChannel) this.f1964j0.get(this.S0)).is_locked()) {
                M((EPGChannel) this.f1964j0.get(this.S0), this.S0, 1);
                return;
            }
            G((EPGChannel) this.f1964j0.get(this.S0));
            if (this.f1978w0.g()) {
                N(null);
            } else {
                handler.removeCallbacks(this.f1967l0);
                B(this.V0);
            }
            y(this.S0);
            this.K0.setText(this.f1958f0);
            if (this.f1973r0.getVisibility() == 8) {
                this.f1973r0.setVisibility(0);
            }
            handler.removeCallbacks(this.f1970o0);
            F();
            this.f1980y0.e0(this.S0);
            return;
        }
        if (id == R.id.btn_resolution) {
            if (this.f1976u0 == null) {
                return;
            }
            int i11 = (this.Z0 + 1) % 4;
            this.Z0 = i11;
            if (i11 == 0) {
                this.f1977v0.setResizeMode(3);
                AspectRatioFrameLayout aspectRatioFrameLayout = this.f1949a1;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(0.0f);
                }
                this.f1959f1.setText("Fill");
            } else if (i11 == 1) {
                this.f1977v0.setResizeMode(0);
                AspectRatioFrameLayout aspectRatioFrameLayout2 = this.f1949a1;
                if (aspectRatioFrameLayout2 != null) {
                    aspectRatioFrameLayout2.setAspectRatio(0.0f);
                }
                this.f1959f1.setText("Fit");
            } else if (i11 == 2) {
                this.f1977v0.setResizeMode(0);
                AspectRatioFrameLayout aspectRatioFrameLayout3 = this.f1949a1;
                if (aspectRatioFrameLayout3 != null) {
                    aspectRatioFrameLayout3.setAspectRatio(1.7777778f);
                }
                this.f1959f1.setText("16:9");
            } else if (i11 == 3) {
                this.f1977v0.setResizeMode(0);
                AspectRatioFrameLayout aspectRatioFrameLayout4 = this.f1949a1;
                if (aspectRatioFrameLayout4 != null) {
                    aspectRatioFrameLayout4.setAspectRatio(1.3333334f);
                }
                this.f1959f1.setText("4:3");
            }
            this.f1959f1.setVisibility(0);
            handler.removeCallbacks(this.f1961g1);
            this.h1 = 2;
            h hVar2 = new h(this, 0);
            this.f1961g1 = hVar2;
            hVar2.run();
            return;
        }
        if (id == R.id.btn_search) {
            Q();
            I();
            Intent intent = new Intent(this, (Class<?>) SearchActivity.class);
            intent.putExtra("is_live", true);
            cVar.z(intent);
            return;
        }
        if (id == R.id.txt_home) {
            I();
            if (((CategoryModel) this.f1952c0.get(this.R0)).getId().equalsIgnoreCase("resume_id") && this.B0 != null) {
                J();
            }
            finish();
            this.W0 = false;
            L();
            return;
        }
        if (id == R.id.txt_movie) {
            I();
            startActivity(new Intent(this, (Class<?>) MovieActivity.class));
            if (((CategoryModel) this.f1952c0.get(this.R0)).getId().equalsIgnoreCase("resume_id") && this.B0 != null) {
                J();
            }
            finish();
            return;
        }
        if (id == R.id.txt_series) {
            Q();
            I();
            startActivity(new Intent(this, (Class<?>) SeriesActivity.class));
            if (((CategoryModel) this.f1952c0.get(this.R0)).getId().equalsIgnoreCase("resume_id") && this.B0 != null) {
                J();
            }
            finish();
            return;
        }
        if (id == R.id.view_click) {
            y0 y0Var2 = this.M;
            if (y0Var2 != null && y0Var2.g()) {
                this.f1973r0.setVisibility(0);
            } else if (this.f1973r0.getVisibility() == 0) {
                handler.removeCallbacks(this.f1970o0);
                this.f1973r0.setVisibility(8);
            }
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_live_mobile);
        this.M = new y0(this);
        b a10 = b.a(getApplicationContext());
        this.f1955d1 = a10;
        a10.getClass();
        r7.r.b();
        this.f1957e1 = a10.f5702c;
        this.f1951b1 = new d(this, new Handler(Looper.getMainLooper()), 1);
        j().a(this, new androidx.fragment.app.a0(this, 4));
        k5.j.a(this);
        this.f1978w0 = new r(this);
        this.Q0 = app.shamel.tv.helper.a.k(this);
        this.f1975t0 = (ConstraintLayout) findViewById(R.id.fullContainer);
        PlayerView playerView = (PlayerView) findViewById(R.id.player_view);
        this.f1977v0 = playerView;
        this.f1949a1 = (AspectRatioFrameLayout) playerView.findViewById(R.id.exo_content_frame);
        playerView.setResizeMode(4);
        this.f1977v0.getSubtitleView().setApplyEmbeddedStyles(false);
        u3.c cVar = new u3.c(Color.parseColor(this.f1978w0.D()), Color.parseColor(this.f1978w0.C()), 0, 0, 0, null);
        this.f1977v0.getSubtitleView().a(3, this.f1978w0.F());
        this.f1977v0.getSubtitleView().setStyle(cVar);
        this.f1953c1 = (MediaRouteButton) findViewById(R.id.btn_cast);
        this.f1959f1 = (TextView) findViewById(R.id.view_txt_resolution);
        this.H0 = (TextView) findViewById(R.id.txt_home);
        this.I0 = (TextView) findViewById(R.id.txt_live);
        this.J0 = (TextView) findViewById(R.id.txt_movie);
        this.N0 = (TextView) findViewById(R.id.txt_series);
        this.K0 = (TextView) findViewById(R.id.txt_name);
        this.f1969n0 = (EditText) findViewById(R.id.et_search);
        this.f1979x0 = (RecyclerView) findViewById(R.id.recycler_category);
        this.f1980y0 = (RecyclerView) findViewById(R.id.recycler_channel);
        this.f1974s0 = (ConstraintLayout) findViewById(R.id.ly_surface);
        this.f1981z0 = (RecyclerView) findViewById(R.id.recycler_epg);
        this.R = (Button) findViewById(R.id.btn_fav);
        this.Q = (Button) findViewById(R.id.btn_catch_up);
        this.f1948a0 = (Button) findViewById(R.id.btn_search);
        this.V = (ImageButton) findViewById(R.id.btn_lock);
        this.H0.setText(this.Q0.getHome());
        this.I0.setText(this.Q0.getLive_tv());
        this.J0.setText(this.Q0.getMovies());
        this.N0.setText(this.Q0.getSeries());
        this.Q.setText(this.Q0.getCatch_up());
        this.f1948a0.setText(this.Q0.getSearch());
        this.R.setText(this.Q0.getAdd_to_favorite());
        this.f1973r0 = (ConstraintLayout) findViewById(R.id.ly_control);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.A0 = seekBar;
        seekBar.setMax(100);
        this.F0 = (TextView) findViewById(R.id.txt_current_time);
        this.E0 = (TextView) findViewById(R.id.txt_current_program);
        this.M0 = (TextView) findViewById(R.id.txt_next_time);
        this.L0 = (TextView) findViewById(R.id.txt_next_program);
        this.G0 = (TextView) findViewById(R.id.txt_group);
        this.D0 = (TextView) findViewById(R.id.txt_channel_name);
        this.f1956e0 = (ImageView) findViewById(R.id.channel_image);
        this.f1972q0 = (ImageView) findViewById(R.id.image_def);
        this.S = (ImageButton) findViewById(R.id.btn_full_catch);
        this.P = (ImageButton) findViewById(R.id.btn_back);
        this.T = (ImageButton) findViewById(R.id.btn_full_fav);
        this.U = (ImageButton) findViewById(R.id.btn_full_search);
        this.Z = (ImageButton) findViewById(R.id.btn_resolution);
        this.O0 = findViewById(R.id.view_click);
        this.W = (ImageButton) findViewById(R.id.btn_next);
        this.X = (ImageButton) findViewById(R.id.btn_play);
        this.Y = (ImageButton) findViewById(R.id.btn_previous);
        this.O = (SeekBar) findViewById(R.id.bright_seekbar);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.volume_seekbar);
        this.P0 = seekBar2;
        seekBar2.setOnSeekBarChangeListener(this);
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        this.N = audioManager;
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = this.N.getStreamVolume(3);
        this.P0.setMax(streamMaxVolume);
        this.P0.setProgress(streamVolume);
        this.O.setOnSeekBarChangeListener(this);
        this.O.setMax(255);
        this.O.setProgress(Settings.System.getInt(getContentResolver(), "screen_brightness", 0));
        this.f1974s0.setOnClickListener(this);
        this.I0.setOnClickListener(this);
        this.H0.setOnClickListener(this);
        this.N0.setOnClickListener(this);
        this.J0.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.f1948a0.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.O0.setOnClickListener(this);
        this.f1969n0.addTextChangedListener(new app.shamel.tv.activities.l(9, this));
        this.f1977v0.getVideoSurfaceView().setOnClickListener(new androidx.leanback.widget.g0(6, this));
        h7.a.a(this, this.f1953c1);
        if (Build.VERSION.SDK_INT >= 26) {
            q.o();
        }
        this.h0 = k5.a.i(this, this.f1978w0.k());
        i1.y0 y0Var = new i1.y0();
        y0Var.j(3, !this.f1978w0.E());
        this.C0 = new z0(y0Var);
        this.W0 = getIntent().getBooleanExtra("is_full", false);
        l.a(this, this.f1978w0.h());
        this.f1952c0 = LTVApp.f2087v;
        int c10 = this.f1978w0.c();
        this.R0 = c10;
        if (c10 > this.f1952c0.size() - 1) {
            this.R0 = 1;
        }
        if (E(((CategoryModel) this.f1952c0.get(this.R0)).getId(), ((CategoryModel) this.f1952c0.get(this.R0)).getId())) {
            this.R0 = 1;
        }
        this.f1950b0 = new n0(this, this.f1952c0, this.f1978w0.g(), false, this.R0, new app.shamel.tv.activities.f(6, this));
        this.f1979x0.setLayoutManager(new LinearLayoutManager(1));
        this.f1979x0.setAdapter(this.f1950b0);
        this.f1979x0.e0(this.R0);
        int i10 = this.R0;
        if (i10 <= 4 || i10 >= this.f1978w0.s().size() + 5) {
            this.f1964j0 = n.K().w((CategoryModel) this.f1952c0.get(this.R0), _UrlKt.FRAGMENT_ENCODE_SET, this.f1978w0.g(), this.f1978w0.o());
        } else if (!this.f1978w0.s().isEmpty()) {
            n K = n.K();
            r rVar = this.f1978w0;
            this.f1964j0 = K.s(_UrlKt.FRAGMENT_ENCODE_SET, rVar.t((String) rVar.s().get(this.R0 - 5)));
        }
        this.S0 = this.f1978w0.d();
        if (this.f1964j0.size() <= 0) {
            this.S0 = -1;
        } else if (this.S0 > this.f1964j0.size() - 1) {
            this.S0 = 0;
        }
        this.f1954d0 = new e(this, this.f1964j0, this.S0, new ya.r() { // from class: c5.e
            @Override // ya.r
            public final Object d(Object obj, Object obj2, Object obj3, Object obj4) {
                EPGChannel ePGChannel = (EPGChannel) obj;
                Integer num = (Integer) obj2;
                Boolean bool = (Boolean) obj4;
                LiveMobileActivity liveMobileActivity = LiveMobileActivity.this;
                Handler handler = liveMobileActivity.X0;
                liveMobileActivity.T0 = num.intValue();
                if (((Boolean) obj3).booleanValue()) {
                    if (!liveMobileActivity.W0) {
                        if (liveMobileActivity.V0.equalsIgnoreCase(ePGChannel.getStream_id())) {
                            if (((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0)).getId().equalsIgnoreCase("resume_id")) {
                                liveMobileActivity.S0 = 0;
                            }
                            liveMobileActivity.W0 = true;
                            liveMobileActivity.L();
                            return null;
                        }
                        if (((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0)).getId().equalsIgnoreCase("all_id") && liveMobileActivity.E(ePGChannel.getCategory_id(), ePGChannel.getCategory_name())) {
                            liveMobileActivity.M(ePGChannel, num.intValue(), 0);
                            return null;
                        }
                        if (!liveMobileActivity.E(ePGChannel.getCategory_id(), ePGChannel.getCategory_name()) && !((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0)).getId().equalsIgnoreCase("lock_id") && ePGChannel.is_locked()) {
                            liveMobileActivity.M(ePGChannel, num.intValue(), 0);
                            return null;
                        }
                        liveMobileActivity.S0 = num.intValue();
                        liveMobileActivity.G(ePGChannel);
                        if (liveMobileActivity.f1978w0.g()) {
                            liveMobileActivity.N(null);
                        } else {
                            handler.removeCallbacks(liveMobileActivity.f1967l0);
                            liveMobileActivity.B(ePGChannel.getStream_id());
                        }
                        String name = ePGChannel.getName();
                        liveMobileActivity.f1958f0 = name;
                        liveMobileActivity.K0.setText(name);
                        liveMobileActivity.O(ePGChannel.is_favorite());
                        liveMobileActivity.y(liveMobileActivity.S0);
                        return null;
                    }
                } else {
                    if (bool.booleanValue()) {
                        liveMobileActivity.z(ePGChannel, num.intValue());
                        liveMobileActivity.O(ePGChannel.is_favorite());
                        return null;
                    }
                    if (!liveMobileActivity.W0) {
                        if (liveMobileActivity.f1978w0.g()) {
                            liveMobileActivity.N(null);
                        } else {
                            handler.removeCallbacks(liveMobileActivity.f1967l0);
                            liveMobileActivity.B(ePGChannel.getStream_id());
                        }
                        String name2 = ePGChannel.getName();
                        liveMobileActivity.f1958f0 = name2;
                        liveMobileActivity.K0.setText(name2);
                        liveMobileActivity.O(ePGChannel.is_favorite());
                        liveMobileActivity.y(liveMobileActivity.T0);
                    }
                }
                return null;
            }
        });
        this.f1980y0.setLayoutManager(new LinearLayoutManager(1));
        this.f1980y0.setAdapter(this.f1954d0);
        this.f1980y0.requestFocus();
        this.f1980y0.e0(this.S0);
        this.f1962i0 = new m(this, new ArrayList());
        this.f1981z0.setLayoutManager(new LinearLayoutManager(1));
        this.f1981z0.setAdapter(this.f1962i0);
        this.f1981z0.setFocusable(false);
        boolean isEmpty = this.f1964j0.isEmpty();
        Handler handler = this.X0;
        if (!isEmpty) {
            L();
            if (E(((EPGChannel) this.f1964j0.get(this.S0)).getCategory_id(), ((EPGChannel) this.f1964j0.get(this.S0)).getCategory_name())) {
                this.S0 = 0;
            }
            if (((EPGChannel) this.f1964j0.get(this.S0)).is_locked()) {
                M((EPGChannel) this.f1964j0.get(this.S0), this.S0, 3);
                return;
            }
            G((EPGChannel) this.f1964j0.get(this.S0));
            this.V0 = ((EPGChannel) this.f1964j0.get(this.S0)).getStream_id();
            if (this.f1978w0.g()) {
                N(null);
            } else {
                handler.removeCallbacks(this.f1967l0);
                B(this.V0);
            }
            String name = ((EPGChannel) this.f1964j0.get(this.S0)).getName();
            this.f1958f0 = name;
            this.K0.setText(name);
            O(((EPGChannel) this.f1964j0.get(this.S0)).is_favorite());
            y(this.S0);
            return;
        }
        this.R0 = 2;
        this.S0 = 0;
        L();
        io.realm.n0 w10 = n.K().w((CategoryModel) this.f1952c0.get(this.R0), _UrlKt.FRAGMENT_ENCODE_SET, this.f1978w0.g(), this.f1978w0.o());
        this.f1964j0 = w10;
        this.f1954d0.q(0, w10);
        if (E(((EPGChannel) this.f1964j0.get(this.S0)).getCategory_id(), ((EPGChannel) this.f1964j0.get(this.S0)).getCategory_name())) {
            this.f1979x0.requestFocus();
            return;
        }
        G((EPGChannel) this.f1964j0.get(this.S0));
        this.V0 = ((EPGChannel) this.f1964j0.get(this.S0)).getStream_id();
        if (this.f1978w0.g()) {
            N(null);
        } else {
            handler.removeCallbacks(this.f1967l0);
            B(this.V0);
        }
        this.K0.setText(this.f1958f0);
        y(this.S0);
        this.f1980y0.requestFocus();
        this.f1980y0.e0(this.S0);
    }

    @Override // f.j, android.app.Activity
    public final void onPause() {
        super.onPause();
        i iVar = this.f1957e1;
        if (iVar != null) {
            iVar.e(this.f1965j1);
        }
        if (this.f1951b1 != null) {
            getContentResolver().unregisterContentObserver(this.f1951b1);
        }
        if (Build.VERSION.SDK_INT <= 23) {
            PlayerView playerView = this.f1977v0;
            if (playerView != null) {
                playerView.g();
            }
            I();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        if (z10) {
            int id = seekBar.getId();
            if (id == R.id.bright_seekbar) {
                if (id == R.id.bright_seekbar && z10) {
                    Window window = getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.screenBrightness = i10 / 255.0f;
                    window.setAttributes(attributes);
                    return;
                }
                return;
            }
            if (id != R.id.volume_seekbar) {
                return;
            }
            this.N.setStreamVolume(3, i10, 0);
            int streamMaxVolume = this.N.getStreamMaxVolume(3);
            a0 a0Var = this.f1976u0;
            if (a0Var == null || streamMaxVolume <= 0) {
                return;
            }
            a0Var.Y(i10 / streamMaxVolume);
        }
    }

    @Override // f.j, android.app.Activity
    public final void onResume() {
        super.onResume();
        i iVar = this.f1957e1;
        if (iVar != null) {
            iVar.a(this.f1965j1);
        }
        AudioManager audioManager = this.N;
        if (audioManager != null && this.P0 != null) {
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = this.N.getStreamVolume(3);
            this.P0.setMax(streamMaxVolume);
            this.P0.setProgress(streamVolume);
        }
        getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.f1951b1);
        if (Build.VERSION.SDK_INT <= 23) {
            D();
        }
    }

    @Override // f.j, android.app.Activity
    public final void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT > 23) {
            D();
        }
    }

    @Override // f.j, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT > 23) {
            PlayerView playerView = this.f1977v0;
            if (playerView != null) {
                playerView.g();
            }
            I();
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        I();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.mobile.LiveMobileActivity.x(java.lang.String):void");
    }

    public final void y(int i10) {
        this.G0.setText(this.Y0);
        this.D0.setText(((EPGChannel) this.f1964j0.get(i10)).getNum() + " " + ((EPGChannel) this.f1964j0.get(i10)).getName());
        String stream_icon = ((EPGChannel) this.f1964j0.get(i10)).getStream_icon();
        if (stream_icon == null || stream_icon.isEmpty()) {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).q(Integer.valueOf(R.drawable.home_logo)).g(R.drawable.home_logo)).E(this.f1956e0);
        } else {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).r(stream_icon).g(R.drawable.home_logo)).E(this.f1956e0);
        }
    }

    public final void z(EPGChannel ePGChannel, int i10) {
        if (ePGChannel == null || l.f4606a.contains(((CategoryModel) this.f1952c0.get(this.R0)).getId())) {
            return;
        }
        n.K().h(ePGChannel.getName(), !ePGChannel.is_favorite(), new c5.f(this, i10, 1));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
