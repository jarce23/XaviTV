package r6;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends v {

    /* renamed from: a, reason: collision with root package name */
    public final u f10858a;

    /* renamed from: b, reason: collision with root package name */
    public final t f10859b;

    public n(u uVar, t tVar) {
        this.f10858a = uVar;
        this.f10859b = tVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            u uVar = this.f10858a;
            if (uVar != null ? uVar.equals(((n) vVar).f10858a) : ((n) vVar).f10858a == null) {
                t tVar = this.f10859b;
                if (tVar != null ? tVar.equals(((n) vVar).f10859b) : ((n) vVar).f10859b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        u uVar = this.f10858a;
        int hashCode = ((uVar == null ? 0 : uVar.hashCode()) ^ 1000003) * 1000003;
        t tVar = this.f10859b;
        return (tVar != null ? tVar.hashCode() : 0) ^ hashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f10858a + ", mobileSubtype=" + this.f10859b + "}";
    }
}
