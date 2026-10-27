package db;

import com.bumptech.glide.f;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class a implements Iterable, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public final int f4350o;

    /* renamed from: p, reason: collision with root package name */
    public final int f4351p;

    /* renamed from: q, reason: collision with root package name */
    public final int f4352q;

    public a(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f4350o = i10;
        this.f4351p = f.j(i10, i11, i12);
        this.f4352q = i12;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (isEmpty() && ((a) obj).isEmpty()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f4350o == aVar.f4350o && this.f4351p == aVar.f4351p && this.f4352q == aVar.f4352q;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f4350o * 31) + this.f4351p) * 31) + this.f4352q;
    }

    public boolean isEmpty() {
        int i10 = this.f4352q;
        int i11 = this.f4351p;
        int i12 = this.f4350o;
        return i10 > 0 ? i12 > i11 : i12 < i11;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f4350o, this.f4351p, this.f4352q);
    }

    public String toString() {
        StringBuilder sb2;
        int i10 = this.f4351p;
        int i11 = this.f4350o;
        int i12 = this.f4352q;
        if (i12 > 0) {
            sb2 = new StringBuilder();
            sb2.append(i11);
            sb2.append("..");
            sb2.append(i10);
            sb2.append(" step ");
            sb2.append(i12);
        } else {
            sb2 = new StringBuilder();
            sb2.append(i11);
            sb2.append(" downTo ");
            sb2.append(i10);
            sb2.append(" step ");
            sb2.append(-i12);
        }
        return sb2.toString();
    }
}
