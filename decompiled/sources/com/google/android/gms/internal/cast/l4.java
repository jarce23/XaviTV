package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l4 extends h4 implements ScheduledExecutorService {

    /* renamed from: p, reason: collision with root package name */
    public final ScheduledExecutorService f3365p;

    public l4(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f3365p = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.cast.h4, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        androidx.emoji2.text.b0.v(this);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        n4 n4Var = new n4(Executors.callable(runnable, null));
        return new i4(n4Var, this.f3365p.schedule(n4Var, j10, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        k4 k4Var = new k4(runnable);
        return new i4(k4Var, this.f3365p.scheduleAtFixedRate(k4Var, j10, j11, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        k4 k4Var = new k4(runnable);
        return new i4(k4Var, this.f3365p.scheduleWithFixedDelay(k4Var, j10, j11, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j10, TimeUnit timeUnit) {
        n4 n4Var = new n4(callable);
        return new i4(n4Var, this.f3365p.schedule(n4Var, j10, timeUnit));
    }
}
