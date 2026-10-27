package b4;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e1 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public int f2215o;

    /* renamed from: p, reason: collision with root package name */
    public int f2216p;

    /* renamed from: q, reason: collision with root package name */
    public OverScroller f2217q;

    /* renamed from: r, reason: collision with root package name */
    public Interpolator f2218r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2219s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2220t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2221u;

    public e1(RecyclerView recyclerView) {
        this.f2221u = recyclerView;
        d0 d0Var = RecyclerView.U0;
        this.f2218r = d0Var;
        this.f2219s = false;
        this.f2220t = false;
        this.f2217q = new OverScroller(recyclerView.getContext(), d0Var);
    }

    public final void a(int i10, int i11) {
        RecyclerView recyclerView = this.f2221u;
        recyclerView.setScrollState(2);
        this.f2216p = 0;
        this.f2215o = 0;
        Interpolator interpolator = this.f2218r;
        d0 d0Var = RecyclerView.U0;
        if (interpolator != d0Var) {
            this.f2218r = d0Var;
            this.f2217q = new OverScroller(recyclerView.getContext(), d0Var);
        }
        this.f2217q.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        b();
    }

    public final void b() {
        if (this.f2219s) {
            this.f2220t = true;
            return;
        }
        RecyclerView recyclerView = this.f2221u;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = m0.k0.f8683a;
        recyclerView.postOnAnimation(this);
    }

    public final void c(int i10, int i11, int i12, Interpolator interpolator) {
        RecyclerView recyclerView = this.f2221u;
        if (i12 == Integer.MIN_VALUE) {
            int abs = Math.abs(i10);
            int abs2 = Math.abs(i11);
            boolean z10 = abs > abs2;
            int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z10) {
                abs = abs2;
            }
            i12 = Math.min((int) (((abs / width) + 1.0f) * 300.0f), 2000);
        }
        int i13 = i12;
        if (interpolator == null) {
            interpolator = RecyclerView.U0;
        }
        if (this.f2218r != interpolator) {
            this.f2218r = interpolator;
            this.f2217q = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f2216p = 0;
        this.f2215o = 0;
        recyclerView.setScrollState(2);
        this.f2217q.startScroll(0, 0, i10, i11, i13);
        b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10;
        int i11;
        int i12;
        int i13;
        boolean awakenScrollBars;
        RecyclerView recyclerView = this.f2221u;
        int[] iArr = recyclerView.H0;
        if (recyclerView.B == null) {
            recyclerView.removeCallbacks(this);
            this.f2217q.abortAnimation();
            return;
        }
        this.f2220t = false;
        this.f2219s = true;
        recyclerView.n();
        OverScroller overScroller = this.f2217q;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i14 = currX - this.f2215o;
            int i15 = currY - this.f2216p;
            this.f2215o = currX;
            this.f2216p = currY;
            int m10 = RecyclerView.m(i14, recyclerView.W, recyclerView.f1460b0, recyclerView.getWidth());
            int m11 = RecyclerView.m(i15, recyclerView.f1459a0, recyclerView.f1461c0, recyclerView.getHeight());
            int[] iArr2 = recyclerView.H0;
            iArr2[0] = 0;
            iArr2[1] = 0;
            if (recyclerView.s(m10, m11, 1, iArr2, null)) {
                m10 -= iArr[0];
                m11 -= iArr[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.l(m10, m11);
            }
            if (recyclerView.A != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                recyclerView.d0(m10, m11, iArr);
                int i16 = iArr[0];
                int i17 = iArr[1];
                int i18 = m10 - i16;
                int i19 = m11 - i17;
                y yVar = recyclerView.B.f2361e;
                if (yVar != null && !yVar.f2453d && yVar.f2454e) {
                    int b2 = recyclerView.f1487v0.b();
                    if (b2 == 0) {
                        yVar.j();
                    } else if (yVar.f2450a >= b2) {
                        yVar.f2450a = b2 - 1;
                        yVar.g(i16, i17);
                    } else {
                        yVar.g(i16, i17);
                    }
                }
                i10 = i18;
                i12 = i16;
                i11 = i19;
                i13 = i17;
            } else {
                i10 = m10;
                i11 = m11;
                i12 = 0;
                i13 = 0;
            }
            if (!recyclerView.E.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.H0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            recyclerView.t(i12, i13, i10, i11, null, 1, iArr3);
            int i20 = i10 - iArr[0];
            int i21 = i11 - iArr[1];
            if (i12 != 0 || i13 != 0) {
                recyclerView.u(i12, i13);
            }
            awakenScrollBars = recyclerView.awakenScrollBars();
            if (!awakenScrollBars) {
                recyclerView.invalidate();
            }
            boolean z10 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i20 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i21 != 0));
            y yVar2 = recyclerView.B.f2361e;
            if ((yVar2 == null || !yVar2.f2453d) && z10) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i22 = i20 < 0 ? -currVelocity : i20 > 0 ? currVelocity : 0;
                    if (i21 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i21 <= 0) {
                        currVelocity = 0;
                    }
                    if (i22 < 0) {
                        recyclerView.w();
                        if (recyclerView.W.isFinished()) {
                            recyclerView.W.onAbsorb(-i22);
                        }
                    } else if (i22 > 0) {
                        recyclerView.x();
                        if (recyclerView.f1460b0.isFinished()) {
                            recyclerView.f1460b0.onAbsorb(i22);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.y();
                        if (recyclerView.f1459a0.isFinished()) {
                            recyclerView.f1459a0.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.v();
                        if (recyclerView.f1461c0.isFinished()) {
                            recyclerView.f1461c0.onAbsorb(currVelocity);
                        }
                    }
                    if (i22 != 0 || currVelocity != 0) {
                        WeakHashMap weakHashMap = m0.k0.f8683a;
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                if (RecyclerView.S0) {
                    p pVar = recyclerView.f1485u0;
                    int[] iArr4 = (int[]) pVar.f2377b;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    pVar.f2380e = 0;
                }
            } else {
                b();
                r rVar = recyclerView.f1483t0;
                if (rVar != null) {
                    rVar.a(recyclerView, i12, i13);
                }
            }
        }
        y yVar3 = recyclerView.B.f2361e;
        if (yVar3 != null && yVar3.f2453d) {
            yVar3.g(0, 0);
        }
        this.f2219s = false;
        if (!this.f2220t) {
            recyclerView.setScrollState(0);
            recyclerView.k0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap2 = m0.k0.f8683a;
            recyclerView.postOnAnimation(this);
        }
    }
}
