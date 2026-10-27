package t0;

import android.view.Choreographer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Choreographer.FrameCallback {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11743o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Runnable f11744p;

    public /* synthetic */ b(Runnable runnable, int i10) {
        this.f11743o = i10;
        this.f11744p = runnable;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j10) {
        switch (this.f11743o) {
            case 0:
                this.f11744p.run();
                break;
            default:
                this.f11744p.run();
                break;
        }
    }
}
