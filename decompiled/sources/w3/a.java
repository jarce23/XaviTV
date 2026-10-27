package w3;

import android.app.ApplicationExitInfo;
import android.media.RouteDiscoveryPreference;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ ApplicationExitInfo d(Object obj) {
        return (ApplicationExitInfo) obj;
    }

    public static /* synthetic */ RouteDiscoveryPreference.Builder g(ArrayList arrayList) {
        return new RouteDiscoveryPreference.Builder(arrayList, false);
    }

    public static /* synthetic */ RouteDiscoveryPreference.Builder h(ArrayList arrayList, boolean z10) {
        return new RouteDiscoveryPreference.Builder(arrayList, z10);
    }
}
