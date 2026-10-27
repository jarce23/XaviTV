package ma;

import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class k extends com.bumptech.glide.f {
    public static int w(List list) {
        za.h.e("<this>", list);
        return list.size() - 1;
    }

    public static List x(Object... objArr) {
        return objArr.length > 0 ? i.B(objArr) : p.f9051o;
    }

    public static void y() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
