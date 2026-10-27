package p;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements Cloneable {

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ int[] f9782o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object[] f9783p;

    /* renamed from: q, reason: collision with root package name */
    public /* synthetic */ int f9784q;

    public j() {
        int i10;
        int i11 = 4;
        while (true) {
            i10 = 40;
            if (i11 >= 32) {
                break;
            }
            int i12 = (1 << i11) - 12;
            if (40 <= i12) {
                i10 = i12;
                break;
            }
            i11++;
        }
        int i13 = i10 / 4;
        this.f9782o = new int[i13];
        this.f9783p = new Object[i13];
    }

    public final void a(int i10, Object obj) {
        int i11 = this.f9784q;
        if (i11 != 0 && i10 <= this.f9782o[i11 - 1]) {
            d(i10, obj);
            return;
        }
        if (i11 >= this.f9782o.length) {
            int i12 = (i11 + 1) * 4;
            int i13 = 4;
            while (true) {
                if (i13 >= 32) {
                    break;
                }
                int i14 = (1 << i13) - 12;
                if (i12 <= i14) {
                    i12 = i14;
                    break;
                }
                i13++;
            }
            int i15 = i12 / 4;
            int[] copyOf = Arrays.copyOf(this.f9782o, i15);
            za.h.d("copyOf(this, newSize)", copyOf);
            this.f9782o = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f9783p, i15);
            za.h.d("copyOf(this, newSize)", copyOf2);
            this.f9783p = copyOf2;
        }
        this.f9782o[i11] = i10;
        this.f9783p[i11] = obj;
        this.f9784q = i11 + 1;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final j clone() {
        Object clone = super.clone();
        za.h.c("null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>", clone);
        j jVar = (j) clone;
        jVar.f9782o = (int[]) this.f9782o.clone();
        jVar.f9783p = (Object[]) this.f9783p.clone();
        return jVar;
    }

    public final Object c(int i10) {
        Object obj;
        int a10 = q.a.a(this.f9784q, i10, this.f9782o);
        if (a10 < 0 || (obj = this.f9783p[a10]) == h.f9778b) {
            return null;
        }
        return obj;
    }

    public final void d(int i10, Object obj) {
        int a10 = q.a.a(this.f9784q, i10, this.f9782o);
        if (a10 >= 0) {
            this.f9783p[a10] = obj;
            return;
        }
        int i11 = ~a10;
        int i12 = this.f9784q;
        if (i11 < i12) {
            Object[] objArr = this.f9783p;
            if (objArr[i11] == h.f9778b) {
                this.f9782o[i11] = i10;
                objArr[i11] = obj;
                return;
            }
        }
        if (i12 >= this.f9782o.length) {
            int i13 = (i12 + 1) * 4;
            int i14 = 4;
            while (true) {
                if (i14 >= 32) {
                    break;
                }
                int i15 = (1 << i14) - 12;
                if (i13 <= i15) {
                    i13 = i15;
                    break;
                }
                i14++;
            }
            int i16 = i13 / 4;
            int[] copyOf = Arrays.copyOf(this.f9782o, i16);
            za.h.d("copyOf(this, newSize)", copyOf);
            this.f9782o = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f9783p, i16);
            za.h.d("copyOf(this, newSize)", copyOf2);
            this.f9783p = copyOf2;
        }
        int i17 = this.f9784q;
        if (i17 - i11 != 0) {
            int[] iArr = this.f9782o;
            int i18 = i11 + 1;
            ma.i.D(i18, i11, i17, iArr, iArr);
            Object[] objArr2 = this.f9783p;
            ma.i.E(i18, i11, this.f9784q, objArr2, objArr2);
        }
        this.f9782o[i11] = i10;
        this.f9783p[i11] = obj;
        this.f9784q++;
    }

    public final String toString() {
        int i10 = this.f9784q;
        if (i10 <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(i10 * 28);
        sb2.append('{');
        int i11 = this.f9784q;
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            sb2.append(this.f9782o[i12]);
            sb2.append('=');
            Object obj = this.f9783p[i12];
            if (obj != this) {
                sb2.append(obj);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        za.h.d("buffer.toString()", sb3);
        return sb3;
    }
}
