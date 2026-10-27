package app.shamel.tv.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.AppInfoModel;
import app.shamel.tv.models.LoginModel;
import app.shamel.tv.models.WordModels;
import c2.j1;
import org.chromium.net.R;
import org.json.JSONException;
import org.json.JSONObject;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class HomeActivity extends e5.k implements View.OnClickListener, j5.d {
    public static final /* synthetic */ int B0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public c2.y0 f1622c0;

    /* renamed from: d0, reason: collision with root package name */
    public h5.b f1623d0;

    /* renamed from: e0, reason: collision with root package name */
    public AppInfoModel f1624e0;

    /* renamed from: f0, reason: collision with root package name */
    public ConstraintLayout f1625f0;

    /* renamed from: g0, reason: collision with root package name */
    public ConstraintLayout f1626g0;
    public ConstraintLayout h0;

    /* renamed from: i0, reason: collision with root package name */
    public ConstraintLayout f1627i0;

    /* renamed from: j0, reason: collision with root package name */
    public ConstraintLayout f1628j0;

    /* renamed from: k0, reason: collision with root package name */
    public ConstraintLayout f1629k0;

    /* renamed from: l0, reason: collision with root package name */
    public ConstraintLayout f1630l0;

    /* renamed from: m0, reason: collision with root package name */
    public ConstraintLayout f1631m0;

    /* renamed from: n0, reason: collision with root package name */
    public app.shamel.tv.helper.r f1632n0;

    /* renamed from: o0, reason: collision with root package name */
    public GifImageView f1633o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f1634p0;

    /* renamed from: q0, reason: collision with root package name */
    public TextView f1635q0;

    /* renamed from: r0, reason: collision with root package name */
    public TextView f1636r0;

    /* renamed from: s0, reason: collision with root package name */
    public TextView f1637s0;

    /* renamed from: t0, reason: collision with root package name */
    public TextView f1638t0;

    /* renamed from: u0, reason: collision with root package name */
    public TextView f1639u0;

    /* renamed from: v0, reason: collision with root package name */
    public TextView f1640v0;

    /* renamed from: w0, reason: collision with root package name */
    public TextView f1641w0;

    /* renamed from: x0, reason: collision with root package name */
    public TextView f1642x0;

    /* renamed from: y0, reason: collision with root package name */
    public TextView f1643y0;

    /* renamed from: z0, reason: collision with root package name */
    public WordModels f1644z0 = new WordModels();
    public final androidx.activity.result.c A0 = l(new androidx.fragment.app.e0(2), new s(this));

    public final void P() {
        WordModels k10 = app.shamel.tv.helper.a.k(this);
        this.f1644z0 = k10;
        this.f1637s0.setText(k10.getLive_tv());
        this.f1638t0.setText(this.f1644z0.getMovies());
        this.f1640v0.setText(this.f1644z0.getSeries());
        this.f1634p0.setText(this.f1644z0.getAccount());
        this.f1635q0.setText(this.f1644z0.getChange_playlist());
        this.f1641w0.setText(this.f1644z0.getSettings());
        this.f1639u0.setText(this.f1644z0.getReload_portal());
        this.f1636r0.setText(this.f1644z0.getExit());
    }

    public final void Q() {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_exit");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return;
        }
        h5.u N = h5.u.N(this.f1644z0.getExit(), this.f1644z0.getExit_description(), this.f1644z0.getStr_yes(), this.f1644z0.getNo());
        N.B0 = new s(this);
        N.M(n10, "fragment_exit");
    }

    public final void R() {
        Toast.makeText(this, this.f1644z0.getPlaylist_is_loading(), 0).show();
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        Q();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        boolean z10 = false;
        if (id == R.id.ly_account) {
            androidx.fragment.app.j0 n10 = n();
            androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
            androidx.fragment.app.s A = n10.A("fragment_account");
            if (A != null) {
                android.support.v4.media.d.v(i10, A, false);
                return;
            }
            h5.b bVar = new h5.b();
            bVar.f5583z0 = this;
            this.f1623d0 = bVar;
            bVar.A0 = new s(this);
            bVar.M(n10, "fragment_account");
            return;
        }
        if (id == R.id.ly_change) {
            this.Y = true;
            Intent intent = new Intent(this, (Class<?>) ChangePlaylistActivity.class);
            intent.addFlags(67108864);
            intent.putExtra("is_home", true);
            startActivity(intent);
            finish();
            return;
        }
        if (id == R.id.ly_exit) {
            Q();
            return;
        }
        if (id == R.id.ly_live) {
            if (this.f1633o0.getVisibility() == 0) {
                R();
                return;
            }
            app.shamel.tv.helper.r rVar = this.f1632n0;
            rVar.getClass();
            try {
                z10 = rVar.f2098b.getBoolean("is_grid", false);
            } catch (Exception unused) {
            }
            if (z10) {
                LTVApp.f2090y = 1;
                startActivity(new Intent(this, (Class<?>) CategoryActivity.class));
                return;
            } else if (app.shamel.tv.helper.a.l(this)) {
                startActivity(new Intent(this, (Class<?>) LiveActivity.class));
                return;
            } else {
                startActivity(new Intent(this, (Class<?>) LiveMobileActivity.class));
                return;
            }
        }
        if (id == R.id.ly_movie) {
            if (this.f1633o0.getVisibility() == 0) {
                R();
                return;
            }
            app.shamel.tv.helper.r rVar2 = this.f1632n0;
            rVar2.getClass();
            try {
                z10 = rVar2.f2098b.getBoolean("is_grid", false);
            } catch (Exception unused2) {
            }
            if (!z10) {
                startActivity(new Intent(this, (Class<?>) MovieActivity.class));
                return;
            } else {
                LTVApp.f2090y = 2;
                startActivity(new Intent(this, (Class<?>) CategoryActivity.class));
                return;
            }
        }
        if (id == R.id.ly_reload) {
            if (this.f1633o0.getVisibility() == 0) {
                R();
                return;
            }
            this.f1633o0.setVisibility(0);
            int i11 = app.shamel.tv.helper.a.i(this);
            AppInfoModel b2 = this.f1632n0.b();
            if (b2.getResult().isEmpty()) {
                return;
            }
            AppInfoModel.UrlModel urlModel = b2.getResult().get(i11);
            this.f1632n0.Q(0L);
            if (urlModel.getUrl().contains("username")) {
                this.f1632n0.P(false);
                L(urlModel.getUrl(), this.f1644z0);
                return;
            } else if (app.shamel.tv.helper.a.a(urlModel.getUrl())) {
                this.f1632n0.P(false);
                M(urlModel.getUrl(), this.f1644z0);
                return;
            } else {
                this.f1632n0.P(true);
                N(urlModel.getUrl(), this.f1644z0);
                return;
            }
        }
        if (id != R.id.ly_series) {
            if (id == R.id.ly_setting) {
                if (this.f1633o0.getVisibility() == 0) {
                    R();
                    return;
                } else {
                    this.A0.z(new Intent(this, (Class<?>) SettingActivity.class));
                    return;
                }
            }
            return;
        }
        if (this.f1633o0.getVisibility() == 0) {
            R();
            return;
        }
        app.shamel.tv.helper.r rVar3 = this.f1632n0;
        rVar3.getClass();
        try {
            z10 = rVar3.f2098b.getBoolean("is_grid", false);
        } catch (Exception unused3) {
        }
        if (!z10) {
            startActivity(new Intent(this, (Class<?>) SeriesActivity.class));
        } else {
            LTVApp.f2090y = 3;
            startActivity(new Intent(this, (Class<?>) CategoryActivity.class));
        }
    }

    @Override // e5.k, f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        LoginModel q10;
        super.onCreate(bundle);
        setContentView(R.layout.activity_home);
        this.f1622c0 = new c2.y0(this);
        k5.j.a(this);
        app.shamel.tv.helper.r rVar = new app.shamel.tv.helper.r(this);
        this.f1632n0 = rVar;
        this.f1624e0 = rVar.b();
        this.f1642x0 = (TextView) findViewById(R.id.txt_time);
        this.f1627i0 = (ConstraintLayout) findViewById(R.id.ly_live);
        this.f1628j0 = (ConstraintLayout) findViewById(R.id.ly_movie);
        this.f1630l0 = (ConstraintLayout) findViewById(R.id.ly_series);
        this.f1625f0 = (ConstraintLayout) findViewById(R.id.ly_account);
        this.f1626g0 = (ConstraintLayout) findViewById(R.id.ly_change);
        this.f1631m0 = (ConstraintLayout) findViewById(R.id.ly_setting);
        this.f1629k0 = (ConstraintLayout) findViewById(R.id.ly_reload);
        this.h0 = (ConstraintLayout) findViewById(R.id.ly_exit);
        this.f1637s0 = (TextView) findViewById(R.id.txt_live);
        this.f1638t0 = (TextView) findViewById(R.id.txt_movie);
        this.f1640v0 = (TextView) findViewById(R.id.txt_series);
        this.f1634p0 = (TextView) findViewById(R.id.txt_account);
        this.f1635q0 = (TextView) findViewById(R.id.txt_change);
        this.f1641w0 = (TextView) findViewById(R.id.txt_setting);
        this.f1639u0 = (TextView) findViewById(R.id.txt_reload);
        this.f1636r0 = (TextView) findViewById(R.id.txt_exit);
        this.f1643y0 = (TextView) findViewById(R.id.txt_version);
        this.f1633o0 = (GifImageView) findViewById(R.id.progress_bar);
        this.f1627i0.setOnClickListener(this);
        this.f1628j0.setOnClickListener(this);
        this.f1630l0.setOnClickListener(this);
        this.f1625f0.setOnClickListener(this);
        this.f1626g0.setOnClickListener(this);
        this.f1631m0.setOnClickListener(this);
        this.f1629k0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        P();
        TextView textView = this.f1642x0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f1644z0.getCurrent_expired());
        sb2.append(" ");
        sb2.append((this.f1632n0.g() || (q10 = this.f1632n0.q()) == null) ? "Undefined." : k5.j.g(q10.getExp_date()));
        textView.setText(sb2.toString());
        LTVApp.f2085t.getClass();
        LTVApp.c();
        LTVApp.f2085t.b();
        this.f1643y0.setText("v" + LTVApp.f2089x);
        if (this.f1624e0.getParent_synced() == 0) {
            try {
                String m10 = com.google.android.gms.internal.cast.n.m(this.f1632n0.r(), this.f1632n0.u());
                j1 j1Var = new j1(this, 3000);
                j1Var.i(com.google.android.gms.internal.cast.n.l(m10), e5.l.f4611f);
                j1Var.f2627r = this;
            } catch (JSONException e7) {
                Log.e("HomeActivity", "onCreate", e7);
                Toast.makeText(this, "JSON error in parent sync", 0).show();
            }
        }
        this.f1627i0.requestFocus();
        j().a(this, new androidx.fragment.app.a0(this, 2));
    }

    @Override // f.j, android.app.Activity
    public final void onResume() {
        super.onResume();
        c2.y0 y0Var = this.f1622c0;
        if (y0Var == null || !y0Var.g()) {
            return;
        }
        this.f1622c0.i();
    }

    @Override // e5.k
    public final void w(boolean z10) {
        if (z10) {
            this.f1632n0.Q(System.currentTimeMillis() / 1000);
            this.f1633o0.setVisibility(8);
            Toast.makeText(this, this.f1644z0.getPortal_loaded_successfully(), 0).show();
            return;
        }
        this.f1633o0.setVisibility(8);
        androidx.fragment.app.j0 n10 = n();
        n10.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n10);
        androidx.fragment.app.s A = n10.A("fragment_no_connection");
        if (A != null) {
            android.support.v4.media.d.v(aVar, A, false);
            return;
        }
        String playlist_is_not_working = this.f1644z0.getPlaylist_is_not_working();
        h5.k0 k0Var = new h5.k0();
        k0Var.f5618y0 = this;
        k0Var.D0 = playlist_is_not_working;
        k0Var.f5619z0 = new s(this);
        k0Var.M(n10, "fragment_no_connection");
    }

    @Override // j5.d
    public final void a(JSONObject jSONObject, int i10) {
    }
}
