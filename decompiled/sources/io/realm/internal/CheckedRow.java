package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CheckedRow extends UncheckedRow {

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f6677t = 0;

    @Override // io.realm.internal.UncheckedRow, io.realm.internal.a0
    public final OsMap A(long j10, RealmFieldType realmFieldType) {
        Table table = this.f6728p;
        if (realmFieldType == table.h(j10)) {
            return new OsMap(this, j10);
        }
        throw new IllegalArgumentException(String.format(Locale.US, "The type of field '%1$s' is not 'RealmFieldType.%2$s'.", table.g(j10), realmFieldType.name()));
    }

    @Override // io.realm.internal.UncheckedRow, io.realm.internal.a0
    public final boolean B(long j10) {
        return nativeIsNull(this.f6729q, j10);
    }

    @Override // io.realm.internal.UncheckedRow, io.realm.internal.a0
    public final a0 D(OsSharedRealm osSharedRealm) {
        if (!isValid()) {
            return f.f6741o;
        }
        return new CheckedRow(this.f6727o, this.f6728p.c(osSharedRealm), nativeFreeze(this.f6729q, osSharedRealm.getNativePtr()));
    }

    @Override // io.realm.internal.UncheckedRow, io.realm.internal.a0
    public final OsMap c(long j10) {
        Table table = this.f6728p;
        if (table.h(j10) == RealmFieldType.STRING_TO_LINK_MAP) {
            return new OsMap(this, j10);
        }
        Locale locale = Locale.US;
        throw new IllegalArgumentException(android.support.v4.media.d.q("Field '", table.g(j10), "' is not a 'RealmDictionary'."));
    }

    @Override // io.realm.internal.UncheckedRow, io.realm.internal.a0
    public final OsSet e(long j10, RealmFieldType realmFieldType) {
        Table table = this.f6728p;
        if (realmFieldType == table.h(j10)) {
            return new OsSet(this, j10);
        }
        throw new IllegalArgumentException(String.format(Locale.US, "The type of field '%1$s' is not 'RealmFieldType.%2$s'.", table.g(j10), realmFieldType.name()));
    }

    @Override // io.realm.internal.UncheckedRow, io.realm.internal.a0
    public final boolean i(long j10) {
        RealmFieldType C = C(j10);
        if (C == RealmFieldType.OBJECT || C == RealmFieldType.LIST) {
            return nativeIsNullLink(this.f6729q, j10);
        }
        return false;
    }

    @Override // io.realm.internal.UncheckedRow, io.realm.internal.a0
    public final void j(long j10) {
        if (C(j10) != RealmFieldType.BINARY) {
            super.j(j10);
        } else {
            this.f6728p.a();
            nativeSetByteArray(this.f6729q, j10, null);
        }
    }

    @Override // io.realm.internal.UncheckedRow, io.realm.internal.a0
    public final OsSet m(long j10) {
        return new OsSet(this, j10);
    }

    @Override // io.realm.internal.UncheckedRow
    public native boolean nativeGetBoolean(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native byte[] nativeGetByteArray(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native long nativeGetColumnKey(long j10, String str);

    @Override // io.realm.internal.UncheckedRow
    public native int nativeGetColumnType(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native long[] nativeGetDecimal128(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native double nativeGetDouble(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native float nativeGetFloat(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native long nativeGetLink(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native long nativeGetLong(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native String nativeGetObjectId(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native String nativeGetString(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native long nativeGetTimestamp(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native boolean nativeIsNullLink(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeNullifyLink(long j10, long j11);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetBoolean(long j10, long j11, boolean z10);

    public native void nativeSetByteArray(long j10, long j11, byte[] bArr);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetFloat(long j10, long j11, float f10);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetLink(long j10, long j11, long j12);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetLong(long j10, long j11, long j12);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetString(long j10, long j11, String str);

    @Override // io.realm.internal.UncheckedRow, io.realm.internal.a0
    public final OsList w(long j10) {
        Table table = this.f6728p;
        if (table.h(j10) == RealmFieldType.LIST) {
            return new OsList(this, j10);
        }
        Locale locale = Locale.US;
        throw new IllegalArgumentException(android.support.v4.media.d.q("Field '", table.g(j10), "' is not a 'RealmList'."));
    }

    @Override // io.realm.internal.UncheckedRow, io.realm.internal.a0
    public final OsList z(long j10, RealmFieldType realmFieldType) {
        Table table = this.f6728p;
        if (realmFieldType == table.h(j10)) {
            return new OsList(this, j10);
        }
        throw new IllegalArgumentException(String.format(Locale.US, "The type of field '%1$s' is not 'RealmFieldType.%2$s'.", table.g(j10), realmFieldType.name()));
    }
}
