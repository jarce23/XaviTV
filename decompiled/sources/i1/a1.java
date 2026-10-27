package i1;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f5798a;

    /* renamed from: b, reason: collision with root package name */
    public final u0 f5799b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5800c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f5801d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean[] f5802e;

    static {
        l1.a0.J(0);
        l1.a0.J(1);
        l1.a0.J(3);
        l1.a0.J(4);
    }

    public a1(u0 u0Var, boolean z10, int[] iArr, boolean[] zArr) {
        int i10 = u0Var.f6039a;
        this.f5798a = i10;
        boolean z11 = false;
        l1.d.b(i10 == iArr.length && i10 == zArr.length);
        this.f5799b = u0Var;
        if (z10 && i10 > 1) {
            z11 = true;
        }
        this.f5800c = z11;
        this.f5801d = (int[]) iArr.clone();
        this.f5802e = (boolean[]) zArr.clone();
    }

    public final boolean a(int i10) {
        return this.f5801d[i10] == 4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a1.class == obj.getClass()) {
            a1 a1Var = (a1) obj;
            if (this.f5800c == a1Var.f5800c && this.f5799b.equals(a1Var.f5799b) && Arrays.equals(this.f5801d, a1Var.f5801d) && Arrays.equals(this.f5802e, a1Var.f5802e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5802e) + ((Arrays.hashCode(this.f5801d) + (((this.f5799b.hashCode() * 31) + (this.f5800c ? 1 : 0)) * 31)) * 31);
    }
}
