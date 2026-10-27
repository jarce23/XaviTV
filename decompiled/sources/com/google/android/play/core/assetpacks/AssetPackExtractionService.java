package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import j9.k0;
import j9.l;
import k9.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AssetPackExtractionService extends Service {

    /* renamed from: o, reason: collision with root package name */
    public l f3903o;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f3903o;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f3903o = (l) ((e) k0.c(getApplicationContext()).f13564p).c();
    }
}
