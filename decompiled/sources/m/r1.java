package m;

import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class r1 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final float f8530o;

    /* renamed from: p, reason: collision with root package name */
    public final int f8531p;

    /* renamed from: q, reason: collision with root package name */
    public final int f8532q;

    /* renamed from: r, reason: collision with root package name */
    public final View f8533r;

    /* renamed from: s, reason: collision with root package name */
    public q1 f8534s;

    /* renamed from: t, reason: collision with root package name */
    public q1 f8535t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8536u;

    /* renamed from: v, reason: collision with root package name */
    public int f8537v;

    /* renamed from: w, reason: collision with root package name */
    public final int[] f8538w = new int[2];

    public r1(View view) {
        this.f8533r = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f8530o = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f8531p = tapTimeout;
        this.f8532q = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        q1 q1Var = this.f8535t;
        View view = this.f8533r;
        if (q1Var != null) {
            view.removeCallbacks(q1Var);
        }
        q1 q1Var2 = this.f8534s;
        if (q1Var2 != null) {
            view.removeCallbacks(q1Var2);
        }
    }

    public abstract l.b0 b();

    public abstract boolean c();

    public boolean d() {
        l.b0 b2 = b();
        if (b2 == null || !b2.a()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r14 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007b, code lost:
    
        if (r4 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.r1.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f8536u = false;
        this.f8537v = -1;
        q1 q1Var = this.f8534s;
        if (q1Var != null) {
            this.f8533r.removeCallbacks(q1Var);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
