package o9;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 extends m implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final Object f9589o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f9590p;

    public c0(Object obj, Object obj2) {
        this.f9589o = obj;
        this.f9590p = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9589o;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f9590p;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
