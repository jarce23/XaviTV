package i1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: d, reason: collision with root package name */
    public static final x0 f6066d = new x0(new w0());

    /* renamed from: e, reason: collision with root package name */
    public static final String f6067e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f6068f;
    public static final String g;

    /* renamed from: a, reason: collision with root package name */
    public final int f6069a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6070b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6071c;

    static {
        int i10 = l1.a0.f8067a;
        f6067e = Integer.toString(1, 36);
        f6068f = Integer.toString(2, 36);
        g = Integer.toString(3, 36);
    }

    public x0(w0 w0Var) {
        this.f6069a = w0Var.f6058a;
        this.f6070b = w0Var.f6059b;
        this.f6071c = w0Var.f6060c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && x0.class == obj.getClass()) {
            x0 x0Var = (x0) obj;
            if (this.f6069a == x0Var.f6069a && this.f6070b == x0Var.f6070b && this.f6071c == x0Var.f6071c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f6069a + 31) * 31) + (this.f6070b ? 1 : 0)) * 31) + (this.f6071c ? 1 : 0);
    }
}
