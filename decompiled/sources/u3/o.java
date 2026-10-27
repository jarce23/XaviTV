package u3;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import i1.a1;
import i1.b1;
import i1.o0;
import i1.r0;
import i1.s0;
import i1.t0;
import i1.z0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import o9.w0;
import org.chromium.net.R;
import s1.y0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o extends FrameLayout {
    public static final float[] U0;
    public final d5.e A;
    public final Drawable A0;
    public final e B;
    public final String B0;
    public final e C;
    public final String C0;
    public final f6.a D;
    public o0 D0;
    public final PopupWindow E;
    public boolean E0;
    public final int F;
    public boolean F0;
    public final ImageView G;
    public boolean G0;
    public final ImageView H;
    public boolean H0;
    public final ImageView I;
    public boolean I0;
    public final View J;
    public boolean J0;
    public final View K;
    public int K0;
    public final TextView L;
    public boolean L0;
    public final TextView M;
    public int M0;
    public final ImageView N;
    public int N0;
    public final ImageView O;
    public long[] O0;
    public final ImageView P;
    public boolean[] P0;
    public final ImageView Q;
    public final long[] Q0;
    public final ImageView R;
    public final boolean[] R0;
    public final ImageView S;
    public long S0;
    public final View T;
    public boolean T0;
    public final View U;
    public final View V;
    public final TextView W;

    /* renamed from: a0, reason: collision with root package name */
    public final TextView f12433a0;

    /* renamed from: b0, reason: collision with root package name */
    public final f0 f12434b0;

    /* renamed from: c0, reason: collision with root package name */
    public final StringBuilder f12435c0;

    /* renamed from: d0, reason: collision with root package name */
    public final Formatter f12436d0;

    /* renamed from: e0, reason: collision with root package name */
    public final r0 f12437e0;

    /* renamed from: f0, reason: collision with root package name */
    public final s0 f12438f0;

    /* renamed from: g0, reason: collision with root package name */
    public final androidx.activity.d f12439g0;
    public final Drawable h0;

    /* renamed from: i0, reason: collision with root package name */
    public final Drawable f12440i0;

    /* renamed from: j0, reason: collision with root package name */
    public final Drawable f12441j0;

    /* renamed from: k0, reason: collision with root package name */
    public final Drawable f12442k0;

    /* renamed from: l0, reason: collision with root package name */
    public final Drawable f12443l0;

    /* renamed from: m0, reason: collision with root package name */
    public final String f12444m0;

    /* renamed from: n0, reason: collision with root package name */
    public final String f12445n0;

    /* renamed from: o, reason: collision with root package name */
    public final t f12446o;

    /* renamed from: o0, reason: collision with root package name */
    public final String f12447o0;

    /* renamed from: p, reason: collision with root package name */
    public final Resources f12448p;

    /* renamed from: p0, reason: collision with root package name */
    public final Drawable f12449p0;

    /* renamed from: q, reason: collision with root package name */
    public final f f12450q;

    /* renamed from: q0, reason: collision with root package name */
    public final Drawable f12451q0;

    /* renamed from: r, reason: collision with root package name */
    public final Class f12452r;

    /* renamed from: r0, reason: collision with root package name */
    public final float f12453r0;

    /* renamed from: s, reason: collision with root package name */
    public final Method f12454s;

    /* renamed from: s0, reason: collision with root package name */
    public final float f12455s0;

    /* renamed from: t, reason: collision with root package name */
    public final Method f12456t;

    /* renamed from: t0, reason: collision with root package name */
    public final String f12457t0;

    /* renamed from: u, reason: collision with root package name */
    public final Class f12458u;

    /* renamed from: u0, reason: collision with root package name */
    public final String f12459u0;

    /* renamed from: v, reason: collision with root package name */
    public final Method f12460v;

    /* renamed from: v0, reason: collision with root package name */
    public final Drawable f12461v0;

    /* renamed from: w, reason: collision with root package name */
    public final Method f12462w;

    /* renamed from: w0, reason: collision with root package name */
    public final Drawable f12463w0;

    /* renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArrayList f12464x;

    /* renamed from: x0, reason: collision with root package name */
    public final String f12465x0;

    /* renamed from: y, reason: collision with root package name */
    public final RecyclerView f12466y;

    /* renamed from: y0, reason: collision with root package name */
    public final String f12467y0;

    /* renamed from: z, reason: collision with root package name */
    public final d5.g f12468z;

    /* renamed from: z0, reason: collision with root package name */
    public final Drawable f12469z0;

    static {
        i1.b0.a("media3.ui");
        U0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Can't wrap try/catch for region: R(61:0|1|(4:3|4|5|6)(1:119)|7|8|9|10|(3:11|12|13)|(3:14|15|16)|17|18|19|20|21|22|23|24|25|26|(1:28)|29|(1:31)(1:102)|32|(1:34)|35|(1:37)|38|(1:40)|41|(1:43)|44|(1:46)(1:(1:100)(1:101))|47|(1:49)|50|(1:52)|53|(1:55)|56|(1:58)|59|(1:61)(1:98)|62|(1:64)(2:94|(1:96)(1:97))|65|(1:67)|68|(1:70)(2:90|(1:92)(1:93))|71|(1:73)|74|(1:76)|77|(1:79)|80|(1:82)|83|(1:85)(1:89)|86|87|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(63:0|1|(4:3|4|5|6)(1:119)|7|8|9|10|11|12|13|(3:14|15|16)|17|18|19|20|21|22|23|24|25|26|(1:28)|29|(1:31)(1:102)|32|(1:34)|35|(1:37)|38|(1:40)|41|(1:43)|44|(1:46)(1:(1:100)(1:101))|47|(1:49)|50|(1:52)|53|(1:55)|56|(1:58)|59|(1:61)(1:98)|62|(1:64)(2:94|(1:96)(1:97))|65|(1:67)|68|(1:70)(2:90|(1:92)(1:93))|71|(1:73)|74|(1:76)|77|(1:79)|80|(1:82)|83|(1:85)(1:89)|86|87|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x022d, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0229, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x022b, code lost:
    
        r5 = null;
        r7 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0641  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02d9  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o(android.content.Context r51, android.util.AttributeSet r52) {
        /*
            Method dump skipped, instructions count: 1617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.o.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static void a(o oVar, o0 o0Var, long j10) {
        if (oVar.I0) {
            b0.j jVar = (b0.j) o0Var;
            if (jVar.e(17) && jVar.e(10)) {
                t0 A = ((s1.a0) jVar).A();
                int o2 = A.o();
                int i10 = 0;
                while (true) {
                    long Z = l1.a0.Z(A.m(i10, oVar.f12438f0, 0L).f6032m);
                    if (j10 < Z) {
                        break;
                    }
                    if (i10 == o2 - 1) {
                        j10 = Z;
                        break;
                    } else {
                        j10 -= Z;
                        i10++;
                    }
                }
                jVar.k(i10, j10, false);
            }
        } else {
            b0.j jVar2 = (b0.j) o0Var;
            if (jVar2.e(5)) {
                jVar2.l(5, j10);
            }
        }
        oVar.s();
    }

    public static boolean c(o0 o0Var, s0 s0Var) {
        t0 A;
        int o2;
        b0.j jVar = (b0.j) o0Var;
        if (!jVar.e(17) || (o2 = (A = ((s1.a0) jVar).A()).o()) <= 1 || o2 > 100) {
            return false;
        }
        for (int i10 = 0; i10 < o2; i10++) {
            if (A.m(i10, s0Var, 0L).f6032m == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f10) {
        o0 o0Var = this.D0;
        if (o0Var == null || !((b0.j) o0Var).e(13)) {
            return;
        }
        s1.a0 a0Var = (s1.a0) this.D0;
        a0Var.f0();
        i1.j0 j0Var = new i1.j0(f10, a0Var.f11203l0.f11506o.f5907b);
        a0Var.f0();
        if (a0Var.f11203l0.f11506o.equals(j0Var)) {
            return;
        }
        y0 g = a0Var.f11203l0.g(j0Var);
        a0Var.I++;
        a0Var.f11202l.f11343v.a(4, j0Var).b();
        a0Var.d0(g, 0, false, 5, -9223372036854775807L, -1, false);
    }

    public final boolean d(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        o0 o0Var = this.D0;
        if (o0Var == null || !(keyCode == 90 || keyCode == 89 || keyCode == 85 || keyCode == 79 || keyCode == 126 || keyCode == 127 || keyCode == 87 || keyCode == 88)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode != 90) {
                if (keyCode == 89) {
                    b0.j jVar = (b0.j) o0Var;
                    if (jVar.e(11)) {
                        s1.a0 a0Var = (s1.a0) jVar;
                        a0Var.f0();
                        jVar.n(11, -a0Var.f11215v);
                    }
                }
                if (keyEvent.getRepeatCount() == 0) {
                    if (keyCode == 79 || keyCode == 85) {
                        if (l1.a0.X(o0Var, this.H0)) {
                            l1.a0.F(o0Var);
                        } else {
                            b0.j jVar2 = (b0.j) o0Var;
                            if (jVar2.e(1)) {
                                ((s1.a0) jVar2).U(false);
                            }
                        }
                    } else if (keyCode == 87) {
                        b0.j jVar3 = (b0.j) o0Var;
                        if (jVar3.e(9)) {
                            jVar3.m();
                        }
                    } else if (keyCode == 88) {
                        b0.j jVar4 = (b0.j) o0Var;
                        if (jVar4.e(7)) {
                            jVar4.o();
                        }
                    } else if (keyCode == 126) {
                        l1.a0.F(o0Var);
                    } else if (keyCode == 127) {
                        int i10 = l1.a0.f8067a;
                        b0.j jVar5 = (b0.j) o0Var;
                        if (jVar5.e(1)) {
                            ((s1.a0) jVar5).U(false);
                        }
                    }
                }
            } else if (((s1.a0) o0Var).F() != 4) {
                b0.j jVar6 = (b0.j) o0Var;
                if (jVar6.e(12)) {
                    s1.a0 a0Var2 = (s1.a0) jVar6;
                    a0Var2.f0();
                    jVar6.n(12, a0Var2.f11216w);
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final void e(b4.f0 f0Var, View view) {
        this.f12466y.setAdapter(f0Var);
        u();
        this.T0 = false;
        PopupWindow popupWindow = this.E;
        popupWindow.dismiss();
        this.T0 = true;
        int width = getWidth() - popupWindow.getWidth();
        int i10 = this.F;
        popupWindow.showAsDropDown(view, width - i10, (-popupWindow.getHeight()) - i10);
    }

    public final w0 f(b1 b1Var, int i10) {
        o9.q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        o9.g0 g0Var = b1Var.f5812a;
        int i11 = 0;
        for (int i12 = 0; i12 < g0Var.size(); i12++) {
            a1 a1Var = (a1) g0Var.get(i12);
            if (a1Var.f5799b.f6041c == i10) {
                for (int i13 = 0; i13 < a1Var.f5798a; i13++) {
                    if (a1Var.a(i13)) {
                        i1.p pVar = a1Var.f5799b.f6042d[i13];
                        if ((pVar.f5983e & 2) == 0) {
                            l lVar = new l(b1Var, i12, i13, this.D.c(pVar));
                            int i14 = i11 + 1;
                            int e7 = o9.a0.e(objArr.length, i14);
                            if (e7 > objArr.length) {
                                objArr = Arrays.copyOf(objArr, e7);
                            }
                            objArr[i11] = lVar;
                            i11 = i14;
                        }
                    }
                }
            }
        }
        return o9.g0.l(i11, objArr);
    }

    public final void g() {
        t tVar = this.f12446o;
        int i10 = tVar.f12503z;
        if (i10 == 3 || i10 == 2) {
            return;
        }
        tVar.f();
        if (!tVar.C) {
            tVar.i(2);
        } else if (tVar.f12503z == 1) {
            tVar.f12490m.start();
        } else {
            tVar.f12491n.start();
        }
    }

    public o0 getPlayer() {
        return this.D0;
    }

    public int getRepeatToggleModes() {
        return this.N0;
    }

    public boolean getShowShuffleButton() {
        return this.f12446o.b(this.O);
    }

    public boolean getShowSubtitleButton() {
        return this.f12446o.b(this.Q);
    }

    public int getShowTimeoutMs() {
        return this.K0;
    }

    public boolean getShowVrButton() {
        return this.f12446o.b(this.P);
    }

    public final boolean h(o0 o0Var) {
        Class cls;
        return (o0Var == null || (cls = this.f12458u) == null || !cls.isAssignableFrom(o0Var.getClass())) ? false : true;
    }

    public final boolean i(o0 o0Var) {
        Class cls;
        return (o0Var == null || (cls = this.f12452r) == null || !cls.isAssignableFrom(o0Var.getClass())) ? false : true;
    }

    public final boolean j() {
        t tVar = this.f12446o;
        return tVar.f12503z == 0 && tVar.f12479a.l();
    }

    public final boolean k(o0 o0Var) {
        try {
            if (i(o0Var)) {
                Method method = this.f12456t;
                method.getClass();
                Object invoke = method.invoke(o0Var, null);
                invoke.getClass();
                if (((Boolean) invoke).booleanValue()) {
                    return true;
                }
            }
            if (!h(o0Var)) {
                return false;
            }
            Method method2 = this.f12462w;
            method2.getClass();
            Object invoke2 = method2.invoke(o0Var, null);
            invoke2.getClass();
            return ((Boolean) invoke2).booleanValue();
        } catch (IllegalAccessException e7) {
            e = e7;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e8) {
            e = e8;
            throw new RuntimeException(e);
        }
    }

    public final boolean l() {
        return getVisibility() == 0;
    }

    public final void m() {
        q();
        p();
        t();
        v();
        x();
        r();
        w();
    }

    public final void n(View view, boolean z10) {
        if (view == null) {
            return;
        }
        view.setEnabled(z10);
        view.setAlpha(z10 ? this.f12453r0 : this.f12455s0);
    }

    public final void o(boolean z10) {
        if (this.E0 == z10) {
            return;
        }
        this.E0 = z10;
        String str = this.C0;
        Drawable drawable = this.A0;
        String str2 = this.B0;
        Drawable drawable2 = this.f12469z0;
        ImageView imageView = this.R;
        if (imageView != null) {
            if (z10) {
                imageView.setImageDrawable(drawable2);
                imageView.setContentDescription(str2);
            } else {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            }
        }
        ImageView imageView2 = this.S;
        if (imageView2 == null) {
            return;
        }
        if (z10) {
            imageView2.setImageDrawable(drawable2);
            imageView2.setContentDescription(str2);
        } else {
            imageView2.setImageDrawable(drawable);
            imageView2.setContentDescription(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        t tVar = this.f12446o;
        tVar.f12479a.addOnLayoutChangeListener(tVar.f12501x);
        this.F0 = true;
        if (j()) {
            tVar.g();
        }
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t tVar = this.f12446o;
        tVar.f12479a.removeOnLayoutChangeListener(tVar.f12501x);
        this.F0 = false;
        removeCallbacks(this.f12439g0);
        tVar.f();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f12446o.f12480b;
        if (view != null) {
            view.layout(0, 0, i12 - i10, i13 - i11);
        }
    }

    public final void p() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        long j10;
        long j11;
        if (l() && this.F0) {
            o0 o0Var = this.D0;
            if (o0Var != null) {
                z11 = (this.G0 && c(o0Var, this.f12438f0)) ? ((b0.j) o0Var).e(10) : ((b0.j) o0Var).e(5);
                b0.j jVar = (b0.j) o0Var;
                z12 = jVar.e(7);
                z13 = jVar.e(11);
                z14 = jVar.e(12);
                z10 = jVar.e(9);
            } else {
                z10 = false;
                z11 = false;
                z12 = false;
                z13 = false;
                z14 = false;
            }
            Resources resources = this.f12448p;
            View view = this.K;
            if (z13) {
                o0 o0Var2 = this.D0;
                if (o0Var2 != null) {
                    s1.a0 a0Var = (s1.a0) o0Var2;
                    a0Var.f0();
                    j11 = a0Var.f11215v;
                } else {
                    j11 = 5000;
                }
                int i10 = (int) (j11 / 1000);
                TextView textView = this.M;
                if (textView != null) {
                    textView.setText(String.valueOf(i10));
                }
                if (view != null) {
                    view.setContentDescription(resources.getQuantityString(R.plurals.exo_controls_rewind_by_amount_description, i10, Integer.valueOf(i10)));
                }
            }
            View view2 = this.J;
            if (z14) {
                o0 o0Var3 = this.D0;
                if (o0Var3 != null) {
                    s1.a0 a0Var2 = (s1.a0) o0Var3;
                    a0Var2.f0();
                    j10 = a0Var2.f11216w;
                } else {
                    j10 = 15000;
                }
                int i11 = (int) (j10 / 1000);
                TextView textView2 = this.L;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(i11));
                }
                if (view2 != null) {
                    view2.setContentDescription(resources.getQuantityString(R.plurals.exo_controls_fastforward_by_amount_description, i11, Integer.valueOf(i11)));
                }
            }
            n(this.G, z12);
            n(view, z13);
            n(view2, z14);
            n(this.H, z10);
            f0 f0Var = this.f12434b0;
            if (f0Var != null) {
                ((d) f0Var).setEnabled(z11);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
    
        if (((s1.a0) r1).A().p() == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q() {
        /*
            r5 = this;
            boolean r0 = r5.l()
            if (r0 == 0) goto L5a
            boolean r0 = r5.F0
            if (r0 != 0) goto Lb
            goto L5a
        Lb:
            android.widget.ImageView r0 = r5.I
            if (r0 == 0) goto L5a
            i1.o0 r1 = r5.D0
            boolean r2 = r5.H0
            boolean r1 = l1.a0.X(r1, r2)
            if (r1 == 0) goto L1c
            android.graphics.drawable.Drawable r2 = r5.h0
            goto L1e
        L1c:
            android.graphics.drawable.Drawable r2 = r5.f12440i0
        L1e:
            if (r1 == 0) goto L24
            r1 = 2131951749(0x7f130085, float:1.9539921E38)
            goto L27
        L24:
            r1 = 2131951748(0x7f130084, float:1.953992E38)
        L27:
            r0.setImageDrawable(r2)
            android.content.res.Resources r2 = r5.f12448p
            java.lang.String r1 = r2.getString(r1)
            r0.setContentDescription(r1)
            i1.o0 r1 = r5.D0
            if (r1 == 0) goto L56
            r2 = r1
            b0.j r2 = (b0.j) r2
            r3 = 1
            boolean r4 = r2.e(r3)
            if (r4 == 0) goto L56
            r4 = 17
            boolean r2 = r2.e(r4)
            if (r2 == 0) goto L57
            s1.a0 r1 = (s1.a0) r1
            i1.t0 r1 = r1.A()
            boolean r1 = r1.p()
            if (r1 != 0) goto L56
            goto L57
        L56:
            r3 = 0
        L57:
            r5.n(r0, r3)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.o.q():void");
    }

    public final void r() {
        d5.e eVar;
        o0 o0Var = this.D0;
        if (o0Var == null) {
            return;
        }
        s1.a0 a0Var = (s1.a0) o0Var;
        a0Var.f0();
        float f10 = a0Var.f11203l0.f11506o.f5906a;
        float f11 = Float.MAX_VALUE;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            eVar = this.A;
            float[] fArr = (float[]) eVar.g;
            if (i10 >= fArr.length) {
                break;
            }
            float abs = Math.abs(f10 - fArr[i10]);
            if (abs < f11) {
                i11 = i10;
                f11 = abs;
            }
            i10++;
        }
        eVar.f4086e = i11;
        String str = ((String[]) eVar.f4087f)[i11];
        d5.g gVar = this.f12468z;
        ((String[]) gVar.f4102f)[0] = str;
        n(this.T, gVar.n(1) || gVar.n(0));
    }

    public final void s() {
        long j10;
        long Z;
        if (l() && this.F0) {
            o0 o0Var = this.D0;
            long j11 = 0;
            if (o0Var == null || !((b0.j) o0Var).e(16)) {
                j10 = 0;
            } else {
                long j12 = this.S0;
                s1.a0 a0Var = (s1.a0) o0Var;
                a0Var.f0();
                long u10 = a0Var.u(a0Var.f11203l0) + j12;
                long j13 = this.S0;
                a0Var.f0();
                if (a0Var.f11203l0.f11493a.p()) {
                    Z = a0Var.f11207n0;
                } else {
                    y0 y0Var = a0Var.f11203l0;
                    if (y0Var.f11502k.f2542d != y0Var.f11494b.f2542d) {
                        Z = l1.a0.Z(y0Var.f11493a.m(a0Var.x(), (s0) a0Var.f2162a, 0L).f6032m);
                    } else {
                        long j14 = y0Var.f11508q;
                        if (a0Var.f11203l0.f11502k.b()) {
                            y0 y0Var2 = a0Var.f11203l0;
                            y0Var2.f11493a.g(y0Var2.f11502k.f2539a, a0Var.f11208o).d(a0Var.f11203l0.f11502k.f2540b);
                        } else {
                            j11 = j14;
                        }
                        y0 y0Var3 = a0Var.f11203l0;
                        t0 t0Var = y0Var3.f11493a;
                        Object obj = y0Var3.f11502k.f2539a;
                        r0 r0Var = a0Var.f11208o;
                        t0Var.g(obj, r0Var);
                        Z = l1.a0.Z(j11 + r0Var.f6016e);
                    }
                }
                j10 = Z + j13;
                j11 = u10;
            }
            TextView textView = this.f12433a0;
            if (textView != null && !this.J0) {
                textView.setText(l1.a0.C(this.f12435c0, this.f12436d0, j11));
            }
            f0 f0Var = this.f12434b0;
            if (f0Var != null) {
                ((d) f0Var).setPosition(j11);
                f0 f0Var2 = this.f12434b0;
                if (k(o0Var)) {
                    j10 = j11;
                }
                ((d) f0Var2).setBufferedPosition(j10);
            }
            removeCallbacks(this.f12439g0);
            int F = o0Var == null ? 1 : ((s1.a0) o0Var).F();
            if (o0Var != null) {
                s1.a0 a0Var2 = (s1.a0) ((b0.j) o0Var);
                if (a0Var2.F() == 3 && a0Var2.E()) {
                    a0Var2.f0();
                    if (a0Var2.f11203l0.f11505n == 0) {
                        f0 f0Var3 = this.f12434b0;
                        long min = Math.min(f0Var3 != null ? ((d) f0Var3).getPreferredUpdateDelay() : 1000L, 1000 - (j11 % 1000));
                        s1.a0 a0Var3 = (s1.a0) o0Var;
                        a0Var3.f0();
                        float f10 = a0Var3.f11203l0.f11506o.f5906a;
                        postDelayed(this.f12439g0, l1.a0.j(f10 > 0.0f ? (long) (min / f10) : 1000L, this.M0, 1000L));
                        return;
                    }
                }
            }
            if (F == 4 || F == 1) {
                return;
            }
            postDelayed(this.f12439g0, 1000L);
        }
    }

    public void setAnimationEnabled(boolean z10) {
        this.f12446o.C = z10;
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(g gVar) {
        boolean z10 = gVar != null;
        ImageView imageView = this.R;
        if (imageView != null) {
            if (z10) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        boolean z11 = gVar != null;
        ImageView imageView2 = this.S;
        if (imageView2 == null) {
            return;
        }
        if (z11) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
    }

    public void setPlayer(o0 o0Var) {
        l1.d.g(Looper.myLooper() == Looper.getMainLooper());
        l1.d.b(o0Var == null || ((s1.a0) o0Var).f11213t == Looper.getMainLooper());
        o0 o0Var2 = this.D0;
        if (o0Var2 == o0Var) {
            return;
        }
        f fVar = this.f12450q;
        if (o0Var2 != null) {
            ((s1.a0) o0Var2).P(fVar);
        }
        this.D0 = o0Var;
        if (o0Var != null) {
            l1.p pVar = ((s1.a0) o0Var).f11204m;
            fVar.getClass();
            pVar.a(fVar);
        }
        m();
    }

    public void setRepeatToggleModes(int i10) {
        this.N0 = i10;
        o0 o0Var = this.D0;
        if (o0Var != null && ((b0.j) o0Var).e(15)) {
            s1.a0 a0Var = (s1.a0) this.D0;
            a0Var.f0();
            int i11 = a0Var.G;
            if (i10 == 0 && i11 != 0) {
                ((s1.a0) this.D0).V(0);
            } else if (i10 == 1 && i11 == 2) {
                ((s1.a0) this.D0).V(1);
            } else if (i10 == 2 && i11 == 1) {
                ((s1.a0) this.D0).V(2);
            }
        }
        this.f12446o.h(this.N, i10 != 0);
        t();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.f12446o.h(this.J, z10);
        p();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z10) {
        this.G0 = z10;
        w();
    }

    public void setShowNextButton(boolean z10) {
        this.f12446o.h(this.H, z10);
        p();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z10) {
        this.H0 = z10;
        q();
    }

    public void setShowPreviousButton(boolean z10) {
        this.f12446o.h(this.G, z10);
        p();
    }

    public void setShowRewindButton(boolean z10) {
        this.f12446o.h(this.K, z10);
        p();
    }

    public void setShowShuffleButton(boolean z10) {
        this.f12446o.h(this.O, z10);
        v();
    }

    public void setShowSubtitleButton(boolean z10) {
        this.f12446o.h(this.Q, z10);
    }

    public void setShowTimeoutMs(int i10) {
        this.K0 = i10;
        if (j()) {
            this.f12446o.g();
        }
    }

    public void setShowVrButton(boolean z10) {
        this.f12446o.h(this.P, z10);
    }

    public void setTimeBarMinUpdateInterval(int i10) {
        this.M0 = l1.a0.i(i10, 16, 1000);
    }

    public void setTimeBarScrubbingEnabled(boolean z10) {
        this.L0 = z10;
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.P;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
            n(imageView, onClickListener != null);
        }
    }

    public final void t() {
        ImageView imageView;
        if (l() && this.F0 && (imageView = this.N) != null) {
            if (this.N0 == 0) {
                n(imageView, false);
                return;
            }
            o0 o0Var = this.D0;
            String str = this.f12444m0;
            Drawable drawable = this.f12441j0;
            if (o0Var == null || !((b0.j) o0Var).e(15)) {
                n(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            n(imageView, true);
            s1.a0 a0Var = (s1.a0) o0Var;
            a0Var.f0();
            int i10 = a0Var.G;
            if (i10 == 0) {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            } else if (i10 == 1) {
                imageView.setImageDrawable(this.f12442k0);
                imageView.setContentDescription(this.f12445n0);
            } else {
                if (i10 != 2) {
                    return;
                }
                imageView.setImageDrawable(this.f12443l0);
                imageView.setContentDescription(this.f12447o0);
            }
        }
    }

    public final void u() {
        RecyclerView recyclerView = this.f12466y;
        recyclerView.measure(0, 0);
        int width = getWidth();
        int i10 = this.F;
        int min = Math.min(recyclerView.getMeasuredWidth(), width - (i10 * 2));
        PopupWindow popupWindow = this.E;
        popupWindow.setWidth(min);
        popupWindow.setHeight(Math.min(getHeight() - (i10 * 2), recyclerView.getMeasuredHeight()));
    }

    public final void v() {
        ImageView imageView;
        if (l() && this.F0 && (imageView = this.O) != null) {
            o0 o0Var = this.D0;
            if (!this.f12446o.b(imageView)) {
                n(imageView, false);
                return;
            }
            String str = this.f12459u0;
            Drawable drawable = this.f12451q0;
            if (o0Var == null || !((b0.j) o0Var).e(14)) {
                n(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            n(imageView, true);
            s1.a0 a0Var = (s1.a0) o0Var;
            a0Var.f0();
            if (a0Var.H) {
                drawable = this.f12449p0;
            }
            imageView.setImageDrawable(drawable);
            a0Var.f0();
            if (a0Var.H) {
                str = this.f12457t0;
            }
            imageView.setContentDescription(str);
        }
    }

    public final void w() {
        boolean z10;
        long j10;
        int i10;
        int i11;
        boolean z11;
        boolean[] zArr;
        boolean z12;
        o0 o0Var = this.D0;
        if (o0Var == null) {
            return;
        }
        boolean z13 = this.G0;
        s0 s0Var = this.f12438f0;
        boolean z14 = false;
        boolean z15 = true;
        this.I0 = z13 && c(o0Var, s0Var);
        long j11 = 0;
        this.S0 = 0L;
        b0.j jVar = (b0.j) o0Var;
        t0 A = jVar.e(17) ? ((s1.a0) o0Var).A() : t0.f6037a;
        long j12 = -9223372036854775807L;
        if (A.p()) {
            z10 = true;
            if (jVar.e(16)) {
                long c10 = jVar.c();
                if (c10 != -9223372036854775807L) {
                    j10 = l1.a0.O(c10);
                    i10 = 0;
                }
            }
            j10 = 0;
            i10 = 0;
        } else {
            int x6 = ((s1.a0) o0Var).x();
            boolean z16 = this.I0;
            int i12 = z16 ? 0 : x6;
            int o2 = z16 ? A.o() - 1 : x6;
            i10 = 0;
            long j13 = 0;
            while (true) {
                if (i12 > o2) {
                    break;
                }
                long j14 = j11;
                if (i12 == x6) {
                    this.S0 = l1.a0.Z(j13);
                }
                A.n(i12, s0Var);
                if (s0Var.f6032m == j12) {
                    l1.d.g(this.I0 ^ z15);
                    break;
                }
                int i13 = s0Var.f6033n;
                while (i13 <= s0Var.f6034o) {
                    r0 r0Var = this.f12437e0;
                    A.f(i13, r0Var, z14);
                    long j15 = j12;
                    i1.c cVar = r0Var.g;
                    cVar.getClass();
                    int i14 = cVar.f5815a;
                    int i15 = z14;
                    while (i15 < i14) {
                        r0Var.d(i15);
                        long j16 = r0Var.f6016e;
                        if (j16 >= j14) {
                            long[] jArr = this.O0;
                            i11 = x6;
                            if (i10 == jArr.length) {
                                int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                this.O0 = Arrays.copyOf(jArr, length);
                                this.P0 = Arrays.copyOf(this.P0, length);
                            }
                            this.O0[i10] = l1.a0.Z(j16 + j13);
                            boolean[] zArr2 = this.P0;
                            i1.b a10 = r0Var.g.a(i15);
                            int i16 = a10.f5803a;
                            if (i16 == -1) {
                                zArr = zArr2;
                                z11 = true;
                                z12 = true;
                            } else {
                                int i17 = 0;
                                while (i17 < i16) {
                                    zArr = zArr2;
                                    int i18 = a10.f5807e[i17];
                                    if (i18 != 0) {
                                        i1.b bVar = a10;
                                        z11 = true;
                                        if (i18 != 1) {
                                            i17++;
                                            zArr2 = zArr;
                                            a10 = bVar;
                                        }
                                    } else {
                                        z11 = true;
                                    }
                                    z12 = z11;
                                    break;
                                }
                                zArr = zArr2;
                                z11 = true;
                                z12 = false;
                            }
                            zArr[i10] = !z12;
                            i10++;
                        } else {
                            i11 = x6;
                            z11 = true;
                        }
                        i15++;
                        z15 = z11;
                        x6 = i11;
                        j14 = 0;
                    }
                    i13++;
                    j12 = j15;
                    z14 = false;
                    j14 = 0;
                }
                j13 += s0Var.f6032m;
                i12++;
                z15 = z15;
                z14 = false;
                j11 = 0;
            }
            z10 = z15;
            j10 = j13;
        }
        long Z = l1.a0.Z(j10);
        TextView textView = this.W;
        if (textView != null) {
            textView.setText(l1.a0.C(this.f12435c0, this.f12436d0, Z));
        }
        f0 f0Var = this.f12434b0;
        if (f0Var != null) {
            d dVar = (d) f0Var;
            dVar.setDuration(Z);
            long[] jArr2 = this.Q0;
            int length2 = jArr2.length;
            int i19 = i10 + length2;
            long[] jArr3 = this.O0;
            if (i19 > jArr3.length) {
                this.O0 = Arrays.copyOf(jArr3, i19);
                this.P0 = Arrays.copyOf(this.P0, i19);
            }
            System.arraycopy(jArr2, 0, this.O0, i10, length2);
            System.arraycopy(this.R0, 0, this.P0, i10, length2);
            long[] jArr4 = this.O0;
            boolean[] zArr3 = this.P0;
            if (i19 != 0 && (jArr4 == null || zArr3 == null)) {
                z10 = false;
            }
            l1.d.b(z10);
            dVar.f12362d0 = i19;
            dVar.f12363e0 = jArr4;
            dVar.f12364f0 = zArr3;
            dVar.e();
        }
        s();
    }

    public final void x() {
        e eVar = this.B;
        eVar.getClass();
        List list = Collections.EMPTY_LIST;
        eVar.f12402d = list;
        e eVar2 = this.C;
        eVar2.getClass();
        eVar2.f12402d = list;
        o0 o0Var = this.D0;
        ImageView imageView = this.Q;
        if (o0Var != null && ((b0.j) o0Var).e(30) && ((b0.j) this.D0).e(29)) {
            b1 B = ((s1.a0) this.D0).B();
            w0 f10 = f(B, 1);
            eVar2.f12402d = f10;
            o oVar = eVar2.g;
            o0 o0Var2 = oVar.D0;
            d5.g gVar = oVar.f12468z;
            o0Var2.getClass();
            z0 H = ((s1.a0) o0Var2).H();
            if (!f10.isEmpty()) {
                if (eVar2.l(H)) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= f10.f9688r) {
                            break;
                        }
                        l lVar = (l) f10.get(i10);
                        if (lVar.f12419a.f5802e[lVar.f12420b]) {
                            ((String[]) gVar.f4102f)[1] = lVar.f12421c;
                            break;
                        }
                        i10++;
                    }
                } else {
                    ((String[]) gVar.f4102f)[1] = oVar.getResources().getString(R.string.exo_track_selection_auto);
                }
            } else {
                ((String[]) gVar.f4102f)[1] = oVar.getResources().getString(R.string.exo_track_selection_none);
            }
            if (this.f12446o.b(imageView)) {
                eVar.m(f(B, 3));
            } else {
                eVar.m(w0.f9686s);
            }
        }
        n(imageView, eVar.a() > 0);
        d5.g gVar2 = this.f12468z;
        n(this.T, gVar2.n(1) || gVar2.n(0));
    }

    public void setProgressUpdateListener(i iVar) {
    }
}
