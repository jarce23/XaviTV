package f;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements Executor {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4830o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayDeque f4831p;

    /* renamed from: q, reason: collision with root package name */
    public Runnable f4832q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f4833r;

    /* renamed from: s, reason: collision with root package name */
    public final Executor f4834s;

    public o(Executor executor) {
        this.f4830o = 1;
        this.f4834s = executor;
        this.f4831p = new ArrayDeque();
        this.f4833r = new Object();
    }

    private final void a(Runnable runnable) {
        synchronized (this.f4833r) {
            try {
                this.f4831p.add(new androidx.fragment.app.d(this, 5, runnable));
                if (this.f4832q == null) {
                    c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        boolean z10;
        synchronized (this.f4833r) {
            z10 = !this.f4831p.isEmpty();
        }
        return z10;
    }

    public final void c() {
        switch (this.f4830o) {
            case 0:
                synchronized (this.f4833r) {
                    try {
                        Runnable runnable = (Runnable) this.f4831p.poll();
                        this.f4832q = runnable;
                        if (runnable != null) {
                            ((p) this.f4834s).execute(runnable);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                Runnable runnable2 = (Runnable) this.f4831p.poll();
                this.f4832q = runnable2;
                if (runnable2 != null) {
                    this.f4834s.execute(runnable2);
                    return;
                }
                return;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f4830o) {
            case 0:
                a(runnable);
                return;
            default:
                synchronized (this.f4833r) {
                    try {
                        this.f4831p.add(new p7.m(this, runnable));
                        if (this.f4832q == null) {
                            c();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    public o(p pVar) {
        this.f4830o = 0;
        this.f4833r = new Object();
        this.f4831p = new ArrayDeque();
        this.f4834s = pVar;
    }
}
