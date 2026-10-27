package l4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8254a = 1;

    /* renamed from: b, reason: collision with root package name */
    public m f8255b;

    public /* synthetic */ r() {
    }

    @Override // l4.n, l4.k
    public void a(m mVar) {
        switch (this.f8254a) {
            case 1:
                a aVar = (a) this.f8255b;
                if (!aVar.R) {
                    aVar.F();
                    aVar.R = true;
                    break;
                }
                break;
        }
    }

    @Override // l4.k
    public final void g(m mVar) {
        switch (this.f8254a) {
            case 0:
                this.f8255b.y();
                mVar.w(this);
                break;
            default:
                a aVar = (a) this.f8255b;
                int i10 = aVar.Q - 1;
                aVar.Q = i10;
                if (i10 == 0) {
                    aVar.R = false;
                    aVar.l();
                }
                mVar.w(this);
                break;
        }
    }

    public r(m mVar) {
        this.f8255b = mVar;
    }
}
