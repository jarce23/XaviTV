package io.realm.internal;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class OsMap implements h {

    /* renamed from: p, reason: collision with root package name */
    public static final long f6690p = nativeGetFinalizerPtr();

    /* renamed from: o, reason: collision with root package name */
    public final long f6691o;

    public OsMap(UncheckedRow uncheckedRow, long j10) {
        OsSharedRealm osSharedRealm = uncheckedRow.f6728p.f6719q;
        long[] nativeCreate = nativeCreate(osSharedRealm.getNativePtr(), uncheckedRow.f6729q, j10);
        this.f6691o = nativeCreate[0];
        if (nativeCreate[1] != -1) {
            new Table(osSharedRealm, nativeCreate[1]);
        }
        osSharedRealm.context.a(this);
    }

    private static native long[] nativeCreate(long j10, long j11, long j12);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeSize(long j10);

    public final long a() {
        return nativeSize(this.f6691o);
    }

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6690p;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6691o;
    }
}
