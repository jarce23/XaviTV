package io.realm.internal;

import java.lang.ref.ReferenceQueue;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final ReferenceQueue f6743a;

    /* renamed from: b, reason: collision with root package name */
    public static final g f6744b;

    static {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        f6743a = referenceQueue;
        Thread thread = new Thread(new e(referenceQueue));
        f6744b = new g();
        thread.setName("RealmFinalizingDaemon");
        thread.start();
    }

    public final void a(h hVar) {
        new NativeObjectReference(this, hVar, f6743a);
    }
}
