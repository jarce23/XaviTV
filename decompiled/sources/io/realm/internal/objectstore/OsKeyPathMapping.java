package io.realm.internal.objectstore;

import io.realm.internal.g;
import io.realm.internal.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class OsKeyPathMapping implements h {

    /* renamed from: p, reason: collision with root package name */
    public static final long f6753p = nativeGetFinalizerMethodPtr();

    /* renamed from: o, reason: collision with root package name */
    public final long f6754o;

    public OsKeyPathMapping(long j10) {
        this.f6754o = -1L;
        this.f6754o = nativeCreateMapping(j10);
        g.f6744b.a(this);
    }

    private static native long nativeCreateMapping(long j10);

    private static native long nativeGetFinalizerMethodPtr();

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6753p;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6754o;
    }
}
