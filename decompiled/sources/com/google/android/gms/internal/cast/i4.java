package com.google.android.gms.internal.cast;

import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i4 extends n4.a implements ScheduledFuture, s9.b, Future {

    /* renamed from: t, reason: collision with root package name */
    public final b4 f3338t;

    /* renamed from: u, reason: collision with root package name */
    public final ScheduledFuture f3339u;

    public i4(b4 b4Var, ScheduledFuture scheduledFuture) {
        super(3);
        this.f3338t = b4Var;
        this.f3339u = scheduledFuture;
    }

    @Override // s9.b
    public final void a(Runnable runnable, Executor executor) {
        this.f3338t.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        boolean cancel = this.f3338t.cancel(z10);
        if (cancel) {
            this.f3339u.cancel(z10);
        }
        return cancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.f3339u.compareTo(delayed);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f3338t.get();
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f3339u.getDelay(timeUnit);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f3338t.f3266p instanceof s3;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f3338t.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) {
        return this.f3338t.get(j10, timeUnit);
    }
}
