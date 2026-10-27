package l1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    public static final u f8132c = new u(-1, -1);

    /* renamed from: a, reason: collision with root package name */
    public final int f8133a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8134b;

    static {
        new u(0, 0);
    }

    public u(int i10, int i11) {
        d.b((i10 == -1 || i10 >= 0) && (i11 == -1 || i11 >= 0));
        this.f8133a = i10;
        this.f8134b = i11;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f8133a == uVar.f8133a && this.f8134b == uVar.f8134b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.f8133a;
        return ((i10 >>> 16) | (i10 << 16)) ^ this.f8134b;
    }

    public final String toString() {
        return this.f8133a + "x" + this.f8134b;
    }
}
