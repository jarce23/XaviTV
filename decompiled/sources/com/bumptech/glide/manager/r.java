package com.bumptech.glide.manager;

import android.content.IntentFilter;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3086o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ s f3087p;

    public /* synthetic */ r(s sVar, int i10) {
        this.f3086o = i10;
        this.f3087p = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3086o) {
            case 0:
                s sVar = this.f3087p;
                sVar.f3092r = sVar.c();
                try {
                    s sVar2 = this.f3087p;
                    sVar2.f3089o.registerReceiver(sVar2.f3094t, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.f3087p.f3093s = true;
                    break;
                } catch (SecurityException e7) {
                    if (Log.isLoggable("ConnectivityMonitor", 5)) {
                        Log.w("ConnectivityMonitor", "Failed to register", e7);
                    }
                    this.f3087p.f3093s = false;
                    return;
                }
            case 1:
                if (this.f3087p.f3093s) {
                    this.f3087p.f3093s = false;
                    s sVar3 = this.f3087p;
                    sVar3.f3089o.unregisterReceiver(sVar3.f3094t);
                    break;
                }
                break;
            default:
                boolean z10 = this.f3087p.f3092r;
                s sVar4 = this.f3087p;
                sVar4.f3092r = sVar4.c();
                if (z10 != this.f3087p.f3092r) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + this.f3087p.f3092r);
                    }
                    s sVar5 = this.f3087p;
                    m6.n.f().post(new o(sVar5, sVar5.f3092r, 1));
                    break;
                }
                break;
        }
    }
}
