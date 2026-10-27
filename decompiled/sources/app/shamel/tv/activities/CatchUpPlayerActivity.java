package app.shamel.tv.activities;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.PlayerView;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.WordModels;
import com.google.gson.Gson;
import i1.c1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CatchUpPlayerActivity extends f.j implements View.OnClickListener, View.OnFocusChangeListener, SeekBar.OnSeekBarChangeListener {
    public ImageButton M;
    public ImageButton N;
    public ImageButton O;
    public ImageButton P;
    public ImageButton Q;
    public ImageButton R;
    public List S;
    public CatchUpEpg T;
    public o1.g U;
    public h5.u V;
    public g W;
    public ImageView X;
    public ImageView Y;
    public ConstraintLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f1583a0;

    /* renamed from: b0, reason: collision with root package name */
    public s1.a0 f1584b0;

    /* renamed from: c0, reason: collision with root package name */
    public PlayerView f1585c0;

    /* renamed from: d0, reason: collision with root package name */
    public app.shamel.tv.helper.r f1586d0;

    /* renamed from: e0, reason: collision with root package name */
    public SeekBar f1587e0;

    /* renamed from: f0, reason: collision with root package name */
    public i1.z0 f1588f0;

    /* renamed from: g0, reason: collision with root package name */
    public TextView f1589g0;
    public TextView h0;

    /* renamed from: i0, reason: collision with root package name */
    public TextView f1590i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f1591j0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    public final Handler f1592k0 = new Handler(Looper.getMainLooper());

    /* renamed from: l0, reason: collision with root package name */
    public int f1593l0 = 0;

    /* renamed from: m0, reason: collision with root package name */
    public int f1594m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    public String f1595n0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: o0, reason: collision with root package name */
    public String f1596o0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: p0, reason: collision with root package name */
    public WordModels f1597p0 = new WordModels();

    /* renamed from: q0, reason: collision with root package name */
    public final androidx.activity.j f1598q0 = new androidx.activity.j(7, this);

    public final void A() {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_exit");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return;
        }
        h5.u N = h5.u.N(this.f1597p0.getStop_playback(), this.f1597p0.getPlayback_description(), this.f1597p0.getStr_yes(), this.f1597p0.getNo());
        this.V = N;
        N.B0 = new h(this, 0);
        N.M(n10, "fragment_exit");
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 4) {
                if (this.Z.getVisibility() == 0) {
                    this.Z.setVisibility(8);
                    return true;
                }
                A();
                return false;
            }
            if (keyCode != 85) {
                if (keyCode != 89) {
                    if (keyCode != 90) {
                        if (keyCode != 19) {
                            Handler handler = this.f1592k0;
                            if (keyCode != 20) {
                                if (keyCode == 23 && this.Z.getVisibility() == 8) {
                                    this.Z.setVisibility(0);
                                    this.P.requestFocus();
                                    handler.removeCallbacks(this.W);
                                    u();
                                    return true;
                                }
                            } else {
                                if (this.Z.getVisibility() == 8) {
                                    this.Z.setVisibility(0);
                                    this.P.requestFocus();
                                    handler.removeCallbacks(this.W);
                                    u();
                                    return true;
                                }
                                if (this.M.hasFocus()) {
                                    this.f1587e0.requestFocus();
                                    return true;
                                }
                                if (this.f1587e0.hasFocus()) {
                                    this.P.requestFocus();
                                    return true;
                                }
                            }
                        } else {
                            if (this.Q.hasFocus() || this.R.hasFocus() || this.P.hasFocus() || this.N.hasFocus() || this.O.hasFocus()) {
                                this.f1587e0.requestFocus();
                                return true;
                            }
                            if (this.f1587e0.hasFocus()) {
                                this.M.requestFocus();
                                return true;
                            }
                        }
                    }
                    if (this.Z.getVisibility() == 8) {
                        this.X.setVisibility(0);
                        y();
                    }
                }
                if (this.Z.getVisibility() == 8) {
                    this.Y.setVisibility(0);
                    z();
                } else if (this.Q.hasFocus()) {
                    return true;
                }
            } else {
                s1.a0 a0Var = this.f1584b0;
                if (a0Var != null) {
                    if (a0Var.E()) {
                        this.f1584b0.U(false);
                        this.P.setImageResource(R.drawable.ic_play);
                    } else {
                        this.f1584b0.U(true);
                        this.P.setImageResource(R.drawable.ic_pause);
                    }
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
            A();
            return;
        }
        Handler handler = this.f1592k0;
        if (id == R.id.btn_forward) {
            handler.removeCallbacks(this.W);
            u();
            y();
            return;
        }
        if (id == R.id.btn_next) {
            if (this.f1593l0 < this.S.size() - 1) {
                int i10 = this.f1593l0 + 1;
                this.f1593l0 = i10;
                v(i10);
                return;
            }
            return;
        }
        if (id == R.id.btn_play) {
            s1.a0 a0Var = this.f1584b0;
            if (a0Var != null) {
                if (a0Var.E()) {
                    this.f1584b0.U(false);
                    this.P.setImageResource(R.drawable.ic_play);
                    return;
                } else {
                    this.f1584b0.U(true);
                    this.P.setImageResource(R.drawable.ic_pause);
                    return;
                }
            }
            return;
        }
        if (id != R.id.btn_previous) {
            if (id == R.id.btn_rewind) {
                handler.removeCallbacks(this.W);
                u();
                z();
                return;
            }
            return;
        }
        int i11 = this.f1593l0;
        if (i11 > 0) {
            int i12 = i11 - 1;
            this.f1593l0 = i12;
            v(i12);
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        i1.x0 x0Var;
        super.onCreate(bundle);
        setContentView(R.layout.activity_catch_up_player);
        k5.j.a(this);
        this.f1586d0 = new app.shamel.tv.helper.r(this);
        this.f1597p0 = app.shamel.tv.helper.a.k(this);
        PlayerView playerView = (PlayerView) findViewById(R.id.player_view);
        this.f1585c0 = playerView;
        playerView.setResizeMode(3);
        this.Z = (ConstraintLayout) findViewById(R.id.ly_control);
        this.M = (ImageButton) findViewById(R.id.btn_back);
        this.Q = (ImageButton) findViewById(R.id.btn_previous);
        this.R = (ImageButton) findViewById(R.id.btn_rewind);
        this.P = (ImageButton) findViewById(R.id.btn_play);
        this.N = (ImageButton) findViewById(R.id.btn_forward);
        this.O = (ImageButton) findViewById(R.id.btn_next);
        this.h0 = (TextView) findViewById(R.id.txt_name);
        this.f1590i0 = (TextView) findViewById(R.id.txt_start_time);
        this.f1589g0 = (TextView) findViewById(R.id.txt_end_time);
        this.f1587e0 = (SeekBar) findViewById(R.id.seekBar);
        this.X = (ImageView) findViewById(R.id.image_forward);
        this.Y = (ImageView) findViewById(R.id.image_rewind);
        this.f1587e0.setMax(100);
        this.f1587e0.setOnSeekBarChangeListener(this);
        this.R.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.R.setOnFocusChangeListener(this);
        this.P.setOnFocusChangeListener(this);
        this.N.setOnFocusChangeListener(this);
        this.O.setOnFocusChangeListener(this);
        this.Q.setOnFocusChangeListener(this);
        this.M.setOnFocusChangeListener(this);
        this.f1585c0.getVideoSurfaceView().setOnClickListener(new c(this, 2));
        this.U = k5.a.i(this, this.f1586d0.k());
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("track_selection_parameters");
            i1.y0 y0Var = new i1.y0();
            String str = i1.z0.L;
            i1.z0 z0Var = i1.z0.F;
            y0Var.f6073a = bundle2.getInt(str, z0Var.f6111a);
            y0Var.f6074b = bundle2.getInt(i1.z0.M, z0Var.f6112b);
            y0Var.f6075c = bundle2.getInt(i1.z0.N, z0Var.f6113c);
            y0Var.f6076d = bundle2.getInt(i1.z0.O, z0Var.f6114d);
            y0Var.f6077e = bundle2.getInt(i1.z0.P, z0Var.f6115e);
            y0Var.f6078f = bundle2.getInt(i1.z0.Q, z0Var.f6116f);
            y0Var.g = bundle2.getInt(i1.z0.R, z0Var.g);
            y0Var.f6079h = bundle2.getInt(i1.z0.S, z0Var.f6117h);
            y0Var.f6080i = bundle2.getInt(i1.z0.T, z0Var.f6118i);
            int i10 = bundle2.getInt(i1.z0.U, z0Var.f6119j);
            y0Var.f6081j = i10;
            y0Var.f6082k = y0Var.f6080i == Integer.MAX_VALUE && i10 == Integer.MAX_VALUE && bundle2.getBoolean(i1.z0.f6109m0, z0Var.f6120k);
            y0Var.f6083l = bundle2.getBoolean(i1.z0.V, z0Var.f6121l);
            String[] stringArray = bundle2.getStringArray(i1.z0.W);
            String[] strArr = new String[0];
            if (stringArray == null) {
                stringArray = strArr;
            }
            y0Var.f6084m = o9.g0.o(stringArray);
            String[] stringArray2 = bundle2.getStringArray(i1.z0.f6108l0);
            String[] strArr2 = new String[0];
            if (stringArray2 == null) {
                stringArray2 = strArr2;
            }
            y0Var.f6085n = o9.g0.o(stringArray2);
            y0Var.f6086o = bundle2.getInt(i1.z0.f6102e0, z0Var.f6124o);
            String[] stringArray3 = bundle2.getStringArray(i1.z0.G);
            String[] strArr3 = new String[0];
            if (stringArray3 == null) {
                stringArray3 = strArr3;
            }
            y0Var.f6087p = i1.y0.d(stringArray3);
            y0Var.f6088q = bundle2.getInt(i1.z0.H, z0Var.f6126q);
            y0Var.f6089r = bundle2.getInt(i1.z0.X, z0Var.f6127r);
            y0Var.f6090s = bundle2.getInt(i1.z0.Y, z0Var.f6128s);
            String[] stringArray4 = bundle2.getStringArray(i1.z0.Z);
            String[] strArr4 = new String[0];
            if (stringArray4 == null) {
                stringArray4 = strArr4;
            }
            y0Var.f6091t = o9.g0.o(stringArray4);
            Bundle bundle3 = bundle2.getBundle(i1.z0.f6106j0);
            if (bundle3 != null) {
                i1.w0 w0Var = new i1.w0();
                String str2 = i1.x0.f6067e;
                i1.x0 x0Var2 = i1.x0.f6066d;
                w0Var.f6058a = bundle3.getInt(str2, x0Var2.f6069a);
                w0Var.f6059b = bundle3.getBoolean(i1.x0.f6068f, x0Var2.f6070b);
                w0Var.f6060c = bundle3.getBoolean(i1.x0.g, x0Var2.f6071c);
                x0Var = new i1.x0(w0Var);
            } else {
                i1.w0 w0Var2 = new i1.w0();
                String str3 = i1.z0.f6104g0;
                i1.x0 x0Var3 = i1.x0.f6066d;
                w0Var2.f6058a = bundle2.getInt(str3, x0Var3.f6069a);
                w0Var2.f6059b = bundle2.getBoolean(i1.z0.h0, x0Var3.f6070b);
                w0Var2.f6060c = bundle2.getBoolean(i1.z0.f6105i0, x0Var3.f6071c);
                x0Var = new i1.x0(w0Var2);
            }
            y0Var.f6092u = x0Var;
            String[] stringArray5 = bundle2.getStringArray(i1.z0.I);
            String[] strArr5 = new String[0];
            if (stringArray5 == null) {
                stringArray5 = strArr5;
            }
            y0Var.f6093v = i1.y0.d(stringArray5);
            y0Var.f6094w = bundle2.getInt(i1.z0.J, z0Var.f6132w);
            y0Var.f6095x = y0Var.f6093v.isEmpty() && y0Var.f6094w == 0 && bundle2.getBoolean(i1.z0.f6110n0, z0Var.f6133x);
            y0Var.f6096y = bundle2.getInt(i1.z0.f6103f0, z0Var.f6134y);
            y0Var.f6097z = bundle2.getBoolean(i1.z0.K, z0Var.f6135z);
            y0Var.A = bundle2.getBoolean(i1.z0.f6107k0, z0Var.A);
            y0Var.B = bundle2.getBoolean(i1.z0.f6098a0, z0Var.B);
            y0Var.C = bundle2.getBoolean(i1.z0.f6099b0, z0Var.C);
            ArrayList parcelableArrayList = bundle2.getParcelableArrayList(i1.z0.f6100c0);
            o9.w0 j10 = parcelableArrayList == null ? o9.w0.f9686s : l1.d.j(new h3.b(3), parcelableArrayList);
            y0Var.D = new HashMap();
            for (int i11 = 0; i11 < j10.f9688r; i11++) {
                i1.v0 v0Var = (i1.v0) j10.get(i11);
                y0Var.D.put(v0Var.f6051a, v0Var);
            }
            int[] intArray = bundle2.getIntArray(i1.z0.f6101d0);
            int[] iArr = new int[0];
            if (intArray == null) {
                intArray = iArr;
            }
            y0Var.E = new HashSet();
            for (int i12 : intArray) {
                y0Var.E.add(Integer.valueOf(i12));
            }
            this.f1588f0 = new i1.z0(y0Var);
        } else {
            this.f1588f0 = new i1.z0(new i1.y0());
        }
        this.f1593l0 = getIntent().getIntExtra("position", 0);
        this.f1596o0 = getIntent().getStringExtra("stream_id");
        this.S = (List) new Gson().fromJson(getIntent().getStringExtra("epg_model"), new i().getType());
        v(this.f1593l0);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        if (z10) {
            this.f1592k0.removeCallbacks(this.W);
            u();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        if (this.f1584b0 == null || !z10) {
            return;
        }
        this.f1592k0.removeCallbacks(this.f1598q0);
        seekBar.setProgress(i10);
        long D = (int) ((this.f1584b0.D() * i10) / 100);
        this.f1584b0.l(5, D);
        this.f1590i0.setText(k5.j.n(D));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        if (this.f1584b0 == null || seekBar.getId() != R.id.seekBar) {
            return;
        }
        this.f1592k0.removeCallbacks(this.f1598q0);
        long o2 = k5.j.o(seekBar.getProgress(), this.f1584b0.D());
        this.f1584b0.l(5, o2);
        this.f1590i0.setText(k5.j.n(o2));
    }

    public final void u() {
        this.f1583a0 = 10;
        g gVar = new g(this, 0);
        this.W = gVar;
        gVar.run();
    }

    public final void v(int i10) {
        CatchUpEpg catchUpEpg = (CatchUpEpg) this.S.get(i10);
        this.T = catchUpEpg;
        this.h0.setText(k5.j.e(catchUpEpg.getTitle()));
        this.f1595n0 = this.T.getUrl(this.f1586d0.B(), this.f1586d0.I(), this.f1586d0.v(), this.f1596o0);
        x();
        this.Z.setVisibility(0);
        w(this.f1595n0);
        u();
    }

    public final void w(String str) {
        s1.a0 a0Var = this.f1584b0;
        if (a0Var != null) {
            a0Var.O();
        }
        i1.s sVar = new i1.s();
        new c1();
        List list = Collections.EMPTY_LIST;
        o9.w0 w0Var = o9.w0.f9686s;
        i1.v vVar = new i1.v();
        i1.y yVar = i1.y.f6072a;
        Uri parse = str == null ? null : Uri.parse(str);
        i1.c0 c0Var = new i1.c0();
        c0Var.f5817a = "title";
        i1.a0 a0Var2 = new i1.a0(_UrlKt.FRAGMENT_ENCODE_SET, new i1.u(sVar), parse != null ? new i1.x(parse, null, null, list, w0Var, -9223372036854775807L) : null, new i1.w(vVar), new i1.d0(c0Var), yVar);
        s1.n nVar = new s1.n(this);
        x4.l lVar = new x4.l(18);
        lVar.f13562p = k5.a.n(this, this.f1586d0.k());
        c2.r rVar = new c2.r(this);
        rVar.g(this.U);
        rVar.h(lVar);
        nVar.b(rVar);
        nVar.c(k5.a.e(this, false));
        s1.a0 a10 = nVar.a();
        this.f1584b0 = a10;
        a10.W(this.f1588f0);
        this.f1584b0.f11204m.a(new j(this, 0));
        this.f1584b0.q(new h2.a());
        s1.a0 a0Var3 = this.f1584b0;
        i1.d dVar = i1.d.f5843b;
        a0Var3.S();
        this.f1584b0.U(true);
        this.f1585c0.setPlayer(this.f1584b0);
        this.f1584b0.p(a0Var2);
        this.f1584b0.N();
        this.f1584b0.j();
        Handler handler = this.f1592k0;
        androidx.activity.j jVar = this.f1598q0;
        handler.removeCallbacks(jVar);
        handler.postDelayed(jVar, 100L);
    }

    public final void x() {
        s1.a0 a0Var = this.f1584b0;
        if (a0Var == null) {
            return;
        }
        a0Var.Z();
        this.f1584b0.O();
        this.f1584b0 = null;
        this.f1585c0.setPlayer(null);
    }

    public final void y() {
        s1.a0 a0Var = this.f1584b0;
        if (a0Var != null) {
            long y8 = a0Var.y();
            long D = this.f1584b0.D();
            int i10 = this.f1591j0 + 30;
            this.f1591j0 = i10;
            long j10 = i10 * 1000;
            if (D < j10) {
                this.f1584b0.l(5, D - 30);
            } else {
                this.f1584b0.l(5, j10 + y8);
            }
            this.f1591j0 = 0;
            Handler handler = this.f1592k0;
            androidx.activity.j jVar = this.f1598q0;
            handler.removeCallbacks(jVar);
            handler.postDelayed(jVar, 100L);
        }
    }

    public final void z() {
        s1.a0 a0Var = this.f1584b0;
        if (a0Var != null) {
            long y8 = a0Var.y();
            int i10 = this.f1591j0 + 30;
            this.f1591j0 = i10;
            long j10 = i10 * 1000;
            if (y8 < j10) {
                this.f1584b0.l(5, 1L);
            } else {
                this.f1584b0.l(5, y8 - j10);
            }
            this.f1591j0 = 0;
            Handler handler = this.f1592k0;
            androidx.activity.j jVar = this.f1598q0;
            handler.removeCallbacks(jVar);
            handler.postDelayed(jVar, 100L);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }
}
