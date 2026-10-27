package io.realm.internal;

import io.realm.RealmFieldType;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Table implements h {

    /* renamed from: r, reason: collision with root package name */
    public static final String f6715r;

    /* renamed from: s, reason: collision with root package name */
    public static final long f6716s;

    /* renamed from: o, reason: collision with root package name */
    public final long f6717o;

    /* renamed from: p, reason: collision with root package name */
    public final g f6718p;

    /* renamed from: q, reason: collision with root package name */
    public final OsSharedRealm f6719q;

    static {
        String nativeGetTablePrefix = Util.nativeGetTablePrefix();
        f6715r = nativeGetTablePrefix;
        nativeGetTablePrefix.length();
        f6716s = nativeGetFinalizerPtr();
    }

    public Table(OsSharedRealm osSharedRealm, long j10) {
        g gVar = osSharedRealm.context;
        this.f6718p = gVar;
        this.f6719q = osSharedRealm;
        this.f6717o = j10;
        gVar.a(this);
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        String str2 = f6715r;
        return !str.startsWith(str2) ? str : str.substring(str2.length());
    }

    public static String k(String str) {
        if (str == null) {
            return null;
        }
        return android.support.v4.media.d.r(new StringBuilder(), f6715r, str);
    }

    private native void nativeClear(long j10);

    private static native long nativeFreeze(long j10, long j11);

    private native long nativeGetColumnCount(long j10);

    private native long nativeGetColumnKey(long j10, String str);

    private native String nativeGetColumnName(long j10, long j11);

    private native String[] nativeGetColumnNames(long j10);

    private native int nativeGetColumnType(long j10, long j11);

    private static native long nativeGetFinalizerPtr();

    private native long nativeGetLinkTarget(long j10, long j11);

    private native String nativeGetName(long j10);

    private native void nativeMoveLastOver(long j10, long j11);

    public static native void nativeNullifyLink(long j10, long j11, long j12);

    public static native void nativeSetBoolean(long j10, long j11, long j12, boolean z10, boolean z11);

    public static native void nativeSetFloat(long j10, long j11, long j12, float f10, boolean z10);

    public static native void nativeSetLink(long j10, long j11, long j12, long j13, boolean z10);

    public static native void nativeSetLong(long j10, long j11, long j12, long j13, boolean z10);

    public static native void nativeSetNull(long j10, long j11, long j12, boolean z10);

    public static native void nativeSetString(long j10, long j11, long j12, String str, boolean z10);

    private native long nativeSize(long j10);

    private native long nativeWhere(long j10);

    public final void a() {
        OsSharedRealm osSharedRealm = this.f6719q;
        if (osSharedRealm != null && !osSharedRealm.isInTransaction()) {
            throw new IllegalStateException("Cannot modify managed objects outside of a write transaction.");
        }
    }

    public final void b() {
        a();
        nativeClear(this.f6717o);
    }

    public final Table c(OsSharedRealm osSharedRealm) {
        if (osSharedRealm.isFrozen()) {
            return new Table(osSharedRealm, nativeFreeze(osSharedRealm.getNativePtr(), this.f6717o));
        }
        throw new IllegalArgumentException("Frozen Realm required");
    }

    public final String d() {
        String e7 = e(nativeGetName(this.f6717o));
        if (e7 == null || e7.length() == 0) {
            throw new IllegalStateException("This object class is no longer part of the schema for the Realm file. It is therefor not possible to access the schema name.");
        }
        return e7;
    }

    public final long f(String str) {
        return nativeGetColumnKey(this.f6717o, str);
    }

    public final String g(long j10) {
        return nativeGetColumnName(this.f6717o, j10);
    }

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6716s;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6717o;
    }

    public final RealmFieldType h(long j10) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.f6717o, j10));
    }

    public final Table i(long j10) {
        return new Table(this.f6719q, nativeGetLinkTarget(this.f6717o, j10));
    }

    public final String j() {
        return nativeGetName(this.f6717o);
    }

    public final void l(long j10) {
        a();
        nativeMoveLastOver(this.f6717o, j10);
    }

    public final TableQuery m() {
        return new TableQuery(this.f6718p, this, nativeWhere(this.f6717o));
    }

    public native long nativeGetRowPtr(long j10, long j11);

    public final String toString() {
        long j10 = this.f6717o;
        long nativeGetColumnCount = nativeGetColumnCount(j10);
        String nativeGetName = nativeGetName(j10);
        StringBuilder sb2 = new StringBuilder("The Table ");
        if (nativeGetName != null && !nativeGetName.isEmpty()) {
            sb2.append(nativeGetName(j10));
            sb2.append(" ");
        }
        sb2.append("contains ");
        sb2.append(nativeGetColumnCount);
        sb2.append(" columns: ");
        String[] nativeGetColumnNames = nativeGetColumnNames(j10);
        int length = nativeGetColumnNames.length;
        boolean z10 = true;
        int i10 = 0;
        while (i10 < length) {
            String str = nativeGetColumnNames[i10];
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(str);
            i10++;
            z10 = false;
        }
        sb2.append(". And ");
        sb2.append(nativeSize(j10));
        sb2.append(" rows.");
        return sb2.toString();
    }
}
