package m0;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f8704a;

    public p0(View view) {
        this.f8704a = new WeakReference(view);
    }

    public final void a(float f10) {
        View view = (View) this.f8704a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
    }

    public final void b() {
        View view = (View) this.f8704a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j10) {
        View view = (View) this.f8704a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
    }

    public final void d(q0 q0Var) {
        View view = (View) this.f8704a.get();
        if (view != null) {
            if (q0Var != null) {
                view.animate().setListener(new l4.i(q0Var, view, 1));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f10) {
        View view = (View) this.f8704a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
    }
}
