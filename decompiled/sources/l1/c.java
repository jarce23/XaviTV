package l1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8080o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ b4.b f8081p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f8082q;

    public /* synthetic */ c(b4.b bVar, Object obj, int i10) {
        this.f8080o = i10;
        this.f8081p = bVar;
        this.f8082q = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8080o) {
            case 0:
                b4.b bVar = this.f8081p;
                if (bVar.f2175a == 0) {
                    bVar.z(this.f8082q);
                    break;
                }
                break;
            default:
                b4.b bVar2 = this.f8081p;
                int i10 = bVar2.f2175a - 1;
                bVar2.f2175a = i10;
                if (i10 == 0) {
                    bVar2.z(this.f8082q);
                    break;
                }
                break;
        }
    }
}
