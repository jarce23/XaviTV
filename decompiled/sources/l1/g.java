package l1;

import android.os.SystemClock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final v f8090a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8091b;

    public g() {
        this(v.f8135a);
    }

    public final synchronized void a() {
        while (!this.f8091b) {
            this.f8090a.getClass();
            wait();
        }
    }

    public final synchronized boolean b(long j10) {
        if (j10 <= 0) {
            return this.f8091b;
        }
        this.f8090a.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = j10 + elapsedRealtime;
        if (j11 < elapsedRealtime) {
            a();
        } else {
            while (!this.f8091b && elapsedRealtime < j11) {
                this.f8090a.getClass();
                wait(j11 - elapsedRealtime);
                this.f8090a.getClass();
                elapsedRealtime = SystemClock.elapsedRealtime();
            }
        }
        return this.f8091b;
    }

    public final synchronized void c() {
        boolean z10 = false;
        while (!this.f8091b) {
            try {
                this.f8090a.getClass();
                wait();
            } catch (InterruptedException unused) {
                z10 = true;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean d(long j10) {
        if (j10 <= 0) {
            return this.f8091b;
        }
        this.f8090a.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = j10 + elapsedRealtime;
        if (j11 < elapsedRealtime) {
            c();
        } else {
            boolean z10 = false;
            while (!this.f8091b && elapsedRealtime < j11) {
                try {
                    this.f8090a.getClass();
                    wait(j11 - elapsedRealtime);
                } catch (InterruptedException unused) {
                    z10 = true;
                }
                this.f8090a.getClass();
                elapsedRealtime = SystemClock.elapsedRealtime();
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
        return this.f8091b;
    }

    public final synchronized void e() {
        this.f8091b = false;
    }

    public final synchronized boolean f() {
        if (this.f8091b) {
            return false;
        }
        this.f8091b = true;
        notifyAll();
        return true;
    }

    public g(v vVar) {
        this.f8090a = vVar;
    }
}
