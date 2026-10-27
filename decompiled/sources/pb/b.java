package pb;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: o, reason: collision with root package name */
    public static final b f10156o;

    /* renamed from: p, reason: collision with root package name */
    public static final b f10157p;

    /* renamed from: q, reason: collision with root package name */
    public static final b f10158q;

    /* renamed from: r, reason: collision with root package name */
    public static final b f10159r;

    /* renamed from: s, reason: collision with root package name */
    public static final b f10160s;

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ b[] f10161t;

    static {
        b bVar = new b("CPU_ACQUIRED", 0);
        f10156o = bVar;
        b bVar2 = new b("BLOCKING", 1);
        f10157p = bVar2;
        b bVar3 = new b("PARKING", 2);
        f10158q = bVar3;
        b bVar4 = new b("DORMANT", 3);
        f10159r = bVar4;
        b bVar5 = new b("TERMINATED", 4);
        f10160s = bVar5;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5};
        f10161t = bVarArr;
        a.a.k(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f10161t.clone();
    }
}
