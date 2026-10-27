package androidx.fragment.app;

import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends x4.f {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ s f775s;

    public q(s sVar) {
        this.f775s = sVar;
    }

    @Override // x4.f
    public final View F(int i10) {
        s sVar = this.f775s;
        View view = sVar.S;
        if (view != null) {
            return view.findViewById(i10);
        }
        throw new IllegalStateException("Fragment " + sVar + " does not have a view");
    }

    @Override // x4.f
    public final boolean G() {
        return this.f775s.S != null;
    }
}
