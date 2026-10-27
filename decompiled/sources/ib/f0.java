package ib;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f0 extends q {

    /* renamed from: q, reason: collision with root package name */
    public long f6556q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f6557r;

    /* renamed from: s, reason: collision with root package name */
    public ma.h f6558s;

    public final void P() {
        long j10 = this.f6556q - 4294967296L;
        this.f6556q = j10;
        if (j10 <= 0 && this.f6557r) {
            shutdown();
        }
    }

    public final void Q(z zVar) {
        ma.h hVar = this.f6558s;
        if (hVar == null) {
            hVar = new ma.h();
            this.f6558s = hVar;
        }
        hVar.addLast(zVar);
    }

    public abstract Thread R();

    public final void S(boolean z10) {
        this.f6556q = (z10 ? 4294967296L : 1L) + this.f6556q;
        if (z10) {
            return;
        }
        this.f6557r = true;
    }

    public final boolean T() {
        ma.h hVar = this.f6558s;
        if (hVar == null) {
            return false;
        }
        z zVar = (z) (hVar.isEmpty() ? null : hVar.removeFirst());
        if (zVar == null) {
            return false;
        }
        zVar.run();
        return true;
    }

    public abstract void shutdown();
}
