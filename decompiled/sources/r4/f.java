package r4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f10757o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ g f10758p;

    public /* synthetic */ f(g gVar, int i10) {
        this.f10757o = i10;
        this.f10758p = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10757o) {
            case 0:
                g.a(this.f10758p);
                break;
            default:
                g.b(this.f10758p);
                break;
        }
    }
}
