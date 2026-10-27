package z6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: o, reason: collision with root package name */
    public static final c f14128o;

    /* renamed from: p, reason: collision with root package name */
    public static final c f14129p;

    /* renamed from: q, reason: collision with root package name */
    public static final c f14130q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ c[] f14131r;

    static {
        c cVar = new c("NETWORK_UNMETERED", 0);
        f14128o = cVar;
        c cVar2 = new c("DEVICE_IDLE", 1);
        f14129p = cVar2;
        c cVar3 = new c("DEVICE_CHARGING", 2);
        f14130q = cVar3;
        f14131r = new c[]{cVar, cVar2, cVar3};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f14131r.clone();
    }
}
