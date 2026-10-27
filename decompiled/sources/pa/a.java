package pa;

import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a implements g {

    /* renamed from: o, reason: collision with root package name */
    public final h f10141o;

    public a(h hVar) {
        this.f10141o = hVar;
    }

    @Override // pa.i
    public final /* bridge */ i K(i iVar) {
        return i7.e.x(this, iVar);
    }

    @Override // pa.g
    public final h getKey() {
        return this.f10141o;
    }

    @Override // pa.i
    public /* bridge */ i n(h hVar) {
        return i7.e.w(this, hVar);
    }

    @Override // pa.i
    public g s(h hVar) {
        za.h.e("key", hVar);
        if (za.h.a(getKey(), hVar)) {
            return this;
        }
        return null;
    }

    @Override // pa.i
    public final Object x(Object obj, p pVar) {
        return pVar.b(obj, this);
    }
}
