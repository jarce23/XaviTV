package w3;

import android.media.MediaRouter2;
import android.media.MediaRouter2$ControllerCallback;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends MediaRouter2$ControllerCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f12894a;

    public b(g gVar) {
        this.f12894a = gVar;
    }

    public final void onControllerUpdated(MediaRouter2.RoutingController routingController) {
        this.f12894a.k(routingController);
    }
}
