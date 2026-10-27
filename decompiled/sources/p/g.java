package p;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements Cloneable {

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ boolean f9773o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ long[] f9774p;

    /* renamed from: q, reason: collision with root package name */
    public /* synthetic */ Object[] f9775q;

    /* renamed from: r, reason: collision with root package name */
    public /* synthetic */ int f9776r;

    public g() {
        int i10;
        int i11 = 4;
        while (true) {
            i10 = 80;
            if (i11 >= 32) {
                break;
            }
            int i12 = (1 << i11) - 12;
            if (80 <= i12) {
                i10 = i12;
                break;
            }
            i11++;
        }
        int i13 = i10 / 8;
        this.f9774p = new long[i13];
        this.f9775q = new Object[i13];
    }

    public final void a(long j10, Long l10) {
        int i10 = this.f9776r;
        if (i10 != 0 && j10 <= this.f9774p[i10 - 1]) {
            g(j10, l10);
            return;
        }
        if (this.f9773o) {
            long[] jArr = this.f9774p;
            if (i10 >= jArr.length) {
                Object[] objArr = this.f9775q;
                int i11 = 0;
                for (int i12 = 0; i12 < i10; i12++) {
                    Object obj = objArr[i12];
                    if (obj != h.f9777a) {
                        if (i12 != i11) {
                            jArr[i11] = jArr[i12];
                            objArr[i11] = obj;
                            objArr[i12] = null;
                        }
                        i11++;
                    }
                }
                this.f9773o = false;
                this.f9776r = i11;
            }
        }
        int i13 = this.f9776r;
        if (i13 >= this.f9774p.length) {
            int i14 = (i13 + 1) * 8;
            int i15 = 4;
            while (true) {
                if (i15 >= 32) {
                    break;
                }
                int i16 = (1 << i15) - 12;
                if (i14 <= i16) {
                    i14 = i16;
                    break;
                }
                i15++;
            }
            int i17 = i14 / 8;
            long[] copyOf = Arrays.copyOf(this.f9774p, i17);
            za.h.d("copyOf(this, newSize)", copyOf);
            this.f9774p = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f9775q, i17);
            za.h.d("copyOf(this, newSize)", copyOf2);
            this.f9775q = copyOf2;
        }
        this.f9774p[i13] = j10;
        this.f9775q[i13] = l10;
        this.f9776r = i13 + 1;
    }

    public final void b() {
        int i10 = this.f9776r;
        Object[] objArr = this.f9775q;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f9776r = 0;
        this.f9773o = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final g clone() {
        Object clone = super.clone();
        za.h.c("null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>", clone);
        g gVar = (g) clone;
        gVar.f9774p = (long[]) this.f9774p.clone();
        gVar.f9775q = (Object[]) this.f9775q.clone();
        return gVar;
    }

    public final Object d(long j10) {
        Object obj;
        int b2 = q.a.b(this.f9774p, this.f9776r, j10);
        if (b2 < 0 || (obj = this.f9775q[b2]) == h.f9777a) {
            return null;
        }
        return obj;
    }

    public final Object e(long j10) {
        Object obj;
        int b2 = q.a.b(this.f9774p, this.f9776r, j10);
        if (b2 < 0 || (obj = this.f9775q[b2]) == h.f9777a) {
            return -1L;
        }
        return obj;
    }

    public final long f(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f9776r)) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.f9773o) {
            long[] jArr = this.f9774p;
            Object[] objArr = this.f9775q;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != h.f9777a) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.f9773o = false;
            this.f9776r = i12;
        }
        return this.f9774p[i10];
    }

    public final void g(long j10, Object obj) {
        Object obj2 = h.f9777a;
        int b2 = q.a.b(this.f9774p, this.f9776r, j10);
        if (b2 >= 0) {
            this.f9775q[b2] = obj;
            return;
        }
        int i10 = ~b2;
        int i11 = this.f9776r;
        if (i10 < i11) {
            Object[] objArr = this.f9775q;
            if (objArr[i10] == obj2) {
                this.f9774p[i10] = j10;
                objArr[i10] = obj;
                return;
            }
        }
        if (this.f9773o) {
            long[] jArr = this.f9774p;
            if (i11 >= jArr.length) {
                Object[] objArr2 = this.f9775q;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    Object obj3 = objArr2[i13];
                    if (obj3 != obj2) {
                        if (i13 != i12) {
                            jArr[i12] = jArr[i13];
                            objArr2[i12] = obj3;
                            objArr2[i13] = null;
                        }
                        i12++;
                    }
                }
                this.f9773o = false;
                this.f9776r = i12;
                i10 = ~q.a.b(this.f9774p, i12, j10);
            }
        }
        int i14 = this.f9776r;
        if (i14 >= this.f9774p.length) {
            int i15 = (i14 + 1) * 8;
            int i16 = 4;
            while (true) {
                if (i16 >= 32) {
                    break;
                }
                int i17 = (1 << i16) - 12;
                if (i15 <= i17) {
                    i15 = i17;
                    break;
                }
                i16++;
            }
            int i18 = i15 / 8;
            long[] copyOf = Arrays.copyOf(this.f9774p, i18);
            za.h.d("copyOf(this, newSize)", copyOf);
            this.f9774p = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f9775q, i18);
            za.h.d("copyOf(this, newSize)", copyOf2);
            this.f9775q = copyOf2;
        }
        int i19 = this.f9776r - i10;
        if (i19 != 0) {
            long[] jArr2 = this.f9774p;
            int i20 = i10 + 1;
            za.h.e("<this>", jArr2);
            System.arraycopy(jArr2, i10, jArr2, i20, i19);
            Object[] objArr3 = this.f9775q;
            ma.i.E(i20, i10, this.f9776r, objArr3, objArr3);
        }
        this.f9774p[i10] = j10;
        this.f9775q[i10] = obj;
        this.f9776r++;
    }

    public final int h() {
        if (this.f9773o) {
            int i10 = this.f9776r;
            long[] jArr = this.f9774p;
            Object[] objArr = this.f9775q;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != h.f9777a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f9773o = false;
            this.f9776r = i11;
        }
        return this.f9776r;
    }

    public final Object i(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f9776r)) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.f9773o) {
            long[] jArr = this.f9774p;
            Object[] objArr = this.f9775q;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != h.f9777a) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.f9773o = false;
            this.f9776r = i12;
        }
        return this.f9775q[i10];
    }

    public final String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f9776r * 28);
        sb2.append('{');
        int i10 = this.f9776r;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(f(i11));
            sb2.append('=');
            Object i12 = i(i11);
            if (i12 != sb2) {
                sb2.append(i12);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        za.h.d("StringBuilder(capacity).…builderAction).toString()", sb3);
        return sb3;
    }
}
