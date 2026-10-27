package o9;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a1 extends g0 {

    /* renamed from: q, reason: collision with root package name */
    public final transient Object[] f9573q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f9574r;

    /* renamed from: s, reason: collision with root package name */
    public final transient int f9575s;

    public a1(Object[] objArr, int i10, int i11) {
        this.f9573q = objArr;
        this.f9574r = i10;
        this.f9575s = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        com.bumptech.glide.e.g(i10, this.f9575s);
        Object obj = this.f9573q[(i10 * 2) + this.f9574r];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // o9.b0
    public final boolean k() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9575s;
    }
}
