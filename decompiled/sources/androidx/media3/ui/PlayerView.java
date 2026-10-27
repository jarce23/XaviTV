package androidx.media3.ui;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SurfaceSyncGroup;
import b0.j;
import i1.a;
import i1.f1;
import i1.m;
import i1.o0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import l1.d;
import o9.g0;
import p4.p;
import s1.a0;
import s1.l;
import u3.g;
import u3.n;
import u3.o;
import u3.t;
import u3.v;
import u3.w;
import u3.x;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class PlayerView extends FrameLayout {
    public static final /* synthetic */ int U = 0;
    public final FrameLayout A;
    public final FrameLayout B;
    public final Handler C;
    public final Class D;
    public final Method E;
    public final Object F;
    public o0 G;
    public boolean H;
    public n I;
    public int J;
    public int K;
    public Drawable L;
    public int M;
    public boolean N;
    public CharSequence O;
    public int P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;

    /* renamed from: o, reason: collision with root package name */
    public final v f1204o;

    /* renamed from: p, reason: collision with root package name */
    public final AspectRatioFrameLayout f1205p;

    /* renamed from: q, reason: collision with root package name */
    public final View f1206q;

    /* renamed from: r, reason: collision with root package name */
    public final View f1207r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f1208s;

    /* renamed from: t, reason: collision with root package name */
    public final p f1209t;

    /* renamed from: u, reason: collision with root package name */
    public final ImageView f1210u;

    /* renamed from: v, reason: collision with root package name */
    public final ImageView f1211v;

    /* renamed from: w, reason: collision with root package name */
    public final SubtitleView f1212w;

    /* renamed from: x, reason: collision with root package name */
    public final View f1213x;

    /* renamed from: y, reason: collision with root package name */
    public final TextView f1214y;

    /* renamed from: z, reason: collision with root package name */
    public final o f1215z;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PlayerView(android.content.Context r24, android.util.AttributeSet r25) {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static void a(PlayerView playerView, Bitmap bitmap) {
        playerView.setImage(new BitmapDrawable(playerView.getResources(), bitmap));
        if (playerView.c()) {
            return;
        }
        ImageView imageView = playerView.f1210u;
        if (imageView != null) {
            imageView.setVisibility(0);
            playerView.r();
        }
        View view = playerView.f1206q;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void setImage(Drawable drawable) {
        ImageView imageView = this.f1210u;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        r();
    }

    private void setImageOutput(o0 o0Var) {
        Class cls = this.D;
        if (cls == null || !cls.isAssignableFrom(o0Var.getClass())) {
            return;
        }
        try {
            Method method = this.E;
            method.getClass();
            Object obj = this.F;
            obj.getClass();
            method.invoke(o0Var, obj);
        } catch (IllegalAccessException | InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final boolean b() {
        o0 o0Var = this.G;
        return o0Var != null && this.F != null && ((j) o0Var).e(30) && ((a0) o0Var).B().a(4);
    }

    public final boolean c() {
        o0 o0Var = this.G;
        return o0Var != null && ((j) o0Var).e(30) && ((a0) o0Var).B().a(2);
    }

    public final void d() {
        ImageView imageView = this.f1210u;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        p pVar;
        SurfaceSyncGroup surfaceSyncGroup;
        super.dispatchDraw(canvas);
        if (Build.VERSION.SDK_INT != 34 || (pVar = this.f1209t) == null || !this.T || (surfaceSyncGroup = (SurfaceSyncGroup) pVar.f9953p) == null) {
            return;
        }
        surfaceSyncGroup.markSyncReady();
        pVar.f9953p = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        o0 o0Var = this.G;
        if (o0Var != null && ((j) o0Var).e(16) && ((a0) this.G).I()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z10 = keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23;
        o oVar = this.f1215z;
        if (z10 && s() && !oVar.j()) {
            f(true);
            return true;
        }
        if ((s() && oVar.d(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            f(true);
            return true;
        }
        if (z10 && s()) {
            f(true);
        }
        return false;
    }

    public final boolean e() {
        o0 o0Var = this.G;
        return o0Var != null && ((j) o0Var).e(16) && ((a0) this.G).I() && ((a0) this.G).E();
    }

    public final void f(boolean z10) {
        if (!(e() && this.R) && s()) {
            o oVar = this.f1215z;
            boolean z11 = oVar.j() && oVar.getShowTimeoutMs() <= 0;
            boolean j10 = j();
            if (z10 || z11 || j10) {
                k(j10);
            }
        }
    }

    public final void g() {
        View view = this.f1207r;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public List<a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            arrayList.add(new a(frameLayout));
        }
        o oVar = this.f1215z;
        if (oVar != null) {
            arrayList.add(new a(oVar));
        }
        return g0.n(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.A;
        d.i("exo_ad_overlay must be present for ad playback", frameLayout);
        return frameLayout;
    }

    public int getArtworkDisplayMode() {
        return this.J;
    }

    public boolean getControllerAutoShow() {
        return this.Q;
    }

    public boolean getControllerHideOnTouch() {
        return this.S;
    }

    public int getControllerShowTimeoutMs() {
        return this.P;
    }

    public Drawable getDefaultArtwork() {
        return this.L;
    }

    public int getImageDisplayMode() {
        return this.K;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.B;
    }

    public o0 getPlayer() {
        return this.G;
    }

    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1205p;
        d.h(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.f1212w;
    }

    @Deprecated
    public boolean getUseArtwork() {
        return this.J != 0;
    }

    public boolean getUseController() {
        return this.H;
    }

    public View getVideoSurfaceView() {
        return this.f1207r;
    }

    public final void h() {
        View view = this.f1207r;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    public final boolean i(Drawable drawable) {
        ImageView imageView = this.f1211v;
        if (imageView != null && drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f10 = intrinsicWidth / intrinsicHeight;
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.J == 2) {
                    f10 = getWidth() / getHeight();
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                AspectRatioFrameLayout aspectRatioFrameLayout = this.f1205p;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(f10);
                }
                imageView.setScaleType(scaleType);
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean j() {
        o0 o0Var = this.G;
        if (o0Var == null) {
            return true;
        }
        int F = ((a0) o0Var).F();
        if (!this.Q) {
            return false;
        }
        if (((j) this.G).e(17) && ((a0) this.G).A().p()) {
            return false;
        }
        if (F != 1 && F != 4) {
            o0 o0Var2 = this.G;
            o0Var2.getClass();
            if (((a0) o0Var2).E()) {
                return false;
            }
        }
        return true;
    }

    public final void k(boolean z10) {
        if (s()) {
            int i10 = z10 ? 0 : this.P;
            o oVar = this.f1215z;
            oVar.setShowTimeoutMs(i10);
            t tVar = oVar.f12446o;
            o oVar2 = tVar.f12479a;
            if (!oVar2.l()) {
                oVar2.setVisibility(0);
                oVar2.m();
                ImageView imageView = oVar2.I;
                if (imageView != null) {
                    imageView.requestFocus();
                }
            }
            tVar.k();
        }
    }

    public final void l() {
        if (!s() || this.G == null) {
            return;
        }
        o oVar = this.f1215z;
        if (!oVar.j()) {
            f(true);
        } else if (this.S) {
            oVar.g();
        }
    }

    public final void m() {
        f1 f1Var;
        o0 o0Var = this.G;
        if (o0Var != null) {
            a0 a0Var = (a0) o0Var;
            a0Var.f0();
            f1Var = a0Var.f11199j0;
        } else {
            f1Var = f1.f5878d;
        }
        int i10 = f1Var.f5879a;
        int i11 = f1Var.f5880b;
        float f10 = this.f1208s ? 0.0f : (i11 == 0 || i10 == 0) ? 0.0f : (i10 * f1Var.f5881c) / i11;
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1205p;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if (((s1.a0) r5.G).E() == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            r5 = this;
            android.view.View r0 = r5.f1213x
            if (r0 == 0) goto L2d
            i1.o0 r1 = r5.G
            r2 = 0
            if (r1 == 0) goto L24
            s1.a0 r1 = (s1.a0) r1
            int r1 = r1.F()
            r3 = 2
            if (r1 != r3) goto L24
            int r1 = r5.M
            r4 = 1
            if (r1 == r3) goto L25
            if (r1 != r4) goto L24
            i1.o0 r1 = r5.G
            s1.a0 r1 = (s1.a0) r1
            boolean r1 = r1.E()
            if (r1 == 0) goto L24
            goto L25
        L24:
            r4 = r2
        L25:
            if (r4 == 0) goto L28
            goto L2a
        L28:
            r2 = 8
        L2a:
            r0.setVisibility(r2)
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.n():void");
    }

    public final void o() {
        o oVar = this.f1215z;
        if (oVar == null || !this.H) {
            setContentDescription(null);
        } else if (oVar.j()) {
            setContentDescription(this.S ? getResources().getString(org.chromium.net.R.string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(org.chromium.net.R.string.exo_controls_show));
        }
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!s() || this.G == null) {
            return false;
        }
        f(true);
        return true;
    }

    public final void p() {
        TextView textView = this.f1214y;
        if (textView != null) {
            CharSequence charSequence = this.O;
            if (charSequence != null) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                return;
            }
            o0 o0Var = this.G;
            if (o0Var != null) {
                a0 a0Var = (a0) o0Var;
                a0Var.f0();
                l lVar = a0Var.f11203l0.f11498f;
            }
            textView.setVisibility(8);
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        l();
        return super.performClick();
    }

    public final void q(boolean z10) {
        Drawable drawable;
        o0 o0Var = this.G;
        boolean z11 = false;
        boolean z12 = (o0Var == null || !((j) o0Var).e(30) || ((a0) o0Var).B().f5812a.isEmpty()) ? false : true;
        boolean z13 = this.N;
        ImageView imageView = this.f1211v;
        View view = this.f1206q;
        if (!z13 && (!z12 || z10)) {
            if (imageView != null) {
                imageView.setImageResource(R.color.transparent);
                imageView.setVisibility(4);
            }
            if (view != null) {
                view.setVisibility(0);
            }
            d();
        }
        if (z12) {
            boolean c10 = c();
            boolean b2 = b();
            if (!c10 && !b2) {
                if (view != null) {
                    view.setVisibility(0);
                }
                d();
            }
            ImageView imageView2 = this.f1210u;
            boolean z14 = (view == null || view.getVisibility() != 4 || imageView2 == null || (drawable = imageView2.getDrawable()) == null || drawable.getAlpha() == 0) ? false : true;
            if (b2 && !c10 && z14) {
                if (view != null) {
                    view.setVisibility(0);
                }
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    r();
                }
            } else if (c10 && !b2 && z14) {
                d();
            }
            if (!c10 && !b2 && this.J != 0) {
                d.h(imageView);
                if (o0Var != null && ((j) o0Var).e(18)) {
                    a0 a0Var = (a0) o0Var;
                    a0Var.f0();
                    byte[] bArr = a0Var.S.f5850f;
                    if (bArr != null) {
                        z11 = i(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                    }
                }
                if (z11 || i(this.L)) {
                    return;
                }
            }
            if (imageView != null) {
                imageView.setImageResource(R.color.transparent);
                imageView.setVisibility(4);
            }
        }
    }

    public final void r() {
        Drawable drawable;
        AspectRatioFrameLayout aspectRatioFrameLayout;
        ImageView imageView = this.f1210u;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return;
        }
        float f10 = intrinsicWidth / intrinsicHeight;
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        if (this.K == 1) {
            f10 = getWidth() / getHeight();
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        if (imageView.getVisibility() == 0 && (aspectRatioFrameLayout = this.f1205p) != null) {
            aspectRatioFrameLayout.setAspectRatio(f10);
        }
        imageView.setScaleType(scaleType);
    }

    public final boolean s() {
        if (!this.H) {
            return false;
        }
        d.h(this.f1215z);
        return true;
    }

    public void setArtworkDisplayMode(int i10) {
        d.g(i10 == 0 || this.f1211v != null);
        if (this.J != i10) {
            this.J = i10;
            q(false);
        }
    }

    public void setAspectRatioListener(u3.a aVar) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1205p;
        d.h(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(aVar);
    }

    public void setControllerAnimationEnabled(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setAnimationEnabled(z10);
    }

    public void setControllerAutoShow(boolean z10) {
        this.Q = z10;
    }

    public void setControllerHideDuringAds(boolean z10) {
        this.R = z10;
    }

    public void setControllerHideOnTouch(boolean z10) {
        d.h(this.f1215z);
        this.S = z10;
        o();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(g gVar) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setOnFullScreenModeChangedListener(gVar);
    }

    public void setControllerShowTimeoutMs(int i10) {
        o oVar = this.f1215z;
        d.h(oVar);
        this.P = i10;
        if (oVar.j()) {
            k(j());
        }
    }

    public void setControllerVisibilityListener(w wVar) {
        if (wVar != null) {
            setControllerVisibilityListener((n) null);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        d.g(this.f1214y != null);
        this.O = charSequence;
        p();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.L != drawable) {
            this.L = drawable;
            q(false);
        }
    }

    public void setEnableComposeSurfaceSyncWorkaround(boolean z10) {
        this.T = z10;
    }

    public void setErrorMessageProvider(m mVar) {
        if (mVar != null) {
            p();
        }
    }

    public void setFullscreenButtonClickListener(x xVar) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setOnFullScreenModeChangedListener(this.f1204o);
    }

    public void setFullscreenButtonState(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.o(z10);
    }

    public void setImageDisplayMode(int i10) {
        d.g(this.f1210u != null);
        if (this.K != i10) {
            this.K = i10;
            r();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z10) {
        if (this.N != z10) {
            this.N = z10;
            q(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x01e9, code lost:
    
        if (r2 != false) goto L99;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setPlayer(i1.o0 r12) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.setPlayer(i1.o0):void");
    }

    public void setRepeatToggleModes(int i10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setRepeatToggleModes(i10);
    }

    public void setResizeMode(int i10) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1205p;
        d.h(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i10);
    }

    public void setShowBuffering(int i10) {
        if (this.M != i10) {
            this.M = i10;
            n();
        }
    }

    public void setShowFastForwardButton(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setShowFastForwardButton(z10);
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setShowMultiWindowTimeBar(z10);
    }

    public void setShowNextButton(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setShowNextButton(z10);
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setShowPlayButtonIfPlaybackIsSuppressed(z10);
    }

    public void setShowPreviousButton(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setShowPreviousButton(z10);
    }

    public void setShowRewindButton(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setShowRewindButton(z10);
    }

    public void setShowShuffleButton(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setShowShuffleButton(z10);
    }

    public void setShowSubtitleButton(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setShowSubtitleButton(z10);
    }

    public void setShowVrButton(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setShowVrButton(z10);
    }

    public void setShutterBackgroundColor(int i10) {
        View view = this.f1206q;
        if (view != null) {
            view.setBackgroundColor(i10);
        }
    }

    public void setTimeBarScrubbingEnabled(boolean z10) {
        o oVar = this.f1215z;
        d.h(oVar);
        oVar.setTimeBarScrubbingEnabled(z10);
    }

    @Deprecated
    public void setUseArtwork(boolean z10) {
        setArtworkDisplayMode(!z10 ? 1 : 0);
    }

    public void setUseController(boolean z10) {
        boolean z11 = true;
        o oVar = this.f1215z;
        d.g((z10 && oVar == null) ? false : true);
        if (!z10 && !hasOnClickListeners()) {
            z11 = false;
        }
        setClickable(z11);
        if (this.H == z10) {
            return;
        }
        this.H = z10;
        if (s()) {
            oVar.setPlayer(this.G);
        } else if (oVar != null) {
            oVar.g();
            oVar.setPlayer(null);
        }
        o();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        View view = this.f1207r;
        if (view instanceof SurfaceView) {
            view.setVisibility(i10);
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(n nVar) {
        o oVar = this.f1215z;
        d.h(oVar);
        CopyOnWriteArrayList copyOnWriteArrayList = oVar.f12464x;
        n nVar2 = this.I;
        if (nVar2 == nVar) {
            return;
        }
        if (nVar2 != null) {
            copyOnWriteArrayList.remove(nVar2);
        }
        this.I = nVar;
        if (nVar != null) {
            copyOnWriteArrayList.add(nVar);
            setControllerVisibilityListener((w) null);
        }
    }
}
