package s;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11129a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static StringBuilder a(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        return sb2;
    }

    public static /* synthetic */ int b(int i10) {
        if (i10 != 0) {
            return i10 - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] c(int i10) {
        int[] iArr = new int[i10];
        System.arraycopy(f11129a, 0, iArr, 0, i10);
        return iArr;
    }
}
