package io.realm;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: o, reason: collision with root package name */
    public static final z f6898o;

    /* renamed from: p, reason: collision with root package name */
    public static final z f6899p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ z[] f6900q;

    static {
        z zVar = new z("TYPED_REALM", 0);
        f6898o = zVar;
        z zVar2 = new z("DYNAMIC_REALM", 1);
        f6899p = zVar2;
        f6900q = new z[]{zVar, zVar2};
    }

    public static z valueOf(String str) {
        return (z) Enum.valueOf(z.class, str);
    }

    public static z[] values() {
        return (z[]) f6900q.clone();
    }
}
