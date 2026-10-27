package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaMetadata;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s extends f.g {
    public static final int D0;
    public int A;
    public final Interpolator A0;
    public Button B;
    public final AccessibilityManager B0;
    public Button C;
    public final h C0;
    public ImageButton D;
    public MediaRouteExpandCollapseButton E;
    public FrameLayout F;
    public LinearLayout G;
    public FrameLayout H;
    public ImageView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public final boolean M;
    public final boolean N;
    public LinearLayout O;
    public RelativeLayout P;
    public LinearLayout Q;
    public View R;
    public OverlayListView S;
    public r T;
    public ArrayList U;
    public HashSet V;
    public HashSet W;
    public HashSet X;
    public SeekBar Y;
    public q Z;

    /* renamed from: a0, reason: collision with root package name */
    public w3.z f1385a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f1386b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f1387c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f1388d0;

    /* renamed from: e0, reason: collision with root package name */
    public final int f1389e0;

    /* renamed from: f0, reason: collision with root package name */
    public HashMap f1390f0;

    /* renamed from: g0, reason: collision with root package name */
    public x4.l f1391g0;
    public final p h0;

    /* renamed from: i0, reason: collision with root package name */
    public PlaybackStateCompat f1392i0;

    /* renamed from: j0, reason: collision with root package name */
    public MediaDescriptionCompat f1393j0;

    /* renamed from: k0, reason: collision with root package name */
    public o f1394k0;

    /* renamed from: l0, reason: collision with root package name */
    public Bitmap f1395l0;

    /* renamed from: m0, reason: collision with root package name */
    public Uri f1396m0;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f1397n0;

    /* renamed from: o0, reason: collision with root package name */
    public Bitmap f1398o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f1399p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f1400q0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f1401r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f1402s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f1403t0;

    /* renamed from: u, reason: collision with root package name */
    public final w3.b0 f1404u;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f1405u0;

    /* renamed from: v, reason: collision with root package name */
    public final f0 f1406v;

    /* renamed from: v0, reason: collision with root package name */
    public int f1407v0;

    /* renamed from: w, reason: collision with root package name */
    public final w3.z f1408w;

    /* renamed from: w0, reason: collision with root package name */
    public int f1409w0;

    /* renamed from: x, reason: collision with root package name */
    public final Context f1410x;

    /* renamed from: x0, reason: collision with root package name */
    public int f1411x0;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1412y;

    /* renamed from: y0, reason: collision with root package name */
    public Interpolator f1413y0;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1414z;

    /* renamed from: z0, reason: collision with root package name */
    public final Interpolator f1415z0;

    static {
        Log.isLoggable("MediaRouteCtrlDialog", 3);
        D0 = (int) TimeUnit.SECONDS.toMillis(30L);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s(android.content.Context r4) {
        /*
            r3 = this;
            r0 = 1
            android.view.ContextThemeWrapper r4 = i7.e.f(r4, r0)
            r1 = 2130969659(0x7f04043b, float:1.7548006E38)
            int r1 = i7.e.o(r4, r1)
            if (r1 != 0) goto L12
            int r1 = i7.e.m(r4)
        L12:
            r3.<init>(r4, r1)
            r3.M = r0
            androidx.mediarouter.app.h r0 = new androidx.mediarouter.app.h
            r1 = 0
            r0.<init>(r1, r3)
            r3.C0 = r0
            android.content.Context r0 = r3.getContext()
            r3.f1410x = r0
            androidx.mediarouter.app.p r1 = new androidx.mediarouter.app.p
            r2 = 0
            r1.<init>(r3, r2)
            r3.h0 = r1
            w3.b0 r1 = w3.b0.d(r0)
            r3.f1404u = r1
            boolean r1 = w3.b0.h()
            r3.N = r1
            androidx.mediarouter.app.f0 r1 = new androidx.mediarouter.app.f0
            r2 = 3
            r1.<init>(r3, r2)
            r3.f1406v = r1
            w3.z r1 = w3.b0.g()
            r3.f1408w = r1
            android.support.v4.media.session.MediaSessionCompat$Token r1 = w3.b0.e()
            r3.p(r1)
            android.content.res.Resources r1 = r0.getResources()
            r2 = 2131167152(0x7f0707b0, float:1.794857E38)
            int r1 = r1.getDimensionPixelSize(r2)
            r3.f1389e0 = r1
            java.lang.String r1 = "accessibility"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.accessibility.AccessibilityManager r0 = (android.view.accessibility.AccessibilityManager) r0
            r3.B0 = r0
            r0 = 2131558415(0x7f0d000f, float:1.8742145E38)
            android.view.animation.Interpolator r0 = android.view.animation.AnimationUtils.loadInterpolator(r4, r0)
            r3.f1415z0 = r0
            r0 = 2131558414(0x7f0d000e, float:1.8742143E38)
            android.view.animation.Interpolator r4 = android.view.animation.AnimationUtils.loadInterpolator(r4, r0)
            r3.A0 = r4
            android.view.animation.AccelerateDecelerateInterpolator r4 = new android.view.animation.AccelerateDecelerateInterpolator
            r4.<init>()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.s.<init>(android.content.Context):void");
    }

    public static void o(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    public final void h(View view, int i10) {
        k kVar = new k(view.getLayoutParams().height, i10, view, 0);
        kVar.setDuration(this.f1407v0);
        kVar.setInterpolator(this.f1413y0);
        view.startAnimation(kVar);
    }

    public final boolean i() {
        return (this.f1393j0 == null && this.f1392i0 == null) ? false : true;
    }

    public final void j(boolean z10) {
        HashSet hashSet;
        int firstVisiblePosition = this.S.getFirstVisiblePosition();
        for (int i10 = 0; i10 < this.S.getChildCount(); i10++) {
            View childAt = this.S.getChildAt(i10);
            w3.z zVar = (w3.z) this.T.getItem(firstVisiblePosition + i10);
            if (!z10 || (hashSet = this.V) == null || !hashSet.contains(zVar)) {
                ((LinearLayout) childAt.findViewById(R.id.volume_item_container)).setVisibility(0);
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
                alphaAnimation.setDuration(0L);
                animationSet.addAnimation(alphaAnimation);
                new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f).setDuration(0L);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                childAt.clearAnimation();
                childAt.startAnimation(animationSet);
            }
        }
        ArrayList arrayList = this.S.f1261o;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            o0 o0Var = (o0) obj;
            o0Var.f1373j = true;
            o0Var.f1374k = true;
            x4.e eVar = o0Var.f1375l;
            if (eVar != null) {
                s sVar = (s) eVar.f13543q;
                sVar.X.remove((w3.z) eVar.f13542p);
                sVar.T.notifyDataSetChanged();
            }
        }
        if (z10) {
            return;
        }
        k(false);
    }

    public final void k(boolean z10) {
        this.V = null;
        this.W = null;
        this.f1403t0 = false;
        if (this.f1405u0) {
            this.f1405u0 = false;
            t(z10);
        }
        this.S.setEnabled(true);
    }

    public final int l(int i10, int i11) {
        return i10 >= i11 ? (int) (((this.A * i11) / i10) + 0.5f) : (int) (((this.A * 9.0f) / 16.0f) + 0.5f);
    }

    public final int m(boolean z10) {
        if (!z10 && this.Q.getVisibility() != 0) {
            return 0;
        }
        int paddingBottom = this.O.getPaddingBottom() + this.O.getPaddingTop();
        if (z10) {
            paddingBottom += this.P.getMeasuredHeight();
        }
        if (this.Q.getVisibility() == 0) {
            paddingBottom += this.Q.getMeasuredHeight();
        }
        return (z10 && this.Q.getVisibility() == 0) ? this.R.getMeasuredHeight() + paddingBottom : paddingBottom;
    }

    public final boolean n() {
        w3.z zVar = this.f1408w;
        return zVar.e() && Collections.unmodifiableList(zVar.f13088u).size() > 1;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1414z = true;
        this.f1404u.a(w3.o.f12981c, this.f1406v, 2);
        p(w3.b0.e());
    }

    @Override // f.g, f.d0, androidx.activity.p, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.mr_controller_material_dialog_b);
        findViewById(android.R.id.button3).setVisibility(8);
        n nVar = new n(this, 0);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mr_expandable_area);
        this.F = frameLayout;
        frameLayout.setOnClickListener(new n(this, 2));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mr_dialog_area);
        this.G = linearLayout;
        linearLayout.setOnClickListener(new i());
        Context context = this.f1410x;
        int n10 = i7.e.n(context, R.attr.colorPrimary);
        if (e0.a.c(n10, i7.e.n(context, android.R.attr.colorBackground)) < 3.0d) {
            n10 = i7.e.n(context, R.attr.colorAccent);
        }
        Button button = (Button) findViewById(android.R.id.button2);
        this.B = button;
        button.setText(R.string.mr_controller_disconnect);
        this.B.setTextColor(n10);
        this.B.setOnClickListener(nVar);
        Button button2 = (Button) findViewById(android.R.id.button1);
        this.C = button2;
        button2.setText(R.string.mr_controller_stop_casting);
        this.C.setTextColor(n10);
        this.C.setOnClickListener(nVar);
        this.L = (TextView) findViewById(R.id.mr_name);
        ((ImageButton) findViewById(R.id.mr_close)).setOnClickListener(nVar);
        this.H = (FrameLayout) findViewById(R.id.mr_default_control);
        n nVar2 = new n(this, 3);
        ImageView imageView = (ImageView) findViewById(R.id.mr_art);
        this.I = imageView;
        imageView.setOnClickListener(nVar2);
        findViewById(R.id.mr_control_title_container).setOnClickListener(nVar2);
        this.O = (LinearLayout) findViewById(R.id.mr_media_main_control);
        this.R = findViewById(R.id.mr_control_divider);
        this.P = (RelativeLayout) findViewById(R.id.mr_playback_control);
        this.J = (TextView) findViewById(R.id.mr_control_title);
        this.K = (TextView) findViewById(R.id.mr_control_subtitle);
        ImageButton imageButton = (ImageButton) findViewById(R.id.mr_control_playback_ctrl);
        this.D = imageButton;
        imageButton.setOnClickListener(nVar);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.mr_volume_control);
        this.Q = linearLayout2;
        linearLayout2.setVisibility(8);
        SeekBar seekBar = (SeekBar) findViewById(R.id.mr_volume_slider);
        this.Y = seekBar;
        w3.z zVar = this.f1408w;
        seekBar.setTag(zVar);
        q qVar = new q(this);
        this.Z = qVar;
        this.Y.setOnSeekBarChangeListener(qVar);
        this.S = (OverlayListView) findViewById(R.id.mr_volume_group_list);
        this.U = new ArrayList();
        r rVar = new r(this, this.S.getContext(), this.U);
        this.T = rVar;
        this.S.setAdapter((ListAdapter) rVar);
        this.X = new HashSet();
        LinearLayout linearLayout3 = this.O;
        OverlayListView overlayListView = this.S;
        boolean n11 = n();
        int n12 = i7.e.n(context, R.attr.colorPrimary);
        int n13 = i7.e.n(context, R.attr.colorPrimaryDark);
        if (n11 && i7.e.i(context) == -570425344) {
            n13 = n12;
            n12 = -1;
        }
        linearLayout3.setBackgroundColor(n12);
        overlayListView.setBackgroundColor(n13);
        linearLayout3.setTag(Integer.valueOf(n12));
        overlayListView.setTag(Integer.valueOf(n13));
        MediaRouteVolumeSlider mediaRouteVolumeSlider = (MediaRouteVolumeSlider) this.Y;
        LinearLayout linearLayout4 = this.O;
        int i10 = i7.e.i(context);
        if (Color.alpha(i10) != 255) {
            i10 = e0.a.f(i10, ((Integer) linearLayout4.getTag()).intValue());
        }
        mediaRouteVolumeSlider.a(i10, i10);
        HashMap hashMap = new HashMap();
        this.f1390f0 = hashMap;
        hashMap.put(zVar, this.Y);
        MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = (MediaRouteExpandCollapseButton) findViewById(R.id.mr_group_expand_collapse);
        this.E = mediaRouteExpandCollapseButton;
        mediaRouteExpandCollapseButton.f1255w = new n(this, 1);
        this.f1413y0 = this.f1402s0 ? this.f1415z0 : this.A0;
        this.f1407v0 = context.getResources().getInteger(R.integer.mr_controller_volume_group_list_animation_duration_ms);
        this.f1409w0 = context.getResources().getInteger(R.integer.mr_controller_volume_group_list_fade_in_duration_ms);
        this.f1411x0 = context.getResources().getInteger(R.integer.mr_controller_volume_group_list_fade_out_duration_ms);
        this.f1412y = true;
        s();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f1404u.i(this.f1406v);
        p(null);
        this.f1414z = false;
        super.onDetachedFromWindow();
    }

    @Override // f.g, android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 25 && i10 != 24) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (this.N || !this.f1402s0) {
            this.f1408w.k(i10 == 25 ? -1 : 1);
        }
        return true;
    }

    @Override // f.g, android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 == 25 || i10 == 24) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public final void p(MediaSessionCompat$Token mediaSessionCompat$Token) {
        MediaMetadataCompat mediaMetadataCompat;
        PlaybackStateCompat t3;
        x4.l lVar = this.f1391g0;
        p pVar = this.h0;
        if (lVar != null) {
            lVar.n(pVar);
            this.f1391g0 = null;
        }
        if (mediaSessionCompat$Token != null && this.f1414z) {
            x4.l lVar2 = new x4.l(this.f1410x, mediaSessionCompat$Token);
            this.f1391g0 = lVar2;
            lVar2.m(pVar);
            MediaMetadata metadata = ((android.support.v4.media.session.h) this.f1391g0.f13561o).f245a.getMetadata();
            if (metadata != null) {
                p.e eVar = MediaMetadataCompat.f186r;
                Parcel obtain = Parcel.obtain();
                metadata.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                mediaMetadataCompat = MediaMetadataCompat.CREATOR.createFromParcel(obtain);
                obtain.recycle();
                mediaMetadataCompat.f191p = metadata;
            } else {
                mediaMetadataCompat = null;
            }
            this.f1393j0 = mediaMetadataCompat == null ? null : mediaMetadataCompat.a();
            android.support.v4.media.session.h hVar = (android.support.v4.media.session.h) this.f1391g0.f13561o;
            MediaSessionCompat$Token mediaSessionCompat$Token2 = hVar.f249e;
            if (mediaSessionCompat$Token2.a() != null) {
                try {
                    t3 = mediaSessionCompat$Token2.a().t();
                } catch (RemoteException e7) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e7);
                }
                this.f1392i0 = t3;
                r();
                q(false);
            }
            PlaybackState playbackState = hVar.f245a.getPlaybackState();
            t3 = playbackState != null ? PlaybackStateCompat.a(playbackState) : null;
            this.f1392i0 = t3;
            r();
            q(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(boolean r13) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.s.q(boolean):void");
    }

    public final void r() {
        MediaDescriptionCompat mediaDescriptionCompat = this.f1393j0;
        Bitmap bitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.f181s;
        Uri uri = mediaDescriptionCompat != null ? mediaDescriptionCompat.f182t : null;
        o oVar = this.f1394k0;
        Bitmap bitmap2 = oVar == null ? this.f1395l0 : oVar.f1360a;
        Uri uri2 = oVar == null ? this.f1396m0 : oVar.f1361b;
        if (bitmap2 == bitmap) {
            if (bitmap2 != null) {
                return;
            }
            if (uri2 != null && uri2.equals(uri)) {
                return;
            }
            if (uri2 == null && uri == null) {
                return;
            }
        }
        if (!n() || this.N) {
            o oVar2 = this.f1394k0;
            if (oVar2 != null) {
                oVar2.cancel(true);
            }
            o oVar3 = new o(this);
            this.f1394k0 = oVar3;
            oVar3.execute(new Void[0]);
        }
    }

    public final void s() {
        Context context = this.f1410x;
        int i10 = com.google.android.gms.internal.cast.n.i(context);
        getWindow().setLayout(i10, -2);
        View decorView = getWindow().getDecorView();
        this.A = (i10 - decorView.getPaddingLeft()) - decorView.getPaddingRight();
        Resources resources = context.getResources();
        this.f1386b0 = resources.getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_item_icon_size);
        this.f1387c0 = resources.getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_item_height);
        this.f1388d0 = resources.getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_max_height);
        this.f1395l0 = null;
        this.f1396m0 = null;
        r();
        q(false);
    }

    public final void t(boolean z10) {
        this.H.requestLayout();
        this.H.getViewTreeObserver().addOnGlobalLayoutListener(new j(this, z10));
    }

    public final void u(boolean z10) {
        int i10 = 0;
        this.R.setVisibility((this.Q.getVisibility() == 0 && z10) ? 0 : 8);
        LinearLayout linearLayout = this.O;
        if (this.Q.getVisibility() == 8 && !z10) {
            i10 = 8;
        }
        linearLayout.setVisibility(i10);
    }
}
