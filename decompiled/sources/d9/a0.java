package d9;

import android.util.StateSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public int f4234a;

    /* renamed from: b, reason: collision with root package name */
    public n f4235b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f4236c;

    /* renamed from: d, reason: collision with root package name */
    public n[] f4237d;

    /* renamed from: e, reason: collision with root package name */
    public z f4238e;

    /* renamed from: f, reason: collision with root package name */
    public z f4239f;
    public z g;

    /* renamed from: h, reason: collision with root package name */
    public z f4240h;

    public a0(n nVar) {
        b();
        a(StateSet.WILD_CARD, nVar);
    }

    public final void a(int[] iArr, n nVar) {
        int i10 = this.f4234a;
        if (i10 == 0 || iArr.length == 0) {
            this.f4235b = nVar;
        }
        int[][] iArr2 = this.f4236c;
        if (i10 >= iArr2.length) {
            int i11 = i10 + 10;
            int[][] iArr3 = new int[i11][];
            System.arraycopy(iArr2, 0, iArr3, 0, i10);
            this.f4236c = iArr3;
            n[] nVarArr = new n[i11];
            System.arraycopy(this.f4237d, 0, nVarArr, 0, i10);
            this.f4237d = nVarArr;
        }
        int[][] iArr4 = this.f4236c;
        int i12 = this.f4234a;
        iArr4[i12] = iArr;
        this.f4237d[i12] = nVar;
        this.f4234a = i12 + 1;
    }

    public final void b() {
        this.f4235b = new n();
        this.f4236c = new int[10][];
        this.f4237d = new n[10];
    }
}
