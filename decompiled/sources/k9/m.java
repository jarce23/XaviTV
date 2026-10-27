package k9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class m implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final i8.d f7850o;

    public m() {
        this.f7850o = null;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e7) {
            i8.d dVar = this.f7850o;
            if (dVar != null) {
                dVar.c(e7);
            }
        }
    }

    public m(i8.d dVar) {
        this.f7850o = dVar;
    }
}
