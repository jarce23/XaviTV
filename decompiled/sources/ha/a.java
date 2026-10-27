package ha;

import io.realm.internal.t;
import io.realm.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public z f5764a;

    /* renamed from: b, reason: collision with root package name */
    public t f5765b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        z zVar = aVar.f5764a;
        z zVar2 = this.f5764a;
        if (zVar != zVar2 && !zVar.equals(zVar2)) {
            return false;
        }
        t tVar = aVar.f5765b;
        t tVar2 = this.f5765b;
        if (tVar != tVar2) {
            return tVar != null && tVar.equals(tVar2);
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = this.f5764a.hashCode();
        t tVar = this.f5765b;
        return hashCode ^ (tVar == null ? 0 : tVar.hashCode());
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.f5764a) + " " + String.valueOf(this.f5765b) + "}";
    }
}
