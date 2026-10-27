package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends x4.f {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ q f738s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ o f739t;

    public n(o oVar, q qVar) {
        this.f739t = oVar;
        this.f738s = qVar;
    }

    @Override // x4.f
    public final View F(int i10) {
        q qVar = this.f738s;
        if (qVar.G()) {
            return qVar.F(i10);
        }
        Dialog dialog = this.f739t.f762s0;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    @Override // x4.f
    public final boolean G() {
        return this.f738s.G() || this.f739t.f766w0;
    }
}
