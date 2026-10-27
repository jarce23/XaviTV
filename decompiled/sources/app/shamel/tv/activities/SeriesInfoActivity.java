package app.shamel.tv.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import app.shamel.tv.models.SeriesModel;
import app.shamel.tv.models.WordModels;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import java.util.Calendar;
import java.util.Locale;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SeriesInfoActivity extends f.j implements View.OnClickListener {
    public ImageButton M;
    public RelativeLayout N;
    public RelativeLayout O;
    public RelativeLayout P;
    public SeriesModel Q;
    public ImageView R;
    public ImageView S;
    public app.shamel.tv.helper.r T;
    public SimpleRatingBar U;
    public ImageView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    public TextView f1805a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f1806b0;

    /* renamed from: c0, reason: collision with root package name */
    public TextView f1807c0;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f1808d0;

    /* renamed from: e0, reason: collision with root package name */
    public TextView f1809e0;

    /* renamed from: f0, reason: collision with root package name */
    public TextView f1810f0;

    /* renamed from: g0, reason: collision with root package name */
    public TextView f1811g0;
    public TextView h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f1812i0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f1813j0 = false;

    /* renamed from: k0, reason: collision with root package name */
    public String f1814k0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: l0, reason: collision with root package name */
    public WordModels f1815l0 = new WordModels();

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (this.O.hasFocus() || this.P.hasFocus() || this.N.hasFocus()) {
                        this.M.setFocusable(true);
                        this.M.requestFocus();
                        return true;
                    }
                    break;
                case 20:
                case 22:
                    if (this.M.hasFocus()) {
                        this.M.setFocusable(false);
                        this.O.requestFocus();
                        return true;
                    }
                    break;
                case 21:
                    if (this.O.hasFocus()) {
                        this.M.setFocusable(true);
                        this.M.requestFocus();
                        return true;
                    }
                    break;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
            finish();
            return;
        }
        if (id == R.id.btn_fav) {
            if (this.f1813j0) {
                this.f1813j0 = false;
                this.R.setImageResource(R.drawable.ic_star);
                this.R.setColorFilter(getColor(R.color.white));
                a6.n.K().j(this.Q.getName(), false, new u0(this, 2));
                return;
            }
            this.f1813j0 = true;
            this.R.setImageResource(R.drawable.ic_star_selected);
            this.R.setColorFilter(getColor(R.color.yellow));
            a6.n.K().j(this.Q.getName(), true, new u0(this, 1));
            return;
        }
        if (id == R.id.btn_play) {
            Intent intent = new Intent(this, (Class<?>) SeasonActivity.class);
            intent.putExtra("series_name", this.Q.getName());
            if (!this.T.g()) {
                intent.putExtra("series_id", this.Q.getSeries_id());
            }
            if (!this.f1814k0.isEmpty()) {
                intent.putExtra("image_url", this.f1814k0);
            }
            startActivity(intent);
            return;
        }
        if (id == R.id.btn_trailer) {
            String youtube = this.Q.getYoutube();
            if (youtube == null || youtube.isEmpty()) {
                Toast.makeText(this, this.f1815l0.getNo_trailer(), 0).show();
                return;
            }
            if (app.shamel.tv.helper.a.l(this)) {
                androidx.emoji2.text.s m10 = k5.j.m(this);
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=".concat(youtube)));
                intent2.setPackage(m10.f595p);
                startActivity(intent2);
                return;
            }
            try {
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:".concat(youtube)));
                intent3.addFlags(335544320);
                startActivity(intent3);
            } catch (Exception unused) {
            }
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.activity_series_info);
        k5.j.a(this);
        this.T = new app.shamel.tv.helper.r(this);
        this.f1815l0 = app.shamel.tv.helper.a.k(this);
        this.V = (ImageView) findViewById(R.id.series_bg);
        this.S = (ImageView) findViewById(R.id.image_logo);
        this.R = (ImageView) findViewById(R.id.image_fav);
        this.f1808d0 = (TextView) findViewById(R.id.txt_name);
        this.h0 = (TextView) findViewById(R.id.txt_year);
        this.f1810f0 = (TextView) findViewById(R.id.txt_rating);
        this.f1806b0 = (TextView) findViewById(R.id.txt_duration);
        this.Y = (TextView) findViewById(R.id.txt_added);
        this.f1805a0 = (TextView) findViewById(R.id.txt_description);
        this.f1809e0 = (TextView) findViewById(R.id.txt_play);
        this.f1811g0 = (TextView) findViewById(R.id.txt_trailer);
        this.O = (RelativeLayout) findViewById(R.id.btn_play);
        this.N = (RelativeLayout) findViewById(R.id.btn_fav);
        this.P = (RelativeLayout) findViewById(R.id.btn_trailer);
        this.M = (ImageButton) findViewById(R.id.btn_back);
        this.O.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.U = (SimpleRatingBar) findViewById(R.id.rating_bar);
        this.f1807c0 = (TextView) findViewById(R.id.txt_genre);
        this.X = (TextView) findViewById(R.id.str_cast);
        this.Z = (TextView) findViewById(R.id.txt_cast);
        this.W = (TextView) findViewById(R.id.str_added);
        this.f1809e0.setText(this.f1815l0.getWatch_season());
        this.f1811g0.setText(this.f1815l0.getTrailer());
        this.X.setText(this.f1815l0.getCast());
        this.W.setText(this.f1815l0.getDate_added());
        this.f1812i0 = getIntent().getStringExtra("series_id");
        if (this.T.g() || this.f1812i0.isEmpty()) {
            this.Q = (SeriesModel) android.support.v4.media.d.j((io.realm.u) a6.n.K().f74p, SeriesModel.class, "name", getIntent().getStringExtra("name"));
        } else {
            this.Q = (SeriesModel) android.support.v4.media.d.j((io.realm.u) a6.n.K().f74p, SeriesModel.class, "series_id", this.f1812i0);
        }
        getIntent().getStringExtra("category_id");
        this.f1812i0 = this.Q.getSeries_id();
        if (this.Q.is_favorite()) {
            this.f1813j0 = true;
            this.R.setImageResource(R.drawable.ic_star_selected);
            this.R.setColorFilter(getColor(R.color.yellow));
        } else {
            this.f1813j0 = false;
            this.R.setImageResource(R.drawable.ic_star);
            this.R.setColorFilter(getColor(R.color.white));
        }
        this.f1808d0.setText(this.Q.getName());
        TextView textView = this.h0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(k5.j.f(this.Q.getReleaseDate()));
        if (this.Q.getGenre().isEmpty()) {
            str = _UrlKt.FRAGMENT_ENCODE_SET;
        } else {
            str = ", " + this.Q.getGenre();
        }
        sb2.append(str);
        textView.setText(sb2.toString());
        try {
            TextView textView2 = this.Y;
            long parseLong = Long.parseLong(this.Q.getLast_modified());
            Calendar calendar = Calendar.getInstance(Locale.FRANCE);
            calendar.setTimeInMillis(parseLong * 1000);
            textView2.setText(DateFormat.format("yyyy-MM-dd", calendar).toString());
        } catch (Exception unused) {
            this.Y.setText(this.Q.getLast_modified());
        }
        this.f1806b0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
        try {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).r(this.Q.getStream_icon()).g(R.drawable.default_series)).E(this.S);
        } catch (Exception unused2) {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).q(Integer.valueOf(R.drawable.default_series)).g(R.drawable.default_series)).E(this.S);
        }
        this.f1805a0.setText(this.Q.getPlot());
        this.f1807c0.setText(this.Q.getGenre());
        this.Z.setText(this.Q.getCast());
        try {
            this.f1810f0.setText(String.valueOf(this.Q.getRating() / 2.0f));
            this.U.setRating(this.Q.getRating() / 2.0f);
        } catch (Exception unused3) {
            this.f1810f0.setText("0.0");
            this.U.setRating(0.0f);
        }
        if (!this.T.g()) {
            a.a.p(this).a(new n5.f(this.T.B() + "/player_api.php?action=get_series_info&username=" + this.T.I() + "&password=" + this.T.v() + "&series_id=" + this.f1812i0, new u0(this, 0), new n7.i(7)));
        }
        if (this.Q.getYoutube().isEmpty()) {
            this.P.setVisibility(8);
            this.O.setNextFocusRightId(R.id.btn_fav);
            this.N.setNextFocusLeftId(R.id.btn_play);
        } else {
            this.P.setVisibility(0);
        }
        this.M.setFocusable(false);
        this.O.requestFocus();
    }
}
