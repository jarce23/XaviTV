package o9;

import java.util.AbstractMap;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x0 extends g0 {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ y0 f9690q;

    public x0(y0 y0Var) {
        this.f9690q = y0Var;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        y0 y0Var = this.f9690q;
        com.bumptech.glide.e.g(i10, y0Var.f9696t);
        Object[] objArr = y0Var.f9695s;
        int i11 = i10 * 2;
        Object obj = objArr[i11];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i11 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // o9.b0
    public final boolean k() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9690q.f9696t;
    }
}
