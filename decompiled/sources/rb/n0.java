package rb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f11042a;

    /* renamed from: b, reason: collision with root package name */
    public int f11043b;

    /* renamed from: c, reason: collision with root package name */
    public int f11044c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11045d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11046e;

    /* renamed from: f, reason: collision with root package name */
    public n0 f11047f;
    public n0 g;

    public n0() {
        this.f11042a = new byte[8192];
        this.f11046e = true;
        this.f11045d = false;
    }

    public final n0 a() {
        n0 n0Var = this.f11047f;
        if (n0Var == this) {
            n0Var = null;
        }
        n0 n0Var2 = this.g;
        za.h.b(n0Var2);
        n0Var2.f11047f = this.f11047f;
        n0 n0Var3 = this.f11047f;
        za.h.b(n0Var3);
        n0Var3.g = this.g;
        this.f11047f = null;
        this.g = null;
        return n0Var;
    }

    public final void b(n0 n0Var) {
        za.h.e("segment", n0Var);
        n0Var.g = this;
        n0Var.f11047f = this.f11047f;
        n0 n0Var2 = this.f11047f;
        za.h.b(n0Var2);
        n0Var2.g = n0Var;
        this.f11047f = n0Var;
    }

    public final n0 c() {
        this.f11045d = true;
        return new n0(this.f11042a, this.f11043b, this.f11044c, true, false);
    }

    public final void d(n0 n0Var, int i10) {
        za.h.e("sink", n0Var);
        byte[] bArr = n0Var.f11042a;
        if (!n0Var.f11046e) {
            throw new IllegalStateException("only owner can write");
        }
        int i11 = n0Var.f11044c;
        int i12 = i11 + i10;
        if (i12 > 8192) {
            if (n0Var.f11045d) {
                throw new IllegalArgumentException();
            }
            int i13 = n0Var.f11043b;
            if (i12 - i13 > 8192) {
                throw new IllegalArgumentException();
            }
            ma.i.C(0, i13, i11, bArr, bArr);
            n0Var.f11044c -= n0Var.f11043b;
            n0Var.f11043b = 0;
        }
        int i14 = n0Var.f11044c;
        int i15 = this.f11043b;
        ma.i.C(i14, i15, i15 + i10, this.f11042a, bArr);
        n0Var.f11044c += i10;
        this.f11043b += i10;
    }

    public n0(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        za.h.e("data", bArr);
        this.f11042a = bArr;
        this.f11043b = i10;
        this.f11044c = i11;
        this.f11045d = z10;
        this.f11046e = z11;
    }
}
