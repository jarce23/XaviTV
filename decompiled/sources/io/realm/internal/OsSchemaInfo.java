package io.realm.internal;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class OsSchemaInfo implements h {

    /* renamed from: p, reason: collision with root package name */
    public static final long f6709p = nativeGetFinalizerPtr();

    /* renamed from: o, reason: collision with root package name */
    public final long f6710o;

    public OsSchemaInfo(Collection collection) {
        long[] jArr = new long[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            jArr[i10] = ((OsObjectSchemaInfo) it.next()).f6693o;
            i10++;
        }
        this.f6710o = nativeCreateFromList(jArr);
        g.f6744b.a(this);
    }

    private static native long nativeCreateFromList(long[] jArr);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetObjectSchemaInfo(long j10, String str);

    public final OsObjectSchemaInfo a(String str) {
        return new OsObjectSchemaInfo(nativeGetObjectSchemaInfo(this.f6710o, str));
    }

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6709p;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6710o;
    }

    public OsSchemaInfo(long j10) {
        this.f6710o = j10;
    }
}
