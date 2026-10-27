package app.shamel.tv.activities.mobile;

import a6.q;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.a;
import androidx.fragment.app.j0;
import androidx.fragment.app.s;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerView;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.mediarouter.app.b;
import app.shamel.tv.activities.m0;
import app.shamel.tv.helper.r;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.WordModels;
import c2.y0;
import c5.d;
import c5.i;
import c5.k;
import c5.l;
import f.j;
import f2.v;
import h5.i0;
import h5.u;
import i1.c0;
import i1.d0;
import i1.w;
import i1.x;
import i1.y;
import i1.z0;
import i7.h;
import java.util.Collections;
import java.util.List;
import o1.g;
import o9.e0;
import o9.g0;
import o9.w0;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.RealWebSocket;
import org.chromium.net.R;
import p7.n;
import s1.a0;
import u3.c;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MovieMobilePlayer extends j implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public static final /* synthetic */ int M0 = 0;
    public d D0;
    public AspectRatioFrameLayout F0;
    public TextView G0;
    public l H0;
    public int I0;
    public y0 J0;
    public final k K0;
    public final l L0;
    public AudioManager M;
    public SeekBar N;
    public ImageButton O;
    public ImageButton P;
    public ImageButton Q;
    public ImageButton R;
    public ImageButton S;
    public ImageButton T;
    public ImageButton U;
    public MediaRouteButton V;
    public ImageButton W;
    public ImageButton X;
    public MovieModel Y;
    public g Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f1982a0;

    /* renamed from: b0, reason: collision with root package name */
    public u f1983b0;

    /* renamed from: c0, reason: collision with root package name */
    public l f1984c0;

    /* renamed from: d0, reason: collision with root package name */
    public i0 f1985d0;

    /* renamed from: e0, reason: collision with root package name */
    public ConstraintLayout f1986e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f1987f0;

    /* renamed from: g0, reason: collision with root package name */
    public a0 f1988g0;
    public PlayerView h0;

    /* renamed from: i0, reason: collision with root package name */
    public r f1989i0;

    /* renamed from: j0, reason: collision with root package name */
    public u f1990j0;

    /* renamed from: k0, reason: collision with root package name */
    public SeekBar f1991k0;

    /* renamed from: l0, reason: collision with root package name */
    public z0 f1992l0;

    /* renamed from: m0, reason: collision with root package name */
    public f2.r f1993m0;

    /* renamed from: n0, reason: collision with root package name */
    public TextView f1994n0;

    /* renamed from: o0, reason: collision with root package name */
    public TextView f1995o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f1996p0;

    /* renamed from: q0, reason: collision with root package name */
    public View f1997q0;

    /* renamed from: r0, reason: collision with root package name */
    public SeekBar f1998r0;

    /* renamed from: s0, reason: collision with root package name */
    public String f1999s0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: t0, reason: collision with root package name */
    public String f2000t0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: u0, reason: collision with root package name */
    public String f2001u0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: v0, reason: collision with root package name */
    public String f2002v0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: w0, reason: collision with root package name */
    public String f2003w0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: x0, reason: collision with root package name */
    public long f2004x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    public int f2005y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    public final Handler f2006z0 = new Handler(Looper.getMainLooper());
    public String A0 = "1920x1080";
    public boolean B0 = false;
    public WordModels C0 = new WordModels();
    public int E0 = 1;

    public MovieMobilePlayer() {
        int i10 = 0;
        this.K0 = new k(this, i10);
        this.L0 = new l(this, i10);
    }

    public static void u(MovieMobilePlayer movieMobilePlayer) {
        long j10;
        try {
            if (movieMobilePlayer.J0 == null) {
                return;
            }
            a0 a0Var = movieMobilePlayer.f1988g0;
            if (a0Var != null) {
                j10 = a0Var.y();
                movieMobilePlayer.f1988g0.U(false);
            } else {
                j10 = 0;
            }
            long j11 = j10;
            y0 y0Var = movieMobilePlayer.J0;
            String str = movieMobilePlayer.f1999s0;
            String str2 = movieMobilePlayer.f2000t0;
            if (str2 == null) {
                str2 = "Unknown Title";
            }
            String str3 = str2;
            MovieModel movieModel = movieMobilePlayer.Y;
            y0Var.a(str, str3, movieModel != null ? movieModel.getStream_icon() : null, j11);
        } catch (Exception e7) {
            Log.e("MovieMobilePlayer", "Error starting cast: " + e7.getMessage());
            Toast.makeText(movieMobilePlayer, "تعذّر الإرسال إلى الكاست", 0).show();
        }
    }

    public final void A(long j10) {
        long y8;
        y0 y0Var = this.J0;
        if (y0Var == null || !y0Var.g()) {
            a0 a0Var = this.f1988g0;
            y8 = a0Var != null ? a0Var.y() : 0L;
        } else {
            y8 = this.J0.b();
        }
        long v10 = v();
        if (v10 <= 0) {
            return;
        }
        long j11 = y8 + j10;
        long j12 = j11 >= 0 ? j11 : 0L;
        if (j12 > v10) {
            j12 = v10 - 1000;
        }
        y0 y0Var2 = this.J0;
        if (y0Var2 == null || !y0Var2.g()) {
            a0 a0Var2 = this.f1988g0;
            if (a0Var2 != null) {
                a0Var2.l(5, j12);
            }
        } else {
            this.J0.h(j12);
        }
        Handler handler = this.f2006z0;
        l lVar = this.L0;
        handler.removeCallbacks(lVar);
        handler.post(lVar);
    }

    public final void B() {
        j0 n10 = n();
        a i10 = android.support.v4.media.d.i(n10, n10);
        s A = n10.A("fragment_exit");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return;
        }
        u N = u.N(this.C0.getStop_playback(), this.C0.getPlayback_description(), this.C0.getStr_yes(), this.C0.getNo());
        this.f1983b0 = N;
        N.B0 = new k(this, 1);
        N.M(n10, "fragment_exit");
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        B();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f2.r rVar;
        int id = view.getId();
        boolean z10 = true;
        boolean z11 = false;
        if (id == R.id.btn_audio) {
            f2.r rVar2 = this.f1993m0;
            if (rVar2 == null) {
                return;
            }
            v vVar = rVar2.f4956c;
            if (vVar == null) {
                Toast.makeText(getApplicationContext(), this.C0.getNo_audio(), 1).show();
                return;
            }
            String audio_track = this.C0.getAudio_track();
            int i10 = vVar.f4949b[1];
            if (i10 == 2 || (i10 == 1 && vVar.a() == 0)) {
                z11 = true;
            }
            n nVar = new n(this, audio_track, this.f1988g0, 1);
            nVar.f10070a = z11;
            nVar.b().show();
            return;
        }
        if (id == R.id.btn_back) {
            B();
            return;
        }
        if (id == R.id.btn_fav) {
            String lowerCase = this.f2001u0.toLowerCase();
            if (lowerCase.contains("xxx") || lowerCase.contains("porn") || lowerCase.contains("adult")) {
                Toast.makeText(this, this.C0.getCant_add_this_movie(), 0).show();
                return;
            }
            if (this.B0) {
                this.B0 = false;
                this.Q.setColorFilter(getColor(R.color.gray));
                a6.n.K().i(this.Y.getName(), false, new i(this, 3));
                return;
            } else {
                this.B0 = true;
                this.Q.setColorFilter(getColor(R.color.yellow));
                a6.n.K().i(this.Y.getName(), true, new i(this, 2));
                return;
            }
        }
        Handler handler = this.f2006z0;
        if (id == R.id.btn_forward) {
            handler.removeCallbacks(this.f1984c0);
            w();
            A(10000L);
            return;
        }
        if (id == R.id.btn_info) {
            i0 i0Var = this.f1985d0;
            if (i0Var != null && i0Var.o()) {
                this.f1985d0.J(false, false);
                return;
            }
            String str = this.f2000t0;
            String str2 = this.f1982a0;
            String stream_icon = this.Y.getStream_icon();
            String str3 = this.A0;
            j0 n10 = n();
            a i11 = android.support.v4.media.d.i(n10, n10);
            s A = n10.A("fragment_info");
            if (A != null) {
                android.support.v4.media.d.v(i11, A, false);
                return;
            }
            i0 i0Var2 = new i0();
            i0Var2.B0 = str;
            i0Var2.f5611x0 = str2;
            i0Var2.A0 = stream_icon;
            i0Var2.C0 = str3;
            this.f1985d0 = i0Var2;
            i0Var2.M(n10, "fragment_info");
            return;
        }
        if (id == R.id.btn_play) {
            y0 y0Var = this.J0;
            if (y0Var == null || !y0Var.g()) {
                a0 a0Var = this.f1988g0;
                if (a0Var != null) {
                    if (a0Var.E()) {
                        this.f1988g0.U(false);
                        this.T.setImageResource(R.drawable.ic_play);
                        return;
                    } else {
                        this.f1988g0.U(true);
                        this.T.setImageResource(R.drawable.ic_pause);
                        return;
                    }
                }
                return;
            }
            h e7 = this.J0.e();
            if (e7 != null && e7.e() == 2) {
                h e8 = this.J0.e();
                if (e8 != null) {
                    e8.o();
                }
                this.T.setImageResource(R.drawable.ic_play);
                return;
            }
            h e10 = this.J0.e();
            if (e10 != null) {
                e10.p();
            }
            this.T.setImageResource(R.drawable.ic_pause);
            return;
        }
        if (id == R.id.btn_resolution) {
            int i12 = (this.E0 + 1) % 4;
            this.E0 = i12;
            if (i12 == 0) {
                this.h0.setResizeMode(3);
                AspectRatioFrameLayout aspectRatioFrameLayout = this.F0;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(0.0f);
                }
                this.G0.setText("Fill");
            } else if (i12 == 1) {
                this.h0.setResizeMode(0);
                AspectRatioFrameLayout aspectRatioFrameLayout2 = this.F0;
                if (aspectRatioFrameLayout2 != null) {
                    aspectRatioFrameLayout2.setAspectRatio(0.0f);
                }
                this.G0.setText("Fit");
            } else if (i12 == 2) {
                this.h0.setResizeMode(0);
                AspectRatioFrameLayout aspectRatioFrameLayout3 = this.F0;
                if (aspectRatioFrameLayout3 != null) {
                    aspectRatioFrameLayout3.setAspectRatio(1.7777778f);
                }
                this.G0.setText("16:9");
            } else if (i12 == 3) {
                this.h0.setResizeMode(0);
                AspectRatioFrameLayout aspectRatioFrameLayout4 = this.F0;
                if (aspectRatioFrameLayout4 != null) {
                    aspectRatioFrameLayout4.setAspectRatio(1.3333334f);
                }
                this.G0.setText("4:3");
            }
            this.G0.setVisibility(0);
            handler.removeCallbacks(this.H0);
            this.I0 = 2;
            l lVar = new l(this, 2);
            this.H0 = lVar;
            lVar.run();
            return;
        }
        if (id == R.id.btn_rewind) {
            handler.removeCallbacks(this.f1984c0);
            w();
            A(-10000L);
            return;
        }
        if (id != R.id.btn_sub) {
            if (id == R.id.view_click) {
                y0 y0Var2 = this.J0;
                if (y0Var2 != null && y0Var2.g()) {
                    this.f1986e0.setVisibility(0);
                    return;
                } else {
                    if (this.f1986e0.getVisibility() == 0) {
                        handler.removeCallbacks(this.f1984c0);
                        this.f1986e0.setVisibility(8);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        y0 y0Var3 = this.J0;
        if ((y0Var3 == null || !y0Var3.g()) && (rVar = this.f1993m0) != null) {
            v vVar2 = rVar.f4956c;
            if (vVar2 == null) {
                Toast.makeText(getApplicationContext(), this.C0.getNo_subtitle(), 1).show();
                return;
            }
            String subtitle = this.C0.getSubtitle();
            int i13 = vVar2.f4949b[3];
            if (i13 != 2 && (i13 != 3 || vVar2.a() != 3)) {
                z10 = false;
            }
            n nVar2 = new n(this, subtitle, this.f1988g0, 3);
            nVar2.f10070a = z10;
            nVar2.b().show();
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.activity_movie_mobile_player);
        j().a(this, new androidx.fragment.app.a0(this, 5));
        this.J0 = new y0(this);
        this.D0 = new d(this, new Handler(Looper.getMainLooper()), 2);
        k5.j.a(this);
        this.f1989i0 = new r(this);
        this.C0 = app.shamel.tv.helper.a.k(this);
        PlayerView playerView = (PlayerView) findViewById(R.id.player_view);
        this.h0 = playerView;
        this.F0 = (AspectRatioFrameLayout) playerView.findViewById(R.id.exo_content_frame);
        if (this.h0.getSubtitleView() != null) {
            this.h0.getSubtitleView().setApplyEmbeddedStyles(false);
            c cVar = new c(Color.parseColor(this.f1989i0.D()), Color.parseColor(this.f1989i0.C()), 0, 0, 0, null);
            this.h0.getSubtitleView().a(2, this.f1989i0.F());
            this.h0.getSubtitleView().setStyle(cVar);
        }
        this.f1997q0 = findViewById(R.id.view_click);
        this.f1986e0 = (ConstraintLayout) findViewById(R.id.ly_control);
        this.P = (ImageButton) findViewById(R.id.btn_back);
        this.W = (ImageButton) findViewById(R.id.btn_rewind);
        this.T = (ImageButton) findViewById(R.id.btn_play);
        this.R = (ImageButton) findViewById(R.id.btn_forward);
        this.S = (ImageButton) findViewById(R.id.btn_info);
        this.X = (ImageButton) findViewById(R.id.btn_sub);
        this.O = (ImageButton) findViewById(R.id.btn_audio);
        this.U = (ImageButton) findViewById(R.id.btn_resolution);
        this.V = (MediaRouteButton) findViewById(R.id.btn_cast);
        this.Q = (ImageButton) findViewById(R.id.btn_fav);
        this.f1996p0 = (TextView) findViewById(R.id.txt_start_time);
        this.f1994n0 = (TextView) findViewById(R.id.txt_end_time);
        this.f1995o0 = (TextView) findViewById(R.id.txt_name);
        this.G0 = (TextView) findViewById(R.id.txt_resolution);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.f1991k0 = seekBar;
        if (seekBar != null) {
            seekBar.setMax(1000);
            this.f1991k0.setOnSeekBarChangeListener(new c5.j(this));
        }
        this.W.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.f1997q0.setOnClickListener(this);
        this.U.setOnClickListener(this);
        if (this.h0.getVideoSurfaceView() != null) {
            this.h0.getVideoSurfaceView().setOnClickListener(new b(1, this));
        }
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.volume_seekbar);
        this.f1998r0 = seekBar2;
        seekBar2.setOnSeekBarChangeListener(this);
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        this.M = audioManager;
        if (audioManager != null) {
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = this.M.getStreamVolume(3);
            this.f1998r0.setMax(streamMaxVolume);
            this.f1998r0.setProgress(streamVolume);
        }
        SeekBar seekBar3 = (SeekBar) findViewById(R.id.bright_seekbar);
        this.N = seekBar3;
        seekBar3.setMax(255);
        try {
            this.N.setProgress(Settings.System.getInt(getContentResolver(), "screen_brightness", 0));
        } catch (Exception unused) {
            this.N.setProgress(128);
        }
        this.N.setOnSeekBarChangeListener(this);
        if (Build.VERSION.SDK_INT >= 26) {
            q.o();
        }
        h7.a.a(this, this.V);
        this.f1982a0 = getIntent().getStringExtra("description");
        this.f2000t0 = getIntent().getStringExtra("name");
        this.f2001u0 = getIntent().getStringExtra("category_name");
        this.f2003w0 = getIntent().getStringExtra("stream_id");
        this.f2002v0 = getIntent().getStringExtra("tmdb_id");
        if (this.f1989i0.g() || (str = this.f2003w0) == null || str.isEmpty()) {
            this.Y = a6.n.K().z(this.f2000t0);
        } else {
            this.Y = a6.n.K().y(this.f2003w0);
        }
        MovieModel movieModel = this.Y;
        if (movieModel == null) {
            Toast.makeText(this, "Movie not found", 0).show();
            finish();
            return;
        }
        this.B0 = movieModel.isIs_favorite();
        this.f1995o0.setText(this.f2000t0);
        this.Q.setColorFilter(getColor(this.B0 ? R.color.yellow : R.color.gray));
        this.Z = k5.a.i(this, this.f1989i0.k());
        i1.y0 y0Var = new i1.y0();
        y0Var.j(3, !this.f1989i0.E());
        this.f1992l0 = new z0(y0Var);
        if (this.f1989i0.g()) {
            this.f1999s0 = this.Y.getUrl();
        } else {
            this.f1999s0 = app.shamel.tv.helper.a.h(this.f1989i0.B(), this.f1989i0.I(), this.f1989i0.v(), this.Y.getStream_id(), this.Y.getExtension());
        }
        long time = this.Y.getTime();
        this.f2004x0 = time;
        if (time == 0) {
            this.f1986e0.setVisibility(0);
            x(0L, this.f1999s0);
            w();
            return;
        }
        String str2 = this.f1999s0;
        y0 y0Var2 = this.J0;
        if (y0Var2 == null || !y0Var2.g()) {
            j0 n10 = n();
            a i10 = android.support.v4.media.d.i(n10, n10);
            s A = n10.A("fragment_resume");
            if (A != null) {
                android.support.v4.media.d.v(i10, A, false);
                return;
            }
            u N = u.N(this.C0.getResume(), this.C0.getResume_plyaback_from_ast_position(), this.C0.getStr_yes(), this.C0.getNo());
            this.f1990j0 = N;
            N.B0 = new x4.l(this, str2);
            N.M(n10, "fragment_resume");
        }
    }

    @Override // f.j, android.app.Activity
    public final void onPause() {
        h7.i iVar;
        k kVar;
        super.onPause();
        y0 y0Var = this.J0;
        if (y0Var != null && (iVar = (h7.i) y0Var.f2775r) != null && (kVar = this.K0) != null) {
            iVar.e(kVar);
        }
        if (this.D0 != null) {
            getContentResolver().unregisterContentObserver(this.D0);
        }
        y0 y0Var2 = this.J0;
        if (y0Var2 != null && y0Var2.g()) {
            PlayerView playerView = this.h0;
            if (playerView != null) {
                playerView.g();
            }
            a0 a0Var = this.f1988g0;
            if (a0Var != null) {
                a0Var.U(false);
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT <= 23) {
            PlayerView playerView2 = this.h0;
            if (playerView2 != null) {
                playerView2.g();
            }
            y();
            return;
        }
        PlayerView playerView3 = this.h0;
        if (playerView3 != null) {
            playerView3.g();
        }
        a0 a0Var2 = this.f1988g0;
        if (a0Var2 != null) {
            a0Var2.U(false);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        int id = seekBar.getId();
        if (z10) {
            if (id != R.id.volume_seekbar) {
                if (id == R.id.bright_seekbar) {
                    Window window = getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.screenBrightness = i10 / 255.0f;
                    window.setAttributes(attributes);
                    return;
                }
                return;
            }
            AudioManager audioManager = this.M;
            if (audioManager != null) {
                audioManager.setStreamVolume(3, i10, 0);
                int streamMaxVolume = this.M.getStreamMaxVolume(3);
                a0 a0Var = this.f1988g0;
                if (a0Var == null || streamMaxVolume <= 0) {
                    return;
                }
                a0Var.Y(i10 / streamMaxVolume);
            }
        }
    }

    @Override // f.j, android.app.Activity
    public final void onResume() {
        String str;
        k kVar;
        super.onResume();
        y0 y0Var = this.J0;
        if (y0Var != null) {
            if (((h7.i) y0Var.f2775r) == null) {
                y0Var.f();
            }
            h7.i iVar = (h7.i) y0Var.f2775r;
            if (iVar != null && (kVar = this.K0) != null) {
                iVar.a(kVar);
            }
        }
        AudioManager audioManager = this.M;
        if (audioManager != null && this.f1998r0 != null) {
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = this.M.getStreamVolume(3);
            this.f1998r0.setMax(streamMaxVolume);
            this.f1998r0.setProgress(streamVolume);
        }
        getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.D0);
        y0 y0Var2 = this.J0;
        if (y0Var2 != null && y0Var2.g()) {
            Handler handler = this.f2006z0;
            l lVar = this.L0;
            handler.removeCallbacks(lVar);
            handler.removeCallbacks(lVar);
            handler.post(lVar);
            return;
        }
        if (this.f1988g0 == null && (str = this.f1999s0) != null && !str.isEmpty()) {
            x(this.f2004x0, this.f1999s0);
        } else if (this.f1988g0 != null) {
            PlayerView playerView = this.h0;
            if (playerView != null) {
                playerView.h();
            }
            this.f1988g0.U(true);
        }
    }

    @Override // f.j, android.app.Activity
    public final void onStop() {
        super.onStop();
        y0 y0Var = this.J0;
        if (y0Var == null || !y0Var.g()) {
            if (Build.VERSION.SDK_INT > 23) {
                PlayerView playerView = this.h0;
                if (playerView != null) {
                    playerView.g();
                }
                y();
                return;
            }
            return;
        }
        PlayerView playerView2 = this.h0;
        if (playerView2 != null) {
            playerView2.g();
        }
        a0 a0Var = this.f1988g0;
        if (a0Var != null) {
            a0Var.U(false);
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        y0 y0Var = this.J0;
        if (y0Var == null || !y0Var.g()) {
            y();
        }
    }

    public final long v() {
        y0 y0Var = this.J0;
        if (y0Var != null && y0Var.g()) {
            return this.J0.c();
        }
        a0 a0Var = this.f1988g0;
        if (a0Var != null) {
            return a0Var.D();
        }
        return 0L;
    }

    public final void w() {
        y0 y0Var = this.J0;
        if (y0Var != null && y0Var.g()) {
            this.f2006z0.removeCallbacks(this.f1984c0);
            this.f1986e0.setVisibility(0);
        } else {
            this.f1987f0 = 10;
            l lVar = new l(this, 1);
            this.f1984c0 = lVar;
            lVar.run();
        }
    }

    public final void x(long j10, String str) {
        if (str.trim().isEmpty()) {
            Toast.makeText(this, "Invalid URL", 0).show();
            return;
        }
        a0 a0Var = this.f1988g0;
        if (a0Var != null) {
            a0Var.O();
            this.f1988g0 = null;
        }
        String p10 = l1.a0.p(l1.a0.G(Uri.parse(str)));
        i1.s sVar = new i1.s();
        e0 e0Var = g0.f9617p;
        w0 w0Var = w0.f9686s;
        List list = Collections.EMPTY_LIST;
        w0 w0Var2 = w0.f9686s;
        i1.v vVar = new i1.v();
        y yVar = y.f6072a;
        Uri parse = Uri.parse(str);
        c0 c0Var = new c0();
        String str2 = this.f2000t0;
        if (str2 == null) {
            str2 = "title";
        }
        c0Var.f5817a = str2;
        i1.a0 a0Var2 = new i1.a0(_UrlKt.FRAGMENT_ENCODE_SET, new i1.u(sVar), parse != null ? new x(parse, p10, null, list, w0Var2, -9223372036854775807L) : null, new w(vVar), new d0(c0Var), yVar);
        f2.r rVar = new f2.r(this);
        this.f1993m0 = rVar;
        rVar.b(this.f1992l0);
        s1.n nVar = new s1.n(this);
        x4.l lVar = new x4.l(18);
        lVar.f13562p = k5.a.n(this, this.f1989i0.k());
        c2.r rVar2 = new c2.r(this);
        rVar2.g(this.Z);
        rVar2.h(lVar);
        nVar.b(rVar2);
        nVar.d(this.f1993m0);
        nVar.c(k5.a.e(this, true));
        a0 a10 = nVar.a();
        this.f1988g0 = a10;
        a10.W(this.f1992l0);
        this.f1988g0.f11204m.a(new app.shamel.tv.activities.j(this, 7));
        this.f1988g0.q(new h2.a());
        this.f1988g0.q(new m0(this, 1));
        a0 a0Var3 = this.f1988g0;
        i1.d dVar = i1.d.f5843b;
        a0Var3.S();
        this.f1988g0.U(true);
        this.h0.setPlayer(this.f1988g0);
        this.f1988g0.p(a0Var2);
        this.f1988g0.N();
        this.f1988g0.j();
        if (j10 > 0) {
            this.f1988g0.l(5, j10);
        }
        Handler handler = this.f2006z0;
        l lVar2 = this.L0;
        handler.removeCallbacks(lVar2);
        handler.removeCallbacks(lVar2);
        handler.post(lVar2);
    }

    public final void y() {
        a0 a0Var = this.f1988g0;
        if (a0Var == null) {
            return;
        }
        long y8 = a0Var.y();
        long D = this.f1988g0.D();
        this.f2004x0 = y8;
        z(y8, D);
        this.f1988g0.Z();
        this.f1988g0.O();
        this.f1988g0 = null;
        this.h0.setPlayer(null);
    }

    public final void z(long j10, long j11) {
        if (this.f2000t0 == null) {
            return;
        }
        if (j10 <= 120000 || j10 + RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS >= j11) {
            a6.n.K().d(this.f2000t0, this.f2002v0, false, 0L, 0, new i(this, 0));
        } else {
            a6.n.K().d(this.f2000t0, this.f2002v0, true, j10, j11 > 0 ? (int) ((100 * j10) / j11) : 0, new i(this, 1));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
