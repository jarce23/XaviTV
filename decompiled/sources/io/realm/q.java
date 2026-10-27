package io.realm;

import io.realm.internal.core.NativeRealmAny;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class q extends x {

    /* renamed from: b, reason: collision with root package name */
    public final Object f6808b;

    public q(Object obj) {
        this.f6808b = obj;
    }

    @Override // io.realm.x
    public final Object b(Class cls) {
        return cls.cast(this.f6808b);
    }

    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        Object obj2 = ((q) obj).f6808b;
        Object obj3 = this.f6808b;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f6808b;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return this.f6808b.toString();
    }

    public q(Serializable serializable, NativeRealmAny nativeRealmAny) {
        super(nativeRealmAny);
        this.f6808b = serializable;
    }
}
