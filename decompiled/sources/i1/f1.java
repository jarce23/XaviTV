package i1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: d, reason: collision with root package name */
    public static final f1 f5878d = new f1(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f5879a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5880b;

    /* renamed from: c, reason: collision with root package name */
    public final float f5881c;

    static {
        l1.a0.J(0);
        l1.a0.J(1);
        l1.a0.J(3);
    }

    public f1(int i10, int i11) {
        this(1.0f, i10, i11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f1) {
            f1 f1Var = (f1) obj;
            if (this.f5879a == f1Var.f5879a && this.f5880b == f1Var.f5880b && this.f5881c == f1Var.f5881c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f5881c) + ((((217 + this.f5879a) * 31) + this.f5880b) * 31);
    }

    public f1(float f10, int i10, int i11) {
        this.f5879a = i10;
        this.f5880b = i11;
        this.f5881c = f10;
    }
}
