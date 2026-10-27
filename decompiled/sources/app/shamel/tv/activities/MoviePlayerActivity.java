package app.shamel.tv.activities;

import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerView;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.SubtitleView;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.RealWebSocket;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MoviePlayerActivity extends f.j implements View.OnClickListener, View.OnFocusChangeListener, SeekBar.OnSeekBarChangeListener {
    public AspectRatioFrameLayout D0;
    public ImageButton M;
    public ImageButton N;
    public ImageButton O;
    public ImageButton P;
    public ImageButton Q;
    public ImageButton R;
    public ImageButton S;
    public ImageButton T;
    public MovieModel U;
    public o1.g V;
    public String W;
    public h5.u X;
    public k0 Y;
    public k0 Z;

    /* renamed from: a0, reason: collision with root package name */
    public ImageView f1754a0;

    /* renamed from: b0, reason: collision with root package name */
    public ImageView f1755b0;

    /* renamed from: c0, reason: collision with root package name */
    public h5.i0 f1756c0;

    /* renamed from: d0, reason: collision with root package name */
    public ConstraintLayout f1757d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f1758e0;

    /* renamed from: f0, reason: collision with root package name */
    public i1.a0 f1759f0;

    /* renamed from: g0, reason: collision with root package name */
    public s1.a0 f1760g0;
    public PlayerView h0;

    /* renamed from: i0, reason: collision with root package name */
    public app.shamel.tv.helper.r f1761i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f1762j0;

    /* renamed from: k0, reason: collision with root package name */
    public h5.u f1763k0;

    /* renamed from: l0, reason: collision with root package name */
    public SeekBar f1764l0;

    /* renamed from: m0, reason: collision with root package name */
    public SubtitleView f1765m0;

    /* renamed from: n0, reason: collision with root package name */
    public i1.z0 f1766n0;

    /* renamed from: o0, reason: collision with root package name */
    public f2.r f1767o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f1768p0;

    /* renamed from: q0, reason: collision with root package name */
    public TextView f1769q0;

    /* renamed from: r0, reason: collision with root package name */
    public TextView f1770r0;

    /* renamed from: s0, reason: collision with root package name */
    public TextView f1771s0;

    /* renamed from: t0, reason: collision with root package name */
    public String f1772t0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: u0, reason: collision with root package name */
    public String f1773u0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: v0, reason: collision with root package name */
    public String f1774v0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: w0, reason: collision with root package name */
    public String f1775w0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: x0, reason: collision with root package name */
    public long f1776x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    public int f1777y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    public final Handler f1778z0 = new Handler(Looper.getMainLooper());
    public String A0 = "1920x1080";
    public WordModels B0 = new WordModels();
    public int C0 = 1;
    public final androidx.activity.j E0 = new androidx.activity.j(8, this);

    public final void A(long j10, long j11) {
        if (j11 <= 0 || j11 == -9223372036854775807L) {
            this.f1771s0.setText(k5.j.n(j10));
            return;
        }
        this.f1771s0.setText(k5.j.n(j10));
        this.f1768p0.setText(k5.j.n(j11));
        this.f1764l0.setProgress(k5.j.k(j10, j11));
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            h5.i0 i0Var = this.f1756c0;
            if (i0Var != null && i0Var.o()) {
                this.f1756c0.J(false, false);
                return true;
            }
            if (this.f1757d0.getVisibility() == 0) {
                this.f1757d0.setVisibility(8);
                return true;
            }
            z();
            return true;
        }
        Handler handler = this.f1778z0;
        if (keyCode == 85) {
            s1.a0 a0Var = this.f1760g0;
            if (a0Var != null) {
                if (a0Var.E()) {
                    this.f1760g0.U(false);
                    this.Q.setImageResource(R.drawable.ic_play);
                } else {
                    this.f1760g0.U(true);
                    this.Q.setImageResource(R.drawable.ic_pause);
                }
            }
            handler.removeCallbacks(this.Y);
            u();
            return true;
        }
        if (keyCode == 89) {
            if (this.f1757d0.getVisibility() == 8) {
                this.f1757d0.setVisibility(0);
            }
            this.S.requestFocus();
            y();
            if (this.f1755b0.getVisibility() == 8) {
                this.f1755b0.setVisibility(0);
            }
            if (this.f1754a0.getVisibility() == 0) {
                this.f1754a0.setVisibility(8);
            }
            handler.removeCallbacks(this.Y);
            u();
            return true;
        }
        if (keyCode == 90) {
            if (this.f1757d0.getVisibility() == 8) {
                this.f1757d0.setVisibility(0);
            }
            this.O.requestFocus();
            x();
            if (this.f1754a0.getVisibility() == 8) {
                this.f1754a0.setVisibility(0);
            }
            if (this.f1755b0.getVisibility() == 0) {
                this.f1755b0.setVisibility(8);
            }
            handler.removeCallbacks(this.Y);
            u();
            return true;
        }
        switch (keyCode) {
            case 19:
                if (this.P.hasFocus() || this.M.hasFocus() || this.T.hasFocus() || this.R.hasFocus()) {
                    this.Q.requestFocus();
                    handler.removeCallbacks(this.Y);
                    u();
                    return true;
                }
                if (this.S.hasFocus() || this.Q.hasFocus() || this.O.hasFocus()) {
                    this.f1764l0.requestFocus();
                    handler.removeCallbacks(this.Y);
                    u();
                    return true;
                }
                if (!this.f1764l0.hasFocus()) {
                    handler.removeCallbacks(this.Y);
                    u();
                    return true;
                }
                this.N.requestFocus();
                handler.removeCallbacks(this.Y);
                u();
                return true;
            case 20:
                if (this.f1757d0.getVisibility() == 8) {
                    this.f1757d0.setVisibility(0);
                    this.Q.requestFocus();
                    handler.removeCallbacks(this.Y);
                    u();
                    return true;
                }
                if (this.N.hasFocus()) {
                    this.f1764l0.requestFocus();
                    handler.removeCallbacks(this.Y);
                    u();
                    return true;
                }
                if (this.f1764l0.hasFocus()) {
                    this.Q.requestFocus();
                    handler.removeCallbacks(this.Y);
                    u();
                    return true;
                }
                if (!this.S.hasFocus() && !this.Q.hasFocus() && !this.O.hasFocus()) {
                    handler.removeCallbacks(this.Y);
                    u();
                    return true;
                }
                this.P.requestFocus();
                handler.removeCallbacks(this.Y);
                u();
                return true;
            case 21:
                if (this.f1757d0.getVisibility() != 8) {
                    handler.removeCallbacks(this.Y);
                    u();
                    return super.dispatchKeyEvent(keyEvent);
                }
                y();
                if (this.f1755b0.getVisibility() == 8) {
                    this.f1755b0.setVisibility(0);
                }
                if (this.f1754a0.getVisibility() == 0) {
                    this.f1754a0.setVisibility(8);
                }
                return true;
            case 22:
                if (this.f1757d0.getVisibility() != 8) {
                    handler.removeCallbacks(this.Y);
                    u();
                    return super.dispatchKeyEvent(keyEvent);
                }
                x();
                if (this.f1754a0.getVisibility() == 8) {
                    this.f1754a0.setVisibility(0);
                }
                if (this.f1755b0.getVisibility() == 0) {
                    this.f1755b0.setVisibility(8);
                    return true;
                }
                return true;
            case 23:
                if (this.f1757d0.getVisibility() == 8) {
                    this.f1757d0.setVisibility(0);
                    this.Q.requestFocus();
                    handler.removeCallbacks(this.Y);
                    u();
                    return true;
                }
                if (this.S.hasFocus()) {
                    y();
                    if (this.f1755b0.getVisibility() == 8) {
                        this.f1755b0.setVisibility(0);
                    }
                    if (this.f1754a0.getVisibility() == 0) {
                        this.f1754a0.setVisibility(8);
                    }
                    handler.removeCallbacks(this.Y);
                    u();
                    return true;
                }
                if (!this.O.hasFocus()) {
                    handler.removeCallbacks(this.Y);
                    u();
                    return super.dispatchKeyEvent(keyEvent);
                }
                x();
                if (this.f1754a0.getVisibility() == 8) {
                    this.f1754a0.setVisibility(0);
                }
                if (this.f1755b0.getVisibility() == 0) {
                    this.f1755b0.setVisibility(8);
                }
                handler.removeCallbacks(this.Y);
                u();
                return true;
            default:
                handler.removeCallbacks(this.Y);
                u();
                return super.dispatchKeyEvent(keyEvent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f2.r rVar;
        int id = view.getId();
        boolean z10 = true;
        boolean z11 = false;
        if (id == R.id.btn_audio) {
            f2.r rVar2 = this.f1767o0;
            if (rVar2 == null) {
                return;
            }
            f2.v vVar = rVar2.f4956c;
            if (vVar == null) {
                Toast.makeText(getApplicationContext(), this.B0.getNo_audio(), 1).show();
                return;
            }
            String audio_track = this.B0.getAudio_track();
            int i10 = vVar.f4949b[1];
            if (i10 == 2 || (i10 == 1 && vVar.a() == 0)) {
                z11 = true;
            }
            p7.n nVar = new p7.n(this, audio_track, this.f1760g0, 1);
            nVar.f10070a = z11;
            nVar.b().show();
            return;
        }
        if (id == R.id.btn_back) {
            z();
            return;
        }
        Handler handler = this.f1778z0;
        if (id == R.id.btn_forward) {
            handler.removeCallbacks(this.Y);
            u();
            x();
            return;
        }
        if (id == R.id.btn_info) {
            h5.i0 i0Var = this.f1756c0;
            if (i0Var != null && i0Var.o()) {
                this.f1756c0.J(false, false);
                return;
            }
            String str = this.f1773u0;
            String str2 = this.W;
            String stream_icon = this.U.getStream_icon();
            String str3 = this.A0;
            androidx.fragment.app.j0 n10 = n();
            androidx.fragment.app.a i11 = android.support.v4.media.d.i(n10, n10);
            androidx.fragment.app.s A = n10.A("fragment_info");
            if (A != null) {
                android.support.v4.media.d.v(i11, A, false);
                return;
            }
            h5.i0 i0Var2 = new h5.i0();
            i0Var2.B0 = str;
            i0Var2.f5611x0 = str2;
            i0Var2.A0 = stream_icon;
            i0Var2.C0 = str3;
            this.f1756c0 = i0Var2;
            i0Var2.M(n10, "fragment_info");
            return;
        }
        if (id == R.id.btn_play) {
            s1.a0 a0Var = this.f1760g0;
            if (a0Var != null) {
                if (a0Var.E()) {
                    this.f1760g0.U(false);
                    this.Q.setImageResource(R.drawable.ic_play);
                    return;
                } else {
                    this.f1760g0.U(true);
                    this.Q.setImageResource(R.drawable.ic_pause);
                    return;
                }
            }
            return;
        }
        if (id != R.id.btn_resolution) {
            if (id != R.id.btn_sub || (rVar = this.f1767o0) == null) {
                return;
            }
            f2.v vVar2 = rVar.f4956c;
            if (vVar2 == null) {
                Toast.makeText(getApplicationContext(), this.B0.getNo_subtitle(), 1).show();
                return;
            }
            String subtitle = this.B0.getSubtitle();
            int i12 = vVar2.f4949b[3];
            if (i12 != 2 && (i12 != 3 || vVar2.a() != 3)) {
                z10 = false;
            }
            p7.n nVar2 = new p7.n(this, subtitle, this.f1760g0, 3);
            nVar2.f10070a = z10;
            nVar2.b().show();
            return;
        }
        if (this.f1760g0 == null) {
            return;
        }
        int i13 = (this.C0 + 1) % 4;
        this.C0 = i13;
        if (i13 == 0) {
            this.h0.setResizeMode(3);
            AspectRatioFrameLayout aspectRatioFrameLayout = this.D0;
            if (aspectRatioFrameLayout != null) {
                aspectRatioFrameLayout.setAspectRatio(0.0f);
            }
            this.f1770r0.setText("Fill");
        } else if (i13 == 1) {
            this.h0.setResizeMode(0);
            AspectRatioFrameLayout aspectRatioFrameLayout2 = this.D0;
            if (aspectRatioFrameLayout2 != null) {
                aspectRatioFrameLayout2.setAspectRatio(0.0f);
            }
            this.f1770r0.setText("Fit");
        } else if (i13 == 2) {
            this.h0.setResizeMode(0);
            AspectRatioFrameLayout aspectRatioFrameLayout3 = this.D0;
            if (aspectRatioFrameLayout3 != null) {
                aspectRatioFrameLayout3.setAspectRatio(1.7777778f);
            }
            this.f1770r0.setText("16:9");
        } else if (i13 == 3) {
            this.h0.setResizeMode(0);
            AspectRatioFrameLayout aspectRatioFrameLayout4 = this.D0;
            if (aspectRatioFrameLayout4 != null) {
                aspectRatioFrameLayout4.setAspectRatio(1.3333334f);
            }
            this.f1770r0.setText("4:3");
        }
        this.f1770r0.setVisibility(0);
        handler.removeCallbacks(this.Z);
        this.f1762j0 = 2;
        k0 k0Var = new k0(this, 0);
        this.Z = k0Var;
        k0Var.run();
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_movie_player);
        k5.j.a(this);
        this.f1761i0 = new app.shamel.tv.helper.r(this);
        this.B0 = app.shamel.tv.helper.a.k(this);
        PlayerView playerView = (PlayerView) findViewById(R.id.player_view);
        this.h0 = playerView;
        this.D0 = (AspectRatioFrameLayout) playerView.findViewById(R.id.subtitle_view);
        playerView.getSubtitleView().setApplyEmbeddedStyles(false);
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.subtitle_view);
        this.f1765m0 = subtitleView;
        subtitleView.setVisibility(8);
        u3.c cVar = new u3.c(Color.parseColor(this.f1761i0.D()), Color.parseColor(this.f1761i0.C()), 0, 0, 0, null);
        this.h0.getSubtitleView().a(3, this.f1761i0.F());
        this.h0.getSubtitleView().setStyle(cVar);
        this.f1765m0.setTextSize(3, this.f1761i0.F());
        this.f1765m0.setBackgroundColor(Color.parseColor(this.f1761i0.C()));
        this.f1765m0.setTextColor(Color.parseColor(this.f1761i0.D()));
        this.f1757d0 = (ConstraintLayout) findViewById(R.id.ly_control);
        this.N = (ImageButton) findViewById(R.id.btn_back);
        this.S = (ImageButton) findViewById(R.id.btn_rewind);
        this.Q = (ImageButton) findViewById(R.id.btn_play);
        this.O = (ImageButton) findViewById(R.id.btn_forward);
        this.P = (ImageButton) findViewById(R.id.btn_info);
        this.T = (ImageButton) findViewById(R.id.btn_sub);
        this.M = (ImageButton) findViewById(R.id.btn_audio);
        this.R = (ImageButton) findViewById(R.id.btn_resolution);
        this.f1771s0 = (TextView) findViewById(R.id.txt_start_time);
        this.f1768p0 = (TextView) findViewById(R.id.txt_end_time);
        this.f1754a0 = (ImageView) findViewById(R.id.image_forward);
        this.f1755b0 = (ImageView) findViewById(R.id.image_rewind);
        this.f1769q0 = (TextView) findViewById(R.id.txt_name);
        this.f1770r0 = (TextView) findViewById(R.id.txt_resolution);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.f1764l0 = seekBar;
        seekBar.setMax(100);
        this.f1764l0.setOnSeekBarChangeListener(this);
        this.S.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.S.setOnFocusChangeListener(this);
        this.Q.setOnFocusChangeListener(this);
        this.O.setOnFocusChangeListener(this);
        this.P.setOnFocusChangeListener(this);
        this.T.setOnFocusChangeListener(this);
        this.M.setOnFocusChangeListener(this);
        this.R.setOnFocusChangeListener(this);
        this.N.setOnFocusChangeListener(this);
        this.W = getIntent().getStringExtra("description");
        this.f1773u0 = getIntent().getStringExtra("name");
        this.f1774v0 = getIntent().getStringExtra("tmdb_id");
        this.f1775w0 = getIntent().getStringExtra("stream_id");
        if (this.f1761i0.g() || this.f1775w0.isEmpty()) {
            this.U = a6.n.K().z(this.f1773u0);
        } else {
            this.U = a6.n.K().y(this.f1775w0);
        }
        String str = this.f1774v0;
        if (str == null || str.isEmpty()) {
            this.f1774v0 = this.U.getTmdb_id();
        }
        this.f1769q0.setText(this.f1773u0);
        this.V = k5.a.i(this, this.f1761i0.k());
        i1.y0 y0Var = new i1.y0();
        y0Var.j(3, !this.f1761i0.E());
        this.f1766n0 = new i1.z0(y0Var);
        if (this.f1761i0.g()) {
            this.f1772t0 = this.U.getUrl();
        } else {
            this.f1772t0 = app.shamel.tv.helper.a.h(this.f1761i0.B(), this.f1761i0.I(), this.f1761i0.v(), this.U.getStream_id(), this.U.getExtension());
        }
        long time = this.U.getTime();
        this.f1776x0 = time;
        if (time == 0) {
            this.f1757d0.setVisibility(0);
            v(0L, this.f1772t0);
            u();
            return;
        }
        String str2 = this.f1772t0;
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_resume");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return;
        }
        h5.u N = h5.u.N(this.B0.getResume(), this.B0.getResume_plyaback_from_ast_position(), this.B0.getStr_yes(), this.B0.getNo());
        this.f1763k0 = N;
        N.B0 = new j5.g(this, str2, false);
        N.M(n10, "fragment_resume");
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        if (z10) {
            this.f1778z0.removeCallbacks(this.Y);
            u();
        }
    }

    @Override // f.j, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT <= 23) {
            PlayerView playerView = this.h0;
            if (playerView != null) {
                playerView.g();
            }
            w();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        if (this.f1760g0 == null || !z10) {
            return;
        }
        seekBar.setProgress(i10);
        long D = (int) ((this.f1760g0.D() * i10) / 100);
        this.f1760g0.l(5, D);
        this.f1771s0.setText(k5.j.n(D));
    }

    @Override // f.j, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT > 23) {
            PlayerView playerView = this.h0;
            if (playerView != null) {
                playerView.g();
            }
            w();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        if (this.f1760g0 == null || seekBar.getId() != R.id.seekBar) {
            return;
        }
        this.f1778z0.removeCallbacks(this.E0);
        long o2 = k5.j.o(seekBar.getProgress(), this.f1760g0.D());
        this.f1760g0.l(5, o2);
        this.f1771s0.setText(k5.j.n(o2));
    }

    public final void u() {
        this.f1758e0 = 10;
        k0 k0Var = new k0(this, 1);
        this.Y = k0Var;
        k0Var.run();
    }

    public final void v(long j10, String str) {
        s1.a0 a0Var = this.f1760g0;
        if (a0Var != null) {
            a0Var.O();
        }
        String p10 = l1.a0.p(l1.a0.G(Uri.parse(str)));
        i1.s sVar = new i1.s();
        o9.e0 e0Var = o9.g0.f9617p;
        o9.w0 w0Var = o9.w0.f9686s;
        List list = Collections.EMPTY_LIST;
        o9.w0 w0Var2 = o9.w0.f9686s;
        i1.v vVar = new i1.v();
        i1.y yVar = i1.y.f6072a;
        Uri parse = Uri.parse(str);
        i1.c0 c0Var = new i1.c0();
        c0Var.f5817a = "title";
        this.f1759f0 = new i1.a0(_UrlKt.FRAGMENT_ENCODE_SET, new i1.u(sVar), parse != null ? new i1.x(parse, p10, null, list, w0Var2, -9223372036854775807L) : null, new i1.w(vVar), new i1.d0(c0Var), yVar);
        f2.r rVar = new f2.r(this);
        this.f1767o0 = rVar;
        rVar.b(this.f1766n0);
        s1.n nVar = new s1.n(this);
        x4.l lVar = new x4.l(18);
        lVar.f13562p = k5.a.n(this, this.f1761i0.k());
        c2.r rVar2 = new c2.r(this);
        rVar2.g(this.V);
        rVar2.h(lVar);
        nVar.b(rVar2);
        nVar.d(this.f1767o0);
        nVar.c(k5.a.e(this, true));
        s1.a0 a10 = nVar.a();
        this.f1760g0 = a10;
        a10.W(this.f1766n0);
        this.f1760g0.f11204m.a(new j(this, 3));
        this.f1760g0.q(new h2.a());
        this.f1760g0.q(new m0(this, 0));
        s1.a0 a0Var2 = this.f1760g0;
        i1.d dVar = i1.d.f5843b;
        a0Var2.S();
        this.f1760g0.U(true);
        this.h0.setPlayer(this.f1760g0);
        this.f1760g0.p(this.f1759f0);
        this.f1760g0.N();
        this.f1760g0.j();
        if (j10 > 0) {
            this.f1760g0.l(5, j10);
        }
        Handler handler = this.f1778z0;
        androidx.activity.j jVar = this.E0;
        handler.removeCallbacks(jVar);
        handler.postDelayed(jVar, 100L);
    }

    public final void w() {
        s1.a0 a0Var = this.f1760g0;
        if (a0Var == null) {
            return;
        }
        if (a0Var.y() <= 120000 || this.f1760g0.y() + RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS >= this.f1760g0.D()) {
            final int i10 = 0;
            a6.n.K().d(this.f1773u0, this.f1774v0, false, 0L, 0, new app.shamel.tv.helper.s(this) { // from class: app.shamel.tv.activities.l0

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ MoviePlayerActivity f1908p;

                {
                    this.f1908p = this;
                }

                @Override // app.shamel.tv.helper.s
                public final void j() {
                    switch (i10) {
                        case 0:
                            this.f1908p.f1761i0.X(a6.n.K().C());
                            break;
                        default:
                            this.f1908p.f1761i0.X(a6.n.K().C());
                            break;
                    }
                }
            });
        } else {
            int y8 = (int) ((this.f1760g0.y() * 100) / this.f1760g0.D());
            final int i11 = 1;
            a6.n.K().d(this.f1773u0, this.f1774v0, true, this.f1760g0.y(), y8, new app.shamel.tv.helper.s(this) { // from class: app.shamel.tv.activities.l0

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ MoviePlayerActivity f1908p;

                {
                    this.f1908p = this;
                }

                @Override // app.shamel.tv.helper.s
                public final void j() {
                    switch (i11) {
                        case 0:
                            this.f1908p.f1761i0.X(a6.n.K().C());
                            break;
                        default:
                            this.f1908p.f1761i0.X(a6.n.K().C());
                            break;
                    }
                }
            });
        }
        this.f1760g0.Z();
        this.f1760g0.O();
        this.f1760g0 = null;
        this.h0.setPlayer(null);
    }

    public final void x() {
        s1.a0 a0Var = this.f1760g0;
        if (a0Var == null) {
            return;
        }
        long y8 = a0Var.y();
        long D = a0Var.D();
        if (D == -9223372036854775807L || D <= 0) {
            a0Var.l(5, y8 + 10000);
            return;
        }
        long j10 = y8 + 10000;
        if (j10 > D) {
            j10 = D;
        }
        a0Var.l(5, j10);
        A(j10, D);
    }

    public final void y() {
        s1.a0 a0Var = this.f1760g0;
        if (a0Var == null) {
            return;
        }
        long y8 = a0Var.y();
        long D = a0Var.D();
        if (D != -9223372036854775807L) {
            if (D > 0) {
                long j10 = y8 - 10000;
                long j11 = j10 >= 0 ? j10 : 0L;
                a0Var.l(5, j11);
                A(j11, D);
                return;
            }
        }
        a0Var.l(5, y8 + 10000);
    }

    public final void z() {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_exit");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return;
        }
        h5.u N = h5.u.N(this.B0.getStop_playback(), this.B0.getPlayback_description(), this.B0.getStr_yes(), this.B0.getNo());
        this.X = N;
        N.B0 = new n0(this, 0);
        N.M(n10, "fragment_exit");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }
}
