package o9;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b1 implements Map, Serializable {

    /* renamed from: u, reason: collision with root package name */
    public static final b1 f9578u = new b1(null, new Object[0], 0);

    /* renamed from: o, reason: collision with root package name */
    public transient y0 f9579o;

    /* renamed from: p, reason: collision with root package name */
    public transient z0 f9580p;

    /* renamed from: q, reason: collision with root package name */
    public transient a1 f9581q;

    /* renamed from: r, reason: collision with root package name */
    public final transient Object f9582r;

    /* renamed from: s, reason: collision with root package name */
    public final transient Object[] f9583s;

    /* renamed from: t, reason: collision with root package name */
    public final transient int f9584t;

    public b1(Object obj, Object[] objArr, int i10) {
        this.f9582r = obj;
        this.f9583s = objArr;
        this.f9584t = i10;
    }

    public static b1 a(Map map) {
        if ((map instanceof b1) && !(map instanceof SortedMap)) {
            return (b1) map;
        }
        Set<Map.Entry> entrySet = map.entrySet();
        boolean z10 = entrySet != null;
        c2.j1 j1Var = new c2.j1(z10 ? entrySet.size() : 4);
        if (z10) {
            int size = entrySet.size() * 2;
            Object[] objArr = (Object[]) j1Var.f2626q;
            if (size > objArr.length) {
                j1Var.f2626q = Arrays.copyOf(objArr, a0.e(objArr.length, size));
            }
        }
        for (Map.Entry entry : entrySet) {
            j1Var.q(entry.getKey(), entry.getValue());
        }
        return j1Var.c();
    }

    @Override // java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final j0 entrySet() {
        y0 y0Var = this.f9579o;
        if (y0Var != null) {
            return y0Var;
        }
        y0 y0Var2 = new y0(this, this.f9583s, this.f9584t);
        this.f9579o = y0Var2;
        return y0Var2;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        a1 a1Var = this.f9581q;
        if (a1Var == null) {
            a1Var = new a1(this.f9583s, 1, this.f9584t);
            this.f9581q = a1Var;
        }
        return a1Var.contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return q.d(this, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009f A[RETURN] */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L6
        L3:
            r9 = r0
            goto L9c
        L6:
            java.lang.Object[] r1 = r8.f9583s
            int r2 = r8.f9584t
            r3 = 1
            if (r2 != r3) goto L20
            r2 = 0
            r2 = r1[r2]
            java.util.Objects.requireNonNull(r2)
            boolean r9 = r2.equals(r9)
            if (r9 == 0) goto L3
            r9 = r1[r3]
            java.util.Objects.requireNonNull(r9)
            goto L9c
        L20:
            java.lang.Object r2 = r8.f9582r
            if (r2 != 0) goto L25
            goto L3
        L25:
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L50
            r4 = r2
            byte[] r4 = (byte[]) r4
            int r2 = r4.length
            int r5 = r2 + (-1)
            int r2 = r9.hashCode()
            int r2 = o9.q.m(r2)
        L37:
            r2 = r2 & r5
            r6 = r4[r2]
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            if (r6 != r7) goto L40
            goto L3
        L40:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L4d
            r9 = r6 ^ 1
            r9 = r1[r9]
            goto L9c
        L4d:
            int r2 = r2 + 1
            goto L37
        L50:
            boolean r4 = r2 instanceof short[]
            if (r4 == 0) goto L7c
            r4 = r2
            short[] r4 = (short[]) r4
            int r2 = r4.length
            int r5 = r2 + (-1)
            int r2 = r9.hashCode()
            int r2 = o9.q.m(r2)
        L62:
            r2 = r2 & r5
            short r6 = r4[r2]
            r7 = 65535(0xffff, float:9.1834E-41)
            r6 = r6 & r7
            if (r6 != r7) goto L6c
            goto L3
        L6c:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L79
            r9 = r6 ^ 1
            r9 = r1[r9]
            goto L9c
        L79:
            int r2 = r2 + 1
            goto L62
        L7c:
            int[] r2 = (int[]) r2
            int r4 = r2.length
            int r4 = r4 - r3
            int r5 = r9.hashCode()
            int r5 = o9.q.m(r5)
        L88:
            r5 = r5 & r4
            r6 = r2[r5]
            r7 = -1
            if (r6 != r7) goto L90
            goto L3
        L90:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto La0
            r9 = r6 ^ 1
            r9 = r1[r9]
        L9c:
            if (r9 != 0) goto L9f
            return r0
        L9f:
            return r9
        La0:
            int r5 = r5 + 1
            goto L88
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.b1.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return q.h(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        z0 z0Var = this.f9580p;
        if (z0Var != null) {
            return z0Var;
        }
        z0 z0Var2 = new z0(this, new a1(this.f9583s, 0, this.f9584t));
        this.f9580p = z0Var2;
        return z0Var2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f9584t;
    }

    public final String toString() {
        int i10 = this.f9584t;
        q.b(i10, "size");
        StringBuilder sb2 = new StringBuilder((int) Math.min(i10 * 8, 1073741824L));
        sb2.append('{');
        k1 it = ((y0) entrySet()).iterator();
        boolean z10 = true;
        while (true) {
            e0 e0Var = (e0) it;
            if (!e0Var.hasNext()) {
                sb2.append('}');
                return sb2.toString();
            }
            Map.Entry entry = (Map.Entry) e0Var.next();
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z10 = false;
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        a1 a1Var = this.f9581q;
        if (a1Var != null) {
            return a1Var;
        }
        a1 a1Var2 = new a1(this.f9583s, 1, this.f9584t);
        this.f9581q = a1Var2;
        return a1Var2;
    }
}
