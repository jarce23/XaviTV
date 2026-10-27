package androidx.lifecycle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final t f1139o;

    /* renamed from: p, reason: collision with root package name */
    public final l f1140p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1141q;

    public k0(t tVar, l lVar) {
        za.h.e("registry", tVar);
        za.h.e("event", lVar);
        this.f1139o = tVar;
        this.f1140p = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1141q) {
            return;
        }
        this.f1139o.d(this.f1140p);
        this.f1141q = true;
    }
}
