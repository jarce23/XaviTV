package c8;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: q, reason: collision with root package name */
    public final transient int f2962q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f2963r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ e f2964s;

    public d(e eVar, int i10, int i11) {
        this.f2964s = eVar;
        this.f2962q = i10;
        this.f2963r = i11;
    }

    @Override // c8.a
    public final Object[] f() {
        return this.f2964s.f();
    }

    @Override // c8.a
    public final int g() {
        return this.f2964s.g() + this.f2962q;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        com.bumptech.glide.d.N(i10, this.f2963r);
        return this.f2964s.get(i10 + this.f2962q);
    }

    @Override // c8.a
    public final int h() {
        return this.f2964s.g() + this.f2962q + this.f2963r;
    }

    @Override // c8.e, java.util.List
    /* renamed from: k */
    public final e subList(int i10, int i11) {
        com.bumptech.glide.d.O(i10, i11, this.f2963r);
        int i12 = this.f2962q;
        return this.f2964s.subList(i10 + i12, i11 + i12);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2963r;
    }
}
