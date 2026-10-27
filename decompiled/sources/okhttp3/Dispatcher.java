package okhttp3;

import android.support.v4.media.d;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ma.j;
import ma.l;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RealCall;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator<RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        h.d("iterator(...)", it);
        while (it.hasNext()) {
            RealCall.AsyncCall next = it.next();
            if (h.a(next.getHost(), str)) {
                return next;
            }
        }
        Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
        h.d("iterator(...)", it2);
        while (it2.hasNext()) {
            RealCall.AsyncCall next2 = it2.next();
            if (h.a(next2.getHost(), str)) {
                return next2;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void promoteAndExecute(RealCall.AsyncCall asyncCall, RealCall realCall, RealCall.AsyncCall asyncCall2) {
        Dispatcher$promoteAndExecute$Effects dispatcher$promoteAndExecute$Effects;
        RealCall.AsyncCall findExistingCallWithHost;
        _UtilJvmKt.assertLockNotHeld(this);
        boolean isShutdown = executorService().isShutdown();
        synchronized (this) {
            if (realCall != null) {
                try {
                    if (!this.runningSyncCalls.remove(realCall)) {
                        throw new IllegalStateException("Call wasn't in-flight!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (asyncCall2 != null) {
                asyncCall2.getCallsPerHost().decrementAndGet();
                if (!this.runningAsyncCalls.remove(asyncCall2)) {
                    throw new IllegalStateException("Call wasn't in-flight!");
                }
            }
            if (asyncCall != null) {
                this.readyAsyncCalls.add(asyncCall);
                if (!asyncCall.getCall().getForWebSocket() && (findExistingCallWithHost = findExistingCallWithHost(asyncCall.getHost())) != null) {
                    asyncCall.reuseCallsPerHostFrom(findExistingCallWithHost);
                }
            }
            final Runnable runnable = (!(realCall == null && asyncCall2 == null) && (isShutdown || this.runningAsyncCalls.isEmpty()) && this.runningSyncCalls.isEmpty()) ? this.idleCallback : null;
            if (isShutdown) {
                final List J = j.J(this.readyAsyncCalls);
                this.readyAsyncCalls.clear();
                dispatcher$promoteAndExecute$Effects = new Object(J, runnable) { // from class: okhttp3.Dispatcher$promoteAndExecute$Effects
                    private final List<RealCall.AsyncCall> callsToExecute;
                    private final Runnable idleCallbackToRun;

                    {
                        h.e("callsToExecute", J);
                        this.callsToExecute = J;
                        this.idleCallbackToRun = runnable;
                    }

                    public final List<RealCall.AsyncCall> getCallsToExecute() {
                        return this.callsToExecute;
                    }

                    public final Runnable getIdleCallbackToRun() {
                        return this.idleCallbackToRun;
                    }
                };
            } else {
                final ArrayList arrayList = new ArrayList();
                Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
                h.d("iterator(...)", it);
                while (it.hasNext()) {
                    RealCall.AsyncCall next = it.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    }
                    if (next.getCallsPerHost().get() < this.maxRequestsPerHost) {
                        it.remove();
                        next.getCallsPerHost().incrementAndGet();
                        arrayList.add(next);
                        this.runningAsyncCalls.add(next);
                    }
                }
                dispatcher$promoteAndExecute$Effects = new Object(arrayList, runnable) { // from class: okhttp3.Dispatcher$promoteAndExecute$Effects
                    private final List<RealCall.AsyncCall> callsToExecute;
                    private final Runnable idleCallbackToRun;

                    {
                        h.e("callsToExecute", arrayList);
                        this.callsToExecute = arrayList;
                        this.idleCallbackToRun = runnable;
                    }

                    public final List<RealCall.AsyncCall> getCallsToExecute() {
                        return this.callsToExecute;
                    }

                    public final Runnable getIdleCallbackToRun() {
                        return this.idleCallbackToRun;
                    }
                };
            }
        }
        int size = dispatcher$promoteAndExecute$Effects.getCallsToExecute().size();
        boolean z10 = true;
        for (int i10 = 0; i10 < size; i10++) {
            RealCall.AsyncCall asyncCall3 = dispatcher$promoteAndExecute$Effects.getCallsToExecute().get(i10);
            if (asyncCall3 == asyncCall) {
                z10 = false;
            } else {
                asyncCall3.getCall().getEventListener$okhttp().dispatcherQueueEnd(asyncCall3.getCall(), this);
            }
            if (isShutdown) {
                RealCall.AsyncCall.failRejected$okhttp$default(asyncCall3, null, 1, null);
            } else {
                asyncCall3.executeOn(executorService());
            }
        }
        if (z10 && asyncCall != null) {
            asyncCall.getCall().getEventListener$okhttp().dispatcherQueueStart(asyncCall.getCall(), this);
        }
        Runnable idleCallbackToRun = dispatcher$promoteAndExecute$Effects.getIdleCallbackToRun();
        if (idleCallbackToRun != null) {
            idleCallbackToRun.run();
        }
    }

    public static /* synthetic */ void promoteAndExecute$default(Dispatcher dispatcher, RealCall.AsyncCall asyncCall, RealCall realCall, RealCall.AsyncCall asyncCall2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            asyncCall = null;
        }
        if ((i10 & 2) != 0) {
            realCall = null;
        }
        if ((i10 & 4) != 0) {
            asyncCall2 = null;
        }
        dispatcher.promoteAndExecute(asyncCall, realCall, asyncCall2);
    }

    /* renamed from: -deprecated_executorService, reason: not valid java name */
    public final ExecutorService m43deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        try {
            Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            h.d("iterator(...)", it);
            while (it.hasNext()) {
                it.next().getCall().cancel();
            }
            Iterator<RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
            h.d("iterator(...)", it2);
            while (it2.hasNext()) {
                it2.next().getCall().cancel();
            }
            Iterator<RealCall> it3 = this.runningSyncCalls.iterator();
            h.d("iterator(...)", it3);
            while (it3.hasNext()) {
                it3.next().cancel();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void enqueue$okhttp(RealCall.AsyncCall asyncCall) {
        h.e("call", asyncCall);
        promoteAndExecute$default(this, asyncCall, null, null, 6, null);
    }

    public final synchronized boolean executed$okhttp(RealCall realCall) {
        h.e("call", realCall);
        return this.runningSyncCalls.add(realCall);
    }

    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        try {
            if (this.executorServiceOrNull == null) {
                this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), _UtilJvmKt.threadFactory(_UtilJvmKt.okHttpName + " Dispatcher", false));
            }
            executorService = this.executorServiceOrNull;
            h.b(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final void finished$okhttp(RealCall.AsyncCall asyncCall) {
        h.e("call", asyncCall);
        promoteAndExecute$default(this, null, null, asyncCall, 3, null);
    }

    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final synchronized List<Call> queuedCalls() {
        List<Call> unmodifiableList;
        try {
            ArrayDeque<RealCall.AsyncCall> arrayDeque = this.readyAsyncCalls;
            ArrayList arrayList = new ArrayList(l.z(arrayDeque));
            Iterator<T> it = arrayDeque.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getCall());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
            h.d("unmodifiableList(...)", unmodifiableList);
        } catch (Throwable th) {
            throw th;
        }
        return unmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized List<Call> runningCalls() {
        List<Call> unmodifiableList;
        try {
            ArrayDeque<RealCall> arrayDeque = this.runningSyncCalls;
            ArrayDeque<RealCall.AsyncCall> arrayDeque2 = this.runningAsyncCalls;
            ArrayList arrayList = new ArrayList(l.z(arrayDeque2));
            Iterator<T> it = arrayDeque2.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getCall());
            }
            unmodifiableList = Collections.unmodifiableList(j.H(arrayDeque, arrayList));
            h.d("unmodifiableList(...)", unmodifiableList);
        } catch (Throwable th) {
            throw th;
        }
        return unmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(d.m(i10, "max < 1: ").toString());
        }
        synchronized (this) {
            this.maxRequests = i10;
        }
        promoteAndExecute$default(this, null, null, null, 7, null);
    }

    public final void setMaxRequestsPerHost(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(d.m(i10, "max < 1: ").toString());
        }
        synchronized (this) {
            this.maxRequestsPerHost = i10;
        }
        promoteAndExecute$default(this, null, null, null, 7, null);
    }

    public final void finished$okhttp(RealCall realCall) {
        h.e("call", realCall);
        promoteAndExecute$default(this, null, realCall, null, 5, null);
    }

    public Dispatcher(ExecutorService executorService) {
        this();
        this.executorServiceOrNull = executorService;
    }
}
