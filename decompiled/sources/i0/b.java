package i0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5778a;

    /* renamed from: b, reason: collision with root package name */
    public a f5779b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5780c;

    public final void a(a aVar) {
        synchronized (this) {
            while (this.f5780c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (this.f5779b == aVar) {
                return;
            }
            this.f5779b = aVar;
            if (this.f5778a) {
                aVar.onCancel();
            }
        }
    }
}
