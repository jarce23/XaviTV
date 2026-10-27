package v4;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import o4.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends d {
    public final ConnectivityManager g;

    public j(Context context, x4.i iVar) {
        super(context, iVar);
        Object systemService = this.f12668b.getSystemService("connectivity");
        za.h.c("null cannot be cast to non-null type android.net.ConnectivityManager", systemService);
        this.g = (ConnectivityManager) systemService;
    }

    @Override // v4.f
    public final Object a() {
        return i.a(this.g);
    }

    @Override // v4.d
    public final IntentFilter e() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override // v4.d
    public final void f(Intent intent) {
        if (za.h.a(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            p.d().a(i.f12674a, "Network broadcast received");
            b(i.a(this.g));
        }
    }
}
