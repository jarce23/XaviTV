package androidx.emoji2.text;

import android.os.Build;
import android.os.LocaleList;
import com.google.android.gms.internal.cast.h4;
import com.google.android.gms.internal.cast.l4;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class b0 {
    public static /* bridge */ /* synthetic */ LocaleList f(Object obj) {
        return (LocaleList) obj;
    }

    public static void u(h4 h4Var) {
        boolean isTerminated;
        ExecutorService executorService = h4Var.f3321o;
        if ((Build.VERSION.SDK_INT <= 23 || h4Var != ForkJoinPool.commonPool()) && !(isTerminated = executorService.isTerminated())) {
            h4Var.shutdown();
            boolean z10 = false;
            while (!isTerminated) {
                try {
                    isTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        h4Var.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void v(l4 l4Var) {
        boolean isTerminated;
        ExecutorService executorService = l4Var.f3321o;
        if ((Build.VERSION.SDK_INT <= 23 || l4Var != ForkJoinPool.commonPool()) && !(isTerminated = executorService.isTerminated())) {
            l4Var.shutdown();
            boolean z10 = false;
            while (!isTerminated) {
                try {
                    isTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        l4Var.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void w(fa.b bVar) {
        boolean isTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || bVar != ForkJoinPool.commonPool()) && !(isTerminated = bVar.isTerminated())) {
            bVar.shutdown();
            boolean z10 = false;
            while (!isTerminated) {
                try {
                    isTerminated = bVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        bVar.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void x(ExecutorService executorService) {
        boolean isTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(isTerminated = executorService.isTerminated())) {
            executorService.shutdown();
            boolean z10 = false;
            while (!isTerminated) {
                try {
                    isTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        executorService.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
