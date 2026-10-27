package w9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: o, reason: collision with root package name */
    public static final c f13149o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ c[] f13150p;

    static {
        c cVar = new c("DEFAULT", 0);
        f13149o = cVar;
        f13150p = new c[]{cVar, new c("SIGNED", 1), new c("FIXED", 2)};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f13150p.clone();
    }
}
