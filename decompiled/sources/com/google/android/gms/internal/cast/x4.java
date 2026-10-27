package com.google.android.gms.internal.cast;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x4 {

    /* renamed from: p, reason: collision with root package name */
    public static final x4 f3580p;

    /* renamed from: q, reason: collision with root package name */
    public static final x4 f3581q;

    /* renamed from: r, reason: collision with root package name */
    public static final x4[] f3582r;

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ x4[] f3583s;

    /* renamed from: o, reason: collision with root package name */
    public final int f3584o;

    /* JADX INFO: Fake field, exist only in values array */
    x4 EF0;

    static {
        h5 h5Var = h5.f3326s;
        x4 x4Var = new x4("DOUBLE", 0, 0, 1, h5Var);
        h5 h5Var2 = h5.f3325r;
        x4 x4Var2 = new x4("FLOAT", 1, 1, 1, h5Var2);
        h5 h5Var3 = h5.f3324q;
        x4 x4Var3 = new x4("INT64", 2, 2, 1, h5Var3);
        x4 x4Var4 = new x4("UINT64", 3, 3, 1, h5Var3);
        h5 h5Var4 = h5.f3323p;
        x4 x4Var5 = new x4("INT32", 4, 4, 1, h5Var4);
        x4 x4Var6 = new x4("FIXED64", 5, 5, 1, h5Var3);
        x4 x4Var7 = new x4("FIXED32", 6, 6, 1, h5Var4);
        h5 h5Var5 = h5.f3327t;
        x4 x4Var8 = new x4("BOOL", 7, 7, 1, h5Var5);
        h5 h5Var6 = h5.f3328u;
        x4 x4Var9 = new x4("STRING", 8, 8, 1, h5Var6);
        h5 h5Var7 = h5.f3331x;
        x4 x4Var10 = new x4("MESSAGE", 9, 9, 1, h5Var7);
        h5 h5Var8 = h5.f3329v;
        x4 x4Var11 = new x4("BYTES", 10, 10, 1, h5Var8);
        x4 x4Var12 = new x4("UINT32", 11, 11, 1, h5Var4);
        h5 h5Var9 = h5.f3330w;
        x4 x4Var13 = new x4("ENUM", 12, 12, 1, h5Var9);
        x4 x4Var14 = new x4("SFIXED32", 13, 13, 1, h5Var4);
        x4 x4Var15 = new x4("SFIXED64", 14, 14, 1, h5Var3);
        x4 x4Var16 = new x4("SINT32", 15, 15, 1, h5Var4);
        x4 x4Var17 = new x4("SINT64", 16, 16, 1, h5Var3);
        x4 x4Var18 = new x4("GROUP", 17, 17, 1, h5Var7);
        x4 x4Var19 = new x4("DOUBLE_LIST", 18, 18, 2, h5Var);
        x4 x4Var20 = new x4("FLOAT_LIST", 19, 19, 2, h5Var2);
        x4 x4Var21 = new x4("INT64_LIST", 20, 20, 2, h5Var3);
        x4 x4Var22 = new x4("UINT64_LIST", 21, 21, 2, h5Var3);
        x4 x4Var23 = new x4("INT32_LIST", 22, 22, 2, h5Var4);
        x4 x4Var24 = new x4("FIXED64_LIST", 23, 23, 2, h5Var3);
        x4 x4Var25 = new x4("FIXED32_LIST", 24, 24, 2, h5Var4);
        x4 x4Var26 = new x4("BOOL_LIST", 25, 25, 2, h5Var5);
        x4 x4Var27 = new x4("STRING_LIST", 26, 26, 2, h5Var6);
        x4 x4Var28 = new x4("MESSAGE_LIST", 27, 27, 2, h5Var7);
        x4 x4Var29 = new x4("BYTES_LIST", 28, 28, 2, h5Var8);
        x4 x4Var30 = new x4("UINT32_LIST", 29, 29, 2, h5Var4);
        x4 x4Var31 = new x4("ENUM_LIST", 30, 30, 2, h5Var9);
        x4 x4Var32 = new x4("SFIXED32_LIST", 31, 31, 2, h5Var4);
        x4 x4Var33 = new x4("SFIXED64_LIST", 32, 32, 2, h5Var3);
        x4 x4Var34 = new x4("SINT32_LIST", 33, 33, 2, h5Var4);
        x4 x4Var35 = new x4("SINT64_LIST", 34, 34, 2, h5Var3);
        x4 x4Var36 = new x4("DOUBLE_LIST_PACKED", 35, 35, 3, h5Var);
        f3580p = x4Var36;
        x4 x4Var37 = new x4("FLOAT_LIST_PACKED", 36, 36, 3, h5Var2);
        x4 x4Var38 = new x4("INT64_LIST_PACKED", 37, 37, 3, h5Var3);
        x4 x4Var39 = new x4("UINT64_LIST_PACKED", 38, 38, 3, h5Var3);
        x4 x4Var40 = new x4("INT32_LIST_PACKED", 39, 39, 3, h5Var4);
        x4 x4Var41 = new x4("FIXED64_LIST_PACKED", 40, 40, 3, h5Var3);
        x4 x4Var42 = new x4("FIXED32_LIST_PACKED", 41, 41, 3, h5Var4);
        x4 x4Var43 = new x4("BOOL_LIST_PACKED", 42, 42, 3, h5Var5);
        x4 x4Var44 = new x4("UINT32_LIST_PACKED", 43, 43, 3, h5Var4);
        x4 x4Var45 = new x4("ENUM_LIST_PACKED", 44, 44, 3, h5Var9);
        x4 x4Var46 = new x4("SFIXED32_LIST_PACKED", 45, 45, 3, h5Var4);
        x4 x4Var47 = new x4("SFIXED64_LIST_PACKED", 46, 46, 3, h5Var3);
        x4 x4Var48 = new x4("SINT32_LIST_PACKED", 47, 47, 3, h5Var4);
        x4 x4Var49 = new x4("SINT64_LIST_PACKED", 48, 48, 3, h5Var3);
        f3581q = x4Var49;
        f3583s = new x4[]{x4Var, x4Var2, x4Var3, x4Var4, x4Var5, x4Var6, x4Var7, x4Var8, x4Var9, x4Var10, x4Var11, x4Var12, x4Var13, x4Var14, x4Var15, x4Var16, x4Var17, x4Var18, x4Var19, x4Var20, x4Var21, x4Var22, x4Var23, x4Var24, x4Var25, x4Var26, x4Var27, x4Var28, x4Var29, x4Var30, x4Var31, x4Var32, x4Var33, x4Var34, x4Var35, x4Var36, x4Var37, x4Var38, x4Var39, x4Var40, x4Var41, x4Var42, x4Var43, x4Var44, x4Var45, x4Var46, x4Var47, x4Var48, x4Var49, new x4("GROUP_LIST", 49, 49, 2, h5Var7), new x4("MAP", 50, 50, 4, h5.f3322o)};
        x4[] values = values();
        f3582r = new x4[values.length];
        for (x4 x4Var50 : values) {
            f3582r[x4Var50.f3584o] = x4Var50;
        }
    }

    public x4(String str, int i10, int i11, int i12, h5 h5Var) {
        this.f3584o = i11;
        int i13 = i12 - 1;
        if (i13 == 1) {
            h5Var.getClass();
        } else if (i13 == 3) {
            h5Var.getClass();
        }
        if (i12 == 1) {
            h5 h5Var2 = h5.f3322o;
            h5Var.ordinal();
        }
    }

    public static x4[] values() {
        return (x4[]) f3583s.clone();
    }
}
