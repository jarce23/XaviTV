package io.realm;

import io.realm.internal.Keep;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@Keep
/* loaded from: classes.dex */
public enum RealmFieldType {
    INTEGER(0),
    BOOLEAN(1),
    STRING(2),
    BINARY(4),
    DATE(8),
    FLOAT(9),
    DOUBLE(10),
    OBJECT(12),
    DECIMAL128(11),
    OBJECT_ID(15),
    UUID(17),
    MIXED(6),
    TYPED_LINK(16),
    LIST(13),
    LINKING_OBJECTS(14),
    INTEGER_LIST(128),
    BOOLEAN_LIST(129),
    STRING_LIST(130),
    BINARY_LIST(132),
    DATE_LIST(136),
    FLOAT_LIST(137),
    DOUBLE_LIST(138),
    DECIMAL128_LIST(139),
    OBJECT_ID_LIST(143),
    UUID_LIST(145),
    MIXED_LIST(134),
    STRING_TO_INTEGER_MAP(512),
    STRING_TO_BOOLEAN_MAP(513),
    STRING_TO_STRING_MAP(514),
    STRING_TO_BINARY_MAP(516),
    STRING_TO_DATE_MAP(520),
    STRING_TO_FLOAT_MAP(521),
    STRING_TO_DOUBLE_MAP(522),
    STRING_TO_DECIMAL128_MAP(523),
    STRING_TO_OBJECT_ID_MAP(527),
    STRING_TO_UUID_MAP(529),
    STRING_TO_MIXED_MAP(518),
    STRING_TO_LINK_MAP(524),
    INTEGER_SET(256),
    BOOLEAN_SET(257),
    STRING_SET(258),
    BINARY_SET(260),
    DATE_SET(264),
    FLOAT_SET(265),
    DOUBLE_SET(266),
    DECIMAL128_SET(267),
    OBJECT_ID_SET(271),
    UUID_SET(273),
    LINK_SET(268),
    MIXED_SET(262);

    private static final RealmFieldType[] basicTypes = new RealmFieldType[18];
    private static final RealmFieldType[] listTypes = new RealmFieldType[18];
    private static final RealmFieldType[] mapTypes = new RealmFieldType[18];
    private static final RealmFieldType[] setTypes = new RealmFieldType[18];
    private final int nativeValue;

    static {
        for (RealmFieldType realmFieldType : values()) {
            int i10 = realmFieldType.nativeValue;
            if (i10 < 128) {
                basicTypes[i10] = realmFieldType;
            } else if (i10 < 256) {
                listTypes[i10 - 128] = realmFieldType;
            } else {
                if (i10 < 512) {
                    setTypes[i10 - 256] = realmFieldType;
                } else {
                    mapTypes[i10 - 512] = realmFieldType;
                }
            }
        }
    }

    RealmFieldType(int i10) {
        this.nativeValue = i10;
    }

    public static RealmFieldType fromNativeValue(int i10) {
        RealmFieldType realmFieldType;
        RealmFieldType realmFieldType2;
        RealmFieldType realmFieldType3;
        RealmFieldType realmFieldType4;
        if (i10 >= 0) {
            RealmFieldType[] realmFieldTypeArr = basicTypes;
            if (i10 < realmFieldTypeArr.length && (realmFieldType4 = realmFieldTypeArr[i10]) != null) {
                return realmFieldType4;
            }
        }
        if (128 <= i10 && i10 < 256) {
            int i11 = i10 - 128;
            RealmFieldType[] realmFieldTypeArr2 = listTypes;
            if (i11 < realmFieldTypeArr2.length && (realmFieldType3 = realmFieldTypeArr2[i11]) != null) {
                return realmFieldType3;
            }
        }
        if (256 <= i10 && i10 < 512) {
            int i12 = i10 - 256;
            RealmFieldType[] realmFieldTypeArr3 = setTypes;
            if (i12 < realmFieldTypeArr3.length && (realmFieldType2 = realmFieldTypeArr3[i12]) != null) {
                return realmFieldType2;
            }
        }
        if (512 <= i10) {
            int i13 = i10 - 512;
            RealmFieldType[] realmFieldTypeArr4 = mapTypes;
            if (i13 < realmFieldTypeArr4.length && (realmFieldType = realmFieldTypeArr4[i13]) != null) {
                return realmFieldType;
            }
        }
        throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Invalid native Realm type: "));
    }

    public int getNativeValue() {
        return this.nativeValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004c A[FALL_THROUGH, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isValid(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.nativeValue
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L64
            if (r0 == r1) goto L61
            r3 = 2
            if (r0 == r3) goto L5e
            r3 = 4
            if (r0 == r3) goto L53
            r1 = 6
            if (r0 == r1) goto L50
            switch(r0) {
                case 6: goto L50;
                case 17: goto L4d;
                case 132: goto L4c;
                case 134: goto L4c;
                case 143: goto L4c;
                case 145: goto L4c;
                case 260: goto L4c;
                case 262: goto L4c;
                case 271: goto L4c;
                case 273: goto L4c;
                case 516: goto L4c;
                case 518: goto L4c;
                case 527: goto L4c;
                case 529: goto L4c;
                default: goto L14;
            }
        L14:
            switch(r0) {
                case 8: goto L49;
                case 9: goto L46;
                case 10: goto L43;
                case 11: goto L40;
                case 12: goto L4c;
                case 13: goto L4c;
                case 14: goto L4c;
                case 15: goto L3d;
                default: goto L17;
            }
        L17:
            switch(r0) {
                case 128: goto L4c;
                case 129: goto L4c;
                case 130: goto L4c;
                default: goto L1a;
            }
        L1a:
            switch(r0) {
                case 136: goto L4c;
                case 137: goto L4c;
                case 138: goto L4c;
                case 139: goto L4c;
                default: goto L1d;
            }
        L1d:
            switch(r0) {
                case 256: goto L4c;
                case 257: goto L4c;
                case 258: goto L4c;
                default: goto L20;
            }
        L20:
            switch(r0) {
                case 264: goto L4c;
                case 265: goto L4c;
                case 266: goto L4c;
                case 267: goto L4c;
                case 268: goto L4c;
                default: goto L23;
            }
        L23:
            switch(r0) {
                case 512: goto L4c;
                case 513: goto L4c;
                case 514: goto L4c;
                default: goto L26;
            }
        L26:
            switch(r0) {
                case 520: goto L4c;
                case 521: goto L4c;
                case 522: goto L4c;
                case 523: goto L4c;
                case 524: goto L4c;
                default: goto L29;
            }
        L29:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unsupported Realm type:  "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L3d:
            boolean r5 = r5 instanceof org.bson.types.ObjectId
            return r5
        L40:
            boolean r5 = r5 instanceof org.bson.types.Decimal128
            return r5
        L43:
            boolean r5 = r5 instanceof java.lang.Double
            return r5
        L46:
            boolean r5 = r5 instanceof java.lang.Float
            return r5
        L49:
            boolean r5 = r5 instanceof java.util.Date
            return r5
        L4c:
            return r2
        L4d:
            boolean r5 = r5 instanceof java.util.UUID
            return r5
        L50:
            boolean r5 = r5 instanceof io.realm.w
            return r5
        L53:
            boolean r0 = r5 instanceof byte[]
            if (r0 != 0) goto L5d
            boolean r5 = r5 instanceof java.nio.ByteBuffer
            if (r5 == 0) goto L5c
            goto L5d
        L5c:
            return r2
        L5d:
            return r1
        L5e:
            boolean r5 = r5 instanceof java.lang.String
            return r5
        L61:
            boolean r5 = r5 instanceof java.lang.Boolean
            return r5
        L64:
            boolean r0 = r5 instanceof java.lang.Long
            if (r0 != 0) goto L76
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L76
            boolean r0 = r5 instanceof java.lang.Short
            if (r0 != 0) goto L76
            boolean r5 = r5 instanceof java.lang.Byte
            if (r5 == 0) goto L75
            goto L76
        L75:
            return r2
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmFieldType.isValid(java.lang.Object):boolean");
    }
}
