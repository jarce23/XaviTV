package w3;

import android.media.MediaRouter;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 extends MediaRouter.VolumeCallback {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f12910a;

    public d0(c0 c0Var) {
        this.f12910a = c0Var;
    }

    @Override // android.media.MediaRouter.VolumeCallback
    public final void onVolumeSetRequest(MediaRouter.RouteInfo routeInfo, int i10) {
        this.f12910a.a(routeInfo, i10);
    }

    @Override // android.media.MediaRouter.VolumeCallback
    public final void onVolumeUpdateRequest(MediaRouter.RouteInfo routeInfo, int i10) {
        this.f12910a.b(routeInfo, i10);
    }
}
