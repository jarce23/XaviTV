package o9;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i0 extends a0 {
    @Override // o9.a0
    public final a0 b(Object obj) {
        obj.getClass();
        a(obj);
        return this;
    }

    public final j0 f() {
        int i10 = this.f9571b;
        if (i10 == 0) {
            int i11 = j0.f9625q;
            return c1.f9592x;
        }
        if (i10 != 1) {
            j0 m10 = j0.m(i10, this.f9570a);
            this.f9571b = m10.size();
            this.f9572c = true;
            return m10;
        }
        Object obj = this.f9570a[0];
        Objects.requireNonNull(obj);
        int i12 = j0.f9625q;
        return new i1(obj);
    }
}
