package i1;

import java.util.Arrays;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final e0[] f5876a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5877b;

    public f0(e0... e0VarArr) {
        this(-9223372036854775807L, e0VarArr);
    }

    public final f0 a(e0... e0VarArr) {
        if (e0VarArr.length == 0) {
            return this;
        }
        int i10 = l1.a0.f8067a;
        e0[] e0VarArr2 = this.f5876a;
        Object[] copyOf = Arrays.copyOf(e0VarArr2, e0VarArr2.length + e0VarArr.length);
        System.arraycopy(e0VarArr, 0, copyOf, e0VarArr2.length, e0VarArr.length);
        return new f0(this.f5877b, (e0[]) copyOf);
    }

    public final f0 b(f0 f0Var) {
        return f0Var == null ? this : a(f0Var.f5876a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f0.class == obj.getClass()) {
            f0 f0Var = (f0) obj;
            if (Arrays.equals(this.f5876a, f0Var.f5876a) && this.f5877b == f0Var.f5877b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return i7.e.q(this.f5877b) + (Arrays.hashCode(this.f5876a) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("entries=");
        sb2.append(Arrays.toString(this.f5876a));
        long j10 = this.f5877b;
        if (j10 == -9223372036854775807L) {
            str = _UrlKt.FRAGMENT_ENCODE_SET;
        } else {
            str = ", presentationTimeUs=" + j10;
        }
        sb2.append(str);
        return sb2.toString();
    }

    public f0(long j10, e0... e0VarArr) {
        this.f5877b = j10;
        this.f5876a = e0VarArr;
    }

    public f0(List list) {
        this((e0[]) list.toArray(new e0[0]));
    }
}
