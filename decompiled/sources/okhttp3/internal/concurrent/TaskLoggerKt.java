package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.Http2Connection;
import ya.a;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class TaskLoggerKt {
    public static final String formatDuration(long j10) {
        String str;
        if (j10 <= -999500000) {
            str = ((j10 - 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS) + " s ";
        } else if (j10 <= -999500) {
            str = ((j10 - 500000) / 1000000) + " ms";
        } else if (j10 <= 0) {
            str = ((j10 - 500) / 1000) + " µs";
        } else if (j10 < 999500) {
            str = ((j10 + 500) / 1000) + " µs";
        } else if (j10 < 999500000) {
            str = ((j10 + 500000) / 1000000) + " ms";
        } else {
            str = ((j10 + 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS) + " s ";
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Logger logger, Task task, TaskQueue taskQueue, String str) {
        logger.fine(taskQueue.getName$okhttp() + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + task.getName());
    }

    public static final <T> T logElapsed(Logger logger, Task task, TaskQueue taskQueue, a aVar) {
        long j10;
        h.e("<this>", logger);
        h.e("task", task);
        h.e("queue", taskQueue);
        h.e("block", aVar);
        boolean isLoggable = logger.isLoggable(Level.FINE);
        if (isLoggable) {
            j10 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(logger, task, taskQueue, "starting");
        } else {
            j10 = -1;
        }
        try {
            T t3 = (T) aVar.invoke();
            if (isLoggable) {
                log(logger, task, taskQueue, "finished run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j10));
            }
            return t3;
        } catch (Throwable th) {
            if (isLoggable) {
                log(logger, task, taskQueue, "failed a run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j10));
            }
            throw th;
        }
    }

    public static final void taskLog(Logger logger, Task task, TaskQueue taskQueue, a aVar) {
        h.e("<this>", logger);
        h.e("task", task);
        h.e("queue", taskQueue);
        h.e("messageBlock", aVar);
        if (logger.isLoggable(Level.FINE)) {
            log(logger, task, taskQueue, (String) aVar.invoke());
        }
    }
}
