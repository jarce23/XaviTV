package m;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q1 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8525o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ r1 f8526p;

    public /* synthetic */ q1(r1 r1Var, int i10) {
        this.f8525o = i10;
        this.f8526p = r1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8525o) {
            case 0:
                ViewParent parent = this.f8526p.f8533r.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                r1 r1Var = this.f8526p;
                r1Var.a();
                View view = r1Var.f8533r;
                if (view.isEnabled() && !view.isLongClickable() && r1Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    r1Var.f8536u = true;
                    break;
                }
                break;
        }
    }
}
