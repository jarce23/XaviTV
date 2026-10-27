package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s implements n {

    /* renamed from: u, reason: collision with root package name */
    public static final Executor f3088u = AsyncTask.SERIAL_EXECUTOR;

    /* renamed from: o, reason: collision with root package name */
    public final Context f3089o;

    /* renamed from: p, reason: collision with root package name */
    public final m f3090p;

    /* renamed from: q, reason: collision with root package name */
    public final c.a f3091q;

    /* renamed from: r, reason: collision with root package name */
    public volatile boolean f3092r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f3093s;

    /* renamed from: t, reason: collision with root package name */
    public final q f3094t = new q(0, this);

    public s(Context context, c.a aVar, m mVar) {
        this.f3089o = context.getApplicationContext();
        this.f3091q = aVar;
        this.f3090p = mVar;
    }

    @Override // com.bumptech.glide.manager.n
    public final void a() {
        f3088u.execute(new r(this, 1));
    }

    @Override // com.bumptech.glide.manager.n
    public final boolean b() {
        f3088u.execute(new r(this, 0));
        return true;
    }

    public final boolean c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3091q.get()).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e7) {
            if (!Log.isLoggable("ConnectivityMonitor", 5)) {
                return true;
            }
            Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e7);
            return true;
        }
    }
}
