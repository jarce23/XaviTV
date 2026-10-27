package io.realm.internal;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class OsList implements h, ObservableCollection {

    /* renamed from: q, reason: collision with root package name */
    public static final long f6687q = nativeGetFinalizerPtr();

    /* renamed from: o, reason: collision with root package name */
    public final long f6688o;

    /* renamed from: p, reason: collision with root package name */
    public final n f6689p = new n();

    public OsList(UncheckedRow uncheckedRow, long j10) {
        OsSharedRealm osSharedRealm = uncheckedRow.f6728p.f6719q;
        long[] nativeCreate = nativeCreate(osSharedRealm.getNativePtr(), uncheckedRow.f6729q, j10);
        this.f6688o = nativeCreate[0];
        osSharedRealm.context.a(this);
        if (nativeCreate[1] != 0) {
            new Table(osSharedRealm, nativeCreate[1]);
        }
    }

    private static native long[] nativeCreate(long j10, long j11, long j12);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeSize(long j10);

    public final long a() {
        return nativeSize(this.f6688o);
    }

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6687q;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6688o;
    }

    @Override // io.realm.internal.ObservableCollection
    public final void notifyChangeListeners(long j10) {
        OsCollectionChangeSet osCollectionChangeSet = new OsCollectionChangeSet(j10, false);
        if (osCollectionChangeSet.d()) {
            return;
        }
        this.f6689p.b(new i(1, osCollectionChangeSet));
    }
}
