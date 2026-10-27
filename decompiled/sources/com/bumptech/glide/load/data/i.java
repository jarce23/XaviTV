package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements d {

    /* renamed from: o, reason: collision with root package name */
    public final String f3048o;

    /* renamed from: p, reason: collision with root package name */
    public final AssetManager f3049p;

    /* renamed from: q, reason: collision with root package name */
    public Object f3050q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f3051r;

    public i(AssetManager assetManager, String str, int i10) {
        this.f3051r = i10;
        this.f3049p = assetManager;
        this.f3048o = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f3051r) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        Object obj = this.f3050q;
        if (obj == null) {
            return;
        }
        try {
            switch (this.f3051r) {
                case 0:
                    ((AssetFileDescriptor) obj).close();
                    break;
                default:
                    ((InputStream) obj).close();
                    break;
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int c() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(com.bumptech.glide.i iVar, c cVar) {
        Object openFd;
        try {
            AssetManager assetManager = this.f3049p;
            String str = this.f3048o;
            switch (this.f3051r) {
                case 0:
                    openFd = assetManager.openFd(str);
                    break;
                default:
                    openFd = assetManager.open(str);
                    break;
            }
            this.f3050q = openFd;
            cVar.p(openFd);
        } catch (IOException e7) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e7);
            }
            cVar.l(e7);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
    }
}
