package y4;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h {
    public static final NetworkCapabilities a(ConnectivityManager connectivityManager, Network network) {
        za.h.e("<this>", connectivityManager);
        return connectivityManager.getNetworkCapabilities(network);
    }

    public static final boolean b(NetworkCapabilities networkCapabilities, int i10) {
        za.h.e("<this>", networkCapabilities);
        return networkCapabilities.hasCapability(i10);
    }

    public static final void c(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        za.h.e("<this>", connectivityManager);
        za.h.e("networkCallback", networkCallback);
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
