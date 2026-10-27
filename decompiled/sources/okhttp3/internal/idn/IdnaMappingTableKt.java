package okhttp3.internal.idn;

import ya.l;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class IdnaMappingTableKt {
    public static final int binarySearch(int i10, int i11, l lVar) {
        h.e("compare", lVar);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) / 2;
            int intValue = ((Number) lVar.invoke(Integer.valueOf(i13))).intValue();
            if (intValue < 0) {
                i12 = i13 - 1;
            } else {
                if (intValue <= 0) {
                    return i13;
                }
                i10 = i13 + 1;
            }
        }
        return (-i10) - 1;
    }

    public static final int read14BitInt(String str, int i10) {
        h.e("<this>", str);
        char charAt = str.charAt(i10);
        return (charAt << 7) + str.charAt(i10 + 1);
    }
}
