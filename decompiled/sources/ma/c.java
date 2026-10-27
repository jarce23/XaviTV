package ma;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends d implements RandomAccess {

    /* renamed from: o, reason: collision with root package name */
    public final d f9041o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9042p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9043q;

    public c(d dVar, int i10, int i11) {
        this.f9041o = dVar;
        this.f9042p = i10;
        com.bumptech.glide.d.f(i10, i11, dVar.f());
        this.f9043q = i11 - i10;
    }

    @Override // ma.a
    public final int f() {
        return this.f9043q;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        int i11 = this.f9043q;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        return this.f9041o.get(this.f9042p + i10);
    }

    @Override // ma.d, java.util.List
    public final List subList(int i10, int i11) {
        com.bumptech.glide.d.f(i10, i11, this.f9043q);
        int i12 = this.f9042p;
        return new c(this.f9041o, i10 + i12, i12 + i11);
    }
}
