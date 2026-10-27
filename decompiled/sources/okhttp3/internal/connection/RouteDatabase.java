package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import ma.j;
import okhttp3.Route;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class RouteDatabase {
    private final Set<Route> _failedRoutes = new LinkedHashSet();

    public final synchronized void connected(Route route) {
        h.e("route", route);
        this._failedRoutes.remove(route);
    }

    public final synchronized void failed(Route route) {
        h.e("failedRoute", route);
        this._failedRoutes.add(route);
    }

    public final synchronized Set<Route> getFailedRoutes() {
        return j.L(this._failedRoutes);
    }

    public final synchronized boolean shouldPostpone(Route route) {
        h.e("route", route);
        return this._failedRoutes.contains(route);
    }
}
