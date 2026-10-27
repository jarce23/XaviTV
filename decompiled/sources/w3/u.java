package w3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13013o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f13014p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ androidx.emoji2.text.t f13015q;

    public /* synthetic */ u(androidx.emoji2.text.t tVar, int i10, int i11) {
        this.f13013o = i11;
        this.f13015q = tVar;
        this.f13014p = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13013o) {
            case 0:
                z zVar = ((w) ((x4.m) this.f13015q.f601f).f13566r).f13048t;
                if (zVar != null) {
                    zVar.j(this.f13014p);
                    break;
                }
                break;
            default:
                z zVar2 = ((w) ((x4.m) this.f13015q.f601f).f13566r).f13048t;
                if (zVar2 != null) {
                    zVar2.k(this.f13014p);
                    break;
                }
                break;
        }
    }
}
