package q3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements Comparable {

    /* renamed from: o, reason: collision with root package name */
    public final int f10297o;

    /* renamed from: p, reason: collision with root package name */
    public final b f10298p;

    public f(int i10, b bVar) {
        this.f10297o = i10;
        this.f10298p = bVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Integer.compare(this.f10297o, ((f) obj).f10297o);
    }
}
