package t5;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends WeakReference {

    /* renamed from: a, reason: collision with root package name */
    public final r5.e f11885a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11886b;

    /* renamed from: c, reason: collision with root package name */
    public y f11887c;

    public a(r5.e eVar, s sVar, ReferenceQueue referenceQueue) {
        super(sVar, referenceQueue);
        m6.f.c("Argument must not be null", eVar);
        this.f11885a = eVar;
        boolean z10 = sVar.f11985o;
        this.f11887c = null;
        this.f11886b = z10;
    }
}
