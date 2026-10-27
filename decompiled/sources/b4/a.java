package b4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f2169a;

    /* renamed from: b, reason: collision with root package name */
    public int f2170b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2171c;

    /* renamed from: d, reason: collision with root package name */
    public int f2172d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            int i10 = this.f2169a;
            if (i10 != aVar.f2169a) {
                return false;
            }
            if (i10 != 8 || Math.abs(this.f2172d - this.f2170b) != 1 || this.f2172d != aVar.f2170b || this.f2170b != aVar.f2172d) {
                if (this.f2172d != aVar.f2172d || this.f2170b != aVar.f2170b) {
                    return false;
                }
                Object obj2 = this.f2171c;
                if (obj2 != null) {
                    if (!obj2.equals(aVar.f2171c)) {
                        return false;
                    }
                } else if (aVar.f2171c != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f2169a * 31) + this.f2170b) * 31) + this.f2172d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[");
        int i10 = this.f2169a;
        sb2.append(i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : "up" : "rm" : "add");
        sb2.append(",s:");
        sb2.append(this.f2170b);
        sb2.append("c:");
        sb2.append(this.f2172d);
        sb2.append(",p:");
        sb2.append(this.f2171c);
        sb2.append("]");
        return sb2.toString();
    }
}
