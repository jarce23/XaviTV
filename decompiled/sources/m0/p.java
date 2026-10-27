package m0;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements q {

    /* renamed from: o, reason: collision with root package name */
    public final ScrollFeedbackProvider f8703o;

    public p(NestedScrollView nestedScrollView) {
        this.f8703o = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // m0.q
    public final void onScrollLimit(int i10, int i11, int i12, boolean z10) {
        this.f8703o.onScrollLimit(i10, i11, i12, z10);
    }

    @Override // m0.q
    public final void onScrollProgress(int i10, int i11, int i12, int i13) {
        this.f8703o.onScrollProgress(i10, i11, i12, i13);
    }
}
