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
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.j0;
import androidx.fragment.app.s;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerView;
import androidx.mediarouter.app.MediaRouteButton;
import app.shamel.tv.activities.mobile.SeriesMobilePlayer;
import app.shamel.tv.helper.a;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.ResumeModel;
import app.shamel.tv.models.WordModels;
import c2.y0;
import c5.d;
import c5.n;
import c5.o;
import f.j;
import f2.r;
import h5.u;
import h7.i;
import i1.c0;
import i1.d0;
import i1.v;
import i1.w;
import i1.x;
import i1.y;
import i1.z0;
import i7.h;
import io.realm.RealmQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import l1.b;
import o1.g;
import o9.e0;
import o9.g0;
import o9.w0;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import s1.a0;
import u3.c;
import x4.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SeriesMobilePlayer extends j implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public static final /* synthetic */ int K0 = 0;
    public o A0;
    public o B0;
    public int C0;
    public int D0;
    public y0 G0;
    public AudioManager M;
    public SeekBar N;
    public SeekBar O;
    public d P;
    public ImageButton Q;
    public ImageButton R;
    public ImageButton S;
    public ImageButton T;
    public ImageButton U;
    public ImageButton V;
    public ImageButton W;
    public ImageButton X;
    public MediaRouteButton Y;
    public a0 Z;

    /* renamed from: a0, reason: collision with root package name */
    public PlayerView f2007a0;

    /* renamed from: b0, reason: collision with root package name */
    public r f2008b0;

    /* renamed from: c0, reason: collision with root package name */
    public z0 f2009c0;

    /* renamed from: d0, reason: collision with root package name */
    public g f2010d0;

    /* renamed from: e0, reason: collision with root package name */
    public ConstraintLayout f2011e0;

    /* renamed from: f0, reason: collision with root package name */
    public TextView f2012f0;

    /* renamed from: g0, reason: collision with root package name */
    public TextView f2013g0;
    public TextView h0;

    /* renamed from: i0, reason: collision with root package name */
    public TextView f2014i0;

    /* renamed from: j0, reason: collision with root package name */
    public SeekBar f2015j0;

    /* renamed from: k0, reason: collision with root package name */
    public AspectRatioFrameLayout f2016k0;

    /* renamed from: l0, reason: collision with root package name */
    public List f2017l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f2018m0;

    /* renamed from: n0, reason: collision with root package name */
    public String f2019n0;

    /* renamed from: o0, reason: collision with root package name */
    public String f2020o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f2021p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f2022q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f2023r0;

    /* renamed from: s0, reason: collision with root package name */
    public String f2024s0;

    /* renamed from: t0, reason: collision with root package name */
    public h5.r f2025t0;

    /* renamed from: u0, reason: collision with root package name */
    public u f2026u0;

    /* renamed from: v0, reason: collision with root package name */
    public u f2027v0;

    /* renamed from: w0, reason: collision with root package name */
    public app.shamel.tv.helper.r f2028w0;

    /* renamed from: x0, reason: collision with root package name */
    public WordModels f2029x0 = new WordModels();

    /* renamed from: y0, reason: collision with root package name */
    public long f2030y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    public int f2031z0 = 0;
    public final Handler E0 = new Handler(Looper.getMainLooper());
    public int F0 = 1;
    public long H0 = 0;
    public final n I0 = new n(this, 1);
    public final o J0 = new o(this, 0);

    public static void u(SeriesMobilePlayer seriesMobilePlayer) {
        long j10;
        try {
            a0 a0Var = seriesMobilePlayer.Z;
            if (a0Var != null) {
                j10 = a0Var.y();
                seriesMobilePlayer.Z.U(false);
            } else {
                j10 = 0;
            }
            seriesMobilePlayer.v(j10, seriesMobilePlayer.f2019n0);
        } catch (Exception e7) {
            b.g("CAST_ERROR", "فشل بدء الكاست: " + e7.getMessage());
            Toast.makeText(seriesMobilePlayer, "تعذّر الإرسال إلى الكاست", 0).show();
        }
    }

    public final void A(int i10) {
        List list = this.f2017l0;
        if (list == null || list.isEmpty() || i10 < 0 || i10 >= this.f2017l0.size()) {
            return;
        }
        this.f2015j0.setProgress(0);
        EpisodeModel episodeModel = (EpisodeModel) this.f2017l0.get(i10);
        this.f2018m0 = i10;
        this.f2020o0 = episodeModel.getTitle();
        this.f2024s0 = this.f2021p0 + this.f2022q0 + this.f2020o0;
        this.h0.setText(this.f2020o0);
        if (this.f2028w0.g()) {
            this.f2019n0 = episodeModel.getUrl();
        } else {
            this.f2019n0 = a.f(this.f2028w0.B(), this.f2028w0.I(), this.f2028w0.v(), episodeModel.getId(), episodeModel.getContainer_extension());
        }
        long x6 = x(this.f2024s0);
        this.f2030y0 = x6;
        if (x6 == 0) {
            this.f2011e0.setVisibility(0);
            this.U.requestFocus();
            if (y()) {
                v(0L, this.f2019n0);
            } else {
                B(0L, this.f2019n0);
            }
            this.E0.removeCallbacks(this.A0);
            z();
            F();
            return;
        }
        this.f2011e0.setVisibility(8);
        j0 n10 = n();
        n10.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n10);
        s A = n10.A("fragment_resume");
        if (A != null) {
            android.support.v4.media.d.v(aVar, A, false);
            return;
        }
        u N = u.N(this.f2029x0.getResume(), this.f2029x0.getResume_plyaback_from_ast_position(), this.f2029x0.getStr_yes(), this.f2029x0.getNo());
        this.f2027v0 = N;
        N.B0 = new n(this, 0);
        N.M(n10, "fragment_resume");
    }

    public final void B(long j10, String str) {
        try {
            a0 a0Var = this.Z;
            if (a0Var != null) {
                a0Var.O();
            }
            String p10 = l1.a0.p(l1.a0.G(Uri.parse(str)));
            i1.s sVar = new i1.s();
            e0 e0Var = g0.f9617p;
            w0 w0Var = w0.f9686s;
            List list = Collections.EMPTY_LIST;
            w0 w0Var2 = w0.f9686s;
            v vVar = new v();
            y yVar = y.f6072a;
            Uri parse = Uri.parse(str);
            c0 c0Var = new c0();
            c0Var.f5817a = this.f2020o0;
            i1.a0 a0Var2 = new i1.a0(_UrlKt.FRAGMENT_ENCODE_SET, new i1.u(sVar), parse != null ? new x(parse, p10, null, list, w0Var2, -9223372036854775807L) : null, new w(vVar), new d0(c0Var), yVar);
            r rVar = new r(this);
            this.f2008b0 = rVar;
            rVar.b(this.f2009c0);
            s1.n nVar = new s1.n(this);
            l lVar = new l(18);
            lVar.f13562p = k5.a.n(this, this.f2028w0.k());
            c2.r rVar2 = new c2.r(this);
            rVar2.g(this.f2010d0);
            rVar2.h(lVar);
            nVar.b(rVar2);
            nVar.d(this.f2008b0);
            nVar.c(k5.a.e(this, true));
            a0 a10 = nVar.a();
            this.Z = a10;
            a10.W(this.f2009c0);
            this.Z.f11204m.a(new app.shamel.tv.activities.j(this, 8));
            this.Z.q(new h2.a());
            a0 a0Var3 = this.Z;
            i1.d dVar = i1.d.f5843b;
            a0Var3.S();
            this.Z.U(true);
            this.f2007a0.setPlayer(this.Z);
            this.Z.p(a0Var2);
            this.Z.N();
            this.Z.j();
            if (j10 > 0) {
                this.Z.l(5, j10);
            }
            this.E0.removeCallbacks(this.J0);
            F();
        } catch (Exception e7) {
            b.g("SeriesMobilePlayer", "playVideo error: " + e7.getMessage());
        }
    }

    public final void C() {
        long j10;
        long j11;
        a0 a0Var;
        if (y()) {
            j10 = this.H0;
            if (j10 <= 0) {
                j10 = this.G0.b();
            }
            j11 = this.G0.c();
        } else {
            a0 a0Var2 = this.Z;
            if (a0Var2 != null) {
                j10 = a0Var2.y();
                j11 = this.Z.D();
            } else {
                j10 = 0;
                j11 = 0;
            }
        }
        this.f2030y0 = j10;
        String str = this.f2024s0;
        if (str != null && j11 > 0) {
            Iterator it = this.f2028w0.A().iterator();
            while (it.hasNext()) {
                if (((ResumeModel) it.next()).getName().equals(str)) {
                    it.remove();
                }
            }
            if (j10 > 10000 && 10000 + j10 < j11) {
                ResumeModel resumeModel = new ResumeModel();
                resumeModel.setName(this.f2024s0);
                resumeModel.setLast_position(j10);
                resumeModel.setPro((int) ((j10 * 100) / j11));
                List A = this.f2028w0.A();
                A.add(0, resumeModel);
                this.f2028w0.a0(A);
            }
        }
        if (y() || (a0Var = this.Z) == null) {
            return;
        }
        try {
            a0Var.Z();
        } catch (Exception unused) {
        }
        try {
            this.Z.O();
        } catch (Exception unused2) {
        }
        this.Z = null;
    }

    public final void D(long j10) {
        long y8;
        if (y()) {
            y8 = this.G0.b();
        } else {
            a0 a0Var = this.Z;
            y8 = a0Var != null ? a0Var.y() : 0L;
        }
        long w10 = w();
        if (w10 <= 0) {
            return;
        }
        long j11 = y8 + j10;
        if (j11 < 0) {
            j11 = 0;
        }
        if (j11 > w10) {
            j11 = Math.max(0L, w10 - 1000);
        }
        if (y()) {
            this.G0.h(j11);
        } else {
            a0 a0Var2 = this.Z;
            if (a0Var2 != null) {
                a0Var2.l(5, j11);
            }
        }
        F();
    }

    public final void E() {
        j0 n10 = n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        s A = n10.A("fragment_exit");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return;
        }
        u N = u.N(this.f2029x0.getStop_playback(), this.f2029x0.getPlayback_description(), this.f2029x0.getStr_yes(), this.f2029x0.getNo());
        this.f2026u0 = N;
        N.B0 = new n(this, 2);
        N.M(n10, "fragment_exit");
    }

    public final void F() {
        Handler handler = this.E0;
        o oVar = this.J0;
        handler.removeCallbacks(oVar);
        handler.postDelayed(oVar, 100L);
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        E();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        int id = view.getId();
        boolean z10 = true;
        boolean z11 = false;
        if (id == R.id.btn_audio) {
            r rVar2 = this.f2008b0;
            if (rVar2 == null || this.Z == null) {
                return;
            }
            f2.v vVar = rVar2.f4956c;
            if (vVar == null) {
                Toast.makeText(getApplicationContext(), this.f2029x0.getNo_audio(), 1).show();
                return;
            }
            String audio_track = this.f2029x0.getAudio_track();
            int i10 = vVar.f4949b[1];
            if (i10 == 1 || (i10 == 2 && vVar.a() == 0)) {
                z11 = true;
            }
            p7.n nVar = new p7.n(this, audio_track, this.Z, 1);
            nVar.f10070a = z11;
            nVar.b().show();
            return;
        }
        if (id == R.id.btn_back) {
            E();
            return;
        }
        if (id == R.id.btn_down) {
            j0 n10 = n();
            androidx.fragment.app.a i11 = android.support.v4.media.d.i(n10, n10);
            s A = n10.A("episode_group");
            if (A != null) {
                android.support.v4.media.d.v(i11, A, false);
                return;
            }
            List list = this.f2017l0;
            int i12 = this.f2023r0;
            int i13 = this.f2018m0;
            h5.r rVar3 = new h5.r();
            rVar3.f5649z0 = list;
            rVar3.D0 = i12;
            rVar3.A0 = i13;
            this.f2025t0 = rVar3;
            rVar3.B0 = new n(this, 4);
            rVar3.M(n10, "episode_group");
            return;
        }
        Handler handler = this.E0;
        if (id == R.id.btn_forward) {
            handler.removeCallbacks(this.A0);
            z();
            D(10000L);
            return;
        }
        if (id == R.id.btn_play) {
            y0 y0Var = this.G0;
            if (y0Var == null || !y0Var.g()) {
                a0 a0Var = this.Z;
                if (a0Var != null) {
                    if (a0Var.E()) {
                        this.Z.U(false);
                        this.U.setImageResource(R.drawable.ic_play);
                        return;
                    } else {
                        this.Z.U(true);
                        this.U.setImageResource(R.drawable.ic_pause);
                        return;
                    }
                }
                return;
            }
            h e7 = this.G0.e();
            if (e7 != null && e7.e() == 2) {
                h e8 = this.G0.e();
                if (e8 != null) {
                    e8.o();
                }
                this.U.setImageResource(R.drawable.ic_play);
                return;
            }
            h e10 = this.G0.e();
            if (e10 != null) {
                e10.p();
            }
            this.U.setImageResource(R.drawable.ic_pause);
            return;
        }
        if (id != R.id.btn_resolution) {
            if (id == R.id.btn_rewind) {
                handler.removeCallbacks(this.A0);
                z();
                D(-10000L);
                return;
            }
            if (id != R.id.btn_sub || y() || (rVar = this.f2008b0) == null || this.Z == null) {
                return;
            }
            f2.v vVar2 = rVar.f4956c;
            if (vVar2 == null) {
                Toast.makeText(getApplicationContext(), this.f2029x0.getNo_subtitle(), 1).show();
                return;
            }
            String subtitle = this.f2029x0.getSubtitle();
            int i14 = vVar2.f4949b[3];
            if (i14 != 3 && (i14 != 2 || vVar2.a() != 3)) {
                z10 = false;
            }
            p7.n nVar2 = new p7.n(this, subtitle, this.Z, 3);
            nVar2.f10070a = z10;
            nVar2.b().show();
            return;
        }
        int i15 = (this.F0 + 1) % 4;
        this.F0 = i15;
        if (i15 == 0) {
            this.f2007a0.setResizeMode(3);
            AspectRatioFrameLayout aspectRatioFrameLayout = this.f2016k0;
            if (aspectRatioFrameLayout != null) {
                aspectRatioFrameLayout.setAspectRatio(0.0f);
            }
            this.f2014i0.setText("Fill");
        } else if (i15 == 1) {
            this.f2007a0.setResizeMode(0);
            AspectRatioFrameLayout aspectRatioFrameLayout2 = this.f2016k0;
            if (aspectRatioFrameLayout2 != null) {
                aspectRatioFrameLayout2.setAspectRatio(0.0f);
            }
            this.f2014i0.setText("Fit");
        } else if (i15 == 2) {
            this.f2007a0.setResizeMode(0);
            AspectRatioFrameLayout aspectRatioFrameLayout3 = this.f2016k0;
            if (aspectRatioFrameLayout3 != null) {
                aspectRatioFrameLayout3.setAspectRatio(1.7777778f);
            }
            this.f2014i0.setText("16:9");
        } else if (i15 == 3) {
            this.f2007a0.setResizeMode(0);
            AspectRatioFrameLayout aspectRatioFrameLayout4 = this.f2016k0;
            if (aspectRatioFrameLayout4 != null) {
                aspectRatioFrameLayout4.setAspectRatio(1.3333334f);
            }
            this.f2014i0.setText("4:3");
        }
        this.f2014i0.setVisibility(0);
        handler.removeCallbacks(this.B0);
        this.D0 = 2;
        o oVar = new o(this, 2);
        this.B0 = oVar;
        oVar.run();
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_series_mobile_player);
        this.G0 = new y0(this);
        this.P = new d(this, new Handler(Looper.getMainLooper()), 3);
        k5.j.a(this);
        this.f2028w0 = new app.shamel.tv.helper.r(this);
        this.f2029x0 = a.k(this);
        if (Build.VERSION.SDK_INT >= 26) {
            q.o();
        }
        PlayerView playerView = (PlayerView) findViewById(R.id.player_view);
        this.f2007a0 = playerView;
        this.f2016k0 = (AspectRatioFrameLayout) playerView.findViewById(R.id.exo_content_frame);
        this.f2007a0.getSubtitleView().setApplyEmbeddedStyles(false);
        this.f2007a0.getSubtitleView().setStyle(new c(Color.parseColor(this.f2028w0.D()), Color.parseColor(this.f2028w0.C()), 0, 0, 0, null));
        this.f2007a0.getSubtitleView().a(3, this.f2028w0.F());
        this.Y = (MediaRouteButton) findViewById(R.id.btn_cast);
        this.f2011e0 = (ConstraintLayout) findViewById(R.id.ly_control);
        this.R = (ImageButton) findViewById(R.id.btn_back);
        this.W = (ImageButton) findViewById(R.id.btn_rewind);
        this.U = (ImageButton) findViewById(R.id.btn_play);
        this.T = (ImageButton) findViewById(R.id.btn_forward);
        this.X = (ImageButton) findViewById(R.id.btn_sub);
        this.Q = (ImageButton) findViewById(R.id.btn_audio);
        this.V = (ImageButton) findViewById(R.id.btn_resolution);
        this.S = (ImageButton) findViewById(R.id.btn_down);
        this.f2012f0 = (TextView) findViewById(R.id.txt_start_time);
        this.f2013g0 = (TextView) findViewById(R.id.txt_end_time);
        this.h0 = (TextView) findViewById(R.id.txt_name);
        this.f2014i0 = (TextView) findViewById(R.id.txt_resolution);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.f2015j0 = seekBar;
        seekBar.setMax(100);
        this.f2015j0.setOnSeekBarChangeListener(this);
        this.R.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.V.setOnClickListener(this);
        final int i10 = 0;
        findViewById(R.id.view_click).setOnClickListener(new View.OnClickListener(this) { // from class: c5.m

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ SeriesMobilePlayer f2946p;

            {
                this.f2946p = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i10) {
                    case 0:
                        SeriesMobilePlayer seriesMobilePlayer = this.f2946p;
                        y0 y0Var = seriesMobilePlayer.G0;
                        if (y0Var != null && y0Var.g()) {
                            seriesMobilePlayer.f2011e0.setVisibility(0);
                            break;
                        } else if (seriesMobilePlayer.f2011e0.getVisibility() == 0) {
                            seriesMobilePlayer.E0.removeCallbacks(seriesMobilePlayer.A0);
                            seriesMobilePlayer.f2011e0.setVisibility(8);
                            break;
                        }
                        break;
                    default:
                        SeriesMobilePlayer seriesMobilePlayer2 = this.f2946p;
                        if (seriesMobilePlayer2.f2011e0.getVisibility() == 8) {
                            seriesMobilePlayer2.f2011e0.setVisibility(0);
                            seriesMobilePlayer2.z();
                            break;
                        }
                        break;
                }
            }
        });
        if (this.f2007a0.getVideoSurfaceView() != null) {
            final int i11 = 1;
            this.f2007a0.getVideoSurfaceView().setOnClickListener(new View.OnClickListener(this) { // from class: c5.m

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ SeriesMobilePlayer f2946p;

                {
                    this.f2946p = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i11) {
                        case 0:
                            SeriesMobilePlayer seriesMobilePlayer = this.f2946p;
                            y0 y0Var = seriesMobilePlayer.G0;
                            if (y0Var != null && y0Var.g()) {
                                seriesMobilePlayer.f2011e0.setVisibility(0);
                                break;
                            } else if (seriesMobilePlayer.f2011e0.getVisibility() == 0) {
                                seriesMobilePlayer.E0.removeCallbacks(seriesMobilePlayer.A0);
                                seriesMobilePlayer.f2011e0.setVisibility(8);
                                break;
                            }
                            break;
                        default:
                            SeriesMobilePlayer seriesMobilePlayer2 = this.f2946p;
                            if (seriesMobilePlayer2.f2011e0.getVisibility() == 8) {
                                seriesMobilePlayer2.f2011e0.setVisibility(0);
                                seriesMobilePlayer2.z();
                                break;
                            }
                            break;
                    }
                }
            });
        }
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.volume_seekbar);
        this.O = seekBar2;
        seekBar2.setOnSeekBarChangeListener(this);
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        this.M = audioManager;
        if (audioManager != null) {
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = this.M.getStreamVolume(3);
            this.O.setMax(streamMaxVolume);
            this.O.setProgress(streamVolume);
        }
        SeekBar seekBar3 = (SeekBar) findViewById(R.id.bright_seekbar);
        this.N = seekBar3;
        seekBar3.setMax(255);
        this.N.setProgress(Settings.System.getInt(getContentResolver(), "screen_brightness", 0));
        this.N.setOnSeekBarChangeListener(this);
        h7.a.a(this, this.Y);
        this.f2018m0 = getIntent().getIntExtra("position", 0);
        this.f2023r0 = getIntent().getIntExtra("season_pos", 0);
        this.f2021p0 = getIntent().getStringExtra("series_name");
        this.f2022q0 = getIntent().getStringExtra("season_name");
        if (this.f2028w0.g()) {
            a6.n K = a6.n.K();
            String str = this.f2021p0;
            String str2 = this.f2022q0;
            K.getClass();
            RealmQuery V = ((io.realm.u) K.f74p).V(EpisodeModel.class);
            V.c("series_name", str);
            V.c("season_name", str2);
            this.f2017l0 = new ArrayList(V.d());
        } else {
            this.f2017l0 = this.f2028w0.e();
        }
        this.f2010d0 = k5.a.i(this, this.f2028w0.k());
        i1.y0 y0Var = new i1.y0();
        y0Var.j(3, !this.f2028w0.E());
        this.f2009c0 = new z0(y0Var);
        A(this.f2018m0);
        j().a(this, new androidx.fragment.app.a0(this, 6));
    }

    @Override // f.j, android.app.Activity
    public final void onPause() {
        i iVar;
        n nVar;
        super.onPause();
        y0 y0Var = this.G0;
        if (y0Var != null && (iVar = (i) y0Var.f2775r) != null && (nVar = this.I0) != null) {
            iVar.e(nVar);
        }
        if (!y() && Build.VERSION.SDK_INT <= 23) {
            PlayerView playerView = this.f2007a0;
            if (playerView != null) {
                playerView.g();
            }
            C();
        }
        if (this.P != null) {
            getContentResolver().unregisterContentObserver(this.P);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        int id = seekBar.getId();
        if (z10) {
            if (id == R.id.bright_seekbar) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.screenBrightness = i10 / 255.0f;
                window.setAttributes(attributes);
                return;
            }
            if (id != R.id.volume_seekbar) {
                if (id == R.id.seekBar) {
                    long w10 = w();
                    if (w10 > 0) {
                        this.f2012f0.setText(k5.j.n((w10 * i10) / 100));
                        return;
                    }
                    return;
                }
                return;
            }
            AudioManager audioManager = this.M;
            if (audioManager == null) {
                return;
            }
            audioManager.setStreamVolume(3, i10, 0);
            int streamMaxVolume = this.M.getStreamMaxVolume(3);
            a0 a0Var = this.Z;
            if (a0Var == null || streamMaxVolume <= 0) {
                return;
            }
            a0Var.Y(i10 / streamMaxVolume);
        }
    }

    @Override // f.j, android.app.Activity
    public final void onResume() {
        String str;
        n nVar;
        super.onResume();
        y0 y0Var = this.G0;
        if (y0Var != null) {
            if (((i) y0Var.f2775r) == null) {
                y0Var.f();
            }
            i iVar = (i) y0Var.f2775r;
            if (iVar != null && (nVar = this.I0) != null) {
                iVar.a(nVar);
            }
        }
        AudioManager audioManager = this.M;
        if (audioManager != null && this.O != null) {
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = this.M.getStreamVolume(3);
            this.O.setMax(streamMaxVolume);
            this.O.setProgress(streamVolume);
        }
        getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.P);
        if (y()) {
            this.E0.removeCallbacks(this.J0);
            F();
            return;
        }
        a0 a0Var = this.Z;
        if (a0Var == null && (str = this.f2019n0) != null) {
            B(this.f2030y0, str);
        } else if (a0Var != null) {
            this.f2007a0.h();
            this.Z.U(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() == R.id.seekBar) {
            this.E0.removeCallbacks(this.J0);
        }
    }

    @Override // f.j, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (!y()) {
            if (Build.VERSION.SDK_INT > 23) {
                PlayerView playerView = this.f2007a0;
                if (playerView != null) {
                    playerView.g();
                }
                C();
                return;
            }
            return;
        }
        PlayerView playerView2 = this.f2007a0;
        if (playerView2 != null) {
            playerView2.g();
        }
        a0 a0Var = this.Z;
        if (a0Var != null) {
            a0Var.U(false);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() == R.id.seekBar) {
            long w10 = w();
            if (w10 <= 0) {
                return;
            }
            long progress = (w10 * seekBar.getProgress()) / 100;
            if (y()) {
                this.G0.h(progress);
            } else {
                a0 a0Var = this.Z;
                if (a0Var != null) {
                    a0Var.l(5, progress);
                }
            }
            this.f2012f0.setText(k5.j.n(progress));
            F();
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (y()) {
            return;
        }
        C();
    }

    public final void v(long j10, String str) {
        String str2;
        int i10;
        if (this.G0 == null) {
            return;
        }
        List list = this.f2017l0;
        EpisodeModel episodeModel = (list == null || (i10 = this.f2018m0) < 0 || i10 >= list.size()) ? null : (EpisodeModel) this.f2017l0.get(this.f2018m0);
        StringBuilder sb2 = new StringBuilder();
        String str3 = this.f2021p0;
        if (str3 == null) {
            str3 = "Series";
        }
        sb2.append(str3);
        if (episodeModel != null) {
            str2 = " - " + episodeModel.getTitle();
        } else {
            str2 = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        sb2.append(str2);
        this.G0.a(str, sb2.toString(), episodeModel != null ? episodeModel.getStream_icon() : null, j10);
    }

    public final long w() {
        if (y()) {
            return this.G0.c();
        }
        a0 a0Var = this.Z;
        if (a0Var != null) {
            return a0Var.D();
        }
        return 0L;
    }

    public final long x(String str) {
        for (ResumeModel resumeModel : this.f2028w0.A()) {
            if (resumeModel.getName().equalsIgnoreCase(str)) {
                return resumeModel.getLast_position();
            }
        }
        return 0L;
    }

    public final boolean y() {
        y0 y0Var = this.G0;
        return y0Var != null && y0Var.g();
    }

    public final void z() {
        y0 y0Var = this.G0;
        if (y0Var != null && y0Var.g()) {
            this.E0.removeCallbacks(this.A0);
            this.f2011e0.setVisibility(0);
        } else {
            this.C0 = 10;
            o oVar = new o(this, 1);
            this.A0 = oVar;
            oVar.run();
        }
    }
}
