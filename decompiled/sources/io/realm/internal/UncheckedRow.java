package io.realm.internal;

import io.realm.RealmFieldType;
import io.realm.internal.core.NativeRealmAny;
import java.util.Date;
import java.util.UUID;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class UncheckedRow implements h, a0 {

    /* renamed from: r, reason: collision with root package name */
    public static final long f6725r = nativeGetFinalizerPtr();

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f6726s = 0;

    /* renamed from: o, reason: collision with root package name */
    public final g f6727o;

    /* renamed from: p, reason: collision with root package name */
    public final Table f6728p;

    /* renamed from: q, reason: collision with root package name */
    public final long f6729q;

    public UncheckedRow(g gVar, Table table, long j10) {
        this.f6727o = gVar;
        this.f6728p = table;
        this.f6729q = j10;
        gVar.a(this);
    }

    private static native long nativeGetFinalizerPtr();

    public OsMap A(long j10, RealmFieldType realmFieldType) {
        return new OsMap(this, j10);
    }

    public boolean B(long j10) {
        return nativeIsNull(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final RealmFieldType C(long j10) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.f6729q, j10));
    }

    public a0 D(OsSharedRealm osSharedRealm) {
        if (!isValid()) {
            return f.f6741o;
        }
        return new UncheckedRow(this.f6727o, this.f6728p.c(osSharedRealm), nativeFreeze(this.f6729q, osSharedRealm.getNativePtr()));
    }

    @Override // io.realm.internal.a0
    public final void E(long j10) {
        this.f6728p.a();
        nativeNullifyLink(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final long F() {
        return nativeGetObjectKey(this.f6729q);
    }

    @Override // io.realm.internal.a0
    public final Decimal128 a(long j10) {
        long[] nativeGetDecimal128 = nativeGetDecimal128(this.f6729q, j10);
        if (nativeGetDecimal128 != null) {
            return Decimal128.fromIEEE754BIDEncoding(nativeGetDecimal128[1], nativeGetDecimal128[0]);
        }
        return null;
    }

    @Override // io.realm.internal.a0
    public final long b(String str) {
        if (str != null) {
            return nativeGetColumnKey(this.f6729q, str);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    public OsMap c(long j10) {
        return new OsMap(this, j10);
    }

    @Override // io.realm.internal.a0
    public final void d(long j10, String str) {
        this.f6728p.a();
        nativeSetString(this.f6729q, j10, str);
    }

    public OsSet e(long j10, RealmFieldType realmFieldType) {
        return new OsSet(this, j10);
    }

    @Override // io.realm.internal.a0
    public final void f(long j10, float f10) {
        this.f6728p.a();
        nativeSetFloat(this.f6729q, j10, f10);
    }

    @Override // io.realm.internal.a0
    public final NativeRealmAny g(long j10) {
        return new NativeRealmAny(nativeGetRealmAny(this.f6729q, j10));
    }

    @Override // io.realm.internal.a0
    public final String[] getColumnNames() {
        return nativeGetColumnNames(this.f6729q);
    }

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6725r;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6729q;
    }

    @Override // io.realm.internal.a0
    public final Table h() {
        return this.f6728p;
    }

    public boolean i(long j10) {
        return nativeIsNullLink(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final boolean isValid() {
        long j10 = this.f6729q;
        return j10 != 0 && nativeIsValid(j10);
    }

    public void j(long j10) {
        this.f6728p.a();
        nativeSetNull(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final byte[] k(long j10) {
        return nativeGetByteArray(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final void l(long j10, boolean z10) {
        this.f6728p.a();
        nativeSetBoolean(this.f6729q, j10, z10);
    }

    public OsSet m(long j10) {
        return new OsSet(this, j10);
    }

    @Override // io.realm.internal.a0
    public final ObjectId n(long j10) {
        return new ObjectId(nativeGetObjectId(this.f6729q, j10));
    }

    public native long nativeFreeze(long j10, long j11);

    public native boolean nativeGetBoolean(long j10, long j11);

    public native byte[] nativeGetByteArray(long j10, long j11);

    public native long nativeGetColumnKey(long j10, String str);

    public native String[] nativeGetColumnNames(long j10);

    public native int nativeGetColumnType(long j10, long j11);

    public native long[] nativeGetDecimal128(long j10, long j11);

    public native double nativeGetDouble(long j10, long j11);

    public native float nativeGetFloat(long j10, long j11);

    public native long nativeGetLink(long j10, long j11);

    public native long nativeGetLong(long j10, long j11);

    public native String nativeGetObjectId(long j10, long j11);

    public native long nativeGetObjectKey(long j10);

    public native long nativeGetRealmAny(long j10, long j11);

    public native String nativeGetString(long j10, long j11);

    public native long nativeGetTimestamp(long j10, long j11);

    public native String nativeGetUUID(long j10, long j11);

    public native boolean nativeIsNull(long j10, long j11);

    public native boolean nativeIsNullLink(long j10, long j11);

    public native boolean nativeIsValid(long j10);

    public native void nativeNullifyLink(long j10, long j11);

    public native void nativeSetBoolean(long j10, long j11, boolean z10);

    public native void nativeSetFloat(long j10, long j11, float f10);

    public native void nativeSetLink(long j10, long j11, long j12);

    public native void nativeSetLong(long j10, long j11, long j12);

    public native void nativeSetNull(long j10, long j11);

    public native void nativeSetString(long j10, long j11, String str);

    @Override // io.realm.internal.a0
    public final UUID o(long j10) {
        return UUID.fromString(nativeGetUUID(this.f6729q, j10));
    }

    @Override // io.realm.internal.a0
    public final double p(long j10) {
        return nativeGetDouble(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final boolean q(long j10) {
        return nativeGetBoolean(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final long r(long j10) {
        return nativeGetLink(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final float s(long j10) {
        return nativeGetFloat(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final long t(long j10) {
        return nativeGetLong(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final String u(long j10) {
        return nativeGetString(this.f6729q, j10);
    }

    @Override // io.realm.internal.a0
    public final void v(long j10, long j11) {
        this.f6728p.a();
        nativeSetLink(this.f6729q, j10, j11);
    }

    public OsList w(long j10) {
        return new OsList(this, j10);
    }

    @Override // io.realm.internal.a0
    public final void x(long j10, long j11) {
        this.f6728p.a();
        nativeSetLong(this.f6729q, j10, j11);
    }

    @Override // io.realm.internal.a0
    public final Date y(long j10) {
        return new Date(nativeGetTimestamp(this.f6729q, j10));
    }

    public OsList z(long j10, RealmFieldType realmFieldType) {
        return new OsList(this, j10);
    }
}
