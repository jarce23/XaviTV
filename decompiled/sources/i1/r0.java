package i1;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f6012a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6013b;

    /* renamed from: c, reason: collision with root package name */
    public int f6014c;

    /* renamed from: d, reason: collision with root package name */
    public long f6015d;

    /* renamed from: e, reason: collision with root package name */
    public long f6016e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6017f;
    public c g = c.f5813c;

    static {
        android.support.v4.media.d.t(0, 1, 2, 3, 4);
    }

    public final long a(int i10, int i11) {
        b a10 = this.g.a(i10);
        if (a10.f5803a != -1) {
            return a10.f5808f[i11];
        }
        return -9223372036854775807L;
    }

    public final int b(long j10) {
        b a10;
        int i10;
        c cVar = this.g;
        long j11 = this.f6015d;
        int i11 = cVar.f5815a;
        if (j10 != Long.MIN_VALUE && (j11 == -9223372036854775807L || j10 < j11)) {
            int i12 = 0;
            while (i12 < i11) {
                cVar.a(i12).getClass();
                cVar.a(i12).getClass();
                if (0 > j10 && ((i10 = (a10 = cVar.a(i12)).f5803a) == -1 || a10.a(-1) < i10)) {
                    break;
                }
                i12++;
            }
            if (i12 < i11) {
                if (j11 != -9223372036854775807L) {
                    cVar.a(i12).getClass();
                    if (0 <= j11) {
                    }
                }
                return i12;
            }
        }
        return -1;
    }

    public final int c(long j10) {
        int i10;
        c cVar = this.g;
        int i11 = cVar.f5815a;
        int i12 = i11 - 1;
        if (i12 == i11 - 1) {
            cVar.a(i12).getClass();
        }
        while (i12 >= 0 && j10 != Long.MIN_VALUE) {
            cVar.a(i12).getClass();
            if (j10 >= 0) {
                break;
            }
            i12--;
        }
        if (i12 >= 0) {
            b a10 = cVar.a(i12);
            int i13 = a10.f5803a;
            if (i13 != -1) {
                while (i10 < i13) {
                    int i14 = a10.f5807e[i10];
                    i10 = (i14 == 0 || i14 == 1) ? 0 : i10 + 1;
                }
            }
            return i12;
        }
        return -1;
    }

    public final long d(int i10) {
        this.g.a(i10).getClass();
        return 0L;
    }

    public final int e(int i10) {
        return this.g.a(i10).a(-1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !r0.class.equals(obj.getClass())) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return Objects.equals(this.f6012a, r0Var.f6012a) && Objects.equals(this.f6013b, r0Var.f6013b) && this.f6014c == r0Var.f6014c && this.f6015d == r0Var.f6015d && this.f6016e == r0Var.f6016e && this.f6017f == r0Var.f6017f && Objects.equals(this.g, r0Var.g);
    }

    public final boolean f(int i10) {
        c cVar = this.g;
        int i11 = cVar.f5815a;
        if (i10 != i11 - 1 || i10 != i11 - 1) {
            return false;
        }
        cVar.a(i10).getClass();
        return false;
    }

    public final boolean g(int i10) {
        this.g.a(i10).getClass();
        return false;
    }

    public final void h(Object obj, Object obj2, int i10, long j10, long j11, c cVar, boolean z10) {
        this.f6012a = obj;
        this.f6013b = obj2;
        this.f6014c = i10;
        this.f6015d = j10;
        this.f6016e = j11;
        this.g = cVar;
        this.f6017f = z10;
    }

    public final int hashCode() {
        Object obj = this.f6012a;
        int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.f6013b;
        int hashCode2 = (((hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f6014c) * 31;
        long j10 = this.f6015d;
        int i10 = (hashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f6016e;
        return this.g.hashCode() + ((((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f6017f ? 1 : 0)) * 31);
    }
}
