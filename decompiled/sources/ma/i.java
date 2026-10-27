package ma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i extends com.bumptech.glide.e {
    public static List B(Object[] objArr) {
        za.h.e("<this>", objArr);
        List asList = Arrays.asList(objArr);
        za.h.d("asList(...)", asList);
        return asList;
    }

    public static void C(int i10, int i11, int i12, byte[] bArr, byte[] bArr2) {
        za.h.e("<this>", bArr);
        za.h.e("destination", bArr2);
        System.arraycopy(bArr, i11, bArr2, i10, i12 - i11);
    }

    public static void D(int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        za.h.e("<this>", iArr);
        za.h.e("destination", iArr2);
        System.arraycopy(iArr, i11, iArr2, i10, i12 - i11);
    }

    public static void E(int i10, int i11, int i12, Object[] objArr, Object[] objArr2) {
        za.h.e("<this>", objArr);
        za.h.e("destination", objArr2);
        System.arraycopy(objArr, i11, objArr2, i10, i12 - i11);
    }

    public static /* synthetic */ void F(int i10, int i11, int i12, Object[] objArr, Object[] objArr2) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = objArr.length;
        }
        E(0, i10, i11, objArr, objArr2);
    }

    public static byte[] G(byte[] bArr, int i10, int i11) {
        za.h.e("<this>", bArr);
        com.bumptech.glide.e.j(i11, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        za.h.d("copyOfRange(...)", copyOfRange);
        return copyOfRange;
    }

    public static Object[] H(Object[] objArr, int i10, int i11) {
        za.h.e("<this>", objArr);
        com.bumptech.glide.e.j(i11, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i10, i11);
        za.h.d("copyOfRange(...)", copyOfRange);
        return copyOfRange;
    }

    public static void I(Object[] objArr, Object obj, int i10, int i11) {
        za.h.e("<this>", objArr);
        Arrays.fill(objArr, i10, i11, obj);
    }

    public static ArrayList K(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object L(int i10, Object[] objArr) {
        za.h.e("<this>", objArr);
        if (i10 < 0 || i10 >= objArr.length) {
            return null;
        }
        return objArr[i10];
    }
}
