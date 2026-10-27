package io.realm;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6674a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f6675b;

    static {
        int[] iArr = new int[s.e.c(3).length];
        f6675b = iArr;
        try {
            iArr[2] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6675b[1] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6675b[0] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[RealmFieldType.values().length];
        f6674a = iArr2;
        try {
            iArr2[RealmFieldType.BOOLEAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f6674a[RealmFieldType.INTEGER.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f6674a[RealmFieldType.FLOAT.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f6674a[RealmFieldType.DOUBLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f6674a[RealmFieldType.STRING.ordinal()] = 5;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f6674a[RealmFieldType.BINARY.ordinal()] = 6;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f6674a[RealmFieldType.DATE.ordinal()] = 7;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f6674a[RealmFieldType.DECIMAL128.ordinal()] = 8;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f6674a[RealmFieldType.OBJECT_ID.ordinal()] = 9;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f6674a[RealmFieldType.MIXED.ordinal()] = 10;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f6674a[RealmFieldType.UUID.ordinal()] = 11;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f6674a[RealmFieldType.OBJECT.ordinal()] = 12;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f6674a[RealmFieldType.LIST.ordinal()] = 13;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_INTEGER_MAP.ordinal()] = 14;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_BOOLEAN_MAP.ordinal()] = 15;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_STRING_MAP.ordinal()] = 16;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_BINARY_MAP.ordinal()] = 17;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_DATE_MAP.ordinal()] = 18;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_FLOAT_MAP.ordinal()] = 19;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_DOUBLE_MAP.ordinal()] = 20;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_DECIMAL128_MAP.ordinal()] = 21;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_OBJECT_ID_MAP.ordinal()] = 22;
        } catch (NoSuchFieldError unused25) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_UUID_MAP.ordinal()] = 23;
        } catch (NoSuchFieldError unused26) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_MIXED_MAP.ordinal()] = 24;
        } catch (NoSuchFieldError unused27) {
        }
        try {
            f6674a[RealmFieldType.STRING_TO_LINK_MAP.ordinal()] = 25;
        } catch (NoSuchFieldError unused28) {
        }
        try {
            f6674a[RealmFieldType.INTEGER_SET.ordinal()] = 26;
        } catch (NoSuchFieldError unused29) {
        }
        try {
            f6674a[RealmFieldType.BOOLEAN_SET.ordinal()] = 27;
        } catch (NoSuchFieldError unused30) {
        }
        try {
            f6674a[RealmFieldType.STRING_SET.ordinal()] = 28;
        } catch (NoSuchFieldError unused31) {
        }
        try {
            f6674a[RealmFieldType.BINARY_SET.ordinal()] = 29;
        } catch (NoSuchFieldError unused32) {
        }
        try {
            f6674a[RealmFieldType.DATE_SET.ordinal()] = 30;
        } catch (NoSuchFieldError unused33) {
        }
        try {
            f6674a[RealmFieldType.FLOAT_SET.ordinal()] = 31;
        } catch (NoSuchFieldError unused34) {
        }
        try {
            f6674a[RealmFieldType.DOUBLE_SET.ordinal()] = 32;
        } catch (NoSuchFieldError unused35) {
        }
        try {
            f6674a[RealmFieldType.DECIMAL128_SET.ordinal()] = 33;
        } catch (NoSuchFieldError unused36) {
        }
        try {
            f6674a[RealmFieldType.OBJECT_ID_SET.ordinal()] = 34;
        } catch (NoSuchFieldError unused37) {
        }
        try {
            f6674a[RealmFieldType.UUID_SET.ordinal()] = 35;
        } catch (NoSuchFieldError unused38) {
        }
        try {
            f6674a[RealmFieldType.LINK_SET.ordinal()] = 36;
        } catch (NoSuchFieldError unused39) {
        }
        try {
            f6674a[RealmFieldType.MIXED_SET.ordinal()] = 37;
        } catch (NoSuchFieldError unused40) {
        }
        try {
            f6674a[RealmFieldType.LINKING_OBJECTS.ordinal()] = 38;
        } catch (NoSuchFieldError unused41) {
        }
        try {
            f6674a[RealmFieldType.INTEGER_LIST.ordinal()] = 39;
        } catch (NoSuchFieldError unused42) {
        }
        try {
            f6674a[RealmFieldType.BOOLEAN_LIST.ordinal()] = 40;
        } catch (NoSuchFieldError unused43) {
        }
        try {
            f6674a[RealmFieldType.STRING_LIST.ordinal()] = 41;
        } catch (NoSuchFieldError unused44) {
        }
        try {
            f6674a[RealmFieldType.BINARY_LIST.ordinal()] = 42;
        } catch (NoSuchFieldError unused45) {
        }
        try {
            f6674a[RealmFieldType.DATE_LIST.ordinal()] = 43;
        } catch (NoSuchFieldError unused46) {
        }
        try {
            f6674a[RealmFieldType.FLOAT_LIST.ordinal()] = 44;
        } catch (NoSuchFieldError unused47) {
        }
        try {
            f6674a[RealmFieldType.DOUBLE_LIST.ordinal()] = 45;
        } catch (NoSuchFieldError unused48) {
        }
        try {
            f6674a[RealmFieldType.DECIMAL128_LIST.ordinal()] = 46;
        } catch (NoSuchFieldError unused49) {
        }
        try {
            f6674a[RealmFieldType.OBJECT_ID_LIST.ordinal()] = 47;
        } catch (NoSuchFieldError unused50) {
        }
        try {
            f6674a[RealmFieldType.UUID_LIST.ordinal()] = 48;
        } catch (NoSuchFieldError unused51) {
        }
        try {
            f6674a[RealmFieldType.MIXED_LIST.ordinal()] = 49;
        } catch (NoSuchFieldError unused52) {
        }
    }
}
