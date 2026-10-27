package okhttp3.internal.platform;

import android.content.Context;
import j4.b;
import java.util.List;
import ma.p;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class PlatformInitializer implements b {
    @Override // j4.b
    public List<Class<b>> dependencies() {
        return p.f9051o;
    }

    @Override // j4.b
    public Platform create(Context context) {
        h.e("context", context);
        PlatformRegistry.INSTANCE.setApplicationContext(context);
        return Platform.Companion.get();
    }
}
