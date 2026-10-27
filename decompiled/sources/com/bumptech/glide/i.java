package com.bumptech.glide;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: o, reason: collision with root package name */
    public static final i f3018o;

    /* renamed from: p, reason: collision with root package name */
    public static final i f3019p;

    /* renamed from: q, reason: collision with root package name */
    public static final i f3020q;

    /* renamed from: r, reason: collision with root package name */
    public static final i f3021r;

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ i[] f3022s;

    static {
        i iVar = new i("IMMEDIATE", 0);
        f3018o = iVar;
        i iVar2 = new i("HIGH", 1);
        f3019p = iVar2;
        i iVar3 = new i("NORMAL", 2);
        f3020q = iVar3;
        i iVar4 = new i("LOW", 3);
        f3021r = iVar4;
        f3022s = new i[]{iVar, iVar2, iVar3, iVar4};
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f3022s.clone();
    }
}
