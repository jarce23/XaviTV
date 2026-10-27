package w3;

import android.os.Bundle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f12938a;

    /* renamed from: b, reason: collision with root package name */
    public o f12939b;

    public j(o oVar, boolean z10) {
        if (oVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        Bundle bundle = new Bundle();
        this.f12938a = bundle;
        this.f12939b = oVar;
        bundle.putBundle("selector", oVar.f12982a);
        bundle.putBoolean("activeScan", z10);
    }

    public final void a() {
        if (this.f12939b == null) {
            o b2 = o.b(this.f12938a.getBundle("selector"));
            this.f12939b = b2;
            if (b2 == null) {
                this.f12939b = o.f12981c;
            }
        }
    }

    public final boolean b() {
        return this.f12938a.getBoolean("activeScan");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            j jVar = (j) obj;
            a();
            o oVar = this.f12939b;
            jVar.a();
            if (oVar.equals(jVar.f12939b) && b() == jVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        a();
        return this.f12939b.hashCode() ^ (b() ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DiscoveryRequest{ selector=");
        a();
        sb2.append(this.f12939b);
        sb2.append(", activeScan=");
        sb2.append(b());
        sb2.append(", isValid=");
        a();
        this.f12939b.a();
        sb2.append(!r1.f12983b.contains(null));
        sb2.append(" }");
        return sb2.toString();
    }
}
