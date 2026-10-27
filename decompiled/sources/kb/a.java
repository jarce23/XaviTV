package kb;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: o, reason: collision with root package name */
    public static final a f7868o;

    /* renamed from: p, reason: collision with root package name */
    public static final a f7869p;

    /* renamed from: q, reason: collision with root package name */
    public static final a f7870q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ a[] f7871r;

    static {
        a aVar = new a("SUSPEND", 0);
        f7868o = aVar;
        a aVar2 = new a("DROP_OLDEST", 1);
        f7869p = aVar2;
        a aVar3 = new a("DROP_LATEST", 2);
        f7870q = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3};
        f7871r = aVarArr;
        a.a.k(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f7871r.clone();
    }
}
