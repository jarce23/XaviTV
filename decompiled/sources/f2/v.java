package f2;

import c2.n1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f4948a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f4949b;

    /* renamed from: c, reason: collision with root package name */
    public final n1[] f4950c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f4951d;

    /* renamed from: e, reason: collision with root package name */
    public final int[][][] f4952e;

    /* renamed from: f, reason: collision with root package name */
    public final n1 f4953f;

    public v(int[] iArr, n1[] n1VarArr, int[] iArr2, int[][][] iArr3, n1 n1Var) {
        this.f4949b = iArr;
        this.f4950c = n1VarArr;
        this.f4952e = iArr3;
        this.f4951d = iArr2;
        this.f4953f = n1Var;
        this.f4948a = iArr.length;
    }

    public final int a() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f4948a; i11++) {
            if (this.f4949b[i11] == 2) {
                int[][] iArr = this.f4952e[i11];
                int length = iArr.length;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    }
                    for (int i14 : iArr[i12]) {
                        int i15 = i14 & 7;
                        int i16 = 1;
                        if (i15 != 0 && i15 != 1 && i15 != 2) {
                            if (i15 == 3) {
                                i16 = 2;
                            } else {
                                if (i15 != 4) {
                                    throw new IllegalStateException();
                                }
                                i13 = 3;
                            }
                        }
                        i13 = Math.max(i13, i16);
                    }
                    i12++;
                }
                i10 = Math.max(i10, i13);
            }
        }
        return i10;
    }
}
