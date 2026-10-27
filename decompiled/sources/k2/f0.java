package k2;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f7726a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f7727b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7728c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7729d;

    public f0(int i10, int i11, int i12, byte[] bArr) {
        this.f7726a = i10;
        this.f7727b = bArr;
        this.f7728c = i11;
        this.f7729d = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f0.class == obj.getClass()) {
            f0 f0Var = (f0) obj;
            if (this.f7726a == f0Var.f7726a && this.f7728c == f0Var.f7728c && this.f7729d == f0Var.f7729d && Arrays.equals(this.f7727b, f0Var.f7727b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f7727b) + (this.f7726a * 31)) * 31) + this.f7728c) * 31) + this.f7729d;
    }
}
