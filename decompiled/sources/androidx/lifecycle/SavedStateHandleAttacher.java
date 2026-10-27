package androidx.lifecycle;

import android.os.Bundle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements p {

    /* renamed from: o, reason: collision with root package name */
    public final i0 f1107o;

    public SavedStateHandleAttacher(i0 i0Var) {
        this.f1107o = i0Var;
    }

    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        if (lVar != l.ON_CREATE) {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + lVar).toString());
        }
        rVar.f().f(this);
        i0 i0Var = this.f1107o;
        if (i0Var.f1134b) {
            return;
        }
        Bundle c10 = i0Var.f1133a.c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = i0Var.f1135c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (c10 != null) {
            bundle.putAll(c10);
        }
        i0Var.f1135c = bundle;
        i0Var.f1134b = true;
    }
}
