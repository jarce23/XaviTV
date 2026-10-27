package io.realm.internal;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class OsObjectStore {
    public static String a(OsSharedRealm osSharedRealm, String str) {
        return nativeGetPrimaryKeyForObject(osSharedRealm.getNativePtr(), Util.nativeGetTablePrefix() + str);
    }

    public static long b(OsSharedRealm osSharedRealm) {
        return nativeGetSchemaVersion(osSharedRealm.getNativePtr());
    }

    public static void c(OsSharedRealm osSharedRealm) {
        nativeSetSchemaVersion(osSharedRealm.getNativePtr(), -1L);
    }

    private static native String nativeGetPrimaryKeyForObject(long j10, String str);

    private static native long nativeGetSchemaVersion(long j10);

    private static native void nativeSetSchemaVersion(long j10, long j11);
}
