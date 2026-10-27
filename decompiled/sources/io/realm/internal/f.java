package io.realm.internal;

import io.realm.RealmFieldType;
import io.realm.internal.core.NativeRealmAny;
import java.util.Date;
import java.util.UUID;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements a0 {

    /* renamed from: o, reason: collision with root package name */
    public static final f f6741o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ f[] f6742p;

    static {
        f fVar = new f("INSTANCE", 0);
        f6741o = fVar;
        f6742p = new f[]{fVar};
    }

    public static IllegalStateException G() {
        return new IllegalStateException("Object is no longer managed by Realm. Has it been deleted?");
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f6742p.clone();
    }

    @Override // io.realm.internal.a0
    public final OsMap A(long j10, RealmFieldType realmFieldType) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final boolean B(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final RealmFieldType C(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final a0 D(OsSharedRealm osSharedRealm) {
        return f6741o;
    }

    @Override // io.realm.internal.a0
    public final void E(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final long F() {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final Decimal128 a(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final long b(String str) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final OsMap c(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final void d(long j10, String str) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final OsSet e(long j10, RealmFieldType realmFieldType) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final void f(long j10, float f10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final NativeRealmAny g(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final String[] getColumnNames() {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final Table h() {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final boolean i(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final boolean isValid() {
        return false;
    }

    @Override // io.realm.internal.a0
    public final void j(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final byte[] k(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final void l(long j10, boolean z10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final OsSet m(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final ObjectId n(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final UUID o(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final double p(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final boolean q(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final long r(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final float s(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final long t(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final String u(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final void v(long j10, long j11) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final OsList w(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final void x(long j10, long j11) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final Date y(long j10) {
        throw G();
    }

    @Override // io.realm.internal.a0
    public final OsList z(long j10, RealmFieldType realmFieldType) {
        throw G();
    }
}
