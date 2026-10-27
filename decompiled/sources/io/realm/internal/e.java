package io.realm.internal;

import io.realm.log.RealmLog;
import java.lang.ref.ReferenceQueue;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final ReferenceQueue f6740o;

    public e(ReferenceQueue referenceQueue) {
        this.f6740o = referenceQueue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                NativeObjectReference nativeObjectReference = (NativeObjectReference) this.f6740o.remove();
                synchronized (nativeObjectReference.f6681c) {
                    NativeObjectReference.nativeCleanUp(nativeObjectReference.f6680b, nativeObjectReference.f6679a);
                }
                NativeObjectReference.f6678f.b(nativeObjectReference);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                RealmLog.b(7, null, "The FinalizerRunnable thread has been interrupted. Native resources cannot be freed anymore", new Object[0]);
                return;
            }
        }
    }
}
