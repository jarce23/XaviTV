package o9;

import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y0 extends j0 {

    /* renamed from: r, reason: collision with root package name */
    public final transient b1 f9694r;

    /* renamed from: s, reason: collision with root package name */
    public final transient Object[] f9695s;

    /* renamed from: t, reason: collision with root package name */
    public final transient int f9696t;

    public y0(b1 b1Var, Object[] objArr, int i10) {
        this.f9694r = b1Var;
        this.f9695s = objArr;
        this.f9696t = i10;
    }

    @Override // o9.b0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f9694r.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // o9.b0
    public final int g(int i10, Object[] objArr) {
        return f().g(i10, objArr);
    }

    @Override // o9.b0
    public final boolean k() {
        return true;
    }

    @Override // o9.j0
    public final g0 o() {
        return new x0(this);
    }

    @Override // o9.j0
    /* renamed from: p */
    public final k1 iterator() {
        return f().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f9696t;
    }
}
