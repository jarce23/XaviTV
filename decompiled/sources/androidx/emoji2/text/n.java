package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends j1.c {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j1.c f589b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f590c;

    public n(j1.c cVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f589b = cVar;
        this.f590c = threadPoolExecutor;
    }

    @Override // j1.c
    public final void m(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f590c;
        try {
            this.f589b.m(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // j1.c
    public final void n(x4.i iVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f590c;
        try {
            this.f589b.n(iVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
