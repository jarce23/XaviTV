package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class l implements d {

    /* renamed from: o, reason: collision with root package name */
    public final boolean f3058o;

    /* renamed from: p, reason: collision with root package name */
    public final Uri f3059p;

    /* renamed from: q, reason: collision with root package name */
    public final ContentResolver f3060q;

    /* renamed from: r, reason: collision with root package name */
    public Object f3061r;

    public l(ContentResolver contentResolver, Uri uri, boolean z10) {
        this.f3060q = contentResolver;
        this.f3059p = uri;
        this.f3058o = z10;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        Object obj = this.f3061r;
        if (obj != null) {
            try {
                e(obj);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int c() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(com.bumptech.glide.i iVar, c cVar) {
        try {
            Object f10 = f(this.f3060q, this.f3059p);
            this.f3061r = f10;
            cVar.p(f10);
        } catch (FileNotFoundException e7) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e7);
            }
            cVar.l(e7);
        }
    }

    public abstract void e(Object obj);

    public abstract Object f(ContentResolver contentResolver, Uri uri);

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
    }
}
