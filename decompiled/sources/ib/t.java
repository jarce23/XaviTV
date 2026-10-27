package ib;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: o, reason: collision with root package name */
    public static final t f6591o;

    /* renamed from: p, reason: collision with root package name */
    public static final t f6592p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ t[] f6593q;

    static {
        t tVar = new t("DEFAULT", 0);
        f6591o = tVar;
        t tVar2 = new t("LAZY", 1);
        t tVar3 = new t("ATOMIC", 2);
        f6592p = tVar3;
        t[] tVarArr = {tVar, tVar2, tVar3, new t("UNDISPATCHED", 3)};
        f6593q = tVarArr;
        a.a.k(tVarArr);
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f6593q.clone();
    }
}
