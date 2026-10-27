package na;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements Map.Entry, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public final f f9285o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9286p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9287q;

    public e(f fVar, int i10) {
        za.h.e("map", fVar);
        this.f9285o = fVar;
        this.f9286p = i10;
        this.f9287q = fVar.f9295v;
    }

    public final void a() {
        if (this.f9285o.f9295v != this.f9287q) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return za.h.a(entry.getKey(), getKey()) && za.h.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.f9285o.f9288o[this.f9286p];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.f9285o.f9289p;
        za.h.b(objArr);
        return objArr[this.f9286p];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int hashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return hashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        f fVar = this.f9285o;
        fVar.c();
        Object[] objArr = fVar.f9289p;
        if (objArr == null) {
            int length = fVar.f9288o.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            fVar.f9289p = objArr;
        }
        int i10 = this.f9286p;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getKey());
        sb2.append('=');
        sb2.append(getValue());
        return sb2.toString();
    }
}
