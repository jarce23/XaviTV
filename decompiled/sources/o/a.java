package o;

import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: s, reason: collision with root package name */
    public final HashMap f9354s = new HashMap();

    @Override // o.f
    public final c f(Object obj) {
        return (c) this.f9354s.get(obj);
    }

    @Override // o.f
    public final Object g(Object obj) {
        Object g = super.g(obj);
        this.f9354s.remove(obj);
        return g;
    }
}
