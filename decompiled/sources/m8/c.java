package m8;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends n4.a {

    /* renamed from: t, reason: collision with root package name */
    public int f9037t;

    /* renamed from: u, reason: collision with root package name */
    public int f9038u;

    /* renamed from: v, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f9039v;

    public c(SwipeDismissBehavior swipeDismissBehavior) {
        super(12);
        this.f9039v = swipeDismissBehavior;
        this.f9038u = -1;
    }

    @Override // n4.a
    public final boolean C(View view, int i10) {
        int i11 = this.f9038u;
        return (i11 == -1 || i11 == i10) && this.f9039v.r(view);
    }

    @Override // n4.a
    public final int f(View view, int i10) {
        int width;
        int width2;
        int width3;
        boolean z10 = view.getLayoutDirection() == 1;
        int i11 = this.f9039v.f3677d;
        if (i11 == 0) {
            if (z10) {
                width = this.f9037t - view.getWidth();
                width2 = this.f9037t;
            } else {
                width = this.f9037t;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i11 != 1) {
            width = this.f9037t - view.getWidth();
            width2 = view.getWidth() + this.f9037t;
        } else if (z10) {
            width = this.f9037t;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f9037t - view.getWidth();
            width2 = this.f9037t;
        }
        return Math.min(Math.max(width, i10), width2);
    }

    @Override // n4.a
    public final int g(View view, int i10) {
        return view.getTop();
    }

    @Override // n4.a
    public final int r(View view) {
        return view.getWidth();
    }

    @Override // n4.a
    public final void v(View view, int i10) {
        this.f9038u = i10;
        this.f9037t = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f9039v;
            swipeDismissBehavior.f3676c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f3676c = false;
        }
    }

    @Override // n4.a
    public final void x(View view, int i10, int i11) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f9039v;
        float f10 = width * swipeDismissBehavior.f3678e;
        float width2 = view.getWidth() * swipeDismissBehavior.f3679f;
        float abs = Math.abs(i10 - this.f9037t);
        if (abs <= f10) {
            view.setAlpha(1.0f);
        } else if (abs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((abs - f10) / (width2 - f10))), 1.0f));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004e, code lost:
    
        if (java.lang.Math.abs(r9.getLeft() - r8.f9037t) >= java.lang.Math.round(r9.getWidth() * 0.5f)) goto L27;
     */
    @Override // n4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f9038u = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 0
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.f9039v
            r4 = 1
            if (r1 == 0) goto L37
            int r5 = r9.getLayoutDirection()
            if (r5 != r4) goto L18
            r5 = r4
            goto L19
        L18:
            r5 = r2
        L19:
            int r6 = r3.f3677d
            r7 = 2
            if (r6 != r7) goto L1f
            goto L50
        L1f:
            if (r6 != 0) goto L2b
            if (r5 == 0) goto L28
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L65
            goto L50
        L28:
            if (r1 <= 0) goto L65
            goto L50
        L2b:
            if (r6 != r4) goto L65
            if (r5 == 0) goto L32
            if (r1 <= 0) goto L65
            goto L50
        L32:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L65
            goto L50
        L37:
            int r1 = r9.getLeft()
            int r5 = r8.f9037t
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L65
        L50:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L5f
            int r10 = r9.getLeft()
            int r0 = r8.f9037t
            if (r10 >= r0) goto L5d
            goto L5f
        L5d:
            int r0 = r0 + r11
            goto L63
        L5f:
            int r10 = r8.f9037t
            int r0 = r10 - r11
        L63:
            r2 = r4
            goto L67
        L65:
            int r0 = r8.f9037t
        L67:
            s0.d r10 = r3.f3674a
            int r11 = r9.getTop()
            boolean r10 = r10.o(r0, r11)
            if (r10 == 0) goto L7b
            app.shamel.tv.activities.y r10 = new app.shamel.tv.activities.y
            r10.<init>(r3, r9, r2)
            r9.postOnAnimation(r10)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.c.y(android.view.View, float, float):void");
    }

    @Override // n4.a
    public final void w(int i10) {
    }
}
