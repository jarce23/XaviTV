package androidx.lifecycle;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f1111a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f1112b;

    public b(Method method, int i10) {
        this.f1111a = i10;
        this.f1112b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1111a == bVar.f1111a && this.f1112b.getName().equals(bVar.f1112b.getName());
    }

    public final int hashCode() {
        return this.f1112b.getName().hashCode() + (this.f1111a * 31);
    }
}
