package t9;

import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f12029a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f12030b;

    public c(String str, Map map) {
        this.f12029a = str;
        this.f12030b = map;
    }

    public static c a(String str) {
        return new c(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f12029a.equals(cVar.f12029a) && this.f12030b.equals(cVar.f12030b);
    }

    public final int hashCode() {
        return this.f12030b.hashCode() + (this.f12029a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f12029a + ", properties=" + this.f12030b.values() + "}";
    }
}
