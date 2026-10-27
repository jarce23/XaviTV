package w3;

import android.media.MediaRouter;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s0 extends m {

    /* renamed from: a, reason: collision with root package name */
    public final MediaRouter.RouteInfo f13006a;

    public s0(MediaRouter.RouteInfo routeInfo) {
        this.f13006a = routeInfo;
    }

    @Override // w3.m
    public final void f(int i10) {
        this.f13006a.requestSetVolume(i10);
    }

    @Override // w3.m
    public final void i(int i10) {
        this.f13006a.requestUpdateVolume(i10);
    }
}
