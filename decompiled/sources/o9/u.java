package o9;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u extends AbstractMap implements Serializable {

    /* renamed from: x, reason: collision with root package name */
    public static final Object f9672x = new Object();

    /* renamed from: o, reason: collision with root package name */
    public transient Object f9673o;

    /* renamed from: p, reason: collision with root package name */
    public transient int[] f9674p;

    /* renamed from: q, reason: collision with root package name */
    public transient Object[] f9675q;

    /* renamed from: r, reason: collision with root package name */
    public transient Object[] f9676r;

    /* renamed from: s, reason: collision with root package name */
    public transient int f9677s;

    /* renamed from: t, reason: collision with root package name */
    public transient int f9678t;

    /* renamed from: u, reason: collision with root package name */
    public transient s f9679u;

    /* renamed from: v, reason: collision with root package name */
    public transient s f9680v;

    /* renamed from: w, reason: collision with root package name */
    public transient n f9681w;

    public static u a(int i10) {
        u uVar = new u();
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("Expected size must be >= 0");
        }
        uVar.f9677s = Math.min(Math.max(i10, 1), 1073741823);
        return uVar;
    }

    public final Map b() {
        Object obj = this.f9673o;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int c() {
        return (1 << (this.f9677s & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (f()) {
            return;
        }
        this.f9677s += 32;
        Map b2 = b();
        if (b2 != null) {
            this.f9677s = Math.min(Math.max(size(), 3), 1073741823);
            b2.clear();
            this.f9673o = null;
            this.f9678t = 0;
            return;
        }
        Arrays.fill(i(), 0, this.f9678t, (Object) null);
        Arrays.fill(j(), 0, this.f9678t, (Object) null);
        Object obj = this.f9673o;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(h(), 0, this.f9678t, 0);
        this.f9678t = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map b2 = b();
        return b2 != null ? b2.containsKey(obj) : d(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map b2 = b();
        if (b2 != null) {
            return b2.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f9678t; i10++) {
            if (com.bumptech.glide.d.k(obj, j()[i10])) {
                return true;
            }
        }
        return false;
    }

    public final int d(Object obj) {
        if (f()) {
            return -1;
        }
        int n10 = q.n(obj);
        int c10 = c();
        Object obj2 = this.f9673o;
        Objects.requireNonNull(obj2);
        int o2 = q.o(n10 & c10, obj2);
        if (o2 == 0) {
            return -1;
        }
        int i10 = ~c10;
        int i11 = n10 & i10;
        do {
            int i12 = o2 - 1;
            int i13 = h()[i12];
            if ((i13 & i10) == i11 && com.bumptech.glide.d.k(obj, i()[i12])) {
                return i12;
            }
            o2 = i13 & c10;
        } while (o2 != 0);
        return -1;
    }

    public final void e(int i10, int i11) {
        Object obj = this.f9673o;
        Objects.requireNonNull(obj);
        int[] h10 = h();
        Object[] i12 = i();
        Object[] j10 = j();
        int size = size();
        int i13 = size - 1;
        if (i10 >= i13) {
            i12[i10] = null;
            j10[i10] = null;
            h10[i10] = 0;
            return;
        }
        Object obj2 = i12[i13];
        i12[i10] = obj2;
        j10[i10] = j10[i13];
        i12[i13] = null;
        j10[i13] = null;
        h10[i10] = h10[i13];
        h10[i13] = 0;
        int n10 = q.n(obj2) & i11;
        int o2 = q.o(n10, obj);
        if (o2 == size) {
            q.p(n10, i10 + 1, obj);
            return;
        }
        while (true) {
            int i14 = o2 - 1;
            int i15 = h10[i14];
            int i16 = i15 & i11;
            if (i16 == size) {
                h10[i14] = q.j(i15, i10 + 1, i11);
                return;
            }
            o2 = i16;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        s sVar = this.f9680v;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this, 0);
        this.f9680v = sVar2;
        return sVar2;
    }

    public final boolean f() {
        return this.f9673o == null;
    }

    public final Object g(Object obj) {
        if (!f()) {
            int c10 = c();
            Object obj2 = this.f9673o;
            Objects.requireNonNull(obj2);
            int k10 = q.k(obj, null, c10, obj2, h(), i(), null);
            if (k10 != -1) {
                Object obj3 = j()[k10];
                e(k10, c10);
                this.f9678t--;
                this.f9677s += 32;
                return obj3;
            }
        }
        return f9672x;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map b2 = b();
        if (b2 != null) {
            return b2.get(obj);
        }
        int d6 = d(obj);
        if (d6 == -1) {
            return null;
        }
        return j()[d6];
    }

    public final int[] h() {
        int[] iArr = this.f9674p;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] i() {
        Object[] objArr = this.f9675q;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Object[] j() {
        Object[] objArr = this.f9676r;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final int k(int i10, int i11, int i12, int i13) {
        Object c10 = q.c(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            q.p(i12 & i14, i13 + 1, c10);
        }
        Object obj = this.f9673o;
        Objects.requireNonNull(obj);
        int[] h10 = h();
        for (int i15 = 0; i15 <= i10; i15++) {
            int o2 = q.o(i15, obj);
            while (o2 != 0) {
                int i16 = o2 - 1;
                int i17 = h10[i16];
                int i18 = ((~i10) & i17) | i15;
                int i19 = i18 & i14;
                int o6 = q.o(i19, c10);
                q.p(i19, o2, c10);
                h10[i16] = q.j(i18, o6, i14);
                o2 = i17 & i10;
            }
        }
        this.f9673o = c10;
        this.f9677s = q.j(this.f9677s, 32 - Integer.numberOfLeadingZeros(i14), 31);
        return i14;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        s sVar = this.f9679u;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this, 1);
        this.f9679u = sVar2;
        return sVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00f1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0104 -> B:47:0x00ea). Please report as a decompilation issue!!! */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object put(java.lang.Object r23, java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.u.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map b2 = b();
        if (b2 != null) {
            return b2.remove(obj);
        }
        Object g = g(obj);
        if (g == f9672x) {
            return null;
        }
        return g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map b2 = b();
        return b2 != null ? b2.size() : this.f9678t;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        n nVar = this.f9681w;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(1, this);
        this.f9681w = nVar2;
        return nVar2;
    }
}
