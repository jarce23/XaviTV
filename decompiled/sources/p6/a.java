package p6;

import com.google.android.gms.internal.cast.n1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f10021a;

    /* renamed from: b, reason: collision with root package name */
    public final n1 f10022b;

    /* renamed from: c, reason: collision with root package name */
    public final c f10023c;

    public a(Integer num, n1 n1Var, c cVar) {
        this.f10021a = num;
        this.f10022b = n1Var;
        this.f10023c = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f10021a.equals(aVar.f10021a) && this.f10022b.equals(aVar.f10022b) && this.f10023c.equals(aVar.f10023c);
    }

    public final int hashCode() {
        return ((((this.f10021a.hashCode() ^ 1000003) * 1000003) ^ this.f10022b.hashCode()) * 1000003) ^ this.f10023c.hashCode();
    }

    public final String toString() {
        return "Event{code=" + this.f10021a + ", payload=" + this.f10022b + ", priority=" + this.f10023c + "}";
    }
}
