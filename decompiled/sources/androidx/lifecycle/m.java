package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: o, reason: collision with root package name */
    public static final m f1144o;

    /* renamed from: p, reason: collision with root package name */
    public static final m f1145p;

    /* renamed from: q, reason: collision with root package name */
    public static final m f1146q;

    /* renamed from: r, reason: collision with root package name */
    public static final m f1147r;

    /* renamed from: s, reason: collision with root package name */
    public static final m f1148s;

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ m[] f1149t;

    static {
        m mVar = new m("DESTROYED", 0);
        f1144o = mVar;
        m mVar2 = new m("INITIALIZED", 1);
        f1145p = mVar2;
        m mVar3 = new m("CREATED", 2);
        f1146q = mVar3;
        m mVar4 = new m("STARTED", 3);
        f1147r = mVar4;
        m mVar5 = new m("RESUMED", 4);
        f1148s = mVar5;
        f1149t = new m[]{mVar, mVar2, mVar3, mVar4, mVar5};
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f1149t.clone();
    }
}
