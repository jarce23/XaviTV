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
public class LiveChannelActivity extends f.j implements View.OnClickListener, View.OnFocusChangeListener {

    /* renamed from: m1, reason: collision with root package name */
    public static final /* synthetic */ int f1685m1 = 0;
    public EPGChannel A0;
    public i1.z0 B0;
    public f2.r C0;
    public TextView D0;
    public TextView E0;
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
    public ArrayList P;
    public TextView P0;
    public d5.e Q;
    public TextView Q0;
    public ImageView R;
    public TextView R0;
    public String S;
    public TextView S0;
    public String T;
    public TextView T0;
    public o1.g U;
    public TextView U0;
    public d5.m V;
    public TextView V0;
    public io.realm.n0 W;
    public TextView W0;
    public List X;
    public TextView X0;
    public y Y;
    public TextView Y0;
    public int Z;
    public WordModels Z0;

    /* renamed from: a0, reason: collision with root package name */
    public EditText f1686a0;

    /* renamed from: b0, reason: collision with root package name */
    public c0 f1688b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f1690c0;

    /* renamed from: d0, reason: collision with root package name */
    public ImageButton f1692d0;

    /* renamed from: e0, reason: collision with root package name */
    public ImageView f1694e0;

    /* renamed from: f0, reason: collision with root package name */
    public ImageButton f1696f0;

    /* renamed from: g0, reason: collision with root package name */
    public ImageButton f1698g0;
    public ImageButton h0;

    /* renamed from: i0, reason: collision with root package name */
    public ImageButton f1700i0;

    /* renamed from: j0, reason: collision with root package name */
    public ImageButton f1702j0;

    /* renamed from: k0, reason: collision with root package name */
    public ImageButton f1704k0;

    /* renamed from: l0, reason: collision with root package name */
    public ImageButton f1706l0;

    /* renamed from: m0, reason: collision with root package name */
    public EPGChannel f1708m0;

    /* renamed from: n0, reason: collision with root package name */
    public ConstraintLayout f1709n0;

    /* renamed from: o0, reason: collision with root package name */
    public ConstraintLayout f1710o0;

    /* renamed from: p0, reason: collision with root package name */
    public ConstraintLayout f1711p0;

    /* renamed from: q0, reason: collision with root package name */
    public ConstraintLayout f1712q0;

    /* renamed from: r0, reason: collision with root package name */
    public ConstraintLayout f1713r0;

    /* renamed from: s0, reason: collision with root package name */
    public c0 f1714s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f1715t0;

    /* renamed from: u0, reason: collision with root package name */
    public s1.a0 f1716u0;

    /* renamed from: v0, reason: collision with root package name */
    public PlayerView f1717v0;

    /* renamed from: w0, reason: collision with root package name */
    public app.shamel.tv.helper.r f1718w0;

    /* renamed from: x0, reason: collision with root package name */
    public LiveVerticalGridView f1719x0;

    /* renamed from: y0, reason: collision with root package name */
    public RecyclerView f1720y0;

    /* renamed from: z0, reason: collision with root package name */
    public SeekBar f1721z0;

    /* renamed from: a1, reason: collision with root package name */
    public int f1687a1 = 0;

    /* renamed from: b1, reason: collision with root package name */
    public int f1689b1 = 0;

    /* renamed from: c1, reason: collision with root package name */
    public int f1691c1 = 0;

    /* renamed from: d1, reason: collision with root package name */
    public int f1693d1 = 0;

    /* renamed from: e1, reason: collision with root package name */
    public int f1695e1 = 0;

    /* renamed from: f1, reason: collision with root package name */
    public String f1697f1 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: g1, reason: collision with root package name */
    public String f1699g1 = _UrlKt.FRAGMENT_ENCODE_SET;
    public boolean h1 = false;

    /* renamed from: i1, reason: collision with root package name */
    public final Handler f1701i1 = new Handler(Looper.getMainLooper());

    /* renamed from: j1, reason: collision with root package name */
    public final String f1703j1 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: l1, reason: collision with root package name */
    public int f1707l1 = 2;

    /* renamed from: k1, reason: collision with root package name */
    public final androidx.activity.result.c f1705k1 = l(new androidx.fragment.app.e0(2), new a0(this));

    public final boolean A(String str, String str2) {
        return this.f1718w0.g() ? str2.contains("adult") || str2.contains("xxx") || str2.contains("porn") : e5.l.f4606a.contains(str);
    }

    public final void B() {
        this.f1690c0 = 10;
        c0 c0Var = new c0(this, 0);
        this.f1688b0 = c0Var;
        c0Var.run();
    }

    public final void C() {
        if (this.f1689b1 < this.W.size() - 1) {
            this.f1689b1++;
        } else {
            this.f1689b1 = 0;
        }
        if (((CategoryModel) this.P.get(this.f1687a1)).getId().equalsIgnoreCase("all_id") && A(((EPGChannel) this.W.get(this.f1689b1)).getCategory_id(), ((EPGChannel) this.W.get(this.f1689b1)).getCategory_name())) {
            M((EPGChannel) this.W.get(this.f1689b1), this.f1689b1, 1);
            return;
        }
        if (!A(((EPGChannel) this.W.get(this.f1689b1)).getCategory_id(), ((EPGChannel) this.W.get(this.f1689b1)).getCategory_name()) && !((CategoryModel) this.P.get(this.f1687a1)).getId().equalsIgnoreCase("lock_id") && ((EPGChannel) this.W.get(this.f1689b1)).is_locked()) {
            M((EPGChannel) this.W.get(this.f1689b1), this.f1689b1, 1);
            return;
        }
        E((EPGChannel) this.W.get(this.f1689b1));
        boolean g = this.f1718w0.g();
        Handler handler = this.f1701i1;
        if (g) {
            N(null);
        } else {
            handler.removeCallbacks(this.Y);
            x(this.f1697f1);
        }
        u(this.f1689b1);
        if (this.f1711p0.getVisibility() == 8) {
            this.f1711p0.setVisibility(0);
        }
        handler.removeCallbacks(this.f1688b0);
        B();
        this.Q0.setText(this.S);
        this.f1719x0.setSelectedPosition(this.f1689b1);
    }

    public final void D() {
        int i10 = this.f1689b1;
        if (i10 > 0) {
            this.f1689b1 = i10 - 1;
        } else {
            this.f1689b1 = this.W.size() - 1;
        }
        if (((CategoryModel) this.P.get(this.f1687a1)).getId().equalsIgnoreCase("all_id") && A(((EPGChannel) this.W.get(this.f1689b1)).getCategory_id(), ((EPGChannel) this.W.get(this.f1689b1)).getCategory_name())) {
            M((EPGChannel) this.W.get(this.f1689b1), this.f1689b1, 1);
            return;
        }
        if (!A(((EPGChannel) this.W.get(this.f1689b1)).getCategory_id(), ((EPGChannel) this.W.get(this.f1689b1)).getCategory_name()) && !((CategoryModel) this.P.get(this.f1687a1)).getId().equalsIgnoreCase("lock_id") && ((EPGChannel) this.W.get(this.f1689b1)).is_locked()) {
            M((EPGChannel) this.W.get(this.f1689b1), this.f1689b1, 1);
            return;
        }
        E((EPGChannel) this.W.get(this.f1689b1));
        boolean g = this.f1718w0.g();
        Handler handler = this.f1701i1;
        if (g) {
            N(null);
        } else {
            handler.removeCallbacks(this.Y);
            x(this.f1697f1);
        }
        u(this.f1689b1);
        this.Q0.setText(this.S);
        if (this.f1711p0.getVisibility() == 8) {
            this.f1711p0.setVisibility(0);
        }
        handler.removeCallbacks(this.f1688b0);
        B();
        this.f1719x0.setSelectedPosition(this.f1689b1);
    }

    public final void E(EPGChannel ePGChannel) {
        if (ePGChannel != null) {
            this.f1718w0.M(this.f1687a1);
            this.f1718w0.N(this.f1689b1);
            this.A0 = ePGChannel;
            this.f1697f1 = ePGChannel.getStream_id();
            this.S = this.A0.getName();
            O(this.A0.is_favorite());
            P(ePGChannel.is_locked());
            if (this.f1718w0.g()) {
                this.T = this.A0.getUrl();
            } else {
                this.T = app.shamel.tv.helper.a.g(this.f1718w0.B(), this.f1718w0.I(), this.f1718w0.v(), this.f1697f1, this.f1718w0.p());
            }
            if (e5.l.f4606a.contains(((CategoryModel) this.P.get(this.f1687a1)).getId()) || A(this.A0.getCategory_id(), this.A0.getCategory_name())) {
                P(true);
            } else {
                a6.n.K().l(this.A0.getName(), true, new a0(this));
            }
            G();
            F(this.T);
        }
    }

    public final void F(String str) {
        s1.a0 a0Var = this.f1716u0;
        if (a0Var != null) {
            a0Var.O();
        }
        if (this.f1694e0.getVisibility() == 0) {
            this.f1694e0.setVisibility(8);
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
        this.C0 = rVar;
        rVar.b(this.B0);
        s1.n nVar = new s1.n(this);
        x4.l lVar = new x4.l(18);
        lVar.f13562p = k5.a.n(this, this.f1718w0.k());
        c2.r rVar2 = new c2.r(this);
        rVar2.g(this.U);
        rVar2.h(lVar);
        nVar.b(rVar2);
        nVar.d(this.C0);
        nVar.c(k5.a.e(this, true));
        s1.a0 a10 = nVar.a();
        this.f1716u0 = a10;
        a10.W(this.B0);
        this.f1716u0.q(new u(1));
        this.f1716u0.f11204m.a(new j(this, 2));
        this.f1716u0.q(new h2.a());
        s1.a0 a0Var3 = this.f1716u0;
        i1.d dVar = i1.d.f5843b;
        a0Var3.S();
        this.f1716u0.U(true);
        this.f1717v0.setPlayer(this.f1716u0);
        this.f1716u0.p(a0Var2);
        this.f1716u0.N();
        this.f1716u0.j();
    }

    public final void G() {
        s1.a0 a0Var = this.f1716u0;
        if (a0Var == null) {
            return;
        }
        a0Var.Z();
        this.f1716u0.O();
        this.f1716u0 = null;
        this.f1717v0.setPlayer(null);
    }

    public final void H(List list) {
        if (list == null || list.size() <= 0) {
            this.H0.setText(this.Z0.getNo_information());
            this.G0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.f1721z0.setProgress(0);
            this.S0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.R0.setText(this.Z0.getNo_information());
            return;
        }
        this.G0.setText(k5.j.e(((CatchUpEpg) list.get(0)).getTitle()));
        this.H0.setText(k5.j.h(k5.j.i(((CatchUpEpg) list.get(0)).getStart()).getTime() + LTVApp.f2083r, app.shamel.tv.helper.a.b(this)));
        this.f1721z0.setProgress(((CatchUpEpg) list.get(0)).getProgress());
        if (list.size() <= 1) {
            this.S0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.R0.setText(this.Z0.getNo_information());
        } else {
            this.R0.setText(k5.j.e(((CatchUpEpg) list.get(1)).getTitle()));
            this.S0.setText(k5.j.h(k5.j.i(((CatchUpEpg) list.get(1)).getStart()).getTime() + LTVApp.f2083r, app.shamel.tv.helper.a.b(this)));
        }
    }

    public final void I(boolean z10) {
        this.M.setFocusable(z10);
        this.N.setFocusable(z10);
        this.O.setFocusable(z10);
    }

    public final void J(boolean z10) {
        this.L0.setFocusable(z10);
        this.N0.setFocusable(z10);
        this.P0.setFocusable(z10);
        this.W0.setFocusable(z10);
        this.f1686a0.setFocusable(z10);
    }

    public final void K() {
        boolean z10 = this.h1;
        Handler handler = this.f1701i1;
        if (z10) {
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.O.setVisibility(8);
            this.f1719x0.setVisibility(8);
            ConstraintLayout constraintLayout = this.f1712q0;
            if (constraintLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) constraintLayout.getLayoutParams()).setMargins(0, 0, 0, 0);
                constraintLayout.requestLayout();
            }
            if (this.f1711p0.getVisibility() == 8) {
                this.f1711p0.setVisibility(0);
            }
            handler.removeCallbacks(this.f1688b0);
            B();
        } else {
            ConstraintLayout constraintLayout2 = this.f1712q0;
            if (constraintLayout2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) constraintLayout2.getLayoutParams()).setMargins(0, 0, 0, 0);
                constraintLayout2.requestLayout();
            }
            this.M.setVisibility(0);
            this.N.setVisibility(0);
            this.O.setVisibility(0);
            handler.removeCallbacks(this.f1688b0);
            this.f1711p0.setVisibility(8);
            L(false);
            this.f1707l1 = 2;
            this.f1719x0.setVisibility(0);
            this.Q.p(this.f1689b1);
            this.f1719x0.requestFocus();
        }
        x.m mVar = new x.m();
        mVar.c(this.f1713r0);
        if (this.h1) {
            mVar.l(R.id.vertical_line2, 0.0f);
            mVar.l(R.id.horizontal_line1, 0.0f);
            mVar.l(R.id.horizontal_line2, 1.0f);
        } else {
            mVar.l(R.id.vertical_line2, 0.5f);
            mVar.l(R.id.horizontal_line1, 0.1f);
            mVar.l(R.id.horizontal_line2, 0.6f);
        }
        mVar.a(this.f1713r0);
    }

    public final void L(boolean z10) {
        if (!z10) {
            this.f1710o0.setVisibility(8);
            this.f1709n0.setVisibility(0);
        } else {
            this.f1710o0.setVisibility(0);
            this.f1709n0.setVisibility(8);
            this.f1696f0.requestFocus();
        }
    }

    public final void M(EPGChannel ePGChannel, int i10, int i11) {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i12 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_channel_lock");
        if (A != null) {
            android.support.v4.media.d.v(i12, A, false);
            return;
        }
        h5.h0 N = h5.h0.N(this.f1718w0.u());
        N.f5607z0 = new v(this, i11, i10, ePGChannel, 1);
        N.M(n10, "fragment_channel_lock");
    }

    public final void N(List list) {
        if (list == null || list.size() == 0) {
            this.V.l(new ArrayList());
            H(new ArrayList());
        } else {
            this.V.l(list);
            H(list);
        }
    }

    public final void O(boolean z10) {
        if (z10) {
            this.N.setText(this.Z0.getRemove_favorites());
        } else {
            this.N.setText(this.Z0.getAdd_to_favorite());
        }
    }

    public final void P(boolean z10) {
        if (z10) {
            this.h0.setImageResource(R.drawable.ic_locked);
        } else {
            this.h0.setImageResource(R.drawable.ic_lock);
        }
    }

    public final void Q() {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_search");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return;
        }
        h5.c0 N = h5.c0.N(this, (CategoryModel) this.P.get(this.f1687a1), this.f1687a1, this.f1718w0.g());
        N.B0 = new a0(this);
        N.M(n10, "fragment_search");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0149, code lost:
    
        if (r9.O.hasFocus() == false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007a, code lost:
    
        if (r9.f1692d0.hasFocus() != false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a1, code lost:
    
        if (r9.f1696f0.hasFocus() != false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d0, code lost:
    
        if (r0 == 3) goto L171;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017b  */
    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.LiveChannelActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EPGChannel ePGChannel;
        int id = view.getId();
        androidx.activity.result.c cVar = this.f1705k1;
        boolean z10 = false;
        if (id == R.id.btn_catch_up || id == R.id.image_epg) {
            if (this.f1718w0.g()) {
                Toast.makeText(this, this.Z0.getNo_epg_avaliable(), 0).show();
                return;
            } else {
                if (this.A0 != null) {
                    G();
                    LTVApp.f2084s = this.A0.getName();
                    cVar.z(new Intent(this, (Class<?>) CatchUpActivity.class));
                    return;
                }
                return;
            }
        }
        if (id == R.id.btn_fav) {
            if (this.W.size() <= 0 || (ePGChannel = (EPGChannel) this.W.get(this.f1691c1)) == null) {
                return;
            }
            v(ePGChannel, this.f1691c1);
            O(!ePGChannel.is_favorite());
            if (ePGChannel.is_favorite()) {
                Toast.makeText(this, this.Z0.getChannel_removed_from_fav(), 0).show();
                return;
            } else {
                Toast.makeText(this, this.Z0.getChannel_added_to_fav(), 0).show();
                return;
            }
        }
        if (id == R.id.btn_search) {
            G();
            Intent intent = new Intent(this, (Class<?>) SearchActivity.class);
            intent.putExtra("is_live", true);
            cVar.z(intent);
            return;
        }
        if (id == R.id.image_audio) {
            f2.r rVar = this.C0;
            if (rVar == null) {
                return;
            }
            f2.v vVar = rVar.f4956c;
            if (vVar == null) {
                Toast.makeText(getApplicationContext(), this.Z0.getNo_audio(), 1).show();
                return;
            }
            String audio_track = this.Z0.getAudio_track();
            int i10 = vVar.f4949b[1];
            if (i10 == 2 || (i10 == 1 && vVar.a() == 0)) {
                z10 = true;
            }
            p7.n nVar = new p7.n(this, audio_track, this.f1716u0, 1);
            nVar.f10070a = z10;
            nVar.b().show();
            return;
        }
        if (id == R.id.image_fav) {
            EPGChannel ePGChannel2 = this.A0;
            if (ePGChannel2 != null) {
                v(ePGChannel2, this.f1689b1);
                O(!this.A0.is_favorite());
                if (this.A0.is_favorite()) {
                    Toast.makeText(this, this.Z0.getChannel_removed_from_fav(), 0).show();
                    return;
                } else {
                    Toast.makeText(this, this.Z0.getChannel_added_to_fav(), 0).show();
                    return;
                }
            }
            return;
        }
        if (id == R.id.image_lock) {
            EPGChannel ePGChannel3 = this.A0;
            if (ePGChannel3 != null) {
                if (A(ePGChannel3.getCategory_id(), this.A0.getCategory_name())) {
                    Toast.makeText(this, this.Z0.getChannel_locked_default(), 0).show();
                    return;
                }
                if (this.A0.is_locked()) {
                    M(this.A0, this.f1689b1, 3);
                    return;
                }
                w(this.A0, this.f1689b1);
                P(!this.A0.is_locked());
                if (this.A0.is_locked()) {
                    Toast.makeText(this, this.Z0.getChannel_unlocked(), 0).show();
                    return;
                } else {
                    Toast.makeText(this, this.Z0.getChannel_locked(), 0).show();
                    return;
                }
            }
            return;
        }
        if (id == R.id.image_search) {
            this.f1711p0.setVisibility(8);
            this.f1707l1 = 2;
            L(false);
            Q();
            return;
        }
        if (id == R.id.image_series || id == R.id.txt_series) {
            G();
            Intent intent2 = new Intent();
            intent2.putExtra("is_changed", "series");
            setResult(-1, intent2);
            finish();
            return;
        }
        if (id == R.id.image_subtitle) {
            f2.r rVar2 = this.C0;
            if (rVar2 == null) {
                return;
            }
            f2.v vVar2 = rVar2.f4956c;
            if (vVar2 == null) {
                Toast.makeText(getApplicationContext(), this.Z0.getNo_subtitle(), 1).show();
                return;
            }
            String subtitle = this.Z0.getSubtitle();
            int i11 = vVar2.f4949b[3];
            if (i11 == 2 || (i11 == 3 && vVar2.a() == 0)) {
                z10 = true;
            }
            p7.n nVar2 = new p7.n(this, subtitle, this.f1716u0, 3);
            nVar2.f10070a = z10;
            nVar2.b().show();
            return;
        }
        if (id == R.id.image_vod || id == R.id.txt_movie) {
            G();
            Intent intent3 = new Intent();
            intent3.putExtra("is_changed", "movie");
            setResult(-1, intent3);
            finish();
            return;
        }
        if (id == R.id.txt_home) {
            G();
            if (((CategoryModel) this.P.get(this.f1687a1)).getId().equalsIgnoreCase("resume_id") && this.A0 != null) {
                this.f1718w0.M(this.f1689b1);
            }
            Intent intent4 = new Intent();
            intent4.putExtra("is_changed", "home");
            setResult(-1, intent4);
            finish();
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_live_channel);
        k5.j.a(this);
        this.f1718w0 = new app.shamel.tv.helper.r(this);
        this.Z0 = app.shamel.tv.helper.a.k(this);
        this.f1713r0 = (ConstraintLayout) findViewById(R.id.fullContainer);
        PlayerView playerView = (PlayerView) findViewById(R.id.player_view);
        this.f1717v0 = playerView;
        playerView.setResizeMode(4);
        this.f1717v0.getSubtitleView().setApplyEmbeddedStyles(false);
        u3.c cVar = new u3.c(Color.parseColor(this.f1718w0.D()), Color.parseColor(this.f1718w0.C()), 0, 0, 0, null);
        this.f1717v0.getSubtitleView().a(3, this.f1718w0.F());
        this.f1717v0.getSubtitleView().setStyle(cVar);
        this.T0 = (TextView) findViewById(R.id.txt_num);
        this.L0 = (TextView) findViewById(R.id.txt_home);
        this.N0 = (TextView) findViewById(R.id.txt_live);
        this.P0 = (TextView) findViewById(R.id.txt_movie);
        this.W0 = (TextView) findViewById(R.id.txt_series);
        this.Q0 = (TextView) findViewById(R.id.txt_name);
        this.f1686a0 = (EditText) findViewById(R.id.et_search);
        this.f1719x0 = (LiveVerticalGridView) findViewById(R.id.recycler_channel);
        this.f1712q0 = (ConstraintLayout) findViewById(R.id.ly_surface);
        this.f1720y0 = (RecyclerView) findViewById(R.id.recycler_epg);
        this.N = (Button) findViewById(R.id.btn_fav);
        this.M = (Button) findViewById(R.id.btn_catch_up);
        this.O = (Button) findViewById(R.id.btn_search);
        this.M0 = (TextView) findViewById(R.id.txt_left);
        this.U0 = (TextView) findViewById(R.id.txt_right);
        this.I0 = (TextView) findViewById(R.id.txt_epg);
        this.O0 = (TextView) findViewById(R.id.txt_lock);
        this.Y0 = (TextView) findViewById(R.id.txt_vod);
        this.V0 = (TextView) findViewById(R.id.txt_search);
        this.E0 = (TextView) findViewById(R.id.txt_bottom_series);
        this.J0 = (TextView) findViewById(R.id.txt_fav);
        this.X0 = (TextView) findViewById(R.id.txt_subtitle);
        this.D0 = (TextView) findViewById(R.id.txt_audio);
        this.M0.setText(this.Z0.getPrevious_channel());
        this.U0.setText(this.Z0.getNext_channel());
        this.L0.setText(this.Z0.getHome());
        this.N0.setText(this.Z0.getLive_tv());
        this.P0.setText(this.Z0.getMovies());
        this.W0.setText(this.Z0.getSeries());
        this.M.setText(this.Z0.getCatch_up());
        this.O.setText(this.Z0.getSearch());
        this.N.setText(this.Z0.getAdd_to_favorite());
        this.I0.setText(this.Z0.getEpg());
        this.O0.setText(this.Z0.getLock());
        this.Y0.setText(this.Z0.getMovies());
        this.V0.setText(this.Z0.getSearch());
        this.E0.setText(this.Z0.getSeries());
        this.J0.setText(this.Z0.getFavorite());
        this.X0.setText(this.Z0.getSubtitle());
        this.D0.setText(this.Z0.getAudio_track());
        int i10 = 1;
        this.f1719x0.setNumColumns(1);
        this.f1719x0.setLoop(false);
        this.f1719x0.setPreserveFocusAfterLayout(true);
        this.f1719x0.setOnChildViewHolderSelectedListener(new e(8, new View[]{null}));
        this.f1711p0 = (ConstraintLayout) findViewById(R.id.ly_control);
        this.f1710o0 = (ConstraintLayout) findViewById(R.id.ly_buttons);
        this.f1709n0 = (ConstraintLayout) findViewById(R.id.ly_actions);
        this.f1696f0 = (ImageButton) findViewById(R.id.image_epg);
        this.f1706l0 = (ImageButton) findViewById(R.id.image_vod);
        this.f1702j0 = (ImageButton) findViewById(R.id.image_series);
        this.f1704k0 = (ImageButton) findViewById(R.id.image_subtitle);
        this.f1692d0 = (ImageButton) findViewById(R.id.image_audio);
        this.h0 = (ImageButton) findViewById(R.id.image_lock);
        this.f1698g0 = (ImageButton) findViewById(R.id.image_fav);
        this.f1700i0 = (ImageButton) findViewById(R.id.image_search);
        this.f1721z0 = (SeekBar) findViewById(R.id.seekBar);
        this.H0 = (TextView) findViewById(R.id.txt_current_time);
        this.G0 = (TextView) findViewById(R.id.txt_current_program);
        this.S0 = (TextView) findViewById(R.id.txt_next_time);
        this.R0 = (TextView) findViewById(R.id.txt_next_program);
        this.K0 = (TextView) findViewById(R.id.txt_group);
        this.F0 = (TextView) findViewById(R.id.txt_channel_name);
        this.R = (ImageView) findViewById(R.id.channel_image);
        this.f1694e0 = (ImageView) findViewById(R.id.image_def);
        this.f1696f0.setOnFocusChangeListener(this);
        this.f1706l0.setOnFocusChangeListener(this);
        this.f1702j0.setOnFocusChangeListener(this);
        this.f1698g0.setOnFocusChangeListener(this);
        this.f1700i0.setOnFocusChangeListener(this);
        this.f1704k0.setOnFocusChangeListener(this);
        this.f1692d0.setOnFocusChangeListener(this);
        this.h0.setOnFocusChangeListener(this);
        this.f1696f0.setOnClickListener(this);
        this.f1706l0.setOnClickListener(this);
        this.f1702j0.setOnClickListener(this);
        this.f1698g0.setOnClickListener(this);
        this.f1700i0.setOnClickListener(this);
        this.f1704k0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.N0.setOnClickListener(this);
        this.L0.setOnClickListener(this);
        this.W0.setOnClickListener(this);
        this.P0.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.f1692d0.setOnClickListener(this);
        this.f1686a0.addTextChangedListener(new l(2, this));
        this.U = k5.a.i(this, this.f1718w0.k());
        i1.y0 y0Var = new i1.y0();
        y0Var.j(3, !this.f1718w0.E());
        this.B0 = new i1.z0(y0Var);
        this.h1 = getIntent().getBooleanExtra("is_full", false);
        e5.l.a(this, this.f1718w0.h());
        this.P = LTVApp.f2087v;
        int c10 = this.f1718w0.c();
        this.f1687a1 = c10;
        if (c10 > this.P.size() - 1) {
            this.f1687a1 = 1;
        }
        int i11 = this.f1687a1;
        if (i11 <= 4 || i11 >= this.f1718w0.s().size() + 5) {
            this.W = a6.n.K().w((CategoryModel) this.P.get(this.f1687a1), _UrlKt.FRAGMENT_ENCODE_SET, this.f1718w0.g(), this.f1718w0.o());
        } else if (this.f1718w0.s().size() > 0) {
            a6.n K = a6.n.K();
            app.shamel.tv.helper.r rVar = this.f1718w0;
            this.W = K.s(_UrlKt.FRAGMENT_ENCODE_SET, rVar.t((String) rVar.s().get(this.f1687a1 - 5)));
        }
        this.f1689b1 = 0;
        d5.e eVar = new d5.e(this, this.W, 0, new x(i10, this));
        this.Q = eVar;
        this.f1719x0.setAdapter(eVar);
        J(false);
        I(false);
        this.V = new d5.m(this, new ArrayList());
        this.f1720y0.setLayoutManager(new LinearLayoutManager(1));
        this.f1720y0.setAdapter(this.V);
        this.f1720y0.setFocusable(false);
        if (this.W.isEmpty()) {
            return;
        }
        K();
        if (A(((EPGChannel) this.W.get(this.f1689b1)).getCategory_id(), ((EPGChannel) this.W.get(this.f1689b1)).getCategory_name())) {
            this.f1689b1 = 0;
        }
        if (!((CategoryModel) this.P.get(this.f1687a1)).getId().equalsIgnoreCase("lock_id") && ((EPGChannel) this.W.get(this.f1689b1)).is_locked()) {
            M((EPGChannel) this.W.get(this.f1689b1), this.f1689b1, 1);
            return;
        }
        E((EPGChannel) this.W.get(this.f1689b1));
        this.f1697f1 = ((EPGChannel) this.W.get(this.f1689b1)).getStream_id();
        if (this.f1718w0.g()) {
            N(null);
        } else {
            this.f1701i1.removeCallbacks(this.Y);
            x(this.f1697f1);
        }
        String name = ((EPGChannel) this.W.get(this.f1689b1)).getName();
        this.S = name;
        this.Q0.setText(name);
        O(((EPGChannel) this.W.get(this.f1689b1)).is_favorite());
        u(this.f1689b1);
        this.f1719x0.requestFocus();
        this.f1719x0.setSelectedPosition(this.f1689b1);
        this.f1719x0.e0(this.f1689b1);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        if (z10) {
            this.f1701i1.removeCallbacks(this.f1688b0);
            B();
        }
    }

    @Override // f.j, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT <= 23) {
            PlayerView playerView = this.f1717v0;
            if (playerView != null) {
                playerView.g();
            }
            G();
        }
    }

    @Override // f.j, android.app.Activity
    public final void onResume() {
        String str;
        super.onResume();
        if ((Build.VERSION.SDK_INT <= 23 || this.f1716u0 == null) && this.f1716u0 == null && (str = this.T) != null && !str.isEmpty()) {
            G();
            F(this.T);
        }
        PlayerView playerView = this.f1717v0;
        if (playerView != null) {
            playerView.h();
        }
    }

    @Override // f.j, android.app.Activity
    public final void onStart() {
        String str;
        super.onStart();
        if (Build.VERSION.SDK_INT <= 23 || this.f1716u0 != null || (str = this.T) == null || str.isEmpty()) {
            return;
        }
        G();
        F(this.T);
    }

    @Override // f.j, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT > 23) {
            PlayerView playerView = this.f1717v0;
            if (playerView != null) {
                playerView.g();
            }
            G();
        }
    }

    public final void u(int i10) {
        this.K0.setText(this.f1703j1);
        this.F0.setText(((EPGChannel) this.W.get(i10)).getNum() + " " + ((EPGChannel) this.W.get(i10)).getName());
        String stream_icon = ((EPGChannel) this.W.get(i10)).getStream_icon();
        if (stream_icon == null || stream_icon.isEmpty()) {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).q(Integer.valueOf(R.drawable.home_logo)).g(R.drawable.home_logo)).E(this.R);
        } else {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).r(stream_icon).g(R.drawable.home_logo)).E(this.R);
        }
    }

    public final void v(EPGChannel ePGChannel, int i10) {
        if (ePGChannel == null || e5.l.f4606a.contains(((CategoryModel) this.P.get(this.f1687a1)).getId())) {
            return;
        }
        a6.n.K().h(ePGChannel.getName(), !ePGChannel.is_favorite(), new b0(this, i10, 0));
    }

    public final void w(EPGChannel ePGChannel, int i10) {
        if (ePGChannel == null || e5.l.f4606a.contains(((CategoryModel) this.P.get(this.f1687a1)).getId())) {
            return;
        }
        a6.n.K().k(ePGChannel.getName(), !ePGChannel.is_locked(), new b0(this, i10, 1));
    }

    public final void x(String str) {
        this.Z = 1;
        y yVar = new y(this, 1, str);
        this.Y = yVar;
        yVar.run();
    }

    public final void y() {
        int i10 = this.f1693d1;
        int size = ((io.realm.u) a6.n.K().f74p).V(EPGChannel.class).d().size() - 1;
        Handler handler = this.f1701i1;
        if (i10 > size) {
            this.T0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.f1699g1 = _UrlKt.FRAGMENT_ENCODE_SET;
            this.f1693d1 = 0;
            handler.removeCallbacks(this.f1714s0);
            return;
        }
        this.T0.setText(this.f1699g1);
        handler.removeCallbacks(this.f1714s0);
        this.f1715t0 = 2;
        c0 c0Var = new c0(this, 1);
        this.f1714s0 = c0Var;
        c0Var.run();
    }

    public final void z(String str) {
        try {
            j5.f.a(this.f1718w0.B()).get_short_epg(this.f1718w0.I(), this.f1718w0.v(), str).enqueue(new a0(this));
        } catch (Exception unused) {
            N(null);
        }
    }
}
