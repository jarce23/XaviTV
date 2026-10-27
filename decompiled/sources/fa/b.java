package fa;

import androidx.emoji2.text.b0;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends ThreadPoolExecutor implements AutoCloseable {

    /* renamed from: p, reason: collision with root package name */
    public static final int f5051p;

    /* renamed from: o, reason: collision with root package name */
    public final ReentrantLock f5052o;

    static {
        int i10 = 0;
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a(Pattern.compile("cpu[0-9]+")));
            if (listFiles != null) {
                i10 = listFiles.length;
            }
        } catch (SecurityException unused) {
        }
        if (i10 <= 0) {
            i10 = Runtime.getRuntime().availableProcessors();
        }
        f5051p = i10 > 0 ? 1 + (i10 * 2) : 1;
    }

    public b(int i10, int i11) {
        super(i10, i11, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100));
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f5052o = reentrantLock;
        reentrantLock.newCondition();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        ReentrantLock reentrantLock = this.f5052o;
        reentrantLock.lock();
        reentrantLock.unlock();
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        b0.w(this);
    }
}
