package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.os.Build;
import android.system.Os;
import java.io.FileDescriptor;
import java.io.IOException;
import x4.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
final class GifInfoHandle {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f10197b = 0;

    /* renamed from: a, reason: collision with root package name */
    public volatile long f10198a;

    static {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            if (k5.a.f7822f == null) {
                try {
                    k5.a.f7822f = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null).invoke(null, null);
                } catch (Exception e7) {
                    throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e7);
                }
            }
            Context context = k5.a.f7822f;
            m mVar = new m();
            if (context == null) {
                throw new IllegalArgumentException("Given context is null");
            }
            m.D("Beginning load of %s...", "pl_droidsonroids_gif");
            mVar.C(context, "pl_droidsonroids_gif", null);
        }
    }

    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) {
        int createTempNativeFileDescriptor;
        try {
            FileDescriptor fileDescriptor = assetFileDescriptor.getFileDescriptor();
            long startOffset = assetFileDescriptor.getStartOffset();
            if (Build.VERSION.SDK_INT > 27) {
                try {
                    createTempNativeFileDescriptor = createTempNativeFileDescriptor();
                    Os.dup2(fileDescriptor, createTempNativeFileDescriptor);
                } finally {
                }
            } else {
                createTempNativeFileDescriptor = extractNativeFileDescriptor(fileDescriptor, false);
            }
            this.f10198a = openNativeFileDescriptor(createTempNativeFileDescriptor, startOffset);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    public static native int createTempNativeFileDescriptor();

    public static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z10);

    private static native void free(long j10);

    private static native int getCurrentFrameIndex(long j10);

    private static native int getCurrentLoop(long j10);

    private static native int getCurrentPosition(long j10);

    private static native int getDuration(long j10);

    private static native int getHeight(long j10);

    private static native int getLoopCount(long j10);

    private static native int getNativeErrorCode(long j10);

    private static native int getNumberOfFrames(long j10);

    private static native long[] getSavedState(long j10);

    private static native int getWidth(long j10);

    private static native boolean isOpaque(long j10);

    public static native long openFile(String str);

    public static native long openNativeFileDescriptor(int i10, long j10);

    private static native long renderFrame(long j10, Bitmap bitmap);

    private static native boolean reset(long j10);

    private static native long restoreRemainder(long j10);

    private static native int restoreSavedState(long j10, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j10);

    private static native void seekToTime(long j10, int i10, Bitmap bitmap);

    private static native void setLoopCount(long j10, char c10);

    public final synchronized int a() {
        return getCurrentFrameIndex(this.f10198a);
    }

    public final synchronized int b() {
        return getCurrentLoop(this.f10198a);
    }

    public final synchronized int c() {
        return getCurrentPosition(this.f10198a);
    }

    public final synchronized int d() {
        return getDuration(this.f10198a);
    }

    public final synchronized int e() {
        return getHeight(this.f10198a);
    }

    public final synchronized int f() {
        return getLoopCount(this.f10198a);
    }

    public final void finalize() {
        try {
            synchronized (this) {
                free(this.f10198a);
                this.f10198a = 0L;
            }
        } finally {
            super.finalize();
        }
    }

    public final synchronized int g() {
        return getNativeErrorCode(this.f10198a);
    }

    public final synchronized int h() {
        return getNumberOfFrames(this.f10198a);
    }

    public final synchronized long[] i() {
        return getSavedState(this.f10198a);
    }

    public final synchronized int j() {
        return getWidth(this.f10198a);
    }

    public final synchronized boolean k() {
        return isOpaque(this.f10198a);
    }

    public final synchronized long l(Bitmap bitmap) {
        return renderFrame(this.f10198a, bitmap);
    }

    public final synchronized boolean m() {
        return reset(this.f10198a);
    }

    public final synchronized long n() {
        return restoreRemainder(this.f10198a);
    }

    public final synchronized int o(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f10198a, jArr, bitmap);
    }

    public final synchronized void p() {
        saveRemainder(this.f10198a);
    }

    public final synchronized void q(int i10, Bitmap bitmap) {
        seekToTime(this.f10198a, i10, bitmap);
    }

    public final void r(int i10) {
        if (i10 < 0 || i10 > 65535) {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.f10198a, (char) i10);
        }
    }
}
