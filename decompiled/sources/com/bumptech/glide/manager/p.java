package com.bumptech.glide.manager;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.google.android.gms.internal.cast.x;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3082a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3083b;

    public /* synthetic */ p(int i10, Object obj) {
        this.f3082a = i10;
        this.f3083b = obj;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        switch (this.f3082a) {
            case 0:
                m6.n.f().post(new o(this, true, 0));
                break;
            case 1:
                break;
            default:
                super.onAvailable(network);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        switch (this.f3082a) {
            case 2:
                za.h.e("network", network);
                za.h.e("capabilities", networkCapabilities);
                o4.p.d().a(v4.i.f12674a, "Network capabilities changed: " + networkCapabilities);
                v4.h hVar = (v4.h) this.f3083b;
                hVar.b(v4.i.a(hVar.f12673f));
                break;
            default:
                super.onCapabilitiesChanged(network, networkCapabilities);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        switch (this.f3082a) {
            case 1:
                ((x) this.f3083b).a(network, linkProperties);
                break;
            default:
                super.onLinkPropertiesChanged(network, linkProperties);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        switch (this.f3082a) {
            case 0:
                m6.n.f().post(new o(this, false, 0));
                return;
            case 1:
                x xVar = (x) this.f3083b;
                synchronized (xVar.f3567h) {
                    try {
                        if (xVar.f3564d != null && xVar.f3565e != null) {
                            x.f3560j.b("the network is lost", new Object[0]);
                            if (xVar.f3565e.remove(network)) {
                                xVar.f3564d.remove(network);
                            }
                            xVar.b();
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            default:
                za.h.e("network", network);
                o4.p.d().a(v4.i.f12674a, "Network connection lost");
                v4.h hVar = (v4.h) this.f3083b;
                hVar.b(v4.i.a(hVar.f12673f));
                return;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        switch (this.f3082a) {
            case 1:
                x xVar = (x) this.f3083b;
                synchronized (xVar.f3567h) {
                    if (xVar.f3564d != null && xVar.f3565e != null) {
                        x.f3560j.b("all networks are unavailable.", new Object[0]);
                        xVar.f3564d.clear();
                        xVar.f3565e.clear();
                        xVar.b();
                        return;
                    }
                    return;
                }
            default:
                super.onUnavailable();
                return;
        }
    }

    private final void a(Network network) {
    }
}
