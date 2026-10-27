package c2;

import java.util.Arrays;
import java.util.Random;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    public final Random f2598a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f2599b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f2600c;

    public h1() {
        this(new Random());
    }

    public final h1 a(int i10) {
        int[] iArr;
        Random random;
        int[] iArr2 = new int[i10];
        int[] iArr3 = new int[i10];
        int i11 = 0;
        while (true) {
            iArr = this.f2599b;
            random = this.f2598a;
            if (i11 >= i10) {
                break;
            }
            iArr2[i11] = random.nextInt(iArr.length + 1);
            int i12 = i11 + 1;
            int nextInt = random.nextInt(i12);
            iArr3[i11] = iArr3[nextInt];
            iArr3[nextInt] = i11;
            i11 = i12;
        }
        Arrays.sort(iArr2);
        int[] iArr4 = new int[iArr.length + i10];
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < iArr.length + i10; i15++) {
            if (i13 >= i10 || i14 != iArr2[i13]) {
                int i16 = i14 + 1;
                int i17 = iArr[i14];
                iArr4[i15] = i17;
                if (i17 >= 0) {
                    iArr4[i15] = i17 + i10;
                }
                i14 = i16;
            } else {
                iArr4[i15] = iArr3[i13];
                i13++;
            }
        }
        return new h1(iArr4, new Random(random.nextLong()));
    }

    public h1(int[] iArr, Random random) {
        this.f2599b = iArr;
        this.f2598a = random;
        this.f2600c = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            this.f2600c[iArr[i10]] = i10;
        }
    }

    public h1(Random random) {
        this(new int[0], random);
    }
}
