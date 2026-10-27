package na;

import com.google.android.gms.internal.cast.n;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements Map, Serializable, ab.a {
    public static final f B;
    public boolean A;

    /* renamed from: o, reason: collision with root package name */
    public Object[] f9288o;

    /* renamed from: p, reason: collision with root package name */
    public Object[] f9289p;

    /* renamed from: q, reason: collision with root package name */
    public int[] f9290q;

    /* renamed from: r, reason: collision with root package name */
    public int[] f9291r;

    /* renamed from: s, reason: collision with root package name */
    public int f9292s;

    /* renamed from: t, reason: collision with root package name */
    public int f9293t;

    /* renamed from: u, reason: collision with root package name */
    public int f9294u;

    /* renamed from: v, reason: collision with root package name */
    public int f9295v;

    /* renamed from: w, reason: collision with root package name */
    public int f9296w;

    /* renamed from: x, reason: collision with root package name */
    public g f9297x;

    /* renamed from: y, reason: collision with root package name */
    public h f9298y;

    /* renamed from: z, reason: collision with root package name */
    public g f9299z;

    static {
        f fVar = new f(0);
        fVar.A = true;
        B = fVar;
    }

    public f() {
        this(8);
    }

    public final int a(Object obj) {
        c();
        while (true) {
            int j10 = j(obj);
            int i10 = this.f9292s * 2;
            int length = this.f9291r.length / 2;
            if (i10 > length) {
                i10 = length;
            }
            int i11 = 0;
            while (true) {
                int[] iArr = this.f9291r;
                int i12 = iArr[j10];
                if (i12 <= 0) {
                    int i13 = this.f9293t;
                    Object[] objArr = this.f9288o;
                    if (i13 < objArr.length) {
                        int i14 = i13 + 1;
                        this.f9293t = i14;
                        objArr[i13] = obj;
                        this.f9290q[i13] = j10;
                        iArr[j10] = i14;
                        this.f9296w++;
                        this.f9295v++;
                        if (i11 > this.f9292s) {
                            this.f9292s = i11;
                        }
                        return i13;
                    }
                    g(1);
                } else {
                    if (za.h.a(this.f9288o[i12 - 1], obj)) {
                        return -i12;
                    }
                    i11++;
                    if (i11 > i10) {
                        k(this.f9291r.length * 2);
                        break;
                    }
                    j10 = j10 == 0 ? this.f9291r.length - 1 : j10 - 1;
                }
            }
        }
    }

    public final f b() {
        c();
        this.A = true;
        if (this.f9296w > 0) {
            return this;
        }
        f fVar = B;
        za.h.c("null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>", fVar);
        return fVar;
    }

    public final void c() {
        if (this.A) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        int i10 = this.f9293t - 1;
        if (i10 >= 0) {
            int i11 = 0;
            while (true) {
                int[] iArr = this.f9290q;
                int i12 = iArr[i11];
                if (i12 >= 0) {
                    this.f9291r[i12] = 0;
                    iArr[i11] = -1;
                }
                if (i11 == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        n.r(this.f9288o, 0, this.f9293t);
        Object[] objArr = this.f9289p;
        if (objArr != null) {
            n.r(objArr, 0, this.f9293t);
        }
        this.f9296w = 0;
        this.f9293t = 0;
        this.f9295v++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return h(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public final void d(boolean z10) {
        int i10;
        Object[] objArr = this.f9289p;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.f9293t;
            if (i11 >= i10) {
                break;
            }
            int[] iArr = this.f9290q;
            int i13 = iArr[i11];
            if (i13 >= 0) {
                Object[] objArr2 = this.f9288o;
                objArr2[i12] = objArr2[i11];
                if (objArr != null) {
                    objArr[i12] = objArr[i11];
                }
                if (z10) {
                    iArr[i12] = i13;
                    this.f9291r[i13] = i12 + 1;
                }
                i12++;
            }
            i11++;
        }
        n.r(this.f9288o, i12, i10);
        if (objArr != null) {
            n.r(objArr, i12, this.f9293t);
        }
        this.f9293t = i12;
    }

    public final boolean e(Collection collection) {
        za.h.e("m", collection);
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!f((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = this.f9299z;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 0);
        this.f9299z = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.f9296w == map.size() && e(map.entrySet());
    }

    public final boolean f(Map.Entry entry) {
        za.h.e("entry", entry);
        int h10 = h(entry.getKey());
        if (h10 < 0) {
            return false;
        }
        Object[] objArr = this.f9289p;
        za.h.b(objArr);
        return za.h.a(objArr[h10], entry.getValue());
    }

    public final void g(int i10) {
        Object[] objArr;
        Object[] objArr2 = this.f9288o;
        int length = objArr2.length;
        int i11 = this.f9293t;
        int i12 = length - i11;
        int i13 = i11 - this.f9296w;
        if (i12 < i10 && i12 + i13 >= i10 && i13 >= objArr2.length / 4) {
            d(true);
            return;
        }
        int i14 = i11 + i10;
        if (i14 < 0) {
            throw new OutOfMemoryError();
        }
        if (i14 > objArr2.length) {
            int length2 = objArr2.length;
            int i15 = length2 + (length2 >> 1);
            if (i15 - i14 < 0) {
                i15 = i14;
            }
            if (i15 - 2147483639 > 0) {
                i15 = i14 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] copyOf = Arrays.copyOf(objArr2, i15);
            za.h.d("copyOf(...)", copyOf);
            this.f9288o = copyOf;
            Object[] objArr3 = this.f9289p;
            if (objArr3 != null) {
                objArr = Arrays.copyOf(objArr3, i15);
                za.h.d("copyOf(...)", objArr);
            } else {
                objArr = null;
            }
            this.f9289p = objArr;
            int[] copyOf2 = Arrays.copyOf(this.f9290q, i15);
            za.h.d("copyOf(...)", copyOf2);
            this.f9290q = copyOf2;
            int highestOneBit = Integer.highestOneBit((i15 >= 1 ? i15 : 1) * 3);
            if (highestOneBit > this.f9291r.length) {
                k(highestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int h10 = h(obj);
        if (h10 < 0) {
            return null;
        }
        Object[] objArr = this.f9289p;
        za.h.b(objArr);
        return objArr[h10];
    }

    public final int h(Object obj) {
        int j10 = j(obj);
        int i10 = this.f9292s;
        while (true) {
            int i11 = this.f9291r[j10];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (za.h.a(this.f9288o[i12], obj)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            j10 = j10 == 0 ? this.f9291r.length - 1 : j10 - 1;
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        d dVar = new d(this, 0);
        int i10 = 0;
        while (dVar.hasNext()) {
            int i11 = dVar.f8745o;
            f fVar = (f) dVar.f8748r;
            if (i11 >= fVar.f9293t) {
                throw new NoSuchElementException();
            }
            dVar.f8745o = i11 + 1;
            dVar.f8746p = i11;
            Object obj = fVar.f9288o[i11];
            int hashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = fVar.f9289p;
            za.h.b(objArr);
            Object obj2 = objArr[dVar.f8746p];
            int hashCode2 = obj2 != null ? obj2.hashCode() : 0;
            dVar.e();
            i10 += hashCode ^ hashCode2;
        }
        return i10;
    }

    public final int i(Object obj) {
        int i10 = this.f9293t;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.f9290q[i10] >= 0) {
                Object[] objArr = this.f9289p;
                za.h.b(objArr);
                if (za.h.a(objArr[i10], obj)) {
                    return i10;
                }
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f9296w == 0;
    }

    public final int j(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f9294u;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0032, code lost:
    
        r3[r0] = r6;
        r5.f9290q[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r6) {
        /*
            r5 = this;
            int r0 = r5.f9295v
            int r0 = r0 + 1
            r5.f9295v = r0
            int r0 = r5.f9293t
            int r1 = r5.f9296w
            r2 = 0
            if (r0 <= r1) goto L10
            r5.d(r2)
        L10:
            int[] r0 = new int[r6]
            r5.f9291r = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.f9294u = r6
        L1c:
            int r6 = r5.f9293t
            if (r2 >= r6) goto L50
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f9288o
            r0 = r0[r2]
            int r0 = r5.j(r0)
            int r1 = r5.f9292s
        L2c:
            int[] r3 = r5.f9291r
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.f9290q
            r1[r2] = r0
            r2 = r6
            goto L1c
        L3a:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L48
            int r4 = r0 + (-1)
            if (r0 != 0) goto L46
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L2c
        L46:
            r0 = r4
            goto L2c
        L48:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r6.<init>(r0)
            throw r6
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: na.f.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.f9297x;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 1);
        this.f9297x = gVar2;
        return gVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[LOOP:0: B:8:0x0024->B:25:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f9288o
            java.lang.String r1 = "<this>"
            za.h.e(r1, r0)
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.f9289p
            if (r0 == 0) goto L10
            r0[r12] = r1
        L10:
            int[] r0 = r11.f9290q
            r0 = r0[r12]
            int r1 = r11.f9292s
            int r1 = r1 * 2
            int[] r2 = r11.f9291r
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L20
            r1 = r2
        L20:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L24:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L2e
            int[] r0 = r11.f9291r
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2f
        L2e:
            r0 = r5
        L2f:
            int r4 = r4 + 1
            int r5 = r11.f9292s
            r6 = -1
            if (r4 <= r5) goto L3b
            int[] r0 = r11.f9291r
            r0[r1] = r2
            goto L6c
        L3b:
            int[] r5 = r11.f9291r
            r7 = r5[r0]
            if (r7 != 0) goto L44
            r5[r1] = r2
            goto L6c
        L44:
            if (r7 >= 0) goto L4b
            r5[r1] = r6
        L48:
            r1 = r0
            r4 = r2
            goto L65
        L4b:
            java.lang.Object[] r5 = r11.f9288o
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.j(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f9291r
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L65
            r9[r1] = r7
            int[] r4 = r11.f9290q
            r4[r8] = r1
            goto L48
        L65:
            int r3 = r3 + r6
            if (r3 >= 0) goto L24
            int[] r0 = r11.f9291r
            r0[r1] = r6
        L6c:
            int[] r0 = r11.f9290q
            r0[r12] = r6
            int r12 = r11.f9296w
            int r12 = r12 + r6
            r11.f9296w = r12
            int r12 = r11.f9295v
            int r12 = r12 + 1
            r11.f9295v = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: na.f.l(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        c();
        int a10 = a(obj);
        Object[] objArr = this.f9289p;
        if (objArr == null) {
            int length = this.f9288o.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.f9289p = objArr;
        }
        if (a10 >= 0) {
            objArr[a10] = obj2;
            return null;
        }
        int i10 = (-a10) - 1;
        Object obj3 = objArr[i10];
        objArr[i10] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        za.h.e("from", map);
        c();
        Set<Map.Entry> entrySet = map.entrySet();
        if (entrySet.isEmpty()) {
            return;
        }
        g(entrySet.size());
        for (Map.Entry entry : entrySet) {
            int a10 = a(entry.getKey());
            Object[] objArr = this.f9289p;
            if (objArr == null) {
                int length = this.f9288o.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.f9289p = objArr;
            }
            if (a10 >= 0) {
                objArr[a10] = entry.getValue();
            } else {
                int i10 = (-a10) - 1;
                if (!za.h.a(entry.getValue(), objArr[i10])) {
                    objArr[i10] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        c();
        int h10 = h(obj);
        if (h10 < 0) {
            return null;
        }
        Object[] objArr = this.f9289p;
        za.h.b(objArr);
        Object obj2 = objArr[h10];
        l(h10);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f9296w;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder((this.f9296w * 3) + 2);
        sb2.append("{");
        int i10 = 0;
        d dVar = new d(this, 0);
        while (dVar.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            int i11 = dVar.f8745o;
            f fVar = (f) dVar.f8748r;
            if (i11 >= fVar.f9293t) {
                throw new NoSuchElementException();
            }
            dVar.f8745o = i11 + 1;
            dVar.f8746p = i11;
            Object obj = fVar.f9288o[i11];
            if (obj == fVar) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = fVar.f9289p;
            za.h.b(objArr);
            Object obj2 = objArr[dVar.f8746p];
            if (obj2 == fVar) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            dVar.e();
            i10++;
        }
        sb2.append("}");
        String sb3 = sb2.toString();
        za.h.d("toString(...)", sb3);
        return sb3;
    }

    @Override // java.util.Map
    public final Collection values() {
        h hVar = this.f9298y;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this);
        this.f9298y = hVar2;
        return hVar2;
    }

    public f(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i10];
        int[] iArr = new int[i10];
        int highestOneBit = Integer.highestOneBit((i10 < 1 ? 1 : i10) * 3);
        this.f9288o = objArr;
        this.f9289p = null;
        this.f9290q = iArr;
        this.f9291r = new int[highestOneBit];
        this.f9292s = 2;
        this.f9293t = 0;
        this.f9294u = Integer.numberOfLeadingZeros(highestOneBit) + 1;
    }
}
