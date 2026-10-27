package g2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends Handler implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final int f5117o;

    /* renamed from: p, reason: collision with root package name */
    public final k f5118p;

    /* renamed from: q, reason: collision with root package name */
    public final long f5119q;

    /* renamed from: r, reason: collision with root package name */
    public i f5120r;

    /* renamed from: s, reason: collision with root package name */
    public IOException f5121s;

    /* renamed from: t, reason: collision with root package name */
    public int f5122t;

    /* renamed from: u, reason: collision with root package name */
    public Thread f5123u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5124v;

    /* renamed from: w, reason: collision with root package name */
    public volatile boolean f5125w;

    /* renamed from: x, reason: collision with root package name */
    public final /* synthetic */ n f5126x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(n nVar, Looper looper, k kVar, i iVar, int i10, long j10) {
        super(looper);
        this.f5126x = nVar;
        this.f5118p = kVar;
        this.f5120r = iVar;
        this.f5117o = i10;
        this.f5119q = j10;
    }

    public final void a(boolean z10) {
        this.f5125w = z10;
        this.f5121s = null;
        if (hasMessages(1)) {
            this.f5124v = true;
            removeMessages(1);
            if (!z10) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                try {
                    this.f5124v = true;
                    this.f5118p.b();
                    Thread thread = this.f5123u;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z10) {
            this.f5126x.f5131b = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            i iVar = this.f5120r;
            iVar.getClass();
            iVar.u(this.f5118p, elapsedRealtime, elapsedRealtime - this.f5119q, true);
            this.f5120r = null;
        }
    }

    public final void b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = elapsedRealtime - this.f5119q;
        i iVar = this.f5120r;
        iVar.getClass();
        iVar.i(this.f5118p, elapsedRealtime, j10, this.f5122t);
        this.f5121s = null;
        n nVar = this.f5126x;
        h2.b bVar = nVar.f5130a;
        j jVar = nVar.f5131b;
        jVar.getClass();
        bVar.execute(jVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f5125w) {
            return;
        }
        int i10 = message.what;
        if (i10 == 1) {
            b();
            return;
        }
        if (i10 == 4) {
            throw ((Error) message.obj);
        }
        this.f5126x.f5131b = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = elapsedRealtime - this.f5119q;
        i iVar = this.f5120r;
        iVar.getClass();
        if (this.f5124v) {
            iVar.u(this.f5118p, elapsedRealtime, j10, false);
            return;
        }
        int i11 = message.what;
        if (i11 == 2) {
            try {
                iVar.b(this.f5118p, elapsedRealtime, j10);
                return;
            } catch (RuntimeException e7) {
                l1.b.h("LoadTask", "Unexpected exception handling load completed", e7);
                this.f5126x.f5132c = new m(e7);
                return;
            }
        }
        if (i11 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.f5121s = iOException;
        int i12 = this.f5122t + 1;
        this.f5122t = i12;
        h d6 = iVar.d(this.f5118p, elapsedRealtime, j10, iOException, i12);
        int i13 = d6.f5115a;
        if (i13 == 3) {
            this.f5126x.f5132c = this.f5121s;
            return;
        }
        if (i13 != 2) {
            if (i13 == 1) {
                this.f5122t = 1;
            }
            long j11 = d6.f5116b;
            if (j11 == -9223372036854775807L) {
                j11 = Math.min((this.f5122t - 1) * 1000, 5000);
            }
            n nVar = this.f5126x;
            l1.d.g(nVar.f5131b == null);
            nVar.f5131b = this;
            if (j11 > 0) {
                sendEmptyMessageDelayed(1, j11);
            } else {
                b();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        try {
            synchronized (this) {
                z10 = this.f5124v;
                this.f5123u = Thread.currentThread();
            }
            if (!z10) {
                Trace.beginSection("load:".concat(this.f5118p.getClass().getSimpleName()));
                try {
                    this.f5118p.a();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.f5123u = null;
                Thread.interrupted();
            }
            if (this.f5125w) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e7) {
            if (this.f5125w) {
                return;
            }
            obtainMessage(3, e7).sendToTarget();
        } catch (Exception e8) {
            if (this.f5125w) {
                return;
            }
            l1.b.h("LoadTask", "Unexpected exception loading stream", e8);
            obtainMessage(3, new m(e8)).sendToTarget();
        } catch (OutOfMemoryError e10) {
            if (this.f5125w) {
                return;
            }
            l1.b.h("LoadTask", "OutOfMemory error loading stream", e10);
            obtainMessage(3, new m(e10)).sendToTarget();
        } catch (Error e11) {
            if (!this.f5125w) {
                l1.b.h("LoadTask", "Unexpected error loading stream", e11);
                obtainMessage(4, e11).sendToTarget();
            }
            throw e11;
        }
    }
}
