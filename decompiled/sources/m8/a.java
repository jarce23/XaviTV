package m8;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9033a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f9034b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z.a f9035c;

    public /* synthetic */ a(z.a aVar, View view, int i10) {
        this.f9033a = i10;
        this.f9035c = aVar;
        this.f9034b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z10) {
        switch (this.f9033a) {
            case 0:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f9035c;
                if (z10 && hideBottomViewOnScrollBehavior.f3662j == 1) {
                    hideBottomViewOnScrollBehavior.r(this.f9034b);
                    break;
                }
                break;
            default:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f9035c;
                if (z10 && hideViewOnScrollBehavior.f3672j == 1) {
                    hideViewOnScrollBehavior.s(this.f9034b);
                    break;
                }
                break;
        }
    }
}
