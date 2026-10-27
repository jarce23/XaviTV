package p7;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final a f10065a;

    /* renamed from: b, reason: collision with root package name */
    public final n7.c f10066b;

    public /* synthetic */ l(a aVar, n7.c cVar) {
        this.f10065a = aVar;
        this.f10066b = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (r7.r.h(this.f10065a, lVar.f10065a) && r7.r.h(this.f10066b, lVar.f10066b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10065a, this.f10066b});
    }

    public final String toString() {
        x4.r rVar = new x4.r(this);
        rVar.e("key", this.f10065a);
        rVar.e("feature", this.f10066b);
        return rVar.toString();
    }
}
