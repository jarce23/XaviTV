package qa;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: o, reason: collision with root package name */
    public static final a f10374o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ a[] f10375p;

    static {
        a aVar = new a("COROUTINE_SUSPENDED", 0);
        f10374o = aVar;
        a[] aVarArr = {aVar, new a("UNDECIDED", 1), new a("RESUMED", 2)};
        f10375p = aVarArr;
        a.a.k(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f10375p.clone();
    }
}
