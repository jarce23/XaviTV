package m;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 implements PopupWindow.OnDismissListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ l.d f8422o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ i0 f8423p;

    public h0(i0 i0Var, l.d dVar) {
        this.f8423p = i0Var;
        this.f8422o = dVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f8423p.V.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f8422o);
        }
    }
}
