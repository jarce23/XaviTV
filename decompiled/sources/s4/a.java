package s4;

import android.media.MediaCodec;
import android.os.Build;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern d(int i10, int i11) {
        return new MediaCodec.CryptoInfo.Pattern(i10, i11);
    }

    public static /* bridge */ /* synthetic */ Supplier f(Object obj) {
        return (Supplier) obj;
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void k(ub.c cVar) {
        boolean isTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || cVar != ForkJoinPool.commonPool()) && !(isTerminated = cVar.isTerminated())) {
            cVar.shutdown();
            boolean z10 = false;
            while (!isTerminated) {
                try {
                    isTerminated = cVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        cVar.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void l(w5.d dVar) {
        boolean isTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || dVar != ForkJoinPool.commonPool()) && !(isTerminated = dVar.isTerminated())) {
            dVar.shutdown();
            boolean z10 = false;
            while (!isTerminated) {
                try {
                    isTerminated = dVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        dVar.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void m() {
    }
}
