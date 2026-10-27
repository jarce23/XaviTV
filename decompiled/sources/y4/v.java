package y4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final w f13861o;

    /* renamed from: p, reason: collision with root package name */
    public final x4.j f13862p;

    public v(w wVar, x4.j jVar) {
        this.f13861o = wVar;
        this.f13862p = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f13861o.f13867d) {
            try {
                if (((v) this.f13861o.f13865b.remove(this.f13862p)) != null) {
                    u uVar = (u) this.f13861o.f13866c.remove(this.f13862p);
                    if (uVar != null) {
                        x4.j jVar = this.f13862p;
                        r4.g gVar = (r4.g) uVar;
                        o4.p.d().a(r4.g.C, "Exceeded time limits on execution for " + jVar);
                        gVar.f10766v.execute(new r4.f(gVar, 0));
                    }
                } else {
                    o4.p.d().a("WrkTimerRunnable", "Timer with " + this.f13862p + " is already marked as complete.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
