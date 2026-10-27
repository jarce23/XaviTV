package q1;

import android.content.Context;
import b4.o;
import java.util.ArrayList;
import java.util.Collections;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetProvider;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g {
    public static CronetEngine a(Context context) {
        ArrayList arrayList = new ArrayList(CronetProvider.getAllProviders(context));
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((CronetProvider) arrayList.get(size)).isEnabled() || CronetProvider.PROVIDER_NAME_FALLBACK.equals(((CronetProvider) arrayList.get(size)).getName())) {
                arrayList.remove(size);
            }
        }
        Collections.sort(arrayList, new o(2));
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            String name = ((CronetProvider) arrayList.get(i10)).getName();
            try {
                CronetEngine.Builder createBuilder = ((CronetProvider) arrayList.get(i10)).createBuilder();
                createBuilder.setUserAgent("samsung-agent/1");
                CronetEngine build = createBuilder.build();
                l1.b.f("CronetUtil", "CronetEngine built using " + name);
                return build;
            } catch (SecurityException unused) {
                l1.b.q("CronetUtil", "Failed to build CronetEngine. Please check that the process has android.permission.ACCESS_NETWORK_STATE.");
            } catch (UnsatisfiedLinkError unused2) {
                l1.b.q("CronetUtil", "Failed to link Cronet binaries. Please check that native Cronet binaries arebundled into your app.");
            }
        }
        l1.b.q("CronetUtil", "CronetEngine could not be built.");
        return null;
    }
}
