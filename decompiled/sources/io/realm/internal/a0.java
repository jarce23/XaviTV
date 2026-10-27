package io.realm.internal;

import io.realm.RealmFieldType;
import io.realm.internal.core.NativeRealmAny;
import java.util.Date;
import java.util.UUID;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public interface a0 {
    OsMap A(long j10, RealmFieldType realmFieldType);

    boolean B(long j10);

    RealmFieldType C(long j10);

    a0 D(OsSharedRealm osSharedRealm);

    void E(long j10);

    long F();

    Decimal128 a(long j10);

    long b(String str);

    OsMap c(long j10);

    void d(long j10, String str);

    OsSet e(long j10, RealmFieldType realmFieldType);

    void f(long j10, float f10);

    NativeRealmAny g(long j10);

    String[] getColumnNames();

    Table h();

    boolean i(long j10);

    boolean isValid();

    void j(long j10);

    byte[] k(long j10);

    void l(long j10, boolean z10);

    OsSet m(long j10);

    ObjectId n(long j10);

    UUID o(long j10);

    double p(long j10);

    boolean q(long j10);

    long r(long j10);

    float s(long j10);

    long t(long j10);

    String u(long j10);

    void v(long j10, long j11);

    OsList w(long j10);

    void x(long j10, long j11);

    Date y(long j10);

    OsList z(long j10, RealmFieldType realmFieldType);
}
