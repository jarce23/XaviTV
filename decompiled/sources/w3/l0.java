package w3;

import android.os.Bundle;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f12958a;

    public l0(m0 m0Var) {
        this.f12958a = m0Var;
    }

    public static void a(String str, Bundle bundle) {
        Log.d("MediaRouteProviderProxy", "Error: " + str + ", data: " + bundle);
    }

    public final void b(Bundle bundle) {
        String string = bundle.getString("groupableTitle");
        m0 m0Var = this.f12958a;
        m0Var.g = string;
        m0Var.f12960h = bundle.getString("transferableTitle");
    }
}
