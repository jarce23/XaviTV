package o9;

import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: o, reason: collision with root package name */
    public transient Set f9648o;

    /* renamed from: p, reason: collision with root package name */
    public transient n f9649p;

    /* renamed from: q, reason: collision with root package name */
    public transient Map f9650q;

    public abstract Map a();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            return ((s0) this).a().equals(((s0) ((o) obj)).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a().toString();
    }
}
