package za;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g extends b implements f, eb.a, la.a {

    /* renamed from: u, reason: collision with root package name */
    public final int f14170u;

    /* renamed from: v, reason: collision with root package name */
    public final int f14171v;

    public g(int i10, Object obj, Class cls, String str, String str2, int i11, int i12) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.f14170u = i10;
        this.f14171v = 0;
    }

    @Override // za.f
    public final int a() {
        return this.f14170u;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f14166r.equals(gVar.f14166r) && this.f14167s.equals(gVar.f14167s) && this.f14171v == gVar.f14171v && this.f14170u == gVar.f14170u && h.a(this.f14164p, gVar.f14164p) && e().equals(gVar.e());
        }
        if (!(obj instanceof g)) {
            return false;
        }
        eb.a aVar = this.f14163o;
        if (aVar == null) {
            f();
            this.f14163o = this;
            aVar = this;
        }
        return obj.equals(aVar);
    }

    public final eb.a f() {
        n.f14178a.getClass();
        return this;
    }

    public final int hashCode() {
        e();
        return this.f14167s.hashCode() + android.support.v4.media.d.g(this.f14166r, e().hashCode() * 31, 31);
    }

    public final String toString() {
        eb.a aVar = this.f14163o;
        if (aVar == null) {
            f();
            this.f14163o = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f14166r;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : android.support.v4.media.d.q("function ", str, " (Kotlin reflection is not available)");
    }
}
