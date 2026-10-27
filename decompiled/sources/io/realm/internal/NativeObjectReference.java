package io.realm.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
final class NativeObjectReference extends PhantomReference<h> {

    /* renamed from: f, reason: collision with root package name */
    public static final i f6678f = new i();

    /* renamed from: a, reason: collision with root package name */
    public final long f6679a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6680b;

    /* renamed from: c, reason: collision with root package name */
    public final g f6681c;

    /* renamed from: d, reason: collision with root package name */
    public NativeObjectReference f6682d;

    /* renamed from: e, reason: collision with root package name */
    public NativeObjectReference f6683e;

    public NativeObjectReference(g gVar, h hVar, ReferenceQueue referenceQueue) {
        super(hVar, referenceQueue);
        this.f6679a = hVar.getNativePtr();
        this.f6680b = hVar.getNativeFinalizerPtr();
        this.f6681c = gVar;
        i iVar = f6678f;
        synchronized (iVar) {
            try {
                this.f6682d = null;
                NativeObjectReference nativeObjectReference = (NativeObjectReference) iVar.f6746b;
                this.f6683e = nativeObjectReference;
                if (nativeObjectReference != null) {
                    nativeObjectReference.f6682d = this;
                }
                iVar.f6746b = this;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static native void nativeCleanUp(long j10, long j11);
}
