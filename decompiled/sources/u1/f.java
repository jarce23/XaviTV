package u1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name */
    public static final f f12199d = new e3.d().a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12200a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12201b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12202c;

    public f(e3.d dVar) {
        this.f12200a = dVar.f4425a;
        this.f12201b = dVar.f4426b;
        this.f12202c = dVar.f4427c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f12200a == fVar.f12200a && this.f12201b == fVar.f12201b && this.f12202c == fVar.f12202c;
    }

    public final int hashCode() {
        return ((this.f12200a ? 1 : 0) << 2) + ((this.f12201b ? 1 : 0) << 1) + (this.f12202c ? 1 : 0);
    }
}
