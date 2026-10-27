package nb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class t extends ib.a implements ra.d {

    /* renamed from: r, reason: collision with root package name */
    public final ra.h f9342r;

    public t(pa.i iVar, ra.h hVar) {
        super(iVar, true);
        this.f9342r = hVar;
    }

    @Override // ib.y0
    public final boolean D() {
        return true;
    }

    @Override // ra.d
    public final ra.d getCallerFrame() {
        ra.h hVar = this.f9342r;
        if (r.a.k(hVar)) {
            return hVar;
        }
        return null;
    }

    @Override // ib.y0
    public final void i(Object obj) {
        pa.d m10 = a.a.m(this.f9342r);
        if (obj instanceof ib.l) {
            obj = com.google.android.gms.internal.cast.n.d(((ib.l) obj).f6575a);
        }
        a.g(obj, m10);
    }

    @Override // ib.y0
    public final void j(Object obj) {
        if (obj instanceof ib.l) {
            obj = com.google.android.gms.internal.cast.n.d(((ib.l) obj).f6575a);
        }
        this.f9342r.resumeWith(obj);
    }
}
