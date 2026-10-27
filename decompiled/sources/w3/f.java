package w3;

import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.MediaRouter2$TransferCallback;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends MediaRouter2$TransferCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f12913a;

    public f(g gVar) {
        this.f12913a = gVar;
    }

    public final void onStop(MediaRouter2.RoutingController routingController) {
        g gVar = this.f12913a;
        m mVar = (m) gVar.f12918k.remove(routingController);
        if (mVar == null) {
            Log.w("MR2Provider", "onStop: No matching routeController found. routingController=" + routingController);
            return;
        }
        w wVar = gVar.f12917j.f13005a;
        if (mVar != wVar.f13049u) {
            w wVar2 = b0.f12895c;
            return;
        }
        z c10 = wVar.c();
        if (wVar.e() != c10) {
            wVar.k(c10, 2);
        }
    }

    public final void onTransfer(MediaRouter2.RoutingController routingController, MediaRouter2.RoutingController routingController2) {
        MediaRouter2.RoutingController systemController;
        List selectedRoutes;
        String id;
        z zVar;
        this.f12913a.f12918k.remove(routingController);
        systemController = this.f12913a.f12916i.getSystemController();
        if (routingController2 == systemController) {
            w wVar = this.f12913a.f12917j.f13005a;
            z c10 = wVar.c();
            if (wVar.e() != c10) {
                wVar.k(c10, 3);
                return;
            }
            return;
        }
        selectedRoutes = routingController2.getSelectedRoutes();
        if (selectedRoutes.isEmpty()) {
            Log.w("MR2Provider", "Selected routes are empty. This shouldn't happen.");
            return;
        }
        int i10 = 0;
        id = n0.c.c(selectedRoutes.get(0)).getId();
        this.f12913a.f12918k.put(routingController2, new c(this.f12913a, routingController2, id));
        w wVar2 = this.f12913a.f12917j.f13005a;
        ArrayList arrayList = wVar2.f13036h;
        int size = arrayList.size();
        while (true) {
            if (i10 >= size) {
                zVar = null;
                break;
            }
            Object obj = arrayList.get(i10);
            i10++;
            zVar = (z) obj;
            if (zVar.c() == wVar2.f13035f && TextUtils.equals(id, zVar.f13070b)) {
                break;
            }
        }
        if (zVar == null) {
            Log.w("MediaRouter", "onSelectRoute: The target RouteInfo is not found for descriptorId=" + id);
        } else {
            wVar2.k(zVar, 3);
        }
        this.f12913a.k(routingController2);
    }

    public final void onTransferFailure(MediaRoute2Info mediaRoute2Info) {
        Log.w("MR2Provider", "Transfer failed. requestedRoute=" + mediaRoute2Info);
    }
}
