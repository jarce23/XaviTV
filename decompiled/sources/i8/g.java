package i8;

import app.shamel.tv.activities.y;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements h {

    /* renamed from: b, reason: collision with root package name */
    public final Executor f6526b;

    /* renamed from: d, reason: collision with root package name */
    public final Object f6528d;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6525a = 0;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6527c = new Object();

    public g(Executor executor, a aVar) {
        this.f6526b = executor;
        this.f6528d = aVar;
    }

    private final void b(i iVar) {
        synchronized (this.f6527c) {
        }
        this.f6526b.execute(new y(this, 11, iVar));
    }

    private final void c(i iVar) {
        if (iVar.n()) {
            return;
        }
        synchronized (this.f6527c) {
        }
        this.f6526b.execute(new y(this, 12, iVar));
    }

    @Override // i8.h
    public final void a(i iVar) {
        switch (this.f6525a) {
            case 0:
                b(iVar);
                return;
            case 1:
                c(iVar);
                return;
            default:
                if (iVar.n()) {
                    synchronized (this.f6527c) {
                    }
                    this.f6526b.execute(new y(this, 13, iVar));
                    return;
                }
                return;
        }
    }

    public g(Executor executor, b bVar) {
        this.f6526b = executor;
        this.f6528d = bVar;
    }

    public g(Executor executor, c cVar) {
        this.f6526b = executor;
        this.f6528d = cVar;
    }
}
