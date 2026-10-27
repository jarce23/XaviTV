package w3;

import android.media.MediaRouter2$RouteCallback;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends MediaRouter2$RouteCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12911a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f12912b;

    public /* synthetic */ e(g gVar, int i10) {
        this.f12911a = i10;
        this.f12912b = gVar;
    }

    public void onRoutesAdded(List list) {
        switch (this.f12911a) {
            case 0:
                this.f12912b.j();
                break;
            default:
                super.onRoutesAdded(list);
                break;
        }
    }

    public void onRoutesChanged(List list) {
        switch (this.f12911a) {
            case 0:
                this.f12912b.j();
                break;
            default:
                super.onRoutesChanged(list);
                break;
        }
    }

    public void onRoutesRemoved(List list) {
        switch (this.f12911a) {
            case 0:
                this.f12912b.j();
                break;
            default:
                super.onRoutesRemoved(list);
                break;
        }
    }

    public void onRoutesUpdated(List list) {
        switch (this.f12911a) {
            case 1:
                this.f12912b.j();
                break;
            default:
                super.onRoutesUpdated(list);
                break;
        }
    }
}
