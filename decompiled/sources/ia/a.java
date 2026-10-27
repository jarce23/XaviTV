package ia;

import io.realm.i0;
import io.realm.internal.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final i0 f6536a;

    public a(y yVar) {
        this.f6536a = yVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && a.class == obj.getClass() && this.f6536a.equals(((a) obj).f6536a);
    }

    public final int hashCode() {
        return this.f6536a.hashCode() * 31;
    }

    public final String toString() {
        return "ObjectChange{object=" + this.f6536a + ", changeset=null}";
    }
}
