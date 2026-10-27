package u3;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {
    public boolean A;
    public boolean B;

    /* renamed from: a, reason: collision with root package name */
    public final o f12479a;

    /* renamed from: b, reason: collision with root package name */
    public final View f12480b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f12481c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewGroup f12482d;

    /* renamed from: e, reason: collision with root package name */
    public final ViewGroup f12483e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewGroup f12484f;
    public final ViewGroup g;

    /* renamed from: h, reason: collision with root package name */
    public final ViewGroup f12485h;

    /* renamed from: i, reason: collision with root package name */
    public final ViewGroup f12486i;

    /* renamed from: j, reason: collision with root package name */
    public final View f12487j;

    /* renamed from: k, reason: collision with root package name */
    public final View f12488k;

    /* renamed from: l, reason: collision with root package name */
    public final AnimatorSet f12489l;

    /* renamed from: m, reason: collision with root package name */
    public final AnimatorSet f12490m;

    /* renamed from: n, reason: collision with root package name */
    public final AnimatorSet f12491n;

    /* renamed from: o, reason: collision with root package name */
    public final AnimatorSet f12492o;

    /* renamed from: p, reason: collision with root package name */
    public final AnimatorSet f12493p;

    /* renamed from: q, reason: collision with root package name */
    public final ValueAnimator f12494q;

    /* renamed from: r, reason: collision with root package name */
    public final ValueAnimator f12495r;

    /* renamed from: s, reason: collision with root package name */
    public final p f12496s;

    /* renamed from: t, reason: collision with root package name */
    public final p f12497t;

    /* renamed from: x, reason: collision with root package name */
    public final q8.a f12501x;

    /* renamed from: u, reason: collision with root package name */
    public final p f12498u = new p(this, 4);

    /* renamed from: v, reason: collision with root package name */
    public final p f12499v = new p(this, 5);

    /* renamed from: w, reason: collision with root package name */
    public final p f12500w = new p(this, 6);
    public boolean C = true;

    /* renamed from: z, reason: collision with root package name */
    public int f12503z = 0;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f12502y = new ArrayList();

    public t(o oVar) {
        this.f12479a = oVar;
        final int i10 = 0;
        this.f12496s = new p(this, i10);
        final int i11 = 3;
        this.f12497t = new p(this, i11);
        final int i12 = 2;
        this.f12501x = new q8.a(i12, this);
        final int i13 = 1;
        this.f12480b = oVar.findViewById(R.id.exo_controls_background);
        this.f12481c = (ViewGroup) oVar.findViewById(R.id.exo_center_controls);
        this.f12483e = (ViewGroup) oVar.findViewById(R.id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) oVar.findViewById(R.id.exo_bottom_bar);
        this.f12482d = viewGroup;
        this.f12486i = (ViewGroup) oVar.findViewById(R.id.exo_time);
        View findViewById = oVar.findViewById(R.id.exo_progress);
        this.f12487j = findViewById;
        this.f12484f = (ViewGroup) oVar.findViewById(R.id.exo_basic_controls);
        this.g = (ViewGroup) oVar.findViewById(R.id.exo_extra_controls);
        this.f12485h = (ViewGroup) oVar.findViewById(R.id.exo_extra_controls_scroll_view);
        View findViewById2 = oVar.findViewById(R.id.exo_overflow_show);
        this.f12488k = findViewById2;
        View findViewById3 = oVar.findViewById(R.id.exo_overflow_hide);
        if (findViewById2 != null && findViewById3 != null) {
            int i14 = 10;
            findViewById2.setOnClickListener(new androidx.mediarouter.app.b(i14, this));
            findViewById3.setOnClickListener(new androidx.mediarouter.app.b(i14, this));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: u3.q

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t f12473b;

            {
                this.f12473b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i11) {
                    case 0:
                        t tVar = this.f12473b;
                        tVar.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = tVar.f12480b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = tVar.f12481c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = tVar.f12483e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        t tVar2 = this.f12473b;
                        tVar2.getClass();
                        tVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        t tVar3 = this.f12473b;
                        tVar3.getClass();
                        tVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        t tVar4 = this.f12473b;
                        tVar4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = tVar4.f12480b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = tVar4.f12481c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = tVar4.f12483e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat.addListener(new r(this, i10));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: u3.q

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t f12473b;

            {
                this.f12473b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i10) {
                    case 0:
                        t tVar = this.f12473b;
                        tVar.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = tVar.f12480b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = tVar.f12481c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = tVar.f12483e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        t tVar2 = this.f12473b;
                        tVar2.getClass();
                        tVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        t tVar3 = this.f12473b;
                        tVar3.getClass();
                        tVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        t tVar4 = this.f12473b;
                        tVar4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = tVar4.f12480b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = tVar4.f12481c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = tVar4.f12483e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat2.addListener(new r(this, i13));
        Resources resources = oVar.getResources();
        float dimension = resources.getDimension(R.dimen.exo_styled_bottom_bar_height) - resources.getDimension(R.dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(R.dimen.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f12489l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new s(this, oVar, i10));
        animatorSet.play(ofFloat).with(d(findViewById, 0.0f, dimension)).with(d(viewGroup, 0.0f, dimension));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f12490m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new s(this, oVar, i13));
        animatorSet2.play(d(findViewById, dimension, dimension2)).with(d(viewGroup, dimension, dimension2));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f12491n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new s(this, oVar, i12));
        animatorSet3.play(ofFloat).with(d(findViewById, 0.0f, dimension2)).with(d(viewGroup, 0.0f, dimension2));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f12492o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new r(this, i12));
        animatorSet4.play(ofFloat2).with(d(findViewById, dimension, 0.0f)).with(d(viewGroup, dimension, 0.0f));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f12493p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new r(this, i11));
        animatorSet5.play(ofFloat2).with(d(findViewById, dimension2, 0.0f)).with(d(viewGroup, dimension2, 0.0f));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f12494q = ofFloat3;
        ofFloat3.setDuration(250L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: u3.q

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t f12473b;

            {
                this.f12473b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i13) {
                    case 0:
                        t tVar = this.f12473b;
                        tVar.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = tVar.f12480b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = tVar.f12481c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = tVar.f12483e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        t tVar2 = this.f12473b;
                        tVar2.getClass();
                        tVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        t tVar3 = this.f12473b;
                        tVar3.getClass();
                        tVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        t tVar4 = this.f12473b;
                        tVar4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = tVar4.f12480b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = tVar4.f12481c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = tVar4.f12483e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat3.addListener(new r(this, 4));
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f12495r = ofFloat4;
        ofFloat4.setDuration(250L);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: u3.q

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t f12473b;

            {
                this.f12473b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i12) {
                    case 0:
                        t tVar = this.f12473b;
                        tVar.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = tVar.f12480b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = tVar.f12481c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = tVar.f12483e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        t tVar2 = this.f12473b;
                        tVar2.getClass();
                        tVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        t tVar3 = this.f12473b;
                        tVar3.getClass();
                        tVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        t tVar4 = this.f12473b;
                        tVar4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = tVar4.f12480b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = tVar4.f12481c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = tVar4.f12483e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat4.addListener(new r(this, 5));
    }

    public static int c(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + width;
    }

    public static ObjectAnimator d(View view, float f10, float f11) {
        return ObjectAnimator.ofFloat(view, "translationY", f10, f11);
    }

    public static boolean j(View view) {
        int id = view.getId();
        return id == R.id.exo_bottom_bar || id == R.id.exo_prev || id == R.id.exo_next || id == R.id.exo_rew || id == R.id.exo_rew_with_amount || id == R.id.exo_ffwd || id == R.id.exo_ffwd_with_amount;
    }

    public final void a(float f10) {
        ViewGroup viewGroup = this.f12485h;
        if (viewGroup != null) {
            viewGroup.setTranslationX((int) ((1.0f - f10) * viewGroup.getWidth()));
        }
        ViewGroup viewGroup2 = this.f12486i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f10);
        }
        ViewGroup viewGroup3 = this.f12484f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f10);
        }
    }

    public final boolean b(View view) {
        return view != null && this.f12502y.contains(view);
    }

    public final void e(Runnable runnable, long j10) {
        if (j10 >= 0) {
            this.f12479a.postDelayed(runnable, j10);
        }
    }

    public final void f() {
        p pVar = this.f12500w;
        o oVar = this.f12479a;
        oVar.removeCallbacks(pVar);
        oVar.removeCallbacks(this.f12497t);
        oVar.removeCallbacks(this.f12499v);
        oVar.removeCallbacks(this.f12498u);
    }

    public final void g() {
        if (this.f12503z == 3) {
            return;
        }
        f();
        int showTimeoutMs = this.f12479a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                e(this.f12500w, showTimeoutMs);
            } else if (this.f12503z == 1) {
                e(this.f12498u, 2000L);
            } else {
                e(this.f12499v, showTimeoutMs);
            }
        }
    }

    public final void h(View view, boolean z10) {
        if (view == null) {
            return;
        }
        ArrayList arrayList = this.f12502y;
        if (!z10) {
            view.setVisibility(8);
            arrayList.remove(view);
            return;
        }
        if (this.A && j(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        arrayList.add(view);
    }

    public final void i(int i10) {
        int i11 = this.f12503z;
        this.f12503z = i10;
        o oVar = this.f12479a;
        if (i10 == 2) {
            oVar.setVisibility(8);
        } else if (i11 == 2) {
            oVar.setVisibility(0);
        }
        if (i11 != i10) {
            Iterator it = oVar.f12464x.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                oVar.getVisibility();
                ((v) nVar).f12507q.o();
            }
        }
    }

    public final void k() {
        if (!this.C) {
            i(0);
            g();
            return;
        }
        int i10 = this.f12503z;
        if (i10 == 1) {
            this.f12492o.start();
        } else if (i10 == 2) {
            this.f12493p.start();
        } else if (i10 == 3) {
            this.B = true;
        } else if (i10 == 4) {
            return;
        }
        g();
    }
}
