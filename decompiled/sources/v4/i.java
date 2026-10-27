package v4;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import o4.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12674a;

    static {
        String f10 = p.f("NetworkStateTracker");
        za.h.d("tagWithPrefix(\"NetworkStateTracker\")", f10);
        f12674a = f10;
    }

    public static final t4.d a(ConnectivityManager connectivityManager) {
        boolean z10;
        NetworkCapabilities a10;
        za.h.e("<this>", connectivityManager);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z11 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            a10 = y4.h.a(connectivityManager, y4.i.a(connectivityManager));
        } catch (SecurityException e7) {
            p.d().c(f12674a, "Unable to validate active network", e7);
        }
        if (a10 != null) {
            z10 = y4.h.b(a10, 16);
            return new t4.d(z11, z10, connectivityManager.isActiveNetworkMetered(), activeNetworkInfo == null && !activeNetworkInfo.isRoaming());
        }
        z10 = false;
        return new t4.d(z11, z10, connectivityManager.isActiveNetworkMetered(), activeNetworkInfo == null && !activeNetworkInfo.isRoaming());
    }
}
