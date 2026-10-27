package ib;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h1 implements pa.g, pa.h {

    /* renamed from: o, reason: collision with root package name */
    public static final h1 f6564o = new h1();

    @Override // pa.i
    public final pa.i K(pa.i iVar) {
        return i7.e.x(this, iVar);
    }

    @Override // pa.i
    public final pa.i n(pa.h hVar) {
        return i7.e.w(this, hVar);
    }

    @Override // pa.i
    public final pa.g s(pa.h hVar) {
        za.h.e("key", hVar);
        if (za.h.a(this, hVar)) {
            return this;
        }
        return null;
    }

    @Override // pa.i
    public final Object x(Object obj, ya.p pVar) {
        return pVar.b(obj, this);
    }

    @Override // pa.g
    public final pa.h getKey() {
        return this;
    }
}
