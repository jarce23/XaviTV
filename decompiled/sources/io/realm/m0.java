package io.realm;

import io.realm.internal.Table;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final d f6781a;

    /* renamed from: b, reason: collision with root package name */
    public final Table f6782b;

    static {
        HashMap hashMap = new HashMap();
        RealmFieldType realmFieldType = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType2 = RealmFieldType.INTEGER;
        int i10 = 26;
        hashMap.put(String.class, new d9.f(i10));
        RealmFieldType realmFieldType3 = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType4 = RealmFieldType.INTEGER;
        d9.f fVar = new d9.f(i10);
        Class cls = Short.TYPE;
        hashMap.put(cls, fVar);
        hashMap.put(Short.class, new d9.f(i10));
        d9.f fVar2 = new d9.f(i10);
        Class cls2 = Integer.TYPE;
        hashMap.put(cls2, fVar2);
        hashMap.put(Integer.class, new d9.f(i10));
        d9.f fVar3 = new d9.f(i10);
        Class cls3 = Long.TYPE;
        hashMap.put(cls3, fVar3);
        hashMap.put(Long.class, new d9.f(i10));
        RealmFieldType realmFieldType5 = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType6 = RealmFieldType.INTEGER;
        d9.f fVar4 = new d9.f(i10);
        Class cls4 = Float.TYPE;
        hashMap.put(cls4, fVar4);
        hashMap.put(Float.class, new d9.f(i10));
        RealmFieldType realmFieldType7 = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType8 = RealmFieldType.INTEGER;
        d9.f fVar5 = new d9.f(i10);
        Class cls5 = Double.TYPE;
        hashMap.put(cls5, fVar5);
        hashMap.put(Double.class, new d9.f(i10));
        RealmFieldType realmFieldType9 = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType10 = RealmFieldType.INTEGER;
        d9.f fVar6 = new d9.f(i10);
        Class cls6 = Boolean.TYPE;
        hashMap.put(cls6, fVar6);
        hashMap.put(Boolean.class, new d9.f(i10));
        d9.f fVar7 = new d9.f(i10);
        Class cls7 = Byte.TYPE;
        hashMap.put(cls7, fVar7);
        hashMap.put(Byte.class, new d9.f(26));
        RealmFieldType realmFieldType11 = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType12 = RealmFieldType.INTEGER;
        hashMap.put(byte[].class, new d9.f(26));
        RealmFieldType realmFieldType13 = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType14 = RealmFieldType.INTEGER;
        hashMap.put(Date.class, new d9.f(26));
        RealmFieldType realmFieldType15 = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType16 = RealmFieldType.INTEGER;
        hashMap.put(ObjectId.class, new d9.f(26));
        RealmFieldType realmFieldType17 = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType18 = RealmFieldType.INTEGER;
        hashMap.put(Decimal128.class, new d9.f(26));
        RealmFieldType realmFieldType19 = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType20 = RealmFieldType.INTEGER;
        hashMap.put(UUID.class, new d9.f(26));
        RealmFieldType realmFieldType21 = RealmFieldType.INTEGER;
        RealmFieldType realmFieldType22 = RealmFieldType.INTEGER;
        hashMap.put(w.class, new d9.f(26));
        Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        RealmFieldType realmFieldType23 = RealmFieldType.INTEGER;
        int i11 = 26;
        hashMap2.put(String.class, new d9.f(i11));
        RealmFieldType realmFieldType24 = RealmFieldType.INTEGER;
        hashMap2.put(cls, new d9.f(i11));
        hashMap2.put(Short.class, new d9.f(i11));
        hashMap2.put(cls2, new d9.f(i11));
        hashMap2.put(Integer.class, new d9.f(i11));
        hashMap2.put(cls3, new d9.f(i11));
        hashMap2.put(Long.class, new d9.f(i11));
        RealmFieldType realmFieldType25 = RealmFieldType.INTEGER;
        hashMap2.put(cls4, new d9.f(i11));
        hashMap2.put(Float.class, new d9.f(i11));
        RealmFieldType realmFieldType26 = RealmFieldType.INTEGER;
        hashMap2.put(cls5, new d9.f(i11));
        hashMap2.put(Double.class, new d9.f(i11));
        RealmFieldType realmFieldType27 = RealmFieldType.INTEGER;
        hashMap2.put(cls6, new d9.f(i11));
        hashMap2.put(Boolean.class, new d9.f(i11));
        hashMap2.put(cls7, new d9.f(i11));
        hashMap2.put(Byte.class, new d9.f(26));
        RealmFieldType realmFieldType28 = RealmFieldType.INTEGER;
        hashMap2.put(byte[].class, new d9.f(26));
        RealmFieldType realmFieldType29 = RealmFieldType.INTEGER;
        hashMap2.put(Date.class, new d9.f(26));
        RealmFieldType realmFieldType30 = RealmFieldType.INTEGER;
        hashMap2.put(ObjectId.class, new d9.f(26));
        RealmFieldType realmFieldType31 = RealmFieldType.INTEGER;
        hashMap2.put(Decimal128.class, new d9.f(26));
        RealmFieldType realmFieldType32 = RealmFieldType.INTEGER;
        hashMap2.put(UUID.class, new d9.f(26));
        RealmFieldType realmFieldType33 = RealmFieldType.INTEGER;
        hashMap2.put(w.class, new d9.f(26));
        Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        RealmFieldType realmFieldType34 = RealmFieldType.INTEGER;
        int i12 = 26;
        hashMap3.put(String.class, new d9.f(i12));
        RealmFieldType realmFieldType35 = RealmFieldType.INTEGER;
        hashMap3.put(cls, new d9.f(i12));
        hashMap3.put(Short.class, new d9.f(i12));
        hashMap3.put(cls2, new d9.f(i12));
        hashMap3.put(Integer.class, new d9.f(i12));
        hashMap3.put(cls3, new d9.f(i12));
        hashMap3.put(Long.class, new d9.f(i12));
        RealmFieldType realmFieldType36 = RealmFieldType.INTEGER;
        hashMap3.put(cls4, new d9.f(i12));
        hashMap3.put(Float.class, new d9.f(i12));
        RealmFieldType realmFieldType37 = RealmFieldType.INTEGER;
        hashMap3.put(cls5, new d9.f(i12));
        hashMap3.put(Double.class, new d9.f(i12));
        RealmFieldType realmFieldType38 = RealmFieldType.INTEGER;
        hashMap3.put(cls6, new d9.f(i12));
        hashMap3.put(Boolean.class, new d9.f(i12));
        hashMap3.put(cls7, new d9.f(i12));
        hashMap3.put(Byte.class, new d9.f(i12));
        RealmFieldType realmFieldType39 = RealmFieldType.INTEGER;
        hashMap3.put(byte[].class, new d9.f(i12));
        RealmFieldType realmFieldType40 = RealmFieldType.INTEGER;
        hashMap3.put(Date.class, new d9.f(i12));
        RealmFieldType realmFieldType41 = RealmFieldType.INTEGER;
        hashMap3.put(ObjectId.class, new d9.f(i12));
        RealmFieldType realmFieldType42 = RealmFieldType.INTEGER;
        hashMap3.put(Decimal128.class, new d9.f(i12));
        RealmFieldType realmFieldType43 = RealmFieldType.INTEGER;
        hashMap3.put(UUID.class, new d9.f(i12));
        RealmFieldType realmFieldType44 = RealmFieldType.INTEGER;
        hashMap3.put(w.class, new d9.f(i12));
        Collections.unmodifiableMap(hashMap3);
        HashMap hashMap4 = new HashMap();
        RealmFieldType realmFieldType45 = RealmFieldType.INTEGER;
        hashMap4.put(k0.class, new d9.f(i12));
        RealmFieldType realmFieldType46 = RealmFieldType.INTEGER;
        hashMap4.put(h0.class, new d9.f(i12));
        RealmFieldType realmFieldType47 = RealmFieldType.INTEGER;
        hashMap4.put(g0.class, new d9.f(i12));
        RealmFieldType realmFieldType48 = RealmFieldType.INTEGER;
        hashMap4.put(o0.class, new d9.f(i12));
        Collections.unmodifiableMap(hashMap4);
    }

    public m0(d dVar, Table table) {
        this.f6781a = dVar;
        this.f6782b = table;
    }
}
