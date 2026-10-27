package w3;

import android.media.MediaRouter;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import java.util.ArrayList;
import java.util.HashSet;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 extends MediaRouter.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final v0 f12914a;

    public f0(v0 v0Var) {
        this.f12914a = v0Var;
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        v0 v0Var = this.f12914a;
        if (v0Var.i(routeInfo)) {
            v0Var.u();
        }
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        int j10;
        v0 v0Var = this.f12914a;
        v0Var.getClass();
        if (v0.o(routeInfo) != null || (j10 = v0Var.j(routeInfo)) < 0) {
            return;
        }
        t0 t0Var = (t0) v0Var.f13028q.get(j10);
        String str = t0Var.f13011b;
        CharSequence name = t0Var.f13010a.getName(v0Var.f12967a);
        h hVar = new h(str, name != null ? name.toString() : _UrlKt.FRAGMENT_ENCODE_SET);
        v0Var.q(t0Var, hVar);
        t0Var.f13012c = hVar.b();
        v0Var.u();
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteGrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i10) {
        this.f12914a.getClass();
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        Display display;
        v0 v0Var = this.f12914a;
        int j10 = v0Var.j(routeInfo);
        if (j10 >= 0) {
            t0 t0Var = (t0) v0Var.f13028q.get(j10);
            try {
                display = routeInfo.getPresentationDisplay();
            } catch (NoSuchMethodError e7) {
                Log.w("MediaRouterJellybeanMr1", "Cannot get presentation display for the route.", e7);
                display = null;
            }
            int displayId = display != null ? display.getDisplayId() : -1;
            if (displayId != t0Var.f13012c.f12935a.getInt("presentationDisplayId", -1)) {
                i iVar = t0Var.f13012c;
                new ArrayList();
                new ArrayList();
                new HashSet();
                if (iVar == null) {
                    throw new IllegalArgumentException("descriptor must not be null");
                }
                Bundle bundle = new Bundle(iVar.f12935a);
                ArrayList c10 = iVar.c();
                ArrayList b2 = iVar.b();
                HashSet a10 = iVar.a();
                bundle.putInt("presentationDisplayId", displayId);
                bundle.putParcelableArrayList("controlFilters", new ArrayList<>(b2));
                bundle.putStringArrayList("groupMemberIds", new ArrayList<>(c10));
                bundle.putStringArrayList("allowedPackages", new ArrayList<>(a10));
                t0Var.f13012c = new i(bundle);
                v0Var.u();
            }
        }
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        int j10;
        v0 v0Var = this.f12914a;
        v0Var.getClass();
        if (v0.o(routeInfo) != null || (j10 = v0Var.j(routeInfo)) < 0) {
            return;
        }
        v0Var.f13028q.remove(j10);
        v0Var.u();
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteSelected(MediaRouter mediaRouter, int i10, MediaRouter.RouteInfo routeInfo) {
        z a10;
        v0 v0Var = this.f12914a;
        if (routeInfo != v0Var.f13021j.getSelectedRoute(8388611)) {
            return;
        }
        u0 o2 = v0.o(routeInfo);
        if (o2 != null) {
            o2.f13016a.l();
            return;
        }
        int j10 = v0Var.j(routeInfo);
        if (j10 >= 0) {
            t0 t0Var = (t0) v0Var.f13028q.get(j10);
            w wVar = v0Var.f13020i;
            String str = t0Var.f13011b;
            wVar.f13042n.removeMessages(262);
            y d6 = wVar.d(wVar.f13032c);
            if (d6 == null || (a10 = d6.a(str)) == null) {
                return;
            }
            a10.l();
        }
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteUngrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup) {
        this.f12914a.getClass();
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteUnselected(MediaRouter mediaRouter, int i10, MediaRouter.RouteInfo routeInfo) {
        this.f12914a.getClass();
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        int j10;
        v0 v0Var = this.f12914a;
        v0Var.getClass();
        if (v0.o(routeInfo) != null || (j10 = v0Var.j(routeInfo)) < 0) {
            return;
        }
        t0 t0Var = (t0) v0Var.f13028q.get(j10);
        int volume = routeInfo.getVolume();
        if (volume != t0Var.f13012c.f12935a.getInt("volume")) {
            i iVar = t0Var.f13012c;
            new ArrayList();
            new ArrayList();
            new HashSet();
            if (iVar == null) {
                throw new IllegalArgumentException("descriptor must not be null");
            }
            Bundle bundle = new Bundle(iVar.f12935a);
            ArrayList c10 = iVar.c();
            ArrayList b2 = iVar.b();
            HashSet a10 = iVar.a();
            bundle.putInt("volume", volume);
            bundle.putParcelableArrayList("controlFilters", new ArrayList<>(b2));
            bundle.putStringArrayList("groupMemberIds", new ArrayList<>(c10));
            bundle.putStringArrayList("allowedPackages", new ArrayList<>(a10));
            t0Var.f13012c = new i(bundle);
            v0Var.u();
        }
    }
}
