package app.shamel.tv.activities.mobile;

import a6.n;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.e0;
import androidx.fragment.app.j0;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerView;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.activities.CatchUpActivity;
import app.shamel.tv.activities.SearchActivity;
import app.shamel.tv.activities.y;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.helper.r;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.WordModels;
import c2.y0;
import c5.c;
import c5.d;
import d5.e;
import d5.m;
import e5.l;
import f.j;
import h5.h0;
import h7.b;
import h7.i;
import i1.c0;
import i1.d0;
import i1.s;
import i1.u;
import i1.v;
import i1.w;
import i1.x;
import i1.z0;
import i7.h;
import io.realm.n0;
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
public class LiveChannelMobileActivity extends j implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: j1, reason: collision with root package name */
    public static final /* synthetic */ int f1913j1 = 0;
    public z0 A0;
    public TextView B0;
    public TextView C0;
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
    public View N0;
    public SeekBar O;
    public SeekBar O0;
    public ImageButton P;
    public WordModels P0;
    public Button Q;
    public Button R;
    public ImageButton S;
    public ImageButton T;
    public ImageButton U;
    public ImageButton V;
    public ImageButton W;
    public ImageButton X;
    public ImageButton Y;
    public ImageButton Z;
    public AspectRatioFrameLayout Z0;

    /* renamed from: a0, reason: collision with root package name */
    public Button f1914a0;

    /* renamed from: a1, reason: collision with root package name */
    public d f1915a1;

    /* renamed from: b0, reason: collision with root package name */
    public ArrayList f1916b0;

    /* renamed from: b1, reason: collision with root package name */
    public MediaRouteButton f1917b1;

    /* renamed from: c0, reason: collision with root package name */
    public e f1918c0;

    /* renamed from: c1, reason: collision with root package name */
    public b f1919c1;

    /* renamed from: d0, reason: collision with root package name */
    public ImageView f1920d0;

    /* renamed from: d1, reason: collision with root package name */
    public i f1921d1;

    /* renamed from: e0, reason: collision with root package name */
    public String f1922e0;

    /* renamed from: e1, reason: collision with root package name */
    public TextView f1923e1;

    /* renamed from: f0, reason: collision with root package name */
    public String f1924f0;

    /* renamed from: f1, reason: collision with root package name */
    public c f1925f1;

    /* renamed from: g0, reason: collision with root package name */
    public g f1926g0;

    /* renamed from: g1, reason: collision with root package name */
    public int f1927g1;
    public m h0;

    /* renamed from: i0, reason: collision with root package name */
    public n0 f1928i0;

    /* renamed from: j0, reason: collision with root package name */
    public List f1930j0;

    /* renamed from: k0, reason: collision with root package name */
    public y f1931k0;

    /* renamed from: l0, reason: collision with root package name */
    public c f1932l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f1933m0;

    /* renamed from: n0, reason: collision with root package name */
    public EditText f1934n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f1935o0;

    /* renamed from: p0, reason: collision with root package name */
    public ImageView f1936p0;

    /* renamed from: q0, reason: collision with root package name */
    public ConstraintLayout f1937q0;

    /* renamed from: r0, reason: collision with root package name */
    public ConstraintLayout f1938r0;

    /* renamed from: s0, reason: collision with root package name */
    public ConstraintLayout f1939s0;

    /* renamed from: t0, reason: collision with root package name */
    public a0 f1940t0;

    /* renamed from: u0, reason: collision with root package name */
    public PlayerView f1941u0;

    /* renamed from: v0, reason: collision with root package name */
    public r f1942v0;

    /* renamed from: w0, reason: collision with root package name */
    public RecyclerView f1943w0;

    /* renamed from: x0, reason: collision with root package name */
    public RecyclerView f1944x0;

    /* renamed from: y0, reason: collision with root package name */
    public SeekBar f1945y0;

    /* renamed from: z0, reason: collision with root package name */
    public EPGChannel f1946z0;
    public int Q0 = 0;
    public int R0 = 0;
    public int S0 = 0;
    public int T0 = 0;
    public String U0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public boolean V0 = false;
    public final Handler W0 = new Handler(Looper.getMainLooper());
    public final String X0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public int Y0 = 1;
    public final androidx.activity.result.c h1 = l(new e0(2), new c5.b(this));

    /* renamed from: i1, reason: collision with root package name */
    public final c5.b f1929i1 = new c5.b(this);

    public static String B(String str) {
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

    public static void u(LiveChannelMobileActivity liveChannelMobileActivity, String str) {
        try {
            f.a(liveChannelMobileActivity.f1942v0.B()).get_short_epg(liveChannelMobileActivity.f1942v0.I(), liveChannelMobileActivity.f1942v0.v(), str).enqueue(new c5.b(liveChannelMobileActivity));
        } catch (Exception unused) {
            liveChannelMobileActivity.M(null);
        }
    }

    public static void v(LiveChannelMobileActivity liveChannelMobileActivity) {
        try {
            String str = liveChannelMobileActivity.f1924f0;
            if (str != null && !str.isEmpty()) {
                a0 a0Var = liveChannelMobileActivity.f1940t0;
                if (a0Var != null) {
                    a0Var.U(false);
                }
                liveChannelMobileActivity.w(B(liveChannelMobileActivity.f1924f0));
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    public final void A(String str) {
        this.f1933m0 = 1;
        y yVar = new y(this, 5, str);
        this.f1931k0 = yVar;
        yVar.run();
    }

    public final void C() {
        y0 y0Var = this.M;
        if (y0Var != null && y0Var.g()) {
            a0 a0Var = this.f1940t0;
            if (a0Var != null) {
                a0Var.U(false);
                return;
            }
            return;
        }
        PlayerView playerView = this.f1941u0;
        if (playerView != null) {
            playerView.h();
        }
        a0 a0Var2 = this.f1940t0;
        if (a0Var2 != null) {
            a0Var2.j();
            return;
        }
        String str = this.f1924f0;
        if (str == null || str.isEmpty()) {
            return;
        }
        G(this.f1924f0);
    }

    public final boolean D(String str, String str2) {
        return this.f1942v0.g() ? str2.contains("adult") || str2.contains("xxx") || str2.contains("porn") : l.f4606a.contains(str);
    }

    public final void E() {
        y0 y0Var = this.M;
        if (y0Var != null && y0Var.g()) {
            this.W0.removeCallbacks(this.f1932l0);
            this.f1937q0.setVisibility(0);
        } else {
            this.f1935o0 = 10;
            c cVar = new c(this, 1);
            this.f1932l0 = cVar;
            cVar.run();
        }
    }

    public final void F(EPGChannel ePGChannel) {
        y0 y0Var;
        String str;
        if (ePGChannel != null) {
            this.f1942v0.M(this.Q0);
            this.f1942v0.N(this.R0);
            this.f1946z0 = ePGChannel;
            this.U0 = ePGChannel.getStream_id();
            this.f1922e0 = this.f1946z0.getName();
            N(this.f1946z0.is_favorite());
            O(ePGChannel.is_locked());
            if (this.f1942v0.g()) {
                this.f1924f0 = this.f1946z0.getUrl();
            } else {
                this.f1924f0 = app.shamel.tv.helper.a.g(this.f1942v0.B(), this.f1942v0.I(), this.f1942v0.v(), this.U0, this.f1942v0.p());
            }
            if (l.f4606a.contains(((CategoryModel) this.f1916b0.get(this.Q0)).getId()) || D(this.f1946z0.getCategory_id(), this.f1946z0.getCategory_name())) {
                O(true);
            } else {
                n.K().l(this.f1946z0.getName(), true, new c5.b(this));
            }
            H();
            G(this.f1924f0);
            y0 y0Var2 = this.M;
            if (y0Var2 == null || !y0Var2.g() || (y0Var = this.M) == null || !y0Var.g() || (str = this.f1924f0) == null || str.trim().isEmpty()) {
                return;
            }
            a0 a0Var = this.f1940t0;
            if (a0Var != null) {
                a0Var.U(false);
            }
            w(B(this.f1924f0));
        }
    }

    public final void G(String str) {
        a0 a0Var = this.f1940t0;
        if (a0Var != null) {
            a0Var.O();
        }
        if (this.f1936p0.getVisibility() == 0) {
            this.f1936p0.setVisibility(8);
        }
        s sVar = new s();
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
        lVar.f13562p = k5.a.n(this, this.f1942v0.k());
        c2.r rVar = new c2.r(this);
        rVar.g(this.f1926g0);
        rVar.h(lVar);
        nVar.b(rVar);
        nVar.c(k5.a.e(this, true));
        a0 a10 = nVar.a();
        this.f1940t0 = a10;
        a10.W(this.A0);
        this.f1940t0.q(new app.shamel.tv.activities.u(2));
        this.f1940t0.f11204m.a(new app.shamel.tv.activities.j(this, 5));
        this.f1940t0.q(new h2.a());
        a0 a0Var3 = this.f1940t0;
        i1.d dVar = i1.d.f5843b;
        a0Var3.S();
        this.f1940t0.U(true);
        this.f1941u0.setPlayer(this.f1940t0);
        this.f1940t0.p(a0Var2);
        this.f1940t0.N();
        this.f1940t0.j();
    }

    public final void H() {
        a0 a0Var = this.f1940t0;
        if (a0Var == null) {
            return;
        }
        a0Var.Z();
        this.f1940t0.O();
        this.f1940t0 = null;
        this.f1941u0.setPlayer(null);
    }

    public final void I() {
        n0 w10 = n.K().w((CategoryModel) this.f1916b0.get(this.Q0), _UrlKt.FRAGMENT_ENCODE_SET, this.f1942v0.g(), this.f1942v0.o());
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= w10.size()) {
                break;
            }
            if (this.f1946z0.getName().equalsIgnoreCase(((EPGChannel) w10.get(i11)).getName())) {
                i10 = i11;
                break;
            }
            i11++;
        }
        this.f1942v0.N(i10);
    }

    public final void J(List list) {
        if (list == null || list.size() <= 0) {
            this.E0.setText(this.P0.getNo_information());
            this.D0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.f1945y0.setProgress(0);
            this.L0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.K0.setText(this.P0.getNo_information());
            return;
        }
        this.D0.setText(k5.j.e(((CatchUpEpg) list.get(0)).getTitle()));
        this.E0.setText(k5.j.h(k5.j.i(((CatchUpEpg) list.get(0)).getStart()).getTime() + LTVApp.f2083r, app.shamel.tv.helper.a.b(this)));
        this.f1945y0.setProgress(((CatchUpEpg) list.get(0)).getProgress());
        if (list.size() <= 1) {
            this.L0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.K0.setText(this.P0.getNo_information());
        } else {
            this.K0.setText(k5.j.e(((CatchUpEpg) list.get(1)).getTitle()));
            this.L0.setText(k5.j.h(k5.j.i(((CatchUpEpg) list.get(1)).getStart()).getTime() + LTVApp.f2083r, app.shamel.tv.helper.a.b(this)));
        }
    }

    public final void K() {
        boolean z10 = this.V0;
        Handler handler = this.W0;
        if (z10) {
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            this.f1914a0.setVisibility(8);
            this.f1943w0.setVisibility(8);
            if (this.f1937q0.getVisibility() == 8) {
                this.f1937q0.setVisibility(0);
            }
            handler.removeCallbacks(this.f1932l0);
            E();
        } else {
            this.Q.setVisibility(0);
            this.R.setVisibility(0);
            this.f1914a0.setVisibility(0);
            handler.removeCallbacks(this.f1932l0);
            this.f1937q0.setVisibility(8);
            this.f1943w0.setVisibility(0);
            this.f1918c0.p(this.R0);
            this.f1943w0.requestFocus();
        }
        x.m mVar = new x.m();
        mVar.c(this.f1939s0);
        if (this.V0) {
            mVar.l(R.id.vertical_line2, 0.0f);
            mVar.l(R.id.horizontal_line1, 0.0f);
            mVar.l(R.id.horizontal_line2, 1.0f);
        } else {
            mVar.l(R.id.vertical_line2, 0.5f);
            mVar.l(R.id.horizontal_line1, 0.1f);
            mVar.l(R.id.horizontal_line2, 0.6f);
        }
        mVar.a(this.f1939s0);
    }

    public final void L(EPGChannel ePGChannel, int i10, int i11) {
        j0 n10 = n();
        androidx.fragment.app.a i12 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_channel_lock");
        if (A != null) {
            android.support.v4.media.d.v(i12, A, false);
            return;
        }
        h0 N = h0.N(this.f1942v0.u());
        N.f5607z0 = new app.shamel.tv.activities.v(this, i11, i10, ePGChannel, 2);
        N.M(n10, "fragment_channel_lock");
    }

    public final void M(List list) {
        if (list == null || list.isEmpty()) {
            this.h0.l(new ArrayList());
            J(new ArrayList());
        } else {
            this.h0.l(list);
            J(list);
        }
    }

    public final void N(boolean z10) {
        if (z10) {
            this.R.setText(this.P0.getRemove_favorites());
            this.T.setColorFilter(getColor(R.color.yellow));
        } else {
            this.R.setText(this.P0.getAdd_to_favorite());
            this.T.setColorFilter(getColor(R.color.white));
        }
    }

    public final void O(boolean z10) {
        if (z10) {
            this.V.setImageResource(R.drawable.ic_locked);
        } else {
            this.V.setImageResource(R.drawable.ic_lock);
        }
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.V0) {
            this.V0 = false;
            K();
            return true;
        }
        H();
        y0 y0Var = this.M;
        if (y0Var != null && y0Var.g()) {
            try {
                i iVar = this.f1921d1;
                if (iVar != null) {
                    iVar.b(true);
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
        finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
            this.V0 = false;
            K();
            return;
        }
        androidx.activity.result.c cVar = this.h1;
        if (id == R.id.btn_catch_up || id == R.id.btn_full_catch) {
            if (this.f1942v0.g()) {
                Toast.makeText(this, this.P0.getNo_epg_avaliable(), 0).show();
                return;
            } else {
                if (this.f1946z0 != null) {
                    H();
                    LTVApp.f2084s = this.f1946z0.getName();
                    cVar.z(new Intent(this, (Class<?>) CatchUpActivity.class));
                    return;
                }
                return;
            }
        }
        if (id == R.id.btn_fav || id == R.id.btn_full_fav) {
            EPGChannel ePGChannel = this.f1946z0;
            if (ePGChannel != null) {
                y(ePGChannel, this.R0);
                N(!this.f1946z0.is_favorite());
                if (this.f1946z0.is_favorite()) {
                    Toast.makeText(this, this.P0.getChannel_removed_from_fav(), 0).show();
                    return;
                } else {
                    Toast.makeText(this, this.P0.getChannel_added_to_fav(), 0).show();
                    return;
                }
            }
            return;
        }
        if (id == R.id.btn_full_search) {
            this.f1937q0.setVisibility(8);
            j0 n10 = n();
            n10.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(n10);
            androidx.fragment.app.s A = n10.A("fragment_search");
            if (A != null) {
                android.support.v4.media.d.v(aVar, A, false);
                return;
            }
            h5.c0 N = h5.c0.N(this, (CategoryModel) this.f1916b0.get(this.Q0), this.Q0, this.f1942v0.g());
            N.B0 = new c5.b(this);
            N.M(n10, "fragment_search");
            return;
        }
        if (id == R.id.btn_lock) {
            EPGChannel ePGChannel2 = this.f1946z0;
            if (ePGChannel2 != null) {
                if (D(ePGChannel2.getCategory_id(), this.f1946z0.getCategory_name())) {
                    Toast.makeText(this, this.P0.getChannel_locked_default(), 0).show();
                } else if (this.f1946z0.is_locked()) {
                    L(this.f1946z0, this.R0, 4);
                } else {
                    z(this.f1946z0, this.R0);
                    O(!this.f1946z0.is_locked());
                    if (this.f1946z0.is_locked()) {
                        Toast.makeText(this, this.P0.getChannel_unlocked(), 0).show();
                    } else {
                        Toast.makeText(this, this.P0.getChannel_locked(), 0).show();
                    }
                }
            }
            H();
            Intent intent = new Intent(this, (Class<?>) SearchActivity.class);
            intent.putExtra("is_live", true);
            cVar.z(intent);
            return;
        }
        Handler handler = this.W0;
        h hVar = null;
        if (id == R.id.btn_next) {
            if (this.R0 < this.f1928i0.size() - 1) {
                this.R0++;
            } else {
                this.R0 = 0;
            }
            if (this.f1928i0.size() <= 0 || this.R0 >= this.f1928i0.size()) {
                return;
            }
            if (((CategoryModel) this.f1916b0.get(this.Q0)).getId().equalsIgnoreCase("all_id") && D(((EPGChannel) this.f1928i0.get(this.R0)).getCategory_id(), ((EPGChannel) this.f1928i0.get(this.R0)).getCategory_name())) {
                L((EPGChannel) this.f1928i0.get(this.R0), this.R0, 1);
                return;
            }
            if (!D(((EPGChannel) this.f1928i0.get(this.R0)).getCategory_id(), ((EPGChannel) this.f1928i0.get(this.R0)).getCategory_name()) && !((CategoryModel) this.f1916b0.get(this.Q0)).getId().equalsIgnoreCase("lock_id") && ((EPGChannel) this.f1928i0.get(this.R0)).is_locked()) {
                L((EPGChannel) this.f1928i0.get(this.R0), this.R0, 1);
                return;
            }
            F((EPGChannel) this.f1928i0.get(this.R0));
            if (this.f1942v0.g()) {
                M(null);
            } else {
                handler.removeCallbacks(this.f1931k0);
                A(this.U0);
            }
            x(this.R0);
            if (this.f1937q0.getVisibility() == 8) {
                this.f1937q0.setVisibility(0);
            }
            handler.removeCallbacks(this.f1932l0);
            E();
            this.J0.setText(this.f1922e0);
            this.f1943w0.e0(this.R0);
            return;
        }
        if (id == R.id.btn_play) {
            y0 y0Var = this.M;
            if (y0Var == null || !y0Var.g()) {
                a0 a0Var = this.f1940t0;
                if (a0Var != null) {
                    if (a0Var.E()) {
                        this.f1940t0.U(false);
                        this.X.setImageResource(R.drawable.ic_play);
                        return;
                    } else {
                        this.f1940t0.U(true);
                        this.X.setImageResource(R.drawable.ic_pause);
                        return;
                    }
                }
                return;
            }
            if (this.f1919c1 == null) {
                this.f1919c1 = b.a(getApplicationContext());
            }
            if (this.f1921d1 == null) {
                b bVar = this.f1919c1;
                bVar.getClass();
                r7.r.b();
                this.f1921d1 = bVar.f5702c;
            }
            h7.d c10 = this.f1921d1.c();
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
            int i10 = this.R0;
            if (i10 > 0) {
                this.R0 = i10 - 1;
            } else {
                this.R0 = this.f1928i0.size() - 1;
            }
            if (this.f1928i0.size() <= 0 || this.R0 >= this.f1928i0.size()) {
                return;
            }
            if (((CategoryModel) this.f1916b0.get(this.Q0)).getId().equalsIgnoreCase("all_id") && D(((EPGChannel) this.f1928i0.get(this.R0)).getCategory_id(), ((EPGChannel) this.f1928i0.get(this.R0)).getCategory_name())) {
                L((EPGChannel) this.f1928i0.get(this.R0), this.R0, 1);
                return;
            }
            if (!D(((EPGChannel) this.f1928i0.get(this.R0)).getCategory_id(), ((EPGChannel) this.f1928i0.get(this.R0)).getCategory_name()) && !((CategoryModel) this.f1916b0.get(this.Q0)).getId().equalsIgnoreCase("lock_id") && ((EPGChannel) this.f1928i0.get(this.R0)).is_locked()) {
                L((EPGChannel) this.f1928i0.get(this.R0), this.R0, 1);
                return;
            }
            F((EPGChannel) this.f1928i0.get(this.R0));
            if (this.f1942v0.g()) {
                M(null);
            } else {
                handler.removeCallbacks(this.f1931k0);
                A(this.U0);
            }
            x(this.R0);
            this.J0.setText(this.f1922e0);
            if (this.f1937q0.getVisibility() == 8) {
                this.f1937q0.setVisibility(0);
            }
            handler.removeCallbacks(this.f1932l0);
            E();
            this.f1943w0.e0(this.R0);
            return;
        }
        if (id == R.id.btn_resolution) {
            if (this.f1940t0 == null) {
                return;
            }
            int i11 = (this.Y0 + 1) % 4;
            this.Y0 = i11;
            if (i11 == 0) {
                this.f1941u0.setResizeMode(3);
                AspectRatioFrameLayout aspectRatioFrameLayout = this.Z0;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(0.0f);
                }
                this.f1923e1.setText("Fill");
            } else if (i11 == 1) {
                this.f1941u0.setResizeMode(0);
                AspectRatioFrameLayout aspectRatioFrameLayout2 = this.Z0;
                if (aspectRatioFrameLayout2 != null) {
                    aspectRatioFrameLayout2.setAspectRatio(0.0f);
                }
                this.f1923e1.setText("Fit");
            } else if (i11 == 2) {
                this.f1941u0.setResizeMode(0);
                AspectRatioFrameLayout aspectRatioFrameLayout3 = this.Z0;
                if (aspectRatioFrameLayout3 != null) {
                    aspectRatioFrameLayout3.setAspectRatio(1.7777778f);
                }
                this.f1923e1.setText("16:9");
            } else if (i11 == 3) {
                this.f1941u0.setResizeMode(0);
                AspectRatioFrameLayout aspectRatioFrameLayout4 = this.Z0;
                if (aspectRatioFrameLayout4 != null) {
                    aspectRatioFrameLayout4.setAspectRatio(1.3333334f);
                }
                this.f1923e1.setText("4:3");
            }
            this.f1923e1.setVisibility(0);
            handler.removeCallbacks(this.f1925f1);
            this.f1927g1 = 2;
            c cVar2 = new c(this, 0);
            this.f1925f1 = cVar2;
            cVar2.run();
            return;
        }
        if (id == R.id.btn_search) {
            H();
            Intent intent2 = new Intent(this, (Class<?>) SearchActivity.class);
            intent2.putExtra("is_live", true);
            cVar.z(intent2);
            return;
        }
        if (id == R.id.txt_back || id == R.id.txt_live) {
            if (((CategoryModel) this.f1916b0.get(this.Q0)).getId().equalsIgnoreCase("resume_id") && this.f1946z0 != null) {
                I();
            }
            finish();
            return;
        }
        if (id == R.id.txt_home) {
            H();
            if (((CategoryModel) this.f1916b0.get(this.Q0)).getId().equalsIgnoreCase("resume_id") && this.f1946z0 != null) {
                I();
            }
            Intent intent3 = new Intent();
            intent3.putExtra("is_changed", "home");
            setResult(-1, intent3);
            finish();
            this.V0 = false;
            K();
            return;
        }
        if (id == R.id.txt_movie) {
            if (((CategoryModel) this.f1916b0.get(this.Q0)).getId().equalsIgnoreCase("resume_id") && this.f1946z0 != null) {
                I();
            }
            H();
            Intent intent4 = new Intent();
            intent4.putExtra("is_changed", "movie");
            setResult(-1, intent4);
            finish();
            return;
        }
        if (id == R.id.txt_series) {
            if (((CategoryModel) this.f1916b0.get(this.Q0)).getId().equalsIgnoreCase("resume_id") && this.f1946z0 != null) {
                I();
            }
            H();
            Intent intent5 = new Intent();
            intent5.putExtra("is_changed", "series");
            setResult(-1, intent5);
            finish();
            return;
        }
        if (id == R.id.view_click) {
            y0 y0Var2 = this.M;
            if (y0Var2 != null && y0Var2.g()) {
                this.f1937q0.setVisibility(0);
            } else if (this.f1937q0.getVisibility() == 0) {
                handler.removeCallbacks(this.f1932l0);
                this.f1937q0.setVisibility(8);
            }
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_live_channel_mobile);
        this.M = new y0(this);
        b a10 = b.a(getApplicationContext());
        this.f1919c1 = a10;
        a10.getClass();
        r7.r.b();
        this.f1921d1 = a10.f5702c;
        this.f1915a1 = new d(this, new Handler(Looper.getMainLooper()), 0);
        j().a(this, new androidx.fragment.app.a0(this, 3));
        k5.j.a(this);
        this.f1942v0 = new r(this);
        this.P0 = app.shamel.tv.helper.a.k(this);
        this.f1939s0 = (ConstraintLayout) findViewById(R.id.fullContainer);
        PlayerView playerView = (PlayerView) findViewById(R.id.player_view);
        this.f1941u0 = playerView;
        this.Z0 = (AspectRatioFrameLayout) playerView.findViewById(R.id.exo_content_frame);
        playerView.setResizeMode(4);
        this.f1941u0.getSubtitleView().setApplyEmbeddedStyles(false);
        u3.c cVar = new u3.c(Color.parseColor(this.f1942v0.D()), Color.parseColor(this.f1942v0.C()), 0, 0, 0, null);
        this.f1941u0.getSubtitleView().a(3, this.f1942v0.F());
        this.f1941u0.getSubtitleView().setStyle(cVar);
        this.f1917b1 = (MediaRouteButton) findViewById(R.id.btn_cast);
        this.f1923e1 = (TextView) findViewById(R.id.view_txt_resolution);
        this.G0 = (TextView) findViewById(R.id.txt_home);
        this.H0 = (TextView) findViewById(R.id.txt_live);
        this.I0 = (TextView) findViewById(R.id.txt_movie);
        this.M0 = (TextView) findViewById(R.id.txt_series);
        this.B0 = (TextView) findViewById(R.id.txt_back);
        this.J0 = (TextView) findViewById(R.id.txt_name);
        this.f1934n0 = (EditText) findViewById(R.id.et_search);
        this.f1943w0 = (RecyclerView) findViewById(R.id.recycler_channel);
        this.f1938r0 = (ConstraintLayout) findViewById(R.id.ly_surface);
        this.f1944x0 = (RecyclerView) findViewById(R.id.recycler_epg);
        this.R = (Button) findViewById(R.id.btn_fav);
        this.Q = (Button) findViewById(R.id.btn_catch_up);
        this.f1914a0 = (Button) findViewById(R.id.btn_search);
        this.G0.setText(this.P0.getHome());
        this.H0.setText(this.P0.getLive_tv());
        this.I0.setText(this.P0.getMovies());
        this.M0.setText(this.P0.getSeries());
        this.B0.setText(this.P0.getBack());
        this.Q.setText(this.P0.getCatch_up());
        this.f1914a0.setText(this.P0.getSearch());
        this.R.setText(this.P0.getAdd_to_favorite());
        this.f1937q0 = (ConstraintLayout) findViewById(R.id.ly_control);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.f1945y0 = seekBar;
        seekBar.setMax(100);
        this.E0 = (TextView) findViewById(R.id.txt_current_time);
        this.D0 = (TextView) findViewById(R.id.txt_current_program);
        this.L0 = (TextView) findViewById(R.id.txt_next_time);
        this.K0 = (TextView) findViewById(R.id.txt_next_program);
        this.F0 = (TextView) findViewById(R.id.txt_group);
        this.C0 = (TextView) findViewById(R.id.txt_channel_name);
        this.f1920d0 = (ImageView) findViewById(R.id.channel_image);
        this.f1936p0 = (ImageView) findViewById(R.id.image_def);
        this.S = (ImageButton) findViewById(R.id.btn_full_catch);
        this.P = (ImageButton) findViewById(R.id.btn_back);
        this.T = (ImageButton) findViewById(R.id.btn_full_fav);
        this.U = (ImageButton) findViewById(R.id.btn_full_search);
        this.V = (ImageButton) findViewById(R.id.btn_lock);
        this.Z = (ImageButton) findViewById(R.id.btn_resolution);
        this.N0 = findViewById(R.id.view_click);
        this.W = (ImageButton) findViewById(R.id.btn_next);
        this.X = (ImageButton) findViewById(R.id.btn_play);
        this.Y = (ImageButton) findViewById(R.id.btn_previous);
        this.O = (SeekBar) findViewById(R.id.bright_seekbar);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.volume_seekbar);
        this.O0 = seekBar2;
        seekBar2.setOnSeekBarChangeListener(this);
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        this.N = audioManager;
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = this.N.getStreamVolume(3);
        this.O0.setMax(streamMaxVolume);
        this.O0.setProgress(streamVolume);
        this.O.setOnSeekBarChangeListener(this);
        this.O.setMax(255);
        this.O.setProgress(Settings.System.getInt(getContentResolver(), "screen_brightness", 0));
        this.f1938r0.setOnClickListener(this);
        this.H0.setOnClickListener(this);
        this.G0.setOnClickListener(this);
        this.M0.setOnClickListener(this);
        this.I0.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.f1914a0.setOnClickListener(this);
        this.B0.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.N0.setOnClickListener(this);
        this.f1934n0.addTextChangedListener(new app.shamel.tv.activities.l(8, this));
        this.f1941u0.getVideoSurfaceView().setOnClickListener(new androidx.leanback.widget.g0(5, this));
        h7.a.a(this, this.f1917b1);
        this.f1926g0 = k5.a.i(this, this.f1942v0.k());
        i1.y0 y0Var = new i1.y0();
        y0Var.j(3, !this.f1942v0.E());
        this.A0 = new z0(y0Var);
        this.V0 = getIntent().getBooleanExtra("is_full", false);
        l.a(this, this.f1942v0.h());
        this.f1916b0 = LTVApp.f2087v;
        int c10 = this.f1942v0.c();
        this.Q0 = c10;
        if (c10 > this.f1916b0.size() - 1) {
            this.Q0 = 1;
        }
        int i10 = this.Q0;
        if (i10 <= 4 || i10 >= this.f1942v0.s().size() + 5) {
            this.f1928i0 = n.K().w((CategoryModel) this.f1916b0.get(this.Q0), _UrlKt.FRAGMENT_ENCODE_SET, this.f1942v0.g(), this.f1942v0.o());
        } else if (!this.f1942v0.s().isEmpty()) {
            n K = n.K();
            r rVar = this.f1942v0;
            this.f1928i0 = K.s(_UrlKt.FRAGMENT_ENCODE_SET, rVar.t((String) rVar.s().get(this.Q0 - 5)));
        }
        this.R0 = 0;
        this.f1918c0 = new e(this, this.f1928i0, 0, new app.shamel.tv.activities.x(2, this));
        this.f1943w0.setLayoutManager(new LinearLayoutManager(1));
        this.f1943w0.setAdapter(this.f1918c0);
        this.f1943w0.requestFocus();
        this.f1943w0.e0(this.R0);
        this.h0 = new m(this, new ArrayList());
        this.f1944x0.setLayoutManager(new LinearLayoutManager(1));
        this.f1944x0.setAdapter(this.h0);
        this.f1944x0.setFocusable(false);
        if (this.f1928i0.isEmpty()) {
            return;
        }
        K();
        if (D(((EPGChannel) this.f1928i0.get(this.R0)).getCategory_id(), ((EPGChannel) this.f1928i0.get(this.R0)).getCategory_name())) {
            this.R0 = 0;
        }
        if (!((CategoryModel) this.f1916b0.get(this.Q0)).getId().equalsIgnoreCase("lock_id") && ((EPGChannel) this.f1928i0.get(this.R0)).is_locked()) {
            L((EPGChannel) this.f1928i0.get(this.R0), this.R0, 1);
            return;
        }
        F((EPGChannel) this.f1928i0.get(this.R0));
        this.U0 = ((EPGChannel) this.f1928i0.get(this.R0)).getStream_id();
        if (this.f1942v0.g()) {
            M(null);
        } else {
            this.W0.removeCallbacks(this.f1931k0);
            A(this.U0);
        }
        String name = ((EPGChannel) this.f1928i0.get(this.R0)).getName();
        this.f1922e0 = name;
        this.J0.setText(name);
        N(((EPGChannel) this.f1928i0.get(this.R0)).is_favorite());
        x(this.R0);
    }

    @Override // f.j, android.app.Activity
    public final void onPause() {
        super.onPause();
        i iVar = this.f1921d1;
        if (iVar != null) {
            iVar.e(this.f1929i1);
        }
        if (this.f1915a1 != null) {
            getContentResolver().unregisterContentObserver(this.f1915a1);
        }
        if (Build.VERSION.SDK_INT <= 23) {
            PlayerView playerView = this.f1941u0;
            if (playerView != null) {
                playerView.g();
            }
            H();
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
            a0 a0Var = this.f1940t0;
            if (a0Var == null || streamMaxVolume <= 0) {
                return;
            }
            a0Var.Y(i10 / streamMaxVolume);
        }
    }

    @Override // f.j, android.app.Activity
    public final void onResume() {
        y0 y0Var;
        super.onResume();
        i iVar = this.f1921d1;
        if (iVar != null) {
            iVar.a(this.f1929i1);
        }
        if (Build.VERSION.SDK_INT <= 23 && ((y0Var = this.M) == null || !y0Var.g())) {
            C();
        }
        AudioManager audioManager = this.N;
        if (audioManager != null && this.O0 != null) {
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = this.N.getStreamVolume(3);
            this.O0.setMax(streamMaxVolume);
            this.O0.setProgress(streamVolume);
        }
        getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.f1915a1);
    }

    @Override // f.j, android.app.Activity
    public final void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT > 23) {
            y0 y0Var = this.M;
            if (y0Var == null || !y0Var.g()) {
                C();
            }
        }
    }

    @Override // f.j, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT > 23) {
            PlayerView playerView = this.f1941u0;
            if (playerView != null) {
                playerView.g();
            }
            H();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.mobile.LiveChannelMobileActivity.w(java.lang.String):void");
    }

    public final void x(int i10) {
        this.F0.setText(this.X0);
        this.C0.setText(((EPGChannel) this.f1928i0.get(i10)).getNum() + " " + ((EPGChannel) this.f1928i0.get(i10)).getName());
        String stream_icon = ((EPGChannel) this.f1928i0.get(i10)).getStream_icon();
        if (stream_icon == null || stream_icon.isEmpty()) {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).q(Integer.valueOf(R.drawable.home_logo)).g(R.drawable.home_logo)).E(this.f1920d0);
        } else {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).r(stream_icon).g(R.drawable.home_logo)).E(this.f1920d0);
        }
    }

    public final void y(EPGChannel ePGChannel, int i10) {
        if (ePGChannel == null || l.f4606a.contains(((CategoryModel) this.f1916b0.get(this.Q0)).getId())) {
            return;
        }
        n.K().h(ePGChannel.getName(), !ePGChannel.is_favorite(), new c5.a(i10, 0, this));
    }

    public final void z(EPGChannel ePGChannel, int i10) {
        if (ePGChannel == null || l.f4606a.contains(((CategoryModel) this.f1916b0.get(this.Q0)).getId())) {
            return;
        }
        n.K().k(ePGChannel.getName(), !ePGChannel.is_locked(), new app.shamel.tv.b(i10, 4, this));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
