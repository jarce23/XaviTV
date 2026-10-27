package p6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: o, reason: collision with root package name */
    public static final c f10025o;

    /* renamed from: p, reason: collision with root package name */
    public static final c f10026p;

    /* renamed from: q, reason: collision with root package name */
    public static final c f10027q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ c[] f10028r;

    static {
        c cVar = new c("DEFAULT", 0);
        f10025o = cVar;
        c cVar2 = new c("VERY_LOW", 1);
        f10026p = cVar2;
        c cVar3 = new c("HIGHEST", 2);
        f10027q = cVar3;
        f10028r = new c[]{cVar, cVar2, cVar3};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f10028r.clone();
    }
}
