package i1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: b, reason: collision with root package name */
    public static final b1 f5811b;

    /* renamed from: a, reason: collision with root package name */
    public final o9.g0 f5812a;

    static {
        o9.e0 e0Var = o9.g0.f9617p;
        f5811b = new b1(o9.w0.f9686s);
        l1.a0.J(0);
    }

    public b1(o9.w0 w0Var) {
        this.f5812a = o9.g0.n(w0Var);
    }

    public final boolean a(int i10) {
        int i11 = 0;
        while (true) {
            o9.g0 g0Var = this.f5812a;
            if (i11 >= g0Var.size()) {
                return false;
            }
            a1 a1Var = (a1) g0Var.get(i11);
            boolean[] zArr = a1Var.f5802e;
            int length = zArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                if (!zArr[i12]) {
                    i12++;
                } else if (a1Var.f5799b.f6041c == i10) {
                    return true;
                }
            }
            i11++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b1.class != obj.getClass()) {
            return false;
        }
        return this.f5812a.equals(((b1) obj).f5812a);
    }

    public final int hashCode() {
        return this.f5812a.hashCode();
    }
}
