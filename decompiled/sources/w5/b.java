package w5;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import p7.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final a f13104a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13105b;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13107d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicInteger f13108e = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    public final c f13106c = c.f13109a;

    public b(a aVar, String str, boolean z10) {
        this.f13104a = aVar;
        this.f13105b = str;
        this.f13107d = z10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        m mVar = new m(this, 4, runnable);
        this.f13104a.getClass();
        rb.d dVar = new rb.d(mVar);
        dVar.setName("glide-" + this.f13105b + "-thread-" + this.f13108e.getAndIncrement());
        return dVar;
    }
}
