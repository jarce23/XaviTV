package io.realm;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public enum v {
    /* JADX INFO: Fake field, exist only in values array */
    INTEGER(RealmFieldType.INTEGER),
    /* JADX INFO: Fake field, exist only in values array */
    BOOLEAN(RealmFieldType.BOOLEAN),
    /* JADX INFO: Fake field, exist only in values array */
    STRING(RealmFieldType.STRING),
    /* JADX INFO: Fake field, exist only in values array */
    BINARY(RealmFieldType.BINARY),
    /* JADX INFO: Fake field, exist only in values array */
    DATE(RealmFieldType.DATE),
    /* JADX INFO: Fake field, exist only in values array */
    FLOAT(RealmFieldType.FLOAT),
    /* JADX INFO: Fake field, exist only in values array */
    DOUBLE(RealmFieldType.DOUBLE),
    /* JADX INFO: Fake field, exist only in values array */
    DECIMAL128(RealmFieldType.DECIMAL128),
    /* JADX INFO: Fake field, exist only in values array */
    OBJECT_ID(RealmFieldType.OBJECT_ID),
    OBJECT(RealmFieldType.TYPED_LINK),
    /* JADX INFO: Fake field, exist only in values array */
    UUID(RealmFieldType.UUID),
    NULL(null);


    /* renamed from: r, reason: collision with root package name */
    public static final v[] f6846r = new v[19];

    /* renamed from: o, reason: collision with root package name */
    public final RealmFieldType f6848o;

    static {
        for (v vVar : values()) {
            if (vVar != NULL) {
                f6846r[vVar.f6848o.getNativeValue()] = vVar;
            }
        }
        f6846r[RealmFieldType.OBJECT.getNativeValue()] = OBJECT;
    }

    v(RealmFieldType realmFieldType) {
        this.f6848o = realmFieldType;
    }
}
