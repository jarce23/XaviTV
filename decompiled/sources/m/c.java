package m;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8374o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f8375p;

    public /* synthetic */ c(ActionBarOverlayLayout actionBarOverlayLayout, int i10) {
        this.f8374o = i10;
        this.f8375p = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8374o) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f8375p;
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.K = actionBarOverlayLayout.f413r.animate().translationY(0.0f).setListener(actionBarOverlayLayout.L);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f8375p;
                actionBarOverlayLayout2.h();
                actionBarOverlayLayout2.K = actionBarOverlayLayout2.f413r.animate().translationY(-actionBarOverlayLayout2.f413r.getHeight()).setListener(actionBarOverlayLayout2.L);
                break;
        }
    }
}
