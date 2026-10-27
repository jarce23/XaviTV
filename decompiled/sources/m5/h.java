package m5;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f8971o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ long f8972p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ i f8973q;

    public h(i iVar, String str, long j10) {
        this.f8973q = iVar;
        this.f8971o = str;
        this.f8972p = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.f8973q;
        iVar.f8974o.a(this.f8972p, this.f8971o);
        iVar.f8974o.b(iVar.toString());
    }
}
