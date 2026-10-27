package b1;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.leanback.preference.internal.OutlineOnlyWithChildrenFrameLayout;
import com.google.android.material.chip.Chip;
import s8.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2165a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2166b;

    public /* synthetic */ a(View view, int i10) {
        this.f2165a = i10;
        this.f2166b = view;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f2165a) {
            case 0:
                OutlineOnlyWithChildrenFrameLayout outlineOnlyWithChildrenFrameLayout = (OutlineOnlyWithChildrenFrameLayout) this.f2166b;
                if (outlineOnlyWithChildrenFrameLayout.getChildCount() <= 0) {
                    ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                    break;
                } else {
                    outlineOnlyWithChildrenFrameLayout.f854p.getOutline(view, outline);
                    break;
                }
            default:
                e eVar = ((Chip) this.f2166b).f3725s;
                if (eVar == null) {
                    outline.setAlpha(0.0f);
                    break;
                } else {
                    eVar.getOutline(outline);
                    break;
                }
        }
    }
}
