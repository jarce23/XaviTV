package p;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class i {

    /* renamed from: o, reason: collision with root package name */
    public int[] f9779o;

    /* renamed from: p, reason: collision with root package name */
    public Object[] f9780p;

    /* renamed from: q, reason: collision with root package name */
    public int f9781q;

    public i(int i10) {
        this.f9779o = i10 == 0 ? q.a.f10216a : new int[i10];
        this.f9780p = i10 == 0 ? q.a.f10217b : new Object[i10 << 1];
    }

    public final int a(Object obj) {
        int i10 = this.f9781q * 2;
        Object[] objArr = this.f9780p;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i10) {
        int i11 = this.f9781q;
        int[] iArr = this.f9779o;
        if (iArr.length < i10) {
            int[] copyOf = Arrays.copyOf(iArr, i10);
            za.h.d("copyOf(this, newSize)", copyOf);
            this.f9779o = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f9780p, i10 * 2);
            za.h.d("copyOf(this, newSize)", copyOf2);
            this.f9780p = copyOf2;
        }
        if (this.f9781q != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i10, Object obj) {
        int i11 = this.f9781q;
        if (i11 == 0) {
            return -1;
        }
        int a10 = q.a.a(i11, i10, this.f9779o);
        if (a10 < 0 || za.h.a(obj, this.f9780p[a10 << 1])) {
            return a10;
        }
        int i12 = a10 + 1;
        while (i12 < i11 && this.f9779o[i12] == i10) {
            if (za.h.a(obj, this.f9780p[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = a10 - 1; i13 >= 0 && this.f9779o[i13] == i10; i13--) {
            if (za.h.a(obj, this.f9780p[i13 << 1])) {
                return i13;
            }
        }
        return ~i12;
    }

    public void clear() {
        if (this.f9781q > 0) {
            this.f9779o = q.a.f10216a;
            this.f9780p = q.a.f10217b;
            this.f9781q = 0;
        }
        if (this.f9781q > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj.hashCode(), obj);
    }

    public final int e() {
        int i10 = this.f9781q;
        if (i10 == 0) {
            return -1;
        }
        int a10 = q.a.a(i10, 0, this.f9779o);
        if (a10 < 0 || this.f9780p[a10 << 1] == null) {
            return a10;
        }
        int i11 = a10 + 1;
        while (i11 < i10 && this.f9779o[i11] == 0) {
            if (this.f9780p[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = a10 - 1; i12 >= 0 && this.f9779o[i12] == 0; i12--) {
            if (this.f9780p[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof i) {
                int i10 = this.f9781q;
                if (i10 != ((i) obj).f9781q) {
                    return false;
                }
                i iVar = (i) obj;
                for (int i11 = 0; i11 < i10; i11++) {
                    Object f10 = f(i11);
                    Object j10 = j(i11);
                    Object obj2 = iVar.get(f10);
                    if (j10 == null) {
                        if (obj2 != null || !iVar.containsKey(f10)) {
                            return false;
                        }
                    } else if (!j10.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f9781q != ((Map) obj).size()) {
                return false;
            }
            int i12 = this.f9781q;
            for (int i13 = 0; i13 < i12; i13++) {
                Object f11 = f(i13);
                Object j11 = j(i13);
                Object obj3 = ((Map) obj).get(f11);
                if (j11 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(f11)) {
                        return false;
                    }
                } else if (!j11.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i10) {
        if (i10 < 0 || i10 >= this.f9781q) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return this.f9780p[i10 << 1];
    }

    public void g(e eVar) {
        int i10 = eVar.f9781q;
        b(this.f9781q + i10);
        if (this.f9781q != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(eVar.f(i11), eVar.j(i11));
            }
        } else if (i10 > 0) {
            ma.i.D(0, 0, i10, eVar.f9779o, this.f9779o);
            ma.i.E(0, 0, i10 << 1, eVar.f9780p, this.f9780p);
            this.f9781q = i10;
        }
    }

    public Object get(Object obj) {
        int d6 = d(obj);
        if (d6 >= 0) {
            return this.f9780p[(d6 << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int d6 = d(obj);
        return d6 >= 0 ? this.f9780p[(d6 << 1) + 1] : obj2;
    }

    public Object h(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f9781q)) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Expected index to be within 0..size()-1, but was ").toString());
        }
        Object[] objArr = this.f9780p;
        int i12 = i10 << 1;
        Object obj = objArr[i12 + 1];
        if (i11 <= 1) {
            clear();
            return obj;
        }
        int i13 = i11 - 1;
        int[] iArr = this.f9779o;
        if (iArr.length <= 8 || i11 >= iArr.length / 3) {
            if (i10 < i13) {
                int i14 = i10 + 1;
                ma.i.D(i10, i14, i11, iArr, iArr);
                Object[] objArr2 = this.f9780p;
                ma.i.E(i12, i14 << 1, i11 << 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f9780p;
            int i15 = i13 << 1;
            objArr3[i15] = null;
            objArr3[i15 + 1] = null;
        } else {
            int i16 = i11 > 8 ? i11 + (i11 >> 1) : 8;
            int[] copyOf = Arrays.copyOf(iArr, i16);
            za.h.d("copyOf(this, newSize)", copyOf);
            this.f9779o = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f9780p, i16 << 1);
            za.h.d("copyOf(this, newSize)", copyOf2);
            this.f9780p = copyOf2;
            if (i11 != this.f9781q) {
                throw new ConcurrentModificationException();
            }
            if (i10 > 0) {
                ma.i.D(0, 0, i10, iArr, this.f9779o);
                ma.i.E(0, 0, i12, objArr, this.f9780p);
            }
            if (i10 < i13) {
                int i17 = i10 + 1;
                ma.i.D(i10, i17, i11, iArr, this.f9779o);
                ma.i.E(i12, i17 << 1, i11 << 1, objArr, this.f9780p);
            }
        }
        if (i11 != this.f9781q) {
            throw new ConcurrentModificationException();
        }
        this.f9781q = i13;
        return obj;
    }

    public int hashCode() {
        int[] iArr = this.f9779o;
        Object[] objArr = this.f9780p;
        int i10 = this.f9781q;
        int i11 = 1;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            i13 += (obj != null ? obj.hashCode() : 0) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return i13;
    }

    public Object i(int i10, Object obj) {
        if (i10 < 0 || i10 >= this.f9781q) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Expected index to be within 0..size()-1, but was ").toString());
        }
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.f9780p;
        Object obj2 = objArr[i11];
        objArr[i11] = obj;
        return obj2;
    }

    public final boolean isEmpty() {
        return this.f9781q <= 0;
    }

    public final Object j(int i10) {
        if (i10 < 0 || i10 >= this.f9781q) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return this.f9780p[(i10 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i10 = this.f9781q;
        int hashCode = obj != null ? obj.hashCode() : 0;
        int c10 = obj != null ? c(hashCode, obj) : e();
        if (c10 >= 0) {
            int i11 = (c10 << 1) + 1;
            Object[] objArr = this.f9780p;
            Object obj3 = objArr[i11];
            objArr[i11] = obj2;
            return obj3;
        }
        int i12 = ~c10;
        int[] iArr = this.f9779o;
        if (i10 >= iArr.length) {
            int i13 = 8;
            if (i10 >= 8) {
                i13 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i13 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i13);
            za.h.d("copyOf(this, newSize)", copyOf);
            this.f9779o = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f9780p, i13 << 1);
            za.h.d("copyOf(this, newSize)", copyOf2);
            this.f9780p = copyOf2;
            if (i10 != this.f9781q) {
                throw new ConcurrentModificationException();
            }
        }
        if (i12 < i10) {
            int[] iArr2 = this.f9779o;
            int i14 = i12 + 1;
            ma.i.D(i14, i12, i10, iArr2, iArr2);
            Object[] objArr2 = this.f9780p;
            ma.i.E(i14 << 1, i12 << 1, this.f9781q << 1, objArr2, objArr2);
        }
        int i15 = this.f9781q;
        if (i10 == i15) {
            int[] iArr3 = this.f9779o;
            if (i12 < iArr3.length) {
                iArr3[i12] = hashCode;
                Object[] objArr3 = this.f9780p;
                int i16 = i12 << 1;
                objArr3[i16] = obj;
                objArr3[i16 + 1] = obj2;
                this.f9781q = i15 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int d6 = d(obj);
        if (d6 >= 0) {
            return h(d6);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int d6 = d(obj);
        if (d6 >= 0) {
            return i(d6, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f9781q;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f9781q * 28);
        sb2.append('{');
        int i10 = this.f9781q;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            Object f10 = f(i11);
            if (f10 != sb2) {
                sb2.append(f10);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            Object j10 = j(i11);
            if (j10 != sb2) {
                sb2.append(j10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        za.h.d("StringBuilder(capacity).…builderAction).toString()", sb3);
        return sb3;
    }

    public final boolean remove(Object obj, Object obj2) {
        int d6 = d(obj);
        if (d6 < 0 || !za.h.a(obj2, j(d6))) {
            return false;
        }
        h(d6);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int d6 = d(obj);
        if (d6 < 0 || !za.h.a(obj2, j(d6))) {
            return false;
        }
        i(d6, obj3);
        return true;
    }
}
