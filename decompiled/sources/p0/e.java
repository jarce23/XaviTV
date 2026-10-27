package p0;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import m.o1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements View.OnTouchListener {
    public static final int F = ViewConfiguration.getTapTimeout();
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final o1 E;

    /* renamed from: o, reason: collision with root package name */
    public final a f9795o;

    /* renamed from: p, reason: collision with root package name */
    public final AccelerateInterpolator f9796p;

    /* renamed from: q, reason: collision with root package name */
    public final o1 f9797q;

    /* renamed from: r, reason: collision with root package name */
    public b f9798r;

    /* renamed from: s, reason: collision with root package name */
    public final float[] f9799s;

    /* renamed from: t, reason: collision with root package name */
    public final float[] f9800t;

    /* renamed from: u, reason: collision with root package name */
    public final int f9801u;

    /* renamed from: v, reason: collision with root package name */
    public final int f9802v;

    /* renamed from: w, reason: collision with root package name */
    public final float[] f9803w;

    /* renamed from: x, reason: collision with root package name */
    public final float[] f9804x;

    /* renamed from: y, reason: collision with root package name */
    public final float[] f9805y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f9806z;

    public e(o1 o1Var) {
        a aVar = new a();
        aVar.f9789e = Long.MIN_VALUE;
        aVar.g = -1L;
        aVar.f9790f = 0L;
        this.f9795o = aVar;
        this.f9796p = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f9799s = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f9800t = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f9803w = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f9804x = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f9805y = fArr5;
        this.f9797q = o1Var;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = ((int) ((1575.0f * f10) + 0.5f)) / 1000.0f;
        fArr5[0] = f11;
        fArr5[1] = f11;
        float f12 = ((int) ((f10 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f12;
        fArr4[1] = f12;
        this.f9801u = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f9802v = F;
        aVar.f9785a = 500;
        aVar.f9786b = 500;
        this.E = o1Var;
    }

    public static float b(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f9799s
            r0 = r0[r7]
            float[] r1 = r3.f9800t
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f9796p
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.f9803w
            r0 = r0[r7]
            float[] r1 = r3.f9804x
            r1 = r1[r7]
            float[] r2 = r3.f9805y
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            return r4
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.e.a(float, float, float, int):float");
    }

    public final float c(float f10, float f11) {
        if (f11 != 0.0f) {
            int i10 = this.f9801u;
            if (i10 == 0 || i10 == 1) {
                if (f10 < f11) {
                    if (f10 >= 0.0f) {
                        return 1.0f - (f10 / f11);
                    }
                    if (this.C && i10 == 1) {
                        return 1.0f;
                    }
                }
            } else if (i10 == 2 && f10 < 0.0f) {
                return f10 / (-f11);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i10 = 0;
        if (this.A) {
            this.C = false;
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        a aVar = this.f9795o;
        int i11 = (int) (currentAnimationTimeMillis - aVar.f9789e);
        int i12 = aVar.f9786b;
        if (i11 > i12) {
            i10 = i12;
        } else if (i11 >= 0) {
            i10 = i11;
        }
        aVar.f9792i = i10;
        aVar.f9791h = aVar.a(currentAnimationTimeMillis);
        aVar.g = currentAnimationTimeMillis;
    }

    public final boolean e() {
        o1 o1Var;
        int count;
        a aVar = this.f9795o;
        float f10 = aVar.f9788d;
        int abs = (int) (f10 / Math.abs(f10));
        Math.abs(aVar.f9787c);
        if (abs != 0 && (count = (o1Var = this.E).getCount()) != 0) {
            int childCount = o1Var.getChildCount();
            int firstVisiblePosition = o1Var.getFirstVisiblePosition();
            int i10 = firstVisiblePosition + childCount;
            if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && o1Var.getChildAt(0).getTop() >= 0)) : !(i10 >= count && o1Var.getChildAt(childCount - 1).getBottom() <= o1Var.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.D
            r1 = 0
            if (r0 != 0) goto L7
            goto L7c
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7c
        L17:
            r7.d()
            return r1
        L1b:
            r7.B = r2
            r7.f9806z = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            m.o1 r4 = r7.f9797q
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            p0.a r9 = r7.f9795o
            r9.f9787c = r0
            r9.f9788d = r8
            boolean r8 = r7.C
            if (r8 != 0) goto L7c
            boolean r8 = r7.e()
            if (r8 == 0) goto L7c
            p0.b r8 = r7.f9798r
            if (r8 != 0) goto L60
            p0.b r8 = new p0.b
            r8.<init>(r1, r7)
            r7.f9798r = r8
        L60:
            r7.C = r2
            r7.A = r2
            boolean r8 = r7.f9806z
            if (r8 != 0) goto L75
            int r8 = r7.f9802v
            if (r8 <= 0) goto L75
            p0.b r9 = r7.f9798r
            long r5 = (long) r8
            java.util.WeakHashMap r8 = m0.k0.f8683a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            p0.b r8 = r7.f9798r
            r8.run()
        L7a:
            r7.f9806z = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.e.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
