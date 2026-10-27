package c8;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: q, reason: collision with root package name */
    public final transient e f2961q;

    public c(e eVar) {
        this.f2961q = eVar;
    }

    @Override // c8.e, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f2961q.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i10) {
        e eVar = this.f2961q;
        com.bumptech.glide.d.N(i10, eVar.size());
        return eVar.get((eVar.size() - 1) - i10);
    }

    @Override // c8.e, java.util.List
    public final int indexOf(Object obj) {
        int lastIndexOf = this.f2961q.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return (r0.size() - 1) - lastIndexOf;
        }
        return -1;
    }

    @Override // c8.e
    public final e j() {
        return this.f2961q;
    }

    @Override // c8.e, java.util.List
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final e subList(int i10, int i11) {
        e eVar = this.f2961q;
        com.bumptech.glide.d.O(i10, i11, eVar.size());
        return eVar.subList(eVar.size() - i11, eVar.size() - i10).j();
    }

    @Override // c8.e, java.util.List
    public final int lastIndexOf(Object obj) {
        int indexOf = this.f2961q.indexOf(obj);
        if (indexOf >= 0) {
            return (r0.size() - 1) - indexOf;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2961q.size();
    }
}
