package s0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b4.d0;
import java.util.Arrays;
import java.util.WeakHashMap;
import m0.k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: v, reason: collision with root package name */
    public static final d0 f11159v = new d0(1);

    /* renamed from: a, reason: collision with root package name */
    public int f11160a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11161b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f11163d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f11164e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f11165f;
    public float[] g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f11166h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f11167i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f11168j;

    /* renamed from: k, reason: collision with root package name */
    public int f11169k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f11170l;

    /* renamed from: m, reason: collision with root package name */
    public final float f11171m;

    /* renamed from: n, reason: collision with root package name */
    public final float f11172n;

    /* renamed from: o, reason: collision with root package name */
    public final int f11173o;

    /* renamed from: p, reason: collision with root package name */
    public final OverScroller f11174p;

    /* renamed from: q, reason: collision with root package name */
    public final n4.a f11175q;

    /* renamed from: r, reason: collision with root package name */
    public View f11176r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f11177s;

    /* renamed from: t, reason: collision with root package name */
    public final CoordinatorLayout f11178t;

    /* renamed from: c, reason: collision with root package name */
    public int f11162c = -1;

    /* renamed from: u, reason: collision with root package name */
    public final p0.b f11179u = new p0.b(5, this);

    public d(Context context, CoordinatorLayout coordinatorLayout, n4.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f11178t = coordinatorLayout;
        this.f11175q = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f11173o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f11161b = viewConfiguration.getScaledTouchSlop();
        this.f11171m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f11172n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f11174p = new OverScroller(context, f11159v);
    }

    public final void a() {
        this.f11162c = -1;
        float[] fArr = this.f11163d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f11164e, 0.0f);
            Arrays.fill(this.f11165f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.f11166h, 0);
            Arrays.fill(this.f11167i, 0);
            Arrays.fill(this.f11168j, 0);
            this.f11169k = 0;
        }
        VelocityTracker velocityTracker = this.f11170l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f11170l = null;
        }
    }

    public final void b(View view, int i10) {
        ViewParent parent = view.getParent();
        CoordinatorLayout coordinatorLayout = this.f11178t;
        if (parent != coordinatorLayout) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + coordinatorLayout + ")");
        }
        this.f11176r = view;
        this.f11162c = i10;
        this.f11175q.v(view, i10);
        n(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            goto L45
        L4:
            n4.a r1 = r3.f11175q
            int r4 = r1.r(r4)
            r2 = 1
            if (r4 <= 0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r0
        L10:
            int r1 = r1.s()
            if (r1 <= 0) goto L18
            r1 = r2
            goto L19
        L18:
            r1 = r0
        L19:
            if (r4 == 0) goto L29
            if (r1 == 0) goto L29
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r4 = r3.f11161b
            int r4 = r4 * r4
            float r4 = (float) r4
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 <= 0) goto L45
            goto L44
        L29:
            if (r4 == 0) goto L37
            float r4 = java.lang.Math.abs(r5)
            int r5 = r3.f11161b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L45
            goto L44
        L37:
            if (r1 == 0) goto L45
            float r4 = java.lang.Math.abs(r6)
            int r5 = r3.f11161b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L45
        L44:
            return r2
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.d.c(android.view.View, float, float):boolean");
    }

    public final void d(int i10) {
        float[] fArr = this.f11163d;
        if (fArr != null) {
            int i11 = this.f11169k;
            int i12 = 1 << i10;
            if ((i11 & i12) != 0) {
                fArr[i10] = 0.0f;
                this.f11164e[i10] = 0.0f;
                this.f11165f[i10] = 0.0f;
                this.g[i10] = 0.0f;
                this.f11166h[i10] = 0;
                this.f11167i[i10] = 0;
                this.f11168j[i10] = 0;
                this.f11169k = (~i12) & i11;
            }
        }
    }

    public final int e(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        float width = this.f11178t.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(i10) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int abs = Math.abs(i11);
        return Math.min(abs > 0 ? Math.round(Math.abs(sin / abs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    public final boolean f() {
        if (this.f11160a == 2) {
            OverScroller overScroller = this.f11174p;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f11176r.getLeft();
            int top = currY - this.f11176r.getTop();
            if (left != 0) {
                View view = this.f11176r;
                WeakHashMap weakHashMap = k0.f8683a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f11176r;
                WeakHashMap weakHashMap2 = k0.f8683a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f11175q.x(this.f11176r, currX, currY);
            }
            if (computeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.f11178t.post(this.f11179u);
            }
        }
        return this.f11160a == 2;
    }

    public final View g(int i10, int i11) {
        CoordinatorLayout coordinatorLayout = this.f11178t;
        for (int childCount = coordinatorLayout.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f11175q.getClass();
            View childAt = coordinatorLayout.getChildAt(childCount);
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean h(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int left = this.f11176r.getLeft();
        int top = this.f11176r.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        OverScroller overScroller = this.f11174p;
        if (i14 == 0 && i15 == 0) {
            overScroller.abortAnimation();
            n(0);
            return false;
        }
        View view = this.f11176r;
        int i16 = (int) this.f11172n;
        int i17 = (int) this.f11171m;
        int abs = Math.abs(i12);
        if (abs < i16) {
            i12 = 0;
        } else if (abs > i17) {
            i12 = i12 > 0 ? i17 : -i17;
        }
        int abs2 = Math.abs(i13);
        if (abs2 < i16) {
            i13 = 0;
        } else if (abs2 > i17) {
            i13 = i13 > 0 ? i17 : -i17;
        }
        int abs3 = Math.abs(i14);
        int abs4 = Math.abs(i15);
        int abs5 = Math.abs(i12);
        int abs6 = Math.abs(i13);
        int i18 = abs5 + abs6;
        int i19 = abs3 + abs4;
        if (i12 != 0) {
            f10 = abs5;
            f11 = i18;
        } else {
            f10 = abs3;
            f11 = i19;
        }
        float f14 = f10 / f11;
        if (i13 != 0) {
            f12 = abs6;
            f13 = i18;
        } else {
            f12 = abs4;
            f13 = i19;
        }
        float f15 = f12 / f13;
        n4.a aVar = this.f11175q;
        overScroller.startScroll(left, top, i14, i15, (int) ((e(i15, i13, aVar.s()) * f15) + (e(i14, i12, aVar.r(view)) * f14)));
        n(2);
        return true;
    }

    public final boolean i(int i10) {
        if ((this.f11169k & (1 << i10)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void j(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f11170l == null) {
            this.f11170l = VelocityTracker.obtain();
        }
        this.f11170l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x6 = motionEvent.getX();
            float y8 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View g = g((int) x6, (int) y8);
            l(x6, y8, pointerId);
            q(g, pointerId);
            int i12 = this.f11166h[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.f11160a == 1) {
                k();
            }
            a();
            return;
        }
        n4.a aVar = this.f11175q;
        if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f11160a == 1) {
                    this.f11177s = true;
                    aVar.y(this.f11176r, 0.0f, 0.0f);
                    this.f11177s = false;
                    if (this.f11160a == 1) {
                        n(0);
                    }
                }
                a();
                return;
            }
            if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x10 = motionEvent.getX(actionIndex);
                float y10 = motionEvent.getY(actionIndex);
                l(x10, y10, pointerId2);
                if (this.f11160a == 0) {
                    q(g((int) x10, (int) y10), pointerId2);
                    int i13 = this.f11166h[pointerId2];
                    return;
                }
                int i14 = (int) x10;
                int i15 = (int) y10;
                View view = this.f11176r;
                if (view != null && i14 >= view.getLeft() && i14 < view.getRight() && i15 >= view.getTop() && i15 < view.getBottom()) {
                    i11 = 1;
                }
                if (i11 != 0) {
                    q(this.f11176r, pointerId2);
                    return;
                }
                return;
            }
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f11160a == 1 && pointerId3 == this.f11162c) {
                int pointerCount = motionEvent.getPointerCount();
                while (true) {
                    if (i11 >= pointerCount) {
                        i10 = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i11);
                    if (pointerId4 != this.f11162c) {
                        View g6 = g((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                        View view2 = this.f11176r;
                        if (g6 == view2 && q(view2, pointerId4)) {
                            i10 = this.f11162c;
                            break;
                        }
                    }
                    i11++;
                }
                if (i10 == -1) {
                    k();
                }
            }
            d(pointerId3);
            return;
        }
        if (this.f11160a == 1) {
            if (i(this.f11162c)) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f11162c);
                float x11 = motionEvent.getX(findPointerIndex);
                float y11 = motionEvent.getY(findPointerIndex);
                float[] fArr = this.f11165f;
                int i16 = this.f11162c;
                int i17 = (int) (x11 - fArr[i16]);
                int i18 = (int) (y11 - this.g[i16]);
                int left = this.f11176r.getLeft() + i17;
                int top = this.f11176r.getTop() + i18;
                int left2 = this.f11176r.getLeft();
                int top2 = this.f11176r.getTop();
                if (i17 != 0) {
                    left = aVar.f(this.f11176r, left);
                    WeakHashMap weakHashMap = k0.f8683a;
                    this.f11176r.offsetLeftAndRight(left - left2);
                }
                if (i18 != 0) {
                    top = aVar.g(this.f11176r, top);
                    WeakHashMap weakHashMap2 = k0.f8683a;
                    this.f11176r.offsetTopAndBottom(top - top2);
                }
                if (i17 != 0 || i18 != 0) {
                    aVar.x(this.f11176r, left, top);
                }
                m(motionEvent);
                return;
            }
            return;
        }
        int pointerCount2 = motionEvent.getPointerCount();
        while (i11 < pointerCount2) {
            int pointerId5 = motionEvent.getPointerId(i11);
            if (i(pointerId5)) {
                float x12 = motionEvent.getX(i11);
                float y12 = motionEvent.getY(i11);
                float f10 = x12 - this.f11163d[pointerId5];
                float f11 = y12 - this.f11164e[pointerId5];
                Math.abs(f10);
                Math.abs(f11);
                int i19 = this.f11166h[pointerId5];
                Math.abs(f11);
                Math.abs(f10);
                int i20 = this.f11166h[pointerId5];
                Math.abs(f10);
                Math.abs(f11);
                int i21 = this.f11166h[pointerId5];
                Math.abs(f11);
                Math.abs(f10);
                int i22 = this.f11166h[pointerId5];
                if (this.f11160a != 1) {
                    View g10 = g((int) x12, (int) y12);
                    if (c(g10, f10, f11) && q(g10, pointerId5)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            i11++;
        }
        m(motionEvent);
    }

    public final void k() {
        VelocityTracker velocityTracker = this.f11170l;
        float f10 = this.f11171m;
        velocityTracker.computeCurrentVelocity(1000, f10);
        float xVelocity = this.f11170l.getXVelocity(this.f11162c);
        float abs = Math.abs(xVelocity);
        float f11 = this.f11172n;
        if (abs < f11) {
            xVelocity = 0.0f;
        } else if (abs > f10) {
            xVelocity = xVelocity > 0.0f ? f10 : -f10;
        }
        float yVelocity = this.f11170l.getYVelocity(this.f11162c);
        float abs2 = Math.abs(yVelocity);
        if (abs2 < f11) {
            f10 = 0.0f;
        } else if (abs2 <= f10) {
            f10 = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f10 = -f10;
        }
        this.f11177s = true;
        this.f11175q.y(this.f11176r, xVelocity, f10);
        this.f11177s = false;
        if (this.f11160a == 1) {
            n(0);
        }
    }

    public final void l(float f10, float f11, int i10) {
        float[] fArr = this.f11163d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f11164e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f11165f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f11166h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f11167i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f11168j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f11163d = fArr2;
            this.f11164e = fArr3;
            this.f11165f = fArr4;
            this.g = fArr5;
            this.f11166h = iArr;
            this.f11167i = iArr2;
            this.f11168j = iArr3;
        }
        float[] fArr9 = this.f11163d;
        this.f11165f[i10] = f10;
        fArr9[i10] = f10;
        float[] fArr10 = this.f11164e;
        this.g[i10] = f11;
        fArr10[i10] = f11;
        int[] iArr7 = this.f11166h;
        int i12 = (int) f10;
        int i13 = (int) f11;
        CoordinatorLayout coordinatorLayout = this.f11178t;
        int left = coordinatorLayout.getLeft();
        int i14 = this.f11173o;
        int i15 = i12 < left + i14 ? 1 : 0;
        if (i13 < coordinatorLayout.getTop() + i14) {
            i15 |= 4;
        }
        if (i12 > coordinatorLayout.getRight() - i14) {
            i15 |= 2;
        }
        if (i13 > coordinatorLayout.getBottom() - i14) {
            i15 |= 8;
        }
        iArr7[i10] = i15;
        this.f11169k |= 1 << i10;
    }

    public final void m(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (i(pointerId)) {
                float x6 = motionEvent.getX(i10);
                float y8 = motionEvent.getY(i10);
                this.f11165f[pointerId] = x6;
                this.g[pointerId] = y8;
            }
        }
    }

    public final void n(int i10) {
        this.f11178t.removeCallbacks(this.f11179u);
        if (this.f11160a != i10) {
            this.f11160a = i10;
            this.f11175q.w(i10);
            if (this.f11160a == 0) {
                this.f11176r = null;
            }
        }
    }

    public final boolean o(int i10, int i11) {
        if (this.f11177s) {
            return h(i10, i11, (int) this.f11170l.getXVelocity(this.f11162c), (int) this.f11170l.getYVelocity(this.f11162c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cd, code lost:
    
        if (r12 != r11) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.d.p(android.view.MotionEvent):boolean");
    }

    public final boolean q(View view, int i10) {
        if (view == this.f11176r && this.f11162c == i10) {
            return true;
        }
        if (view == null || !this.f11175q.C(view, i10)) {
            return false;
        }
        this.f11162c = i10;
        b(view, i10);
        return true;
    }
}
