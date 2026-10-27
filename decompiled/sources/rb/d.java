package rb;

import android.os.Process;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends Thread {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11001o = 1;

    public /* synthetic */ d(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        c cVar;
        ReentrantLock reentrantLock;
        c cVar2;
        g b2;
        c cVar3;
        g gVar;
        c cVar4;
        switch (this.f11001o) {
            case 0:
                break;
            case 1:
                Process.setThreadPriority(9);
                super.run();
                return;
            default:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
        }
        while (true) {
            try {
                cVar = g.Companion;
                cVar.getClass();
                reentrantLock = g.lock;
                reentrantLock.lock();
                try {
                    cVar2 = g.Companion;
                    cVar2.getClass();
                    b2 = c.b();
                    cVar3 = g.Companion;
                    cVar3.getClass();
                    gVar = g.idleSentinel;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused2) {
                continue;
            }
            if (b2 == gVar) {
                cVar4 = g.Companion;
                cVar4.getClass();
                g.idleSentinel = null;
                reentrantLock.unlock();
                return;
            }
            reentrantLock.unlock();
            if (b2 != null) {
                b2.timedOut();
            }
        }
    }

    public /* synthetic */ d(String str) {
        super(str);
    }

    public /* synthetic */ d(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
