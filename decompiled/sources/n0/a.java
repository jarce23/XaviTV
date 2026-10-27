package n0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: o, reason: collision with root package name */
    public final int f9094o;

    /* renamed from: p, reason: collision with root package name */
    public final g f9095p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9096q;

    public a(int i10, g gVar, int i11) {
        this.f9094o = i10;
        this.f9095p = gVar;
        this.f9096q = i11;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f9094o);
        this.f9095p.f9111a.performAction(this.f9096q, bundle);
    }
}
