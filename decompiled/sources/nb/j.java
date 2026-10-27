package nb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class j extends za.b implements ya.a, eb.a {

    /* renamed from: u, reason: collision with root package name */
    public final boolean f9328u;

    public j(k kVar) {
        super(kVar, ib.v.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
        this.f9328u = false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return e().equals(jVar.e()) && this.f14166r.equals(jVar.f14166r) && this.f14167s.equals(jVar.f14167s) && za.h.a(this.f14164p, jVar.f14164p);
        }
        if (obj instanceof j) {
            return obj.equals(f());
        }
        return false;
    }

    public final eb.a f() {
        if (this.f9328u) {
            return this;
        }
        eb.a aVar = this.f14163o;
        if (aVar != null) {
            return aVar;
        }
        za.n.f14178a.getClass();
        this.f14163o = this;
        return this;
    }

    public final int hashCode() {
        return this.f14167s.hashCode() + android.support.v4.media.d.g(this.f14166r, e().hashCode() * 31, 31);
    }

    @Override // ya.a
    public final Object invoke() {
        return this.f14164p.getClass().getSimpleName();
    }

    public final String toString() {
        eb.a f10 = f();
        return f10 != this ? f10.toString() : android.support.v4.media.d.r(new StringBuilder("property "), this.f14166r, " (Kotlin reflection is not available)");
    }
}
