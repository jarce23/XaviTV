package f2;

import i1.u0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final u0 f4946a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f4947b;

    public s(int i10, u0 u0Var, int[] iArr) {
        if (iArr.length == 0) {
            l1.b.h("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.f4946a = u0Var;
        this.f4947b = iArr;
    }
}
