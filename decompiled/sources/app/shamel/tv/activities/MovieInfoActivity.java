package app.shamel.tv.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.shamel.tv.activities.mobile.MovieMobilePlayer;
import app.shamel.tv.models.MovieInfoResponse;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveHorizontalGridView;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import j9.w1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MovieInfoActivity extends f.j implements View.OnClickListener {

    /* renamed from: u0, reason: collision with root package name */
    public static final /* synthetic */ int f1734u0 = 0;
    public d5.k M;
    public ImageButton N;
    public RelativeLayout O;
    public RelativeLayout P;
    public Button Q;
    public RelativeLayout R;
    public LiveHorizontalGridView S;
    public MovieModel T;
    public ImageView U;
    public ConstraintLayout V;
    public MovieInfoResponse W;
    public ImageView X;
    public ImageView Y;
    public app.shamel.tv.helper.r Z;

    /* renamed from: a0, reason: collision with root package name */
    public SimpleRatingBar f1735a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f1736b0;

    /* renamed from: c0, reason: collision with root package name */
    public TextView f1737c0;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f1738d0;

    /* renamed from: e0, reason: collision with root package name */
    public TextView f1739e0;

    /* renamed from: f0, reason: collision with root package name */
    public TextView f1740f0;

    /* renamed from: g0, reason: collision with root package name */
    public TextView f1741g0;
    public TextView h0;

    /* renamed from: i0, reason: collision with root package name */
    public TextView f1742i0;

    /* renamed from: j0, reason: collision with root package name */
    public TextView f1743j0;

    /* renamed from: k0, reason: collision with root package name */
    public TextView f1744k0;

    /* renamed from: l0, reason: collision with root package name */
    public TextView f1745l0;

    /* renamed from: m0, reason: collision with root package name */
    public List f1746m0 = new ArrayList();

    /* renamed from: n0, reason: collision with root package name */
    public String f1747n0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: o0, reason: collision with root package name */
    public String f1748o0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: p0, reason: collision with root package name */
    public String f1749p0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: q0, reason: collision with root package name */
    public String f1750q0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: t0, reason: collision with root package name */
    public int f1753t0 = 2;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f1751r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    public WordModels f1752s0 = new WordModels();

    public static void u(MovieInfoActivity movieInfoActivity, List list) {
        movieInfoActivity.f1746m0 = list;
        if (list.size() <= 0) {
            movieInfoActivity.Q.setVisibility(8);
            movieInfoActivity.S.setVisibility(8);
            movieInfoActivity.f1737c0.setVisibility(8);
            d5.k kVar = movieInfoActivity.M;
            kVar.g = new ArrayList();
            kVar.d();
            return;
        }
        if (!app.shamel.tv.helper.a.l(movieInfoActivity)) {
            movieInfoActivity.Q.setVisibility(0);
        }
        movieInfoActivity.S.setVisibility(0);
        movieInfoActivity.f1737c0.setVisibility(0);
        d5.k kVar2 = movieInfoActivity.M;
        kVar2.g = list;
        kVar2.d();
    }

    public static void v(MovieInfoActivity movieInfoActivity) {
        TextView textView = movieInfoActivity.f1738d0;
        long parseLong = Long.parseLong(movieInfoActivity.T.getAdded());
        w1[] w1VarArr = k5.j.f7826a;
        Calendar calendar = Calendar.getInstance(Locale.FRANCE);
        calendar.setTimeInMillis(parseLong * 1000);
        textView.setText(DateFormat.format("yyyy-MM-dd", calendar).toString());
        movieInfoActivity.f1739e0.setText(movieInfoActivity.W.getInfo().getDescription());
        try {
            movieInfoActivity.f1743j0.setText(_UrlKt.FRAGMENT_ENCODE_SET + (Float.parseFloat(movieInfoActivity.T.getRating()) / 2.0f));
            movieInfoActivity.f1735a0.setRating(Float.parseFloat(movieInfoActivity.T.getRating()) / 2.0f);
        } catch (Exception unused) {
            movieInfoActivity.f1743j0.setText("N/A");
            movieInfoActivity.f1735a0.setRating(0.0f);
        }
        movieInfoActivity.f1745l0.setText(k5.j.f(movieInfoActivity.W.getInfo().getReleasedate()));
        movieInfoActivity.f1740f0.setText(movieInfoActivity.W.getInfo().getDuration());
        movieInfoActivity.f1741g0.setText(movieInfoActivity.W.getInfo().getGenre());
        if (!movieInfoActivity.W.getInfo().getCover_big().isEmpty()) {
            com.bumptech.glide.b.e(movieInfoActivity.getApplicationContext()).r(movieInfoActivity.W.getInfo().getCover_big()).E(movieInfoActivity.X);
        }
        int i10 = 0;
        if (movieInfoActivity.W.getInfo().getYoutube_trailer().isEmpty()) {
            movieInfoActivity.R.setVisibility(8);
            movieInfoActivity.O.setNextFocusLeftId(R.id.btn_play);
            movieInfoActivity.P.setNextFocusRightId(R.id.btn_fav);
        } else {
            movieInfoActivity.R.setVisibility(0);
        }
        if (movieInfoActivity.W.getInfo().getTmdb_id().isEmpty()) {
            return;
        }
        movieInfoActivity.f1747n0 = movieInfoActivity.W.getInfo().getTmdb_id();
        j5.f.a(e5.l.f4612h).getCastModels(movieInfoActivity.f1747n0 + "/credits?api_key=d96abf17668601f56b3d7b8336a61933").enqueue(new i0(movieInfoActivity, i10));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r0 == 3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
    
        if (r0 == 3) goto L41;
     */
    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            if (r0 != 0) goto Ld2
            int r0 = r7.getKeyCode()
            r1 = 2
            r2 = 1
            r3 = 3
            r4 = 0
            switch(r0) {
                case 19: goto L9a;
                case 20: goto L59;
                case 21: goto L34;
                case 22: goto L13;
                default: goto L11;
            }
        L11:
            goto Ld2
        L13:
            int[] r0 = app.shamel.tv.activities.j0.f1901a
            int r5 = r6.f1753t0
            int r5 = s.e.b(r5)
            r0 = r0[r5]
            if (r0 != r3) goto Ld2
            android.widget.ImageButton r0 = r6.N
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto Ld2
            r6.f1753t0 = r1
            android.widget.ImageButton r7 = r6.N
            r7.setFocusable(r4)
            android.widget.RelativeLayout r7 = r6.P
            r7.requestFocus()
            return r2
        L34:
            int[] r0 = app.shamel.tv.activities.j0.f1901a
            int r1 = r6.f1753t0
            int r1 = s.e.b(r1)
            r0 = r0[r1]
            if (r0 == r2) goto L44
            if (r0 != r3) goto Ld2
            goto Ld1
        L44:
            android.widget.RelativeLayout r0 = r6.P
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto Ld2
            r6.f1753t0 = r2
            android.widget.ImageButton r7 = r6.N
            r7.setFocusable(r2)
            android.widget.ImageButton r7 = r6.N
            r7.requestFocus()
            return r2
        L59:
            int[] r7 = app.shamel.tv.activities.j0.f1901a
            int r0 = r6.f1753t0
            int r0 = s.e.b(r0)
            r7 = r7[r0]
            if (r7 == r2) goto L76
            if (r7 == r1) goto Ld1
            if (r7 != r3) goto Ld1
            r6.f1753t0 = r1
            android.widget.ImageButton r7 = r6.N
            r7.setFocusable(r4)
            android.widget.RelativeLayout r7 = r6.P
            r7.requestFocus()
            return r2
        L76:
            java.util.List r7 = r6.f1746m0
            if (r7 == 0) goto Ld1
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto Ld1
            r6.f1753t0 = r3
            android.widget.RelativeLayout r7 = r6.P
            r7.setFocusable(r4)
            android.widget.RelativeLayout r7 = r6.O
            r7.setFocusable(r4)
            android.widget.RelativeLayout r7 = r6.R
            r7.setFocusable(r4)
            r6.w()
            app.shamel.tv.view.LiveHorizontalGridView r7 = r6.S
            r7.requestFocus()
            return r2
        L9a:
            int[] r0 = app.shamel.tv.activities.j0.f1901a
            int r4 = r6.f1753t0
            int r4 = s.e.b(r4)
            r0 = r0[r4]
            if (r0 != r2) goto Lb3
            r6.f1753t0 = r2
            android.widget.ImageButton r7 = r6.N
            r7.setFocusable(r2)
            android.widget.ImageButton r7 = r6.N
            r7.requestFocus()
            return r2
        Lb3:
            if (r0 != r1) goto Lcf
            r6.f1753t0 = r1
            android.widget.RelativeLayout r7 = r6.P
            r7.setFocusable(r2)
            android.widget.RelativeLayout r7 = r6.O
            r7.setFocusable(r2)
            android.widget.RelativeLayout r7 = r6.R
            r7.setFocusable(r2)
            android.widget.RelativeLayout r7 = r6.P
            r7.requestFocus()
            r6.w()
            return r2
        Lcf:
            if (r0 != r3) goto Ld2
        Ld1:
            return r2
        Ld2:
            boolean r7 = super.dispatchKeyEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.MovieInfoActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back || id == R.id.txt_home) {
            finish();
            return;
        }
        if (id == R.id.btn_fav) {
            String str = this.f1748o0;
            if (str.contains("xxx") || str.contains("porn") || str.contains("adult")) {
                Toast.makeText(this, this.f1752s0.getCant_add_this_movie(), 0).show();
                return;
            }
            if (this.f1751r0) {
                this.f1751r0 = false;
                this.U.setImageResource(R.drawable.ic_star);
                this.U.setColorFilter(getColor(R.color.white));
                a6.n.K().i(this.T.getName(), false, new i0(this, 3));
                return;
            }
            this.f1751r0 = true;
            this.U.setImageResource(R.drawable.ic_star_selected);
            this.U.setColorFilter(getColor(R.color.yellow));
            a6.n.K().i(this.T.getName(), true, new i0(this, 2));
            return;
        }
        if (id == R.id.btn_play) {
            int f10 = this.Z.f();
            if (this.Z.g()) {
                this.f1750q0 = this.T.getUrl();
            } else {
                this.f1750q0 = app.shamel.tv.helper.a.h(this.Z.B(), this.Z.I(), this.Z.v(), this.T.getStream_id(), this.T.getExtension());
            }
            if (f10 == 0) {
                Intent intent = app.shamel.tv.helper.a.l(this) ? new Intent(this, (Class<?>) MoviePlayerActivity.class) : new Intent(this, (Class<?>) MovieMobilePlayer.class);
                intent.putExtra("name", this.T.getName());
                intent.putExtra("stream_id", this.T.getStream_id());
                intent.putExtra("description", this.f1739e0.getText().toString());
                intent.putExtra("category_name", this.f1748o0);
                intent.putExtra("tmdb_id", this.f1747n0);
                startActivity(intent);
                return;
            }
            if (f10 == 1) {
                if (k5.j.l(this) == null) {
                    y(1);
                    return;
                }
                String str2 = this.f1750q0;
                this.T.getName();
                try {
                    Uri parse = Uri.parse(str2);
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setPackage("org.videolan.vlc");
                    intent2.setDataAndTypeAndNormalize(parse, "video/*");
                    intent2.setFlags(268435456);
                    startActivity(intent2);
                    return;
                } catch (Exception e7) {
                    Log.e("MovieInfoActivity", "externalvlcplayer", e7);
                    return;
                }
            }
            if (f10 == 2) {
                x4.e j10 = k5.j.j(this);
                if (j10 == null) {
                    y(2);
                    return;
                }
                String str3 = (String) j10.f13543q;
                String str4 = (String) j10.f13542p;
                try {
                    Uri parse2 = Uri.parse(this.f1750q0);
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setPackage(str3);
                    intent3.setClassName(str3, str4);
                    intent3.setDataAndType(parse2, "application/x-mpegURL");
                    startActivity(intent3);
                    return;
                } catch (ActivityNotFoundException e8) {
                    Log.e("MovieInfoActivity", "externalMXplayer", e8);
                    return;
                }
            }
            return;
        }
        if (id != R.id.btn_show_cast) {
            if (id == R.id.btn_trailer) {
                MovieInfoResponse movieInfoResponse = this.W;
                if (movieInfoResponse == null) {
                    Toast.makeText(this, this.f1752s0.getNo_trailer(), 0).show();
                    return;
                }
                String youtube_trailer = movieInfoResponse.getInfo().getYoutube_trailer();
                if (youtube_trailer == null || youtube_trailer.isEmpty()) {
                    Toast.makeText(this, this.f1752s0.getNo_trailer(), 0).show();
                    return;
                }
                if (app.shamel.tv.helper.a.l(this)) {
                    androidx.emoji2.text.s m10 = k5.j.m(this);
                    Intent intent4 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=".concat(youtube_trailer)));
                    intent4.setPackage(m10.f595p);
                    startActivity(intent4);
                    return;
                }
                try {
                    Intent intent5 = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:".concat(youtube_trailer)));
                    intent5.addFlags(335544320);
                    startActivity(intent5);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        int i10 = j0.f1901a[s.e.b(this.f1753t0)];
        if (i10 != 1) {
            if (i10 == 2) {
                this.f1753t0 = 2;
                this.P.setFocusable(true);
                this.O.setFocusable(true);
                this.R.setFocusable(true);
                this.P.requestFocus();
                this.Q.setText("Show Cast");
                w();
                return;
            }
            return;
        }
        List list = this.f1746m0;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f1753t0 = 3;
        this.P.setFocusable(false);
        this.O.setFocusable(false);
        this.R.setFocusable(false);
        w();
        this.Q.setText("Hide Cast");
        this.S.requestFocus();
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_movie_info);
        k5.j.a(this);
        this.Z = new app.shamel.tv.helper.r(this);
        this.f1752s0 = app.shamel.tv.helper.a.k(this);
        this.V = (ConstraintLayout) findViewById(R.id.fullContainer);
        this.X = (ImageView) findViewById(R.id.movie_bg);
        this.Y = (ImageView) findViewById(R.id.image_logo);
        this.U = (ImageView) findViewById(R.id.image_fav);
        this.h0 = (TextView) findViewById(R.id.txt_name);
        this.f1745l0 = (TextView) findViewById(R.id.txt_year);
        this.f1743j0 = (TextView) findViewById(R.id.txt_rating);
        this.f1740f0 = (TextView) findViewById(R.id.txt_duration);
        this.f1738d0 = (TextView) findViewById(R.id.txt_added);
        this.f1739e0 = (TextView) findViewById(R.id.txt_description);
        this.f1742i0 = (TextView) findViewById(R.id.txt_play);
        this.f1744k0 = (TextView) findViewById(R.id.txt_trailer);
        this.P = (RelativeLayout) findViewById(R.id.btn_play);
        this.O = (RelativeLayout) findViewById(R.id.btn_fav);
        this.R = (RelativeLayout) findViewById(R.id.btn_trailer);
        this.N = (ImageButton) findViewById(R.id.btn_back);
        this.Q = (Button) findViewById(R.id.btn_show_cast);
        this.f1736b0 = (TextView) findViewById(R.id.str_added);
        this.Q.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.f1735a0 = (SimpleRatingBar) findViewById(R.id.rating_bar);
        this.f1741g0 = (TextView) findViewById(R.id.txt_genre);
        this.f1737c0 = (TextView) findViewById(R.id.str_cast);
        this.S = (LiveHorizontalGridView) findViewById(R.id.cast_list);
        ArrayList arrayList = new ArrayList();
        f fVar = new f(3, this);
        d5.k kVar = new d5.k(0);
        kVar.g = arrayList;
        kVar.f4125f = this;
        kVar.f4124e = fVar;
        this.M = kVar;
        this.S.setAdapter(kVar);
        int i10 = 1;
        if (app.shamel.tv.helper.a.l(this)) {
            this.S.setLoop(false);
            this.S.setPreserveFocusAfterLayout(true);
            this.S.setOnChildViewHolderSelectedListener(new e(12, new View[]{null}));
            this.Q.setVisibility(8);
        } else {
            this.S.setLayoutManager(new LinearLayoutManager(0));
        }
        this.f1736b0.setText(this.f1752s0.getDate_added() + ":");
        this.f1742i0.setText(this.f1752s0.getPlay());
        this.f1744k0.setText(this.f1752s0.getTrailer());
        this.f1737c0.setText(this.f1752s0.getCast());
        this.N.setFocusable(false);
        this.f1749p0 = getIntent().getStringExtra("stream_id");
        if (this.Z.g() || this.f1749p0.isEmpty()) {
            this.T = a6.n.K().z(getIntent().getStringExtra("name"));
        } else {
            this.T = a6.n.K().y(this.f1749p0);
        }
        this.f1748o0 = getIntent().getStringExtra("category_name");
        this.f1749p0 = this.T.getStream_id();
        boolean isIs_favorite = this.T.isIs_favorite();
        this.f1751r0 = isIs_favorite;
        if (isIs_favorite) {
            this.U.setImageResource(R.drawable.ic_star_selected);
            this.U.setColorFilter(getColor(R.color.yellow));
        } else {
            this.U.setImageResource(R.drawable.ic_star);
            this.U.setColorFilter(getColor(R.color.white));
        }
        this.h0.setText(this.T.getName());
        try {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).r(this.T.getStream_icon()).g(R.drawable.default_bg)).E(this.Y);
        } catch (Exception unused) {
            ((com.bumptech.glide.m) com.bumptech.glide.b.e(getApplicationContext()).q(Integer.valueOf(R.drawable.default_bg)).g(R.drawable.default_bg)).E(this.Y);
        }
        if (this.Z.g()) {
            x();
        } else {
            j5.f.a(this.Z.B()).get_vod_info(this.Z.I(), this.Z.v(), this.f1749p0).enqueue(new i0(this, i10));
        }
        this.P.requestFocus();
    }

    public final void w() {
        x.m mVar = new x.m();
        mVar.c(this.V);
        int i10 = j0.f1901a[s.e.b(this.f1753t0)];
        if (i10 == 1) {
            mVar.l(R.id.guide_line1, 0.38f);
            mVar.l(R.id.guide_line2, 0.85f);
            mVar.l(R.id.guide_line3, 1.25f);
            mVar.d(R.id.image_logo, 4, R.id.guide_line1, 4);
            mVar.d(R.id.image_logo, 3, R.id.guide_line1, 3);
        } else if (i10 == 2) {
            mVar.l(R.id.guide_line1, 0.0f);
            mVar.l(R.id.guide_line2, 0.6f);
            mVar.l(R.id.guide_line3, 1.0f);
            mVar.d(R.id.image_logo, 3, R.id.btn_view, 4);
            mVar.d(R.id.image_logo, 4, R.id.guide_line2, 4);
            mVar.d(R.id.str_cast, 3, R.id.guide_line2, 3);
        }
        mVar.a(this.V);
    }

    public final void x() {
        this.f1743j0.setText("N/A");
        this.f1741g0.setText("N/A");
        this.f1735a0.setRating(0.0f);
        this.f1745l0.setText("N/A");
        this.f1740f0.setText("N/A");
        this.f1739e0.setText(this.f1752s0.getNo_information());
        this.f1738d0.setText("N/A");
        this.R.setVisibility(8);
        this.P.setNextFocusRightId(R.id.btn_fav);
        this.O.setNextFocusLeftId(R.id.btn_play);
    }

    public final void y(int i10) {
        f.f fVar = new f.f(this);
        fVar.setTitle(this.f1752s0.getInstall_external_player());
        String want_external_player = this.f1752s0.getWant_external_player();
        f.b bVar = fVar.f4778a;
        bVar.f4706f = want_external_player;
        bVar.f4710k = false;
        String ok = this.f1752s0.getOk();
        e0 e0Var = new e0(this, i10, 1);
        bVar.g = ok;
        bVar.f4707h = e0Var;
        String cancel = this.f1752s0.getCancel();
        d0 d0Var = new d0(1);
        bVar.f4708i = cancel;
        bVar.f4709j = d0Var;
        fVar.create().show();
    }
}
