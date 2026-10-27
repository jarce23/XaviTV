package z4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final j f14102o;

    /* renamed from: p, reason: collision with root package name */
    public final s9.b f14103p;

    public e(j jVar, s9.b bVar) {
        this.f14102o = jVar;
        this.f14103p = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f14102o.f14111o != this) {
            return;
        }
        if (h.f14109t.g(this.f14102o, this, h.f(this.f14103p))) {
            h.c(this.f14102o);
        }
    }
}
