package androidx.lifecycle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class SavedStateHandleController implements p {

    /* renamed from: o, reason: collision with root package name */
    public boolean f1108o;

    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        if (lVar == l.ON_DESTROY) {
            this.f1108o = false;
            rVar.f().f(this);
        }
    }
}
