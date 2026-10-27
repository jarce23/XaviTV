package o9;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z extends v0 implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final Comparator[] f9697o;

    public z(p pVar, p pVar2) {
        this.f9697o = new Comparator[]{pVar, pVar2};
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i10 = 0;
        while (true) {
            Comparator[] comparatorArr = this.f9697o;
            if (i10 >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i10].compare(obj, obj2);
            if (compare != 0) {
                return compare;
            }
            i10++;
        }
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            return Arrays.equals(this.f9697o, ((z) obj).f9697o);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f9697o);
    }

    public final String toString() {
        return android.support.v4.media.d.r(new StringBuilder("Ordering.compound("), Arrays.toString(this.f9697o), ")");
    }
}
