package l;

import android.widget.PopupWindow;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u implements PopupWindow.OnDismissListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ v f8049o;

    public u(v vVar) {
        this.f8049o = vVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f8049o.c();
    }
}
