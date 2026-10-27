package l;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p extends FrameLayout implements k.b {

    /* renamed from: o, reason: collision with root package name */
    public final CollapsibleActionView f8041o;

    /* JADX WARN: Multi-variable type inference failed */
    public p(View view) {
        super(view.getContext());
        this.f8041o = (CollapsibleActionView) view;
        addView(view);
    }
}
