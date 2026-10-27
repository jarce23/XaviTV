package i4;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f6396e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6397a;

    /* renamed from: b, reason: collision with root package name */
    public final File f6398b;

    /* renamed from: c, reason: collision with root package name */
    public final Lock f6399c;

    /* renamed from: d, reason: collision with root package name */
    public FileChannel f6400d;

    public a(String str, File file, boolean z10) {
        Lock lock;
        this.f6397a = z10;
        File file2 = new File(file, str.concat(".lck"));
        this.f6398b = file2;
        String absolutePath = file2.getAbsolutePath();
        h.d("lockFile.absolutePath", absolutePath);
        HashMap hashMap = f6396e;
        synchronized (hashMap) {
            try {
                Object obj = hashMap.get(absolutePath);
                if (obj == null) {
                    obj = new ReentrantLock();
                    hashMap.put(absolutePath, obj);
                }
                lock = (Lock) obj;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f6399c = lock;
    }

    public final void a(boolean z10) {
        File file = this.f6398b;
        this.f6399c.lock();
        if (z10) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.f6400d = channel;
            } catch (IOException e7) {
                this.f6400d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e7);
            }
        }
    }

    public final void b() {
        try {
            FileChannel fileChannel = this.f6400d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f6399c.unlock();
    }
}
