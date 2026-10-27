package app.shamel.tv.activities;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class LiveActivity extends f.j implements View.OnFocusChangeListener, View.OnClickListener {

    /* renamed from: p1, reason: collision with root package name */
    public static final /* synthetic */ int f1645p1 = 0;
    public RecyclerView A0;
    public SeekBar B0;
    public EPGChannel C0;
    public i1.z0 D0;
    public f2.r E0;
    public TextView F0;
    public TextView G0;
    public TextView H0;
    public TextView I0;
    public TextView J0;
    public TextView K0;
    public TextView L0;
    public Button M;
    public TextView M0;
    public Button N;
    public TextView N0;
    public Button O;
    public TextView O0;
    public d5.n0 P;
    public TextView P0;
    public List Q;
    public TextView Q0;
    public d5.e R;
    public TextView R0;
    public ImageView S;
    public TextView S0;
    public String T;
    public TextView T0;
    public String U;
    public TextView U0;
    public o1.g V;
    public TextView V0;
    public d5.m W;
    public TextView W0;
    public io.realm.n0 X;
    public TextView X0;
    public List Y;
    public TextView Y0;
    public y Z;
    public TextView Z0;

    /* renamed from: a0, reason: collision with root package name */
    public int f1646a0;

    /* renamed from: a1, reason: collision with root package name */
    public TextView f1647a1;

    /* renamed from: b0, reason: collision with root package name */
    public EditText f1648b0;

    /* renamed from: b1, reason: collision with root package name */
    public WordModels f1649b1;

    /* renamed from: c0, reason: collision with root package name */
    public z f1650c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f1652d0;

    /* renamed from: e0, reason: collision with root package name */
    public ImageButton f1654e0;

    /* renamed from: f0, reason: collision with root package name */
    public ImageView f1656f0;

    /* renamed from: g0, reason: collision with root package name */
    public ImageButton f1658g0;
    public ImageButton h0;

    /* renamed from: i0, reason: collision with root package name */
    public ImageButton f1660i0;

    /* renamed from: j0, reason: collision with root package name */
    public ImageButton f1662j0;

    /* renamed from: k0, reason: collision with root package name */
    public ImageButton f1664k0;

    /* renamed from: l0, reason: collision with root package name */
    public ImageButton f1666l0;

    /* renamed from: m0, reason: collision with root package name */
    public ImageButton f1668m0;

    /* renamed from: n0, reason: collision with root package name */
    public EPGChannel f1670n0;

    /* renamed from: o0, reason: collision with root package name */
    public ConstraintLayout f1672o0;

    /* renamed from: p0, reason: collision with root package name */
    public ConstraintLayout f1674p0;

    /* renamed from: q0, reason: collision with root package name */
    public ConstraintLayout f1675q0;

    /* renamed from: r0, reason: collision with root package name */
    public ConstraintLayout f1676r0;

    /* renamed from: s0, reason: collision with root package name */
    public ConstraintLayout f1677s0;

    /* renamed from: t0, reason: collision with root package name */
    public z f1678t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f1679u0;

    /* renamed from: v0, reason: collision with root package name */
    public s1.a0 f1680v0;

    /* renamed from: w0, reason: collision with root package name */
    public PlayerView f1681w0;

    /* renamed from: x0, reason: collision with root package name */
    public app.shamel.tv.helper.r f1682x0;

    /* renamed from: y0, reason: collision with root package name */
    public LiveVerticalGridView f1683y0;

    /* renamed from: z0, reason: collision with root package name */
    public LiveVerticalGridView f1684z0;

    /* renamed from: c1, reason: collision with root package name */
    public int f1651c1 = 0;

    /* renamed from: d1, reason: collision with root package name */
    public int f1653d1 = 0;

    /* renamed from: e1, reason: collision with root package name */
    public int f1655e1 = 0;

    /* renamed from: f1, reason: collision with root package name */
    public int f1657f1 = 0;

    /* renamed from: g1, reason: collision with root package name */
    public int f1659g1 = 0;
    public int h1 = 0;

    /* renamed from: i1, reason: collision with root package name */
    public String f1661i1 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: j1, reason: collision with root package name */
    public String f1663j1 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: k1, reason: collision with root package name */
    public boolean f1665k1 = false;

    /* renamed from: l1, reason: collision with root package name */
    public final Handler f1667l1 = new Handler(Looper.getMainLooper());

    /* renamed from: m1, reason: collision with root package name */
    public String f1669m1 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: o1, reason: collision with root package name */
    public int f1673o1 = 2;

    /* renamed from: n1, reason: collision with root package name */
    public final androidx.activity.result.c f1671n1 = l(new androidx.fragment.app.e0(2), new w(this));

    public static void u(LiveActivity liveActivity, int i10) {
        androidx.fragment.app.j0 n10 = liveActivity.n();
        androidx.fragment.app.a i11 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_lock");
        if (A != null) {
            android.support.v4.media.d.v(i11, A, false);
            return;
        }
        h5.h0 N = h5.h0.N(liveActivity.f1682x0.u());
        N.f5607z0 = new app.shamel.tv.b(i10, 1, liveActivity);
        N.M(n10, "fragment_lock");
    }

    public final void A(String str) {
        try {
            j5.f.a(this.f1682x0.B()).get_short_epg(this.f1682x0.I(), this.f1682x0.v(), str).enqueue(new w(this));
        } catch (Exception unused) {
            R(null);
        }
    }

    public final void B() {
        J();
        startActivity(new Intent(this, (Class<?>) SeriesActivity.class));
        if (((CategoryModel) this.Q.get(this.f1651c1)).getId().equalsIgnoreCase("resume_id") && this.C0 != null) {
            K();
        }
        finish();
    }

    public final void C() {
        J();
        startActivity(new Intent(this, (Class<?>) MovieActivity.class));
        if (((CategoryModel) this.Q.get(this.f1651c1)).getId().equalsIgnoreCase("resume_id") && this.C0 != null) {
            K();
        }
        finish();
    }

    public final boolean D(String str, String str2) {
        return this.f1682x0.g() ? str2.contains("adult") || str2.contains("xxx") || str2.contains("porn") : e5.l.f4606a.contains(str);
    }

    public final void E() {
        this.f1652d0 = 10;
        z zVar = new z(this, 0);
        this.f1650c0 = zVar;
        zVar.run();
    }

    public final void F() {
        if (this.f1653d1 < this.X.size() - 1) {
            this.f1653d1++;
        } else {
            this.f1653d1 = 0;
        }
        if (((CategoryModel) this.Q.get(this.f1651c1)).getId().equalsIgnoreCase("all_id") && D(((EPGChannel) this.X.get(this.f1653d1)).getCategory_id(), ((EPGChannel) this.X.get(this.f1653d1)).getCategory_name())) {
            Q((EPGChannel) this.X.get(this.f1653d1), this.f1653d1, 1);
            return;
        }
        if (!e5.l.f4606a.contains(((CategoryModel) this.Q.get(this.f1651c1)).getId()) && !((CategoryModel) this.Q.get(this.f1651c1)).getId().equalsIgnoreCase("lock_id") && ((EPGChannel) this.X.get(this.f1653d1)).is_locked()) {
            Q((EPGChannel) this.X.get(this.f1653d1), this.f1653d1, 1);
            return;
        }
        H((EPGChannel) this.X.get(this.f1653d1));
        boolean g = this.f1682x0.g();
        Handler handler = this.f1667l1;
        if (g) {
            R(null);
        } else {
            handler.removeCallbacks(this.Z);
            y(this.f1661i1);
        }
        v(this.f1653d1);
        if (this.f1675q0.getVisibility() == 8) {
            this.f1675q0.setVisibility(0);
        }
        handler.removeCallbacks(this.f1650c0);
        E();
        this.S0.setText(this.T);
        this.f1684z0.setSelectedPosition(this.f1653d1);
    }

    public final void G() {
        int i10 = this.f1653d1;
        if (i10 > 0) {
            this.f1653d1 = i10 - 1;
        } else {
            this.f1653d1 = this.X.size() - 1;
        }
        if (((CategoryModel) this.Q.get(this.f1651c1)).getId().equalsIgnoreCase("all_id") && D(((EPGChannel) this.X.get(this.f1653d1)).getCategory_id(), ((EPGChannel) this.X.get(this.f1653d1)).getCategory_name())) {
            Q((EPGChannel) this.X.get(this.f1653d1), this.f1653d1, 1);
            return;
        }
        if (!e5.l.f4606a.contains(((CategoryModel) this.Q.get(this.f1651c1)).getId()) && !((CategoryModel) this.Q.get(this.f1651c1)).getId().equalsIgnoreCase("lock_id") && ((EPGChannel) this.X.get(this.f1653d1)).is_locked()) {
            Q((EPGChannel) this.X.get(this.f1653d1), this.f1653d1, 1);
            return;
        }
        H((EPGChannel) this.X.get(this.f1653d1));
        boolean g = this.f1682x0.g();
        Handler handler = this.f1667l1;
        if (g) {
            R(null);
        } else {
            handler.removeCallbacks(this.Z);
            y(this.f1661i1);
        }
        v(this.f1653d1);
        this.S0.setText(this.T);
        if (this.f1675q0.getVisibility() == 8) {
            this.f1675q0.setVisibility(0);
        }
        handler.removeCallbacks(this.f1650c0);
        E();
        this.f1684z0.setSelectedPosition(this.f1653d1);
    }

    public final void H(EPGChannel ePGChannel) {
        if (ePGChannel != null) {
            this.f1682x0.M(this.f1651c1);
            this.f1682x0.N(this.f1653d1);
            this.C0 = ePGChannel;
            this.f1661i1 = ePGChannel.getStream_id();
            this.T = this.C0.getName();
            S(this.C0.is_favorite());
            T(ePGChannel.is_locked());
            if (this.f1682x0.g()) {
                this.U = this.C0.getUrl();
            } else {
                this.U = app.shamel.tv.helper.a.g(this.f1682x0.B(), this.f1682x0.I(), this.f1682x0.v(), this.f1661i1, this.f1682x0.p());
            }
            if (e5.l.f4606a.contains(((CategoryModel) this.Q.get(this.f1651c1)).getId()) || D(this.C0.getCategory_id(), this.C0.getCategory_name())) {
                T(true);
            } else {
                a6.n.K().l(this.C0.getName(), true, new w(this));
            }
            this.P.e(1);
            J();
            I(this.U);
        }
    }

    public final void I(String str) {
        s1.a0 a0Var = this.f1680v0;
        if (a0Var != null) {
            a0Var.O();
        }
        if (this.f1656f0.getVisibility() == 0) {
            this.f1656f0.setVisibility(8);
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
        f2.r rVar = new f2.r(this);
        this.E0 = rVar;
        rVar.b(this.D0);
        s1.n nVar = new s1.n(this);
        x4.l lVar = new x4.l(18);
        lVar.f13562p = k5.a.n(this, this.f1682x0.k());
        c2.r rVar2 = new c2.r(this);
        rVar2.g(this.V);
        rVar2.h(lVar);
        nVar.b(rVar2);
        nVar.d(this.E0);
        nVar.c(k5.a.e(this, true));
        s1.a0 a10 = nVar.a();
        this.f1680v0 = a10;
        a10.W(this.D0);
        this.f1680v0.q(new u(0));
        this.f1680v0.f11204m.a(new j(this, 1));
        this.f1680v0.q(new h2.a());
        s1.a0 a0Var3 = this.f1680v0;
        i1.d dVar = i1.d.f5843b;
        a0Var3.S();
        this.f1680v0.U(true);
        this.f1681w0.setPlayer(this.f1680v0);
        this.f1680v0.p(a0Var2);
        this.f1680v0.N();
        this.f1680v0.j();
    }

    public final void J() {
        s1.a0 a0Var = this.f1680v0;
        if (a0Var == null) {
            return;
        }
        a0Var.Z();
        this.f1680v0.O();
        this.f1680v0 = null;
        this.f1681w0.setPlayer(null);
    }

    public final void K() {
        int i10;
        int i11 = 0;
        if (this.f1682x0.g()) {
            String category_name = this.C0.getCategory_name();
            i10 = 0;
            while (true) {
                if (i10 >= this.Q.size()) {
                    i10 = 0;
                    break;
                } else if (((CategoryModel) this.Q.get(i10)).getName().equalsIgnoreCase(category_name)) {
                    break;
                } else {
                    i10++;
                }
            }
        } else {
            String category_id = this.C0.getCategory_id();
            i10 = 0;
            for (int i12 = 0; i12 < this.Q.size(); i12++) {
                if (((CategoryModel) this.Q.get(i12)).getId().equalsIgnoreCase(category_id)) {
                    i10 = i12;
                }
            }
        }
        io.realm.n0 w10 = a6.n.K().w((CategoryModel) this.Q.get(i10), _UrlKt.FRAGMENT_ENCODE_SET, this.f1682x0.g(), this.f1682x0.o());
        int i13 = 0;
        while (true) {
            if (i13 >= w10.size()) {
                break;
            }
            if (this.C0.getName().equalsIgnoreCase(((EPGChannel) w10.get(i13)).getName())) {
                i11 = i13;
                break;
            }
            i13++;
        }
        this.f1682x0.M(i10);
        this.f1682x0.N(i11);
    }

    public final void L(List list) {
        if (list == null || list.size() <= 0) {
            this.J0.setText(this.f1649b1.getNo_information());
            this.I0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.B0.setProgress(0);
            this.U0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.T0.setText(this.f1649b1.getNo_information());
            return;
        }
        this.I0.setText(k5.j.e(((CatchUpEpg) list.get(0)).getTitle()));
        this.J0.setText(k5.j.h(k5.j.i(((CatchUpEpg) list.get(0)).getStart()).getTime() + LTVApp.f2083r, app.shamel.tv.helper.a.b(this)));
        this.B0.setProgress(((CatchUpEpg) list.get(0)).getProgress());
        if (list.size() <= 1) {
            this.U0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.T0.setText(this.f1649b1.getNo_information());
        } else {
            this.T0.setText(k5.j.e(((CatchUpEpg) list.get(1)).getTitle()));
            this.U0.setText(k5.j.h(k5.j.i(((CatchUpEpg) list.get(1)).getStart()).getTime() + LTVApp.f2083r, app.shamel.tv.helper.a.b(this)));
        }
    }

    public final void M(boolean z10) {
        this.M.setFocusable(z10);
        this.N.setFocusable(z10);
        this.O.setFocusable(z10);
    }

    public final void N(boolean z10) {
        this.N0.setFocusable(z10);
        this.P0.setFocusable(z10);
        this.R0.setFocusable(z10);
        this.Y0.setFocusable(z10);
        this.f1648b0.setFocusable(z10);
    }

    public final void O() {
        boolean z10 = this.f1665k1;
        Handler handler = this.f1667l1;
        if (z10) {
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.O.setVisibility(8);
            this.f1684z0.setVisibility(8);
            this.f1683y0.setVisibility(8);
            ConstraintLayout constraintLayout = this.f1676r0;
            if (constraintLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) constraintLayout.getLayoutParams()).setMargins(0, 0, 0, 0);
                constraintLayout.requestLayout();
            }
            if (this.f1675q0.getVisibility() == 8) {
                this.f1675q0.setVisibility(0);
            }
            handler.removeCallbacks(this.f1650c0);
            E();
        } else {
            ConstraintLayout constraintLayout2 = this.f1676r0;
            if (constraintLayout2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) constraintLayout2.getLayoutParams()).setMargins(0, 0, 0, 0);
                constraintLayout2.requestLayout();
            }
            this.M.setVisibility(0);
            this.N.setVisibility(0);
            this.O.setVisibility(0);
            handler.removeCallbacks(this.f1650c0);
            this.f1675q0.setVisibility(8);
            P(false);
            this.f1673o1 = 2;
            this.f1684z0.setVisibility(0);
            this.f1683y0.setVisibility(0);
            this.R.p(this.f1653d1);
            this.f1684z0.requestFocus();
        }
        x.m mVar = new x.m();
        mVar.c(this.f1677s0);
        if (this.f1665k1) {
            mVar.l(R.id.vertical_line1, -0.23f);
            mVar.l(R.id.vertical_line2, 0.0f);
            mVar.l(R.id.horizontal_line1, 0.0f);
            mVar.l(R.id.horizontal_line2, 1.0f);
        } else {
            mVar.l(R.id.vertical_line1, 0.23f);
            mVar.l(R.id.vertical_line2, 0.5f);
            mVar.l(R.id.horizontal_line1, 0.1f);
            mVar.l(R.id.horizontal_line2, 0.6f);
        }
        mVar.a(this.f1677s0);
    }

    public final void P(boolean z10) {
        if (!z10) {
            this.f1674p0.setVisibility(8);
            this.f1672o0.setVisibility(0);
        } else {
            this.f1674p0.setVisibility(0);
            this.f1672o0.setVisibility(8);
            this.f1658g0.requestFocus();
        }
    }

    public final void Q(EPGChannel ePGChannel, int i10, int i11) {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i12 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_channel_lock");
        if (A != null) {
            android.support.v4.media.d.v(i12, A, false);
            return;
        }
        h5.h0 N = h5.h0.N(this.f1682x0.u());
        N.f5607z0 = new v(this, i11, i10, ePGChannel, 0);
        N.M(n10, "fragment_channel_lock");
    }

    public final void R(List list) {
        if (list == null || list.isEmpty()) {
            this.W.l(new ArrayList());
            L(new ArrayList());
        } else {
            this.W.l(list);
            L(list);
        }
    }

    public final void S(boolean z10) {
        if (z10) {
            this.N.setText(this.f1649b1.getRemove_favorites());
        } else {
            this.N.setText(this.f1649b1.getAdd_to_favorite());
        }
    }

    public final void T(boolean z10) {
        if (z10) {
            this.f1660i0.setImageResource(R.drawable.ic_locked);
        } else {
            this.f1660i0.setImageResource(R.drawable.ic_lock);
        }
    }

    public final void U() {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_search");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return;
        }
        h5.c0 N = h5.c0.N(this, (CategoryModel) this.Q.get(this.f1651c1), this.f1651c1, this.f1682x0.g());
        N.B0 = new w(this);
        N.M(n10, "fragment_search");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01a7, code lost:
    
        if (r7.f1654e0.hasFocus() != false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01cf, code lost:
    
        if (r7.f1658g0.hasFocus() != false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01ff, code lost:
    
        if (r0 == 3) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0296, code lost:
    
        if (r7.O.hasFocus() == false) goto L185;
     */
    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r8) {
        /*
            Method dump skipped, instructions count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.LiveActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EPGChannel ePGChannel;
        int id = view.getId();
        androidx.activity.result.c cVar = this.f1671n1;
        boolean z10 = false;
        if (id == R.id.btn_catch_up || id == R.id.image_epg) {
            if (this.f1682x0.g()) {
                Toast.makeText(this, this.f1649b1.getNo_epg_avaliable(), 0).show();
                return;
            } else {
                if (this.C0 != null) {
                    J();
                    LTVApp.f2084s = this.C0.getName();
                    cVar.z(new Intent(this, (Class<?>) CatchUpActivity.class));
                    return;
                }
                return;
            }
        }
        if (id == R.id.btn_fav) {
            if (this.X.size() <= 0 || (ePGChannel = (EPGChannel) this.X.get(this.f1657f1)) == null) {
                return;
            }
            w(ePGChannel, this.f1657f1);
            S(!ePGChannel.is_favorite());
            if (ePGChannel.is_favorite()) {
                Toast.makeText(this, this.f1649b1.getChannel_removed_from_fav(), 0).show();
                return;
            } else {
                Toast.makeText(this, this.f1649b1.getChannel_added_to_fav(), 0).show();
                return;
            }
        }
        if (id == R.id.btn_search) {
            J();
            Intent intent = new Intent(this, (Class<?>) SearchActivity.class);
            intent.putExtra("is_live", true);
            cVar.z(intent);
            return;
        }
        if (id == R.id.image_audio) {
            f2.r rVar = this.E0;
            if (rVar == null) {
                return;
            }
            f2.v vVar = rVar.f4956c;
            if (vVar == null) {
                Toast.makeText(getApplicationContext(), this.f1649b1.getNo_audio(), 1).show();
                return;
            }
            String audio_track = this.f1649b1.getAudio_track();
            int i10 = vVar.f4949b[1];
            if (i10 == 2 || (i10 == 1 && vVar.a() == 0)) {
                z10 = true;
            }
            p7.n nVar = new p7.n(this, audio_track, this.f1680v0, 1);
            nVar.f10070a = z10;
            nVar.b().show();
            return;
        }
        if (id == R.id.image_fav) {
            EPGChannel ePGChannel2 = this.C0;
            if (ePGChannel2 != null) {
                w(ePGChannel2, this.f1653d1);
                S(!this.C0.is_favorite());
                if (this.C0.is_favorite()) {
                    Toast.makeText(this, this.f1649b1.getChannel_removed_from_fav(), 0).show();
                    return;
                } else {
                    Toast.makeText(this, this.f1649b1.getChannel_added_to_fav(), 0).show();
                    return;
                }
            }
            return;
        }
        if (id == R.id.image_lock) {
            EPGChannel ePGChannel3 = this.C0;
            if (ePGChannel3 != null) {
                if (D(ePGChannel3.getCategory_id(), this.C0.getCategory_name())) {
                    Toast.makeText(this, this.f1649b1.getChannel_locked_default(), 0).show();
                    return;
                }
                if (this.C0.is_locked()) {
                    Q(this.C0, this.f1653d1, 4);
                    return;
                }
                x(this.C0, this.f1653d1);
                T(!this.C0.is_locked());
                if (this.C0.is_locked()) {
                    Toast.makeText(this, this.f1649b1.getChannel_unlocked(), 0).show();
                    return;
                } else {
                    Toast.makeText(this, this.f1649b1.getChannel_locked(), 0).show();
                    return;
                }
            }
            return;
        }
        if (id == R.id.image_search) {
            this.f1675q0.setVisibility(8);
            this.f1673o1 = 2;
            P(false);
            U();
            return;
        }
        if (id == R.id.image_series || id == R.id.txt_series) {
            B();
            return;
        }
        if (id != R.id.image_subtitle) {
            if (id == R.id.image_vod || id == R.id.txt_movie) {
                C();
                return;
            }
            if (id == R.id.txt_home) {
                J();
                if (((CategoryModel) this.Q.get(this.f1651c1)).getId().equalsIgnoreCase("resume_id") && this.C0 != null) {
                    K();
                }
                finish();
                return;
            }
            return;
        }
        f2.r rVar2 = this.E0;
        if (rVar2 == null) {
            return;
        }
        f2.v vVar2 = rVar2.f4956c;
        if (vVar2 == null) {
            Toast.makeText(getApplicationContext(), this.f1649b1.getNo_subtitle(), 0).show();
            return;
        }
        String subtitle = this.f1649b1.getSubtitle();
        int i11 = vVar2.f4949b[3];
        if (i11 == 2 || (i11 == 3 && vVar2.a() == 0)) {
            z10 = true;
        }
        p7.n nVar2 = new p7.n(this, subtitle, this.f1680v0, 3);
        nVar2.f10070a = z10;
        nVar2.b().show();
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_live);
        k5.j.a(this);
        this.f1682x0 = new app.shamel.tv.helper.r(this);
        this.f1649b1 = app.shamel.tv.helper.a.k(this);
        this.f1677s0 = (ConstraintLayout) findViewById(R.id.fullContainer);
        PlayerView playerView = (PlayerView) findViewById(R.id.player_view);
        this.f1681w0 = playerView;
        playerView.setResizeMode(4);
        int i10 = 0;
        this.f1681w0.getSubtitleView().setApplyEmbeddedStyles(false);
        u3.c cVar = new u3.c(Color.parseColor(this.f1682x0.D()), Color.parseColor(this.f1682x0.C()), 0, 0, 0, null);
        this.f1681w0.getSubtitleView().a(3, this.f1682x0.F());
        this.f1681w0.getSubtitleView().setStyle(cVar);
        this.V0 = (TextView) findViewById(R.id.txt_num);
        this.N0 = (TextView) findViewById(R.id.txt_home);
        this.P0 = (TextView) findViewById(R.id.txt_live);
        this.R0 = (TextView) findViewById(R.id.txt_movie);
        this.Y0 = (TextView) findViewById(R.id.txt_series);
        this.S0 = (TextView) findViewById(R.id.txt_name);
        this.f1648b0 = (EditText) findViewById(R.id.et_search);
        this.f1683y0 = (LiveVerticalGridView) findViewById(R.id.recycler_category);
        this.f1684z0 = (LiveVerticalGridView) findViewById(R.id.recycler_channel);
        this.f1676r0 = (ConstraintLayout) findViewById(R.id.ly_surface);
        this.A0 = (RecyclerView) findViewById(R.id.recycler_epg);
        this.N = (Button) findViewById(R.id.btn_fav);
        this.M = (Button) findViewById(R.id.btn_catch_up);
        this.O = (Button) findViewById(R.id.btn_search);
        this.O0 = (TextView) findViewById(R.id.txt_left);
        this.W0 = (TextView) findViewById(R.id.txt_right);
        this.F0 = (TextView) findViewById(R.id.txt_audio);
        this.K0 = (TextView) findViewById(R.id.txt_epg);
        this.f1647a1 = (TextView) findViewById(R.id.txt_vod);
        this.X0 = (TextView) findViewById(R.id.txt_search);
        this.G0 = (TextView) findViewById(R.id.txt_bottom_series);
        this.L0 = (TextView) findViewById(R.id.txt_fav);
        this.Z0 = (TextView) findViewById(R.id.txt_subtitle);
        this.Q0 = (TextView) findViewById(R.id.txt_lock);
        this.O0.setText(this.f1649b1.getPrevious_channel());
        this.W0.setText(this.f1649b1.getNext_channel());
        this.N0.setText(this.f1649b1.getHome());
        this.P0.setText(this.f1649b1.getLive_tv());
        this.R0.setText(this.f1649b1.getMovies());
        this.Y0.setText(this.f1649b1.getSeries());
        this.F0.setText(this.f1649b1.getAudio_track());
        this.M.setText(this.f1649b1.getCatch_up());
        this.O.setText(this.f1649b1.getSearch());
        this.N.setText(this.f1649b1.getAdd_to_favorite());
        this.K0.setText(this.f1649b1.getEpg());
        this.f1647a1.setText(this.f1649b1.getMovies());
        this.X0.setText(this.f1649b1.getSearch());
        this.G0.setText(this.f1649b1.getSeries());
        this.L0.setText(this.f1649b1.getFavorite());
        this.Z0.setText(this.f1649b1.getSubtitle());
        this.Q0.setText(this.f1649b1.getLock());
        int i11 = 1;
        this.f1683y0.setNumColumns(1);
        this.f1683y0.setLoop(false);
        this.f1683y0.setPreserveFocusAfterLayout(true);
        this.f1683y0.setOnChildViewHolderSelectedListener(new e(6, new View[]{null}));
        this.f1684z0.setNumColumns(1);
        this.f1684z0.setLoop(false);
        this.f1684z0.setPreserveFocusAfterLayout(true);
        this.f1684z0.setOnChildViewHolderSelectedListener(new e(7, new View[]{null}));
        this.f1675q0 = (ConstraintLayout) findViewById(R.id.ly_control);
        this.f1674p0 = (ConstraintLayout) findViewById(R.id.ly_buttons);
        this.f1672o0 = (ConstraintLayout) findViewById(R.id.ly_actions);
        this.f1658g0 = (ImageButton) findViewById(R.id.image_epg);
        this.f1660i0 = (ImageButton) findViewById(R.id.image_lock);
        this.f1668m0 = (ImageButton) findViewById(R.id.image_vod);
        this.f1664k0 = (ImageButton) findViewById(R.id.image_series);
        this.f1666l0 = (ImageButton) findViewById(R.id.image_subtitle);
        this.f1654e0 = (ImageButton) findViewById(R.id.image_audio);
        this.h0 = (ImageButton) findViewById(R.id.image_fav);
        this.f1662j0 = (ImageButton) findViewById(R.id.image_search);
        this.B0 = (SeekBar) findViewById(R.id.seekBar);
        this.J0 = (TextView) findViewById(R.id.txt_current_time);
        this.I0 = (TextView) findViewById(R.id.txt_current_program);
        this.U0 = (TextView) findViewById(R.id.txt_next_time);
        this.T0 = (TextView) findViewById(R.id.txt_next_program);
        this.M0 = (TextView) findViewById(R.id.txt_group);
        this.H0 = (TextView) findViewById(R.id.txt_channel_name);
        this.S = (ImageView) findViewById(R.id.channel_image);
        this.f1656f0 = (ImageView) findViewById(R.id.image_def);
        this.f1658g0.setOnFocusChangeListener(this);
        this.f1668m0.setOnFocusChangeListener(this);
        this.f1664k0.setOnFocusChangeListener(this);
        this.h0.setOnFocusChangeListener(this);
        this.f1662j0.setOnFocusChangeListener(this);
        this.f1666l0.setOnFocusChangeListener(this);
        this.f1654e0.setOnFocusChangeListener(this);
        this.f1660i0.setOnFocusChangeListener(this);
        this.f1658g0.setOnClickListener(this);
        this.f1668m0.setOnClickListener(this);
        this.f1664k0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.f1662j0.setOnClickListener(this);
        this.f1666l0.setOnClickListener(this);
        this.f1654e0.setOnClickListener(this);
        this.f1660i0.setOnClickListener(this);
        this.P0.setOnClickListener(this);
        this.N0.setOnClickListener(this);
        this.Y0.setOnClickListener(this);
        this.R0.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.f1648b0.addTextChangedListener(new l(i11, this));
        this.V = k5.a.i(this, this.f1682x0.k());
        i1.y0 y0Var = new i1.y0();
        y0Var.j(3, !this.f1682x0.E());
        this.D0 = new i1.z0(y0Var);
        this.f1665k1 = getIntent().getBooleanExtra("is_full", false);
        e5.l.a(this, this.f1682x0.h());
        this.Q = LTVApp.f2087v;
        int c10 = this.f1682x0.c();
        this.f1651c1 = c10;
        if (c10 > this.Q.size() - 1) {
            this.f1651c1 = 1;
        }
        if (D(((CategoryModel) this.Q.get(this.f1651c1)).getId(), ((CategoryModel) this.Q.get(this.f1651c1)).getId())) {
            this.f1651c1 = 1;
        }
        d5.n0 n0Var = new d5.n0(this, this.Q, this.f1682x0.g(), false, this.f1651c1, new f(i11, this));
        this.P = n0Var;
        this.f1683y0.setAdapter(n0Var);
        this.f1683y0.setSelectedPosition(this.f1651c1);
        int i12 = this.f1651c1;
        if (i12 <= 4 || i12 >= this.f1682x0.s().size() + 5) {
            this.X = a6.n.K().w((CategoryModel) this.Q.get(this.f1651c1), _UrlKt.FRAGMENT_ENCODE_SET, this.f1682x0.g(), this.f1682x0.o());
        } else if (this.f1682x0.s().size() > 0) {
            a6.n K = a6.n.K();
            app.shamel.tv.helper.r rVar = this.f1682x0;
            this.X = K.s(_UrlKt.FRAGMENT_ENCODE_SET, rVar.t((String) rVar.s().get(this.f1651c1 - 5)));
        }
        this.f1653d1 = this.f1682x0.d();
        if (this.X.size() <= 0) {
            this.f1653d1 = -1;
        } else if (this.f1653d1 > this.X.size() - 1) {
            this.f1653d1 = 0;
        }
        d5.e eVar = new d5.e(this, this.X, this.f1653d1, new x(i10, this));
        this.R = eVar;
        this.f1684z0.setAdapter(eVar);
        N(false);
        M(false);
        this.W = new d5.m(this, new ArrayList());
        this.A0.setLayoutManager(new LinearLayoutManager(1));
        this.A0.setAdapter(this.W);
        this.A0.setFocusable(false);
        boolean isEmpty = this.X.isEmpty();
        Handler handler = this.f1667l1;
        if (!isEmpty) {
            O();
            if (D(((EPGChannel) this.X.get(this.f1653d1)).getCategory_id(), ((EPGChannel) this.X.get(this.f1653d1)).getCategory_name())) {
                this.f1653d1 = 0;
            }
            if (((EPGChannel) this.X.get(this.f1653d1)).is_locked()) {
                Q((EPGChannel) this.X.get(this.f1653d1), this.f1653d1, 3);
                return;
            }
            H((EPGChannel) this.X.get(this.f1653d1));
            this.f1661i1 = ((EPGChannel) this.X.get(this.f1653d1)).getStream_id();
            if (this.f1682x0.g()) {
                R(null);
            } else {
                handler.removeCallbacks(this.Z);
                y(this.f1661i1);
            }
            this.S0.setText(this.T);
            v(this.f1653d1);
            this.f1684z0.requestFocus();
            this.f1684z0.setSelectedPosition(this.f1653d1);
            this.f1684z0.e0(this.f1653d1);
            return;
        }
        this.f1651c1 = 2;
        this.f1653d1 = 0;
        O();
        io.realm.n0 w10 = a6.n.K().w((CategoryModel) this.Q.get(this.f1651c1), _UrlKt.FRAGMENT_ENCODE_SET, this.f1682x0.g(), this.f1682x0.o());
        this.X = w10;
        this.R.q(0, w10);
        if (D(((EPGChannel) this.X.get(this.f1653d1)).getCategory_id(), ((EPGChannel) this.X.get(this.f1653d1)).getCategory_name())) {
            this.f1683y0.requestFocus();
            return;
        }
        H((EPGChannel) this.X.get(this.f1653d1));
        this.f1661i1 = ((EPGChannel) this.X.get(this.f1653d1)).getStream_id();
        if (this.f1682x0.g()) {
            R(null);
        } else {
            handler.removeCallbacks(this.Z);
            y(this.f1661i1);
        }
        this.S0.setText(this.T);
        v(this.f1653d1);
        this.f1684z0.requestFocus();
        this.f1684z0.setSelectedPosition(this.f1653d1);
        this.f1684z0.e0(this.f1653d1);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        if (z10) {
            this.f1667l1.removeCallbacks(this.f1650c0);
            E();
        }
    }

    @Override // f.j, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT <= 23) {
            PlayerView playerView = this.f1681w0;
            if (playerView != null) {
                playerView.g();
            }
            J();
        }
    }

    @Override // f.j, android.app.Activity
    public final void onResume() {
        String str;
        super.onResume();
        if ((Build.VERSION.SDK_INT <= 23 || this.f1680v0 == null) && this.f1680v0 == null && (str = this.U) != null && !str.isEmpty()) {
            J();
            I(this.U);
        }
        PlayerView playerView = this.f1681w0;
        if (playerView != null) {
            playerView.h();
        }
    }

    @Override // f.j, android.app.Activity
    public final void onStart() {
        String str;
        super.onStart();
        if (Build.VERSION.SDK_INT <= 23 || this.f1680v0 != null || (str = this.U) == null || str.isEmpty()) {
            return;
        }
        J();
        I(this.U);
    }

    @Override // f.j, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT > 23) {
            PlayerView playerView = this.f1681w0;
            if (playerView != null) {
                playerView.g();
            }
            J();
        }
    }

    public final void v(int i10) {
        this.M0.setText(this.f1669m1);
        this.H0.setText(((EPGChannel) this.X.get(i10)).getNum() + " " + ((EPGChannel) this.X.get(i10)).getName());
        String stream_icon = ((EPGChannel) this.X.get(i10)).getStream_icon();
        if (stream_icon == null || stream_icon.isEmpty()) {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).q(Integer.valueOf(R.drawable.home_logo)).g(R.drawable.home_logo)).E(this.S);
        } else {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).r(stream_icon).g(R.drawable.home_logo)).E(this.S);
        }
    }

    public final void w(EPGChannel ePGChannel, int i10) {
        if (ePGChannel == null || e5.l.f4606a.contains(((CategoryModel) this.Q.get(this.f1651c1)).getId())) {
            return;
        }
        a6.n.K().h(ePGChannel.getName(), !ePGChannel.is_favorite(), new t(this, i10, 0));
    }

    public final void x(EPGChannel ePGChannel, int i10) {
        if (ePGChannel == null || e5.l.f4606a.contains(((CategoryModel) this.Q.get(this.f1651c1)).getId())) {
            return;
        }
        a6.n.K().k(ePGChannel.getName(), !ePGChannel.is_locked(), new t(this, i10, 1));
    }

    public final void y(String str) {
        this.f1646a0 = 1;
        y yVar = new y(this, 0, str);
        this.Z = yVar;
        yVar.run();
    }

    public final void z() {
        int i10 = this.f1659g1;
        int size = ((io.realm.u) a6.n.K().f74p).V(EPGChannel.class).d().size() - 1;
        Handler handler = this.f1667l1;
        if (i10 > size) {
            this.V0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.f1663j1 = _UrlKt.FRAGMENT_ENCODE_SET;
            this.f1659g1 = 0;
            handler.removeCallbacks(this.f1678t0);
            return;
        }
        this.V0.setText(this.f1663j1);
        handler.removeCallbacks(this.f1678t0);
        this.f1679u0 = 2;
        z zVar = new z(this, 1);
        this.f1678t0 = zVar;
        zVar.run();
    }
}
