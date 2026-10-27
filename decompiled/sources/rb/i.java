package rb;

import java.io.Closeable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    public l f11013o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11014p;

    /* renamed from: q, reason: collision with root package name */
    public n0 f11015q;

    /* renamed from: s, reason: collision with root package name */
    public byte[] f11017s;

    /* renamed from: r, reason: collision with root package name */
    public long f11016r = -1;

    /* renamed from: t, reason: collision with root package name */
    public int f11018t = -1;

    /* renamed from: u, reason: collision with root package name */
    public int f11019u = -1;

    public final void a(long j10) {
        l lVar = this.f11013o;
        if (lVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!this.f11014p) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long j11 = lVar.f11035p;
        if (j10 <= j11) {
            if (j10 < 0) {
                throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "newSize < 0: ").toString());
            }
            long j12 = j11 - j10;
            while (true) {
                if (j12 <= 0) {
                    break;
                }
                n0 n0Var = lVar.f11034o;
                za.h.b(n0Var);
                n0 n0Var2 = n0Var.g;
                za.h.b(n0Var2);
                int i10 = n0Var2.f11044c;
                long j13 = i10 - n0Var2.f11043b;
                if (j13 > j12) {
                    n0Var2.f11044c = i10 - ((int) j12);
                    break;
                } else {
                    lVar.f11034o = n0Var2.a();
                    o0.a(n0Var2);
                    j12 -= j13;
                }
            }
            this.f11015q = null;
            this.f11016r = j10;
            this.f11017s = null;
            this.f11018t = -1;
            this.f11019u = -1;
        } else if (j10 > j11) {
            long j14 = j10 - j11;
            int i11 = 1;
            boolean z10 = true;
            for (long j15 = 0; j14 > j15; j15 = 0) {
                n0 V = lVar.V(i11);
                int min = (int) Math.min(j14, 8192 - V.f11044c);
                int i12 = V.f11044c + min;
                V.f11044c = i12;
                j14 -= min;
                if (z10) {
                    this.f11015q = V;
                    this.f11016r = j11;
                    this.f11017s = V.f11042a;
                    this.f11018t = i12 - min;
                    this.f11019u = i12;
                    z10 = false;
                }
                i11 = 1;
            }
        }
        lVar.f11035p = j10;
    }

    public final int c(long j10) {
        l lVar = this.f11013o;
        if (lVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j10 >= -1) {
            long j11 = lVar.f11035p;
            if (j10 <= j11) {
                if (j10 == -1 || j10 == j11) {
                    this.f11015q = null;
                    this.f11016r = j10;
                    this.f11017s = null;
                    this.f11018t = -1;
                    this.f11019u = -1;
                    return -1;
                }
                n0 n0Var = lVar.f11034o;
                n0 n0Var2 = this.f11015q;
                long j12 = 0;
                if (n0Var2 != null) {
                    long j13 = this.f11016r - (this.f11018t - n0Var2.f11043b);
                    if (j13 > j10) {
                        n0Var2 = n0Var;
                        n0Var = n0Var2;
                        j11 = j13;
                    } else {
                        j12 = j13;
                    }
                } else {
                    n0Var2 = n0Var;
                }
                if (j11 - j10 > j10 - j12) {
                    while (true) {
                        za.h.b(n0Var2);
                        long j14 = (n0Var2.f11044c - n0Var2.f11043b) + j12;
                        if (j10 < j14) {
                            break;
                        }
                        n0Var2 = n0Var2.f11047f;
                        j12 = j14;
                    }
                } else {
                    while (j11 > j10) {
                        za.h.b(n0Var);
                        n0Var = n0Var.g;
                        za.h.b(n0Var);
                        j11 -= n0Var.f11044c - n0Var.f11043b;
                    }
                    n0Var2 = n0Var;
                    j12 = j11;
                }
                if (this.f11014p) {
                    za.h.b(n0Var2);
                    if (n0Var2.f11045d) {
                        byte[] bArr = n0Var2.f11042a;
                        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                        za.h.d("copyOf(...)", copyOf);
                        n0 n0Var3 = new n0(copyOf, n0Var2.f11043b, n0Var2.f11044c, false, true);
                        if (lVar.f11034o == n0Var2) {
                            lVar.f11034o = n0Var3;
                        }
                        n0Var2.b(n0Var3);
                        n0 n0Var4 = n0Var3.g;
                        za.h.b(n0Var4);
                        n0Var4.a();
                        n0Var2 = n0Var3;
                    }
                }
                this.f11015q = n0Var2;
                this.f11016r = j10;
                za.h.b(n0Var2);
                this.f11017s = n0Var2.f11042a;
                int i10 = n0Var2.f11043b + ((int) (j10 - j12));
                this.f11018t = i10;
                int i11 = n0Var2.f11044c;
                this.f11019u = i11;
                return i11 - i10;
            }
        }
        throw new ArrayIndexOutOfBoundsException("offset=" + j10 + " > size=" + lVar.f11035p);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f11013o == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        this.f11013o = null;
        this.f11015q = null;
        this.f11016r = -1L;
        this.f11017s = null;
        this.f11018t = -1;
        this.f11019u = -1;
    }
}
