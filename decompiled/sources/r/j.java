package r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: v, reason: collision with root package name */
    public final /* synthetic */ k f10403v;

    public j(k kVar) {
        this.f10403v = kVar;
    }

    @Override // r.h
    public final String g() {
        i iVar = (i) this.f10403v.f10404o.get();
        if (iVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + iVar.f10399a + "]";
    }
}
