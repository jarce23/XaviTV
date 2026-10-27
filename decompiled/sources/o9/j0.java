package o9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class j0 extends b0 implements Set {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f9625q = 0;

    /* renamed from: p, reason: collision with root package name */
    public transient g0 f9626p;

    public static int l(int i10) {
        int max = Math.max(i10, 2);
        if (max >= 751619276) {
            if (max < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * 0.7d < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    public static j0 m(int i10, Object... objArr) {
        if (i10 == 0) {
            return c1.f9592x;
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new i1(obj);
        }
        int l10 = l(i10);
        Object[] objArr2 = new Object[l10];
        int i11 = l10 - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object obj2 = objArr[i14];
            if (obj2 == null) {
                throw new NullPointerException(android.support.v4.media.d.m(i14, "at index "));
            }
            int hashCode = obj2.hashCode();
            int m10 = q.m(hashCode);
            while (true) {
                int i15 = m10 & i11;
                Object obj3 = objArr2[i15];
                if (obj3 == null) {
                    objArr[i13] = obj2;
                    objArr2[i15] = obj2;
                    i12 += hashCode;
                    i13++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                m10++;
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new i1(obj4);
        }
        if (l(i13) < l10 / 2) {
            return m(i13, objArr);
        }
        int length = objArr.length;
        if (i13 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new c1(i12, i11, i13, objArr, objArr2);
    }

    public static j0 n(Collection collection) {
        if ((collection instanceof j0) && !(collection instanceof SortedSet)) {
            j0 j0Var = (j0) collection;
            if (!j0Var.k()) {
                return j0Var;
            }
        }
        Object[] array = collection.toArray();
        return m(array.length, array);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof j0) && (this instanceof c1) && (((j0) obj) instanceof c1) && hashCode() != obj.hashCode()) {
            return false;
        }
        return q.e(this, obj);
    }

    @Override // o9.b0
    public g0 f() {
        g0 g0Var = this.f9626p;
        if (g0Var != null) {
            return g0Var;
        }
        g0 o2 = o();
        this.f9626p = o2;
        return o2;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return q.h(this);
    }

    public g0 o() {
        Object[] array = toArray(b0.f9577o);
        e0 e0Var = g0.f9617p;
        return g0.l(array.length, array);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public abstract k1 iterator();
}
