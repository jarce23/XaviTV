package y4;

import android.net.ConnectivityManager;
import android.net.Network;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i {
    public static final Network a(ConnectivityManager connectivityManager) {
        za.h.e("<this>", connectivityManager);
        return connectivityManager.getActiveNetwork();
    }
}
