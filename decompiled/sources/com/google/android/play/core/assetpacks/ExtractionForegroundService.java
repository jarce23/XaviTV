package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import j9.c0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ExtractionForegroundService extends Service {

    /* renamed from: o, reason: collision with root package name */
    public final c0 f3904o = new c0(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f3904o;
    }
}
