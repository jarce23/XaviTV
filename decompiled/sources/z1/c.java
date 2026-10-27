package z1;

import android.os.HandlerThread;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements n9.h {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13956o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f13957p;

    public /* synthetic */ c(int i10, int i11) {
        this.f13956o = i11;
        this.f13957p = i10;
    }

    @Override // n9.h
    public final Object get() {
        switch (this.f13956o) {
            case 0:
                return new HandlerThread(d.g(this.f13957p, "ExoPlayer:MediaCodecAsyncAdapter:"));
            default:
                return new HandlerThread(d.g(this.f13957p, "ExoPlayer:MediaCodecQueueingThread:"));
        }
    }
}
