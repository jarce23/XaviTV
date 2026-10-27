package app.shamel.tv.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.AppInfoModel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import org.json.JSONObject;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ChangePlaylistActivity extends e5.k implements j5.d {
    public static final /* synthetic */ int G0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public h5.k f1599c0;

    /* renamed from: d0, reason: collision with root package name */
    public AppInfoModel f1600d0;

    /* renamed from: e0, reason: collision with root package name */
    public Button f1601e0;

    /* renamed from: f0, reason: collision with root package name */
    public Button f1602f0;

    /* renamed from: g0, reason: collision with root package name */
    public ImageView f1603g0;
    public TextView h0;

    /* renamed from: i0, reason: collision with root package name */
    public TextView f1604i0;

    /* renamed from: j0, reason: collision with root package name */
    public d5.j0 f1605j0;

    /* renamed from: k0, reason: collision with root package name */
    public app.shamel.tv.helper.r f1606k0;

    /* renamed from: l0, reason: collision with root package name */
    public GifImageView f1607l0;

    /* renamed from: m0, reason: collision with root package name */
    public LiveVerticalGridView f1608m0;

    /* renamed from: n0, reason: collision with root package name */
    public TextView f1609n0;

    /* renamed from: o0, reason: collision with root package name */
    public TextView f1610o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f1611p0;

    /* renamed from: q0, reason: collision with root package name */
    public TextView f1612q0;

    /* renamed from: r0, reason: collision with root package name */
    public TextView f1613r0;

    /* renamed from: s0, reason: collision with root package name */
    public TextView f1614s0;

    /* renamed from: t0, reason: collision with root package name */
    public TextView f1615t0;

    /* renamed from: u0, reason: collision with root package name */
    public TextView f1616u0;

    /* renamed from: v0, reason: collision with root package name */
    public TextView f1617v0;

    /* renamed from: w0, reason: collision with root package name */
    public TextView f1618w0;

    /* renamed from: x0, reason: collision with root package name */
    public TextView f1619x0;

    /* renamed from: y0, reason: collision with root package name */
    public final SimpleDateFormat f1620y0 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    /* renamed from: z0, reason: collision with root package name */
    public long f1621z0 = 0;
    public List A0 = new ArrayList();
    public WordModels B0 = new WordModels();
    public int C0 = 0;
    public int D0 = 0;
    public AppInfoModel.UrlModel E0 = null;
    public boolean F0 = false;

    public static void P(ChangePlaylistActivity changePlaylistActivity, AppInfoModel.UrlModel urlModel) {
        changePlaylistActivity.f1607l0.setVisibility(0);
        if (urlModel.getUrl().contains("username")) {
            changePlaylistActivity.f1606k0.P(false);
            changePlaylistActivity.L(urlModel.getUrl(), changePlaylistActivity.B0);
        } else if (app.shamel.tv.helper.a.a(urlModel.getUrl())) {
            changePlaylistActivity.f1606k0.P(false);
            changePlaylistActivity.M(urlModel.getUrl(), changePlaylistActivity.B0);
        } else {
            changePlaylistActivity.f1606k0.P(true);
            changePlaylistActivity.N(urlModel.getUrl(), changePlaylistActivity.B0);
        }
    }

    public static void Q(ChangePlaylistActivity changePlaylistActivity, int i10) {
        androidx.fragment.app.j0 n10 = changePlaylistActivity.n();
        androidx.fragment.app.a i11 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_add");
        if (A != null) {
            android.support.v4.media.d.v(i11, A, false);
            return;
        }
        p pVar = new p(changePlaylistActivity);
        h5.k kVar = new h5.k();
        kVar.C0 = changePlaylistActivity;
        kVar.H0 = pVar;
        kVar.S0 = i10;
        changePlaylistActivity.f1599c0 = kVar;
        kVar.M(n10, "fragment_add");
    }

    @Override // j5.d
    public final void a(JSONObject jSONObject, int i10) {
        if (jSONObject != null) {
            if (i10 == 2000) {
                try {
                    AppInfoModel.UrlModel urlModel = this.E0;
                    if (urlModel != null) {
                        this.A0.remove(urlModel);
                        d5.j0 j0Var = this.f1605j0;
                        j0Var.f4120d = this.A0;
                        j0Var.d();
                        this.f1600d0.setResult(this.A0);
                        this.f1606k0.L(this.f1600d0);
                        k5.j.p(this.f1600d0);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            try {
                if (jSONObject.getBoolean("status")) {
                    Toast.makeText(this, this.B0.getActivate_success(), 0).show();
                    this.f1600d0.setIs_trial(2);
                    this.f1600d0.setIs_google_pay(true);
                    SharedPreferences.Editor edit = this.f1606k0.f2098b.edit();
                    edit.putBoolean("is_changed", true);
                    edit.apply();
                    this.f1606k0.L(this.f1600d0);
                    this.f1601e0.setVisibility(4);
                }
            } catch (Exception unused2) {
                this.f1600d0.setIs_trial(2);
                this.f1600d0.setIs_google_pay(true);
                SharedPreferences.Editor edit2 = this.f1606k0.f2098b.edit();
                edit2.putBoolean("is_changed", true);
                edit2.apply();
                this.f1606k0.L(this.f1600d0);
                this.f1601e0.setVisibility(4);
            }
        }
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                switch (keyCode) {
                    case 19:
                    case 21:
                        if (this.f1601e0.hasFocus()) {
                            this.f1601e0.setFocusable(false);
                            this.f1608m0.requestFocus();
                            return true;
                        }
                        break;
                    case 20:
                        if (this.D0 > this.A0.size() - 3) {
                            this.f1601e0.setFocusable(true);
                            this.f1601e0.requestFocus();
                            return true;
                        }
                        break;
                    case 22:
                        int i10 = this.D0;
                        if (i10 % 3 == 2 || i10 == this.A0.size()) {
                            this.f1601e0.setFocusable(true);
                            this.f1601e0.requestFocus();
                            return true;
                        }
                        break;
                }
            } else {
                if (!this.F0) {
                    androidx.fragment.app.j0 n10 = n();
                    androidx.fragment.app.a i11 = android.support.v4.media.d.i(n10, n10);
                    androidx.fragment.app.s A = n10.A("fragment_exit");
                    if (A != null) {
                        android.support.v4.media.d.v(i11, A, false);
                        return true;
                    }
                    h5.u N = h5.u.N(this.B0.getExit(), this.B0.getExit_description(), this.B0.getStr_yes(), this.B0.getNo());
                    N.B0 = new p(this);
                    N.M(n10, "fragment_exit");
                    return true;
                }
                startActivity(new Intent(this, (Class<?>) HomeActivity.class));
                finish();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // e5.k, f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k5.j.a(this);
        if (app.shamel.tv.helper.a.l(this)) {
            setContentView(R.layout.activity_change_playlist);
        } else {
            setContentView(R.layout.activity_change_playlist_mobile);
        }
        app.shamel.tv.helper.r rVar = new app.shamel.tv.helper.r(this);
        this.f1606k0 = rVar;
        AppInfoModel b2 = rVar.b();
        this.f1600d0 = b2;
        if (b2 != null) {
            this.A0 = b2.getResult();
            int i10 = app.shamel.tv.helper.a.i(this);
            this.C0 = i10;
            this.D0 = i10;
        }
        this.B0 = app.shamel.tv.helper.a.k(this);
        this.f1608m0 = (LiveVerticalGridView) findViewById(R.id.recycler_playlist);
        this.f1618w0 = (TextView) findViewById(R.id.txt_mac_address);
        this.f1612q0 = (TextView) findViewById(R.id.str_mac_trial);
        this.f1614s0 = (TextView) findViewById(R.id.str_trial);
        this.f1613r0 = (TextView) findViewById(R.id.str_scan_code);
        this.f1609n0 = (TextView) findViewById(R.id.str_device_key);
        this.f1616u0 = (TextView) findViewById(R.id.txt_description);
        this.f1611p0 = (TextView) findViewById(R.id.str_mac_address);
        this.f1617v0 = (TextView) findViewById(R.id.txt_device_key);
        this.f1619x0 = (TextView) findViewById(R.id.txt_version);
        this.f1604i0 = (TextView) findViewById(R.id.notiTitle);
        this.h0 = (TextView) findViewById(R.id.notiContent);
        this.f1615t0 = (TextView) findViewById(R.id.str_upload);
        this.f1602f0 = (Button) findViewById(R.id.btn_web_site);
        this.f1603g0 = (ImageView) findViewById(R.id.image_logo);
        this.f1610o0 = (TextView) findViewById(R.id.str_link);
        this.f1607l0 = (GifImageView) findViewById(R.id.progress_bar);
        this.f1601e0 = (Button) findViewById(R.id.btn_pay);
        this.f1602f0.setOnClickListener(new androidx.leanback.widget.g0(2, this));
        if (app.shamel.tv.helper.a.l(this)) {
            this.f1608m0.setNumColumns(3);
            this.f1608m0.setLoop(false);
            this.f1608m0.setPreserveFocusAfterLayout(true);
            this.f1608m0.setOnChildViewHolderSelectedListener(new e(5, new View[]{null}));
            this.f1603g0.setVisibility(0);
            this.f1602f0.setVisibility(8);
            this.f1613r0.setVisibility(0);
        } else {
            this.f1608m0.setLayoutManager(new GridLayoutManager(3));
            this.f1608m0.setHasFixedSize(true);
            this.f1603g0.setVisibility(8);
            this.f1602f0.setVisibility(0);
            this.f1613r0.setVisibility(8);
        }
        this.f1602f0.setText(this.B0.getOpen_website());
        this.f1604i0.setText(this.B0.getIbo_pro_description());
        this.h0.setText(this.B0.getIbo_pro_general_player());
        this.f1615t0.setText(this.B0.getTo_add_manage());
        this.f1611p0.setText(this.B0.getMac_address());
        this.f1618w0.setText(this.f1606k0.r());
        TextView textView = this.f1617v0;
        app.shamel.tv.helper.r rVar2 = this.f1606k0;
        rVar2.getClass();
        String str = _UrlKt.FRAGMENT_ENCODE_SET;
        try {
            str = rVar2.f2098b.getString("device_key", _UrlKt.FRAGMENT_ENCODE_SET);
        } catch (Exception unused) {
        }
        textView.setText(str);
        this.f1613r0.setText(this.B0.getScan_code());
        this.f1609n0.setText(this.B0.getDevice_key());
        LTVApp.f2085t.getClass();
        LTVApp.c();
        LTVApp.f2085t.b();
        this.f1619x0.setText("v" + LTVApp.f2089x);
        if (this.f1600d0.getTestingModel().isIs_ibo()) {
            this.f1603g0.setVisibility(4);
            this.f1610o0.setVisibility(4);
            this.f1613r0.setVisibility(4);
            this.f1602f0.setVisibility(4);
            this.f1604i0.setVisibility(4);
            this.h0.setVisibility(4);
        }
        this.F0 = getIntent().getBooleanExtra("is_home", false);
        this.Y = false;
        e5.k.O(false);
        if (this.A0 == null) {
            this.A0 = new ArrayList();
        }
        try {
            Date parse = this.f1620y0.parse(this.f1600d0.getExpiredDate());
            this.f1621z0 = parse != null ? parse.getTime() : 0L;
        } catch (Exception unused2) {
            this.f1621z0 = 0L;
        }
        AppInfoModel appInfoModel = this.f1600d0;
        if (appInfoModel != null) {
            if (appInfoModel.getIs_trial() == 2 || this.f1621z0 - new Date().getTime() > 604800000) {
                this.f1612q0.setText(this.B0.getMac_activated());
                this.f1601e0.setVisibility(4);
                this.f1616u0.setText(this.B0.getEnjoy_tv());
                this.f1614s0.setVisibility(8);
            } else if (this.f1621z0 - new Date().getTime() > 0) {
                this.f1612q0.setText(this.B0.getTv_is_trial());
                this.f1614s0.setText(this.B0.getStr_trial_description());
                this.f1614s0.setVisibility(0);
            } else {
                this.f1612q0.setText(this.B0.getTv_mac_expired());
                this.f1614s0.setVisibility(8);
                this.f1601e0.setVisibility(4);
            }
        }
        if (k5.j.b()) {
            this.f1601e0.setVisibility(4);
        }
        List list = this.A0;
        int i11 = this.C0;
        r rVar3 = new r(this);
        d5.j0 j0Var = new d5.j0();
        j0Var.f4122f = -1;
        j0Var.g = new WordModels();
        j0Var.f4120d = new ArrayList(list);
        j0Var.f4121e = rVar3;
        j0Var.f4122f = i11;
        j0Var.g = app.shamel.tv.helper.a.k(this);
        this.f1605j0 = j0Var;
        this.f1601e0.setFocusable(false);
        this.f1608m0.setAdapter(this.f1605j0);
        this.f1608m0.requestFocus();
        this.f1608m0.setSelectedPosition(this.C0);
        j().a(this, new androidx.fragment.app.a0(this, 1));
    }

    @Override // e5.k
    public final void w(boolean z10) {
        if (z10) {
            this.f1607l0.setVisibility(8);
            this.f1606k0.Q(System.currentTimeMillis() / 1000);
            app.shamel.tv.helper.r rVar = this.f1606k0;
            int i10 = this.C0;
            SharedPreferences.Editor edit = rVar.f2098b.edit();
            edit.putInt("playlist_position", i10);
            edit.apply();
            startActivity(new Intent(this, (Class<?>) HomeActivity.class));
            finish();
            return;
        }
        this.f1607l0.setVisibility(8);
        androidx.fragment.app.j0 n10 = n();
        n10.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n10);
        androidx.fragment.app.s A = n10.A("fragment_no_connection");
        if (A != null) {
            android.support.v4.media.d.v(aVar, A, true);
            return;
        }
        String playlist_is_not_working = this.B0.getPlaylist_is_not_working();
        h5.k0 k0Var = new h5.k0();
        k0Var.f5618y0 = this;
        k0Var.D0 = playlist_is_not_working;
        k0Var.f5619z0 = new p(this);
        k0Var.M(n10, "fragment_no_connection");
    }
}
