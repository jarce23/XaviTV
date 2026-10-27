package ca;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: o, reason: collision with root package name */
    public static final a f2982o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ a[] f2983p;

    static {
        a aVar = new a("NO_POLICY", 0);
        f2982o = aVar;
        f2983p = new a[]{aVar, new a("IDENTITY", 1), new a("CAMEL_CASE", 2), new a("PASCAL_CASE", 3), new a("LOWER_CASE_WITH_UNDERSCORES", 4)};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f2983p.clone();
    }
}
