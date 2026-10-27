package b4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o1 {

    /* renamed from: a, reason: collision with root package name */
    public int f2371a;

    /* renamed from: b, reason: collision with root package name */
    public int f2372b;

    /* renamed from: c, reason: collision with root package name */
    public int f2373c;

    /* renamed from: d, reason: collision with root package name */
    public int f2374d;

    /* renamed from: e, reason: collision with root package name */
    public int f2375e;

    public boolean a() {
        int i10 = this.f2371a;
        int i11 = 2;
        if ((i10 & 7) != 0) {
            int i12 = this.f2374d;
            int i13 = this.f2372b;
            if (((i12 > i13 ? 1 : i12 == i13 ? 2 : 4) & i10) == 0) {
                return false;
            }
        }
        if ((i10 & 112) != 0) {
            int i14 = this.f2374d;
            int i15 = this.f2373c;
            if ((((i14 > i15 ? 1 : i14 == i15 ? 2 : 4) << 4) & i10) == 0) {
                return false;
            }
        }
        if ((i10 & 1792) != 0) {
            int i16 = this.f2375e;
            int i17 = this.f2372b;
            if ((((i16 > i17 ? 1 : i16 == i17 ? 2 : 4) << 8) & i10) == 0) {
                return false;
            }
        }
        if ((i10 & 28672) != 0) {
            int i18 = this.f2375e;
            int i19 = this.f2373c;
            if (i18 > i19) {
                i11 = 1;
            } else if (i18 != i19) {
                i11 = 4;
            }
            if ((i10 & (i11 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
