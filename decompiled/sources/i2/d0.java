package i2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 implements Choreographer.FrameCallback, Handler.Callback {

    /* renamed from: s, reason: collision with root package name */
    public static final d0 f6153s = new d0();

    /* renamed from: o, reason: collision with root package name */
    public volatile long f6154o = -9223372036854775807L;

    /* renamed from: p, reason: collision with root package name */
    public final Handler f6155p;

    /* renamed from: q, reason: collision with root package name */
    public Choreographer f6156q;

    /* renamed from: r, reason: collision with root package name */
    public int f6157r;

    public d0() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        int i10 = l1.a0.f8067a;
        Handler handler = new Handler(looper, this);
        this.f6155p = handler;
        handler.sendEmptyMessage(1);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j10) {
        this.f6154o = j10;
        Choreographer choreographer = this.f6156q;
        choreographer.getClass();
        choreographer.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            try {
                this.f6156q = Choreographer.getInstance();
            } catch (RuntimeException e7) {
                l1.b.r("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e7);
            }
            return true;
        }
        if (i10 == 2) {
            Choreographer choreographer = this.f6156q;
            if (choreographer != null) {
                int i11 = this.f6157r + 1;
                this.f6157r = i11;
                if (i11 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
            return true;
        }
        if (i10 != 3) {
            return false;
        }
        Choreographer choreographer2 = this.f6156q;
        if (choreographer2 != null) {
            int i12 = this.f6157r - 1;
            this.f6157r = i12;
            if (i12 == 0) {
                choreographer2.removeFrameCallback(this);
                this.f6154o = -9223372036854775807L;
            }
        }
        return true;
    }
}
