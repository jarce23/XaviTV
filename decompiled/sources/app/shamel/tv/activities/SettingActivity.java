package app.shamel.tv.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.AppInfoModel;
import app.shamel.tv.models.WordModels;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SettingActivity extends e5.k implements View.OnClickListener {

    /* renamed from: u0, reason: collision with root package name */
    public static final /* synthetic */ int f1845u0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public d5.y f1846c0;

    /* renamed from: d0, reason: collision with root package name */
    public h5.k f1847d0;

    /* renamed from: e0, reason: collision with root package name */
    public double f1848e0;

    /* renamed from: f0, reason: collision with root package name */
    public AppInfoModel f1849f0;

    /* renamed from: g0, reason: collision with root package name */
    public ImageButton f1850g0;
    public Button h0;

    /* renamed from: i0, reason: collision with root package name */
    public Button f1851i0;

    /* renamed from: j0, reason: collision with root package name */
    public double f1852j0;

    /* renamed from: k0, reason: collision with root package name */
    public app.shamel.tv.helper.r f1853k0;

    /* renamed from: l0, reason: collision with root package name */
    public GifImageView f1854l0;

    /* renamed from: m0, reason: collision with root package name */
    public RecyclerView f1855m0;

    /* renamed from: n0, reason: collision with root package name */
    public ArrayList f1856n0;

    /* renamed from: o0, reason: collision with root package name */
    public TextView f1857o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f1858p0;

    /* renamed from: q0, reason: collision with root package name */
    public WordModels f1859q0 = new WordModels();

    /* renamed from: r0, reason: collision with root package name */
    public int f1860r0 = 0;

    /* renamed from: s0, reason: collision with root package name */
    public final SimpleDateFormat f1861s0 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    /* renamed from: t0, reason: collision with root package name */
    public long f1862t0 = 0;

    public final ArrayList P(WordModels wordModels) {
        this.f1858p0.setText(wordModels.getSettings());
        this.h0.setText(wordModels.getPay_with_google_pay() + "(€" + this.f1849f0.getPrice() + ")");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e5.m(wordModels.getAdd_playlist(), 0, R.drawable.image_playlist));
        arrayList.add(new e5.m(wordModels.getParent_control(), 1, R.drawable.ic_lock));
        arrayList.add(new e5.m(wordModels.getChange_playlist(), 2, R.drawable.image_playlist));
        arrayList.add(new e5.m(wordModels.getChange_language(), 3, R.drawable.image_languange));
        arrayList.add(new e5.m(wordModels.getChangeLayout(), 4, R.drawable.ic_widget));
        arrayList.add(new e5.m(wordModels.getHide_live_category(), 5, R.drawable.image_hiding));
        arrayList.add(new e5.m(wordModels.getHide_vod_category(), 6, R.drawable.image_hiding));
        arrayList.add(new e5.m(wordModels.getHide_series_category(), 7, R.drawable.image_hiding));
        arrayList.add(new e5.m(wordModels.getClear_history_channels(), 8, R.drawable.ic_delete));
        arrayList.add(new e5.m(wordModels.getClear_history_movies(), 9, R.drawable.ic_delete));
        arrayList.add(new e5.m(wordModels.getClear_history_series(), 10, R.drawable.ic_delete));
        arrayList.add(new e5.m(wordModels.getLive_sort(), 11, R.drawable.image_sort));
        arrayList.add(new e5.m(wordModels.getLive_stream_format(), 12, R.drawable.icon_live));
        arrayList.add(new e5.m(wordModels.getSelectPlayer(), 13, R.drawable.ic_player));
        arrayList.add(new e5.m(wordModels.getExternal_player(), 14, R.drawable.ic_external_player));
        arrayList.add(new e5.m(wordModels.getAutomatic(), 15, R.drawable.ic_auto));
        arrayList.add(new e5.m(wordModels.getTime_format(), 16, R.drawable.ic_timmer));
        arrayList.add(new e5.m(wordModels.getSubtitle_settings(), 17, R.drawable.image_subtitle));
        arrayList.add(new e5.m(wordModels.getSelect_device_type(), 18, R.drawable.ic_devices));
        arrayList.add(new e5.m(wordModels.getUpdate_now(), 19, R.drawable.ic_update));
        return arrayList;
    }

    public final void Q(int i10) {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i11 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_clear_history");
        if (A != null) {
            android.support.v4.media.d.v(i11, A, false);
            return;
        }
        h5.m mVar = new h5.m();
        mVar.C0 = this;
        mVar.D0 = i10;
        mVar.M(n10, "fragment_clear_history");
    }

    public final void R(int i10) {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i11 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_hide_category");
        if (A != null) {
            android.support.v4.media.d.v(i11, A, false);
            return;
        }
        h5.y yVar = new h5.y();
        yVar.F0 = this;
        yVar.G0 = i10;
        yVar.H0 = new a6.a0(4);
        yVar.M(n10, "fragment_hide_category");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if ((r4.f1860r0 % 4) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (r4.f1850g0.hasFocus() != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
    
        return true;
     */
    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            if (r0 != 0) goto L92
            int r0 = r5.getKeyCode()
            r1 = 0
            r2 = 4
            if (r0 == r2) goto L69
            r3 = 1
            switch(r0) {
                case 19: goto L59;
                case 20: goto L2b;
                case 21: goto L1d;
                case 22: goto L14;
                default: goto L12;
            }
        L12:
            goto L92
        L14:
            android.widget.ImageButton r0 = r4.f1850g0
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L92
            goto L2a
        L1d:
            androidx.recyclerview.widget.RecyclerView r0 = r4.f1855m0
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L92
            int r0 = r4.f1860r0
            int r0 = r0 % r2
            if (r0 != 0) goto L92
        L2a:
            return r3
        L2b:
            android.widget.ImageButton r0 = r4.f1850g0
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L3e
            android.widget.ImageButton r5 = r4.f1850g0
            r5.setFocusable(r1)
            androidx.recyclerview.widget.RecyclerView r5 = r4.f1855m0
            r5.requestFocus()
            return r3
        L3e:
            int r0 = r4.f1860r0
            java.util.ArrayList r1 = r4.f1856n0
            int r1 = r1.size()
            int r1 = r1 - r2
            if (r0 <= r1) goto L92
            android.widget.Button r5 = r4.f1851i0
            r5.setFocusable(r3)
            android.widget.Button r5 = r4.h0
            r5.setFocusable(r3)
            android.widget.Button r5 = r4.h0
            r5.requestFocus()
            return r3
        L59:
            int r0 = r4.f1860r0
            r1 = 3
            if (r0 >= r1) goto L92
            android.widget.ImageButton r5 = r4.f1850g0
            r5.setFocusable(r3)
            android.widget.ImageButton r5 = r4.f1850g0
            r5.requestFocus()
            return r3
        L69:
            pl.droidsonroids.gif.GifImageView r0 = r4.f1854l0
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L7f
            app.shamel.tv.models.WordModels r0 = r4.f1859q0
            java.lang.String r0 = r0.getPlaylist_is_loading()
            android.widget.Toast r0 = android.widget.Toast.makeText(r4, r0, r1)
            r0.show()
            goto L92
        L7f:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = "is_changed"
            java.lang.String r2 = ""
            r0.putExtra(r1, r2)
            r1 = -1
            r4.setResult(r1, r0)
            r4.finish()
        L92:
            boolean r5 = super.dispatchKeyEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.SettingActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btn_back) {
            return;
        }
        if (this.f1854l0.getVisibility() == 0) {
            Toast.makeText(this, this.f1859q0.getPlaylist_is_loading(), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("is_changed", _UrlKt.FRAGMENT_ENCODE_SET);
        setResult(-1, intent);
        finish();
    }

    @Override // e5.k, f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting);
        k5.j.a(this);
        app.shamel.tv.helper.r rVar = new app.shamel.tv.helper.r(this);
        this.f1853k0 = rVar;
        this.f1849f0 = rVar.b();
        this.f1859q0 = app.shamel.tv.helper.a.k(this);
        this.f1850g0 = (ImageButton) findViewById(R.id.btn_back);
        this.f1858p0 = (TextView) findViewById(R.id.txt_setting);
        this.f1857o0 = (TextView) findViewById(R.id.txt_mac_address);
        this.h0 = (Button) findViewById(R.id.btn_pay);
        this.f1851i0 = (Button) findViewById(R.id.btn_tv_pay);
        this.f1854l0 = (GifImageView) findViewById(R.id.progress_bar);
        this.h0.setOnClickListener(this);
        this.f1851i0.setOnClickListener(this);
        this.f1850g0.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_setting);
        this.f1855m0 = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(4));
        this.f1855m0.setHasFixedSize(true);
        TextView textView = this.f1857o0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f1859q0.getMac_address());
        sb2.append(": ");
        sb2.append(this.f1853k0.r());
        sb2.append("\n");
        sb2.append(this.f1859q0.getDevice_key());
        sb2.append(": ");
        app.shamel.tv.helper.r rVar2 = this.f1853k0;
        rVar2.getClass();
        String str = _UrlKt.FRAGMENT_ENCODE_SET;
        try {
            str = rVar2.f2098b.getString("device_key", _UrlKt.FRAGMENT_ENCODE_SET);
        } catch (Exception unused) {
        }
        sb2.append(str);
        textView.setText(sb2.toString());
        this.f1856n0 = P(this.f1859q0);
        this.f1852j0 = Double.parseDouble(LTVApp.f2089x);
        double parseDouble = Double.parseDouble(this.f1849f0.getApp_version());
        this.f1848e0 = parseDouble;
        ArrayList arrayList = this.f1856n0;
        int i10 = parseDouble > this.f1852j0 ? 19 : -1;
        b bVar = new b(this, 4);
        d5.y yVar = new d5.y(2);
        yVar.g = arrayList;
        yVar.f4222e = bVar;
        yVar.f4223f = i10;
        this.f1846c0 = yVar;
        this.f1855m0.setAdapter(yVar);
        this.f1855m0.e0(0);
        this.f1850g0.setFocusable(false);
        this.h0.setFocusable(false);
        this.f1851i0.setFocusable(false);
        this.f1851i0.setVisibility(8);
        this.h0.setVisibility(8);
        try {
            this.f1862t0 = this.f1861s0.parse(this.f1849f0.getExpiredDate()).getTime();
        } catch (Exception unused2) {
            this.f1862t0 = 0L;
        }
        if (this.f1849f0.getIs_trial() == 2 || this.f1862t0 - new Date().getTime() > 604800000) {
            this.h0.setVisibility(8);
        }
    }

    @Override // e5.k
    public final void w(boolean z10) {
        if (z10) {
            this.f1854l0.setVisibility(8);
            SharedPreferences.Editor edit = this.f1853k0.f2098b.edit();
            edit.putInt("playlist_position", 0);
            edit.apply();
            startActivity(new Intent(this, (Class<?>) HomeActivity.class));
            finish();
            return;
        }
        this.f1854l0.setVisibility(8);
        androidx.fragment.app.j0 n10 = n();
        n10.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n10);
        androidx.fragment.app.s A = n10.A("fragment_no_connection");
        if (A != null) {
            android.support.v4.media.d.v(aVar, A, false);
            return;
        }
        String playlist_is_not_working = this.f1859q0.getPlaylist_is_not_working();
        h5.k0 k0Var = new h5.k0();
        k0Var.f5618y0 = this;
        k0Var.D0 = playlist_is_not_working;
        k0Var.f5619z0 = new z0(this);
        k0Var.M(n10, "fragment_no_connection");
    }
}
