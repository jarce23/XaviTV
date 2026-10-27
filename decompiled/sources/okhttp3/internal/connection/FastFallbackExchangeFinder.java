package okhttp3.internal.connection;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class FastFallbackExchangeFinder implements ExchangeFinder {
    private final long connectDelayNanos;
    private final BlockingQueue<RoutePlanner.ConnectResult> connectResults;
    private long nextTcpConnectAtNanos;
    private final RoutePlanner routePlanner;
    private final TaskRunner taskRunner;
    private final CopyOnWriteArrayList<RoutePlanner.Plan> tcpConnectsInFlight;

    public FastFallbackExchangeFinder(RoutePlanner routePlanner, TaskRunner taskRunner) {
        h.e("routePlanner", routePlanner);
        h.e("taskRunner", taskRunner);
        this.routePlanner = routePlanner;
        this.taskRunner = taskRunner;
        this.connectDelayNanos = TimeUnit.MILLISECONDS.toNanos(250L);
        this.nextTcpConnectAtNanos = Long.MIN_VALUE;
        this.tcpConnectsInFlight = new CopyOnWriteArrayList<>();
        this.connectResults = taskRunner.getBackend().decorate(new LinkedBlockingDeque());
    }

    private final RoutePlanner.ConnectResult awaitTcpConnect(long j10, TimeUnit timeUnit) {
        RoutePlanner.ConnectResult poll;
        if (this.tcpConnectsInFlight.isEmpty() || (poll = this.connectResults.poll(j10, timeUnit)) == null) {
            return null;
        }
        this.tcpConnectsInFlight.remove(poll.getPlan());
        return poll;
    }

    private final void cancelInFlightConnects() {
        Iterator<RoutePlanner.Plan> it = this.tcpConnectsInFlight.iterator();
        h.d("iterator(...)", it);
        while (it.hasNext()) {
            RoutePlanner.Plan next = it.next();
            next.mo145cancel();
            RoutePlanner.Plan mo147retry = next.mo147retry();
            if (mo147retry != null) {
                getRoutePlanner().getDeferredPlans().addLast(mo147retry);
            }
        }
        this.tcpConnectsInFlight.clear();
    }

    private final RoutePlanner.ConnectResult launchTcpConnect() {
        final RoutePlanner.Plan failedPlan;
        if (a.a(getRoutePlanner(), null, 1, null)) {
            try {
                failedPlan = getRoutePlanner().plan();
            } catch (Throwable th) {
                failedPlan = new FailedPlan(th);
            }
            if (failedPlan.isReady()) {
                return new RoutePlanner.ConnectResult(failedPlan, null, null, 6, null);
            }
            if (failedPlan instanceof FailedPlan) {
                return ((FailedPlan) failedPlan).getResult();
            }
            this.tcpConnectsInFlight.add(failedPlan);
            final String str = _UtilJvmKt.okHttpName + " connect " + getRoutePlanner().getAddress().url().redact();
            TaskQueue.schedule$default(this.taskRunner.newQueue(), new Task(str) { // from class: okhttp3.internal.connection.FastFallbackExchangeFinder$launchTcpConnect$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    RoutePlanner.ConnectResult connectResult;
                    CopyOnWriteArrayList copyOnWriteArrayList;
                    BlockingQueue blockingQueue;
                    try {
                        connectResult = failedPlan.mo149connectTcp();
                    } catch (Throwable th2) {
                        connectResult = new RoutePlanner.ConnectResult(failedPlan, null, th2, 2, null);
                    }
                    copyOnWriteArrayList = this.tcpConnectsInFlight;
                    if (!copyOnWriteArrayList.contains(failedPlan)) {
                        return -1L;
                    }
                    blockingQueue = this.connectResults;
                    blockingQueue.put(connectResult);
                    return -1L;
                }
            }, 0L, 2, null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:3:0x0002, B:5:0x000a, B:11:0x0020, B:13:0x002a, B:20:0x0054, B:23:0x005d, B:25:0x0063, B:27:0x0070, B:28:0x0078, B:31:0x007e, B:34:0x008a, B:36:0x0090, B:39:0x0096, B:40:0x009a, B:42:0x009e, B:43:0x009f, B:46:0x00a5, B:54:0x0049, B:56:0x00b2, B:57:0x00b9), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:3:0x0002, B:5:0x000a, B:11:0x0020, B:13:0x002a, B:20:0x0054, B:23:0x005d, B:25:0x0063, B:27:0x0070, B:28:0x0078, B:31:0x007e, B:34:0x008a, B:36:0x0090, B:39:0x0096, B:40:0x009a, B:42:0x009e, B:43:0x009f, B:46:0x00a5, B:54:0x0049, B:56:0x00b2, B:57:0x00b9), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0002 A[SYNTHETIC] */
    @Override // okhttp3.internal.connection.ExchangeFinder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.internal.connection.RealConnection find() {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
        L2:
            java.util.concurrent.CopyOnWriteArrayList<okhttp3.internal.connection.RoutePlanner$Plan> r2 = r8.tcpConnectsInFlight     // Catch: java.lang.Throwable -> L1d
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L20
            okhttp3.internal.connection.RoutePlanner r2 = r8.getRoutePlanner()     // Catch: java.lang.Throwable -> L1d
            r3 = 1
            boolean r2 = okhttp3.internal.connection.a.a(r2, r0, r3, r0)     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L16
            goto L20
        L16:
            r8.cancelInFlightConnects()
            za.h.b(r1)
            throw r1
        L1d:
            r0 = move-exception
            goto Lba
        L20:
            okhttp3.internal.connection.RoutePlanner r2 = r8.getRoutePlanner()     // Catch: java.lang.Throwable -> L1d
            boolean r2 = r2.isCanceled()     // Catch: java.lang.Throwable -> L1d
            if (r2 != 0) goto Lb2
            okhttp3.internal.concurrent.TaskRunner r2 = r8.taskRunner     // Catch: java.lang.Throwable -> L1d
            okhttp3.internal.concurrent.TaskRunner$Backend r2 = r2.getBackend()     // Catch: java.lang.Throwable -> L1d
            long r2 = r2.nanoTime()     // Catch: java.lang.Throwable -> L1d
            long r4 = r8.nextTcpConnectAtNanos     // Catch: java.lang.Throwable -> L1d
            long r4 = r4 - r2
            java.util.concurrent.CopyOnWriteArrayList<okhttp3.internal.connection.RoutePlanner$Plan> r6 = r8.tcpConnectsInFlight     // Catch: java.lang.Throwable -> L1d
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r6 != 0) goto L49
            r6 = 0
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 > 0) goto L46
            goto L49
        L46:
            r5 = r4
            r4 = r0
            goto L52
        L49:
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r8.launchTcpConnect()     // Catch: java.lang.Throwable -> L1d
            long r5 = r8.connectDelayNanos     // Catch: java.lang.Throwable -> L1d
            long r2 = r2 + r5
            r8.nextTcpConnectAtNanos = r2     // Catch: java.lang.Throwable -> L1d
        L52:
            if (r4 != 0) goto L5d
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L1d
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r8.awaitTcpConnect(r5, r2)     // Catch: java.lang.Throwable -> L1d
            if (r4 != 0) goto L5d
            goto L2
        L5d:
            boolean r2 = r4.isSuccess()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L8a
            r8.cancelInFlightConnects()     // Catch: java.lang.Throwable -> L1d
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getPlan()     // Catch: java.lang.Throwable -> L1d
            boolean r2 = r2.isReady()     // Catch: java.lang.Throwable -> L1d
            if (r2 != 0) goto L78
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getPlan()     // Catch: java.lang.Throwable -> L1d
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r2.mo150connectTlsEtc()     // Catch: java.lang.Throwable -> L1d
        L78:
            boolean r2 = r4.isSuccess()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L8a
            okhttp3.internal.connection.RoutePlanner$Plan r0 = r4.getPlan()     // Catch: java.lang.Throwable -> L1d
            okhttp3.internal.connection.RealConnection r0 = r0.mo146handleSuccess()     // Catch: java.lang.Throwable -> L1d
            r8.cancelInFlightConnects()
            return r0
        L8a:
            java.lang.Throwable r2 = r4.getThrowable()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L9f
            boolean r3 = r2 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L1d
            if (r3 == 0) goto L9e
            if (r1 != 0) goto L9a
            java.io.IOException r2 = (java.io.IOException) r2     // Catch: java.lang.Throwable -> L1d
            r1 = r2
            goto L9f
        L9a:
            com.bumptech.glide.f.a(r1, r2)     // Catch: java.lang.Throwable -> L1d
            goto L9f
        L9e:
            throw r2     // Catch: java.lang.Throwable -> L1d
        L9f:
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getNextPlan()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L2
            okhttp3.internal.connection.RoutePlanner r3 = r8.getRoutePlanner()     // Catch: java.lang.Throwable -> L1d
            ma.h r3 = r3.getDeferredPlans()     // Catch: java.lang.Throwable -> L1d
            r3.addFirst(r2)     // Catch: java.lang.Throwable -> L1d
            goto L2
        Lb2:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L1d
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L1d
            throw r0     // Catch: java.lang.Throwable -> L1d
        Lba:
            r8.cancelInFlightConnects()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.FastFallbackExchangeFinder.find():okhttp3.internal.connection.RealConnection");
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }
}
