package r5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: o, reason: collision with root package name */
    public static final a f10784o;

    /* renamed from: p, reason: collision with root package name */
    public static final a f10785p;

    /* renamed from: q, reason: collision with root package name */
    public static final a f10786q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ a[] f10787r;

    static {
        a aVar = new a("PREFER_ARGB_8888", 0);
        f10784o = aVar;
        a aVar2 = new a("PREFER_RGB_565", 1);
        f10785p = aVar2;
        f10787r = new a[]{aVar, aVar2};
        f10786q = aVar;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f10787r.clone();
    }
}
