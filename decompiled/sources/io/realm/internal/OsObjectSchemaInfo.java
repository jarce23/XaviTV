package io.realm.internal;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class OsObjectSchemaInfo implements h {

    /* renamed from: p, reason: collision with root package name */
    public static final long f6692p = nativeGetFinalizerPtr();

    /* renamed from: o, reason: collision with root package name */
    public final long f6693o;

    public OsObjectSchemaInfo(String str) {
        this(nativeCreateRealmObjectSchema(_UrlKt.FRAGMENT_ENCODE_SET, str, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAddProperties(long j10, long[] jArr, long[] jArr2);

    private static native long nativeCreateRealmObjectSchema(String str, String str2, boolean z10);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetProperty(long j10, String str);

    public final Property b(String str) {
        long nativeGetProperty = nativeGetProperty(this.f6693o, str);
        Property property = new Property();
        property.f6714o = nativeGetProperty;
        g.f6744b.a(property);
        return property;
    }

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6692p;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6693o;
    }

    public OsObjectSchemaInfo(long j10) {
        this.f6693o = j10;
        g.f6744b.a(this);
    }
}
