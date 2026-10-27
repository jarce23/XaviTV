package app.shamel.tv.activities;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.transition.TransitionManager;
import android.util.Log;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.ResumeModel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.SubtitleView;
import i1.b1;
import io.realm.RealmQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SeriesPlayerActivity extends f.j implements View.OnClickListener, View.OnFocusChangeListener, SeekBar.OnSeekBarChangeListener {
    public AspectRatioFrameLayout I0;
    public d5.r M;
    public ImageButton N;
    public ImageButton O;
    public ImageButton P;
    public ImageButton Q;
    public ImageButton R;
    public ImageButton S;
    public ImageButton T;
    public ImageButton U;
    public ImageButton V;
    public ImageButton W;
    public o1.g X;
    public List Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public h5.u f1816a0;

    /* renamed from: b0, reason: collision with root package name */
    public g f1817b0;

    /* renamed from: c0, reason: collision with root package name */
    public v0 f1818c0;

    /* renamed from: d0, reason: collision with root package name */
    public ImageView f1819d0;

    /* renamed from: e0, reason: collision with root package name */
    public ImageView f1820e0;

    /* renamed from: f0, reason: collision with root package name */
    public ConstraintLayout f1821f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f1822g0;
    public s1.a0 h0;

    /* renamed from: i0, reason: collision with root package name */
    public PlayerView f1823i0;

    /* renamed from: j0, reason: collision with root package name */
    public app.shamel.tv.helper.r f1824j0;

    /* renamed from: k0, reason: collision with root package name */
    public RecyclerView f1825k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f1826l0;

    /* renamed from: m0, reason: collision with root package name */
    public h5.u f1827m0;

    /* renamed from: n0, reason: collision with root package name */
    public String f1828n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f1829o0;

    /* renamed from: p0, reason: collision with root package name */
    public SeekBar f1830p0;

    /* renamed from: q0, reason: collision with root package name */
    public SubtitleView f1831q0;

    /* renamed from: r0, reason: collision with root package name */
    public i1.z0 f1832r0;

    /* renamed from: s0, reason: collision with root package name */
    public f2.r f1833s0;

    /* renamed from: t0, reason: collision with root package name */
    public TextView f1834t0;

    /* renamed from: u0, reason: collision with root package name */
    public TextView f1835u0;

    /* renamed from: v0, reason: collision with root package name */
    public TextView f1836v0;

    /* renamed from: w0, reason: collision with root package name */
    public TextView f1837w0;

    /* renamed from: x0, reason: collision with root package name */
    public TextView f1838x0;

    /* renamed from: y0, reason: collision with root package name */
    public WordModels f1839y0 = new WordModels();

    /* renamed from: z0, reason: collision with root package name */
    public String f1840z0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public String A0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public String B0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public String C0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public long D0 = 0;
    public int E0 = 0;
    public int F0 = 0;
    public final Handler G0 = new Handler(Looper.getMainLooper());
    public int H0 = 1;
    public final v0 J0 = new v0(this, 0);

    public final void A() {
        if (this.h0 != null) {
            String str = this.f1828n0;
            Iterator it = this.f1824j0.A().iterator();
            while (it.hasNext()) {
                if (((ResumeModel) it.next()).getName().equals(str)) {
                    it.remove();
                }
            }
            if (this.h0.y() > 120000 && this.h0.y() + 10000 < this.h0.D()) {
                ResumeModel resumeModel = new ResumeModel();
                resumeModel.setName(this.f1828n0);
                resumeModel.setLast_position(this.h0.y());
                resumeModel.setPro((int) ((this.h0.y() * 100) / this.h0.D()));
                List A = this.f1824j0.A();
                A.add(0, resumeModel);
                this.f1824j0.a0(A);
            }
            this.h0.Z();
            this.h0.O();
            this.h0 = null;
        }
    }

    public final void B() {
        s1.a0 a0Var = this.h0;
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
        F(j10, D);
    }

    public final void C() {
        s1.a0 a0Var = this.h0;
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
                F(j11, D);
                return;
            }
        }
        a0Var.l(5, y8 + 10000);
    }

    public final void D(boolean z10) {
        x.m mVar = new x.m();
        mVar.c(this.f1821f0);
        if (z10) {
            mVar.l(R.id.horizontal_line1, 0.75f);
            mVar.l(R.id.horizontal_line2, 1.0f);
        } else {
            mVar.l(R.id.horizontal_line1, 0.9f);
            mVar.l(R.id.horizontal_line2, 1.15f);
        }
        TransitionManager.beginDelayedTransition(this.f1821f0);
        mVar.a(this.f1821f0);
        if (!z10) {
            this.f1825k0.setFocusable(false);
            this.R.requestFocus();
            return;
        }
        this.f1825k0.setFocusable(true);
        d5.r rVar = this.M;
        int i10 = this.Z;
        int i11 = rVar.g;
        rVar.g = i10;
        rVar.e(i11);
        rVar.e(rVar.g);
        this.f1825k0.requestFocus();
        this.f1825k0.e0(this.Z);
    }

    public final void E() {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_exit");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return;
        }
        h5.u N = h5.u.N(this.f1839y0.getStop_playback(), this.f1839y0.getPlayback_description(), this.f1839y0.getStr_yes(), this.f1839y0.getNo());
        this.f1816a0 = N;
        N.B0 = new w0(this, 0);
        N.M(n10, "fragment_exit");
    }

    public final void F(long j10, long j11) {
        if (j11 <= 0 || j11 == -9223372036854775807L) {
            this.f1838x0.setText(k5.j.n(j10));
            return;
        }
        this.f1838x0.setText(k5.j.n(j10));
        this.f1834t0.setText(k5.j.n(j11));
        this.f1830p0.setProgress(k5.j.k(j10, j11));
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            if (this.f1821f0.getVisibility() != 0) {
                E();
                return true;
            }
            this.f1821f0.setVisibility(8);
            D(false);
            return true;
        }
        Handler handler = this.G0;
        if (keyCode != 66) {
            if (keyCode == 85) {
                s1.a0 a0Var = this.h0;
                if (a0Var != null) {
                    if (a0Var.E()) {
                        this.h0.U(false);
                        this.R.setImageResource(R.drawable.ic_play);
                    } else {
                        this.h0.U(true);
                        this.R.setImageResource(R.drawable.ic_pause);
                    }
                }
                handler.removeCallbacks(this.f1817b0);
                x();
                return true;
            }
            if (keyCode == 89) {
                if (this.f1821f0.getVisibility() == 8) {
                    this.f1821f0.setVisibility(0);
                }
                this.U.requestFocus();
                C();
                if (this.f1820e0.getVisibility() == 8) {
                    this.f1820e0.setVisibility(0);
                }
                if (this.f1819d0.getVisibility() == 0) {
                    this.f1819d0.setVisibility(8);
                }
                handler.removeCallbacks(this.f1817b0);
                x();
                return true;
            }
            if (keyCode == 90) {
                if (this.f1821f0.getVisibility() == 8) {
                    this.f1821f0.setVisibility(0);
                }
                this.P.requestFocus();
                B();
                if (this.f1819d0.getVisibility() == 8) {
                    this.f1819d0.setVisibility(0);
                }
                if (this.f1820e0.getVisibility() == 0) {
                    this.f1820e0.setVisibility(8);
                }
                handler.removeCallbacks(this.f1817b0);
                x();
                return true;
            }
            switch (keyCode) {
                case 19:
                    if (this.f1821f0.getVisibility() == 0 && this.f1830p0.hasFocus()) {
                        this.O.requestFocus();
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return true;
                    }
                    if (this.f1821f0.getVisibility() == 0 && u()) {
                        this.f1830p0.requestFocus();
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return true;
                    }
                    if (this.f1821f0.getVisibility() == 0 && v()) {
                        this.R.requestFocus();
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return true;
                    }
                    if (this.f1821f0.getVisibility() != 0 || !this.f1825k0.hasFocus()) {
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return true;
                    }
                    D(false);
                    this.V.requestFocus();
                    handler.removeCallbacks(this.f1817b0);
                    x();
                    return true;
                case 20:
                    if (this.f1821f0.getVisibility() == 8) {
                        this.f1821f0.setVisibility(0);
                        this.R.requestFocus();
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return true;
                    }
                    if (this.O.hasFocus()) {
                        this.f1830p0.requestFocus();
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return true;
                    }
                    if (this.f1830p0.hasFocus()) {
                        this.R.requestFocus();
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return true;
                    }
                    if (u()) {
                        this.V.requestFocus();
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return true;
                    }
                    if (!v()) {
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return true;
                    }
                    D(true);
                    handler.removeCallbacks(this.f1817b0);
                    x();
                    return true;
                case 21:
                    if (this.f1825k0.hasFocus()) {
                        if (this.F0 == 0) {
                            handler.removeCallbacks(this.f1817b0);
                            x();
                            return true;
                        }
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    if (this.f1821f0.getVisibility() != 8) {
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    C();
                    if (this.f1820e0.getVisibility() == 8) {
                        this.f1820e0.setVisibility(0);
                    }
                    if (this.f1819d0.getVisibility() == 0) {
                        this.f1819d0.setVisibility(8);
                    }
                    return true;
                case 22:
                    if (this.f1825k0.hasFocus()) {
                        if (this.F0 == this.Y.size() - 1) {
                            handler.removeCallbacks(this.f1817b0);
                            x();
                            return true;
                        }
                    }
                    if (this.f1821f0.getVisibility() != 8) {
                        handler.removeCallbacks(this.f1817b0);
                        x();
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    B();
                    if (this.f1819d0.getVisibility() == 8) {
                        this.f1819d0.setVisibility(0);
                    }
                    if (this.f1820e0.getVisibility() == 0) {
                        this.f1820e0.setVisibility(8);
                        return true;
                    }
                    return true;
                case 23:
                    break;
                default:
                    return super.dispatchKeyEvent(keyEvent);
            }
        }
        if (this.f1821f0.getVisibility() == 8) {
            this.f1821f0.setVisibility(0);
            this.R.requestFocus();
            handler.removeCallbacks(this.f1817b0);
            x();
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.U.hasFocus()) {
            C();
            if (this.f1820e0.getVisibility() == 8) {
                this.f1820e0.setVisibility(0);
            }
            if (this.f1819d0.getVisibility() == 0) {
                this.f1819d0.setVisibility(8);
            }
            handler.removeCallbacks(this.f1817b0);
            x();
            return true;
        }
        if (!this.P.hasFocus()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        B();
        if (this.f1819d0.getVisibility() == 8) {
            this.f1819d0.setVisibility(0);
        }
        if (this.f1820e0.getVisibility() == 0) {
            this.f1820e0.setVisibility(8);
        }
        handler.removeCallbacks(this.f1817b0);
        x();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f2.r rVar;
        int id = view.getId();
        boolean z10 = true;
        boolean z11 = false;
        if (id == R.id.btn_audio) {
            f2.r rVar2 = this.f1833s0;
            if (rVar2 == null) {
                return;
            }
            f2.v vVar = rVar2.f4956c;
            if (vVar == null) {
                Toast.makeText(getApplicationContext(), this.f1839y0.getNo_audio(), 1).show();
                return;
            }
            String audio_track = this.f1839y0.getAudio_track();
            int i10 = vVar.f4949b[1];
            if (i10 == 2 || (i10 == 1 && vVar.a() == 0)) {
                z11 = true;
            }
            p7.n nVar = new p7.n(this, audio_track, this.h0, 1);
            nVar.f10070a = z11;
            nVar.b().show();
            return;
        }
        if (id == R.id.btn_back) {
            E();
            return;
        }
        if (id == R.id.btn_next) {
            if (this.Z < this.Y.size() - 1) {
                this.Z++;
                A();
                y(this.Z);
                return;
            }
            return;
        }
        if (id == R.id.btn_play) {
            s1.a0 a0Var = this.h0;
            if (a0Var != null) {
                if (a0Var.E()) {
                    this.h0.U(false);
                    this.R.setImageResource(R.drawable.ic_play);
                    return;
                } else {
                    this.h0.U(true);
                    this.R.setImageResource(R.drawable.ic_pause);
                    return;
                }
            }
            return;
        }
        if (id == R.id.btn_previous) {
            int i11 = this.Z;
            if (i11 > 0) {
                this.Z = i11 - 1;
                A();
                y(this.Z);
                return;
            }
            return;
        }
        if (id != R.id.btn_resolution) {
            if (id != R.id.btn_sub || (rVar = this.f1833s0) == null) {
                return;
            }
            f2.v vVar2 = rVar.f4956c;
            if (vVar2 == null) {
                Toast.makeText(getApplicationContext(), this.f1839y0.getNo_subtitle(), 1).show();
                return;
            }
            String subtitle = this.f1839y0.getSubtitle();
            int i12 = vVar2.f4949b[3];
            if (i12 != 2 && (i12 != 3 || vVar2.a() != 3)) {
                z10 = false;
            }
            p7.n nVar2 = new p7.n(this, subtitle, this.h0, 3);
            nVar2.f10070a = z10;
            nVar2.b().show();
            return;
        }
        if (this.h0 == null) {
            return;
        }
        int i13 = (this.H0 + 1) % 4;
        this.H0 = i13;
        if (i13 == 0) {
            this.f1823i0.setResizeMode(3);
            AspectRatioFrameLayout aspectRatioFrameLayout = this.I0;
            if (aspectRatioFrameLayout != null) {
                aspectRatioFrameLayout.setAspectRatio(0.0f);
            }
            this.f1836v0.setText("Fill");
        } else if (i13 == 1) {
            this.f1823i0.setResizeMode(0);
            AspectRatioFrameLayout aspectRatioFrameLayout2 = this.I0;
            if (aspectRatioFrameLayout2 != null) {
                aspectRatioFrameLayout2.setAspectRatio(0.0f);
            }
            this.f1836v0.setText("Fit");
        } else if (i13 == 2) {
            this.f1823i0.setResizeMode(0);
            AspectRatioFrameLayout aspectRatioFrameLayout3 = this.I0;
            if (aspectRatioFrameLayout3 != null) {
                aspectRatioFrameLayout3.setAspectRatio(1.7777778f);
            }
            this.f1836v0.setText("16:9");
        } else if (i13 == 3) {
            this.f1823i0.setResizeMode(0);
            AspectRatioFrameLayout aspectRatioFrameLayout4 = this.I0;
            if (aspectRatioFrameLayout4 != null) {
                aspectRatioFrameLayout4.setAspectRatio(1.3333334f);
            }
            this.f1836v0.setText("4:3");
        }
        this.f1836v0.setVisibility(0);
        this.G0.removeCallbacks(this.f1818c0);
        this.f1826l0 = 2;
        v0 v0Var = new v0(this, 1);
        this.f1818c0 = v0Var;
        v0Var.run();
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_series_player);
        k5.j.a(this);
        this.f1824j0 = new app.shamel.tv.helper.r(this);
        this.f1839y0 = app.shamel.tv.helper.a.k(this);
        PlayerView playerView = (PlayerView) findViewById(R.id.player_view);
        this.f1823i0 = playerView;
        this.I0 = (AspectRatioFrameLayout) playerView.findViewById(R.id.exo_content_frame);
        playerView.getSubtitleView().setApplyEmbeddedStyles(false);
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.subtitle_view);
        this.f1831q0 = subtitleView;
        subtitleView.setVisibility(8);
        this.f1823i0.getSubtitleView().setStyle(new u3.c(Color.parseColor(this.f1824j0.D()), Color.parseColor(this.f1824j0.C()), 0, 0, 0, null));
        this.f1823i0.getSubtitleView().a(3, this.f1824j0.F());
        this.f1831q0.setTextSize(3, this.f1824j0.F());
        this.f1831q0.setBackgroundColor(Color.parseColor(this.f1824j0.C()));
        this.f1831q0.setTextColor(Color.parseColor(this.f1824j0.D()));
        this.f1821f0 = (ConstraintLayout) findViewById(R.id.ly_control);
        this.O = (ImageButton) findViewById(R.id.btn_back);
        this.S = (ImageButton) findViewById(R.id.btn_previous);
        this.U = (ImageButton) findViewById(R.id.btn_rewind);
        this.R = (ImageButton) findViewById(R.id.btn_play);
        this.P = (ImageButton) findViewById(R.id.btn_forward);
        this.Q = (ImageButton) findViewById(R.id.btn_next);
        this.V = (ImageButton) findViewById(R.id.btn_sub);
        this.N = (ImageButton) findViewById(R.id.btn_audio);
        this.T = (ImageButton) findViewById(R.id.btn_resolution);
        this.W = (ImageButton) findViewById(R.id.btn_title_setting);
        this.f1836v0 = (TextView) findViewById(R.id.txt_resolution);
        this.f1838x0 = (TextView) findViewById(R.id.txt_start_time);
        this.f1834t0 = (TextView) findViewById(R.id.txt_end_time);
        this.f1835u0 = (TextView) findViewById(R.id.txt_name);
        this.f1837w0 = (TextView) findViewById(R.id.txt_season);
        this.f1820e0 = (ImageView) findViewById(R.id.image_rewind);
        this.f1819d0 = (ImageView) findViewById(R.id.image_forward);
        this.f1825k0 = (RecyclerView) findViewById(R.id.recycler_episodes);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.f1830p0 = seekBar;
        seekBar.setMax(100);
        this.f1830p0.setOnSeekBarChangeListener(this);
        this.O.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.O.setOnFocusChangeListener(this);
        this.U.setOnFocusChangeListener(this);
        this.R.setOnFocusChangeListener(this);
        this.P.setOnFocusChangeListener(this);
        this.V.setOnFocusChangeListener(this);
        this.N.setOnFocusChangeListener(this);
        this.T.setOnFocusChangeListener(this);
        this.W.setOnFocusChangeListener(this);
        this.Q.setOnFocusChangeListener(this);
        this.S.setOnFocusChangeListener(this);
        this.Q.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.Z = getIntent().getIntExtra("position", 0);
        this.f1829o0 = getIntent().getIntExtra("season_pos", 0);
        this.B0 = getIntent().getStringExtra("series_name");
        this.C0 = getIntent().getStringExtra("season_name");
        getIntent().getStringExtra("tmdb_id");
        if (this.f1824j0.g()) {
            a6.n K = a6.n.K();
            String str = this.B0;
            String str2 = this.C0;
            K.getClass();
            RealmQuery V = ((io.realm.u) K.f74p).V(EpisodeModel.class);
            V.c("series_name", str);
            V.c("season_name", str2);
            this.Y = new ArrayList(V.d());
        } else {
            this.Y = this.f1824j0.e();
        }
        this.f1837w0.setText(this.C0);
        new ArrayList();
        f fVar = new f(5, this);
        d5.r rVar = new d5.r(0);
        rVar.f4177i = this;
        rVar.g = -1;
        rVar.f4176h = fVar;
        this.M = rVar;
        List list = this.Y;
        int i10 = this.f1829o0;
        rVar.f4174e = list;
        rVar.f4175f = i10;
        rVar.d();
        this.f1825k0.setLayoutManager(new LinearLayoutManager(0));
        this.f1825k0.setHasFixedSize(true);
        this.f1825k0.setAdapter(this.M);
        this.X = k5.a.i(this, this.f1824j0.k());
        i1.y0 y0Var = new i1.y0();
        y0Var.j(3, true ^ this.f1824j0.E());
        this.f1832r0 = new i1.z0(y0Var);
        y(this.Z);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        if (z10) {
            this.G0.removeCallbacks(this.f1817b0);
            x();
        }
    }

    @Override // f.j, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (l1.a0.f8067a <= 23) {
            PlayerView playerView = this.f1823i0;
            if (playerView != null) {
                playerView.g();
            }
            A();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        if (this.h0 == null || !z10) {
            return;
        }
        seekBar.setProgress(i10);
        long D = (int) ((this.h0.D() * i10) / 100);
        this.h0.l(5, D);
        this.f1838x0.setText(k5.j.n(D));
    }

    @Override // f.j, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (l1.a0.f8067a > 23) {
            PlayerView playerView = this.f1823i0;
            if (playerView != null) {
                playerView.g();
            }
            A();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        if (this.h0 == null || seekBar.getId() != R.id.seekBar) {
            return;
        }
        this.G0.removeCallbacks(this.J0);
        long o2 = k5.j.o(seekBar.getProgress(), this.h0.D());
        this.h0.l(5, o2);
        this.f1838x0.setText(k5.j.n(o2));
    }

    public final boolean u() {
        return this.S.hasFocus() || this.U.hasFocus() || this.R.hasFocus() || this.P.hasFocus() || this.Q.hasFocus();
    }

    public final boolean v() {
        return this.N.hasFocus() || this.V.hasFocus() || this.T.hasFocus() || this.W.hasFocus();
    }

    public final long w(String str) {
        List A = this.f1824j0.A();
        for (int i10 = 0; i10 < A.size(); i10++) {
            if (((ResumeModel) A.get(i10)).getName().equalsIgnoreCase(str)) {
                return ((ResumeModel) A.get(i10)).getLast_position();
            }
        }
        return 0L;
    }

    public final void x() {
        this.f1822g0 = 10;
        g gVar = new g(this, 1);
        this.f1817b0 = gVar;
        gVar.run();
    }

    public final void y(int i10) {
        this.f1830p0.setProgress(0);
        this.f1840z0 = ((EpisodeModel) this.Y.get(i10)).getTitle();
        this.f1828n0 = this.B0 + this.C0 + this.f1840z0;
        this.f1835u0.setText(this.f1840z0);
        if (this.f1824j0.g()) {
            this.A0 = ((EpisodeModel) this.Y.get(i10)).getUrl();
        } else {
            this.A0 = app.shamel.tv.helper.a.f(this.f1824j0.B(), this.f1824j0.I(), this.f1824j0.v(), ((EpisodeModel) this.Y.get(i10)).getId(), ((EpisodeModel) this.Y.get(i10)).getContainer_extension());
        }
        long w10 = w(this.f1828n0);
        this.D0 = w10;
        if (w10 == 0) {
            this.f1821f0.setVisibility(0);
            this.f1825k0.setFocusable(false);
            this.R.requestFocus();
            z(0L, this.A0);
            this.G0.removeCallbacks(this.f1817b0);
            x();
            return;
        }
        this.f1821f0.setVisibility(8);
        D(false);
        androidx.fragment.app.j0 n10 = n();
        n10.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n10);
        androidx.fragment.app.s A = n10.A("fragment_resume");
        if (A != null) {
            android.support.v4.media.d.v(aVar, A, false);
            return;
        }
        h5.u N = h5.u.N(this.f1839y0.getResume(), this.f1839y0.getResume_plyaback_from_ast_position(), this.f1839y0.getStr_yes(), this.f1839y0.getNo());
        this.f1827m0 = N;
        N.B0 = new w0(this, 2);
        N.M(n10, "fragment_resume");
    }

    public final void z(long j10, String str) {
        v0 v0Var = this.J0;
        Handler handler = this.G0;
        try {
            s1.a0 a0Var = this.h0;
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
            i1.a0 a0Var2 = new i1.a0(_UrlKt.FRAGMENT_ENCODE_SET, new i1.u(sVar), parse != null ? new i1.x(parse, p10, null, list, w0Var2, -9223372036854775807L) : null, new i1.w(vVar), new i1.d0(c0Var), yVar);
            b1 b1Var = b1.f5811b;
            f2.r rVar = new f2.r(this);
            this.f1833s0 = rVar;
            rVar.b(this.f1832r0);
            s1.n nVar = new s1.n(this);
            x4.l lVar = new x4.l(18);
            lVar.f13562p = k5.a.n(this, this.f1824j0.k());
            c2.r rVar2 = new c2.r(this);
            rVar2.g(this.X);
            rVar2.h(lVar);
            nVar.b(rVar2);
            nVar.d(this.f1833s0);
            nVar.c(k5.a.e(this, true));
            s1.a0 a10 = nVar.a();
            this.h0 = a10;
            a10.W(this.f1832r0);
            this.h0.f11204m.a(new j(this, 4));
            this.h0.q(new h2.a());
            s1.a0 a0Var3 = this.h0;
            i1.d dVar = i1.d.f5843b;
            a0Var3.S();
            this.h0.U(true);
            this.f1823i0.setPlayer(this.h0);
            this.h0.p(a0Var2);
            this.h0.N();
            this.h0.j();
            if (j10 != 0) {
                this.h0.l(5, j10);
            }
            handler.removeCallbacks(v0Var);
            handler.postDelayed(v0Var, 100L);
        } catch (Exception e7) {
            Log.e("SeriesPlayerActivity", "playVideo", e7);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }
}
